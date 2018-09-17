package com.kailynwilliams;

public class Main {

    public static void main(String[] args) {

        int []intArray= {12,-23,5,8,3,-1};
        sort(intArray, 0,intArray.length);

        for(int i=0; i<intArray.length;i++ ){
            System.out.println(intArray[i]);
        }
    }
    public static void sort(int[]array, int start, int end){
        if((end-start)<2){
            return;
        }
        int mid= (end+start)/2;

        sort(array,start,mid); // Left side of array
        sort(array,mid,end);// Right side of array
        merge(array,start,mid,end);//Merge rest of array

    }
    public static void merge(int[]array, int start, int mid, int end){
        if(array[mid-1]<=array[mid]){
            return;
        }
        int i=start;
        int j= mid;
        int temp=0;
        int []tempArr= new int[end-start];
        while(i<mid && j<end) {

            if (array[i] <= array[j]) {
                tempArr[temp] = array[i];
                i++;
                temp++;
            } else {
                tempArr[temp] = array[j];
                j++;
                temp++;
            }
        }
        int afterArray= temp+start;

        System.arraycopy(array,i,array,afterArray,mid-i);
        System.arraycopy(tempArr,0,array,start,temp);// Copy elements that got merged

    }
}
