package es.ulpgc.eite.da.basicquizlab;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  private Button falseButton, trueButton,cheatButton, nextButton;
  private TextView questionText, resultText;

  private String[] questionArray;
  private int quizIndex =0;
  private int[] answerArray;
  private boolean nextButtonEnabled;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    getSupportActionBar().setTitle(R.string.question_title);

    initLayoutData();
    linkLayoutComponents();
    initLayoutContent();
    enableLayoutButtons();
  }

  private void initLayoutData() {
    questionArray=getResources().getStringArray(R.array.question_array);
    answerArray =getResources().getIntArray(R.array.answer_array);
  }

  private void linkLayoutComponents() {
    falseButton = findViewById(R.id.falseButton);
    trueButton = findViewById(R.id.trueButton);
    cheatButton = findViewById(R.id.cheatButton);
    nextButton = findViewById(R.id.nextButton);

    questionText = findViewById(R.id.questionText);
    resultText = findViewById(R.id.resultText);
  }

  private void initLayoutContent() {
    questionText.setText(questionArray[quizIndex]);
    resultText.setText(R.string.empty_text);
  }

  private void enableLayoutButtons() {

    trueButton.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        onTrueButtonClicked(v);
      }
    });

    falseButton.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        onFalseButtonClicked(v);
      }
    });

    nextButton.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        onNextButtonClicked(v);
      }
    });

    cheatButton.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        onCheatButtonClicked(v);
      }
    });
  }


  public void onButtonClicked(View view) {

    switch (view.getId()) {
      case R.id.falseButton:
        onFalseButtonClicked(view);
      case R.id.trueButton:
        onTrueButtonClicked(view);
      case R.id.nextButton:
        onNextButtonClicked(view);
      case R.id.cheatButton:
        onCheatButtonClicked(view);
    }

  }

  //TODO: impedir que podamos hacer click en el boton
  // si ya hemos contestado a la pregunta
  private void onTrueButtonClicked(View v) {

    if(nextButtonEnabled) {
      return;
    }

    if(answerArray[quizIndex] == 1) {
      resultText.setText(R.string.correct_text);
    } else {
      resultText.setText(R.string.incorrect_text);
    }

    nextButtonEnabled = true;
  }

  //TODO: impedir que podamos hacer click en el boton
  // si ya hemos contestado a la pregunta
  private void onFalseButtonClicked(View v) {

    if(nextButtonEnabled) {
      return;
    }

    if(answerArray[quizIndex] == 0) {
      resultText.setText(R.string.correct_text);
    } else {
      resultText.setText(R.string.incorrect_text);
    }

    nextButtonEnabled = true;
  }

  //TODO: implementar boton para pasar a siguiente pantalla
  private void onCheatButtonClicked(View v) {
    // no implementado
  }

  //TODO: impedir que podamos hacer click en el boton
  // si aun no hemos contestado a la pregunta
  private void onNextButtonClicked(View v) {

    if(!nextButtonEnabled) {
      return;
    }

    nextButtonEnabled = false;
    quizIndex++;

    // si queremos que el quiz acabe al llegar
    // a la ultima pregunta debemos comentar esta linea
    checkIndexData();

    if(quizIndex < questionArray.length) {
      initLayoutContent();
    }
  }

  //TODO: refactorizar en un método este codigo
  // por si queremos implementar otras opciones posibles
  private void checkIndexData() {

    // hacemos que si llegamos al final del quiz
    // volvamos a empezarlo nuevamente
    if(quizIndex == questionArray.length) {
      quizIndex =0;
    }
  }
}
