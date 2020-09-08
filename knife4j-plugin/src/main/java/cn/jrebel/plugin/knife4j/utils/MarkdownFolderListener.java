package cn.jrebel.plugin.knife4j.utils;

import com.github.xiaoymin.knife4j.spring.model.MarkdownFiles;
import org.zeroturnaround.javarebel.Logger;
import org.zeroturnaround.javarebel.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static java.util.concurrent.TimeUnit.SECONDS;

public class MarkdownFolderListener {
    private static long lastTime;

    private static final Logger log = LoggerFactory.getLogger("knife4jPlugin");

    public static void register(String pathName, MarkdownFiles markdownFiles) {
        final File file = new File(pathName);
        if (file.exists()) {
            lastTime = file.lastModified();
            ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
            scheduledExecutorService.scheduleAtFixedRate(() -> {
                if (file.lastModified() > lastTime) {
                    log.infoEcho("Reloading knife4j markdown");
                    markdownFiles.setMarkdownFiles(new ArrayList<>());
                    markdownFiles.init();
                    lastTime = file.lastModified();
                }
            }, 0, 1, SECONDS);
        }
    }
}