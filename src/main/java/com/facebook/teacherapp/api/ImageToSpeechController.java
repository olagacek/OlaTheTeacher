package com.facebook.teacherapp.api;

import com.facebook.teacherapp.image.ImageToText;
import com.facebook.teacherapp.speech.TextToSpeechConverter;
import com.google.protobuf.ByteString;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
public class ImageToSpeechController {

    TextToSpeechConverter converter = new TextToSpeechConverter();
    ImageToText imageToText = new ImageToText();

    @PostMapping("/convert")
    public HttpEntity<FileSystemResource> transferAudio(@RequestParam("file") MultipartFile image) {
        try {
            ByteString imageByteStr = ByteString.copyFrom(image.getBytes());
            convert(image);
            String text = imageToText.convertImageToText(imageByteStr);
            System.out.println(text);
            converter.convertToSpeech(text, "output.mp3");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File("/Users/aleksandragacek/OlaTheTeacher/output.mp3");
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.valueOf("audio/mp3"));
        header.set(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=output.mp3");
        header.setContentLength(file.length());

        return new HttpEntity<>(new FileSystemResource(file), header);
    }

    public File convert(MultipartFile file) throws IOException {
        File convFile = new File("output.png");
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }
}
