package org.example.singleton.def;

public class Clipboard {

  private String value;
  private static Clipboard clipboard = null;

  // Private constructor to prevent instantiation from outside
  private Clipboard() {

  }

  // Method to provide access to the singleton instance
  public static Clipboard getInstance() {
    if (clipboard == null) {
      clipboard = new Clipboard();
    }
    return clipboard;
  }

  public void copy(String value) {
    this.value = value;
  }

  public String paste() {
    return this.value;
  }

}
