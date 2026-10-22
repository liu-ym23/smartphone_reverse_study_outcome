package com.obric.oui.tips;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.apm.constant.PerfConsts;
import com.obric.common.oui.R;
import com.obric.oui.common.util.ViewExtensionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OTips.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0014\u0010:\u001a\u00020;2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020;0=J\u001a\u0010>\u001a\u00020;2\u0006\u0010?\u001a\u00020\u00072\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0018J\u0014\u0010A\u001a\u00020;2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020;0=J\u001a\u0010B\u001a\u00020;2\u0006\u0010?\u001a\u00020\u00072\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0018R(\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR#\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0019\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR#\u0010\u001c\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0016\u001a\u0004\b\u001d\u0010\u0014R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020#8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010*\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R(\u00100\u001a\u0004\u0018\u00010!2\b\u0010/\u001a\u0004\u0018\u00010!8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b1\u00102\"\u0004\b3\u00104R#\u00105\u001a\n \u0012*\u0004\u0018\u000106068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\u0016\u001a\u0004\b7\u00108¨\u0006C"}, d2 = {"Lcom/obric/oui/tips/OTips;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ic", "Landroid/graphics/drawable/Drawable;", "leftIc", "getLeftIc", "()Landroid/graphics/drawable/Drawable;", "setLeftIc", "(Landroid/graphics/drawable/Drawable;)V", "leftIcon", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getLeftIcon", "()Landroid/widget/ImageView;", "leftIcon$delegate", "Lkotlin/Lazy;", "leftIconTint", "Landroid/content/res/ColorStateList;", "rightIc", "getRightIc", "setRightIc", "rightIcon", "getRightIcon", "rightIcon$delegate", "rightIconTint", "spanText", "", "value", "", "textRolling", "getTextRolling", "()Z", "setTextRolling", "(Z)V", PerfConsts.PERF_DISK_FILE_NUM, "tipsLine", "getTipsLine", "()I", "setTipsLine", "(I)V", "txt", "tipsText", "getTipsText", "()Ljava/lang/String;", "setTipsText", "(Ljava/lang/String;)V", "tipsTv", "Landroid/widget/TextView;", "getTipsTv", "()Landroid/widget/TextView;", "tipsTv$delegate", "setLeftIconOnClickListener", "", "clickAction", "Lkotlin/Function0;", "setLeftIconRes", "res", "tintList", "setRightIconOnClickListener", "setRightIconRes", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OTips extends ConstraintLayout {
    private final Lazy leftIcon$delegate;
    private ColorStateList leftIconTint;
    private final Lazy rightIcon$delegate;
    private ColorStateList rightIconTint;
    private String spanText;
    private final Lazy tipsTv$delegate;

    public static /* synthetic */ void $r8$lambda$V134awnnd7xZxcmCKPAFAQ5Up4Y(Function0 r0, View r1) {
        m1419setLeftIconOnClickListener$lambda3(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$ZamPUp5DVk9OnEUuucYd9oZvnwo(Function0 r0, View r1) {
        m1420setRightIconOnClickListener$lambda2(r0, r1);
    }

    public OTips(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public OTips(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ OTips(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public OTips(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        this.leftIcon$delegate = LazyKt.lazy(new OTips$leftIcon$2(this));
        this.tipsTv$delegate = LazyKt.lazy(new OTips$tipsTv$2(this));
        this.rightIcon$delegate = LazyKt.lazy(new OTips$rightIcon$2(this));
        LayoutInflater.from(r4).inflate(R.layout.o_tips, this);
        if (r5 == null) goto L47;
        TypedArray r7 = r4.obtainStyledAttributes(r5, R.styleable.OTips);
        Intrinsics.checkNotNullExpressionValue(r7, "context.obtainStyledAttr…attrs, R.styleable.OTips)");
        Drawable r8 = r7.getDrawable(R.styleable.OTips_oui_leftIcon);
        if (r8 == null) goto L8;
        setLeftIc(r8);
    L8:
        Drawable r9 = r7.getDrawable(R.styleable.OTips_oui_RightIcon);
        if (r9 == null) goto L12;
        setRightIc(r9);
    L12:
        ColorStateList r10 = r7.getColorStateList(R.styleable.OTips_oui_leftIcon_tint);
        if (r10 == null) goto L22;
        this.leftIconTint = r10;
        ImageView r11 = getLeftIcon();
        if (r11 == null) goto L22;
        Drawable r12 = r11.getDrawable();
        if (r12 == null) goto L22;
        r12.setTintList(r10);
    L22:
        ColorStateList r13 = r7.getColorStateList(R.styleable.OTips_oui_rightIcon_tint);
        if (r13 == null) goto L32;
        this.rightIconTint = r13;
        ImageView r14 = getRightIcon();
        if (r14 == null) goto L32;
        Drawable r15 = r14.getDrawable();
        if (r15 == null) goto L32;
        r15.setTintList(r13);
    L32:
        Integer r16 = Integer.valueOf(r7.getColor(R.styleable.OTips_oui_tipsTextColor, -1));
        if (r16.intValue() == (-1)) goto L35;
        boolean r17 = true;
    L36:
        if (r17 == true) goto L39;
        r16 = null;
    L39:
        if (r16 == null) goto L45;
        int r18 = r16.intValue();
        TextView r19 = getTipsTv();
        if (r19 == null) goto L45;
        r19.setTextColor(r18);
    L45:
        setTipsText(r7.getString(R.styleable.OTips_oui_tipsText));
        setTipsLine(r7.getInteger(R.styleable.OTips_oui_tipsLine, 1));
        setTextRolling(r7.getBoolean(R.styleable.OTips_oui_textRolling, false));
        this.spanText = r7.getString(R.styleable.OTips_oui_spanText);
        r7.recycle();
        return;
    L35:
        r17 = false;
        goto L36
    }

    public final ImageView getLeftIcon() {
        return (ImageView) this.leftIcon$delegate.getValue();
    }

    private final Drawable getLeftIc() {
        return getLeftIcon().getDrawable();
    }

    private final void setLeftIc(Drawable r2) {
        getLeftIcon().setImageDrawable(r2);
        ImageView r3 = getLeftIcon();
        Intrinsics.checkNotNullExpressionValue(r3, "leftIcon");
        ViewExtensionsKt.makeVisible(r3);
        invalidate();
    }

    public final TextView getTipsTv() {
        return (TextView) this.tipsTv$delegate.getValue();
    }

    public final String getTipsText() {
        CharSequence r0 = getTipsTv().getText();
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.toString();
    }

    public final void setTipsText(String r2) {
        getTipsTv().setText(r2);
        invalidate();
    }

    public final int getTipsLine() {
        return getTipsTv().getMaxLines();
    }

    public final void setTipsLine(int r3) {
        getTipsTv().setMaxLines(r3);
        TextView r0 = getTipsTv();
        boolean r1 = true;
        if (r3 == 1) goto L6;
        r1 = false;
    L6:
        r0.setSingleLine(r1);
        invalidate();
    }

    public final ImageView getRightIcon() {
        return (ImageView) this.rightIcon$delegate.getValue();
    }

    private final Drawable getRightIc() {
        return getRightIcon().getDrawable();
    }

    private final void setRightIc(Drawable r2) {
        getRightIcon().setImageDrawable(r2);
        ImageView r3 = getRightIcon();
        Intrinsics.checkNotNullExpressionValue(r3, "rightIcon");
        ViewExtensionsKt.makeVisible(r3);
        invalidate();
    }

    public final boolean getTextRolling() {
        if (getTipsTv().isSelected() == true) goto L5;
    L7:
        return false;
    L5:
        if (getTipsLine() != 1) goto L7;
        return true;
    }

    public final void setTextRolling(boolean r3) {
        getTipsTv().setSelected(r3);
        if (r3 == false) goto L5;
        getTipsTv().setMovementMethod(null);
        String r4 = getTipsText();
        getTipsTv().setText(null);
        getTipsTv().setText(r4);
        setTipsLine(1);
        getTipsTv().setMarqueeRepeatLimit(-1);
        getTipsTv().setEllipsize(TextUtils.TruncateAt.MARQUEE);
    L6:
        invalidate();
        return;
    L5:
        getTipsTv().setEllipsize(TextUtils.TruncateAt.END);
        goto L6
    }

    public static /* synthetic */ void setRightIconRes$default(OTips r0, int r1, ColorStateList r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.setRightIconRes(r1, r2);
    }

    public final void setRightIconRes(int r2, ColorStateList r3) {
        ImageView r0 = getRightIcon();
        if (r0 == null) goto L19;
        r0.setImageResource(r2);
        if (r3 == null) goto L12;
        Drawable r1 = r0.getDrawable();
        if (r1 == null) goto L17;
        r1.setTintList(r3);
    L17:
        ViewExtensionsKt.makeVisible(r0);
        r0.invalidate();
        return;
    L12:
        if (this.rightIconTint == null) goto L17;
        Drawable r4 = r0.getDrawable();
        if (r4 == null) goto L17;
        r4.setTintList(this.rightIconTint);
        goto L17
    }

    public static /* synthetic */ void setLeftIconRes$default(OTips r0, int r1, ColorStateList r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.setLeftIconRes(r1, r2);
    }

    public final void setLeftIconRes(int r2, ColorStateList r3) {
        ImageView r0 = getLeftIcon();
        if (r0 == null) goto L19;
        r0.setImageResource(r2);
        if (r3 == null) goto L12;
        Drawable r1 = r0.getDrawable();
        if (r1 == null) goto L17;
        r1.setTintList(r3);
    L17:
        ViewExtensionsKt.makeVisible(r0);
        r0.invalidate();
        return;
    L12:
        if (this.leftIconTint == null) goto L17;
        Drawable r4 = r0.getDrawable();
        if (r4 == null) goto L17;
        r4.setTintList(this.leftIconTint);
        goto L17
    }

    /* JADX INFO: renamed from: setRightIconOnClickListener$lambda-2, reason: not valid java name */
    private static final void m1420setRightIconOnClickListener$lambda2(Function0 r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "$clickAction");
        r0.invoke();
    }

    public final void setRightIconOnClickListener(final Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "clickAction");
        ImageView r1 = getRightIcon();
        if (r1 == null) goto L7;
        r1.setOnClickListener(new OTips$$ExternalSyntheticLambda1(r2));
        return;
    }

    /* JADX INFO: renamed from: setLeftIconOnClickListener$lambda-3, reason: not valid java name */
    private static final void m1419setLeftIconOnClickListener$lambda3(Function0 r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "$clickAction");
        r0.invoke();
    }

    public final void setLeftIconOnClickListener(final Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "clickAction");
        ImageView r1 = getLeftIcon();
        if (r1 == null) goto L7;
        r1.setOnClickListener(new OTips$$ExternalSyntheticLambda0(r2));
        return;
    }
}
