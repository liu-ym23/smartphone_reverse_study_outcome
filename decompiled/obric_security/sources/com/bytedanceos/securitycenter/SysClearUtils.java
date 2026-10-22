package com.bytedanceos.securitycenter;

import android.os.Environment;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SysClearUtils {
    private static final boolean DEBUG = false;
    private static final String TAG = "SysClearUtils";

    static {
    }

    public SysClearUtils() {
    }

    public static String getTestConfig(String tag, String key) {
        List<String> r0 = getFileLines(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "360/cleandroid/debug_config.ini");
        if (r0 == null) goto L14;
        Iterator<String> r1 = r0.iterator();
        boolean r2 = false;
    L6:
        if (r1.hasNext() == false) goto L14;
        String r3 = r1.next();
        if (("[" + tag + "]").equals(r3) == true) goto L9;
        if (r2 == false) goto L6;
        String r4 = key + "=";
        if (r3.startsWith(r4) == false) goto L6;
        return r3.substring(r4.length());
    L9:
        r2 = true;
    L14:
        return null;
    }

    public static List<String> getFileLines(String filePath) {
        File r0 = new File(filePath);
        BufferedReader r1 = null;
        if (r0.exists() == true) goto L5;
        return null;
    L5:
        ArrayList r4 = new ArrayList();
        BufferedReader r2 = new BufferedReader(new FileReader(r0), 1024);     // Catch: Throwable -> L18 Exception -> L27
    L33:
        String r3 = r2.readLine();     // Catch: Throwable -> L15 Exception -> L17
        if (r3 == null) goto L13;
        if (TextUtils.isEmpty(r3) == true) goto L33;
        r4.add(r3);     // Catch: Throwable -> L15 Exception -> L17
    L13:
        r2.close();     // Catch: Exception -> L25
    L30:
    L17:
        r1 = r2;
    L15:
        th = th;
        r1 = r2;
    L19:
        if (r1 != null) goto L28;
    L21:
        throw th;
    L28:
        r1.close();     // Catch: Exception -> L26
        goto L21
    L18:
        th = th;
    L24:
        return r4;
    L22:
        if (r1 == null) goto L24;
        r1.close();     // Catch: Exception -> L25
        goto L30
    }

    public static int[] insertElement(int[] original, int element, int index) {
        int r0 = original.length;
        int[] r1 = new int[r0 + 1];
        System.arraycopy(original, 0, r1, 0, index);
        r1[index] = element;
        System.arraycopy(original, index, r1, index + 1, r0 - index);
        return r1;
    }
}
