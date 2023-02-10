package com.laboratorykkoon9.springjpa.intra.boxoffice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoxOfficeFailureInnerDto {
    private String message;
    private String errorCode;

    public BoxOfficeFailureInnerDto(String message, String errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }
}
