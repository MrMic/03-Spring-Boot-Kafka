package fr.michaelchlon.springboot.kafka;

import fr.michaelchlon.springboot.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {
  private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

  @KafkaListener(
      topics = "${spring.kafka.topic-json.name}",
      groupId = "${spring.kafka.consumer.group-id}")
  public void consume(User user) {
    LOGGER.info(String.format("#### <- USER Message received: %s", user.toString()));
  }
}
