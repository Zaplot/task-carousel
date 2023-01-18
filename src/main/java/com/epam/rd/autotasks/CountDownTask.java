package com.epam.rd.autotasks;

public class CountDownTask implements Task{
    private static int initialValueOfTheCountdown;
    public CountDownTask(int value) {
        initialValueOfTheCountdown = Math.max(value, 0);
        if (value == 0){isFinished();}
    }

    public int getValue() {
        return initialValueOfTheCountdown;
    }


    @Override
    public void execute() {
        if (initialValueOfTheCountdown >= 0){
            initialValueOfTheCountdown--;
        } else {
            initialValueOfTheCountdown = 0;
            isFinished();
        }
    }

    @Override
    public boolean isFinished() {
        return initialValueOfTheCountdown == 0;
    }
}
