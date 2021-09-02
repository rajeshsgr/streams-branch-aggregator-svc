package com.raj.nola.streams.binding;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;

public interface SalesAggregatorListenerBinding {

    @Input("sales-input-channel-1")
    KStream<String, String> salesInputStream();
}
