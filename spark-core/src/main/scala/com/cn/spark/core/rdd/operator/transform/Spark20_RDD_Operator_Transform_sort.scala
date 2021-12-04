package com.cn.spark.core.rdd.operator.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark20_RDD_Operator_Transform_sort {
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(sparkConf)

    // TODO 算子 - (Key - Value类型)

    val rdd = sc.makeRDD(List(("a",1),("b",2),("c",3)))
//    val sortRDD1: RDD[(String, Int)] = rdd.sortByKey(true)
    val sortRDD1: RDD[(String, Int)] = rdd.sortByKey(false)
    sortRDD1.collect().foreach(println)



    sc.stop()
  }
}
