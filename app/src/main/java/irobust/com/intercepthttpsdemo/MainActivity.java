package irobust.com.intercepthttpsdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import irobust.com.intercepthttpsdemo.api.GithubApi;
import irobust.com.intercepthttpsdemo.api.Repo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private List<Repo> listOfRepos;
    private Button btn;
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.btn = (Button) findViewById(R.id.button);
        this.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequestToGithub();
            }
        });
    }

    private void sendRequestToGithub(){
        Call<List<Repo>> repos = GithubApi.service().listRepos();
        repos.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                if(response.isSuccessful()){
                    listOfRepos = response.body();
                }
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {

            }
        });
    }
}
