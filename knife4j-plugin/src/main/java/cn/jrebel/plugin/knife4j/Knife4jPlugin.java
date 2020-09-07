package cn.jrebel.plugin.knife4j;

import org.zeroturnaround.javarebel.ClassResourceSource;
import org.zeroturnaround.javarebel.Plugin;

/**
 * Knife4jPlugin
 *
 * @author jinghong
 * @date 2020-09-07
 */
public class Knife4jPlugin implements Plugin {
    @Override
    public void preinit() {

    }

    @Override
    public boolean checkDependencies(ClassLoader cl, ClassResourceSource crs) {
        return false;
    }

    @Override
    public String getId() {
        return "jrebel_knife4j_plugin";
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getAuthor() {
        return null;
    }

    @Override
    public String getWebsite() {
        return null;
    }

    @Override
    public String getSupportedVersions() {
        return null;
    }

    @Override
    public String getTestedVersions() {
        return null;
    }
}
