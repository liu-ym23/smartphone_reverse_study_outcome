package a;

import android.content.res.Resources;
import android.util.Log;
import android.util.TypedValue;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.common.utility.Logger;
import com.bytedance.privacy.utils.LogUtils;
import java.util.HashMap;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static String A(String r1, String r2) {
        return r1 + r2;
    }

    public static String B(String r1, String r2, String r3) {
        return r1 + r2 + r3;
    }

    public static void C(Exception r0, StringBuilder r1, String r2) {
        r1.append(r0.getMessage());
        Log.e(r2, r1.toString());
    }

    public static float a(float r0, float r1, float r2, float r3) {
        return ((r0 - r1) * r2) + r3;
    }

    public static int b(float r0, int r1, int r2) {
        return (Float.hashCode(r0) + r1) * r2;
    }

    public static int c(int r0, int r1, int r2) {
        return (Integer.hashCode(r0) + r1) * r2;
    }

    public static int d(String r1, int r2, float r3) {
        Resources r0 = Resources.getSystem();
        Intrinsics.e(r0, r1);
        return MathKt.a(TypedValue.applyDimension(r2, r3, r0.getDisplayMetrics()));
    }

    public static String e(int r1, String r2) {
        return r2 + r1;
    }

    public static String f(int r1, String r2, String r3) {
        return r2 + r1 + r3;
    }

    public static String g(RecyclerView r0, StringBuilder r1) {
        r1.append(r0.exceptionLabel());
        return r1.toString();
    }

    public static String h(String r1, long r2) {
        return r1 + r2;
    }

    public static String i(String r1, Fragment r2, String r3) {
        return r1 + r2 + r3;
    }

    public static String j(String r1, String r2) {
        return r1 + r2;
    }

    public static String k(String r1, String r2, String r3) {
        return r1 + r2 + r3;
    }

    public static String l(StringBuilder r0, int r1, char r2) {
        r0.append(r1);
        r0.append(r2);
        return r0.toString();
    }

    public static String m(StringBuilder r0, int r1, int r2, String r3, char r4) {
        StringBuilder r5 = r0.replace(r1, r2, r3);
        r5.append(r4);
        return r5.toString();
    }

    public static String n(StringBuilder r0, String r1, int r2) {
        r0.append(r2);
        r0.append(r1);
        return r0.toString();
    }

    public static String o(StringBuilder r0, String r1, String r2) {
        r0.append(r1);
        r0.append(r2);
        return r0.toString();
    }

    public static StringBuilder p(int r1, String r2, String r3) {
        StringBuilder r0 = new StringBuilder(r2);
        r0.append(r1);
        r0.append(r3);
        return r0;
    }

    public static StringBuilder q(String r1) {
        StringBuilder r0 = new StringBuilder();
        r0.append(r1);
        return r0;
    }

    public static StringBuilder r(String r1, int r2, String r3, int r4, String r5) {
        StringBuilder r0 = new StringBuilder(r1);
        r0.append(r2);
        r0.append(r3);
        r0.append(r4);
        r0.append(r5);
        return r0;
    }

    public static StringBuilder s(String r1, long r2, String r4) {
        StringBuilder r0 = new StringBuilder(r1);
        r0.append(r2);
        r0.append(r4);
        return r0;
    }

    public static StringBuilder t(String r1, String r2) {
        StringBuilder r0 = new StringBuilder();
        r0.append(r1);
        r0.append(r2);
        return r0;
    }

    public static StringBuilder u(String r1, String r2, String r3) {
        StringBuilder r0 = new StringBuilder(r1);
        r0.append(r2);
        r0.append(r3);
        return r0;
    }

    public static void v(int r0, HashMap r1, String r2, int r3, String r4) {
        r1.put(r2, Integer.valueOf(r0));
        r1.put(r4, Integer.valueOf(r3));
    }

    public static void w(Exception r0, StringBuilder r1, String r2) {
        r1.append(r0.getMessage());
        LogUtils.b(r2, r1.toString());
    }

    public static void x(String r1, Fragment r2, String r3) {
        Log.v(r3, r1 + r2);
    }

    public static void y(String r1, String r2, String r3) {
        Logger.d(r3, r1 + r2);
    }

    public static boolean z(String r1, String r2) {
        return r1.toLowerCase(Locale.getDefault()).contains(r2);
    }
}
