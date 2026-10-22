package com.android.settings.location;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import androidx.preference.PreferenceViewHolder;
import com.android.settings.DimmableIconPreference;
import dalvik.system.DexClassLoader;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: classes2.dex */
public class DimmableIZatIconPreference extends DimmableIconPreference {
    private static final String TAG = "DimmableIZatIconPreference";
    private static Method mGetConsentMethod;
    private static Method mGetXtProxyMethod;
    private static String mIzatPackage;
    private static DexClassLoader mLoader;
    private static Class mNotifierClz;
    private static Method mShowIzatMethod;
    private static Class mXtProxyClz;
    boolean mChecked;

    static /* synthetic */ void access$000(DimmableIZatIconPreference r0, boolean r1) {
        r0.dimIcon(r1);
    }

    private static void load(Context r7) {
        if (mLoader == null) goto L14;
        return;
    L14:
    L11:
        e = move-exception;
        mXtProxyClz = null;
        mNotifierClz = null;
        mIzatPackage = null;
        mGetXtProxyMethod = null;
        mGetConsentMethod = null;
        mShowIzatMethod = null;
        e.printStackTrace();
        return;
    L6:
        if (mXtProxyClz != null) goto L8;
    L9:
        DexClassLoader r1 = new DexClassLoader("/system/framework/izat.xt.srv.jar", r7.getFilesDir().getAbsolutePath(), null, ClassLoader.getSystemClassLoader());     // Catch: Throwable -> L11
        mLoader = r1;     // Catch: Throwable -> L11
        mXtProxyClz = Class.forName("com.qti.izat.XTProxy", true, r1);     // Catch: Throwable -> L11
        mNotifierClz = Class.forName("com.qti.izat.XTProxy$Notifier", true, mLoader);     // Catch: Throwable -> L11
        mIzatPackage = (String) mXtProxyClz.getField("IZAT_XT_PACKAGE").get(null);     // Catch: Throwable -> L11
        mGetXtProxyMethod = mXtProxyClz.getMethod("getXTProxy", new Class[]{Context.class, mNotifierClz});     // Catch: Throwable -> L11
        mGetConsentMethod = mXtProxyClz.getMethod("getUserConsent", new Class[0]);     // Catch: Throwable -> L11
        mShowIzatMethod = mXtProxyClz.getMethod("showIzat", new Class[]{Context.class, String.class});     // Catch: Throwable -> L11
        return;
    L8:
        if (mNotifierClz == null) goto L9;
    }

    public static DimmableIconPreference newInstance(Context r1, CharSequence r2, InjectedSetting r3) {
        load(r1);
        String r0 = mIzatPackage;
        if (r0 == null) goto L9;
        if (r0.equals(r3.packageName) == false) goto L9;
        return new DimmableIZatIconPreference(r1, null, R.attr.checkBoxPreferenceStyle);
    L9:
        return new DimmableIconPreference(r1, r2);
    }

    static boolean showIzat(Context r4, String r5) {
        load(r4);
        Method r1 = mShowIzatMethod;     // Catch: Throwable -> L7
        if (r1 == null) goto L12;
        return ((Boolean) r1.invoke(null, new Object[]{r4, r5})).booleanValue();
    L12:
        return true;
    L7:
        e = move-exception;
        e.printStackTrace();
        return true;
    }

    private DimmableIZatIconPreference(Context r5, AttributeSet r6, int r7) {
        super(r5, r6, r7, null);
        Object r8 = Proxy.newProxyInstance(mLoader, new Class[]{mNotifierClz}, new AnonymousClass1(this));
        this.mChecked = ((Boolean) mGetConsentMethod.invoke(mGetXtProxyMethod.invoke(null, new Object[]{r5, r8}), new Object[0])).booleanValue();     // Catch: Throwable -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.android.settings.DimmableIconPreference, com.android.settingslib.RestrictedPreference, com.android.settingslib.widget.TwoTargetPreference, androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r1) {
        super.onBindViewHolder(r1);
        if (isEnabled() == true) goto L5;
    L8:
        boolean r2 = true;
    L9:
        dimIcon(r2);
        return;
    L5:
        if (this.mChecked == false) goto L8;
        r2 = false;
        goto L9
    }
}
