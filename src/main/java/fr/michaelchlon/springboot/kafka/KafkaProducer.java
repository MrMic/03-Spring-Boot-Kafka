package fr.michaelchlon.springboot.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
  private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);
  private KafkaTemplate<String, String> kafkaTemplate;

  // * INFO: ╾╼ CONSTRUCTOR ╾───────────────────────────────────────────────────╼
  public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  // ______________________________________________________________________
  public void sendMessage(String message) {
    LOGGER.info(String.format("#### -> Message sent -> %s", message));
    kafkaTemplate.send("java_guides", message);
  }

}
