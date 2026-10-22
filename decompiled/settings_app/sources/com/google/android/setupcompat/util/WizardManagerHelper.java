package com.google.android.setupcompat.util;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import com.GlobalProxyLancet;
import com.bytedance.networkstackapplib.NetworkStackConstant;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class WizardManagerHelper {
    public static final String ACTION_NEXT = "com.android.wizard.NEXT";
    public static final String EXTRA_IS_DEFERRED_SETUP = "deferredSetup";
    public static final String EXTRA_IS_FIRST_RUN = "firstRun";
    public static final String EXTRA_IS_PORTAL_SETUP = "portalSetup";
    public static final String EXTRA_IS_PRE_DEFERRED_SETUP = "preDeferredSetup";
    public static final String EXTRA_IS_SETUP_FLOW = "isSetupFlow";
    public static final String EXTRA_IS_SUW_SUGGESTED_ACTION_FLOW = "isSuwSuggestedActionFlow";
    public static final String EXTRA_RESULT_CODE = "com.android.setupwizard.ResultCode";
    public static final String EXTRA_SUW_LIFECYCLE = "suw_lifecycle";
    public static final String EXTRA_THEME = "theme";
    public static final String EXTRA_USE_IMMERSIVE_MODE = "useImmersiveMode";
    public static final String EXTRA_WIZARD_BUNDLE = "wizardBundle";
    public static final String SETTINGS_GLOBAL_DEVICE_PROVISIONED = "device_provisioned";
    public static final String SETTINGS_SECURE_USER_SETUP_COMPLETE = "user_setup_complete";

    public static final enum SuwLifeCycleEnum extends Enum<SuwLifeCycleEnum> {
        private static final /* synthetic */ SuwLifeCycleEnum[] $VALUES = null;
        public static final SuwLifeCycleEnum DEFERRED = null;
        public static final SuwLifeCycleEnum INITIALIZATION = null;
        public static final SuwLifeCycleEnum PORTAL = null;
        public static final SuwLifeCycleEnum PREDEFERRED = null;
        public static final SuwLifeCycleEnum RESTORE_ANYTIME = null;
        public static final SuwLifeCycleEnum UNKNOWN = null;
        public final int value;

        private static /* synthetic */ SuwLifeCycleEnum[] $values() {
            return new SuwLifeCycleEnum[]{UNKNOWN, INITIALIZATION, PREDEFERRED, DEFERRED, PORTAL, RESTORE_ANYTIME};
        }

        public static SuwLifeCycleEnum valueOf(String r1) {
            return (SuwLifeCycleEnum) Enum.valueOf(SuwLifeCycleEnum.class, r1);
        }

        public static SuwLifeCycleEnum[] values() {
            return (SuwLifeCycleEnum[]) $VALUES.clone();
        }

        static {
            UNKNOWN = new SuwLifeCycleEnum(NetworkStackConstant.UNKNOWN_TYPE, 0, 0);
            INITIALIZATION = new SuwLifeCycleEnum("INITIALIZATION", 1, 1);
            PREDEFERRED = new SuwLifeCycleEnum("PREDEFERRED", 2, 2);
            DEFERRED = new SuwLifeCycleEnum("DEFERRED", 3, 3);
            PORTAL = new SuwLifeCycleEnum("PORTAL", 4, 4);
            RESTORE_ANYTIME = new SuwLifeCycleEnum("RESTORE_ANYTIME", 5, 5);
            $VALUES = $values();
        }

        private SuwLifeCycleEnum(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
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

    public static void copyWizardManagerExtras(Intent r8, Intent r9) {
        r9.putExtra("wizardBundle", GlobalProxyLancet.com_bytedance_sysoptimizer_BadParcelableLancet_getBundleExtra(r8, "wizardBundle"));
        Iterator r0 = Arrays.asList(new String[]{"firstRun", "deferredSetup", "preDeferredSetup", "portalSetup", "isSetupFlow", "isSuwSuggestedActionFlow"}).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        String r1 = (String) r0.next();
        r9.putExtra(r1, r8.getBooleanExtra(r1, false));
        goto L4
    L6:
        r9.putExtra("suw_lifecycle", r8.getIntExtra("suw_lifecycle", SuwLifeCycleEnum.UNKNOWN.value));
        r9.putExtra("theme", r8.getStringExtra("theme"));
    }

    @Deprecated
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

    public static boolean isPortalSetupWizard(Intent r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        if (r2.getBooleanExtra("portalSetup", false) == false) goto L9;
        return true;
    L9:
        return false;
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

    public static boolean isInitialSetupWizard(Intent r2) {
        return r2.getBooleanExtra("firstRun", false);
    }

    public static boolean isAnySetupWizard(Intent r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        return r2.getBooleanExtra("isSetupFlow", false);
    }

    private WizardManagerHelper() {
    }
}
