package org.wangling.hadoop;

import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Test;

import java.net.URI;
@Slf4j
public class HDFSMain {
    public static void main(String[] args){
        Configuration conf=new Configuration();
        conf.set("dfs.replication","1");
        FileSystem fileSystem=null;
        try {
            fileSystem = FileSystem.get(new URI("hdfs://172.16.217.131:9000"), conf, "root");
        }catch (Exception e){
            e.printStackTrace();
        }
        Path srcPath=new Path("/wangling/generatorConfig.xml");
        Path dstPath=new Path("/wangling/generator.xml");
        try{

            fileSystem.rename(srcPath,dstPath);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
