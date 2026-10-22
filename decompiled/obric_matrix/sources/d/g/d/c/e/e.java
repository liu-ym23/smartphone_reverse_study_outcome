package d.g.d.c.e;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.RequiresApi;
import kotlin.f0;
import kotlin.n0.c.l;
import kotlin.n0.c.p;
import kotlin.n0.d.o;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes2.dex */
public class e extends d.g.d.c.g.c<d.g.d.c.e.d> {
    private CharSequence A;
    private DialogInterface.OnClickListener B;
    private d.g.d.c.e.a.EnumC0441a C;
    private boolean D;
    private f E;
    private f F;
    private boolean G;
    private boolean H;
    private boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private boolean f16883J;
    private View K;
    private boolean L;
    private boolean M;
    private final Context N;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private CharSequence f16884i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private CharSequence f16885j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f16886k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Drawable f16887l;
    private String m;
    private com.obric.oui.dialog.alert.view.a n;
    private a o;
    private Integer p;
    private Integer q;
    private boolean r;
    private int s;
    private CharSequence t;
    private DialogInterface.OnClickListener u;
    private d.g.d.c.e.a.EnumC0441a v;
    private CharSequence w;
    private DialogInterface.OnClickListener x;
    private d.g.d.c.e.a.EnumC0441a y;
    private boolean z;

    public interface a {
        void a(ImageView r1);
    }

    static final class b extends q implements l<CharSequence, f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ e f16888f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ d.g.d.c.e.d f16889g;

        b(e r1, d.g.d.c.e.d r2) {
            this.f16888f = r1;
            this.f16889g = r2;
            super(1);
        }

        public final void a(CharSequence r2) {
            o.f(r2, "it");
            boolean r0 = e.k(this.f16888f);
            d.g.d.c.e.d r1 = this.f16889g;
            if (r0 == false) goto L5;
            r1.O(r2);
            return;
        L5:
            r1.P(r2);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(CharSequence r1) {
            a(r1);
            return f0.f18324a;
        }
    }

    static final class c extends q implements l<CharSequence, f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ e f16890f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ d.g.d.c.e.d f16891g;

        c(e r1, d.g.d.c.e.d r2) {
            this.f16890f = r1;
            this.f16891g = r2;
            super(1);
        }

        public final void a(CharSequence r5) {
            o.f(r5, "it");
            d.g.d.c.e.d.N(this.f16891g, r5, false, 2, null);
            if (e.j(this.f16890f) == false) goto L6;
            this.f16891g.z();
            return;
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(CharSequence r1) {
            a(r1);
            return f0.f18324a;
        }
    }

    static final class d implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ p f16892f;

