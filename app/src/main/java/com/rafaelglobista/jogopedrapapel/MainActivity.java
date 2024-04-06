package com.rafaelglobista.jogopedrapapel;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void selecionarPedra( View view ){
        verificarGanhador("pedra");
    }
    public void selecionarPapel( View view ){
        verificarGanhador("papel");
    }
    public void selecionarTesoura( View view ){
        verificarGanhador("tesoura");
    }

    private void verificarGanhador(String escolhaUsuario){
        String escolhaPC = gerarEscolha();

        ImageView imageApp = findViewById(R.id.imageView);
        ImageView imageMinhaEscolha = findViewById(R.id.imageMinhaEscolha);
        TextView txtresultado = findViewById(R.id.txtResultado);

        //exibe a escolha do PC
        switch (escolhaPC){
            case "pedra" :
                imageApp.setImageResource(R.drawable.pedra);
                break;

            case "papel" :
                imageApp.setImageResource(R.drawable.papel);
                break;

            case "tesoura" :
                imageApp.setImageResource(R.drawable.tesoura);
                break;
        }

        //exibe a escolha do usuario
        switch (escolhaUsuario){
            case "pedra" :
                imageMinhaEscolha.setImageResource(R.drawable.pedra);
                break;

            case "papel" :
                imageMinhaEscolha.setImageResource(R.drawable.papel);
                break;

            case "tesoura" :
                imageMinhaEscolha.setImageResource(R.drawable.tesoura);
                break;
        }

        if (
                escolhaPC=="pedra" && escolhaUsuario=="tesoura" ||
                escolhaPC=="papel" && escolhaUsuario=="pedra" ||
                escolhaPC=="tesoura" && escolhaUsuario=="papel"){

            txtresultado.setText("Você Perdeu!");
        } else if (
                escolhaUsuario=="pedra" && escolhaPC=="tesoura" ||
                escolhaUsuario=="papel" && escolhaPC=="pedra" ||
                escolhaUsuario=="tesoura" && escolhaPC=="papel"){
            txtresultado.setText("Você ganhou!");
        }else {
            txtresultado.setText("Empate!");
        }
    }

    private String gerarEscolha(){
        String[] escolhaPC = {"pedra", "papel", "tesoura"};

        //Chamar o Random
        int aleatorio = new Random().nextInt(3);
        return escolhaPC[aleatorio];
    }

}