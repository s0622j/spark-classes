package com.cn.spark.core.rdd.builder

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark_RDD_File_Par {
  def main(args: Array[String]): Unit = {
    //    todo 准备环境
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("RDD")
    val sc = new SparkContext(sparkConf)

    //    todo 创建RDD
    // textFile可以将文件作为数据处理的数据源,默认可以设定分区
    // minPartitions:最小分区数量
    // math.min(defaultParallelism, 2)
    // val rdd: RDD[String] = sc.textFile("data/1.txt")
    // 不使用默认，可通过第二个参数指定分区数
    // spark读取文件，底层其实使用的就是Hadoop的读取方式
    // 分区数量的计算方式
    // totalSize = 7
    // goalSize = 7 / 2  = 3(byte)

    // 7 / 3  = 2...1  (1.1)  + 1 = 3(分区)
    val rdd: RDD[String] = sc.textFile("data/1.txt",2)

    rdd.saveAsTextFile("output")

    //    todo 关闭环境
    sc.stop()
  }
}
