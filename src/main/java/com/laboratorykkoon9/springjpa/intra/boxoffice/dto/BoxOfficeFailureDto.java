package com.laboratorykkoon9.springjpa.intra.boxoffice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoxOfficeFailureDto {
    private BoxOfficeFailureInnerDto faultInfo;

    public BoxOfficeFailureDto(BoxOfficeFailureInnerDto faultInfo) {
        this.faultInfo = faultInfo;
    }
}
