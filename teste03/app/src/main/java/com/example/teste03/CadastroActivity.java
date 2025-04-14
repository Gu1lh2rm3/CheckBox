package com.example.teste03;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.teste03.ConfirmacaoActivity;
import com.example.teste03.R;
import com.google.android.material.textfield.TextInputEditText;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class CadastroActivity extends AppCompatActivity {

    TextInputEditText editNome;
    Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        editNome = findViewById(R.id.edit_nome);
        btnEnviar = findViewById(R.id.btn_enviar);

        btnEnviar.setOnClickListener(v -> {
            String nome = Objects.requireNonNull(editNome.getText()).toString();
            Intent intent = new Intent(CadastroActivity.this, ConfirmacaoActivity.class);
            intent.putExtra("nomeCliente", nome);
            startActivity(intent);
        });
    }
}
