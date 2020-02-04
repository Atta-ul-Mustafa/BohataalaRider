package com.example.bohataalarider;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Base

{
        private static Retrofit retrofit = null;

        private static String BASE_URL = "http://bohataala.clientsidetesting.com/";

        public static Retrofit getClient()
        {
            if (retrofit == null)
            {
                retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
            return retrofit;
        }

}
