package com.facebook.teacherapp;

import com.facebook.teacherapp.speech.TextToSpeechConverter;
import com.google.cloud.texttospeech.v1.AudioConfig;
import com.google.cloud.texttospeech.v1.AudioEncoding;
import com.google.cloud.texttospeech.v1.SsmlVoiceGender;
import com.google.cloud.texttospeech.v1.SynthesisInput;
import com.google.cloud.texttospeech.v1.SynthesizeSpeechResponse;
import com.google.cloud.texttospeech.v1.TextToSpeechClient;
import com.google.cloud.texttospeech.v1.VoiceSelectionParams;
import com.google.protobuf.ByteString;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@SpringBootApplication
public class QuickstartSample {

    public static void main(String[] args) {
       // TextToSpeechConverter converter = new TextToSpeechConverter();
        //String text = "Mercury is the smallest and innermost planet in the Solar System. Its orbital period around the" +
//                " Sun of 87.97 days is the shortest of all the planets in the Solar System. It is named after the Roman" +
//                " deity Mercury, the messenger of the gods.";
        //String outputFile = "mercury.mp3";
        //converter.convertToSpeech(text, outputFile);
        SpringApplication.run(QuickstartSample.class, args);
    }
}
