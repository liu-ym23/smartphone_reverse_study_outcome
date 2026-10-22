package s6;

import a3.i;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import androidx.collection.ArrayMap;
import androidx.core.app.NotificationCompat;
import androidx.core.util.Consumer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.bumptech.glide.load.engine.bitmap_recycle.h;
import com.bytedance.ai.bridge.core.AIBridgeMethod$Error;
import com.bytedance.ai.model.m;
import com.bytedance.ai.monitor.bridge.BridgeType;
import com.bytedance.ai.widget.o;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.AppDataCenter;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.util.NativeTools;
import com.bytedance.ies.bullet.service.base.PoolResult;
import com.bytedance.ies.bullet.service.base.k;
import com.bytedance.ies.bullet.service.base.x;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.google.gson.JsonObject;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.Callback;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.behavior.s0;
import com.obric.launcher.widget.R$id;
import com.obric.oui.orecyclerview.widget.w0;
import en.l;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.sequences.SequencesKt;
import kotlinx.serialization.internal.ClassValueParametrizedCache$getgIAlus$$inlined$getOrSet$1;
import kotlinx.serialization.internal.j0;
import kotlinx.serialization.internal.r0;
import kotlinx.serialization.internal.x0;
import kotlinx.serialization.internal.y0;
import l9.n;
import mt.b0;
import mt.j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pn.g;
import ym.p;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements k, g, b0, j, y0, cj.j, s8.b {
    public static volatile c d = null;
    public static int e = 80;
    public static Boolean f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f21827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f21828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f21829c;

    public /* synthetic */ c(int r5, Object r10, Object r11) {
        this.f21827a = r5;
        this.f21828b = r10;
        this.f21829c = r11;
    }

    public static void i(z8.c r10, HashMap r11) {
        if (r11.isEmpty() == true) goto L21;
        JSONArray r5 = new JSONArray();
        Iterator r12 = r11.keySet().iterator();
    L7:
        if (r12.hasNext() == false) goto L13;
        String r13 = (String) r12.next();
        String r14 = NativeTools.l((String) r11.get(r13));
        JSONObject r15 = new JSONObject();     // Catch: JSONException -> L11
        r15.put("lib_name", r13);     // Catch: JSONException -> L11
        r15.put("lib_uuid", r14);     // Catch: JSONException -> L11
        r5.put(r15);     // Catch: JSONException -> L11
    L11:
        e = move-exception;
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", e);
        goto L7
    L13:
        mh.e.g(r5, "crash_lib_uuid", r10.f23416a);
        return;
    }

    public static boolean j() {
        Boolean r5 = f;
        if (r5 != null) goto L5;
        String[] r10 = {"/data/local/su", "/data/local/bin/su", "/data/local/xbin/su", "/system/xbin/su", "/system/bin/su", "/system/bin/.ext/su", "/system/bin/failsafe/su", "/system/sd/xbin/su", "/system/usr/we-need-root/su", "/sbin/su", "/su/bin/su"};
        int r11 = 0;
    L8:
        if (r11 >= 11) goto L18;
    L15:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
    L17:
        r11 = r11 + 1;
        goto L8
    L11:
        if (new File(r10[r11]).exists() == false) goto L17;
        f = Boolean.TRUE;     // Catch: Throwable -> L15
        return true;
    L18:
        f = Boolean.FALSE;
        return false;
    L5:
        return r5.booleanValue();
    }

    public static c w() {
        if (d != null) goto L16;
        monitor-enter(c.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (d != null) goto L11;
        c r5 = new c(0, false);     // Catch: Throwable -> L9
        r5.f21828b = new CopyOnWriteArraySet();     // Catch: Throwable -> L9
        r5.f21829c = new ConcurrentHashMap();     // Catch: Throwable -> L9
        d = r5;     // Catch: Throwable -> L9
    L11:
        monitor-exit(c.class);     // Catch: Throwable -> L9
    L16:
        return d;
    }

    public void A(h r5, Object r10) {
        HashMap r11 = (HashMap) this.f21829c;
        com.bumptech.glide.load.engine.bitmap_recycle.c r12 = (com.bumptech.glide.load.engine.bitmap_recycle.c) r11.get(r5);
        if (r12 != null) goto L5;
        r12 = new com.bumptech.glide.load.engine.bitmap_recycle.c(r5);
        r12.d = r12;
        com.bumptech.glide.load.engine.bitmap_recycle.c r13 = (com.bumptech.glide.load.engine.bitmap_recycle.c) this.f21828b;
        r12.d = r13.d;
        r12.f1449c = r13;
        r13.d = r12;
        r12.d.f1449c = r12;
        r11.put(r5, r12);
    L7:
        if (r12.f1448b != null) goto L9;
        r12.f1448b = new ArrayList();
    L9:
        r12.f1448b.add(r10);
        return;
    L5:
        r5.a();
        goto L7
    }

    public Object B() {
        com.bumptech.glide.load.engine.bitmap_recycle.c r5 = (com.bumptech.glide.load.engine.bitmap_recycle.c) this.f21828b;
        com.bumptech.glide.load.engine.bitmap_recycle.c r10 = r5.d;
    L3:
        Object r11 = null;
        if (r10.equals(r5) == true) goto L14;
        ArrayList r12 = r10.f1448b;
        if (r12 == null) goto L8;
        int r13 = r12.size();
    L9:
        if (r13 <= 0) goto L11;
        r11 = r10.f1448b.remove(r13 - 1);
    L11:
        if (r11 != null) goto L12;
        com.bumptech.glide.load.engine.bitmap_recycle.c r14 = r10.d;
        r14.f1449c = r10.f1449c;
        r10.f1449c.d = r14;
        HashMap r15 = (HashMap) this.f21829c;
        h r16 = r10.f1447a;
        r15.remove(r16);
        r16.a();
        r10 = r10.d;
        goto L3
    L12:
        return r11;
    L8:
        r13 = 0;
        goto L9
    L14:
        return null;
    }

    public void C(int r5, Bundle r10, Messenger r11) {
        Message r12 = Message.obtain();
        r12.what = r5;
        r12.arg1 = 1;
        r12.setData(r10);
        r12.replyTo = r11;
        ((Messenger) this.f21828b).send(r12);
    }

    @Override // pn.g
    public HashMap a() {
        HashMap r5 = new HashMap();
        LynxError r10 = (LynxError) this.f21828b;
        r5.put("code", Integer.valueOf(r10.a()));
        String r11 = r10.f9995j;
        String r12 = "";
        if (r11 != null) goto L5;
        r11 = "";
    L5:
        r5.put("level", r11);
        String r13 = r10.f9993h;
        if (r13 == null) goto L9;
        r12 = r13;
    L9:
        r5.put("summary_message", r12);
        return r5;
    }

    /* JADX WARN: Type inference failed for: r5v7, types: [kotlin.jvm.functions.Function2, kotlin.jvm.internal.Lambda] */
    @Override // kotlinx.serialization.internal.y0
    public Object b(KClass r10, ArrayList r11) {
        Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);
        Intrinsics.checkNotNullParameter(r11, "types");
        r0 r5 = (r0) androidx.room.b.b((com.google.common.util.concurrent.r0) this.f21829c, JvmClassMappingKt.getJavaClass(r10));
        Object r12 = r5.f19338a.get();
        if (r12 != null) goto L6;
        r12 = r5.a(new ClassValueParametrizedCache$getgIAlus$$inlined$getOrSet$1());
    L6:
        x0 r13 = (x0) r12;
        ArrayList r14 = new ArrayList(CollectionsKt.h(r11));
        Iterator r15 = r11.iterator();
    L8:
        if (r15.hasNext() == false) goto L10;
        r14.add(new j0((KType) r15.next()));
        goto L8
    L10:
        ConcurrentHashMap r16 = r13.f19369a;
        Object r17 = r16.get(r14);
        if (r17 != null) goto L21;
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L14
        Object r19 = Result.m124constructorimpl((kotlinx.serialization.c) ((Lambda) this.f21828b).mo2invoke(r10, r11));     // Catch: Throwable -> L14
    L16:
        Result r20 = Result.m123boximpl(r19);
        Object r21 = r16.putIfAbsent(r14, r20);
        if (r21 != null) goto L19;
        r17 = r20;
        goto L21
    L19:
        r17 = r21;
    L14:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r19 = Result.m124constructorimpl(ResultKt.createFailure(th));
    L21:
        return ((Result) r17).m133unboximpl();
    }

    @Override // com.bytedance.ies.bullet.service.base.k
    public void c(PoolResult r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "result");
        ((com.bytedance.ies.bullet.service.preload.d) this.f21828b).getClass();
        JSONObject r11 = com.bytedance.ies.bullet.service.preload.d.h(-2, "load failed", false);
        ((sc.a) this.f21829c).a(r11);
    }

    @Override // s8.b
    public void d(Intent r5) {
        Context r10 = (Context) this.f21828b;
        r5.setComponent(new ComponentName(r10, (Class) ((p) this.f21829c).f23313c));     // Catch: Throwable -> L5
        r10.startService(r5);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }

    public void e(int r5, int r10, Callback r11) {
        LynxLog.b(2, "UIList", com.lynx.tasm.base.h.b(r5, r10, "ListScroller scrollToPositionNoSmooth: position=", ", offset="));
        w0 r12 = (w0) this.f21829c;
        if (r12 != null) goto L5;
    L10:
        l r13 = (l) this.f21828b;
        if (r13 == null) goto L13;
        r13.stopScroll();
        r13.stopNestedScroll();
    L13:
        RecyclerView.LayoutManager r14 = r13.getLayoutManager();
        if ((r14 instanceof LinearLayoutManager) == false) goto L17;
        ((LinearLayoutManager) r14).scrollToPositionWithOffset(r5, r10);
    L19:
        if (r11 == null) goto L23;
        r11.invoke(new Object[]{0});
        return;
    L23:
        return;
    L17:
        if ((r14 instanceof StaggeredGridLayoutManager) == false) goto L19;
        ((StaggeredGridLayoutManager) r14).scrollToPositionWithOffset(r5, r10);
        goto L19
    L5:
        if (r12.d == false) goto L10;
        LynxLog.b(4, "UIList", "ListScroller scrollToPositionSmoothly is scrolling ");
        if (r11 == null) goto L22;
        r11.invoke(new Object[]{1, "dumplicated, scrollToPositionSmoothly is working"});
        return;
    }

    public void f(bj.a r13) {
        Intrinsics.checkNotNullParameter(r13, NotificationCompat.CATEGORY_CALL);
        String r5 = (String) ((HashMap) this.f21829c).remove(r13.f934c);
        if (r5 == null) goto L5;
        AtomicBoolean r10 = z2.d.f23373a;
        int r11 = r13.f938k;
        q7.a r12 = new q7.a(15, r5, false, r13);
        String r14 = r13.f932a;
        Intrinsics.checkNotNullParameter(r14, "bridgeName");
        Intrinsics.checkNotNullParameter(r12, "builder");
        z2.d.a(new s0(r14, r11, r12, System.currentTimeMillis()));
        i r15 = i.f83a;
        BridgeType r16 = BridgeType.f2388c;
        String r17 = r13.f932a;
        Intrinsics.checkNotNullParameter(r17, "name");
        Intrinsics.checkNotNullParameter(r16, "type");
        z2.d.b("applet_old_bridge", new com.bytedance.ies.web.jsbridge2.p(1, r17, r16, r5, r13));
    L5:
        c r18 = (c) this.f21828b;
        if (r18 == null) goto L9;
        r18.f(r13);
        return;
    }

    public void g(JSONObject r12) {
        i9.g r11 = (i9.g) ((i4.a) this.f21828b).f17502b;
        String r5 = r11.f17552c;
        String r10 = r11.e;
        String r13 = r11.d;
        JSONArray r14 = r12.optJSONArray("native_log");
        if (r14 != null) goto L6;
        Pair r15 = new Pair("unknown_err", IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
    L58:
        JSONObject r16 = new JSONObject();
        r16.put((String) r15.first, r15.second);     // Catch: JSONException -> L61
        r16.put("signal", r5);     // Catch: JSONException -> L61
        io.reactivex.exceptions.a.i("native_crash_watch: " + ((String) r15.first));     // Catch: JSONException -> L61
    L63:
        z8.c.l(r12, "filters", "native_crash_watch", r15.first);
        z8.c.l(r12, "filters", "native_crash_watch_value", String.valueOf(r15.second));
        n.b("testEvent", r16, null);
        return;
    L61:
        e = move-exception;
        e.printStackTrace();
        goto L63
    L6:
        if (r11.f == false) goto L8;
        r15 = new Pair("normal", IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
        goto L58
    L8:
        int r17 = 0;
        int r18 = 0;
    L10:
        if (r18 >= r14.length()) goto L17;
        String r19 = r14.optString(r18);
        if (r19.endsWith(")") == false) goto L16;
        if (r19.contains("[xcrash] child terminated by a signal") == false) goto L16;
        String r20 = androidx.constraintlayout.motion.widget.a.n(r19, 1, r19.lastIndexOf(40) + 1);
    L18:
        if (r20 == null) goto L21;
        r15 = new Pair("xcrash_crash", r20);
        goto L58
    L21:
        if (mh.e.m(r14) == true) goto L44;
        int r21 = 0;
    L24:
        if (r21 >= r14.length()) goto L44;
        Object r22 = r14.opt(r21);
        if ((r22 instanceof String) == false) goto L44;
        if (((String) r22).contains("[xcrash] enter") == true) goto L31;
        r21 = r21 + 1;
        goto L24
    L31:
        if (mh.e.m(r14) == true) goto L42;
        int r23 = 0;
    L34:
        if (r23 >= r14.length()) goto L42;
        Object r24 = r14.opt(r23);
        if ((r24 instanceof String) == false) goto L42;
        if (((String) r24).contains("[xcrash] exit") == true) goto L44;
        r23 = r23 + 1;
    L42:
        r15 = new Pair("xcrash_block", IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
    L44:
        String[] r25 = r10.split("\n");
        int r26 = r25.length;
        int r27 = 0;
    L45:
        if (r17 >= r26) goto L50;
        if (r25[r17].trim().startsWith("#") == false) goto L49;
        r27 = r27 + 1;
    L49:
        r17 = r17 + 1;
        goto L45
    L50:
        if (r27 > 1) goto L53;
        r15 = new Pair("backtrace_err", IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
        goto L58
    L53:
        if (r5.contains("SIGABRT") == true) goto L55;
    L57:
        r15 = new Pair("normal", IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
        goto L58
    L55:
        if (TextUtils.isEmpty(r13) == false) goto L57;
        r15 = new Pair("abort_nomsg", IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
    L16:
        r18 = r18 + 1;
        goto L10
    L17:
        r20 = null;
        goto L18
    }

    public void h(z8.c r5) {
        i4.a r10 = (i4.a) this.f21828b;     // Catch: Throwable -> L14
        if (r10 != null) goto L24;
    L21:
        return;
    L24:
        i9.g r11 = (i9.g) r10.f17502b;     // Catch: Throwable -> L16
        String r12 = r11.f17551b;     // Catch: Throwable -> L16
        if (r12 == null) goto L21;
        if (r11.e == null) goto L21;
        if (r12.contains("XAsanTracker") == false) goto L21;
        if (r11.e.contains("libnpth_xasan") == false) goto L21;
        File r13 = new File(com.bytedance.crash.util.g.h(com.bytedance.crash.n.f4057a), x8.a.f22994q);     // Catch: Throwable -> L14
        File r14 = new File(com.bytedance.crash.util.g.h(com.bytedance.crash.n.f4057a), x8.a.f22993p);     // Catch: Throwable -> L14
        mh.e.g("gwp_asan", "config_crash", r5.f23416a);     // Catch: Throwable -> L14
        r13.renameTo(new File(com.bytedance.crash.util.g.h(com.bytedance.crash.n.f4057a), x8.a.f22995r));     // Catch: Throwable -> L14
        cl.a.I(r13);     // Catch: Throwable -> L14
        cl.a.C(r14);     // Catch: Throwable -> L14
        goto L21
    L16:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();     // Catch: Throwable -> L14
        m.b.h("NPTH_CATCH", th);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
    }

    public boolean k(bj.a r10, cj.b r11, com.bytedance.sdk.xbridge.cn.protocol.e r12) {
        int r5 = 0;
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "callback");
        Lazy r13 = com.bytedance.ai.model.p.f2292a;
        View r14 = (View) r11.f1189a.e.get();
        w0.e r15 = null;
        if (r14 == null) goto L37;
        Object r16 = r14.getTag(R$id.applet_ai_container_tag);
        if ((r16 instanceof WeakReference) == false) goto L8;
        WeakReference r17 = (WeakReference) r16;
    L9:
        if (r17 == null) goto L18;
        Object r18 = r17.get();
        if (r18 == null) goto L18;
        if ((r18 instanceof w0.e) == false) goto L15;
        w0.e r19 = (w0.e) r18;
    L16:
        if (r19 == null) goto L18;
    L17:
        r15 = r19;
        goto L37
    L15:
        r19 = null;
    L18:
        r19 = (com.bytedance.ai.model.widgets.a) SequencesKt.firstOrNull(SequencesKt.filter(SequencesKt.map(MapsKt.asSequence(com.bytedance.ai.model.p.f2293b), new m(r5)), new com.bytedance.ai.bridge.method.net.e(r14, 2)));
        if (r19 != null) goto L17;
        com.bytedance.ai.widget.l r20 = o.f3079j;
        monitor-enter(r20);
        Iterator r21 = CollectionsKt.e(o.f3080k).iterator();     // Catch: Throwable -> L34
    L25:
        if (r21.hasNext() == false) goto L36;
        o r22 = (o) ((WeakReference) r21.next()).get();     // Catch: Throwable -> L34
        if (r22 == null) goto L30;
        com.bytedance.ai.widget.contianer.f r23 = r22.c(new com.bytedance.ai.widget.g(r5, r14));     // Catch: Throwable -> L34
    L31:
        if (r23 == null) goto L25;
        monitor-exit(r20);
        r15 = r23;
        goto L37
    L30:
        r23 = null;
        goto L31
    L36:
        monitor-exit(r20);
    L34:
        th = move-exception;
        throw th;
    L8:
        r17 = null;
    L37:
        if (r15 == null) goto L41;
        String r24 = r15.getAppletId();
        if (r24 == null) goto L41;
        ((HashMap) this.f21829c).put(r10.f934c, r24);
    L41:
        c r25 = (c) this.f21828b;
        if (r25 != null) goto L44;
    L46:
        return false;
    L44:
        if (r25.k(r10, r11, r12) != true) goto L46;
        return true;
    }

    public com.bytedance.forest.preload.f l(com.bytedance.forest.utils.a r5) {
        ArrayList r10 = (ArrayList) this.f21829c;
        monitor-enter(r10);
        Iterator r11 = ((ArrayList) this.f21829c).iterator();     // Catch: Throwable -> L10
    L6:
        if (r11.hasNext() == false) goto L12;
        Object r12 = r11.next();     // Catch: Throwable -> L10
        if (Intrinsics.areEqual(((com.bytedance.forest.preload.f) r12).f4576c, r5) == false) goto L6;
    L13:
        com.bytedance.forest.preload.f r13 = (com.bytedance.forest.preload.f) r12;     // Catch: Throwable -> L10
        monitor-exit(r10);
        return r13;
    L12:
        r12 = null;
    L10:
        th = move-exception;
        throw th;
    }

    public String m() {
        i4.a r5 = (i4.a) this.f21828b;
        if (r5 == null) goto L19;
        String r10 = ((i9.g) r5.f17502b).a();
        if (r10 != null) goto L7;
    L10:
        w8.f r11 = (w8.f) ((i4.a) this.f21828b).f17503c;
        HashMap r12 = (HashMap) r11.f22816a;
        if (r12 != null) goto L13;
        return "";
    L13:
        if (r12.isEmpty() == false) goto L16;
        return "";
    L16:
        return (String) ((HashMap) r11.f22816a).get("signal_line");
    L7:
        if (r10.isEmpty() == true) goto L10;
        return r10;
    L19:
        return null;
    }

    public void n(z8.c r10) {
        i9.a r5 = (i9.a) this.f21829c;
        if (r5 == null) goto L22;
        long r11 = r5.f17520b;     // Catch: Throwable -> L9
        JSONObject r12 = r10.f23416a;
        if (r11 == 0) goto L11;
        mh.e.g(Long.valueOf(r11), "crash_time", r12);     // Catch: Throwable -> L9
    L11:
        String r13 = ((i9.a) this.f21829c).f17519a;     // Catch: Throwable -> L9
        if (r13 == null) goto L15;
        mh.e.g(r13, "data", r12);     // Catch: Throwable -> L9
    L16:
        mh.e.g(CrashType.ASAN.toString(), "crash_type", r12);     // Catch: Throwable -> L9
        mh.e.g(IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST, "commit_id", r12);     // Catch: Throwable -> L9
        mh.e.g(IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST, "jenkins_job_id", r12);     // Catch: Throwable -> L9
        return;
    L15:
        Log.e("NATIVE", "AsanReport is Null\n");     // Catch: Throwable -> L9
        mh.e.g("AsanReport is Null\n", "data", r12);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
        return;
    }

    public void o() {
        HashMap r5 = (HashMap) ((w8.f) ((i4.a) this.f21828b).f17503c).f22816a;
        if (r5 != null) goto L16;
    L9:
        String r10 = null;
    L10:
        if (r10 == null) goto L14;
        Long.parseLong(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
    L14:
        System.currentTimeMillis();
        return;
    L16:
        if (r5.isEmpty() == true) goto L9;
        r10 = (String) r5.get("crash_time");     // Catch: Throwable -> L7
        goto L10
    }

    @Override // mt.j
    public void onComplete() {
        ((j) this.f21829c).onComplete();
    }

    @Override // mt.b0, mt.j
    public void onError(Throwable r5) {
        switch(this.f21827a) {
            case 10: goto L6;
            default: goto L4;
        };
    L4:
        ((j) this.f21829c).onError(r5);
        return;
    L6:
        ((b0) this.f21829c).onError(r5);
    }

    @Override // mt.b0, mt.j
    public void onSubscribe(Disposable r5) {
        switch(this.f21827a) {
            case 10: goto L6;
            default: goto L4;
        };
    L4:
        DisposableHelper.replace((AtomicReference) this.f21828b, r5);
        return;
    L6:
        DisposableHelper.replace((AtomicReference) this.f21828b, r5);
    }

    @Override // com.bytedance.ies.bullet.service.base.k
    public void onSuccess(String r5) {
        Intrinsics.checkNotNullParameter(r5, "sessionId");
        ((com.bytedance.ies.bullet.service.preload.d) this.f21828b).getClass();
        JSONObject r10 = com.bytedance.ies.bullet.service.preload.d.h(0, "succeed", true);
        ((sc.a) this.f21829c).a(r10);
    }

    public void p(z8.c r5) {
        JSONObject r10 = r5.f23416a;
        mh.e.g(1, "is_native_crash", r10);
        mh.e.g(Long.valueOf(System.currentTimeMillis()), "repack_time", r10);
        mh.e.g(((File) ((i4.a) this.f21828b).d).getName(), "crash_uuid", r10);
        mh.e.g(Long.valueOf(av.i.b()), "jiffy", r10);
    }

    public void q(z8.c r11) {
        if (cl.a.a(r11, (File) ((i4.a) this.f21828b).d) == (-1)) goto L5;
        z8.c.l(r11.b(), "filters", "has_callback", "true");
    L10:
        JSONObject r10 = r11.f23416a;
        if (r10.opt("storage") != null) goto L16;
        HashMap r5 = new HashMap();
        Context r12 = com.bytedance.crash.n.f4057a;
        com.lynx.tasm.base.h.d(r5);
        Iterator r13 = r5.keySet().iterator();
    L14:
        if (r13.hasNext() == false) goto L16;
        String r14 = (String) r13.next();
        String r15 = (String) r5.get(r14);
        z8.c.l(r11.b(), "filters", r14, r15);
    L16:
        Header r16 = new Header();
        JSONObject r17 = r10.optJSONObject("header");
        JSONObject r18 = r16.f4029a;
        if (r17 == null) goto L23;
        Iterator<String> r19 = r17.keys();
    L21:
        if (r19.hasNext() == false) goto L23;
        String r20 = r19.next();
        mh.e.g(r17.opt(r20), r20, r18);
    L23:
        mh.e.g(r18, "header", r10);
        r11.f23417b = r16;
        Header.d(r16);
        String r21 = r10.optString("process_name");
        Context r22 = com.bytedance.crash.n.f4057a;
        z8.c r23 = Header.c(r21, r10.optLong("app_start_time", 0), r10.optLong("crash_time", 0));
        if (mh.e.n(r18) == false) goto L26;
        mh.e.g(r23.o().f4029a, "header", r10);
    L27:
        mh.e.j(r11.b(), r23.b());
        if (r18.has("params_err") == false) goto L30;
        z8.c.l(r10, "filters", "params_err", r18.optString("params_err"));
    L30:
        io.reactivex.internal.observers.h.c(r11, r16, CrashType.NATIVE);
        return;
    L26:
        mh.e.j(r18, r23.o().f4029a);
        goto L27
    L5:
        HashMap r110 = new HashMap();
        Context r24 = com.bytedance.crash.n.f4057a;
        com.lynx.tasm.base.h.d(r110);
        Iterator r25 = r110.keySet().iterator();
    L7:
        if (r25.hasNext() == false) goto L9;
        String r26 = (String) r25.next();
        String r27 = (String) r110.get(r26);
        z8.c.l(r11.b(), "filters", r26, r27);
        goto L7
    L9:
        z8.c.l(r11.b(), "filters", "has_callback", "false");
        goto L10
    }

    public void r() {
        HashMap r5 = (HashMap) ((w8.f) ((i4.a) this.f21828b).f17503c).f22816a;
        if (r5 != null) goto L16;
    L9:
        String r10 = null;
    L10:
        if (r10 == null) goto L14;
        Long.parseLong(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
    L14:
        System.currentTimeMillis();
        return;
    L16:
        if (r5.isEmpty() == true) goto L9;
        r10 = (String) r5.get("start_time");     // Catch: Throwable -> L7
        goto L10
    }

    public void s(z8.c r10) {
        i4.a r5 = (i4.a) this.f21828b;
        if (r5 == null) goto L5;
        HashMap r11 = (HashMap) ((w8.f) r5.f17503c).f22816a;
    L6:
        if (r11 == null) goto L47;
        String r12 = (String) r11.get("process_name");
        JSONObject r13 = r10.f23416a;
        if (r12 == null) goto L10;
        mh.e.g(r12, "process_name", r13);
    L10:
        String r14 = (String) r11.get("start_time");
        if (r14 != null) goto L45;
    L16:
        String r15 = (String) r11.get(LynxMonitorService.KEY_PID);
        if (r15 != null) goto L41;
    L22:
        String r16 = (String) r11.get("start_pid");
        if (r16 != null) goto L39;
    L28:
        String r17 = (String) r11.get("crash_thread_name");
        if (r17 == null) goto L31;
        mh.e.g(r17, "crash_thread_name", r13);
    L31:
        String r18 = (String) r11.get("crash_time");
        if (r18 != null) goto L43;
    L37:
        mh.e.g(m(), "data", r13);
        return;
    L43:
        mh.e.g(Long.decode(r18), "crash_time", r13);     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
        goto L37
    L39:
        mh.e.g(Long.decode(r16), "start_pid", r13);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
        goto L28
    L41:
        mh.e.g(Long.decode(r15), LynxMonitorService.KEY_PID, r13);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
        goto L22
    L45:
        r10.f(Long.decode(r14).longValue(), 0);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
        goto L16
    L47:
        return;
    L5:
        r11 = null;
        goto L6
    }

    public void t(z8.c r13) {
        JSONObject r5 = r13.f23416a;
        i.a.m(r5);
        HashMap r10 = new HashMap();
        String r11 = "false";
        if (j() == false) goto L5;
        r10.put("is_root", "true");
        mh.e.g("true", "is_root", r5);
    L6:
        File[] r12 = ((File) ((i4.a) this.f21828b).d).listFiles();
        int r14 = r12.length;
        boolean r15 = false;
        int r16 = 0;
    L8:
        if (r16 >= r14) goto L18;
        File r17 = r12[r16];
    L15:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
        cl.a.C(r17);
    L17:
        r16 = r16 + 1;
        goto L8
    L11:
        if (r17.isDirectory() == true) goto L17;
        if (r17.getName().contains("asan_report") == false) goto L17;
        boolean r18 = true;
    L19:
        if (r18 == false) goto L26;
        if (r18 == false) goto L22;
        r11 = "true";
    L22:
        r10.put("has_asan", r11);
        if (((i9.a) this.f21829c) == null) goto L26;
        r10.put("has_asan_file", "true");
    L26:
        r10.put(WsConstants.KEY_SDK_VERSION, "3.1.7-rc.89");
        if (r5.opt("java_data") == null) goto L29;
        r15 = true;
    L29:
        r10.put("has_java_stack", String.valueOf(r15));
        z8.c.l(r13.b(), "filters", "is_64_devices", String.valueOf(Header.h()));
        z8.c.l(r13.b(), "filters", "is_64_runtime", String.valueOf(NativeTools.k().E()));
        z8.c.l(r13.b(), "filters", "is_x86_devices", String.valueOf(Header.i()));
        String r19 = System.getProperty("os.version");     // Catch: Throwable -> L32
    L33:
        z8.c.l(r13.b(), "filters", "kernel_version", r19);
        z8.c.l(r13.b(), "filters", "is_hm_os", String.valueOf(com.lynx.tasm.p.f()));
        r13.k(r10);
        com.bytedance.crash.n.f4063k.getClass();
        AppDataCenter.a(r5);
        return;
    L32:
        r19 = null;
        goto L33
    L18:
        r18 = false;
        goto L19
    L5:
        r10.put("is_root", "false");
        mh.e.g("false", "is_root", r5);
        goto L6
    }

    public String toString() {
        switch(this.f21827a) {
            case 2: goto L6;
            default: goto L5;
        };
    L6:
        StringBuilder r5 = new StringBuilder("GroupedLinkedMap( ");
        com.bumptech.glide.load.engine.bitmap_recycle.c r10 = (com.bumptech.glide.load.engine.bitmap_recycle.c) this.f21828b;
        com.bumptech.glide.load.engine.bitmap_recycle.c r11 = r10.f1449c;
        boolean r12 = false;
    L8:
        if (r11.equals(r10) == true) goto L14;
        r5.append('{');
        r5.append(r11.f1447a);
        r5.append(':');
        ArrayList r13 = r11.f1448b;
        if (r13 == null) goto L12;
        int r14 = r13.size();
    L13:
        r5.append(r14);
        r5.append("}, ");
        r11 = r11.f1449c;
        r12 = true;
        goto L8
    L12:
        r14 = 0;
        goto L13
    L14:
        if (r12 == false) goto L16;
        r5.delete(r5.length() - 2, r5.length());
    L16:
        r5.append(" )");
        return r5.toString();
    L5:
        return super.toString();
    }

    public void u(z8.c r10) {
        File r5 = (File) ((i4.a) this.f21828b).d;
        String r11 = com.bytedance.crash.util.g.f4181a;
        File r12 = new File(r5, "flog.txt");
        if (r12.exists() == false) goto L19;
        String r13 = cl.a.D(r12.getAbsolutePath());     // Catch: Throwable -> L10
        JSONArray r14 = new JSONArray();     // Catch: Throwable -> L10
        if (r13 == null) goto L12;
        String[] r15 = r13.split("\n");     // Catch: Throwable -> L10
        int r16 = r15.length;     // Catch: Throwable -> L10
        int r17 = 0;
    L8:
        if (r17 >= r16) goto L12;
        r14.put(r15[r17]);     // Catch: Throwable -> L10
        r17 = r17 + 1;     // Catch: Throwable -> L10
    L12:
        mh.e.g(r14, "native_log", r10.f23416a);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
        return;
    }

    public Object v(h r5) {
        HashMap r10 = (HashMap) this.f21829c;
        com.bumptech.glide.load.engine.bitmap_recycle.c r11 = (com.bumptech.glide.load.engine.bitmap_recycle.c) r10.get(r5);
        if (r11 != null) goto L5;
        r11 = new com.bumptech.glide.load.engine.bitmap_recycle.c(r5);
        r10.put(r5, r11);
    L6:
        com.bumptech.glide.load.engine.bitmap_recycle.c r12 = r11.d;
        r12.f1449c = r11.f1449c;
        r11.f1449c.d = r12;
        com.bumptech.glide.load.engine.bitmap_recycle.c r13 = (com.bumptech.glide.load.engine.bitmap_recycle.c) this.f21828b;
        r11.d = r13;
        com.bumptech.glide.load.engine.bitmap_recycle.c r14 = r13.f1449c;
        r11.f1449c = r14;
        r14.d = r11;
        r11.d.f1449c = r11;
        ArrayList r15 = r11.f1448b;
        if (r15 == null) goto L9;
        int r16 = r15.size();
    L10:
        if (r16 > 0) goto L14;
        return null;
    L14:
        return r11.f1448b.remove(r16 - 1);
    L9:
        r16 = 0;
        goto L10
    L5:
        r5.a();
        goto L6
    }

    public JSONObject x(boolean r5) {
        JSONObject r10 = new JSONObject();
        Iterator r11 = ((ConcurrentHashMap) this.f21829c).entrySet().iterator();     // Catch: JSONException -> L10
    L5:
        if (r11.hasNext() == false) goto L7;
        Map.Entry r12 = (Map.Entry) r11.next();     // Catch: JSONException -> L10
        r10.put((String) r12.getKey(), r12.getValue());     // Catch: JSONException -> L10
        goto L5
    L7:
        if (r5 == false) goto L9;
        ib.d r13 = com.bytedance.apm.util.c.f3909a;     // Catch: JSONException -> L10
        r13.getClass();     // Catch: JSONException -> L10
        r13.getClass();     // Catch: JSONException -> L10
    L9:
        return r10;
    }

    public void y(z8.c r10) {
        File r5 = (File) ((i4.a) this.f21828b).d;
        String r11 = com.bytedance.crash.util.g.f4181a;
        File r12 = new File(r5, "javastack.txt");
        String r13 = "";
        if (r12.exists() == true) goto L52;
    L8:
        String r14 = "";
    L9:
        File r15 = new File((File) ((i4.a) this.f21828b).d, "abortmsg.txt");
        if (r15.exists() == true) goto L50;
    L48:
    L43:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
        return;
    L40:
        if (r14.isEmpty() == true) goto L57;
        mh.e.g(r14, "java_data", r10.f23416a);     // Catch: Throwable -> L43
        return;
    L57:
        return;
    L50:
        BufferedReader r16 = new BufferedReader(new FileReader(r15));     // Catch: Throwable -> L28
        String r17 = r16.readLine();     // Catch: Throwable -> L23
        if (r17 != null) goto L16;
    L26:
        com.bytedance.android.anniex.base.service.f.h(r16);
    L33:
        if (r14.isEmpty() == true) goto L35;
        r14 = com.lynx.tasm.utils.k.j(r14, "\n", r13);
        goto L48
    L35:
        r14 = r13;
        goto L48
    L16:
        if (r17.startsWith("[FATAL:") == true) goto L18;
    L27:
        com.bytedance.android.anniex.base.service.f.h(r16);
        goto L33
    L18:
        if (r17.contains("Please include Java exception stack in crash report ttwebview:") == false) goto L27;
        StringBuilder r18 = new StringBuilder();     // Catch: Throwable -> L23
        int r19 = r17.indexOf(" ttwebview:");     // Catch: Throwable -> L23
        r18.append("Caused by: ");     // Catch: Throwable -> L23
        r18.append("Please include Java exception stack in crash report");     // Catch: Throwable -> L23
        r18.append("\n");     // Catch: Throwable -> L23
        r18.append(r17.substring(r19 + 11));     // Catch: Throwable -> L23
        r18.append("\n");     // Catch: Throwable -> L23
    L20:
        String r20 = r16.readLine();     // Catch: Throwable -> L23
        if (r20 == null) goto L25;
        r18.append(r20);     // Catch: Throwable -> L23
        r18.append("\n");     // Catch: Throwable -> L23
        goto L20
    L25:
        r13 = r18.toString();     // Catch: Throwable -> L23
    L23:
        Throwable th2 = th;
    L46:
        com.bytedance.crash.c.f4025a.getClass();     // Catch: Throwable -> L36
        m.b.h("NPTH_CATCH", th2);     // Catch: Throwable -> L36
        com.bytedance.android.anniex.base.service.f.h(r16);
    L36:
        th = move-exception;
        com.bytedance.android.anniex.base.service.f.h(r16);
        throw th;
    L28:
        th = move-exception;
        th2 = th;
        r16 = null;
        goto L46
    L52:
        r14 = com.bytedance.crash.util.h.j(r12.getAbsolutePath());     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
        goto L8
    }

    public boolean z() {
        return cl.a.C((File) ((i4.a) this.f21828b).d);
    }

    public /* synthetic */ c(int r5, Object r10, boolean r11, Object r12) {
        this.f21827a = r5;
        this.f21829c = r10;
        this.f21828b = r12;
    }

    public /* synthetic */ c(int r5, boolean r10) {
        this.f21827a = r5;
    }

    public /* synthetic */ c(boolean r5) {
        this.f21827a = 9;
    }

    @Override // mt.b0, mt.j
    public void onSuccess(Object r5) {
        switch(this.f21827a) {
            case 10: goto L6;
            default: goto L4;
        };
    L4:
        ((j) this.f21829c).onSuccess(r5);
        return;
    L6:
        ((b0) this.f21829c).onSuccess(r5);
    }

    public c(Context r5, l r10) {
        this.f21827a = 7;
        e = r5.getResources().getDisplayMetrics().densityDpi / 4;
        this.f21828b = r10;
        this.f21829c = new w0(r10);
    }

    @Override // s8.b
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void mo1705a() {
    }

    @Override // cj.j
    public void a(HashMap r12) {
        String r5 = "";
        Intrinsics.checkNotNullParameter(r12, "data");
        Consumer r10 = (Consumer) this.f21828b;
        Consumer r11 = (Consumer) this.f21829c;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L6
        Object r14 = r12.get("code");     // Catch: Throwable -> L6
        String r15 = null;
        if ((r14 instanceof Integer) == false) goto L8;
        Integer r16 = (Integer) r14;     // Catch: Throwable -> L6
    L9:
        Object r17 = r12.get("data");     // Catch: Throwable -> L6
        if ((r17 instanceof Map) == false) goto L12;
        Map r18 = (Map) r17;     // Catch: Throwable -> L6
    L13:
        if (r18 != null) goto L53;
        r18 = MapsKt.emptyMap();     // Catch: Throwable -> L6
    L53:
        Intrinsics.checkNotNullParameter(r18, "value");     // Catch: Throwable -> L17
        Object r19 = Result.m124constructorimpl(z0.a.a().toJsonTree(r18).getAsJsonObject());     // Catch: Throwable -> L17
    L19:
        Throwable r20 = Result.m127exceptionOrNullimpl(r19);     // Catch: Throwable -> L6
        if (r20 == null) goto L25;
        String r21 = "convert map to Json error with msg:" + r20.getMessage();     // Catch: Throwable -> L6
        Intrinsics.checkNotNullParameter("ai_bridge", "tag");     // Catch: Throwable -> L6
        t0.d r22 = com.bytedance.ai.utils.c.f2846a;     // Catch: Throwable -> L6
        if (r22 == null) goto L25;
        r22.e("ai_bridge", r21);     // Catch: Throwable -> L6
    L25:
        if (Result.m130isFailureimpl(r19) == false) goto L27;
        r19 = null;
    L27:
        JsonObject r23 = (JsonObject) r19;     // Catch: Throwable -> L6
        if (r16 != null) goto L32;
    L34:
        Object r110 = r12.get("msg");     // Catch: Throwable -> L6
        if ((r110 instanceof String) == false) goto L37;
        r15 = (String) r110;     // Catch: Throwable -> L6
    L37:
        if (r15 != null) goto L39;
        r15 = "";
    L39:
        r11.accept(new AIBridgeMethod$Error(r15, r23));     // Catch: Throwable -> L6
    L40:
        Object r111 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L6
    L43:
        Throwable r112 = Result.m127exceptionOrNullimpl(r111);
        if (r112 == null) goto L55;
        String r113 = r112.getMessage();
        if (r113 == null) goto L49;
        r5 = r113;
    L49:
        r11.accept(new AIBridgeMethod$Error(r5));
        return;
    L55:
        return;
    L32:
        if (r16.intValue() != 1) goto L34;
        JsonObject r24 = new JsonObject();     // Catch: Throwable -> L6
        r24.addProperty("code", 1);     // Catch: Throwable -> L6
        r24.add("data", r23);     // Catch: Throwable -> L6
        r24.addProperty("msg", String.valueOf(r12.get("msg")));     // Catch: Throwable -> L6
        r10.accept(r24);     // Catch: Throwable -> L6
        goto L40
    L17:
        th = move-exception;
        Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L6
        r19 = Result.m124constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L6
        goto L19
    L12:
        r18 = null;
        goto L13
    L8:
        r16 = null;
    L6:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r111 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L43
    }

    public c(c r5) {
        this.f21827a = 17;
        this.f21828b = r5;
        this.f21829c = new HashMap();
    }

    public c(sn.a r5) {
        this.f21827a = 16;
        this.f21828b = new HashMap();
        this.f21829c = r5;
    }

    public c(int r5) {
        this.f21827a = r5;
        switch(r5) {
            case 3: goto L10;
            case 6: goto L8;
            case 13: goto L6;
            default: goto L4;
        };
    L4:
        this.f21828b = new com.bumptech.glide.load.engine.bitmap_recycle.c(null);
        this.f21829c = new HashMap();
        return;
    L6:
        this.f21828b = new AtomicReference();
        this.f21829c = new ArrayMap();
        return;
    L8:
        x r10 = new x("bdx_monitor_cpu");
        r10.e = new JSONObject();
        r10.f = new JSONObject();
        this.f21828b = r10;
        x r11 = new x("bdx_monitor_memory");
        r11.e = new JSONObject();
        r11.f = new JSONObject();
        this.f21829c = r11;
        return;
    L10:
        this.f21828b = new LinkedList();
        this.f21829c = new ArrayList(3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(Function2 r5) {
        this.f21827a = 12;
        Intrinsics.checkNotNullParameter(r5, "compute");
        this.f21828b = (Lambda) r5;
        this.f21829c = new com.google.common.util.concurrent.r0(1);
    }
}
