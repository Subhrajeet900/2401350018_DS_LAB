public class BinarySearch {
 public static int binarySearchIterative(int[] arr, int key) {
 int left = 0, right = arr.length - 1;
 while (left <= right) {
 int mid = left + (right - left) / 2;
 if (arr[mid] == key) return mid;
 if (arr[mid] < key) left = mid + 1;
 else right = mid - 1;
 }
 return -1;
 }
 public static int binarySearchRecursive(int[] arr, int left, int right, int key) {
 if (left > right) return -1;
 int mid = left + (right - left) / 2;
 if (arr[mid] == key) return mid;
 if (arr[mid] < key) return binarySearchRecursive(arr, mid + 1, right, key);
 return binarySearchRecursive(arr, left, mid - 1, key);
 }
 public static void main(String[] args) {
 int[] arr = {2, 3, 4, 10, 40};
 System.out.println(binarySearchIterative(arr, 10));
 System.out.println(binarySearchRecursive(arr, 0, arr.length - 1, 10));
 }
}
