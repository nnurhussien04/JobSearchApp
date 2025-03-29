package model;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import service.EmployableApiService;
import service.RetrofitInstance;

public class JobRepository {
    private MutableLiveData<List<Job>> mutableLiveData = new MutableLiveData<>();
    private Application application = new Application();

    public JobRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Job>> getMutableLiveData() {
        EmployableApiService employableApiService = RetrofitInstance.getService();
        Call<List<Job>> call = employableApiService.ListAllJobs();
        call.enqueue(new Callback<List<Job>>() {
            @Override
            public void onResponse(Call<List<Job>> call, Response<List<Job>> response) {
                List<Job> jobs = response.body();
                mutableLiveData.setValue(jobs);
            }

            @Override
            public void onFailure(Call<List<Job>> call, Throwable t) {
                Log.i("JobRepositoryError", t.getMessage());
            }
        });
        return mutableLiveData;
    }
}
