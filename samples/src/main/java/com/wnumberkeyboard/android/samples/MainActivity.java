package com.wnumberkeyboard.android.samples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.wnumberkeyboard.android.WNumberKeyboardView;

/**
 * @author wuzhen
 * @version Version 1.0, 2016-09-13
 */
public class MainActivity extends AppCompatActivity implements WNumberKeyboardView.IOnKeyboardListener {

    EditText editText;
    WNumberKeyboardView keyboardView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.edit_text);

        keyboardView = (WNumberKeyboardView) findViewById(R.id.view_keyboard);
        keyboardView.setIOnKeyboardListener(this);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                keyboardView.shuffleKeyboard();
            }
        });
    }

    @Override
    public void onInsertKeyEvent(String text) {
        editText.append(text);
    }

    @Override
    public void onDeleteKeyEvent() {
        int start = editText.length() - 1;
        if (start >= 0) {
            editText.getText().delete(start, start + 1);
        }
    }
}
