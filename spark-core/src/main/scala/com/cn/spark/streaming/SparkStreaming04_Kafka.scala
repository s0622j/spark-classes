package com.cn.spark.streaming

import org.apache.kafka.clients.consumer.{ConsumerConfig, ConsumerRecord}
import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.InputDStream
import org.apache.spark.streaming.kafka010.{ConsumerStrategies, KafkaUtils, LocationStrategies}
import org.apache.spark.streaming.{Seconds, StreamingContext}

object SparkStreaming04_Kafka {

  /*
  *
  * [root@data101 /soft/kafka]#bin/kafka-topics.sh --list --zookeeper master100:2181
  * [root@data101 /soft/kafka]#bin/kafka-topics.sh --create --zookeeper master100:2181 --replication-factor 3 --partitions 3 --topic atguiguNew
  * [root@data101 /soft/kafka]#bin/kafka-console-producer.sh --broker-list data101:9092 --topic atguiguNew
  *
  * */

  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("SparkStreaming")
    val ssc = new StreamingContext(sparkConf, Seconds(3))

    val kafkaPara: Map[String, Object] = Map[String, Object](
      ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG -> "data101:9092,data102:9092,data103:9092",
      ConsumerConfig.GROUP_ID_CONFIG -> "atguigu",
      "key.deserializer" -> "org.apache.kafka.common.serialization.StringDeserializer",
      "value.deserializer" -> "org.apache.kafka.common.serialization.StringDeserializer"
    )

    val kafkaDataDS: InputDStream[ConsumerRecord[String, String]] = KafkaUtils.createDirectStream[String, String](
      ssc,
      LocationStrategies.PreferConsistent,
      ConsumerStrategies.Subscribe[String, String](Set("atguiguNew"), kafkaPara)
    )
    kafkaDataDS.map(_.value()).print()


    ssc.start()
    ssc.awaitTermination()
  }

}
