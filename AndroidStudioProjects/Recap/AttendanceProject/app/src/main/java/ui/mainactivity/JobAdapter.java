package ui.mainactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.northcoders.attendanceproject.R;
import com.northcoders.attendanceproject.databinding.JobListBinding;

import java.util.List;
import java.util.zip.Inflater;

import model.Job;

public class JobAdapter extends RecyclerView.Adapter<JobAdapter.AlbumViewHolder> {
    List<Job> jobs;
    Context context;

    public JobAdapter(List<Job> jobs, Context context) {
        this.jobs = jobs;
        this.context = context;
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        JobListBinding jobListBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.job_list,parent,false);
        return new AlbumViewHolder(jobListBinding);
    } 

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {
        holder.jobListBinding.setJob(jobs.get(position));
    }

    @Override
    public int getItemCount() {
        return jobs.size();
    }


    public static class AlbumViewHolder extends RecyclerView.ViewHolder{
        JobListBinding jobListBinding;

        public AlbumViewHolder(JobListBinding joblistBinding) {
            super(joblistBinding.getRoot());
            this.jobListBinding = joblistBinding;
        }


    }
}
