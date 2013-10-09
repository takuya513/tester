package tester;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

import mergeSort.*;
import quickSort.*;
import sort.*;
import tools.*;

public class Tester {
	static Scanner sc;
	static int outCount = 0;
	public static void main(String args[]) throws InterruptedException {
		sc = new Scanner(System.in);

		sortChecer();
		//intSorting();

		//doubleSorting();
		//stringSorting();
	}


	public static void stringSorting(){

		int length = 10000;

		MyString[] stringArray = new MyString[length];
		String[] data2 = MyArrayUtil.randomStringArray(stringArray.length);
		for(int i = 0;i < stringArray.length;i++)
			stringArray[i] = new MyString(data2[i]);

		//MyArrayUtil.print(stringArray);
		Sort<MyString> qs = new QuickSort<MyString>();
		Sort<MyString> qs6 = new QuickSort6<MyString>();
		Sort<MyString> qms = new QuickMergeSort<MyString>();//修正

		MyString[] stringArray2 = Arrays.copyOf(stringArray, stringArray.length);
		MyString[] stringArray3 = Arrays.copyOf(stringArray, stringArray.length);
		MyString[] stringArray4 = Arrays.copyOf(stringArray, stringArray.length);

		long qmsStart = System.currentTimeMillis();
		qms.sort(stringArray);
		long qmsEnd = System.currentTimeMillis();

		long qs6Start = System.currentTimeMillis();
		qs6.sort(stringArray2);
		long qs6End = System.currentTimeMillis();

		long Start = System.currentTimeMillis();
		Arrays.sort(stringArray3);
		long End = System.currentTimeMillis();
		//MyArrayUtil.print(stringArray);

		long qsStart = System.currentTimeMillis();
		qs.sort(stringArray4);
		long qsEnd = System.currentTimeMillis();

		System.out.println("Arrays Sort time         :"+(End - Start));
		System.out.println("QuickMerge time          :"+(qmsEnd - qmsStart));
		System.out.println("Paralle Quick Sort6 time :"+(qs6End- qs6Start));
		System.out.println("Quick Sort time          :"+(qsEnd- qsStart));

	}

	public static void sortChecer(){
		int i = 10;
		long start = System.currentTimeMillis();
		//for(int i = 10;i < 1000;i++)
			intSortingCheck(i);

		long stop = System.currentTimeMillis();
		System.out.println("Finish");
		System.out.println("outCount : "+outCount);
		System.out.println("Time : "+(stop-start));
	}

