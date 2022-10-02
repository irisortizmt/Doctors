package com.doctors.repository;

import com.doctors.modelo.DoctorModel;
import com.doctors.modelo.ScoreModel;
import com.doctors.repository.crudrepository.ScoreCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

@Repository
public class ScoreRepository {

    @Autowired
    private ScoreCrudRepository scoreCrudRepository;

    public List<ScoreModel> getAllScores() {
        return (List<ScoreModel>) scoreCrudRepository.findAll();
    }

    public Optional<ScoreModel> getScore(Integer id) {
        return scoreCrudRepository.findById(id);
    }

    public ScoreModel saveScore(ScoreModel scoreModel ){

        return scoreCrudRepository.save(scoreModel);
    }
    public boolean deleteScore(Integer id){
        scoreCrudRepository.deleteById(id);
        return true;
    }

    public ScoreModel updateScore (ScoreModel scoreModel){
        return scoreCrudRepository.save(scoreModel);
    }
}
