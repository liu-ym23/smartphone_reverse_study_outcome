package com.android.settingslib.applications;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
import android.util.Slog;
import com.GlobalProxyLancet;
import com.android.settingslib.accessibility.AccessibilityUtils;
import com.bytedance.librarian.LibrarianImpl;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes.dex */
public class ServiceListing {
    private final boolean mAddDeviceLockedFlags;
    private final List<Callback> mCallbacks;
    private final ContentResolver mContentResolver;
    private final Context mContext;
    private final HashSet<ComponentName> mEnabledServices;
    private final String mIntentAction;
    private boolean mListening;
    private final String mNoun;
    private final BroadcastReceiver mPackageReceiver;
    private final String mPermission;
    private final List<ServiceInfo> mServices;
    private final String mSetting;
    private final ContentObserver mSettingsObserver;
    private final String mTag;
    private final Predicate mValidator;

    public static class Builder {
        private boolean mAddDeviceLockedFlags;
        private final Context mContext;
        private String mIntentAction;
        private String mNoun;
        private String mPermission;
        private String mSetting;
        private String mTag;
        private Predicate mValidator;

        public Builder(Context r2) {
            this.mAddDeviceLockedFlags = false;
            this.mContext = r2;
        }

        public Builder setTag(String r1) {
            this.mTag = r1;
            return this;
        }

        public Builder setSetting(String r1) {
            this.mSetting = r1;
            return this;
        }

        public Builder setIntentAction(String r1) {
            this.mIntentAction = r1;
            return this;
        }

        public Builder setPermission(String r1) {
            this.mPermission = r1;
            return this;
        }

        public Builder setNoun(String r1) {
            this.mNoun = r1;
            return this;
        }

        public Builder setValidator(Predicate<ServiceInfo> r1) {
            this.mValidator = r1;
            return this;
        }

        public Builder setAddDeviceLockedFlags(boolean r1) {
            this.mAddDeviceLockedFlags = r1;
            return this;
        }

        public ServiceListing build() {
            return new ServiceListing(this.mContext, this.mTag, this.mSetting, this.mIntentAction, this.mPermission, this.mNoun, this.mAddDeviceLockedFlags, this.mValidator, null);
        }
    }

    public interface Callback {
        void onServicesReloaded(List<ServiceInfo> r1);
    }

    /* synthetic */ ServiceListing(Context r1, String r2, String r3, String r4, String r5, String r6, boolean r7, Predicate r8, AnonymousClass1 r9) {
        this(r1, r2, r3, r4, r5, r6, r7, r8);
    }

    private ServiceListing(Context r3, String r4, String r5, String r6, String r7, String r8, boolean r9, Predicate r10) {
        this.mEnabledServices = new HashSet();
        this.mServices = new ArrayList();
        this.mCallbacks = new ArrayList();
        final Handler r1 = new Handler();
        this.mSettingsObserver = new AnonymousClass1(this, r1);
        this.mPackageReceiver = new AnonymousClass2(this);
        this.mContentResolver = r3.getContentResolver();
        this.mContext = r3;
        this.mTag = r4;
        this.mSetting = r5;
        this.mIntentAction = r6;
        this.mPermission = r7;
        this.mNoun = r8;
        this.mAddDeviceLockedFlags = r9;
        this.mValidator = r10;
    }

    public void addCallback(Callback r1) {
        this.mCallbacks.add(r1);
    }

    public void removeCallback(Callback r1) {
        this.mCallbacks.remove(r1);
    }

