package com.laboratorykkoon9.springjpa.intra.boxoffice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.laboratorykkoon9.springjpa.intra.boxoffice.dto.BoxOfficeDailyResponseDto;
import com.laboratorykkoon9.springjpa.intra.boxoffice.dto.BoxOfficeRequestDto;
import com.laboratorykkoon9.springjpa.intra.boxoffice.util.JsonParser;
import com.laboratorykkoon9.springjpa.intra.boxoffice.util.JsonToMapConverter;
import com.laboratorykkoon9.springjpa.intra.boxoffice.util.QueryStringConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@RequiredArgsConstructor
@Service
public class BoxOfficeClient {
    private final WebClient webClient = WebClient.builder().build();
    private final ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
    @Value("${boxoffice.base-url}")
    private String BASE_URL;
    @Value("${boxoffice.key}")
    private String API_KEY;

    private WebClient.ResponseSpec requestGet(String path, String param) {
        return webClient.get()
                .uri(BASE_URL + path + param)
                .retrieve();
    }

    public BoxOfficeDailyResponseDto dailyBoxOffices(BoxOfficeRequestDto dto) {
        BoxOfficeDailyResponseDto result = null;
        JsonParser<BoxOfficeRequestDto> jsonParser = new JsonParser<>();
        try {
            String queryString = QueryStringConverter.convert(JsonToMapConverter.convert(jsonParser.parse(dto)));
            result = requestGet("searchDailyBoxOfficeList.json", queryString)
                    .bodyToMono(BoxOfficeDailyResponseDto.class)
                    .block();
        } catch (Exception e) {
            log.info("dailyBoxOffices error = {}", e.getLocalizedMessage());
            new IllegalArgumentException(e.getLocalizedMessage());
        }
        return result;
    }
}
