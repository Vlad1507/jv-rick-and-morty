package mate.academy.rickandmorty.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mate.academy.rickandmorty.dto.external.character.CharacterInfoDto;
import mate.academy.rickandmorty.dto.internal.cartoon.CartoonCharacterDto;
import mate.academy.rickandmorty.dto.internal.cartoon.CartoonCharacterSearchDto;
import mate.academy.rickandmorty.mapper.CharacterMapper;
import mate.academy.rickandmorty.services.CharacterService;
import mate.academy.rickandmorty.services.rickandmortyclient.CartoonClient;
import mate.academy.rickandmorty.services.rickandmortyclient.CharacterDtoConvertService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/characters")
@RequiredArgsConstructor
public class CharacterController {
    private final CharacterService characterService;
    private final CharacterDtoConvertService convertService;
    private final CartoonClient client;
    private final CharacterMapper mapper;

//    @PostMapping
//    public CartoonCharacterDto save(@RequestBody CharacterInfoDto characterInfoDto) {
//        return characterService.save(characterInfoDto);
//    }

    @GetMapping("/all")
    public List<CartoonCharacterDto> findAll(Pageable pageable) {
        return characterService.findAll(pageable);
    }

    @GetMapping("/search")
    public List<CartoonCharacterDto> findAllByName(
            CartoonCharacterSearchDto cartoonCharacterSearchDto
    ) {
        return characterService.searchAllByName(cartoonCharacterSearchDto);
    }

    @GetMapping("/test")
    public ResponseEntity<String> test(Pageable pageable){
        convertService.getCharacterConvertedDto();
        List<CharacterInfoDto> characterInfoDtos = client.fetchCharacterDataFromApi("character");
        characterService.save(mapper.toModel(characterInfoDtos.stream().findFirst().get()));
        return ResponseEntity.ok("Data was fetched and saved successfully");
    }
}
