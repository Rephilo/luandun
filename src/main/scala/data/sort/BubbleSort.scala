package data.sort

import scala.annotation.tailrec

object BubbleSort {

  /**
    * @param list 待排序列表
    * @tparam A 列表元素类型
    * @return
    */
  def bubbleSort[A](list: List[A])(implicit a: A => Ordered[A]): List[A] = {
    /**
      * @param unSorteds   每一趟冒泡时待排序列表
      * @param remains     已遍历且未冒出的元素列表
      * @param accOrdereds 已冒出的元素组成的有序列表(是累积的)
      * @return 每一趟冒泡后排好序的列表
      */
    @tailrec
    def bubble(unSorteds: List[A], remains: List[A], accOrdereds: List[A]): List[A] = unSorteds match {
      case h1 :: h2 :: t =>
        if (h1 > h2)
          bubble(h1 :: t, h2 :: remains, accOrdereds)
        else
          bubble(h2 :: t, h1 :: remains, accOrdereds)
      case h1 :: Nil =>
        if (remains.isEmpty)
          h1 :: accOrdereds
        else
          bubble(remains, Nil, h1 :: accOrdereds)
    }

    bubble(list, Nil, Nil)
  }

  def main(args: Array[String]): Unit = {
    val list = List(1, 13, 7, 5, 8, 9, 20, 43, 11, 8)
    println(bubbleSort(list))
  }
}

