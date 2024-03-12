package com.example.meusexercicio2e3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    EditText editText1, editText2, editText3, editText4;
    Button button;
    TextView resultTextView;

    boolean isFirstClick = true; // Variável para rastrear o primeiro clique

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);
        button = findViewById(R.id.button);
        resultTextView = findViewById(R.id.resultTextView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verificar se todos os campos estão preenchidos
                if (editText1.getText().toString().isEmpty() ||
                        editText2.getText().toString().isEmpty() ||
                        editText3.getText().toString().isEmpty() ||
                        editText4.getText().toString().isEmpty()) {
                    resultTextView.setText("Por favor, preencha todos os campos.");
                    return;
                }

                // Se não for o primeiro clique, limpar a textView
                if (!isFirstClick) {
                    resultTextView.setText("");
                }

                // Capturar os valores dos campos de texto
                int num1 = Integer.parseInt(editText1.getText().toString());
                int num2 = Integer.parseInt(editText2.getText().toString());
                int num3 = Integer.parseInt(editText3.getText().toString());
                int num4 = Integer.parseInt(editText4.getText().toString());

                // Criar uma lista para armazenar os valores
                ArrayList<Integer> numeros = new ArrayList<>();
                numeros.add(num1);
                numeros.add(num2);
                numeros.add(num3);
                numeros.add(num4);

                // Exibir os valores na ordem de inserção
                resultTextView.append("Ordem de inserção: " + numeros.toString() + "\n");

                // Ordenar os valores em ordem crescente e exibir
                Collections.sort(numeros);
                resultTextView.append("Ordem crescente: " + numeros.toString() + "\n");

                // Ordenar os valores em ordem decrescente e exibir
                Collections.reverse(numeros);
                resultTextView.append("Ordem decrescente: " + numeros.toString());

                isFirstClick = false; // Marcar que não é mais o primeiro clique
            }
        });
    }
}


