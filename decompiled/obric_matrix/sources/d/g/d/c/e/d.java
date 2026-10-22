package d.g.d.c.e;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.obric.oui.animation.easy.ViewPropertySpringAnimator;
import com.obric.oui.common.util.g;
import com.obric.oui.text.OTextView;
import com.ss.ttuploader.TTVideoUploader;
import com.ttnet.org.chromium.net.NetError;
import java.util.Objects;
import kotlin.f0;
import kotlin.n0.c.l;
import kotlin.n0.d.o;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(30)
public class d extends d.g.d.c.g.a {
    private boolean A;
    private final String r;
    private FrameLayout s;
    private f t;
    private TextView u;
    private TextView v;
    private FrameLayout w;
    private f x;
    private FrameLayout y;
    private f z;

    static final class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d f16878f;

        a(d r1) {
            this.f16878f = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            TextView r0 = d.w(this.f16878f);
            if (r0 == null) goto L8;
            Layout r1 = r0.getLayout();
            if (r1 == null) goto L8;
            r1.getLineCount();
        L8:
            TextView r2 = d.w(this.f16878f);
            if (r2 == null) goto L12;
            r2.getMaxLines();
            return;
        }
    }

    static final class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d f16879f;

        static final class a extends q implements l<ViewPropertySpringAnimator<View>, f0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ b f16880f;

            a(b r1) {
                this.f16880f = r1;
                super(1);
            }

            public final void a(ViewPropertySpringAnimator<View> r2) {
                o.f(r2, "it");
                if (this.f16880f.f16879f.n().getAlpha() != 0.0f) goto L6;
                this.f16880f.f16879f.n().setAlpha(1.0f);
                return;
            }

            @Override // kotlin.n0.c.l
            public /* bridge */ /* synthetic */ f0 invoke(ViewPropertySpringAnimator<View> r1) {
                a(r1);
                return f0.f18324a;
            }
        }

        b(d r1) {
            this.f16879f = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.g.d.c.f.a r0 = d.g.d.c.f.a.f16894a;
            View r1 = this.f16879f.n();
            Window r2 = this.f16879f.getWindow();
            boolean r3 = !this.f16879f.i();
            d r4 = this.f16879f;
            Context r5 = r4.getContext();
            o.e(r5, "context");
            ViewPropertySpringAnimator r6 = d.g.d.c.f.a.g(r0, r1, r2, r3, d.x(r4, r5), false, 8, null).start();
            if (d.v(this.f16879f) == false) goto L6;
            ViewPropertySpringAnimator.setListener$default(r6, new a(this), null, null, 6, null);
            return;
        }
    }

    static final class c extends q implements l<ViewPropertySpringAnimator<View>, f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d f16881f;

        c(d r1) {
            this.f16881f = r1;
            super(1);
        }

        public final void a(ViewPropertySpringAnimator<View> r2) {
            o.f(r2, "it");
            this.f16881f.G();
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(ViewPropertySpringAnimator<View> r1) {
            a(r1);
            return f0.f18324a;
        }
    }

    /* JADX INFO: renamed from: d.g.d.c.e.d$d, reason: collision with other inner class name */
    static final class C0442d extends q implements l<ViewPropertySpringAnimator<View>, f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d f16882f;

        C0442d(d r1) {
            this.f16882f = r1;
            super(1);
        }

        public final void a(ViewPropertySpringAnimator<View> r2) {
            o.f(r2, "it");
            this.f16882f.G();
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(ViewPropertySpringAnimator<View> r1) {
            a(r1);
            return f0.f18324a;
        }
    }

    public d(Context r2, boolean r3, boolean r4) {
        o.f(r2, "context");
        super(r2, r3, r4);
        this.r = "OAlertDialog";
        this.A = true;
        this.s = (FrameLayout) findViewById(com.obric.common.oui.f.U);
        TextView r5 = (TextView) findViewById(com.obric.common.oui.f.Q0);
        TextView r6 = null;
        if (r5 != null) goto L5;
        r5 = null;
    L13:
        this.u = r5;
        TextView r7 = (TextView) findViewById(com.obric.common.oui.f.P0);
        if ((r7 instanceof OTextView) == false) goto L17;
        r6 = r7;
    L17:
        OTextView r8 = (OTextView) r6;
        if (r8 == null) goto L20;
        r8.setEnableAutoAlignLeft(true);
    L20:
        f0 r9 = f0.f18324a;
        this.v = r7;
        this.w = (FrameLayout) findViewById(com.obric.common.oui.f.A);
        this.y = (FrameLayout) findViewById(com.obric.common.oui.f.x);
        return;
    L5:
        if ((r5 instanceof OTextView) == true) goto L7;
        TextView r0 = null;
    L8:
        OTextView r1 = (OTextView) r0;
        if (r1 == null) goto L11;
        r1.setEnableAutoAlignLeft(true);
    L11:
        f0 r10 = f0.f18324a;
        goto L13
    L7:
        r0 = r5;
        goto L8
    }

    private final int A() {
        FrameLayout r3 = this.y;
        if (r3 != null) goto L5;
        return 0;
    L5:
        d.g.d.f.b r1 = d.g.d.f.b.f16934a;
        o.c(r3);
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
        if (r4 != null) goto L9;
    L7:
        r4 = null;
    L10:
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) r4;
        if (r5 != null) goto L13;
        return 0;
    L13:
        return r5.topMargin;
    L9:
        if ((r4 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        goto L7
    }

    private final int B() {
        FrameLayout r0 = this.w;
        int r1 = 0;
        if (r0 != null) goto L5;
        return 0;
    L5:
        o.c(r0);
        r0.measure(0, 0);
        FrameLayout r2 = this.w;
        o.c(r2);
        if (r2.getVisibility() != 0) goto L8;
        FrameLayout r3 = this.w;
        o.c(r3);
        int r4 = r3.getMeasuredHeight();
    L9:
        d.g.d.f.b r5 = d.g.d.f.b.f16934a;
        FrameLayout r6 = this.w;
        o.c(r6);
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if (r7 != null) goto L13;
    L11:
        r7 = null;
    L14:
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r7;
        if (r8 == null) goto L18;
        r1 = r8.topMargin;
    L18:
        return r4 + r1;
    L13:
        if ((r7 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
    L8:
        r4 = 0;
        goto L9
    }

    private final int C() {
        FrameLayout r0 = this.s;
        int r1 = 0;
        if (r0 != null) goto L5;
        return 0;
    L5:
        o.c(r0);
        r0.measure(0, 0);
        FrameLayout r2 = this.s;
        o.c(r2);
        if (r2.getVisibility() != 0) goto L8;
        FrameLayout r3 = this.s;
        o.c(r3);
        int r4 = r3.getMeasuredHeight();
    L9:
        d.g.d.f.b r5 = d.g.d.f.b.f16934a;
        FrameLayout r6 = this.s;
        o.c(r6);
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if (r7 != null) goto L13;
    L11:
        r7 = null;
    L14:
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r7;
        if (r8 == null) goto L18;
        r1 = r8.topMargin;
    L18:
        return r4 + r1;
    L13:
        if ((r7 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
    L8:
        r4 = 0;
        goto L9
    }

    private final int D() {
        TextView r0 = this.v;
        int r1 = 0;
        if (r0 != null) goto L5;
        return 0;
    L5:
        o.c(r0);
        r0.measure(0, 0);
        TextView r2 = this.v;
        o.c(r2);
        if (r2.getVisibility() != 0) goto L8;
        TextView r3 = this.v;
        o.c(r3);
        int r4 = r3.getMeasuredHeight();
    L9:
        d.g.d.f.b r5 = d.g.d.f.b.f16934a;
        TextView r6 = this.v;
        o.c(r6);
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if (r7 != null) goto L13;
    L11:
        r7 = null;
    L14:
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r7;
        if (r8 == null) goto L18;
        r1 = r8.topMargin;
    L18:
        return r4 + r1;
    L13:
        if ((r7 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
    L8:
        r4 = 0;
        goto L9
    }

    private final int E() {
        TextView r0 = this.u;
        int r1 = 0;
        if (r0 != null) goto L5;
        return 0;
    L5:
        o.c(r0);
        r0.measure(0, 0);
        TextView r2 = this.u;
        o.c(r2);
        if (r2.getVisibility() != 0) goto L8;
        TextView r3 = this.u;
        o.c(r3);
        int r4 = r3.getMeasuredHeight();
    L9:
        d.g.d.f.b r5 = d.g.d.f.b.f16934a;
        TextView r6 = this.u;
        o.c(r6);
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if (r7 != null) goto L13;
    L11:
        r7 = null;
    L14:
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r7;
        if (r8 == null) goto L18;
        r1 = r8.topMargin;
    L18:
        return r4 + r1;
    L13:
        if ((r7 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
    L8:
        r4 = 0;
        goto L9
    }

    public static /* synthetic */ void N(d r0, CharSequence r1, boolean r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        r0.M(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setMessage");
    }

    public static final /* synthetic */ boolean v(d r0) {
        return r0.j();
    }

    public static final /* synthetic */ TextView w(d r0) {
        return r0.v;
    }

    public static final /* synthetic */ float x(d r0, Context r1) {
        return r0.o(r1);
    }

    private final void y(Context r14) {
        FrameLayout r0 = this.y;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getVisibility() == 0) goto L8;
        return;
    L8:
        if (g.f10945a.a(r14) == false) goto L28;
        int r1 = d.g.d.g.a.f16942a.b(r14);     // Catch: Exception -> L22
        if (p() == false) goto L14;
        float r2 = 16;
        Resources r5 = Resources.getSystem();     // Catch: Exception -> L22
        o.e(r5, "Resources.getSystem()");     // Catch: Exception -> L22
        r1 = r1 - kotlin.o0.a.a(TypedValue.applyDimension(1, r2, r5.getDisplayMetrics()));     // Catch: Exception -> L22
    L14:
        int r3 = C();     // Catch: Exception -> L22
        int r6 = E();     // Catch: Exception -> L22
        int r7 = D();     // Catch: Exception -> L22
        int r8 = B();     // Catch: Exception -> L22
        int r9 = A();     // Catch: Exception -> L22
        int r15 = com.obric.oui.common.util.f.b(r14);     // Catch: Exception -> L22
        float r10 = TTVideoUploader.KeyIsGetTosKey;
        Resources r11 = Resources.getSystem();     // Catch: Exception -> L22
        o.e(r11, "Resources.getSystem()");     // Catch: Exception -> L22
        if (r15 <= kotlin.o0.a.a(TypedValue.applyDimension(1, r10, r11.getDisplayMetrics()))) goto L17;
        int r16 = r15 + NetError.ERR_SSL_SERVER_CERT_CHANGED;     // Catch: Exception -> L22
    L18:
        int r4 = (((((r16 - r1) - r3) - r6) - r7) - r8) - r9;     // Catch: Exception -> L22
        Resources r12 = Resources.getSystem();     // Catch: Exception -> L22
        o.e(r12, "Resources.getSystem()");     // Catch: Exception -> L22
        int r13 = kotlin.r0.e.i(r4, 0, r16 - kotlin.o0.a.a(TypedValue.applyDimension(1, 52, r12.getDisplayMetrics())));     // Catch: Exception -> L22
        Resources r17 = Resources.getSystem();     // Catch: Exception -> L22
        o.e(r17, "Resources.getSystem()");     // Catch: Exception -> L22
        r0.measure(View.MeasureSpec.makeMeasureSpec(kotlin.o0.a.a(TypedValue.applyDimension(1, 440, r17.getDisplayMetrics())), Integer.MIN_VALUE), 0);     // Catch: Exception -> L22
        int r18 = r0.getMeasuredHeight();     // Catch: Exception -> L22
        d.g.d.f.f.b.a(this.r, "adjustContentHeight, maxHeight: " + r16 + ", HORIZONTAL_MAX_HEIGHT: 300, availableHeight: " + r4 + ", measured BodyHeight: " + r18 + ", maxBodyHeight: " + r13 + ", iconPanelVerticalSpace: " + r3 + ", titleVerticalSpace: " + r6 + ", messageVerticalSpace: " + r7 + ", buttonVerticalSpace: " + r8 + ", bodyMarginSpace: " + r9);     // Catch: Exception -> L22
        if (r18 <= r13) goto L29;
        d.g.d.f.f.b.e(this.r, "adjustContentHeight, from: " + r18 + " to: " + r13);     // Catch: Exception -> L22
        ViewGroup.LayoutParams r19 = r0.getLayoutParams();     // Catch: Exception -> L22
        r19.height = r13;     // Catch: Exception -> L22
        f0 r20 = f0.f18324a;     // Catch: Exception -> L22
        r0.setLayoutParams(r19);     // Catch: Exception -> L22
        return;
    L29:
        return;
    L17:
        Resources r110 = Resources.getSystem();     // Catch: Exception -> L22
        o.e(r110, "Resources.getSystem()");     // Catch: Exception -> L22
        r16 = kotlin.o0.a.a(TypedValue.applyDimension(1, r10, r110.getDisplayMetrics()));     // Catch: Exception -> L22
    L22:
        e = move-exception;
        d.g.d.f.f.b.c(this.r, "adjustContentHeight error", e);
        return;
    }

    public final boolean F() {
        return this.A;
    }

    public final void G() {
        super.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e("OAlertDialog", "origin Dismiss exception!", e);
    }

    public void H() {
        n().post(new b(this));
    }

    public void I() {
        ViewPropertySpringAnimator r0 = d.g.d.c.f.a.e(d.g.d.c.f.a.f16894a, n(), getWindow(), !i(), false, 4, null);
        ViewPropertySpringAnimator.setListener$default(r0, null, new C0442d(this), new c(this), 1, null);
        r0.start();
    }

    public final void J(boolean r1) {
        this.A = r1;
    }

    public final void K(f r5) {
        o.f(r5, "controller");
        this.z = r5;
        FrameLayout r0 = this.y;
        if (r0 != null) goto L5;
        return;
    L5:
        if (m() == false) goto L7;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        r1.height = 0;
        f0 r3 = f0.f18324a;
        r0.setLayoutParams(r1);
    L7:
        r0.setVisibility(0);
        Context r4 = getContext();
        o.e(r4, "context");
        r5.a(r4, r0);
    }

    public final void L(f r3) {
        o.f(r3, "controller");
        this.x = r3;
        FrameLayout r0 = this.w;
        if (r0 == null) goto L6;
        Context r2 = getContext();
        o.e(r2, "context");
        r3.a(r2, r0);
        return;
    }

    public final void M(CharSequence r2, boolean r3) {
        o.f(r2, "message");
        TextView r4 = this.v;
        if (r4 == null) goto L5;
        r4.setVisibility(0);
        r4.setText(r2);
    L5:
        TextView r1 = this.v;
        if (r1 == null) goto L9;
        r1.setMaxLines(Integer.MAX_VALUE);
        return;
    }

    public final void O(CharSequence r6) {
        o.f(r6, "title");
        TextView r5 = this.u;
        if (r5 == null) goto L6;
        r5.setVisibility(0);
        r5.setText(r6);
        float r7 = 19;
        Resources r1 = Resources.getSystem();
        o.e(r1, "Resources.getSystem()");
        int r2 = kotlin.o0.a.a(TypedValue.applyDimension(1, r7, r1.getDisplayMetrics()));
        Resources r4 = Resources.getSystem();
        o.e(r4, "Resources.getSystem()");
        r5.setPadding(0, r2, 0, kotlin.o0.a.a(TypedValue.applyDimension(1, r7, r4.getDisplayMetrics())));
        return;
    }

    public final void P(CharSequence r2) {
        o.f(r2, "title");
        TextView r1 = this.u;
        if (r1 == null) goto L6;
        r1.setVisibility(0);
        r1.setText(r2);
        r1.setPadding(0, 0, 0, 0);
        return;
    }

    public final void Q(f r3) {
        o.f(r3, "controller");
        this.t = r3;
        FrameLayout r0 = this.s;
        if (r0 == null) goto L6;
        r0.setVisibility(0);
        Context r2 = getContext();
        o.e(r2, "context");
        r3.a(r2, r0);
        return;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        I();
    }

    @Override // d.g.d.c.g.a
    public int k() {
        return com.obric.common.oui.g.f8256f;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle r3) {
        if (j() == false) goto L5;
        n().setAlpha(0.0f);
    L5:
        super.onCreate(r3);
        f r4 = this.t;
        if (r4 == null) goto L8;
        r4.b(this);
    L8:
        f r5 = this.x;
        if (r5 == null) goto L11;
        r5.b(this);
    L11:
        f r6 = this.z;
        if (r6 == null) goto L15;
        r6.b(this);
        return;
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        H();
        f r0 = this.x;
        if ((r0 instanceof d.g.d.c.e.a) == false) goto L5;
        Objects.requireNonNull(r0, "null cannot be cast to non-null type com.obric.oui.dialog.alert.ButtonStyleController");
        ((d.g.d.c.e.a) r0).e();
    L5:
        TextView r1 = this.v;
        if (r1 == null) goto L9;
        r1.postDelayed(new a(this), 1000);
        return;
    }

    @Override // d.g.d.c.g.a, android.app.Dialog
    public void show() {
        super.show();
        Context r0 = getContext();
        o.e(r0, "context");
        y(r0);
    }

    public final void z() {
        TextView r1 = this.v;
        if (r1 == null) goto L6;
        r1.setMaxLines(Integer.MAX_VALUE);
        return;
    }
}
