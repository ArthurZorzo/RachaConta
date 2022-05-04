package com.example.rachaconta;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText consumoTotal;
    EditText couvertPessoa;
    RadioGroup sEN;
    RadioGroup numPessoas;
    Button dividir;
    EditText custoTotal;
    EditText valorPorPessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        consumoTotal = (EditText) findViewById(R.id.edtConsumoTotal);
        couvertPessoa = (EditText) findViewById(R.id.edtCouvetPessoa);
        sEN = (RadioGroup) findViewById(R.id.rgTaxa);
        numPessoas = (RadioGroup) findViewById(R.id.rgNumPessoas);
        dividir = (Button) findViewById(R.id.btnDividir);
        custoTotal = (EditText) findViewById(R.id.edtTotal);
        valorPorPessoa = (EditText) findViewById(R.id.edtPorPessoa);
    }

    public void onDividirClick(View V) {
        AlertDialog.Builder msg = new AlertDialog.Builder(MainActivity.this);

        double totalConsumo = Double.parseDouble(consumoTotal.getText().toString());
        double couventPessoa = Double.parseDouble(couvertPessoa.getText().toString());
        double couvent = 0;
        double totalPessoa = 0;


        switch (sEN.getCheckedRadioButtonId()) {
            case R.id.rbSim:
                switch (numPessoas.getCheckedRadioButtonId()) {
                    case R.id.rb2:
                        couvent = (totalConsumo * ((couventPessoa*2) / 100)) + totalConsumo;
                        totalPessoa = couvent / 2;
                        break;
                    case R.id.rb3:
                        couvent = (totalConsumo * ((couventPessoa*3) / 100)) + totalConsumo;
                        totalPessoa = couvent / 3;
                        break;
                    case R.id.rb4:
                        couvent = (totalConsumo * ((couventPessoa*4) / 100)) + totalConsumo;
                        totalPessoa = couvent / 4;
                        break;
                    case R.id.rb5:
                        couvent = (totalConsumo * ((couventPessoa*5) / 100)) + totalConsumo;
                        totalPessoa = couvent / 5;
                        break;
                }
                break;
            case R.id.rbNao:
                couvent = 1;
                msg.setMessage("Não tem taxa");
                msg.setNeutralButton("Ok", null);
                msg.show();
        }

        custoTotal.setText(String.valueOf(couvent));
        valorPorPessoa.setText(String.valueOf(totalPessoa));
    }
}