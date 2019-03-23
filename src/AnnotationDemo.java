

/**
 * AnnotationDemo
 */
public class AnnotationDemo implements TestDemo{
    public static void main(String[] args) {
        TestDemo that = new AnnotationDemo();
        that.testDemo();
    }

    public void testDemo() {
        System.out.println("Java Annotation Demo!");
    }
    
}