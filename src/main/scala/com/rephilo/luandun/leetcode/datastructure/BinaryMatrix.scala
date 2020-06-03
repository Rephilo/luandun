package com.rephilo.luandun.leetcode.datastructure

abstract class BinaryMatrix {
  def get(x: Int, y: Int): Int

  def dimensions(): Array[Int]
}
