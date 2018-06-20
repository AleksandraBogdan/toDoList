package com.company;

public class Task {
    private  String taskName;
    private  boolean done;

    Task(String str){
        taskName = str;
        setDone(false);
    }
    boolean isDone() {
        return done;
    }

    void setDone(boolean done) {
        this.done = done;
    }

    String getTaskName() {
        return taskName;
    }

    void setTaskName(String newName) {
        this.taskName = newName;
    }
}
