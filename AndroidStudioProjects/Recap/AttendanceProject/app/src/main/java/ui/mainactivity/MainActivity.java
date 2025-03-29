package ui.mainactivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.northcoders.attendanceproject.R;
import com.northcoders.attendanceproject.databinding.JobListBinding;
import com.northcoders.attendanceproject.databinding.ViewJobBinding;

import java.util.ArrayList;
import java.util.List;

import model.Job;
import model.JobRepository;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Job> jobs;
    private JobAdapter jobAdapter;
    private MainActivityViewModel mainActivityViewModel;
    private ViewJobBinding viewJobBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.view_job);
        //JobRepository jobRepository = new JobRepository(this.getApplication());
        //jobRepository.getMutableLiveData();
        viewJobBinding = DataBindingUtil.setContentView(this,R.layout.view_job);
        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        getAllJobs();
    }

    private void getAllJobs(){
        mainActivityViewModel.jobMutableLiveData().observe(this, new Observer<List<Job>>() {
            @Override
            public void onChanged(List<Job> jobsFromLiveData) {
                Log.d("MainActivityJob", "Jobs received: " + jobsFromLiveData.size());
                jobs = (ArrayList<Job>) jobsFromLiveData;
                displayInRecyclerView();
            }
        });
    }

    private void displayInRecyclerView(){
        recyclerView = viewJobBinding.recyclerView;
        jobAdapter = new JobAdapter(jobs,this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(jobAdapter);
        recyclerView.setHasFixedSize(true);
        jobAdapter.notifyDataSetChanged();

    }


}