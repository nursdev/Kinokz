package kino.kz.mapper;

import kino.kz.model.dto.ActorCreateDTO;
import kino.kz.model.dto.ActorViewDTO;
import kino.kz.model.entity.Actor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ActorMapper {

    public List<ActorViewDTO> toDTO(List<Actor> actors) {
        return actors.stream()
                .map(this::convertToDTO)
                .toList();
    }

    public ActorViewDTO toDTO(Actor actor) {
        return convertToDTO(actor);
    }

    public Actor toEntity(ActorCreateDTO actorCreateDTO) {
        return Actor.builder()
                .firstName(actorCreateDTO.getFirstName())
                .lastName(actorCreateDTO.getLastName())
                .build();
    }

    private ActorViewDTO convertToDTO(Actor actor) {
        return ActorViewDTO.builder()
                .id(actor.getId())
                .firstName(actor.getFirstName())
                .lastName(actor.getLastName())
                .build();
    }
}
