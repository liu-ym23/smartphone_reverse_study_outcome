package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.networkstackapplib.NetworkStackConstant;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.CharBuffer;

/* JADX INFO: loaded from: classes.dex */
public class Debug {
    public Debug() {
    }

    public static void logStack(String tag, String msg, int n) {
        StackTraceElement[] r0 = new Throwable().getStackTrace();
        int r2 = 1;
        int r8 = Math.min(n, r0.length - 1);
        String r3 = " ";
    L3:
        if (r2 > r8) goto L5;
        StackTraceElement r4 = r0[r2];
        r3 = r3 + " ";
        Log.v(tag, msg + r3 + (".(" + r0[r2].getFileName() + ":" + r0[r2].getLineNumber() + ") " + r0[r2].getMethodName()) + r3);
        r2 = r2 + 1;
        goto L3
    }

    public static void printStack(String msg, int n) {
        StackTraceElement[] r0 = new Throwable().getStackTrace();
        int r2 = 1;
        int r8 = Math.min(n, r0.length - 1);
        String r3 = " ";
    L3:
        if (r2 > r8) goto L5;
        StackTraceElement r4 = r0[r2];
        r3 = r3 + " ";
        System.out.println(msg + r3 + (".(" + r0[r2].getFileName() + ":" + r0[r2].getLineNumber() + ") ") + r3);
        r2 = r2 + 1;
        goto L3
    }

    public static String getName(View view) {
        return view.getContext().getResources().getResourceEntryName(view.getId());
    L4:
        return NetworkStackConstant.UNKNOWN_TYPE;
    }

    public static void dumpPoc(Object obj) {
        StackTraceElement r0 = new Throwable().getStackTrace()[1];
        String r1 = ".(" + r0.getFileName() + ":" + r0.getLineNumber() + ")";
        Class<?> r2 = obj.getClass();
        System.out.println(r1 + "------------- " + r2.getName() + " --------------------");
        Field[] r3 = r2.getFields();
        int r4 = 0;
    L4:
        if (r4 >= r3.length) goto L31;
        Field r6 = r3[r4];
        Object r7 = r6.get(obj);     // Catch: IllegalAccessException -> L33
        if (r6.getName().startsWith("layout_constraint") == false) goto L30;
        if ((r7 instanceof Integer) == false) goto L15;
        if (r7.toString().equals("-1") == true) goto L30;
    L15:
        if ((r7 instanceof Integer) == false) goto L20;
        if (r7.toString().equals("0") == true) goto L30;
    L20:
        if ((r7 instanceof Float) == false) goto L25;
        if (r7.toString().equals("1.0") == true) goto L30;
    L25:
        if ((r7 instanceof Float) == true) goto L27;
    L29:
        System.out.println(r1 + "    " + r6.getName() + " " + r7);     // Catch: IllegalAccessException -> L33
        goto L30
    L27:
        if (r7.toString().equals("0.5") == false) goto L29;
    L30:
        r4 = r4 + 1;
        goto L4
    L31:
        System.out.println(r1 + "------------- " + r2.getSimpleName() + " --------------------");
    }

    public static String getName(Context context, int id) {
        if (id != (-1)) goto L10;
        return NetworkStackConstant.UNKNOWN_TYPE;
    L10:
        return context.getResources().getResourceEntryName(id);
    L9:
        return "?" + id;
    }

    public static String getName(Context context, int[] id) {
        String r0 = id.length + "[";     // Catch: Exception -> L17
        int r1 = 0;
    L4:
        if (r1 >= id.length) goto L15;
        StringBuilder r2 = new StringBuilder().append(r0);     // Catch: Exception -> L17
        if (r1 != 0) goto L9;
        String r3 = "";
    L10:
        String r4 = r2.append(r3).toString();     // Catch: Exception -> L17
        String r5 = context.getResources().getResourceEntryName(id[r1]);     // Catch: Resources.NotFoundException -> L13 Exception -> L17
    L14:
        r0 = r4 + r5;     // Catch: Exception -> L17
        r1 = r1 + 1;     // Catch: Exception -> L17
    L13:
        r5 = "? " + id[r1] + " ";     // Catch: Exception -> L17
        goto L14
    L9:
        r3 = " ";
        goto L10
    L15:
        return r0 + "]";
    L17:
        e = move-exception;
        Log.v("DEBUG", e.toString());
        return NetworkStackConstant.UNKNOWN_TYPE;
    }

