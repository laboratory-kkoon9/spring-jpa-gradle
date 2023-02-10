package com.laboratorykkoon9.springjpa.intra.boxoffice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class BoxOfficeDailyResponseDto {
    @JsonProperty(value = "boxOfficeResult")
    private BoxOfficeDailyDto boxOfficeDailyDto;

}
