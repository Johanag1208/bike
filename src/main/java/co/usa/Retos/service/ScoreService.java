package co.usa.Retos.service;

import co.usa.Retos.model.Score;
import co.usa.Retos.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll(){
        return  scoreRepository.getAll();
    }

    public Optional<Score> getScore(int id){
        return  scoreRepository.getScore(id);
    }

    public Score save(Score s) {
        if (s.getIdScore() == null) {
            return  scoreRepository.save(s);
        } else {
            Optional <Score> saux= scoreRepository.getScore(s.getIdScore());
            if(saux.isEmpty()){
                return  scoreRepository.save(s);
            }else{
                return s;
            }
        }
    }
}
