//package data.sort
//
//import scala.annotation.tailrec
//
//object InsertSort {
//  /**
//    * @param list 待排列表
//    * @tparam A 列表元素类型
//    * @return
//    */
//  def insertionSort[A](list: List[A])(implicit a: A => Ordered[A]): List[A] = {
//    /**
//      * @param unSorteds   待排列表
//      * @param accOrdereds 累积有序列表
//      * @return 有序列表
//      */
//    @tailrec
//    def sort(unSorteds: List[A], accOrdereds: List[A]): List[A] = unSorteds match {
//      case ha :: ta => sort(ta, insert(ha, accOrdereds))
//      case Nil => accOrdereds
//    }
//
//    /**
//      * @param a           待插入元素
//      * @param accOrdereds 累积有序列表
//      * @return
//      */
//    def insert(a: A, accOrdereds: List[A]): List[A] = accOrdereds match {
//      case h :: t if a > h => h :: insert(a, t)
//      case _ => a :: accOrdereds
//    }
//
//
//    sort(list, Nil)
//  }
//}
