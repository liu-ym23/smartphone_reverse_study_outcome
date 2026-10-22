package com.ttnet.org.chromium.base;

import android.content.Context;
import android.provider.Settings;
import androidx.annotation.Nullable;
import com.ttnet.org.chromium.base.supplier.Supplier;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class CommandLineInitUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String COMMAND_LINE_FILE_PATH = "/data/local";
    private static final String COMMAND_LINE_FILE_PATH_DEBUG_APP = "/data/local/tmp";

    private CommandLineInitUtil() {
    }

    private static String getDebugApp(Context r3) {
        if (Settings.Global.getInt(r3.getContentResolver(), "adb_enabled", 0) == 1) goto L5;
        return null;
    L5:
        return Settings.Global.getString(r3.getContentResolver(), "debug_app");
    }

    public static void initCommandLine(String r1) {
        initCommandLine(r1, null);
    }

    private static boolean shouldUseDebugCommandLine(@Nullable Supplier<Boolean> r2) {
        if (r2 != null) goto L5;
    L7:
        Context r3 = ContextUtils.getApplicationContext();
        if (r3.getPackageName().equals(getDebugApp(r3)) == false) goto L10;
        return true;
    L10:
        if (BuildInfo.isDebugAndroid() == true) goto L15;
        return false;
    L15:
        return true;
    L5:
        if (r2.get().booleanValue() == false) goto L7;
        return true;
    }

    public static void initCommandLine(String r2, @Nullable Supplier<Boolean> r3) {
        File r0 = new File(COMMAND_LINE_FILE_PATH_DEBUG_APP, r2);
        if (r0.exists() == true) goto L5;
    L6:
        r0 = new File(COMMAND_LINE_FILE_PATH, r2);
    L7:
        CommandLine.initFromFile(r0.getPath());
        return;
    L5:
        if (shouldUseDebugCommandLine(r3) == true) goto L7;
        goto L6
    }
}
