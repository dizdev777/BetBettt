package com.superslots.wingames

import android.content.Context
import androidx.lifecycle.ViewModel
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class JIhuuHUWQrh : ViewModel() {
    val iqjwrjiqwjirqijwrjiqw = ""
    val jiqwjiriqwrjiqwor = "JDt69d7fVFM33F6KuWHh5A"
    lateinit var iijhuy7UHu8qhuqwr: String

    fun jiqwruqy7wrqjiurhiqwrjqir(context: Context, result: (MutableMap<String,Any>?) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            iijhuy7UHu8qhuqwr = hqiwjrhuqwrjiqiwr2(context) ?: ""
        }
        val conversionDataListener = object : AppsFlyerConversionListener {
            override fun onConversionDataSuccess(data: MutableMap<String, Any>) {
                result.invoke(data)
            }

            override fun onConversionDataFail(error: String?) {
                result.invoke(null)
            }

            override fun onAppOpenAttribution(p0: MutableMap<String, String>?) {

            }

            override fun onAttributionFailure(error: String?) {

            }
        }
        AppsFlyerLib.getInstance().init(jiqwjiriqwrjiqwor, conversionDataListener, context.applicationContext)
        AppsFlyerLib.getInstance().start(context)

    }

    fun buildFinalLink(baseLink: String, path: String, queryParams: Map<String, String>): String {
        val ijqwrhuqhwr7u2rhuirj = StringBuilder(baseLink)

        if (path.isNotEmpty() && !path.startsWith("/")) {
            ijqwrhuqhwr7u2rhuirj.append('/')
        }

        ijqwrhuqhwr7u2rhuirj.append(path)

        if (queryParams.isNotEmpty()) {
            ijqwrhuqhwr7u2rhuirj.append('?')

            for ((qjiwjriqjiwrjiw, qhuwirjiqwjirjiqwr) in queryParams) {
                ijqwrhuqhwr7u2rhuirj.append(qwuhirhuwqrhuqhuru2(qjiwjriqjiwrjiw))
                ijqwrhuqhwr7u2rhuirj.append('=')
                ijqwrhuqhwr7u2rhuirj.append(qwuhirhuwqrhuqhuru2(qhuwirjiqwjirjiqwr))
                ijqwrhuqhwr7u2rhuirj.append('&')
            }

            ijqwrhuqhwr7u2rhuirj.deleteCharAt(ijqwrhuqhwr7u2rhuirj.length - 1)
        }

        return ijqwrhuqhwr7u2rhuirj.toString()
    }

    private fun qwuhirhuwqrhuqhuru2(hqiwrjiqwirjiwjr: String): String {
        return java.net.URLEncoder.encode(hqiwrjiqwirjiwjr, "UTF-8")
    }

    private fun hqiwjrhuqwrjiqiwr2(uqhwirjiqwrjqwr: Context): String? {
        return try {
            AdvertisingIdClient.getAdvertisingIdInfo(uqhwirjiqwrjqwr).id
        } catch (e: Exception) {
            null
        }
    }
}
