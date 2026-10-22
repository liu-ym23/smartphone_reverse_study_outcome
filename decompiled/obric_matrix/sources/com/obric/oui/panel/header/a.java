package com.obric.oui.panel.header;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewCompat;
import com.obric.common.oui.d;
import com.obric.common.oui.f;
import com.obric.oui.common.util.j;
import com.obric.oui.divider.ODivider;
import kotlin.b0;
import kotlin.n0.d.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public class a extends b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AppCompatImageView f11240f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final TextView f11241g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ImageView f11242h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final View f11243i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final View f11244j;

    /* JADX INFO: renamed from: com.obric.oui.panel.header.a$a, reason: collision with other inner class name */
    public static final class ViewOnAttachStateChangeListenerC0296a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f11245f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ a f11246g;

        public ViewOnAttachStateChangeListenerC0296a(View r1, a r2) {
            this.f11245f = r1;
            this.f11246g = r2;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View r6) {
            o.g(r6, "view");
            this.f11245f.removeOnAttachStateChangeListener(this);
            Resources r0 = Resources.getSystem();
            o.e(r0, "Resources.getSystem()");
            int r7 = kotlin.o0.a.a(TypedValue.applyDimension(1, 44, r0.getDisplayMetrics()));
            j.d(a.h(this.f11246g), r7, r7, new View[]{a.f(this.f11246g), a.g(this.f11246g)});
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View r1) {
            o.g(r1, "view");
        }
    }

    public a(Context r2, View.OnClickListener r3, CharSequence r4) {
        o.f(r2, "context");
        this(r2, r3, r4, false);
    }

    public /* synthetic */ a(Context r2, View.OnClickListener r3, CharSequence r4, int r5, g r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = null;
    L8:
        this(r2, r3, r4);
    }

    public a(Context r8, View.OnClickListener r9, CharSequence r10, boolean r11) {
        o.f(r8, "context");
        super(r8, r11, 0, 4, null);
        View r12 = View.inflate(b.b(this, r8, false, 2, null), com.obric.common.oui.g.f8260j, null);
        o.e(r12, "View.inflate(generateThe…anel_normal_header, null)");
        this.f11244j = r12;
        int r1 = com.obric.oui.common.util.a.f10942a.b(d(), com.obric.common.oui.b.f8195d, d.f8222i);
        r12.setBackgroundColor(0);
        View r2 = r12.findViewById(f.Z);
        o.e(r2, "rootView.findViewById(R.id.iv_close)");
        this.f11240f = (AppCompatImageView) r2;
        View r3 = r12.findViewById(f.W0);
        o.e(r3, "rootView.findViewById(R.id.tv_title)");
        this.f11241g = (TextView) r3;
        View r4 = r12.findViewById(f.X);
        o.e(r4, "rootView.findViewById(R.id.iv_back)");
        this.f11242h = (ImageView) r4;
        View r5 = r12.findViewById(f.N);
        o.e(r5, "rootView.findViewById(R.id.divider)");
        ODivider r6 = (ODivider) r5;
        o.e(r12.findViewById(f.Q), "rootView.findViewById(R.id.grabber)");
        View r7 = r12.findViewById(f.d0);
        o.e(r7, "rootView.findViewById(R.id.main_view)");
        this.f11243i = r7;
        ViewGroup.LayoutParams r13 = r7.getLayoutParams();
        if (r13 == null) goto L16;
        r13.height = r1;
        r7.setLayoutParams(r13);
        if (r9 == null) goto L8;
        i(r9);
    L8:
        if (TextUtils.isEmpty(r10) == true) goto L11;
        o.c(r10);
        k(this, r10, null, null, 6, null);
    L11:
        if (ViewCompat.isAttachedToWindow(r12) == false) goto L13;
        Resources r14 = Resources.getSystem();
        o.e(r14, "Resources.getSystem()");
        int r15 = kotlin.o0.a.a(TypedValue.applyDimension(1, 44, r14.getDisplayMetrics()));
        j.d(h(this), r15, r15, new View[]{f(this), g(this)});
        return;
    L13:
        r12.addOnAttachStateChangeListener(new ViewOnAttachStateChangeListenerC0296a(r12, this));
        return;
    L16:
        throw new b0("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public static final /* synthetic */ ImageView f(a r0) {
        return r0.f11242h;
    }

    public static final /* synthetic */ AppCompatImageView g(a r0) {
        return r0.f11240f;
    }

    public static final /* synthetic */ View h(a r0) {
        return r0.f11244j;
    }

    public static /* synthetic */ void k(a r0, CharSequence r1, Drawable r2, Boolean r3, int r4, Object r5) {
        if (r5 != null) goto L12;
        if ((r4 & 2) == 0) goto L7;
        r2 = null;
    L7:
        if ((r4 & 4) == 0) goto L9;
        r3 = Boolean.FALSE;
    L9:
        r0.j(r1, r2, r3);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setTitle");
    }

    @Override // com.obric.oui.panel.header.b
    public View e() {
        return this.f11244j;
    }

    public final void i(View.OnClickListener r5) {
        AppCompatImageView r0 = this.f11240f;
        Resources r2 = Resources.getSystem();
        o.e(r2, "Resources.getSystem()");
        j.a(r0, kotlin.o0.a.a(TypedValue.applyDimension(1, 44, r2.getDisplayMetrics())));
        this.f11240f.setOnClickListener(r5);
    }

    public final void j(CharSequence r2, Drawable r3, Boolean r4) {
        o.f(r2, "charSequence");
        this.f11241g.setText(r2);
        if (r3 == null) goto L5;
        r3.setBounds(0, 0, 70, 70);
    L5:
        this.f11241g.setCompoundDrawables(r3, null, null, null);
        if (o.a(r4, Boolean.TRUE) == false) goto L9;
        this.f11241g.setTypeface(Typeface.defaultFromStyle(1));
        return;
    }
}
