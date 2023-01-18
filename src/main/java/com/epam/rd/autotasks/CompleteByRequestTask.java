package com.epam.rd.autotasks;

public class CompleteByRequestTask implements Task {
    boolean isCompleted;
    @Override
    public void execute() {
        if (isCompleted){
            isFinished();
        }
    }

    @Override
    public boolean isFinished() {
        throw new UnsupportedOperationException();
    }

    public void complete() {
        isCompleted = true;
    }
}
