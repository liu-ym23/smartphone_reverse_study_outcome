package com.obric.oui.window.permission;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.net.MailTo;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.window.embedding.EmbeddingCompat;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.common.oui.f;
import com.obric.common.oui.g;
import com.obric.common.oui.i;
import com.obric.oui.button.OButton;
import com.obric.oui.titlebar.optimize.OCTitleBar;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class WebViewActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private WebView f11643f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ProgressBar f11644g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private TextView f11645h;

    class a extends WebViewClient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ WebViewActivity f11646a;

        a(WebViewActivity r1) {
            this.f11646a = r1;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView r1, String r2) {
            super.onPageFinished(r1, r2);
            WebViewActivity.v(this.f11646a).setVisibility(8);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView r1, String r2, Bitmap r3) {
            super.onPageStarted(r1, r2, r3);
            WebViewActivity.v(this.f11646a).setVisibility(0);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView r1, WebResourceRequest r2, WebResourceError r3) {
            super.onReceivedError(r1, r2, r3);
            StringBuilder r4 = new StringBuilder();
            r4.append("onReceivedError: ");
            if (r3 == null) goto L5;
            CharSequence r5 = r3.getDescription();
        L6:
            r4.append(r5);
            Log.e("WebViewActivity", r4.toString());
            WebViewActivity.w(this.f11646a);
            return;
        L5:
            r5 = "unknown error";
            goto L6
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView r4, WebResourceRequest r5) {
            String r3 = r5.getUrl().toString();
            if (r3.startsWith("tel:") == false) goto L5;
        L23:
            r4.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(r3)));     // Catch: Exception -> L20
            return true;
        L20:
            Log.e("WebViewActivity", "shouldOverrideUrlLoading can resolve : " + r3);
        L21:
            r4.loadUrl(r3);
            return true;
        L5:
            if (r3.startsWith(MailTo.MAILTO_SCHEME) == true) goto L23;
            if (r3.startsWith("sms:") == true) goto L23;
            if (r3.startsWith("smsto:") == true) goto L23;
            if (r3.startsWith("market:") == true) goto L23;
            if (r3.startsWith("geo:") == true) goto L23;
            if (r3.startsWith("whatsapp:") == true) goto L23;
            if (r3.startsWith("intent:") == false) goto L21;
            goto L21
        }
    }

    class b extends WebChromeClient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ WebViewActivity f11647a;

        b(WebViewActivity r1) {
            this.f11647a = r1;
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView r1, int r2) {
            WebViewActivity.v(this.f11647a).setProgress(r2);
            if (r2 != 100) goto L6;
            WebViewActivity.v(this.f11647a).setVisibility(8);
            return;
        }
    }

    class c implements OnApplyWindowInsetsListener {
        c(WebViewActivity r1) {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View r4, WindowInsetsCompat r5) {
            int r3 = r5.getSystemWindowInsetTop();
            r4.setPadding(r4.getPaddingLeft(), r3, r4.getPaddingRight(), 0);
            return r5;
        }
    }

    public WebViewActivity() {
    }

    private /* synthetic */ void B(View r2) {
        if (d.g.d.f.c.a(this) == false) goto L6;
        this.f11645h.setVisibility(8);
        this.f11643f.setVisibility(0);
        this.f11643f.reload();
        return;
    }

    public static void D(Context r2, String r3, String r4) {
        Intent r0 = new Intent(r2, WebViewActivity.class);
        r0.putExtra("extra_url", r3);
        r0.putExtra("extra_title", r4);
        r2.startActivity(r0);
    }

    private void E() {
        this.f11643f.setVisibility(8);
        this.f11645h.setVisibility(0);
        if (d.g.d.f.c.a(this) == false) goto L5;
        TextView r0 = this.f11645h;
        int r1 = i.f8275l;
    L6:
        r0.setText(r1);
        this.f11645h.setOnClickListener(new com.obric.oui.window.permission.b(this));
        return;
    L5:
        r0 = this.f11645h;
        r1 = i.m;
        goto L6
    }

    static /* synthetic */ ProgressBar v(WebViewActivity r0) {
        return r0.f11644g;
    }

    static /* synthetic */ void w(WebViewActivity r0) {
        r0.E();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = EmbeddingCompat.DEBUG, value = "onStop")
    public static void x(WebViewActivity r2) {
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

    private Boolean y() {
        return Boolean.valueOf(!getWindow().getDecorView().getFitsSystemWindows());
    }

    private /* synthetic */ void z(View r1) {
        finish();
    }

    public /* synthetic */ void A(View r1) {
        z(r1);
    }

    public /* synthetic */ void C(View r1) {
        B(r1);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f11643f.canGoBack() == false) goto L5;
        this.f11643f.goBack();
        return;
    L5:
        finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        super.onContentChanged();
        View r0 = ((ViewGroup) findViewById(R.id.content)).getChildAt(0);
        if (y().booleanValue() == false) goto L6;
        ViewCompat.setOnApplyWindowInsetsListener(r0, new c(this));
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"SetJavaScriptEnabled"})
    protected void onCreate(@Nullable Bundle r4) {
        super.onCreate(r4);
        setContentView(g.f8252b);
        Window r5 = getWindow();
        int r0 = com.obric.common.oui.c.D;
        r5.setStatusBarColor(getColor(r0));
        r5.setNavigationBarColor(getColor(r0));
        int r6 = Build.VERSION.SDK_INT;
        if (r6 < 30) goto L5;
        d.g.d.f.a.a(this);
    L5:
        this.f11643f = (WebView) findViewById(f.X0);
        this.f11644g = (ProgressBar) findViewById(f.I0);
        this.f11645h = (TextView) findViewById(f.P);
        String r1 = getIntent().getStringExtra("extra_title");
        if (TextUtils.isEmpty(r1) == false) goto L8;
        r1 = getString(i.o);
    L8:
        OCTitleBar r2 = (OCTitleBar) findViewById(f.Y0);
        if (r2 == null) goto L13;
        r2.setTitleText(r1);
        OButton r3 = r2.getMLeftActionBack();
        if (r3 == null) goto L13;
        r3.setOnClickListener(new com.obric.oui.window.permission.a(this));
    L13:
        this.f11643f.setBackgroundColor(ContextCompat.getColor(this, r0));
        this.f11643f.setLayerType(2, null);
        WebSettings r7 = this.f11643f.getSettings();
        r7.setJavaScriptEnabled(true);
        r7.setDomStorageEnabled(true);
        r7.setLoadWithOverviewMode(true);
        r7.setUseWideViewPort(true);
        if (r6 < 33) goto L16;
        r7.setAlgorithmicDarkeningAllowed(true);
    L16:
        this.f11643f.setWebViewClient(new a(this));
        this.f11643f.setWebChromeClient(new b(this));
        String r8 = getIntent().getStringExtra("extra_url");
        if (r8 == null) goto L20;
        this.f11643f.loadUrl(r8);
        return;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        x(this);
    }

    public void u() {
        super.onStop();
    }
}
