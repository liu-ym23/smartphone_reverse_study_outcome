package com.bytedance.bdturing.u;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.bytedance.bdturing.g;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WebView f3160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Handler f3161b;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        WebView f3162f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f3163g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ b f3164h;

        a(b r1, String r2) {
            this.f3164h = r1;
            this.f3163g = r2;
            this.f3162f = b.b(r1);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Build.VERSION.SDK_INT < 19) goto L5;
            this.f3162f.evaluateJavascript("javascript:window.Native2JSBridge._handleMessageFromApp(" + this.f3163g + ")", null);
            StringBuilder r0 = new StringBuilder();
            r0.append("callJsCode ====== ");
            r0.append(this.f3163g);
            g.f("JsBridgeModule", r0.toString());
            return;
        L5:
            this.f3162f.loadUrl("javascript:window.Native2JSBridge._handleMessageFromApp('" + this.f3163g + "')");
        }
    }

    /* JADX INFO: renamed from: com.bytedance.bdturing.u.b$b, reason: collision with other inner class name */
    class RunnableC0087b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        WebView f3165f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ b f3166g;

        RunnableC0087b(b r1) {
            this.f3166g = r1;
            this.f3165f = b.b(r1);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f3165f.stopLoading();
            this.f3165f.loadUrl("about:blank");
            this.f3165f.clearCache(true);
            this.f3165f.clearHistory();
            ViewParent r0 = this.f3165f.getParent();
            if (r0 != null) goto L5;
        L7:
            this.f3165f.destroy();
            return;
        L5:
            if ((r0 instanceof ViewGroup) == false) goto L7;
            ((ViewGroup) r0).removeView(this.f3165f);
            goto L7
        }
    }

    private class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.bytedance.bdturing.u.a f3167a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f3168b;

        class a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f3169f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ c f3170g;

            a(c r1, String r2) {
                this.f3170g = r1;
                this.f3169f = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.bdturing.u.c r0 = new com.bytedance.bdturing.u.c(this.f3170g.f3168b, this.f3169f);
                c.a(this.f3170g).a(r0);
            }
        }

        public c(b r1, com.bytedance.bdturing.u.a r2) {
            this.f3168b = r1;
            this.f3167a = r2;
        }

        static /* synthetic */ com.bytedance.bdturing.u.a a(c r0) {
            return r0.f3167a;
        }

        @JavascriptInterface
        public void callMethodParams(String r3) {
            g.a("JsBridgeModule", "JS called method ======= callMethodParams(" + r3 + ")");
            if (b.a(this.f3168b) != null) goto L6;
            g.c("JsBridgeModule", "uihandler is null");
            return;
        L6:
            b.a(this.f3168b).post(new a(this, r3));
        }

        @JavascriptInterface
        public void offMethodParams(String r2) {
            g.a("JsBridgeModule", "JS called method ======= offMethodParams(" + r2 + ")");
        }

        @JavascriptInterface
        public void onMethodParams(String r2) {
            g.a("JsBridgeModule", "JS called method ======= onMethodParams(" + r2 + ")");
            new JSONObject(r2).getString("__callback_id");     // Catch: JSONException -> L5
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
        }
    }

    public b(com.bytedance.bdturing.u.a r2, WebView r3) {
        this.f3161b = null;
        this.f3160a = r3;
        if (r3 != null) goto L5;
        return;
    L5:
        r3.getSettings().setJavaScriptEnabled(true);
        this.f3160a.addJavascriptInterface(new c(this, r2), "androidJsBridge");
        this.f3161b = new Handler(Looper.getMainLooper());
    }

    static /* synthetic */ Handler a(b r0) {
        return r0.f3161b;
    }

    static /* synthetic */ WebView b(b r0) {
        return r0.f3160a;
    }

    public void c(String r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (this.f3160a == null) goto L11;
        Handler r0 = this.f3161b;
        if (r0 == null) goto L12;
        r0.post(new a(this, r3));
        g.a("JsBridgeModule", "callJsCode ====== " + r3);
        return;
    L12:
        return;
    }

    public void d() {
        if (this.f3160a != null) goto L5;
        return;
    L5:
        this.f3161b.post(new RunnableC0087b(this));
        this.f3161b = null;
        this.f3160a = null;
    }
}
