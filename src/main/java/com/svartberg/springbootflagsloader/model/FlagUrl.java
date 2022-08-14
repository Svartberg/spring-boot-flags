package com.svartberg.springbootflagsloader.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FlagUrl {

  @JsonProperty("svg")
  private String svg;

  @JsonProperty("png")
  private String png;
}
