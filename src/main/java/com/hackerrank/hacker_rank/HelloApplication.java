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
        int minimalSum = 0;
        for (int i = 0; i < minorToMayor.size() - 1; i++) {
            minimalSum += minorToMayor.get(i);
        }
        // Max sum
        List<Integer> maxToMinor = new ArrayList<Integer>(arr);
        maxToMinor.sort(Comparator.reverseOrder());
        int maxSum = 0;
        for (int i = 0; i < maxToMinor.size() - 1; i++) {
            maxSum += maxToMinor.get(i);
        }
        System.out.println(minimalSum + ' ' + maxSum);
    }


    public static void main(String[] args) {
        //plusMinus(List.of(-4, 3, -9, 0, 4, 1));
        miniMaxSum(List.of(1, 2, 3, 4, 5));
    }
}