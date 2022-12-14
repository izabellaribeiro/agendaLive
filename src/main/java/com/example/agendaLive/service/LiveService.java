package com.example.agendaLive.service;

import com.example.agendaLive.dto.LiveDTO;
import org.springframework.http.ResponseEntity;

public interface LiveService {

    public ResponseEntity<?> toRegistrerLive(LiveDTO liveDTO);
    public ResponseEntity<?> toEditLive(String liveName, LiveDTO liveDTO);
    public ResponseEntity<?> toRemoveLive(String liveName);
    public ResponseEntity<?> toListLives();
    public ResponseEntity<?> getLiveByName();

}