package com.svartberg.springbootflagsloader.controller;

import com.svartberg.springbootflagsloader.dto.CountryFlagDTO;
import com.svartberg.springbootflagsloader.service.CountryFlagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class CountryFlagController {

  private final CountryFlagService countryFlagService;

  @PostMapping("/")
  public ResponseEntity<?> postFlagsDownload(@RequestBody CountryFlagDTO countryFlagDTO) {
    countryFlagService.saveCountryFlags(countryFlagDTO);
    return ResponseEntity.noContent().build();
  }
}
