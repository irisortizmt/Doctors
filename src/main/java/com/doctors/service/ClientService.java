package com.doctors.service;

import com.doctors.modelo.ClientModel;
import com.doctors.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<ClientModel> getAllClients(){
        return clientRepository.getAllClients();
    }
    public Optional<ClientModel> getClient(Integer idClient){
        return clientRepository.getClient(idClient);
    }
    public ClientModel saveClient(ClientModel clientModel){
        return clientRepository.saveClient(clientModel);
    }
    public boolean deleteClient(Integer idClient){
        try{
            clientRepository.deleteClient(idClient);
            return true;
        }catch (Exception e){
            return false;
        }
   }
    public ClientModel updateClient(ClientModel clientModel){
        if(clientModel.getIdClient()!=null){
            Optional<ClientModel> c = clientRepository.getClient(clientModel.getIdClient());
            if(!c.isEmpty()){
                if(clientModel.getName()!=null){
                    c.get().setName(clientModel.getName());
                }
                if(clientModel.getEmail()!=null){
                    c.get().setEmail(clientModel.getEmail());
                }
                if(clientModel.getAge()!=null){
                    c.get().setAge(clientModel.getAge());
                }
                if(clientModel.getPassword()!=null){
                    c.get().setPassword(clientModel.getPassword());
                }
                if(clientModel.getMessages()!=null){
                    c.get().setMessages(clientModel.getMessages());
                }
                if(clientModel.getReservations()!=null){
                    c.get().setReservations(clientModel.getReservations());
                }
                clientRepository.saveClient(c.get());
                return c.get();
            }else{
                return clientModel;
            }
        }else{
            return clientModel;
        }
    }

}
