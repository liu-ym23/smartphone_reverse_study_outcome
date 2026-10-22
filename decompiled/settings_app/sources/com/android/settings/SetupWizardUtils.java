package com.android.settings;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import com.android.setupwizardlib.util.SystemBarHelper;
import com.android.setupwizardlib.util.WizardManagerHelper;

/* JADX INFO: loaded from: classes2.dex */
public class SetupWizardUtils {
    public static final String EXTRA_SCRIPT_URI = "scriptUri";
    private static final String TAG = "SetupWizardUtils";

    public SetupWizardUtils() {
    }

    public static boolean isUsingWizardManager(Activity r1) {
        return r1.getIntent().hasExtra(EXTRA_SCRIPT_URI);
    }

    public static int getTheme(Intent r1) {
        if (WizardManagerHelper.isLightTheme(r1, true) == false) goto L6;
        return R.style.SetupWizardTheme_Light;
    L6:
        return R.style.SetupWizardTheme;
    }

    public static int getTransparentTheme(Intent r1) {
        if (WizardManagerHelper.isLightTheme(r1, true) == false) goto L6;
        return R.style.SetupWizardTheme_Light_Transparent;
    L6:
        return R.style.SetupWizardTheme_Transparent;
    }

    public static void setImmersiveMode(Activity r3) {
        if (r3.getIntent().getBooleanExtra("useImmersiveMode", false) == false) goto L6;
        SystemBarHelper.hideSystemBars(r3.getWindow());
        return;
    }

    public static void applyImmersiveFlags(Dialog r0) {
        SystemBarHelper.hideSystemBars(r0);
    }

    public static void copySetupExtras(Intent r2, Intent r3) {
        r3.putExtra("theme", r2.getStringExtra("theme"));
        r3.putExtra("useImmersiveMode", r2.getBooleanExtra("useImmersiveMode", false));
    }
}
