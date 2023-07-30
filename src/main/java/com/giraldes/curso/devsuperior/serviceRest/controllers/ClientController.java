package com.giraldes.curso.devsuperior.serviceRest.controllers;

import com.giraldes.curso.devsuperior.serviceRest.DTO.ClientDTO;
import com.giraldes.curso.devsuperior.serviceRest.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value="/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    public String teste(){
        return "CAcildis";
    }
    @GetMapping(value = "{Id}")
    public ResponseEntity<ClientDTO> findByID(@PathVariable Long Id){
            var ClientDTO = clientService.findByID(Id);
            return ResponseEntity.ok(ClientDTO);


    }
    @PutMapping(value = "{Id}")
    public ResponseEntity<ClientDTO> update(@PathVariable Long Id,@Valid @RequestBody ClientDTO dto){
        var ClientDTO = clientService.findByID(Id);
        ClientDTO = clientService.update(Id,dto);
        return ResponseEntity.ok(ClientDTO);
    }
    @DeleteMapping(value = "{Id}")
    public ResponseEntity<ClientDTO> delete(@PathVariable Long Id){
        clientService.delete(Id);

        return ResponseEntity.noContent().build();
    }
    @GetMapping
    public Page<ClientDTO> findAll(Pageable pageable){

        return clientService.findAll(pageable);

    }
    @PostMapping
    public ResponseEntity<ClientDTO> insert(@Valid @RequestBody ClientDTO dto){

        dto = clientService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);

    }




}
