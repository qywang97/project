package com.company.basic.ArrayDemo;

public class ArrayDemo1 {
    public static void main(String[] args) {
        int arr[][] = { {1,2,3},{4,5,6,7},{8,9},{10,11,12,13,14,15,16,17,18,19,20,21,23}};
        int sum = 0;
        for(int i = 0 ; i <arr.length ; i++){//arr.length
            for(int j = 0 ; j<arr[i].length ;j++){//arr[i].length
                System.out.println(arr[i][j]+"    ");
                sum = sum + arr[i][j];
            }
            System.out.println();
        }
        // 报错下标越界
        System.out.println(arr[3].length);
    }
}
