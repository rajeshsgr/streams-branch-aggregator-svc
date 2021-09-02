package com.raj.nola.streams.services;

import com.raj.nola.streams.binding.SalesAggregatorListenerBinding;
import com.raj.nola.streams.model.salesAggregate.SalesAggregate;
import com.raj.nola.streams.model.salesRecord.Payload;
import com.raj.nola.streams.model.salesRecord.SalesRecord;
import io.confluent.shaded.com.google.gson.Gson;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.Grouped;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;

@Service
@EnableBinding(SalesAggregatorListenerBinding.class)
public class SalesAggregatorListenerService {

    @Autowired
    SalesAggregate salesAggregate;

    @StreamListener("sales-input-channel-1")
    public void salesProcess(KStream<String, String> input) {

        System.out.println("Sales Aggregator ListenerService Starts... ");


        Gson gson = new Gson();


        KStream<String, Payload> KS1 = input.mapValues(v -> gson.fromJson(v, SalesRecord.class).getPayload());

        KS1.map((k,v) -> new KeyValue<>(v.getCategory(), v.getPrice()))
                .groupByKey(Grouped.with(Serdes.String(), Serdes.Double()))
                .reduce(Double::sum)
                .toStream()
                .foreach((k,v) -> {
                    System.out.println(" Key --" + k + "Value-- " + v);
                });

       /* KS1.groupBy((k,v)->v.getCategory())
                .aggregate(
                        ()->salesAggregate.init(),
                        (k, v,aggV) -> salesAggregate.aggregate(v,aggV)

                )
                .toStream().groupByKey()
                 .foreach((k,v) -> {
                 System.out.println(" Key --" + k + "Value-- " + v.toString());
        });*/

        /*KS1.peek((k, v) -> {


            System.out.println(" Key --" + k + "Value-- " + v);

        });*/


    }

}
