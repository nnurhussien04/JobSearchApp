package ui.mainactivity;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import model.Candidate;
import model.CandidateRepository;
import model.Employer;
import model.EmployerRepository;
import model.Job;
import model.JobRepository;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import service.EmployableApiService;
import service.RetrofitInstance;

public class MainActivityViewModel extends AndroidViewModel {
    JobRepository jobRepository;
    EmployerRepository employerRepository;

    CandidateRepository candidateRepository;
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.jobRepository = new JobRepository(application);
        this.employerRepository = new EmployerRepository(application);
        this.candidateRepository = new CandidateRepository(application);
    }

    public MutableLiveData<List<Job>> jobMutableLiveData(){
        return jobRepository.getMutableLiveData();
    }

    public void employerMutableLiveData(Employer employer){
        employerRepository.postMutableLiveData(employer);
    }

    public void candidateMutableLiveData(Candidate candidate){
        candidateRepository.postMutableLiveData(candidate);
    }

    public Call<ResponseBody> loginMutableLiveData(String username, String password){
        EmployableApiService employableApiService = RetrofitInstance.getService();
        return employableApiService.login(username,password);
    }



}
