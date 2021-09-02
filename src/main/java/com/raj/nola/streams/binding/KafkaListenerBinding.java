package com.raj.nola.streams.binding;

import com.raj.nola.streams.model.salesRecord.Payload;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;

public interface KafkaListenerBinding {

    @Input("input-channel-1")
    KStream<String, String> inputStream();

    @Output("premium-customer-channel")
    KStream<String, Payload> premiumCustomerStream();

    @Output("non-premium-customer-channel")
    KStream<String, Payload> nonPremiumCustomerStream();

    @Output("blocked-customer-channel")
    KStream<String, Payload> blockedCustomerStream();
}