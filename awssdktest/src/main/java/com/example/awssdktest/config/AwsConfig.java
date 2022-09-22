package com.example.awssdktest.config;


import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsConfig {

	@Value("${cloud.aws.credentials.accessKey}")
	private String accessKeyId;
	@Value("${cloud.aws.credentials.secretKey}")
	private String secretAccessKey;

	@Bean
	public AmazonS3 getAmazonS3Client() {
		final BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials(accessKeyId, secretAccessKey);
		return AmazonS3ClientBuilder
				.standard()
				.withRegion(Regions.AP_NORTHEAST_2)
				.withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials))
				.build();
	}

	@Bean
	public AmazonSimpleEmailService AmazonSESClient() {
		final BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials(accessKeyId, secretAccessKey);
		return AmazonSimpleEmailServiceClientBuilder
				.standard()
				//.withCredentials(new ProfileCredentialsProvider())
				.withRegion(Regions.AP_NORTHEAST_2)
				.withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials)) //
				//.withCredentials(new EnvironmentVariableCredentialsProvider())
				.build();
	}


	@Bean
	public AmazonSNSClient getAmazonSNSClient(){
		final BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials(accessKeyId, secretAccessKey);
		return (AmazonSNSClient) AmazonSNSClientBuilder
				.standard()
				.withRegion(Regions.AP_NORTHEAST_1)
				.withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials))
				.build();
	}

}
