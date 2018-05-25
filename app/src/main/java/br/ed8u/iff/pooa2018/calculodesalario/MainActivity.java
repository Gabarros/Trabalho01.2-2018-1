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
        etFilhos.setText("");
        etFaltas.setText("");
        etHoras.setText("");

        tvProventos.setText("R$ 0,00");
        tvSalario.setText("R$ 0,00");
        tvDescontos.setText("R$ 0,00");

    }

    public void calcula_salario(float salario_base){
        float horas, faltas, filhos;

        horas = Float.parseFloat(etHoras.getText().toString());
        faltas = Float.parseFloat(etFaltas.getText().toString());
        filhos = Float.parseFloat(etFilhos.getText().toString());

        float total_horas;
        float total_filhos;
        float total_faltas;

        float salario_liquido;

        float proventos;
        float descontos;
        float inss;

        total_horas = horas * ((salario_base/240)*2);
        total_faltas = (float) (faltas * (salario_base/30));
        total_filhos = (float) (filhos * (salario_base * 0.03));

        proventos = salario_base + total_horas + total_filhos;
        inss = (float) (proventos * 0.10);
        descontos = total_faltas + inss;

        salario_liquido = proventos - descontos;

        tvProventos.setText("R$ "+String.valueOf(proventos));
        tvSalario.setText("R$ "+String.valueOf(salario_liquido));
        tvDescontos.setText("R$ "+String.valueOf(descontos));
    }

    public void calcula(){

        float salario_base;


        switch (rg.getCheckedRadioButtonId()){
            case R.id.rbGerente:

                salario_base = 2000;
                calcula_salario(salario_base);

                break;

            case R.id.rbServente:
                salario_base = 300;
                calcula_salario(salario_base);


                break;

            case R.id.rbSupervisor:
                salario_base = 900;
                calcula_salario(salario_base);

                break;
        }


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

            calcula();
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
