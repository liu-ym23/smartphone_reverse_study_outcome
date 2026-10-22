package ym;

import ai.j0;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Debug;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.ws.RealWebSocket;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f23304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Class f23305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Field f23306c;
    public static Field d;
    public static boolean e;

    public static long a(int r5) {
        if (r5 >= 0) goto L6;
        return 0;
    L6:
        return ((long) r5) * RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE;
    }

    public static com.bytedance.ies.bullet.service.monitor.i b() {
        return (com.bytedance.ies.bullet.service.monitor.i) com.bytedance.ies.bullet.service.monitor.i.d.getValue();
    }

    public static Class c(Context r5) {
        if (f23305b != null) goto L9;
        if (e == true) goto L9;
        f23305b = Class.forName(r5.getPackageName() + ".BuildConfig");     // Catch: ClassNotFoundException -> L10
    L7:
        e = true;
    L9:
        return f23305b;
    }

    public static Object d(Object r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "input");
        if (StringsKt.P(r11, "$") == false) goto L5;
        r11 = r11.substring(2);
    L5:
        int r5 = StringsKt.r(".", 0, 6, r11);
        if (r5 != (-1)) goto L8;
        String r12 = "";
    L10:
        int r13 = r5 + 1;
        if (r11 == null) goto L57;
        String r14 = r11.substring(r13);
        if ((r10 instanceof Map) == false) goto L26;
        if (r12.length() == 0) goto L17;
        Map r15 = (Map) r10;
        if (r15.containsKey(r12) == false) goto L26;
        Object r16 = r15.get(r12);
        if (r16 != null) goto L23;
        return null;
    L23:
        return d(r16, r14);
    L17:
        return ((Map) r10).get(r11);
    L26:
        if ((r10 instanceof String) == false) goto L37;
        if (Intrinsics.areEqual(r11, "length") == true) goto L30;
        int r17 = Integer.parseInt(r11);
        String r18 = (String) r10;
        if (r17 < r18.length()) goto L34;
        return null;
    L34:
        return String.valueOf(r18.charAt(r17));
    L30:
        return Integer.valueOf(((String) r10).length());
    L37:
        if ((r10 instanceof List) == true) goto L39;
    L55:
        return null;
    L39:
        if (Intrinsics.areEqual(r11, "length") == true) goto L41;
        if (r5 >= 0) goto L48;
        List r19 = (List) r10;
        int r20 = Integer.parseInt(r11);
        if (r20 < r19.size()) goto L46;
        return null;
    L46:
        return r19.get(r20);
    L48:
        List r21 = (List) r10;
        int r22 = Integer.parseInt(r12);
        if (r22 >= r21.size()) goto L51;
        Object r23 = r21.get(r22);
    L52:
        if (r23 == null) goto L55;
        return d(r23, r11.substring(r13));
    L51:
        r23 = null;
        goto L52
    L41:
        return Integer.valueOf(((List) r10).size());
    L57:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L8:
        if (r11 == null) goto L59;
        r12 = r11.substring(0, r5);
        goto L10
    L59:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public static String e(ActivityManager.ProcessErrorStateInfo r5) {
        StringBuilder r10 = new StringBuilder("|------------- processErrorStateInfo--------------|\ncondition: ");
        r10.append(r5.condition);
        r10.append("\nprocessName: ");
        r10.append(r5.processName);
        r10.append("\npid: ");
        r10.append(r5.pid);
        r10.append("\nuid: ");
        r10.append(r5.uid);
        r10.append("\ntag: ");
        r10.append(r5.tag);
        r10.append("\nshortMsg : ");
        r10.append(r5.shortMsg);
        r10.append("\nlongMsg : ");
        return j0.q(r10, r5.longMsg, "\n-----------------------end----------------------------");
    }

    public static final String f(Uri r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);
        if (r5.isHierarchical() == true) goto L6;
        r5 = null;
    L6:
        if (r5 != null) goto L8;
        return null;
    L8:
        return r5.getQueryParameter(r10);
    }

    public static void g(Context r5, JSONObject r10) {
        h(r10);     // Catch: Throwable -> L7
        ActivityManager r11 = (ActivityManager) r5.getSystemService("activity");     // Catch: Throwable -> L7
        if (r11 == null) goto L5;
        p(r10, r11);     // Catch: Throwable -> L7
    L5:
        i(r10, r11);     // Catch: Throwable -> L7
        return;
    }

    public static void h(JSONObject r10) {
        Debug.MemoryInfo r5 = new Debug.MemoryInfo();
        Debug.getMemoryInfo(r5);
        JSONObject r11 = new JSONObject();
        r11.put("dalvikPrivateDirty", a(r5.dalvikPrivateDirty));
        r11.put("dalvikPss", a(r5.dalvikPss));
        r11.put("dalvikSharedDirty", a(r5.dalvikSharedDirty));
        r11.put("nativePrivateDirty", a(r5.nativePrivateDirty));
        r11.put("nativePss", a(r5.nativePss));
        r11.put("nativeSharedDirty", a(r5.nativeSharedDirty));
        r11.put("otherPrivateDirty", a(r5.otherPrivateDirty));
        r11.put("otherPss", a(r5.otherPss));
        r11.put("otherSharedDirty", r5.otherSharedDirty);
        String r12 = r5.getMemoryStat("summary.graphics");     // Catch: Throwable -> L8
        if (TextUtils.isEmpty(r12) == true) goto L6;
        r11.put("summary.graphics", a(Integer.parseInt(r12)));     // Catch: Throwable -> L8
    L6:
        r11.put("totalPrivateClean", r5.getTotalPrivateClean());
        r11.put("totalPrivateDirty", r5.getTotalPrivateDirty());
        r11.put("totalPss", a(r5.getTotalPss()));
        r11.put("totalSharedClean", r5.getTotalSharedClean());
        r11.put("totalSharedDirty", a(r5.getTotalSharedDirty()));
        r11.put("totalSwappablePss", a(r5.getTotalSwappablePss()));
        r10.put("memory_info", r11);
    }

    public static void i(JSONObject r13, ActivityManager r14) {
        JSONObject r5 = new JSONObject();
        long r10 = Debug.getNativeHeapAllocatedSize() / 1048576;
        boolean r11 = false;
        if (r10 <= 200) goto L5;
        boolean r12 = true;
    L6:
        z8.c.l(r13, "filters", "native_heap_leak", String.valueOf(r12));
        if (r10 <= 300) goto L9;
        boolean r15 = true;
    L10:
        z8.c.l(r13, "filters", "native_heap_leak_300M", String.valueOf(r15));
        if (r10 <= 500) goto L13;
        boolean r16 = true;
    L14:
        z8.c.l(r13, "filters", "native_heap_leak_500M", String.valueOf(r16));
        if (r10 <= 800) goto L17;
        boolean r17 = true;
    L18:
        z8.c.l(r13, "filters", "native_heap_leak_800M", String.valueOf(r17));
        r5.put("native_heap_size", Debug.getNativeHeapSize());
        r5.put("native_heap_alloc_size", Debug.getNativeHeapAllocatedSize());
        r5.put("native_heap_free_size", Debug.getNativeHeapFreeSize());
        Runtime r18 = Runtime.getRuntime();
        long r19 = r18.maxMemory();
        long r20 = r18.freeMemory();
        long r21 = r18.totalMemory();
        r5.put("max_memory", r19);
        r5.put("free_memory", r20);
        r5.put("total_memory", r21);
        float r22 = r21 - r20;
        float r23 = r19;
        float r24 = 0.95f * r23;
        if (r22 <= r24) goto L22;
        String r25 = ">95%";
    L34:
        if (r22 <= r24) goto L36;
        r11 = true;
    L36:
        z8.c.l(r13, "filters", "java_heap_leak", String.valueOf(r11));
        z8.c.l(r13, "filters", "java_heap_usage", r25);
        if (r14 == null) goto L39;
        r5.put("memory_class", r14.getMemoryClass());
        r5.put("large_memory_class", r14.getLargeMemoryClass());
    L39:
        r13.put("app_memory_info", r5);
        return;
    L22:
        if (r22 <= (0.85f * r23)) goto L25;
        r25 = "(85%-95%]";
        goto L34
    L25:
        if (r22 <= (0.75f * r23)) goto L28;
        r25 = "(75%-85%]";
        goto L34
    L28:
        if (r22 <= (0.65f * r23)) goto L31;
        r25 = "(65%-75%]";
        goto L34
    L31:
        if (r22 <= (r23 * 0.5f)) goto L33;
        r25 = "(50%-65%]";
        goto L34
    L33:
        r25 = "<=50%";
        goto L34
    L17:
        r17 = false;
        goto L18
    L13:
        r16 = false;
        goto L14
    L9:
        r15 = false;
        goto L10
    L5:
        r12 = false;
        goto L6
    }

    public static boolean j(ActivityManager.ProcessErrorStateInfo r5, ActivityManager.ProcessErrorStateInfo r10) {
        if (String.valueOf(r5.condition).equals(String.valueOf(r10.condition)) == true) goto L5;
        return false;
    L5:
        if (String.valueOf(r5.processName).equals(String.valueOf(r10.processName)) == true) goto L7;
        return false;
    L7:
        if (String.valueOf(r5.pid).equals(String.valueOf(r10.pid)) == true) goto L9;
        return false;
    L9:
        if (String.valueOf(r5.uid).equals(String.valueOf(r10.uid)) == true) goto L11;
        return false;
    L11:
        if (String.valueOf(r5.tag).equals(String.valueOf(r10.tag)) == true) goto L13;
        return false;
    L13:
        if (String.valueOf(r5.shortMsg).equals(String.valueOf(r10.shortMsg)) == true) goto L15;
        return false;
    L15:
        if (String.valueOf(r5.longMsg).equals(String.valueOf(r10.longMsg)) == false) goto L25;
        return true;
    L25:
        return false;
    }

    public static boolean k(Context r5, String r10) {
        if (r10 != null) goto L5;
    L7:
        if (r10 != null) goto L9;
        return false;
    L9:
        if (r10.equals(r5.getApplicationInfo().processName) == false) goto L13;
        return true;
    L13:
        return false;
    L5:
        if (r10.equals(r5.getPackageName()) == false) goto L7;
        return true;
    }

    public static final boolean l(Object r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r5, 0) == false) goto L8;
    L20:
        return false;
    L8:
        if (Intrinsics.areEqual(r5, "") == true) goto L20;
        if ((r5 instanceof Number) == false) goto L13;
    L19:
        return true;
    L13:
        if ((r5 instanceof String) == true) goto L19;
        if ((r5 instanceof Boolean) == false) goto L19;
        return ((Boolean) r5).booleanValue();
    }

    public static final void m(AppCompatCheckedTextView r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "textView");
        Typeface r11 = r5.getTypeface();
        if (r11 != null) goto L5;
        r11 = Typeface.DEFAULT;
    L5:
        boolean r12 = false;
        if (r11 != null) goto L9;
    L11:
        r5.setTypeface(Typeface.create(r11, r10, r12));
        return;
    L9:
        if (r11.isItalic() != true) goto L11;
        r12 = true;
        goto L11
    }

    public static final Uri n(Uri r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "queryParameterName");
        if (r5.isHierarchical() == true) goto L5;
        return r5;
    L5:
        Uri.Builder r11 = r5.buildUpon().clearQuery();
        Iterator<String> r12 = r5.getQueryParameterNames().iterator();
    L7:
        if (r12.hasNext() == false) goto L15;
        String r13 = r12.next();
        if (Intrinsics.areEqual(r13, r10) == true) goto L7;
        Iterator<String> r14 = r5.getQueryParameters(r13).iterator();
    L12:
        if (r14.hasNext() == false) goto L7;
        r11.appendQueryParameter(r13, r14.next());
        goto L12
    L15:
        return r11.build();
    }

    public static String o(Context r5) {
        if (TextUtils.isEmpty(f23304a) == false) goto L5;
        int r10 = Process.myPid();     // Catch: Throwable -> L29
        ActivityManager r11 = (ActivityManager) r5.getSystemService("activity");     // Catch: Throwable -> L29
        if (r11 == null) goto L15;
        Iterator<ActivityManager.RunningAppProcessInfo> r12 = r11.getRunningAppProcesses().iterator();     // Catch: Throwable -> L29
    L10:
        if (r12.hasNext() == false) goto L15;
        ActivityManager.RunningAppProcessInfo r13 = r12.next();     // Catch: Throwable -> L29
        if (r13.pid != r10) goto L10;
        String r14 = r13.processName;     // Catch: Throwable -> L29
        f23304a = r14;     // Catch: Throwable -> L29
        return r14;
    L15:
        String r15 = null;
        BufferedReader r16 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L23
        StringBuilder r17 = new StringBuilder();     // Catch: Throwable -> L30
    L18:
        int r18 = r16.read();     // Catch: Throwable -> L30
        if (r18 <= 0) goto L21;
        r17.append((char) r18);     // Catch: Throwable -> L30
        goto L18
    L21:
        r15 = r17.toString();     // Catch: Throwable -> L30
    L22:
        com.bytedance.android.anniex.base.service.f.h(r16);
        f23304a = r15;
        if (r15 != null) goto L28;
        return "";
    L28:
        return r15;
    L23:
        r16 = null;
        goto L22
    L5:
        return f23304a;
    }

    public static void p(JSONObject r10, ActivityManager r11) {
        JSONObject r5 = new JSONObject();
        ActivityManager.MemoryInfo r12 = new ActivityManager.MemoryInfo();
        r11.getMemoryInfo(r12);
        r5.put("availMemUnit", ((r12.availMem / 512) / RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE) / RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE);
        r5.put("lowMemory", r12.lowMemory);
        r5.put("threshold", r12.threshold);
        r5.put("totalMemUnit", ((r12.totalMem / 512) / RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE) / RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE);
        r10.put("sys_memory_info", r5);
    }

    public static boolean q(Context r5) {
        String r10 = o(r5);
        if (r10 == null) goto L8;
        if (r10.contains(":") == false) goto L8;
        return false;
    L8:
        if (r10 != null) goto L10;
    L12:
        if (r10 != null) goto L14;
    L16:
        return false;
    L14:
        if (r10.equals(r5.getApplicationInfo().processName) == false) goto L16;
        return true;
    L10:
        if (r10.equals(r5.getPackageName()) == false) goto L12;
        return true;
    }

    public static final void r(int r5, View r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        ViewGroup.LayoutParams r12 = null;
        if ((r11 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r11;
    L6:
        if (r13 == null) goto L9;
        r13.setMarginStart(r5);
        r13.setMarginEnd(r5);
        r10.requestLayout();
        r12 = r13;
    L9:
        r10.setLayoutParams(r12);
        return;
    L5:
        r13 = null;
        goto L6
    }

    public static final void s(int r5, View r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.getLayoutParams().width = r5;
        r10.requestLayout();
    }
}
