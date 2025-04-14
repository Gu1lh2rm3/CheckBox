package com.example.teste02;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import com.example.teste02.R;

public class MainActivity extends AppCompatActivity {

    EditText etSalario;
    RadioGroup rgAumento;
    RadioButton rb40, rb45, rb50;
    Button btnCalcular;
    TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etSalario = findViewById(R.id.et_salario);
        rgAumento = findViewById(R.id.rg_aumento);
        rb40 = findViewById(R.id.rb_40);
        rb45 = findViewById(R.id.rb_45);
        rb50 = findViewById(R.id.rb_50);
        btnCalcular = findViewById(R.id.btn_calcular);
        tvResultado = findViewById(R.id.tv_resultado);

        btnCalcular.setOnClickListener(v -> {
            String salarioStr = etSalario.getText().toString();

            if (salarioStr.isEmpty()) {
                Toast.makeText(this, "Digite o salário!", Toast.LENGTH_SHORT).show();
                return;
            }

            double salario = Double.parseDouble(salarioStr);
            double percentual = 0;

            int selectedId = rgAumento.getCheckedRadioButtonId();

            if (selectedId == rb40.getId()) {
                percentual = 0.40;
            } else if (selectedId == rb45.getId()) {
                percentual = 0.45;
            } else if (selectedId == rb50.getId()) {
                percentual = 0.50;
            } else {
                Toast.makeText(this, "Selecione um percentual!", Toast.LENGTH_SHORT).show();
                return;
            }

            double novoSalario = salario + (salario * percentual);
            tvResultado.setText(String.format("Novo salário: R$ %.2f", novoSalario));
        });
    }
}
