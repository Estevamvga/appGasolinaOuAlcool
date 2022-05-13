package br.edu.edu.appgasolinaoualcool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editGasolina;
    EditText editAlcool;
    Button btcalcular;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        carregarComponentes();
        configurarBotaoResultado();
        

    }

    

    protected void carregarComponentes() {
        editGasolina=findViewById(R.id.editGasolina);
        editAlcool=findViewById(R.id.editAlcool);
        btcalcular=findViewById(R.id.btCalcular);
        txtResultado=findViewById(R.id.txtResultado);


    }

    protected void configurarBotaoResultado() {
        btcalcular.setOnClickListener(view -> {
            Toast.makeText(this, "Seu melhor combustível é: ", Toast.LENGTH_SHORT).show();
            realizaCalculo();
            limpaCampos();
            esconderteclado();
        });
    }


    protected void realizaCalculo() {
        double gasolina=editGasolina.getText().length() > 0 ? Double.parseDouble(editGasolina.getText().toString()) : 0;
        double alcool=editAlcool.getText().length() > 0 ? Double.parseDouble(editAlcool.getText().toString()) : 0;
        double calculo=(alcool / gasolina);


        if (gasolina == 0 || alcool == 0) {
            txtResultado.setText("Preencha os valores acima!");

        } else {
            if (calculo >= 0.7) {
                txtResultado.setText("Abasteça com Gasolina");
            } else {
                txtResultado.setText("Abasteça com Etanol");
            }
        }
    }

     protected void limpaCampos() {
        editGasolina.setText("");
        editAlcool.setText("");
        editGasolina.requestFocus();
    }

    private void esconderteclado() {

        View view = this.getCurrentFocus();
        if(view !=null){
            InputMethodManager imm = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

    }
}
