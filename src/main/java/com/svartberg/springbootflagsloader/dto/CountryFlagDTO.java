package com.svartberg.springbootflagsloader.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.svartberg.springbootflagsloader.model.ImgType;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CountryFlagDTO {

  @JsonProperty("names")
  private List<String> names;

  @JsonProperty("path")
  private String path;

  @JsonProperty("format")
  private ImgType format;
}
