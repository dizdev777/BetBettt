package com.superslots.wingames

import android.Manifest
import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.CookieManager
import android.webkit.PermissionRequest
import android.webkit.ValueCallback
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.onesignal.OneSignal
import com.superslots.wingames.databinding.ActivityGameBonusBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class IJHUrwuqry7qwruhruu : AppCompatActivity() {
    private var jiwqirqwirqwrjiwqr: ValueCallback<Array<Uri>>? = null
    private var iqjwrhuqwrihuqwrqwrji2: ActivityResultLauncher<Intent>? = null

    lateinit var jfqworjuqwjri: ActivityGameBonusBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        jfqworjuqwjri = ActivityGameBonusBinding.inflate(layoutInflater)
        setContentView(jfqworjuqwjri.root)
        CookieManager.getInstance().setAcceptCookie(true)
        CookieManager.getInstance().setAcceptThirdPartyCookies(jfqworjuqwjri.gameBonus,true)

        qiwjrhuqwjriuhqwrij2()
        megasutijqwi(this)
        jiqwrhuqwrjiqwjirji2()
        val jiqwrqwirjiqwrji = CoroutineScope(Dispatchers.IO)
        jiqwrqwirjiqwrji.launch {
            OneSignal.Notifications.requestPermission(true)
        }
        fijqwihjrjqwiirqwuhrh2()
        intent.getStringExtra("url")?.let { jfqworjuqwjri.gameBonus.loadUrl(it) }

    }

    override fun onBackPressed() {
        if (jfqworjuqwjri.gameBonus.canGoBack())
            jfqworjuqwjri.gameBonus.goBack()
        else
            super.onBackPressed()
    }
   fun jiqwrhuqwrjiqwjirji2(){
       jfqworjuqwjri.gameBonus.settings.apply {
           javaScriptEnabled=true
           domStorageEnabled=true
           builtInZoomControls = true
           displayZoomControls = false
           allowFileAccess = true
           allowContentAccess = true
           javaScriptCanOpenWindowsAutomatically=true
           useWideViewPort = true
           databaseEnabled = true
           loadWithOverviewMode = true

       }
   }
    fun qiwjrhuqwjriuhqwrij2(){
        CookieManager.allowFileSchemeCookies()
        CookieManager.getInstance().acceptThirdPartyCookies(jfqworjuqwjri.gameBonus)
        jfqworjuqwjri.gameBonus.webViewClient= object : WebViewClient() {

            override fun onPageFinished(qwijrhuqwrjiqwr: WebView?, qhuwrhuqwrhuqwhru: String?) {
                super.onPageFinished(qwijrhuqwrjiqwr, qhuwrhuqwrhuqwhru)
                jfqworjuqwjri.gameBonus.visibility = View.VISIBLE
                CookieManager.getInstance().flush()
            }

            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                val url = request?.url.toString()
                if (url.startsWith("http")) {
                    view?.loadUrl(url)
                } else {
                    try {
                        if (ContextCompat.checkSelfPermission(
                                this@IJHUrwuqry7qwruhruu.applicationContext,
                                android.Manifest.permission.CAMERA
                            ) != PackageManager.PERMISSION_GRANTED
                        ) {
                            ActivityCompat.requestPermissions(
                                this@IJHUrwuqry7qwruhruu,
                                arrayOf(android.Manifest.permission.CAMERA),
                                201
                            )
                        } else {
                            try {
                                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                                this@IJHUrwuqry7qwruhruu.startActivity(intent)
                            } catch (e: ActivityNotFoundException) {
                                val intent = Intent(Intent.ACTION_GET_CONTENT,Uri.parse(url))
                                intent.addCategory(Intent.CATEGORY_OPENABLE)
                                intent.type = "*/*"
                                this@IJHUrwuqry7qwruhruu.startActivity(intent)
                            }

                        }


                    } catch (e: Exception) {

                    }

                }
                return true
            }
        }
    }
    private fun megasutijqwi(appCompatActivity: AppCompatActivity) {
        iqjwrhuqwrihuqwrqwrji2 = appCompatActivity.activityResultRegistry.register(
            "UploadFile",
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                if (result.data != null) {
                    val uri: Uri? = result.data?.data
                    if (uri != null && jiwqirqwirqwrjiwqr != null) {
                        jiwqirqwirqwrjiwqr?.onReceiveValue(arrayOf(uri))
                        jiwqirqwirqwrjiwqr = null
                    }
                }
            }
            else
            {
                jiwqirqwirqwrjiwqr?.onReceiveValue(null)
                jiwqirqwirqwrjiwqr = null
            }
        }
    }
    fun fijqwihjrjqwiirqwuhrh2(){
        jfqworjuqwjri.gameBonus.webChromeClient = object : WebChromeClient() {
            override fun onPermissionRequest(request: PermissionRequest?) {
                if (request?.resources?.contains("android.permission.CAMERA") == true || request?.resources?.contains(
                        "android.webkit.resource.VIDEO_CAPTURE"
                    ) == true
                ) {
                    if (ContextCompat.checkSelfPermission(
                            this@IJHUrwuqry7qwruhruu,
                            Manifest.permission.CAMERA
                        ) != PackageManager.PERMISSION_GRANTED
                    ) {
                        ActivityCompat.requestPermissions(
                            this@IJHUrwuqry7qwruhruu,
                            arrayOf(Manifest.permission.CAMERA),
                            201
                        )
                    } else {
                        request.grant(request.resources)
                    }
                } else {
                    super.onPermissionRequest(request)
                }
            }
            override fun onShowFileChooser(
                webView: WebView?, filePathCallback: ValueCallback<Array<Uri>>?,
                fileChooserParams: FileChooserParams?
            ): Boolean {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    val zaresheniegkdfgkdfgjdf = ContextCompat.checkSelfPermission(
                        this@IJHUrwuqry7qwruhruu,
                        android.Manifest.permission.READ_MEDIA_IMAGES
                    )
                    if (zaresheniegkdfgkdfgjdf != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(
                            this@IJHUrwuqry7qwruhruu, arrayOf(android.Manifest.permission.READ_MEDIA_IMAGES), 300
                        )
                    }
                    else
                    {
                        if (jiwqirqwirqwrjiwqr != null) {
                            jiwqirqwirqwrjiwqr?.onReceiveValue(null)
                            jiwqirqwirqwrjiwqr = null
                        }
                        jiwqirqwirqwrjiwqr = filePathCallback
                        val intent = Intent(Intent.ACTION_GET_CONTENT)
                        intent.addCategory(Intent.CATEGORY_OPENABLE)
                        intent.type = "*/*"
                        iqjwrhuqwrihuqwrqwrji2?.launch(Intent.createChooser(intent, "File Browser"))
                        return true
                    }
                } else {
                    val razresheniekgfkgdkf =
                        ContextCompat.checkSelfPermission(
                            this@IJHUrwuqry7qwruhruu,
                            android.Manifest.permission.READ_EXTERNAL_STORAGE
                        )
                    if (razresheniekgfkgdkf != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(
                            this@IJHUrwuqry7qwruhruu, arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),
                            200
                        )
                    }
                    else
                    {
                        if (jiwqirqwirqwrjiwqr != null) {
                            jiwqirqwirqwrjiwqr?.onReceiveValue(null)
                            jiwqirqwirqwrjiwqr = null
                        }
                        jiwqirqwirqwrjiwqr = filePathCallback
                        val intent = Intent(Intent.ACTION_GET_CONTENT)
                        intent.addCategory(Intent.CATEGORY_OPENABLE)
                        intent.type = "*/*"
                        iqjwrhuqwrihuqwrqwrji2?.launch(Intent.createChooser(intent, "File Browser"))
                        return true
                    }

                }
                return false

            }
        }
    }
}