package com.svartberg.springbootflagsloader.service;

import com.svartberg.springbootflagsloader.dto.CountryFlagDTO;

public interface CountryFlagService {

  void saveCountryFlags(CountryFlagDTO countryDTO);
}
