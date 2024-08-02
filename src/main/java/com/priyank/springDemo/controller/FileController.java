package com.priyank.springDemo.controller;

//Importing required classes 
import java.io.File; 
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

//Annotation 
@RestController
@RequestMapping("/api")
public class FileController { 
   
	@PostMapping("/upload")
    public String uploadFile(@RequestParam("myFile") MultipartFile file) {
		
        String uploadsDir = System.getProperty("user.dir") + "/Uploads";
        File uploadsDirFile = new File(uploadsDir);

        if (!uploadsDirFile.exists()) {
            uploadsDirFile.mkdirs();
        }

        String filePath = uploadsDir + File.separator + file.getOriginalFilename();
        String fileUploadStatus;

        try (FileOutputStream fout = new FileOutputStream(filePath)) {
        	
            fout.write(file.getBytes());
            fileUploadStatus = "File Uploaded Successfully";
            System.out.println(fileUploadStatus);
            
        } catch (IOException e) {
        	
            e.printStackTrace();
            fileUploadStatus = "Error in uploading file: " + e;
        }
        
        return fileUploadStatus;
	}
}
