package com.bytedance.bdturing;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public class VerifyWebView extends WebView {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private r f3017f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f3018g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected boolean f3019h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f3020i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f3021j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private i f3022k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private WebChromeClient f3023l;
    private WebViewClient m;
    private Runnable n;

    class a implements TypeEvaluator<int[]> {
        a(VerifyWebView r1) {
        }

        public int[] a(float r6, int[] r7, int[] r8) {
            int r5 = r7.length;
            int[] r0 = new int[r5];
            int r1 = 0;
        L3:
            if (r1 >= r5) goto L5;
            r0[r1] = (int) (r7[r1] + ((r8[r1] - r7[r1]) * r6));
            r1 = r1 + 1;
            goto L3
        L5:
            return r0;
        }

        @Override // android.animation.TypeEvaluator
        public /* bridge */ /* synthetic */ int[] evaluate(float r1, int[] r2, int[] r3) {
            return a(r1, r2, r3);
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ VerifyWebView f3024a;

        b(VerifyWebView r1) {
            this.f3024a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator r3) {
            ViewGroup.LayoutParams r0 = this.f3024a.getLayoutParams();
            int[] r4 = (int[]) r3.getAnimatedValue();
            r0.width = r4[0];
            r0.height = r4[1];
            this.f3024a.setLayoutParams(r0);
        }
    }

    class c extends WebChromeClient {
        c(VerifyWebView r1) {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage r4) {
            if (r4 == null) goto L4;
            String r0 = r4.message();
        L5:
            com.bytedance.bdturing.g.c("VerifyWebView", "onConsoleMessage:" + r0);
            return super.onConsoleMessage(r4);
        L4:
            r0 = "";
            goto L5
        }
    }

    class d extends WebViewClient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ VerifyWebView f3025a;

        d(VerifyWebView r1) {
            this.f3025a = r1;
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView r1, String r2) {
            super.onLoadResource(r1, r2);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView r3, String r4) {
            com.bytedance.bdturing.g.c("VerifyWebView", "onPageFinished:mIsLoadFail=" + VerifyWebView.a(this.f3025a) + ":mIsPageFinished=" + this.f3025a.f3019h);
            if (VerifyWebView.a(this.f3025a) == true) goto L7;
            VerifyWebView r0 = this.f3025a;
            if (r0.f3019h == true) goto L7;
            VerifyWebView.b(r0);
        L7:
            super.onPageFinished(r3, r4);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView r3, String r4, Bitmap r5) {
            com.bytedance.bdturing.g.c("VerifyWebView", "onPageStarted");
            super.onPageStarted(r3, r4, r5);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView r3, int r4, String r5, String r6) {
            com.bytedance.bdturing.g.c("VerifyWebView", r4 + " onReceivedError " + r5);
            if (TextUtils.isEmpty(r5) == true) goto L5;
            String r0 = r5;
        L6:
            VerifyWebView.c(this.f3025a, r4, r6, r0);
            super.onReceivedError(r3, r4, r5, r6);
            return;
        L5:
            r0 = "onReceivedError";
            goto L6
        }

        @Override // android.webkit.WebViewClient
        @RequiresApi(api = 23)
        public void onReceivedHttpError(WebView r4, WebResourceRequest r5, WebResourceResponse r6) {
            super.onReceivedHttpError(r4, r5, r6);
            if (r5.getUrl().toString().toLowerCase().contains("/favicon.ico") == false) goto L8;
            return;
        L8:
            if (r6 == null) goto L10;
            int r7 = r6.getStatusCode();
        L11:
            if (r6 == null) goto L13;
            String r8 = r6.getReasonPhrase();
        L14:
            if (r5 == null) goto L16;
            String r0 = r5.getUrl().toString();
        L17:
            com.bytedance.bdturing.g.c("VerifyWebView", "onReceivedHttpError:" + r7 + "::" + r5.isForMainFrame() + ":" + r8 + ":" + r0);
            VerifyWebView.c(this.f3025a, r7, r0, r8);
            return;
        L16:
            r0 = "";
            goto L17
        L13:
            r8 = "onReceivedHttpError";
            goto L14
        L10:
            r7 = -1;
        L6:
            e = move-exception;
            com.bytedance.bdturing.g.e(e);
            goto L8
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView r5, SslErrorHandler r6, SslError r7) {
            if (r7 == null) goto L4;
            int r0 = r7.getPrimaryError();
        L5:
            if (r7 != null) goto L7;
        L9:
            String r1 = "onReceivedSslError";
        L10:
            if (r7 == null) goto L12;
            String r2 = r7.getUrl();
        L13:
            VerifyWebView.c(this.f3025a, r0, r2, r1);
            com.bytedance.bdturing.g.c("VerifyWebView", "onReceivedSslError:" + r7 + ":" + Thread.currentThread().getName());
            super.onReceivedSslError(r5, r6, r7);
            return;
        L12:
            r2 = "";
            goto L13
        L7:
            if (r7.getCertificate() == null) goto L9;
            r1 = r7.getCertificate().toString();
            goto L10
        L4:
            r0 = -1;
            goto L5
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView r4, String r5) {
            if (r5.toLowerCase().contains("/favicon.ico") == false) goto L9;
            return new WebResourceResponse("image/png", null, null);
        L6:
            e = move-exception;
            e.printStackTrace();
        L9:
            return super.shouldInterceptRequest(r4, r5);
        }
    }

    class e implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ VerifyWebView f3026f;

        e(VerifyWebView r1) {
            this.f3026f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (VerifyWebView.d(this.f3026f) == null) goto L6;
            VerifyWebView.d(this.f3026f).b();
            return;
        }
    }

    class f implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f3027f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f3028g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f3029h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ VerifyWebView f3030i;

        f(VerifyWebView r1, int r2, String r3, String r4) {
            this.f3030i = r1;
            this.f3027f = r2;
            this.f3028g = r3;
            this.f3029h = r4;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (VerifyWebView.d(this.f3030i) == null) goto L6;
            VerifyWebView.d(this.f3030i).c(this.f3027f, this.f3028g, this.f3029h);
            return;
        }
    }

    class g implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f3031f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f3032g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ VerifyWebView f3033h;

        g(VerifyWebView r1, int r2, String r3) {
            this.f3033h = r1;
            this.f3031f = r2;
            this.f3032g = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (VerifyWebView.d(this.f3033h) == null) goto L6;
            VerifyWebView.d(this.f3033h).a(this.f3031f, this.f3032g);
            return;
        }
    }

    class h implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ VerifyWebView f3034f;

        class a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ h f3035f;

            a(h r1) {
                this.f3035f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f3035f.f3034f.reload();
            }
        }

        h(VerifyWebView r1) {
            this.f3034f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (VerifyWebView.e(this.f3034f) == true) goto L6;
            this.f3034f.post(new a(this));
            return;
        }
    }

    @RequiresApi(api = 17)
    public VerifyWebView(Context r1, AttributeSet r2) {
        super(f(r1), r2);
        this.f3018g = false;
        this.f3019h = false;
        this.f3020i = 0;
        this.f3021j = false;
        this.f3023l = new c(this);
        this.m = new d(this);
        this.n = new h(this);
    }

    static /* synthetic */ boolean a(VerifyWebView r0) {
        return r0.f3018g;
    }

    static /* synthetic */ void b(VerifyWebView r0) {
        r0.i();
    }

    static /* synthetic */ void c(VerifyWebView r0, int r1, String r2, String r3) {
        r0.h(r1, r2, r3);
    }

    static /* synthetic */ r d(VerifyWebView r0) {
        return r0.f3017f;
    }

    static /* synthetic */ boolean e(VerifyWebView r0) {
        return r0.f3021j;
    }

    @RequiresApi(api = 17)
    public static Context f(Context r2) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 >= 21) goto L5;
        return r2;
    L5:
        if (r0 <= 22) goto L7;
        return r2;
    L7:
        return r2.createConfigurationContext(new Configuration());
    }

    private void h(int r4, String r5, String r6) {
        this.f3018g = true;
        com.bytedance.bdturing.e.l(r4, r6 + "|" + r5);
        if (this.f3017f == null) goto L5;
        post(new f(this, r4, r5, r6));
    L5:
        int r7 = this.f3020i;
        if (r7 >= 3) goto L9;
        this.f3020i = r7 + 1;
        q.c().f(this.n, 500);
        return;
    L9:
        if (this.f3017f == null) goto L13;
        post(new g(this, r4, r6));
        return;
    }

    private void i() {
        com.bytedance.bdturing.g.c("VerifyWebView", "onLoadSuccess");
        com.bytedance.bdturing.e.l(0, "success");
        this.f3019h = true;
        if (this.f3017f == null) goto L6;
        post(new e(this));
        return;
    }

    public void g(r r6) {
        this.f3017f = r6;
        WebSettings r7 = getSettings();
        boolean r0 = true;
        r7.setLoadWithOverviewMode(true);
        r7.setDomStorageEnabled(true);
        r7.setAppCacheEnabled(false);
        r7.setUseWideViewPort(true);
        r7.setSupportZoom(false);
        r7.setAllowFileAccessFromFileURLs(false);
        r7.setLoadsImagesAutomatically(true);
        r7.setDefaultTextEncodingName("utf-8");
        r7.setCacheMode(2);
        r7.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        r7.setTextZoom(100);
        if (com.bytedance.bdturing.b.f().e().getRegionType() == BdTuringConfig.c.f3014k) goto L6;
        r0 = false;
    L6:
        if (r0 == true) goto L8;
    L19:
        setOverScrollMode(2);     // Catch: Throwable -> L12
    L14:
        setScrollContainer(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        if (com.bytedance.bdturing.g.d() == false) goto L17;
        setWebChromeClient(this.f3023l);
    L17:
        setWebViewClient(this.m);
        return;
    L12:
        th = move-exception;
        th.printStackTrace();
        goto L14
    L8:
        if (Build.VERSION.SDK_INT < 21) goto L19;
        r7.setMixedContentMode(0);
        goto L19
    }

    public void j(int r6, int r7, int r8, int r9) {
        ValueAnimator r10 = ValueAnimator.ofObject(new a(this), new Object[]{new int[]{r8, r9}, new int[]{r6, r7}});
        r10.addUpdateListener(new b(this));
        r10.setDuration(300).start();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.bytedance.bdturing.g.c("VerifyWebView", "onDetachedFromWindow:");
        this.f3021j = true;
        q.c().g(this.n);
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent r2) {
        i r0 = this.f3022k;
        if (r0 == null) goto L6;
        r0.c(r2);
    L6:
        return super.onTouchEvent(r2);
    }

    @Override // android.webkit.WebView
    public void reload() {
        com.bytedance.bdturing.g.c("VerifyWebView", "reload called:");
        this.f3019h = false;
        this.f3018g = false;
        super.reload();
    }

    public void setOnTouchListener(i r1) {
        this.f3022k = r1;
    }
}
