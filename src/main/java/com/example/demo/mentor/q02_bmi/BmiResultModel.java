package com.example.demo.mentor.q02_bmi;

import lombok.Data;

//BMI計算結果格納用Model

@Data
public class BmiResultModel {

	private double height;

	private double weight;

	private double bmi;

	private String obesity;

}
