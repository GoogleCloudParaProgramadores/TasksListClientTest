package com.gcp.services.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CallerRunnable implements Runnable {
    private String host;
    private int id;

    public CallerRunnable(String host, int id){
        this.host = host;
        this.id = id;
    }

    public void run() {
        try {
            while(true) {
                String stringTime = getTime();
                System.out.println("Caller " + id + ": " + stringTime);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getTime() throws Exception{
        //URL url = new URL("http://localhost:8080/workload");
        //URL url = new URL("http://taskslistservice.karaveladev.com.br:8080/workload");
        URL url = new URL(host);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        con.disconnect();
        return content.toString();
    }
}
