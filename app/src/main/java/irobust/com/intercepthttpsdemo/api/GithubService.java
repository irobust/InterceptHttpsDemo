package irobust.com.intercepthttpsdemo.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GithubService {
    @GET("users/irobust/repos")
    Call<List<Repo>> listRepos();
}
