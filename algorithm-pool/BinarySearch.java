public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[] {90,180,700,260, 100, 5, 4, 3};
        Arrays.sort(arr);

        int target = 90;

        boolean isExist = binarySearch(arr, target, 0, arr.length);

        System.out.println(isExist);
    }

    public static boolean binarySearch(int[] data, int target, int low, int high) {
        if(low > high) {
            return false;
        } else {
            int mid = (low + high) / 2;
            if(target == data[mid])
                return true;
            else if(target < data[mid])
                return binarySearch(data, target, low, mid - 1);
            else
                return binarySearch(data, target, mid + 1, high);
        }
    }
}