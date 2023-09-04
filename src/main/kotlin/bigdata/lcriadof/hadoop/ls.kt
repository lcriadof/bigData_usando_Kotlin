package bigdata.lcriadof.hadoop

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.FileSystem
import org.apache.hadoop.fs.Path

fun main() {
    val conf = Configuration()
    conf.set("fs.defaultFS", "hdfs://localhost:9000")
    val fs = FileSystem.get(conf)

    val path = Path("/")
    val files = fs.listStatus(path)

    files.forEach {
        println("${it.permission} ${it.owner} ${it.group} ${it.len} ${it.modificationTime}  ->    ${it.path}")
    }



    fs.close()
}


