package com.model;

import com.dto.LiveDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

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
    private LocalDateTime localDate;
    private String liveLink;
    private LocalDateTime registrationDate;

    public Live(LiveDTO liveDTO) {
        this.liveName = liveDTO.getLiveName();
        this.channelName = liveDTO.getChannelName();
        this.localDate = liveDTO.getLocalDate();
        this.liveLink = liveDTO.getLiveLink();
        this.registrationDate = liveDTO.getRegistrationDate();
    }

    public void editar(LiveDTO liveDTO) {
        this.setLiveName(liveDTO.getLiveName());
        this.setChannelName(liveDTO.getChannelName());
        this.setLocalDate(liveDTO.getLocalDate());
        this.setLiveLink(liveDTO.getLiveLink());
        this.setRegistrationDate(liveDTO.getRegistrationDate());
    }

    public LiveDTO getDto(){
        return new LiveDTO(this.liveName, this.channelName, this.localDate, this.liveLink, this.registrationDate);
    }
}