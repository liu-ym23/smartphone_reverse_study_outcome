package d.g.d.c.e;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.g;
import com.obric.oui.button.OButton;
import com.obric.oui.common.util.j;
import kotlin.m;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private OButton f16848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private OButton f16849b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private OButton f16850c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d.g.d.c.e.d f16851d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f16852e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private FrameLayout f16853f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Context f16854g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f16855h;

    /* JADX INFO: renamed from: d.g.d.c.e.a$a, reason: collision with other inner class name */
    public static final enum EnumC0441a extends Enum<EnumC0441a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final EnumC0441a f16856f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final EnumC0441a f16857g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final EnumC0441a f16858h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final /* synthetic */ EnumC0441a[] f16859i = null;

        static {
            EnumC0441a r1 = new EnumC0441a("TextReverse", 0);
            f16856f = r1;
            EnumC0441a r2 = new EnumC0441a("TextReverse2", 1);
            f16857g = r2;
            EnumC0441a r3 = new EnumC0441a("Negative", 2);
            f16858h = r3;
            f16859i = new EnumC0441a[]{r1, r2, r3};
        }

        private EnumC0441a(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumC0441a valueOf(String r1) {
            return (EnumC0441a) Enum.valueOf(EnumC0441a.class, r1);
        }

        public static EnumC0441a[] values() {
            return (EnumC0441a[]) f16859i.clone();
        }
    }

    static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f16860f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f16861g;

        b(a r1, CharSequence r2, EnumC0441a r3, DialogInterface.OnClickListener r4) {
            this.f16860f = r1;
            this.f16861g = r4;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            DialogInterface.OnClickListener r4 = this.f16861g;
            if (r4 == null) goto L5;
            r4.onClick(a.c(this.f16860f), -2);
        L5:
            a.d(this.f16860f);
        }
    }

    static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f16862f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f16863g;

        c(a r1, CharSequence r2, EnumC0441a r3, DialogInterface.OnClickListener r4) {
            this.f16862f = r1;
            this.f16863g = r4;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            DialogInterface.OnClickListener r4 = this.f16863g;
            if (r4 == null) goto L5;
            r4.onClick(a.c(this.f16862f), -3);
        L5:
            a.d(this.f16862f);
        }
    }

    static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f16864f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f16865g;

        d(a r1, CharSequence r2, boolean r3, EnumC0441a r4, DialogInterface.OnClickListener r5) {
            this.f16864f = r1;
            this.f16865g = r5;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            DialogInterface.OnClickListener r4 = this.f16865g;
            if (r4 == null) goto L5;
            r4.onClick(a.c(this.f16864f), -1);
        L5:
            a.d(this.f16864f);
        }
    }

    static {
    }

    public a(Context r2, int r3) {
        o.f(r2, "context");
        this.f16854g = r2;
        this.f16855h = r3;
    }

    public static final /* synthetic */ d.g.d.c.e.d c(a r0) {
        return r0.f16851d;
    }

    public static final /* synthetic */ void d(a r0) {
        r0.k();
    }

    private final void j(OButton r1, EnumC0441a r2) {
        if (r2 == null) goto L16;
        int r0 = d.g.d.c.e.b.f16866a[r2.ordinal()];
        if (r0 != 1) goto L6;
        int r3 = com.obric.common.oui.c.o;
    L14:
        r1.setTextColor(ContextCompat.getColor(r1.getContext(), r3));
        return;
    L6:
        if (r0 != 2) goto L8;
        r3 = com.obric.common.oui.c.q;
        goto L14
    L8:
        if (r0 != 3) goto L11;
        r3 = com.obric.common.oui.c.r;
        goto L14
    L11:
        throw new m();
    }

    private final void k() {
        d.g.d.c.e.d r0 = this.f16851d;
        if (r0 != null) goto L5;
    L7:
        d.g.d.c.e.d r1 = this.f16851d;
        if (r1 == null) goto L11;
        r1.dismiss();
        return;
    L11:
        return;
    L5:
        if (r0.F() == true) goto L7;
    }

    @Override // d.g.d.c.e.f
    public void a(Context r4, FrameLayout r5) {
        o.f(r4, "context");
        o.f(r5, "parent");
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-1, -2);
        int r1 = this.f16855h;
        if (r1 != 0) goto L5;
        int r2 = g.f8262l;
    L9:
        View r6 = LayoutInflater.from(r4).inflate(r2, r5, false);
        r5.addView(r6, r0);
        this.f16852e = r6;
        if (r6 == null) goto L12;
        r6.setVisibility(8);
    L12:
        this.f16848a = (OButton) r6.findViewById(com.obric.common.oui.f.f8241c);
        this.f16849b = (OButton) r6.findViewById(com.obric.common.oui.f.f8239a);
        this.f16850c = (OButton) r6.findViewById(com.obric.common.oui.f.f8240b);
        this.f16853f = (FrameLayout) r6.findViewById(com.obric.common.oui.f.f8238J);
        return;
    L5:
        if (r1 == 1) goto L7;
        r2 = g.m;
        goto L9
    L7:
        r2 = g.n;
        goto L9
    }

    @Override // d.g.d.c.e.f
    public void b(d.g.d.c.e.d r2) {
        o.f(r2, "dialog");
        this.f16851d = r2;
    }

    public final void e() {
    }

    public final void f(View r3) {
        o.f(r3, "view");
        if (this.f16855h == 2) goto L5;
        return;
    L5:
        if (this.f16853f == null) goto L17;
        View r0 = this.f16852e;
        if (r0 == null) goto L9;
        r0.setVisibility(0);
    L9:
        FrameLayout r1 = this.f16853f;
        if (r1 == null) goto L12;
        r1.addView(r3);
    L12:
        FrameLayout r2 = this.f16853f;
        if (r2 == null) goto L18;
        j.g(r2);
        return;
    L18:
        return;
    }

    public final void g(CharSequence r4, DialogInterface.OnClickListener r5, EnumC0441a r6) {
        OButton r0 = this.f16849b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r4) == false) goto L8;
        r0.setVisibility(8);
        return;
    L8:
        View r1 = this.f16852e;
        if (r1 == null) goto L11;
        r1.setVisibility(0);
    L11:
        r0.setText(r4);
        j(r0, r6);
        r0.setVisibility(0);
        r0.setOnClickListener(new b(this, r4, r6, r5));
    }

    public final void h(CharSequence r4, DialogInterface.OnClickListener r5, EnumC0441a r6) {
        OButton r0 = this.f16850c;
        if (r0 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r4) == false) goto L8;
        r0.setVisibility(8);
        return;
    L8:
        View r1 = this.f16852e;
        if (r1 == null) goto L11;
        r1.setVisibility(0);
    L11:
        r0.setText(r4);
        j(r0, r6);
        r0.setVisibility(0);
        r0.setOnClickListener(new c(this, r4, r6, r5));
    }

    public final void i(CharSequence r10, DialogInterface.OnClickListener r11, EnumC0441a r12, boolean r13) {
        OButton r0 = this.f16848a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r10) == false) goto L8;
        r0.setVisibility(8);
        return;
    L8:
        View r1 = this.f16852e;
        if (r1 == null) goto L11;
        r1.setVisibility(0);
    L11:
        if (r13 == false) goto L13;
        r0.setBackgroundTintList(ContextCompat.getColorStateList(this.f16854g, com.obric.common.oui.c.N));
        r0.setTextColor(ContextCompat.getColor(this.f16854g, com.obric.common.oui.c.U));
    L13:
        r0.setText(r10);
        j(r0, r12);
        r0.setVisibility(0);
        r0.setOnClickListener(new d(this, r10, r13, r12, r11));
    }
}
