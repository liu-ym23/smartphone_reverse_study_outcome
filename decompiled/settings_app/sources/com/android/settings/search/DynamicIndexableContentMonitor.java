package com.android.settings.search;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.Activity;
import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.database.ContentObserver;
import android.hardware.input.InputManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.UserHandle;
import android.os.UserManager;
import android.print.PrintManager;
import android.print.PrintServicesLoader;
import android.printservice.PrintServiceInfo;
import android.provider.UserDictionary;
import android.view.accessibility.AccessibilityManager;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import com.android.internal.content.PackageMonitor;
import com.android.settings.accessibility.AccessibilitySettings;
import com.android.settings.inputmethod.InputMethodAndLanguageSettings;
import com.android.settings.print.PrintSettingsFragment;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class DynamicIndexableContentMonitor extends PackageMonitor implements InputManager.InputDeviceListener, LoaderManager.LoaderCallbacks<List<PrintServiceInfo>> {
    private static final long DELAY_PROCESS_PACKAGE_CHANGE = 2000;
    private static final int MSG_PACKAGE_AVAILABLE = 1;
    private static final int MSG_PACKAGE_UNAVAILABLE = 2;
    private static final String TAG = "DynamicIndexableContentMonitor";
    private final List<String> mAccessibilityServices;
    private Context mContext;
    private final Handler mHandler;
    private boolean mHasFeatureIme;
    private final List<String> mImeServices;
    private boolean mRegistered;
    private final ContentObserver mUserDictionaryContentObserver;

    private final class UserDictionaryContentObserver extends ContentObserver {
        final /* synthetic */ DynamicIndexableContentMonitor this$0;

        public UserDictionaryContentObserver(DynamicIndexableContentMonitor r1, Handler r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r1, Uri r2) {
            if (UserDictionary.Words.CONTENT_URI.equals(r2) == false) goto L6;
            Index.getInstance(DynamicIndexableContentMonitor.access$200(this.this$0)).updateFromClassNameResource(InputMethodAndLanguageSettings.class.getName(), true, true);
            return;
        }
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<List<PrintServiceInfo>> r1) {
    }

    public DynamicIndexableContentMonitor() {
        this.mAccessibilityServices = new ArrayList();
        this.mImeServices = new ArrayList();
        Handler r0 = new AnonymousClass1(this);
        this.mHandler = r0;
        this.mUserDictionaryContentObserver = new UserDictionaryContentObserver(this, r0);
    }

    static /* synthetic */ void access$000(DynamicIndexableContentMonitor r0, String r1) {
        r0.handlePackageAvailable(r1);
    }

    static /* synthetic */ void access$100(DynamicIndexableContentMonitor r0, String r1) {
        r0.handlePackageUnavailable(r1);
    }

    static /* synthetic */ Context access$200(DynamicIndexableContentMonitor r0) {
        return r0.mContext;
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public /* bridge */ /* synthetic */ void onLoadFinished(Loader<List<PrintServiceInfo>> r1, List<PrintServiceInfo> r2) {
        onLoadFinished2(r1, r2);
    }

    private static Intent getAccessibilityServiceIntent(String r2) {
        Intent r0 = new Intent("android.accessibilityservice.AccessibilityService");
        r0.setPackage(r2);
        return r0;
    }

    private static Intent getIMEServiceIntent(String r2) {
        Intent r0 = new Intent("android.view.InputMethod");
        r0.setPackage(r2);
        return r0;
    }

    public void register(Activity r9, int r10) {
        this.mContext = r9;
        if (((UserManager) r9.getSystemService(UserManager.class)).isUserUnlocked() == true) goto L6;
        OLog.w(TAG, "Skipping content monitoring because user is locked");
        this.mRegistered = false;
        return;
    L6:
        this.mRegistered = true;
        boolean r2 = this.mContext.getPackageManager().hasSystemFeature("android.software.print");
        this.mHasFeatureIme = this.mContext.getPackageManager().hasSystemFeature("android.software.input_methods");
        List<AccessibilityServiceInfo> r3 = ((AccessibilityManager) this.mContext.getSystemService("accessibility")).getInstalledAccessibilityServiceList();
        int r4 = r3.size();
        int r5 = 0;
    L7:
        if (r5 >= r4) goto L15;
        ResolveInfo r6 = r3.get(r5).getResolveInfo();
        if (r6 == null) goto L14;
        if (r6.serviceInfo == null) goto L14;
        this.mAccessibilityServices.add(r6.serviceInfo.packageName);
    L14:
        r5 = r5 + 1;
        goto L7
    L15:
        if (r2 == false) goto L18;
        r9.getLoaderManager().initLoader(r10, null, this);
    L18:
        if (this.mHasFeatureIme == false) goto L27;
        List<InputMethodInfo> r11 = ((InputMethodManager) this.mContext.getSystemService("input_method")).getInputMethodList();
        int r7 = r11.size();
        int r8 = 0;
    L20:
        if (r8 >= r7) goto L26;
        ServiceInfo r12 = r11.get(r8).getServiceInfo();
        if (r12 == null) goto L25;
        this.mImeServices.add(r12.packageName);
    L25:
        r8 = r8 + 1;
        goto L20
    L26:
        this.mContext.getContentResolver().registerContentObserver(UserDictionary.Words.CONTENT_URI, true, this.mUserDictionaryContentObserver);
    L27:
        ((InputManager) r9.getSystemService("input")).registerInputDeviceListener(this, this.mHandler);
        register(r9, Looper.getMainLooper(), UserHandle.CURRENT, false);
    }

    public void unregister() {
        if (this.mRegistered == true) goto L5;
        return;
    L5:
        super.unregister();
        ((InputManager) this.mContext.getSystemService("input")).unregisterInputDeviceListener(this);
        if (this.mHasFeatureIme == false) goto L8;
        this.mContext.getContentResolver().unregisterContentObserver(this.mUserDictionaryContentObserver);
    L8:
        this.mAccessibilityServices.clear();
        this.mImeServices.clear();
    }

    public void onPackageAppeared(String r1, int r2) {
        postMessage(1, r1);
    }

    public void onPackageDisappeared(String r1, int r2) {
        postMessage(2, r1);
    }

    public void onPackageModified(String r3) {
        super.onPackageModified(r3);
        int r0 = this.mContext.getPackageManager().getApplicationEnabledSetting(r3);     // Catch: IllegalArgumentException -> L10
        if (r0 == 0) goto L8;
        if (r0 == 1) goto L8;
        postMessage(2, r3);     // Catch: IllegalArgumentException -> L10
    L13:
        return;
    L8:
        postMessage(1, r3);     // Catch: IllegalArgumentException -> L10
    L10:
        e = move-exception;
        OLog.e(TAG, "Package does not exist: " + r3, e);
    }

    @Override // android.hardware.input.InputManager.InputDeviceListener
    public void onInputDeviceAdded(int r3) {
        Index.getInstance(this.mContext).updateFromClassNameResource(InputMethodAndLanguageSettings.class.getName(), false, true);
    }

    @Override // android.hardware.input.InputManager.InputDeviceListener
    public void onInputDeviceRemoved(int r1) {
        onInputDeviceChanged(r1);
    }

    @Override // android.hardware.input.InputManager.InputDeviceListener
    public void onInputDeviceChanged(int r2) {
        Index.getInstance(this.mContext).updateFromClassNameResource(InputMethodAndLanguageSettings.class.getName(), true, true);
    }

    private void postMessage(int r3, String r4) {
        Message r5 = this.mHandler.obtainMessage(r3, r4);
        this.mHandler.sendMessageDelayed(r5, DELAY_PROCESS_PACKAGE_CHANGE);
    }

    private void handlePackageAvailable(String r5) {
        if (this.mAccessibilityServices.contains(r5) == true) goto L10;
        Intent r0 = getAccessibilityServiceIntent(r5);
        List<ResolveInfo> r1 = this.mContext.getPackageManager().queryIntentServices(r0, 0);
        if (r1 == null) goto L10;
        if (r1.isEmpty() == true) goto L10;
        this.mAccessibilityServices.add(r5);
        Index.getInstance(this.mContext).updateFromClassNameResource(AccessibilitySettings.class.getName(), false, true);
    L10:
        if (this.mHasFeatureIme == true) goto L12;
        return;
    L12:
        if (this.mImeServices.contains(r5) == true) goto L20;
        Intent r2 = getIMEServiceIntent(r5);
        List<ResolveInfo> r3 = this.mContext.getPackageManager().queryIntentServices(r2, 0);
        if (r3 != null) goto L16;
        return;
    L16:
        if (r3.isEmpty() == true) goto L22;
        this.mImeServices.add(r5);
        Index.getInstance(this.mContext).updateFromClassNameResource(InputMethodAndLanguageSettings.class.getName(), false, true);
        return;
    L22:
        return;
    }

    private void handlePackageUnavailable(String r4) {
        int r0 = this.mAccessibilityServices.indexOf(r4);
        if (r0 < 0) goto L6;
        this.mAccessibilityServices.remove(r0);
        Index.getInstance(this.mContext).updateFromClassNameResource(AccessibilitySettings.class.getName(), true, true);
    L6:
        if (this.mHasFeatureIme == false) goto L11;
        int r5 = this.mImeServices.indexOf(r4);
        if (r5 < 0) goto L12;
        this.mImeServices.remove(r5);
        Index.getInstance(this.mContext).updateFromClassNameResource(InputMethodAndLanguageSettings.class.getName(), true, true);
        return;
    L12:
        return;
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public Loader<List<PrintServiceInfo>> onCreateLoader(int r2, Bundle r3) {
        return new PrintServicesLoader((PrintManager) this.mContext.getSystemService("print"), this.mContext, 3);
    }

    /* JADX INFO: renamed from: onLoadFinished, reason: avoid collision after fix types in other method */
    public void onLoadFinished2(Loader<List<PrintServiceInfo>> r2, List<PrintServiceInfo> r3) {
        Index.getInstance(this.mContext).updateFromClassNameResource(PrintSettingsFragment.class.getName(), false, true);
    }
}
