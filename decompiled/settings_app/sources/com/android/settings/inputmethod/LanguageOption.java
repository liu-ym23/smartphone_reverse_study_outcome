package com.android.settings.inputmethod;

import android.app.ActivityManagerNative;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.LocaleList;
import android.os.RemoteException;
import android.provider.Settings;
import com.android.internal.app.LocalePicker;
import com.android.internal.app.LocaleStore;
import com.android.settings.ProductFlavor;
import com.android.settings.R;
import com.android.settings.servicemanager.IPlatform;
import com.android.settings.settingitemsprovider.DatabaseHelper;
import com.android.settingslib.applications.RecentAppOpsAccess;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.obric.olog.OLog;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class LanguageOption {
    private static final String TAG = "LanguageOption";
    private Context mContext;
    private final Configuration mCurConfig;

    public static class LocaleInfo implements Comparable<LocaleInfo> {
        String label;
        Locale locale;
        Collator sCollator;

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(LocaleInfo r1) {
            return compareTo2(r1);
        }

        public LocaleInfo(String r2, Locale r3) {
            this.sCollator = Collator.getInstance();
            this.label = r2;
            this.locale = r3;
        }

        public String getLabel() {
            return this.label;
        }

        public Locale getLocale() {
            return this.locale;
        }

        public String toString() {
            return this.label;
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(LocaleInfo r2) {
            return this.sCollator.compare(this.label, r2.label);
        }
    }

    public LanguageOption(Context r2) {
        this.mCurConfig = new Configuration();
        this.mContext = r2;
    }

    public LocaleInfo[] constructAdapter(Context r13) {
        Resources r14 = r13.getResources();
        String[] r0 = Resources.getSystem().getAssets().getLocales();
        int r1 = r14.getIdentifier("special_locale_codes", "array", RecentAppOpsAccess.ANDROID_SYSTEM_PACKAGE_NAME);
        int r2 = r14.getIdentifier("special_locale_names", "array", RecentAppOpsAccess.ANDROID_SYSTEM_PACKAGE_NAME);
        String[] r3 = r14.getStringArray(r1);
        String[] r15 = r14.getStringArray(r2);
        Arrays.sort(r0);
        int r4 = r0.length;
        LocaleInfo[] r5 = new LocaleInfo[r4];
        boolean r6 = ProductFlavor.isNeridaHk();
        int r7 = 0;
        int r8 = 0;
        int r9 = 0;
    L3:
        if (r8 >= r4) goto L22;
        String r10 = r0[r8];
        if (r6 == false) goto L14;
        if (r10.equals("en-US") == true) goto L19;
        if (r10.equals("zh-CN") == true) goto L19;
        if (r10.equals("zh-HK") == true) goto L19;
    L21:
        r8 = r8 + 1;
    L19:
        if (r10.length() != 5) goto L21;
        Locale r11 = new Locale(r10.substring(0, 2), r10.substring(3, 5));
        r5[r9] = new LocaleInfo(getLabel(r11, r3, r15), r11);
        r9 = r9 + 1;
        goto L21
    L14:
        if (r10.equals("en-US") == true) goto L19;
        if (r10.equals("zh-CN") == true) goto L19;
    L22:
        LocaleInfo[] r12 = new LocaleInfo[r9];
    L23:
        if (r7 >= r9) goto L25;
        r12[r7] = r5[r7];
        r7 = r7 + 1;
        goto L23
    L25:
        return r12;
    }

    public boolean isCurrent(LocaleInfo r1) {
        return ((IPlatform) ServiceManager.getService(IPlatform.class)).isCurrentLanguage(r1);
    }

    public String getLabel(Locale r6, String[] r7, String[] r8) {
        String r5 = r6.getLanguage();
        int r1 = 0;
        if ("zh".equalsIgnoreCase(r5) == true) goto L5;
        String[] r9 = Resources.getSystem().getAssets().getLocales();
        int r10 = 0;
        int r0 = 0;
    L15:
        if (r10 >= r9.length) goto L23;
        String r2 = r9[r10];
        if (r2.length() != 5) goto L21;
        if (r2.substring(0, 2).equals(r5) == false) goto L21;
        r0 = r0 + 1;
    L21:
        r10 = r10 + 1;
        goto L15
    L23:
        if (r0 <= 1) goto L27;
        return r6.getDisplayName(r6);
    L27:
        return r6.getDisplayLanguage(r6);
    L5:
        if (r1 >= r7.length) goto L12;
        if (r7[r1].equals(r6.toString()) == true) goto L9;
        r1 = r1 + 1;
        goto L5
    L9:
        return r8[r1];
    L12:
        return r6.getDisplayLanguage(r6);
    }

    public void setLocale(LocaleInfo r2) {
        Locale r3 = r2.locale;
        DatabaseHelper.getInstance(this.mContext).ensureDbUpgradedBeforeLocaleSwitch();
        updateFontScale(r3);
        updateLocale(r3);
        OLog.d(TAG, "setLocale-----------------finish");
    }

    private void updateFontScale(Locale r8) {
        Configuration r0 = this.mContext.getResources().getConfiguration();
        r0.setLocale(r8);
        String[] r1 = this.mContext.createConfigurationContext(r0).getResources().getStringArray(R.array.font_scale_values);
        OLog.d(TAG, "locale " + r8 + " , font scale array: " + r1);
        float r9 = getCurrentFontScale();
        int r2 = r1.length;
        boolean r3 = false;
        int r4 = 0;
    L4:
        if (r4 >= r2) goto L9;
        if (Float.valueOf(r1[r4]).floatValue() == r9) goto L7;
        r4 = r4 + 1;
        goto L4
    L7:
        r3 = true;
    L9:
        if (r3 == true) goto L14;
        float r5 = Float.valueOf(r1[r1.length - 1]).floatValue();
        OLog.d(TAG, "current font " + r9 + " not found, set as " + r5);
        setFontSize(r5);
        return;
    }

    private float getCurrentFontScale() {
        this.mCurConfig.updateFrom(ActivityManagerNative.getDefault().getConfiguration());     // Catch: RemoteException -> L5
    L4:
        return this.mCurConfig.fontScale;
    }

    public void updateLocale(Locale r4) {
        List<LocaleStore.LocaleInfo> r3 = getUserLocaleList();
        OLog.d(TAG, "new local:" + r4 + ", the old list:" + r3);
        LocaleStore.LocaleInfo r5 = LocaleStore.getLocaleInfo(r4);
        int r1 = 0;
        if (r3.contains(r5) == false) goto L5;
        r3.add(0, r3.remove(r3.indexOf(r5)));
    L6:
        int r6 = r3.size();
        Locale[] r0 = new Locale[r6];
    L7:
        if (r1 >= r6) goto L9;
        r0[r1] = r3.get(r1).getLocale();
        r1 = r1 + 1;
        goto L7
    L9:
        LocaleList r7 = new LocaleList(r0);
        LocaleList.setDefault(r7);
        LocalePicker.updateLocales(r7);
        return;
    L5:
        r3.add(0, r5);
        goto L6
    }

    private void setFontSize(float r2) {
        Settings.System.putFloat(this.mContext.getContentResolver(), "font_scale", r2);
    }

    private List<LocaleStore.LocaleInfo> getUserLocaleList() {
        ArrayList r3 = new ArrayList();
        LocaleList r0 = LocalePicker.getLocales();
        int r1 = 0;
    L4:
        if (r1 >= r0.size()) goto L6;
        r3.add(LocaleStore.getLocaleInfo(r0.get(r1)));
        r1 = r1 + 1;
        goto L4
    L6:
        return r3;
    }

    public static boolean isChinese() {
        return "zh".equals(Locale.getDefault().getLanguage());
    }

    public static boolean isEnglish() {
        return "en".equals(Locale.getDefault().getLanguage());
    }
}
