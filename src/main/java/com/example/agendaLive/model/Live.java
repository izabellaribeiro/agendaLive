package com.example.agendaLive.model;

import com.example.agendaLive.dto.LiveDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.asm.Advice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Live {

    @Id
    @GeneratedValue
    Long id;

    private String liveName;
    private String channelName;
    private LocalDate localDate;
    private String liveLink;
    private LocalDate registrationDate;

    public Live(LiveDTO liveDTO) {
        this.liveName = liveDTO.getLiveName();
        this.channelName = liveDTO.getChannelName();
        this.localDate = LocalDate.parse(liveDTO.getLocalDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.liveLink = liveDTO.getLiveLink();
        this.registrationDate = LocalDate.parse(liveDTO.getRegistrationDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public void editar(LiveDTO liveDTO) {
        this.setLiveName(liveDTO.getLiveName());
        this.setChannelName(liveDTO.getChannelName());
        this.setLocalDate(LocalDate.parse(liveDTO.getLocalDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        this.setLiveLink(liveDTO.getLiveLink());
        this.setRegistrationDate(LocalDate.parse(liveDTO.getRegistrationDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }

    public LiveDTO getDto(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        return new LiveDTO(this.liveName, this.channelName, this.localDate.format(formatter), this.liveLink, this.registrationDate.format(formatter));
    }
}