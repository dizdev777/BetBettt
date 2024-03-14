package com.superslots.wingams

import android.Manifest
import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
import com.superslots.wingams.databinding.ActivityGameBonusBinding

class BetBonus : AppCompatActivity() {
    private var theloadmess: ValueCallback<Array<Uri>>? = null
    private var egyptLaucher: ActivityResultLauncher<Intent>? = null

    lateinit var jfqworjuqwjri: ActivityGameBonusBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        jfqworjuqwjri = ActivityGameBonusBinding.inflate(layoutInflater)
        setContentView(jfqworjuqwjri.root)
        CookieManager.getInstance().setAcceptCookie(true)
        CookieManager.getInstance().setAcceptThirdPartyCookies(jfqworjuqwjri.gameBonus,true)
        fijqwhurqjiwri2()
        jiqwrjqiwrjiwi2()
        megasutijqwi(this)
        fijqwihjrjqwiirqwuhrh2()
        Log.d("fkqwjrio",intent.getStringExtra("url").toString())
        intent.getStringExtra("url")?.let { jfqworjuqwjri.gameBonus.loadUrl(it) }

    }

    override fun onBackPressed() {
        if (jfqworjuqwjri.gameBonus.canGoBack())
            jfqworjuqwjri.gameBonus.goBack()
        else
            super.onBackPressed()
    }
   fun fijqwhurqjiwri2(){
       jfqworjuqwjri.gameBonus.settings.apply {
           javaScriptEnabled=true
           domStorageEnabled=true
           javaScriptCanOpenWindowsAutomatically=true
           useWideViewPort = true
           databaseEnabled = true
           loadWithOverviewMode = true
           builtInZoomControls = true
           displayZoomControls = false
           allowFileAccess = true
           allowContentAccess = true
       }
   }
    fun jiqwrjqiwrjiwi2(){
        CookieManager.allowFileSchemeCookies()
        CookieManager.getInstance().acceptThirdPartyCookies(jfqworjuqwjri.gameBonus)
        jfqworjuqwjri.gameBonus.webViewClient= object : WebViewClient() {

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
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
                                this@BetBonus.applicationContext,
                                android.Manifest.permission.CAMERA
                            ) != PackageManager.PERMISSION_GRANTED
                        ) {
                            ActivityCompat.requestPermissions(
                                this@BetBonus,
                                arrayOf(android.Manifest.permission.CAMERA),
                                201
                            )
                        } else {
                            try {
                                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                                this@BetBonus.startActivity(intent)
                            } catch (e: ActivityNotFoundException) {
                                val intent = Intent(Intent.ACTION_GET_CONTENT,Uri.parse(url))
                                intent.addCategory(Intent.CATEGORY_OPENABLE)
                                intent.type = "*/*"
                                this@BetBonus.startActivity(intent)
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
        egyptLaucher = appCompatActivity.activityResultRegistry.register(
            "UploadFile",
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                if (result.data != null) {
                    val uri: Uri? = result.data?.data
                    if (uri != null && theloadmess != null) {
                        theloadmess?.onReceiveValue(arrayOf(uri))
                        theloadmess = null
                    }
                }
            }
            else
            {
                theloadmess?.onReceiveValue(null)
                theloadmess = null
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
                            this@BetBonus,
                            Manifest.permission.CAMERA
                        ) != PackageManager.PERMISSION_GRANTED
                    ) {
                        ActivityCompat.requestPermissions(
                            this@BetBonus,
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
                        this@BetBonus,
                        android.Manifest.permission.READ_MEDIA_IMAGES
                    )
                    if (zaresheniegkdfgkdfgjdf != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(
                            this@BetBonus, arrayOf(android.Manifest.permission.READ_MEDIA_IMAGES), 300
                        )
                    }
                    else
                    {
                        if (theloadmess != null) {
                            theloadmess?.onReceiveValue(null)
                            theloadmess = null
                        }
                        theloadmess = filePathCallback
                        val intent = Intent(Intent.ACTION_GET_CONTENT)
                        intent.addCategory(Intent.CATEGORY_OPENABLE)
                        intent.type = "*/*"
                        egyptLaucher?.launch(Intent.createChooser(intent, "File Browser"))
                        return true
                    }
                } else {
                    val razresheniekgfkgdkf =
                        ContextCompat.checkSelfPermission(
                            this@BetBonus,
                            android.Manifest.permission.READ_EXTERNAL_STORAGE
                        )
                    if (razresheniekgfkgdkf != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(
                            this@BetBonus, arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),
                            200
                        )
                    }
                    else
                    {
                        if (theloadmess != null) {
                            theloadmess?.onReceiveValue(null)
                            theloadmess = null
                        }
                        theloadmess = filePathCallback
                        val intent = Intent(Intent.ACTION_GET_CONTENT)
                        intent.addCategory(Intent.CATEGORY_OPENABLE)
                        intent.type = "*/*"
                        egyptLaucher?.launch(Intent.createChooser(intent, "File Browser"))
                        return true
                    }

                }
                return false

            }
        }
    }
}