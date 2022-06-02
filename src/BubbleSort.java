import java.util.Arrays;

public class BubbleSort {

	public static void sort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < (arr.length - i) - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	static void sortRecur(int arr[], int n) {

		if (n == 1)
			return;

		for (int i = 0; i < n - 1; i++)
			if (arr[i] > arr[i + 1]) {
				int temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
			}
		sortRecur(arr, n - 1);
	}

	public static void main(String[] args) {
		int[] ar = { 5, 12, 4, 2, 66, 1 };
		 //sort(ar);
		// sortRecur(ar, ar.length);
		System.out.println(Arrays.toString(ar));
	}

}
