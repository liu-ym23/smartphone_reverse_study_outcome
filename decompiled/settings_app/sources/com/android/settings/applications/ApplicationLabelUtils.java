package com.android.settings.applications;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.android.settings.R;
import com.android.settings.pinyin.PinyinUtils;
import com.android.settings.utils.HanziToPinyin;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ApplicationLabelUtils {
    private static String[] sSpecialLableSource;
    private static String[] sSpecialLableSourceExclude;
    private static String[] sSpecialLableTarget;

    public ApplicationLabelUtils() {
    }

    public static String getSection(String r1) {
        if (TextUtils.isEmpty(r1) == true) goto L8;
        char r2 = r1.charAt(0);
        if (Character.isLetter(r2) == true) goto L7;
        return "#";
    L7:
        return Character.toString(r2);
    L8:
        return "#";
    }

    public static LabelEntry generatorLabelEntry(Context r6, String r7, String r8) {
        ArrayList<HanziToPinyin.Token> r0 = null;
        if (r8 != null) goto L5;
        return null;
    L5:
        ensureSpecialLableSource(r6);
        if (r8 == null) goto L18;
        String r1 = r8.trim();
        if (TextUtils.isEmpty(r1) == true) goto L18;
        int r2 = 0;
    L10:
        String[] r3 = sSpecialLableSource;
        if (r2 >= r3.length) goto L18;
        if (r1.startsWith(r3[r2]) == false) goto L17;
        if (r1.startsWith(sSpecialLableSourceExclude[r2]) == true) goto L17;
        StringBuilder r4 = new StringBuilder().append(sSpecialLableTarget[r2]);
        boolean r5 = true;
        r0 = HanziToPinyin.getInstance().get(r4.append(r1.substring(1)).toString());
    L19:
        if (r5 == true) goto L21;
        r0 = HanziToPinyin.getInstance().get(r8);
    L21:
        StringBuilder r9 = new StringBuilder();
        StringBuilder r10 = new StringBuilder();
        Iterator<HanziToPinyin.Token> r11 = r0.iterator();
    L23:
        if (r11.hasNext() == false) goto L27;
        HanziToPinyin.Token r12 = r11.next();
        char r13 = r12.target.charAt(0);
        if (Character.isSpaceChar(r13) == true) goto L23;
        r9.append(r13);
        r10.append(r12.target);
        goto L23
    L27:
        String r14 = r10.toString();
        if (getSection(r14).equals("#") == false) goto L31;
        r14 = "#" + r14;
    L31:
        return new LabelEntry.Builder().setPacakgeName(r7).setLabel(r8).setLabelPinyin(r14).setFirstLetters(r9.toString()).setFirstChar(PinyinUtils.getFirstChar(r14)).build();
    L17:
        r2 = r2 + 1;
    L18:
        r5 = false;
        goto L19
    }

    public static String loadLabelPinyin(Context r5, String r6) {
        ArrayList<HanziToPinyin.Token> r0 = null;
        if (r6 != null) goto L5;
        return null;
    L5:
        ensureSpecialLableSource(r5);
        if (r6 == null) goto L18;
        String r1 = r6.trim();
        if (TextUtils.isEmpty(r1) == true) goto L18;
        int r2 = 0;
    L10:
        String[] r3 = sSpecialLableSource;
        if (r2 >= r3.length) goto L18;
        if (r1.startsWith(r3[r2]) == false) goto L17;
        if (r1.startsWith(sSpecialLableSourceExclude[r2]) == true) goto L17;
        StringBuilder r4 = new StringBuilder().append(sSpecialLableTarget[r2]);
        boolean r7 = true;
        r0 = HanziToPinyin.getInstance().get(r4.append(r1.substring(1)).toString());
    L19:
        if (r7 == true) goto L21;
        r0 = HanziToPinyin.getInstance().get(r6);
    L21:
        StringBuilder r8 = new StringBuilder();
        StringBuilder r9 = new StringBuilder();
        Iterator<HanziToPinyin.Token> r10 = r0.iterator();
    L23:
        if (r10.hasNext() == false) goto L27;
        HanziToPinyin.Token r11 = r10.next();
        char r12 = r11.target.charAt(0);
        if (Character.isSpaceChar(r12) == true) goto L23;
        r8.append(r12);
        r9.append(r11.target);
        goto L23
    L27:
        String r13 = r9.toString();
        if (getSection(r13).equals("#") == true) goto L30;
        return r13;
    L30:
        return "#" + r13;
    L17:
        r2 = r2 + 1;
    L18:
        r7 = false;
        goto L19
    }

    public static String loadLabel(Context r3, ApplicationInfo r4) {
        CharSequence r0 = r4.loadLabel(r3.getPackageManager());
        if (TextUtils.isEmpty(r0) == false) goto L15;
        CharSequence r5 = loadResolveInfoLabel(r3, r4.packageName);
        if (TextUtils.isEmpty(r5) == true) goto L8;
        r0 = r5;
    L8:
        if (TextUtils.isEmpty(r0) == false) goto L15;
        r0 = r4.packageName;
    L15:
        return r0.toString().replaceAll("\\p{C}", "").replaceAll("\\p{Z}", HanziToPinyin.Token.SEPARATOR).trim();
    L12:
        e = move-exception;
        OLog.d("ApplicationLabelUtils", "label:" + r0 + " pkg:" + r4.packageName);
        e.printStackTrace();
        return r0.toString();
    }

    private static CharSequence loadResolveInfoLabel(Context r2, String r3) {
        PackageManager r4 = r2.getPackageManager();
        Intent r5 = r4.getLaunchIntentForPackage(r3);
        if (r5 == null) goto L12;
        List<ResolveInfo> r6 = r4.queryIntentActivities(r5, 0);
        if (r6 == null) goto L17;
        Iterator<ResolveInfo> r7 = r6.iterator();
    L8:
        if (r7.hasNext() == false) goto L18;
        CharSequence r0 = r7.next().loadLabel(r4);
        if (TextUtils.isEmpty(r0) == true) goto L8;
        return r0;
    L18:
        return null;
    L17:
        return null;
    L12:
        return null;
    }

    private static synchronized void ensureSpecialLableSource(Context r3) {
        monitor-enter(ApplicationLabelUtils.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (sSpecialLableSource != null) goto L7;
    L10:
        sSpecialLableSource = r3.getResources().getStringArray(R.array.speical_app_label_source);     // Catch: Throwable -> L13
        sSpecialLableTarget = r3.getResources().getStringArray(R.array.speical_app_label_target);     // Catch: Throwable -> L13
        sSpecialLableSourceExclude = r3.getResources().getStringArray(R.array.speical_app_label_source_exclude);     // Catch: Throwable -> L13
    L11:
        monitor-exit(ApplicationLabelUtils.class);
        return;
    L7:
        if (sSpecialLableTarget == null) goto L10;
        if (sSpecialLableSourceExclude != null) goto L11;
        goto L10
    }
}
