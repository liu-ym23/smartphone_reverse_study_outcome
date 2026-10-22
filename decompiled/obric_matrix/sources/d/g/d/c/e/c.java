package d.g.d.c.e;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.bytedance.common.wschannel.WsConstants;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Drawable f16867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f16868b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.obric.oui.dialog.alert.view.a f16869c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private e.a f16870d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Integer f16871e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Integer f16872f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f16873g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @DrawableRes
    private int f16874h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private View f16875i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Context f16876j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f16877k;

    public static final class a extends FrameLayout {
        public a(Context r2) {
            o.f(r2, "context");
            super(r2);
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int r2, int r3) {
            super.onMeasure(r2, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r2) / 2, BasicMeasure.EXACTLY));
        }
    }

    static {
    }

    public c(Context r2, int r3) {
        o.f(r2, "context");
        this.f16876j = r2;
        this.f16877k = r3;
    }

    private final void c(Context r5, FrameLayout r6) {
        Integer r1 = this.f16872f;
        if (r1 == null) goto L5;
        o.c(r1);
        int r2 = r1.intValue();
    L6:
        Integer r3 = this.f16871e;
        if (r3 == null) goto L9;
        o.c(r3);
        int r4 = r3.intValue();
    L10:
        ViewGroup.LayoutParams r0 = new FrameLayout.LayoutParams(r2, r4);
        if (this.f16873g == false) goto L13;
        FrameLayout r7 = new FrameLayout(r5);
    L14:
        r7.addView(e(), new FrameLayout.LayoutParams(-1, -1));
        r6.addView(r7, r0);
        return;
    L13:
        r7 = new a(r5);
        goto L14
    L9:
        r4 = -2;
        goto L10
    L5:
        r2 = -1;
        goto L6
    }

    private final void d(Context r5, FrameLayout r6) {
        Integer r0 = this.f16872f;
        int r1 = -2;
        if (r0 == null) goto L5;
        o.c(r0);
        int r2 = r0.intValue();
    L6:
        Integer r3 = this.f16871e;
        if (r3 == null) goto L9;
        o.c(r3);
        r1 = r3.intValue();
    L9:
        FrameLayout.LayoutParams r7 = new FrameLayout.LayoutParams(r2, r1);
        r7.gravity = 1;
        Resources r4 = Resources.getSystem();
        o.e(r4, "Resources.getSystem()");
        r7.topMargin = kotlin.o0.a.a(TypedValue.applyDimension(1, 28, r4.getDisplayMetrics()));
        r6.addView(e(), r7);
        return;
    L5:
        r2 = -2;
        goto L6
    }

    private final View e() {
        View r0 = this.f16875i;
        if (r0 == null) goto L5;
        return r0;
    L5:
        ImageView r1 = new ImageView(this.f16876j);
        r1.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Drawable r2 = this.f16867a;
        int r3 = this.f16874h;
        String r4 = this.f16868b;
        e.a r5 = this.f16870d;
        if (r5 == null) goto L9;
        if (r5 == null) goto L23;
        r5.a(r1);
    L23:
        return r1;
    L9:
        if (r2 == null) goto L11;
        r1.setImageDrawable(r2);
        goto L23
    L11:
        if (r3 == 0) goto L13;
        r1.setImageResource(r3);
        goto L23
    L13:
        if (r4 != null) goto L15;
    L18:
        boolean r6 = true;
    L19:
        if (r6 == true) goto L23;
        com.obric.oui.dialog.alert.view.a r7 = this.f16869c;
        if (r7 == null) goto L23;
        r7.a(r1, r4);
        goto L23
    L15:
        if (r4.length() == 0) goto L18;
        r6 = false;
        goto L19
    }

    @Override // d.g.d.c.e.f
    public void a(Context r2, FrameLayout r3) {
        o.f(r2, "context");
        o.f(r3, "parent");
        if (this.f16877k != 0) goto L5;
        d(r2, r3);
        return;
    L5:
        c(r2, r3);
    }

    @Override // d.g.d.c.e.f
    public void b(d r1) {
        o.f(r1, "dialog");
    }

    public final void f(Drawable r2) {
        o.f(r2, "drawable");
        this.f16867a = r2;
    }

    public final void g(String r2) {
        o.f(r2, WsConstants.KEY_CONNECTION_URL);
        this.f16868b = r2;
    }

    public final void h(com.obric.oui.dialog.alert.view.a r2) {
        o.f(r2, "delegate");
        this.f16869c = r2;
    }

    public final void i(Integer r1, Integer r2) {
        this.f16872f = r1;
        this.f16871e = r2;
        this.f16873g = true;
    }

    public final void j(e.a r2) {
        o.f(r2, "loader");
        this.f16870d = r2;
    }
}
