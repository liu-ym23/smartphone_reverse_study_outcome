package w8;

import ai.g0;
import ai.j0;
import android.content.Context;
import android.os.Debug;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.room.writer.DaoWriter;
import av.i;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.AppDataCenter;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.ICrashCallback;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.n;
import com.bytedance.crash.p;
import com.bytedance.crash.runtime.ConfigManager;
import com.bytedance.crash.upload.s;
import com.bytedance.crash.upload.t;
import com.bytedance.crash.util.ListMap;
import com.bytedance.crash.util.NativeTools;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import l9.l;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ym.m;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static File f22803a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static File f22804b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f22805c = false;
    public static volatile boolean d = false;
    public static final LinkedBlockingQueue e = null;
    public static volatile boolean f;
    public static volatile boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final long f22806h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static long f22807i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static File f22808j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static File f22809k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static z8.c f22810l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static long f22811m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final boolean f22812n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final so.e f22813o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Object f22814p = null;

    static {
        e = new LinkedBlockingQueue();
        f = false;
        g = false;
        f22806h = -1;
        f22807i = -1;
        f22808j = null;
        f22810l = null;
        f22811m = -1;
        f22812n = false;
        f22813o = new so.e(7);
    }

    public static String a(z8.c r11, JSONObject r12) {
        JSONObject r5 = r11.f23416a;
        if (k(r5) == true) goto L56;
    L6:
        String r10 = "";
    L7:
        if (r12 == null) goto L9;
        String r13 = r12.optString("mainStackFromTrace", "");
    L10:
        boolean r14 = true;
        if (r10 == "") goto L50;
        if (r13 == "") goto L50;
        int r15 = com.bytedance.crash.util.h.f4186a;
        if (r13 != "") goto L17;
        if (r10 == "") goto L50;
    L17:
        String[] r16 = null;
        if (r13 == "") goto L20;
        String[] r17 = r13.split("\n");
    L21:
        if (r10 == "") goto L24;
        r16 = r10.split("\n");
    L24:
        if (r16 == null) goto L49;
        if (r17 == null) goto L49;
        int r18 = 0;
    L28:
        if (r18 >= r17.length) goto L35;
        if (r17[r18].startsWith("  at ") == true) goto L31;
        r18 = r18 + 1;
        goto L28
    L31:
        String r19 = r17[r18];
        if (r19.contains("(") == false) goto L36;
        r19 = r19.split("\\(")[0];
    L36:
        int r20 = 0;
    L38:
        if (r20 >= r16.length) goto L45;
        if (r16[r20].startsWith("  at ") == true) goto L41;
        r20 = r20 + 1;
        goto L38
    L41:
        String r21 = r16[r20];
        if (r21.contains("(") == false) goto L47;
        r21 = r21.split("\\(")[0];
    L47:
        if (r19.equals(r21) == false) goto L49;
    L45:
        r21 = "";
        goto L47
    L35:
        r19 = "";
    L49:
        h(r11, j0.q(new StringBuilder(), b.f22765p, r10), r13, "JavaStack", false, true);
        r14 = false;
        goto L50
    L20:
        r17 = null;
    L50:
        if (r13 == "") goto L53;
        h(r11, r13, "", "NativeStack", true, r14);
        return r13;
    L53:
        z8.c.l(r11.b(), "filters", "anr_replace_mainstack", "OnlyJavaStack");
        return r10;
    L9:
        r13 = "";
        goto L10
    L56:
        r10 = new JSONObject(r5.optString("data")).optString("mainStackFromTrace", "");     // Catch: JSONException -> L55
        goto L7
    }

    public static JSONObject b(String r5, JSONObject r10, boolean r11) {
        String r12 = "at InvalidStack.NoStackAvailable(Invalid.java:1).\n";
        if (r10 != null) goto L15;
        r10 = new JSONObject();
        r10.put("thread_number", 1);     // Catch: JSONException -> L28
        if (TextUtils.isEmpty(r5) == true) goto L9;
        r12 = r5;
    L9:
        r10.put("mainStackFromTrace", r12);     // Catch: JSONException -> L28
    L11:
        if (TextUtils.isEmpty(r5) == true) goto L22;
    L13:
        boolean r13 = false;
    L30:
        r10.put(LynxMonitorService.KEY_PID, Process.myPid());     // Catch: JSONException -> L29
        r10.put("package", n.f4057a.getPackageName());     // Catch: JSONException -> L29
        r10.put("is_remote_process", 0);     // Catch: JSONException -> L29
        r10.put("is_new_stack", 10);     // Catch: JSONException -> L29
        if (r11 == true) goto L26;
        r10.put("not_current", 1);     // Catch: JSONException -> L29
    L26:
        r10.put("invalid", r13);     // Catch: JSONException -> L29
    L27:
        return r10;
    L22:
        r13 = true;
        goto L30
    L15:
        if (TextUtils.isEmpty(r10.optString("mainStackFromTrace")) == false) goto L13;
        if (TextUtils.isEmpty(r5) == true) goto L20;
        r12 = r5;
    L20:
        mh.e.g(r12, "mainStackFromTrace", r10);
        if (TextUtils.isEmpty(r5) == false) goto L13;
        goto L13
    }

    public static void c(int r5, JSONObject r10, File r11, File r12) {
        if (f22805c == true) goto L5;
    L29:
        r10.optLong("crash_time");     // Catch: Throwable -> L11
        r10.optLong("app_start_time");     // Catch: Throwable -> L11
        r10.optString("process_name");     // Catch: Throwable -> L11
        r10.optString("data");     // Catch: Throwable -> L11
        r10.optString("crash_uuid");     // Catch: Throwable -> L11
        if (n.f4062j.isEngMode() == false) goto L13;
        ArrayList r13 = new ArrayList();     // Catch: Throwable -> L11
        r13.add(r11.getAbsolutePath());     // Catch: Throwable -> L11
        r13.add(com.bytedance.crash.util.g.f(n.f4057a).getAbsolutePath());     // Catch: Throwable -> L11
        r13.add(r12.getAbsolutePath());     // Catch: Throwable -> L11
    L13:
        g0 r14 = p.f;     // Catch: Throwable -> L11
        Iterator r15 = ((ListMap) r14.f210b).a(CrashType.ANR).iterator();     // Catch: Throwable -> L11
    L15:
        if (r15.hasNext() == false) goto L16;
        if (r15.next() != null) goto L26;
        io.reactivex.exceptions.a.c("notifyAnrEx: begin, notifyMode = " + r5);     // Catch: Throwable -> L23
        CrashType r16 = CrashType.LAUNCH;     // Catch: Throwable -> L23
        throw null;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        io.reactivex.exceptions.a.f(th);     // Catch: Throwable -> L11
        com.bytedance.crash.c.f4025a.getClass();     // Catch: Throwable -> L11
        m.b.h("NPTH_CATCH", th);     // Catch: Throwable -> L11
        goto L15
    L26:
        throw new ClassCastException();     // Catch: Throwable -> L11
    L16:
        ConfigManager r17 = n.f4062j;     // Catch: Throwable -> L11
        if (r17.isEngMode() == false) goto L35;
        io.reactivex.exceptions.a.c("notifyAnrEx: sleep time = " + r17.getDelayTime());     // Catch: Throwable -> L11
        Thread.sleep(r17.getDelayTime());     // Catch: Throwable -> L11
        io.reactivex.exceptions.a.c("notifyAnrEx: sleep end");     // Catch: Throwable -> L11
        return;
    L35:
        return;
    L11:
        th = move-exception;
        io.reactivex.exceptions.a.f(th);
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
        return;
    L5:
        if (r5 != 1) goto L29;
        io.reactivex.exceptions.a.c("notifyAnrEx: mUploadOnStart == true  && notifyMode == 1 , return");
    }

    public static void d(long r34, long r36, boolean r38) {
        long r10 = System.currentTimeMillis();
        f22811m = r10;
        Context r11 = n.f4057a;
        JSONObject r12 = new JSONObject();
        mh.e.g(a.a.f(), "current_message", r12);
        mh.e.g(a.a.p(), "history_message", r12);
        mh.e.g(a.a.e(SystemClock.uptimeMillis()), "pending_messages", r12);
        long r13 = System.currentTimeMillis();
        String r14 = com.bytedance.crash.util.h.c(Looper.getMainLooper().getThread().getStackTrace());
        long r15 = System.currentTimeMillis();
        String r16 = com.bytedance.crash.util.g.h(n.f4057a);
        StringBuilder r17 = new StringBuilder();
        r17.append(x8.a.f22986i);
        r17.append("/proc/");
        r17.append(Process.myPid());
        r17.append("/trace_");
        File r5 = new File(r16, j0.o(r17, r10, "/"));
        f22803a = r5;
        r5.mkdirs();
        long r18 = System.currentTimeMillis();
        cl.a.q(new File(f22803a, "looper_message.txt"), r12);
        long r19 = System.currentTimeMillis();
        File r20 = new File(f22803a, "main_stack.txt");
        r20.createNewFile();     // Catch: IOException -> L43
    L52:
        cl.a.u(r14, r20, false);     // Catch: Throwable -> L44
    L6:
        long r24 = System.currentTimeMillis();
        File r21 = new File(f22803a, "trace.txt");
        f22804b = r21;
        com.bytedance.android.anniex.base.service.e.l("anr_trace", r21.getAbsolutePath());
        NativeTools r110 = NativeTools.f4167b;
        if (Header.i() == true) goto L9;
        NativeTools.k().i(r21.getAbsolutePath());
    L9:
        long r111 = System.currentTimeMillis();
        com.bytedance.android.anniex.base.service.e.l("after_trace", r21.getAbsolutePath());
        a.a.h(f22803a);
        long r112 = System.currentTimeMillis();
        z8.c r113 = o();     // Catch: Throwable -> L19
        JSONObject r114 = r113.f23416a;
        mh.e.j(r114, r12);     // Catch: Throwable -> L19
        m.g(r11, r114);     // Catch: Throwable -> L19
        mh.e.g(Boolean.valueOf(b.h()), "is_background", r114);     // Catch: Throwable -> L19
        z8.c.l(r113.b(), "custom", "npth_trace_cost", String.valueOf(r111 - r10));     // Catch: Throwable -> L19
        JSONObject r22 = zm.p.g(r14);     // Catch: Throwable -> L19
        b(null, r22, true);     // Catch: Throwable -> L19
        if (r22 != null) goto L15;
    L21:
        mh.e.g(Long.valueOf(r10), "crash_time", r114);     // Catch: Throwable -> L19
        if (r38 == false) goto L24;
        r113.j("anr_sig_time", zm.p.e().format(new Date(r34)));     // Catch: Throwable -> L19
        r113.j("sig_to_begin_dump_cost", String.valueOf(r10 - r34));     // Catch: Throwable -> L19
    L25:
        r113.j("crash_time", zm.p.e().format(new Date(r10)));     // Catch: Throwable -> L19
        r113.j("dump_loop_msg_cost", String.valueOf(r13 - r10));     // Catch: Throwable -> L19
        r113.j("dump_main_stack_cost", String.valueOf(r15 - r13));     // Catch: Throwable -> L19
        r113.j("make_trace_dir_cost", String.valueOf(r18 - r15));     // Catch: Throwable -> L19
        r113.j("write_loop_msg_cost", String.valueOf(r19 - r18));     // Catch: Throwable -> L19
        r113.j("write_main_stack_cost", String.valueOf(r24 - r19));     // Catch: Throwable -> L19
        r113.j("dump_trace_cost", String.valueOf(r111 - r24));     // Catch: Throwable -> L19
        r113.j("dump_native_files_cost", String.valueOf(r112 - r111));     // Catch: Throwable -> L19
        mh.e.g(r22.toString(), "data", r114);     // Catch: Throwable -> L19
        l r23 = l.f();     // Catch: Throwable -> L19
        CrashType r25 = CrashType.ANR;     // Catch: Throwable -> L19
        z8.c r26 = r23.g(r25, r113, null, false);     // Catch: Throwable -> L19
        JSONArray r27 = zm.p.f(f22803a);     // Catch: Throwable -> L19
        JSONObject r28 = r26.f23416a;     // Catch: Throwable -> L19
        mh.e.g(r27, "logcat", r28);     // Catch: Throwable -> L19
        long r29 = f22807i;     // Catch: Throwable -> L19
        if (r29 > 0) goto L29;
        z8.c.l(r26.b(), "custom", "last_anr_interval", "none");     // Catch: Throwable -> L19
    L31:
        mh.e.g(i9.f.h(), "alive_pids", r28);     // Catch: Throwable -> L19
        mh.e.g(n.b(r10, r25, false, false), "crash_uuid", r28);     // Catch: Throwable -> L19
        JSONObject r30 = r28.optJSONObject("filters");     // Catch: Throwable -> L19
        if (r30 != null) goto L50;
        r30 = new JSONObject();     // Catch: Throwable -> L19
        mh.e.g(r30, "filters", r28);     // Catch: Throwable -> L19
    L50:
        r30.put("crash_length", b.b(r10));     // Catch: Throwable -> L45
        r30.put("disable_looper_monitor", String.valueOf(l9.c.b()));     // Catch: Throwable -> L45
        r30.put("is_64_runtime", String.valueOf(NativeTools.k().E()));     // Catch: Throwable -> L45
        if (p.e() == false) goto L37;
        String r31 = "true";
    L38:
        r30.put("crash_after_crash", r31);     // Catch: Throwable -> L45
        r30.put("from_file", String.valueOf(zm.p.f23511i));     // Catch: Throwable -> L45
        r30.put("last_resume_activity", String.valueOf(m9.c.e().f20040k));     // Catch: Throwable -> L45
        r30.put("start_uuid", n.f());     // Catch: Throwable -> L45
        r30.put("has_signal", String.valueOf(r38));     // Catch: Throwable -> L45
        goto L39
    L37:
        r31 = "false";
    L39:
        f22810l = r26;     // Catch: Throwable -> L19
        cl.a.q(new File(f22803a, "origin_json.txt"), r28);     // Catch: Throwable -> L19
        return;
    L29:
        z8.c.l(r26.b(), "custom", "last_anr_interval", String.valueOf(r10 - r29));     // Catch: Throwable -> L19
        goto L31
    L24:
        r113.j("anr_info_time", zm.p.e().format(new Date(r36)));     // Catch: Throwable -> L19
        r113.j("anrinfo_to_begin_dump_cost", String.valueOf(r10 - r36));     // Catch: Throwable -> L19
        goto L25
    L15:
        if (r21.length() >= 500) goto L17;
        JSONObject r32 = r22;
    L18:
        mh.e.g(r32, "all_thread_stacks", r114);     // Catch: Throwable -> L19
        goto L21
    L17:
        r32 = null;
    L19:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
    }

    public static void e(File r19, File r20, String r21) {
        File r5 = new File(r19, String.valueOf(Process.myPid()));
        f22808j = r20;
        if (s.m(null, CrashType.ANR) == false) goto L6;
        cl.a.s(r5.getAbsolutePath());
    L32:
        File r10 = f22804b;     // Catch: Throwable -> L31
        if (r10 == null) goto L14;
        JSONArray r11 = cl.a.F(r10.getAbsolutePath());     // Catch: Throwable -> L31
    L15:
        String r12 = m.o(n.f4057a);
        String r13 = m();
        boolean r14 = false;
        JSONObject r15 = f22810l.f23416a;     // Catch: Throwable -> L22
        z8.c r16 = new z8.c(r15);     // Catch: Throwable -> L22
        r14 = j(r12, r11, r15, r16);     // Catch: Throwable -> L21
        g(r21, r15.optString("data"), r15.optJSONObject("all_thread_stacks"));     // Catch: Throwable -> L29
    L20:
        boolean r17 = r14;
        z8.c r18 = r16;
    L40:
        z5.a.c(f22803a, CrashType.ANR);     // Catch: Throwable -> L30
    L36:
        z8.c.l(f22810l.f23416a, "filters", "anr_step", "complete");     // Catch: Throwable -> L26
        f(r5, f22803a, r12, r13, p.e(), f22811m, n.f4059c, System.currentTimeMillis(), f22810l.f23416a, r21, r18, true, 1, r17, true);     // Catch: Throwable -> L26
        return;
    L26:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
        return;
    L22:
        r18 = null;
        r17 = false;
    L14:
        r11 = null;
        goto L15
    L6:
        if (p.f4086j == false) goto L32;
        if (Debug.isDebuggerConnected() == false) goto L32;
        cl.a.s(r5.getAbsolutePath());
        goto L32
    }

    public static void f(File r32, File r33, String r34, String r35, boolean r36, long r37, long r39, long r41, JSONObject r43, String r44, z8.c r45, boolean r46, int r47, boolean r48, boolean r49) {
        if (r33 != null) goto L6;
        File r17 = r32;
    L7:
        long r10 = System.currentTimeMillis();
        String r18 = "s";
        String r19 = "us";
        com.bytedance.android.anniex.base.service.e.l("pack_upload_anr", "0");
        if (r45 != null) goto L10;
        z8.c r11 = new z8.c(r43);
    L11:
        Long r12 = Long.valueOf(r37);
        String r20 = "ms";
        JSONObject r13 = r11.f23416a;
        String r21 = " total ";
        mh.e.g(r12, "crash_time", r13);
        if (r39 == (-1)) goto L14;
        mh.e.g(Long.valueOf(r39), "app_start_time", r13);
    L14:
        mh.e.g(Long.valueOf(r41), "anr_time", r13);
        mh.e.g(Boolean.valueOf(r46), "is_current_process", r13);
        if (TextUtils.isEmpty(r34) == true) goto L17;
        String r5 = r34;
        mh.e.g(r5, "process_name", r13);
    L18:
        r11.j("crash_time", zm.p.e().format(new Date(r37)));
        r11.j("anr_info_time", zm.p.e().format(new Date(r41)));
        r11.j("anr_upload_time", zm.p.e().format(new Date(r10)));
        String r14 = r43.optJSONObject("filters").optString("has_signal", "");     // Catch: Throwable -> L21
    L23:
        if (r14 != "") goto L31;
        if (r37 <= r41) goto L27;
        z8.c.l(r11.b(), "filters", "has_signal", String.valueOf(false));
        goto L31
    L27:
        if (r37 >= r41) goto L29;
        z8.c.l(r11.b(), "filters", "has_signal", String.valueOf(true));
        goto L31
    L29:
        z8.c.l(r11.b(), "filters", "has_signal", "unknow");
    L31:
        if (new File(r32, "silent_anr").exists() == false) goto L33;
        z8.c.l(r11.b(), "filters", "no_dump_anr_info", "true");
    L33:
        z8.c.l(r11.b(), "filters", "already_has_anr", String.valueOf(f22812n));
        z8.c.l(r11.b(), "filters", "from", String.valueOf(new File(r32, "thread").exists()));
        if (r33 != null) goto L310;
    L46:
        boolean r15 = false;
    L47:
        z8.c.l(r11.b(), "filters", "memory_leak", String.valueOf(r15));
        if (r33 != null) goto L318;
    L54:
        boolean r16 = false;
    L55:
        z8.c.l(r11.b(), "filters", "fd_leak", String.valueOf(r16));
        if (r33 != null) goto L296;
    L62:
        boolean r22 = false;
    L63:
        z8.c.l(r11.b(), "filters", "threads_leak", String.valueOf(r22));
        d r23 = new d();
        boolean r24 = TextUtils.isEmpty(r35);
        c r25 = r23.f22794a;
        if (r24 == false) goto L66;
        n.f4057a.getPackageName();
        r25.f22785p = r5;
    L67:
        JSONArray r110 = r13.optJSONArray("logcat");
        if (r110 == null) goto L147;
        if (r110.length() == 0) goto L147;
        float r26 = 0.0f;
        int r27 = r110.length() - 1;
        long r28 = 0;
        float r111 = 0.0f;
    L73:
        if (r27 <= 0) goto L143;
        String r29 = r110.getString(r27);     // Catch: Exception -> L138
        if (TextUtils.isEmpty(r29) == true) goto L137;
        JSONArray r38 = r110;
    L133:
        e = e;
    L134:
        String r112 = r20;
        String r30 = r21;
    L140:
        io.reactivex.exceptions.a.f(new RuntimeException(e));
    L141:
        r27 = r27 - 1;
        r21 = r30;
        r20 = r112;
        r110 = r38;
        goto L73
    L78:
        if (r29.contains("GC freed") == true) goto L80;
    L79:
        r112 = r20;
        r30 = r21;
        goto L141
    L80:
        Matcher r31 = Pattern.compile("(\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}.\\d{3})\\s+(\\d+)\\s+(\\d+) ([IWDE])\\s+([\\s\\S]*):([\\s\\S]*)").matcher(r29);     // Catch: Exception -> L133
        if (r31.find() == false) goto L135;
        String r40 = r31.group(1);     // Catch: Exception -> L133
        r31.group(2);     // Catch: Exception -> L133
        r31.group(3);     // Catch: Exception -> L133
        r31.group(4);     // Catch: Exception -> L133
        r31.group(5);     // Catch: Exception -> L133
        String r42 = r31.group(6);     // Catch: Exception -> L133
        Date r113 = new Date(r13.optLong("crash_time"));     // Catch: Exception -> L133
        long r50 = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(String.format("%tY", new Object[]{r113}) + DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD + r40).getTime() - r113.getTime()) / 1000;     // Catch: Exception -> L133
        r30 = r21;
    L126:
        e = e;
    L123:
        r112 = r20;
        goto L140
    L85:
        if (r42.contains(r30) == false) goto L125;
        if (Math.abs(r50) > 30) goto L125;
        if (r50 >= 0) goto L125;
        r28 = r28 + 1;
        String[] r51 = r42.split(r30);     // Catch: Exception -> L121
        if (r51.length != 2) goto L124;
        String r52 = r51[1];     // Catch: Exception -> L121
        r112 = r20;
        if (r52.contains(r112) == true) goto L306;
        String r53 = r19;
        if (r52.contains(r53) == true) goto L308;
        String r54 = r18;
    L115:
        e = e;
        r19 = r53;
        r18 = r54;
        goto L140
    L111:
        if (r52.contains(r54) == false) goto L114;
        r111 = r111 + (Float.parseFloat(r52.split(r54)[0]) * 1000.0f);
    L114:
        r19 = r53;
        r18 = r54;
        goto L141
    L308:
        r111 = r111 + (Float.parseFloat(r52.split(r53)[0]) / 1000000.0f);
        r19 = r53;
    L107:
        e = e;
    L108:
        r19 = r53;
    L117:
        e = e;
        goto L108
    L306:
        r111 = r111 + Float.parseFloat(r52.split(r112)[0]);
    L100:
        e = e;
    L119:
        e = e;
        goto L140
    L124:
        r54 = r18;
        r53 = r19;
        r112 = r20;
    L121:
        e = e;
    L125:
        r112 = r20;
        if (Math.abs(r50) <= 30) goto L141;
        if (r50 >= 0) goto L141;
    L135:
        r112 = r20;
        r30 = r21;
        io.reactivex.exceptions.a.c("NO MATCH");     // Catch: Exception -> L100
        goto L141
    L137:
        r38 = r110;
    L138:
        e = e;
        r38 = r110;
    L143:
        if (r28 <= 0) goto L145;
        r26 = r111 / r28;
    L145:
        r11.e(r111, "gc_time");
        r11.h("gc_count", r28);
        r11.e(r26, "gc_time_avg");
    L147:
        if (TextUtils.isEmpty(r44) == true) goto L149;
    L153:
        String r55 = r44;
    L155:
        if (TextUtils.isEmpty(r55) == false) goto L157;
        String r56 = "invalid";
    L158:
        mh.e.g(r56, "anr_info", r43);
        if (TextUtils.isEmpty(r55) == false) goto L161;
    L166:
        r23.f22797h.e("anr_reason", "silent anr");
    L168:
        if (b.f22763n <= 0) goto L172;
        r11.j("anr_time_from_info", zm.p.e().format(new Date(b.f22763n)));
        long r57 = f22806h;
        long r58 = b.f22763n;
        if (r57 <= r58) goto L172;
        r11.j("anr_to_sig_cost", String.valueOf(r57 - r58));
    L172:
        long r59 = b.f22763n;
        JSONObject r60 = r13.optJSONObject("current_message");
        if (r60 != null) goto L176;
        z8.c.l(r13, "filters", "anr_cmsg_wall", "no_cmsg");
        long r114 = r37;
    L197:
        JSONObject r61 = r13.optJSONObject("app_memory_info");
        JSONObject r62 = r13.optJSONObject("memory_info");
        if (r61 == null) goto L202;
        long r63 = r61.optLong("max_memory");
        long r115 = r61.optLong("free_memory");
        long r210 = r61.optLong("total_memory");
        if (r63 <= 0) goto L202;
        r11.e(((r210 - r115) * 100) / r63, "java_heap_usage");
    L202:
        if (r62 == null) goto L205;
        r11.h("total_pss", r62.optLong("totalPss") / 1048576);
    L205:
        if (TextUtils.isEmpty(r55) == true) goto L210;
        if (r36 == true) goto L210;
        if (r48 == true) goto L210;
        boolean r211 = false;
    L211:
        z8.c.l(r11.b(), "filters", "is_current_process", String.valueOf(r46));
        z8.c.l(r11.b(), "filters", "crash_after_crash", String.valueOf(r36));
        JSONObject r64 = r43.optJSONObject("filters");     // Catch: Exception -> L290
        if (r64 == null) goto L221;
        String r65 = r64.optString("last_resume_activity");     // Catch: Exception -> L290
        if (TextUtils.isEmpty(r23.g) == true) goto L221;
        if (TextUtils.isEmpty(r65) == false) goto L219;
    L220:
        r64.put("last_resume_activity", r23.g);     // Catch: Exception -> L290
        goto L221
    L219:
        if (r65.equals("null") == true) goto L220;
    L221:
        String r66 = r25.f22786q;
        if (r66 == null) goto L224;
        String r116 = r66;
    L225:
        z8.c.l(r13, "features_str", "top_cpu_process_name", r116);
        mh.e.g(r23.a(), "anr_atribute", r43);
        JSONObject r67 = r43.optJSONObject("filters");
        Iterator r68 = r23.f22795b.entrySet().iterator();
    L227:
        if (r68.hasNext() == false) goto L229;
        Map.Entry r69 = (Map.Entry) r68.next();
        mh.e.g(r69.getValue(), (String) r69.getKey(), r67);
        goto L227
    L229:
        Iterator r70 = r23.f.entrySet().iterator();
    L231:
        if (r70.hasNext() == false) goto L233;
        Map.Entry r71 = (Map.Entry) r70.next();
        mh.e.g(r71.getValue(), (String) r71.getKey(), r43);
        goto L231
    L233:
        r11.h("use_time", (r114 - n.f4059c) / 1000);
        r11.h("dstate_count", b.f22762m);
        r11.h("thread_all_count", b.f22761l);
        JSONArray r72 = r43.optJSONArray("history_message");
        if (r72 == null) goto L236;
        long[] r73 = b.i(r72);
        r11.h("history_message_cpu_avg", r73[0]);
        r11.h("history_message_wall_avg", r73[1]);
    L236:
        JSONObject r74 = r43.optJSONObject("features_num");
        JSONObject r75 = r43.optJSONObject("features_str");
        if (r74 != null) goto L239;
        r74 = new JSONObject();
        mh.e.g(r74, "features_num", r13);
    L239:
        if (r75 != null) goto L241;
        r75 = new JSONObject();
        mh.e.g(r75, "features_str", r13);
    L241:
        r23.c(r74);
        Iterator r76 = r23.f22796c.entrySet().iterator();
    L243:
        if (r76.hasNext() == false) goto L245;
        Map.Entry r77 = (Map.Entry) r76.next();
        mh.e.g(r77.getValue(), (String) r77.getKey(), r75);
        goto L243
    L245:
        v8.a.d().getClass();
        String r78 = r5;
        ArrayList r79 = v8.a.d().c(r114, r78);
        if (r79 == null) goto L256;
        JSONArray r80 = new JSONArray();
        Iterator r81 = r79.iterator();
    L250:
        if (r81.hasNext() == false) goto L252;
        r80.put((String) r81.next());
        goto L250
    L252:
        JSONObject r82 = r13.optJSONObject("custom_long");
        if (r82 != null) goto L255;
        r82 = new JSONObject();
        mh.e.g(r82, "custom_long", r13);
    L255:
        mh.e.g(r80, "alogFiles", r82);
    L256:
        n.f4063k.getClass();
        AppDataCenter.a(r43);
        File r83 = r17;
        cl.a.q(new File(r83, "result_body.json"), r43);
        File r84 = f22808j;
        if (r84 == null) goto L260;
        cl.a.C(r84);
        f22808j = null;
        f22810l = null;
        f22804b = null;
    L260:
        if (r47 != 0) goto L262;
        return;
    L262:
        long r85 = SystemClock.uptimeMillis();
        c(r47, r43, r83, r32);
        z8.c.l(r43, "custom", "notify_anr_cost", String.valueOf(SystemClock.uptimeMillis() - r85));
        if (p.f4084h == false) goto L266;
        io.reactivex.exceptions.a.c("packOriginJson: isStopUpload == true, return");
        return;
    L266:
        com.lynx.jsbridge.a.j(r83, r43);
        if (cl.a.A(r32) == false) goto L271;
        i(true, 1, r33, r43);
        return;
    L271:
        if (r33 == null) goto L273;
        c5.a r86 = new c5.a(r33, true);
    L274:
        if (r33 != null) goto L276;
        r86 = new c5.a(r32, true);
    L276:
        t r87 = com.bytedance.crash.upload.b.a(CrashType.ANR.getName(), com.bytedance.crash.upload.b.i(n.f4062j.getJavaCrashUploadUrl(), r43.optJSONObject("header")), r43.toString(), null, new c5.a[]{r86, new c5.a(com.bytedance.crash.upload.b.e(), false), com.bytedance.android.anniex.base.service.e.m(r37), i9.f.c(r43.optJSONArray("alive_pids"))});
        boolean r88 = r87.c();
        if (r88 == false) goto L285;
        if (r49 == false) goto L280;
        i(r87.b(), 0, r32, r43);
    L282:
        if (r87.b() == true) goto L285;
        if (r211 == true) goto L285;
        v8.a.a(r78, r79);
        goto L285
    L280:
        i(r87.b(), 0, r33, r43);
    L285:
        if (r88 == false) goto L287;
        String r89 = "success";
    L288:
        com.bytedance.android.anniex.base.service.e.l("upload_anr", r89);
        return;
    L287:
        r89 = MessageIndication.STATUS_FAILED;
        goto L288
    L273:
        r86 = null;
        goto L274
    L224:
        r116 = "";
    L210:
        z8.c.l(r43, "filters", WsConstants.KEY_APP_ID, String.valueOf(r43.optJSONObject("header").opt(WsConstants.KEY_APP_ID)));
        mh.e.g(2010, WsConstants.KEY_APP_ID, r43.optJSONObject("header"));
        r211 = true;
        goto L211
    L176:
        if (r59 > 0) goto L178;
        r59 = r37;
        r114 = r59;
    L180:
        if (r114 > 0) goto L182;
        z8.c.l(r13, "filters", "anr_cmsg_wall", "no_crash_time");
        goto L197
    L182:
        long r90 = r114 - r59;
        long r117 = r60.optLong("currentMessageCost") - r90;
        if (r117 < 60000) goto L186;
        z8.c.l(r13, "filters", "anr_cmsg_wall", ">=60s");
    L196:
        r11.j("anr_to_dump_cost", String.valueOf(r90));
        goto L197
    L186:
        if (r117 < 10000) goto L189;
        z8.c.l(r13, "filters", "anr_cmsg_wall", ">=10s");
        goto L196
    L189:
        if (r117 < 5000) goto L192;
        z8.c.l(r13, "filters", "anr_cmsg_wall", ">=5s");
        goto L196
    L192:
        if (r117 <= 0) goto L194;
        z8.c.l(r13, "filters", "anr_cmsg_wall", ">0");
        goto L196
    L194:
        if (r117 > 0) goto L196;
        z8.c.l(r13, "filters", "anr_cmsg_wall", "<=0");
        goto L196
    L178:
        r114 = r37;
        goto L180
    L161:
        if ("silent anr no anr info".equals(r55) == true) goto L166;
        b.e(r55, r23);     // Catch: Throwable -> L164
    L164:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
        goto L168
    L157:
        r56 = r55;
        goto L158
    L149:
        if (r13.has("enable_slient_anr") == false) goto L153;
        if (r13.optBoolean("enable_slient_anr") == false) goto L153;
        r55 = "silent anr no anr info";
        goto L155
    L66:
        r25.f22785p = r5;
        goto L67
    L296:
        if (new i9.b(new File(r33, "threads.txt"), 3).a() <= 350) goto L62;
        r22 = true;
        goto L63
    L318:
        if (new i9.b(new File(r33, "fds.txt"), 0).a() <= 960) goto L54;
        r16 = true;
        goto L55
    L310:
        long r118 = new i9.b(new File(r33, "meminfo.txt"), 1).a();     // Catch: Throwable -> L293
        if (NativeTools.k().E() == false) goto L39;
        long r212 = Long.MAX_VALUE;
    L44:
        if (r118 <= r212) goto L46;
        r15 = true;
        goto L47
    L39:
        if (Header.h() == false) goto L42;
        r212 = 3891200;
        goto L44
    L42:
        r212 = 2867200;
    L21:
        r14 = "";
        goto L23
    L17:
        r5 = r13.optString("process_name");
        goto L18
    L10:
        r11 = r45;
        goto L11
    L6:
        r17 = r33;
        goto L7
    }

    public static void g(String r5, String r10, JSONObject r11) {
        g0 r12 = p.f;
        ListMap r13 = (ListMap) r12.f209a;
        monitor-enter(r13);
        List r14 = ((ListMap) r12.f209a).a(CrashType.ANR);     // Catch: Throwable -> L38
        monitor-exit(r13);     // Catch: Throwable -> L38
        if (r14.size() <= 0) goto L16;
        Iterator r15 = r14.iterator();
    L10:
        if (r15.hasNext() == false) goto L16;
        ICrashCallback r16 = (ICrashCallback) r15.next();
        r16.onCrash(CrashType.ANR, r5, null);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
    L16:
        CopyOnWriteArrayList r17 = (CopyOnWriteArrayList) p.f.g;
        if (r17.size() <= 0) goto L37;
        JSONObject r18 = new JSONObject();
        if (mh.e.n(r11) == true) goto L23;
        r18.put("all_thread_stacks", r11);     // Catch: Throwable -> L41
    L23:
        if (TextUtils.isEmpty(r10) == true) goto L25;
        r18.put("data", r10);     // Catch: Throwable -> L41
    L25:
        r18.toString();     // Catch: Throwable -> L41
    L26:
        Iterator r19 = r17.iterator();
    L28:
        if (r19.hasNext() == false) goto L57;
        if (r19.next() != null) goto L36;
        throw null;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
        goto L28
    L36:
        throw new ClassCastException();
    L57:
        return;
    L37:
        return;
    L38:
        th = move-exception;
        throw th;
    }

    public static void h(z8.c r10, String r11, String r12, String r13, boolean r14, boolean r15) {
        JSONObject r5 = r10.f23416a;
        JSONObject r16 = new JSONObject(r5.optString("data"));     // Catch: JSONException -> L5
    L6:
        if (r14 == true) goto L25;
    L8:
        List r17 = Arrays.asList(r12.split("\n"));     // Catch: Exception -> L22
        if (r17 == null) goto L19;
        JSONArray r18 = new JSONArray();     // Catch: Exception -> L22
        Iterator r19 = r17.iterator();     // Catch: Exception -> L22
    L13:
        if (r19.hasNext() == false) goto L15;
        r18.put((String) r19.next());     // Catch: Exception -> L22
        goto L13
    L15:
        JSONObject r20 = r5.optJSONObject("custom_long");     // Catch: Exception -> L22
        if (r20 != null) goto L18;
        r20 = new JSONObject();     // Catch: Exception -> L22
        mh.e.g(r20, "custom_long", r5);     // Catch: Exception -> L22
    L18:
        mh.e.g(r18, "main_stack_2nd", r20);     // Catch: Exception -> L22
    L19:
        if (r15 == false) goto L28;
        z8.c.l(r10.b(), "filters", "anr_replace_mainstack", r13);     // Catch: Exception -> L22
        return;
    L29:
        return;
    L28:
        return;
    L25:
        r16.put("mainStackFromTrace", r11);     // Catch: Exception -> L22
        NativeTools.k().getClass();     // Catch: Exception -> L22
        r5.put("crash_lib_uuid", NativeTools.F(r11));     // Catch: Exception -> L22
        r5.put("data", r16.toString());     // Catch: Exception -> L22
    L5:
        r16 = b(null, null, false);
        goto L6
    }

    public static void i(boolean r5, int r10, File r11, JSONObject r12) {
        if (r11 == null) goto L5;
        cl.a.C(r11);     // Catch: Throwable -> L26
    L31:
        return;
    L5:
        if (p.e() == true) goto L7;
        cl.a.C(com.bytedance.crash.util.g.f(n.f4057a));     // Catch: Throwable -> L26
    L7:
        if (r5 == true) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(r12.optString("crash_uuid")) == false) goto L11;
        r12.optString("start_uuid");     // Catch: Throwable -> L26
    L11:
        r12.optString("data");     // Catch: Throwable -> L26
        r12.optLong("app_start_time");     // Catch: Throwable -> L26
        r12.optLong("crash_time");     // Catch: Throwable -> L26
        r12.optString("process_name");     // Catch: Throwable -> L26
        g0 r13 = p.f;     // Catch: Throwable -> L25
        CrashType r14 = CrashType.ANR;     // Catch: Throwable -> L25
        List r15 = ((ListMap) r13.e).a(r14);     // Catch: Throwable -> L25
        if (r15.size() <= 0) goto L23;
        Iterator r16 = r15.iterator();     // Catch: Throwable -> L25
        if (r16.hasNext() == false) goto L23;
        if (r16.next() != null) goto L22;
        throw null;     // Catch: Throwable -> L25
    L22:
        throw new ClassCastException();     // Catch: Throwable -> L25
    L23:
        s.g(r10, CrashType.ANR);     // Catch: Throwable -> L26
    }

    public static boolean j(String r5, JSONArray r10, JSONObject r11, z8.c r12) {
        boolean r13 = false;
        d r14 = new d();     // Catch: Throwable -> L21
        r14.f22794a.f22785p = r5;     // Catch: Throwable -> L21
        boolean r15 = k(r11);     // Catch: Throwable -> L21
        boolean r16 = !r15;
        if (r10 != null) goto L22;
    L17:
        z8.c.l(r12.b(), "filters", "anr_replace_mainstack", "OnlyJavaStack");     // Catch: Throwable -> L19
        return r16;
    L22:
        if (mh.e.m(r10) == true) goto L17;
        Pair r17 = b.a(r10, r14, true);     // Catch: Throwable -> L19
        JSONObject r18 = (JSONObject) r17.first;     // Catch: Throwable -> L19
        JSONObject r19 = (JSONObject) r17.second;     // Catch: Throwable -> L19
        String r20 = a(r12, r18);     // Catch: Throwable -> L19
        if (r15 == false) goto L11;
    L13:
        r13 = r16;
    L14:
        if (r19 == null) goto L16;
        mh.e.g(r19, "all_thread_stacks", r11);     // Catch: Throwable -> L21
    L16:
        return r13;
    L11:
        if (r20 == "") goto L13;
    L20:
        return r16;
    L25:
        return r13;
    }

    public static boolean k(JSONObject r5) {
        JSONObject r10 = new JSONObject(r5.optString("data"));     // Catch: JSONException -> L6
        String r11 = r10.optString("mainStackFromTrace");     // Catch: JSONException -> L6
        boolean r12 = !r10.optBoolean("invalid", false);
    L9:
        if (TextUtils.isEmpty(r11) == false) goto L11;
        return false;
    L11:
        if (r11.contains("at InvalidStack.NoStackAvailable(Invalid.java:1).\n") == false) goto L14;
        return false;
    L14:
        return r12;
    L7:
        r12 = false;
    L6:
        r11 = "";
        goto L7
    }

    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v6 */
    public static void l() {
        String r5 = "\n";
        ?? r10 = 1;
        d = true;
        Context r11 = n.f4057a;
        String r12 = com.bytedance.crash.util.g.f4181a;
        File r13 = new File(com.bytedance.crash.util.g.h(r11) + "/" + x8.a.e);
        if (r13.exists() == false) goto L325;
        File[] r14 = r13.listFiles();
        if (r14 != null) goto L8;
        return;
    L8:
        if (r14.length == 0) goto L326;
        int r15 = 0;
        int r16 = 0;
    L12:
        if (r16 >= r14.length) goto L242;
        File r17 = r14[r16];
        if (r16 < 5) goto L16;
        cl.a.s(r17.getAbsolutePath());
    L16:
        String[] r18 = r17.list();
        if (r18 != null) goto L19;
    L20:
        File[] r26 = r14;
        int r27 = r16;
        int r19 = r15;
        String r20 = r5;
        cl.a.C(r17);
    L241:
        r5 = r20;
        r15 = r19;
        r14 = r26;
        r16 = r27 + 1;
        r10 = r10;
        goto L12
    L19:
        if (r18.length == 0) goto L20;
        Arrays.sort(r18);
        int r21 = r18.length - (r10 == true ? 1 : 0);
    L23:
        if (r21 < 0) goto L38;
        if (r18[r21].startsWith("anr_info_") == true) goto L26;
        r21 = r21 - 1;
        goto L23
    L26:
        File r22 = new File(r17, r18[r21]);
        String[] r23 = r22.getName().substring(9).split("_");
        if (r23.length >= r10) goto L260;
        boolean r24 = r10 == true ? 1 : 0;
        File r110 = r22;
        long r25 = -1;
    L280:
        long r28 = Long.decode(cl.a.c(-1, new File(r17, "app_start_time"), r5)).longValue();     // Catch: Throwable -> L41
    L286:
        String r29 = cl.a.c(-1, new File(r17, "cmd"), "");     // Catch: IOException -> L44
    L43:
        String r111 = r29;
        if (new File(r17, "hasJavaCrash").exists() == false) goto L48;
    L51:
        boolean r30 = r10 == true ? 1 : 0;
    L52:
        int r210 = r18.length - (r10 == true ? 1 : 0);
        boolean r31 = false;
    L53:
        r26 = r14;
        r27 = r16;
        if (r210 < 0) goto L199;
        if (r18[r210].startsWith("trace_") == true) goto L266;
        r5 = r5;
        boolean r36 = r30;
        long r39 = r28;
        long r41 = r25;
        File r32 = r110;
        String[] r33 = r18;
        r111 = r111;
        File r37 = r17;
    L198:
        r210 = r210 - 1;
        r111 = r111;
        r14 = r26;
        r16 = r27;
        r5 = r5;
        r110 = r32;
        r18 = r33;
        r30 = r36;
        r17 = r37;
        r28 = r39;
        r25 = r41;
        goto L53
    L266:
        long r112 = Long.decode(r18[r210].substring(6)).longValue();     // Catch: Throwable -> L59
    L60:
        File r34 = new File(r17, r18[r210]);
        File r35 = new File(r34, "main_stack.txt");
        long r211 = r28;
        File r38 = new File(r34, "trace.txt");
        File r40 = new File(r34, "looper_message.txt");
        long r310 = r25;
        File r42 = new File(r17, j0.q(new StringBuilder(), r18[r210], "/result_body.json"));
        if (r42.exists() == true) goto L272;
    L92:
        File r311 = r35;
        String r312 = "header";
        r36 = r30;
        r33 = r18;
    L93:
        r37 = r17;
    L94:
        String r43 = null;
    L96:
        if (r38.exists() == true) goto L284;
        JSONArray r44 = new JSONArray();
    L99:
        JSONArray r45 = r44;
        File r46 = new File(r34, "origin_json.txt");
        if (r46.exists() == true) goto L298;
        File r47 = r34;
        long r48 = r112;
        String r49 = "filters";
        r111 = r111;
        String r410 = "anr_step";
        String r411 = "trace_";
        r39 = r211;
        r41 = r310;
        JSONArray r313 = r45;
        r32 = r110;
        String r50 = "NPTH_CATCH";
    L290:
        z8.c r51 = o();     // Catch: IOException -> L249 Throwable -> L193
        Context r52 = n.f4057a;     // Catch: IOException -> L249 Throwable -> L193
        long r113 = r39;
        long r114 = r48;
        z8.c r53 = Header.c(r111, r113, r114);     // Catch: Throwable -> L188 IOException -> L191
        String r115 = r312;
        mh.e.g(r53.o().f4029a, r115, r51.f23416a);     // Catch: Throwable -> L183 IOException -> L186
        mh.e.j(r51.f23416a, r53.f23416a);     // Catch: Throwable -> L183 IOException -> L186
    L302:
        mh.e.g(b(cl.a.c(-1, r311, r5), null, false).toString(), "data", r51.f23416a);     // Catch: Throwable -> L147 IOException -> L149
        if (r40.exists() == false) goto L145;
        mh.e.j(r51.f23416a, new JSONObject(cl.a.c(-1, r40, r5)));     // Catch: Throwable -> L245
    L145:
        if (mh.e.m(r313) == false) goto L150;
        String r54 = "stack";
    L151:
        z8.c.l(r51.b(), r49, r410, r54);     // Catch: Throwable -> L147 IOException -> L149
        String r212 = "logcat";
        JSONArray r55 = r51.f23416a.optJSONArray(r212);     // Catch: Throwable -> L158 IOException -> L161
        if (r55 != null) goto L156;
    L163:
        mh.e.g(zm.p.f(r47), r212, r51.f23416a);     // Catch: Throwable -> L158 IOException -> L161
    L164:
        z8.c r56 = new z8.c(r51.f23416a);     // Catch: Throwable -> L158 IOException -> L161
        String r57 = m();     // Catch: Throwable -> L158 IOException -> L161
        boolean r213 = j(r111, r313, r51.f23416a, r56);     // Catch: Throwable -> L158 IOException -> L161
        JSONObject r58 = r51.f23416a;     // Catch: Throwable -> L158 IOException -> L161
        if (r32 != null) goto L256;
    L174:
        File r59 = r32;
        String r116 = null;
    L178:
        r5 = r5;
        r32 = r59;
        String r60 = "data";
        r39 = r113;
        r212 = r212;
        String r61 = r115;
        f(r37, r47, r111, r57, r36 ? 1 : 0, r114, r113, r41, r58, r116, r56, r24, 1, r213, false);     // Catch: Throwable -> L181 IOException -> L246
    L180:
        r31 = true;
        goto L198
    L181:
        th = th;
    L195:
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h(r50, th);
    L196:
        r31 = true;
    L200:
        if (r31 == false) goto L288;
    L230:
        r20 = r5;
        r19 = 0;
    L231:
        String[] r62 = r37.list();
        int r63 = r62.length;
        int r117 = r19;
        int r64 = 1;
    L232:
        if (r117 >= r63) goto L237;
        String r65 = r411;
        if (r62[r117].startsWith(r65) == false) goto L236;
        r64 = r19;
    L236:
        r117 = r117 + 1;
        r411 = r65;
        goto L232
    L237:
        r10 = 1;
        r10 = 1;
        if (r64 == 0) goto L241;
        cl.a.C(r37);
        goto L241
    L288:
        z8.c r66 = o();     // Catch: Throwable -> L227 IOException -> L248
        Context r67 = n.f4057a;     // Catch: Throwable -> L227 IOException -> L248
        long r118 = r39;
        long r119 = r41;
        z8.c r68 = Header.c(r111, r118, r119);     // Catch: Throwable -> L227 IOException -> L248
        mh.e.g(r68.o().f4029a, r61, r66.f23416a);     // Catch: Throwable -> L227 IOException -> L248
        mh.e.j(r66.b(), r68.b());     // Catch: Throwable -> L227 IOException -> L248
        r19 = 0;
        String r69 = null;
        mh.e.g(b("at InvalidStack.NoStackAvailable(Invalid.java:1).\n", null, false).toString(), r60, r66.f23416a);     // Catch: Throwable -> L209 IOException -> L211
        String r70 = r212;
        JSONArray r71 = r66.f23416a.optJSONArray(r70);     // Catch: Throwable -> L209 IOException -> L211
        if (r71 != null) goto L206;
    L212:
        boolean r72 = true;
    L213:
        if (r72 == false) goto L215;
        mh.e.g(zm.p.f(r37), r70, r66.f23416a);     // Catch: Throwable -> L209 IOException -> L211
    L215:
        z8.c r73 = new z8.c(r66.f23416a);     // Catch: Throwable -> L209 IOException -> L211
        String r74 = m();     // Catch: Throwable -> L209 IOException -> L211
        boolean r214 = j(r111, new JSONArray(), r66.f23416a, r73);     // Catch: Throwable -> L209 IOException -> L211
        JSONObject r75 = r66.f23416a;     // Catch: Throwable -> L209 IOException -> L211
        if (r32 != null) goto L218;
    L224:
        r20 = r5;
    L225:
        f(r37, null, r111, r74, r36, r119, r118, r119, r75, r69, r73, r24, 1, r214, false);     // Catch: Throwable -> L222 IOException -> L247
        goto L231
    L218:
        if (r32.exists() == false) goto L224;
        r20 = r5;
        r69 = cl.a.c(-1, r32, r20);     // Catch: Throwable -> L222 IOException -> L247
    L222:
        th = th;
    L229:
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h(r50, th);
        goto L231
    L206:
        if (r71.length() == 0) goto L212;
        r72 = false;
        goto L213
    L211:
        r20 = r5;
    L209:
        th = th;
        r20 = r5;
        goto L229
    L227:
        th = th;
        r20 = r5;
        r19 = 0;
        goto L229
    L256:
        if (r32.exists() == false) goto L174;
        r59 = r32;
        r116 = cl.a.c(-1, r59, r5);     // Catch: Throwable -> L171 IOException -> L173
        goto L178
    L173:
        r32 = r59;
    L171:
        th = th;
        r32 = r59;
    L160:
        r60 = "data";
        r39 = r113;
        r61 = r115;
    L175:
        th = th;
        goto L160
    L156:
        if (r55.length() != 0) goto L164;
    L158:
        th = th;
    L162:
        r60 = "data";
        r39 = r113;
        r61 = r115;
        goto L196
    L150:
        r54 = "trace";
    L149:
        r39 = r113;
        r61 = r115;
        r212 = "logcat";
        r5 = r5;
        r60 = "data";
    L147:
        th = th;
        r39 = r113;
        r61 = r115;
        r212 = "logcat";
        r5 = r5;
        r60 = "data";
    L186:
        r39 = r113;
        r61 = r115;
    L187:
        r5 = r5;
        r60 = "data";
        r212 = "logcat";
    L183:
        th = th;
        r39 = r113;
        r61 = r115;
    L185:
        r5 = r5;
        r60 = "data";
        r212 = "logcat";
        goto L195
    L191:
        r39 = r113;
    L188:
        th = th;
        r39 = r113;
    L190:
        r61 = r312;
        goto L185
    L193:
        th = th;
    L192:
        r61 = r312;
        goto L187
    L298:
        JSONObject r76 = new JSONObject(cl.a.c(-1, r46, r5));     // Catch: Throwable -> L107 IOException -> L109
        if (mh.e.m(r45) == false) goto L111;
        String r77 = "origin_no_trace";
    L112:
        z8.c.l(r76, "filters", "anr_step", r77);     // Catch: Throwable -> L107 IOException -> L109
        z8.c r78 = new z8.c(r76);     // Catch: Throwable -> L107 IOException -> L109
        String r79 = m();     // Catch: Throwable -> L107 IOException -> L109
        boolean r314 = j(r111, r45, r76, r78);     // Catch: Throwable -> L107 IOException -> L109
        if (r110 != null) goto L308;
    L119:
        long r80 = -1;
        String r120 = r43;
    L125:
        r39 = r211;
        r41 = r310;
        r313 = r45;
        r32 = r110;
        r48 = r112;
        r50 = r12;
        r411 = r11;
        r47 = r34;
        r49 = "filters";
        r111 = r111;
        r410 = "anr_step";
        f(r37, r34, r111, r79, r36 ? 1 : 0, r112, r39, r41, r76, r120, r78, r24, 1, r314, false);     // Catch: Throwable -> L128 IOException -> L130
        r5 = r5;
        goto L180
    L130:
        e = e;
    L133:
        io.reactivex.exceptions.a.f(e);
    L128:
        th = th;
    L132:
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h(r50, th);
        goto L290
    L308:
        if (r110.exists() == false) goto L119;
        r80 = -1;
        r120 = cl.a.c(-1, r110, r5);     // Catch: Throwable -> L107 IOException -> L109
        goto L125
    L122:
        e = e;
    L110:
        r47 = r34;
        r48 = r112;
        r49 = "filters";
        r111 = r111;
        r410 = "anr_step";
        r411 = r11;
        r39 = r211;
        r41 = r310;
        r313 = r45;
        r32 = r110;
        r50 = r12;
    L120:
        th = th;
    L108:
        r47 = r34;
        r48 = r112;
        r49 = "filters";
        r111 = r111;
        r410 = "anr_step";
        r411 = r11;
        r39 = r211;
        r41 = r310;
        r313 = r45;
        r32 = r110;
        r50 = r12;
        goto L132
    L111:
        r77 = "origin_all";
    L109:
        e = e;
    L107:
        th = th;
        goto L108
    L284:
        r44 = cl.a.d(-1, r38);     // Catch: Throwable -> L100
    L100:
        r44 = new JSONArray();
        goto L99
    L272:
        JSONObject r81 = new JSONObject(cl.a.c(-1, r42, r5));     // Catch: Throwable -> L254
        long r82 = SystemClock.uptimeMillis();     // Catch: Throwable -> L254
        c(1, r81, r34, r17);     // Catch: Throwable -> L254
        long r315 = SystemClock.uptimeMillis() - r82;     // Catch: Throwable -> L254
        if (p.f4084h == false) goto L67;
        io.reactivex.exceptions.a.c("uploadPackedTraceResult: isStopUpload == true, return");     // Catch: Throwable -> L254
    L65:
        r36 = r30;
        r33 = r18;
        r37 = r17;
    L66:
        r39 = r211;
        r41 = r310;
        r32 = r110;
        goto L180
    L67:
        z8.c.l(r81, "custom", "notify_anr_cost", String.valueOf(r315));     // Catch: Throwable -> L254
        com.lynx.jsbridge.a.j(r34, r81);     // Catch: Throwable -> L254
        ArrayList r83 = v8.a.d().c(r112, r111);     // Catch: Throwable -> L254
        if (cl.a.A(r17) == false) goto L71;
        i(true, 1, r34, r81);     // Catch: Throwable -> L254
        goto L65
    L71:
        r33 = r18;
        r311 = r35;
        r312 = "header";
        r36 = r30;
        r37 = r17;
        r43 = null;
        t r84 = com.bytedance.crash.upload.b.a(CrashType.ANR.getName(), com.bytedance.crash.upload.b.i(n.f4062j.getJavaCrashUploadUrl(), r81.optJSONObject("header")), r81.toString(), null, new c5.a[]{new c5.a(r34, true), new c5.a(com.bytedance.crash.upload.b.e(), false), com.bytedance.android.anniex.base.service.e.m(r112), i9.f.c(r81.optJSONArray("alive_pids"))});     // Catch: Throwable -> L244
        if (r84.c() == false) goto L66;
        if (r84.b() == true) goto L87;
        v8.a.a(r111, r83);     // Catch: Throwable -> L244
    L87:
        i(r84.b(), 0, r34, r81);     // Catch: Throwable -> L244
    L89:
        r36 = r30;
    L90:
        r312 = "header";
    L91:
        r311 = r35;
    L59:
        r112 = -1;
        goto L60
    L199:
        r61 = "header";
        r36 = r30;
        r39 = r28;
        r41 = r25;
        r32 = r110;
        r411 = "trace_";
        r111 = r111;
        r37 = r17;
        r212 = "logcat";
        r5 = r5;
        r60 = "data";
        r50 = "NPTH_CATCH";
        goto L200
    L48:
        if (new File(r17, "hasNativeCrash").exists() == true) goto L51;
        r30 = false;
    L44:
        r29 = "unknown_err";
    L41:
        r28 = -1;
        goto L286
    L260:
        long r85 = Long.decode(r23[r15]).longValue();     // Catch: Throwable -> L35
        if (r23.length < 2) goto L34;
        r24 = "current".equals(r23[r10 == true ? 1 : 0]);     // Catch: Throwable -> L255
    L33:
        r110 = r22;
        r25 = r85;
    L34:
        r24 = r10 == true ? 1 : 0;
    L35:
        r85 = -1;
        goto L34
    L38:
        r24 = r10 == true ? 1 : 0;
        r25 = -1;
        r110 = null;
        goto L280
    L242:
        f22805c = r10;
        return;
    L326:
        return;
    }

    public static String m() {
        return n.f4057a.getPackageName();
    L4:
        return "";
    }

    public static File n() {
        if (f22809k != null) goto L6;
        f22809k = new File(com.bytedance.crash.util.g.h(n.f4057a), x8.a.f22996t + m.o(n.f4057a).replaceAll(":", "_"));
    L6:
        return f22809k;
    }

    public static z8.c o() {
        JSONObject r5 = new JSONObject();
        z8.c r10 = new z8.c(r5);
        mh.e.g(1, "is_anr", r5);
        mh.e.g("true", "has_dump", r5);
        mh.e.g(Long.valueOf(i.b()), "jiffy", r5);
        i.a.m(r5);
        z8.c.l(r10.b(), "filters", WsConstants.KEY_SDK_VERSION, "3.1.7-rc.89");
        String r11 = String.valueOf(Header.h());
        z8.c.l(r10.b(), "filters", "is_64_devices", r11);
        String r12 = String.valueOf(NativeTools.k().E());
        z8.c.l(r10.b(), "filters", "is_64_runtime", r12);
        String r13 = String.valueOf(Header.i());
        z8.c.l(r10.b(), "filters", "is_x86_devices", r13);
        if (s6.c.j() == false) goto L5;
        String r14 = "true";
    L6:
        z8.c.l(r10.b(), "filters", "is_root", r14);
        String r15 = System.getProperty("os.version");     // Catch: Throwable -> L9
    L10:
        z8.c.l(r10.b(), "filters", "kernel_version", r15);
        String r16 = String.valueOf(com.lynx.tasm.p.f());
        z8.c.l(r10.b(), "filters", "is_hm_os", r16);
        z8.c.l(r10.b(), "filters", "has_dump", "true");
        return r10;
    L9:
        r15 = null;
        goto L10
    L5:
        r14 = "false";
        goto L6
    }
}
