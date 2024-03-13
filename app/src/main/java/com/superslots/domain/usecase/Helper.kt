package com.superslots.domain.usecase

import android.content.Context
import android.net.ConnectivityManager

object Constants {
    const val oneSignalIdKey = "852fca47-67fc-4429-bc"
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