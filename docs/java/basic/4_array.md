---
title: 数组
---

## 1.遍历数组
```java
int[] ns = { 1, 2, 3, 4, 5 };

// for循环
for (int i = 0; i < ns.length; i++) {
    System.out.println(ns[i]);
}

// for each循环
for (int i : ns) {
    System.out.println(i);
}

// Arrays.toString
System.out.println(Arrays.toString(ns)); // [1, 2, 3, 4, 5]
```

## 2.二维数组
```java
 // 二维数组
int[][] ns2 = {
        { 4, 5, 6 },
        { 1, 2, 3 },
        { 7, 8, 9 }
};

// for循环二维数组
for (int[] arr : ns2) {
    for (int i : arr) {
        System.out.println(i);
    }
}

// 使用标准库
String str = Arrays.deepToString(ns2);
System.out.println(str); // [[4, 5, 6], [1, 2, 3], [7, 8, 9]]
```

## 2.命令行参数
```java
// Java程序的入口是main方法，main方法可以接受一个参数
// public static void main(String[] args) { ... }
// 这个参数通过命令行传递进来，它的类型是 String[]
// JVM接受命令行的输入并传给main方法

// java -v
for (String arg : args) {
    if ("-v".equals(arg)) {
        System.out.println("v 1.0");
    }
}
```