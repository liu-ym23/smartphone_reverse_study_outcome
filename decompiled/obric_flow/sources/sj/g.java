package sj;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.bytedance.common.utility.Logger;
import com.bytedance.ttnet.TTNetInit;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g implements s9.f, da.a, rj.a, u9.k, u9.j, ol.c {
    public static final int h(Activity r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        WindowInsetsCompat r10 = ViewCompat.getRootWindowInsets(r5.getWindow().getDecorView());
        if (r10 == null) goto L7;
        Insets r11 = r10.getInsets(WindowInsetsCompat.Type.ime());
        if (r11 == null) goto L7;
        Integer r12 = Integer.valueOf(r11.bottom);
    L8:
        if (r12 != null) goto L10;
        return 0;
    L10:
        return r12.intValue();
    L7:
        r12 = null;
        goto L8
    }

    public static Object i(Class r5, String r10, Object... r11) {
        if (TextUtils.isEmpty(r10) == false) goto L19;
        return null;
    L19:
        Method r12 = k(r5, r10, new Class[0]);     // Catch: Throwable -> L13
        if (r12 != null) goto L9;
        return null;
    L9:
        r12.setAccessible(true);     // Catch: Throwable -> L13
        if (r11.length <= 0) goto L16;
        return r12.invoke(r11[0], null);
    L16:
        return r12.invoke(null, null);
    L13:
        th = move-exception;
        d5.b.e("ReflectUtils", "exception in invokeMethod, pkg : " + r5.getName() + ", function : " + r10 + ", " + th.toString());
        return null;
    }

    public static String j(String r5, long r10, String r11, String r12) {
        return r5 + r11 + r12 + r10;
    }

    public static Method k(Class r5, String r10, Class[] r11) {
        if (r5 != null) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r10) == true) goto L19;
        return r5.getMethod(r10, r11);
    L9:
        th = move-exception;
        d5.b.e("ReflectUtils", "exception in getMethod, pkg : " + r5.getName() + ", function : " + r10 + ", " + th.toString());
        return r5.getDeclaredMethod(r10, r11);
    L20:
        return null;
    L19:
        return null;
    }

    public static final void l() {
        if (com.bytedance.android.monitorV2.webview.c.f3753x.getValue() != null) goto L6;
        return;
    L6:
        throw new ClassCastException();
    }

    public static final void n(Activity r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        View r10 = r5.getCurrentFocus();
        if (r10 == null) goto L6;
        Object r11 = r5.getSystemService("input_method");
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) r11).hideSoftInputFromWindow(r10.getWindowToken(), 2);
        return;
    L6:
        WindowInsetsControllerCompat r12 = ViewCompat.getWindowInsetsController(r5.getWindow().getDecorView());
        if (r12 == null) goto L10;
        r12.hide(WindowInsetsCompat.Type.ime());
        return;
    }

    public static void o(Bundle r5, StringBuilder r10) {
        Iterator<String> r11 = r5.keySet().iterator();
        boolean r12 = true;
    L4:
        if (r11.hasNext() == false) goto L46;
        String r13 = r11.next();
        if (r12 == true) goto L8;
        r10.append(", ");
    L8:
        r10.append(r13);
        r10.append('=');
        Object r14 = r5.get(r13);
        if ((r14 instanceof int[]) == false) goto L12;
        r10.append(Arrays.toString((int[]) r14));
    L45:
        r12 = false;
        goto L4
    L12:
        if ((r14 instanceof byte[]) == false) goto L18;
        byte[] r15 = (byte[]) r14;
        if (r15.length >= 102400) goto L16;
        r10.append(Arrays.toString(r15));
        goto L45
    L16:
        r10.append("byte[] in Bundle is too long, limit for 100K");
        goto L45
    L18:
        if ((r14 instanceof boolean[]) == false) goto L21;
        r10.append(Arrays.toString((boolean[]) r14));
        goto L45
    L21:
        if ((r14 instanceof short[]) == false) goto L24;
        r10.append(Arrays.toString((short[]) r14));
        goto L45
    L24:
        if ((r14 instanceof long[]) == false) goto L27;
        r10.append(Arrays.toString((long[]) r14));
        goto L45
    L27:
        if ((r14 instanceof float[]) == false) goto L30;
        r10.append(Arrays.toString((float[]) r14));
        goto L45
    L30:
        if ((r14 instanceof double[]) == false) goto L33;
        r10.append(Arrays.toString((double[]) r14));
        goto L45
    L33:
        if ((r14 instanceof String[]) == false) goto L36;
        r10.append(Arrays.toString((String[]) r14));
        goto L45
    L36:
        if ((r14 instanceof CharSequence[]) == false) goto L39;
        r10.append(Arrays.toString((CharSequence[]) r14));
        goto L45
    L39:
        if ((r14 instanceof Parcelable[]) == false) goto L42;
        r10.append(Arrays.toString((Parcelable[]) r14));
        goto L45
    L42:
        if ((r14 instanceof Bundle) == false) goto L44;
        r10.append(p((Bundle) r14));
        goto L45
    L44:
        r10.append(r14);
        goto L45
    }

    public static String p(Bundle r5) {
        if (r5 != null) goto L5;
        return "null";
    L5:
        StringBuilder r10 = new StringBuilder(128);
        r10.append("Bundle[{");
        o(r5, r10);
        r10.append("}]");
        return r10.toString();
    }

    public static g q() {
        monitor-enter(g.class);
        Logger.w("SyncMainProcessConfig", "Sync main process config in current process.");     // Catch: Throwable -> L8
        TTNetInit.getTTNetDepend();     // Catch: Throwable -> L8
        TTNetInit.getTTNetDepend();     // Catch: Throwable -> L8
        throw null;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    public static void r(Intent r10, StringBuilder r11) {
        String r5 = r10.getAction();
        boolean r12 = false;
        if (r5 == null) goto L5;
        r11.append("act=");
        r11.append(r5);
        boolean r13 = false;
    L6:
        Set<String> r14 = r10.getCategories();
        if (r14 == null) goto L18;
        if (r13 == true) goto L10;
        r11.append(' ');
    L10:
        r11.append("cat=[");
        Iterator<String> r15 = r14.iterator();
        boolean r16 = true;
    L12:
        if (r15.hasNext() == false) goto L17;
        String r17 = r15.next();
        if (r16 == true) goto L16;
        r11.append(',');
    L16:
        r11.append(r17);
        r16 = false;
        goto L12
    L17:
        r11.append("]");
        r13 = false;
    L18:
        Uri r18 = r10.getData();
        if (r18 == null) goto L36;
        if (r13 == true) goto L22;
        r11.append(' ');
    L22:
        r11.append("dat=");
        Method r19 = Uri.class.getDeclaredMethod("toSafeString", null);     // Catch: IllegalAccessException -> L25 InvocationTargetException -> L27 NoSuchMethodException -> L29
        r19.setAccessible(true);     // Catch: IllegalAccessException -> L25 InvocationTargetException -> L27 NoSuchMethodException -> L29
        String r20 = (String) r19.invoke(r18, null);     // Catch: IllegalAccessException -> L25 InvocationTargetException -> L27 NoSuchMethodException -> L29
    L35:
        r11.append(r20);
        r13 = false;
        goto L36
    L25:
        e = move-exception;
        e.printStackTrace();
    L34:
        r20 = r18.toString();
    L29:
        e = move-exception;
        e.printStackTrace();
    L27:
        e = move-exception;
        e.printStackTrace();
    L36:
        String r21 = r10.getType();
        if (r21 == null) goto L41;
        if (r13 == true) goto L40;
        r11.append(' ');
    L40:
        r11.append("typ=");
        r11.append(r21);
        r13 = false;
    L41:
        int r22 = r10.getFlags();
        if (r22 == 0) goto L46;
        if (r13 == true) goto L45;
        r11.append(' ');
    L45:
        r11.append("flg=0x");
        r11.append(Integer.toHexString(r22));
        r13 = false;
    L46:
        String r23 = r10.getPackage();
        if (r23 == null) goto L51;
        if (r13 == true) goto L50;
        r11.append(' ');
    L50:
        r11.append("pkg=");
        r11.append(r23);
        r13 = false;
    L51:
        ComponentName r24 = r10.getComponent();
        if (r24 == null) goto L56;
        if (r13 == true) goto L55;
        r11.append(' ');
    L55:
        r11.append("cmp=");
        r11.append(r24.flattenToShortString());
        r13 = false;
    L56:
        Rect r25 = r10.getSourceBounds();
        if (r25 == null) goto L62;
        if (r13 == true) goto L60;
        r11.append(' ');
    L60:
        r11.append("bnds=");
        r11.append(r25.toShortString());
        r13 = false;
    L62:
        if (r10.getClipData() == null) goto L66;
        if (r13 == true) goto L65;
        r11.append(' ');
    L65:
        r11.append("(has clip)");
    L67:
        Bundle r26 = r10.getExtras();
        if (r26 == null) goto L72;
        if (r12 == true) goto L71;
        r11.append(' ');
    L71:
        r11.append("extras={");
        o(r26, r11);
        r11.append('}');
    L72:
        Intent r27 = r10.getSelector();
        if (r27 == null) goto L81;
        r11.append(" sel=");
        r(r27, r11);
        r11.append("}");
        return;
    L81:
        return;
    L66:
        r12 = r13;
        goto L67
    L5:
        r13 = true;
        goto L6
    }

    public abstract void m(JSONObject r5);
}
