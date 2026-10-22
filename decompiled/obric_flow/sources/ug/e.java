package ug;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.forest.model.ForestBuffer;
import com.bytedance.forest.model.o;
import com.bytedance.forest.utils.m;
import com.bytedance.news.common.settings.SettingsConfigProvider;
import com.lynx.serval.svg.SVGRender;
import com.lynx.serval.svg.SVGRenderEngine;
import com.lynx.tasm.behavior.ui.scroll.base.LynxBaseScrollView;
import com.lynx.tasm.ui.image.f0;
import com.obric.feature.miniapp.widget.MiniAppConstants;
import hn.f;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import z2.g;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements g, com.bytedance.forest.model.a, f, lm.d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile e f22359c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f22360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f22361b;

    public /* synthetic */ e(Object r5, int r10) {
        this.f22360a = r10;
        this.f22361b = r5;
    }

    public static e c(Context r5) {
        if (f22359c != null) goto L16;
        monitor-enter(e.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f22359c != null) goto L11;
        f22359c = new e(r5, 0);     // Catch: Throwable -> L9
    L11:
        monitor-exit(e.class);     // Catch: Throwable -> L9
    L16:
        return f22359c;
    }

    @Override // com.bytedance.forest.model.a
    public InputStream a() {
        File r5 = ((o) this.f22361b).f4396c;     // Catch: Exception -> L5
        if (r5 != null) goto L7;
        Intrinsics.throwNpe();     // Catch: Exception -> L5
    L7:
        return new FileInputStream(r5);
    L5:
        e = move-exception;
        StringBuilder r10 = new StringBuilder("error occurs when getting input stream from ResponseCache, file: ");
        File r11 = ((o) this.f22361b).f4396c;
        if (r11 == null) goto L12;
        String r12 = r11.getPath();
    L13:
        r10.append(r12);
        f0.g(112, ForestBuffer.TAG, r10.toString(), e);
        return null;
    L12:
        r12 = null;
        goto L13
    }

    @Override // com.bytedance.forest.model.a
    public boolean b() {
        return true;
    }

    public void d(int r5, String r10) {
        SharedPreferences r11 = (SharedPreferences) this.f22361b;
        r11.edit().putInt("key_prefix_version_".concat(r10), r5).apply();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        r11.edit().putString("key_prefix_version_".concat(r10), String.valueOf(r5)).apply();
    }

    public void e(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        ((VelocityTracker) this.f22361b).addMovement(r5);
    }

    public boolean f(String r5) {
        Intrinsics.checkNotNullParameter(r5, "uniqueSchema");
        com.bytedance.ies.bullet.service.base.e r10 = (com.bytedance.ies.bullet.service.base.e) ((m) this.f22361b).remove(r5);
        if (r10 == null) goto L5;
        r10.f5986c.release();
    L5:
        if (r10 == null) goto L8;
        return true;
    L8:
        return false;
    }

    public void g() {
        ((VelocityTracker) this.f22361b).clear();
    }

    public boolean h(Bundle r18) {
        Intrinsics.checkNotNullParameter(r18, "args");
        if (kn.e.f().f20541c < 5) goto L5;
        boolean r5 = true;
    L6:
        Context r10 = (Context) this.f22361b;
        if (r5 == false) goto L14;
        Intrinsics.checkNotNullParameter("DefaultMiniAppWidgetPageOpener", "tag");
        Intrinsics.checkNotNullParameter("openPage blocked by thermal protection", "msg");
        org.koin.core.a r11 = su.a.f22013b;
        if (r11 == null) goto L13;
        ((ju.b) r11.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).w("DefaultMiniAppWidgetPageOpener", "openPage blocked by thermal protection");
        kn.e.f().b(r10);
        return false;
    L13:
        throw new IllegalStateException("KoinApplication has not been started");
    L14:
        String r12 = r18.getString("appletId");
        if (r12 != null) goto L17;
    L22:
        r12 = MiniAppConstants.APPLET_ID_CALENDAR;
    L23:
        String r14 = r18.getString("appletPageId");
        if (r14 != null) goto L26;
    L31:
        r14 = r18.getString("pageId");
        if (r14 != null) goto L34;
    L36:
        r14 = null;
    L37:
        if (r14 != null) goto L39;
        r14 = "index";
    L39:
        Intent r13 = new Intent();
        r13.setPackage("com.obric.appletapp");
        r13.setAction("com.obric.miniapp.CALENDAR_MAIN");
        r13.putExtras(r18);
        r13.putExtra("appletId", r12);
        r13.putExtra(Constant.APPID, r12);
        r13.putExtra("appletPageId", r14);
        r13.putExtra("pageId", r14);
        r13.putExtra(MiniAppConstants.APPLET_FROM_LAUNCHER, true);
        r13.putExtra("launchFrom", "owidget");
        String r15 = r18.getString("pageType");
        if (r15 != null) goto L43;
        r15 = "";
    L43:
        if (StringsKt.isBlank(r15) == false) goto L45;
        r15 = OpenPageMethod.APP_FULL;
    L45:
        r13.putExtra("pageType", r15);
        String r16 = r18.getString("pageData");
        if (r16 == null) goto L48;
        Intrinsics.checkNotNull(r16);
        r13.putExtra("pageData", r16);
    L48:
        String r17 = r18.getString("pageSettings");
        if (r17 == null) goto L51;
        Intrinsics.checkNotNull(r17);
        r13.putExtra("pageSettings", r17);
    L51:
        r13.addFlags(268435456);
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L55
        String r20 = "openMiniAppPage appletId=" + r12 + " pageId=" + r14 + " args=" + r18;     // Catch: Throwable -> L55
        Intrinsics.checkNotNullParameter("DefaultMiniAppWidgetPageOpener", "tag");     // Catch: Throwable -> L55
        Intrinsics.checkNotNullParameter(r20, "msg");     // Catch: Throwable -> L55
        org.koin.core.a r21 = su.a.f22013b;     // Catch: Throwable -> L55
        if (r21 == null) goto L58;
        ((ju.b) r21.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("DefaultMiniAppWidgetPageOpener", r20);     // Catch: Throwable -> L55
        r10.getApplicationContext().startActivity(r13);     // Catch: Throwable -> L55
        Object r22 = Result.m124constructorimpl(Boolean.TRUE);     // Catch: Throwable -> L55
    L60:
        Throwable r23 = Result.m127exceptionOrNullimpl(r22);
        if (r23 == null) goto L67;
        String r24 = androidx.constraintlayout.motion.widget.a.p("openMiniAppPage failed appletId=", r12, " pageId=", r14);
        Intrinsics.checkNotNullParameter("DefaultMiniAppWidgetPageOpener", "tag");
        Intrinsics.checkNotNullParameter(r24, "msg");
        Intrinsics.checkNotNullParameter(r23, "t");
        org.koin.core.a r25 = su.a.f22013b;
        if (r25 == null) goto L66;
        ((ju.b) r25.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("DefaultMiniAppWidgetPageOpener", r24, r23);
        goto L67
    L66:
        throw new IllegalStateException("KoinApplication has not been started");
    L67:
        Boolean r26 = Boolean.FALSE;
        if (Result.m130isFailureimpl(r22) == false) goto L71;
        r22 = r26;
    L71:
        return ((Boolean) r22).booleanValue();
    L58:
        throw new IllegalStateException("KoinApplication has not been started");     // Catch: Throwable -> L55
    L55:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r22 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L60
    L34:
        if (StringsKt.isBlank(r14) == true) goto L36;
    L26:
        if (StringsKt.isBlank(r14) == false) goto L29;
        r14 = null;
    L29:
        if (r14 == null) goto L31;
    L17:
        if (StringsKt.isBlank(r12) == false) goto L20;
        r12 = null;
    L20:
        if (r12 == null) goto L22;
    L5:
        r5 = false;
        goto L6
    }

    public e(int r5) {
        this.f22360a = r5;
        switch(r5) {
            case 6: goto L6;
            default: goto L4;
        };
    L4:
        this.f22361b = new m(this);
        return;
    L6:
        this.f22361b = VelocityTracker.obtain();
    }

    @Override // z2.g
    public void b(z2.f r5) {
        switch(this.f22360a) {
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, "event");
        r5.f = (String) this.f22361b;
        return;
    L6:
        Intrinsics.checkNotNullParameter(r5, "event");
        AppletRuntime r10 = (AppletRuntime) this.f22361b;
        Applet r11 = r10.f2197h;
        r5.f = r11.i();
        r5.g = r11.i();
        r5.c("botId", r11.I);
        r5.c("js_worker_id", r10.t().e());
    }

    public e(Context r5, int r10) {
        this.f22360a = r10;
        switch(r10) {
            case 11: goto L12;
            default: goto L5;
        };
    L12:
        Intrinsics.checkNotNullParameter(r5, "context");
        this.f22361b = r5;
        return;
    L5:
        if (og.a.a(SettingsConfigProvider.class) != null) goto L11;
        if (((SharedPreferences) this.f22361b) != null) goto L14;
        this.f22361b = r5.getSharedPreferences("__settings_meta.sp", 0);
        return;
    L14:
        return;
    L11:
        throw new ClassCastException();
    }

    @Override // lm.d
    public void a(Bitmap r24) {
        rm.a r10 = (rm.a) this.f22361b;
        r10.getClass();
        if (r24 == null) goto L31;
        float r11 = r24.getWidth();
        float r15 = r24.getHeight();
        float r14 = r10.f21788a;
        if (r14 <= 0.0f) goto L23;
        float r13 = r10.f21789b;
        if (r13 > 0.0f) goto L10;
        return;
    L10:
        if (r11 > 0.0f) goto L12;
        return;
    L12:
        if (r15 <= 0.0f) goto L26;
        SVGRender r12 = r10.f21791h;
        SVGRenderEngine r16 = r12.f9953c;
        if (r16 == null) goto L27;
        float[] r5 = r16.calculateViewBoxTransform(r10.f21790c, r10.d, r14, r13, 0.0f, 0.0f, r11, r15, r10.e, r10.f, r10.g);
        if (r5 != null) goto L18;
        return;
    L18:
        if (r5.length == 6) goto L20;
        return;
    L20:
        if (r12.f9951a == null) goto L30;
        float[] r17 = {r5[0], r5[2], r5[4], r5[1], r5[3], r5[5], 0.0f, 0.0f, 1.0f};
        Matrix r18 = new Matrix();
        r18.setValues(r17);
        r12.f9951a.concat(r18);
        r12.f9951a.drawBitmap(r24, 0.0f, 0.0f, new Paint(2));
        return;
    L30:
        return;
    L27:
        return;
    L26:
        return;
    L23:
        return;
    }

    public e(OutputStream r5) {
        this.f22360a = 7;
        this.f22361b = new BufferedOutputStream(r5, 1024);
    }

    public e(JSONObject r5) {
        this.f22360a = 9;
        Intrinsics.checkNotNullParameter(r5, "origin");
        this.f22361b = r5;
    }

    @Override // hn.f
    public void a(boolean r5) {
        if (r5 == false) goto L5;
        ((LynxBaseScrollView) this.f22361b).a(0);
        return;
    }

    @Override // lm.d
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void mo1706a() {
        ((rm.a) this.f22361b).getClass();
    }

    public int a(String r5) {
        SharedPreferences r10 = (SharedPreferences) this.f22361b;
        int r11 = 0;
        return r10.getInt("key_prefix_version_".concat(r5), 0);
    L5:
        e = move-exception;
        r11 = Integer.valueOf(r10.getString("key_prefix_version_".concat(r5), "0")).intValue();     // Catch: Exception -> L8
    L10:
        e.printStackTrace();
        return r11;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }
}
