package jms;

import model.Samples;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author zard
 * @date Created in 27/05/2022 22:41
 */
@WebServlet("/JMSProducer")
public class QSender extends HttpServlet {

//    private static final String DEFAULT_MESSAGE = "the 4 message!" ;
    // xml文件272行
    private static final String DEFAULT_CONNECTION_FACTORY = "jms/RemoteConnectionFactory" ;
    // xml文件293行,初次找JBOSS的JNDI太不容易了
    private static final String DEFAULT_DESTINATION = "jms/queue/test" ;
    private static final String DEFAULT_MESSAGE_COUNT = "1" ;

    private static final String DEFAULT_USERNAME = "testjms" ;
    private static final String DEFAULT_PASSWORD = "123456" ;
    private static final String INITIAL_CONTEXT_FACTORY = "org.jboss.naming.remote.client.InitialContextFactory" ;
    private static final String PROVIDER_URL = "remote://127.0.0.1:4447" ;

    public static void main(String[] args) {
        Samples samples = new Samples();
        samples.setResult(1);
        try {
            new QSender().send(samples);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void send(Samples samples) throws Exception {
        Context context= null ;
        Connection connection= null ;
        try {
            // 设置上下文的JNDI查找
            final Properties env = new Properties();
            env.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY); // 该KEY的值为初始化Context的工厂类,JNDI驱动的类名
            env.put(Context.PROVIDER_URL,  PROVIDER_URL); // 该KEY的值为Context服务提供者的URL.命名服务提供者的URL
            env.put(Context.SECURITY_PRINCIPAL, DEFAULT_USERNAME);
            env.put(Context.SECURITY_CREDENTIALS, DEFAULT_PASSWORD); //应用用户的登录名,密码.
            // 获取到InitialContext对象.
            context = new InitialContext(env);

            ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup(DEFAULT_CONNECTION_FACTORY);
            Destination destination = (Destination) context.lookup(DEFAULT_DESTINATION);

            // 创建JMS连接、会话、生产者和消费者
            connection = connectionFactory.createConnection(DEFAULT_USERNAME, DEFAULT_PASSWORD);
            Session session = connection.createSession( false , Session.AUTO_ACKNOWLEDGE);
            MessageProducer producer = session.createProducer(destination);
            connection.start();

            int count = Integer.parseInt(DEFAULT_MESSAGE_COUNT);
            // 发送特定数目的消息
            TextMessage message = null ;
            for ( int i = 0 ; i < count; i++) {
                message = session.createTextMessage(samples.getUserIds() + "$" + samples.getResult());
                producer.send(message);
            }
            // 等待30秒退出
            CountDownLatch latch = new CountDownLatch( 1 );
            latch.await( 30 , TimeUnit.SECONDS);

        } catch (Exception e) {
            throw e;
        } finally {
            if (context != null ) {
                context.close();
            }
            // 关闭连接负责会话,生产商和消费者
            if (connection != null ) {
                connection.close();
            }
        }
    }
//
//    private static final long serialVersionUID = 1L;
//
//    private static final String DEFAULT_MESSAGE = "the 4 message!" ;
//    // xml文件272行
//    private static final String DEFAULT_CONNECTION_FACTORY = "jms/RemoteConnectionFactory" ;
//    // xml文件293行,初次找JBOSS的JNDI太不容易了
//    private static final String DEFAULT_DESTINATION = "/jms/queue/test" ;
//    private static final String DEFAULT_MESSAGE_COUNT = "1" ;
//
//    private static final String DEFAULT_USERNAME = "user" ;
//    private static final String DEFAULT_PASSWORD = "kolkata" ;
//    private static final String INITIAL_CONTEXT_FACTORY = "org.jboss.naming.remote.client.InitialContextFactory" ;
//    private static final String PROVIDER_URL = "remote://localhost:4447" ;
//
//    public QSender() {
//        super();
//    }
//
//    public void send(Samples samples) {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(
//                System.in));
//        try {
//
//            Context context= null ;
//            Connection connection= null ;
//            try {
//                // 设置上下文的JNDI查找
//                final Properties env = new Properties();
//                env.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY); // 该KEY的值为初始化Context的工厂类,JNDI驱动的类名
//                env.put(Context.PROVIDER_URL,  PROVIDER_URL); // 该KEY的值为Context服务提供者的URL.命名服务提供者的URL
//                env.put(Context.SECURITY_PRINCIPAL, DEFAULT_USERNAME);
//                env.put(Context.SECURITY_CREDENTIALS, DEFAULT_PASSWORD); //应用用户的登录名,密码.
//                // 获取到InitialContext对象.
//                context = new InitialContext(env);
//                ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup(DEFAULT_CONNECTION_FACTORY);
//                Destination destination = (Destination) context.lookup(DEFAULT_DESTINATION);
//
//                // 创建JMS连接、会话、生产者和消费者
//                connection = connectionFactory.createConnection(DEFAULT_USERNAME, DEFAULT_PASSWORD);
//                Session session = connection.createSession( false , Session.AUTO_ACKNOWLEDGE);
//                MessageProducer producer = session.createProducer(destination);
//                connection.start();
//
//                int count = Integer.parseInt(DEFAULT_MESSAGE_COUNT);
//                // 发送特定数目的消息
//                TextMessage message = null ;
//                for ( int i = 0 ; i < count; i++) {
//                    message = session.createTextMessage(samples.getTubeNumber()+","+ samples.getUserIds());
//                    producer.send(message);
//                }
//                // 等待30秒退出
//                CountDownLatch latch = new CountDownLatch( 1 );
//                latch.await( 30 , TimeUnit.SECONDS);
//
//            } catch (Exception e) {
//                throw e;
//            } finally {
//                if (context != null ) {
//                    context.close();
//                }
//                // 关闭连接负责会话,生产商和消费者
//                if (connection != null ) {
//                    connection.close();
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.exit(1);
//        }
//    }

}
