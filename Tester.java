package tester;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

import newSort.*;
import mergeSort.*;
import quickMergeSort.*;
import quickSort.*;
import sort.*;
import tools.*;

public class Tester {
	static Scanner sc;
	static int outCount = 0;
	static File file ;

	final static String[] sortNames = {"QuickSort","QuickSort2","ArraysSort","ParallelQuickSort",
		"ForkJoinQuickSort","MergeSort","ParallelMergeSort","NewSort2",
		"QuickMergeSort","QuickMergeSort3","QuickMergeSort4","QuickMergeSort5","NewSort3","NewSort4"};

	static final int SORTNUM = sortNames.length;
	static long[] start = new long[SORTNUM];
	static long[] stop = new long[SORTNUM];
	public static void main(String args[]) throws InterruptedException {
		sc = new Scanner(System.in);
		//file = new File("C:\\Users\\takuya\\Desktop\\chenLec\\chen_zemi\\GraduationStudy\\test.txt");
		//sortChecer();
		intSorting();
		//pinPointCheak();
		//doubleSorting();
		//stringSorting();
	}

	public static void sortChecer(){
		//int i = 24;



		boolean b = false;
		long start = System.currentTimeMillis();
		for(int j = 0;j < 1;j++){
			for(int i = 99;i < 100;i++)
				if(!intSortingCheck(i)){
					b = true;
					break;
				}
			if(b == true)
				break;
		}

		//intSortingCheck(i);
		long stop = System.currentTimeMillis();
		System.out.println("Finish");
		System.out.println("outCount : "+outCount);
		System.out.println("Time : "+(stop-start));
	}

