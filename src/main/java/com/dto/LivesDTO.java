package com.dto;

import ch.qos.logback.core.util.COWArrayList;
import com.model.Live;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.ArrayList;

@NoArgsConstructor
@Getter
@Setter
public class LivesDTO {

    List<LiveDTO> dataLives;

    public LivesDTO(List<Live> liveList){
        this.dataLives = new ArrayList<>();

        for (Live live : liveList) {
            dataLives.add(live.getDto());
        }
    }

}
