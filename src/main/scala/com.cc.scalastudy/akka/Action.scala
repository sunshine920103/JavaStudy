package com.cc.scalastudy.akka

/**
  * @author ：cc
  * @date ：created in 2020/4/16 09:46
  * @description ：定义消息
  * @modified By：
  * @version: $version$
  */
trait Action {
  val message: String
  val time: Int

}

case class TurnOnLight(time: Int) extends Action { //开灯消息
  override val message: String = "turn on the living root light"
}

case class BoilWater(time: Int) extends Action { //烧水消息
  override val message: String = "burn a pot of water"
}
