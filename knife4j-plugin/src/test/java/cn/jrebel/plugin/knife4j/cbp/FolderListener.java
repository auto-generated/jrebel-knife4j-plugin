package cn.jrebel.plugin.knife4j.cbp;

import java.io.File;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static java.util.concurrent.TimeUnit.SECONDS;

public class FolderListener {
    private static long lastTime;

    public static void listener(final File file) {
        lastTime = file.lastModified();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            if (file.lastModified() > lastTime) {
                System.out.println("file update! time : " + file.lastModified());
                lastTime = file.lastModified();
            }
        }, 0, 1, SECONDS);
    }

    public static void main(String[] args) {
        final File file = new File("/Users/jinghong/code/jrebel-knife4j-plugin/knife4j-sample/src/main/resources/markdown");
        listener(file);
        while (true) {

        }

    }
}