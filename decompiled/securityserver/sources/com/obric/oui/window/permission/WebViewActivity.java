package com.obric.oui.window.permission;

import android.R;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.obric.oui.button.OButton;
import com.obric.oui.titlebar.optimize.OCTitleBar;
import com.obric.oui.utils.ActivityUtils;

/* JADX INFO: loaded from: classes2.dex */
public class WebViewActivity extends AppCompatActivity {
    public static final /* synthetic */ int f = 0;
    public WebView b;
    public ProgressBar c;
    public TextView e;

    /* JADX INFO: renamed from: com.obric.oui.window.permission.WebViewActivity$3, reason: invalid class name */
    class AnonymousClass3 implements OnApplyWindowInsetsListener {
        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View r4, WindowInsetsCompat r5) {
            int r3 = r5.getSystemWindowInsetTop();
            r4.setPadding(r4.getPaddingLeft(), r3, r4.getPaddingRight(), 0);
            return r5;
        }
    }

    public WebViewActivity() {
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        if (this.b.canGoBack() == false) goto L5;
        this.b.goBack();
        return;
    L5:
        finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.Window.Callback
    public final void onContentChanged() {
        super.onContentChanged();
        View r0 = ((ViewGroup) findViewById(R.id.content)).getChildAt(0);
        if ((!getWindow().getDecorView().getFitsSystemWindows()) == false) goto L6;
        ViewCompat.setOnApplyWindowInsetsListener(r0, new AnonymousClass3());
        return;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        setContentView(com.bytedance.securityserver.R.layout.activity_webview);
        Window r5 = getWindow();
        r5.setStatusBarColor(getColor(com.bytedance.securityserver.R.color.oui_bg_base_1));
        r5.setNavigationBarColor(getColor(com.bytedance.securityserver.R.color.oui_bg_base_1));
        ActivityUtils.a(this);
        this.b = (WebView) findViewById(com.bytedance.securityserver.R.id.webView);
        this.c = (ProgressBar) findViewById(com.bytedance.securityserver.R.id.progressBar);
        this.e = (TextView) findViewById(com.bytedance.securityserver.R.id.errorView);
        String r6 = getIntent().getStringExtra("extra_title");
        if (TextUtils.isEmpty(r6) == false) goto L5;
        r6 = getString(com.bytedance.securityserver.R.string.title_privacy_policy_and_user_agreement);
    L5:
        OCTitleBar r1 = (OCTitleBar) findViewById(com.bytedance.securityserver.R.id.web_activity_title_bar);
        if (r1 == null) goto L10;
        r1.setTitleText(r6);
        OButton r7 = r1.getMLeftActionBack();
        if (r7 == null) goto L10;
        r7.setOnClickListener(new a(this, 1));
    L10:
        this.b.setBackgroundColor(ContextCompat.getColor(this, com.bytedance.securityserver.R.color.oui_bg_base_1));
        this.b.setLayerType(2, null);
        WebSettings r8 = this.b.getSettings();
        r8.setJavaScriptEnabled(true);
        r8.setDomStorageEnabled(true);
        r8.setLoadWithOverviewMode(true);
        r8.setUseWideViewPort(true);
        r8.setAlgorithmicDarkeningAllowed(true);
        this.b.setWebViewClient(new AnonymousClass1(this));
        this.b.setWebChromeClient(new AnonymousClass2(this));
        String r9 = getIntent().getStringExtra("extra_url");
        if (r9 == null) goto L14;
        this.b.loadUrl(r9);
        return;
    }
}
