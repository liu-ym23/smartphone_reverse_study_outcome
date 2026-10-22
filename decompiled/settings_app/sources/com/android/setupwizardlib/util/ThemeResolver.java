package com.android.setupwizardlib.util;

import android.app.Activity;
import android.content.Intent;
import com.android.setupwizardlib.R;

/* JADX INFO: loaded from: classes.dex */
public class ThemeResolver {
    private static ThemeResolver defaultResolver;
    private final int defaultTheme;
    private final String oldestSupportedTheme;
    private final boolean useDayNight;

    /* JADX INFO: renamed from: com.android.setupwizardlib.util.ThemeResolver$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private int defaultTheme;
        private String oldestSupportedTheme;
        private boolean useDayNight;

        public Builder() {
            this.defaultTheme = R.style.SuwThemeGlif_DayNight;
            this.oldestSupportedTheme = null;
            this.useDayNight = true;
        }

        public Builder(ThemeResolver r2) {
            this.defaultTheme = R.style.SuwThemeGlif_DayNight;
            this.oldestSupportedTheme = null;
            this.useDayNight = true;
            this.defaultTheme = ThemeResolver.access$000(r2);
            this.oldestSupportedTheme = ThemeResolver.access$100(r2);
            this.useDayNight = ThemeResolver.access$200(r2);
        }

        public Builder setDefaultTheme(int r1) {
            this.defaultTheme = r1;
            return this;
        }

        public Builder setOldestSupportedTheme(String r1) {
            this.oldestSupportedTheme = r1;
            return this;
        }

        public Builder setUseDayNight(boolean r1) {
            this.useDayNight = r1;
            return this;
        }

        public ThemeResolver build() {
            return new ThemeResolver(this.defaultTheme, this.oldestSupportedTheme, this.useDayNight, null);
        }
    }

    /* synthetic */ ThemeResolver(int r1, String r2, boolean r3, AnonymousClass1 r4) {
        this(r1, r2, r3);
    }

    static /* synthetic */ int access$000(ThemeResolver r0) {
        return r0.defaultTheme;
    }

    static /* synthetic */ String access$100(ThemeResolver r0) {
        return r0.oldestSupportedTheme;
    }

    static /* synthetic */ boolean access$200(ThemeResolver r0) {
        return r0.useDayNight;
    }

    public static void setDefault(ThemeResolver r0) {
        defaultResolver = r0;
    }

    public static ThemeResolver getDefault() {
        if (defaultResolver != null) goto L6;
        defaultResolver = new Builder().setDefaultTheme(R.style.SuwThemeGlif_DayNight).setUseDayNight(true).build();
    L6:
        return defaultResolver;
    }

    private ThemeResolver(int r1, String r2, boolean r3) {
        this.defaultTheme = r1;
        this.oldestSupportedTheme = r2;
        this.useDayNight = r3;
    }

    public int resolve(Intent r2) {
        return resolve(r2.getStringExtra("theme"), WizardManagerHelper.isSetupWizardIntent(r2));
    }

    public int resolve(String r2) {
        return resolve(r2, false);
    }

    private int resolve(String r2, boolean r3) {
        if (this.useDayNight == false) goto L6;
        if (r3 == true) goto L6;
        int r4 = getDayNightThemeRes(r2);
    L7:
        if (r4 == 0) goto L9;
        String r0 = this.oldestSupportedTheme;
        if (r0 != null) goto L13;
    L16:
        return r4;
    L13:
        if (compareThemes(r2, r0) >= 0) goto L16;
        return this.defaultTheme;
    L9:
        return this.defaultTheme;
    L6:
        r4 = getThemeRes(r2);
        goto L7
    }

    public void applyTheme(Activity r2) {
        r2.setTheme(resolve(r2.getIntent()));
    }

    private static int getDayNightThemeRes(String r3) {
        if (r3 == null) goto L49;
        r3.hashCode();
        byte r2 = -1;
        switch(r3.hashCode()) {
            case -2128555920: goto L36;
            case -1270463490: goto L32;
            case -1241052239: goto L28;
            case 3175618: goto L24;
            case 115650329: goto L20;
            case 115650330: goto L16;
            case 299066663: goto L12;
            case 767685465: goto L8;
            default: goto L39;
        };
    L39:
        switch(r2) {
            case 0: goto L48;
            case 1: goto L46;
            case 2: goto L44;
            case 3: goto L42;
            case 4: goto L48;
            case 5: goto L44;
            case 6: goto L46;
            case 7: goto L42;
            default: goto L49;
        };
    L42:
        return R.style.SuwThemeGlif_DayNight;
    L44:
        return R.style.SuwThemeGlifV3_DayNight;
    L46:
        return R.style.SuwThemeMaterial_DayNight;
    L48:
        return R.style.SuwThemeGlifV2_DayNight;
    L8:
        if (r3.equals(WizardManagerHelper.THEME_GLIF_LIGHT) == false) goto L39;
        r2 = 7;
        goto L39
    L12:
        if (r3.equals(WizardManagerHelper.THEME_MATERIAL) == false) goto L39;
        r2 = 6;
        goto L39
    L16:
        if (r3.equals(WizardManagerHelper.THEME_GLIF_V3) == false) goto L39;
        r2 = 5;
        goto L39
    L20:
        if (r3.equals(WizardManagerHelper.THEME_GLIF_V2) == false) goto L39;
        r2 = 4;
        goto L39
    L24:
        if (r3.equals(WizardManagerHelper.THEME_GLIF) == false) goto L39;
        r2 = 3;
        goto L39
    L28:
        if (r3.equals(WizardManagerHelper.THEME_GLIF_V3_LIGHT) == false) goto L39;
        r2 = 2;
        goto L39
    L32:
        if (r3.equals(WizardManagerHelper.THEME_MATERIAL_LIGHT) == false) goto L39;
        r2 = 1;
        goto L39
    L36:
        if (r3.equals(WizardManagerHelper.THEME_GLIF_V2_LIGHT) == false) goto L39;
        r2 = 0;
    L49:
        return 0;
    }

