package cn.jrebel.plugin.knife4j.cbp;

import org.zeroturnaround.bundled.javassist.ClassPool;
import org.zeroturnaround.bundled.javassist.CtClass;
import org.zeroturnaround.bundled.javassist.CtMethod;
import org.zeroturnaround.javarebel.integration.support.JavassistClassBytecodeProcessor;

public class Knife4jControllerCBP extends JavassistClassBytecodeProcessor {
    @Override
    public void process(ClassPool cp, ClassLoader cl, CtClass ctClass) throws Exception {
        cp.importPackage("java.util");

        ctClass.addMethod(CtMethod.make("" +
                "private void reinitialize() {" +
                "System.out.println(\"啊哈\");" +
                "}", ctClass));

        ctClass.getDeclaredMethod("apiSorts").insertBefore("reinitialize();");
    }
}
