package com.luu.app.coderack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Vector;

public class numtocharActivity extends AppCompatActivity {

    private EditText txtInput, txtOutput;
    private Vector<Integer> stack;

    private void initTxt(){
        txtInput = (EditText) this.findViewById(R.id.txtInputNumToChar);
        txtOutput = (EditText) this.findViewById(R.id.txtOutputNumToChar);
        txtOutput.setKeyListener(null);
    }

    private void initButton(){
        initButtonSolve();
        initButtonCopy();
    }

    private void initButtonSolve(){
        Button btnSolve = (Button) this.findViewById(R.id.btnSolveNumToChar);
        btnSolve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtOutput.setText("");
                String str = txtInput.getText().toString();
                if (str.length() != 0 && (str.length() % 2 == 0)) {
                    String buffer;
                    while (str.length() > 0) {
                        buffer = str.substring(0, 2);
                        stack.addElement(Integer.parseInt(buffer));
                        str = str.substring(2);
                    }
                    String output = "";
                    char bufferChar;
                    for (int i = 0; i < stack.size(); i++) {
                        bufferChar = (char) (stack.elementAt(i) + 64);
                        output += bufferChar;
                    }
                    txtOutput.setText(output);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Input Error !", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initButtonCopy(){
        Button btnCopy = (Button) this.findViewById(R.id.btnCopyNumToChar);
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
        setContentView(R.layout.activity_numtochar);

        getSupportActionBar().setTitle("Number To Character");
        stack = new Vector<>();
        initTxt();
        initButton();
    }
}
