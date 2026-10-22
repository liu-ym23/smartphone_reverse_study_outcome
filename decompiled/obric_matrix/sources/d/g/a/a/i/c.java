package d.g.a.a.i;

import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    private static void a(Bundle r4, StringBuilder r5) {
        Iterator<String> r0 = r4.keySet().iterator();
        boolean r1 = true;
    L4:
        if (r0.hasNext() == false) goto L47;
        String r2 = r0.next();
        if (r1 == true) goto L8;
        r5.append(", ");
    L8:
        r5.append(r2);
        r5.append('=');
        Object r3 = r4.get(r2);
        if ((r3 instanceof int[]) == false) goto L13;
        String r6 = Arrays.toString((int[]) r3);
    L11:
        r5.append(r6);
    L46:
        r1 = false;
        goto L4
    L13:
        if ((r3 instanceof byte[]) == false) goto L19;
        byte[] r7 = (byte[]) r3;
        if (r7.length >= 102400) goto L17;
        r6 = Arrays.toString(r7);
        goto L11
    L17:
        r6 = "byte[] in Bundle is too long, limit for 100K";
        goto L11
    L19:
        if ((r3 instanceof boolean[]) == false) goto L22;
        r6 = Arrays.toString((boolean[]) r3);
        goto L11
    L22:
        if ((r3 instanceof short[]) == false) goto L25;
        r6 = Arrays.toString((short[]) r3);
        goto L11
    L25:
        if ((r3 instanceof long[]) == false) goto L28;
        r6 = Arrays.toString((long[]) r3);
        goto L11
    L28:
        if ((r3 instanceof float[]) == false) goto L31;
        r6 = Arrays.toString((float[]) r3);
        goto L11
    L31:
        if ((r3 instanceof double[]) == false) goto L34;
        r6 = Arrays.toString((double[]) r3);
        goto L11
    L34:
        if ((r3 instanceof String[]) == false) goto L37;
        r6 = Arrays.toString((String[]) r3);
        goto L11
    L37:
        if ((r3 instanceof CharSequence[]) == false) goto L40;
        r6 = Arrays.toString((CharSequence[]) r3);
        goto L11
    L40:
        if ((r3 instanceof Parcelable[]) == false) goto L43;
        r6 = Arrays.toString((Parcelable[]) r3);
        goto L11
    L43:
        if ((r3 instanceof Bundle) == false) goto L45;
        r6 = b((Bundle) r3);
        goto L11
    L45:
        r5.append(r3);
        goto L46
    }

    public static String b(Bundle r2) {
        if (r2 != null) goto L5;
        return "null";
    L5:
        StringBuilder r0 = new StringBuilder(128);
        r0.append("Bundle[{");
        a(r2, r0);
        r0.append("}]");
        return r0.toString();
    }

    private static void c(Intent r6, StringBuilder r7) {
        int r0 = Build.VERSION.SDK_INT;
        String r1 = r6.getAction();
        boolean r2 = true;
        boolean r3 = false;
        if (r1 == null) goto L5;
        r7.append("act=");
        r7.append(r1);
        boolean r4 = false;
    L6:
        Set<String> r5 = r6.getCategories();
        if (r5 == null) goto L18;
        if (r4 == true) goto L10;
        r7.append(' ');
    L10:
        r7.append("cat=[");
        Iterator<String> r8 = r5.iterator();
    L12:
        if (r8.hasNext() == false) goto L17;
        String r9 = r8.next();
        if (r2 == true) goto L16;
        r7.append(',');
    L16:
        r7.append(r9);
        r2 = false;
        goto L12
    L17:
        r7.append("]");
        r4 = false;
    L18:
        Uri r10 = r6.getData();
        if (r10 == null) goto L36;
        if (r4 == true) goto L22;
        r7.append(' ');
    L22:
        r7.append("dat=");
        if (r0 < 14) goto L26;
        String r11 = e(r10);
    L25:
        r7.append(r11);
    L35:
        r4 = false;
        goto L36
    L26:
        String r12 = r10.getScheme();
        if (r12 != null) goto L29;
    L34:
        r7.append(r10);
        goto L35
    L29:
        if (r12.equalsIgnoreCase("tel") == false) goto L32;
        r11 = "tel:xxx-xxx-xxxx";
        goto L25
    L32:
        if (r12.equalsIgnoreCase("smsto") == false) goto L34;
        r11 = "smsto:xxx-xxx-xxxx";
    L36:
        String r13 = r6.getType();
        if (r13 == null) goto L41;
        if (r4 == true) goto L40;
        r7.append(' ');
    L40:
        r7.append("typ=");
        r7.append(r13);
        r4 = false;
    L41:
        int r14 = r6.getFlags();
        if (r14 == 0) goto L46;
        if (r4 == true) goto L45;
        r7.append(' ');
    L45:
        r7.append("flg=0x");
        r7.append(Integer.toHexString(r14));
        r4 = false;
    L46:
        String r15 = r6.getPackage();
        if (r15 == null) goto L51;
        if (r4 == true) goto L50;
        r7.append(' ');
    L50:
        r7.append("pkg=");
        r7.append(r15);
        r4 = false;
    L51:
        ComponentName r16 = r6.getComponent();
        if (r16 == null) goto L56;
        if (r4 == true) goto L55;
        r7.append(' ');
    L55:
        r7.append("cmp=");
        r7.append(r16.flattenToShortString());
        r4 = false;
    L56:
        Rect r17 = r6.getSourceBounds();
        if (r17 == null) goto L62;
        if (r4 == true) goto L60;
        r7.append(' ');
    L60:
        r7.append("bnds=");
        r7.append(r17.toShortString());
        r4 = false;
    L62:
        if (r0 >= 16) goto L64;
    L68:
        r3 = r4;
    L69:
        Bundle r18 = r6.getExtras();
        if (r18 == null) goto L75;
        if (r3 == true) goto L73;
        r7.append(' ');
    L73:
        r7.append("extras={");
        a(r18, r7);
        r7.append('}');
    L75:
        if (r0 < 15) goto L83;
        Intent r19 = r6.getSelector();
        if (r19 == null) goto L84;
        r7.append(" sel=");
        c(r19, r7);
        r7.append("}");
        return;
    L84:
        return;
    L83:
        return;
    L64:
        if (r6.getClipData() == null) goto L68;
        if (r4 == true) goto L67;
        r7.append(' ');
    L67:
        r7.append("(has clip)");
        goto L69
    L5:
        r4 = true;
        goto L6
    }

    public static String d(Intent r2) {
        if (r2 != null) goto L5;
        return "null";
    L5:
        StringBuilder r0 = new StringBuilder(128);
        r0.append("Intent { ");
        c(r2, r0);
        r0.append(" }");
        return r0.toString();
    }

    private static String e(Uri r4) {
        if (Build.VERSION.SDK_INT < 14) goto L13;
        Method r0 = Uri.class.getDeclaredMethod("toSafeString", new Class[0]);     // Catch: IllegalAccessException -> L6 InvocationTargetException -> L8 NoSuchMethodException -> L10
        r0.setAccessible(true);     // Catch: IllegalAccessException -> L6 InvocationTargetException -> L8 NoSuchMethodException -> L10
        return (String) r0.invoke(r4, new Object[0]);
    L6:
        e = move-exception;
        e.printStackTrace();
    L10:
        e = move-exception;
        e.printStackTrace();
    L8:
        e = move-exception;
        e.printStackTrace();
    L13:
        return r4.toString();
    }
}
