package com.example.retrofitapi

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_pdf_view.*
import java.net.URLEncoder

class PdfView : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf_view)

        pdfView.settings.javaScriptEnabled = true

        val textName = intent.getStringExtra("textName")
        val purl = intent.getStringExtra("purl")

        val pd= ProgressDialog(this)
        pd.setTitle(textName)
        pd.setMessage("Opening.......!!!")

        pdfView.webViewClient = object : WebViewClient() {

            override fun onPageStarted(view: WebView, url: String, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                pd.show()

            }

            override fun onPageFinished(view: WebView, url: String) {
                super.onPageFinished(view, url)
                pd.dismiss()
            }

        }
        pdfView.settings.javaScriptEnabled = true
        val pdfSetting = pdfView.settings
        pdfSetting.loadWithOverviewMode =true
        pdfSetting.builtInZoomControls = true
        pdfSetting.setSupportZoom(true)
        pdfSetting.setSaveFormData(true)
        pdfSetting.useWideViewPort = true
        pdfSetting.displayZoomControls = true

        var url =""
        try {
            url= URLEncoder.encode(purl, "UTF-8")
        }catch (e: Exception){

        }

        pdfView.loadUrl("https://docs.google.com/gview?embedded=true&url=$url")
    }
}