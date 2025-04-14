package com.example.teste03;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.teste03.MainActivity;
import com.example.teste03.R;

public class ConfirmacaoActivity extends AppCompatActivity {

    TextView tvMensagem;
    Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacao);

        tvMensagem = findViewById(R.id.tv_mensagem);
        btnVoltar = findViewById(R.id.btn_voltar);

        String nomeCliente = getIntent().getStringExtra("nomeCliente");
        tvMensagem.setText("Bem-vindo, " + nomeCliente + "!");

        btnVoltar.setOnClickListener(v -> {
            Intent intent = new Intent(ConfirmacaoActivity.this, MainActivity.class);
            // limpar pilha de activities
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });
    }
}
