package Daniel.Kapash.ex1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final String TEXT_VIEW_KEY = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.textView);
        textView.setMovementMethod(new ScrollingMovementMethod());
        if (savedInstanceState != null) {
            textView.setText(savedInstanceState.getString(TEXT_VIEW_KEY));
        }
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        TextView textView = findViewById(R.id.textView);
        outState.putString(TEXT_VIEW_KEY, textView.getText().toString());
        super.onSaveInstanceState(outState);
    }


    public void sendMessage(View view) {
        EditText editText = findViewById(R.id.editText);
        String message = editText.getText().toString();
        editText.setText("");
        TextView textView = findViewById(R.id.textView);
        if (!message.equals("")) {
            String feed = textView.getText().toString();
            feed = feed + "\n" + message;
            textView.setText(feed);
        }
    }
}
