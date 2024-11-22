package BeyondClasses;

public class A {
    private int t = 1;

    class B {
        private int t = 2;

        class C {
            private int t = 3;
            public void printT() {
                System.out.println(t);
                System.out.println(this.t);
                System.out.println(B.this.t);
                System.out.println(A.this.t);
            }
        }
    }

    public static void main(String[] args) {
        A a = new A();
        B b = a.new B();
        B.C c = b.new C();
        c.printT(); // 3, 3, 2, 1

        //C myC = new C(); /* 🔴 ERROR: Does not compile! */
    }
}
