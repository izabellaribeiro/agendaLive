package com.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LiveDTO {

    String liveName;
    String channelName;
    LocalDateTime localDate;
    String liveLink;
    LocalDateTime registrationDate;

}
