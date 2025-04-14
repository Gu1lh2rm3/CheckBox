package com.example.registra_pedido;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResumoActivity extends AppCompatActivity {
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo);

        TextView textResumo = findViewById(R.id.textResumo);
        Button btnVoltar = findViewById(R.id.btnVoltarInicio);

        Intent intent = getIntent();
        String nome = intent.getStringExtra("nome");
        String lanche = intent.getStringExtra("lanche");

        textResumo.setText("Pedido de " + nome + ":\n" + lanche);

        btnVoltar.setOnClickListener(v -> {
            Intent voltar = new Intent(this, MainActivity.class);
            voltar.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(voltar);
        });
    }
}
