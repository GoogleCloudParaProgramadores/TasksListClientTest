package com.gcp.services.test;

public class TasksListWorkloadClient {
    public static void main(String[] args) {
        System.out.println("Starting Tasks List Workload Client Test.");
        int totalThread = Integer.parseInt(args[0]);
        String url = args[1];

        for(int i = 0; i < totalThread; i++) {
            Runnable userAgent = new CallerRunnable(url, i);
            (new Thread(userAgent)).start();
        }
    }
}