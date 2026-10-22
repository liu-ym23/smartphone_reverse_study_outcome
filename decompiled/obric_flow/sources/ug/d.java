package ug;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import com.airbnb.lottie.l;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.iesgurd.meta.PrepareMeta;
import com.bytedance.iesgurd.meta.PrepareMetaPackage;
import com.bytedance.iesgurd.update.ErrorCode;
import com.bytedance.iesgurd.update.UpdateException;
import com.bytedance.news.common.settings.SettingsConfigProvider;
import com.google.common.base.u;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.tasm.LynxTemplateRender;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.behavior.ui.utils.n;
import com.lynx.tasm.behavior.ui.utils.p;
import com.lynx.tasm.behavior.x0;
import com.lynx.tasm.q;
import com.lynx.tasm.utils.CallStackUtil;
import com.lynx.tasm.utils.k;
import com.obric.common.oea.style.scene.alpha.alphaplayer.widget.GLTextureView;
import com.obric.oui.constraintlayout.motion.widget.MotionLayout;
import com.squareup.kotlinpoet.a0;
import com.squareup.kotlinpoet.x;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mn.i;
import org.json.JSONException;
import org.json.JSONObject;
import s8.h;
import wc.f;
import ym.j;
import zm.z;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements fo.b, x {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile d f22355h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f22356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f22357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f22358c;
    public Object d;
    public Object e;
    public Object f;
    public Object g;

    public /* synthetic */ d(Object r5, Object r10, Serializable r11, Object r12, Object r13, Serializable r14, int r15) {
        this.f22356a = r15;
        this.f22357b = r5;
        this.f22358c = r10;
        this.d = r11;
        this.e = r12;
        this.f = r13;
        this.g = r14;
    }

    public static String d(String r5, String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return r5;
    L6:
        return k.j(r5, "_", r10);
    }

    public static d f(Context r5) {
        if (f22355h != null) goto L16;
        monitor-enter(d.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f22355h != null) goto L11;
        f22355h = new d(r5);     // Catch: Throwable -> L9
    L11:
        monitor-exit(d.class);     // Catch: Throwable -> L9
    L16:
        return f22355h;
    }

    public static void j(d r13, int r14, ArrayList r15, int r16, Integer r17) {
        Intrinsics.checkNotNullParameter(r15, "entries");
        ((ArrayList) r13.e).add(new yr.a(r14, r15, null, 1.0f, r17, r17, null, r16, (androidx.core.view.inputmethod.a) r13.g));
        ((LinkedHashMap) r13.f).put(Integer.valueOf(r14), Integer.valueOf(r16));
    }

    public static void p(int r5, String r10) {
        Log.e("EglHelper", "throwEglException tid=" + Thread.currentThread().getId() + " " + (r10 + " failed: " + r5));
    }

    @Override // fo.b
    public void a(String r10) {
        switch(this.f22356a) {
            case 2: goto L100;
            default: goto L4;
        };
    L4:
        Log.d("scc_sdk", "!!! scc cloud service doCheck() !!!");
        if (vf.a.a() != null) goto L8;
        Log.w("scc_sdk", "net adapter null, skip check!");
        return;
    L8:
        if (TextUtils.isEmpty(r10) == true) goto L98;
        u r5 = null;
        if (TextUtils.isEmpty(r10) == false) goto L12;
        String r11 = null;
    L14:
        if (TextUtils.isEmpty(r11) == true) goto L98;
        if ("http".equalsIgnoreCase(r11) == false) goto L19;
    L20:
        String r12 = p.h(r10);
        yf.b r13 = new yf.b();
        r13.f23255b = SystemClock.uptimeMillis();
        r13.f23254a.put("scc_cloudservice_url", r12);
        monitor-enter(this);
        vf.b r14 = (vf.b) this.f22357b;     // Catch: Throwable -> L95
        boolean r15 = r14.f22574a;     // Catch: Throwable -> L95
        boolean r16 = r14.f22575b;     // Catch: Throwable -> L95
        String r17 = r14.d;     // Catch: Throwable -> L95
        int r18 = r14.f22576c;     // Catch: Throwable -> L95
        monitor-exit(this);     // Catch: Throwable -> L95
        if (r15 == true) goto L27;
        Log.w("scc_sdk", "cloud service not enable, skip check!");
        r13.f23255b = SystemClock.uptimeMillis();
        r13.f23254a.put("scc_report_reason", "internal_switch_off");
        r13.c();
        return;
    L27:
        if (TextUtils.isEmpty(r12) == false) goto L29;
        String r19 = null;
    L30:
        boolean r20 = false;
        if (TextUtils.isEmpty(r19) == false) goto L34;
        u r21 = null;
    L42:
        if (r21 == null) goto L47;
        androidx.constraintlayout.motion.widget.a.B(new StringBuilder("url hit allow host:"), r21.f8670b, "scc_sdk");
        String r22 = r21.f8670b;
        r13.f23254a.put("scc_report_reason", "scc_cloudservice_local_white_list");
        ConcurrentHashMap r110 = r13.f23254a;
        if (r22 != null) goto L46;
        r22 = "";
    L46:
        r110.put("scc_cs_local_white_list_matched_rule", r22);
        r13.c();
        return;
    L47:
        j r23 = yf.a.f23253a;
        r23.getClass();
        if (TextUtils.isEmpty(r12) == true) goto L59;
        monitor-enter(r23);
        Boolean r24 = (Boolean) ((LruCache) r23.f23302a).get(r12);     // Catch: Throwable -> L56
        if (r24 != null) goto L54;
    L58:
        monitor-exit(r23);     // Catch: Throwable -> L56
        goto L59
    L54:
        if (r24.booleanValue() == false) goto L58;
        r20 = true;
    L56:
        th = move-exception;
        throw th;
    L59:
        if (r20 == false) goto L61;
        androidx.constraintlayout.motion.widget.a.A("url hit allow cache:", r12, "scc_sdk");
        r13.f23254a.put("scc_report_reason", "scc_cloudservice");
        r13.f23254a.put("scc_cloudservice_check_delta", "0");
        r13.f23254a.put("scc_cloudservice_label", "cache_white");
        r13.c();
        return;
    L61:
        String r25 = p.h(r12);
        monitor-enter(this);
    L68:
        th = move-exception;
        throw th;
    L64:
        if (((ArrayList) this.f).remove(r25) == false) goto L70;
        r5 = new u(r25, 2);     // Catch: Throwable -> L68
        monitor-exit(this);     // Catch: Throwable -> L68
    L71:
        if (r5 == null) goto L73;
        androidx.constraintlayout.motion.widget.a.B(new StringBuilder("url hit user allow:"), r5.f8670b, "scc_sdk");
        r13.f23254a.put("scc_report_reason", "user_skip");
        r13.c();
        return;
    L73:
        monitor-enter(this);
    L79:
        th = move-exception;
        throw th;
    L75:
        if (((ConcurrentHashMap) this.d).containsKey(r12) == false) goto L81;
        Log.d("scc_sdk", "url already checking, skip check!");     // Catch: Throwable -> L79
        monitor-exit(this);     // Catch: Throwable -> L79
        return;
    L81:
        r13.a();     // Catch: Throwable -> L79
        ((ConcurrentHashMap) this.g).put(r12, r13);     // Catch: Throwable -> L79
        ((ScheduledExecutorService) this.f22358c).schedule(new h(7, this, r12), 5, TimeUnit.SECONDS);     // Catch: Throwable -> L79
        ((ConcurrentHashMap) this.d).putIfAbsent(r12, ((ScheduledExecutorService) this.f22358c).submit(new com.airbnb.lottie.k(r12, r17, this)));     // Catch: Throwable -> L79
        if (r16 == false) goto L84;
        ((ConcurrentHashMap) this.e).putIfAbsent(r12, ((ScheduledExecutorService) this.f22358c).submit(new l(r12, r18, r13)));     // Catch: Throwable -> L79
    L84:
        monitor-exit(this);     // Catch: Throwable -> L79
        return;
    L70:
        monitor-exit(this);     // Catch: Throwable -> L68
        goto L71
    L34:
        if (TextUtils.isEmpty(r19) == false) goto L37;
    L39:
        monitor-enter(this);
        r21 = ((vf.b) this.f22357b).a(r19);     // Catch: Throwable -> L92
        monitor-exit(this);     // Catch: Throwable -> L92
    L92:
        th = move-exception;
        throw th;
    L37:
        if (r19.endsWith("/") == false) goto L39;
        r19 = androidx.constraintlayout.motion.widget.a.n(r19, 1, 0);
        goto L39
    L29:
        r19 = Uri.parse(r12).getHost();
    L95:
        th = move-exception;
        throw th;
    L19:
        if (IIvyAIPackageResourceService.SCHEMA.equalsIgnoreCase(r11) == false) goto L98;
    L12:
        r11 = Uri.parse(r10).getScheme();
    L98:
        Log.d("scc_sdk", "url schema not http/https, skip check!");
        return;
    L100:
        com.lynx.tasm.utils.j.f(new q(this, r10, CallStackUtil.a(new Throwable("Fetch template resource failed")), 3));
    }

    @Override // fo.b
    public void b(byte[] r5) {
        com.lynx.tasm.utils.j.f(new ab.b(25, this, false, r5));
    }

    @Override // com.squareup.kotlinpoet.x
    public LinkedHashMap c() {
        return (LinkedHashMap) this.g;
    }

    public synchronized qg.c e(String r10) {
        monitor-enter(this);
        qg.c r5 = (qg.c) ((HashMap) this.d).get(r10);     // Catch: Throwable -> L15
        if (r5 == null) goto L10;
        qg.c r11 = (qg.c) this.e;     // Catch: Throwable -> L15
        monitor-exit(this);
        if (r5 != r11) goto L9;
        return null;
    L9:
        return r5;
    L10:
        String r12 = ((SharedPreferences) this.f22357b).getString(d("key_local_app_settings_data", r10), "");     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r12) == false) goto L30;
    L24:
        ((HashMap) this.d).put(r10, (qg.c) this.e);     // Catch: Throwable -> L15
        monitor-exit(this);
        return null;
    L30:
        JSONObject r13 = new JSONObject(r12);     // Catch: Throwable -> L15 JSONException -> L17
        String r14 = ((SharedPreferences) this.f22357b).getString(d("key_local_user_settings_data", r10), "");     // Catch: Throwable -> L15 JSONException -> L17
        if (TextUtils.isEmpty(r14) == true) goto L19;
        JSONObject r15 = new JSONObject(r14);     // Catch: Throwable -> L15 JSONException -> L17
    L20:
        qg.c r16 = new qg.c(((SharedPreferences) this.f22357b).getString(d("key_last_update_token", r10), ""), r13, r15);     // Catch: Throwable -> L15 JSONException -> L17
        ((HashMap) this.d).put(r10, r16);     // Catch: Throwable -> L15 JSONException -> L17
        monitor-exit(this);
        return r16;
    L19:
        r15 = new JSONObject();     // Catch: Throwable -> L15 JSONException -> L17
    L17:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public void finalize() {
        switch(this.f22356a) {
            case 11: goto L10;
            default: goto L4;
        };
    L4:
        super.finalize();
        return;
    L10:
        ((ScheduledExecutorService) this.f22358c).shutdown();     // Catch: Throwable -> L8
        super.finalize();
        return;
    L8:
        super.finalize();
    }

    public void g(int r5) {
        PrepareMeta r10 = (PrepareMeta) this.g;
        File r11 = new File(r10.getUpdatingDir(), r10.getChannel());
        if (r11.exists() == false) goto L14;
        com.bytedance.geckox.utils.d.j(r11);
    L14:
        ((la.a) this.f22357b).g(0);     // Catch: Throwable -> L7
        com.bytedance.geckox.utils.d.g(new na.a((la.a) this.f22357b), r10.getUpdatingDir().getAbsolutePath(), r10.getChannel());     // Catch: Throwable -> L7
        ((la.a) this.f22357b).d();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        int r12 = r5 + 1;
        if (r12 >= 2) goto L12;
        GeckoLogger.a("unzip failed, retry: " + th.getMessage());
        g(r12);
        return;
    L12:
        GeckoLogger.a("unzip failed, not retry: " + th.getMessage());
        com.bytedance.geckox.utils.d.j(r10.getUpdatingDir());
        throw th;
    }

    public void h(Object r5, String r10, JSONObject r11) {
        if (((JSONObject) this.f) != null) goto L5;
        this.f = new JSONObject();
    L5:
        ((JSONObject) this.f).put(r10, r5);
        r11.put(r10, r5);
    }

    public synchronized void i(qg.c r13, pg.d r14, boolean r15) {
        monitor-enter(this);
        JSONObject r5 = r13.f21511a;     // Catch: Throwable -> L8
        JSONObject r10 = r13.f21512b;     // Catch: Throwable -> L8
        qg.c r11 = e((String) r14.f21352c.f5320b);     // Catch: Throwable -> L8
        if (r11 == null) goto L142;
        JSONObject r12 = r11.f21511a;     // Catch: Throwable -> L8
        JSONObject r16 = r11.f21512b;     // Catch: Throwable -> L8
        if (r12 != null) goto L10;
        r12 = new JSONObject();     // Catch: Throwable -> L8
    L10:
        if (r16 != null) goto L12;
        r16 = new JSONObject();     // Catch: Throwable -> L8
    L12:
        if (r5 == null) goto L37;
        Iterator<String> r17 = r5.keys();     // Catch: Throwable -> L8
    L15:
        if (r17.hasNext() == false) goto L37;
        String r18 = r17.next();     // Catch: Throwable -> L8
        Object r19 = r5.opt(r18);     // Catch: Throwable -> L8 Exception -> L30
        Object r20 = r12.opt(r18);     // Catch: Throwable -> L8 Exception -> L30
        String r21 = String.valueOf(r19);     // Catch: Throwable -> L8 Exception -> L30
        String r110 = String.valueOf(r20);     // Catch: Throwable -> L8 Exception -> L30
    L18:
        if ((r19 instanceof JSONObject) == false) goto L33;
        if ((r20 instanceof JSONObject) == false) goto L33;
        JsonObject r22 = (JsonObject) new JsonParser().parse(r21);     // Catch: Throwable -> L8 Exception -> L27
        JsonObject r111 = (JsonObject) new JsonParser().parse(r110);     // Catch: Throwable -> L8 Exception -> L27
        if (r22 == null) goto L15;
        if (r22.equals(r111) == true) goto L15;
        h(r19, r18, r12);     // Catch: Throwable -> L8 Exception -> L27
    L28:
        if (TextUtils.equals(r21, r110) == true) goto L15;
        h(r19, r18, r12);     // Catch: Throwable -> L8 Exception -> L30
    L33:
        if (TextUtils.equals(r21, r110) == true) goto L15;
        h(r19, r18, r12);     // Catch: Throwable -> L8 Exception -> L30
    L30:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L8
    L37:
        if (r10 == null) goto L62;
        Iterator<String> r23 = r10.keys();     // Catch: Throwable -> L8
    L40:
        if (r23.hasNext() == false) goto L62;
        String r24 = r23.next();     // Catch: Throwable -> L8
        Object r25 = r10.opt(r24);     // Catch: Throwable -> L8 Exception -> L55
        Object r26 = r16.opt(r24);     // Catch: Throwable -> L8 Exception -> L55
        String r27 = String.valueOf(r25);     // Catch: Throwable -> L8 Exception -> L55
        String r112 = String.valueOf(r26);     // Catch: Throwable -> L8 Exception -> L55
    L43:
        if ((r25 instanceof JSONObject) == false) goto L58;
        if ((r26 instanceof JSONObject) == false) goto L58;
        JsonObject r28 = (JsonObject) new JsonParser().parse(r27);     // Catch: Throwable -> L8 Exception -> L52
        JsonObject r113 = (JsonObject) new JsonParser().parse(r112);     // Catch: Throwable -> L8 Exception -> L52
        if (r28 == null) goto L40;
        if (r28.equals(r113) == true) goto L40;
        h(r25, r24, r16);     // Catch: Throwable -> L8 Exception -> L52
    L53:
        if (TextUtils.equals(r27, r112) == true) goto L40;
        h(r25, r24, r16);     // Catch: Throwable -> L8 Exception -> L55
    L58:
        if (TextUtils.equals(r27, r112) == true) goto L40;
        h(r25, r24, r16);     // Catch: Throwable -> L8 Exception -> L55
    L55:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L8
    L62:
        ((HashMap) this.d).put((String) r14.f21352c.f5320b, r11);     // Catch: Throwable -> L8
        SharedPreferences.Editor r29 = ((SharedPreferences) this.f22357b).edit();     // Catch: Throwable -> L8
        r29.putString(d("key_last_update_token", (String) r14.f21352c.f5320b), r13.f21513c);     // Catch: Throwable -> L8 Exception -> L65
    L188:
        String r114 = d("key_local_app_settings_data", (String) r14.f21352c.f5320b);     // Catch: Throwable -> L8 Exception -> L70
        if (r5 == null) goto L72;
        String r30 = r12.toString();     // Catch: Throwable -> L8 Exception -> L70
    L73:
        r29.putString(r114, r30);     // Catch: Throwable -> L8 Exception -> L70
    L172:
        String r115 = d("key_local_user_settings_data", (String) r14.f21352c.f5320b);     // Catch: Throwable -> L8 Exception -> L79
        if (r10 == null) goto L81;
        String r31 = r16.toString();     // Catch: Throwable -> L8 Exception -> L79
    L82:
        r29.putString(r115, r31);     // Catch: Throwable -> L8 Exception -> L79
    L85:
        r29.apply();     // Catch: Throwable -> L8
        Context r116 = (Context) this.g;     // Catch: Throwable -> L8
        if (r116 != null) goto L89;
    L166:
        monitor-exit(this);
        return;
    L89:
        if (((SharedPreferences) this.f22358c) != null) goto L91;
        this.f22358c = r116.getSharedPreferences("diff_settings.sp", 0);     // Catch: Throwable -> L8
    L91:
        SharedPreferences.Editor r117 = ((SharedPreferences) this.f22358c).edit();     // Catch: Throwable -> L8
        if (r15 == false) goto L100;
        String r118 = ((SharedPreferences) this.f22358c).getString(d("key_local_app_settings_data", (String) r14.f21352c.f5320b), "");     // Catch: Throwable -> L8 Exception -> L97
        if (TextUtils.isEmpty(r118) == true) goto L100;
        r117.putString(d("key_local_settings_dff_last", (String) r14.f21352c.f5320b), r118);     // Catch: Throwable -> L8 Exception -> L97
    L97:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L8
    L100:
        if (((JSONObject) this.f) != null) goto L176;
        r117.apply();     // Catch: Throwable -> L8
        goto L166
    L176:
        String r32 = ((SharedPreferences) this.f22358c).getString(d("key_diff_app_settings_timestamp", (String) r14.f21352c.f5320b), "");     // Catch: Throwable -> L8 Exception -> L128
        JSONObject r33 = new JSONObject();     // Catch: Throwable -> L8 Exception -> L128
    L108:
        e = e;
        JSONObject r34 = null;
    L130:
        e.printStackTrace();     // Catch: Throwable -> L8
    L131:
        if (r33 != null) goto L186;
    L136:
        if (r34 != null) goto L174;
    L141:
        r117.apply();     // Catch: Throwable -> L8
        this.f = null;     // Catch: Throwable -> L8
        goto L166
    L174:
        r117.putString(d("key_diff_app_settings_timestamp", (String) r14.f21352c.f5320b), r34.toString());     // Catch: Throwable -> L8 Exception -> L139
    L139:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L8
        goto L141
    L186:
        r33.put("settings_sdk_timestamp", System.currentTimeMillis());     // Catch: Throwable -> L8 Exception -> L134
        r117.putString(d("key_local_app_settings_data", (String) r14.f21352c.f5320b), r33.toString());     // Catch: Throwable -> L8 Exception -> L134
    L134:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L8
        goto L136
    L106:
        if (TextUtils.isEmpty(r32) == true) goto L110;
        r34 = new JSONObject(r32);     // Catch: Throwable -> L8 Exception -> L108
    L170:
        Iterator<String> r35 = ((JSONObject) this.f).keys();     // Catch: Throwable -> L8 Exception -> L115
        long r36 = System.currentTimeMillis();     // Catch: Throwable -> L8 Exception -> L115
    L113:
        if (r35.hasNext() == false) goto L117;
        String r37 = r35.next();     // Catch: Throwable -> L8 Exception -> L115
        r33.put(r37, ((JSONObject) this.f).opt(r37));     // Catch: Throwable -> L8 Exception -> L115
        r34.put(r37, r36);     // Catch: Throwable -> L8 Exception -> L115
        goto L113
    L117:
        Iterator<String> r38 = r34.keys();     // Catch: Throwable -> L8 Exception -> L115
        ArrayList r39 = new ArrayList();     // Catch: Throwable -> L8 Exception -> L115
    L119:
        if (r38.hasNext() == false) goto L123;
        String r40 = r38.next();     // Catch: Throwable -> L8 Exception -> L115
        if ((r36 - r34.optLong(r40, r36)) <= 259200000) goto L119;
        r39.add(r40);     // Catch: Throwable -> L8 Exception -> L115
        goto L119
    L123:
        Iterator r41 = r39.iterator();     // Catch: Throwable -> L8 Exception -> L115
    L124:
        if (r41.hasNext() == false) goto L131;
        r34.remove((String) r41.next());     // Catch: Throwable -> L8 Exception -> L115
    L115:
        e = e;
        goto L130
    L110:
        r34 = new JSONObject();     // Catch: Throwable -> L8 Exception -> L108
    L128:
        e = e;
        r33 = null;
        r34 = null;
        goto L130
    L81:
        r31 = "";
    L79:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L8
        goto L85
    L72:
        r30 = "";
    L70:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L8
        goto L172
    L65:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L8
        goto L188
    L142:
        ((HashMap) this.d).put((String) r14.f21352c.f5320b, r13);     // Catch: Throwable -> L8
        SharedPreferences.Editor r119 = ((SharedPreferences) this.f22357b).edit();     // Catch: Throwable -> L8
        r119.putString(d("key_last_update_token", (String) r14.f21352c.f5320b), r13.f21513c);     // Catch: Throwable -> L8 Exception -> L145
    L180:
        String r120 = d("key_local_app_settings_data", (String) r14.f21352c.f5320b);     // Catch: Throwable -> L8 Exception -> L150
        if (r5 == null) goto L152;
        String r42 = r5.toString();     // Catch: Throwable -> L8 Exception -> L150
    L153:
        r119.putString(r120, r42);     // Catch: Throwable -> L8 Exception -> L150
    L184:
        String r121 = d("key_local_user_settings_data", (String) r14.f21352c.f5320b);     // Catch: Throwable -> L8 Exception -> L159
        if (r10 == null) goto L161;
        String r122 = r10.toString();     // Catch: Throwable -> L8 Exception -> L159
    L162:
        r119.putString(r121, r122);     // Catch: Throwable -> L8 Exception -> L159
    L165:
        r119.apply();     // Catch: Throwable -> L8
        goto L166
    L161:
        r122 = "";
    L159:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L8
        goto L165
    L152:
        r42 = "";
    L150:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L8
        goto L184
    L145:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    public void k() {
        StringBuilder r5 = new StringBuilder("[");
        PrepareMeta r10 = (PrepareMeta) this.g;
        r5.append(r10);
        r5.append("]start unzip");
        GeckoLogger.a(r5.toString());
        long r11 = System.currentTimeMillis();
        g(0);     // Catch: Exception -> L14
        File r12 = (File) this.e;
        if (com.bytedance.geckox.utils.d.j(r12) == false) goto L13;
        if (new File(r10.getUpdatingDir(), r10.getChannel()).renameTo(r12) == false) goto L11;
        ((la.a) this.f22357b).b().delete();
        ((com.bytedance.iesgurd.meta.h) this.f22358c).g = System.currentTimeMillis() - r11;
        return;
    L11:
        throw new UpdateException(ErrorCode.e, "rename zip file failed");
    L13:
        throw new UpdateException(ErrorCode.e, "delete res dir failed");
    L14:
        e = move-exception;
        throw new UpdateException(ErrorCode.e, e.getMessage());
    }

    public boolean l() {
        Log.w("EglHelper", "createSurface()  tid=" + Thread.currentThread().getId());
        if (((EGL10) this.f22358c) == null) goto L37;
        if (((EGLDisplay) this.d) == null) goto L35;
        if (((EGLConfig) this.f) == null) goto L33;
        m();
        GLTextureView r5 = (GLTextureView) ((WeakReference) this.f22357b).get();
        EGLSurface r10 = null;
        if (r5 == null) goto L16;
        zp.d r11 = r5.g;
        EGL10 r12 = (EGL10) this.f22358c;
        EGLDisplay r13 = (EGLDisplay) this.d;
        EGLConfig r14 = (EGLConfig) this.f;
        SurfaceTexture r15 = r5.getSurfaceTexture();
        ((f) r11).getClass();
        r10 = r12.eglCreateWindowSurface(r13, r14, r15, null);     // Catch: IllegalArgumentException -> L13
    L15:
        this.e = r10;
    L17:
        EGLSurface r16 = (EGLSurface) this.e;
        if (r16 == null) goto L29;
        if (r16 == EGL10.EGL_NO_SURFACE) goto L29;
        if (((EGL10) this.f22358c).eglMakeCurrent((EGLDisplay) this.d, r16, r16, (EGLContext) this.g) == true) goto L26;
        Log.w("EGLHelper", "eglMakeCurrent failed: " + ((EGL10) this.f22358c).eglGetError());
        return false;
    L26:
        return true;
    L29:
        if (((EGL10) this.f22358c).eglGetError() != 12299) goto L31;
        Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
    L31:
        return false;
    L13:
        e = move-exception;
        Log.e("GLTextureView", "eglCreateWindowSurface", e);
        goto L15
    L16:
        this.e = null;
        goto L17
    L33:
        throw new RuntimeException("mEglConfig not initialized");
    L35:
        throw new RuntimeException("eglDisplay not initialized");
    L37:
        throw new RuntimeException("egl not initialized");
    }

    public void m() {
        EGLSurface r5 = (EGLSurface) this.e;
        if (r5 == null) goto L11;
        EGLSurface r10 = EGL10.EGL_NO_SURFACE;
        if (r5 == r10) goto L12;
        ((EGL10) this.f22358c).eglMakeCurrent((EGLDisplay) this.d, r10, r10, EGL10.EGL_NO_CONTEXT);
        GLTextureView r11 = (GLTextureView) ((WeakReference) this.f22357b).get();
        if (r11 == null) goto L9;
        zp.d r12 = r11.g;
        EGL10 r13 = (EGL10) this.f22358c;
        EGLDisplay r14 = (EGLDisplay) this.d;
        EGLSurface r15 = (EGLSurface) this.e;
        ((f) r12).getClass();
        r13.eglDestroySurface(r14, r15);
    L9:
        this.e = null;
        return;
    L12:
        return;
    }

    public void n() {
        Log.w("EglHelper", "finish() tid=" + Thread.currentThread().getId());
        if (((EGLContext) this.g) == null) goto L10;
        GLTextureView r5 = (GLTextureView) ((WeakReference) this.f22357b).get();
        if (r5 == null) goto L9;
        zp.c r10 = r5.f;
        EGL10 r11 = (EGL10) this.f22358c;
        EGLDisplay r12 = (EGLDisplay) this.d;
        EGLContext r13 = (EGLContext) this.g;
        ((i) r10).getClass();
        if (r11.eglDestroyContext(r12, r13) == true) goto L9;
        Log.e("DefaultContextFactory", "display:" + r12 + " context: " + r13);
        StringBuilder r14 = new StringBuilder("tid=");
        r14.append(Thread.currentThread().getId());
        Log.i("DefaultContextFactory", r14.toString());
        p(r11.eglGetError(), "eglDestroyContex");
    L9:
        this.g = null;
    L10:
        EGLDisplay r15 = (EGLDisplay) this.d;
        if (r15 == null) goto L14;
        ((EGL10) this.f22358c).eglTerminate(r15);
        this.d = null;
        return;
    }

    public void o() {
        Log.w("EglHelper", "start() tid=" + Thread.currentThread().getId());
        EGL10 r5 = (EGL10) EGLContext.getEGL();
        this.f22358c = r5;
        EGLDisplay r10 = r5.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.d = r10;
        if (r10 == EGL10.EGL_NO_DISPLAY) goto L55;
        if (((EGL10) this.f22358c).eglInitialize(r10, new int[2]) == false) goto L53;
        GLTextureView r11 = (GLTextureView) ((WeakReference) this.f22357b).get();
        if (r11 != null) goto L9;
        this.f = null;
        this.g = null;
    L37:
        EGLContext r12 = (EGLContext) this.g;
        if (r12 != null) goto L40;
    L41:
        this.g = null;
        p(((EGL10) this.f22358c).eglGetError(), "createContext");
    L42:
        Log.w("EglHelper", "createContext " + ((EGLContext) this.g) + " tid=" + Thread.currentThread().getId());
        this.e = null;
        return;
    L40:
        if (r12 != EGL10.EGL_NO_CONTEXT) goto L42;
    L9:
        zp.b r13 = r11.e;
        EGL10 r14 = (EGL10) this.f22358c;
        EGLDisplay r15 = (EGLDisplay) this.d;
        zp.a r16 = (zp.a) r13;
        int[] r17 = new int[1];
        if (r14.eglChooseConfig(r15, r16.f23555a, null, 0, r17) == false) goto L50;
        int r18 = r17[0];
        if (r18 <= 0) goto L49;
        EGLConfig[] r19 = new EGLConfig[r18];
        if (r14.eglChooseConfig(r15, r16.f23555a, r19, r18, r17) == false) goto L47;
        int r20 = 0;
    L16:
        if (r20 >= r18) goto L30;
        EGLConfig r21 = r19[r20];
        int r22 = r16.a(r14, r15, r21, 12325);
        int r110 = r16.a(r14, r15, r21, 12326);
        if (r22 < r16.f23558h) goto L29;
        if (r110 < 0) goto L29;
        int r23 = r16.a(r14, r15, r21, 12324);
        int r111 = r16.a(r14, r15, r21, 12323);
        int r112 = r16.a(r14, r15, r21, 12322);
        int r113 = r16.a(r14, r15, r21, 12321);
        if (r23 != r16.d) goto L29;
        if (r111 != r16.e) goto L29;
        if (r112 != r16.f) goto L29;
        if (r113 != r16.g) goto L29;
    L31:
        if (r21 == null) goto L45;
        this.f = r21;
        zp.c r24 = r11.f;
        EGL10 r25 = (EGL10) this.f22358c;
        EGLDisplay r26 = (EGLDisplay) this.d;
        int r27 = ((GLTextureView) ((i) r24).f20153a).f11369i;
        int[] r28 = {12440, r27, 12344};
        EGLContext r29 = EGL10.EGL_NO_CONTEXT;
        if (r27 != 0) goto L36;
        r28 = null;
    L36:
        this.g = r25.eglCreateContext(r26, r21, r29, r28);
        goto L37
    L45:
        throw new IllegalArgumentException("No config chosen");
    L29:
        r20 = r20 + 1;
        goto L16
    L30:
        r21 = null;
        goto L31
    L47:
        throw new IllegalArgumentException("eglChooseConfig#2 failed");
    L49:
        throw new IllegalArgumentException("No configs match configSpec");
    L50:
        Log.getStackTraceString(new IllegalArgumentException("eglChooseConfig failed"));
        zp.f r30 = GLTextureView.f11364k;
        r16.f23556b.getClass();
        throw new IllegalArgumentException("eglChooseConfig failed");
    L53:
        throw new RuntimeException("eglInitialize failed");
    L55:
        throw new RuntimeException("eglGetDisplay failed");
    }

    public d(int r5) {
        this.f22356a = r5;
        switch(r5) {
            case 10: goto L12;
            case 11: goto L10;
            case 12: goto L9;
            case 13: goto L6;
            default: goto L4;
        };
    L4:
        this.d = new i4.a(0);
        this.e = new n(this);
        this.f = new x0(this);
        Intrinsics.checkNotNullParameter(this, "airSolutionContext");
        z r10 = new z();
        r10.f23549a = this;
        this.g = r10;
        return;
    L6:
        this.e = new ArrayList();
        this.f = new LinkedHashMap();
        this.g = new androidx.core.view.inputmethod.a(this, 16);
        return;
    L10:
        this.f22358c = Executors.newScheduledThreadPool(3);
        this.d = new ConcurrentHashMap();
        this.e = new ConcurrentHashMap();
        this.f = new ArrayList();
        this.f22357b = new vf.b(vf.a.d);
        this.g = new ConcurrentHashMap();
        return;
    L12:
        this.f22358c = "";
        this.d = "";
        this.e = new Bundle();
        this.g = new t9.a();
        return;
    }

    public d(Context r5) {
        this.f22356a = 0;
        this.d = new HashMap();
        this.e = new qg.c("", null, null);
        this.g = r5;
        if (og.a.a(SettingsConfigProvider.class) != null) goto L9;
        if (((SharedPreferences) this.f22357b) != null) goto L10;
        this.f22357b = r5.getSharedPreferences("__local_settings_data.sp", 0);
        return;
    L10:
        return;
    L9:
        throw new ClassCastException();
    }

    public d(PrepareMeta r10) {
        this.f22356a = 7;
        this.g = r10;
        la.a r5 = r10.getUpdateBuffer();
        if (r5 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        this.f22357b = r5;
        com.bytedance.iesgurd.meta.h r11 = r10.getStatisticModel();
        if (r11 != null) goto L8;
        Intrinsics.throwNpe();
    L8:
        this.f22358c = r11;
        File r12 = r10.getUpdatingDir().getParentFile();
        this.d = r12;
        this.e = new File(r10.getUpdatingDir(), "res");
        this.f = new File(r12, r10.getLocalVersion() + "/res");
    }

    public d(LynxTemplateRender r5, String r10, com.lynx.tasm.x r11) {
        this.f22356a = 2;
        this.g = r5;
        this.d = r10;
        this.f = r11;
    }

    public d(String r5) {
        this.f22356a = 6;
        Boolean r10 = Boolean.FALSE;
        Intrinsics.checkNotNullParameter(r5, "eventName");
        this.f22357b = r5;
        this.f22358c = null;
        this.f = null;
        this.d = null;
        this.e = r10;
        this.g = null;
    }

    public d(sj.k r5, WeakHandler r10) {
        this.f22356a = 9;
        this.f22358c = new AtomicBoolean(false);
        this.g = new jm.a(this, 5);
        this.e = r5;
        this.f = r10;
    }

    public d(LynxTemplateRender r5, String r10, String r11) {
        this.f22356a = 2;
        this.g = r5;
        this.f22358c = r11;
        this.d = r10;
    }

    public d(LynxTemplateRender r5, String r10, TemplateData r11) {
        this.f22356a = 2;
        this.g = r5;
        this.f22357b = r11;
        this.d = r10;
    }

    public d(LynxTemplateRender r5, String r10, Map r11) {
        this.f22356a = 2;
        this.g = r5;
        this.e = r11;
        this.d = r10;
    }

    public d(MotionLayout r5) {
        this.f22356a = 3;
        this.f22358c = new ArrayList();
        this.e = "ViewTransitionController";
        this.g = new ArrayList();
        this.f22357b = r5;
    }

    public d(String r5, a0 r10) {
        this.f22356a = 4;
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "type");
        this.f22357b = r5;
        this.f22358c = r10;
        Set r11 = com.squareup.kotlinpoet.e.f15130c;
        this.d = new com.squareup.kotlinpoet.d();
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = new LinkedHashMap();
    }

    public File a() {
        PrepareMetaPackage r5 = ((PrepareMeta) this.g).getFullPackage();
        if (r5 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        String r10 = r5.getUrlList().get(0);
        int r11 = StringsKt.u(r10, "/");
        if (r11 == (-1)) goto L18;
        int r12 = r11 + 1;
        if (r10 == null) goto L16;
        String r13 = r10.substring(r12);
        if (r13.length() == 0) goto L14;
        return new File((File) this.e, r13);
    L14:
        throw new RuntimeException("url path illegal, url:".concat(r10));
    L16:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L18:
        throw new RuntimeException(td.d.b("url path illegal, url:", r10));
    }
}
