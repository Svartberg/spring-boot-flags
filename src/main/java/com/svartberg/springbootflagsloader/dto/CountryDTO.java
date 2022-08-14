package com.svartberg.springbootflagsloader.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.svartberg.springbootflagsloader.model.FlagUrl;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CountryDTO {

  @JsonProperty("name")
  private String name;

  @JsonProperty("flags")
  private FlagUrl flags;
}
