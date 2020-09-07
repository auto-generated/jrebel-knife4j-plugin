package cn.jrebel.plugin.knife4j.cbp;

import org.zeroturnaround.bundled.javassist.ClassPool;
import org.zeroturnaround.bundled.javassist.CtClass;
import org.zeroturnaround.bundled.javassist.CtMethod;
import org.zeroturnaround.javarebel.integration.support.JavassistClassBytecodeProcessor;

public class MarkdownFilesCBP extends JavassistClassBytecodeProcessor {
    @Override
    public void process(ClassPool cp, ClassLoader cl, CtClass ctClass) throws Exception {
        cp.importPackage("java.util.List");
        cp.importPackage("java.util.ArrayList");
        ctClass.addMethod(CtMethod.make("" +
                "private void _handle() {" +
                "init();" +
                "}", ctClass));
        // ctClass.getDeclaredMethod("getMarkdownFiles").insertBefore("_handle();");

        ctClass.addMethod(CtMethod.make("" +
                "private void _init() {" +
                "markdownFiles.clear();" +
                "}", ctClass));
        ctClass.getDeclaredMethod("init").insertBefore("_init();");
    }
}