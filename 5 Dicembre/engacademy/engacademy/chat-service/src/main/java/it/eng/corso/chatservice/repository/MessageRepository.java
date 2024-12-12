package it.eng.corso.chatservice.repository;

import it.eng.corso.chatservice.model.Message;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

@Repository
public interface MessageRepository extends ReactiveMongoRepository<Message, String> {

    @Tailable
    Flux<Message> findByRoomId(Integer roomId);
}