	public static boolean intSortingCheck(int t){


		int length = t;

		MyInteger[] array = new MyInteger[length];
		//int[] data = ArrayUtil.randomIntArray(array.length); //乱数

		int [] data = ArrayUtil.makeIntArray(array.length);


		for(int i = 0;i < array.length;i++)
			array[i] = new MyInteger(data[i]);




		MyInteger[] array10 = Arrays.copyOf(array,array.length);
		MyInteger[] array11 = Arrays.copyOf(array,array.length);
		MyInteger[] array12 = Arrays.copyOf(array,array.length);
		MyInteger[] array13 = Arrays.copyOf(array,array.length);
		MyInteger[] array14 = Arrays.copyOf(array,array.length);
		MyInteger[] array9 = Arrays.copyOf(array,array.length);

		Sort<MyInteger> qs6 = new ParallelQuickSort<MyInteger>();
		Sort<MyInteger> pms = new ParallelMergeSort<MyInteger>();//修正
		Sort<MyInteger> qms = new QuickMergeSort<MyInteger>();
		Sort<MyInteger> qms_2 = new QuickMergeSort2<MyInteger>();
		Sort<MyInteger> qms3 = new QuickMergeSort3<MyInteger>();
		Sort<MyInteger> qms4 = new QuickMergeSort4<MyInteger>();
		QuickMergeSort5<MyInteger> qms5 = new QuickMergeSort5<MyInteger>();
		Sort<MyInteger> ns = new NewSort<MyInteger>();
		Sort<MyInteger> ns2 = new NewSort2<MyInteger>();
		Sort<MyInteger> ns3 = new NewSort3<MyInteger>();
		Sort<MyInteger> ns4 = new NewSort4<MyInteger>();
		Sort<MyInteger> ns5 = new NewSort5<MyInteger>();



		//		long start11 = System.currentTimeMillis();
		//		qms.sort(array10);
		//		long stop11 = System.currentTimeMillis();

		//		long start10 = System.currentTimeMillis();
				qms_2.sort(array11);
		//		long stop10 = System.currentTimeMillis();



		//MyArrayUtil.print(array12);
		long start12 = System.currentTimeMillis();
		ns5.sort(array12);
		long stop12 = System.currentTimeMillis();
		//MyArrayUtil.print(array12);
		System.out.println("length : "+t);
		long start13 = System.currentTimeMillis();
		qms5.sort(array13);
		long stop13 = System.currentTimeMillis();

		long start14 = System.currentTimeMillis();
		ns4.sort(array14);
		long stop14 = System.currentTimeMillis();

		//QuickSort5<MyInteger> qs5 = new QuickSort5<MyInteger>();
		//		qms3 = new QuickMergeSort3<MyInteger>();
		//		long start9 = System.currentTimeMillis();
		//		qms3.sort(array9);
		//		long stop9 = System.currentTimeMillis();



		//MyArrayUtil.print(array14);
		if(!MyArrayUtil.checker(array14)){

			System.out.println("OUT");
			MyArrayUtil.print(array);
			MyArrayUtil.print(array14);



			outCount++;

			return false;
		}else{
			//System.out.println("OK");
			//MyArrayUtil.print(array14);
		}
		System.out.println();
		System.out.println();
		//System.out.println("start : "+start13+"  stop : "+stop13);
		//System.out.println("start : "+start14+"  stop : "+stop14);
		System.out.println("ns5 time : "+(stop12 - start12));
		System.out.println("ns3 time : "+(stop13 - start13));
		System.out.println("ns4 time : "+(stop14 - start14));

		return true;
		//		System.out.println("Quick Merge Sort_2 time  :"+(stop10 - start10)); //修正
		//		System.out.println("Quick Merge Sort time  :"+(stop11 - start11)); //修正


	}
	private static void doubleSorting() {


		int length  = 10000000;


		MyDouble[] array = new MyDouble[length];
		double[] data2 = MyArrayUtil.randomDoubleArray(array.length);
		for(int i = 0;i < array.length;i++)
			array[i] = new MyDouble(data2[i]);


		MyDouble[][] arrays = new MyDouble[SORTNUM][array.length];
		for(int i = 0; i < SORTNUM;i++){
			arrays[i] = Arrays.copyOf(array,array.length);
		}


		Sort<MyDouble> qs = new QuickSort<MyDouble>();
		Sort<MyDouble> qs2 = new QuickSort2<MyDouble>();
		Sort<MyDouble> pqs = new ParallelQuickSort<MyDouble>();
		ForkJoinQuickSort<MyDouble> fjqs = new ForkJoinQuickSort<MyDouble>();
		Sort<MyDouble> ms = new MergeSort<MyDouble>();
		ParallelMergeSort<MyDouble> pms = new ParallelMergeSort<MyDouble>();
		Sort<MyDouble> ns = new NewSort2<MyDouble>();
		Sort<MyDouble> qms = new QuickMergeSort2<MyDouble>();
		Sort<MyDouble> qms3 = new QuickMergeSort3<MyDouble>();
		Sort<MyDouble> qms4 = new QuickMergeSort4<MyDouble>();
		QuickMergeSort5<MyDouble> qms5 = new QuickMergeSort5<MyDouble>();



		System.out.println(sortNames[0]);
		start[0] = System.currentTimeMillis();
		qs.sort(arrays[0]);
		stop[0] = System.currentTimeMillis();

		System.out.println(sortNames[1]);
		start[1] = System.currentTimeMillis();
		qs2.sort(arrays[1]);
		stop[1] = System.currentTimeMillis();


		System.out.println(sortNames[2]);
		start[2] = System.currentTimeMillis();
		Arrays.sort(arrays[2]);
		stop[2] = System.currentTimeMillis();


		System.out.println(sortNames[3]);
		start[3] = System.currentTimeMillis();
		//pqs.sort(arrays[3]);
		stop[3] = System.currentTimeMillis();

		System.out.println(sortNames[4]);
		start[4] = System.currentTimeMillis();
		fjqs.sort(arrays[4]);
		stop[4] = System.currentTimeMillis();
		//		MyArrayUtil.print(array7);

		System.out.println(sortNames[5]);
		start[5] = System.currentTimeMillis();
		ms.sort(arrays[5]);
		stop[5] = System.currentTimeMillis();


		System.out.println(sortNames[6]);
		start[6] = System.currentTimeMillis();
		//pms.sort(arrays[6]);
		stop[6] = System.currentTimeMillis();

		System.out.println(sortNames[7]);
		start[7] = System.currentTimeMillis();
		//ns.sort(arrays[7]);
		stop[7] = System.currentTimeMillis();

		System.out.println(sortNames[8]);
		start[8] = System.currentTimeMillis();
		qms.sort(arrays[8]);
		stop[8] = System.currentTimeMillis();

		System.out.println(sortNames[9]);
		start[9] = System.currentTimeMillis();
		qms3.sort(arrays[9]);
		stop[9] = System.currentTimeMillis();


		System.out.println(sortNames[10]);
		start[10] = System.currentTimeMillis();
		qms4.sort(arrays[10]);
		stop[10] = System.currentTimeMillis();

		System.out.println(sortNames[11]);
		start[11] = System.currentTimeMillis();
		qms5.sort(arrays[11]);
		stop[11] = System.currentTimeMillis();

		System.out.println();
		System.out.println();
		for(int i = 0;i < SORTNUM;i++){
			if(!MyArrayUtil.checker(arrays[i])){
				System.out.println(sortNames[i]+ " is False");
				//MyArrayUtil.print(arrays[i]);
			}
		}

		System.out.println();
		System.out.println();

		for(int i = 0; i < SORTNUM;i++){
			System.out.println(sortNames[i]+"  times : "+(stop[i] - start[i]));
		}

	}


