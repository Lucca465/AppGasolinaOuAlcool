package com.example.appgasolinaoualcool;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina = findViewById(R.id.editPrecoGasolina);
        textResultado = findViewById(R.id.textResultado);

    }

    public void calcularPreco(View view){

        // Recuperar valores digitados
        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        // Validar os campos digitados
        Boolean camposValidados = validarCampos(precoAlcool, precoGasolina);

        if (camposValidados){

            // Convertendo String para números
            Double valorAlcool = Double.parseDouble(precoAlcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);

            // Formula utilizada para saber qual vale mais a pena utilizar:
            if( (valorAlcool / valorGasolina) >= 0.7){
                textResultado.setText("É melhor utilizar gasolina");
            }else {
                textResultado.setText("É melhor utilizar Alcool");
            }

        }else {
            textResultado.setText("campo de texto faltando");
            textResultado.setTextColor(getResources().getColor(R.color.red));
        }

    }

    public boolean validarCampos(String pAlcool, String pGasolina){
        Boolean camposValidados = true;

        if ( pAlcool == null || pAlcool.equals("") ){
            camposValidados = false;
        } else if(pGasolina == null || pGasolina.equals("")) {
            camposValidados = false;
        }

        return camposValidados;
    }
}