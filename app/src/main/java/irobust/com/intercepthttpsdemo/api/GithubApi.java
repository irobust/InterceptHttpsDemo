package irobust.com.intercepthttpsdemo.api;

import okhttp3.CertificatePinner;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GithubApi {
    public static GithubService service(){
        OkHttpClient.Builder httpBuilder = new OkHttpClient.Builder();
        CertificatePinner certificatePinner = new CertificatePinner.Builder()
                .add("api.github.com", "sha256/WoiWRyIOVNa9ihaBciRSC7XHjliYS9VwUGOIud4PB18=")
                .build();

        OkHttpClient client = httpBuilder.certificatePinner(certificatePinner).build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://api.github.com")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
        GithubService service = retrofit.create(GithubService.class);
        return service;
    }
}
