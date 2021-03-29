package pollub.ism.lab04;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    int gracz =0;
    char[][] pola_gry = new char[3][3];
    List<Button> buttony = new ArrayList<>();

    void nowaGra()
    {
        for(int i =0; i<=2; i++)
        for(int j=0; j<=2; j++)
            pola_gry [i][j] = ' ';
        buttony.get(0).setText(" ");
        buttony.get(1).setText(" ");
        buttony.get(2).setText(" ");
        buttony.get(3).setText(" ");
        buttony.get(4).setText(" ");
        buttony.get(5).setText(" ");
        buttony.get(6).setText(" ");
        buttony.get(7).setText(" ");
        buttony.get(8).setText(" ");
    }
    int czyWygrana()
    {
        for(int i = 0; i < 3; i++){//sprawdzenie pol
            if(pola_gry[i][0] != ' ' && pola_gry[i][0] == pola_gry[i][1] && pola_gry[i][0] == pola_gry[i][2])
                return 1;//wygrana
            else if(pola_gry[0][i] != ' ' && pola_gry[0][i] == pola_gry[1][i] && pola_gry[0][i] == pola_gry[2][i])
                return 1;//wygrana
        }
        if(pola_gry[0][0] != ' ' && pola_gry[0][0] == pola_gry[1][1] && pola_gry[0][0] == pola_gry[2][2])
            return 1;
        else if(pola_gry[0][2] != ' ' && pola_gry[0][2] == pola_gry[1][1] && pola_gry[0][2] == pola_gry[2][0])
            return 1;

        for (int rzad = 0; rzad < 3; rzad++){
            for (int kolumna = 0; kolumna < 3; kolumna++)
                if(pola_gry[rzad][kolumna] ==' ')
                    return 0;
        }
        return 2; // remis
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttony.add((Button) findViewById(R.id.button11));
        buttony.add((Button) findViewById(R.id.button12));
        buttony.add((Button) findViewById(R.id.button13));
        buttony.add((Button) findViewById(R.id.button21));
        buttony.add((Button) findViewById(R.id.button22));
        buttony.add((Button) findViewById(R.id.button23));
        buttony.add((Button) findViewById(R.id.button31));
        buttony.add((Button) findViewById(R.id.button32));
        buttony.add((Button) findViewById(R.id.button33));

        nowaGra();
    }

    public void przycisk(View view) {
        char a;
        Button button =((Button) view);
        if(gracz==1)
            a = 'X';
        else
            a = 'O';

        if(button.equals(buttony.get(0))&&pola_gry[0][0]==' ') {
            pola_gry[0][0] = a;
            buttony.get(0).setText(String.valueOf(a));
        }
        else if(button.equals(buttony.get(1))&&pola_gry[0][1]==' ') {
            pola_gry[0][1] = a;
            buttony.get(1).setText(String.valueOf(a));
        }else if(button.equals(buttony.get(2))&&pola_gry[0][2]==' ') {
            pola_gry[0][2] = a;
            buttony.get(2).setText(String.valueOf(a));
        }else if(button.equals(buttony.get(3))&&pola_gry[1][0]==' ') {
            pola_gry[1][0] = a;
            buttony.get(3).setText(String.valueOf(a));
        }else if(button.equals(buttony.get(4))&&pola_gry[1][1]==' ') {
            pola_gry[1][1] = a;
            buttony.get(4).setText(String.valueOf(a));
        }else if(button.equals(buttony.get(5))&&pola_gry[1][2]==' ') {
            pola_gry[1][2] = a;
            buttony.get(5).setText(String.valueOf(a));
        }else if(button.equals(buttony.get(6))&&pola_gry[2][0]==' ') {
            pola_gry[2][0] = a;
            buttony.get(6).setText(String.valueOf(a));
        }else if(button.equals(buttony.get(7))&&pola_gry[2][1]==' ') {
            pola_gry[2][1] = a;
            buttony.get(7).setText(String.valueOf(a));
        }else if(button.equals(buttony.get(8))&&pola_gry[2][2]==' ') {
            pola_gry[2][2] = a;
            buttony.get(8).setText(String.valueOf(a));
        }


        if(czyWygrana()==1&&gracz==1)
            Toast.makeText(this,"Wygrały X", Toast.LENGTH_LONG).show();
        else if(czyWygrana()==1&&gracz==0)
            Toast.makeText(this,"Wygrały O", Toast.LENGTH_LONG).show();
        else if(czyWygrana()==2)
            Toast.makeText(this,"REMIS", Toast.LENGTH_LONG).show();
        if(czyWygrana()==1||czyWygrana()==2)
        {
            nowaGra();
        }
        if(gracz==1)
            gracz=0;
        else
            gracz=1;




    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putChar("przycisk1", pola_gry[0][0]);
        outState.putChar("przycisk2", pola_gry[0][1]);
        outState.putChar("przycisk3", pola_gry[0][2]);
        outState.putChar("przycisk4", pola_gry[1][0]);
        outState.putChar("przycisk5", pola_gry[1][1]);
        outState.putChar("przycisk6", pola_gry[1][2]);
        outState.putChar("przycisk7", pola_gry[2][0]);
        outState.putChar("przycisk8", pola_gry[2][1]);
        outState.putChar("przycisk9", pola_gry[2][2]);
    }
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        pola_gry[0][0] = savedInstanceState.getChar("przycisk1");
        pola_gry[0][1] = savedInstanceState.getChar("przycisk2");
        pola_gry[0][2] = savedInstanceState.getChar("przycisk3");
        pola_gry[1][0] = savedInstanceState.getChar("przycisk4");
        pola_gry[1][1] = savedInstanceState.getChar("przycisk5");
        pola_gry[1][2] = savedInstanceState.getChar("przycisk6");
        pola_gry[2][0] = savedInstanceState.getChar("przycisk7");
        pola_gry[2][1] = savedInstanceState.getChar("przycisk8");
        pola_gry[2][2] = savedInstanceState.getChar("przycisk9");
        buttony.get(0).setText(String.valueOf(savedInstanceState.getChar("przycisk1")));
        buttony.get(1).setText(String.valueOf(savedInstanceState.getChar("przycisk2")));
        buttony.get(2).setText(String.valueOf(savedInstanceState.getChar("przycisk3")));
        buttony.get(3).setText(String.valueOf(savedInstanceState.getChar("przycisk4")));
        buttony.get(4).setText(String.valueOf(savedInstanceState.getChar("przycisk5")));
        buttony.get(5).setText(String.valueOf(savedInstanceState.getChar("przycisk6")));
        buttony.get(6).setText(String.valueOf(savedInstanceState.getChar("przycisk7")));
        buttony.get(7).setText(String.valueOf(savedInstanceState.getChar("przycisk8")));
        buttony.get(8).setText(String.valueOf(savedInstanceState.getChar("przycisk9")));

    }

}