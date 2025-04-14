package com.example.pizzaria;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResumoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo);

        TextView textResumo = findViewById(R.id.textResumo);
        Button btnNovoPedido = findViewById(R.id.btnNovoPedido);

        Intent intent = getIntent();
        String sabores = intent.getStringExtra("sabores");
        String tamanho = intent.getStringExtra("tamanho");
        String pagamento = intent.getStringExtra("pagamento");
        int preco = intent.getIntExtra("preco", 0);

        String resumo = "Pedido:\n" +
                "Sabores: " + sabores + "\n" +
                "Tamanho: " + tamanho + "\n" +
                "Pagamento: " + pagamento + "\n" +
                "Total: R$" + preco;

        textResumo.setText(resumo);

        btnNovoPedido.setOnClickListener(v -> {
            Intent novo = new Intent(this, PizzaActivity.class);
            novo.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(novo);
        });
    }
}
