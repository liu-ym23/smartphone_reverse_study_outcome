package com.android.settings.fuelgauge.appBatteryUseOptimization;

import android.net.Uri;
import android.provider.BaseColumns;

/* JADX INFO: loaded from: classes2.dex */
public class OptimizationHelper {
    static final String AUTHORITY = "com.bytedanceos.security.appUseBatteryOptimization";
    static final Uri CONTENT_ID_URI_BASE = null;
    static final Uri CONTENT_URI = null;

    static class ItemColumns implements BaseColumns {
        static final String DEFAULT_VALUE = "defaultValue";
        static final String ENABLE = "enable";
        static final String INSTALL = "installed";
        static final int INSTALLED = 1;
        static final int NOT_OPTIMIZATION = 0;
        static final int OPTIMIZATION = 1;
        static final String PACKAGE_NAME = "packageName";
        static final String PARAM = "param";
        static final String UID = "uid";
        static final int UNINSTALLED = 0;
        static final String USERID = "userid";
        static final String VERSION = "version";

        ItemColumns() {
        }
    }

    public OptimizationHelper() {
    }

    static {
        CONTENT_URI = Uri.parse("content://com.bytedanceos.security.appUseBatteryOptimization/appUseBatteryOptimization");
        CONTENT_ID_URI_BASE = Uri.parse("content://com.bytedanceos.security.appUseBatteryOptimization/appUseBatteryOptimization/");
    }
}
