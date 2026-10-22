package sk;

import ai.j0;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import com.bytedance.ies.bullet.core.e;
import com.bytedance.salamander.anniex.b0;
import com.lynx.base.log.LynxLog;
import com.lynx.jsbridge.LynxModuleWrapper;
import com.lynx.jsbridge.MethodDescriptor;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.core.LynxEngineProxy;
import j5.b;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.net.UnknownHostException;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import tc.c;
import x4.h;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f21938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f21939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f21940c;
    public static long d;
    public static long e;
    public static long f;
    public static long g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static long f21941h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static long f21942i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static long f21943j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static long f21944k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static long f21945l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static long f21946m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static long f21947n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static boolean f21948o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static String f21949p;

    public static StringBuilder a(String r5) {
        return j0.u(r5);
    }

    public static void b(LynxModuleWrapper r10, LynxEngineProxy r11, ReadableMap r12, String r13) {
        ReadableMap r5 = r12.getMap("methodDetail", new JavaOnlyMap());
        r5.getString("module", null);
        String r14 = r5.getString("method", null);
        boolean r15 = false;
        boolean r16 = r12.getBoolean("fromPiper", false);
        String r17 = r12.getString("tasmEntryName", null);
        int r18 = r12.getInt("callbackId", -1);
        if (r13.equals(NotificationCompat.CATEGORY_CALL) == true) goto L7;
        if (r14 != null) goto L6;
    L29:
        Iterator<MethodDescriptor> r19 = r10.getMethodDescriptors().iterator();     // Catch: Exception -> L21
    L9:
        if (r19.hasNext() == false) goto L47;
        MethodDescriptor r20 = r19.next();     // Catch: Exception -> L21
        String r21 = r20.getName();     // Catch: Exception -> L21
        if (r21 == null) goto L9;
        if (r21.isEmpty() == true) goto L9;
        if (r21.equals(r13) == false) goto L9;
        WeakReference r22 = new WeakReference(r11);     // Catch: Exception -> L21
        if (r15 == true) goto L20;
        if (r16 == true) goto L24;
        r20.getMethod().invoke(r10.getModule(), new Object[]{r5, new b0(r22, r18, r17)});     // Catch: Exception -> L21
        goto L9
    L24:
        r20.getMethod().invoke(r10.getModule(), r5.getArray("param", new JavaOnlyArray()).asArrayList().toArray());     // Catch: Exception -> L21
        goto L9
    L20:
        r20.getMethod().invoke(r10.getModule(), new Object[]{r14, r5, new om.a(r22, r16, r18, r17)});     // Catch: Exception -> L21
        goto L9
    L47:
        return;
    L21:
        e = move-exception;
        LynxLog.b(4, "LynxLepusModule", "Lepus Module invokeAsync: " + e.toString());
        return;
    L6:
        if (r14.length() == 0) goto L29;
    L7:
        r15 = true;
        goto L29
    }

    public static void c(String r5, WebView r10, h r11) {
        Intrinsics.checkNotNullParameter(r11, "nativeCommon");
        String r12 = r11.f22973a;
        if (r12 != null) goto L5;
    L6:
        String r13 = b.a(r5, r10, "url");
        if (r13 == null) goto L9;
        r11.f22973a = r13;
    L9:
        String r14 = r11.d;
        if (r14 != null) goto L12;
    L13:
        String r15 = b.a(r5, r10, "native_page");
        if (r15 == null) goto L16;
        r11.d = r15;
    L16:
        String r16 = r11.f22975c;
        if (r16 != null) goto L19;
    L20:
        String r17 = b.a(r5, r10, "container_type");
        if (r17 == null) goto L25;
        r11.f22975c = r17;
        return;
    L25:
        return;
    L19:
        if (r16.length() == 0) goto L20;
        return;
    L12:
        if (r14.length() != 0) goto L16;
    L5:
        if (r12.length() != 0) goto L9;
        goto L6
    }

    public static final boolean d(e r5) {
        if (r5 == null) goto L15;
        String r10 = r5.f;
        if (r10 == null) goto L15;
        c r11 = c.f22119c;
        rc.c r12 = c.f22119c.a(pb.a.class, r10);
        if ((r12 instanceof com.ivy.ivykit.plugin.impl.jsb.c) == false) goto L9;
        com.ivy.ivykit.plugin.impl.jsb.c r13 = (com.ivy.ivykit.plugin.impl.jsb.c) r12;
    L10:
        if (r13 == null) goto L12;
        Boolean r14 = Boolean.FALSE;
    L13:
        if (r14 == null) goto L15;
        boolean r15 = r14.booleanValue();
    L16:
        if (r5 == null) goto L24;
        rd.e r16 = r5.g;
        if (r16 == null) goto L24;
        rd.b r17 = r16.f21723a;
        if (r17 == null) goto L24;
        Boolean r18 = (Boolean) new vd.a(r17, "use_piper_data", Boolean.valueOf(r15)).f22372b;
        if (r18 == null) goto L24;
        boolean r19 = r18.booleanValue();
    L25:
        boolean r20 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.a(6, "BulletContext.usePiperData: res=" + r19 + ", defaultVal=" + r15, null);
        return r19;
    L24:
        r19 = r15;
        goto L25
    L12:
        r14 = null;
        goto L13
    L9:
        r13 = null;
    L15:
        r15 = false;
        goto L16
    }

    public static JSONArray e() {
        JSONArray r5 = new JSONArray();
        JSONObject r10 = new JSONObject();
        r10.put("module_name", "base");
        r10.put("span_name", "app_constructor");
        r10.put("start", f21939b);
        r10.put("end", f21940c);
        JSONObject r11 = new JSONObject();
        r11.put("module_name", "base");
        r11.put("span_name", "app_attachBaseContext");
        r11.put("start", d);
        r11.put("end", e);
        JSONObject r12 = new JSONObject();
        r12.put("module_name", "base");
        r12.put("span_name", "app_onCreate");
        r12.put("start", f);
        r12.put("end", g);
        JSONObject r13 = new JSONObject();
        r13.put("module_name", "base");
        r13.put("span_name", "activity_onCreate");
        r13.put("start", f21941h);
        r13.put("end", f21942i);
        JSONObject r14 = new JSONObject();
        r14.put("module_name", "base");
        r14.put("span_name", "activity_onResume");
        r14.put("start", f21945l);
        r14.put("end", f21946m);
        JSONObject r15 = new JSONObject();
        r15.put("module_name", "base");
        r15.put("span_name", "activity_onStart");
        r15.put("start", f21943j);
        r15.put("end", f21944k);
        if (f21947n <= 0) goto L5;
        JSONObject r16 = new JSONObject();
        r16.put("module_name", "base");
        r16.put("span_name", "activity_onWindowFocusChanged");
        r16.put("start", f21947n);
        r5.put(r16);
    L5:
        r5.put(r10);
        r5.put(r11);
        r5.put(r12);
        r5.put(r13);
        r5.put(r14);
        r5.put(r15);
        return r5;
    }

    public static final boolean f(e r5) {
        if (r5 == null) goto L15;
        String r10 = r5.f;
        if (r10 == null) goto L15;
        c r11 = c.f22119c;
        rc.c r12 = c.f22119c.a(pb.a.class, r10);
        if ((r12 instanceof com.ivy.ivykit.plugin.impl.jsb.c) == false) goto L9;
        com.ivy.ivykit.plugin.impl.jsb.c r13 = (com.ivy.ivykit.plugin.impl.jsb.c) r12;
    L10:
        if (r13 == null) goto L12;
        Boolean r14 = Boolean.FALSE;
    L13:
        if (r14 == null) goto L15;
        boolean r15 = r14.booleanValue();
    L16:
        if (r5 == null) goto L24;
        rd.e r16 = r5.g;
        if (r16 == null) goto L24;
        rd.b r17 = r16.f21723a;
        if (r17 == null) goto L24;
        Boolean r18 = (Boolean) new vd.a(r17, "use_xbridge3", Boolean.valueOf(r15)).f22372b;
        if (r18 == null) goto L24;
        boolean r19 = r18.booleanValue();
    L25:
        boolean r20 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.a(6, "BulletContext.useXBride3: res=" + r19 + ", defaultVal=" + r15, null);
        return r19;
    L24:
        r19 = r15;
        goto L25
    L12:
        r14 = null;
        goto L13
    L9:
        r13 = null;
    L15:
        r15 = true;
        goto L16
    }

    public static final boolean g(e r5) {
        if (r5 == null) goto L15;
        String r10 = r5.f;
        if (r10 == null) goto L15;
        c r11 = c.f22119c;
        rc.c r12 = c.f22119c.a(pb.a.class, r10);
        if ((r12 instanceof com.ivy.ivykit.plugin.impl.jsb.c) == false) goto L9;
        com.ivy.ivykit.plugin.impl.jsb.c r13 = (com.ivy.ivykit.plugin.impl.jsb.c) r12;
    L10:
        if (r13 == null) goto L12;
        Boolean r14 = Boolean.TRUE;
    L13:
        if (r14 == null) goto L15;
        boolean r15 = r14.booleanValue();
    L16:
        if (r5 == null) goto L24;
        rd.e r16 = r5.g;
        if (r16 == null) goto L24;
        rd.b r17 = r16.f21723a;
        if (r17 == null) goto L24;
        Boolean r18 = (Boolean) new vd.a(r17, "use_xbridge3", Boolean.valueOf(r15)).f22372b;
        if (r18 == null) goto L24;
        boolean r19 = r18.booleanValue();
    L25:
        boolean r20 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.a(6, "BulletContext.useXBride3: res=" + r19 + ", defaultVal=" + r15, null);
        return r19;
    L24:
        r19 = r15;
        goto L25
    L12:
        r14 = null;
        goto L13
    L9:
        r13 = null;
    L15:
        r15 = false;
        goto L16
    }

    public static String h(Throwable r5) {
        if (r5 != null) goto L5;
        return "";
    L5:
        Throwable r10 = r5;
    L6:
        if (r10 == null) goto L12;
        if ((r10 instanceof UnknownHostException) == true) goto L9;
        r10 = r10.getCause();
        goto L6
    L9:
        return "ALOG:UnknownHostException";
    L12:
        StringWriter r11 = new StringWriter();
        PrintWriter r12 = new PrintWriter(r11);
        r5.printStackTrace(r12);     // Catch: Throwable -> L16
    L14:
        r12.flush();
        return r11.toString();
    }
}
