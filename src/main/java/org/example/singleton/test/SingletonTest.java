package org.example.singleton.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.example.singleton.def.EnumSingleton;
import org.example.singleton.def.LazySingleton;

public class SingletonTest {

  public static void main(String[] args)
      throws InvocationTargetException, InstantiationException, IllegalAccessException {
    breakingSinglton();

  }

  private static void breakingSinglton()
      throws InvocationTargetException, InstantiationException, IllegalAccessException {
    Constructor[] constructors = LazySingleton.class.getDeclaredConstructors();
    Constructor constructor = constructors[0];
    // making the constructor as public
    constructor.setAccessible(true);
    LazySingleton lazySingletonRef = (LazySingleton) constructor.newInstance();
    LazySingleton lazySingleton = LazySingleton.getInstance();
    System.out.println("Hash code of the object of Reflection Obj "+ lazySingletonRef.hashCode());
    System.out.println("Hash code of the objcet of getInstance "+ lazySingleton.hashCode());

    // Solution for this is Enum
    EnumSingleton.INSTANCE.doSomething();
  }

}
