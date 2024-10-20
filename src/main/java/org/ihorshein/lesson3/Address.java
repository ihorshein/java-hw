package org.ihorshein.lesson3;

class Address {
  /**
   * City name.
   */
  private String city;

  /**
   * Street name.
   */
  private String street;

  Address(String city, String street) {
    this.city = city;
    this.street = street;
  }

  public String getCity() {
    return city;
  }
}
