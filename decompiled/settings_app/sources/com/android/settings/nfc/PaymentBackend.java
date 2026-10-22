package com.android.settings.nfc;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.nfc.NfcAdapter;
import android.nfc.cardemulation.ApduServiceInfo;
import android.nfc.cardemulation.CardEmulation;
import android.os.Handler;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.Settings;
import com.android.internal.content.PackageMonitor;
import com.android.settings.Constants;
import com.android.settings.R;
import com.android.settings.SettingsFeature;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class PaymentBackend {
    public static final String TAG = "Settings.PaymentBackend";
    private final NfcAdapter mAdapter;
    private ArrayList<PaymentAppInfo> mAppInfos;
    private PaymentAppInfo mBytedanceWalletAppInfo;
    private ArrayList<Callback> mCallbacks;
    private final CardEmulation mCardEmuManager;
    private final Context mContext;
    private PaymentAppInfo mDefaultAppInfo;
    private final Handler mHandler;
    private final PackageMonitor mSettingsPackageMonitor;

    public interface Callback {
        void onPaymentAppsChanged();
    }

    public static class PaymentAppInfo {
        long appInstallTime;
        Drawable banner;
        public ComponentName componentName;
        CharSequence description;
        boolean isDefault;
        CharSequence label;
        public ComponentName settingsComponent;
        public UserHandle userHandle;

        public PaymentAppInfo() {
        }

        public String getKey() {
            return Integer.toString(hashCode());
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.componentName, this.userHandle});
        }

        public boolean equals(Object r5) {
            if (r5 != this) goto L6;
            return true;
        L6:
            if ((r5 instanceof PaymentAppInfo) == true) goto L8;
            return false;
        L8:
            PaymentAppInfo r6 = (PaymentAppInfo) r5;
            if (this.componentName.equals(r6.componentName) == false) goto L14;
            if (this.userHandle.equals(r6.userHandle) == false) goto L14;
            return true;
        L14:
            return false;
        }
    }

    public static class PaymentInfo {
        public ComponentName componentName;
        public int userId;

        public PaymentInfo() {
        }
    }

    private class SettingsPackageMonitor extends PackageMonitor {
        final /* synthetic */ PaymentBackend this$0;

        private SettingsPackageMonitor(PaymentBackend r1) {
            this.this$0 = r1;
        }

        /* synthetic */ SettingsPackageMonitor(PaymentBackend r1, AnonymousClass1 r2) {
            this(r1);
        }

        public void onPackageAdded(String r1, int r2) {
            PaymentBackend.access$100(this.this$0).obtainMessage().sendToTarget();
        }

        public void onPackageAppeared(String r1, int r2) {
            PaymentBackend.access$100(this.this$0).obtainMessage().sendToTarget();
        }

        public void onPackageDisappeared(String r1, int r2) {
            PaymentBackend.access$100(this.this$0).obtainMessage().sendToTarget();
        }

        public void onPackageRemoved(String r1, int r2) {
            PaymentBackend.access$100(this.this$0).obtainMessage().sendToTarget();
        }
    }

    static /* synthetic */ Handler access$100(PaymentBackend r0) {
        return r0.mHandler;
    }

    public PaymentBackend(Context r3) {
        this.mSettingsPackageMonitor = new SettingsPackageMonitor(this, null);
        this.mCallbacks = new ArrayList();
        this.mHandler = new AnonymousClass2(this);
        this.mContext = r3;
        NfcAdapter r4 = NfcAdapter.getDefaultAdapter(r3);
        this.mAdapter = r4;
        if (r4 == null) goto L5;
        this.mCardEmuManager = CardEmulation.getInstance(r4);
        refresh();
        return;
    L5:
        this.mCardEmuManager = null;
    }

    public void onPause() {
        this.mSettingsPackageMonitor.unregister();
    }

    public void onResume() {
        PackageMonitor r0 = this.mSettingsPackageMonitor;
        Context r3 = this.mContext;
        r0.register(r3, r3.getMainLooper(), false);
    }

    public void refresh() {
        PackageManager r0 = this.mContext.getPackageManager();
        CardEmulation r1 = this.mCardEmuManager;
        if (r1 != null) goto L5;
        return;
    L5:
        List r2 = r1.getServices(Constants.TYPE_PAYMENT);
        ArrayList<PaymentAppInfo> r3 = new ArrayList();
        if (r2 != null) goto L9;
        makeCallbacks();
        return;
    L9:
        List r4 = ((UserManager) this.mContext.createContextAsUser(UserHandle.of(ActivityManager.getCurrentUser()), 0).getSystemService(UserManager.class)).getEnabledProfiles();
        PaymentInfo r5 = getDefaultPaymentApp();
        Iterator r6 = r4.iterator();
        PaymentAppInfo r7 = null;
    L11:
        if (r6.hasNext() == false) goto L49;
        UserHandle r8 = (UserHandle) r6.next();
        List r9 = this.mCardEmuManager.getServices(Constants.TYPE_PAYMENT, r8.getIdentifier());
        if (r9 == null) goto L11;
        Iterator r10 = r9.iterator();
    L17:
        if (r10.hasNext() == false) goto L11;
        ApduServiceInfo r11 = (ApduServiceInfo) r10.next();
        PaymentAppInfo r12 = new PaymentAppInfo();
        r12.userHandle = r8;
        r12.label = r11.loadLabel(r0);
        if (r12.label != null) goto L21;
        r12.label = r11.loadAppLabel(r0);
    L21:
        if (r5 != null) goto L24;
        r12.isDefault = false;
    L31:
        if (r12.isDefault == false) goto L33;
        r7 = r12;
    L33:
        r12.componentName = r11.getComponent();
        String r13 = r11.getSettingsActivityName();
        if (r13 == null) goto L36;
        r12.settingsComponent = new ComponentName(r12.componentName.getPackageName(), r13);
    L56:
        r12.appInstallTime = r0.getPackageInfo(r12.componentName.getPackageName(), 0).firstInstallTime;     // Catch: PackageManager.NameNotFoundException -> L39
    L42:
        if (r11.getDescription() != null) goto L44;
        CharSequence r14 = r11.loadLabel(r0);
    L45:
        r12.description = r14;
        r12.banner = r11.loadIcon(r0);
        if (PaymentSettingsFragment.WALLET_COMPONENT_NAME.equals(r11.getComponent().flattenToString()) == true) goto L47;
        r3.add(r12);
        goto L17
    L47:
        this.mBytedanceWalletAppInfo = r12;
        goto L17
    L44:
        r14 = r11.getDescription();
    L39:
        e = move-exception;
        e.printStackTrace();
        goto L42
    L36:
        r12.settingsComponent = null;
        goto L56
    L24:
        if (r11.getComponent().equals(r5.componentName) == true) goto L26;
    L28:
        boolean r15 = false;
    L29:
        r12.isDefault = r15;
        goto L31
    L26:
        if (r5.userId != r8.getIdentifier()) goto L28;
        r15 = true;
        goto L29
    L49:
        Collections.sort(r3, new AnonymousClass1(this));
        if (SettingsFeature.isWalletNfcFeatureEnabled(this.mContext) == false) goto L54;
        PaymentAppInfo r16 = this.mBytedanceWalletAppInfo;
        if (r16 == null) goto L54;
        r3.add(0, r16);
    L54:
        this.mAppInfos = r3;
        this.mDefaultAppInfo = r7;
        makeCallbacks();
    }

    public void registerCallback(Callback r1) {
        this.mCallbacks.add(r1);
    }

    public void unregisterCallback(Callback r1) {
        this.mCallbacks.remove(r1);
    }

    public List<PaymentAppInfo> getPaymentAppInfos() {
        return this.mAppInfos;
    }

    public PaymentAppInfo getDefaultApp() {
        return this.mDefaultAppInfo;
    }

    void makeCallbacks() {
        Iterator<Callback> r1 = this.mCallbacks.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().onPaymentAppsChanged();
        goto L4
    }

    Drawable loadDrawableForPackage(String r2, int r3) {
        return this.mContext.getPackageManager().getResourcesForApplication(r2).getDrawable(r3);
    L5:
        return null;
    }

    boolean isForegroundMode() {
        if (Settings.Secure.getInt(this.mContext.getContentResolver(), "nfc_payment_foreground") == 0) goto L10;
        return true;
    L10:
        return false;
    L11:
        return false;
    }

    void setForegroundMode(boolean r2) {
        Settings.Secure.putInt(this.mContext.getContentResolver(), "nfc_payment_foreground", r2 ? 1 : 0);
    }

    PaymentInfo getDefaultPaymentApp() {
        Iterator r0 = ((UserManager) this.mContext.createContextAsUser(UserHandle.of(ActivityManager.getCurrentUser()), 0).getSystemService(UserManager.class)).getEnabledProfiles().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        UserHandle r1 = (UserHandle) r0.next();
        ComponentName r2 = getDefaultPaymentApp(r1.getIdentifier());
        if (r2 == null) goto L4;
        PaymentInfo r3 = new PaymentInfo();
        r3.userId = r1.getIdentifier();
        r3.componentName = r2;
        return r3;
    L9:
        return null;
    }

    ComponentName getDefaultPaymentApp(int r2) {
        String r1 = Settings.Secure.getStringForUser(this.mContext.getContentResolver(), "nfc_payment_default_component", r2);
        if (r1 != null) goto L5;
        return null;
    L5:
        return ComponentName.unflattenFromString(r1);
    }

    public void setDefaultPaymentApp(ComponentName r2) {
        setDefaultPaymentApp(r2, UserHandle.myUserId());
    }

    public void setDefaultPaymentApp(ComponentName r6, int r7) {
        Context r0 = this.mContext;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getContentResolver() == null) goto L26;
        Iterator r1 = ((UserManager) this.mContext.createContextAsUser(UserHandle.of(ActivityManager.getCurrentUser()), 0).getSystemService(UserManager.class)).getEnabledProfiles().iterator();
    L9:
        if (r1.hasNext() == false) goto L17;
        UserHandle r2 = (UserHandle) r1.next();
        String r3 = null;
        if (r2.getIdentifier() == r7) goto L12;
        Settings.Secure.putStringForUser(this.mContext.getContentResolver(), "nfc_payment_default_component", null, r2.getIdentifier());
        goto L9
    L12:
        ContentResolver r4 = this.mContext.getContentResolver();
        if (r6 == null) goto L15;
        r3 = r6.flattenToString();
    L15:
        Settings.Secure.putStringForUser(r4, "nfc_payment_default_component", r3, r2.getIdentifier());
        goto L9
    L17:
        refresh();
        return;
    }

    public CharSequence getDefaultPaymentDescription() {
        refresh();
        PaymentAppInfo r0 = this.mDefaultAppInfo;
        if (r0 == null) goto L7;
        return r0.label;
    L7:
        return this.mContext.getResources().getString(R.string.no_nfc_payment);
    }
}
