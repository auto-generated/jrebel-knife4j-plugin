package cn.jrebel.plugin.knife4j.utils;

import com.github.xiaoymin.knife4j.spring.model.MarkdownFiles;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static java.util.concurrent.TimeUnit.SECONDS;

public class FolderListener {
    private static long lastTime;

    public static void register(String pathName, MarkdownFiles markdownFiles) {
        if (pathName == null && !"".equals(pathName)) {
            return;
        }
        final File file = new File(pathName);
        if (file.exists()) {
            lastTime = file.lastModified();
            ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
            scheduledExecutorService.scheduleAtFixedRate(() -> {
                if (file.lastModified() > lastTime) {
                    markdownFiles.setMarkdownFiles(new ArrayList<>());
                    markdownFiles.init();
                    lastTime = file.lastModified();
                }
            }, 0, 1, SECONDS);
        }
    }
}