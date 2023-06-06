package org.example;


//import com.sun.org.slf4j.internal.Logger;
//import com.sun.org.slf4j.internal.LoggerFactory;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class first {
    public static void main(String[] args) {

        //Logger l = LoggerFactory.getLogger(LoggingExample.class);
        //Set Producer Properties
        String bootserver="localhost:9092";
        Properties proper=new Properties();
        proper.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootserver);
        proper.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        proper.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
        //Crete producer
        KafkaProducer<String,String>first_producer =new KafkaProducer<String, String>(proper);
        //create producer record
        ProducerRecord<String,String>record=new ProducerRecord<String,String>("java_first","hye kafka in java");
        //Send data to kafka
        //ffirst_producer.send(record);
        first_producer.send(record, new Callback() {
            @Override
            public void onCompletion(RecordMetadata metadata, Exception exception) {
                //Logger logger= LoggerFactory.getLogger(first.class);
                if(exception==null){
                      System.out.println("send succesfully");
                }
                else{
                    System.out.println("not send right");
                }

            }
        });
        first_producer.flush();
        first_producer.close();


    }
}
