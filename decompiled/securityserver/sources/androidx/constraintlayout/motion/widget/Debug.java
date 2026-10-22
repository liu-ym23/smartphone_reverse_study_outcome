package androidx.constraintlayout.motion.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.networkstackapplib.NetworkStackConstant;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.CharBuffer;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"LogConditional"})
public class Debug {
    public Debug() {
    }

    public static void dumpLayoutParams(ViewGroup r11, String r12) {
        StackTraceElement r0 = new Throwable().getStackTrace()[1];
        String r1 = ".(" + r0.getFileName() + ":" + r0.getLineNumber() + ") " + r12 + "  ";
        int r2 = r11.getChildCount();
        System.out.println(r12 + " children " + r2);
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L17;
        View r4 = r11.getChildAt(r3);
        PrintStream r5 = System.out;
        StringBuilder r6 = a.a.t(r1, "     ");
        r6.append(getName(r4));
        r5.println(r6.toString());
        ViewGroup.LayoutParams r7 = r4.getLayoutParams();
        Field[] r8 = r7.getClass().getFields();
        int r9 = 0;
    L6:
        if (r9 >= r8.length) goto L16;
        Field r10 = r8[r9];
        Object r13 = r10.get(r7);     // Catch: IllegalAccessException -> L18
        if (r10.getName().contains("To") == false) goto L15;
        if (r13.toString().equals("-1") == true) goto L15;
        System.out.println(r1 + "       " + r10.getName() + " " + r13);     // Catch: IllegalAccessException -> L18
    L15:
        r9 = r9 + 1;
        goto L6
    L16:
        r3 = r3 + 1;
        goto L3
    }

    public static void dumpPoc(Object r11) {
        StackTraceElement r0 = new Throwable().getStackTrace()[1];
        String r1 = ".(" + r0.getFileName() + ":" + r0.getLineNumber() + ")";
        Class<?> r2 = r11.getClass();
        PrintStream r3 = System.out;
        StringBuilder r4 = a.a.t(r1, "------------- ");
        r4.append(r2.getName());
        r4.append(" --------------------");
        r3.println(r4.toString());
        Field[] r5 = r2.getFields();
        int r6 = 0;
    L4:
        if (r6 >= r5.length) goto L31;
        Field r7 = r5[r6];
        Object r8 = r7.get(r11);     // Catch: IllegalAccessException -> L33
        if (r7.getName().startsWith("layout_constraint") == false) goto L30;
        if ((r8 instanceof Integer) == false) goto L15;
        if (r8.toString().equals("-1") == true) goto L30;
    L15:
        if ((r8 instanceof Integer) == false) goto L20;
        if (r8.toString().equals("0") == true) goto L30;
    L20:
        if ((r8 instanceof Float) == false) goto L25;
        if (r8.toString().equals("1.0") == true) goto L30;
    L25:
        if ((r8 instanceof Float) == true) goto L27;
    L29:
        System.out.println(r1 + "    " + r7.getName() + " " + r8);     // Catch: IllegalAccessException -> L33
        goto L30
    L27:
        if (r8.toString().equals("0.5") == false) goto L29;
    L30:
        r6 = r6 + 1;
        goto L4
    L31:
        PrintStream r12 = System.out;
        StringBuilder r9 = a.a.t(r1, "------------- ");
        r9.append(r2.getSimpleName());
        r9.append(" --------------------");
        r12.println(r9.toString());
    }

    public static String getActionType(MotionEvent r5) {
        int r6 = r5.getAction();
        Field[] r0 = MotionEvent.class.getFields();
        int r1 = 0;
    L4:
        if (r1 >= r0.length) goto L15;
        Field r2 = r0[r1];
        if (Modifier.isStatic(r2.getModifiers()) == false) goto L14;
        if (r2.getType().equals(Integer.TYPE) == false) goto L14;
        if (r2.getInt(null) != r6) goto L14;
        return r2.getName();
    L14:
        r1 = r1 + 1;
        goto L4
    L15:
        return "---";
    }

    public static String getCallFrom(int r2) {
        StackTraceElement r3 = new Throwable().getStackTrace()[r2 + 2];
        return ".(" + r3.getFileName() + ":" + r3.getLineNumber() + ")";
    }

    public static String getLoc() {
        StackTraceElement r0 = new Throwable().getStackTrace()[1];
        return ".(" + r0.getFileName() + ":" + r0.getLineNumber() + ") " + r0.getMethodName() + "()";
    }

    public static String getLocation() {
        StackTraceElement r0 = new Throwable().getStackTrace()[1];
        return ".(" + r0.getFileName() + ":" + r0.getLineNumber() + ")";
    }

    public static String getLocation2() {
        StackTraceElement r0 = new Throwable().getStackTrace()[2];
        return ".(" + r0.getFileName() + ":" + r0.getLineNumber() + ")";
    }

    public static String getName(View r1) {
        return r1.getContext().getResources().getResourceEntryName(r1.getId());
    L4:
        return NetworkStackConstant.UNKNOWN_TYPE;
    }

