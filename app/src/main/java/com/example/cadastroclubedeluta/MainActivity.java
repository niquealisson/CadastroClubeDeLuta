package com.example.cadastroclubedeluta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Varieveis associados aos campos de EditText
    private EditText nome;
    private EditText cpf;
    private EditText telefone;
    private EditText email;
    private EditText data;
    //
    private AlunoDAO dao;
    private Aluno aluno = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Associar o xml com as variaveis do java

        nome = findViewById(R.id.editNome);
        cpf = findViewById(R.id.editCPF);
        telefone = findViewById(R.id.editTelefone);
        email = findViewById(R.id.editEmail);
        data = findViewById(R.id.editData);
        dao = new AlunoDAO(this);

        //Vinculação
        Intent it = getIntent();
        if(it.hasExtra("aluno")){
            aluno = (Aluno) it.getSerializableExtra("aluno");
            nome.setText(aluno.getNome());
            cpf.setText(aluno.getCpf());
            telefone.setText(aluno.getTelefone());
            email.setText(aluno.getEmail());
            data.setText(aluno.getData());
        }
    }
      //metodo onclick para o botão salvar
    public void salvar (View view){

        if(aluno == null) {
            aluno  = new Aluno();
            aluno.setNome(nome.getText().toString());
            aluno.setCpf(cpf.getText().toString());
            aluno.setTelefone(telefone.getText().toString());
            aluno.setEmail(email.getText().toString());
            aluno.setData(data.getText().toString());
            long id = dao.insert(aluno);
            Toast.makeText(this, "Aluno Cadastrado com Sucesso! ", Toast.LENGTH_SHORT).show();
        }else{
            aluno.setNome(nome.getText().toString());
            aluno.setCpf(cpf.getText().toString());
            aluno.setTelefone(telefone.getText().toString());
            aluno.setEmail(email.getText().toString());
            aluno.setData(data.getText().toString());
            dao.atualizar(aluno);
            Toast.makeText(this, "Cadastro Atualizado", Toast.LENGTH_SHORT).show();
        }

        }

}