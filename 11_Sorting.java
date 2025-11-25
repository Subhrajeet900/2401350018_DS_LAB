public class BasicSorts {
 public static void insertionSort(int[] arr) {
 for (int i = 1; i < arr.length; i++) {
 int key = arr[i];
 int j = i - 1;
 while (j >= 0 && arr[j] > key) {
 arr[j + 1] = arr[j];
 j--;
 }
 arr[j] = key;
 }
 }
 public static void selectionSort(int[] arr) {
 for (int i = 0; i < arr.length - 1; i++) {
 int minIdx = i;
 for (int j = i + 1; j < arr.length; j++) {
 if (arr[j] < arr[minIdx]) {
 minIdx = j;
 }
 }
 int temp = arr[i];
 arr[i] = arr[minIdx];
 arr[minIdx] = temp;
 }
 }
 public static void bubbleSort(int[] arr) {
 boolean swapped;
 for (int i = 0; i < arr.length - 1; i++) {
 swapped = false;
 for (int j = 0; j < arr.length - 1 - i; j++) {
 if (arr[j] > arr[j + 1]) {
 int temp = arr[j];
 arr[j] = arr[j + 1];
 arr[j + 1] = temp;
 swapped = true;
 }
 }
 if (!swapped) break;
 }
 }
 public static void main(String[] args) {
 int[] arr1 = {5, 2, 4, 6, 1, 3};
 insertionSort(arr1);
 int[] arr2 = {64, 25, 12, 22, 11};
 selectionSort(arr2);
 int[] arr3 = {5, 1, 4, 2, 8};
 bubbleSort(arr3);
 }
}
