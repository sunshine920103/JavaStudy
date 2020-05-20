package com.cc.dataStruct.scala

import scala.util.control.Breaks.{break, breakable}

/**
  * @author ：cc
  * @date ：created in 2020/5/18 14:45
  * @description ：$ {description}
  * @modified By：
  * @version: $version$
  */
class Sorts() {
  def bubbleSort(array: Array[Int]): Array[Int] = {
    breakable {
      for (i <- array.indices) {
        var flag = false //没有交换
        for (j <- 0 until array.length - 1 - i) {
          if (array(j) > array(j + 1)) {
            var temp = array(j)
            array(j) = array(j + 1)
            array(j + 1) = temp
            flag = true
          }
        }
        if (!flag) break

      }
    }
    array
  }

  def insertSort(array: Array[Int]): Array[Int] = {
    for (i <- 1 until array.length) {
      val value = array(i)
      var insert = i
      breakable {
        for (j <- i - 1 to 0 by -1) {
          if (array(j) > value) {
            array(j + 1) = array(j)
            insert = j
          } else {
            break
          }
        }
      }

      if (insert != i) array(insert) = value
    }
    array
  }

  def selectSort(array: Array[Int]): Array[Int] = {
    for (i <- 0 until array.length - 1) {
      var min = i
      for (j <- i + 1 until array.length) {
        if (array(min) > array(j)) {
          min = j
        }
      }
      if (min != i) {
        var temp = array(i)
        array(i) = array(min)
        array(min) = temp
      }
    }
    array
  }


}

object testSorts {
  def main(args: Array[String]): Unit = {
    val a = Array(4, 5, 1, 6, 7, 2)
    //    println(new Sorts().bubbleSort(a).mkString(","))
    //println(new Sorts().insertSort(a).mkString(","))
    println(new Sorts().selectSort(a).mkString(","))


  }
}
