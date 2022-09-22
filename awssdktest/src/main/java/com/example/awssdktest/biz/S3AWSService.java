package com.example.awssdktest.biz;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.HttpMethod;
import com.amazonaws.SdkClientException;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.*;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class S3AWSService {
    private final Logger logger = LoggerFactory.getLogger(S3AWSService.class);
    @Autowired
    private AmazonS3 amazonS3;

    @Value("${cloud.aws.credentials.region}")
    private String region;
    @Value("${cloud.aws.credentials.bucket}")
    private String bucket;
    @Value("${domain.file}")
    private String filePath;
    @Value("${cloud.aws.credentials.imgurl}")
    private String awsImgUrl;

    public void aa(String key_name, String bucket_name) {
        System.out.format("Creating a pre-signed URL for uploading %s to S3 bucket %s...\n", key_name, bucket_name);
        // Set the pre-signed URL to expire after 12 hours.
        java.util.Date expiration = new java.util.Date();
        long expirationInMs = expiration.getTime();
        expirationInMs += 1000 * 60 * 60 * 12;
        expiration.setTime(expirationInMs);
        try {
            GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(bucket_name, key_name)
                    .withMethod(HttpMethod.PUT)
                    .withKey(key_name)
                    .withBucketName(bucket_name)
                    .withExpiration(expiration);
            URL url = amazonS3.generatePresignedUrl(generatePresignedUrlRequest);
            //print URL
            System.out.println("\n\rGenerated URL: " + url.toString());
            //Print curl command to consume URL
            System.out.println("\n\rExample command to use URL for file upload: \n\r");
            System.out.println("curl --request PUT --upload-file /path/to/" + key_name + " '" + url.toString() + "' -# > /dev/null");
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
            System.exit(1);
        }
    }

    public String bb(String objectKey, String bucketName) throws IOException {
        String result = null;
        try {
//            AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
//                    .withCredentials(new ProfileCredentialsProvider())
//                    .withRegion(region)
//                    .build();

            // Set the pre-signed URL to expire after one hour.
            logger.info("=======try init");
            java.util.Date expiration = new java.util.Date();
            long expTimeMillis = expiration.getTime();
            expTimeMillis += 1000 * 60 * 60;
            expiration.setTime(expTimeMillis);
            logger.info("Generating pre-signed URL");
            // Generate the pre-signed URL.
            GeneratePresignedUrlRequest generatePresignedUrlRequest =
                    new GeneratePresignedUrlRequest(bucketName, objectKey)
                            .withMethod(HttpMethod.PUT)
                            .withExpiration(expiration);
//            URL url = s3Client.generatePresignedUrl(generatePresignedUrlRequest);
            logger.info("presign Request URL tostring = {}", generatePresignedUrlRequest.toString());
            URL url = amazonS3.generatePresignedUrl(generatePresignedUrlRequest);
            logger.info("url tostring  - {}", url.toString());
            // Create the connection and use it to upload the new object using the pre-signed URL.
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("PUT");
            logger.info("connect tostring  - {}", connection.toString());
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
            out.write("This text uploaded as an object via presigned URL.");
            out.close();
            logger.info("out tostring - {}", out.toString());
            // Check the HTTP response code. To complete the upload and make the object available,
            // you must interact with the connection object in some way.
            logger.info("response code - {}", connection.getResponseCode());
            System.out.println("HTTP response code: " + connection.getResponseCode());

            // Check to make sure that the object was uploaded successfully.
//            S3Object object = s3Client.getObject(bucketName, objectKey);
            S3Object object = amazonS3.getObject(bucketName, objectKey);

            System.out.println("Object " + object.getKey() + " created in bucket " + object.getBucketName());

        } catch (AmazonServiceException e) {
            // The call was transmitted successfully, but Amazon S3 couldn't process
            // it, so it returned an error response.
            e.printStackTrace();
        } catch (SdkClientException e) {
            // Amazon S3 couldn't be contacted for a response, or the client
            // couldn't parse the response from Amazon S3.
            e.printStackTrace();
        }

        return result;
    }


    public void test3(String aa, String bb) throws IOException {
        Regions clientRegion = Regions.AP_NORTHEAST_2;
        String bucketName = bb;
        String objectKey = aa;

        try {
//            AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
//                    .withCredentials(new ProfileCredentialsProvider())
//                    .withRegion(clientRegion)
//                    .build();

            // Set the pre-signed URL to expire after one hour.
            java.util.Date expiration = new java.util.Date();
            long expTimeMillis = expiration.getTime();
            expTimeMillis += 1000 * 60 * 60;
            expiration.setTime(expTimeMillis);

            // Generate the pre-signed URL.
            System.out.println("Generating pre-signed URL.");
            GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(bucketName, objectKey)
                    .withMethod(HttpMethod.PUT)
                    .withExpiration(expiration);
//            URL url = s3Client.generatePresignedUrl(generatePresignedUrlRequest);
            URL url = amazonS3.generatePresignedUrl(generatePresignedUrlRequest);

            // Create the connection and use it to upload the new object using the pre-signed URL.
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("PUT");
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
            out.write("This text uploaded as an object via presigned URL.");
            out.close();

            // Check the HTTP response code. To complete the upload and make the object available,
            // you must interact with the connection object in some way.
            connection.getResponseCode();
            System.out.println("HTTP response code: " + connection.getResponseCode());

            // Check to make sure that the object was uploaded successfully.
//            S3Object object = s3Client.getObject(bucketName, objectKey);
            S3Object object = amazonS3.getObject(bucketName, objectKey);
            System.out.println("Object " + object.getKey() + " created in bucket " + object.getBucketName());
        } catch (AmazonServiceException e) {
            // The call was transmitted successfully, but Amazon S3 couldn't process
            // it, so it returned an error response.
            e.printStackTrace();
        } catch (SdkClientException e) {
            // Amazon S3 couldn't be contacted for a response, or the client
            // couldn't parse the response from Amazon S3.
            e.printStackTrace();
        }
    }

    public String CreatePresignUrl(String key_name, String bucket_name) {
        String result = "";
        key_name = UUID.randomUUID().toString() + ".jpeg";
        bucket_name = "hooxi-s3";

        System.out.format("Creating a pre-signed URL for uploading %s to S3 bucket %s...\n", key_name, bucket_name);
        // Set the pre-signed URL to expire after 12 hours.
        java.util.Date expiration = new java.util.Date();
        long expirationInMs = expiration.getTime();
        expirationInMs += 1000 * 60 * 60 * 12;
        expiration.setTime(expirationInMs);
        try {
            GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(bucket_name, key_name)
                    .withMethod(HttpMethod.PUT)
                    .withKey(key_name)
                    .withBucketName(bucket_name)
                    .withExpiration(expiration);
            URL url = amazonS3.generatePresignedUrl(generatePresignedUrlRequest);
            result = url.toString();
            //print URL
            System.out.println("\n\rGenerated URL: " + url.toString());
            //Print curl command to consume URL
            System.out.println("\n\rExample command to use URL for file upload: \n\r");
            System.out.println("curl --request PUT --upload-file /path/to/" + key_name + " '" + url.toString() + "' -# > /dev/null");

        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
            System.exit(1);
        }

        return result;
    }


    public List<String> ObjectSaveService(MultipartFile[] file) throws IOException {

        List<String> result = new ArrayList<>();
        result = uploadImage(Arrays.asList(file));
        logger.info("result - - -{}", new Gson().toJson(result));
        return result;
    }

    public File tofile(MultipartFile mfile) throws IOException {
        File file = new File(mfile.getOriginalFilename());
        mfile.transferTo(file);
        return file;
    }

    public List<String> FileSaveService(MultipartFile[] uploadfile) throws IllegalStateException, IOException {
        List<String> ll = new ArrayList<>();
        String nn = "";
        for (MultipartFile mf : uploadfile) {
            if (!mf.isEmpty()) {
                nn = UUID.randomUUID().toString();
                File newFileName = new File(nn + "_" + mf.getOriginalFilename());
                logger.info("path - - {}", newFileName.getPath());
                Path directory = Paths.get(filePath).toAbsolutePath().normalize();
                // directory 해당 경로까지 디렉토리를 모두 만든다.
                Files.createDirectories(directory);
                // 파일명을 바르게 수정한다.
                String fileName = StringUtils.cleanPath(nn + "_" + mf.getOriginalFilename()).replaceAll(" ", "");
                // 파일명에 '..' 문자가 들어 있다면 오류를 발생하고 아니라면 진행(해킹및 오류방지)
                Assert.state(!fileName.contains(".."), "Name of file cannot contain '..'");
                // 파일을 저장할 경로를 Path 객체로 받는다.
                Path targetPath = directory.resolve(fileName).normalize();
                // 파일이 이미 존재하는지 확인하여 존재한다면 오류를 발생하고 없다면 저장한다.
                Assert.state(!Files.exists(targetPath), fileName + " File alerdy exists.");
                mf.transferTo(targetPath);
//                ll.add("http://192.168.0.42:9506/admin/img/"+boardName+"/"+fileName);
                ll.add(fileName);
                logger.info("upload file -{}", new Gson().toJson(ll));
            }
        }
        return ll;
    }

    public File getFile(String name) {
        Path directory = Paths.get(filePath).toAbsolutePath().normalize();
        logger.info("direct - {}", directory + name);
        File f = new File(directory + "/" + name);
        logger.info("path = {}", f.getAbsolutePath());
        return f;
    }


    public List<String> uploadImage(List<MultipartFile> multipartFile) {
        List<String> fileNameList = new ArrayList<>();

        multipartFile.forEach(file -> {
            String fileName = createFileName(file.getOriginalFilename());
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(file.getSize());
            objectMetadata.setContentType(file.getContentType());

            try (InputStream inputStream = file.getInputStream()) {
                amazonS3.putObject(new PutObjectRequest(bucket+"/dev", fileName, inputStream, objectMetadata)
                        .withCannedAcl(CannedAccessControlList.PublicRead));
            } catch (IOException e) {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "이미지 업로드에 실패했습니다.");
            }

            fileNameList.add(awsImgUrl+fileName);
        });

        return fileNameList;
    }

    public void deleteImage(String fileName) {
        amazonS3.deleteObject(new DeleteObjectRequest(bucket, fileName));
    }

    private String createFileName(String fileName) {
        return UUID.randomUUID().toString().concat(getFileExtension(fileName));
    }

    private String getFileExtension(String fileName) {
        try {
            return fileName.substring(fileName.lastIndexOf("."));
        } catch (StringIndexOutOfBoundsException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "잘못된 형식의 파일(" + fileName + ") 입니다.");
        }
    }
}