package com.obric.oui.window.permission;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.common.oui.R;
import com.obric.olog.OLog;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.oui.utils.ActivityUtils;
import com.obric.oui.utils.NetworkUtil;
import com.obric.oui.window.OWindowConfigController;
import com.obric.privacy.GrantUtil;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes5.dex */
public class WebViewActivity extends AppCompatActivity {
    private static final String EXTRA_TITLE = "extra_title";
    private static final String EXTRA_URL = "extra_url";
    private static final String TAG = "WebViewActivity";
    private TextView errorView;
    private Runnable mPendingReloadTimeoutRunnable;
    private ShowWebViewRunnable mPendingShowWebViewRunnable;
    private boolean mReloadingFromErrorPage;
    private WebView webView;

    private static class ShowWebViewRunnable implements Runnable {
        private final WeakReference<WebView> webViewRef;

        public ShowWebViewRunnable(WebView r2) {
            this.webViewRef = new WeakReference(r2);
        }

        @Override // java.lang.Runnable
        public void run() {
            WebView r1 = this.webViewRef.get();
            if (r1 == null) goto L6;
            r1.setAlpha(1.0f);
            return;
        }
    }

    public void com_obric_oui_window_permission_WebViewActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_obric_oui_window_permission_WebViewActivity__onResume$___twin___() {
        super.onResume();
    }

    public void com_obric_oui_window_permission_WebViewActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_obric_oui_window_permission_WebViewActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_obric_oui_window_permission_WebViewActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_obric_oui_window_permission_WebViewActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_obric_oui_window_permission_WebViewActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com_obric_oui_window_permission_WebViewActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_obric_oui_window_permission_WebViewActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public WebViewActivity() {
    }

    static /* synthetic */ boolean access$000(WebViewActivity r0) {
        return r0.mReloadingFromErrorPage;
    }

    static /* synthetic */ boolean access$002(WebViewActivity r0, boolean r1) {
        r0.mReloadingFromErrorPage = r1;
        return r1;
    }

    static /* synthetic */ Runnable access$100(WebViewActivity r0) {
        return r0.mPendingReloadTimeoutRunnable;
    }

    static /* synthetic */ TextView access$200(WebViewActivity r0) {
        return r0.errorView;
    }

    static /* synthetic */ WebView access$300(WebViewActivity r0) {
        return r0.webView;
    }

    static /* synthetic */ ShowWebViewRunnable access$400(WebViewActivity r0) {
        return r0.mPendingShowWebViewRunnable;
    }

    static /* synthetic */ void access$500(WebViewActivity r0) {
        r0.showErrorPage();
    }

    public static void open(Context r2, String r3, String r4) {
        Intent r0 = new Intent(r2, WebViewActivity.class);
        r0.putExtra(EXTRA_URL, r3);
        r0.putExtra(EXTRA_TITLE, r4);
        r2.startActivity(r0);
    }

