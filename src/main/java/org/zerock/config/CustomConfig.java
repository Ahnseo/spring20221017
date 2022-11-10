package org.zerock.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
@ImportResource("/WEB-INF/spring/root-context.xml")
public class CustomConfig {
	
	// WEB-INF/props/aws.properties 파일 속의  id, key(비번) 매칭하기
	@Value("${aws.accessKeyId}") //import org.springframework.beans.factory.annotation.Value;
	private String accessKeyId;
	
	@Value("${aws.secretAccessKey}") //import org.springframework.beans.factory.annotation.Value;
	private String secretAccessKey;
	

	@Bean
	public AwsCredentials awsCredentials() {
		return AwsBasicCredentials.create(accessKeyId, secretAccessKey);
	}
	
	@Bean
	public AwsCredentialsProvider awsCredentialsProvider() {
		return StaticCredentialsProvider.create(  awsCredentials()  );
	}
	
	@Bean
	public S3Client s3Client() {
		//spring 에서 aws s3 객체로 put/ delete 메소드를 사용하기 위해
		return  S3Client.builder()
				.credentialsProvider(  awsCredentialsProvider()  ) //자격증명 메소드	
				.region(Region.AP_NORTHEAST_2).build();
	}
}
