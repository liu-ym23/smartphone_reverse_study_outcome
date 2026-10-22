package com.obric.oui.tab;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.obric.common.oui.f;
import com.obric.common.oui.g;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010,\u001a\u00020+\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-¢\u0006\u0004\b/\u00100J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R.\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR4\u0010\u0019\u001a\u0004\u0018\u00010\u00102\b\u0010\b\u001a\u0004\u0018\u00010\u00108\u0006@FX\u0087\u000e¢\u0006\u0018\n\u0004\b\u0011\u0010\u0012\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001c\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0019\u0010\"\u001a\u00020\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010(\u001a\u00020#8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010\u001b¨\u00061"}, d2 = {"Lcom/obric/oui/tab/c;", "Landroid/widget/RelativeLayout;", "", "selected", "Lkotlin/f0;", "setSelected", "(Z)V", "Landroid/content/res/ColorStateList;", "value", "j", "Landroid/content/res/ColorStateList;", "getTextColor", "()Landroid/content/res/ColorStateList;", "setTextColor", "(Landroid/content/res/ColorStateList;)V", "textColor", "", "k", "Ljava/lang/Integer;", "getSelectedBgColor", "()Ljava/lang/Integer;", "setSelectedBgColor", "(Ljava/lang/Integer;)V", "getSelectedBgColor$annotations", "()V", "selectedBgColor", "g", "I", "defaultSelectTextColor", "Landroid/widget/ImageView;", "h", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "icon", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "title", "f", "defaultTextColor", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public final class c extends RelativeLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f11505f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f11506g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ImageView f11507h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final TextView f11508i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ColorStateList f11509j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Integer f11510k;

    /* JADX WARN: Multi-variable type inference failed */
    public c(Context r3) {
        this(r3, null, 2, 0 == true ? 1 : 0);
    }

    public c(Context r3, AttributeSet r4) {
        o.f(r3, "context");
        super(r3, r4);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setClickable(false);
        setFocusable(false);
        LayoutInflater.from(r3).inflate(g.v, this, true);
        View r5 = findViewById(f.V);
        o.e(r5, "findViewById(R.id.icon_container)");
        FrameLayout r6 = (FrameLayout) r5;
        View r7 = findViewById(f.T);
        o.e(r7, "findViewById(R.id.icon)");
        this.f11507h = (ImageView) r7;
        View r8 = findViewById(f.S0);
        o.e(r8, "findViewById(R.id.title)");
        this.f11508i = (TextView) r8;
        this.f11505f = ContextCompat.getColor(getContext(), com.obric.common.oui.c.P);
        this.f11506g = ContextCompat.getColor(getContext(), com.obric.common.oui.c.y);
    }

    public /* synthetic */ c(Context r1, AttributeSet r2, int r3, kotlin.n0.d.g r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public static final /* synthetic */ int[] a() {
        return RelativeLayout.SELECTED_STATE_SET;
    }

    public static /* synthetic */ void getSelectedBgColor$annotations() {
    }

    public final ImageView getIcon() {
        return this.f11507h;
    }

    public final Integer getSelectedBgColor() {
        return this.f11510k;
    }

    public final ColorStateList getTextColor() {
        return this.f11509j;
    }

    public final TextView getTitle() {
        return this.f11508i;
    }

    @Override // android.view.View
    public void setSelected(boolean r3) {
        super.setSelected(r3);
        if (r3 == false) goto L11;
        ColorStateList r4 = this.f11509j;
        if (r4 == null) goto L7;
        int r5 = r4.getColorForState(a(), this.f11506g);
    L8:
        this.f11508i.setTextColor(r5);
        if (this.f11507h.getDrawable() == null) goto L19;
    L17:
        ImageView r2 = this.f11507h;
        Drawable r0 = DrawableCompat.wrap(r2.getDrawable());
        r0.setTint(r5);
        f0 r6 = f0.f18324a;
        r2.setImageDrawable(r0);
        return;
    L19:
        return;
    L7:
        r5 = this.f11506g;
        goto L8
    L11:
        ColorStateList r7 = this.f11509j;
        if (r7 == null) goto L14;
        r5 = r7.getDefaultColor();
    L15:
        this.f11508i.setTextColor(r5);
        if (this.f11507h.getDrawable() != null) goto L17;
        return;
    L14:
        r5 = this.f11505f;
        goto L15
    }

    public final void setSelectedBgColor(Integer r3) {
        this.f11510k = r3;
        if (r3 != null) goto L5;
        return;
    L5:
        GradientDrawable r0 = new GradientDrawable();
        r0.setShape(0);
        r0.setCornerRadius(getResources().getDimension(com.obric.common.oui.d.f8224k));
        r0.setColor(r3.intValue());
        f0 r2 = f0.f18324a;
    }

    public final void setTextColor(ColorStateList r3) {
        this.f11509j = r3;
        if (r3 != null) goto L5;
        return;
    L5:
        this.f11508i.setTextColor(r3.getDefaultColor());
        if (this.f11507h.getDrawable() == null) goto L9;
        ImageView r2 = this.f11507h;
        Drawable r0 = DrawableCompat.wrap(r2.getDrawable());
        r0.setTint(r3.getDefaultColor());
        f0 r4 = f0.f18324a;
        r2.setImageDrawable(r0);
        return;
    }
}
