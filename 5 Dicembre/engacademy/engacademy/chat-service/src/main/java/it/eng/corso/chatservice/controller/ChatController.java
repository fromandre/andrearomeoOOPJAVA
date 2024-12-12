package it.eng.corso.chatservice.controller;

import it.eng.corso.chatservice.model.Message;
import it.eng.corso.chatservice.service.MessageService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@RestController
public class ChatController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/chat")
    public Mono<Message> save(@RequestBody Message message ){
        message.setCreatedAt(LocalDateTime.now() );
        return messageService.save( message );
    }

    @GetMapping(value = "/chat/room/{roomId}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Message> findByRoomId(@PathVariable Integer roomId){
        return messageService.findByRoomId( roomId );
    }



}
