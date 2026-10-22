package ym;

import ai.j0;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Handler;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.engine.d0;
import com.bytedance.common.wschannel.client.WsClientService;
import com.bytedance.ies.bullet.service.base.PoolResult;
import com.bytedance.pia.core.bridge.methods.l0;
import com.bytedance.pia.core.bridge.methods.n0;
import com.bytedance.pia.core.setting.Settings;
import com.google.gson.JsonObject;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.performance.PerformanceController;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;
import kotlinx.serialization.internal.i1;
import mt.b0;
import mt.z;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class p implements f, z.h, com.bytedance.ies.bullet.service.base.k, hh.a, pt.o, b0, i1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f23311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f23312b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f23313c;

    public /* synthetic */ p(int r5, Object r10, Object r11) {
        this.f23311a = r5;
        this.f23312b = r10;
        this.f23313c = r11;
    }

    public static p i(String r5, String r10) {
        p r11 = new p(r5, 1);
        long r12 = PerformanceController.a();
        HashMap r13 = (HashMap) r11.f23313c;
        r13.put("pipelineStart", Long.valueOf(r12));
        r13.put(r10, Long.valueOf(r12));
        return r11;
    }

    @Override // hh.a
    public void a(JsonObject r5) {
        if (((AtomicBoolean) this.f23312b).get() == false) goto L5;
        return;
    L5:
        ((rh.i) this.f23313c).f.sendWorkerBridgeMessage(com.bytedance.pia.core.utils.j.e(r5));
    }

    @Override // pt.o
    public Object apply(Object r5) {
        z r10 = (z) this.f23313c;
        TimeUnit r11 = (TimeUnit) this.f23312b;
        return new ut.f(r5, r10.b(r11), r11);
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
    @Override // kotlinx.serialization.internal.i1
    public kotlinx.serialization.c b(KClass r5) {
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        ConcurrentHashMap r10 = (ConcurrentHashMap) this.f23313c;
        Class r11 = JvmClassMappingKt.getJavaClass(r5);
        Object r12 = r10.get(r11);
        if (r12 != null) goto L9;
        r12 = new kotlinx.serialization.internal.k((kotlinx.serialization.c) ((Lambda) this.f23312b).invoke(r5));
        Object r13 = r10.putIfAbsent(r11, r12);
        if (r13 == null) goto L9;
        r12 = r13;
    L9:
        return ((kotlinx.serialization.internal.k) r12).f19302a;
    }

    @Override // com.bytedance.ies.bullet.service.base.k
    public void c(PoolResult r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "result");
        int r11 = r5.ordinal();
        if (r11 == 1) goto L13;
        if (r11 != 2) goto L6;
        String r12 = "FAIL_LOAD_ERROR";
    L14:
        boolean r13 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.a(2, com.lynx.tasm.utils.b.j("PreRender Failed ", r12, ", ", r10), "XPreload");
        sc.a r14 = (sc.a) this.f23313c;
        if (r14 == null) goto L21;
        StringBuilder r15 = new StringBuilder("PoolResult:");
        r15.append(r12);
        r15.append(',');
        if (r10 != null) goto L19;
        r10 = "Preload Fail";
    L19:
        r15.append(r10);
        r14.onError(-1, r15.toString());
        return;
    L21:
        return;
    L6:
        if (r11 != 3) goto L8;
        r12 = "FAIL_INVALID";
        goto L14
    L8:
        if (r11 == 4) goto L10;
        r12 = "NULL";
        goto L14
    L10:
        r12 = "FAIL_EXCEPTION";
        goto L14
    L13:
        r12 = "FAIL_EXISTS";
        goto L14
    }

    @Override // hh.a
    public void close() {
        ((AtomicBoolean) this.f23312b).compareAndSet(false, true);
    }

    @Override // hh.a
    public void d(l0 r5) {
        n0 r10 = new n0(4, this, r5);
        ((rh.i) this.f23313c).e.b(r10);
    }

    public JavaOnlyMap e() {
        JavaOnlyMap r5 = new JavaOnlyMap();
        r5.putString("pipelineOrigin", (String) this.f23312b);
        r5.putMap("timestampMap", new JavaOnlyMap((HashMap) this.f23313c));
        return r5;
    }

    @Override // z.h
    public EncodeStrategy f(z.f r5) {
        return EncodeStrategy.TRANSFORMED;
    }

    @Override // z.a
    public boolean g(Object r5, File r10, z.f r11) {
        com.bumptech.glide.load.resource.bitmap.c r12 = new com.bumptech.glide.load.resource.bitmap.c(((BitmapDrawable) ((d0) r5).get()).getBitmap(), (com.bumptech.glide.load.engine.bitmap_recycle.a) this.f23312b);
        return ((com.bumptech.glide.load.resource.bitmap.b) this.f23313c).g(r12, r10, r11);
    }

    @Override // ym.f
    public void h(a6.a r5) {
        com.lynx.tasm.utils.j.f(new s8.h(8, this, r5));
    }

    public void j(int r17, LynxBaseUI r18, String r19) {
        String r5 = "insert";
        if (r17 == 0) goto L13;
        if (r17 == 1) goto L12;
        if (r17 == 2) goto L11;
        if (r17 == 3) goto L10;
        if (r17 == 4) goto L9;
        String r13 = "";
    L15:
        if (r13.isEmpty() == true) goto L35;
        JavaOnlyMap r14 = new JavaOnlyMap();
        r14.putInt("target", r18.getSign());
        if (r17 == 0) goto L27;
        if (r17 == 1) goto L26;
        if (r17 == 2) goto L25;
        if (r17 == 3) goto L24;
        if (r17 == 4) goto L23;
        r5 = "";
        goto L27
    L23:
        r5 = "style_update";
        goto L27
    L24:
        r5 = "update";
        goto L27
    L25:
        r5 = "detach";
        goto L27
    L26:
        r5 = "remove";
    L27:
        r14.putString("action", r5);
        r14.putString("a11y-id", r18.getAccessibilityId());
        if (r17 == 4) goto L30;
    L33:
        ((ArrayList) this.f23312b).add(r14);
        return;
    L30:
        if (((HashSet) this.f23313c).contains(r19) == false) goto L36;
        r14.putString("style", r19);
        goto L33
    L36:
        return;
    L35:
        return;
    L9:
        r13 = "style_update";
        goto L15
    L10:
        r13 = "update";
        goto L15
    L11:
        r13 = "detach";
        goto L15
    L12:
        r13 = "remove";
        goto L15
    L13:
        r13 = "insert";
        goto L15
    }

    public synchronized void k(dk.a r5, dk.b r10) {
        monitor-enter(this);
        ((ArrayList) this.f23312b).add(r5);     // Catch: Throwable -> L6
        ((ArrayList) this.f23313c).add(r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void l(String r5, String r10) {
        LinkedHashMap r11 = (LinkedHashMap) this.f23312b;
        List r12 = (List) r11.get(r5);
        if (r12 != null) goto L5;
        r12 = new LinkedList();
    L5:
        r12.add(String.valueOf(r10));
        r11.put(r5, r12);
    }

    public String m() {
        LinkedHashMap r5 = (LinkedHashMap) this.f23312b;
        boolean r10 = r5.isEmpty();
        String r11 = (String) this.f23313c;
        if (r10 == false) goto L5;
        return r11;
    L5:
        Pattern r12 = com.bytedance.frameworks.baselib.network.http.util.c.f4694a;
        StringBuilder r13 = new StringBuilder();
        Iterator r14 = r5.entrySet().iterator();
    L7:
        if (r14.hasNext() == false) goto L34;
        Map.Entry r15 = (Map.Entry) r14.next();
        String r16 = URLEncoder.encode((String) r15.getKey(), "UTF-8");     // Catch: UnsupportedEncodingException -> L31
        List r17 = (List) r15.getValue();
        if (r17 == null) goto L7;
        if (r17.size() <= 0) goto L7;
        Iterator r18 = r17.iterator();
    L16:
        if (r18.hasNext() == false) goto L7;
        String r19 = (String) r18.next();
        if (r19 != null) goto L48;
        String r20 = "";
    L26:
        if (r13.length() <= 0) goto L28;
        r13.append("&");
    L28:
        r13.append(r16);
        if (r20.isEmpty() == true) goto L16;
        r13.append("=");
        r13.append(r20);
        goto L16
    L48:
        r20 = URLEncoder.encode(r19, "UTF-8");     // Catch: UnsupportedEncodingException -> L21
    L21:
        e = move-exception;
        throw new IllegalArgumentException(e);
    L31:
        e = move-exception;
        throw new IllegalArgumentException(e);
    L34:
        String r21 = r13.toString();
        if (r11 != null) goto L37;
    L45:
        return r21;
    L37:
        if (r11.length() == 0) goto L45;
        if (r11.indexOf(63) < 0) goto L44;
        return j0.D(r11, "&", r21);
    L44:
        return j0.D(r11, "?", r21);
    }

    public synchronized List n(String r5) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (((ArrayList) this.f23312b).contains(r5) == true) goto L6;
        ((ArrayList) this.f23312b).add(r5);     // Catch: Throwable -> L10
    L6:
        List r10 = (List) ((HashMap) this.f23313c).get(r5);     // Catch: Throwable -> L10
        if (r10 != null) goto L12;
        r10 = new ArrayList();     // Catch: Throwable -> L10
        ((HashMap) this.f23313c).put(r5, r10);     // Catch: Throwable -> L10
    L12:
        monitor-exit(this);
        return r10;
    }

    public synchronized ArrayList o(Class r10, Class r11) {
        monitor-enter(this);
        ArrayList r5 = new ArrayList();     // Catch: Throwable -> L23
        Iterator r12 = ((ArrayList) this.f23312b).iterator();     // Catch: Throwable -> L23
    L4:
        if (r12.hasNext() == false) goto L25;
        String r13 = (String) r12.next();     // Catch: Throwable -> L23
        List r14 = (List) ((HashMap) this.f23313c).get(r13);     // Catch: Throwable -> L23
        if (r14 == null) goto L4;
        Iterator r15 = r14.iterator();     // Catch: Throwable -> L23
    L11:
        if (r15.hasNext() == false) goto L4;
        m0.d r16 = (m0.d) r15.next();     // Catch: Throwable -> L23
        if (r16.f19949a.isAssignableFrom(r10) == true) goto L15;
    L17:
        boolean r17 = false;
    L18:
        if (r17 == false) goto L11;
        if (r5.contains(r16.f19950b) == true) goto L11;
        r5.add(r16.f19950b);     // Catch: Throwable -> L23
        goto L11
    L15:
        if (r11.isAssignableFrom(r16.f19950b) == false) goto L17;
        r17 = true;
        goto L18
    L25:
        monitor-exit(this);
        return r5;
    L23:
        th = move-exception;
        throw th;
    }

    @Override // mt.b0, mt.j
    public void onError(Throwable r5) {
        switch(this.f23311a) {
            case 10: goto L6;
            default: goto L4;
        };
    L4:
        ((b0) this.f23312b).onError(r5);
        return;
    L6:
        ((mt.j) this.f23313c).onError(r5);
    }

    @Override // mt.b0, mt.j
    public void onSubscribe(Disposable r5) {
        switch(this.f23311a) {
            case 10: goto L6;
            default: goto L4;
        };
    L4:
        ((b0) this.f23312b).onSubscribe(r5);
        return;
    L6:
        DisposableHelper.replace((AtomicReference) this.f23312b, r5);
    }

    @Override // com.bytedance.ies.bullet.service.base.k
    public void onSuccess(String r5) {
        Intrinsics.checkNotNullParameter(r5, "sessionId");
        com.bytedance.ies.bullet.service.base.b.a(2, "PreRender Success", "XPreload");
        ((com.bytedance.ies.bullet.service.preload.f) this.f23312b).getClass();
        JSONObject r10 = new JSONObject();
        r10.put("code", 1);
        JSONObject r11 = new JSONObject();
        r11.put("message", "Preload Success");
        r11.put("result", true);
        Unit r12 = Unit.INSTANCE;
        r10.put("data", r11);
        sc.a r13 = (sc.a) this.f23313c;
        if (r13 == null) goto L6;
        r13.a(r10);
        return;
    }

    public String toString() {
        switch(this.f23311a) {
            case 3: goto L15;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        String r5 = "[ ";
        if (((fr.e) this.f23312b) == null) goto L12;
        int r10 = 0;
    L10:
        if (r10 >= 9) goto L12;
        r5 = androidx.constraintlayout.motion.widget.a.r(j0.u(r5), ((fr.e) this.f23312b).f17002h[r10], " ");
        r10 = r10 + 1;
    L12:
        StringBuilder r11 = j0.w(r5, "] ");
        r11.append((fr.e) this.f23312b);
        return r11.toString();
    L5:
        return super.toString();
    L15:
        return m();
    }

    public /* synthetic */ p(int r5, boolean r10) {
        this.f23311a = r5;
    }

    public p(int r5) {
        this.f23311a = r5;
        switch(r5) {
            case 6: goto L8;
            case 13: goto L6;
            default: goto L4;
        };
    L4:
        this.f23312b = new ArrayList();
        this.f23313c = new HashSet();
        return;
    L6:
        this.f23312b = new ArrayList();
        this.f23313c = new HashMap();
        return;
    L8:
        this.f23312b = new ArrayList();
        this.f23313c = new ArrayList();
    }

    @Override // mt.b0, mt.j
    public void onSuccess(Object r5) {
        switch(this.f23311a) {
            case 10: goto L9;
            default: goto L11;
        };
    L9:
        ((mt.j) this.f23313c).onSuccess(r5);
        return;
    L11:
        Object r10 = ((com.lynx.tasm.behavior.ui.utils.n) this.f23313c).apply(r5);     // Catch: Throwable -> L6
        io.reactivex.internal.functions.e.d(r10, "The mapper function returned a null value.");     // Catch: Throwable -> L6
        ((b0) this.f23312b).onSuccess(r10);
        return;
    L6:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        onError(th);
    }

    public p(Context r5) {
        this.f23311a = 15;
        if (r5.getApplicationInfo().targetSdkVersion < 26) goto L5;
        this.f23312b = new s8.d(this, r5);
    L6:
        this.f23313c = WsClientService.class;
        return;
    L5:
        this.f23312b = new s6.c(15, this, false, r5);
        goto L6
    }

    public p(String r5, int r10) {
        this.f23311a = r10;
        switch(r10) {
            case 3: goto L6;
            default: goto L4;
        };
    L4:
        this.f23312b = r5;
        this.f23313c = new HashMap();
        return;
    L6:
        this.f23312b = new LinkedHashMap();
        this.f23313c = r5;
    }

    public p(nh.d r10, yg.b r11) {
        this.f23311a = 16;
        boolean r5 = false;
        Intrinsics.checkNotNullParameter(r11, "manifest");
        Intrinsics.checkNotNullParameter(r10, "context");
        this.f23312b = r10;
        if (r11.d == false) goto L33;
        Lazy r12 = Settings.B;
        if (com.lynx.tasm.p.a().s() == false) goto L34;
        Object r13 = null;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L12
        rh.f r15 = new rh.f();     // Catch: Throwable -> L12
        r15.f21750h = "Prefetch";     // Catch: Throwable -> L12
        r15.f = r10.f20251w;     // Catch: Throwable -> L12
        r15.f21747a = r11.f23260a.toString();     // Catch: Throwable -> L12
        r15.f21748b = Uri.withAppendedPath(r11.f23262c, "assets/js/" + r11.f23261b + ".pia.worker.js").toString();     // Catch: Throwable -> L12
        View r16 = r10.c();     // Catch: Throwable -> L12
        if ((r16 instanceof WebView) == false) goto L14;
        WebView r17 = (WebView) r16;     // Catch: Throwable -> L12
    L15:
        if (r17 == null) goto L19;
        WebSettings r18 = r17.getSettings();     // Catch: Throwable -> L12
        if (r18 == null) goto L19;
        r18.getUserAgentString();     // Catch: Throwable -> L12
    L19:
        r15.f21749c = r10;     // Catch: Throwable -> L12
        r15.g = false;     // Catch: Throwable -> L12
        Object r19 = Result.m124constructorimpl(r15.a());     // Catch: Throwable -> L12
    L23:
        if (Result.m130isFailureimpl(r19) == true) goto L26;
        r13 = r19;
    L26:
        rh.g r20 = (rh.g) r13;
        if (r20 == null) goto L35;
        ((Handler) com.bytedance.pia.core.utils.m.f7156b.getValue()).post(new s8.h(4, this, r5, r20));
        return;
    L35:
        return;
    L14:
        r17 = null;
    L12:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r19 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L23
    L34:
        return;
    }

    public p(rh.i r5) {
        this.f23311a = 8;
        this.f23312b = new AtomicBoolean(false);
        this.f23313c = r5;
    }

    public p(fr.d r5) {
        this.f23311a = 7;
        this.f23313c = r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public p(Function1 r5) {
        this.f23311a = 12;
        Intrinsics.checkNotNullParameter(r5, "compute");
        this.f23312b = (Lambda) r5;
        this.f23313c = new ConcurrentHashMap();
    }
}
