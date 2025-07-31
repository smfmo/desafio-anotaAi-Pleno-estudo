package io.github.smfmo.desafio_anota_ai.service.aws;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AwsSnsService {

    AmazonSNS snsClient;
    Topic catalogTopic;

    @Autowired
    public AwsSnsService(AmazonSNS snsClient,
                         @Qualifier("catalogEventsTopic")Topic catalogTopic) {
        this.snsClient = snsClient;
        this.catalogTopic = catalogTopic;
    }

    public void publish(MessageDto message){
        snsClient.publish(catalogTopic.getTopicArn(), message.toString());
    }
}
