package com.doctors.repository;

import com.doctors.modelo.AdminModel;
import com.doctors.repository.crudrepository.AdminCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AdminRepository {

    @Autowired
    private AdminCrudRepository adminCrudRepository;

    public List<AdminModel> getAllAdmins(){
        return (List<AdminModel>)adminCrudRepository.findAll();
    }

    public Optional<AdminModel> getAdmin(Integer id){
        return adminCrudRepository.findById(id);
    }

    public AdminModel saveAdmin(AdminModel adminModel){
        return adminCrudRepository.save(adminModel);
    }

    public boolean deleteAdmin(AdminModel adminModel){
        adminCrudRepository.delete(adminModel);
        return true;
    }

    public AdminModel updateAdmin(AdminModel adminModel){
        return adminCrudRepository.save(adminModel);
    }
}