    private static int getThemeRes(String r3) {
        if (r3 == null) goto L57;
        r3.hashCode();
        byte r2 = -1;
        switch(r3.hashCode()) {
            case -2128555920: goto L36;
            case -1270463490: goto L32;
            case -1241052239: goto L28;
            case 3175618: goto L24;
            case 115650329: goto L20;
            case 115650330: goto L16;
            case 299066663: goto L12;
            case 767685465: goto L8;
            default: goto L39;
        };
    L39:
        switch(r2) {
            case 0: goto L56;
            case 1: goto L54;
            case 2: goto L52;
            case 3: goto L50;
            case 4: goto L48;
            case 5: goto L46;
            case 6: goto L44;
            case 7: goto L42;
            default: goto L57;
        };
    L42:
        return R.style.SuwThemeGlif_Light;
    L44:
        return R.style.SuwThemeMaterial;
    L46:
        return R.style.SuwThemeGlifV3;
    L48:
        return R.style.SuwThemeGlifV2;
    L50:
        return R.style.SuwThemeGlif;
    L52:
        return R.style.SuwThemeGlifV3_Light;
    L54:
        return R.style.SuwThemeMaterial_Light;
    L56:
        return R.style.SuwThemeGlifV2_Light;
    L8:
        if (r3.equals(WizardManagerHelper.THEME_GLIF_LIGHT) == false) goto L39;
        r2 = 7;
        goto L39
    L12:
        if (r3.equals(WizardManagerHelper.THEME_MATERIAL) == false) goto L39;
        r2 = 6;
        goto L39
    L16:
        if (r3.equals(WizardManagerHelper.THEME_GLIF_V3) == false) goto L39;
        r2 = 5;
        goto L39
    L20:
        if (r3.equals(WizardManagerHelper.THEME_GLIF_V2) == false) goto L39;
        r2 = 4;
        goto L39
    L24:
        if (r3.equals(WizardManagerHelper.THEME_GLIF) == false) goto L39;
        r2 = 3;
        goto L39
    L28:
        if (r3.equals(WizardManagerHelper.THEME_GLIF_V3_LIGHT) == false) goto L39;
        r2 = 2;
        goto L39
    L32:
        if (r3.equals(WizardManagerHelper.THEME_MATERIAL_LIGHT) == false) goto L39;
        r2 = 1;
        goto L39
    L36:
        if (r3.equals(WizardManagerHelper.THEME_GLIF_V2_LIGHT) == false) goto L39;
        r2 = 0;
    L57:
        return 0;
    }

    private static int compareThemes(String r0, String r1) {
        return Integer.valueOf(getThemeVersion(r0)).compareTo(Integer.valueOf(getThemeVersion(r1)));
    }

    private static int getThemeVersion(String r6) {
        if (r6 == null) goto L45;
        r6.hashCode();
        switch(r6.hashCode()) {
            case -2128555920: goto L36;
            case -1270463490: goto L32;
            case -1241052239: goto L28;
            case 3175618: goto L24;
            case 115650329: goto L20;
            case 115650330: goto L16;
            case 299066663: goto L12;
            case 767685465: goto L8;
            default: goto L6;
        };
    L6:
        byte r7 = -1;
    L39:
        switch(r7) {
            case 0: goto L44;
            case 1: goto L43;
            case 2: goto L42;
            case 3: goto L41;
            case 4: goto L44;
            case 5: goto L42;
            case 6: goto L43;
            case 7: goto L41;
            default: goto L45;
        };
    L41:
        return 2;
    L42:
        return 4;
    L43:
        return 1;
    L44:
        return 3;
    L8:
        if (r6.equals(WizardManagerHelper.THEME_GLIF_LIGHT) == false) goto L46;
        r7 = 7;
        goto L39
    L46:
        r7 = -1;
        goto L39
    L12:
        if (r6.equals(WizardManagerHelper.THEME_MATERIAL) == false) goto L47;
        r7 = 6;
        goto L39
    L47:
        r7 = -1;
        goto L39
    L16:
        if (r6.equals(WizardManagerHelper.THEME_GLIF_V3) == false) goto L48;
        r7 = 5;
        goto L39
    L48:
        r7 = -1;
        goto L39
    L20:
        if (r6.equals(WizardManagerHelper.THEME_GLIF_V2) == false) goto L49;
        r7 = 4;
        goto L39
    L49:
        r7 = -1;
        goto L39
    L24:
        if (r6.equals(WizardManagerHelper.THEME_GLIF) == false) goto L50;
        r7 = 3;
        goto L39
    L50:
        r7 = -1;
        goto L39
    L28:
        if (r6.equals(WizardManagerHelper.THEME_GLIF_V3_LIGHT) == false) goto L51;
        r7 = 2;
        goto L39
    L51:
        r7 = -1;
        goto L39
    L32:
        if (r6.equals(WizardManagerHelper.THEME_MATERIAL_LIGHT) == false) goto L52;
        r7 = 1;
        goto L39
    L52:
        r7 = -1;
        goto L39
    L36:
        if (r6.equals(WizardManagerHelper.THEME_GLIF_V2_LIGHT) == false) goto L53;
        r7 = 0;
        goto L39
    L53:
        r7 = -1;
    L45:
        return -1;
    }
}
