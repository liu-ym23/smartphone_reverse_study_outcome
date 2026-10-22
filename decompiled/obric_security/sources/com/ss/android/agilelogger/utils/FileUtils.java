package com.ss.android.agilelogger.utils;

import android.content.Context;
import com.bytedance.tracing.internal.TracingConstants;
import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
public class FileUtils {
    public FileUtils() {
    }

    public static File getDefaultLogDir(Context r2) {
        File r1 = r2.getExternalFilesDir(TracingConstants.KEY_LOGS);
        if (r1 != null) goto L6;
        r1 = new File(r2.getFilesDir(), TracingConstants.KEY_LOGS);
    L6:
        if (r1.exists() == true) goto L8;
        r1.mkdir();
    L8:
        return r1;
    }

    public static String getBufferDirPath(Context r2) {
        File r3 = r2.getFilesDir();
        if (r3 == null) goto L9;
        File r0 = new File(r3.getAbsolutePath(), "ALOG");
        if (r0.exists() == true) goto L8;
        r0.mkdir();
    L8:
        return r0.getAbsolutePath();
    L9:
        return null;
    }
}
