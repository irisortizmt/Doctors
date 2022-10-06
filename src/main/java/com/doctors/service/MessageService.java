package com.doctors.service;

import com.doctors.modelo.MessageModel;
import com.doctors.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<MessageModel> getAllMessages() {
        return messageRepository.getAllMessages();
    }

    public Optional<MessageModel> getMessage(Integer idMessage) {
        return messageRepository.getMessage(idMessage);
    }

    public MessageModel saveMessage(MessageModel messageModel){

        return messageRepository.saveMessage(messageModel);
    }
    public boolean deleteMessage(Integer idMessage){
        try {
            messageRepository.deleteMessage(idMessage);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public MessageModel updateMessage (MessageModel messageModel ){
        if(messageModel.getIdMessage()!=null){
            Optional<MessageModel> m = messageRepository.getMessage(messageModel.getIdMessage());
            if(!m.isEmpty()){
                if(messageModel.getMessageText()!=null){
                    m.get().setMessageText(messageModel.getMessageText());
                }
                if(messageModel.getDoctor()!=null){
                    m.get().setDoctor(messageModel.getDoctor());
                }
                if(messageModel.getClient()!=null){
                    m.get().setClient(messageModel.getClient());
                }
                messageRepository.saveMessage(m.get());
                return m.get();
            }else{
                return messageModel;
            }
        }else{
            return messageModel;
        }
    }
}
