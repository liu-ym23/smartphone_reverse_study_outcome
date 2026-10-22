package d.g.d.c.g;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.ImageView;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.g;
import com.obric.oui.common.util.f;
import com.obric.oui.common.util.j;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.f0;
import kotlin.m;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(30)
public abstract class a extends Dialog {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f16907f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private View f16908g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ImageView f16909h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f16910i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f16911j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private EnumC0445a f16912k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private View.OnClickListener f16913l;
    private boolean m;
    private boolean n;
    private final b o;
    private final boolean p;
    private final boolean q;

    /* JADX INFO: renamed from: d.g.d.c.g.a$a, reason: collision with other inner class name */
    public static final enum EnumC0445a extends Enum<EnumC0445a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final EnumC0445a f16914f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final EnumC0445a f16915g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final EnumC0445a f16916h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final /* synthetic */ EnumC0445a[] f16917i = null;

        static {
            EnumC0445a r1 = new EnumC0445a("LIGHT", 0);
            f16914f = r1;
            EnumC0445a r2 = new EnumC0445a("DARK", 1);
            f16915g = r2;
            EnumC0445a r3 = new EnumC0445a("CUSTOM", 2);
            f16916h = r3;
            f16917i = new EnumC0445a[]{r1, r2, r3};
        }

        private EnumC0445a(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumC0445a valueOf(String r1) {
            return (EnumC0445a) Enum.valueOf(EnumC0445a.class, r1);
        }

        public static EnumC0445a[] values() {
            return (EnumC0445a[]) f16917i.clone();
        }
    }

    public static final class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f16918a;

