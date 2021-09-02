package com.raj.nola.streams.services;

import com.raj.nola.streams.binding.KafkaListenerBinding;
import com.raj.nola.streams.model.salesRecord.Payload;
import com.raj.nola.streams.model.salesRecord.SalesRecord;
import io.confluent.shaded.com.google.gson.Gson;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Predicate;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@EnableBinding(KafkaListenerBinding.class)
public class KafkaListenerService {


    @StreamListener("input-channel-1")
   // @SendTo("premium-customer-channel")
    @SendTo({"premium-customer-channel", "non-premium-customer-channel","blocked-customer-channel"})

    public KStream<String, Payload>[] process(KStream<String, String> input) {

        System.out.println("Kafka Listener Service... ");

        Gson gson = new Gson();

       /*
       KStream<String, Payload> KS1 = input.mapValues(v -> gson.fromJson(v, SalesRecord.class).getPayload()).
                filter((key, value) -> value.getCategory().equalsIgnoreCase("Platinum") && value.getPaymentStatus()!="Blocked");
        */

        KStream<String, Payload> KS1 = input.mapValues(v -> gson.fromJson(v, SalesRecord.class).getPayload());

     /*   KS1.foreach((k, v) -> {

            System.out.println("--"+v+"\n");

        });*/


        Predicate<String, Payload> premiumOrders = (k, v) ->( (v.getCategory().equalsIgnoreCase("Platinum")) && !(v.getPaymentStatus().equalsIgnoreCase("Blocked")));
        Predicate<String, Payload> nonPremiumOrders = (k, v) ->( !(v.getCategory().equalsIgnoreCase("Platinum")) && !(v.getPaymentStatus().equalsIgnoreCase("Blocked")));
        Predicate<String, Payload> blockedOrders =(k,v) -> (v.getPaymentStatus().equalsIgnoreCase("Blocked"));


        System.out.println("Kafka Listener Service Ends... ");


        return KS1.branch(premiumOrders,nonPremiumOrders,blockedOrders);




       /* KStream<String, Payload> [] branches =input.mapValues(v -> gson.fromJson(v, SalesRecord.class).getPayload()).
                branch(
                        (k,v) -> v.getCategory().equalsIgnoreCase("Platinum") && v.getPaymentStatus()!="Blocked",
                        (k,v) -> v.getCategory().equalsIgnoreCase("!=Platinum") && v.getPaymentStatus()!="Blocked",
                        (k,v) -> v.getPaymentStatus().equalsIgnoreCase("Blocked") );



        branches[0].to("premium-cus-sales-topic");
        branches[1].to("non-premium-cus-sales-topic");
        branches[2].to("blocked-sales-topic");
        */





       // return KS1;


    }


}
