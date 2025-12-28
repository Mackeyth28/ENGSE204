package Lab5;

import java.util.Scanner;

// 1. Superclass: Media
class Media {
    protected String title;

    public Media(String title) {
        this.title = title;
    }

    public void process() {
        System.out.println("Starting generic media processing.");
    }
}

// 2. Subclass: Video
class Video extends Media {
    protected int duration;

    public Video(String title, int duration) {
        super(title);
        this.duration = duration;
    }

    @Override
    public void process() {
        System.out.println("Processing video: " + title + " for " + duration + " minutes.");
    }
}

// 3. Subclass: Audio
class Audio extends Media {
    protected String quality;

    public Audio(String title, String quality) {
        super(title);
        this.quality = quality;
    }

    @Override
    public void process() {
        System.out.println("Processing audio: " + title + " with " + quality + " quality.");
    }
}

// 4. Utility Class: Processor
class Processor {
    public static void runProcessor(Media m) {
        // Polymorphism: calls the specific process() method based on the object type
        m.process();
    }
}

// Main Class
public class Lab6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for Video
        String videoTitle = sc.nextLine();
        int videoDuration = sc.nextInt();
        sc.nextLine(); // Consume the leftover newline

        // Input for Audio
        String audioTitle = sc.nextLine();
        String audioQuality = sc.nextLine();

        // 1. Create Video and Audio objects
        Video videoObj = new Video(videoTitle, videoDuration);
        Audio audioObj = new Audio(audioTitle, audioQuality);

        // 2. Process Video
        Processor.runProcessor(videoObj);

        // 3. Process Audio
        Processor.runProcessor(audioObj);

        sc.close();
    }
}