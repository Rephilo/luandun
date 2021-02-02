package com.rephilo.luandun.scala.leetcode.explore.arrays._977

object Solution {
  def sortedSquares(A: Array[Int]): Array[Int] = {
    A.map(x => x * x).sorted
  }
}
