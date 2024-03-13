package com.superslots.domain.usecase

import android.os.Handler
import android.os.Looper
import android.util.Log
import com.appsflyer.AppsFlyerConversionListener
import java.util.concurrent.CompletableFuture

class AppsFlyerEventListener : AppsFlyerConversionListener {
    private var conversionDataCompletableFuture = CompletableFuture<MutableMap<String, Any>?>()
    private var errorCompletableFuture = CompletableFuture<String?>()

    override fun onConversionDataSuccess(conversionData: MutableMap<String, Any>?) {
        Handler(Looper.getMainLooper()).post {
            Log.d("fkqwjrio","onConversionDataSuccess")
            conversionDataCompletableFuture.complete(conversionData)
        }
    }

    override fun onConversionDataFail(error: String?) {
        Handler(Looper.getMainLooper()).post {
            Log.d("fkqwjrio","onConversionDataFail")
            errorCompletableFuture.complete(error)
        }
    }

    override fun onAppOpenAttribution(attributionData: MutableMap<String, String>?) {
    }

    override fun onAttributionFailure(error: String?) {
    }

    fun getConversionDataFuture(): CompletableFuture<MutableMap<String, Any>?> {
        return conversionDataCompletableFuture
    }

    fun getErrorFuture(): CompletableFuture<String?> {
        return errorCompletableFuture
    }
}
