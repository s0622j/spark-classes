package com.cn.spark.core.rdd.builder

import org.apache.spark.{SparkConf, SparkContext}

object Spark_RDD_File1 {
  def main(args: Array[String]): Unit = {
    //    todo 准备环境
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("RDD")
    val sc = new SparkContext(sparkConf)

    //    todo 创建RDD
    //    从文件中创建RDD,将文件中的数据作为处理的数据源

//    TextFiles: 以行为单位读取数据，读取的数据都是字符串
//    wholeTextFiles: 以文件为单位读取数据
//    读取的结果表示为元组，第一个元素表示文件路径，第二个元素表示文件内容
    val rdd = sc.wholeTextFiles("data")

    rdd.collect().foreach(println)
    //    todo 关闭环境
    sc.stop()
  }
}
