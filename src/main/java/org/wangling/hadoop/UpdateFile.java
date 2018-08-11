package org.wangling.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.net.URI;

public class UpdateFile {
    /*
    *通过Java API操作hdfs文件系统
    *
    * 已知：
    *    api名称
    *    get copyLocal mkdir
    * 1、连接到hdfs
    *    指定连接的url hdfs协议
    *    指定用户名
    *
    * */
    public static void main(String[] args) throws Exception{
        //hdfs api支持多种文件系统，默认是hdfs，支持ftp，本地文件系统
        Configuration conf=new Configuration();
        //配置通过当前客户端操作hdfs的配置信息，该配置会覆盖Hadoop的默认配置
        //配置备份的副本个数
        conf.set("dfs.replication","1");
        FileSystem fileSystem=FileSystem.get(new URI("hdfs://172.16.217.131:9000"),conf,"root");
        System.out.println(fileSystem);
        //创建目录
        boolean isDone=fileSystem.mkdirs(new Path("/test_ok"));
        System.out.println(isDone);
        //源文件
        Path srcPath=new Path("/Users/wangling/Downloads/generatorConfig.xml");
        ////目标路径
        Path dsPath=new Path("/test_ok");
        //复制文件
        fileSystem.copyFromLocalFile(srcPath,dsPath);
        fileSystem.close();
    }
}
