package model;

import android.widget.TextView;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;

import com.northcoders.attendanceproject.BR;

public class Job extends BaseObservable {
    String jobRole;

    String jobType;

    String jobSector;

    String location;

    int salary;

    String description;

    String benefits;

    Employer employer;

    public Job(String jobRole, String jobType, String jobSector, String location, int salary, String description, String benefits, Employer employer) {
        this.jobRole = jobRole;
        this.jobType = jobType;
        this.jobSector = jobSector;
        this.location = location;
        this.salary = salary;
        this.description = description;
        this.benefits = benefits;
        this.employer = employer;
    }

    public Job() {
    }

    @Bindable
    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
        notifyPropertyChanged(BR.jobRole);
    }

    @Bindable
    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
        notifyPropertyChanged(BR.jobType);
    }

    @Bindable
    public String getJobSector() {
        return jobSector;
    }

    public void setJobSector(String jobSector) {
        this.jobSector = jobSector;
        notifyPropertyChanged(BR.jobSector);
    }

    @Bindable
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
        notifyPropertyChanged(BR.location);
    }

    @Bindable
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
        notifyPropertyChanged(BR.salary);
    }

    @Bindable
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        notifyPropertyChanged(BR.description);
    }

    @Bindable
    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
        notifyPropertyChanged(BR.benefits);
    }

    @Bindable
    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
        notifyPropertyChanged(BR.employer);
    }

    @BindingAdapter("intText")
    public static void setIntToText(TextView view, int value) {
        view.setText(String.valueOf(value));
    }

    @BindingAdapter("employerText")
    public static void setEmployerToText(TextView view, Employer employer){
        view.setText(employer.firstName + " " + employer.lastName);
    }

}
