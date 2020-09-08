package cn.jrebel.plugin.knife4j.cbp;

import org.zeroturnaround.bundled.javassist.ClassPool;
import org.zeroturnaround.bundled.javassist.CtClass;
import org.zeroturnaround.javarebel.integration.support.CacheAwareJavassistClassBytecodeProcessor;

public class Swagger2ControllerCBP extends CacheAwareJavassistClassBytecodeProcessor {

    @Override
    public void process(ClassPool cp, ClassLoader cl, CtClass ctClass) throws Exception {
        ctClass.getDeclaredMethod("apiSorts").insertBefore("org.zeroturnaround.jrebel.springfox.SpringfoxReloader.reloadForRequest();");
    }
}