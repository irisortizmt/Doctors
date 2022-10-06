package com.doctors.service;


import com.doctors.modelo.ScoreModel;
import com.doctors.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public List<ScoreModel> getAllScores(){
        return scoreRepository.getAllScores();
    }

    public Optional<ScoreModel> getScore(Integer id){
        return scoreRepository.getScore(id);
    }

    public ScoreModel saveScore(ScoreModel scoreModel){
        return scoreRepository.saveScore(scoreModel);
    }

    public boolean deleteScore(Integer id){
        try{
            scoreRepository.deleteScore(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public ScoreModel updateScore(ScoreModel scoreModel){
        if(scoreModel.getId()!=null){
            Optional<ScoreModel> s = scoreRepository.getScore(scoreModel.getId());
            if(!s.isEmpty()){
                if(scoreModel.getScore()!=null){
                    s.get().setScore(scoreModel.getScore());
                }
                scoreRepository.saveScore(s.get());
                return s.get();
            }else{
                return scoreModel;
            }
        }else{
            return scoreModel;
        }
    }

}
