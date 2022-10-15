package co.usa.Retos.service;

import co.usa.Retos.model.Bike;
import co.usa.Retos.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BikeService {
    @Autowired
    private BikeRepository bikeRepository;

    public List<Bike> getAll(){
        return bikeRepository.getAll();
    }

    public Optional<Bike> getBike(int id){
        return bikeRepository.getBike(id);
    }

    public Bike save(Bike b) {
        if (b.getId() == null) {
            return bikeRepository.save(b);
        } else {
            Optional <Bike> baux=bikeRepository.getBike(b.getId());
            if(baux.isEmpty()){
                return bikeRepository.save(b);
            }else{
                return b;
            }
        }
    }
}
