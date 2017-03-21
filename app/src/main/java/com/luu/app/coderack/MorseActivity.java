package com.luu.app.coderack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Vector;

public class MorseActivity extends AppCompatActivity {

    private EditText txtInput, txtOutput;
    private Vector<String> stack;
    private String[] alphabet = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
            "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8",
            "9", "0", " " };
    private String[] morse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
            "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
            "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
            "-.--", "--..", ".----", "..---", "...--", "....-", ".....",
            "-....", "--...", "---..", "----.", "-----", "|" };

    private void initTxt(){
        txtInput = (EditText) this.findViewById(R.id.txtInputMorse);
        txtOutput = (EditText) this.findViewById(R.id.txtOutputMorse);
        txtOutput.setKeyListener(null);
    }

    private void initButton(){
        initButtonSolve();
        initButtonCopy();
    }

    private void initButtonSolve(){
        Button btnSolve = (Button) this.findViewById(R.id.btnSolveMorse);
        btnSolve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtOutput.setText("");
                String str = txtInput.getText().toString().trim();
                if (str.length() > 0) {
                    String output = "";
                    String buffer = "";
                    for (int i = 0; i < str.length(); i++) {
                        if (str.charAt(i) == ' ') {
                            for (int j = 0; j < 37; j++) {
                                if (buffer.equals(morse[j])) {
                                    output += alphabet[j];
                                    buffer = "";
                                    break;
                                }
                            }
                        } else {
                            buffer += str.charAt(i);
                        }
                    }
                    for (int j = 0; j < 37; j++) {
                        if (buffer.equals(morse[j])) {
                            output += alphabet[j];
                            break;
                        }
                    }
                    txtOutput.setText(output);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Input Error !", Toast.LENGTH_SHORT);
                }
            }
        });
    }

    private void initButtonCopy(){
        Button btnCopy = (Button) this.findViewById(R.id.btnCopyMorse);
        btnCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.text.ClipboardManager clipboard = (android.text.ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                clipboard.setText(txtOutput.getText().toString());
                Toast.makeText(getApplicationContext(), "Copied string " + txtOutput.getText().toString()
                        + " !", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_morse);

        getSupportActionBar().setTitle("Cracking Morse Code");
        stack = new Vector<>();
        initTxt();
        initButton();
    }
}
