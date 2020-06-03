package com.rephilo.luandun.leetcode._20200421

import .BinaryMatrix

import scala.annotation.tailrec

object Solution {
  /**
    * 2020 April 21st
    *
    * @param binaryMatrix
    * @return
    */
  def leftMostColumnWithOne(binaryMatrix: BinaryMatrix): Int = {
    if (binaryMatrix == null || binaryMatrix.dimensions().isEmpty) {
      return -1
    }

    val row = binaryMatrix.dimensions()(0)
    val col = binaryMatrix.dimensions()(1)

    @tailrec
    def findLeftMost(currRow: Int, currCol: Int, result: Int, binaryMatrix: BinaryMatrix): Int = {
      if (currCol < 0 || currRow >= row || result == 0) {
        return result
      }

      if (binaryMatrix.get(currRow, currCol) == 0) {
        findLeftMost(currRow + 1, currCol, result, binaryMatrix)
      } else {
        findLeftMost(currRow, currCol - 1, currCol, binaryMatrix)
      }
    }

    findLeftMost(0, col - 1, -1, binaryMatrix)
  }
}
