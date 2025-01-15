package mate.academy.rickandmorty.mapper;

import mate.academy.rickandmorty.config.AppConfig;
import mate.academy.rickandmorty.dto.internal.episode.EpisodeDto;
import mate.academy.rickandmorty.model.Episode;
import org.mapstruct.Mapper;

@Mapper(config = AppConfig.class)
public interface EpisodeMapper {

    EpisodeDto toDto(Episode episode);

    Episode toModel(EpisodeDto episodeDto);
}
