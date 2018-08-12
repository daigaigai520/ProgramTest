package test.character;

/**
 * @author daigaigai
 */
public class VisibleTest {

    private int value;

    private volatile boolean flag;

    /**
     * flag为volatile的
     * 则value不会被指令重排,所以value一定是执行的
     */
    private Thread start = new Thread(() -> {
        value = 100;
        flag = true;
    });

    /**
     * 读取了volatile的flag, start的所有工作区间都会进入主存中
     * 所以如果false为true,则value一定为100
     */
    private Thread end = new Thread(() -> {
        System.out.println(flag + "" + value);
    });

    /**
     * 结果不会有true0的
     */
    private static void test() {
        VisibleTest test = new VisibleTest();
        test.start.start();
        test.end.start();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            test();
        }
    }
}