	private static void doubleSorting() {


//		System.out.println("Input doubleArray length");
		//int length = sc.nextInt();
		int length  = 1000000;


		MyDouble[] doubleArray = new MyDouble[length];
		double[] data2 = MyArrayUtil.randomDoubleArray(doubleArray.length);
		for(int i = 0;i < doubleArray.length;i++)
			doubleArray[i] = new MyDouble(data2[i]);

		MyDouble[] doubleArray2 = Arrays.copyOf(doubleArray,doubleArray.length);
		MyDouble[] doubleArray6 = Arrays.copyOf(doubleArray,doubleArray.length);
		MyDouble[] doubleArray7 = Arrays.copyOf(doubleArray,doubleArray.length);
		MyDouble[] doubleArray8 = Arrays.copyOf(doubleArray,doubleArray.length);
		MyDouble[] doubleArray9 = Arrays.copyOf(doubleArray,doubleArray.length);
		MyDouble[] doubleArray10 = Arrays.copyOf(doubleArray,doubleArray.length);
		MyDouble[] doubleArray11 = Arrays.copyOf(doubleArray,doubleArray.length);

		Sort<MyDouble> qs = new QuickSort<MyDouble>();
		Sort<MyDouble> qs2 = new QuickSort2<MyDouble>();
		Sort<MyDouble> qs6 = new QuickSort6<MyDouble>();
		Sort<MyDouble> ms = new MergeSort<MyDouble>();
		Sort<MyDouble> pms = new ParallelMergeSort<MyDouble>();//修正
		Sort<MyDouble> qms = new QuickMergeSort<MyDouble>();//修正


//		MyArrayUtil.print(doubleArray);
		long qsStart = System.currentTimeMillis();
		qs.sort(doubleArray);
		long qsStop = System.currentTimeMillis();

		long qs2Start = System.currentTimeMillis();
		qs2.sort(doubleArray2);
		long qs2Stop = System.currentTimeMillis();


		long qs6Start = System.currentTimeMillis();
		qs6.sort(doubleArray6);
		long qs6Stop = System.currentTimeMillis();

		long msStart = System.currentTimeMillis();
		ms.sort(doubleArray7);
		long msStop = System.currentTimeMillis();


		long pmsStart = System.currentTimeMillis();
		pms.sort(doubleArray8);
		long pmsStop = System.currentTimeMillis();

		long Start = System.currentTimeMillis();
		Arrays.sort(doubleArray9);
		long Stop = System.currentTimeMillis();

//		MyArrayUtil.print(doubleArray10);
		Sort<MyDouble> qs5 = new QuickSort5<MyDouble>();
		long start9 = System.currentTimeMillis();
		qs5.sort(doubleArray10);
		long stop9 = System.currentTimeMillis();
//		MyArrayUtil.print(doubleArray10);

		long start10 = System.currentTimeMillis();
		qms.sort(doubleArray11);
		long stop10 = System.currentTimeMillis();

		System.out.println("Normal Quick Sort time   :"+(qsStop - qsStart));
		System.out.println("Paralle Quick Sort2 time :"+(qs2Stop - qs2Start));
		System.out.println("Paralle Quick Sort6 time :"+(qs6Stop - qs6Start));
		System.out.println("Merge Sort time          :"+(msStop - msStart));
		System.out.println("ParallelMerge Sort time  :"+(pmsStop - pmsStart)); //修正
		System.out.println("Arrays Sort time         :"+(Stop - Start)); //修正
		System.out.println("forkJoin quickSort time  :"+(stop9 - start9)); //修正
		System.out.println("quickMergeSort time      :"+(stop10 - start10)); //修正
	}

	public static void intSortingCheck(int t){

		int length = t;

		MyInteger[] array = new MyInteger[length];
		int[] data = ArrayUtil.randomIntArray(array.length); //乱数


		for(int i = 0;i < array.length;i++)
			array[i] = new MyInteger(data[i]);


		MyInteger[] array10 = Arrays.copyOf(array,array.length);
		MyInteger[] array11 = Arrays.copyOf(array,array.length);
		MyInteger[] array12 = Arrays.copyOf(array,array.length);

		Sort<MyInteger> qs6 = new QuickSort6<MyInteger>();
		Sort<MyInteger> pms = new ParallelMergeSort<MyInteger>();//修正
		Sort<MyInteger> qms = new QuickMergeSort<MyInteger>();
		Sort<MyInteger> qms_2 = new QuickMergeSort_2<MyInteger>();
		Sort<MyInteger> ns = new NewSort<MyInteger>();



		long start11 = System.currentTimeMillis();
		qms.sort(array10);
		long stop11 = System.currentTimeMillis();

		long start10 = System.currentTimeMillis();
		qms_2.sort(array11);
		long stop10 = System.currentTimeMillis();

		MyArrayUtil.print(array12);
		long start12 = System.currentTimeMillis();
		ns.sort(array12);
		long stop12 = System.currentTimeMillis();
		MyArrayUtil.print(array12);
		
		
		System.out.println("length : "+t);
		if(!MyArrayUtil.checker(array10)){
			System.out.println("OUT");
			outCount++;
		}

//		System.out.println("Quick Merge Sort_2 time  :"+(stop10 - start10)); //修正
//		System.out.println("Quick Merge Sort time  :"+(stop11 - start11)); //修正


	}


