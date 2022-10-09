import java.util.Scanner;

class Test {
    public static void main(String[] args) {
        // 换行输出
        System.out.println("我可以换行");
        // 行内输出
        System.out.print("我不能换行");
        System.out.print("【我也不能换行】");
        System.out.println();

        // 格式化输出
        double d = 3.14;
        System.out.printf("%.1f\n", d); // 显示1位小数3.1

        // 输入
        // var scanner = new Scanner(System.in);
        // System.out.print("请输入名称");
        // var name = scanner.nextLine();

        // System.out.print("请输入年龄");
        // var age = scanner.nextInt();
        // System.out.printf("你好%s, 你的年龄是%d\n", name, age);

        // 判断浮点数相等
        double x = 1 - 9.0 / 10;
        System.out.println(x); // 0.09999999999999998
        if (x == 0.1) {
            System.out.println("x is 0.1");
        } else {
            System.out.println("x is NOT 0.1");
        }

        // 因此需要使用某个临界值来判断
        if (Math.abs(x - 0.1) < 0.00000001) { // 说明和0.1差距非常非常小，可以认为等于0.1
            System.out.println("x is 0.1");
        } else {
            System.out.println("x is NOT 0.1");
        }

        // 判断引用类型相等
        // 引用类型比较比较的是引用地址是否相同，"=="比较的是具体的值，需要使用equals方法
        String s1 = "hello";
        String s2 = "HELLO".toLowerCase();
        boolean bool = s1.equals(s2);
        if (bool) {
            System.out.println("s1和s2相等");
        } else {
            System.out.println("s1和s2不相等");
        }

        // 使用equals方法的时候，需要避免调用者不能为null 比如s1是null
        if (s1 != null && s1.equals("hello")) {
            System.out.println("hello");
        }

        // switch新语法
        String fruit = "apple";
        int opt = switch (fruit) {
            case "apple" -> 1;
            default -> 0;
        };
        System.out.println("opt = " + opt);

        // yield关键字，可以在switch语句中手动返回值
        String animal = "dog";
        int res = switch (animal) {
            case "cat" -> 1;
            case "bear", "bird" -> 2;

            // 当返回值需要编写很多代码的时候
            default -> {
                int code = 1000;
                yield code + 1; // switch返回的值
            }
        };
        System.out.println("res = " + res);

        // for循环
        int[] ns = { 1, 2, 3, 4, 5 };
        for (int i = 0; i < ns.length; i++) {
            System.out.println(ns[i]);
        }

        System.out.println();

        // for each循环，但是不能保证循环的顺序
        for (int i : ns) {
            System.out.println(i);
        }

    }
}