    public static String getState(MotionLayout layout, int stateId) {
        return getState(layout, stateId, -1);
    }

    public static String getState(MotionLayout layout, int stateId, int len) {
        if (stateId != (-1)) goto L6;
        return "UNDEFINED";
    L6:
        String r2 = layout.getContext().getResources().getResourceEntryName(stateId);
        if (len != (-1)) goto L9;
        return r2;
    L9:
        if (r2.length() <= len) goto L12;
        r2 = r2.replaceAll("([^_])[aeiou]+", "$1");
    L12:
        if (r2.length() <= len) goto L18;
        int r3 = r2.replaceAll("[^_]", "").length();
        if (r3 > 0) goto L16;
        return r2;
    L16:
        return r2.replaceAll(CharBuffer.allocate((r2.length() - len) / r3).toString().replace(0, '.') + "_", "_");
    L18:
        return r2;
    }

    public static String getActionType(MotionEvent event) {
        int r5 = event.getAction();
        Field[] r0 = MotionEvent.class.getFields();
        int r1 = 0;
    L4:
        if (r1 >= r0.length) goto L15;
        Field r2 = r0[r1];
        if (Modifier.isStatic(r2.getModifiers()) == false) goto L14;
        if (r2.getType().equals(Integer.TYPE) == false) goto L14;
        if (r2.getInt(null) != r5) goto L14;
        return r2.getName();
    L14:
        r1 = r1 + 1;
        goto L4
    L15:
        return "---";
    }

    public static String getLocation() {
        StackTraceElement r0 = new Throwable().getStackTrace()[1];
        return ".(" + r0.getFileName() + ":" + r0.getLineNumber() + ")";
    }

    public static String getLoc() {
        StackTraceElement r0 = new Throwable().getStackTrace()[1];
        return ".(" + r0.getFileName() + ":" + r0.getLineNumber() + ") " + r0.getMethodName() + "()";
    }

    public static String getLocation2() {
        StackTraceElement r0 = new Throwable().getStackTrace()[2];
        return ".(" + r0.getFileName() + ":" + r0.getLineNumber() + ")";
    }

    public static String getCallFrom(int n) {
        StackTraceElement r2 = new Throwable().getStackTrace()[n + 2];
        return ".(" + r2.getFileName() + ":" + r2.getLineNumber() + ")";
    }

    public static void dumpLayoutParams(ViewGroup layout, String str) {
        StackTraceElement r0 = new Throwable().getStackTrace()[1];
        String r1 = ".(" + r0.getFileName() + ":" + r0.getLineNumber() + ") " + str + "  ";
        int r2 = layout.getChildCount();
        System.out.println(str + " children " + r2);
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L17;
        View r4 = layout.getChildAt(r3);
        System.out.println(r1 + "     " + getName(r4));
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        Field[] r6 = r5.getClass().getFields();
        int r7 = 0;
    L6:
        if (r7 >= r6.length) goto L16;
        Field r8 = r6[r7];
        Object r9 = r8.get(r5);     // Catch: IllegalAccessException -> L18
        if (r8.getName().contains("To") == false) goto L15;
        if (r9.toString().equals("-1") == true) goto L15;
        System.out.println(r1 + "       " + r8.getName() + " " + r9);     // Catch: IllegalAccessException -> L18
    L15:
        r7 = r7 + 1;
        goto L6
    L16:
        r3 = r3 + 1;
        goto L3
    }

    public static void dumpLayoutParams(ViewGroup.LayoutParams param, String str) {
        StackTraceElement r0 = new Throwable().getStackTrace()[1];
        String r8 = ".(" + r0.getFileName() + ":" + r0.getLineNumber() + ") " + str + "  ";
        System.out.println(" >>>>>>>>>>>>>>>>>>. dump " + r8 + "  " + param.getClass().getName());
        Field[] r1 = param.getClass().getFields();
        int r2 = 0;
    L4:
        if (r2 >= r1.length) goto L14;
        Field r3 = r1[r2];
        Object r4 = r3.get(param);     // Catch: IllegalAccessException -> L16
        String r5 = r3.getName();     // Catch: IllegalAccessException -> L16
        if (r5.contains("To") == false) goto L13;
        if (r4.toString().equals("-1") == true) goto L13;
        System.out.println(r8 + "       " + r5 + " " + r4);     // Catch: IllegalAccessException -> L16
    L13:
        r2 = r2 + 1;
        goto L4
    L14:
        System.out.println(" <<<<<<<<<<<<<<<<< dump " + r8);
    }
}
