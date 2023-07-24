package com.example.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.common.reflect.ClassPath;

public class Switcher_ {
    public static void main(String[] args) throws Exception {
        List<Class<?>> classes = getClasses();

        // Print out all classes
        for (int i = 0; i < classes.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, classes.get(i).getSimpleName());
        }

        // Get user input
        System.out.print("\nChoose a class: ");
        int choice = Integer.valueOf(System.console().readLine());

        // Run the class
        classes.get(choice - 1)
            .getDeclaredMethod("main", String[].class)
            .invoke(null, (Object) new String[] {});
    }

    private static List<Class<?>> getClasses() {
        final String packageName = Switcher_.class.getPackage().getName();
        final List<Class<?>> classes = new ArrayList<>();
        final ClassLoader loader = Thread.currentThread()
            .getContextClassLoader();

        try {
            ClassPath classpath = ClassPath.from(loader);
            for (ClassPath.ClassInfo classInfo : classpath.getTopLevelClasses(packageName)) {
                if (classInfo.getSimpleName().endsWith("_")) {
                    continue;
                }

                classes.add(classInfo.load());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return classes;
    }
}
