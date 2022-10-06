package com.doctors.controller;


import com.doctors.modelo.ScoreModel;
import com.doctors.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Score")
@CrossOrigin(origins="*")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @GetMapping("/all")
    public List<ScoreModel> getAllScores(){
        return scoreService.getAllScores();
    }

    @PostMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public List<ScoreModel> getAllScores2(){
        return scoreService.getAllScores();
    }

    @GetMapping("/{id}")
    public Optional<ScoreModel> getScore(@PathVariable Integer id){
        return scoreService.getScore(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ScoreModel saveScore(@RequestBody ScoreModel scoreModel){
        return scoreService.saveScore(scoreModel);
    }
    @DeleteMapping("/delete/{id}")
    public boolean deleteScore(@PathVariable Integer id){
        return scoreService.deleteScore(id);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public ScoreModel updateScore(@RequestBody ScoreModel scoreModel){
        return scoreService.updateScore(scoreModel);
    }
}
