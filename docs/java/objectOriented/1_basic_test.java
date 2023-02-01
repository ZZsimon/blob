import java.util.Arrays;

class Test {
    public static void main(String[] args) {

        // class Person {
        // public String name;
        // public int age;
        // }

        // // 创建实例需要使用new操作符
        // Person zhangsan = new Person();
        // // 有了这个zhangsan变量，我们就可以通过这个变量来给实例添加字短
        // zhangsan.name = "张三";
        // zhangsan.age = 1;

        // System.out.println(zhangsan.name);
        // System.out.println(zhangsan.age);

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
                    System.err.println("输入的年龄不符合规范");
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

        class Group {
            private String[] names;

            public void setNames(String... names) {
                System.out.println(Arrays.toString(names));
                this.names = names;
            }

            public void setNames2(String[] names) {
                System.out.println(Arrays.toString(names));
                this.names = names;
            }
        }

        Group g = new Group();
        g.setNames("Mike", "Jack", "Lee"); // [Mike, Jack, Lee]
        g.setNames(); // []

        // 【setNames2】这个方法需要自己先构造 String[]
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

        Person2 p = new Person2();
        // bob -> Bob
        String bob = "Bob";
        System.out.println("bob -> " + bob);
        // 让this.name 指向了 Bob这个内存空间
        p.setName(bob); // 传入bob变量
        System.out.println(p.getName()); // "Bob"
        // 让bob指向了一个新的内存空间，但是之前的内存空间Bob还是在的
        // 也就是 String 是不能被重新赋值的
        // 因此 this.name 依然指向 Bob这个内存空间
        bob = "Alice"; // bob改名为Alice
        System.out.println(p.getName()); // "Bob"还是"Alice"?
    }
}
