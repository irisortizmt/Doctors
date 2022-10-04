package com.doctors.controller;

import com.doctors.modelo.AdminModel;
import com.doctors.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Admin")
@CrossOrigin(origins = "*")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/all")
    @PostMapping("/all")
    public List<AdminModel> getAllAdmins(){
        return adminService.getAllAdmins();
    }

    @GetMapping("/{id}")
    public Optional<AdminModel> getAdmin(@PathVariable Integer id){
        return adminService.getAdmin(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public AdminModel saveAdmin(@RequestBody AdminModel adminModel){
        return adminService.saveAdmin(adminModel);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteAdmin(@PathVariable Integer id){
        return adminService.deleteAdmin(id);
    }

    @PutMapping("/update")
    public AdminModel updateAdmin(@RequestBody AdminModel adminModel){
        return adminService.updateAdmin(adminModel);
    }
}
