package com.android.settings;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.UserManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.IWebViewUpdateService;
import android.webkit.WebViewProviderInfo;
import android.widget.LinearLayout;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemCheck;

/* JADX INFO: loaded from: classes2.dex */
public class WebViewImplementationFragment extends BaseFragment implements View.OnClickListener {
    private static final String TAG = "WebViewImplementation";
    private LinearLayout mProvidersContainer;
    private IWebViewUpdateService mWebViewUpdateService;

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_WebViewImplementationFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_WebViewImplementationFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public WebViewImplementationFragment() {
    }

    public void com_android_settings_WebViewImplementationFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
        if (UserManager.get(this.mContext).isAdminUser() == true) goto L6;
        finish();
        return;
    L6:
        this.mWebViewUpdateService = getWebViewUpdateService();
    }

    private static IWebViewUpdateService getWebViewUpdateService() {
        return IWebViewUpdateService.Stub.asInterface(ServiceManager.getService("webviewupdate"));
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.web_view_provider_fragment, r3, false);
        this.mProvidersContainer = (LinearLayout) findViewByIdNullable(R.id.ll_providers_container);
        ArrayList<WebViewProviderInfo> r5 = getEnabledWebViewProviders(this.mContext, this.mWebViewUpdateService);
        if (r5 != null) goto L5;
        OLog.e(TAG, "No WebView providers available");
        finish();
    L7:
        return this.mRootView;
    L5:
        addProviderItems(r5);
        goto L7
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        updateCheckedState();
    }

    public void com_android_settings_WebViewImplementationFragment__onResume$___twin___() {
        super.onResume();
        updateCheckedState();
    }

    private void addProviderItems(ArrayList<WebViewProviderInfo> r5) {
        LinearLayout r0 = this.mProvidersContainer;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.removeAllViews();
        if (r5 != null) goto L8;
        return;
    L8:
        int r1 = r5.size();
        int r2 = 0;
    L9:
        if (r2 >= r1) goto L11;
        WebViewProviderInfo r3 = r5.get(r2);
        this.mProvidersContainer.addView(createProviderItem(r3, r1, r2));
        r2 = r2 + 1;
        goto L9
    }

    private View createProviderItem(WebViewProviderInfo r3, int r4, int r5) {
        SettingItemCheck r0 = new SettingItemCheck(this._mActivity);
        r0.setTitle(r3.description);
        Utils.setItemBgStyle(r0, r4, r5);
        r0.setTag(r3);
        r0.setOnClickListener(this);
        return r0;
    }

    private void updateCheckedState() {
        if (this.mProvidersContainer != null) goto L5;
        return;
    L5:
        String r0 = getCurrentWebViewPackageName(this.mWebViewUpdateService);
        int r1 = this.mProvidersContainer.getChildCount();
        int r3 = 0;
    L6:
        if (r3 >= r1) goto L14;
        SettingItemCheck r4 = (SettingItemCheck) this.mProvidersContainer.getChildAt(r3);
        WebViewProviderInfo r5 = (WebViewProviderInfo) r4.getTag();
        if (r5 != null) goto L10;
    L12:
        boolean r6 = false;
    L13:
        r4.setChecked(r6);
        r3 = r3 + 1;
        goto L6
    L10:
        if (TextUtils.equals(r0, r5.packageName) == false) goto L12;
        r6 = true;
        goto L13
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r1) {
        WebViewProviderInfo r2 = (WebViewProviderInfo) r1.getTag();
        if (r2 != null) goto L5;
        return;
    L5:
        if (changeWebViewProvider(r2.packageName) == false) goto L7;
        finish();
        return;
    L7:
        ToastUtils.show(this._mActivity, R.string.select_webview_provider_toast_text);
    }

    private boolean changeWebViewProvider(String r3) {
        IWebViewUpdateService r2 = this.mWebViewUpdateService;
        if (r2 == null) goto L10;
        if (r3 == null) goto L10;
        return r3.equals(r2.changeProviderAndSetting(r3));
    L8:
        e = move-exception;
        OLog.w(TAG, "Problem reaching webviewupdate service", e);
    L10:
        return false;
    }

    static String getCurrentWebViewDescription(Context r4) {
        IWebViewUpdateService r0 = getWebViewUpdateService();
        ArrayList<WebViewProviderInfo> r5 = getEnabledWebViewProviders(r4, r0);
        if (r5 != null) goto L5;
        return null;
    L5:
        String r1 = getCurrentWebViewPackageName(r0);
        Iterator<WebViewProviderInfo> r6 = r5.iterator();
    L7:
        if (r6.hasNext() == false) goto L12;
        WebViewProviderInfo r2 = r6.next();
        if (TextUtils.equals(r1, r2.packageName) == false) goto L7;
        return r2.description;
    L12:
        return null;
    }

    private static ArrayList<WebViewProviderInfo> getEnabledWebViewProviders(Context r9, IWebViewUpdateService r10) {
        if (r10 != null) goto L23;
        return null;
    L23:
        WebViewProviderInfo[] r11 = r10.getValidWebViewPackages();     // Catch: RemoteException -> L20
        if (r11 != null) goto L8;
        return null;
    L8:
        int r1 = r11.length;     // Catch: RemoteException -> L20
        int r2 = 0;
        ArrayList<WebViewProviderInfo> r3 = null;
    L9:
        if (r2 >= r1) goto L19;
        WebViewProviderInfo r4 = r11[r2];     // Catch: RemoteException -> L20
        if (Utils.isPackageEnabled(r9, r4.packageName) == false) goto L17;
        OLog.d(TAG, "find enabled webView provider : " + r4.description + " , " + r4.packageName);     // Catch: RemoteException -> L20
        if (r3 != null) goto L16;
        r3 = new ArrayList();     // Catch: RemoteException -> L20
    L16:
        r3.add(r4);     // Catch: RemoteException -> L20
    L18:
        r2 = r2 + 1;
        goto L9
    L17:
        OLog.d(TAG, "find disabled webView provider : " + r4.description + " , " + r4.packageName);     // Catch: RemoteException -> L20
        goto L18
    L19:
        return r3;
    L20:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    private static String getCurrentWebViewPackageName(IWebViewUpdateService r0) {
        if (r0 == null) goto L11;
        return r0.getCurrentWebViewPackageName();
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    L11:
        return null;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_WebViewImplementationFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(WebViewImplementationFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_WebViewImplementationFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_WebViewImplementationFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(WebViewImplementationFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_WebViewImplementationFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_WebViewImplementationFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(WebViewImplementationFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_WebViewImplementationFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
