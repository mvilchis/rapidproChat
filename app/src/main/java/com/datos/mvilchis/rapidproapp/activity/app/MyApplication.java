package com.datos.mvilchis.rapidproapp.activity.app;

import android.app.Application;
import android.content.Intent;

import com.datos.mvilchis.rapidproapp.activity.activity.LoginActivity;
import com.datos.mvilchis.rapidproapp.activity.helper.MyPreferenceManager;

/**
 * Created by Admin on 07/08/2016.
 */
public class MyApplication extends Application {
  public static final String TAG = MyApplication.class.getSimpleName();
  private static MyApplication mInstance;
  private MyPreferenceManager preference;
  @Override
  public void onCreate() {
    super.onCreate();
    mInstance = this;
  }
  public static synchronized MyApplication getInstance() {
    return mInstance;
  }

  public MyPreferenceManager getPrefManager() {
    if (preference == null) {
      preference = new MyPreferenceManager(this);
    }
    return preference;
  }
  public void logout() {
    preference.clear();
    Intent intent = new Intent(this, LoginActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
    startActivity(intent);
  }
}
