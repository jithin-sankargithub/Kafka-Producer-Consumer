Running Zookeeper 
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
Running kafka server
.\bin\windows\kafka-server-start.bat .\config\server.properties
Creating kafka topic
.\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --create --topic <topic-name> --partitions 3 --replication-factor 1
Creating a producer
.\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic <topic-name>
Creating a consumer
.\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic <topic-name> --from-beginning
