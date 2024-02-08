module com.hackerrank.hacker_rank {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.hackerrank.hacker_rank to javafx.fxml;
    exports com.hackerrank.hacker_rank;
}