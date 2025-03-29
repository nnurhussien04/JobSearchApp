package model;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import service.EmployableApiService;
import service.RetrofitInstance;

public class CandidateRepository {
    private MutableLiveData<Candidate> mutableLiveData = new MutableLiveData<>();
    private Application application;


    public CandidateRepository(Application application) {
        this.application = application;
    }

    public void postMutableLiveData(Candidate candidate) {
        EmployableApiService employableApiService = RetrofitInstance.getService();
        Call<Candidate> call = employableApiService.candidateSignUp(candidate);
        call.enqueue(new Callback<Candidate>() {

            @Override
            public void onResponse(Call<Candidate> call, Response<Candidate> response) {
                Toast toast = Toast.makeText(application.getBaseContext(),"Sign Up Successful",Toast.LENGTH_SHORT);
                toast.show();
            }

            @Override
            public void onFailure(Call<Candidate> call, Throwable t) {
                Log.i("CandidateRepositoryError", t.getMessage());
                Toast toast = Toast.makeText(application.getBaseContext(),"Sign Up Failed",Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}

