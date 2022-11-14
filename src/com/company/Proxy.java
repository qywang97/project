package com.company;

import java.io.IOException;
import java.lang.reflect.Method;

public class Proxy {

    private static Object TypeSpec;

    public static Object newProxyInstance() throws IOException {
//        //新建一个代理类
//        TypeSpec.Builder typeSpecBuilder = TypeSpec.classBuilder("TimeProxy")
//                .addSuperinterface(Flyable.class);
//        // 代理类需要注入的接口对象 =》 private Flyable flyable; public Bird3(Flyable flyable) {this.flyable = flyable;}
//        FieldSpec fieldSpec = FieldSpec.builder(Flyable.class, "flyable", Modifier.PRIVATE).build();
//        typeSpecBuilder.addField(fieldSpec);// 注入private Flyable flyable;
//
//        MethodSpec constructorMethodSpec = MethodSpec.constructorBuilder()
//                .addModifiers(Modifier.PUBLIC)
//                .addParameter(Flyable.class, "flyable")
//                .addStatement("this.flyable = flyable")
//                .build();
//        typeSpecBuilder.addMethod(constructorMethodSpec);// 注入public Bird3(Flyable flyable) {this.flyable = flyable;}
//
//        Method[] methods = Flyable.class.getDeclaredMethods();// 获取接口的所有方法
//        for (Method method : methods) {
//            MethodSpec methodSpec = MethodSpec.methodBuilder(method.getName())
//                    .addModifiers(Modifier.PUBLIC)
//                    .addAnnotation(Override.class)
//                    .returns(method.getReturnType())
//                    .addStatement("long start = $T.currentTimeMillis()", System.class)
//                    .addCode("\n")
//                    .addStatement("this.flyable." + method.getName() + "()")
//                    .addCode("\n")
//                    .addStatement("long end = $T.currentTimeMillis()", System.class)
//                    .addStatement("$T.out.println(\"Fly Time =\" + (end - start))", System.class)
//                    .build();
//            typeSpecBuilder.addMethod(methodSpec);
//        }
//
//        JavaFile javaFile = JavaFile.builder("com.youngfeng.proxy", typeSpecBuilder.build()).build();
//        // 为了看的更清楚，我将源码文件生成到桌面
//        javaFile.writeTo(new File("/Users/ouyangfeng/Desktop/"));

        return null;
    }

}
