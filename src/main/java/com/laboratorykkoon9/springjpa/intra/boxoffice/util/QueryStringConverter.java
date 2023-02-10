package com.laboratorykkoon9.springjpa.intra.boxoffice.util;

import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

import static com.laboratorykkoon9.springjpa.intra.boxoffice.constants.BoxOfficeConstants.EMPTY_ERROR_MESSAGE;

public class QueryStringConverter {
    private QueryStringConverter() {
    }

    public static String convert(Map<String, Object> messages) {
        if (messages == null) {
            throw new NullPointerException(EMPTY_ERROR_MESSAGE);
        }
        UriComponentsBuilder queryString = UriComponentsBuilder.newInstance();
        for (String key : messages.keySet()) {
            if(messages.get(key) == null) {
                continue;
            }
            queryString.queryParam(key, messages.get(key).toString());
        }

        return queryString.toUriString();
    }
}