    public static String getState(MotionLayout r1, int r2) {
        return getState(r1, r2, -1);
    }

    public static void logStack(String r6, String r7, int r8) {
        StackTraceElement[] r0 = new Throwable().getStackTrace();
        int r2 = 1;
        int r9 = Math.min(r8, r0.length - 1);
        String r3 = " ";
    L3:
        if (r2 > r9) goto L5;
        StackTraceElement r4 = r0[r2];
        String r5 = ".(" + r0[r2].getFileName() + ":" + r0[r2].getLineNumber() + ") " + r0[r2].getMethodName();
        r3 = a.a.j(r3, " ");
        Log.v(r6, r7 + r3 + r5 + r3);
        r2 = r2 + 1;
        goto L3
    }

    public static void printStack(String r7, int r8) {
        StackTraceElement[] r0 = new Throwable().getStackTrace();
        int r2 = 1;
        int r9 = Math.min(r8, r0.length - 1);
        String r3 = " ";
    L3:
        if (r2 > r9) goto L5;
        StackTraceElement r4 = r0[r2];
        String r5 = ".(" + r0[r2].getFileName() + ":" + r0[r2].getLineNumber() + ") ";
        r3 = a.a.j(r3, " ");
        System.out.println(r7 + r3 + r5 + r3);
        r2 = r2 + 1;
        goto L3
    }

    public static String getState(MotionLayout r2, int r3, int r4) {
        if (r3 != (-1)) goto L6;
        return "UNDEFINED";
    L6:
        String r5 = r2.getContext().getResources().getResourceEntryName(r3);
        if (r4 != (-1)) goto L9;
        return r5;
    L9:
        if (r5.length() <= r4) goto L12;
        r5 = r5.replaceAll("([^_])[aeiou]+", "$1");
    L12:
        if (r5.length() <= r4) goto L18;
        int r6 = r5.replaceAll("[^_]", "").length();
        if (r6 > 0) goto L16;
        return r5;
    L16:
        return r5.replaceAll(CharBuffer.allocate((r5.length() - r4) / r6).toString().replace(0, '.') + "_", "_");
    L18:
        return r5;
    }

    public static String getName(Context r1, int r2) {
        if (r2 != (-1)) goto L10;
        return NetworkStackConstant.UNKNOWN_TYPE;
    L10:
        return r1.getResources().getResourceEntryName(r2);
    L9:
        return a.a.e(r2, "?");
    }

    public static String getName(Context r5, int[] r6) {
        String r0 = r6.length + "[";     // Catch: Exception -> L9
        int r1 = 0;
    L4:
        if (r1 >= r6.length) goto L17;
        StringBuilder r2 = new StringBuilder();     // Catch: Exception -> L9
        r2.append(r0);     // Catch: Exception -> L9
        if (r1 != 0) goto L11;
        String r3 = "";
    L12:
        r2.append(r3);     // Catch: Exception -> L9
        String r4 = r2.toString();     // Catch: Exception -> L9
        String r7 = r5.getResources().getResourceEntryName(r6[r1]);     // Catch: Exception -> L9 Resources.NotFoundException -> L15
    L16:
        r0 = r4 + r7;     // Catch: Exception -> L9
        r1 = r1 + 1;     // Catch: Exception -> L9
    L15:
        r7 = "? " + r6[r1] + " ";     // Catch: Exception -> L9
        goto L16
    L11:
        r3 = " ";
        goto L12
    L17:
        return r0 + "]";
    L9:
        e = move-exception;
        Log.v("DEBUG", e.toString());
        return NetworkStackConstant.UNKNOWN_TYPE;
    }

    public static void dumpLayoutParams(ViewGroup.LayoutParams r7, String r8) {
        StackTraceElement r0 = new Throwable().getStackTrace()[1];
        String r1 = ".(" + r0.getFileName() + ":" + r0.getLineNumber() + ") " + r8 + "  ";
        PrintStream r2 = System.out;
        StringBuilder r9 = a.a.u(" >>>>>>>>>>>>>>>>>>. dump ", r1, "  ");
        r9.append(r7.getClass().getName());
        r2.println(r9.toString());
        Field[] r10 = r7.getClass().getFields();
        int r3 = 0;
    L4:
        if (r3 >= r10.length) goto L14;
        Field r4 = r10[r3];
        Object r5 = r4.get(r7);     // Catch: IllegalAccessException -> L16
        String r6 = r4.getName();     // Catch: IllegalAccessException -> L16
        if (r6.contains("To") == false) goto L13;
        if (r5.toString().equals("-1") == true) goto L13;
        System.out.println(r1 + "       " + r6 + " " + r5);     // Catch: IllegalAccessException -> L16
    L13:
        r3 = r3 + 1;
        goto L4
    L14:
        System.out.println(" <<<<<<<<<<<<<<<<< dump " + r1);
    }
}
