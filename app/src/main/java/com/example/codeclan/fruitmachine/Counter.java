package com.example.codeclan.fruitmachine;

/**
 * Created by fraserblack on 09/01/2018.
 */

public class Counter {

    public int winnings;

    public Counter() {
        this.winnings = 0;
    }

    public Integer getWinnings() {
        return this.winnings;
    }

    public int increaseByOne(){
        winnings++;
        return this.getWinnings();
    }

    public int increaseByTwo() {
        winnings += 2;
        return this.getWinnings();
    }

    public int increaseByThree() {
        winnings += 3;
        return this.getWinnings();
    }

    public int increaseByFour(){
        winnings += 4;
        return this.getWinnings();
    }

    public int increaseByFive() {
        winnings += 5;
        return this.getWinnings();
    }


}