        d(p r1) {
            this.f16892f = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r2, int r3) {
            p r1 = this.f16892f;
            o.e(r2, "dialog");
            r1.invoke(r2, Integer.valueOf(r3));
        }
    }

    /* JADX INFO: renamed from: d.g.d.c.e.e$e, reason: collision with other inner class name */
    static final class DialogInterfaceOnClickListenerC0443e implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ p f16893f;

        DialogInterfaceOnClickListenerC0443e(p r1) {
            this.f16893f = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r2, int r3) {
            p r1 = this.f16893f;
            o.e(r2, "dialog");
            r1.invoke(r2, Integer.valueOf(r3));
        }
    }

    public e(Context r2) {
        o.f(r2, "context");
        super(r2);
        this.N = r2;
        this.m = "";
        this.D = true;
        super.b(false);
    }

    public static final /* synthetic */ boolean j(e r0) {
        return r0.f16883J;
    }

    public static final /* synthetic */ boolean k(e r0) {
        return r0.f16886k;
    }

    public static /* synthetic */ e s(e r0, CharSequence r1, boolean r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        r0.r(r1, r2);
        return r0;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: title");
    }

    private final void t(CharSequence r1, l<? super CharSequence, f0> r2) {
        if (TextUtils.isEmpty(r1) == true) goto L6;
        o.c(r1);
        r2.invoke(r1);
        return;
    }

    @Override // d.g.d.c.g.c
    public /* bridge */ /* synthetic */ d.g.d.c.g.a c() {
        return m();
    }

    public final e l(boolean r1) {
        this.D = r1;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @RequiresApi(30)
    public d.g.d.c.e.d m() {
        d.g.d.c.e.d r0 = p(this.N, this.H, this.G);
        t(this.f16884i, new b(this, r0));
        t(this.f16885j, new c(this, r0));
        f r1 = this.F;
        boolean r2 = true;
        if (r1 == null) goto L6;
        r0.Q(r1);
    L33:
        r0.J(this.D);
        d.g.d.c.e.a r3 = new d.g.d.c.e.a(this.N, this.s);
        r0.L(r3);
        f r4 = this.E;
        if (r4 == null) goto L37;
        r0.K(r4);
    L37:
        if (f() == true) goto L44;
        if (this.s == 2) goto L42;
        r2 = false;
    L42:
        d.g.d.c.g.c.i(this, r2, null, 2, null);
    L44:
        if (this.I == false) goto L47;
        d.g.d.c.g.c.i(this, false, null, 2, null);
    L47:
        if (this.L == false) goto L50;
        r0.h();
    L50:
        if (this.M == false) goto L52;
        r0.e();
    L52:
        r0.setOnShowListener(g());
        r0.setOnDismissListener(e());
        r0.setOnCancelListener(d());
        r3.i(this.w, this.x, this.y, this.z);
        r3.g(this.t, this.u, this.v);
        r3.h(this.A, this.B, this.C);
        View r7 = this.K;
        if (r7 == null) goto L55;
        o.c(r7);
        r3.f(r7);
    L55:
        return r0;
    L6:
        if (this.m.length() <= 0) goto L8;
        Object[] r5 = true;
    L9:
        if (r5 == true) goto L11;
    L13:
        Object[] r6 = false;
    L14:
        Drawable r8 = this.f16887l;
        if (r8 != null) goto L19;
        if (r6 == true) goto L19;
        if (this.o == null) goto L33;
    L19:
        d.g.d.c.e.c r9 = new d.g.d.c.e.c(this.N, this.r ? 1 : 0);
        a r10 = this.o;
        if (r10 == null) goto L22;
        o.c(r10);
        r9.j(r10);
    L32:
        r0.Q(r9);
        goto L33
    L22:
        if (r8 == null) goto L24;
        r9.f(r8);
        Integer r11 = this.p;
        Integer r12 = this.q;
    L31:
        r9.i(r11, r12);
        goto L32
    L24:
        r9.g(this.m);
        com.obric.oui.dialog.alert.view.a r13 = this.n;
        if (r13 == null) goto L27;
        r9.h(r13);
    L27:
        r11 = this.p;
        if (r11 == null) goto L32;
        r12 = this.q;
        if (r12 == null) goto L32;
    L11:
        if (this.n == null) goto L13;
        r6 = true;
        goto L14
    L8:
        r5 = false;
        goto L9
    }

    public final e n(CharSequence r1) {
        this.f16885j = r1;
        return this;
    }

    public final e o(CharSequence r2, p<? super DialogInterface, ? super Integer, f0> r3) {
        o.f(r2, "text");
        o.f(r3, "listener");
        this.t = r2;
        this.u = new d(r3);
        return this;
    }

    @RequiresApi(30)
    public d.g.d.c.e.d p(Context r1, boolean r2, boolean r3) {
        o.f(r1, "context");
        return new d.g.d.c.e.d(r1, r2, r3);
    }

    public final e q(CharSequence r2, p<? super DialogInterface, ? super Integer, f0> r3) {
        o.f(r2, "text");
        o.f(r3, "listener");
        this.w = r2;
        this.x = new DialogInterfaceOnClickListenerC0443e(r3);
        return this;
    }

    public final e r(CharSequence r1, boolean r2) {
        this.f16886k = r2;
        this.f16884i = r1;
        return this;
    }
}
