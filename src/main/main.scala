import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord, RecordMetadata}

import java.util.Properties

object Main {
  def main(args: Array[String]): Unit = {

    val brokeurl = "localhost:9092"
    val props: Properties = new Properties();
    props.setProperty("bootstrap.servers",brokeurl)
    props.setProperty("key.serializer","org.apache.kafka.common.serialization.StringSerializer")
    props.setProperty("value.serializer","org.apache.kafka.common.serialization.StringSerializer")
    val producer:KafkaProducer[String,String] = new KafkaProducer[String,String](props)

    for(i<-0 until 1000){
      producer.send(new ProducerRecord[String,String]("c", s"testkey$i", s"testvalue$i"),
        (m:RecordMetadata, e:Exception) =>{
          if(e!=null){
            println("Exception")
          }else{
            println("Successfully sent")
          }

        });
    }
  }
}