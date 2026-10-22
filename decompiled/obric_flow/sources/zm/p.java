package zm;

import android.app.ActivityManager;
import android.app.Application;
import android.app.ApplicationExitInfo;
import android.content.Context;
import android.graphics.Color;
import android.os.Process;
import android.os.SystemClock;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.app.NotificationCompat;
import androidx.room.writer.DaoWriter;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.util.ListMap;
import com.bytedance.crash.util.NativeTools;
import com.bytedance.geckox.GeckoGlobalConfig;
import com.lynx.jsbridge.LynxResourceModule;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SimpleDateFormat f23507a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static SimpleDateFormat f23508b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static SimpleDateFormat f23509c = null;
    public static SimpleDateFormat d = null;
    public static ListMap e = null;
    public static boolean f = false;
    public static String g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static long f23510h = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f23511i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static ec.b f23512j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static ActivityManager.ProcessErrorStateInfo f23513k;

    public static GeckoGlobalConfig.ENVType a() {
        Application r5 = k5.d.s;
        if (r5 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("application");
        r5 = null;
    L6:
        int r10 = r5.getSharedPreferences("gecko_settings", 0).getInt("gecko_env", 2);
        if (r10 == 0) goto L15;
        if (r10 == 1) goto L13;
        return GeckoGlobalConfig.ENVType.PROD;
    L13:
        return GeckoGlobalConfig.ENVType.DEV;
    L15:
        return GeckoGlobalConfig.ENVType.BOE;
    }

    public static String b(int r12, long r13) {
        ListMap r5 = e;
        if (r5 != null) goto L19;
        File r10 = new File(i9.f.f17539c, "exit_info");
        e = new ListMap();
        if (r10.exists() == true) goto L8;
        r5 = e;
        goto L19
    L8:
        String[] r11 = r10.list();
        if (r11 != null) goto L11;
        r5 = e;
        goto L19
    L11:
        int r14 = r11.length;
        int r15 = 0;
    L12:
        if (r15 >= r14) goto L18;
        String r16 = r11[r15];
        String[] r17 = r16.split("_");
        if (r17.length != 2) goto L17;
        long r18 = i9.f.b(r17[0], -1);
        int r19 = (int) i9.f.b(r17[1], -1);
        ListMap r110 = e;
        Integer r20 = Integer.valueOf(r19);
        r110.a(r20).add(new Pair(Long.valueOf(r18), r16));
    L17:
        r15 = r15 + 1;
        goto L12
    L18:
        r5 = e;
    L19:
        List r111 = r5.get(Integer.valueOf(r12));
        if (r111 != null) goto L22;
    L34:
        return null;
    L22:
        if (r111.isEmpty() == true) goto L34;
        Iterator r21 = r111.iterator();
    L25:
        if (r21.hasNext() == false) goto L29;
        Pair r22 = (Pair) r21.next();
        if (Math.abs(((Long) r22.first).longValue() - r13) >= WsConstants.EXIT_DELAY_TIME) goto L25;
        File r112 = new File(i9.f.f17539c, "exit_info/" + ((String) r22.second));
    L30:
        if (r112 != null) goto L36;
        r112 = new File(i9.f.f17539c, "exit_info/" + ((String) ((Pair) r111.get(0)).second));
    L36:
        return cl.a.c(-1, r112, "\n");
    L29:
        r112 = null;
        goto L30
    }

    public static String c(Context r5) {
        if ((SystemClock.uptimeMillis() - f23510h) >= 5000) goto L34;
        return null;
    L34:
        ActivityManager r10 = (ActivityManager) r5.getSystemService("activity");     // Catch: Throwable -> L33
        if (r10 == null) goto L16;
        List<ActivityManager.ProcessErrorStateInfo> r11 = r10.getProcessesInErrorState();     // Catch: Throwable -> L33
        if (r11 == null) goto L16;
        Iterator<ActivityManager.ProcessErrorStateInfo> r12 = r11.iterator();     // Catch: Throwable -> L33
    L12:
        if (r12.hasNext() == false) goto L16;
        ActivityManager.ProcessErrorStateInfo r13 = r12.next();     // Catch: Throwable -> L33
        if (r13.condition != 2) goto L12;
    L17:
        if (r13 == null) goto L29;
        if (Process.myPid() != r13.pid) goto L29;
        ActivityManager.ProcessErrorStateInfo r14 = f23513k;     // Catch: Throwable -> L33
        if (r14 != null) goto L24;
    L27:
        f23513k = r13;     // Catch: Throwable -> L33
        g = null;     // Catch: Throwable -> L33
        f23510h = SystemClock.uptimeMillis();     // Catch: Throwable -> L33
        f23511i = false;     // Catch: Throwable -> L33
        return ym.m.e(r13);
    L24:
        if (ym.m.j(r14, r13) == false) goto L27;
        f23510h = SystemClock.uptimeMillis();     // Catch: Throwable -> L33
        return null;
    L16:
        r13 = null;
    L29:
        String r15 = g;
        if (r15 == null) goto L37;
        f23511i = true;
        g = null;
        f23510h = SystemClock.uptimeMillis();
        return r15;
    L37:
        return null;
    }

    public static String d(Context r10, int[] r11) {
        if ((SystemClock.uptimeMillis() - f23510h) >= 5000) goto L43;
        return null;
    L43:
        ActivityManager r5 = (ActivityManager) r10.getSystemService("activity");     // Catch: Throwable -> L42
        if (r5 == null) goto L17;
        Process.myPid();     // Catch: Throwable -> L42
        List<ActivityManager.ProcessErrorStateInfo> r12 = r5.getProcessesInErrorState();     // Catch: Throwable -> L42
        if (r12 == null) goto L17;
        Iterator<ActivityManager.ProcessErrorStateInfo> r13 = r12.iterator();     // Catch: Throwable -> L42
    L13:
        if (r13.hasNext() == false) goto L17;
        ActivityManager.ProcessErrorStateInfo r14 = r13.next();     // Catch: Throwable -> L42
        if (r14.condition != 2) goto L13;
    L18:
        if (r14 == null) goto L35;
        if (Process.myPid() == r14.pid) goto L24;
        if (r11 == null) goto L35;
        if (r14.processName.contains(r10.getPackageName()) == false) goto L35;
    L24:
        ActivityManager.ProcessErrorStateInfo r15 = f23513k;     // Catch: Throwable -> L42
        if (r15 != null) goto L27;
    L30:
        f23513k = r14;     // Catch: Throwable -> L42
        g = null;     // Catch: Throwable -> L42
        f23510h = SystemClock.uptimeMillis();     // Catch: Throwable -> L42
        f23511i = false;     // Catch: Throwable -> L42
        if (r11 == null) goto L34;
        r11[0] = r14.pid;     // Catch: Throwable -> L42
    L34:
        return ym.m.e(r14);
    L27:
        if (ym.m.j(r15, r14) == false) goto L30;
        f23510h = SystemClock.uptimeMillis();     // Catch: Throwable -> L42
        return null;
    L17:
        r14 = null;
    L35:
        String r16 = g;
        if (r16 == null) goto L41;
        if (r11 == null) goto L39;
        r11[0] = Process.myPid();
    L39:
        f23511i = true;
        g = null;
        f23510h = SystemClock.uptimeMillis();
        return r16;
    L41:
        return null;
    }

    public static SimpleDateFormat e() {
        if (f23508b != null) goto L6;
        f23508b = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
    L6:
        return f23508b;
    }

    public static JSONArray f(File r10) {
        File r5 = new File(r10, "logcat.txt");     // Catch: Throwable -> L8
        File r11 = new File(r10, "logerr.txt");     // Catch: Throwable -> L8
        if (r11.exists() == false) goto L12;
        if (com.lynx.jsbridge.a.n(r5) == false) goto L10;
        com.bytedance.crash.util.b.a(true, 1);     // Catch: Throwable -> L8
        goto L12
    L10:
        HashMap r12 = com.bytedance.crash.util.b.f4173a;     // Catch: Throwable -> L8
        io.reactivex.exceptions.a.i("single_logcat failed ver 2");     // Catch: Throwable -> L8
        com.bytedance.crash.util.b.a(false, 3);     // Catch: Throwable -> L8
    L12:
        if (r5.exists() == true) goto L14;
    L16:
        r5.getParentFile().mkdirs();     // Catch: Throwable -> L8
        i(r5.getAbsolutePath(), r11.getAbsolutePath(), true);     // Catch: Throwable -> L8
    L17:
        String r13 = r5.getAbsolutePath();     // Catch: Throwable -> L8
        File r14 = new File(r13);     // Catch: Throwable -> L22 IOException -> L30
        if (r14.length() <= LynxResourceModule.DEFAULT_MEDIA_SIZE) goto L24;
        JSONArray r15 = cl.a.d(r14.length() - LynxResourceModule.DEFAULT_MEDIA_SIZE, r14);     // Catch: Throwable -> L22 IOException -> L30
    L33:
        return r15;
    L24:
        r15 = cl.a.F(r13);     // Catch: Throwable -> L22 IOException -> L30
    L22:
        th = move-exception;
        io.reactivex.exceptions.a.f(th);     // Catch: Throwable -> L8
        return null;
    L34:
        return null;
    L14:
        if (r5.length() <= 0) goto L16;
    L8:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
        return null;
    }

    public static JSONObject g(String r5) {
        JSONObject r10 = new JSONObject();     // Catch: Throwable -> L4
        r10.put("thread_number", 1);     // Catch: Throwable -> L4
        r10.put("mainStackFromTrace", r5);     // Catch: Throwable -> L4
        return r10;
    L4:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
        return null;
    }

    public static void h() {
        File r5 = new File(i9.f.f17539c, "exit_info");
        if (r5.exists() == false) goto L16;
        String[] r10 = r5.list();
        if (r10 == null) goto L17;
        JSONObject r11 = l9.c.e();
        int r12 = mh.e.c(r11, 50, new String[]{"custom_event_settings", "npth_simple_setting", "exit_reason_limit"});
        if (r10.length <= r12) goto L14;
        Arrays.sort(r10);
    L12:
        if (r12 >= r10.length) goto L18;
        cl.a.C(new File(r5, r10[r12]));
        r12 = r12 + 1;
        goto L12
    L18:
        return;
    L14:
        return;
    L17:
        return;
    }

    public static void i(String r10, String r11, boolean r12) {
        if (NativeTools.k().f4169a == false) goto L15;
        HashMap r5 = com.bytedance.crash.util.b.f4173a;
        com.bytedance.crash.util.a r13 = (com.bytedance.crash.util.a) r5.get("single_logcat");
        if (r13 != null) goto L8;
        Context r14 = com.bytedance.crash.n.f4057a;
        String r15 = com.bytedance.crash.util.g.f4181a;
        r13 = new com.bytedance.crash.util.a(new File(new File(com.bytedance.crash.util.g.h(r14), x8.a.f22985h), "single_logcat"));
        r5.put("single_logcat", r13);
    L8:
        if (r13.e != 1) goto L10;
    L11:
        io.reactivex.exceptions.a.i("use native single logcat");
        NativeTools.k().e(r10, r11);
        if (r12 == false) goto L22;
        SystemClock.sleep(WsConstants.EXIT_DELAY_TIME);
        return;
    L22:
        return;
    L10:
        if (r13.f4171b != 2) goto L11;
    L15:
        io.reactivex.exceptions.a.l("use java logcat cause native logcat error");
        AtomicBoolean r16 = new AtomicBoolean(true);
        com.bytedance.apm.d r17 = new com.bytedance.apm.d(9, r10, r16);
        new Thread(r17).start();     // Catch: Throwable -> L18
        return;
    L18:
        r16.set(false);
        r17.run();
    }

    public static boolean j() {
        ActivityManager r5 = (ActivityManager) com.bytedance.crash.n.f4057a.getSystemService("activity");
        if (r5 != null) goto L5;
        return false;
    L5:
        int r10 = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> r11 = r5.getRunningAppProcesses();
        if (r11 == null) goto L15;
        Iterator<ActivityManager.RunningAppProcessInfo> r12 = r11.iterator();
    L9:
        if (r12.hasNext() == false) goto L15;
        ActivityManager.RunningAppProcessInfo r13 = r12.next();
        if (r13 == null) goto L9;
        if (r13.pid != r10) goto L9;
        return false;
    L15:
        List<ActivityManager.ProcessErrorStateInfo> r14 = r5.getProcessesInErrorState();
        if (r14 == null) goto L27;
        Iterator<ActivityManager.ProcessErrorStateInfo> r15 = r14.iterator();
    L19:
        if (r15.hasNext() == false) goto L27;
        ActivityManager.ProcessErrorStateInfo r16 = r15.next();
        if (r16 == null) goto L19;
        if (r16.pid != r10) goto L19;
        if (r16.condition != 1) goto L27;
        return false;
    L27:
        return true;
    }

    public static boolean k(String r16, com.bytedance.ies.bullet.service.base.n r17, String r18, List r19) {
        com.bytedance.ies.bullet.base.utils.logger.b r5 = new com.bytedance.ies.bullet.base.utils.logger.b();
        if (r16 != null) goto L5;
        String r10 = "";
    L6:
        Intrinsics.checkNotNullParameter("session_id", "name");
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        androidx.room.jarjarred.org.antlr.runtime.a.B("session_id", r10, r5.f5260a);
        boolean r11 = false;
        if (r19 == null) goto L23;
        Iterator r12 = r19.iterator();
    L10:
        if (r12.hasNext() == false) goto L23;
        com.bytedance.ies.bullet.service.base.n r13 = (com.bytedance.ies.bullet.service.base.n) r12.next();
        String r14 = r13.e();
        int r15 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        boolean r110 = r11;
        Map r20 = MapsKt.mapOf(new kotlin.Pair[]{TuplesKt.to("bid", r13.getBid()), TuplesKt.to("bulletTag", r17.e()), TuplesKt.to("url", String.valueOf(r17.getSchema())), TuplesKt.to("RouterAbilityProvider", r13), TuplesKt.to("bulletTag", r14)});
        Intrinsics.checkNotNullParameter("forEach closeAffinity", "moduleTag");
        Intrinsics.checkNotNullParameter("XRouter", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "forEach closeAffinity", "XRouter", r20, r5);
        if (Intrinsics.areEqual(r13, r17) == true) goto L17;
        if (Intrinsics.areEqual(r18, r14) == false) goto L17;
    L18:
        if (r13 != null) goto L19;
        r11 = r110;
        goto L10
    L19:
        Map r111 = MapsKt.mapOf(new kotlin.Pair[]{TuplesKt.to("bid", r13.getBid()), TuplesKt.to("bulletTag", r17.e()), TuplesKt.to("url", String.valueOf(r17.getSchema())), TuplesKt.to("RouterAbilityProvider", r13), TuplesKt.to("bulletTag", r14)});
        Intrinsics.checkNotNullParameter("XRouter", "moduleTag");
        Intrinsics.checkNotNullParameter("do closeAffinity", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XRouter", "do closeAffinity", r111, r5);
        r13.close();
        r11 = true;
    L17:
        r13 = null;
    L23:
        int r21 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        Map r22 = MapsKt.mapOf(new kotlin.Pair[]{TuplesKt.to("bulletTag", r17.e()), TuplesKt.to("url", String.valueOf(r17.getSchema())), TuplesKt.to("result", Boolean.valueOf(r11))});
        Intrinsics.checkNotNullParameter("XRouter", "moduleTag");
        Intrinsics.checkNotNullParameter("closeAffinity result", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XRouter", "closeAffinity result", r22, r5);
        return r11;
    L5:
        r10 = r16;
        goto L6
    }

    public static final void l(FrameLayout r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        com.obric.oui.material.n.q(0, 1, r5);
    }

    public static final void m(FrameLayout r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r10 == false) goto L5;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        com.obric.oui.material.n.q(0, 0, r5);
        return;
    L5:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        com.obric.oui.material.n.q(0, 0, r5);
    }

    public static final int n(float r5, int r10) {
        if (r5 != 1.0f) goto L5;
        return r10;
    L5:
        float r11 = RangesKt.coerceIn(r5, 0.0f, 1.0f);
        return Color.argb((int) (Color.alpha(r10) * r11), Color.red(r10), Color.green(r10), Color.blue(r10));
    }

    public static SimpleDateFormat o() {
        if (d != null) goto L6;
        d = new SimpleDateFormat("yyyy-MM-dd@HH-mm-ss.SSS", Locale.getDefault());
    L6:
        return d;
    }

    public static void p() {
        Context r5 = com.bytedance.crash.n.f4057a;
        int r10 = 0;
        if (r5 == null) goto L12;
        ActivityManager r11 = (ActivityManager) r5.getSystemService("activity");
        if (r11 == null) goto L12;
        List<ApplicationExitInfo> r12 = r11.getHistoricalProcessExitReasons(r5.getPackageName(), 0, 30);
        if (r12 == null) goto L12;
        if (r12.size() <= 0) goto L12;
    L13:
        if (r12 == null) goto L173;
        String r13 = "lastReasonTime";
        File r14 = new File(i9.f.f17539c, "lastReasonTime");
        long r15 = -1;
        if (r14.exists() == true) goto L145;
    L18:
        r12.sort(new ca.d(20));
        File r16 = new File(i9.f.f17539c, "exit_info");
        r16.mkdirs();
        Iterator<ApplicationExitInfo> r17 = r12.iterator();
    L20:
        if (r17.hasNext() == false) goto L139;
        ApplicationExitInfo r18 = r17.next();
        if (r18.getTimestamp() < r15) goto L139;
        File r19 = new File(r16, r18.getTimestamp() + "_" + r18.getPid());
        if (r19.exists() == true) goto L20;
        Properties r20 = new Properties();
        r20.setProperty("process", String.valueOf(r18.getProcessName()));
        r20.setProperty("reason", String.valueOf(r18.getReason()));
        r20.setProperty("sub_reason", String.valueOf(e9.b.a(r18, new Object[r10])));
        r20.setProperty(Constant.DESCRIPTION, String.valueOf(r18.getDescription()));
        r20.setProperty(NotificationCompat.CATEGORY_STATUS, String.valueOf(r18.getStatus()));
        r20.setProperty("importance", String.valueOf(r18.getImportance()));
        r20.setProperty("pss", String.valueOf(r18.getPss()));
        r20.setProperty("rss", String.valueOf(r18.getRss()));
        FileOutputStream r110 = new FileOutputStream(r19);     // Catch: Throwable -> L35 IOException -> L37
        r20.store(r110, "exitInfo");     // Catch: Throwable -> L31 IOException -> L33
        com.bytedance.android.anniex.base.service.f.h(r110);
    L41:
        List r21 = i9.f.f.get(Integer.valueOf(r18.getPid()));
        if (r21 != null) goto L44;
    L47:
        File r22 = new File(i9.f.d, String.valueOf(r18.getTimestamp()));
        r22.mkdirs();
        File r23 = new File(r22, "info.txt");
        StringBuilder r111 = new StringBuilder();     // Catch: IOException -> L54
        File r112 = r16;
        r111.append(r18.getPid());     // Catch: IOException -> L52
        r111.append(" 0 0 ");     // Catch: IOException -> L52
        r111.append(r18.getProcessName());     // Catch: IOException -> L52
        cl.a.u(r111.toString(), r23, false);     // Catch: IOException -> L52
    L57:
        i9.e r24 = i9.f.d(System.currentTimeMillis(), r22, r22.getName());
        i9.f.f.a(Integer.valueOf(r18.getPid())).add(r24);
        i9.f.e.add(r24);
        File r25 = r22;
    L58:
        int r26 = r18.getPid();
        HashMap r27 = new HashMap();
        String r28 = com.lynx.jsbridge.a.d(r26, DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD);
        long r29 = r15;
        com.bytedance.crash.upload.g.k(r27, new av.h(r28, 1));
        com.bytedance.crash.upload.g.q(r27, new av.h(r28, 2));
        Iterator r30 = r27.values().iterator();
    L60:
        if (r30.hasNext() == false) goto L94;
        com.bytedance.crash.upload.f r31 = (com.bytedance.crash.upload.f) r30.next();
        if (r31.f4114j != r26) goto L60;
        ArrayList r32 = r31.f4110b;
        if (r32.isEmpty() == true) goto L83;
        cl.a.I(new File(r25, "hasJavaCrash"));
        Iterator r33 = r32.iterator();
        boolean r34 = false;
        boolean r113 = false;
    L68:
        if (r33.hasNext() == false) goto L82;
        r33 = r33;
        com.bytedance.crash.upload.e r35 = (com.bytedance.crash.upload.e) r33.next();
        boolean r210 = r34;
        boolean r211 = r113;
        r13 = r13;
        cl.a.u(r25.getAbsolutePath(), new File(r35.f4105a, "has_kill_info"), false);     // Catch: Throwable -> L122
    L78:
        cl.a.I(new File(r35.f4105a, "has_exit_info"));
        if (r35.g == CrashType.ANR) goto L80;
        r113 = r211;
        r34 = true;
        goto L68
    L80:
        r34 = r210;
        r113 = true;
    L76:
        r13 = r13;
    L77:
        r13 = r13;
        r211 = r113;
        goto L78
    L82:
        boolean r212 = r34;
        String r213 = r13;
        boolean r214 = r113;
    L84:
        ArrayList r36 = r31.f4111c;
        if (r36.isEmpty() == true) goto L93;
        cl.a.I(new File(r25, "hasNativeCrash"));
        Iterator r37 = r36.iterator();
    L88:
        if (r37.hasNext() == false) goto L92;
        com.bytedance.crash.upload.e r38 = (com.bytedance.crash.upload.e) r37.next();
        cl.a.u(r25.getAbsolutePath(), new File(r38.f4105a, "has_kill_info"), false);     // Catch: Throwable -> L123
    L91:
        cl.a.I(new File(r38.f4105a, "has_exit_info"));
        goto L88
    L92:
        boolean r39 = true;
    L95:
        JSONObject r40 = new JSONObject();
        JSONObject r41 = new JSONObject();
        mh.e.k(r40, new Object[]{"main_process", String.valueOf(com.bytedance.crash.n.f4057a.getPackageName().equals(r18.getProcessName()))});
        mh.e.k(r40, new Object[]{"reason", String.valueOf(r18.getReason())});
        mh.e.k(r40, new Object[]{"sub_reason", String.valueOf(e9.b.a(r18, new Object[0]))});
        mh.e.k(r40, new Object[]{Constant.DESCRIPTION, String.valueOf(r18.getDescription())});
        mh.e.k(r40, new Object[]{NotificationCompat.CATEGORY_STATUS, String.valueOf(r18.getStatus())});
        mh.e.k(r40, new Object[]{"importance", String.valueOf(r18.getImportance())});
        mh.e.k(r41, new Object[]{"pss", String.valueOf(r18.getPss())});
        mh.e.k(r41, new Object[]{"rss", String.valueOf(r18.getRss())});
        mh.e.k(r40, new Object[]{"find_java", String.valueOf(r212)});
        mh.e.k(r40, new Object[]{"find_anr", String.valueOf(r214)});
        mh.e.k(r40, new Object[]{"find_native", String.valueOf(r39)});
        if (com.bytedance.crash.n.f4057a == null) goto L141;
        io.reactivex.exceptions.a.i("upload exit_reason_monitor " + r41 + " " + r40);
        l9.n.b("exit_reason_monitor", r40, r41);
    L141:
        Iterator r42 = i9.f.f17541i.iterator();     // Catch: Throwable -> L112
    L101:
        if (r42.hasNext() == false) goto L102;
        if (r42.next() != null) goto L111;
        throw null;     // Catch: Throwable -> L107
    L107:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();     // Catch: Throwable -> L124
        m.b.h("NPTH_CATCH", th);     // Catch: Throwable -> L124
        goto L101
    L111:
        throw new ClassCastException();     // Catch: Throwable -> L124
    L102:
        r16 = r112;
        r17 = r17;
        r15 = r29;
        r13 = r213;
        r10 = 0;
        goto L20
    L93:
        r39 = false;
        goto L95
    L83:
        r213 = r13;
        r212 = false;
        r214 = false;
        goto L84
    L94:
        r213 = r13;
        r39 = false;
        r212 = false;
        r214 = false;
    L52:
        e = e;
    L56:
        io.reactivex.exceptions.a.j(e);
    L54:
        e = e;
        r112 = r16;
        goto L56
    L44:
        if (r21.isEmpty() == true) goto L47;
        r25 = ((i9.e) r21.get(0)).f17536i;
        r112 = r16;
        goto L58
    L33:
        e = e;
    L143:
        io.reactivex.exceptions.a.j(e);     // Catch: Throwable -> L113
        com.bytedance.android.anniex.base.service.f.h(r110);
    L113:
        th = th;
        FileOutputStream r43 = r110;
    L115:
        r110 = r43;
    L116:
        com.bytedance.android.anniex.base.service.f.h(r110);
        throw th;
    L31:
        th = th;
        goto L116
    L37:
        e = e;
        r110 = null;
    L35:
        th = th;
        r43 = null;
    L139:
        cl.a.u(String.valueOf(System.currentTimeMillis()), new File(i9.f.f17539c, r13), false);     // Catch: Throwable -> L125
        return;
    L174:
        return;
    L145:
        r15 = i9.f.b(cl.a.c(-1, r14, "\n"), -1);     // Catch: IOException -> L121
        goto L18
    L173:
        return;
    L12:
        r12 = null;
        goto L13
    }

    public static final void q(List r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Iterator r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((com.obric.oui.material.d) r11.next()).a(r10);
        goto L4
    }

    public static final void r(ViewGroup[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r5 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r5) goto L15;
        ViewGroup r13 = r10[r12];
        int r14 = r13.getChildCount();
        int r15 = 0;
    L5:
        if (r15 >= r14) goto L14;
        int r16 = r15 + 1;
        KeyEvent.Callback r17 = r13.getChildAt(r15);
        if ((r17 instanceof com.obric.oui.material.d) == false) goto L9;
        com.obric.oui.material.d r18 = (com.obric.oui.material.d) r17;
    L10:
        if (r18 == null) goto L13;
        r18.a(r11);
    L13:
        r15 = r16;
        goto L5
    L9:
        r18 = null;
        goto L10
    L14:
        r12 = r12 + 1;
        goto L3
    }

    public static final void s(ViewGroup[] r10, View r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r5 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r5) goto L15;
        ViewGroup r13 = r10[r12];
        int r14 = r13.getChildCount();
        int r15 = 0;
    L5:
        if (r15 >= r14) goto L14;
        int r16 = r15 + 1;
        KeyEvent.Callback r17 = r13.getChildAt(r15);
        if ((r17 instanceof com.obric.oui.material.d) == false) goto L9;
        com.obric.oui.material.d r18 = (com.obric.oui.material.d) r17;
    L10:
        if (r18 == null) goto L13;
        r18.setBackdropTarget(r11);
    L13:
        r15 = r16;
        goto L5
    L9:
        r18 = null;
        goto L10
    L14:
        r12 = r12 + 1;
        goto L3
    }

    public static final boolean t(float r5) {
        if (r5 < 1.2f) goto L5;
        return true;
    L5:
        return false;
    }
}
