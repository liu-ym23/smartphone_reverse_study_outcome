package com.obric.android.agilelogger.utils;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class FileUtils {
    public FileUtils() {
    }

    public static File getDefaultLogDir(Context r2) {
        File r0 = new File(r2.getFilesDir(), "ologs");
        if (r0.exists() == true) goto L5;
        r0.mkdir();
    L5:
        return r0;
    }

    public static String getBufferDirPath(Context r2) {
        File r3 = r2.getFilesDir();
        if (r3 == null) goto L9;
        File r0 = new File(r3.getAbsolutePath(), "olog_cache");
        if (r0.exists() == true) goto L8;
        r0.mkdir();
    L8:
        return r0.getAbsolutePath();
    L9:
        return null;
    }
}
