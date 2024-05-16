package org.example.creational.singleton.def;

import java.io.Serializable;

public class SerializableSingleton implements Serializable {

  public static SerializableSingleton INSTANCE = null;

  private SerializableSingleton() {}

  public static SerializableSingleton getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new SerializableSingleton();
    }
    return INSTANCE;
  }

  // Method to prevent cloning of Singleton objects
//  protected Object clone() throws CloneNotSupportedException {
//    throw new CloneNotSupportedException("Cloning of Singleton instance is not allowed");
//  }

  // Method to prevent deserialization from creating new instances
  /**
   * This is the key method which is responsible during deserialization process
   * This method get invoked, and we are simply returning already created object
   * @return
   */
  protected Object readResolve() {
    return getInstance();
  }

}
