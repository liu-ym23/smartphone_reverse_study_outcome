package com.bytedanceos.application;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.obric.olog.OLog;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class ApplicationLabelUtils {
    public static final Pattern PCPATTERN = null;
    public static final Pattern PZPATTERN = null;

    public ApplicationLabelUtils() {
    }

    static {
        PCPATTERN = Pattern.compile("\\p{C}");
        PZPATTERN = Pattern.compile("\\p{Z}");
    }

    public static LabelEntry generatorLabelEntry(String label) {
        if (label != null) goto L6;
        return null;
    L6:
        return new LabelEntry(label);
    }

    public static String loadLabel(PackageManager pm, ApplicationInfo info) {
        CharSequence r0 = info.loadLabel(pm);
        if (TextUtils.isEmpty(r0) == false) goto L11;
        CharSequence r3 = loadResolveInfoLabel(pm, info.packageName);
        if (TextUtils.isEmpty(r3) == true) goto L8;
        r0 = r3;
    L8:
        if (TextUtils.isEmpty(r0) == false) goto L11;
        r0 = info.packageName;
    L11:
        if (TextUtils.isEmpty(r0) == false) goto L18;
        return "";
    L18:
        return PZPATTERN.matcher(PCPATTERN.matcher(r0).replaceAll("")).replaceAll(" ").trim();
    L15:
        e = move-exception;
        OLog.d("ApplicationLabelUtils", "label:" + r0 + " pkg:" + info.packageName);
        e.printStackTrace();
        return r0.toString();
    }

    private static CharSequence loadResolveInfoLabel(PackageManager pm, String packageName) {
        Intent r3 = pm.getLaunchIntentForPackage(packageName);
        if (r3 == null) goto L12;
        List<ResolveInfo> r4 = pm.queryIntentActivities(r3, 0);
        if (r4 == null) goto L17;
        Iterator<ResolveInfo> r5 = r4.iterator();
    L8:
        if (r5.hasNext() == false) goto L18;
        CharSequence r0 = r5.next().loadLabel(pm);
        if (TextUtils.isEmpty(r0) == true) goto L8;
        return r0;
    L18:
        return null;
    L17:
        return null;
    L12:
        return null;
    }
}
