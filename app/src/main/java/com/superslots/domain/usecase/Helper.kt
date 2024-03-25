package com.superslots.domain.usecase

import android.content.Context
import android.net.ConnectivityManager

object Constants {
    const val oneSignalIdKey = "7aaef462-381a-4e9a-b949-0713b53d96e8"
}
fun netChe(context: Context):Boolean{
    val connection = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    return if(connection!=null){
        val activeNet = connection.activeNetwork
        activeNet != null
    }
    else
        false

}