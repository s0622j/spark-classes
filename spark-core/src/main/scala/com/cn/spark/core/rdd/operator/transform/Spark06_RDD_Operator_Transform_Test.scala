package com.cn.spark.core.rdd.operator.transform

import java.text.SimpleDateFormat
import java.util.Date

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark06_RDD_Operator_Transform_Test {
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(sparkConf)

    // TODO 算子 - groupBy
    val rdd: RDD[String] = sc.textFile("data/apache.log")

    val timeRDD: RDD[(String, Iterable[(String, Int)])] = rdd.map(
      line => {
        val datas: Array[String] = line.split(" ")
        val time: String = datas(3)
        //time.substring(0,)
        val sdf: SimpleDateFormat = new SimpleDateFormat("dd/MM/yyyy:HH:mm:ss")
        val data: Date = sdf.parse(time)
        val sdf1: SimpleDateFormat = new SimpleDateFormat("HH")
        val hour: String = sdf1.format(data)
        (hour, 1)
      }
    ).groupBy(_._1)
//    timeRDD.collect().foreach(println)
//    timeRDD.map(t => (t._1,t._2.size))

    timeRDD.map{
      case (hour,iter) => {
        (hour,iter.size)
      }
    }.collect().foreach(println)

    sc.stop()
  }
}
