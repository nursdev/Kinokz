package kino.kz.service;

import kino.kz.model.dto.ActorCreateDTO;
import kino.kz.model.dto.ActorViewDTO;
import kino.kz.mapper.ActorMapper;
import kino.kz.model.entity.Actor;
import kino.kz.repository.ActorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ActorService {

    private final ActorRepository actorRepository;
    private final ActorMapper actorMapper;
    public List<ActorViewDTO> getActors() {
        List<Actor> actors = actorRepository.findAll();
        return actorMapper.toDTO(actors);
    }

    @Transactional
    public ActorViewDTO createActor(ActorCreateDTO actorCreateDTO) {
        Actor actor = actorMapper.toEntity(actorCreateDTO);
        actorRepository.save(actor);
        return actorMapper.toDTO(actor);
    }

    @Transactional
    public void deleteActor(Long id) {
        actorRepository.deleteById(id);
    }
}
