---
title: 运算
---

## 1.整数运算
```java
// 精确运算，会舍去小数部分 
int age = 10 / 3 // age的值是3

int x = 2147483647;
int y = 1;
int sum = x + y;
System.out.println(sum); // -2147483648
// 计算后的结果所需要的内存空间超出了sum拥有的内存空间，那么该怎么保存sum呢？
// int类型使用4个字节，每个字节都是一个8位的二进制数，也就是有32位可以来保存int类型数据
// 其中第一位是符号位，那么其实int类型保存数据可以从 -2^31 ~ 2^31-1
// 为什么正数需要减1呢，这就是下面要讲到的

// 事实上，加法计算的时候会先转换成二进制数在进行运行
// x对应的二进制是 01111111 11111111 11111111 11111111，注意第1位是符号位，0表示正数
// y对应的二进制是 00000000 00000000 00000000 00000001，注意第1位是符号位，0表示正数
// 计算的二进制数: 10000000 00000000 00000000 00000000，注意第1位是符号位，1表示负数
// 我靠，变成了一个负数了。关键就在于这个地方，由于最高位是符号位，当最大的正数+1后，31位全部变成了0，符号位变成了1
// 此时，sum就是个负数。又因为后面31位全部都是0，所以他就是-2^31，也就是最小的那个数。

// 那么如果此时，不想要它变成负数，该怎么办呢？可以想到让最高位不再是符号位就行了，
// 那么就需要给int类型扩大内存空间，也就是用别的类型来保存数据
long x1 = 2147483647;
long y1 = 1;
long sum2 = x1 + y1;
System.out.println(sum2); // 2147483648
```


## 2.浮点数运算
```java
// 浮点数计算会有误差
double d1 = 0.1;
double d2 = 0.2;
double d3 = d1 + d2; // 0.30000000000000004
```

## 3.布尔运算
```java
// 只有 “==”，没有 “===”
int a = 2;
boolean res = a == 2;
```

## 4.字符和字符串运算
```java
 // 字符的类型是char，占用2个字节内存
char c = '浙';
System.out.println(c);

// 使用ini可以直接获取到该字符的Unicodde编码
int c1 = '浙';
System.out.println(c1);

 // 多行字符串使用""" ... """
String str = """
        浙江
        宁波
        家乡
        """;
System.out.println(str);

// 使用 + 操作符可以拼接字符串
String s1 = "浙江";
String s2 = "家乡";
String s3 = s1 + "宁波" + s2;
System.out.println(s3); // 浙江宁波家乡

String s4 = s3 + '！';
System.out.println(s4); // 浙江宁波家乡！

// 字符串不可变！
String s = "hello";
String t = s;
s = "world";
System.out.println(t); // t是"hello"还是"world"?

```

## 5.数组运算
```java
// 使用数组来保存一组相同类型的数据
// 数组一旦创建后，长度不可再改变
int[] ns = new int[5];
// .length来获取数组的长度
System.out.println(ns.length);

int[] ns2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

String[] names = { "ABC", "XYZ", "zoo" };
String s = names[1];
names[1] = "cat";
System.out.println(s); // s是"XYZ"还是"cat"?
```

参考链接：[负数的二进制使用补码方式来计算](https://blog.csdn.net/android_cai_niao/article/details/122209215)
