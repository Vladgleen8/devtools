package ru.mentee.power;

public class ProgressDemo {
    public static void main(String[] args) {
        MenteeProgress medvedevVladislav = new MenteeProgress(
                "Medvedev Vladislav",
                2,
                10
        );
        var progress = medvedevVladislav;

        System.out.println(progress.summary());
        if (progress.readyForSprint()) {
            System.out.println("Status: sprint ready");
        } else {
            System.out.println("Status: backlog first");
        }
    }
}
