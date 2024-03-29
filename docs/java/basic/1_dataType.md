---
title: 数据类型
---

## 1.基本结构

Java是面向对象的语言，一个程序的基本单位就是 `class`。

`public` 是访问修饰符，表示这个 `class` 是公开的。如果不写 `public`，这个 `class` 就不能被其他文件引用到。

```java
public class Hello {
    public static void main(String[] args) {
        System.out.println("基本结构")
    }
}
```

## 2.计算机内存
该语句执行的时候，**JVM**在内存中为变量 `n` 分配一个“存储单元”，填入值为1
```java
int num = 1;
```
那么如何理解“存储单元”呢？

我们先抛开这个词语，先理解下面这段话。

计算机内存是用来存储数据的，就像一个大屋子可以存储很多东西。大屋子可以分为很多房间，每个房间可以存储很多东西。每个房间里有很多盒子，每个盒子又可以存储很多东西。我们可以以**一个盒子作为衡量房子存储空间的单位**，也可以以**一个房间作为衡量房子存储空间的单位**，比如说这个房子大小有10个房间，这个房子大小有99999个盒子。

**那么，这些“盒子”、“房间”其实都可以抽象为衡量房子大小的存储单元。这个单元可以大，也可以小。衡量房子大小可以用“盒子”来衡量，也可以用“房间”来衡量。假设衡量房子大小的最小的单元是“盒子”**

**同样的，衡量内存大小也有不同的存储单元。这个单元可以大，也可以小。衡量内存大小可以用“字节”来衡量，也可以用“1M”、“1G”、“1T”等来衡量。计算机中规定，衡量内存大小最小的单元是“字节”**

到这里，应该就可以明白“存储单元”的意思了！接下来的问题是：我们理解一个“盒子”具体有多大，但是怎么知道一个“字节”有多大呢？一个“字节”可以存储多少数据呢？

事实上，一个“字节”就是一个8位二进制数，它可以存储的数据是一个范围区间，`00000000~11111111`，换算成十进制就是 `0~255`，因此一个“字节”，就可能是0～255间的一个数字。

## 3.基本数据类型
不同数据类型占用的内存大小是不同的，我们知道内存大小可以用“字节”来就衡量。比如说A数据类型占用了1字节，B数据类型占用了2字节，这就和房间里的不同东西占用的盒子数量是不同的情况一样，比如**男人衣服**占用一个盒子，**女人衣服**占用10个盒子。

下面是Java不同的基本数据类型占用的内存：
- byte：1个字节
- short：2个字节
- int：4个字节
- long：8个字节
- float：4个字节
- double：8个字节
- char：2个字节

```java
public class Hello {
    public static void main(String[] args) {
        float f1 = 3.14f;
        double d = 3.1415;

        // 布尔类型占用的内存大小并没有做规定，通常是4个字节
        boolean b1 = true;

        // char表示一个字符
        char zh = '中'
    }
}
```

## 4.变量、常量
```java
public class Hello {
    public static void main(String[] args) {
        String str = "hello";

        // 写数据类型很麻烦，例如上面的String，就可以用var关键字
        // 编译器自动根据赋值语句，判断出赋值后的变量是什么类型
        var str = "hello";

        // 常量使用final修饰符
        final double PI = 3.14;
    }
}
```