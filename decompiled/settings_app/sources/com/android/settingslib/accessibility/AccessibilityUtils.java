package com.android.settingslib.accessibility;

import android.R;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Configuration;
import android.os.UserHandle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.ArraySet;
import android.view.accessibility.AccessibilityManager;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class AccessibilityUtils {
    public static final char ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR = ':';

    public AccessibilityUtils() {
    }

    public static Set<ComponentName> getEnabledServicesFromSettings(Context r1) {
        return getEnabledServicesFromSettings(r1, UserHandle.myUserId());
    }

    public static boolean hasServiceCrashed(String r5, String r6, List<AccessibilityServiceInfo> r7) {
        int r1 = 0;
    L4:
        if (r1 >= r7.size()) goto L12;
        AccessibilityServiceInfo r2 = r7.get(r1);
        ServiceInfo r3 = r7.get(r1).getResolveInfo().serviceInfo;
        if (TextUtils.equals(r3.packageName, r5) == false) goto L11;
        if (TextUtils.equals(r3.name, r6) == false) goto L11;
        return r2.crashed;
    L11:
        r1 = r1 + 1;
        goto L4
    L12:
        return false;
    }

    public static Set<ComponentName> getEnabledServicesFromSettings(Context r2, int r3) {
        String r4 = Settings.Secure.getStringForUser(r2.getContentResolver(), "enabled_accessibility_services", r3);
        if (TextUtils.isEmpty(r4) == true) goto L5;
        HashSet r5 = new HashSet();
        TextUtils.SimpleStringSplitter r0 = new TextUtils.SimpleStringSplitter(ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR);
        r0.setString(r4);
        Iterator r6 = r0.iterator();
    L8:
        if (r6.hasNext() == false) goto L12;
        ComponentName r1 = ComponentName.unflattenFromString((String) r6.next());
        if (r1 == null) goto L8;
        r5.add(r1);
        goto L8
    L12:
        return r5;
    L5:
        return Collections.emptySet();
    }

    public static CharSequence getTextForLocale(Context r2, Locale r3, int r4) {
        Configuration r1 = new Configuration(r2.getResources().getConfiguration());
        r1.setLocale(r3);
        return r2.createConfigurationContext(r1).getText(r4);
    }

    public static void setAccessibilityServiceState(Context r1, ComponentName r2, boolean r3) {
        setAccessibilityServiceState(r1, r2, r3, UserHandle.myUserId());
    }

    public static void setAccessibilityServiceState(Context r3, ComponentName r4, boolean r5, int r6) {
        Set r0 = getEnabledServicesFromSettings(r3, r6);
        if (r0.isEmpty() == false) goto L5;
        r0 = new ArraySet(1);
    L5:
        if (r5 == false) goto L7;
        r0.add(r4);
    L12:
        StringBuilder r7 = new StringBuilder();
        Iterator r8 = r0.iterator();
    L14:
        if (r8.hasNext() == false) goto L16;
        r7.append(((ComponentName) r8.next()).flattenToString());
        r7.append(ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR);
        goto L14
    L16:
        int r9 = r7.length();
        if (r9 <= 0) goto L19;
        r7.deleteCharAt(r9 - 1);
    L19:
        Settings.Secure.putStringForUser(r3.getContentResolver(), "enabled_accessibility_services", r7.toString(), r6);
        return;
    L7:
        r0.remove(r4);
        Set<ComponentName> r10 = getInstalledServices(r3);
        Iterator r11 = r0.iterator();
    L9:
        if (r11.hasNext() == false) goto L12;
        if (r10.contains((ComponentName) r11.next()) == false) goto L9;
        goto L12
    }

    public static String getShortcutTargetServiceComponentNameString(Context r2, int r3) {
        String r4 = Settings.Secure.getStringForUser(r2.getContentResolver(), "accessibility_shortcut_target_service", r3);
        if (r4 == null) goto L6;
        return r4;
    L6:
        return r2.getString(R.string.config_defaultCredentialManagerAutofillService);
    }

    private static Set<ComponentName> getInstalledServices(Context r4) {
        HashSet r0 = new HashSet();
        r0.clear();
        List<AccessibilityServiceInfo> r5 = AccessibilityManager.getInstance(r4).getInstalledAccessibilityServiceList();
        if (r5 != null) goto L5;
        return r0;
    L5:
        Iterator<AccessibilityServiceInfo> r6 = r5.iterator();
    L7:
        if (r6.hasNext() == false) goto L9;
        ResolveInfo r1 = r6.next().getResolveInfo();
        r0.add(new ComponentName(r1.serviceInfo.packageName, r1.serviceInfo.name));
        goto L7
    L9:
        return r0;
    }
}
