package com.svartberg.springbootflagsloader.service;

import com.svartberg.springbootflagsloader.client.CountryFlagClient;
import com.svartberg.springbootflagsloader.dto.CountryDTO;
import com.svartberg.springbootflagsloader.dto.CountryFlagDTO;
import com.svartberg.springbootflagsloader.exception.DirectoryDoesNotExist;
import com.svartberg.springbootflagsloader.model.FlagUrl;
import com.svartberg.springbootflagsloader.model.ImgType;
import java.io.File;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CountryFlagServiceImpl implements CountryFlagService {

  private final FlagLoaderService flagLoaderService;
  private final CountryFlagClient countryFlagsClient;

  @Override
  public void saveCountryFlags(CountryFlagDTO countryDTO) {
    validateSavePath(countryDTO.getPath());
    List<CountryDTO> countryFlagsInfo = getCountryFlagsInfo(countryDTO.getNames());
    countryFlagsInfo.forEach(e ->
        flagLoaderService.downloadAndSaveFlag(e.getName(),
            getFlagUrlOfType(e.getFlags(), countryDTO.getFormat()),
            countryDTO.getPath(),
            countryDTO.getFormat()));

  }

  private void validateSavePath(String path) {
    var directory = new File(path);
    if (!directory.isDirectory()) {
      throw new DirectoryDoesNotExist(path);
    }
  }

  private String getFlagUrlOfType(FlagUrl flagUrl, ImgType imgType) {
    if (imgType == ImgType.PNG) {
      return flagUrl.getPng();
    } else {
      return flagUrl.getSvg();
    }
  }

  private List<CountryDTO> getCountryFlagsInfo(List<String> countryNames) {
    return countryFlagsClient.getCountry(countryNames);
  }
}
