package es.ulpgc.eite.da.basicquizlab;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CheatActivity extends AppCompatActivity {

  private TextView answerText;
  private Button yesButton, noButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_cheat);
    getSupportActionBar().setTitle(R.string.cheat_title);

    initLayoutData();
    linkLayoutComponents();
    initLayoutContent();
    enableLayoutButtons();
  }

  private void initLayoutData() {
    // TODO: falta implementacion
  }

  private void linkLayoutComponents() {
    yesButton = findViewById(R.id.yesButton);
    noButton = findViewById(R.id.noButton);

    answerText = findViewById(R.id.answerText);
  }

  private void initLayoutContent() {
    // TODO: falta implementacion
  }

  private void enableLayoutButtons() {

    yesButton.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        onYesButtonClicked(v);
      }
    });

    noButton.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        onNoButtonClicked(v);
      }
    });

  }

  private void onNoButtonClicked(View v) {

  }

  private void onYesButtonClicked(View v) {

  }

}