	public static void intSorting(){

		int length =10000000;  //学校のパソコン用
		//	int length = Integer.MAX_VALUE;

		MyInteger[] array = new MyInteger[length];
		int[] data = ArrayUtil.randomIntArray(array.length); //乱数
		//int[] data = ArrayUtil.myIntArray(array.length);  //手動入力

		//int[] data = ArrayUtil.makeIntArray(array.length);


		for(int i = 0;i < array.length;i++)
			array[i] = new MyInteger(data[i]);

		MyInteger[][] arrays = new MyInteger[SORTNUM][array.length];
		for(int i = 0; i < SORTNUM;i++){
			arrays[i] = Arrays.copyOf(array,array.length);
		}


		Sort<MyInteger> qs = new QuickSort<MyInteger>();
		Sort<MyInteger> qs2 = new QuickSort2<MyInteger>();
		Sort<MyInteger> pqs = new ParallelQuickSort<MyInteger>();
		ForkJoinQuickSort<MyInteger> fjqs = new ForkJoinQuickSort<MyInteger>();
		Sort<MyInteger> ms = new MergeSort<MyInteger>();
		ParallelMergeSort<MyInteger> pms = new ParallelMergeSort<MyInteger>();
		Sort<MyInteger> ns = new NewSort2<MyInteger>();
		Sort<MyInteger> qms = new QuickMergeSort2<MyInteger>();
		Sort<MyInteger> qms3 = new QuickMergeSort3<MyInteger>();
		Sort<MyInteger> qms4 = new QuickMergeSort4<MyInteger>();
		QuickMergeSort5<MyInteger> qms5 = new QuickMergeSort5<MyInteger>();
		Sort<MyInteger> ns3 = new NewSort3<MyInteger>();
		Sort<MyInteger> ns4 = new NewSort4<MyInteger>();
		Sort<MyInteger> ns5 = new NewSort5<MyInteger>();



		System.out.println(sortNames[0]);
		start[0] = System.currentTimeMillis();
		qs.sort(arrays[0]);
		stop[0] = System.currentTimeMillis();

		System.out.println(sortNames[1]);
		start[1] = System.currentTimeMillis();
		qs2.sort(arrays[1]);
		stop[1] = System.currentTimeMillis();


		System.out.println(sortNames[2]);
		start[2] = System.currentTimeMillis();
		//Arrays.sort(arrays[2]);
		stop[2] = System.currentTimeMillis();


		System.out.println(sortNames[3]);
		start[3] = System.currentTimeMillis();
		//pqs.sort(arrays[3]);
		stop[3] = System.currentTimeMillis();

		System.out.println(sortNames[4]);
		start[4] = System.currentTimeMillis();
		fjqs.sort(arrays[4]);
		stop[4] = System.currentTimeMillis();
		//		MyArrayUtil.print(array7);

		System.out.println(sortNames[5]);
		start[5] = System.currentTimeMillis();
		//ms.sort(arrays[5]);
		stop[5] = System.currentTimeMillis();


		System.out.println(sortNames[6]);
		start[6] = System.currentTimeMillis();
		//pms.sort(arrays[6]);
		stop[6] = System.currentTimeMillis();

		System.out.println(sortNames[7]);
		start[7] = System.currentTimeMillis();
		//ns.sort(arrays[7]);
		stop[7] = System.currentTimeMillis();

		System.out.println(sortNames[8]);
		start[8] = System.currentTimeMillis();
		//qms.sort(arrays[8]);
		stop[8] = System.currentTimeMillis();

		System.out.println(sortNames[9]);
		start[9] = System.currentTimeMillis();
		//qms5.sort(arrays[9]);
		stop[9] = System.currentTimeMillis();


		System.out.println(sortNames[10]);
		start[10] = System.currentTimeMillis();
		qms4.sort(arrays[10]);
		stop[10] = System.currentTimeMillis();

		System.out.println(sortNames[11]);
		start[11] = System.currentTimeMillis();
		qms5.sort(arrays[11]);
		stop[11] = System.currentTimeMillis();

		System.out.println(sortNames[12]);
		start[12] = System.currentTimeMillis();
		//ns3.sort(arrays[12]);
		stop[12] = System.currentTimeMillis();

		System.out.println(sortNames[13]);
		start[13] = System.currentTimeMillis();
		//ns4.sort(arrays[13]);
		stop[13] = System.currentTimeMillis();



		System.out.println();
		System.out.println();
		for(int i = 0;i < SORTNUM;i++){
			if(!MyArrayUtil.checker(arrays[i])){
				System.out.println(sortNames[i]+ " is False");
				//MyArrayUtil.print(arrays[i]);
			}
		}

		System.out.println();
		System.out.println();

		for(int i = 0; i < SORTNUM;i++){
			System.out.println(sortNames[i]+"  times : "+(stop[i] - start[i]));
		}


	}



