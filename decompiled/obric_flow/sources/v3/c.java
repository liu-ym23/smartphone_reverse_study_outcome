package v3;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SafeBrowsingResponse;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.android.anniex.container.AnnieXContainer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AnnieXContainer f22511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WebViewClient f22512b;

    public c(AnnieXContainer r5, WebViewClient r10) {
        Intrinsics.checkNotNullParameter(r5, "container");
        this.f22511a = r5;
        this.f22512b = r10;
    }

    @Override // android.webkit.WebViewClient
    public final void doUpdateVisitedHistory(WebView r5, String r10, boolean r11) {
        super.doUpdateVisitedHistory(r5, r10, r11);
        WebViewClient r12 = this.f22512b;
        if (r12 == null) goto L6;
        r12.doUpdateVisitedHistory(r5, r10, r11);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final void onFormResubmission(WebView r5, Message r10, Message r11) {
        super.onFormResubmission(r5, r10, r11);
        WebViewClient r12 = this.f22512b;
        if (r12 == null) goto L6;
        r12.onFormResubmission(r5, r10, r11);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView r5, String r10) {
        super.onLoadResource(r5, r10);
        WebViewClient r11 = this.f22512b;
        if (r11 == null) goto L6;
        r11.onLoadResource(r5, r10);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageCommitVisible(WebView r5, String r10) {
        super.onPageCommitVisible(r5, r10);
        WebViewClient r11 = this.f22512b;
        if (r11 == null) goto L6;
        r11.onPageCommitVisible(r5, r10);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView r5, String r10) {
        super.onPageFinished(r5, r10);
        WebViewClient r11 = this.f22512b;
        if (r11 == null) goto L5;
        r11.onPageFinished(r5, r10);
    L5:
        this.f22511a.onWebPageFinish(r5, r10);
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView r5, String r10, Bitmap r11) {
        super.onPageStarted(r5, r10, r11);
        WebViewClient r12 = this.f22512b;
        if (r12 == null) goto L6;
        r12.onPageStarted(r5, r10, r11);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedClientCertRequest(WebView r5, ClientCertRequest r10) {
        super.onReceivedClientCertRequest(r5, r10);
        WebViewClient r11 = this.f22512b;
        if (r11 == null) goto L6;
        r11.onReceivedClientCertRequest(r5, r10);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView r5, int r10, String r11, String r12) {
        super.onReceivedError(r5, r10, r11, r12);
        WebViewClient r13 = this.f22512b;
        if (r13 == null) goto L6;
        r13.onReceivedError(r5, r10, r11, r12);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpAuthRequest(WebView r5, HttpAuthHandler r10, String r11, String r12) {
        super.onReceivedHttpAuthRequest(r5, r10, r11, r12);
        WebViewClient r13 = this.f22512b;
        if (r13 == null) goto L6;
        r13.onReceivedHttpAuthRequest(r5, r10, r11, r12);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpError(WebView r5, WebResourceRequest r10, WebResourceResponse r11) {
        super.onReceivedHttpError(r5, r10, r11);
        WebViewClient r12 = this.f22512b;
        if (r12 == null) goto L6;
        r12.onReceivedHttpError(r5, r10, r11);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedLoginRequest(WebView r5, String r10, String r11, String r12) {
        super.onReceivedLoginRequest(r5, r10, r11, r12);
        WebViewClient r13 = this.f22512b;
        if (r13 == null) goto L6;
        r13.onReceivedLoginRequest(r5, r10, r11, r12);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(WebView r5, SslErrorHandler r10, SslError r11) {
        super.onReceivedSslError(r5, r10, r11);
        WebViewClient r12 = this.f22512b;
        if (r12 == null) goto L6;
        r12.onReceivedSslError(r5, r10, r11);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView r5, RenderProcessGoneDetail r10) {
        WebViewClient r11 = this.f22512b;
        if (r11 == null) goto L6;
        r11.onRenderProcessGone(r5, r10);
    L6:
        return super.onRenderProcessGone(r5, r10);
    }

    @Override // android.webkit.WebViewClient
    public final void onSafeBrowsingHit(WebView r5, WebResourceRequest r10, int r11, SafeBrowsingResponse r12) {
        WebViewClient r13 = this.f22512b;
        if (r13 == null) goto L5;
        r13.onSafeBrowsingHit(r5, r10, r11, r12);
    L5:
        super.onSafeBrowsingHit(r5, r10, r11, r12);
    }

    @Override // android.webkit.WebViewClient
    public final void onScaleChanged(WebView r5, float r10, float r11) {
        super.onScaleChanged(r5, r10, r11);
        WebViewClient r12 = this.f22512b;
        if (r12 == null) goto L6;
        r12.onScaleChanged(r5, r10, r11);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final void onTooManyRedirects(WebView r5, Message r10, Message r11) {
        super.onTooManyRedirects(r5, r10, r11);
        WebViewClient r12 = this.f22512b;
        if (r12 == null) goto L6;
        r12.onTooManyRedirects(r5, r10, r11);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final void onUnhandledKeyEvent(WebView r5, KeyEvent r10) {
        super.onUnhandledKeyEvent(r5, r10);
        WebViewClient r11 = this.f22512b;
        if (r11 == null) goto L6;
        r11.onUnhandledKeyEvent(r5, r10);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView r5, String r10) {
        WebViewClient r11 = this.f22512b;
        if (r11 == null) goto L6;
        r11.shouldInterceptRequest(r5, r10);
    L6:
        return super.shouldInterceptRequest(r5, r10);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideKeyEvent(WebView r5, KeyEvent r10) {
        WebViewClient r11 = this.f22512b;
        if (r11 == null) goto L6;
        r11.shouldOverrideKeyEvent(r5, r10);
    L6:
        return super.shouldOverrideKeyEvent(r5, r10);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView r5, String r10) {
        WebViewClient r11 = this.f22512b;
        if (r11 == null) goto L6;
        r11.shouldOverrideUrlLoading(r5, r10);
    L6:
        return super.shouldOverrideUrlLoading(r5, r10);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView r5, WebResourceRequest r10, WebResourceError r11) {
        super.onReceivedError(r5, r10, r11);
        WebViewClient r12 = this.f22512b;
        if (r12 == null) goto L6;
        r12.onReceivedError(r5, r10, r11);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView r5, WebResourceRequest r10) {
        WebViewClient r11 = this.f22512b;
        if (r11 == null) goto L6;
        r11.shouldInterceptRequest(r5, r10);
    L6:
        return super.shouldInterceptRequest(r5, r10);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView r5, WebResourceRequest r10) {
        WebViewClient r11 = this.f22512b;
        if (r11 == null) goto L6;
        r11.shouldOverrideUrlLoading(r5, r10);
    L6:
        return super.shouldOverrideUrlLoading(r5, r10);
    }
}
