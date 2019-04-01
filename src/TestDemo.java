

/**
 * TestDemo
 */
public interface TestDemo {

    void testDemo();

    default void print(){
        System.out.println("我是一辆车!");
    }

}