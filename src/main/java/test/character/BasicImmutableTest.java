package test.character;

/**
 * @author daigaigai
 */
public class BasicImmutableTest {

    private static Integer add(Integer i) {
        i += 1;
        return i;
    }

    public static void main(String[] args) {
        Integer i = 0;
        Integer result = add(i);
        System.out.println(i + ":" + i.hashCode());
        System.out.println(result + ":" + result.hashCode());
    }

}
