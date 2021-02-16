package es.ulpgc.eite.da.basicquizlab;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  private Button falseButton, trueButton,cheatButton, nextButton;
  private TextView questionText, replyText;

  private String[] questionArray;
  private int questionIndex=0;
  private int[] replyArray;
  private boolean nextButtonEnabled;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    getSupportActionBar().setTitle(R.string.question_title);

    initLayoutData();

    linkLayoutComponents();
    initLayoutContent();

    updateLayoutContent();

  }


  private void initLayoutData() {
    questionArray=getResources().getStringArray(R.array.question_array);
    replyArray=getResources().getIntArray(R.array.reply_array);
  }


  private void linkLayoutComponents() {
    falseButton = findViewById(R.id.falseButton);
    trueButton = findViewById(R.id.trueButton);
    cheatButton = findViewById(R.id.cheatButton);
    nextButton = findViewById(R.id.nextButton);

    questionText = findViewById(R.id.questionText);
    replyText = findViewById(R.id.replyText);
  }

  private void initLayoutContent() {
    falseButton.setText(R.string.false_button_text);
    trueButton.setText(R.string.true_button_text);
    nextButton.setText(R.string.next_button_text);
    cheatButton.setText(R.string.cheat_button_text);

  }

  //TODO: refactorizar en un método este codigo repetido
  private void updateLayoutContent() {
    questionText.setText(questionArray[questionIndex]);
    replyText.setText(R.string.empty_text);
  }

  public void onButtonClick(View view) {

    switch (view.getId()) {
      case R.id.falseButton:
      case R.id.trueButton:
        buttonClicked(view.getId());
        break;
      case R.id.nextButton:
        nextButtonClicked();
        break;
      case R.id.cheatButton:
        cheatButtonClicked();
    }

  }

  //TODO: impedir que podamos hacer click en el boton
  // si ya hemos contestado a la pregunta
  private void buttonClicked(int id) {

    if(nextButtonEnabled) {
      return;
    }

    switch (id) {
      case R.id.falseButton:
        falseButtonClicked();
        break;
      case R.id.trueButton:
        trueButtonClicked();
    }

    nextButtonEnabled = true;
  }

  private void trueButtonClicked() {

    if(replyArray[questionIndex] == 1) {
      replyText.setText(R.string.correct_text);
    } else {
      replyText.setText(R.string.incorrect_text);
    }
  }

  private void falseButtonClicked() {

    if(replyArray[questionIndex] == 0) {
      replyText.setText(R.string.correct_text);
    } else {
      replyText.setText(R.string.incorrect_text);
    }

  }

  //TODO: implementar boton para pasar a siguiente pantalla
  private void cheatButtonClicked() {
    // no implementado
  }

  //TODO: impedir que podamos hacer click en el boton
  // si aun no hemos contestado a la pregunta
  private void nextButtonClicked() {

    if(!nextButtonEnabled) {
      return;
    }

    nextButtonEnabled = false;
    questionIndex++;

    // si queremos que el quiz acabe al llegar
    // a la ultima pregunta debemos comentar esta linea
    checkIndexData();

    if(questionIndex < questionArray.length) {
      updateLayoutContent();
    }

  }

  //TODO: refactorizar en un método este codigo
  // por si queremos implementar otras opciones posibles
  private void checkIndexData() {

    // hacemos que si llegamos al final del quiz
    // volvamos a empezarlo nuevamente
    if(questionIndex == questionArray.length) {
      questionIndex=0;
    }

  }

}
