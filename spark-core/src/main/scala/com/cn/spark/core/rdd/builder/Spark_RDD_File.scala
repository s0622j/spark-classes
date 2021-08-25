package com.cn.spark.core.rdd.builder

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark_RDD_File {
  def main(args: Array[String]): Unit = {
    //    todo 准备环境
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("RDD")
    val sc = new SparkContext(sparkConf)

    //    todo 创建RDD
    //    从文件中创建RDD,将文件中的数据作为处理的数据源
    //    path路径默认以当前环境的根路径为基准。可以写绝对路径，也可以写相对路径
    //    sc.textFile("D:\\idea_workspase\\spark-classes\\data\\1.txt")

    //    val rdd: RDD[String] = sc.textFile("data/1.txt")
    //    path路径可以是文件的具体路径,也可以是目录名称
    //    val rdd: RDD[String] = sc.textFile("data")
    //    path路径还可以使用通配符*
    //    val rdd = sc.textFile("data/1*.txt")
    //    path还可以是分布式存储系统路径:HDFS
    val rdd = sc.textFile("hdfs://linux1:8020/test.txt")
    rdd.collect().foreach(println)
    //    todo 关闭环境
    sc.stop()
  }
}
