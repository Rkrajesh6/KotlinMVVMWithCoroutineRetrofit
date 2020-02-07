package com.example.assignment.network

import com.example.assignment.utils.Utils
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
/**
 * Created by rajeshkumar07 on 06-02-2020.
 */
object RetrofitService {
    private var mApiInterface: Api? = null

    /**
     * Created by : rajeshkumar07
     * Created Date/Time : 06-02-2020 16:40
     * Description : This method is used to create the Retrofit instance with Api interfaces.
     */
    fun create(): Api? {
        val builder: Retrofit.Builder = Retrofit.Builder()
            .baseUrl(Utils.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())

        val httpClient: OkHttpClient.Builder = OkHttpClient.Builder()
        httpClient.readTimeout(Utils.REQUEST_TIMEOUT, TimeUnit.SECONDS)
        httpClient.connectTimeout(Utils.REQUEST_TIMEOUT, TimeUnit.SECONDS)
        httpClient.addInterceptor(interceptor())

        val retrofit: Retrofit = builder.client(httpClient.build()).build()

        mApiInterface = retrofit.create(Api::class.java)
        return mApiInterface
    }
    /**
     * Created by : rajeshkumar07
     * Created Date/Time : 06-02-2020 16:41
     * Description : this method is used to enable the logger into retrofit.
     */
    private fun interceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }
}