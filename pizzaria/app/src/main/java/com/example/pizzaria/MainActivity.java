package com.example.pizzaria;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PizzaActivity extends AppCompatActivity {

    CheckBox checkCalabresa, checkMarguerita, checkPortuguesa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);

        checkCalabresa = findViewById(R.id.checkCalabresa);
        checkMarguerita = findViewById(R.id.checkMarguerita);
        checkPortuguesa = findViewById(R.id.checkPortuguesa);
        Button btnAvancar = findViewById(R.id.btnAvancar);

        btnAvancar.setOnClickListener(v -> {
            StringBuilder sabores = new StringBuilder();
            if (checkCalabresa.isChecked()) sabores.append("Calabresa, ");
            if (checkMarguerita.isChecked()) sabores.append("Marguerita, ");
            if (checkPortuguesa.isChecked()) sabores.append("Portuguesa, ");

            if (sabores.length() == 0) {
                Toast.makeText(this, "Selecione pelo menos um sabor!", Toast.LENGTH_SHORT).show();
                return;
            }

            sabores.setLength(sabores.length() - 2); // remove a última vírgula

            Intent intent = new Intent(this, TamanhoPagamentoActivity.class);
            intent.putExtra("sabores", sabores.toString());
            startActivity(intent);
        });
    }
}
