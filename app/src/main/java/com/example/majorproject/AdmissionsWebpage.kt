package com.example.majorproject


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.widget.Toolbar


class AdmissionsWebpage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admissions_webpage)

        var myToolBar: Toolbar = findViewById(R.id.myToolbar)
        setSupportActionBar(myToolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val web: WebView = findViewById(R.id.wvUCCAdmissions)
        web.webViewClient = CustomWebViewClient(this)

        val webSettings = web.settings
        webSettings.javaScriptEnabled = true

    web.loadUrl("https://www.instagram.com/uccjamaica")
        }
}
