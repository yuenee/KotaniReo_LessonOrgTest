package com.example.demo.mentor.q02_bmi;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;

// homeの入力値に対応するModel

@Data
public class BmiFormModel {
	// 身長
	@NotNull
	@Min(1)
	private double height;

	// 体重
	@NotNull
	@Min(1)
	private double weight;

}
