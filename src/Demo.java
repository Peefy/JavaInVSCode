


/**
 * Demo
 */
public class Demo {

    public static void main(String[] args) {
        System.out.println("java");
        DemoA demo = new DemoB();
        demo.func();
        DemoB demoB = (DemoB)demo;
        demoB.func();
        DemoC demoC = (DemoC)demo;
        demoC.func();
    }
}
