package com.doctors.repository;

import com.doctors.modelo.MessageModel;
import com.doctors.repository.crudrepository.MessageCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {

    @Autowired
    private MessageCrudRepository messageCrudRepository;

    public List<MessageModel> getAllMessages() {
        return (List<MessageModel>) messageCrudRepository.findAll();
    }

    public Optional<MessageModel> getMessage(Integer idMessage) {
        return messageCrudRepository.findById(idMessage);
    }

    public MessageModel saveMessage(MessageModel messageModel){

        return messageCrudRepository.save(messageModel);
    }
    public boolean deleteMessage(MessageModel messageModel){
        messageCrudRepository.delete(messageModel);
        return true;
    }

    public MessageModel updateMessage (MessageModel messageModel ){
        return messageCrudRepository.save(messageModel);
    }

}
