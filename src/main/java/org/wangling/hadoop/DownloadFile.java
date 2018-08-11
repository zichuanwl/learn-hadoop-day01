package org.wangling.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.net.URI;


public class DownloadFile {
    public static void main(String[] args) throws Exception{

        Configuration configuration=new Configuration();
        configuration.set("dfs.replication","1");
        FileSystem fileSystem=FileSystem.get(new URI("hdfs://172.16.217.131:9000"),configuration,"root");
        Path srcPath=new Path("/test_ok/generatorConfig.xml");
        Path dstPath=new Path("/Users/wangling/Desktop/");
        fileSystem.copyToLocalFile(true,srcPath,dstPath);
    }
}
