package com.example.pearl_reads;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface YelpApi {
    @GET("businesses/search")
    Call<Bookstoresearch> getBookstores(
            @Query("location") String location,
            @Query("term") String term
    );
}
