package org.example.singleton.def;

public class LazySingleton {

  private static LazySingleton INSTANCE = null;

  private LazySingleton() {}

  /**
   * In Lazy Singleton here is the problem multithreading
   * when two threads trying to access the method at same time it will creates the 2 Objects
    * @return
   */
  public static LazySingleton getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new LazySingleton();
    }
    return INSTANCE;
  }

}
