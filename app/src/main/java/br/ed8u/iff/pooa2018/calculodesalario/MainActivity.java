package br.ed8u.iff.pooa2018.calculodesalario;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    public void limpar(){

    }

    public void calcula_salario(){
        
    }

    private Button btOk;
    private Button btLimpar;

    private RadioGroup rg;

    private RadioButton rbGerente;
    private RadioButton rbSupervisor;
    private RadioButton rbServente;

    private EditText etHoras;
    private EditText etFaltas;
    private EditText etFilhos;

    private TextView tvProventos;
    private TextView tvDescontos;
    private TextView tvSalario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btOk = (Button) findViewById(R.id.btOk);
        btLimpar = (Button) findViewById(R.id.btLimpar);

        rg = (RadioGroup) findViewById(R.id.rgCargo);

        rbGerente = (RadioButton) findViewById(R.id.rbGerente);
        rbServente = (RadioButton) findViewById(R.id.rbServente);
        rbSupervisor = (RadioButton) findViewById(R.id.rbSupervisor);

        etHoras = (EditText) findViewById(R.id.etHoras);
        etFaltas = (EditText) findViewById(R.id.etFaltas);
        etFilhos = (EditText) findViewById(R.id.etFilhos);

        tvProventos = (TextView) findViewById(R.id.tvProvento);
        tvDescontos = (TextView) findViewById(R.id.tvDesconto);
        tvSalario = (TextView) findViewById(R.id.tvSalario);



        btOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            calcula_salario();
            }
        });

        btLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpar();
            }
        });
    }
}
