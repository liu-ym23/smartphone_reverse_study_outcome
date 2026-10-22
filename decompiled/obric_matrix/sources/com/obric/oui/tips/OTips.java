package com.obric.oui.tips;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.common.util.j;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.h;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\u0007\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0007\u0010\u0006R%\u0010\u000e\u001a\n \t*\u0004\u0018\u00010\b0\b8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR(\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR(\u0010\u001f\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014R%\u0010$\u001a\n \t*\u0004\u0018\u00010 0 8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u000b\u001a\u0004\b\"\u0010#R%\u0010'\u001a\n \t*\u0004\u0018\u00010\b0\b8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u000b\u001a\u0004\b&\u0010\rR$\u0010.\u001a\u00020(2\u0006\u0010)\u001a\u00020(8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R(\u00105\u001a\u0004\u0018\u00010/2\b\u00100\u001a\u0004\u0018\u00010/8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b1\u00102\"\u0004\b3\u00104¨\u00066"}, d2 = {"Lcom/obric/oui/tips/OTips;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lkotlin/Function0;", "Lkotlin/f0;", "clickAction", "setRightIconOnClickListener", "(Lkotlin/n0/c/a;)V", "setLeftIconOnClickListener", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "h", "Lkotlin/h;", "getRightIcon", "()Landroid/widget/ImageView;", "rightIcon", "Landroid/graphics/drawable/Drawable;", "ic", "getLeftIc", "()Landroid/graphics/drawable/Drawable;", "setLeftIc", "(Landroid/graphics/drawable/Drawable;)V", "leftIc", "", "value", "getTextRolling", "()Z", "setTextRolling", "(Z)V", "textRolling", "getRightIc", "setRightIc", "rightIc", "Landroid/widget/TextView;", "g", "getTipsTv", "()Landroid/widget/TextView;", "tipsTv", "f", "getLeftIcon", "leftIcon", "", "num", "getTipsLine", "()I", "setTipsLine", "(I)V", "tipsLine", "", "txt", "getTipsText", "()Ljava/lang/String;", "setTipsText", "(Ljava/lang/String;)V", "tipsText", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public final class OTips extends ConstraintLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final h f11521f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final h f11522g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final h f11523h;

    static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.a f11524f;

        a(kotlin.n0.c.a r1) {
            this.f11524f = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.f11524f.invoke();
        }
    }

    static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.a f11525f;

        b(kotlin.n0.c.a r1) {
            this.f11525f = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.f11525f.invoke();
        }
    }

    private final Drawable getLeftIc() {
        ImageView r1 = getLeftIcon();
        o.e(r1, "leftIcon");
        return r1.getDrawable();
    }

    private final Drawable getRightIc() {
        ImageView r1 = getRightIcon();
        o.e(r1, "rightIcon");
        return r1.getDrawable();
    }

    private final void setLeftIc(Drawable r2) {
        getLeftIcon().setImageDrawable(r2);
        ImageView r3 = getLeftIcon();
        o.e(r3, "leftIcon");
        j.g(r3);
        invalidate();
    }

    private final void setRightIc(Drawable r2) {
        getRightIcon().setImageDrawable(r2);
        ImageView r3 = getRightIcon();
        o.e(r3, "rightIcon");
        j.g(r3);
        invalidate();
    }

    public final ImageView getLeftIcon() {
        return (ImageView) this.f11521f.getValue();
    }

    public final ImageView getRightIcon() {
        return (ImageView) this.f11523h.getValue();
    }

    public final boolean getTextRolling() {
        TextView r0 = getTipsTv();
        o.e(r0, "tipsTv");
        if (r0.isSelected() == true) goto L5;
    L7:
        return false;
    L5:
        if (getTipsLine() != 1) goto L7;
        return true;
    }

    public final int getTipsLine() {
        TextView r1 = getTipsTv();
        o.e(r1, "tipsTv");
        return r1.getMaxLines();
    }

    public final String getTipsText() {
        TextView r1 = getTipsTv();
        o.e(r1, "tipsTv");
        CharSequence r2 = r1.getText();
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.toString();
    }

    public final TextView getTipsTv() {
        return (TextView) this.f11522g.getValue();
    }

    public final void setLeftIconOnClickListener(kotlin.n0.c.a<f0> r2) {
        o.f(r2, "clickAction");
        ImageView r1 = getLeftIcon();
        if (r1 == null) goto L6;
        r1.setOnClickListener(new a(r2));
        return;
    }

    public final void setRightIconOnClickListener(kotlin.n0.c.a<f0> r2) {
        o.f(r2, "clickAction");
        ImageView r1 = getRightIcon();
        if (r1 == null) goto L6;
        r1.setOnClickListener(new b(r2));
        return;
    }

    public final void setTextRolling(boolean r4) {
        TextView r0 = getTipsTv();
        o.e(r0, "tipsTv");
        r0.setSelected(r4);
        if (r4 == false) goto L5;
        TextView r5 = getTipsTv();
        o.e(r5, "tipsTv");
        r5.setMovementMethod(null);
        String r6 = getTipsText();
        TextView r2 = getTipsTv();
        o.e(r2, "tipsTv");
        r2.setText(null);
        TextView r1 = getTipsTv();
        o.e(r1, "tipsTv");
        r1.setText(r6);
        setTipsLine(1);
        TextView r7 = getTipsTv();
        o.e(r7, "tipsTv");
        r7.setMarqueeRepeatLimit(-1);
        TextView r8 = getTipsTv();
        o.e(r8, "tipsTv");
        TextUtils.TruncateAt r3 = TextUtils.TruncateAt.MARQUEE;
    L6:
        r8.setEllipsize(r3);
        invalidate();
        return;
    L5:
        r8 = getTipsTv();
        o.e(r8, "tipsTv");
        r3 = TextUtils.TruncateAt.END;
        goto L6
    }

    public final void setTipsLine(int r3) {
        TextView r0 = getTipsTv();
        o.e(r0, "tipsTv");
        r0.setMaxLines(r3);
        TextView r1 = getTipsTv();
        o.e(r1, "tipsTv");
        boolean r2 = true;
        if (r3 == 1) goto L6;
        r2 = false;
    L6:
        r1.setSingleLine(r2);
        invalidate();
    }

    public final void setTipsText(String r3) {
        TextView r0 = getTipsTv();
        o.e(r0, "tipsTv");
        r0.setText(r3);
        invalidate();
    }
}
