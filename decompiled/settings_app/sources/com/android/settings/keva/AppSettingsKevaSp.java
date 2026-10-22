package com.android.settings.keva;

import com.bytedance.keva.Keva;

/* JADX INFO: loaded from: classes2.dex */
public class AppSettingsKevaSp {
    private static final String KEVA_FIRST_SEARCH = "settings_first_search";
    private static final String KEVA_REPO_NAME = "settings_keva_sp";
    private static final Keva keva = null;

    public AppSettingsKevaSp() {
    }

    static {
        keva = Keva.getRepo(KEVA_REPO_NAME, 0);
    }

    public static void setKevaFirstSearch(boolean r2) {
        keva.storeBoolean(KEVA_FIRST_SEARCH, r2);
    }

    public static Boolean getKevaFirstSearch() {
        return Boolean.valueOf(keva.getBoolean(KEVA_FIRST_SEARCH, true));
    }
}
