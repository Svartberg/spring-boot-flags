package com.svartberg.springbootflagsloader.service;

import com.svartberg.springbootflagsloader.model.ImgType;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.PreDestroy;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FlagLoaderServiceImpl implements FlagLoaderService {

  private final Logger logger = LoggerFactory.getLogger(FlagLoaderServiceImpl.class);

  private final ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 1, TimeUnit.SECONDS,
      new LinkedBlockingQueue<>());

  @Override
  public void downloadAndSaveFlag(String countryName, String flagUrl, String savePath,
      ImgType format) {
    executor.submit(() -> {
      logger.debug("Thread " + Thread.currentThread());
      try {
        URL flagUlr = new URL(flagUrl);
        File path = new File(createPathToFlagImage(savePath, countryName, format));
        logger.debug(path.getPath());

        FileUtils.copyURLToFile(flagUlr, path);

      } catch (IOException e) {
        logger.error(e.getMessage());
      }
    });
  }

  @PreDestroy
  public void destroy() {
    executor.shutdown();
  }

  private String createPathToFlagImage(String savePath, String countryName, ImgType format) {
    return savePath + "/" + countryName.replace(' ', '_').toLowerCase() + "." + format;
  }
}
