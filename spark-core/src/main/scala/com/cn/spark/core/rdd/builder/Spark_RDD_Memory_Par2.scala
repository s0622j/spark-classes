package com.cn.spark.core.rdd.builder

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark_RDD_Memory_Par2 {
  def main(args: Array[String]): Unit = {
    //    todo 准备环境
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("RDD")
    val sc = new SparkContext(sparkConf)

    //    todo 创建RDD
    // [1,2],[3,4]
    //    val rdd: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4), 2) //Ctrl+H 显示类层级
    // [1],[2],[3,4]
    //    val rdd: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4), 3)
    // [1],[2,3],[4,5]
    val rdd: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4, 5), 3)

    // 将处理的数据保存成分区文件
    rdd.saveAsTextFile("output")

    //    todo 关闭环境
    sc.stop()
  }
}
