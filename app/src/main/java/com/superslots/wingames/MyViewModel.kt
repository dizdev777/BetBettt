package com.superslots.wingames

import android.content.Context
import android.os.Handler
import android.os.Looper
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.appsflyer.AppsFlyerLib
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import com.superslots.domain.usecase.AppsFlyerEventListener
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {
    private val appsFlyerEventListener = AppsFlyerEventListener()
    val conversionDataLiveData = MutableLiveData<MutableMap<String, Any>?>()
    val conversionDataFailLiveData = MutableLiveData<String?>()
    val someValue = ""
    val appsfSignalAppId = "JDt69d7fVFM33F6KuWHh5A"
    lateinit var advertisingId: String

    fun initializeAppsFlyer(context: Context) {
        AppsFlyerLib.getInstance().init(appsfSignalAppId, appsFlyerEventListener, context.applicationContext)
        AppsFlyerLib.getInstance().start(context)
        CoroutineScope(Dispatchers.IO).launch {
            advertisingId = getAdvertisingId(context) ?: ""
        }
    }

    fun fetchAppsFlyerData() {
        appsFlyerEventListener.getConversionDataFuture().thenAccept { conversionData ->
            Handler(Looper.getMainLooper()).post {
                conversionDataLiveData.value = conversionData
            }
        }

        appsFlyerEventListener.getErrorFuture().thenAccept { conversionDataFail ->
            Handler(Looper.getMainLooper()).post {
                conversionDataFailLiveData.value = conversionDataFail
            }
        }
    }

    fun buildFinalLink(baseLink: String, path: String, queryParams: Map<String, String>): String {
        val finalLinkBuilder = StringBuilder(baseLink)

        if (path.isNotEmpty() && !path.startsWith("/")) {
            finalLinkBuilder.append('/')
        }

        finalLinkBuilder.append(path)

        if (queryParams.isNotEmpty()) {
            finalLinkBuilder.append('?')

            for ((key, value) in queryParams) {
                finalLinkBuilder.append(encodeParameter(key))
                finalLinkBuilder.append('=')
                finalLinkBuilder.append(encodeParameter(value))
                finalLinkBuilder.append('&')
            }

            finalLinkBuilder.deleteCharAt(finalLinkBuilder.length - 1)
        }

        return finalLinkBuilder.toString()
    }

    private fun encodeParameter(parameter: String): String {
        return java.net.URLEncoder.encode(parameter, "UTF-8")
    }

    private fun getAdvertisingId(context: Context): String? {
        return try {
            AdvertisingIdClient.getAdvertisingIdInfo(context).id
        } catch (e: Exception) {
            null
        }
    }
}
