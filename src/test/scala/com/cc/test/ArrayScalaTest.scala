package com.cc.test

import com.cc.dataStruct.scala.ArrayScala
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec


/**
  * @author ：cc
  * @date ：created in 2020/5/8 13:57
  * @description ：$ {description}
  * @modified By：
  * @version: $version$
  */
class ArrayScalaTest extends AnyWordSpec with Matchers {

  "find value after insert " in {
    val array = new ArrayScala(10)
    array.insert(0, 1) shouldBe "1"
    array.insert(1, 2) shouldBe "2"
    array.insert(2, 3) shouldBe "3"
    array.insert(3, 4) shouldBe "4"

    array.print shouldBe "1234"

  }

  "not insert value if capacity is full" in {
    val array = new ArrayScala(10)
    for (i <- Range(0, 10))
      array.insert(i, i + 2)
    array.insert(1, 99) shouldBe "array is full"
  }

  "not insert value if index is negative or out of bound" in {
    val array = new ArrayScala(10)
    array.insert(-1, 2) shouldBe "array is out of bounds"
    array.insert(10, 2) shouldBe "array is out of bounds"
  }

  "not find after delete" in {
    val array = new ArrayScala(10)
    array.insert(0, 1) shouldBe "1"
    array.insert(1, 2) shouldBe "2"
    array.insert(2, 3) shouldBe "3"
    array.insert(3, 4) shouldBe "4"
    array.print shouldBe "1234"

    array.insert(2, 5)
    array.print shouldBe "12534"

    array.delete(2)
    array.print shouldBe "1234"

  }

  "not delete for empty array" in {
    val array = new ArrayScala(10)
    assertThrows[IllegalStateException] {
      array.delete(2)
    }
  }


}
