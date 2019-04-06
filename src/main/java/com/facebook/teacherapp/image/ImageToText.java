package com.facebook.teacherapp.image;

import com.google.protobuf.ByteString;
import com.google.cloud.vision.v1.*;
import java.util.ArrayList;
import java.util.List;

public class ImageToText
{

    public String convertImageToText(ByteString imgBytes) throws Exception {
        List<AnnotateImageRequest> requests = new ArrayList<>();

        Image img = Image.newBuilder().setContent(imgBytes).build();
        Feature feat = Feature.newBuilder().setType(Feature.Type.DOCUMENT_TEXT_DETECTION).build();
        AnnotateImageRequest request =
                AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
        requests.add(request);

        // This requires GOOGLE_APPLICATION_CREDENTIALS to be set as environment variable
        try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
            BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
            List<AnnotateImageResponse> responses = response.getResponsesList();
            client.close();

            // We know that there is just one image ;)
            AnnotateImageResponse res = responses.get(0);
            if (res.hasError()) {
                throw new Exception(res.getError().getMessage());
            }
            return res.getFullTextAnnotation().getText();
        }
    }
}