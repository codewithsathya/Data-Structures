import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        Temp.heapify(arr);
        System.out.println(Arrays.toString(arr));
        
    }
}
