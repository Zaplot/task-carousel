package com.epam.rd.autotasks;

import java.util.Arrays;

public class TaskCarousel {
    private int capacity;
    public Task[] taskCarousel;
    public int countTasks = 0;
    public int countExecutions = 0;
    public TaskCarousel(int capacity) {
        this.capacity = capacity;
        this.taskCarousel = new Task[capacity];
    }
    public boolean checkTaskAdding(Task task){
        return task != null && !isFull() && !task.isFinished();
    }
    public boolean addTask(Task task) {
        boolean successfulAdd = false;
        if (taskCarousel.length > countTasks && checkTaskAdding(task) ){
            taskCarousel[countTasks] = task;
            countTasks++;
            successfulAdd = true;
        }
        return successfulAdd;
    }

    public boolean execute() {
        if (taskCarousel.length>0 &&(CountDownTask)taskCarousel[0].getValue  > countExecutions){ /* Here is the problem*/
            taskCarousel[0].execute();
            countExecutions++;
            Task[] temp = new Task[capacity-countExecutions] ;
            System.arraycopy(taskCarousel, 1, temp, 0, taskCarousel.length-1);
            taskCarousel = temp;

            return true;
        }
        return false;
    }

    public boolean isFull() {
        return countTasks == capacity;
    }

    public boolean isEmpty() {
        return countTasks == 0;
    }

}
