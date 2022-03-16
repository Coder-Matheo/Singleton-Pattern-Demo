package com.example.singletonpatterndemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SingletonClass singletonClass = SingletonClass.getInstance();

        singletonClass.setLeitzins(1.4);
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);

        Log.i("TAG", "onCreate: "+ singletonClass.getLeitzins());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(editText.getText())){
                    textView.setError("Is Empty Zins "+ singletonClass.getLeitzins());
                }else {
                    singletonClass.setLeitzins(Double.parseDouble(editText.getText().toString()));
                    textView.setText("Zins ist "+singletonClass.getLeitzins() );
                }
            }
        });
    }
}