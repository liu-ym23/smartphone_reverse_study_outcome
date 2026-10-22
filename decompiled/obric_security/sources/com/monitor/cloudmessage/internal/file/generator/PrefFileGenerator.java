package com.monitor.cloudmessage.internal.file.generator;

import android.content.Context;
import com.monitor.cloudmessage.utils.FileUtils;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class PrefFileGenerator {
    private static final String PREFS_SUFFIX = ".xml";

    public PrefFileGenerator() {
    }

    public static File copySPFiles(Context r9) {
        String r1 = r9.getApplicationInfo().dataDir + "/shared_prefs";
        String r10 = r9.getApplicationInfo().dataDir + "/spFiles";
        String r2 = r10 + File.separator + "/tmp";
        File r3 = new File(r1);
        if (r3.exists() == false) goto L18;
        File[] r4 = r3.listFiles();
        int r5 = r4.length;
        int r6 = 0;
    L5:
        if (r6 >= r5) goto L18;
        File r7 = r4[r6];
        String r8 = r7.getName();
        if (r8.endsWith(PREFS_SUFFIX) == false) goto L11;
        if (FileUtils.copyFile(r7.getAbsolutePath(), r2, r8) == true) goto L11;
        return null;
    L11:
        r6 = r6 + 1;
    L18:
        FileUtils.zip(r2, r10 + File.separator + "sp.zip");     // Catch: Exception -> L15
        FileUtils.removeDir(r2);
        return new File(r10 + File.separator + "sp.zip");
    L15:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
