import java.util.Arrays;

class Test {
    public static void main(String[] args) {
        int[] ns = { 1, 2, 3, 4, 5 };
        for (int i = 0; i < ns.length; i++) {
            System.out.println(ns[i]);
        }

        System.out.println();

        for (int i : ns) {
            System.out.println(i);
        }

        System.out.println();

        System.out.println(Arrays.toString(ns));

        System.out.println();

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

        // 使用标准库的deepToString方法
        String str = Arrays.deepToString(ns2);
        System.out.println(str); // [[4, 5, 6], [1, 2, 3], [7, 8, 9]]

        // Java程序的入口是main方法，main方法可以接受一个参数
        // public static void main(String[] args) { ... }
        // 这个参数通过命令行传递进来，它的类型是 String[]
        // JVM接受命令行的输入并传给main方法

        for (String arg : args) {
            if ("-v".equals(arg)) {
                System.out.println("v 1.0");
            }
        }

    }
}
