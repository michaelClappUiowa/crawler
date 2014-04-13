package hubs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		String writePath = "anserHubsAll.txt";//outPut file path
		String readPath = "testHubsAll.txt";// input file path
//		Big big = new Big(writePath , readPath);
//		big.doWork();
		small Small = new small(writePath , readPath);
		Small.doWork();
}}