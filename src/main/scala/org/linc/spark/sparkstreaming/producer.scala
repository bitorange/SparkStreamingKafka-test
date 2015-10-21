package org.linc.spark.sparkstreaming

/**
 * Created by orange on 2015/9/17.
 */

import java.util.Properties
import scala.util.Properties
import org.codehaus.jettison.json.JSONObject
import kafka.javaapi.producer.Producer
import kafka.producer.KeyedMessage
import kafka.producer.KeyedMessage
import kafka.producer.ProducerConfig
import scala.util.Random

object KafkaProducer {

  private val users = Array(
    "111", "112",
    "113", "114",
    "115", "116",
    "117", "118",
    "119", "120")

  private val random = new Random()

  private var pointer = -1

  def getUserID() : String = {
    pointer = pointer + 1
    if(pointer >= users.length) {
      pointer = 0
      users(pointer)
    } else {
      users(pointer)
    }
  }

  def click() : Double = {
    random.nextInt(10)
  }

  // bin/kafka-topics.sh --zookeeper zk1:2181,zk2:2181,zk3:2181/kafka --create --topic user_events --replication-factor 2 --partitions 2
  // bin/kafka-topics.sh --zookeeper zk1:2181,zk2:2181,zk3:2181/kafka --list
  // bin/kafka-topics.sh --zookeeper zk1:2181,zk2:2181,zk3:2181/kafka --describe user_events
  // bin/kafka-console-consumer.sh --zookeeper zk1:2181,zk2:2181,zk3:22181/kafka --topic test_json_basis_event --from-beginning
  def main(args: Array[String]): Unit = {
    val topic = "wucheng"
    val brokers = "10.4.21.221:9090"//,10.4.21.223:9093,10.4.21.224:9094
    val props = new Properties()
    props.put("metadata.broker.list", brokers)
    props.put("serializer.class", "kafka.serializer.StringEncoder")

    // System.out.println("asdljlsadj");
    val kafkaConfig = new ProducerConfig(props)
    val producer = new Producer[String, String](kafkaConfig)

    while(true) {
      // prepare event data
      val event = new JSONObject()
      event
        .put("p_id", getUserID)
        .put("num", click)
        .put("p_time", System.currentTimeMillis.toString)
        .put("longitude", click)
        .put("latitude", click)

      // produce event message
      producer.send(new KeyedMessage[String, String](topic, event.toString))
      println("Message sent: " + event)

      Thread.sleep(200)
    }
  }
}

