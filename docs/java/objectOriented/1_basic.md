---
title: 面向对象基础
---

## 1.前言
面向对象编程，是一种通过对象的方式，把现实世界的事物映射到计算机模型的一种编程方法。

譬如我们定义了“人”这种抽象概念，具体的人可能有“张三”、“李四”等。因此“人”可以被称为某种类（class）。

其实可以简单理解为种类的意思，“张三”、“李四”都属于“人”这种类型的事物。

而具体的“张三”、“李四”被称为 `实例` ，可以简单理解为实际的例子。“张三”就是”人“这种类型的一个例子。

因此，其实就是**种类和具体实际例子的关系**。

## 2.class
```java
// 使用class关键字来定义类
// 内部的字段来定义类的特征，类上可以定义多个字段，因此类第一个特点就是可以封装数据
class Person {
    public String name;
    public int age;
}

// 创建实例需要使用new操作符
Person zhangsan = new Person();
// 有了这个zhangsan变量，我们就可以通过这个变量来给实例添加字短
zhangsan.name = "张三";
zhangsan.age = 1;

System.out.println(zhangsan.name);
System.out.println(zhangsan.age);
```

## 3.方法
```java
class Person {
    public String name;
    public int age;
}

Person zhangsan = new Person();

// 随意地在外部修改实例的属性容易造成混乱
// 譬如 zhangsan.age = -100; 这明显是有问题的
// 因此，我们需要对设置实例属性这个动作添加一些规则或者限制
zhangsan.age = -100;

// 首先我们可以使用private修饰符，这个修饰符会禁止在class外部修改实例的属性
class Person {
    private String name;
    private int age;

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        // 在方法中还可以添加一些限制条件，控制传入的age是否可以生效
        if (age < 0 || age > 100) {
            throw new IllegalArgumentException("年龄不符合限制");
        }
        this.age = age;
    }
}

Person ming = new Person();
ming.name = "Xiao Ming";
System.out.println(ming.name); // 没有生效

ming.setName("Mike");
System.out.println(ming.name); // 生效了

ming.setAge(101); // 报错
```

## 4.方法的参数
```java
class Group {
    private String[] names;

    // 可变参数
    public void setNames(String... names) {
        System.out.println(Arrays.toString(names));
        this.names = names;
    }

    // 正常类型的参数
    public void setNames2(String[] names) {
        System.out.println(Arrays.toString(names));
        this.names = names;
    }
}

Group g = new Group();
g.setNames("Mike", "Jack", "Lee"); // [Mike, Jack, Lee]
g.setNames(); // []

// 【setNames2】这个方法需要自己先构造 String[]，比较麻烦
g.setNames2(new String[] { "Mike", "Lee", "Jack" });

class Person2 {
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

// 基本类型和引用类型的参数传递是不同的
// 基本类型很简单，就是传递具体的值
// 引用类型传递按照指向的内存地址传递
// 但是String这个引用类型，是不能被重新赋值的，也就是常说的String不可变！！！
Person2 p = new Person2();
// bob -> Bob
String bob = "Bob";
System.out.println("bob -> " + bob);
// 让this.name 指向了 Bob这个内存空间
p.setName(bob); // 传入bob变量
System.out.println(p.getName()); // "Bob"
// 让bob指向了一个新的内存空间，但是之前的内存空间Bob还是在的
// 也就是String是不能被重新赋值的
// 因此this.name依然指向 Bob这个内存空间
bob = "Alice"; // bob改名为Alice
System.out.println(p.getName()); // "Bob"还是"Alice"?
```
