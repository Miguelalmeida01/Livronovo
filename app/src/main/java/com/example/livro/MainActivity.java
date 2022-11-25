package com.example.livro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etLivro;
    private EditText etAutor;
    private EditText etAno;
    private RadioButton rb1;
    private RadioButton rb2;
    private CheckBox cbCapa;
    private ListView lvNacionalidade;
    private String tipo;
    private String capa;
    private String mensagem;
    private String Nacionalidade;
    private String[] listaNacionalidade = {"Brasileiro", "Americado", "Argentino"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etLivro =findViewById(R.id.editTextAluno);
        etAutor = findViewById(R.id.editTextCPF);
        etAno = findViewById(R.id.editTextAno);
        rb1 = findViewById(R.id.radioButtonMasc);
        rb2 = findViewById(R.id.radioButtonFem);
        lvNacionalidade = findViewById(R.id.listViewGenero);
        cbCapa = findViewById(R.id.checkBoxDiplomado);
        //Criar Adaptador
        ArrayAdapter<String>  adaptador  = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                listaNacionalidade
        );

        //Adicionar Adaptador a ListView
        lvNacionalidade.setAdapter(adaptador);
        //Adiciona Clique na Lista
        lvNacionalidade.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Nacionalidade = lvNacionalidade.getItemAtPosition(i).toString();
            }
        });
    }

    public void mostraMensagem(View view)
    {
        mensagem = etLivro.getText().toString()+" "+etAutor.getText().toString()+" "+etAno.getText().toString();
        if(rb1.isChecked())
        {
            tipo = "Nacional";
        }
        else
        {
            tipo = "Estrangeiro";
        }
        if(cbCapa.isChecked())
        {
            capa = "sim";
        }
        else
            capa = "não";

        mensagem = mensagem +" tipo:"+tipo+" capa dura:"+capa+" "+ Nacionalidade;
        Toast.makeText(getApplicationContext(), mensagem, Toast.LENGTH_LONG).show();
    }
}