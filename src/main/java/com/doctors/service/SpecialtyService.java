package com.doctors.service;

import com.doctors.modelo.SpecialtyModel;
import com.doctors.repository.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialtyService {

    @Autowired
    private SpecialtyRepository specialtyRepository;

    public List<SpecialtyModel> getAllSpecialties() {
        return specialtyRepository.getAllSpecialties();
    }

    public Optional<SpecialtyModel> getSpecialty(Integer id) {
        return specialtyRepository.getSpecialty(id);
    }

    public SpecialtyModel saveSpecialty(SpecialtyModel specialtyModel) {
        return specialtyRepository.saveSpecialty(specialtyModel);
    }

    public boolean deleteSpecialty(Integer id) {
        try{
            specialtyRepository.deleteSpecialty(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public SpecialtyModel updateSpecialty(SpecialtyModel specialtyModel) {
        if (specialtyModel.getId() != null) {
            Optional<SpecialtyModel> s = specialtyRepository.getSpecialty(specialtyModel.getId());
            if (!s.isEmpty()) {
                if (specialtyModel.getName() != null) {
                    s.get().setName(specialtyModel.getName());
                }
                if (specialtyModel.getDescription() != null) {
                    s.get().setDescription(specialtyModel.getDescription());
                }
                if (specialtyModel.getDoctors() != null) {
                    s.get().setDoctors(specialtyModel.getDoctors());
                }
                specialtyRepository.saveSpecialty(s.get());
                return s.get();
            } else {
                return specialtyModel;
            }
        } else {
                return specialtyModel;
            }
    }
}




