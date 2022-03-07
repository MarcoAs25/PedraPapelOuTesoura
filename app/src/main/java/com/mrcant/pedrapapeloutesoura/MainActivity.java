package com.mrcant.pedrapapeloutesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public int playerPoints, oponentPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playerPoints = 0;
        oponentPoints = 0;
    }

    public void selecionouPedra(View view){
        Jogar(view, 0);
    }
    public void selecionouPapel(View view){
        Jogar(view, 1);
    }
    public void selecionouTesoura(View view){
        Jogar(view, 2);
    }

    public void Jogar(View view, int selecionado){
        TextView textResultado = findViewById(R.id.txtResultadoJogo);

        TextView textPlayerPoints = findViewById(R.id.txtPlayerPoints);
        TextView textOponentPoints = findViewById(R.id.txtOponentPoints);

        Random rand = new Random();
        int ValorDoOponente = rand.nextInt(3);
        changeImageOponent(view, ValorDoOponente);

        if(selecionado == ValorDoOponente){
            textResultado.setText("Empate!!");
        }else if((Math.abs((selecionado+3)-1)%3) == ValorDoOponente){
            textResultado.setText("Você venceu!!");
            playerPoints++;
            textPlayerPoints.setText(Integer.toString(playerPoints));
        }else{
            textResultado.setText("Você perdeu :(");
            oponentPoints++;
            textOponentPoints.setText(Integer.toString(oponentPoints));
        }

    }

    public  void changeImageOponent(View view, int ValorDoOponente){
        ImageView img = findViewById(R.id.imageViewBase);

        switch (ValorDoOponente){
            case 0:
                img.setImageResource(
                        R.drawable.pedra
                );
                break;
            case 1:
                img.setImageResource(
                        R.drawable.papel
                );
                break;
            case 2:
                img.setImageResource(
                        R.drawable.tesoura
                );
                break;
            default:
                img.setImageResource(
                        R.drawable.padrao
                );
        }
    }

}