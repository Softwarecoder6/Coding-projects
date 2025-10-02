import java.util.Random;
public class Sorting_Algo 
{
public static void main( String[] args )
{
int size_of_array = 100;
int[]arr = new int[size_of_array];
Random rand = new Random();
System.out.println("The unsorted array:");
for (int i = 0; i < size_of_array; i++)
{
arr[i] = rand.nextInt(40) + 1;
}
for(int j = 0; j < arr.length; j++)
{
System.out.print(arr[j]);
if(j<arr.length -1)
System.out.print(", ");
}
System.out.println();
System.out.println();
System.out.println("After quick sort:");
System.out.println();
quicksort(arr, 0, arr.length-1);
for(int j = 0; j < arr.length; j++)
{
System.out.print(arr[j]);
if(j<arr.length -1)
System.out.print(", ");
}
System.out.println();
System.out.println();
System.out.println("After heap sort:");
System.out.println();
heapsort(arr, size_of_array);
for (int x = 0; x < arr.length; x++) 
{
System.out.print(arr[x]);
if(x<arr.length -1)
System.out.print(", ");
}
System.out.println();
}
public static void quicksort(int[] A, int p, int r)
{
if(p < r)
{
int q = partition(A,p,r);
quicksort(A, p, q-1);
quicksort(A, q + 1, r);
}
}
public static int partition(int[] A, int p, int r)
{
int x = A[r];
int i = p - 1;
for (int j = p; j <= r - 1; j++)
{
if(A[j] <= x)
{
i++;
int temp = A[i];
A[i] = A[j];
A[j] = temp;
}
}
int temp = A[i + 1];
A[i + 1] = A[r];
A[r] = temp;
return i + 1;
}
public static void heapsort(int[] A, int n)
{
n = A.length;
int heapsize = n;
build_max_heap(A, n);
for(int i = n - 1; i >= 1;i-- )
{
int temp = A[0];
A[0] = A[i];
A[i] = temp;
heapsize--;
maxheapify(A, heapsize, 0);
}
}
public static void build_max_heap(int[] A, int n)
{
for(int i = n/2 - 1; i >= 0;i-- )
{
maxheapify(A, n, i);
}
}
public static void maxheapify(int[] A, int heapsize, int i)
{
int l = 2 * i + 1;
int r = 2 * i + 2;
int largest = i;
if(l < heapsize && A[l] > A[largest])
{
largest = l;
}
if(r < heapsize && A[r] > A[largest])
{
largest = r;
}
if(largest != i)
{
int temp = A[i];
A[i] = A[largest];
A[largest] = temp;
maxheapify(A, heapsize, largest);
}
}
}
