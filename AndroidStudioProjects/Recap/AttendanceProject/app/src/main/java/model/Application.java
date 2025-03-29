package model;

public class Application {
    Candidate candidate;

    Job job;

    String outcome;

    public Application(Candidate candidate, Job job, String outcome) {
        this.candidate = candidate;
        this.job = job;
        this.outcome = outcome;
    }

    public Application() {
    }

}
