package com.obric.oui.tips;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.common.util.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OTips extends ConstraintLayout {
    private final Drawable getLeftIc() {
        ImageView r1 = getLeftIcon();
        Intrinsics.e(r1, "leftIcon");
        return r1.getDrawable();
    }

    private final Drawable getRightIc() {
        ImageView r1 = getRightIcon();
        Intrinsics.e(r1, "rightIcon");
        return r1.getDrawable();
    }

    private final void setLeftIc(Drawable r2) {
        getLeftIcon().setImageDrawable(r2);
        ImageView r3 = getLeftIcon();
        Intrinsics.e(r3, "leftIcon");
        ViewExtensionsKt.e(r3);
        invalidate();
    }

    private final void setRightIc(Drawable r2) {
        getRightIcon().setImageDrawable(r2);
        ImageView r3 = getRightIcon();
        Intrinsics.e(r3, "rightIcon");
        ViewExtensionsKt.e(r3);
        invalidate();
    }

    public final ImageView getLeftIcon() {
        throw null;
    }

    public final ImageView getRightIcon() {
        throw null;
    }

    public final boolean getTextRolling() {
        TextView r0 = getTipsTv();
        Intrinsics.e(r0, "tipsTv");
        if (r0.isSelected() == true) goto L5;
    L7:
        return false;
    L5:
        if (getTipsLine() != 1) goto L7;
        return true;
    }

    public final int getTipsLine() {
        TextView r1 = getTipsTv();
        Intrinsics.e(r1, "tipsTv");
        return r1.getMaxLines();
    }

    @Nullable
    public final String getTipsText() {
        TextView r1 = getTipsTv();
        Intrinsics.e(r1, "tipsTv");
        CharSequence r2 = r1.getText();
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.toString();
    }

    public final TextView getTipsTv() {
        throw null;
    }

    public final void setLeftIconOnClickListener(@NotNull final Function0<Unit> r2) {
        Intrinsics.f(r2, "clickAction");
        ImageView r1 = getLeftIcon();
        if (r1 == null) goto L6;
        r1.setOnClickListener(new AnonymousClass1(r2));
        return;
    }

    public final void setRightIconOnClickListener(@NotNull final Function0<Unit> r2) {
        Intrinsics.f(r2, "clickAction");
        ImageView r1 = getRightIcon();
        if (r1 == null) goto L6;
        r1.setOnClickListener(new ViewOnClickListenerC00401(r2));
        return;
    }

    public final void setTextRolling(boolean r4) {
        TextView r0 = getTipsTv();
        Intrinsics.e(r0, "tipsTv");
        r0.setSelected(r4);
        if (r4 == false) goto L5;
        TextView r5 = getTipsTv();
        Intrinsics.e(r5, "tipsTv");
        r5.setMovementMethod(null);
        String r6 = getTipsText();
        TextView r2 = getTipsTv();
        Intrinsics.e(r2, "tipsTv");
        r2.setText(null);
        TextView r1 = getTipsTv();
        Intrinsics.e(r1, "tipsTv");
        r1.setText(r6);
        setTipsLine(1);
        TextView r7 = getTipsTv();
        Intrinsics.e(r7, "tipsTv");
        r7.setMarqueeRepeatLimit(-1);
        TextView r8 = getTipsTv();
        Intrinsics.e(r8, "tipsTv");
        r8.setEllipsize(TextUtils.TruncateAt.MARQUEE);
    L6:
        invalidate();
        return;
    L5:
        TextView r9 = getTipsTv();
        Intrinsics.e(r9, "tipsTv");
        r9.setEllipsize(TextUtils.TruncateAt.END);
        goto L6
    }

    public final void setTipsLine(int r3) {
        TextView r0 = getTipsTv();
        Intrinsics.e(r0, "tipsTv");
        r0.setMaxLines(r3);
        TextView r1 = getTipsTv();
        Intrinsics.e(r1, "tipsTv");
        boolean r2 = true;
        if (r3 == 1) goto L6;
        r2 = false;
    L6:
        r1.setSingleLine(r2);
        invalidate();
    }

    public final void setTipsText(@Nullable String r3) {
        TextView r0 = getTipsTv();
        Intrinsics.e(r0, "tipsTv");
        r0.setText(r3);
        invalidate();
    }
}
