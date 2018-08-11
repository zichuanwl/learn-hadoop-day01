package org.wangling.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URI;

public class GetFileData {
    public static void main(String[] args)throws Exception{
        Configuration conf=new Configuration();
        conf.set("dfs.replication","1");
        FileSystem fileSystem=FileSystem.get(new URI("hdfs://172.16.217.131:9000"),conf,"root");
        FSDataInputStream fsDataInputStream=fileSystem.
                open(new Path("hdfs://172.16.217.131:9000/wangling/generator.xml"));
        FileOutputStream fileOutputStream=new
                FileOutputStream(new File("/Users/wangling/Desktop/conf.xml"));
        //buffSize是设置输入流缓存大小，close是否关闭输入流、输出流
        IOUtils.copyBytes(fsDataInputStream,fileOutputStream,128,true);
    }
}
