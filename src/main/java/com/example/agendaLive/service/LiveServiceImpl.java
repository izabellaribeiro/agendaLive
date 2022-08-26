package com.example.agendaLive.service;

import com.example.agendaLive.dto.LiveDTO;
import com.example.agendaLive.dto.LivesDTO;
import com.example.agendaLive.model.Live;
import com.example.agendaLive.repository.LiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LiveServiceImpl {

    @Autowired
    LiveRepository liveRepository;

    public ResponseEntity<?> toRegistrerLive(LiveDTO liveDTO) {
        Live live = new Live(liveDTO);
        // criar exceção para a possibilidade da existência dessa live;

        this.liveRepository.save(live);

        return ResponseEntity.status(HttpStatus.CREATED).body(live.getDto());
    }

    public ResponseEntity<?> toEditLive(String liveName, LiveDTO liveDTO) {
        Live live = getLiveByName(liveName);
        live.editar(liveDTO);
        this.liveRepository.save(live);

        return ResponseEntity.status(HttpStatus.OK).body(live.getDto());
    }

    public ResponseEntity<?> toRemoveLive(String liveName) {
        this.liveRepository.delete(getLiveByName(liveName));

        return ResponseEntity.status(HttpStatus.OK).body("Live removida!");
    }

    public ResponseEntity<?> toListLives() {
        List<Live> liveList = this.liveRepository.findAll();
        LivesDTO livesDTO = new LivesDTO(liveList);

        return ResponseEntity.status(HttpStatus.OK).body(livesDTO.getDataLives());
    }

    public Live getLiveByName(String liveName){
        Live live;

        if (liveRepository.findByLiveName(liveName).isPresent()) {
            live = liveRepository.findByLiveName(liveName).get();
        } else {
            return null;
        }
        return live;
    }
}
