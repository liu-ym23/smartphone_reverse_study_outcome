package obric.widget.search;

import android.content.Intent;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;

/* JADX INFO: loaded from: classes5.dex */
public interface WebSearch {
    DownloadListener getDownloadListener();

    WebChromeClient getWebChromeClient();

    WebViewClient getWebViewClient();

    void onActivityResult(int requestCode, int resultCode, Intent data);

    void performSearch(String url);
}
