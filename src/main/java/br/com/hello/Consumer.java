package br.com.hello;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(mappedName = "java:/jms/queue/myqueue", activationConfig = {
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "testQueue") })
public class Consumer implements MessageListener {

	public void onMessage(Message message) {

		TextMessage textMessage = (TextMessage) message;
		try {
			System.out.println("Message Received:"
					+ textMessage.getJMSTimestamp());
		} catch (JMSException e) {
			e.printStackTrace();
		}

	}
}