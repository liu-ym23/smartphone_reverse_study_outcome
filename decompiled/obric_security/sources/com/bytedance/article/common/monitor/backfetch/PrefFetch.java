package com.bytedance.article.common.monitor.backfetch;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.util.FileUtils;
import com.bytedance.apm.util.PermissionUtils;
import com.bytedance.article.common.monitor.file.FileUploadManager;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PrefFetch {
    private static final String PREFS_SUFFIX = ".xml";
    public static final String SP_FILE_BACK_TYPE = "sp_file_back";
    private static long lastFetchTime;

    static {
    }

    public PrefFetch() {
    }

    public static List<String> getSharedPreferenceTags(Context r6) {
        ArrayList r0 = new ArrayList();
        File r1 = new File(r6.getApplicationInfo().dataDir + "/shared_prefs");
        if (r1.exists() == false) goto L10;
        File[] r7 = r1.listFiles();
        int r2 = r7.length;
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L10;
        String r4 = r7[r3].getName();
        if (r4.endsWith(PREFS_SUFFIX) == false) goto L9;
        r0.add(r4.substring(0, r4.length() - 4));
    L9:
        r3 = r3 + 1;
    L10:
        Collections.sort(r0);
        return r0;
    }

    public static boolean copySPFiles(Context r8) {
        if (PermissionUtils.isGrantSDCardWritePermission(r8) == true) goto L5;
        return false;
    L5:
        String r0 = r8.getApplicationInfo().dataDir + "/shared_prefs";
        String r9 = r8.getApplicationInfo().dataDir + "/spFiles";
        String r2 = r9 + File.separator + "/tmp";
        File r3 = new File(r0);
        if (r3.exists() == false) goto L21;
        File[] r1 = r3.listFiles();
        int r4 = r1.length;
        int r5 = 0;
    L8:
        if (r5 >= r4) goto L21;
        File r6 = r1[r5];
        String r7 = r6.getName();
        if (r7.endsWith(PREFS_SUFFIX) == false) goto L14;
        if (FileUtils.copyFile(r6.getAbsolutePath(), r2, r7) == true) goto L14;
        return false;
    L14:
        r5 = r5 + 1;
    L21:
        FileUtils.compress(r9 + File.separator + generateUploadFileName(), new String[]{r2});     // Catch: Exception -> L18
        FileUtils.removeDir(r2);
        return true;
    L18:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    private static String generateUploadFileName() {
        SimpleDateFormat r0 = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
        String r1 = FetchUtils.getVersionName(ApmContext.getHeader());
        if (TextUtils.isEmpty(r1) == false) goto L7;
        return String.format("%s_sp.zip", new Object[]{r0.format(new Date(System.currentTimeMillis()))});
    L7:
        return String.format("%s_sp_%s.zip", new Object[]{r0.format(new Date(System.currentTimeMillis())), r1});
    }

    public static void uploadSpFiles(final Context r4) {
        if (FetchUtils.checkFetchInterval(lastFetchTime, System.currentTimeMillis()) == true) goto L6;
        return;
    L6:
        if (copySPFiles(r4) == false) goto L9;
        lastFetchTime = System.currentTimeMillis();
        FileUploadManager.registerFileCallBack(SP_FILE_BACK_TYPE, new AnonymousClass1(r4));
        return;
    }
}
