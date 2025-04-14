package com.example.pizzaria;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TamanhoPagamentoActivity extends AppCompatActivity {

    RadioGroup grupoTamanho, grupoPagamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tamanho_pagamento);

        grupoTamanho = findViewById(R.id.grupoTamanho);
        grupoPagamento = findViewById(R.id.grupoPagamento);
        Button btnConfirmar = findViewById(R.id.btnConfirmar);

        String sabores = getIntent().getStringExtra("sabores");

        btnConfirmar.setOnClickListener(v -> {
            int idTamanho = grupoTamanho.getCheckedRadioButtonId();
            int idPagamento = grupoPagamento.getCheckedRadioButtonId();

            if (idTamanho == -1 || idPagamento == -1) {
                Toast.makeText(this, "Selecione tamanho e pagamento!", Toast.LENGTH_SHORT).show();
                return;
            }

            RadioButton tamanhoSelecionado = findViewById(idTamanho);
            RadioButton pagamentoSelecionado = findViewById(idPagamento);

            int preco = 0;
            if (idTamanho == R.id.radioPequena) preco = 25;
            else if (idTamanho == R.id.radioMedia) preco = 35;
            else if (idTamanho == R.id.radioGrande) preco = 45;

            Intent intent = new Intent(this, ResumoActivity.class);
            intent.putExtra("sabores", sabores);
            intent.putExtra("tamanho", tamanhoSelecionado.getText().toString());
            intent.putExtra("pagamento", pagamentoSelecionado.getText().toString());
            intent.putExtra("preco", preco);
            startActivity(intent);
        });
    }
}
