import org.apache.kafka.clients.producer.{Callback, KafkaProducer, ProducerRecord, RecordMetadata}

import java.util.Properties

object KafkaProducerexample {
  def main(args: Array[String]): Unit = {


    val properties: Properties = new Properties();
    properties.setProperty("bootstrap.servers", "localhost:9092")
    properties.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    properties.setProperty("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")


    val producer: KafkaProducer[String, String] = new KafkaProducer[String, String](properties)






    for (i <- 0 until 10000) {
      producer.send(new ProducerRecord[String, String]("myscalatopic", s"i", s"testvalu$i"), (m:RecordMetadata,e:Exception) =>{

          if (e != null) {
            println("Exception")

          }
          else println("Sent SuccesFully"+m.offset() )
      })
    }



  }

}
