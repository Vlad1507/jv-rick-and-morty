package mate.academy.rickandmorty.services.rickandmortyclient;

import mate.academy.rickandmorty.dto.external.character.CharacterInfoDto;
import mate.academy.rickandmorty.mapper.CharacterMapper;
import mate.academy.rickandmorty.repository.cartooncharacter.CartoonCharacterRepository;
import mate.academy.rickandmorty.services.CharacterService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CharacterDtoConvertService {
    private final CartoonClient client;
    private final CharacterService service;
    private static final String CHARACTER_ENDPOINT = "character";
    private final CharacterMapper mapper;
    private final CartoonCharacterRepository repository;

    public CharacterDtoConvertService(CartoonClient client, CharacterService service, CharacterMapper mapper, CartoonCharacterRepository repository) {
        this.client = client;
        this.service = service;
        this.mapper = mapper;
        this.repository = repository;
    }

    public void getCharacterConvertedDto() {
        List<CharacterInfoDto> characterInfoDto = client.fetchCharacterDataFromApi(CHARACTER_ENDPOINT);
        for (CharacterInfoDto character : characterInfoDto) {
            service.save(mapper.toModel(character));
        }
    }

    private List<CharacterInfoDto> getCharacterInfoDtos(List<CharacterInfoDto> list) {
        for (CharacterInfoDto characterInfoDto : list) {
//            service.save(characterInfoDto);
        }
        return list;
    }

}
