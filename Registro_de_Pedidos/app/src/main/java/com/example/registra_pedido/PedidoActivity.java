package com.example.registra_pedido;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PedidoActivity extends AppCompatActivity {

    EditText inputNome;
    RadioGroup grupoLanches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);

        inputNome = findViewById(R.id.inputNome);
        grupoLanches = findViewById(R.id.grupoLanches);
        Button btnConfirmar = findViewById(R.id.btnConfirmar);

        btnConfirmar.setOnClickListener(v -> {
            String nome = inputNome.getText().toString();
            int selectedId = grupoLanches.getCheckedRadioButtonId();
            RadioButton selectedLanche = findViewById(selectedId);

            if (nome.isEmpty() || selectedId == -1) {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(this, ResumoActivity.class);
            intent.putExtra("nome", nome);
            intent.putExtra("lanche", selectedLanche.getText().toString());
            startActivity(intent);
        });
    }
}
