package com.company;

import java.util.ArrayList;
import java.util.Scanner;

class toDoList {

    private static final int addNew = 1;
    private static final int printAll = 2;
    private static final int printDone = 3;
    private static final int printUndone = 4;
    private static final int markDone = 5;
    private static final int delete = 6;
    private static final int edit = 7;
    private static final int end = 8;

    private static ArrayList<Task> list = new ArrayList<>();

    static void run() {
        Scanner in = new Scanner(System.in);

        while (true) {
            printInstruction();
            switch (in.nextInt()) {
                case addNew:
                    addNew(in);
                    break;
                case printAll:
                    printAll();
                    break;
                case printDone: {
                    for (Task aList : list) {
                        if (aList.isDone())
                            System.out.println(aList.getTaskName());
                    }
                    System.out.println("\n\n");
                    break;
                }
                case printUndone: {
                    for (Task aList : list) {
                        if (!(aList.isDone()))
                            System.out.println(aList.getTaskName());
                    }
                    System.out.println("\n\n");
                    break;
                }
                case markDone:
                    printAll();
                    setMarkDone(in);
                    break;
                case delete:
                    printAll();
                    delete(in);
                    break;
                case edit:
                    printAll();
                    edit(in);
                    break;
                case end:
                    return;
            }

        }
    }

    private static void addNew(Scanner in) {
        System.out.print("Enter task: ");
        String str = in.nextLine(); // пропускаем enter после ввода числа
        Task newTask = new Task(in.nextLine());
        list.add(newTask);
    }

    private static void printInstruction() {
        System.out.println("1 - Add new task\n" +
                "2 - Print all list of tasks\n" +
                "3 - Print list of completed tasks\n" +
                "4 - Print list of uncompleted tasks\n" +
                "5 - Mark task as done\n" +
                "6 - Delete task\n" +
                "7 - Edit task\n" +
                "8 - End\n" +
                "Press number of command and Enter: ");
    }

    private static void setMarkDone(Scanner in) {
        System.out.print("Enter number of the task which you want to mark as done: ");
        int number = in.nextInt();
        list.get(number).setDone(true);
    }

    private static void edit(Scanner in) {
        System.out.print("Enter number of the task which you want to edit: ");
        int number = in.nextInt();
        System.out.print("Enter task: ");
        String str = in.nextLine(); // пропускаем enter после ввода числа
        str = in.nextLine();
        list.get(number).setTaskName(str);
    }

    private static void delete(Scanner in) {
        System.out.print("Enter number of the task which you want to delete: ");
        int number = in.nextInt();
        list.remove(number);
    }


    private static void printAll() {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(i + " - " + list.get(i).getTaskName());
            if (list.get(i).isDone())
                System.out.println("  done");
            else
                System.out.println("  undone");
        }
        System.out.println("\n\n");
    }
}


