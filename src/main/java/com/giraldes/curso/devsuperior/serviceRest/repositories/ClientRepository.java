package com.giraldes.curso.devsuperior.serviceRest.repositories;

import com.giraldes.curso.devsuperior.serviceRest.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long>{
}
