package com.example.agendaLive.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LiveDTO {

    String liveName;
    String channelName;
    String localDate;
    String liveLink;
    String registrationDate;

}
