package com.obric.oui.avatar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Space;
import androidx.annotation.ColorInt;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.c;
import com.obric.common.oui.f;
import com.obric.common.oui.g;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.b0;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002<=B\u001d\b\u0007\u0012\u0006\u00107\u001a\u000206\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u000108¢\u0006\u0004\b:\u0010;J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J/\u0010\r\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0006J\u0015\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00042\b\b\u0001\u0010\u0013\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\u0012J\u0015\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0017\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u0017\u0010\u001bJ\u0015\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\b¢\u0006\u0004\b\u0017\u0010\u0012J\u0015\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\r\u0010\"\u001a\u00020!¢\u0006\u0004\b\"\u0010#J\r\u0010%\u001a\u00020$¢\u0006\u0004\b%\u0010&J\r\u0010'\u001a\u00020!¢\u0006\u0004\b'\u0010#R\u0016\u0010)\u001a\u00020$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00102\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u00020!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u00103R\u0016\u00105\u001a\u00020!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u00103¨\u0006>"}, d2 = {"Lcom/obric/oui/avatar/OAvatar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/obric/oui/avatar/OAvatar$a;", "size", "Lkotlin/f0;", "h", "(Lcom/obric/oui/avatar/OAvatar$a;)V", "g", "", "spaceHorizontalMargin", "spaceVerticalMargin", "borderWidth", "contentSize", "f", "(IIII)V", "setAvatarSize", "inset", "setAvatarInset", "(I)V", TypedValues.Custom.S_COLOR, "setIconBorderColor", "Landroid/graphics/Bitmap;", "bitmap", "setAvatar", "(Landroid/graphics/Bitmap;)V", "Landroid/graphics/drawable/Drawable;", "drawable", "(Landroid/graphics/drawable/Drawable;)V", "resId", "Lcom/obric/oui/avatar/OAvatar$b;", "iconType", "setIconType", "(Lcom/obric/oui/avatar/OAvatar$b;)V", "Lcom/obric/oui/avatar/OCircleImageView;", "getContentImageView", "()Lcom/obric/oui/avatar/OCircleImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "getBackgroundImageView", "()Landroidx/appcompat/widget/AppCompatImageView;", "getLogoImageView", "Landroidx/appcompat/widget/AppCompatImageView;", "ivBg", "Landroid/widget/Space;", "i", "Landroid/widget/Space;", "spacer", "j", "Lcom/obric/oui/avatar/OAvatar$b;", "k", "I", "iconBorderColor", "Lcom/obric/oui/avatar/OCircleImageView;", "ivAvatar", "ivIcon", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "b", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public final class OAvatar extends ConstraintLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final OCircleImageView f10739f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final OCircleImageView f10740g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AppCompatImageView f10741h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Space f10742i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private b f10743j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f10744k;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f10745g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f10746h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final a f10747i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final a f10748j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final a f10749k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final a f10750l = null;
        public static final a m = null;
        public static final a n = null;
        public static final a o = null;
        private static final /* synthetic */ a[] p = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f10751f;

        static {
            a r1 = new a("DP_16", 0, 16);
            f10745g = r1;
            a r2 = new a("DP_20", 1, 20);
            f10746h = r2;
            a r3 = new a("DP_24", 2, 24);
            f10747i = r3;
            a r4 = new a("DP_32", 3, 32);
            f10748j = r4;
            a r5 = new a("DP_40", 4, 40);
            f10749k = r5;
            a r6 = new a("DP_48", 5, 48);
            f10750l = r6;
            a r7 = new a("DP_56", 6, 56);
            m = r7;
            a r8 = new a("DP_64", 7, 64);
            n = r8;
            a r9 = new a("DP_72", 8, 72);
            o = r9;
            p = new a[]{r1, r2, r3, r4, r5, r6, r7, r8, r9};
        }

        private a(String r1, int r2, int r3) {
            super(r1, r2);
            this.f10751f = r3;
        }

        public static a valueOf(String r1) {
            return (a) Enum.valueOf(a.class, r1);
        }

        public static a[] values() {
            return (a[]) p.clone();
        }

        public final int a() {
            return this.f10751f;
        }
    }

    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f10752f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final b f10753g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final /* synthetic */ b[] f10754h = null;

        static {
            b r1 = new b("ONLINE", 0);
            f10752f = r1;
            b r2 = new b("LOGO", 1);
            f10753g = r2;
            f10754h = new b[]{r1, r2};
        }

        private b(String r1, int r2) {
            super(r1, r2);
        }

        public static b valueOf(String r1) {
            return (b) Enum.valueOf(b.class, r1);
        }

        public static b[] values() {
            return (b[]) f10754h.clone();
        }
    }

    public OAvatar(Context r4, AttributeSet r5) {
        o.f(r4, "context");
        super(r4, r5);
        a r6 = a.f10747i;
        this.f10743j = b.f10753g;
        this.f10744k = -1;
        ViewGroup.inflate(r4, g.y, this);
        View r7 = findViewById(f.W);
        o.e(r7, "findViewById(R.id.iv_avatar)");
        OCircleImageView r8 = (OCircleImageView) r7;
        this.f10739f = r8;
        View r0 = findViewById(f.a0);
        o.e(r0, "findViewById(R.id.iv_icon)");
        this.f10740g = (OCircleImageView) r0;
        View r1 = findViewById(f.Y);
        o.e(r1, "findViewById(R.id.iv_bg)");
        this.f10741h = (AppCompatImageView) r1;
        View r2 = findViewById(f.M0);
        o.e(r2, "findViewById(R.id.spacer)");
        this.f10742i = (Space) r2;
        setClipChildren(false);
        Resources r3 = Resources.getSystem();
        o.e(r3, "Resources.getSystem()");
        r8.setBorderWidth(kotlin.o0.a.a(TypedValue.applyDimension(1, 1, r3.getDisplayMetrics())));
        r8.setBorderColor(ContextCompat.getColor(r4, c.m));
    }

    private final void f(int r4, int r5, int r6, int r7) {
        Space r0 = this.f10742i;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        Objects.requireNonNull(r1, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r2 = (ConstraintLayout.LayoutParams) r1;
        ((ViewGroup.MarginLayoutParams) r2).rightMargin = r4;
        ((ViewGroup.MarginLayoutParams) r2).bottomMargin = r5;
        r0.setLayoutParams(r2);
        setAvatarInset(1);
        this.f10740g.setContentPadding(0);
        this.f10740g.setBorderWidth(r6);
        this.f10740g.setBorderColor(this.f10744k);
        OCircleImageView r3 = this.f10740g;
        ViewGroup.LayoutParams r8 = r3.getLayoutParams();
        Objects.requireNonNull(r8, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r9 = (ConstraintLayout.LayoutParams) r8;
        int r10 = r7 + (r6 * 2);
        ((ViewGroup.MarginLayoutParams) r9).width = r10;
        ((ViewGroup.MarginLayoutParams) r9).height = r10;
        r3.setLayoutParams(r9);
    }

    private final void g(a r12) {
        float r0 = 20.0f;
        float r3 = 1.0f;
        float r6 = 0.0f;
        switch(com.obric.oui.avatar.a.f10766b[r12.ordinal()]) {
            case 1: goto L11;
            case 2: goto L9;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L6;
            case 6: goto L5;
            case 7: goto L5;
            default: goto L4;
        };
    L4:
        float r13 = 0.0f;
        r0 = 0.0f;
        r3 = 0.0f;
    L13:
        Resources r1 = Resources.getSystem();
        o.e(r1, "Resources.getSystem()");
        int r2 = kotlin.o0.a.a(TypedValue.applyDimension(1, r6, r1.getDisplayMetrics()));
        Resources r5 = Resources.getSystem();
        o.e(r5, "Resources.getSystem()");
        int r14 = kotlin.o0.a.a(TypedValue.applyDimension(1, r13, r5.getDisplayMetrics()));
        Resources r7 = Resources.getSystem();
        o.e(r7, "Resources.getSystem()");
        int r4 = kotlin.o0.a.a(TypedValue.applyDimension(1, r3, r7.getDisplayMetrics()));
        Resources r8 = Resources.getSystem();
        o.e(r8, "Resources.getSystem()");
        f(r2, r14, r4, kotlin.o0.a.a(TypedValue.applyDimension(1, r0, r8.getDisplayMetrics())));
        return;
    L5:
        float r15 = (2 * 2.0f) + 20.0f;
        float r9 = r15 - 2.0f;
        float r16 = r15 - 4.0f;
    L7:
        r3 = 2.0f;
    L12:
        float r10 = r9;
        r6 = r16;
        r13 = r10;
        goto L13
    L6:
        float r17 = (2 * 2.0f) + 16.0f;
        r9 = r17 - 2.0f;
        r16 = r17 - 4.0f;
        r0 = 16.0f;
        goto L7
    L8:
        float r18 = (2 * 1.5f) + 16.0f;
        r9 = r18 - 1.5f;
        r16 = r18 - 3.5f;
        r0 = 16.0f;
    L10:
        r3 = 1.5f;
        goto L12
    L9:
        float r19 = (2 * 1.5f) + 12.0f;
        r9 = r19 - 1.5f;
        r16 = r19 - 3.5f;
        r0 = 12.0f;
        goto L10
    L11:
        r0 = 10.0f;
        float r110 = (2 * 1.0f) + 10.0f;
        r9 = r110 - 1.0f;
        r16 = r110 - 3.0f;
        goto L12
    }

    private final void h(a r11) {
        float r0 = 12.0f;
        float r3 = 1.5f;
        float r5 = 0.0f;
        switch(com.obric.oui.avatar.a.f10765a[r11.ordinal()]) {
            case 1: goto L12;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L7;
            case 5: goto L7;
            case 6: goto L6;
            case 7: goto L5;
            default: goto L4;
        };
    L4:
        r0 = 0.0f;
        r3 = 0.0f;
    L13:
        Resources r12 = Resources.getSystem();
        o.e(r12, "Resources.getSystem()");
        int r13 = kotlin.o0.a.a(TypedValue.applyDimension(1, r5, r12.getDisplayMetrics()));
        Resources r2 = Resources.getSystem();
        o.e(r2, "Resources.getSystem()");
        int r4 = kotlin.o0.a.a(TypedValue.applyDimension(1, r5, r2.getDisplayMetrics()));
        Resources r6 = Resources.getSystem();
        o.e(r6, "Resources.getSystem()");
        int r7 = kotlin.o0.a.a(TypedValue.applyDimension(1, r3, r6.getDisplayMetrics()));
        Resources r8 = Resources.getSystem();
        o.e(r8, "Resources.getSystem()");
        f(r13, r4, r7, kotlin.o0.a.a(TypedValue.applyDimension(1, r0, r8.getDisplayMetrics())));
        return;
    L5:
        r5 = ((2 * 2.0f) + 12.0f) + 2.0f;
    L8:
        r3 = 2.0f;
        goto L13
    L6:
        r5 = ((2 * 2.0f) + 12.0f) + 1.0f;
        goto L8
    L7:
        r5 = ((2 * 2.0f) + 10.0f) + 0.5f;
        r0 = 10.0f;
        goto L8
    L9:
        r5 = ((2 * 1.5f) + 8.0f) + 0.5f;
    L11:
        r0 = 8.0f;
        goto L13
    L10:
        r5 = ((2 * 1.5f) + 8.0f) - 0.5f;
        goto L11
    L12:
        r0 = 6.0f;
        r5 = ((2 * 1.0f) + 6.0f) - 1;
        r3 = 1.0f;
        goto L13
    }

    public final AppCompatImageView getBackgroundImageView() {
        return this.f10741h;
    }

    public final OCircleImageView getContentImageView() {
        return this.f10739f;
    }

    public final OCircleImageView getLogoImageView() {
        return this.f10740g;
    }

    public final void setAvatar(int r1) {
        this.f10739f.setImageResource(r1);
    }

    public final void setAvatar(Bitmap r2) {
        o.f(r2, "bitmap");
        this.f10739f.setImageBitmap(r2);
    }

    public final void setAvatar(Drawable r1) {
        this.f10739f.setImageDrawable(r1);
    }

    public final void setAvatarInset(int r3) {
        OCircleImageView r2 = this.f10739f;
        ViewGroup.LayoutParams r0 = r2.getLayoutParams();
        Objects.requireNonNull(r0, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r1 = (ConstraintLayout.LayoutParams) r0;
        r1.setMargins(r3, r3, r3, r3);
        r2.setLayoutParams(r1);
    }

    public final void setAvatarSize(a r6) {
        o.f(r6, "size");
        ViewGroup.LayoutParams r0 = getLayoutParams();
        if (r0 == null) goto L16;
        float r1 = r6.a();
        Resources r2 = Resources.getSystem();
        o.e(r2, "Resources.getSystem()");
        r0.width = kotlin.o0.a.a(TypedValue.applyDimension(1, r1, r2.getDisplayMetrics()));
        float r3 = r6.a();
        Resources r4 = Resources.getSystem();
        o.e(r4, "Resources.getSystem()");
        r0.height = kotlin.o0.a.a(TypedValue.applyDimension(1, r3, r4.getDisplayMetrics()));
        setLayoutParams(r0);
        if (this.f10740g.isShown() == true) goto L7;
        return;
    L7:
        if (this.f10740g.getDrawable() == null) goto L18;
        b r5 = this.f10743j;
        if (r5 != b.f10752f) goto L12;
        h(r6);
        return;
    L12:
        if (r5 != b.f10753g) goto L20;
        g(r6);
        return;
    L20:
        return;
    L18:
        return;
    L16:
        throw new b0("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public final void setIconBorderColor(@ColorInt int r1) {
        this.f10744k = r1;
    }

    public final void setIconType(b r2) {
        o.f(r2, "iconType");
        this.f10743j = r2;
    }
}
