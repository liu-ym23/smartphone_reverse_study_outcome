package w8;

import ai.g0;
import android.content.Context;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.app.NotificationCompat;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.deserialization.JvmProtoBufUtil;
import av.i;
import com.bumptech.glide.load.engine.h0;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.ICrashCallback;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.n;
import com.bytedance.crash.util.ListMap;
import com.bytedance.crash.util.NativeTools;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.tasm.utils.j;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Pattern;
import l9.l;
import okhttp3.internal.ws.RealWebSocket;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ym.m;
import zm.p;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static long f22761l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static long f22762m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static long f22763n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static Pattern f22764o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static String f22765p = "";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static volatile boolean f22766q = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h0 f22767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f22768b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f22769c;
    public long d;
    public File e;
    public boolean f;
    public final Object g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final d f22770h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f22771i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public a f22772j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public File f22773k;

    public b(Context r5) {
        this.d = -1;
        this.f = true;
        this.g = new Object();
        d r10 = new d();
        this.f22770h = r10;
        this.f22771i = -1;
        this.f22772j = new a();
        this.f22768b = r5;
        String r11 = m.o(r5);
        r5.getPackageName();
        r10.f22794a.f22785p = r11;
        if (a.a.d == false) goto L5;
        return;
    L5:
        a.a.d = true;
        a.a.e = 100;
        a.a.f18h = 300;
        a.a.f = new ArrayList();
        g r12 = new g();
        l9.c.f19554a.add(r12);
        if (l9.c.f19555b == false) goto L8;
        r12.b();
    L8:
        a.a.a(a.a.r());
    }

    public static Pair a(JSONArray r16, d r17, boolean r18) {
        String r5 = null;
        if (r16 == null) goto L5;
        JSONArray r10 = new JSONArray();
        JSONArray r11 = new JSONArray();
        JSONArray r12 = new JSONArray();
        String r13 = null;
        JSONObject r14 = null;
        int r15 = 0;
        boolean r19 = false;
    L8:
        if (r15 >= r16.length()) goto L51;
        String r110 = r16.optString(r15);
        if (TextUtils.isEmpty(r110) == false) goto L18;
        JSONObject r111 = c(r12, r13, r10, r17, r18);
        if (r111 == null) goto L15;
        r14 = r111;
    L15:
        if (r12.length() <= 0) goto L17;
        r12 = new JSONArray();
    L17:
        r13 = r5;
    L50:
        r15 = r15 + 1;
        r5 = null;
        goto L8
    L18:
        if (r19 == false) goto L22;
        if (r19 != true) goto L50;
    L31:
        if (r110.contains(" prio=") == false) goto L47;
        JSONObject r112 = c(r12, r13, r10, r17, r18);
        if (r112 == null) goto L35;
        r14 = r112;
    L35:
        String r113 = r110.substring(1, r110.indexOf(34, 1));
        if (r18 == true) goto L38;
    L41:
        StringBuilder r20 = j.d(r113, "  (");
        r20.append(r110.substring(r110.indexOf(34, 2) + 1));
        r20.append(" )");
        r13 = r20.toString();
    L43:
        if (r12.length() <= 0) goto L45;
        r12 = new JSONArray();
    L45:
        r12.put(r110);
        goto L50
    L38:
        if (JvmProtoBufUtil.DEFAULT_MODULE_NAME.equals(r113) == false) goto L41;
        r13 = r113;
        goto L43
    L47:
        if (TextUtils.isEmpty(r13) == false) goto L49;
        r11.put(r110);
        goto L50
    L49:
        r12.put(r110);
        goto L50
    L22:
        if (r110.startsWith("DALVIK THREADS") == false) goto L24;
    L29:
        r19 = true;
        goto L31
    L24:
        if (r110.startsWith("suspend") == true) goto L29;
        if (r110.startsWith("\"") == true) goto L29;
        r11.put(r110);
        goto L50
    L51:
        if (r17 == null) goto L54;
        String r21 = r17.f22799j;
        f r22 = r17.f22797h;
        r22.e("max_utm_thread", r21);
        r22.e("max_stm_thread", r17.f22800k);
        r22.e("max_utm_stm_thread", r17.f22801l);
        io.reactivex.exceptions.a.d("AnrDataCallback", "end trace: " + r17.f22801l);
        int[] r23 = r17.f22798i;
        r23[2] = 0;
        r23[1] = 0;
        r23[0] = 0;
        r17.f22799j = "unknown";
        r17.f22800k = "unknown";
        r17.f22801l = "unknown";
    L54:
        if (r10.length() <= 0) goto L56;
        JSONObject r24 = new JSONObject();
        mh.e.g(Integer.valueOf(r10.length()), "thread_all_count", r24);
        mh.e.g(r10, "thread_stacks", r24);
        f22761l = r10.length();
    L58:
        return new Pair(r14, r24);
    L56:
        r24 = null;
        goto L58
    L5:
        return new Pair(null, null);
    }

    public static String b(long r5) {
        long r10 = r5 - n.f4059c;
        if (r10 >= 30000) goto L7;
        return "0 - 30s";
    L7:
        if (r10 >= 60000) goto L11;
        return "30s - 1min";
    L11:
        if (r10 >= 120000) goto L15;
        return "1min - 2min";
    L15:
        if (r10 >= 300000) goto L19;
        return "2min - 5min";
    L19:
        if (r10 >= 600000) goto L23;
        return "5min - 10min";
    L23:
        if (r10 >= 1800000) goto L27;
        return "10min - 30min";
    L27:
        if (r10 >= 3600000) goto L30;
        return "30min - 1h";
    L30:
        return "1h - ";
    }

    public static JSONObject c(JSONArray r21, String r22, JSONArray r23, d r24, boolean r25) {
        if (r21.length() >= 0) goto L5;
    L6:
        return null;
    L5:
        if (TextUtils.isEmpty(r22) == true) goto L6;
        int[] r5 = l(r21);     // Catch: IllegalArgumentException -> L9 Throwable -> L87
    L12:
        int r14 = 0;
        long[] r10 = {-1, -1, -1};
        String r11 = "0";
        int r12 = 0;
        int r13 = 0;
    L14:
        if (r13 >= 6) goto L45;
        if (r13 >= r21.length()) goto L45;
        String r15 = r21.optString(r13);
        if (TextUtils.isEmpty(r15) == true) goto L43;
        int r16 = r15.indexOf("sysTid=");     // Catch: Exception -> L25
        if (r16 < 0) goto L27;
        int r17 = r16 + 7;
        r11 = r15.substring(r17, r15.indexOf(" ", r17));     // Catch: Exception -> L25
    L27:
        int r18 = r15.indexOf("nice=");     // Catch: Exception -> L25
        if (r18 < 0) goto L31;
        int r19 = r18 + 5;
        r12 = Integer.decode(r15.substring(r19, r15.indexOf(" ", r19))).intValue();     // Catch: Throwable -> L85
    L31:
        int r110 = r15.indexOf("state=");     // Catch: Exception -> L25
        if (r110 < 0) goto L36;
        int r111 = r110 + 6;     // Catch: Exception -> L25
        if (r15.substring(r111, r15.indexOf(" ", r111)) != "D") goto L36;
        f22762m++;     // Catch: Exception -> L25
    L36:
        int r112 = r15.indexOf("schedstat=(");     // Catch: Exception -> L25
        if (r112 < 0) goto L43;
        int r113 = r112 + 11;     // Catch: Exception -> L25
        String[] r20 = r15.substring(r113, r15.indexOf(")", r113)).trim().split(" ");     // Catch: Exception -> L25
        if (r20.length != 3) goto L43;
        r10[0] = Long.valueOf(r20[0]).longValue();     // Catch: Exception -> L25
        r10[1] = Long.valueOf(r20[1]).longValue();     // Catch: Exception -> L25
        r10[2] = Long.valueOf(r20[2]).longValue();     // Catch: Exception -> L25
    L25:
        e = move-exception;
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", e);
    L43:
        r13 = r13 + 1;
    L45:
        if (r25 == true) goto L47;
    L68:
        JSONObject r26 = new JSONObject();
        JSONArray r27 = mh.e.p(r21);
        mh.e.g(r22, "thread_name", r26);
        mh.e.g(r27, "thread_stack", r26);
        r23.put(r26);
        if (JvmProtoBufUtil.DEFAULT_MODULE_NAME.equals(r22) == true) goto L73;
        String r28 = r22.substring(0, r22.indexOf(40)).trim();     // Catch: Throwable -> L86
    L74:
        if (r24 == null) goto L83;
        m.o(n.f4057a);
        if (r5 == null) goto L78;
        int r29 = r5[0];
    L79:
        if (r5 == null) goto L81;
        int r30 = r5[1];
    L82:
        r24.b(r11, r28, r29, r30, r12, r10[0], r10[1], r10[2]);
        goto L83
    L81:
        r30 = -1;
        goto L82
    L78:
        r29 = -1;
    L83:
        return null;
    L73:
        r28 = r22;
        goto L74
    L47:
        if (JvmProtoBufUtil.DEFAULT_MODULE_NAME.equals(r22) == false) goto L68;
        if (r24 == null) goto L57;
        String r31 = String.valueOf(Process.myPid());
        m.o(n.f4057a);
        if (r5 == null) goto L52;
        int r32 = r5[0];
    L53:
        if (r5 == null) goto L55;
        int r33 = r5[1];
    L56:
        r24.b(r31, JvmProtoBufUtil.DEFAULT_MODULE_NAME, r32, r33, r12, r10[0], r10[1], r10[2]);
        goto L57
    L55:
        r33 = -1;
        goto L56
    L52:
        r32 = -1;
    L57:
        JSONObject r34 = new JSONObject();
        JSONArray r35 = mh.e.p(r21);
        mh.e.g(1, "thread_number", r34);
        StringBuilder r36 = new StringBuilder();
        StringBuilder r37 = new StringBuilder();
        f22765p = "";
    L59:
        if (r14 >= r35.length()) goto L66;
        String r38 = r35.optString(r14);
        r36.append(r38);
        r36.append('\n');
        if (r38.startsWith("  | ") == false) goto L63;
    L64:
        r37.append(r38);
        r37.append('\n');
    L65:
        r14 = r14 + 1;
        goto L59
    L63:
        if (r38.startsWith("\"main\" ") == false) goto L65;
    L66:
        f22765p = r37.toString();
        mh.e.g(r36.toString(), "mainStackFromTrace", r34);
        return r34;
    L9:
        e = move-exception;
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", e);
    L11:
        r5 = null;
        goto L12
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void e(String r40, d r41) {
        String[] r5 = r40.split("\n");
        boolean r10 = true;
        char r11 = 2;
        float[] r12 = {-1.0f, -1.0f, -1.0f};
        int r13 = r5.length;
        String r14 = "unknown";
        float r15 = 0.0f;
        int r16 = 0;
        int r17 = 0;
        char r18 = 0;
        int r19 = 0;
        boolean r110 = true;
        String r111 = "unknown";
        String r112 = r111;
        String r113 = r112;
        String r114 = r113;
        float r115 = 0.0f;
    L3:
        String r20 = "true";
        if (r17 >= r13) goto L409;
        String r21 = r5[r17];
        if (TextUtils.isEmpty(r21) == false) goto L9;
        r12 = r12;
        r16 = r16;
        int r24 = r13;
        String r25 = r14;
        r15 = r15;
        r17 = r17;
        char r22 = 3;
        boolean r23 = r10;
        char r116 = r11;
    L408:
        r17 = r17 + 1;
        r10 = r23;
        r11 = r116;
        r5 = r5;
        r13 = r24;
        r14 = r25;
        r15 = r15;
        r12 = r12;
        r16 = r16;
        goto L3
    L9:
        if (r18 == 0) goto L390;
        r24 = r13;
        if (r18 != 1) goto L13;
        r12 = r12;
        r20 = "true";
        r16 = r16;
        r25 = r14;
        r15 = r15;
        r115 = r115;
        r17 = r17;
        r18 = r18;
        r19 = r19;
        String r34 = r111;
        r114 = r114;
        r21 = r21.trim();
        String r26 = r21.toLowerCase();
        if (r26.contains("appfreeze") == false) goto L286;
        r41.f22797h.e("anr_reason", "AppFreeze");
        r18 = '\n';
        r19 = r19;
        r115 = r115;
    L280:
        r111 = r34;
        r114 = r114;
    L57:
        char r27 = 4;
        r22 = 3;
        r23 = true;
        r116 = 2;
    L406:
        if (r18 < r27) goto L408;
    L410:
        r41.f22797h.e("success_end_anrinfo", r20);
        return;
    L286:
        if (r26.startsWith("shortmsg") == false) goto L289;
        boolean r28 = false;
    L292:
        if (r26.contains("input dispatch") == false) goto L294;
    L295:
        String r29 = r34;
        if (r26.contains("waiting to send non-key event") == false) goto L332;
        if (r26.contains("finished processing certain input events that were delivered to it over") == false) goto L332;
        String r30 = "Input dispatching timed out (Waiting to send non-key event because the touched window has not finished processing certain input events that were delivered to it over xxms ago.  Wait queue length: xx.  Wait queue head age: xxms.)";
    L342:
        if (r26.contains("reason:") == true) goto L344;
    L372:
        String r31 = r30;
    L309:
        r111 = r29;
    L373:
        r41.f22797h.e("anr_reason", r31);
        if (r28 == false) goto L376;
        r19 = r19;
        r115 = r115;
        r114 = r114;
        r27 = 4;
        r22 = 3;
        r23 = true;
        r116 = 2;
        r18 = 2;
    L376:
        String r32 = r21.trim();
        if (r32.startsWith("Load:") == false) goto L388;
        String[] r33 = r32.replace("Load:", "").trim().split("/");
        r22 = 3;
        if (3 != r33.length) goto L385;
        int r35 = 0;
    L382:
        if (r35 >= r33.length) goto L384;
        r12[r35] = Float.valueOf(r33[r35]).floatValue();
        r35 = r35 + 1;
        goto L382
    L384:
        float r36 = r12[0];
        r23 = true;
        float r37 = r12[1];
        r116 = 2;
        float r38 = r12[2];
        r41.f22797h.e("load_0", String.valueOf(r36));
        r41.f22797h.e("load_1", String.valueOf(r37));
        r41.f22797h.e("load_2", String.valueOf(r38));
        Float r39 = Float.valueOf(r36);
        Float r42 = Float.valueOf(r37);
        Float r43 = Float.valueOf(r38);
        JSONArray r44 = new JSONArray();
        c r45 = r41.f22794a;
        r45.s = r44;
        r44.put(r39);
        r45.s.put(r42);
        r45.s.put(r43);
    L386:
        r18 = 3;
    L387:
        r114 = r114;
        r27 = 4;
        goto L406
    L385:
        r23 = true;
        r116 = 2;
        goto L386
    L388:
        r22 = 3;
        r23 = true;
        r116 = 2;
        r18 = r18;
        goto L387
    L344:
        if (r26.contains("no window has focus but there is a focused application") == false) goto L346;
    L370:
        r112 = "no focused window";
    L351:
        String r46 = r112;
        r41.f22797h.e("input_timeout_type", r46);
        r112 = r46;
        goto L372
    L346:
        if (r26.contains("does not have a focused window") == true) goto L370;
        if (r26.contains("waiting to send non-key event because the touched window has not finished") == false) goto L353;
        r112 = "non-key event not finished";
        goto L351
    L353:
        if (r26.contains("waiting to send key event because the focused window has not finished") == false) goto L356;
        r112 = "key event not finished";
        goto L351
    L356:
        if (r26.contains("window is paused") == false) goto L359;
        r112 = "window is paused";
        goto L351
    L359:
        if (r26.contains("window’s input channel is not registered") == false) goto L362;
        r112 = "input channel not registered";
        goto L351
    L362:
        if (r26.contains("window’s input connection is") == false) goto L365;
        r112 = "window being removed";
        goto L351
    L365:
        if (r26.contains("window’s input channel is full") == false) goto L368;
        r112 = "input channel is full";
        goto L351
    L368:
        if (r26.contains("is not responding. waited") == false) goto L351;
        r112 = "activity is not responding";
    L332:
        if (r26.contains("application does not have a focused window") == false) goto L335;
        r30 = "Input dispatching timed out (Application does not have a focused window)";
        goto L342
    L335:
        if (r26.contains("waiting because no window has focus but there is a focused") == false) goto L338;
        r30 = "Input dispatching timed out (Waiting because no window has focus but there is a focused application that may eventually add a window when it finishes starting up.)";
        goto L342
    L338:
        if (r26.contains("window's input channel is full.") == false) goto L340;
        r30 = "Input dispatching timed out (Waiting because the touched window's input channel is full.  Outbound queue length: XXX.  Wait queue length: XX.)";
        goto L342
    L340:
        r30 = "Input dispatching timed out";
        goto L342
    L294:
        if (r26.contains("keyDispatchingTimedOut") == true) goto L295;
        if (r26.contains("broadcast of intent") == false) goto L311;
        r31 = "Broadcast of Intent";
        r29 = r34;
        if ("null".equalsIgnoreCase(r29) == false) goto L309;
        r111 = r21.substring(r21.indexOf("{") + 1, r21.indexOf("}")).trim();     // Catch: Throwable -> L419
        String[] r47 = r111.split("/");     // Catch: Throwable -> L418
        if (r47.length <= 1) goto L307;
        r111 = r47[r47.length - 1];     // Catch: Throwable -> L418
    L307:
        r41.f22797h.e("anr_tag", r111);     // Catch: Throwable -> L418
        goto L373
    L311:
        r29 = r34;
        if (r26.contains("executing service") == false) goto L323;
        r31 = "executing service";
        if ("null".equalsIgnoreCase(r29) == false) goto L309;
        r111 = r21.substring(r21.indexOf("service ") + 8).trim();     // Catch: Throwable -> L419
        String[] r48 = r111.split("/");     // Catch: Throwable -> L418
        if (r48.length <= 1) goto L320;
        r111 = r48[r48.length - 1];     // Catch: Throwable -> L418
    L320:
        r41.f22797h.e("anr_tag", r111);     // Catch: Throwable -> L418
        goto L373
    L323:
        if (r26.contains("service.startforeground") == false) goto L325;
        r31 = "not call Service.startForeground";
        goto L309
    L325:
        r111 = r29;
        r31 = r25;
        goto L373
    L289:
        if (r26.startsWith("reason:") == false) goto L389;
        r28 = true;
        goto L292
    L389:
        r111 = r34;
        r22 = 3;
        r23 = true;
        r116 = 2;
    L405:
        r19 = r19;
        r111 = r111;
        r115 = r115;
        r18 = r18;
    L400:
        r114 = r114;
    L401:
        r27 = 4;
        goto L406
    L13:
        if (r18 != 2) goto L15;
        r12 = r12;
        r20 = "true";
        r16 = r16;
        r25 = r14;
        r15 = r15;
        r115 = r115;
        r17 = r17;
        r18 = r18;
        r19 = r19;
        r114 = r114;
        goto L376
    L15:
        if (r18 == 3) goto L18;
        r22 = 3;
        r25 = r14;
    L17:
        r116 = 2;
        r23 = true;
        goto L405
    L18:
        String[] r49 = r21.split("\\s");
        r25 = r14;
        if (r49.length >= 2) goto L22;
        r22 = 3;
        goto L17
    L22:
        if ("CPU".equalsIgnoreCase(r49[0]) == true) goto L24;
    L58:
        boolean r50 = r49[1].equalsIgnoreCase("TOTAL:");
        r15 = r15;
        if (r50 == false) goto L61;
    L63:
        boolean r51 = false;
    L64:
        r115 = r115;
        int r117 = 0;
    L65:
        r18 = r18;
        String r118 = "%";
        if (r49[r117].contains("%") == true) goto L71;
        r117 = r117 + 1;
        if (r117 >= r49.length) goto L71;
        r18 = r18;
    L71:
        int r119 = r117 + 1;
        r17 = r17;
        if (r119 < r49.length) goto L75;
        r12 = r12;
        r22 = 3;
        r23 = true;
    L74:
        r116 = 2;
        goto L405
    L75:
        if (r50 == false) goto L78;
        String r52 = null;
        String r53 = "TOTAL";
        r12 = r12;
    L77:
        String r54 = r113;
    L84:
        int r120 = r117 + 2;
        r34 = r111;
        float r55 = -1.0f;
        float r121 = -1.0f;
        float r122 = -1.0f;
        float r123 = -1.0f;
        float r210 = -1.0f;
    L85:
        boolean r310 = r51;
        if (r120 >= r49.length) goto L89;
        if (r49[r120].endsWith(r118) == false) goto L89;
        int r124 = r120 + 1;
        if (r124 >= r49.length) goto L89;
        String r56 = r49[r120];     // Catch: Throwable -> L129
        String r311 = r118;
        String r312 = r52;
        float r57 = Float.valueOf(r56.substring(0, r56.length() - 1)).floatValue();     // Catch: Throwable -> L412
        String r58 = r49[r124].toLowerCase();     // Catch: Throwable -> L412
        switch(r58.hashCode()) {
            case -2035663874: goto L111;
            case -1182753893: goto L108;
            case -1134867395: goto L105;
            case 104552: goto L102;
            case 3599307: goto L99;
            default: goto L113;
        };     // Catch: Throwable -> L412
    L113:
        byte r59 = -1;
    L114:
        if (r59 != 0) goto L116;
        r121 = r57;
        goto L130
    L116:
        if (r59 != 1) goto L118;
        r122 = r57;
        goto L130
    L118:
        if (r59 != 2) goto L120;
        r55 = r57;
        goto L130
    L120:
        if (r59 != 3) goto L122;
        r123 = r57;
        goto L130
    L122:
        if (r59 != 4) goto L130;
        r210 = r57;
        goto L130
    L99:
        if (r58.equals("user") == false) goto L113;
        r59 = 0;
        goto L114
    L102:
        if (r58.equals("irq") == false) goto L113;
        r59 = 3;
        goto L114
    L105:
        if (r58.equals("kernel") == false) goto L113;
        r59 = 1;
        goto L114
    L108:
        if (r58.equals("iowait") == false) goto L113;
        r59 = 2;
        goto L114
    L111:
        if (r58.equals("softirq") == false) goto L113;
        r59 = 4;
    L130:
        r120 = r120 + 3;
        r51 = r310;
        r52 = r312;
        r118 = r311;
    L129:
        r312 = r52;
        r311 = r118;
    L89:
        String r313 = r52;
        float r60 = r15;
        float r61 = r115;
    L133:
        if (r120 >= r49.length) goto L136;
        int r125 = r120 + 1;
        if (r125 >= r49.length) goto L136;
        String r126 = r49[r125].toLowerCase();     // Catch: Throwable -> L174
        int r211 = r125;
        int r127 = r126.hashCode();     // Catch: Throwable -> L173
        String r314 = r53;
        if (r127 == 103658937) goto L151;
        if (r127 == 103901109) goto L426;
    L153:
        byte r62 = -1;
    L154:
        if (r62 != 0) goto L156;
        int r128 = r19;
        String r129 = r114;
        Long r63 = Long.valueOf(r49[r120]);     // Catch: Throwable -> L413
        r49 = r49;
        float r64 = r63.longValue();     // Catch: Throwable -> L414
        if (r129.equals(r54) == false) goto L175;
        r60 = r64;
    L175:
        r49 = r49;
        r114 = r129;
        r19 = r128;
        r120 = r211;
        r53 = r314;
        goto L133
    L156:
        if (r62 != 1) goto L149;
        r128 = r19;
        float r65 = Long.valueOf(r49[r120]).longValue();     // Catch: Throwable -> L415
        r129 = r114;
        if (r129.equals(r54) == false) goto L165;
        r61 = r65;
    L165:
        r49 = r49;
    L166:
        r129 = r114;
    L167:
        r128 = r19;
    L149:
        r128 = r19;
        r129 = r114;
        goto L175
    L426:
        if (r126.equals("minor") == false) goto L153;
        r62 = 0;
        goto L154
    L151:
        if (r126.equals("major") == false) goto L153;
        r62 = 1;
    L173:
        r314 = r53;
    L174:
        r314 = r53;
        r211 = r125;
    L136:
        String r315 = r53;
        int r130 = r19;
        String r131 = r114;
        if (r50 == false) goto L193;
        String r132 = r54;
        if (r110 == false) goto L183;
        long r66 = r16;
        r114 = r131;
        r41.f22797h.e("anr_has_ago", "true");
        f r133 = r41.f22797h;
        r133.d((((r121 + r122) + r55) + r123) + r210, "cpu_total");
        r133.d(r121, "cpu_user");
        r133.d(r122, "cpu_kernel");
        r133.d(r55, "cpu_iowait");
        if (r66 <= 0) goto L182;
        float r67 = r66;
        r133.d(r60 / r67, "minor_rate");
        r133.d(r61 / r67, "major_rate");
    L182:
        c r68 = r41.f22794a;
        r68.f = r121;
        r68.g = r122;
        r68.f22777h = r55;
        r68.f22778i = r60;
        r68.f22779j = r61;
        float r134 = r60;
        r20 = "true";
        float r212 = r61;
        int r69 = r130;
        r16 = r16;
    L279:
        r19 = r69;
        r15 = r134;
        r113 = r132;
        r115 = r212;
        r18 = r18;
        goto L280
    L183:
        r114 = r131;
        if (r130 != 1) goto L190;
        long r70 = r16;
        r16 = r16;
        r41.f22797h.d((((r121 + r122) + r55) + r123) + r210, "cpu_total");
        f r71 = r41.f22797h;
        r71.d(r121, "cpu_user");
        r71.d(r122, "cpu_kernel");
        r71.d(r55, "cpu_iowait");
        if (r70 <= 0) goto L188;
        float r72 = r70;
        r71.d(r60 / r72, "minor_rate");
        r71.d(r61 / r72, "major_rate");
    L188:
        c r73 = r41.f22794a;
        r73.f = r121;
        r73.g = r122;
        r73.f22777h = r55;
        r73.f22778i = r60;
        r73.f22779j = r61;
    L189:
        r134 = r60;
        r20 = "true";
        r212 = r61;
        r69 = r130;
        goto L279
    L190:
        r16 = r16;
        if (r130 != 2) goto L189;
        c r74 = r41.f22794a;
        r74.f22780k = r121;
        r74.f22781l = r122;
        r74.f22782m = r55;
        r74.f22783n = r60;
        r74.f22784o = r61;
        goto L189
    L193:
        r132 = r54;
        r16 = r16;
        r114 = r131;
        r134 = r60;
        if (r110 == false) goto L231;
        r41.getClass();
        r212 = r61;
        float r75 = r121 + r122;
        r20 = "true";
        boolean r135 = r315.contains("kworker");
        c r136 = r41.f22794a;
        f r137 = r41.f22797h;
        if (r135 == false) goto L199;
        float r76 = r136.f22776c + r75;
        r136.f22776c = r76;
        ((d) r137.f22816a).e.put("cpu_kwork", Float.valueOf(r76));
    L223:
        int r77 = Integer.valueOf(r313).intValue();
        Float r78 = Float.valueOf(r75);
        if (r136.f22788t != null) goto L227;
        r136.f22788t = new JSONObject();
    L227:
        if (r136.f22787r != (-1)) goto L229;
        r136.f22787r = r315.equals(r136.f22785p) ? 1 : 0;
        r136.f22786q = r315;
    L229:
        mh.e.g(mh.e.g(r78, "cpu", mh.e.g(r315, "process_name", new JSONObject())), String.valueOf(r77), r136.f22788t);
    L230:
        r69 = r130;
        goto L279
    L199:
        if (r315.contains("kswapd") == false) goto L202;
        r137.d(r75, "cpu_kswapd");
        r136.f22774a = r75;
        goto L223
    L202:
        if (r315.contains("mmcqd") == false) goto L205;
        r137.d(r75, "cpu_mmcqd");
        r136.f22775b = r75;
        goto L223
    L205:
        if (r315.contains("dex2oat") == false) goto L211;
        r137.d(r75, "cpu_dex2oat");
        Integer.valueOf(r313).getClass();
        Float r79 = Float.valueOf(r75);
        if (r136.f22792x != null) goto L209;
        r136.f22792x = new JSONArray();
    L209:
        r136.f22792x.put(r79);
        goto L223
    L211:
        if (r315.contains("system_server") == false) goto L214;
        r137.d(r75, "cpu_system_server");
        r136.d = r75;
        goto L223
    L214:
        if (r315.contains("lmkd") == false) goto L216;
        r137.d(r75, "cpu_lmkd");
        r136.e = r75;
        goto L223
    L216:
        String r80 = m.f23304a;
        if (r80 != null) goto L221;
        r80 = "";
    L221:
        if (r80.equals(r315) == false) goto L223;
        r137.d(r75, "cpu_app_total");
        r137.d(r121, "cpu_app_user");
        r137.d(r122, "cpu_app_kernel");
        goto L223
    L231:
        r20 = "true";
        r212 = r61;
        if (r130 != 1) goto L270;
        if (r310 == false) goto L269;
        r41.getClass();
        float r138 = r121 + r122;
        boolean r139 = r315.contains("kworker");
        c r140 = r41.f22794a;
        f r81 = r41.f22797h;
        if (r139 == false) goto L238;
        float r82 = r140.f22776c + r138;
        r140.f22776c = r82;
        ((d) r81.f22816a).e.put("cpu_kwork", Float.valueOf(r82));
    L262:
        int r83 = Integer.valueOf(r313).intValue();
        Float r84 = Float.valueOf(r138);
        if (r140.f22789u != null) goto L266;
        r140.f22789u = new JSONObject();
    L266:
        if (r140.f22787r != (-1)) goto L268;
        r140.f22787r = r315.equals(r140.f22785p) ? 1 : 0;
        r140.f22786q = r315;
    L268:
        mh.e.g(mh.e.g(r84, "cpu", mh.e.g(r315, "process_name", new JSONObject())), String.valueOf(r83), r140.f22789u);
        goto L230
    L238:
        if (r315.contains("kswapd") == false) goto L241;
        r81.d(r138, "cpu_kswapd");
        r140.f22774a = r138;
        goto L262
    L241:
        if (r315.contains("mmcqd") == false) goto L244;
        r81.d(r138, "cpu_mmcqd");
        r140.f22775b = r138;
        goto L262
    L244:
        if (r315.contains("dex2oat") == false) goto L250;
        r81.d(r138, "cpu_dex2oat");
        Integer.valueOf(r313).getClass();
        Float r85 = Float.valueOf(r138);
        if (r140.f22792x != null) goto L248;
        r140.f22792x = new JSONArray();
    L248:
        r140.f22792x.put(r85);
        goto L262
    L250:
        if (r315.contains("system_server") == false) goto L253;
        r81.d(r138, "cpu_system_server");
        r140.d = r138;
        goto L262
    L253:
        if (r315.contains("lmkd") == false) goto L255;
        r81.d(r138, "cpu_lmkd");
        r140.e = r138;
        goto L262
    L255:
        String r86 = m.f23304a;
        if (r86 != null) goto L260;
        r86 = "";
    L260:
        if (r86.equals(r315) == false) goto L262;
        r81.d(r138, "cpu_app_total");
        r81.d(r121, "cpu_app_user");
        r81.d(r122, "cpu_app_kernel");
        goto L262
    L269:
        r41.getClass();
        goto L230
    L270:
        r69 = r130;
        if (r69 != 2) goto L279;
        if (r310 == false) goto L278;
        c r87 = r41.f22794a;
        int r88 = Integer.valueOf(r313).intValue();
        Float r89 = Float.valueOf(r121 + r122);
        if (r87.f22790v != null) goto L434;
        r87.f22790v = new JSONObject();
    L434:
        r87.f22790v.put(String.valueOf(r88), new JSONObject().put("process_name", r315).put("cpu", r89));     // Catch: JSONException -> L417
        goto L279
    L278:
        r41.getClass();
        goto L279
    L78:
        String r141 = r49[r119];
        r12 = r12;
        String[] r90 = r141.substring(0, r141.length() - 1).split("/");
        if (r90.length > 1) goto L81;
        io.reactivex.exceptions.a.e(NotificationCompat.CATEGORY_ERROR, "err cmdLine: ".concat(r21));
        r23 = true;
        r22 = 3;
        goto L74
    L81:
        r52 = r90[0];
        r53 = r90[1];
        if (r51 == false) goto L77;
        r54 = r53;
        goto L84
    L61:
        if (r21.charAt(2) == ' ') goto L63;
        r51 = true;
        goto L64
    L24:
        if ("usage".equalsIgnoreCase(r49[1]) == false) goto L58;
        r19 = r19 + 1;
        if (r21.contains("ago") == false) goto L29;
        r110 = true;
    L32:
        if (r49.length >= 6) goto L34;
    L40:
        int r91 = 0;
    L42:
        if (r49.length >= 12) goto L44;
    L56:
        r12 = r12;
        r20 = "true";
        r16 = r16;
        r15 = r15;
        r17 = r17;
        goto L57
    L44:
        if (r49[7].contains("(") == false) goto L56;
        if (r49[11].contains(")") == false) goto L56;
        if (f22763n != 0) goto L56;
        StringBuilder r92 = new StringBuilder();
        String r93 = r49[7];
        r92.append(r93.substring(1, r93.length()));
        r92.append(" ");
        r92.append(r49[8]);
        long r94 = p.e().parse(r92.toString()).getTime();     // Catch: Throwable -> L55
        f22763n = r94;     // Catch: Throwable -> L55
        if (r110 == false) goto L53;
        f22763n = r94 + ((long) r91);     // Catch: Throwable -> L55
        goto L56
    L53:
        f22763n = r94 - ((long) r91);     // Catch: Throwable -> L55
    L55:
        f22763n = 0;
        goto L56
    L34:
        if (r49[3].contains("ms") == false) goto L40;
        if (r49[5].contains("ms") == false) goto L40;
        r91 = Integer.valueOf(r49[3].replace("ms", "")).intValue();     // Catch: Throwable -> L39
        r16 = Math.abs(Integer.valueOf(r49[5].replace("ms", "")).intValue() - r91);     // Catch: Throwable -> L39
    L39:
        r91 = 0;
        r16 = 0;
        goto L42
    L29:
        if (r21.contains("later") == false) goto L32;
        r110 = false;
        goto L32
    L390:
        r12 = r12;
        r20 = "true";
        r16 = r16;
        r24 = r13;
        r25 = r14;
        r15 = r15;
        r115 = r115;
        r17 = r17;
        r18 = r18;
        r19 = r19;
        r111 = r111;
        r114 = r114;
        r22 = 3;
        r23 = true;
        r116 = 2;
        String r95 = r21.trim();
        if (r95.startsWith("tag:") == false) goto L402;
        r111 = r95.replace("tag:", "").trim();
        r41.f22797h.e("anr_tag", r111);
        if (r111 == null) goto L399;
        int r96 = r111.indexOf("/");     // Catch: Throwable -> L421
        StringBuilder r97 = new StringBuilder();     // Catch: Throwable -> L421
        r97.append(r111.substring(0, r96));     // Catch: Throwable -> L420
        r97.append(r111.substring(r96 + 1));     // Catch: Throwable -> L420
        r41.g = r97.toString();     // Catch: Throwable -> L420
    L399:
        r19 = r19;
        r18 = 1;
        r115 = r115;
        goto L400
    L402:
        String r98 = r95.trim();
        if (r98.startsWith("processName:") == false) goto L405;
        r114 = r98.replace("processName:", "").trim();
        r19 = r19;
        r111 = r111;
        r115 = r115;
        r18 = r18;
        goto L401
    L409:
        r20 = "true";
        goto L410
    }

    public static void f(String r5, z8.c r10) {
        g0 r11 = com.bytedance.crash.p.f;
        ListMap r12 = (ListMap) r11.f209a;
        monitor-enter(r12);
        List r13 = ((ListMap) r11.f209a).a(CrashType.ANR);     // Catch: Throwable -> L32
        monitor-exit(r12);     // Catch: Throwable -> L32
        if (r13.size() <= 0) goto L16;
        Iterator r14 = r13.iterator();
    L10:
        if (r14.hasNext() == false) goto L16;
        ICrashCallback r15 = (ICrashCallback) r14.next();
        r15.onCrash(CrashType.ANR, r5, null);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
    L16:
        CopyOnWriteArrayList r16 = (CopyOnWriteArrayList) com.bytedance.crash.p.f.g;
        if (r16.size() <= 0) goto L31;
        JSONObject r17 = new JSONObject();
        r17.put("all_thread_stacks", r10.f23416a.opt("all_thread_stacks"));     // Catch: Throwable -> L35
        r17.put("data", r10.f23416a.optString("data"));     // Catch: Throwable -> L35
        r17.toString();     // Catch: Throwable -> L35
    L20:
        Iterator r18 = r16.iterator();
    L22:
        if (r18.hasNext() == false) goto L51;
        if (r18.next() != null) goto L30;
        throw null;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
        goto L22
    L30:
        throw new ClassCastException();
    L51:
        return;
    L31:
        return;
    L32:
        th = move-exception;
        throw th;
    }

    public static boolean h() {
        if (n.f4057a != null) goto L5;
        boolean r5 = m9.c.e().f20047r;
    L6:
        boolean r10 = !r5;
        if (r5 == true) goto L12;
        m9.c r11 = m9.c.e();
        r11.getClass();
        if ((SystemClock.uptimeMillis() - r11.s) > 2000) goto L12;
        return false;
    L12:
        return r10;
    L5:
        r5 = m9.c.e().f20047r;
        goto L6
    }

    public static long[] i(JSONArray r11) {
        long r5 = 0;
        long[] r10 = {0, 0};
        if (r11 == null) goto L14;
        int r12 = 0;
        int r13 = 0;
        long r14 = 0;
    L16:
        if (r12 >= r11.length()) goto L12;
        if (r11.getJSONObject(r12).getInt("type") != 8) goto L11;
        r14 = r14 + ((long) r11.getJSONObject(r12).getInt("cpuDuration"));     // Catch: Throwable -> L15
        r5 = r5 + ((long) r11.getJSONObject(r12).getInt("duration"));     // Catch: Throwable -> L15
        r13 = r13 + 1;     // Catch: Throwable -> L15
    L11:
        r12 = r12 + 1;     // Catch: Throwable -> L15
        goto L16
    L12:
        if (r13 <= 0) goto L14;
        long r15 = r13;
        r10[0] = r14 / r15;     // Catch: Throwable -> L15
        r10[1] = r5 / r15;     // Catch: Throwable -> L15
    L14:
        return r10;
    }

    public static int[] l(JSONArray r5) {
        int r10 = 0;
    L4:
        if (r10 >= r5.length()) goto L32;
        String r11 = r5.optString(r10);
        if (r11 != null) goto L8;
    L10:
        int r12 = -1;
    L11:
        if (r12 > 0) goto L13;
        r10 = r10 + 1;
        goto L4
    L13:
        if (f22764o != null) goto L15;
        f22764o = Pattern.compile("[^0-9]+");
    L15:
        String[] r13 = f22764o.split(r11.substring(r12));
        if (r13 != null) goto L18;
        return null;
    L18:
        if (r13.length >= 2) goto L27;
        return null;
    L27:
        int r14 = Integer.decode(r13[1]).intValue();     // Catch: Throwable -> L22
        int r15 = Integer.decode(r13[2]).intValue();     // Catch: Throwable -> L22
        return new int[]{r14, r15, r14 + r15};
    L23:
        throw new IllegalArgumentException("Err stack line: ".concat(r11));
    L8:
        if (r11.isEmpty() == true) goto L10;
        r12 = r11.indexOf("utm=");
        goto L11
    L32:
        return null;
    }

    public final void d(long r10, JSONArray r11) {
        if (r11 == null) goto L5;
    L18:
        a r5 = this.f22772j;
        r5.f22759k = true;
        if (r11 == null) goto L48;
        r5.f22755c = r11;     // Catch: Throwable -> L38
        r5.e = System.currentTimeMillis();     // Catch: Throwable -> L38
        a r12 = this.f22772j;     // Catch: Throwable -> L38
        this.d = r12.e;     // Catch: Throwable -> L38
        if (r12.g != null) goto L24;
        r12.f22754b = a.a.f();     // Catch: Throwable -> L38
        this.f22772j.g = a.a.p();     // Catch: Throwable -> L38
        this.f22772j.f = a.a.e(r10);     // Catch: Throwable -> L38
    L24:
        this.f22772j.f22756h = new JSONObject();     // Catch: Throwable -> L38
        m.g(this.f22768b, this.f22772j.f22756h);     // Catch: Throwable -> L38
        this.f22772j.f22757i = h();     // Catch: Throwable -> L38
        this.f = !com.bytedance.crash.p.e();     // Catch: Throwable -> L38
    L44:
        Pair r13 = a(this.f22772j.f22755c, this.f22770h, true);     // Catch: Throwable -> L39
        a r14 = this.f22772j;     // Catch: Throwable -> L39
        r14.f22753a = (JSONObject) r13.first;     // Catch: Throwable -> L39
        r14.d = (JSONObject) r13.second;     // Catch: Throwable -> L39
    L26:
        a r15 = this.f22772j;
        if (r15.f22753a == null) goto L42;
    L33:
        a r16 = this.f22772j;
        if (r16.d != null) goto L36;
        r16.d = com.bytedance.crash.util.h.d(null);
    L36:
        File r17 = com.bytedance.crash.util.g.f(n.f4057a);
        r17.mkdirs();
        a.a.h(r17);
        return;
    L42:
        JSONObject r18 = p.g(com.bytedance.crash.util.h.c(Looper.getMainLooper().getThread().getStackTrace()));     // Catch: Throwable -> L30
    L32:
        r15.f22753a = r18;
    L30:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
        r18 = null;
        goto L32
    L48:
        return;
    L5:
        if (this.f22772j.f22759k == true) goto L18;
        NativeTools r19 = NativeTools.f4167b;
        if (Header.i() == true) goto L17;
        File r20 = com.bytedance.crash.util.g.a();
        com.bytedance.android.anniex.base.service.e.l("anr_trace", r20.getParentFile().getName());
        long r21 = SystemClock.uptimeMillis();
        if (NativeTools.k().i(r20.getAbsolutePath()) == false) goto L11;
        this.f22772j.f22758j = SystemClock.uptimeMillis() - r21;
    L11:
        com.bytedance.android.anniex.base.service.e.l("after_trace", r20.getParentFile().getName());
        r11 = cl.a.F(r20.getAbsolutePath());     // Catch: Throwable -> L14 IOException -> L16
    L16:
        r11 = new JSONArray();
    L14:
        th = move-exception;
        JSONArray r22 = new JSONArray();
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
        r11 = r22;
        goto L18
    L17:
        r11 = new JSONArray();
        goto L18
    }

    public final void g(JSONArray r20, long r21) {
        boolean r5 = z5.a.e();
        long r10 = SystemClock.uptimeMillis();
        if (r20 == null) goto L16;
        a r14 = this.f22772j;
        r14.f22760l = true;
        if (r21 < 0) goto L7;
        r14.f22758j = r21;
    L7:
        d(r10, r20);
        if (mh.e.c(l9.c.e(), -1, new String[]{"custom_event_settings", "npth_simple_setting", "enable_background_killed_anr"}) == 1) goto L14;
        boolean r11 = m9.c.e().f20047r;
        boolean r12 = !r11;
        if (r11 == true) goto L15;
        m9.c r13 = m9.c.e();
        r13.getClass();
        if ((SystemClock.uptimeMillis() - r13.s) <= 2000) goto L14;
    L15:
        boolean r15 = !r12;
    L17:
        String r16 = p.d(this.f22768b, null);
        String r17 = "normal";
        if (TextUtils.isEmpty(r16) == false) goto L21;
        if (r15 == false) goto L21;
        boolean r18 = true;
    L23:
        if (r15 == false) goto L25;
    L28:
        Object r19 = this.g;
        monitor-enter(r19);
        monitor-exit(r19);     // Catch: Throwable -> L224
        if (this.f22772j.f22759k == true) goto L34;
    L43:
        a r22 = this.f22772j;
        if (r22.f22759k == false) goto L46;
        r22.a();
    L46:
        d(r10, null);
        io.reactivex.exceptions.a.l("found ANR without signal");
    L47:
        a r23 = this.f22772j;
        if (r18 == true) goto L50;
        this.f22772j = new a();
    L50:
        String r110 = r17;
        a r111 = r23;
        String r24 = r110;
    L51:
        if (r18 == false) goto L53;
    L73:
        if (r111 == null) goto L254;
        r111.f22753a.put(LynxMonitorService.KEY_PID, Process.myPid());     // Catch: Throwable -> L77
        r111.f22753a.put("package", this.f22768b.getPackageName());     // Catch: Throwable -> L77
        r111.f22753a.put("is_remote_process", 0);     // Catch: Throwable -> L77
        r111.f22753a.put("is_new_stack", 10);     // Catch: Throwable -> L77
        JSONObject r25 = new JSONObject();     // Catch: Throwable -> L77
        z8.c r26 = new z8.c(r25);     // Catch: Throwable -> L77
        mh.e.g(r111.f22753a.toString(), "data", r25);     // Catch: Throwable -> L77
        mh.e.g(1, "is_anr", r25);     // Catch: Throwable -> L77
        mh.e.g(r24, "anrType", r25);     // Catch: Throwable -> L77
        mh.e.g(r111.g, "history_message", r25);     // Catch: Throwable -> L77
        mh.e.g(r111.f22754b, "current_message", r25);     // Catch: Throwable -> L77
        mh.e.g(r111.f, "pending_messages", r25);     // Catch: Throwable -> L77
        mh.e.g(Long.valueOf(System.currentTimeMillis()), "anr_time", r25);     // Catch: Throwable -> L77
        mh.e.g(Long.valueOf(r111.e), "crash_time", r25);     // Catch: Throwable -> L77
        mh.e.g(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(r111.e)), "crash_time_readable", r25);     // Catch: Throwable -> L77
        z8.c.n(r25, r111.f22756h);     // Catch: Throwable -> L77
        if (r18 == false) goto L79;
        String r112 = "invalid";
    L80:
        mh.e.g(r112, "anr_info", r25);     // Catch: Throwable -> L77
        if (r18 == true) goto L87;
        JSONObject r113 = r111.d;     // Catch: Throwable -> L77
        if (r113 != null) goto L85;
    L86:
        JSONObject r114 = com.bytedance.crash.util.h.d(null);     // Catch: Throwable -> L77
    L88:
        mh.e.g(r114, "all_thread_stacks", r25);     // Catch: Throwable -> L77
        l r27 = l.f();     // Catch: Throwable -> L77
        CrashType r28 = CrashType.ANR;     // Catch: Throwable -> L77
        z8.c r29 = r27.g(r28, r26, null, false);     // Catch: Throwable -> L77
        mh.e.g(Boolean.valueOf(r111.f22757i), "is_background", r29.f23416a);     // Catch: Throwable -> L77
        mh.e.g(p.f(com.bytedance.crash.util.g.c(n.f4057a, n.f())), "logcat", r29.f23416a);     // Catch: Throwable -> L77
        mh.e.g("true", "has_dump", r29.f23416a);     // Catch: Throwable -> L77
        z8.c.l(r29.b(), "custom", "npth_trace_cost", String.valueOf(r111.f22758j));     // Catch: Throwable -> L77
        long r115 = this.f22771i;     // Catch: Throwable -> L77
        if (r115 <= 0) goto L91;
        z8.c.l(r29.b(), "custom", "last_anr_interval", String.valueOf(r10 - r115));     // Catch: Throwable -> L77
    L92:
        mh.e.g(n.b(r111.e, r28, false, false), "crash_uuid", r29.f23416a);     // Catch: Throwable -> L77
        mh.e.g(Long.valueOf(i.b()), "jiffy", r29.f23416a);     // Catch: Throwable -> L77
        JSONObject r30 = r29.f23416a.optJSONObject("filters");     // Catch: Throwable -> L77
        if (r30 != null) goto L95;
        r30 = new JSONObject();     // Catch: Throwable -> L77
        mh.e.g(r30, "filters", r29.f23416a);     // Catch: Throwable -> L77
    L95:
        JSONObject r31 = r30;
        i.a.m(r29.f23416a);     // Catch: Throwable -> L77
        r31.put("anrType", r24);     // Catch: Throwable -> L227
        r31.put("crash_length", b(r111.e));     // Catch: Throwable -> L227
        r31.put("disable_looper_monitor", String.valueOf(l9.c.b()));     // Catch: Throwable -> L227
        r31.put(WsConstants.KEY_SDK_VERSION, "3.1.7-rc.89");     // Catch: Throwable -> L227
        long r116 = i.j(n.f());     // Catch: Throwable -> L227
        if (NativeTools.k().E() == false) goto L100;
        long r117 = Long.MAX_VALUE;
    L104:
        if (r116 <= r117) goto L106;
        boolean r32 = true;
    L107:
        r31.put("memory_leak", String.valueOf(r32));     // Catch: Throwable -> L227
        if (i.a(n.f()) <= 960) goto L110;
        boolean r33 = true;
    L111:
        r31.put("fd_leak", String.valueOf(r33));     // Catch: Throwable -> L227
        if (i.l(n.f()) <= 350) goto L114;
        boolean r34 = true;
    L115:
        r31.put("threads_leak", String.valueOf(r34));     // Catch: Throwable -> L227
        r31.put("is_64_devices", String.valueOf(Header.h()));     // Catch: Throwable -> L227
        r31.put("is_64_runtime", String.valueOf(NativeTools.k().E()));     // Catch: Throwable -> L227
        r31.put("is_x86_devices", String.valueOf(Header.i()));     // Catch: Throwable -> L227
        if (s6.c.j() == false) goto L118;
        String r35 = "true";
    L119:
        r31.put("is_root", r35);     // Catch: Throwable -> L227
        r31.put("anr_no_run", String.valueOf(r5));     // Catch: Throwable -> L227
        if (com.bytedance.crash.p.e() == false) goto L122;
        String r36 = "true";
    L123:
        r31.put("crash_after_crash", r36);     // Catch: Throwable -> L227
        r31.put("from_file", String.valueOf(p.f23511i));     // Catch: Throwable -> L227
        r31.put("has_dump", "true");     // Catch: Throwable -> L227
        r31.put("from_kill", String.valueOf(r18));     // Catch: Throwable -> L227
        r31.put("last_resume_activity", String.valueOf(m9.c.e().f20040k));     // Catch: Throwable -> L227
        r31.put("start_uuid", n.f());     // Catch: Throwable -> L227
        long r37 = r111.f22758j;     // Catch: Throwable -> L227
        if (r37 >= 100) goto L127;
        String r38 = "0 - 100ms";
    L142:
        r31.put("npth_trace_cost", r38);     // Catch: Throwable -> L227
        if (r18 == true) goto L149;
        e(r16, this.f22770h);     // Catch: Throwable -> L146
    L152:
        r29.h("use_time", (r111.e - n.f4059c) / 1000);     // Catch: Throwable -> L227
        r29.h("dstate_count", f22762m);     // Catch: Throwable -> L227
        r29.h("thread_all_count", f22761l);     // Catch: Throwable -> L227
        long[] r39 = i(r111.g);     // Catch: Throwable -> L227
        r29.h("history_message_cpu_avg", r39[0]);     // Catch: Throwable -> L227
        r29.h("history_message_wall_avg", r39[1]);     // Catch: Throwable -> L227
        r111.f22756h.optJSONObject("sys_memory_info");     // Catch: Throwable -> L227
        goto L153
    L146:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();     // Catch: Throwable -> L227
        m.b.h("NPTH_CATCH", th);     // Catch: Throwable -> L227
        goto L152
    L149:
        if (mh.e.c(l9.c.e(), -1, new String[]{"custom_event_settings", "npth_simple_setting", "enable_killed_anr"}) == 1) goto L152;
        r31.put(WsConstants.KEY_APP_ID, String.valueOf(r29.o().f4029a.opt(WsConstants.KEY_APP_ID)));     // Catch: Throwable -> L227
        r29.o().f4029a.put(WsConstants.KEY_APP_ID, 2010);     // Catch: Throwable -> L227
        goto L152
    L127:
        if (r37 >= 500) goto L130;
        r38 = "100mss - 500ms";
        goto L142
    L130:
        if (r37 >= 1000) goto L133;
        r38 = "500ms - 1s";
        goto L142
    L133:
        if (r37 >= 5000) goto L136;
        r38 = "1s - 5s";
        goto L142
    L136:
        if (r37 >= 10000) goto L139;
        r38 = "5s - 10s";
        goto L142
    L139:
        if (r37 >= 20000) goto L141;
        r38 = "10s - 20s";
        goto L142
    L141:
        r38 = "20s - ";
        goto L142
    L122:
        r36 = "false";
        goto L123
    L118:
        r35 = "false";
        goto L119
    L114:
        r34 = false;
        goto L115
    L110:
        r33 = false;
        goto L111
    L106:
        r32 = false;
        goto L107
    L100:
        if (Header.h() == false) goto L102;
        r117 = 3891200;
        goto L104
    L102:
        r117 = 2867200;
    L153:
        JSONObject r40 = r29.f23416a.optJSONObject("features_num");     // Catch: Throwable -> L77
        JSONObject r41 = r29.f23416a.optJSONObject("features_str");     // Catch: Throwable -> L77
        if (r40 != null) goto L156;
        r40 = new JSONObject();     // Catch: Throwable -> L77
        mh.e.g(r40, "features_num", r29.f23416a);     // Catch: Throwable -> L77
    L156:
        if (r41 != null) goto L158;
        r41 = new JSONObject();     // Catch: Throwable -> L77
        mh.e.g(r41, "features_str", r29.f23416a);     // Catch: Throwable -> L77
    L158:
        if (r18 == false) goto L172;
        Iterator r42 = this.f22770h.f22795b.entrySet().iterator();     // Catch: Throwable -> L77
    L161:
        if (r42.hasNext() == false) goto L163;
        Map.Entry r43 = (Map.Entry) r42.next();     // Catch: Throwable -> L77
        mh.e.g(r43.getValue(), (String) r43.getKey(), r31);     // Catch: Throwable -> L77
        goto L161
    L163:
        this.f22770h.c(r40);     // Catch: Throwable -> L77
        Iterator r44 = this.f22770h.f22796c.entrySet().iterator();     // Catch: Throwable -> L77
    L165:
        if (r44.hasNext() == false) goto L167;
        Map.Entry r45 = (Map.Entry) r44.next();     // Catch: Throwable -> L77
        mh.e.g(r45.getValue(), (String) r45.getKey(), r41);     // Catch: Throwable -> L77
        goto L165
    L167:
        d r46 = this.f22770h;     // Catch: Throwable -> L77
        JSONObject r47 = r29.f23416a;     // Catch: Throwable -> L77
        Iterator r48 = r46.f.entrySet().iterator();     // Catch: Throwable -> L77
    L169:
        if (r48.hasNext() == false) goto L171;
        Map.Entry r49 = (Map.Entry) r48.next();     // Catch: Throwable -> L77
        mh.e.g(r49.getValue(), (String) r49.getKey(), r47);     // Catch: Throwable -> L77
        goto L169
    L171:
        String r50 = n.f4062j.getJavaCrashUploadUrl();     // Catch: Throwable -> L77
        File r51 = new File(new File(com.bytedance.crash.util.g.h(this.f22768b), x8.a.f22983b), n.b(r111.e, CrashType.ANR, false, false));     // Catch: Throwable -> L77
        this.e = r51;     // Catch: Throwable -> L77
        cl.a.m(r51, r51.getName(), r50, r29.f23416a);     // Catch: Throwable -> L77
        return;
    L172:
        this.f22770h.getClass();     // Catch: Throwable -> L77
        this.f22771i = SystemClock.uptimeMillis();     // Catch: Throwable -> L77
        String r52 = this.f22770h.f22794a.f22786q;     // Catch: Throwable -> L77
        if (r52 != null) goto L176;
        r52 = "";
    L176:
        z8.c.l(r29.f23416a, "features_str", "top_cpu_process_name", r52);     // Catch: Throwable -> L77
        mh.e.g(this.f22770h.a(), "anr_atribute", r29.f23416a);     // Catch: Throwable -> L77
        Iterator r53 = this.f22770h.f22795b.entrySet().iterator();     // Catch: Throwable -> L77
    L178:
        if (r53.hasNext() == false) goto L180;
        Map.Entry r54 = (Map.Entry) r53.next();     // Catch: Throwable -> L77
        mh.e.g(r54.getValue(), (String) r54.getKey(), r31);     // Catch: Throwable -> L77
        goto L178
    L180:
        this.f22770h.c(r40);     // Catch: Throwable -> L77
        Iterator r55 = this.f22770h.f22796c.entrySet().iterator();     // Catch: Throwable -> L77
    L182:
        if (r55.hasNext() == false) goto L184;
        Map.Entry r56 = (Map.Entry) r55.next();     // Catch: Throwable -> L77
        mh.e.g(r56.getValue(), (String) r56.getKey(), r41);     // Catch: Throwable -> L77
        goto L182
    L184:
        d r57 = this.f22770h;     // Catch: Throwable -> L77
        JSONObject r58 = r29.f23416a;     // Catch: Throwable -> L77
        Iterator r59 = r57.f.entrySet().iterator();     // Catch: Throwable -> L77
    L186:
        if (r59.hasNext() == false) goto L188;
        Map.Entry r60 = (Map.Entry) r59.next();     // Catch: Throwable -> L77
        mh.e.g(r60.getValue(), (String) r60.getKey(), r58);     // Catch: Throwable -> L77
        goto L186
    L188:
        File r61 = this.e;     // Catch: Throwable -> L77
        if (r61 == null) goto L191;
        cl.a.C(r61);     // Catch: Throwable -> L77
        this.e = null;     // Catch: Throwable -> L77
    L191:
        mh.e.c(l9.c.e(), -1, new String[]{"custom_event_settings", "npth_simple_setting", "disable_force_anr_block"});     // Catch: Throwable -> L77
        v8.a.d().getClass();     // Catch: Throwable -> L77
        ArrayList r62 = v8.a.d().c(r111.e, m.o(this.f22768b));     // Catch: Throwable -> L77
        if (r62 == null) goto L232;
        JSONArray r63 = new JSONArray();     // Catch: Throwable -> L77
        Iterator r64 = r62.iterator();     // Catch: Throwable -> L77
    L196:
        if (r64.hasNext() == false) goto L198;
        r63.put((String) r64.next());     // Catch: Throwable -> L77
        goto L196
    L198:
        JSONObject r65 = r29.f23416a.optJSONObject("custom_long");     // Catch: Throwable -> L77
        if (r65 != null) goto L201;
        r65 = new JSONObject();     // Catch: Throwable -> L77
        mh.e.g(r65, "custom_long", r29.f23416a);     // Catch: Throwable -> L77
    L201:
        mh.e.g(r63, "alogFiles", r65);     // Catch: Throwable -> L77
    L232:
        if (a.a.l(com.bytedance.crash.util.g.f(this.f22768b)).length() <= RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE) goto L230;
        z8.c.l(r29.b(), "filters", "has_system_traces", "true");     // Catch: Throwable -> L228
    L230:
        JSONArray r66 = i.h(new File(com.bytedance.crash.util.g.c(n.f4057a, n.f()), "pthreads.txt"), new File(com.bytedance.crash.util.g.c(n.f4057a, n.f()), "rountines.txt"));     // Catch: Throwable -> L229
        r31.put("leak_threads_count", String.valueOf(r66.length()));     // Catch: Throwable -> L229
        if (r66.length() <= 0) goto L235;
        cl.a.p(new File(com.bytedance.crash.util.g.c(n.f4057a, n.f()), "leakd_threads.txt"), r66);     // Catch: Throwable -> L229
    L235:
        i.i(com.bytedance.crash.util.g.f(this.f22768b), new File(com.bytedance.crash.util.g.c(n.f4057a, n.f()), "fds.txt"));     // Catch: Throwable -> L211
    L214:
        r111.f22753a.optString("mainStackFromTrace");     // Catch: Throwable -> L77
        ConcurrentLinkedQueue r67 = z8.d.f23418a;     // Catch: Throwable -> L77
        JSONArray r68 = new JSONArray();     // Catch: Throwable -> L77
        f(r16, r29);     // Catch: Throwable -> L77
        com.bytedance.crash.upload.b.l(r29.f23416a, r68, new com.bytedance.ies.bullet.service.popup.ui.c(this, r111.e, r62));     // Catch: Throwable -> L77
        JSONObject r69 = new JSONObject();     // Catch: Throwable -> L77
        JSONObject r70 = new JSONObject();     // Catch: Throwable -> L77
        if (r111.f22760l == false) goto L217;
        mh.e.g(IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST, "from_signal", r69);     // Catch: Throwable -> L77
    L217:
        long r71 = r111.f22758j;     // Catch: Throwable -> L77
        if (r71 < 0) goto L220;
        mh.e.g(Long.valueOf(r71), "trace_cost", r70);     // Catch: Throwable -> L77
    L220:
        l9.n.b("anr_event", r69, r70);     // Catch: Throwable -> L77
        return;
    L211:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();     // Catch: Throwable -> L77
        m.b.h("NPTH_CATCH", th);     // Catch: Throwable -> L77
        goto L214
    L91:
        z8.c.l(r29.b(), "custom", "last_anr_interval", "none");     // Catch: Throwable -> L77
        goto L92
    L85:
        if (r113.length() == 0) goto L86;
    L87:
        r114 = r111.d;     // Catch: Throwable -> L77
        goto L88
    L79:
        r112 = r16;
    L77:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
        return;
    L254:
        return;
    L53:
        if (TextUtils.isEmpty(r16) == false) goto L73;
        if (this.f22772j.f22753a == null) goto L63;
        if ((System.currentTimeMillis() - this.d) <= 35000) goto L63;
        this.f22772j.a();
        d r72 = this.f22770h;
        r72.f22795b.clear();
        r72.f22796c.clear();
        r72.d.clear();
        r72.e.clear();
        File r73 = this.e;
        if (r73 == null) goto L250;
        cl.a.C(r73);
        this.e = null;
        return;
    L250:
        return;
    L63:
        if (this.f22772j.f22753a != null) goto L65;
        return;
    L65:
        if ((System.currentTimeMillis() - this.d) > 2000) goto L67;
        return;
    L67:
        if (NativeTools.k().y() == true) goto L69;
        return;
    L69:
        if (this.f22773k != null) goto L71;
        this.f22773k = new File(this.f22768b.getFilesDir(), x8.a.f22996t + m.o(this.f22768b).replaceAll(":", "_"));
    L71:
        cl.a.C(this.f22773k);
        return;
    L34:
        if ((System.currentTimeMillis() - this.d) > 35000) goto L43;
        if (r18 == false) goto L38;
        String r74 = "trace_only";
    L37:
        r17 = r74;
        if (r18 == false) goto L41;
        String r75 = "found foreground ANR signal";
    L42:
        io.reactivex.exceptions.a.l(r75);
        goto L47
    L41:
        r75 = "found ANR with signal";
        goto L42
    L38:
        r74 = "trace_last";
    L224:
        th = move-exception;
        throw th;
    L25:
        if (TextUtils.isEmpty(r16) == false) goto L28;
        r24 = "normal";
        r111 = null;
    L21:
        r18 = false;
    L14:
        r12 = false;
        goto L15
    L16:
        r15 = false;
        goto L17
    }

    public final void j() {
        Context r5 = this.f22768b;
        if (NativeTools.k().y() == true) goto L17;
    L12:
        this.f22772j.a();
        long r10 = SystemClock.uptimeMillis();
        a r11 = this.f22772j;
        if (r11.g != null) goto L19;
        r11.f22754b = a.a.f();
        this.f22772j.g = a.a.p();
        this.f22772j.f = a.a.e(r10);
        return;
    L19:
        return;
    L17:
    L7:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
        goto L12
    L5:
        if (this.f22773k != null) goto L9;
        this.f22773k = new File(r5.getFilesDir(), x8.a.f22996t + m.o(r5).replaceAll(":", "_"));     // Catch: Throwable -> L7
    L9:
        cl.a.u(String.valueOf(1), this.f22773k, false);     // Catch: Throwable -> L7
        goto L12
    }

    public final void k(long r5, JSONArray r10) {
        monitor-enter(b.class);     // Catch: Throwable -> L21
    L52:
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L6:
        if (f22766q == false) goto L10;
        b.class.wait();     // Catch: Throwable -> L44
        goto L52
    L10:
        f22766q = true;     // Catch: Throwable -> L23
        monitor-exit(b.class);     // Catch: Throwable -> L23
        g(r10, r5);     // Catch: Throwable -> L21
        monitor-enter(b.class);
        f22766q = false;     // Catch: Throwable -> L18
        b.class.notifyAll();     // Catch: Throwable -> L18
        monitor-exit(b.class);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    L21:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();     // Catch: Throwable -> L35
        m.b.h("NPTH_CATCH", th);     // Catch: Throwable -> L35
        monitor-enter(b.class);
        f22766q = false;     // Catch: Throwable -> L32
        b.class.notifyAll();     // Catch: Throwable -> L32
        return;
    L32:
        th = move-exception;
        throw th;
    L35:
        th = move-exception;
        monitor-enter(b.class);
        f22766q = false;     // Catch: Throwable -> L41
        b.class.notifyAll();     // Catch: Throwable -> L41
        throw th;
    L41:
        th = move-exception;
        throw th;
    }
}
