package com.doctors.controller;

import com.doctors.modelo.ClientModel;
import com.doctors.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public List<ClientModel> getAllClients(){
        return clientService.getAllClients();
    }
    @PostMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public List<ClientModel> getAllClients2(){
        return clientService.getAllClients();
    }
    @GetMapping("/{idClient}")
    public Optional<ClientModel> getClient(@PathVariable Integer idClient){
        return clientService.getClient(idClient);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ClientModel saveClient(@RequestBody ClientModel clientModel){
        return clientService.saveClient(clientModel);
    }

    @DeleteMapping("/delete/{idClient}")
    public boolean deleteClient(@PathVariable Integer idClient){
        return clientService.deleteClient(idClient);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public ClientModel updateClient(@RequestBody ClientModel clientModel){
        return clientService.updateClient(clientModel);
    }



}
