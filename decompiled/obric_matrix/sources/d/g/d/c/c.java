package d.g.d.c;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.obric.common.oui.j;
import kotlin.n0.d.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends Dialog {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private d.g.d.c.d f16822f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f16823g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f16824h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f16825i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f16826j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private CharSequence f16827k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f16828l;
    private d.g.d.c.b m;
    private String n;
    private d.g.d.c.a o;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f16829a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f16830b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f16831c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f16832d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private CharSequence f16833e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f16834f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private d.g.d.c.b f16835g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f16836h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private d.g.d.c.a f16837i;

        public a() {
            this.f16830b = true;
            this.f16831c = "";
            this.f16832d = true;
            this.f16833e = "";
        }

        public final c a(Context r5) {
            o.f(r5, "context");
            c r0 = new c(r5, 0, 2, null);
            c.i(r0, this.f16829a);
            c.f(r0, this.f16830b);
            c.l(r0, this.f16831c);
            c.k(r0, this.f16832d);
            c.j(r0, this.f16833e);
            c.h(r0, this.f16834f);
            c.g(r0, this.f16835g);
            c.e(r0, this.f16836h);
            c.d(r0, this.f16837i);
            return r0;
        }

        public final a b(d.g.d.c.a r2, String r3) {
            o.f(r2, "listener");
            this.f16836h = r3;
            this.f16837i = r2;
            return this;
        }

        public final a c(boolean r1) {
            this.f16830b = r1;
            return this;
        }

        public final a d(d.g.d.c.b r2, String r3) {
            o.f(r2, "listener");
            this.f16834f = r3;
            this.f16835g = r2;
            return this;
        }

        public final a e(boolean r2, CharSequence r3) {
            o.f(r3, "message");
            this.f16832d = r2;
            this.f16833e = r3;
            return this;
        }

        public final a f(String r2) {
            o.f(r2, "title");
            this.f16831c = r2;
            return this;
        }
    }

    public static final class b implements DialogInterface.OnKeyListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface r1, int r2, KeyEvent r3) {
            if (r2 != 4) goto L6;
            return true;
        L6:
            return false;
        }
    }

    /* JADX INFO: renamed from: d.g.d.c.c$c, reason: collision with other inner class name */
    public static final class ViewTreeObserverOnPreDrawListenerC0440c implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ c f16838f;

        ViewTreeObserverOnPreDrawListenerC0440c(c r1) {
            this.f16838f = r1;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            c.a(this.f16838f).c().getViewTreeObserver().removeOnPreDrawListener(this);
            int r0 = c.a(this.f16838f).c().getLineCount();
            TextView r2 = c.a(this.f16838f).c();
            if (r0 <= 1) goto L5;
            r2.setGravity(3);
            return false;
        L5:
            r2.setGravity(1);
            return false;
        }
    }

    static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ c f16839f;

        d(c r1) {
            this.f16839f = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.f16839f.dismiss();
            d.g.d.c.b r0 = c.c(this.f16839f);
            if (r0 == null) goto L6;
            r0.a();
            return;
        }
    }

    static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ c f16840f;

        e(c r1) {
            this.f16840f = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.f16840f.dismiss();
            d.g.d.c.a r0 = c.b(this.f16840f);
            if (r0 == null) goto L6;
            r0.cancel();
            return;
        }
    }

    static final class f implements DialogInterface.OnCancelListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ c f16841f;

        f(c r1) {
            this.f16841f = r1;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r1) {
            d.g.d.c.a r0 = c.b(this.f16841f);
            if (r0 == null) goto L6;
            r0.cancel();
            return;
        }
    }

    private c(Context r1, int r2) {
        super(r1, j.f8281f);
        this.f16824h = true;
        this.f16825i = "";
        this.f16826j = true;
        this.f16827k = "";
    }

    /* synthetic */ c(Context r1, int r2, int r3, g r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = j.f8281f;
    L5:
        this(r1, r2);
    }

    public static final /* synthetic */ d.g.d.c.d a(c r0) {
        d.g.d.c.d r1 = r0.f16822f;
        if (r1 == null) goto L5;
        return r1;
    L5:
        o.v("binding");
        throw null;
    }

    public static final /* synthetic */ d.g.d.c.a b(c r0) {
        return r0.o;
    }

    public static final /* synthetic */ d.g.d.c.b c(c r0) {
        return r0.m;
    }

    public static final /* synthetic */ void d(c r0, d.g.d.c.a r1) {
        r0.o = r1;
    }

    public static final /* synthetic */ void e(c r0, String r1) {
        r0.n = r1;
    }

    public static final /* synthetic */ void f(c r0, boolean r1) {
        r0.f16824h = r1;
    }

    public static final /* synthetic */ void g(c r0, d.g.d.c.b r1) {
        r0.m = r1;
    }

    public static final /* synthetic */ void h(c r0, String r1) {
        r0.f16828l = r1;
    }

    public static final /* synthetic */ void i(c r0, boolean r1) {
        r0.f16823g = r1;
    }

    public static final /* synthetic */ void j(c r0, CharSequence r1) {
        r0.f16827k = r1;
    }

    public static final /* synthetic */ void k(c r0, boolean r1) {
        r0.f16826j = r1;
    }

    public static final /* synthetic */ void l(c r0, String r1) {
        r0.f16825i = r1;
    }

    private final void m() {
        d.g.d.c.d r0 = this.f16822f;
        if (r0 == null) goto L54;
        r0.d().setText(this.f16825i);
        d.g.d.c.d r1 = this.f16822f;
        if (r1 == null) goto L52;
        TextView r2 = r1.c();
        boolean r4 = false;
        if (this.f16826j == false) goto L9;
        int r3 = 0;
    L10:
        r2.setVisibility(r3);
        d.g.d.c.d r5 = this.f16822f;
        if (r5 == null) goto L50;
        r5.c().setText(this.f16827k);
        d.g.d.c.d r6 = this.f16822f;
        if (r6 == null) goto L48;
        r6.c().getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserverOnPreDrawListenerC0440c(this));
        String r7 = this.f16828l;
        if (r7 != null) goto L17;
    L20:
        boolean r8 = true;
    L21:
        if (r8 == true) goto L27;
        d.g.d.c.d r9 = this.f16822f;
        if (r9 == null) goto L25;
        r9.b().setText(this.f16828l);
        goto L27
    L25:
        o.v("binding");
        throw null;
    L27:
        d.g.d.c.d r10 = this.f16822f;
        if (r10 == null) goto L46;
        r10.b().setOnClickListener(new d(this));
        String r11 = this.n;
        if (r11 != null) goto L32;
    L33:
        r4 = true;
    L34:
        if (r4 == true) goto L40;
        d.g.d.c.d r12 = this.f16822f;
        if (r12 == null) goto L38;
        r12.a().setText(this.n);
        goto L40
    L38:
        o.v("binding");
        throw null;
    L40:
        d.g.d.c.d r13 = this.f16822f;
        if (r13 == null) goto L44;
        r13.a().setOnClickListener(new e(this));
        setOnCancelListener(new f(this));
        return;
    L44:
        o.v("binding");
        throw null;
    L32:
        if (r11.length() != 0) goto L34;
    L46:
        o.v("binding");
        throw null;
    L17:
        if (r7.length() == 0) goto L20;
        r8 = false;
        goto L21
    L48:
        o.v("binding");
        throw null;
    L50:
        o.v("binding");
        throw null;
    L9:
        r3 = 8;
        goto L10
    L52:
        o.v("binding");
        throw null;
    L54:
        o.v("binding");
        throw null;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle r6) {
        super.onCreate(r6);
        requestWindowFeature(1);
        d.g.d.c.d.a r0 = d.g.d.c.d.f16842f;
        LayoutInflater r1 = LayoutInflater.from(getContext());
        o.e(r1, "LayoutInflater.from(context)");
        d.g.d.c.d r2 = r0.a(r1, null, false);
        this.f16822f = r2;
        if (r2 == null) goto L17;
        setContentView(r2.e());
        if (this.f16824h == true) goto L7;
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        setOnKeyListener(new b());
    L7:
        m();
        Window r3 = getWindow();
        if (r3 != null) goto L10;
        return;
    L10:
        if (this.f16823g == false) goto L12;
        r3.setType(2038);
    L12:
        r3.setLayout(-1, -2);
        r3.setGravity(17);
        r3.setBackgroundDrawable(new ColorDrawable(0));
        WindowManager.LayoutParams r5 = r3.getAttributes();
        TypedArray r4 = r3.getWindowStyle();
        o.e(r4, "windowStyle");
        Resources r7 = r4.getResources();
        o.e(r7, "windowStyle.resources");
        int r8 = r7.getDisplayMetrics().widthPixels;
        Resources r9 = Resources.getSystem();
        o.e(r9, "Resources.getSystem()");
        int r10 = r8 - (kotlin.o0.a.a(TypedValue.applyDimension(1, 24, r9.getDisplayMetrics())) * 2);
        r5.width = r10;
        float r11 = 312;
        Resources r12 = Resources.getSystem();
        o.e(r12, "Resources.getSystem()");
        if (r10 <= kotlin.o0.a.a(TypedValue.applyDimension(1, r11, r12.getDisplayMetrics()))) goto L15;
        Resources r13 = Resources.getSystem();
        o.e(r13, "Resources.getSystem()");
        r5.width = kotlin.o0.a.a(TypedValue.applyDimension(1, r11, r13.getDisplayMetrics()));
    L15:
        r3.setAttributes(r5);
        return;
    L17:
        o.v("binding");
        throw null;
    }
}
