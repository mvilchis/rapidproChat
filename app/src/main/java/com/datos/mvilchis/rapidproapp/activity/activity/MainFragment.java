package com.datos.mvilchis.rapidproapp.activity.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.datos.mvilchis.rapidproapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 07/08/2016.
 */
public class MainFragment extends Fragment {
  private RecyclerView mMessagesView;
  private EditText mInputMessageView;
  private List<String> mMessages = new ArrayList<String>();
  private String mUsername;
  public MainFragment() {
    super();
  }
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_main, container, false);
  }
  @Override
  public void onDestroy() {
    super.onDestroy();
  }
  @Override
  public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    mInputMessageView = (EditText) view.findViewById(R.id.message_input);
    mInputMessageView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
      @Override
      public boolean onEditorAction(TextView v, int id, KeyEvent event) {
        if (id == R.id.send || id == EditorInfo.IME_NULL) {
          //attemptSend();
          return true;
        }
        return false;
      }
    });

  }
  @Override
  public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (Activity.RESULT_OK != resultCode) {
      getActivity().finish();
      return;
    }

    mUsername = data.getStringExtra("username");
  }
}
