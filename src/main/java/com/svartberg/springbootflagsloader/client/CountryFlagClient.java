package com.svartberg.springbootflagsloader.client;

import com.svartberg.springbootflagsloader.dto.CountryDTO;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(value = "flags", url = "https://restcountries.com/")
public interface CountryFlagClient {

  @ResponseBody
  @GetMapping(path = "v2/alpha?codes={country}&fields=flags&fields=name", consumes = "application/json")
  List<CountryDTO> getCountry(@PathVariable("country") List<String> country);
}
