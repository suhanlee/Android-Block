package com.devsh.libfileupload;

import android.util.Log;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServerStorage {

    private static String TAG = "BoodlStorage";

    public static void uploadImageFile(File file) {
        uploadImageFile(file, "file");
    }


    public static void uploadImageFile(File file, String fileParamName) {
        ServerUploadService service = ServiceGenerator.createService(ServerUploadService.class);

        // create RequestBody instance from file
        RequestBody requestFile =
                RequestBody.create(MediaType.parse("multipart/form-data"), file);

        // MultipartBody.Part is used to send also the actual file name
        MultipartBody.Part body =
                MultipartBody.Part.createFormData(fileParamName, file.getName(), requestFile);

        // add another part within the multipart request
        String descriptionString = "hello, title contents";
        RequestBody description =
                RequestBody.create(
                        MediaType.parse("multipart/form-data"), descriptionString);

        Call<ServerUploadResponse> call = service.uploadImage(description, body);
        call.enqueue(new Callback<ServerUploadResponse>() {
            @Override
            public void onResponse(Call<ServerUploadResponse> call, Response<ServerUploadResponse> response) {
                if (response.isSuccessful()) {
                    ServerUploadResponse body = response.body();
                    Log.i(TAG, "ResourceURL:" + body.getResourceUrl());

                }
            }

            @Override
            public void onFailure(Call<ServerUploadResponse> call, Throwable t) {

            }
        });
    }
}
