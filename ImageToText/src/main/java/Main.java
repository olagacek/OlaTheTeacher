import com.google.protobuf.ByteString;

import java.io.FileInputStream;



public class Main {

    static public void main(String[] args) {
        String path = "/home/nhemisirmkow/GIT/OlaTheTeacher/ImageToText/data/text5.gif";
        try {
            ByteString imgBytes = ByteString.readFrom(new FileInputStream(path));
            String text = ImageToText.ImageToText(imgBytes);
            System.out.println(text);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
