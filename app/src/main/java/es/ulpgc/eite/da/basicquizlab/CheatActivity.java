package es.ulpgc.eite.da.basicquizlab;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CheatActivity extends AppCompatActivity {

  public final static String EXTRA_ANSWER = "EXTRA_ANSWER";
  public final static String EXTRA_CHEATED = "EXTRA_CHEATED";

  private Button yesButton, noButton;
  private TextView answerText;
  private int currentAnswer;
  private boolean answerCheated;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_cheat);

    getSupportActionBar().setTitle(R.string.cheat_title);

    //currentAnswer= getIntent().getIntExtra(EXTRA_ANSWER, -1);

    initLayoutData();
    linkLayoutComponents();
    initLayoutContent();
    enableLayoutButtons();
  }


  private void initLayoutData() {
    currentAnswer= getIntent().getIntExtra(EXTRA_ANSWER, -1);
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
    answerCheated = false;

    finish();
  }

  @Override
  public void onBackPressed() {
    super.onBackPressed();

    Intent intent = new Intent();
    intent.putExtra(EXTRA_CHEATED, answerCheated);
    setResult(QuestionActivity.CHEAT_REQUEST, intent);

    //finish();
  }

  private void onYesButtonClicked(View v) {
    answerCheated = true;

    if(currentAnswer==1) {
      answerText.setText(R.string.true_text);
    } else {
      answerText.setText(R.string.false_text);
    }


  }

}