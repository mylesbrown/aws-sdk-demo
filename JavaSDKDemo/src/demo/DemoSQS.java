package demo;
import java.util.List;
import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;

/*
 * This sample demonstrates how to make basic requests to Amazon SQS using the
 * AWS SDK for Java.
 *
 * You must have a valid Amazon Web Services developer 
 * account, and be signed up to use Amazon SQS.
 * 
 * Fill in your AWS access credentials in the AwsCredentials.properties file
 */
public class DemoSQS {

    public static void main(String[] args) throws Exception {

    	 Region region = Region.getRegion(Regions.US_WEST_1);
         
         // Create an S3 client
         AmazonSQSClient sqs = new AmazonSQSClient(new ClasspathPropertiesFileCredentialsProvider());
         sqs.setRegion(region);


            // Create a new Queue using the AWS Explorer. Then list the queues
            System.out.println("Listing all queues in your account.");
            for (String queueUrl : sqs.listQueues().getQueueUrls()) {
                System.out.println("  QueueUrl: " + queueUrl);
            }
           
            /* Using the queue URL from the list, create a receiver and print at most the first five messages in your new queue
             * 
             */ 
            

            /* Delete the first message received using the queue URL and the receipt handle
             * 
             */
             
            
    }
}
