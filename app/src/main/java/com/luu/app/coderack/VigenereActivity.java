package com.luu.app.coderack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class VigenereActivity extends AppCompatActivity {

    private EditText txtInput, txtKey, txtOutput;

    private void initTxt(){
        txtInput = (EditText) this.findViewById(R.id.txtInputVegenere);
        txtKey = (EditText) this.findViewById(R.id.txtKeyVigenere);
        txtOutput = (EditText) this.findViewById(R.id.txtResultVigenere);
        txtOutput.setKeyListener(null);
    }

    private void initButton(){
        initButtonSolve();
        initButtonCopy();
    }

    private void initButtonSolve(){
        Button btnSolve = (Button) this.findViewById(R.id.btnSolveVegenere);
        btnSolve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtOutput.setText("");
                String input = txtInput.getText().toString().toUpperCase();
                String key = txtKey.getText().toString().toUpperCase();
                if (input.length() == 0 || key.length() == 0 || input.length() != key.length()){
                    Toast.makeText(getApplicationContext(),"Input Error !", Toast.LENGTH_SHORT).show();
                }
                else {
                    String result = "";
                    char bufferInput, bufferKey, buffer;
                    for (int i = 0; i < input.length(); i++){
                        bufferInput = input.charAt(i);
                        if (bufferInput == ' ') result += bufferInput;
                        else {
                            bufferKey = key.charAt(i);
                            int delta = bufferKey - 'A';
                            buffer = (char)(bufferInput - delta);
                            if (buffer >= 'A') result += buffer;
                            else {
                                buffer += 26;
                                result += buffer;
                            }
                        }
                    }
                    txtOutput.setText(result);
                }
            }
        });
    }

    private void initButtonCopy(){
        Button btnCopy = (Button) this.findViewById(R.id.btnCopyVegenere);
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
        setContentView(R.layout.activity_vigenere);
        getSupportActionBar().setTitle("Cracking Vigerene Code");
        initTxt();
        initButton();
    }

}
