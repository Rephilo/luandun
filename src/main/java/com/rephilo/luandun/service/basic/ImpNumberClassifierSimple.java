package com.rephilo.luandun.service.basic;

import java.util.stream.IntStream;

/**
 * @Author:HuoYaJing
 * @Description:完美数分类（该数的所有正约数之和等于其本身，比如6 约数有1，2，3；1+2+3=6；6为一个完美数）
 * 过剩数：正约数之和>数本身
 * 不足数：真约数之和<数本身
 * @Date: Create in 11:04 AM 2018/12/13
 */
public class ImpNumberClassifierSimple {
	public static IntStream factorsOf(int number) {
		return IntStream.range(1, number + 1).filter(potential -> number % potential == 0);
	}

	public static int aliquotSum(int number) {
		return factorsOf(number).sum() - number;
	}

	public static boolean isPerfect(int number) {
		return aliquotSum(number) == number;
	}

	public static boolean isAbundat(int number) {
		return aliquotSum(number) > number;
	}

	public static boolean isDeficient(int number) {
		return aliquotSum(number) < number;
	}

	public static void main(String[] args) {
		System.out.println(aliquotSum(9));
	}

}
