package com.android.setupwizardlib.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import com.GlobalProxyLancet;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class WizardManagerHelper {
    private static final String ACTION_NEXT = "com.android.wizard.NEXT";
    static final String EXTRA_ACTION_ID = "actionId";
    static final String EXTRA_IS_DEFERRED_SETUP = "deferredSetup";
    static final String EXTRA_IS_FIRST_RUN = "firstRun";
    static final String EXTRA_IS_PRE_DEFERRED_SETUP = "preDeferredSetup";
    public static final String EXTRA_IS_SETUP_FLOW = "isSetupFlow";
    private static final String EXTRA_RESULT_CODE = "com.android.setupwizard.ResultCode";
    static final String EXTRA_SCRIPT_URI = "scriptUri";
    public static final String EXTRA_THEME = "theme";
    public static final String EXTRA_USE_IMMERSIVE_MODE = "useImmersiveMode";
    static final String EXTRA_WIZARD_BUNDLE = "wizardBundle";
    public static final String SETTINGS_GLOBAL_DEVICE_PROVISIONED = "device_provisioned";
    public static final String SETTINGS_SECURE_USER_SETUP_COMPLETE = "user_setup_complete";
    public static final String THEME_GLIF = "glif";
    public static final String THEME_GLIF_LIGHT = "glif_light";
    public static final String THEME_GLIF_V2 = "glif_v2";
    public static final String THEME_GLIF_V2_LIGHT = "glif_v2_light";
    public static final String THEME_GLIF_V3 = "glif_v3";
    public static final String THEME_GLIF_V3_LIGHT = "glif_v3_light";
    public static final String THEME_HOLO = "holo";
    public static final String THEME_HOLO_LIGHT = "holo_light";
    public static final String THEME_MATERIAL = "material";
    public static final String THEME_MATERIAL_LIGHT = "material_light";

    public WizardManagerHelper() {
    }

    public static Intent getNextIntent(Intent r1, int r2) {
        return getNextIntent(r1, r2, null);
    }

    public static Intent getNextIntent(Intent r2, int r3, Intent r4) {
        Intent r0 = new Intent("com.android.wizard.NEXT");
        copyWizardManagerExtras(r2, r0);
        r0.putExtra("com.android.setupwizard.ResultCode", r3);
        if (r4 != null) goto L5;
    L7:
        r0.putExtra("theme", r2.getStringExtra("theme"));
        return r0;
    L5:
        if (r4.getExtras() == null) goto L7;
        r0.putExtras(r4.getExtras());
        goto L7
    }

    public static void copyWizardManagerExtras(Intent r4, Intent r5) {
        r5.putExtra("wizardBundle", GlobalProxyLancet.com_bytedance_sysoptimizer_BadParcelableLancet_getBundleExtra(r4, "wizardBundle"));
        Iterator r0 = Arrays.asList(new String[]{"firstRun", "deferredSetup", "preDeferredSetup", "isSetupFlow"}).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        String r1 = (String) r0.next();
        r5.putExtra(r1, r4.getBooleanExtra(r1, false));
        goto L4
    L6:
        Iterator r2 = Arrays.asList(new String[]{"theme", "scriptUri", EXTRA_ACTION_ID}).iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        String r3 = (String) r2.next();
        r5.putExtra(r3, r4.getStringExtra(r3));
        goto L8
    }

    public static boolean isSetupWizardIntent(Intent r2) {
        return r2.getBooleanExtra("firstRun", false);
    }

    public static boolean isUserSetupComplete(Context r2) {
        if (Settings.Secure.getInt(r2.getContentResolver(), "user_setup_complete", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    public static boolean isDeviceProvisioned(Context r2) {
        if (Settings.Global.getInt(r2.getContentResolver(), "device_provisioned", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    public static boolean isDeferredSetupWizard(Intent r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        if (r2.getBooleanExtra("deferredSetup", false) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean isPreDeferredSetupWizard(Intent r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        if (r2.getBooleanExtra("preDeferredSetup", false) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean isLightTheme(Intent r1, boolean r2) {
        return isLightTheme(r1.getStringExtra("theme"), r2);
    }

    public static boolean isLightTheme(String r1, boolean r2) {
        if (THEME_HOLO_LIGHT.equals(r1) == false) goto L5;
        return true;
    L5:
        if (THEME_MATERIAL_LIGHT.equals(r1) == false) goto L7;
        return true;
    L7:
        if (THEME_GLIF_LIGHT.equals(r1) == false) goto L9;
        return true;
    L9:
        if (THEME_GLIF_V2_LIGHT.equals(r1) == false) goto L11;
        return true;
    L11:
        if (THEME_GLIF_V3_LIGHT.equals(r1) == false) goto L14;
        return true;
    L14:
        if (THEME_HOLO.equals(r1) == false) goto L16;
        return false;
    L16:
        if (THEME_MATERIAL.equals(r1) == false) goto L18;
        return false;
    L18:
        if (THEME_GLIF.equals(r1) == false) goto L20;
        return false;
    L20:
        if (THEME_GLIF_V2.equals(r1) == false) goto L22;
        return false;
    L22:
        if (THEME_GLIF_V3.equals(r1) == true) goto L32;
        return r2;
    L32:
        return false;
    }

    @Deprecated
    public static int getThemeRes(Intent r2, int r3) {
        return new ThemeResolver.Builder(ThemeResolver.getDefault()).setDefaultTheme(r3).setUseDayNight(false).build().resolve(r2);
    }

    @Deprecated
    public static int getThemeRes(Intent r2, int r3, String r4) {
        return new ThemeResolver.Builder(ThemeResolver.getDefault()).setDefaultTheme(r3).setUseDayNight(false).setOldestSupportedTheme(r4).build().resolve(r2);
    }

    @Deprecated
    public static int getThemeRes(String r2, int r3, String r4) {
        return new ThemeResolver.Builder(ThemeResolver.getDefault()).setDefaultTheme(r3).setUseDayNight(false).setOldestSupportedTheme(r4).build().resolve(r2);
    }

    @Deprecated
    public static int getThemeRes(String r2, int r3) {
        return new ThemeResolver.Builder(ThemeResolver.getDefault()).setDefaultTheme(r3).setUseDayNight(false).build().resolve(r2);
    }

    public static void applyTheme(Activity r1) {
        ThemeResolver.getDefault().applyTheme(r1);
    }
}
