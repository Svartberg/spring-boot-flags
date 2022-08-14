package com.svartberg.springbootflagsloader.service;

import com.svartberg.springbootflagsloader.model.ImgType;

public interface FlagLoaderService {

  void downloadAndSaveFlag(String countryName, String FlagUrl, String savePath, ImgType format);

}
