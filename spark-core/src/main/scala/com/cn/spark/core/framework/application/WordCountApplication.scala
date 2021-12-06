package com.cn.spark.core.framework.application

import com.cn.spark.core.framework.common.TApplication
import com.cn.spark.core.framework.controller.WordCountController

object WordCountApplication extends App with TApplication{

  // 启动应用程序
  start(){
    val controller = new WordCountController()
    controller.dispatch()
  }

}
