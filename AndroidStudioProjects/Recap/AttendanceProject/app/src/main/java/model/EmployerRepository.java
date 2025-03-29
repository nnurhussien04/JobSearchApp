package model;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import service.EmployableApiService;
import service.RetrofitInstance;

public class EmployerRepository {
    private MutableLiveData<Employer> mutableLiveData = new MutableLiveData<>();
    private Application application = new Application();

    public EmployerRepository(Application application) {
        this.application = application;
    }

    public void postMutableLiveData(Employer employer) {
        EmployableApiService employableApiService = RetrofitInstance.getService();
        Call<Employer> call = employableApiService.employerSignUp(employer);
        call.enqueue(new Callback<Employer>() {

            @Override
            public void onResponse(Call<Employer> call, Response<Employer> response) {
                Toast toast = Toast.makeText(application.getBaseContext(),"Sign Up Successful",Toast.LENGTH_SHORT);
                toast.show();
            }

            @Override
            public void onFailure(Call<Employer> call, Throwable t) {
                Log.i("CandidateRepositoryError", t.getMessage());
                Toast toast = Toast.makeText(application.getBaseContext(),"Sign Up Failed",Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}

