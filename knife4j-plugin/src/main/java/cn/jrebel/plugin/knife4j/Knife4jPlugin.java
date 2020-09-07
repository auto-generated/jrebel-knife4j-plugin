package cn.jrebel.plugin.knife4j;

import cn.jrebel.plugin.knife4j.cbp.Knife4jControllerCBP;
import cn.jrebel.plugin.knife4j.cbp.MarkdownFilesCBP;
import org.zeroturnaround.javarebel.ClassResourceSource;
import org.zeroturnaround.javarebel.Integration;
import org.zeroturnaround.javarebel.IntegrationFactory;
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
        Integration integration = IntegrationFactory.getInstance();
        ClassLoader cl = getClass().getClassLoader();

        integration.addIntegrationProcessor(cl,
                "com.github.xiaoymin.knife4j.spring.web.Knife4jController",
                new Knife4jControllerCBP());
        integration.addIntegrationProcessor(cl,
                "com.github.xiaoymin.knife4j.spring.model.MarkdownFiles",
                new MarkdownFilesCBP());

    }

    @Override
    public boolean checkDependencies(ClassLoader cl, ClassResourceSource crs) {
        return crs.getClassResource("com.github.xiaoymin.knife4j.spring.web.Knife4jController") != null;
    }

    @Override
    public String getId() {
        return "jrebel_knife4j_plugin";
    }

    @Override
    public String getName() {
        return "jrebel-knife4j-plugin";
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getAuthor() {
        return "i@jinghong.me";
    }

    @Override
    public String getWebsite() {
        return "https://jrebel.cn";
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
