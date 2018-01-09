package com.example.codeclan.fruitmachine;

/**
 * Created by fraserblack on 09/01/2018.
 */

public class Counter {

    public int winnings;

    public Counter() {
        this.winnings = 0;
    }

    public int getWinnings() {
        return this.winnings;
    }

    public int increaseByOne(){
        winnings++;
        return this.getWinnings();
    }

    public int increaseByThree() {
        winnings += 3;
        return this.getWinnings();

    }

    public int increaseByFive() {
        winnings += 5;
        return this.getWinnings();
    }


}
