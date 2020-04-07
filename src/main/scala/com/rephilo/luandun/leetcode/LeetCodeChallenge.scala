package com.rephilo.luandun.leetcode

import scala.annotation.tailrec

/**
  * leetcode April challenge
  *
  * @author wangxiao15
  */
object LeetCodeChallenge {
  /**
    * 136
    * 天秀解法，异或
    *
    * @param nums
    * @return
    */
  def singleNumber(nums: Array[Int]): Int = nums.reduce(_ ^ _)

  /**
    * 202
    * 弗洛伊德循环查找算法
    * 生成一个链表，快指针走两格，慢指针走一格，如果汇合说明是循环，如果快指针先到1则是快乐数
    *
    * @param n
    * @return
    */
  def isHappy(n: Int): Boolean = {
    @scala.annotation.tailrec
    def squareSum(n: Int, sum: Int): Int = {
      n match {
        case 0 => sum
        case _ => squareSum(n / 10, sum + (n % 10) * (n % 10))
      }
    }

    @scala.annotation.tailrec
    def floydCycleFinding(slow: Int, fast: Int): Boolean = {
      fast match {
        case 1 => true
        case _ if fast == slow => false
        case _ => floydCycleFinding(squareSum(slow, 0), squareSum(squareSum(fast, 0), 0))
      }
    }

    floydCycleFinding(n, squareSum(n, 0))
  }
}
