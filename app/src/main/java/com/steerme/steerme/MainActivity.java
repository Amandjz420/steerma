package com.steerme.steerme;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.view.KeyEvent;
import android.app.Activity;

public class MainActivity extends Activity {

  private WebView webView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    webView = findViewById(R.id.webView);
    WebSettings webSettings = webView.getSettings();
    webSettings.setJavaScriptEnabled(true);
    webView.getSettings().setUserAgentString("here");
    webView.setWebViewClient(new WebViewClient() {
      @Override
      public void onPageFinished(WebView view, String url) {
        //hide loading image
        findViewById(R.id.imageView).setVisibility(View.GONE);
        //show webview
        findViewById(R.id.webView).setVisibility(View.VISIBLE);
      }
    });
    webView.loadUrl("https://steerme.glideapp.io");
    Log.i("'MAIN_ACTIVITY'", "initiated sjndsaknk");

  }

  @Override
  public boolean onKeyDown(int keyCode, KeyEvent event) {
    if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
      webView.goBack();
      return true;
    }
    return true;
//    return super.onKeyDown(keyCode, event);
  }

  @Override
  public void onBackPressed() {
    if(webView.canGoBack()){
      webView.goBack();
    }else {
//      super.onBackPressed();
    }
  }
}

