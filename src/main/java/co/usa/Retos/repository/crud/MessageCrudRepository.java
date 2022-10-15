package co.usa.Retos.repository.crud;

import co.usa.Retos.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
}
