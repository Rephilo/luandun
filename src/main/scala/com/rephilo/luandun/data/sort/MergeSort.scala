package com.rephilo.luandun.data.sort

object MergeSort {
  def mergeSort[A](list: List[A])(implicit element: A => Ordered[A]): List[A] = {
    /**
      * @param p 待排序的包含两个列表的元组
      * @return
      */
    def sort(p: (List[A], List[A])): List[A] = {
      p match {
        case (Nil, Nil) => Nil
        case (a :: Nil, Nil) => a :: Nil
        case (Nil, a :: Nil) => a :: Nil
        case (as, bs) => merge(splitIn2AndSort(as), splitIn2AndSort(bs))
      }
    }

    /**
      * 将给定列表划分为两个列表，并归并排序返回一个有序列表
      *
      * @param as 待划分列表
      * @return
      */
    def splitIn2AndSort(as: List[A]): List[A] = sort(splitIn2(as))

    /**
      * 合并两个有序列表
      *
      * @param as 有序列表
      * @param bs 有序列表
      * @return 合并后的有序列表
      */
    def merge(as: List[A], bs: List[A]): List[A] = {
      def loop(cs: List[A], ds: List[A], accSorteds: List[A]): List[A] = (cs, ds) match {
        case (Nil, Nil) => accSorteds
        case (hc :: tc, hd :: td) =>
          if (hc < hd)
            loop(tc, ds, hc :: accSorteds)
          else
            loop(td, cs, hd :: accSorteds)
        case (hc :: tc, Nil) => loop(tc, Nil, hc :: accSorteds)
        case (Nil, hd :: td) => loop(Nil, td, hd :: accSorteds)
      }

      loop(as, bs, Nil).reverse
    }

    def splitIn2(as: List[A]): (List[A], List[A]) = {
      val mid = as.length / 2
      (as.slice(0, mid), as.slice(mid, as.length))
    }

    splitIn2AndSort(list)
  }
}
