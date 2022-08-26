package com.example.agendaLive.controller;

import com.example.agendaLive.dto.LiveDTO;
import com.example.agendaLive.service.LiveServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LiveApiController {

    @Autowired
    LiveServiceImpl liveService;

    @PostMapping("/")
    public ResponseEntity<?> toRegistrerLive(@RequestBody LiveDTO liveDTO) {
        System.out.println("tô aqui");
        return this.liveService.toRegistrerLive(liveDTO);
    }

    @PutMapping("/{liveName}")
    public ResponseEntity<?> toEditLive(@PathVariable String liveName, @RequestBody LiveDTO liveDTO){
        return this.liveService.toEditLive(liveName, liveDTO);
    }

    @DeleteMapping("/{liveName}")
    public ResponseEntity<?> toRemoveLive(@PathVariable String liveName){
        return this.liveService.toRemoveLive(liveName);
    }

    @GetMapping("/list")
    public ResponseEntity<?> toListLives(){
        return this.liveService.toListLives();
    }
}