	public static void intSorting(){

		System.out.println("Input arrays length");
		//int length = sc.nextInt();
		int length =12;
//		int length = Integer.MAX_VALUE;
		System.out.println("Integer "+Integer.MAX_VALUE );

		MyInteger[] array = new MyInteger[length];
		int[] data = ArrayUtil.randomIntArray(array.length); //乱数
		//int[] data = ArrayUtil.myIntArray(array.length);  //手動入力


		for(int i = 0;i < array.length;i++)
			array[i] = new MyInteger(data[i]);

		MyInteger[] array2 = Arrays.copyOf(array,array.length);
		MyInteger[] array4 = Arrays.copyOf(array,array.length);
		MyInteger[] array6 = Arrays.copyOf(array,array.length);
		MyInteger[] array7 = Arrays.copyOf(array,array.length);
		MyInteger[] array8 = Arrays.copyOf(array,array.length);
		MyInteger[] array9 = Arrays.copyOf(array,array.length);
		MyInteger[] array10 = Arrays.copyOf(array,array.length);

		Sort<MyInteger> qs = new QuickSort<MyInteger>();
		Sort<MyInteger> qs2 = new QuickSort2<MyInteger>();
		Sort<MyInteger> qs6 = new QuickSort6<MyInteger>();
		Sort<MyInteger> ms = new MergeSort<MyInteger>();
		Sort<MyInteger> pms = new ParallelMergeSort<MyInteger>();//修正
		Sort<MyInteger> qms = new QuickMergeSort<MyInteger>();


		//System.out.println("THERA : "+ Runtime.getRuntime().availableProcessors());

		MyArrayUtil.print(array);
		System.out.println("-------QuickSort------");
		long start = System.currentTimeMillis();
		qs.sort(array);
		long stop = System.currentTimeMillis();
//		MyArrayUtil.print(array);

		System.out.println("-------QuickSort2------");
		long start2 = System.currentTimeMillis();
		qs2.sort(array2);
		long stop2 = System.currentTimeMillis();
//		MyArrayUtil.print(array2);


		System.out.println("-------ArraySort------");
		long start4 = System.currentTimeMillis();
		Arrays.sort(array4);
		long stop4 = System.currentTimeMillis();
//		MyArrayUtil.print(array4);


		System.out.println("-------QuickSort6------");
		long start6 = System.currentTimeMillis();
		qs6.sort(array6);
		long stop6 = System.currentTimeMillis();
//		MyArrayUtil.print(array66);

		System.out.println("-------MergeSort------");
		long start7 = System.currentTimeMillis();
		ms.sort(array7);
		long stop7 = System.currentTimeMillis();
//		MyArrayUtil.print(array7);

		System.out.println("-------ParallelMergeSort------");
		long start8 = System.currentTimeMillis();
		pms.sort(array8);
		long stop8 = System.currentTimeMillis();


//		MyArrayUtil.print(array8);
		QuickSort5<MyInteger> qs5 = new QuickSort5<MyInteger>();
		long start9 = System.currentTimeMillis();
		qs5.sort(array9);
		long stop9 = System.currentTimeMillis();
		//MyArrayUtil.print(array9);

		System.out.println("-------QuickMergeSort------");
		long start10 = System.currentTimeMillis();
		qms.sort(array10);
		long stop10 = System.currentTimeMillis();
		MyArrayUtil.print(array10);
		if(!MyArrayUtil.checker(array10)){
			System.out.println("False");
		}


		System.out.println("Normal Quick Sort time   :"+(stop - start));
		System.out.println("Parallel Quick Sort time :"+(stop2 - start2));
		System.out.println("Parallel Quick Sort6 time:"+(stop6 - start6)); //修正
		System.out.println("ArraysSort time          :"+(stop4 - start4)); //修正
		System.out.println("Merge Sort time          :"+(stop7 - start7)); //修正
		System.out.println("ParallelMerge Sort time  :"+(stop8 - start8)); //修正
		System.out.println("forkJoin quickSort time  :"+(stop9 - start9)); //修正
		System.out.println("Quick Merge Sort time  :"+(stop10 - start10)); //修正

	}

}
