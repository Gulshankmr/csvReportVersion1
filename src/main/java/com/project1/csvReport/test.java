package com.project1.csvReport;
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
		    int n=sc.nextInt();
		    do{
		        System.out.print(n+" ");
		        if(n%2==0){
		            n = (int) Math.pow(n,0.5);
		        }
		        else{
		            n=(int) Math.pow(n,1.5);
		        }
		    }while(n!=1);
		}
	}
}