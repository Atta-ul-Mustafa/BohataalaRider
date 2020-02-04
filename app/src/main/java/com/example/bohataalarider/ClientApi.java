package com.example.bohataalarider;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ClientApi {

    @POST("api/rider/getAssignedTasks")
    Call<RriderA> getnewInprogress(@Body FRider fSubCat);

    @POST("api/rider/updateTaskStatus")
    Call<Rstatus> changestats(@Body FRiderStatus fSubCat);

    @POST("api/order/getOrderDetail")
    Call<ROrderDetails> getdetails(@Body ForderDetails fSubCat);

    @POST("api/rider/getTasksHistory")
    Call<RriderHistory> geHistory(@Body FRider fSubCat);


    @POST("api/rider/riderLogin")
    Call<RloginA> login(@Body Flogin fSubCat);

}
