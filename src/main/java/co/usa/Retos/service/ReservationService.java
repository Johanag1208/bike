package co.usa.Retos.service;

import co.usa.Retos.model.Reservation;
import co.usa.Retos.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return  reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int id){
        return  reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation r) {
        if (r.getIdReservation() == null) {
            return  reservationRepository.save(r);
        } else {
            Optional <Reservation> raux= reservationRepository.getReservation(r.getIdReservation());
            if(raux.isEmpty()){
                return  reservationRepository.save(r);
            }else{
                return r;
            }
        }
    }
}
