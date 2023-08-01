package com.github.thomasandre84

import com.github.thomasandre84.apihub.common.rest.FileProviderResourceIf
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.core.StreamingOutput
import java.io.*
import java.nio.file.Files

@Path(FileProviderResourceIf.BASE_URL)
class FileProviderResource: FileProviderResourceIf {

    val folder = java.nio.file.Path.of("/tmp/test/");


    override fun listFiles(): List<String> {
        val files = Files.list(folder)
        return files.map { it.toFile().name }.toList()
    }



    override fun getFile(@PathParam("fileName") fileName: String): File {
        return File(folder.toFile(), fileName)
    }


    override fun getFileStream(@PathParam("fileName") fileName: String): InputStream {
        val file = File(folder.toFile(), fileName)
        val input = BufferedInputStream(FileInputStream(file))
        //val out = BufferedOutputStream(FileOutputStream(file));

        return input;
    }

}