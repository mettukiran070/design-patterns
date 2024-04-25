package org.example.singleton.test;

import org.example.singleton.def.Clipboard;

public class SingletonTest {

  public static void main(String[] args) {
    Clipboard clipboard1 = Clipboard.getInstance();
    Clipboard clipboard2 = Clipboard.getInstance();

    clipboard1.copy("Java");
    clipboard2.copy("Design Patterns");

    System.out.println(clipboard1.paste());
    System.out.println(clipboard2.paste());
  }

}
