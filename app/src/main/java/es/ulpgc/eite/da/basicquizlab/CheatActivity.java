package es.ulpgc.eite.da.basicquizlab;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CheatActivity extends AppCompatActivity {

  private Button yesButton, noButton;
  private TextView answerText;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_cheat);

    getSupportActionBar().setTitle(R.string.cheat_title);

    linkLayoutComponents();
    initLayoutContent();
    enableLayoutButtons();
  }


  private void initLayoutData() {
    // TODO: pendiente de implementar
  }

  private void linkLayoutComponents() {
    yesButton = findViewById(R.id.yesButton);
    noButton = findViewById(R.id.noButton);

    answerText = findViewById(R.id.answerText);
  }

  private void initLayoutContent() {
    answerText.setText(R.string.empty_text);

//    falseButton.setEnabled(true);
//    trueButton.setEnabled(true);

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