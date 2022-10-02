package com.doctors.repository.crudrepository;

import com.doctors.modelo.MessageModel;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<MessageModel, Integer> {
}
