package com.company;

class Task {
    private  String taskName;
    private  boolean done;
    private String description;

    Task(String str){
        taskName = str;
        setDone(false);
        description = "Empty";
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

    String getDescription() {
        return description;
    }

    void setDescription(String description) {
        this.description = description;
    }
}
