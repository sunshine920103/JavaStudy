package com.cc.scalastudy.akka

import akka.actor.{ActorSystem, Props}

/**
  * @author ：cc
  * @date ：created in 2020/4/16 10:05
  * @description ：$ {description}
  * @modified By：
  * @version: $version$
  */
object TestRobot extends App {
  val actorSystem = ActorSystem("robot-system")
  val robotActor = actorSystem.actorOf(Props(new RobotActor()), "robotActor") //创建一个机器人
  robotActor ! TurnOnLight(1) //给机器人发送开灯命令
  robotActor ! BoilWater(2) //给机器人发送烧水命令
  robotActor ! "who are you" //给机器人发送任意命令
  actorSystem terminate()

}
