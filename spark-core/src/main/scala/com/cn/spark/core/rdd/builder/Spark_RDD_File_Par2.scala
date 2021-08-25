package com.cn.spark.core.rdd.builder

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark_RDD_File_Par2 {
  def main(args: Array[String]): Unit = {
    //    todo 准备环境
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("RDD")
    val sc = new SparkContext(sparkConf)

    //    todo 创建RDD

    // 14byte / 2 = 7byte
    // 14 / 7 = 2(分区)
    /*
    1234567@@ => 012345678
    89@@      => 9 10 11 12
    0         => 13

    [0,7]   => 1234567
    [7,14]  => 890
     */

    // 如果数据源为多个文件，那么计算分区时以文件为单位是进行分区
    val rdd: RDD[String] = sc.textFile("data/word.txt",2)

    rdd.saveAsTextFile("output")

    //    todo 关闭环境
    sc.stop()
  }
}
