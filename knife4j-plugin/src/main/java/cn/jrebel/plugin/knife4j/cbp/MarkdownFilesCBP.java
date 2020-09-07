package cn.jrebel.plugin.knife4j.cbp;

import org.zeroturnaround.bundled.javassist.ClassPool;
import org.zeroturnaround.bundled.javassist.CtClass;
import org.zeroturnaround.bundled.javassist.CtField;
import org.zeroturnaround.javarebel.integration.support.JavassistClassBytecodeProcessor;

public class MarkdownFilesCBP extends JavassistClassBytecodeProcessor {
    @Override
    public void process(ClassPool cp, ClassLoader cl, CtClass ctClass) throws Exception {
        cp.importPackage("java.util.List");
        cp.importPackage("cn.jrebel.plugin.knife4j.utils");
        cp.importPackage("com.github.xiaoymin.knife4j.spring.model.MarkdownFiles");
        cp.importPackage("cn.jrebel.plugin.knife4j.utils.FolderListener");
        cp.importPackage("java.io.File");
        cp.importPackage("org.springframework.core.io.Resource");
        cp.importPackage("java.util.ArrayList");

        ctClass.addField(CtField.make("public boolean _flag=true;", ctClass));
        ctClass.getDeclaredMethod("createMarkdownFile").insertBefore(
                "{if(_flag){FolderListener.register($1.getFile().getParent(),$0);}this._flag=false;}"
        );
    }
}