	public static void stringSorting(){


		//System.out.println("Input arrays length");
		//int length = sc.nextInt();
		int length =1000000;  //学校のパソコン用

		MyString[] array = new MyString[length];
		String[] data = MyArrayUtil.randomStringArray(array.length);
		for(int i = 0;i < array.length;i++)
			array[i] = new MyString(data[i]);

		for(int i = 0;i < array.length;i++)
			array[i] = new MyString(data[i]);

		MyString[][] arrays = new MyString[SORTNUM][array.length];
		for(int i = 0; i < SORTNUM;i++){
			arrays[i] = Arrays.copyOf(array,array.length);
		}


		Sort<MyString> qs = new QuickSort<MyString>();
		Sort<MyString> qs2 = new QuickSort2<MyString>();
		Sort<MyString> pqs = new ParallelQuickSort<MyString>();
		ForkJoinQuickSort<MyString> fjqs = new ForkJoinQuickSort<MyString>();
		Sort<MyString> ms = new MergeSort<MyString>();
		ParallelMergeSort<MyString> pms = new ParallelMergeSort<MyString>();
		Sort<MyString> ns = new NewSort4<MyString>();
		Sort<MyString> qms = new QuickMergeSort2<MyString>();
		Sort<MyString> qms3 = new QuickMergeSort3<MyString>();
		Sort<MyString> qms4 = new QuickMergeSort4<MyString>();
		QuickMergeSort5<MyString> qms5 = new QuickMergeSort5<MyString>();



		System.out.println(sortNames[0]);
		start[0] = System.currentTimeMillis();
		qs.sort(arrays[0]);
		stop[0] = System.currentTimeMillis();

		System.out.println(sortNames[1]);
		start[1] = System.currentTimeMillis();
		qs2.sort(arrays[1]);
		stop[1] = System.currentTimeMillis();


		System.out.println(sortNames[2]);
		start[2] = System.currentTimeMillis();
		Arrays.sort(arrays[2]);
		stop[2] = System.currentTimeMillis();


		System.out.println(sortNames[3]);
		start[3] = System.currentTimeMillis();
		pqs.sort(arrays[3]);
		stop[3] = System.currentTimeMillis();

		System.out.println(sortNames[4]);
		start[4] = System.currentTimeMillis();
		fjqs.sort(arrays[4]);
		stop[4] = System.currentTimeMillis();
		//		MyArrayUtil.print(array7);

		System.out.println(sortNames[5]);
		start[5] = System.currentTimeMillis();
		ms.sort(arrays[5]);
		stop[5] = System.currentTimeMillis();


		System.out.println(sortNames[6]);
		start[6] = System.currentTimeMillis();
		pms.sort(arrays[6]);
		stop[6] = System.currentTimeMillis();

		System.out.println(sortNames[7]);
		start[7] = System.currentTimeMillis();
		//ns.sort(arrays[7]);
		stop[7] = System.currentTimeMillis();

		System.out.println(sortNames[8]);
		start[8] = System.currentTimeMillis();
		//qms.sort(arrays[8]);
		stop[8] = System.currentTimeMillis();

		System.out.println(sortNames[9]);
		start[9] = System.currentTimeMillis();
		//qms3.sort(arrays[9]);
		stop[9] = System.currentTimeMillis();


		System.out.println(sortNames[10]);
		start[10] = System.currentTimeMillis();
		//qms4.sort(arrays[10]);
		stop[10] = System.currentTimeMillis();

		System.out.println(sortNames[11]);
		start[11] = System.currentTimeMillis();
		qms5.sort(arrays[11]);
		stop[11] = System.currentTimeMillis();

		System.out.println();
		System.out.println();
		for(int i = 0;i < SORTNUM;i++){
			if(!MyArrayUtil.checker(arrays[i])){
				System.out.println(sortNames[i]+ " is False");
				//MyArrayUtil.print(arrays[i]);
			}
		}

		System.out.println();
		System.out.println();

		for(int i = 0; i < SORTNUM;i++){
			System.out.println(sortNames[i]+"  times : "+(stop[i] - start[i]));
		}
	}
}
