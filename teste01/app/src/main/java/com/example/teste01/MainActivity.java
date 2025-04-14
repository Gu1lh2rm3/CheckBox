package com.example.teste01;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.teste01.R;

public class MainActivity extends AppCompatActivity {

    CheckBox cbArroz, cbLeite, cbCarne, cbFeijao, cbCoca;
    Button btnCalcular;
    TextView tvResultado;

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbArroz = findViewById(R.id.cb_arroz);
        cbLeite = findViewById(R.id.cb_leite);
        cbCarne = findViewById(R.id.cb_carne);
        cbFeijao = findViewById(R.id.cb_feijao);
        cbCoca = findViewById(R.id.cb_coca);
        btnCalcular = findViewById(R.id.btn_calcular);
        tvResultado = findViewById(R.id.tv_resultado);

        btnCalcular.setOnClickListener(v -> {
            double total = 0;

            if (cbArroz.isChecked()) total += 2.69;
            if (cbLeite.isChecked()) total += 2.70;
            if (cbCarne.isChecked()) total += 16.70;
            if (cbFeijao.isChecked()) total += 3.38;
            if (cbCoca.isChecked()) total += 3.00;

            tvResultado.setText(String.format("Total: R$ %.2f", total));
        });
    }
}