package org.example.creational.singleton.def;

public class EagerSingleton {

  private static EagerSingleton INSTANCE = new EagerSingleton();

  private EagerSingleton() {}

  /**
   * it will solve the multi threading problem
   * @return
   */
  public static EagerSingleton getInstance() {
    return INSTANCE;
  }

}
