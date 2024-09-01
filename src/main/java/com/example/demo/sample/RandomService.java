package com.example.demo.sample;

import java.util.Random;

public class RandomService {
	public int getNumber(){
		
		Random random = new Random();
		
		 int number = random.nextInt(3);
		
		return number;
		
	}
}
