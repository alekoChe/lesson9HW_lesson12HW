package ru.gdAleko.lesson9HW.foo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Foo {

   public static List<String> linkedList = new LinkedList<>();
    public static List<String> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        int size = 1000000;
        String str = "1";
        String str2 = "1";
        for (int i = 0; i < 5; i++) {
            linkedList.add("0");
            arrayList.add("0");
        }
        for (int i = 0; i < size; i++) {
            String str1 = str + i;
            linkedList.add(str1);
            arrayList.add(str1);
        }

        long start1 = System.currentTimeMillis();
        for (int i = 10; i < size / 2 - 1; i++) {
            //linkedList.remove(i);
            str2 = str + i;
            linkedList.remove(str2);
        }
        long finis1 = System.currentTimeMillis();

        long start2 = System.currentTimeMillis();
        for (int i=10; i<size / 2 -1;i++) {
            //arrayList.remove(i);
            str2 = str + i;
            arrayList.remove(str2);
        }
        long finis2 = System.currentTimeMillis();

        System.out.println("linkedTime = " + (finis1 - start1));
        System.out.println("arrayTime = " + (finis2 - start2));
    }

    public class Fooo {
        int a;
        String b;

        public void setA(int a) {
            this.a = a;
        }
    }
}
