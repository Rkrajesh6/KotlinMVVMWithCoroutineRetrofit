package com.example.assignment.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import org.jetbrains.annotations.Contract

/**
 * Created by rajeshkumar07 on 06-02-2020.
 */
object Utils {
    const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    const val REQUEST_TIMEOUT = 60L

    /**
     * Created by : rajeshkumar07
     * Created Date/Time : 06-02-2020 14:47
     * Description : This function is using for checking network connected or not.
     */
    fun isNetworkAvailable(context: Context): Boolean {
        var isInternetConnected = false
        try {
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkArray = connectivityManager.allNetworks
            for (network in networkArray) {
                val networkInfo = connectivityManager.getNetworkInfo(network)
                isInternetConnected = isInternetConnected || checkNetworkInfo(networkInfo)
            }
        } catch (ignore: Exception) {
        }
        return isInternetConnected
    }

    @Contract("null -> false")
    private fun checkNetworkInfo(networkInfo: NetworkInfo?): Boolean {
        if (networkInfo != null && networkInfo.isConnected) {
            when (networkInfo.type) {
                ConnectivityManager.TYPE_WIFI -> return true
                ConnectivityManager.TYPE_MOBILE -> return true
                ConnectivityManager.TYPE_ETHERNET -> return true
            }
        }
        return false
    }
}