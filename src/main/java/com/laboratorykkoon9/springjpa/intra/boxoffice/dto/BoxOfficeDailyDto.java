package com.laboratorykkoon9.springjpa.intra.boxoffice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class BoxOfficeDailyDto {
    @JsonProperty(value = "boxofficeType")
    private String type;

    @JsonProperty(value = "showRange")
    private String range;

    @JsonProperty(value = "dailyBoxOfficeList")
    private List<BoxOfficeDailyItemDto> boxOfficeDailyItems;

}
