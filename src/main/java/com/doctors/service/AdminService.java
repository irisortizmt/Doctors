package com.doctors.service;

import com.doctors.modelo.AdminModel;
import com.doctors.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<AdminModel> getAllAdmins(){
        return adminRepository.getAllAdmins();
    }

    public Optional<AdminModel> getAdmin(Integer id){
        return adminRepository.getAdmin(id);
    }

    public AdminModel saveAdmin(AdminModel adminModel){
        return adminRepository.saveAdmin(adminModel);
    }

    public boolean deleteAdmin (Integer id){
        return adminRepository.deleteAdmin(id);
    }

    public AdminModel updateAdmin (AdminModel adminModel){
        return adminRepository.updateAdmin(adminModel);
    }
}
