package kino.kz.controller;

import kino.kz.model.dto.ActorCreateDTO;
import kino.kz.model.dto.ActorViewDTO;
import kino.kz.service.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/actors")
@RequiredArgsConstructor
public class ActorController {

    private final ActorService actorService;

    @GetMapping
    public ResponseEntity<List<ActorViewDTO>> getActors() {
        return ResponseEntity.ok(actorService.getActors());
    }

    @PostMapping
    public ResponseEntity<List<ActorViewDTO>> createActor(@RequestBody ActorCreateDTO actor) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Collections.singletonList(actorService.createActor(actor)));
    }

    @DeleteMapping("/{actorId}")
    public ResponseEntity<Void> deleteActor(@PathVariable("actorId") Long id) {
        actorService.deleteActor(id);
        return ResponseEntity.ok().build();
    }
}
