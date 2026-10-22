package sg;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import com.lynx.component.svg.parser.SVGParseException;
import com.lynx.component.svg.parser.n0;
import com.lynx.tasm.behavior.ui.scroll.base.LynxBaseScrollViewNested;
import com.obric.oui.indicator.IndicatorAnimator$RenderReason;
import com.obric.oui.indicator.IndicatorDotView;
import com.obric.oui.indicator.IndicatorImageDotView;
import com.obric.oui.indicator.OCarouselIndicator;
import com.obric.oui.indicator.h;
import com.obric.oui.indicator.l;
import com.obric.oui.indicator.p;
import com.obric.oui.indicator.s;
import hn.f;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;
import kotlin.jvm.internal.Intrinsics;
import sj.k;
import v6.i;
import z.d;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements d, f, fo.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile a f21901b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f21902a;

    public /* synthetic */ a(Object r5) {
        this.f21902a = r5;
    }

    public static a b(Context r5) {
        if (f21901b != null) goto L16;
        monitor-enter(a.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f21901b != null) goto L11;
        a r10 = new a();     // Catch: Throwable -> L9
        r10.f21902a = r5.getSharedPreferences("__ctx_info.sp", 0);     // Catch: Throwable -> L9
        f21901b = r10;     // Catch: Throwable -> L9
    L11:
        monitor-exit(a.class);     // Catch: Throwable -> L9
    L16:
        return f21901b;
    }

    @Override // hn.f
    public void a(boolean r5) {
        if (r5 == false) goto L5;
        ((LynxBaseScrollViewNested) this.f21902a).a(0);
        return;
    }

    @Override // fo.d
    public void c(fo.f r10) {
        InputStream r5 = r10.f16963b;
        k r11 = (k) this.f21902a;
        String r12 = null;
        if (r5 != null) goto L29;
    L14:
        byte[] r13 = null;
    L15:
        if (r13 == null) goto L19;
        r12 = new String(r13);     // Catch: SVGParseException -> L10
    L19:
        if (TextUtils.isEmpty(r12) == false) goto L21;
        r10.f16962a = "data is empty!";     // Catch: SVGParseException -> L10
    L24:
        r11.i(r10.f16962a);
        return;
    L21:
        r11.h(n0.e(r12));     // Catch: SVGParseException -> L10
        return;
    L29:
        ByteArrayOutputStream r14 = new ByteArrayOutputStream();     // Catch: SVGParseException -> L10
        byte[] r15 = new byte[2048];     // Catch: SVGParseException -> L10
    L27:
        int r16 = r5.read(r15, 0, 2048);     // Catch: SVGParseException -> L10 IOException -> L26
        if (r16 == (-1)) goto L12;
        r14.write(r15, 0, r16);     // Catch: SVGParseException -> L10 IOException -> L26
        goto L27
    L12:
        r13 = r14.toByteArray();     // Catch: SVGParseException -> L10 IOException -> L26
    L10:
        e = move-exception;
        r10.f16962a = e.toString();
        new RuntimeException(e);
        goto L24
    }

    @Override // fo.d
    public void d(fo.f r5) {
        ((k) this.f21902a).i(r5.f16962a);
    }

    public void e(i r5) {
        PriorityQueue r10 = (PriorityQueue) this.f21902a;
        if (r10.size() >= 30) goto L6;
        r10.add(r5);
        return;
    L6:
        if (r5.compareTo((Comparable) r10.peek()) <= 0) goto L10;
        r10.poll();
        r10.add(r5);
        return;
    }

    public void f(h r10) {
        Intrinsics.checkNotNullParameter(r10, "state");
        int r5 = OCarouselIndicator.J;
        OCarouselIndicator r11 = (OCarouselIndicator) this.f21902a;
        l r12 = r11.getPager();
        if (r12 != null) goto L5;
        int r13 = 0;
    L6:
        Iterator r14 = r11.f13463z.iterator();
    L8:
        if (r14.hasNext() == false) goto L10;
        p r15 = (p) r14.next();
        OCarouselIndicator.o(r15.f13503b, OCarouselIndicator.y(r15, r10));
        r11.t(r15, r13);
        goto L8
    L10:
        return;
    L5:
        r13 = r12.a();
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r1v11, types: [android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r5v1, types: [android.view.View, com.obric.oui.indicator.g] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r8v2, types: [android.view.View, com.obric.oui.indicator.OBaseIndicator, com.obric.oui.indicator.OCarouselIndicator, java.lang.Object] */
    public void g(IndicatorAnimator$RenderReason r10, h r11) {
        Intrinsics.checkNotNullParameter(r11, "state");
        Intrinsics.checkNotNullParameter(r10, "reason");
        ?? r12 = (OCarouselIndicator) this.f21902a;
        ArrayList r13 = r12.f13463z;
        Iterator r5 = r13.iterator();
    L3:
        AttributeSet r14 = null;
        if (r5.hasNext() == false) goto L6;
        ((p) r5.next()).f13503b.animate().setListener(null).cancel();
        goto L3
    L6:
        ArrayDeque r15 = new ArrayDeque();
        Iterator r16 = r13.iterator();
    L8:
        if (r16.hasNext() == false) goto L16;
        View r17 = ((p) r16.next()).f13503b;
        if ((r17 instanceof IndicatorDotView) == false) goto L12;
        IndicatorDotView r18 = (IndicatorDotView) r17;
    L13:
        if (r18 == null) goto L8;
        r15.addLast(r18);
        goto L8
    L12:
        r18 = null;
        goto L13
    L16:
        LinearLayout r19 = r12.f13461x;
        if (r19 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("dotsTrackLayout");
        r19 = null;
    L19:
        r19.removeAllViews();
        r13.clear();
        Iterator r110 = OCarouselIndicator.w(r11.f13479a, r11.f13481c).iterator();
    L20:
        boolean r20 = r110.hasNext();
        ArrayDeque r21 = r12.A;
        if (r20 == false) goto L46;
        s r22 = (s) r110.next();
        IndicatorImageDotView r23 = r12.x(r22);
        int r24 = 0;
        ?? r25 = r23;
        if (r23 != null) goto L30;
        IndicatorDotView r26 = (IndicatorDotView) r15.pollFirst();
        r25 = r26;
        if (r26 != null) goto L30;
        IndicatorDotView r27 = (IndicatorDotView) r21.pollFirst();
        if (r27 != null) goto L29;
        r27 = new IndicatorDotView(r12.getContext(), r14, 6, r24);
    L29:
        r25 = r27;
    L30:
        ViewParent r28 = r25.getParent();
        if ((r28 instanceof ViewGroup) == false) goto L33;
        ?? r29 = (ViewGroup) r28;
    L34:
        if (r29 == 0) goto L37;
        r29.removeView(r25);
    L37:
        p r30 = new p(r22, r25, r25);
        r12.A(r25, false);
        l r31 = r12.getPager();
        if (r31 == null) goto L41;
        r24 = r31.a();
    L41:
        r12.t(r30, r24);
        r25.setOnClickListener(new com.google.android.material.snackbar.a(3, r30, r12));
        ?? r32 = r12.f13461x;
        if (r32 != 0) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("dotsTrackLayout");
        r32 = 0;
    L44:
        r32.addView(r25);
        r13.add(r30);
        goto L20
    L33:
        r29 = 0;
    L46:
        if (r15.isEmpty() == true) goto L48;
        r21.addLast((IndicatorDotView) r15.removeFirst());
        goto L46
    L48:
        r12.C();
    }

    @Override // z.d
    public void a(byte[] r5, Object r10, MessageDigest r11) {
        Integer r12 = (Integer) r10;
        if (r12 == null) goto L15;
        r11.update(r5);
        ByteBuffer r13 = (ByteBuffer) this.f21902a;
        monitor-enter(r13);
        ((ByteBuffer) this.f21902a).position(0);     // Catch: Throwable -> L10
        r11.update(((ByteBuffer) this.f21902a).putInt(r12.intValue()).array());     // Catch: Throwable -> L10
        monitor-exit(r13);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
