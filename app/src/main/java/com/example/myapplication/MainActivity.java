package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ArrayList<Integer> player1 = new ArrayList<>();
    ArrayList<Integer> player2 = new ArrayList<>();
    int activePlayer = 1;
    int player1WinsCounts = 0;
    int player2WinsCounts = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buClick( View view){
        Button buSelected = (Button) view;
        int cellId = 0;
        if (buSelected.getId() == R.id.bu1) {
            cellId = 1;
        } else if (buSelected.getId() == R.id.bu2) {
            cellId = 2;
        } else if (buSelected.getId() == R.id.bu3) {
            cellId = 3;
        } else if (buSelected.getId() == R.id.bu4) {
            cellId = 4;
        } else if (buSelected.getId() == R.id.bu5) {
            cellId = 5;
        } else if (buSelected.getId() == R.id.bu6) {
            cellId = 6;
        } else if (buSelected.getId() == R.id.bu7) {
            cellId = 7;
        } else if (buSelected.getId() == R.id.bu8) {
            cellId = 8;
        } else if (buSelected.getId() == R.id.bu9) {
            cellId = 9;
        }
        playGame(cellId,buSelected);
    }

    public void playGame(int cellId, Button buSelected){
        if( activePlayer == 1 ){
            buSelected.setText("X");
            buSelected.setBackgroundResource(R.color.blue);
            player1.add(cellId);
            activePlayer = 2;
            autoPlay();
        }else{
            buSelected.setText("O");
            buSelected.setBackgroundResource(R.color.darkGreen);
            player2.add(cellId);
            activePlayer = 1;
        }
        buSelected.setEnabled(false);
        checkWinner();
    }

    public void checkWinner() {
        int winer = -1;
        // row 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winer = 1;
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winer = 2;
        }
        // row 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winer = 1;
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winer = 2;
        }
        // row 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winer = 1;
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winer = 2;
        }
        // col 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winer = 1;
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winer = 2;
        }
        // col 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winer = 1;
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winer = 2;
        }
        // col 3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winer = 1;
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winer = 2;
        }

        if (winer == 1) {
            player1WinsCounts += 1;
            Toast.makeText(this, "Player 1 win the game", Toast.LENGTH_LONG).show();
            restartGame();
        } else if (winer == 2) {
            player2WinsCounts += 1;
            Toast.makeText(this, "Player 2 win the game", Toast.LENGTH_LONG).show();
            restartGame();
        }
    }

    public void autoPlay(){
        ArrayList<Integer> emptyCells = new ArrayList<>();
        for( int cellId=1; cellId<=9; cellId++){
            if( !(player1.contains(cellId) || player2.contains(cellId))){
                emptyCells.add(cellId);
            }
        }
        if(emptyCells.size() == 0){
            restartGame();
        }
        Random r = new Random();
        int randIndex = r.nextInt(emptyCells.size());
        int cellId = emptyCells.get(randIndex);
        Button buSelected = null;
        switch (cellId){
            case 1: buSelected = findViewById(R.id.bu1); break;
            case 2: buSelected = findViewById(R.id.bu2); break;
            case 3: buSelected = findViewById(R.id.bu3); break;
            case 4: buSelected = findViewById(R.id.bu4); break;
            case 5: buSelected = findViewById(R.id.bu5); break;
            case 6: buSelected = findViewById(R.id.bu6); break;
            case 7: buSelected = findViewById(R.id.bu7); break;
            case 8: buSelected = findViewById(R.id.bu8); break;
            case 9: buSelected = findViewById(R.id.bu9); break;
            default: buSelected = findViewById(R.id.bu1); break;
        }
        playGame(cellId, buSelected);
    }

    public void restartGame(){
        activePlayer = 1;
        player1.clear();
        player2.clear();
        for(int cellId=1; cellId<=9; cellId++){
            Button buSelected = null;
            switch (cellId){
                case 1:
                    buSelected = findViewById(R.id.bu1);
                    break;
                case 2:
                    buSelected = findViewById(R.id.bu2);
                    break;
                case 3:
                    buSelected = findViewById(R.id.bu3);
                    break;
                case 4:
                    buSelected = findViewById(R.id.bu4);
                    break;
                case 5:
                    buSelected = findViewById(R.id.bu5);
                    break;
                case 6:
                    buSelected = findViewById(R.id.bu6);
                    break;
                case 7:
                    buSelected = findViewById(R.id.bu7);
                    break;
                case 8:
                    buSelected = findViewById(R.id.bu8);
                    break;
                case 9:
                    buSelected = findViewById(R.id.bu9);
                    break;
                default:
                    buSelected = findViewById(R.id.bu1);
                    break;
            }
            buSelected.setText("");
            buSelected.setBackgroundResource(R.color.whileBu);
            buSelected.setEnabled(true);
        }
        Toast.makeText(this,"Player1: "+player1WinsCounts+", Player2: "+player2WinsCounts, Toast.LENGTH_LONG).show();
    }
}
