package com.luu.app.coderack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Vector;

public class CaesarActivity extends AppCompatActivity {

    private EditText txtInput, txtLine, txtOutput;
    private Vector<String> result;

    private void initTxt(){
        txtInput = (EditText) this.findViewById(R.id.txtCaesarInput);
        txtLine = (EditText) this.findViewById(R.id.txtCaesarLine);
        txtOutput = (EditText) this.findViewById(R.id.txtCaesarOutput);
        txtOutput.setKeyListener(null);
    }

    private void initButton(){
        initButtonSolve();
        initButtonCopy();
    }

    private void initButtonSolve(){
        Button btnSolve = (Button) this.findViewById(R.id.btnCaesarSolve);
        btnSolve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = txtInput.getText().toString().toUpperCase();
                if (str.length() != 0) {
                    txtOutput.setText("");
                    String output = "";
                    for (int i = 1; i <= 26; i++) {
                        for (int j = 0; j < str.length(); j++) {
                            char buffer = str.charAt(j);
                            if (buffer == ' ') output += buffer;
                            else {
                                char buffer1 = (char) (buffer + i);
                                if (buffer1 <= 'Z') output += buffer1;
                                else {
                                    buffer1 = (char) (buffer1 - 26);
                                    output += buffer1;
                                }
                            }
                        }
                        result.addElement(output);
                        output = "";
                    }
                    for (int i = 0; i < (result.size() - 1); i++) {
                        txtOutput.setText(txtOutput.getText().toString() + (i + 1) + ". "
                                + result.elementAt(i) + "\n");
                    }
                    txtOutput.setText(txtOutput.getText().toString() + "26" + ". "
                            + result.lastElement());
                }
                else {
                    Toast.makeText(getApplicationContext(), "Input Error !!", Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });
    }

    private void initButtonCopy(){
        Button btnCopy = (Button) this.findViewById(R.id.btnCaesarCopy);
        btnCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.text.ClipboardManager clipboard = (android.text.ClipboardManager)
                        getSystemService(CLIPBOARD_SERVICE);
                clipboard.setText("Text to Copy");
                if (txtLine.getText().toString().length() == 0)
                    Toast.makeText(getApplicationContext(), "Input Error !!", Toast.LENGTH_SHORT)
                            .show();
                else {
                    int line = Integer.parseInt(txtLine.getText().toString());
                    if (line > 26 || line < 1)
                        Toast.makeText(getApplicationContext(), "Input Error !!", Toast.LENGTH_SHORT)
                            .show();
                    else {
                        String str = result.elementAt(line - 1);
                        clipboard.setText(str);
                        Toast.makeText(getApplicationContext(), "Copied string " + str + " !", Toast.LENGTH_SHORT)
                                .show();
                    }
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caesar);
        getSupportActionBar().setTitle("Cracking Caesar Code");
        result = new Vector<>();
        initTxt();
        initButton();
    }

}
