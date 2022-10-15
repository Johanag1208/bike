package co.usa.Retos.service;

import co.usa.Retos.model.Message;
import co.usa.Retos.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll(){
        return  messageRepository.getAll();
    }

    public Optional<Message> getMessage(int id){
        return  messageRepository.getMessage(id);
    }

    public Message save(Message m) {
        if (m.getIdMessage() == null) {
            return  messageRepository.save(m);
        } else {
            Optional <Message> maux= messageRepository.getMessage(m.getIdMessage());
            if(maux.isEmpty()){
                return  messageRepository.save(m);
            }else{
                return m;
            }
        }
    }

}
