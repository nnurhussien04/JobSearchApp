package service;

import java.util.List;

import model.Candidate;
import model.Employer;
import model.Job;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface EmployableApiService {
    @GET("jobs")
    public Call<List<Job>> ListAllJobs();

    @FormUrlEncoded
    @POST("/login")
    Call<ResponseBody> login(
            @Field("username") String username,
            @Field("password") String password
    );

    @POST("/signup/employer")
    Call<Employer> employerSignUp(@Body Employer employer);

    @POST("/signup/candidate")
    Call<Candidate> candidateSignUp(@Body Candidate candidate);


}
