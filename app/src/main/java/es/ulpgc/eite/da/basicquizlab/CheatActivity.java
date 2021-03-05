package es.ulpgc.eite.da.basicquizlab;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CheatActivity extends AppCompatActivity {

  public final static String EXTRA_ANSWER = "ANSWER";
  //public final static String EXTRA_CHEATED = "EXTRA_CHEATED";

  private TextView answerText;
  private Button yesButton, noButton;
  private int currentAnswer;

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
    // 0 = false, 1 = true
    currentAnswer= getIntent().getIntExtra(EXTRA_ANSWER, -1);
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
    finish();
  }

  private void onYesButtonClicked(View v) {
    if(currentAnswer == 1) {
      answerText.setText(R.string.true_text);
    } else {
      answerText.setText(R.string.false_text);
    }

  }

}