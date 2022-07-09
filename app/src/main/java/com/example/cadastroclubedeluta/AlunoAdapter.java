package com.example.cadastroclubedeluta;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
//class adaptadora para mostrar mais inforemacões na tela de listagem de cadastrados
public class AlunoAdapter extends BaseAdapter {

    //variaveis

    private List<Aluno> alunos;
    private Activity activity;


    public AlunoAdapter(Activity activity,List<Aluno> alunos){
        this.activity = activity;
        this.alunos = alunos;
    }
    //Getters
    @Override
    public int getCount() {
        return alunos.size();
    }

    @Override
    public Object getItem(int i) {
        return alunos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return alunos.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        //criar visão para o item ser listado na tela

        View v = activity.getLayoutInflater().inflate(R.layout.item,viewGroup, false);
        TextView nome = v.findViewById(R.id.txt_nome);
        TextView cpf = v.findViewById(R.id.txt_cpf);
        TextView telefone = v.findViewById(R.id.txt_telefone);
        TextView email = v.findViewById(R.id.txt_email);
        TextView data = v.findViewById(R.id.txt_data);

        Aluno a = alunos.get(i);

        nome.setText(a.getNome());
        cpf.setText(a.getCpf());
        telefone.setText(a.getTelefone());
        email.setText(a.getEmail());
        data.setText(a.getData());
        return v;
    }
}
