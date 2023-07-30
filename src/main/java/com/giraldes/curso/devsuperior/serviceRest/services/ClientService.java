package com.giraldes.curso.devsuperior.serviceRest.services;

import com.giraldes.curso.devsuperior.serviceRest.DTO.ClientDTO;
import com.giraldes.curso.devsuperior.serviceRest.entities.Client;
import com.giraldes.curso.devsuperior.serviceRest.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.giraldes.curso.devsuperior.serviceRest.services.exception.ClientNotFoundException;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Transactional
    public ClientDTO findByID(Long Id){

            return new ClientDTO(clientRepository.findById(Id).orElseThrow(() -> new ClientNotFoundException("Cliente não existente")));


    }
    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long Id){
        if(!clientRepository.existsById(Id)){

            throw new ClientNotFoundException("Cliente não existente");
        }
        try {
            clientRepository.deleteById(Id);
        }
        catch(DataIntegrityViolationException e){

            //throw new DatabaseException("Cliente não existente");
        }
    }

    @Transactional
    public Page<ClientDTO> findAll(Pageable pageable){
         return clientRepository.findAll(pageable).map(x -> new ClientDTO(x));

    }
    @Transactional
    public ClientDTO insert(ClientDTO clientDTO){

        return new ClientDTO(clientRepository.save(new Client(clientDTO)));

    }
    @Transactional
    public ClientDTO update(Long id, ClientDTO clientDTO){

        Client Client = clientRepository.getReferenceById(id);
        copyPropsFromDtoToEntity(clientDTO, Client);
        return new ClientDTO(clientRepository.save(Client));

    }

    private static void copyPropsFromDtoToEntity(ClientDTO clientDTO, Client Client) {
        Client.setBirthDate(clientDTO.getBirthDate());
        Client.setName(clientDTO.getName());
        Client.setIncome(clientDTO.getIncome());
        Client.setChildren(clientDTO.getChildren());
    }


}
