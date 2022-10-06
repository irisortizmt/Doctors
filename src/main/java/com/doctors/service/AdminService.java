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
        try{
            adminRepository.deleteAdmin(id);
            return true;
        }catch (Exception e){
            return false;
        }
     }

    public AdminModel updateAdmin (AdminModel adminModel){
        if(adminModel.getId()!=null){
            Optional<AdminModel> a = adminRepository.getAdmin(adminModel.getId());
            if(!a.isEmpty()){
                if(adminModel.getName()!=null){
                    a.get().setName(adminModel.getName());
                }
                if(adminModel.getEmail()!=null){
                    a.get().setEmail(adminModel.getEmail());
                }
                if(adminModel.getPassword()!=null){
                    a.get().setPassword(adminModel.getPassword());
                }
                adminRepository.saveAdmin(a.get());
                return a.get();
            }else{
                return adminModel;
            }
        }else{
            return adminModel;
        }
    }
}
