package com.example.teste03;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.teste03.R;

public class MainActivity extends AppCompatActivity {

    Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCadastrar = findViewById(R.id.btn_cadastrar);

        btnCadastrar.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, com.example.temdetudo.CadastroActivity.class);
            startActivity(intent);
        });
    }
}