    public void setListening(boolean r3) {
        if (this.mListening != r3) goto L5;
        return;
    L5:
        this.mListening = r3;
        if (r3 == false) goto L8;
        IntentFilter r4 = new IntentFilter();
        r4.addAction("android.intent.action.PACKAGE_ADDED");
        r4.addAction("android.intent.action.PACKAGE_CHANGED");
        r4.addAction("android.intent.action.PACKAGE_REMOVED");
        r4.addAction("android.intent.action.PACKAGE_REPLACED");
        r4.addDataScheme("package");
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, this.mPackageReceiver, r4);
        this.mContentResolver.registerContentObserver(Settings.Secure.getUriFor(this.mSetting), false, this.mSettingsObserver);
        return;
    L8:
        this.mContext.unregisterReceiver(this.mPackageReceiver);
        this.mContentResolver.unregisterContentObserver(this.mSettingsObserver);
    }

    private void saveEnabledServices() {
        Iterator<ComponentName> r0 = this.mEnabledServices.iterator();
        StringBuilder r1 = null;
    L4:
        if (r0.hasNext() == false) goto L10;
        ComponentName r2 = r0.next();
        if (r1 != null) goto L8;
        r1 = new StringBuilder();
    L9:
        r1.append(r2.flattenToString());
        goto L4
    L8:
        r1.append(AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR);
        goto L9
    L10:
        ContentResolver r3 = this.mContentResolver;
        String r4 = this.mSetting;
        if (r1 == null) goto L13;
        String r5 = r1.toString();
    L14:
        Settings.Secure.putString(r3, r4, r5);
        return;
    L13:
        r5 = "";
        goto L14
    }

    private void loadEnabledServices() {
        this.mEnabledServices.clear();
        String r0 = Settings.Secure.getString(this.mContentResolver, this.mSetting);
        if (r0 != null) goto L5;
        return;
    L5:
        if ("".equals(r0) == true) goto L16;
        String[] r1 = r0.split(":");
        int r2 = r1.length;
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L17;
        ComponentName r4 = ComponentName.unflattenFromString(r1[r3]);
        if (r4 == null) goto L11;
        this.mEnabledServices.add(r4);
    L11:
        r3 = r3 + 1;
        goto L7
    L17:
        return;
    }

    public void reload() {
        loadEnabledServices();
        this.mServices.clear();
        int r0 = ActivityManager.getCurrentUser();
        if (this.mAddDeviceLockedFlags == false) goto L5;
        int r1 = 786564;
    L6:
        PackageManager r2 = this.mContext.getPackageManager();
        Iterator r3 = r2.queryIntentServicesAsUser(new Intent(this.mIntentAction), r1, r0).iterator();
    L8:
        if (r3.hasNext() == false) goto L20;
        ServiceInfo r4 = ((ResolveInfo) r3.next()).serviceInfo;
        if (this.mEnabledServices.contains(r4.getComponentName()) == true) goto L8;
        if (this.mPermission.equals(r4.permission) == false) goto L13;
        Predicate r5 = this.mValidator;
        if (r5 == null) goto L19;
        if (r5.test(r4) == false) goto L8;
    L19:
        this.mServices.add(r4);
        goto L8
    L13:
        Slog.w(this.mTag, "Skipping " + this.mNoun + " service " + r4.packageName + LibrarianImpl.Constants.SEPARATOR + r4.name + ": it does not require the permission " + this.mPermission);
        goto L8
    L20:
        Iterator<ComponentName> r6 = this.mEnabledServices.iterator();
    L22:
        if (r6.hasNext() == false) goto L27;
        Iterator r7 = r2.queryIntentServicesAsUser(new Intent().setComponent(r6.next()), r1, r0).iterator();
    L25:
        if (r7.hasNext() == false) goto L22;
        this.mServices.add(((ResolveInfo) r7.next()).serviceInfo);
        goto L25
    L27:
        Iterator<Callback> r8 = this.mCallbacks.iterator();
    L29:
        if (r8.hasNext() == false) goto L31;
        r8.next().onServicesReloaded(this.mServices);
        goto L29
    L31:
        return;
    L5:
        r1 = 132;
        goto L6
    }

    public boolean isEnabled(ComponentName r1) {
        return this.mEnabledServices.contains(r1);
    }

    public void setEnabled(ComponentName r1, boolean r2) {
        if (r2 == false) goto L4;
        this.mEnabledServices.add(r1);
    L5:
        saveEnabledServices();
        return;
    L4:
        this.mEnabledServices.remove(r1);
        goto L5
    }
}
