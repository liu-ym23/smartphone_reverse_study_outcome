package com.ss.android.larksso;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.window.embedding.EmbeddingCompat;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import java.net.URLDecoder;
import java.util.List;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import os.teatracker.IBdInstall;

/* JADX INFO: loaded from: classes2.dex */
public class LarkSSOActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private WebView f12009f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f12010g;

    class a implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ LarkSSOActivity f12011f;

        a(LarkSSOActivity r1) {
            this.f12011f = r1;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r1) {
            LarkSSOActivity.v(this.f12011f);
            LarkSSOActivity.w(this.f12011f);
        }
    }

    class b extends WebViewClient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ LarkSSOActivity f12012a;

        b(LarkSSOActivity r1) {
            this.f12012a = r1;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView r4, String r5) {
            if (LarkSSOActivity.x(this.f12012a, r5) == false) goto L7;
            LarkSSOActivity.v(this.f12012a);
            LarkSSOActivity.y(this.f12012a, r5);
            return true;
        L7:
            if (TextUtils.isEmpty(r5) == true) goto L13;
            if (r5.contains("https://www.feishu.cn/download") == false) goto L13;
            Intent r6 = new Intent();
            r6.setAction("android.intent.action.VIEW");
            r6.setData(Uri.parse("https://www.feishu.cn/download"));
            this.f12012a.startActivity(r6);
            return true;
        L13:
            return super.shouldOverrideUrlLoading(r4, r5);
        }
    }

    public LarkSSOActivity() {
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = EmbeddingCompat.DEBUG, value = "onStop")
    public static void A(LarkSSOActivity r2) {
        r2.u();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT < 21) goto L12;
        r2.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L8
        return;
    L13:
        return;
    }

    private void B() {
        F();
        ActionBar r0 = getSupportActionBar();
        if (r0 == null) goto L5;
        r0.hide();
    L5:
        ((ImageView) findViewById(e.f12033a)).setOnClickListener(new a(this));
    }

    private void C() {
        Uri r0 = Uri.parse(this.f12010g);     // Catch: Exception -> L4
        String r1 = String.format("%s://oauth/failure?state=%s&code=%s&err_code=0", new Object[]{r0.getQueryParameter(IBdInstall.PARAM_APP_ID), r0.getQueryParameter(WsConstants.KEY_CONNECTION_STATE), i.f12043k.a()});     // Catch: Exception -> L4
        Intent r2 = getIntent();     // Catch: Exception -> L4
        r2.setData(Uri.parse(r1));     // Catch: Exception -> L4
        setResult(0, r2);     // Catch: Exception -> L4
        finish();     // Catch: Exception -> L4
        return;
    L4:
        com.ss.android.larksso.l.c.h("LarkSSOActivity", "errorCallBack, Jump back to SSOSDK failed");
    }

    private String D(String r6) {
        if (TextUtils.isEmpty(r6) == true) goto L16;
        List<String> r0 = j.a(this, r6);
        if (r0 != null) goto L7;
    L14:
        Log.i("LarkSSOActivity", "the md5 list is null");
        return "";
    L7:
        if (r0.size() == 0) goto L14;
        if (G(r6, r0.get(0)) == true) goto L12;
        String r5 = "Package name and signature verification failed";
    L17:
        Log.i("LarkSSOActivity", r5);
        return "";
    L12:
        return r0.get(0);
    L16:
        r5 = "the PackageName is null";
        goto L17
    }

    private void E() {
        if (getCallingActivity() != null) goto L5;
        return;
    L5:
        String r0 = getCallingActivity().getPackageName();
        this.f12010g = this.f12010g.concat(String.format("&%s=%s&%s=%s", new Object[]{"package_id", r0, "signature", D(r0)}));
        Log.i("LarkSSOActivity", "buildUrl is:" + this.f12010g);
    }

    private void F() {
        if (h.d(this, getWindow()) == false) goto L6;
        k.e(this, -1);
        return;
    }

    private boolean G(String r2, String r3) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r3) == false) goto L8;
        return false;
    L8:
        return j.c(this, r2, r3);
    }

    private boolean H(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return false;
    L5:
        Uri r2 = Uri.parse(r3);
        if (r2 != null) goto L9;
        return false;
    L9:
        if ("oauth".equals(r2.getHost()) == true) goto L11;
        return false;
    L11:
        if (TextUtils.isEmpty(r2.getQueryParameter(WsConstants.KEY_CONNECTION_STATE)) == false) goto L13;
        return false;
    L13:
        if (TextUtils.isEmpty(r2.getQueryParameter("code")) == true) goto L18;
        return true;
    L18:
        return false;
    }

    private void I() {
        this.f12010g = URLDecoder.decode(this.f12010g, "UTF-8");     // Catch: Exception -> L4
    L5:
        WebView r0 = (WebView) findViewById(e.f12034b);
        this.f12009f = r0;
        r0.getSettings().setJavaScriptEnabled(true);
        this.f12009f.setWebViewClient(new b(this));
        this.f12009f.setWebChromeClient(new WebChromeClient());
        d.a(this.f12009f, this.f12010g);
        return;
    L4:
        C();
        goto L5
    }

    private void J() {
        CookieSyncManager r2 = CookieSyncManager.createInstance(this.f12009f.getContext());
        CookieManager r0 = CookieManager.getInstance();
        r0.setAcceptCookie(true);
        r0.removeSessionCookie();
        r0.removeAllCookie();
        r2.sync();
    }

    private void K(String r3) {
        Intent r1 = getIntent();     // Catch: Exception -> L5
        r1.setData(Uri.parse(r3));     // Catch: Exception -> L5
        setResult(-1, r1);     // Catch: Exception -> L5
        com.ss.android.larksso.l.c.h("LarkSSOActivity", "successCallBack, Jump back from WebView successfully");     // Catch: Exception -> L5
        finish();     // Catch: Exception -> L5
        return;
    L5:
        com.ss.android.larksso.l.c.h("LarkSSOActivity", "successCallBack, Jump back to SSOSDK failed");
    }

    static /* synthetic */ void v(LarkSSOActivity r0) {
        r0.J();
    }

    static /* synthetic */ void w(LarkSSOActivity r0) {
        r0.z();
    }

    static /* synthetic */ boolean x(LarkSSOActivity r0, String r1) {
        return r0.H(r1);
    }

    static /* synthetic */ void y(LarkSSOActivity r0, String r1) {
        r0.K(r1);
    }

    private void z() {
        Uri r0 = Uri.parse(this.f12010g);     // Catch: Exception -> L4
        String r1 = String.format("%s://oauth/cancel?state=%s&code=%s", new Object[]{r0.getQueryParameter(IBdInstall.PARAM_APP_ID), r0.getQueryParameter(WsConstants.KEY_CONNECTION_STATE), i.f12041i.a()});     // Catch: Exception -> L4
        Intent r2 = getIntent();     // Catch: Exception -> L4
        r2.setData(Uri.parse(r1));     // Catch: Exception -> L4
        setResult(0, r2);     // Catch: Exception -> L4
        finish();     // Catch: Exception -> L4
        return;
    L4:
        com.ss.android.larksso.l.c.h("LarkSSOActivity", "cancelCallBack, Jump back to SSOSDK failed");
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        J();
        z();
        super.onBackPressed();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r3) {
        super.onCreate(r3);
        setContentView(f.f12036a);
        B();
        Intent r4 = getIntent();
        if (TextUtils.isEmpty(r4.getStringExtra("build_url")) == false) goto L6;
        finish();
        return;
    L6:
        this.f12010g = r4.getStringExtra("build_url");
        E();
        I();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        A(this);
    }

    public void u() {
        super.onStop();
    }
}
