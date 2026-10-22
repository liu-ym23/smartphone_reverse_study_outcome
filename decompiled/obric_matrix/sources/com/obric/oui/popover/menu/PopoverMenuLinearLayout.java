package com.obric.oui.popover.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.c;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.p;
import kotlin.n0.d.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u00011B'\b\u0007\u0012\u0006\u0010+\u001a\u00020*\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010,\u0012\b\b\u0002\u0010.\u001a\u00020\u0007¢\u0006\u0004\b/\u00100J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R*\u0010!\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010\u0006R6\u0010)\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u00062"}, d2 = {"Lcom/obric/oui/popover/menu/PopoverMenuLinearLayout;", "Landroid/widget/LinearLayout;", "", "pressed", "Lkotlin/f0;", "setPressed", "(Z)V", "", "i", "I", "pressedColor", "Lcom/obric/oui/popover/menu/PopoverMenuLinearLayout$a;", "g", "Lcom/obric/oui/popover/menu/PopoverMenuLinearLayout$a;", "getIndexPos", "()Lcom/obric/oui/popover/menu/PopoverMenuLinearLayout$a;", "setIndexPos", "(Lcom/obric/oui/popover/menu/PopoverMenuLinearLayout$a;)V", "indexPos", "", "f", "F", "getPressedCornerRadius", "()F", "setPressedCornerRadius", "(F)V", "pressedCornerRadius", "value", "j", "Z", "getForceDark", "()Z", "setForceDark", "forceDark", "Lkotlin/Function2;", "h", "Lkotlin/n0/c/p;", "getNotifyPressedCallback", "()Lkotlin/n0/c/p;", "setNotifyPressedCallback", "(Lkotlin/n0/c/p;)V", "notifyPressedCallback", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public class PopoverMenuLinearLayout extends LinearLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f11289f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private a f11290g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private p<? super Boolean, ? super Integer, f0> f11291h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f11292i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f11293j;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f11294f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final /* synthetic */ a[] f11295g = null;

        static {
            a r1 = new a("OTHER", 2);
            f11294f = r1;
            f11295g = new a[]{new a("FIRST", 0), new a("LAST", 1), r1, new a("ONLY_ONE", 3)};
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        public static a valueOf(String r1) {
            return (a) Enum.valueOf(a.class, r1);
        }

        public static a[] values() {
            return (a[]) f11295g.clone();
        }
    }

    public PopoverMenuLinearLayout(Context r7, AttributeSet r8) {
        this(r7, r8, 0, 4, null);
    }

    public PopoverMenuLinearLayout(Context r2, AttributeSet r3, int r4) {
        o.f(r2, "context");
        super(r2, r3, r4);
        Resources r5 = Resources.getSystem();
        o.e(r5, "Resources.getSystem()");
        this.f11289f = TypedValue.applyDimension(1, 12, r5.getDisplayMetrics());
        this.f11290g = a.f11294f;
        this.f11292i = ContextCompat.getColor(r2, c.E);
    }

    public /* synthetic */ PopoverMenuLinearLayout(Context r1, AttributeSet r2, int r3, int r4, g r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public final boolean getForceDark() {
        return this.f11293j;
    }

    public final a getIndexPos() {
        return this.f11290g;
    }

    public final p<Boolean, Integer, f0> getNotifyPressedCallback() {
        return this.f11291h;
    }

    public final float getPressedCornerRadius() {
        return this.f11289f;
    }

    public final void setForceDark(boolean r3) {
        if (r3 == false) goto L4;
        int r0 = Color.parseColor("#FF45474F");
    L5:
        this.f11292i = r0;
        this.f11293j = r3;
        return;
    L4:
        r0 = ContextCompat.getColor(getContext(), c.E);
        goto L5
    }

    public final void setIndexPos(a r2) {
        o.f(r2, "<set-?>");
        this.f11290g = r2;
    }

    public final void setNotifyPressedCallback(p<? super Boolean, ? super Integer, f0> r1) {
        this.f11291h = r1;
    }

    @Override // android.view.View
    public void setPressed(boolean r4) {
        super.setPressed(r4);
        p<? super Boolean, ? super Integer, f0> r0 = this.f11291h;
        if (r0 == null) goto L6;
        f0 r1 = r0.invoke(Boolean.valueOf(r4), Integer.valueOf(this.f11292i));
    L6:
        if (r4 == false) goto L8;
        GradientDrawable r5 = new GradientDrawable();
        r5.setColor(this.f11292i);
        float r2 = this.f11289f;
        r5.setCornerRadii(new float[]{r2, r2, r2, r2, r2, r2, r2, r2});
        f0 r3 = f0.f18324a;
        setBackground(r5);
        return;
    L8:
        setBackgroundColor(0);
    }

    public final void setPressedCornerRadius(float r1) {
        this.f11289f = r1;
    }
}