    public void com_obric_oui_window_permission_WebViewActivity__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        setContentView(R.layout.activity_webview);
        Window r5 = getWindow();
        r5.getDecorView().setSystemUiVisibility(1792);
        ActivityUtils.adaptLightDarkSystemBars(this);
        r5.setStatusBarColor(0);
        r5.setNavigationBarColor(0);
        r5.setNavigationBarContrastEnforced(false);
        this.webView = (WebView) findViewById(R.id.webView);
        this.mPendingShowWebViewRunnable = new ShowWebViewRunnable(this.webView);
        this.errorView = (TextView) findViewById(R.id.errorView);
        String r6 = getIntent().getStringExtra(EXTRA_TITLE);
        if (TextUtils.isEmpty(r6) == false) goto L5;
        r6 = getString(R.string.title_privacy_policy_and_user_agreement);
    L5:
        OFloatingTitleBar r0 = (OFloatingTitleBar) findViewById(R.id.web_activity_title_bar);
        if (r0 == null) goto L8;
        r0.setCenterTitle(r6);
        r0.addStartAction(R.drawable.o_floating_title_bar_icon_back, -1, new WebViewActivity$$ExternalSyntheticLambda0(this));
    L8:
        this.webView.setLayerType(2, null);
        WebSettings r7 = this.webView.getSettings();
        r7.setJavaScriptEnabled(true);
        r7.setDomStorageEnabled(true);
        r7.setLoadWithOverviewMode(true);
        r7.setUseWideViewPort(true);
        r7.setAlgorithmicDarkeningAllowed(true);
        this.webView.setAlpha(0.0f);
        this.webView.setWebViewClient(new AnonymousClass1(this));
        this.webView.setWebChromeClient(new AnonymousClass2(this));
        String r8 = getIntent().getStringExtra(EXTRA_URL);
        if (r8 == null) goto L11;
        Log.d(TAG, "onCreate: start load url " + r8);
        this.webView.loadUrl(r8);
    L11:
        this.webView.setOnApplyWindowInsetsListener(new WebViewActivity$$ExternalSyntheticLambda1(this));
    }

    /* JADX INFO: renamed from: lambda$onCreate$0$com-obric-oui-window-permission-WebViewActivity, reason: not valid java name */
    /* synthetic */ void m1462x6c03b53d(View r1) {
        onBackPressed();
    }

    /* JADX INFO: renamed from: lambda$onCreate$1$com-obric-oui-window-permission-WebViewActivity, reason: not valid java name */
    /* synthetic */ WindowInsets m1463x6b8d4f3e(View r2, WindowInsets r3) {
        int r0 = OWindowConfigController.getSystemBarInsetsInfo(r2, r3).bottom;
        if (OWindowConfigController.isGestureNavigation(r2.getContext()) == false) goto L5;
        r0 = 0;
    L5:
        updateLayoutForInsetBottom(r0);
        return r3;
    }

    private void showErrorPage() {
        Log.w(TAG, "showErrorPage");
        this.mReloadingFromErrorPage = false;
        Runnable r1 = this.mPendingReloadTimeoutRunnable;
        if (r1 == null) goto L5;
        this.webView.removeCallbacks(r1);
    L5:
        this.webView.setVisibility(8);
        this.errorView.setVisibility(0);
        if (NetworkUtil.isNetworkAvailable(this) == false) goto L8;
        this.errorView.setText(R.string.tip_load_fail);
    L9:
        this.errorView.setOnClickListener(new WebViewActivity$$ExternalSyntheticLambda3(this));
        return;
    L8:
        this.errorView.setText(R.string.tip_load_fail_no_network);
        goto L9
    }

    /* JADX INFO: renamed from: lambda$showErrorPage$3$com-obric-oui-window-permission-WebViewActivity, reason: not valid java name */
    /* synthetic */ void m1465x72207c25(View r3) {
        if (NetworkUtil.isNetworkAvailable(this) == false) goto L9;
        this.errorView.setVisibility(8);
        this.webView.setVisibility(0);
        Log.d(TAG, "onClick, reload");
        this.webView.reload();
        this.mReloadingFromErrorPage = true;
        if (this.mPendingReloadTimeoutRunnable != null) goto L7;
        this.mPendingReloadTimeoutRunnable = new WebViewActivity$$ExternalSyntheticLambda2(this);
    L7:
        this.webView.removeCallbacks(this.mPendingReloadTimeoutRunnable);
        this.webView.postDelayed(this.mPendingReloadTimeoutRunnable, WsConstants.EXIT_DELAY_TIME);
        return;
    }

    /* JADX INFO: renamed from: lambda$showErrorPage$2$com-obric-oui-window-permission-WebViewActivity, reason: not valid java name */
    /* synthetic */ void m1464x7296e224() {
        if (this.mReloadingFromErrorPage == false) goto L6;
        Log.w(TAG, "reload timeout, keep showing error page");
        showErrorPage();
        return;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.webView.canGoBack() == false) goto L5;
        Log.d(TAG, "onBackPressed, go back");
        this.webView.goBack();
        return;
    L5:
        finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        WebView r0 = this.webView;
        if (r0 == null) goto L9;
        r0.removeCallbacks(this.mPendingShowWebViewRunnable);
        Runnable r1 = this.mPendingReloadTimeoutRunnable;
        if (r1 == null) goto L7;
        this.webView.removeCallbacks(r1);
    L7:
        this.webView.stopLoading();
        this.webView.removeAllViews();
        this.webView.destroy();
        Log.d(TAG, "onDestroy, webView destroyed");
        return;
    }

    public void updateLayoutForInsetBottom(int r2) {
        if ((this.webView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L6;
        ViewGroup.MarginLayoutParams r0 = (ViewGroup.MarginLayoutParams) this.webView.getLayoutParams();
        r0.bottomMargin = r2;
        this.webView.setLayoutParams(r0);
        Log.d(TAG, "updateLayoutForInsetBottom, insetBottom: " + r2);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_obric_oui_window_permission_WebViewActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(WebViewActivity r1) {
        r1.com_obric_oui_window_permission_WebViewActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_obric_oui_window_permission_WebViewActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(WebViewActivity r1) {
        String r0 = r1.getClass().getName();
        com_obric_oui_window_permission_WebViewActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_obric_oui_window_permission_WebViewActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(WebViewActivity r4) {
        String r0 = r4.getClass().getName();
        r4.com_obric_oui_window_permission_WebViewActivity__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        WebViewActivity r5 = r4;
        String r2 = r5.getCallingPackage();
        if (r2 != null) goto L9;
        OLog.e("BaseActivity", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r6 = r5.getReferrer();
        if (r6 == null) goto L9;
        r2 = r6.toString();
    L9:
        OLog.i("TeaEventReportUtil", "callingPkg=" + r2);
        if (r2 != null) goto L12;
        r2 = "null";
    L12:
        AppMetricsUtils.INSTANCE.reportColdStartActivity(r2, r0);
    L13:
        AppMetricsUtils.INSTANCE.setColdStartTime(0);
    }

    @Insert(mayCreateSuper = true, value = "startActivityForResult")
    public static void com_obric_oui_window_permission_WebViewActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(WebViewActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_obric_oui_window_permission_WebViewActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_obric_oui_window_permission_WebViewActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(WebViewActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_obric_oui_window_permission_WebViewActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_obric_oui_window_permission_WebViewActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(WebViewActivity r4) {
        String r0 = r4.getClass().getName();
        r4.com_obric_oui_window_permission_WebViewActivity__onPause$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_obric_oui_window_permission_WebViewActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(WebViewActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        r3.com_obric_oui_window_permission_WebViewActivity__onCreate$___twin___(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        WebViewActivity r5 = r3;
        String r6 = r5.getCallingPackage();
        if (r6 != null) goto L9;
        OLog.e("AppLifecycle", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r7 = r5.getReferrer();
        if (r7 == null) goto L9;
        r6 = r7.toString();
    L9:
        OLog.i("AppLifecycle", "TeaEventReportUtil callingPkg=" + r6);
        if (r6 != null) goto L12;
        r6 = "null";
    L12:
        AppMetricsUtils r8 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r8.callingPackageEvent(r6, r0, false);
        return;
    }
}
