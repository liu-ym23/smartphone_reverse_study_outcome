package ym;

import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Choreographer;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.bytedance.ai.model.objects.PageStatus;
import com.bytedance.ai.model.widgets.WebViewFloatingPageV2;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMapKeySetIterator;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.squareup.kotlinpoet.f0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements f, ol.d, pg.b, xn.d, ReadableMapKeySetIterator, pt.g, or.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f23297a;

    public /* synthetic */ d(Object r5) {
        this.f23297a = r5;
    }

    @Override // ol.d
    public void a(String r5) {
        com.bytedance.ai.utils.c.n("Create Floating Ball onPageStarted");
        WebViewFloatingPageV2 r10 = (WebViewFloatingPageV2) this.f23297a;
        r10.getClass();
        Intrinsics.checkNotNullParameter("AIContainerViewBase", "tag");
        t0.d r11 = com.bytedance.ai.utils.c.f2846a;
        if (r11 == null) goto L5;
        r11.i("AIContainerViewBase", "onViewStart");
    L5:
        PageStatus r12 = PageStatus.f2286a;
        z2.d.e("applet_view_start", new w8.f(r10));
        Intrinsics.checkNotNullParameter(PageStatus.f2286a, "<set-?>");
    }

    @Override // pt.g
    public void accept(Object r5) {
        ((pt.a) this.f23297a).run();
    }

    @Override // ol.d
    public boolean b(String r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        if (r10.length() != 0) goto L8;
        return false;
    L8:
        if (StringsKt.P(r10, "http") == true) goto L54;
        String r5 = "shouldOverrideUrlLoading http url:".concat(r10);     // Catch: ActivityNotFoundException -> L18 IllegalStateException -> L20 IllegalArgumentException -> L22 SecurityException -> L24
        Intrinsics.checkNotNullParameter("WebViewFloatingPageV2", "tag");     // Catch: ActivityNotFoundException -> L18 IllegalStateException -> L20 IllegalArgumentException -> L22 SecurityException -> L24
        t0.d r11 = com.bytedance.ai.utils.c.f2846a;     // Catch: ActivityNotFoundException -> L18 IllegalStateException -> L20 IllegalArgumentException -> L22 SecurityException -> L24
        if (r11 == null) goto L12;
        r11.i("WebViewFloatingPageV2", r5);     // Catch: ActivityNotFoundException -> L18 IllegalStateException -> L20 IllegalArgumentException -> L22 SecurityException -> L24
    L12:
        Intent r12 = new Intent("android.intent.action.VIEW", Uri.parse(r10));     // Catch: ActivityNotFoundException -> L18 IllegalStateException -> L20 IllegalArgumentException -> L22 SecurityException -> L24
        r12.setFlags(805306368);     // Catch: ActivityNotFoundException -> L18 IllegalStateException -> L20 IllegalArgumentException -> L22 SecurityException -> L24
        u0.a r13 = s0.a.f21800c;     // Catch: ActivityNotFoundException -> L18 IllegalStateException -> L20 IllegalArgumentException -> L22 SecurityException -> L24
        if (r13 == null) goto L44;
        Application r14 = r13.f22194a;     // Catch: ActivityNotFoundException -> L18 IllegalStateException -> L20 IllegalArgumentException -> L22 SecurityException -> L24
        if (r14 == null) goto L45;
        r14.startActivity(r12);     // Catch: ActivityNotFoundException -> L18 IllegalStateException -> L20 IllegalArgumentException -> L22 SecurityException -> L24
    L53:
        return true;
    L45:
        return true;
    L44:
        return true;
    L18:
        e = move-exception;
        String r15 = "shouldOverrideUrlLoading http url:".concat(r10);
        Intrinsics.checkNotNullParameter("WebViewFloatingPageV2", "tag");
        t0.d r16 = com.bytedance.ai.utils.c.f2846a;
        if (r16 == null) goto L46;
        r16.w("WebViewFloatingPageV2", r15, e);
        return true;
    L46:
        return true;
    L22:
        e = move-exception;
        String r17 = "shouldOverrideUrlLoading http url:".concat(r10);
        Intrinsics.checkNotNullParameter("WebViewFloatingPageV2", "tag");
        t0.d r18 = com.bytedance.ai.utils.c.f2846a;
        if (r18 == null) goto L50;
        r18.w("WebViewFloatingPageV2", r17, e);
        return true;
    L50:
        return true;
    L20:
        e = move-exception;
        String r19 = "shouldOverrideUrlLoading http url:".concat(r10);
        Intrinsics.checkNotNullParameter("WebViewFloatingPageV2", "tag");
        t0.d r20 = com.bytedance.ai.utils.c.f2846a;
        if (r20 == null) goto L48;
        r20.w("WebViewFloatingPageV2", r19, e);
        return true;
    L48:
        return true;
    L24:
        e = move-exception;
        String r21 = "shouldOverrideUrlLoading http url:".concat(r10);
        Intrinsics.checkNotNullParameter("WebViewFloatingPageV2", "tag");
        t0.d r22 = com.bytedance.ai.utils.c.f2846a;
        if (r22 == null) goto L52;
        r22.w("WebViewFloatingPageV2", r21, e);
        return true;
    L52:
        return true;
    L54:
        return false;
    }

    @Override // ol.d
    public void c(sj.e r5) {
        String r10 = "onRenderProcessGone: " + r5;
        Intrinsics.checkNotNullParameter("WebViewFloatingPageV2", "tag");
        t0.d r11 = com.bytedance.ai.utils.c.f2846a;
        if (r11 == null) goto L6;
        r11.e("WebViewFloatingPageV2", r10);
        return;
    }

    @Override // pg.b
    public pg.d create() {
        pg.c r5 = new pg.c();
        r5.f21347a = com.bytedance.ies.bullet.core.h.g.f5316b;
        r5.e = 3600000;
        r5.f21349c = new ai.p(((com.bytedance.ies.bullet.settings.a) this.f23297a).f6161b);
        return r5.a();
    }

    @Override // ol.d
    public rl.b d(rl.b r5) {
        Intrinsics.checkNotNullParameter(r5, "before");
        return r5;
    }

    @Override // xn.d
    public void e(wn.b r5, xn.e r10, xn.c r11) {
        Callback r12 = (Callback) this.f23297a;
        if (r12 == null) goto L6;
        JavaOnlyMap r13 = new JavaOnlyMap();
        r13.putInt("code", 0);
        r13.putString("msg", "");
        r12.invoke(new Object[]{r13});
        return;
    }

    @Override // ol.d
    public void f(WebView r5, String r10) {
        com.bytedance.ai.utils.c.n("Create Floating Ball onPageFinished");
        WebViewFloatingPageV2 r11 = (WebViewFloatingPageV2) this.f23297a;
        if (r11.e != null) goto L5;
        r11.i(r5);
    L5:
        WebView r12 = r11.e;
        if (r12 == null) goto L14;
        String r13 = "window.getAppData = function() { return JSON.stringify(" + r11.f2330b.getPageData() + "); }; \n";
        StringBuilder r14 = new StringBuilder("window.getViewContext = function() { return JSON.stringify(");
        r11.f2330b.setPageId(r11.f2331c);
        r14.append(r11.f2330b.toViewContext());
        r14.append("); };\n");
        r12.evaluateJavascript(r13 + r14.toString(), null);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        String r15 = "JavaScript execution error: " + th.getMessage();
        Intrinsics.checkNotNullParameter("WebViewPage", "tag");
        t0.d r16 = com.bytedance.ai.utils.c.f2846a;
        if (r16 == null) goto L14;
        r16.e("WebViewPage", r15);
    L14:
        r11.e(r10);
    }

    @Override // xn.d
    public void g(int r5, Throwable r10) {
        Callback r11 = (Callback) this.f23297a;
        if (r11 == null) goto L6;
        JavaOnlyMap r12 = new JavaOnlyMap();
        r12.putInt("code", r5);
        r12.putString("msg", "prefetch image failed");
        r11.invoke(new Object[]{r12});
        return;
    }

    @Override // ym.f
    public void h(a6.a r5) {
        Choreographer.getInstance().postFrameCallback(new c(this, r5));
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMapKeySetIterator
    public boolean hasNextKey() {
        return ((Iterator) this.f23297a).hasNext();
    }

    @Override // ol.d
    public void i(String r5, int r10, String r11) {
        u0.a r12 = s0.a.f21800c;
        if (r12 != null) goto L5;
        return;
    L5:
        if (r12.f22200k != true) goto L16;
        if (r5 != null) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r11) == false) goto L11;
        r11 = "unknown-source";
    L11:
        StringBuilder r13 = new StringBuilder("[console]\"");
        r13.append(r5);
        r13.append("\", source: ");
        r13.append(r11);
        r13.append('(');
        r13.append(r10);
        r13.append("), pageId: ");
        String r14 = androidx.room.jarjarred.org.antlr.runtime.a.v(r13, ((WebViewFloatingPageV2) this.f23297a).f2331c, "AppletFloatingBall", "tag");
        t0.d r15 = com.bytedance.ai.utils.c.f2846a;
        if (r15 == null) goto L18;
        r15.d("AppletFloatingBall", r14);
        return;
    L18:
        return;
    }

    @Override // ol.d
    public void j(WebResourceRequest r5, WebResourceError r10) {
        CharSequence r11 = null;
        if (r5 == null) goto L5;
        Uri r12 = r5.getUrl();
    L6:
        Objects.toString(r12);
        if (r10 == null) goto L9;
        r11 = r10.getDescription();
    L9:
        Objects.toString(r11);
        ((WebViewFloatingPageV2) this.f23297a).getClass();
        Intrinsics.checkNotNullParameter("AIContainerViewBase", "tag");
        t0.d r13 = com.bytedance.ai.utils.c.f2846a;
        if (r13 == null) goto L12;
        r13.i("AIContainerViewBase", "onViewError");
    L12:
        Intrinsics.checkNotNullParameter(PageStatus.f2288c, "<set-?>");
        return;
    L5:
        r12 = null;
        goto L6
    }

    public synchronized z.h k(Class r5) {
        monitor-enter(this);
        int r10 = ((ArrayList) this.f23297a).size();     // Catch: Throwable -> L10
        int r11 = 0;
    L4:
        if (r11 >= r10) goto L13;
        m0.e r12 = (m0.e) ((ArrayList) this.f23297a).get(r11);     // Catch: Throwable -> L10
        if (r12.f19952a.isAssignableFrom(r5) == true) goto L7;
        r11 = r11 + 1;
        goto L4
    L7:
        z.h r13 = r12.f19953b;     // Catch: Throwable -> L10
        monitor-exit(this);
        return r13;
    L13:
        monitor-exit(this);
        return null;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMapKeySetIterator
    public String nextKey() {
        return (String) ((Iterator) this.f23297a).next();
    }

    public d(Map r5) {
        Intrinsics.checkNotNullParameter(r5, "tags");
        Regex r10 = f0.f15148a;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        this.f23297a = Collections.unmodifiableMap(new LinkedHashMap(r5));
    }

    @Override // ol.d
    public void b(int r5, String r10, String r11) {
        ((WebViewFloatingPageV2) this.f23297a).getClass();
        Intrinsics.checkNotNullParameter("AIContainerViewBase", "tag");
        t0.d r12 = com.bytedance.ai.utils.c.f2846a;
        if (r12 == null) goto L5;
        r12.i("AIContainerViewBase", "onViewError");
    L5:
        Intrinsics.checkNotNullParameter(PageStatus.f2288c, "<set-?>");
    }
}
