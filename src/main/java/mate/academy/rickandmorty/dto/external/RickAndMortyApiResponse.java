package mate.academy.rickandmorty.dto.external;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RickAndMortyApiResponse<T, M> {
    private M info;
    private List<T> results;

}
