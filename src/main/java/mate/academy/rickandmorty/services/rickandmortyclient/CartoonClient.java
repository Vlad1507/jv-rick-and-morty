package mate.academy.rickandmorty.services.rickandmortyclient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

import mate.academy.rickandmorty.dto.external.RickAndMortyDto;
import mate.academy.rickandmorty.dto.external.character.CharacterInfoDto;
import mate.academy.rickandmorty.dto.external.character.CharacterResponseDataDto;
import mate.academy.rickandmorty.dto.external.episode.EpisodeInfoDto;
import mate.academy.rickandmorty.dto.external.episode.EpisodeResponseDataDto;
import mate.academy.rickandmorty.dto.external.location.LocationInfoDto;
import mate.academy.rickandmorty.dto.external.location.LocationResponseDataDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CartoonClient {
    private static final String BASE_URL = "https://rickandmortyapi.com/api/";
    private static final Map<String, Class<? extends RickAndMortyDto>> endpointToDto = Map.of(
            "character", CharacterResponseDataDto.class,
            "episode", EpisodeResponseDataDto.class,
            "location", LocationResponseDataDto.class
    );
    private final ObjectMapper objectMapper;
    private final HttpClient client = HttpClient.newHttpClient();
    private final RestTemplate restTemplate = new RestTemplateBuilder().build();

    public CartoonClient(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public List<CharacterInfoDto> fetchCharacterDataFromApi(String endpoint) {
        Class<? extends RickAndMortyDto> dtoClass = endpointToDto.get(endpoint);
        String url = BASE_URL + endpoint;
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url))
                .build();
        try {
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
//            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            RickAndMortyDto responseDto = objectMapper.readValue(responseEntity.getBody(), dtoClass);
            CharacterResponseDataDto characterResponseDataDto = (CharacterResponseDataDto) responseDto;
            return characterResponseDataDto.getResults();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<LocationInfoDto> fetchLocationDataFromApi(String endpoint) {
        Class<? extends RickAndMortyDto> dtoClass = endpointToDto.get(endpoint);
        String url = BASE_URL + endpoint;
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            RickAndMortyDto responseDto = objectMapper.readValue(response.body(), dtoClass);
            LocationResponseDataDto locationResponseDataDto = (LocationResponseDataDto) responseDto;
            return locationResponseDataDto.getResults();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public List<EpisodeInfoDto> fetchEpisodeDataFromApi(String endpoint) {
        Class<? extends RickAndMortyDto> dtoClass = endpointToDto.get(endpoint);
        String url = BASE_URL + endpoint;
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            RickAndMortyDto responseDto = objectMapper.readValue(response.body(), dtoClass);
            EpisodeResponseDataDto episodeResponseDataDto = (EpisodeResponseDataDto) responseDto;
            return episodeResponseDataDto.getResults();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
