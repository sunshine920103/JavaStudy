package com.cc.dataStruct.scala

/**
  * @author ：cc
  * @date ：created in 2020/5/7 13:50
  * @description ：$ {description}
  * @modified By：
  * @version: $version$
  */
class ArrayScala(capacity: Int) {
  val data: Array[Int] = new Array[Int](capacity)
  var count = 0

  //according to the index ,find the element in the data and returned
  def find(index: Int): Int = {
    if (index < 0 || index >= capacity)
      return -1
    data(index)
  }

  //insert data to the location specified by the index
  def insert(index: Int, value: Int): String = {
    if (count == capacity)
      return "array is full"
    if (index < 0 || index >= capacity)
      return "array is out of bounds"
    for (i <- count until index by -1)
      data(i) = data(i - 1)

    data(index) = value
    count += 1

    return value.toString
  }

  //delete data that specified by the index
  def delete(index: Int): String = {
    if (count == 0)
      throw new IllegalStateException("array is empty")

    if (index < 0 || index >= count)
      return "array is out of bounds"

    for (i <- index until count - 1)
      data(i) = data(i + 1)
    count -= 1
    return "delete success"
  }


  def print: String = {
    val buf = new StringBuilder
    for (i <- 0 until count)
      buf ++= data(i).toString
    buf.toString()
  }

}
