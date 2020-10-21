package com.baizhi;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.Bucket;
import com.aliyun.oss.model.CreateBucketRequest;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.PutObjectRequest;
import org.junit.Test;

import java.io.File;
import java.util.List;

/**
 * @ClassName TsetAliyun
 * @Author wyy
 * @Date 2020/8/27 22:02
 * @Description TOOO
 */
public class TestAliyun {
    // Endpoint以杭州为例，其它Region请按实际情况填写。
   /* private String endpoint = "http://oss-cn-beijing.aliyuncs.com";
    // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
    private String accessKeyId = "LTAI4GEJBXgRgXWC4HfQyybt";
    private String accessKeySecret = "y0Oi2TxMyMyV8g8t1n0R57BeJAFbqg";

    @Test
    public void createBucket(){
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-beijing.aliyuncs.com";
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = "LTAI4GEJBXgRgXWC4HfQyybt";
        String accessKeySecret = "y0Oi2TxMyMyV8g8t1n0R57BeJAFbqg";

        String bucketName = "yingx-wyyy";  //存储空间名


// 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

// 创建存储空间。
        ossClient.createBucket(bucketName);

// 关闭OSSClient。
        ossClient.shutdown();
    }

    */
    //本地文件上传
   /* @Test
    public void uploadAliyun() {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-beijing.aliyuncs.com";
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = "LTAI4GEJBXgRgXWC4HfQyybt";
        String accessKeySecret = "y0Oi2TxMyMyV8g8t1n0R57BeJAFbqg";
        //yourBucktName
        String bucketName = "yingx-wyy";  //存储空间名
        //yourObjectName    上传的文件名    上传的目录
        String fileName="photo/2.jpg";
        //yourLocalFile
        String localPath="D:\\image\\timg.jpg";
// 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

// 创建PutObjectRequest对象。
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, fileName, new File(localPath));
// 如果需要上传时设置存储类型与访问权限，请参考以下示例代码。
// ObjectMetadata metadata = new ObjectMetadata();
// metadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS, StorageClass.Standard.toString());
// metadata.setObjectAcl(CannedAccessControlList.Private);
// putObjectRequest.setMetadata(metadata);
// 上传文件。
        ossClient.putObject(putObjectRequest);
// 关闭OSSClient。
        ossClient.shutdown();
    }

    */

    // 查询存储空间。
    /*@Test
    public void testQueryBucket() {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-beijing.aliyuncs.com";
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = "LTAI4GEJBXgRgXWC4HfQyybt";
        String accessKeySecret = "y0Oi2TxMyMyV8g8t1n0R57BeJAFbqg";

// 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

// 列举存储空间。
        List<Bucket> buckets = ossClient.listBuckets();
        for (Bucket bucket : buckets) {
            System.out.println(" - " + bucket.getName());
        }

// 关闭OSSClient。
        ossClient.shutdown();
    }

     */

    /*@Test
    public void testDownload(){
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-beijing.aliyuncs.com";
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = "LTAI4GEJBXgRgXWC4HfQyybt";
        String accessKeySecret = "y0Oi2TxMyMyV8g8t1n0R57BeJAFbqg";
        String bucketName = "yingx-wyy";  //存储空间名
        String objectName = "photo/2.jpg";
        String localPath="D:\\图片\\3.jpg";
// 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

// 下载OSS文件到本地文件。如果指定的本地文件存在会覆盖，不存在则新建。
        ossClient.getObject(new GetObjectRequest(bucketName, objectName), new File(localPath));

// 关闭OSSClient。
        ossClient.shutdown();

    }

     */

    //删除文件
    /*@Test
    public void TestDelete(){
        String bucketName = "yingx-wyy";
        String objectName = "photo/1.png";
// 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
// 删除文件。如需删除文件夹，请将ObjectName设置为对应的文件夹名称。如果文件夹非空，则需要将文件夹下的所有object删除后才能删除该文件夹。
        ossClient.deleteObject(bucketName, objectName);
// 关闭OSSClient。
        ossClient.shutdown();
    }

     */

}
