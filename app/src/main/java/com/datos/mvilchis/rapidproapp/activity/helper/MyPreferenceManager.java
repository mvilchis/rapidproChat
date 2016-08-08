package com.datos.mvilchis.rapidproapp.activity.helper;

import android.content.Context;
import android.content.SharedPreferences;

import com.datos.mvilchis.rapidproapp.activity.Model.Contact;

/**
 * Created by Admin on 07/08/2016.
 */
public class MyPreferenceManager {
  private String TAG = MyPreferenceManager.class.getSimpleName();
  SharedPreferences preference;
  SharedPreferences.Editor editor;
  Context context;
  int PRIVATE_MODE = 0;
  private static final String PREF_NAME = "android_rapidpro";
  private static final String KEY_USER_ID = "user_id";
  private static final String KEY_USER_EMAIL = "user_email";
  private static final String KEY_NOTIFICATIONS = "notifications";

  public  MyPreferenceManager(Context context){
    this.context = context;
    preference = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
    editor = preference.edit();
  }
  public void storeContact(Contact contact) {
    editor.putString(KEY_USER_EMAIL, contact.getEmail());
    editor.commit();
  }
  public Contact getContact() {
    if (preference.getString(KEY_USER_EMAIL, null) != null) {
      String email;
      email = preference.getString(KEY_USER_EMAIL, null);
      return new Contact(email);
    }
    return  null;
  }
  public void addNotification(String notification) {
    String oldNotifications = getNotifications();
    if (oldNotifications != null) {
      oldNotifications += "|" + notification;
    }else {
      oldNotifications = notification;
    }
    editor.putString(KEY_NOTIFICATIONS, oldNotifications);
    editor.commit();
  }
  public String getNotifications() {
    return preference.getString(KEY_NOTIFICATIONS, null);
  }
  public void clear() {
    editor.clear();
    editor.commit();
  }
}
