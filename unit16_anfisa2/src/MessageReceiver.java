
import javax.jms.*;
//import com.sun.messaging.ConnectionFactory;
//import com.sun.messaging.ConnectionConfiguration;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class MessageReceiver implements MessageListener {

  Session session = null;
  ConnectionFactory factory = null;
  Connection connection = null;
  MessageConsumer consumer = null;

  MessageReceiver() throws NamingException {
    try {
      // was in lesson 30:
      // factory = new com.sun.messaging.ConnectionFactory();
      // factory.setProperty(ConnectionConfiguration.imqAddressList,
      // "mq://localhost:7677,mq://localhost:7677");
      // connection = factory.createQueueConnection("admin","admin");

      // Find the JNDI context
      Context jndiContext = new InitialContext();
      
      // Look up the factory and the queue
      factory = (ConnectionFactory) jndiContext
          .lookup("MyTestConnectionFactory");

      // was in lesson 30: Queue ioQueue = session.createQueue( "TestQueue" );
      Queue ioQueue = (Queue) jndiContext.lookup("MyJMSTestQueue");

      connection = factory.createConnection();

      connection.start();

      session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

      consumer = session.createConsumer(ioQueue);
      
      consumer.setMessageListener(this);

      System.out.println("Listening to the TestQueue...");

      // wait for quote
      Thread.sleep(100);

    } catch (InterruptedException e) {
      System.out.println("Error: " + e.getMessage());
    } catch (JMSException e) {
      System.out.println("Error: " + e.getMessage());
    } finally {
      try {
        // session.close();
        connection.close();
      } catch (Exception e) {
        System.out.println("Can't close JMS connection/session "
            + e.getMessage());
      }
    }

  }

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
