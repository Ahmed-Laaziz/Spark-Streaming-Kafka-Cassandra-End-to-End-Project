// Import necessary libraries and packages
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext._
import org.apache.spark.streaming._
import org.apache.spark.streaming.StreamingContext._
import org.apache.spark.streaming.kafka._
import com.datastax.spark.connector.SomeColumns
import com.datastax.spark.connector.cql.CassandraConnector
import com.datastax.spark.connector.streaming._

// Create a SparkConf with an application name and Cassandra host configuration
val sparkConf = new SparkConf().setAppName("KafkaSparkStreaming").set("spark.cassandra.connection.host", "127.0.0.1")

// Create a StreamingContext with the SparkConf and a batch interval of 20 seconds
val ssc = new StreamingContext(sparkConf, Seconds(20))

// Define the Kafka topic(s) and their respective partition counts
val topicpMap = "mytopic".split(",").map((_, 1.toInt)).toMap

// Create a DStream by consuming data from Kafka using KafkaUtils
val lines = KafkaUtils.createStream(ssc, "localhost:2181", "sparkgroup", topicpMap).map(_._2)

// Print the received lines from Kafka to the console
lines.print()

// Transform the lines and save them to Cassandra
lines.map(line => {
  val arr = line.split(",")
  (arr(0), arr(1), arr(2), arr(3), arr(4))
}).saveToCassandra("sparkdata", "cust_data", SomeColumns("fname", "lname", "url", "product", "cnt"))

// Start the Spark Streaming context
ssc.start()

// Await termination to keep the application running
ssc.awaitTermination
