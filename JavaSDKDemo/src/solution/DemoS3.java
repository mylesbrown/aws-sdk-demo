package solution;
import java.io.*;

import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.amazonaws.regions.*;
import com.amazonaws.services.s3.*;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.PutObjectRequest;

/*
 * This sample demonstrates how to make basic requests to Amazon S3 using the
 * AWS SDK for Java.
 *
 * You must have a valid Amazon Web Services developer
 * account, and be signed up to use Amazon S3.
 * 
 * Fill in your AWS access credentials in the AwsCredentials.properties file
 * 
 */
public class DemoS3 {

    public static void main(String[] args) throws IOException {

        Region region = Region.getRegion(Regions.US_WEST_1);
        
        // Create an S3 client
        AmazonS3Client s3 = new AmazonS3Client(new ClasspathPropertiesFileCredentialsProvider());
        s3.setRegion(region);
        
 
            /*
             * List the buckets in your account
             */
            System.out.println("Listing buckets");
            for (Bucket bucket : s3.listBuckets()) {
                System.out.println(" - " + bucket.getName());
            }
            System.out.println();
            
            /*
             * Create a new bucket with a name of your choice, but try to think of a name that will be globally unique.
             * To create the bucket, call the createBucket ethod of the s3 client object, providing the bucket name. 
             * But If the region is other than us-east-1, we need to specify a regional constraint. Unfortunately, this Region object is
             * different from the one above. The easiest way to create this Region is to use the method:
             *     com.amazonaws.services.s3.model.Region.fromValue(region.getName())
             *     
             */
                    s3.createBucket("somethingunique", com.amazonaws.services.s3.model.Region.fromValue(region.getName())) ;   
            /*
             * Now upload an object to your bucket - You can easily upload a file to
             * S3, or upload directly an InputStream if you know the length of
             * the data in the stream. You can also specify your own metadata
             * when uploading to S3, which allows you set a variety of options
             * like content-type and content-encoding, plus additional metadata
             * specific to your applications.
             * 
             *  For this demo, create a File object that points to a file on your machine, like the sample text file included: 
             *         File sourceFile = new File("sampletext.txt")
             *         
             * Then construct a PutObjectRequest object using the bucket name you 
             * created earlier, an object key of your choice, and the File object.
             * 
             * Finally, upload the object by submitting the request using the putObject method of the s3 client object.
             * 
             * Check that this all worked by updating the list of buckets under the "Amazon S3" section of the AWS Explorer
             */
                    File sourceFile = new File("sampletext.txt");
                    PutObjectRequest putObjectRequest = new PutObjectRequest("somethingunique", "sampletext", sourceFile);
                	s3.putObject(putObjectRequest);
    }
}
