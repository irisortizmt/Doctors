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
    public List<AdminModel> getAllAdmins(){
        return adminService.getAllAdmins();
    }

    @PostMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public List<AdminModel> getAllAdmins2() {
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

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteAdmin(@PathVariable Integer id){
        return adminService.deleteAdmin(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public AdminModel updateAdmin(@RequestBody AdminModel adminModel){
        return adminService.updateAdmin(adminModel);
    }
}