        b(a r1, Looper r2) {
            this.f16918a = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r2) {
            o.f(r2, NotificationCompat.CATEGORY_MESSAGE);
            super.handleMessage(r2);
            if (r2.what != 101) goto L6;
            a.d(this.f16918a);
            return;
        }
    }

    static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f16919f;

        c(a r1, boolean r2) {
            this.f16919f = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.f16919f.dismiss();
            View.OnClickListener r1 = a.b(this.f16919f);
            if (r1 == null) goto L6;
            r1.onClick(r2);
            return;
        }
    }

    static final class d implements View.OnApplyWindowInsetsListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f16920a;

        d(a r1) {
            this.f16920a = r1;
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public final WindowInsets onApplyWindowInsets(View r12, WindowInsets r13) {
            o.f(r12, BaseSwitches.V);
            o.f(r13, "insets");
            d.g.d.g.a r0 = d.g.d.g.a.f16942a;
            int r1 = r0.b(this.f16920a.getContext());
            int r2 = r0.a(this.f16920a.n());
            d.g.d.f.f.b.i(a.c(this.f16920a), "onApplyWindowInsets, naviHeight: " + r1 + ", imeInsets: " + r2);
            Context r3 = this.f16920a.getContext();
            o.e(r3, "context");
            if (r2 >= f.b(r3)) goto L42;
            boolean r6 = true;
            Integer r7 = null;
            if (r2 <= 0) goto L20;
            if (this.f16920a.p() == false) goto L11;
            r12.setPadding(0, 0, 0, r2);
            String r14 = a.c(this.f16920a);
            StringBuilder r4 = new StringBuilder();
            r4.append("onApplyWindowInsets, update rootView.padding, bottomPadding: ");
        L9:
            r4.append(r2);
            String r5 = r4.toString();
        L10:
            d.g.d.f.f.b.i(r14, r5);
            r6 = false;
        L31:
            if (r6 == false) goto L42;
            d.g.d.f.b r15 = d.g.d.f.b.f16934a;
            Object r16 = this.f16920a.n().getParent();
            if (r16 != null) goto L36;
        L34:
            r16 = null;
        L37:
            View r17 = (View) r16;
            String r8 = a.c(this.f16920a);
            StringBuilder r9 = new StringBuilder();
            r9.append("onApplyWindowInsets, post recheck, parentView.height: ");
            if (r17 == null) goto L40;
            r7 = Integer.valueOf(r17.getHeight());
        L40:
            r9.append(r7);
            r9.append(", rootView.height: ");
            r9.append(this.f16920a.n().getHeight());
            d.g.d.f.f.b.i(r8, r9.toString());
            a.a(this.f16920a).removeMessages(101);
            a.a(this.f16920a).sendEmptyMessageDelayed(101, 200);
            goto L42
        L36:
            if ((r16 instanceof View) == false) goto L34;
        L11:
            View r18 = this.f16920a.n();
            ViewGroup.LayoutParams r10 = this.f16920a.n().getLayoutParams();
            if ((r10 instanceof ViewGroup.MarginLayoutParams) == true) goto L14;
            ViewGroup.LayoutParams r11 = null;
        L15:
            ViewGroup.MarginLayoutParams r19 = (ViewGroup.MarginLayoutParams) r11;
            if (r19 == null) goto L18;
            Resources r110 = Resources.getSystem();
            o.e(r110, "Resources.getSystem()");
            r19.bottomMargin = kotlin.o0.a.a(TypedValue.applyDimension(1, 16, r110.getDisplayMetrics())) + r2;
        L18:
            f0 r20 = f0.f18324a;
            r18.setLayoutParams(r10);
            r14 = a.c(this.f16920a);
            r4 = new StringBuilder();
            r4.append("onApplyWindowInsets, update rootView.layoutParams, bottomMargin: ");
            Resources r21 = Resources.getSystem();
            o.e(r21, "Resources.getSystem()");
            r2 = r2 + kotlin.o0.a.a(TypedValue.applyDimension(1, 16, r21.getDisplayMetrics()));
            goto L9
        L14:
            r11 = r10;
            goto L15
        L20:
            if (this.f16920a.p() == false) goto L22;
            Resources r22 = Resources.getSystem();
            o.e(r22, "Resources.getSystem()");
            int r23 = r1 - kotlin.o0.a.a(TypedValue.applyDimension(1, 16, r22.getDisplayMetrics()));
            this.f16920a.n().setPadding(0, 0, 0, r23);
            d.g.d.f.f.b.i(a.c(this.f16920a), "onApplyWindowInsets, update rootView.padding, bottomPadding: " + r23);
            goto L31
        L22:
            View r111 = this.f16920a.n();
            ViewGroup.LayoutParams r24 = this.f16920a.n().getLayoutParams();
            if ((r24 instanceof ViewGroup.MarginLayoutParams) == true) goto L25;
            ViewGroup.LayoutParams r25 = null;
        L26:
            ViewGroup.MarginLayoutParams r26 = (ViewGroup.MarginLayoutParams) r25;
            if (r26 == null) goto L29;
            r26.bottomMargin = r1;
        L29:
            f0 r27 = f0.f18324a;
            r111.setLayoutParams(r24);
            r14 = a.c(this.f16920a);
            r5 = "onApplyWindowInsets, update rootView.layoutParams, bottomMargin: " + r1;
            goto L10
        L25:
            r25 = r24;
        L42:
            return r13.consumeSystemWindowInsets();
        }
    }

    static {
    }

    public a(Context r3, boolean r4, boolean r5) {
        o.f(r3, "context");
        super(r3);
        this.p = r4;
        this.q = r5;
        this.f16907f = "AbstractDialog";
        this.f16912k = EnumC0445a.f16915g;
        Window r6 = getWindow();
        if (r6 == null) goto L5;
        r6.requestFeature(1);
    L5:
        if (r5 == false) goto L7;
        int r7 = g.f8258h;
    L8:
        setContentView(r7);
        View r8 = findViewById(com.obric.common.oui.f.L0);
        o.e(r8, "findViewById(R.id.root_view)");
        this.f16911j = r8;
        this.f16909h = (ImageView) findViewById(com.obric.common.oui.f.z);
        this.f16908g = findViewById(com.obric.common.oui.f.D);
        if (r5 == false) goto L18;
        View r9 = this.f16911j;
        if (r9 == null) goto L16;
        if (r9 == null) goto L14;
        ViewGroup.LayoutParams r0 = r9.getLayoutParams();
        r0.height = -1;
        f0 r1 = f0.f18324a;
        r9.setLayoutParams(r0);
        goto L18
    L14:
        o.v("rootView");
        throw null;
    L16:
        o.v("rootView");
        throw null;
    L18:
        u();
        t(this, this.f16910i, null, 2, null);
        ViewStub r10 = (ViewStub) findViewById(com.obric.common.oui.f.G);
        o.e(r10, "viewStub");
        r10.setLayoutResource(k());
        r10.inflate();
        d.g.d.c.f.a r11 = d.g.d.c.f.a.f16894a;
        View r2 = this.f16911j;
        if (r2 == null) goto L22;
        r11.a(r2);
        this.o = new b(this, Looper.getMainLooper());
        return;
    L22:
        o.v("rootView");
        throw null;
    L7:
        r7 = g.f8257g;
        goto L8
    }

    public static final /* synthetic */ b a(a r0) {
        return r0.o;
    }

    public static final /* synthetic */ View.OnClickListener b(a r0) {
        return r0.f16913l;
    }

    public static final /* synthetic */ String c(a r0) {
        return r0.f16907f;
    }

    public static final /* synthetic */ void d(a r0) {
        r0.r();
    }

    public static /* synthetic */ void g(a r1, EnumC0445a r2, Integer r3, Integer r4, int r5, Object r6) {
        if (r6 != null) goto L12;
        if ((r5 & 2) == 0) goto L7;
        r3 = null;
    L7:
        if ((r5 & 4) == 0) goto L9;
        r4 = null;
    L9:
        r1.f(r2, r3, r4);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: applyCloseIconStyle");
    }

    private final void q(Window r3) {
        if (Build.VERSION.SDK_INT < 29) goto L6;
        if (r3 == null) goto L6;
        r3.setNavigationBarContrastEnforced(false);
    L6:
        if (r3 == null) goto L8;
        r3.setDecorFitsSystemWindows(false);
    L8:
        if (r3 == null) goto L10;
        r3.clearFlags(134217728);
    L10:
        if (r3 == null) goto L12;
        r3.addFlags(Integer.MIN_VALUE);
    L12:
        if (r3 == null) goto L14;
        r3.setNavigationBarColor(0);
    L14:
        if (r3 == null) goto L17;
        r3.setNavigationBarDividerColor(0);
        return;
    }

    private final void r() {
        d.g.d.g.a r0 = d.g.d.g.a.f16942a;     // Catch: Exception -> L37
        View r1 = this.f16911j;     // Catch: Exception -> L37
        if (r1 != null) goto L6;
        o.v("rootView");     // Catch: Exception -> L37
        throw null;
    L6:
        if (r0.a(r1) <= 0) goto L8;
        return;
    L8:
        if (this.p == false) goto L42;
        d.g.d.f.b r2 = d.g.d.f.b.f16934a;     // Catch: Exception -> L37
        View r3 = this.f16911j;     // Catch: Exception -> L37
        if (r3 == null) goto L33;
        Object r4 = r3.getParent();     // Catch: Exception -> L37
        if (r4 != null) goto L15;
    L13:
        r4 = null;
    L16:
        View r5 = (View) r4;     // Catch: Exception -> L37
        if (r5 == null) goto L43;
        int r6 = r5.getHeight();     // Catch: Exception -> L37
        View r7 = this.f16911j;     // Catch: Exception -> L37
        if (r7 != null) goto L21;
        o.v("rootView");     // Catch: Exception -> L37
        throw null;
    L21:
        if (r6 <= r7.getHeight()) goto L44;
        View r8 = this.f16911j;     // Catch: Exception -> L37
        if (r8 == null) goto L29;
        r8.requestLayout();     // Catch: Exception -> L37
        String r9 = this.f16907f;     // Catch: Exception -> L37
        StringBuilder r10 = new StringBuilder();     // Catch: Exception -> L37
        r10.append("recheckInset, requestLayout, parentView.height: ");     // Catch: Exception -> L37
        r10.append(r5.getHeight());     // Catch: Exception -> L37
        r10.append(", rootView.height: ");     // Catch: Exception -> L37
        View r11 = this.f16911j;     // Catch: Exception -> L37
        if (r11 == null) goto L27;
        r10.append(r11.getHeight());     // Catch: Exception -> L37
        d.g.d.f.f.b.i(r9, r10.toString());     // Catch: Exception -> L37
        return;
    L27:
        o.v("rootView");     // Catch: Exception -> L37
        throw null;
    L29:
        o.v("rootView");     // Catch: Exception -> L37
        throw null;
    L44:
        return;
    L43:
        return;
    L15:
        if ((r4 instanceof View) == false) goto L13;
    L33:
        o.v("rootView");     // Catch: Exception -> L37
        throw null;
    L42:
        return;
    L37:
        e = move-exception;
        d.g.d.f.f.b.c(this.f16907f, "recheckInset failed", e);
    }

    public static /* synthetic */ void t(a r0, boolean r1, View.OnClickListener r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        r0.s(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setCloseIconEnabled");
    }

    private final void u() {
        View r0 = this.f16911j;
        if (r0 == null) goto L6;
        r0.setOnApplyWindowInsetsListener(new d(this));
        return;
    L6:
        o.v("rootView");
        throw null;
    }

    public final void e() {
        this.n = true;
    }

    public final void f(EnumC0445a r2, Integer r3, Integer r4) {
        o.f(r2, "style");
        if (this.f16910i == false) goto L38;
        int r5 = d.g.d.c.g.b.f16921a[r2.ordinal()];
        if (r5 != 1) goto L7;
        int r6 = com.obric.common.oui.c.f8211j;
        int r7 = com.obric.common.oui.c.f8209h;
    L17:
        r4 = Integer.valueOf(r7);
    L18:
        ImageView r8 = this.f16909h;
        if (r8 == null) goto L21;
        r8.setImageTintList(ContextCompat.getColorStateList(getContext(), r6));
    L21:
        Drawable r9 = null;
        if (r4 != null) goto L26;
        View r1 = this.f16908g;
        if (r1 == null) goto L39;
        r1.setBackground(null);
        return;
    L39:
        return;
    L26:
        View r10 = this.f16908g;
        if (r10 == null) goto L29;
        Drawable r11 = r10.getBackground();
    L31:
        if ((r11 instanceof GradientDrawable) == false) goto L34;
        r9 = r11;
    L34:
        GradientDrawable r12 = (GradientDrawable) r9;
        if (r12 == null) goto L41;
        r12.setColor(ContextCompat.getColorStateList(getContext(), r4.intValue()));
        return;
    L41:
        return;
    L29:
        r11 = null;
        goto L31
    L7:
        if (r5 != 2) goto L9;
        r6 = com.obric.common.oui.c.q;
        r7 = com.obric.common.oui.c.f8212k;
        goto L17
    L9:
        if (r5 != 3) goto L14;
        if (r3 == null) goto L12;
        r6 = r3.intValue();
        goto L18
    L12:
        r6 = com.obric.common.oui.c.f8211j;
        goto L18
    L14:
        throw new m();
    }

    public final void h() {
        this.m = true;
    }

    public final boolean i() {
        return this.n;
    }

    protected final boolean j() {
        return this.m;
    }

    public abstract int k();

    protected int l(Window r1) {
        o.f(r1, "$this$getLayoutMarginHorizontal");
        Context r0 = r1.getContext();
        o.e(r0, "context");
        return r0.getResources().getDimensionPixelSize(com.obric.common.oui.d.f8219f);
    }

    public final boolean m() {
        return this.q;
    }

    public final View n() {
        View r0 = this.f16911j;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.v("rootView");
        throw null;
    }

    protected final float o(Context r1) {
        o.f(r1, "context");
        Resources r0 = r1.getResources();
        o.e(r0, "context.resources");
        if ((r0.getConfiguration().uiMode & 48) != 32) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L8;
        return 0.8f;
    L8:
        return 0.32f;
    L5:
        r2 = false;
        goto L6
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        this.o.removeCallbacksAndMessages(null);
    }

    public final boolean p() {
        return this.p;
    }

    public void s(boolean r7, View.OnClickListener r8) {
        this.f16910i = r7;
        this.f16913l = r8;
        ImageView r9 = this.f16909h;
        if (r9 == null) goto L16;
        Resources r2 = Resources.getSystem();
        o.e(r2, "Resources.getSystem()");
        j.a(r9, kotlin.o0.a.a(TypedValue.applyDimension(1, 44, r2.getDisplayMetrics())));
        if (r7 == false) goto L12;
        View r10 = this.f16908g;
        if (r10 == null) goto L9;
        j.g(r10);
    L9:
        g(this, this.f16912k, null, null, 6, null);
        View r11 = this.f16908g;
        if (r11 == null) goto L17;
        r11.setOnClickListener(new c(this, r7));
        return;
    L17:
        return;
    L12:
        View r6 = this.f16908g;
        if (r6 == null) goto L19;
        j.e(r6);
        return;
    L19:
        return;
    }

    @Override // android.app.Dialog
    @RequiresApi(30)
    public void show() {
        super.show();
        Window r0 = getWindow();
        if (r0 == null) goto L62;
        r0.setBackgroundDrawableResource(R.color.transparent);
        if (this.n == false) goto L12;
        Window r1 = getWindow();
        if (r1 == null) goto L9;
        r1.setWindowAnimations(-1);
    L9:
        Window r2 = getWindow();
        if (r2 == null) goto L13;
        r2.clearFlags(2);
    L13:
        q(r0);
        WindowManager.LayoutParams r3 = r0.getAttributes();
        r3.gravity = 81;
        r3.setFitInsetsSides(WindowInsets.Side.all() ^ 8);
        if (this.q == false) goto L16;
        r3.height = -1;
    L18:
        if (this.p == false) goto L43;
        View r4 = this.f16911j;
        if (r4 == null) goto L41;
        if (r4 == null) goto L39;
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        r5.width = -1;
        if ((r5 instanceof ViewGroup.MarginLayoutParams) == true) goto L25;
        ViewGroup.LayoutParams r6 = null;
    L26:
        ViewGroup.MarginLayoutParams r7 = (ViewGroup.MarginLayoutParams) r6;
        if (r7 == null) goto L29;
        r7.bottomMargin = 0;
    L29:
        f0 r8 = f0.f18324a;
        r4.setLayoutParams(r5);
        View r9 = this.f16911j;
        if (r9 != null) goto L32;
        o.v("rootView");
        throw null;
    L32:
        if ((r9 instanceof RadiusLayout) == true) goto L34;
        r9 = null;
    L34:
        RadiusLayout r10 = (RadiusLayout) r9;
        if (r10 == null) goto L47;
        Context r11 = r10.getContext();
        o.e(r11, "context");
        float r12 = r11.getResources().getDimension(com.obric.common.oui.d.f8223j);
        r10.c(r12, r12, 0.0f, 0.0f);
    L47:
        com.obric.oui.common.util.g r13 = com.obric.oui.common.util.g.f10945a;
        Context r14 = r0.getContext();
        o.e(r14, "context");
        if (r13.a(r14) == false) goto L57;
        View r15 = this.f16911j;
        if (r15 == null) goto L55;
        if (r15 == null) goto L53;
        ViewGroup.LayoutParams r16 = r15.getLayoutParams();
        Resources r17 = Resources.getSystem();
        o.e(r17, "Resources.getSystem()");
        r16.width = kotlin.o0.a.a(TypedValue.applyDimension(1, 440, r17.getDisplayMetrics()));
        f0 r18 = f0.f18324a;
        r15.setLayoutParams(r16);
        goto L57
    L53:
        o.v("rootView");
        throw null;
    L55:
        o.v("rootView");
        throw null;
    L57:
        r0.setAttributes(r3);
        return;
    L25:
        r6 = r5;
        goto L26
    L39:
        o.v("rootView");
        throw null;
    L41:
        o.v("rootView");
        throw null;
    L43:
        View r19 = this.f16911j;
        if (r19 == null) goto L60;
        if (r19 == null) goto L58;
        ViewGroup.LayoutParams r20 = r19.getLayoutParams();
        Context r21 = r0.getContext();
        o.e(r21, "context");
        Resources r22 = r21.getResources();
        o.e(r22, "context.resources");
        r20.width = r22.getDisplayMetrics().widthPixels - (l(r0) * 2);
        f0 r23 = f0.f18324a;
        r19.setLayoutParams(r20);
        goto L47
    L58:
        o.v("rootView");
        throw null;
    L60:
        o.v("rootView");
        throw null;
    L16:
        r3.height = -2;
        goto L18
    L12:
        r0.addFlags(2);
        goto L13
    }
}
