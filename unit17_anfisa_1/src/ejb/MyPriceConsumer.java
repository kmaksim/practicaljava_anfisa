package ejb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Message-Driven Bean implementation class for: MyPriceConsumer
 */

@MessageDriven(mappedName="MyJMSTestQueue", activationConfig =  {
        @ActivationConfigProperty(propertyName = "acknowledgeMode",
                                  propertyValue = "Auto-acknowledge"),
        @ActivationConfigProperty(propertyName = "destinationType",
                                  propertyValue = "javax.jms.Queue")
    })

public class MyPriceConsumer implements MessageListener {

    public MyPriceConsumer() {

    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message msg) {
    	String msgText;
        try {
          if (msg instanceof TextMessage) {
            msgText = ((TextMessage) msg).getText();
            System.out.println("Got from the queue: " + msgText);
          } else {
            System.out.println("Got a non-text message");
          }
        } catch (JMSException e) {
          System.out.println("Error while consuming a message: " + e.getMessage());
        }
        
    }

}
