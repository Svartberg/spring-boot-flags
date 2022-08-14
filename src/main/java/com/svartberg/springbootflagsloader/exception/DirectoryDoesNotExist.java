package com.svartberg.springbootflagsloader.exception;

public class DirectoryDoesNotExist extends RuntimeException {

  public DirectoryDoesNotExist(String path) {
    super("Directory with the path: " + path + " does not exists");
  }
}
