package com.hackerrank.hacker_rank;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    // First exercise
    public static void plusMinus(List<Integer> arr) {
        DecimalFormat formatter = new DecimalFormat("0.000000");
        double arrSize = arr.size();
        // Print positive results
        double positive = (double) arr.stream().filter((it) -> it > 0).count();
        System.out.println(formatter.format(positive / arrSize));
        // Print negative results
        double negative = (double) arr.stream().filter((it) -> it < 0).count();
        System.out.println(formatter.format(negative / arrSize));
        // Print zeros results
        double zeros = (double) arr.stream().filter((it) -> it == 0).count();
        System.out.println(formatter.format(zeros / arrSize));
    }

    // Second exercise
    public static void miniMaxSum(List<Integer> arr) {
        // Minimal sum
        List<Integer> minorToMayor = new ArrayList<Integer>(arr);
        minorToMayor.sort(Comparator.naturalOrder());
        long minimalSum = 0;
        for (int i = 0; i < minorToMayor.size() - 1; i++) {
            minimalSum += minorToMayor.get(i);
        }
        // Max sum
        List<Integer> maxToMinor = new ArrayList<Integer>(arr);
        maxToMinor.sort(Comparator.reverseOrder());
        long maxSum = 0;
        for (int i = 0; i < maxToMinor.size() - 1; i++) {
            maxSum += maxToMinor.get(i);
        }
        System.out.println(minimalSum + " " + maxSum);
    }

    // Third exercise
    public static String timeConversion(String s) {
        DecimalFormat formatter = new DecimalFormat("00");
        int hour = Integer.parseInt(s.split(":")[0]);
        if (s.contains("PM") && hour < 12) {
            int newHour = hour + 12;
            return formatter.format(newHour) + s.substring(2, s.length() - 2);
        } else if (hour == 12 && s.contains("AM")) {
            return "00" + s.substring(2, s.length() - 2);
        } else {
            return s.substring(0, s.length() - 2);
        }
    }

    public static int findMedian(List<Integer> arr) {
        //arr.sort(Comparator::comparingInt);
        int medianValue = arr.size() / 2;
        return arr.get(medianValue);
    }

    public static int lonelyinteger(List<Integer> a) {
        for (Integer value : a) {
            long counter = a.stream().filter(it -> it.equals(value)).count();
            if (counter == 1) {
                return value;
            }
        }
        return -1;
    }

    public static int diagonalDifference(List<List<Integer>> arr) {

    }


    public static void main(String[] args) {
        //plusMinus(List.of(-4, 3, -9, 0, 4, 1));
        //miniMaxSum(List.of(256741038, 623958417, 467905213, 714532089, 938071625));
        timeConversion("12:05:45PM");
    }
}