package com.rephilo.luandun.data.sort

import scala.annotation.tailrec

object SelectSort {
  def selectionSort[A](list: List[A])(implicit a: A => Ordered[A]): List[A] = {
    /**
      * @param unSorteds  未排序列表
      * @param accSorteds 累积最终的有序列表
      * @return
      */
    def sort(unSorteds: List[A], accSorteds: List[A]): List[A] =
      unSorteds match {
        case h :: t => select(unSorteds, Nil, accSorteds)
        case Nil => accSorteds
      }

    /**
      *
      * @param unSorteds  未排序列表
      * @param sorteds    选择出的元素组成的有序列表
      * @param accSorteds 累积最终的有序列表
      * @return
      */
    @tailrec
    def select(unSorteds: List[A], sorteds: List[A], accSorteds: List[A]): List[A] =
      unSorteds match {
        case h1 :: h2 :: t =>
          if (h1 < h2)
            select(h2 :: t, h1 :: sorteds, accSorteds)
          else
            select(h1 :: t, h2 :: sorteds, accSorteds)
        case h :: Nil => sort(sorteds, h :: accSorteds)
        case Nil => sort(sorteds, accSorteds)
      }

    sort(list, Nil)
  }
}
