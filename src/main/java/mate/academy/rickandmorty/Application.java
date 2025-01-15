package mate.academy.rickandmorty;

import com.fasterxml.jackson.databind.ObjectMapper;
import mate.academy.rickandmorty.dto.external.character.CharacterInfoDto;
import mate.academy.rickandmorty.dto.external.character.CharacterResponseDataDto;
import mate.academy.rickandmorty.services.rickandmortyclient.CartoonClient;
import mate.academy.rickandmorty.services.rickandmortyclient.CharacterDtoConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Map;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
//        CartoonClient client = new CartoonClient(new ObjectMapper());
//        List<CharacterResponseDataDto> character = client.fetchDataFromApi("character", CharacterResponseDataDto.class);
//        System.out.println(character);
    }
}
