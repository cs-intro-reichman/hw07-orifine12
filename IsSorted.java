public class IsSorted {

    private static boolean isSorted(int[] a, int i) {
    if (a.length <= 1 || i == a.length - 1) return true;
    return a[i] <= a[i + 1] && isSorted(a, i + 1);
}
    

    public static void main(String[] args) {
        int[] a = {1, 2, 2, 5};
        System.out.println(isSorted(a)); // true

        int[] b = {1, 3, 2};
        System.out.println(isSorted(b)); // false
    
}
