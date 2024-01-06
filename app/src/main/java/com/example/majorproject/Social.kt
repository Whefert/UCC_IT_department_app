package com.example.majorproject

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat.startActivity


class Social : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_social)

        var myToolBar: Toolbar = findViewById(R.id.myToolbar)
        setSupportActionBar(myToolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val platform = intent.getStringExtra("platform")

        supportActionBar?.title="$platform Page"
        val web: WebView = findViewById(R.id.wvSocial)
        web.webViewClient = CustomWebViewClient(this)

        val webSettings = web.settings
        webSettings.javaScriptEnabled = true

        when(platform){
            "Facebook" -> web.loadUrl("https://www.facebook.com/uccjamaica")
            "Instagram"-> web.loadUrl("https://www.instagram.com/uccjamaica")
            "Twitter"-> web.loadUrl("https://twitter.com/UCCjamaica")
        }


    }
}

//Allows external website to load within WebView element
class CustomWebViewClient internal constructor(private val activity: Activity) :
    WebViewClient() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun shouldOverrideUrlLoading(
        view: WebView?,
        request: WebResourceRequest?
    ): Boolean {
        val url: String = request?.url.toString();
        view?.loadUrl(url)
        return true
    }
    override fun shouldOverrideUrlLoading(webView: WebView, url: String): Boolean {
        webView.loadUrl(url)
        return true
    }
    override fun onReceivedError(
        view: WebView,
        request: WebResourceRequest,
        error: WebResourceError
    ) {
        Toast.makeText(activity, "Error! $error", Toast.LENGTH_SHORT).show()
    }
}