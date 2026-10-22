package w8;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ies.bullet.service.popup.ui.AbsPopupFragment;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.google.common.reflect.w;
import com.lynx.animax.loader.AnimaXLoaderCompletionHandler;
import com.lynx.animax.loader.AnimaXLoaderResponse$Type;
import com.lynx.tasm.resourceprovider.LynxResourceResponse$ResponseState;
import java.io.InputStream;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements z2.g, com.bytedance.forest.model.a, com.obric.oui.picker.reels.views.a, go.a, rm.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile f f22815b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f22816a;

    public /* synthetic */ f(Object r5) {
        this.f22816a = r5;
    }

    public static f c(Context r5) {
        if (f22815b != null) goto L16;
        monitor-enter(f.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f22815b != null) goto L11;
        f r10 = new f();     // Catch: Throwable -> L9
        r10.f22816a = new b(r5);     // Catch: Throwable -> L9
        f22815b = r10;     // Catch: Throwable -> L9
    L11:
        monitor-exit(f.class);     // Catch: Throwable -> L9
    L16:
        return f22815b;
    }

    @Override // com.bytedance.forest.model.a
    public InputStream a() {
        return ((com.bytedance.forest.pollyfill.d) this.f22816a).b();
    }

    @Override // com.bytedance.forest.model.a
    public boolean b() {
        return false;
    }

    public void d(float r5, String r10) {
        ((d) this.f22816a).e.put(r10, Float.valueOf(r5));
    }

    public void e(String r5, String r10) {
        ((d) this.f22816a).f22795b.put(r5, r10);
    }

    @Override // go.a
    public void f(w r5) {
        byte[] r10 = (byte[]) r5.f9376b;
        AnimaXLoaderCompletionHandler r11 = (AnimaXLoaderCompletionHandler) this.f22816a;
        if (r10 != null) goto L5;
    L8:
        Throwable r12 = (Throwable) r5.d;
        int r13 = 6;
        r11.a(new q7.a(r13, AnimaXLoaderResponse$Type.f9630c, false, r12));
        return;
    L5:
        if (((LynxResourceResponse$ResponseState) r5.f9377c) != LynxResourceResponse$ResponseState.f10948b) goto L8;
        int r14 = 6;
        r11.a(new q7.a(r14, AnimaXLoaderResponse$Type.f9628a, false, r10));
    }

    public boolean g() {
        HashMap r5 = (HashMap) this.f22816a;
        if (r5 != null) goto L5;
    L27:
        return false;
    L5:
        if (r5.isEmpty() == true) goto L27;
        if (TextUtils.isEmpty((CharSequence) r5.get("process_name")) == false) goto L11;
        return false;
    L11:
        if (TextUtils.isEmpty((CharSequence) r5.get("crash_thread_name")) == false) goto L14;
        return false;
    L14:
        if (TextUtils.isEmpty((CharSequence) r5.get(LynxMonitorService.KEY_PID)) == false) goto L17;
        return false;
    L17:
        if (TextUtils.isEmpty((CharSequence) r5.get("tid")) == false) goto L20;
        return false;
    L20:
        if (TextUtils.isEmpty((CharSequence) r5.get("start_time")) == false) goto L23;
        return false;
    L23:
        if (TextUtils.isEmpty((CharSequence) r5.get("crash_time")) == false) goto L26;
        return false;
    L26:
        return !TextUtils.isEmpty((CharSequence) r5.get("signal_line"));
    }

    public ObjectAnimator h() {
        return ObjectAnimator.ofFloat(((AbsPopupFragment) this.f22816a).j(), "alpha", new float[]{1.0f, 0.0f});
    }

    public f(AbsPopupFragment r5) {
        Intrinsics.checkNotNullParameter(r5, "fragment");
        Intrinsics.checkNotNullParameter(r5, "fragment");
        Intrinsics.checkNotNullParameter(r5, "fragment");
        this.f22816a = r5;
    }

    @Override // z2.g
    public void b(z2.f r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        com.bytedance.ai.model.widgets.a r10 = (com.bytedance.ai.model.widgets.a) this.f22816a;
        Applet r11 = r10.f2329a.f2197h;
        r5.f = r11.f2259b;
        r5.g = r11.i();
        r5.c("renderType", r10.h());
        r5.e(r10.f2330b.buildMonitorEvent());
    }
}
