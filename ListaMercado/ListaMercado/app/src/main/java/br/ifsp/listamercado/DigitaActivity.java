package br.ifsp.listamercado;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class DigitaActivity extends AppCompatActivity {

    private EditText nomeEditText;
    private EditText marcaEditText;
    private EditText quantidadeEditText;
    private Button inserirButton;
    private Button cancelarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digita);

        nomeEditText = findViewById(R.id.nomeEditText);
        marcaEditText = findViewById(R.id.marcaEditText);
        quantidadeEditText = findViewById(R.id.quantidadeEditText);
        inserirButton = findViewById(R.id.inserirButton);
        cancelarButton = findViewById(R.id.cancelarButton);

        inserirButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obter os dados inseridos pelo usuário
                String nome = nomeEditText.getText().toString();
                String marca = marcaEditText.getText().toString();
                String quantidade = quantidadeEditText.getText().toString();

                // Criar um novo objeto Produto
                Produto produto = new Produto(nome, marca, quantidade);

                // Adicionar o produto à lista na MainActivity
                MainActivity.addItem(produto);

                // Fechar a DigitaActivity
                finish();
            }
        });

        cancelarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Fechar a DigitaActivity sem adicionar um produto
                finish();
            }
        });
    }
}
