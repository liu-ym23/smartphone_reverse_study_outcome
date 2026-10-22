package com.obric.android.agilelogger.utils;

import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class ObjectToStringUtils {
    public ObjectToStringUtils() {
    }

    public static String bundleToString(Bundle r2) {
        if (r2 != null) goto L5;
        return "null";
    L5:
        StringBuilder r0 = new StringBuilder(128);
        r0.append("Bundle[{");
        bundleToShortString(r2, r0);
        r0.append("}]");
        return r0.toString();
    }

    public static String intentToString(Intent r2) {
        if (r2 != null) goto L5;
        return "null";
    L5:
        StringBuilder r0 = new StringBuilder(128);
        r0.append("Intent { ");
        intentToShortString(r2, r0);
        r0.append(" }");
        return r0.toString();
    }

    private static void bundleToShortString(Bundle r4, StringBuilder r5) {
        Iterator<String> r0 = r4.keySet().iterator();
        boolean r1 = true;
    L4:
        if (r0.hasNext() == false) goto L46;
        String r2 = r0.next();
        if (r1 == true) goto L8;
        r5.append(", ");
    L8:
        r5.append(r2).append('=');
        Object r3 = r4.get(r2);
        if ((r3 instanceof int[]) == false) goto L12;
        r5.append(Arrays.toString((int[]) r3));
    L45:
        r1 = false;
        goto L4
    L12:
        if ((r3 instanceof byte[]) == false) goto L18;
        byte[] r6 = (byte[]) r3;
        if (r6.length >= 102400) goto L16;
        r5.append(Arrays.toString(r6));
        goto L45
    L16:
        r5.append("byte[] in Bundle is too long, limit for 100K");
        goto L45
    L18:
        if ((r3 instanceof boolean[]) == false) goto L21;
        r5.append(Arrays.toString((boolean[]) r3));
        goto L45
    L21:
        if ((r3 instanceof short[]) == false) goto L24;
        r5.append(Arrays.toString((short[]) r3));
        goto L45
    L24:
        if ((r3 instanceof long[]) == false) goto L27;
        r5.append(Arrays.toString((long[]) r3));
        goto L45
    L27:
        if ((r3 instanceof float[]) == false) goto L30;
        r5.append(Arrays.toString((float[]) r3));
        goto L45
    L30:
        if ((r3 instanceof double[]) == false) goto L33;
        r5.append(Arrays.toString((double[]) r3));
        goto L45
    L33:
        if ((r3 instanceof String[]) == false) goto L36;
        r5.append(Arrays.toString((String[]) r3));
        goto L45
    L36:
        if ((r3 instanceof CharSequence[]) == false) goto L39;
        r5.append(Arrays.toString((CharSequence[]) r3));
        goto L45
    L39:
        if ((r3 instanceof Parcelable[]) == false) goto L42;
        r5.append(Arrays.toString((Parcelable[]) r3));
        goto L45
    L42:
        if ((r3 instanceof Bundle) == false) goto L44;
        r5.append(bundleToString((Bundle) r3));
        goto L45
    L44:
        r5.append(r3);
        goto L45
    }

    private static void intentToShortString(Intent r5, StringBuilder r6) {
        String r0 = r5.getAction();
        boolean r1 = false;
        boolean r2 = true;
        if (r0 == null) goto L5;
        r6.append("act=").append(r0);
        boolean r3 = false;
    L6:
        Set<String> r4 = r5.getCategories();
        if (r4 == null) goto L18;
        if (r3 == true) goto L10;
        r6.append(' ');
    L10:
        r6.append("cat=[");
        Iterator<String> r7 = r4.iterator();
    L12:
        if (r7.hasNext() == false) goto L17;
        String r8 = r7.next();
        if (r2 == true) goto L16;
        r6.append(',');
    L16:
        r6.append(r8);
        r2 = false;
        goto L12
    L17:
        r6.append("]");
        r3 = false;
    L18:
        Uri r9 = r5.getData();
        if (r9 == null) goto L23;
        if (r3 == true) goto L22;
        r6.append(' ');
    L22:
        r6.append("dat=");
        r6.append(uriToSafeString(r9));
        r3 = false;
    L23:
        String r10 = r5.getType();
        if (r10 == null) goto L28;
        if (r3 == true) goto L27;
        r6.append(' ');
    L27:
        r6.append("typ=").append(r10);
        r3 = false;
    L28:
        int r11 = r5.getFlags();
        if (r11 == 0) goto L33;
        if (r3 == true) goto L32;
        r6.append(' ');
    L32:
        r6.append("flg=0x").append(Integer.toHexString(r11));
        r3 = false;
    L33:
        String r12 = r5.getPackage();
        if (r12 == null) goto L38;
        if (r3 == true) goto L37;
        r6.append(' ');
    L37:
        r6.append("pkg=").append(r12);
        r3 = false;
    L38:
        ComponentName r13 = r5.getComponent();
        if (r13 == null) goto L43;
        if (r3 == true) goto L42;
        r6.append(' ');
    L42:
        r6.append("cmp=").append(r13.flattenToShortString());
        r3 = false;
    L43:
        Rect r14 = r5.getSourceBounds();
        if (r14 == null) goto L49;
        if (r3 == true) goto L47;
        r6.append(' ');
    L47:
        r6.append("bnds=").append(r14.toShortString());
        r3 = false;
    L49:
        if (r5.getClipData() == null) goto L53;
        if (r3 == true) goto L52;
        r6.append(' ');
    L52:
        r6.append("(has clip)");
    L54:
        Bundle r15 = r5.getExtras();
        if (r15 == null) goto L59;
        if (r1 == true) goto L58;
        r6.append(' ');
    L58:
        r6.append("extras={");
        bundleToShortString(r15, r6);
        r6.append('}');
    L59:
        Intent r16 = r5.getSelector();
        if (r16 == null) goto L66;
        r6.append(" sel=");
        intentToShortString(r16, r6);
        r6.append("}");
        return;
    L66:
        return;
    L53:
        r1 = r3;
        goto L54
    L5:
        r3 = true;
        goto L6
    }

    private static String uriToSafeString(Uri r4) {
        Method r0 = Uri.class.getDeclaredMethod("toSafeString", new Class[0]);     // Catch: IllegalAccessException -> L4 InvocationTargetException -> L6 NoSuchMethodException -> L8
        r0.setAccessible(true);     // Catch: IllegalAccessException -> L4 InvocationTargetException -> L6 NoSuchMethodException -> L8
        return (String) r0.invoke(r4, new Object[0]);
    L4:
        e = move-exception;
        e.printStackTrace();
    L11:
        return r4.toString();
    L8:
        e = move-exception;
        e.printStackTrace();
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }
}
