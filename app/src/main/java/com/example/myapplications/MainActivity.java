package com.example.myapplications;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);3

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.clearCheck();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                RadioButton rb = (RadioButton) group.findViewById(checkedId);
                if (rb != null && checkedId >= -1) {

                    Toast.makeText(MainActivity.this, rb.getText(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void onClear(View v) {
        radioGroup.clearCheck();
    }

    public void onSubmit(View v) {

        RadioButton rb = (RadioButton) radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
        if (rb != null) {

            Toast.makeText(MainActivity.this, rb.getText(), Toast.LENGTH_SHORT).show();
        } else {

            Toast.makeText(MainActivity.this, "Ничего не выбрано!", Toast.LENGTH_SHORT).show();
        }
    }
}