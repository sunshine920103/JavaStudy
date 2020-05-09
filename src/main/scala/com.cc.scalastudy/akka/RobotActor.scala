package com.cc.scalastudy.akka

import akka.actor.Actor
import akka.event.Logging

/**
  * @author ：cc
  * @date ：created in 2020/4/16 09:51
  * @description ：$ {description}
  * @modified By：
  * @version: $version$
  */
class RobotActor extends Actor {
  val log = Logging(context.system, this)

  override def receive: Receive = { //机器人接受指令
    case t: TurnOnLight => log.info("{} after {} hour", t.message, t.time)
    case b: BoilWater => log.info("{} after {} hour", b.message, b.time)
    case _ => log.info("I can not handle this message")
  }
}
