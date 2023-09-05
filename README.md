<h1 align="center">Analyzing Real-time User Sentiments during E-commerce Website Navigation 📊</h1>

<p align="center">
  <img src="https://i.ibb.co/VBkzZKk/Screenshot-2023-09-05-143507.png" alt="Screenshot-2023-09-05-143507" border="0" />
</p>

<p align="center">🛒 Explore real-time user sentiments and insights during e-commerce website navigation!</p>

<p align="center">
  <a href="#demo">Demo</a> •
  <a href="#overview">Overview</a> •
  <a href="#features">Features</a> •
  <a href="#how-to">How To</a> •
  <a href="#technologies">Technologies</a> •
  <a href="#contact">Contact</a>
</p>

## Demo
- Add a link to your demo video here.

## Overview
The "Analyzing Real-time User Sentiments during E-commerce Website Navigation" project is a real-time analytics solution designed to gain insights into user sentiments as they navigate through an e-commerce website. By monitoring and analyzing user interactions, this project helps e-commerce businesses make data-driven decisions to enhance user experience and drive sales.

## Features
- **Real-time Sentiment Analysis**: Analyze user sentiments in real-time based on their interactions with the website.
- **User Behavior Tracking**: Monitor user interactions such as clicks, searches, and product views.
- **Sentiment Visualization**: Visualize sentiment trends and user behavior for better decision-making.
- **Alerts and Notifications**: Receive alerts for critical sentiment changes or user behavior anomalies.

## How To
To run this project, you'll need the following technologies:

- Spark Streaming
- Kafka
- Cassandra

### Version Information
- Spark: spark-2.1.1-bin-hadoop2.7
- Apache Cassandra: apache-cassandra-3.9
- Kafka: kafka_2.11-0.9.0.0

### Setting up the Environment
1. Start Kafka:
   - Zookeeper: `bin/zookeeper-server-start.sh config/zookeeper.properties`
   - Kafka: `bin/kafka-server-start.sh config/server.properties`

2. Create a Kafka topic:
- `bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic mytopic` 

3. Start a Kafka producer to send data:
- `bin/kafka-console-producer.sh --broker-list localhost:9092 --topic mytopic`

4. Start a Kafka consumer to receive data:
- `bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic mytopic --from-beginning`

5. Start Spark:
- `sbin/start-all.sh`

6. Start Cassandra:
- `bin/cassandra -f`

7. Create a Cassandra keyspace and table:
`
CREATE KEYSPACE sparkdata WITH REPLICATION = {'class':'SimpleStrategy','replication_factor':1};
USE sparkdata;
CREATE TABLE cust_data (
  fname TEXT,
  lname TEXT,
  url TEXT,
  product TEXT,
  cnt COUNTER,
  PRIMARY KEY (fname, lname, url, product)
);`


### Spark Kafka Cassandra Streaming Code

Start the Spark Shell with the following command:
- `bin/spark-shell --packages "com.datastax.spark:spark-cassandra-connector_2.11:2.0.2","org.apache.spark:spark-streaming-kafka-0-8_2.11:2.0.0`

- Run your Spark Streaming code within the Spark Shell.

### Technologies
- Apache Spark
- Apache Kafka
- Apache Cassandra


### Contact
For further details and inquiries about the project, please contact:

[Ahmed Laaziz] (mailto:laazizahmed72@gmail.com) - LinkedIn
<p align="center">⭐ Don't forget to star this repository if you find it helpful! ⭐</p>
