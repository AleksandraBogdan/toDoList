package com.company;

import java.util.ArrayList;
import java.util.Scanner;


class toDoList {
    private static toDoList instance;
    private static ArrayList<Task> list = new ArrayList<>();

    private toDoList() {
    }

    static toDoList getInstance() {
        if (instance == null) {
            instance = new toDoList();
        }
        return instance;
    }

    void run() {
        Scanner in = new Scanner(System.in);

        while (true) {
            printInstruction();
            switch (in.nextInt()) {
                case Config.addNew:
                    addNew(in);
                    break;
                case Config.printAll:
                    printAll();
                    break;
                case Config.printDone: {
                    boolean flag = false;
                    for (Task aList : list) {
                        if (aList.isDone()) {
                            flag = true;
                            System.out.println(aList.getTaskName());
                        }
                    }
                    if (!flag)
                        System.out.println("There are no tasks");
                    System.out.println("\n\n");
                    break;
                }
                case Config.printUndone: {
                    boolean flag = false;
                    for (Task aList : list) {
                        if (!(aList.isDone())) {
                            flag = true;
                            System.out.println(aList.getTaskName());
                        }
                    }
                    if (!flag)
                        System.out.println("There are no tasks");
                    System.out.println("\n\n");
                    break;
                }
                case Config.markDone:
                    printAll();
                    setMarkDone(in);
                    break;
                case Config.deleteTask:
                    printAll();
                    delete(in);
                    break;
                case Config.editTask:
                    printAll();
                    edit(in);
                    break;
                case Config.editDescription:
                    editDescription(in);
                    break;
                case Config.showDescription:
                    showDescription(in);
                    break;
                case Config.end:
                    return;
                default:
                    System.out.println("Input correct number");
            }

        }
    }

    private static boolean check(int number) {
        if (list.size() <= number) {
            System.out.println("Input correct number");
            return false;
        }
        return true;

    }

    private static void addNew(Scanner in) {
        System.out.print("Enter task: ");
        in.nextLine(); // пропускаем enter после ввода числа
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
                "8 - Edit description\n" +
                "9 - Show description\n" +
                "10 - End\n" +
                "Press number of command and Enter: ");
    }

    private static void setMarkDone(Scanner in) {
        System.out.print("Enter number of the task which you want to mark as done: ");
        int number = in.nextInt();
        if (check(number))
            list.get(number).setDone(true);
    }

    private static void edit(Scanner in) {
        System.out.print("Enter number of the task which you want to edit: ");
        int number = in.nextInt();
        if (check(number)) {
            System.out.print("Enter task: ");
            in.nextLine(); // пропускаем enter после ввода числа
            String str = in.nextLine();
            list.get(number).setTaskName(str);
        }
    }

    private static void delete(Scanner in) {
        System.out.print("Enter number of the task which you want to delete: ");
        int number = in.nextInt();
        if (check(number))
            list.remove(number);
    }


    private static void printAll() {
        boolean flag = false;
        for (int i = 0; i < list.size(); i++) {
            flag = true;
            System.out.print(i + " - " + list.get(i).getTaskName());
            if (list.get(i).isDone())
                System.out.println("  done");
            else
                System.out.println("  undone");
        }
        if (!flag)
            System.out.println("There are no tasks");
        System.out.println("\n\n");
    }


    private static void editDescription(Scanner in) {
        printAll();
        System.out.print("Enter number of the task which you want to change: ");
        int number = in.nextInt();
        if (check(number)) {
            System.out.print("Enter new description: ");
            in.nextLine(); // пропускаем enter после ввода числа
            String str = in.nextLine();
            list.get(number).setDescription(str);
        }
    }

    private static void showDescription(Scanner in) {
        printAll();
        System.out.print("Enter number of the task which you want to see: ");
        int number = in.nextInt();
        if (check(number))
            System.out.println(list.get(number).getDescription());
    }
}