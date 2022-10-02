package com.doctors.repository.crudrepository;

import com.doctors.modelo.ClientModel;
import org.springframework.data.repository.CrudRepository;

public interface ClientCrudRepository extends CrudRepository <ClientModel, Integer> {
}
