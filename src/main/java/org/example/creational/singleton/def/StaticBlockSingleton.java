package org.example.creational.singleton.def;

public class StaticBlockSingleton {

  private static StaticBlockSingleton INSTANCE;

  private StaticBlockSingleton() {

  }

  static {
    try {
      INSTANCE = new StaticBlockSingleton();
    } catch(Exception e) {
      throw new RuntimeException("Exception occurred in creating singleton instance");
    }
  }

  private static StaticBlockSingleton getInstance() {
    return INSTANCE;
  }

}
