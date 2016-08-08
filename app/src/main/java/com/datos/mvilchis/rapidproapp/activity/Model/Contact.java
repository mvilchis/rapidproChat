package com.datos.mvilchis.rapidproapp.activity.Model;

import java.io.Serializable;
import java.io.StringReader;

/**
 * Created by Admin on 07/08/2016.
 */
public class Contact implements Serializable{
  private String email;
  public Contact() {
  }

  public Contact(String email) {
    this.email = email;
  }
  public String getEmail() {
    return  this.email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
}
