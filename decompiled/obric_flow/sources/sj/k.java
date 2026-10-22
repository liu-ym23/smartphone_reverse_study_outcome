package sj;

import ai.p0;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.compose.runtime.ComposerKt;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.n;
import com.bytedance.crash.upload.t;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ttnet.TTNetInit;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.google.common.collect.ImmutableMap;
import com.google.common.reflect.u;
import com.google.common.reflect.y;
import com.lynx.base.log.LynxLog;
import com.lynx.component.svg.UISvg;
import com.lynx.component.svg.parser.n0;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.behavior.ui.scroll.base.LynxBaseScrollView;
import com.zte.miboard.cards.CardParentCallback;
import com.zte.miboard.cards.travel.TravelCard;
import java.io.File;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;
import obric.flow.externalcard.R$dimen;
import obric.flow.externalcard.travel.TravelWidgetView;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class k implements p0, z2.g, com.lynx.tasm.behavior.b, hn.f, CardParentCallback {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile k f21936b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f21937a;

    public /* synthetic */ k(Object r5, boolean r10) {
        this.f21937a = r5;
    }

    public static t f(JSONObject r10, File r11, File r12, File r13, File r14, long r15) {
        String r5 = com.bytedance.crash.upload.b.i(n.f4062j.getNativeCrashUploadUrl(), r10.optJSONObject("header"));     // Catch: Throwable -> L14
        com.lynx.jsbridge.a.j(r13, r10);     // Catch: Throwable -> L5
    L7:
        String r16 = r10.toString();     // Catch: Throwable -> L14
        c5.a r17 = new c5.a(r12, true);     // Catch: Throwable -> L14
        c5.a r18 = new c5.a(r13, true);     // Catch: Throwable -> L14
        c5.a r19 = new c5.a(com.bytedance.crash.upload.b.e(), false);     // Catch: Throwable -> L14
        if (r14 != null) goto L11;
        c5.a r110 = null;
    L10:
        c5.a r20 = r110;
        c5.a[] r21 = {r17, r18, r19, r20, com.bytedance.android.anniex.base.service.e.m(r15), i9.f.c(r10.optJSONArray("alive_pids"))};     // Catch: Throwable -> L14
        return com.bytedance.crash.upload.b.a(CrashType.NATIVE.getName(), r5, r16, r11, r21);
    L11:
        r110 = new c5.a(r14, false);     // Catch: Throwable -> L14
        goto L10
    L5:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();     // Catch: Throwable -> L14
        m.b.h("NPTH_CATCH", th);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        t r22 = new t(ComposerKt.reuseKey);
        io.reactivex.exceptions.a.j(th);
        return r22;
    }

    public static k g() {
        if (f21936b != null) goto L6;
        f21936b = new k(n.f4057a, false);
    L6:
        return f21936b;
    }

    public static boolean j(String r5, String r10, String r11, ArrayList r12) {
        io.reactivex.exceptions.a.d("npth", "real upload alog " + r11 + ": " + r12);
        return com.bytedance.crash.upload.b.p(com.bytedance.crash.upload.b.g(n.f4062j.getAlogUploadUrl(), r5, r10), r5, r10, r11, r12);
    L5:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public static void k(JSONObject r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.length() <= 0) goto L18;
        String r10 = com.bytedance.crash.upload.b.i(n.f4062j.getJavaCrashUploadUrl(), r5.optJSONObject("header"));     // Catch: Throwable -> L10
        r5.put("upload_scene", "direct");     // Catch: Throwable -> L10
        if (com.bytedance.crash.upload.b.b(r10, r5.toString(), true).c() == false) goto L12;
        io.reactivex.exceptions.a.i("upload dart success");     // Catch: Throwable -> L10
        return;
    L12:
        return;
    L10:
        th = move-exception;
        io.reactivex.exceptions.a.j(th);
        return;
    }

    public static void l(JSONObject r5) {
        if (mh.e.n(r5) == true) goto L15;
        String r10 = com.bytedance.crash.upload.b.i(n.f4062j.getJavaCrashUploadUrl(), r5.optJSONObject("header"));     // Catch: Throwable -> L9
        r5.put("upload_scene", "direct");     // Catch: Throwable -> L9
        if (com.bytedance.crash.upload.b.b(r10, r5.toString(), true).c() == false) goto L14;
        io.reactivex.exceptions.a.i("upload game success");     // Catch: Throwable -> L9
        return;
    L14:
        return;
    L9:
        th = move-exception;
        io.reactivex.exceptions.a.j(th);
        return;
    }

    public static k m() {
        monitor-enter(k.class);
        new k(0);     // Catch: Throwable -> L6
        throw null;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    @Override // hn.f
    public void a(boolean r5) {
        if (r5 == false) goto L5;
        ((LynxBaseScrollView) this.f21937a).a(0);
        return;
    }

    @Override // z2.g
    public void b(z2.f r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        AppletRuntime r10 = (AppletRuntime) this.f21937a;
        r5.f = r10.f2197h.i();
        Applet r11 = r10.f2197h;
        r5.g = r11.i();
        r5.c("botId", r11.I);
    }

    @Override // ai.p0
    public int c(String r5, String r10) {
        return x9.b.b().a(r5, r10);
    }

    @Override // com.lynx.tasm.behavior.b
    public List create() {
        ArrayList r5 = new ArrayList();
        sg.a r10 = (sg.a) this.f21937a;
        ArrayList r11 = ((com.bytedance.ies.bullet.lynx.init.b) r10.f21902a).f5669b;
        boolean r12 = com.bytedance.ies.bullet.service.base.b.f5956a;
        String r13 = "LynxKitEnv globalBehaviors size == " + r11.size();
        LogLevel r14 = LogLevel.f5954b;
        com.bytedance.ies.bullet.service.base.b.d(r13, r14, "XLynxKit");
        r5.addAll(r11);
        we.a r15 = ((com.bytedance.ies.bullet.lynx.init.b) r10.f21902a).d;
        if (r15 == null) goto L11;
        StringBuilder r16 = new StringBuilder("LynxKitEnv imageBehaviors size == ");
        if (Fresco.f7728c == true) goto L7;
        Fresco.a((Application) r15.f22857a);
    L7:
        ArrayList r17 = new ArrayList();
        String r18 = "image";
        boolean r19 = true;
        boolean r110 = false;
        r17.add(new com.ivy.ivykit.plugin.impl.render.a(r18, r19, r19, r110, 25));
        String r111 = "filter-image";
        r17.add(new com.ivy.ivykit.plugin.impl.render.a(r111, r110, r19, r110, 26));
        String r112 = "inline-image";
        r17.add(new com.ivy.ivykit.plugin.impl.render.a(r112, r110, r19, r110, 27));
        r16.append(r17.size());
        com.bytedance.ies.bullet.service.base.b.d(r16.toString(), r14, "XLynxKit");
        if (Fresco.f7728c == true) goto L10;
        Fresco.a((Application) r15.f22857a);
    L10:
        ArrayList r20 = new ArrayList();
        r20.add(new com.ivy.ivykit.plugin.impl.render.a(r18, r19, r19, r110, 25));
        r20.add(new com.ivy.ivykit.plugin.impl.render.a(r111, r110, r19, r110, 26));
        r20.add(new com.ivy.ivykit.plugin.impl.render.a(r112, r110, r19, r110, 27));
        r5.addAll(r20);
    L11:
        return r5;
    }

    @Override // ai.p0
    public boolean d() {
        return !x9.b.b().f22999b.isEmpty();
    }

    @Override // ai.p0
    public int e(String r5) {
        com.lynx.tasm.behavior.utils.d.m(r5, (CopyOnWriteArraySet) this.f21937a);
        return 0;
    }

    public void h(n0 r5) {
        int r10 = UISvg.f9723j;
        StringBuilder r11 = new StringBuilder("postDrawable(). threadName:");
        r11.append(Thread.currentThread().getName());
        r11.append(" svg hashCode:");
        if (r5 == null) goto L5;
        int r12 = r5.hashCode();
    L6:
        r11.append(r12);
        r11.append(" ui-svg hashCode:");
        UISvg r13 = (UISvg) this.f21937a;
        r11.append(r13);
        r11.append(" isAsync:");
        r11.append(LynxEnv.inst().enableSvgAsync());
        LynxLog.b(2, "lynx_UISvg", r11.toString());
        if (LynxEnv.inst().enableSvgAsync() == false) goto L10;
        mn.h.k().execute(new lm.f(r13, r5, 0));
        return;
    L10:
        lm.f r14 = new lm.f(r13, r5, 1);
        com.lynx.tasm.utils.j.a().post(r14);
        return;
    L5:
        r12 = -1;
        goto L6
    }

    public void i(String r5) {
        LynxLog.b(4, "lynx_UISvg", f4.b.b(new StringBuilder("requestSrc error! the src is "), ((UISvg) this.f21937a).f9724a, " error message is", r5));
    }

    public Type n(TypeVariable r5, com.google.common.reflect.f r10) {
        com.google.common.reflect.g r11 = new com.google.common.reflect.g(r5);
        Type r12 = (Type) ((ImmutableMap) this.f21937a).get(r11);
        if (r12 != null) goto L15;
        Type[] r13 = r5.getBounds();
        if (r13.length != 0) goto L7;
        return r5;
    L7:
        Type[] r14 = new com.google.common.reflect.j(r10).c(r13);
        if (u.f9373a == false) goto L13;
        if (Arrays.equals(r13, r14) == false) goto L13;
        return r5;
    L13:
        return y.e(r5.getGenericDeclaration(), r5.getName(), r14);
    L15:
        return new com.google.common.reflect.j(r10).b(r12);
    }

    @Override // com.zte.miboard.cards.CardParentCallback
    public Bundle onCardContentViewLongClick(View r5, Bundle r10) {
        obric.flow.externalcard.a.e(r5, r10);
        return r10;
    }

    @Override // com.zte.miboard.cards.CardParentCallback
    public void onContentStateChanged() {
        TravelWidgetView r5 = (TravelWidgetView) this.f21937a;
        TravelCard r10 = r5.f20451b;
        TravelCard r11 = null;
        if (r10 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("travelView");
        r10 = null;
    L6:
        if (r10.isContentReady() == false) goto L18;
        TravelCard r12 = r5.f20451b;
        if (r12 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("travelView");
        r12 = null;
    L10:
        kk.a.j(r12);
        TravelCard r13 = r5.f20451b;
        if (r13 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("travelView");
        r13 = null;
    L13:
        r5.addView(r13);
        TravelCard r14 = r5.f20451b;
        if (r14 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("travelView");
    L17:
        ViewGroup.LayoutParams r15 = r11.getLayoutParams();
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) r15).topMargin = r5.getContext().getResources().getDimensionPixelSize(R$dimen.travel_widget_margin_top);
        return;
    L16:
        r11 = r14;
        goto L17
    L18:
        TravelCard r16 = r5.f20451b;
        if (r16 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("travelView");
    L22:
        r5.removeView(r11);
        return;
    L21:
        r11 = r16;
        goto L22
    }

    public k(Object r5) {
        Intrinsics.checkNotNullParameter(r5, "proxy");
        this.f21937a = r5;
    }

    @Override // ai.p0
    public boolean a() {
        return false;
    }

    public k(Context r5) {
        this.f21937a = new sg.a(r5);
    }

    public k(int r5) {
        switch(r5) {
            case 5: goto L5;
            default: goto L3;
        };
    L3:
        this.f21937a = new CopyOnWriteArraySet();
        new ConcurrentHashMap();
        TTNetInit.getTTNetDepend();
        TTNetInit.getTTNetDepend();
        throw null;
    L5:
        this.f21937a = ImmutableMap.of();
    }
}
