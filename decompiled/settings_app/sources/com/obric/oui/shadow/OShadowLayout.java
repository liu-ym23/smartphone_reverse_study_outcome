package com.obric.oui.shadow;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.obric.common.oui.R;
import com.obric.oui.common.style.Shadow;
import com.obric.oui.material.MaterialConfigFormatNames;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OShadowLayout.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ(\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nH\u0003J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0015J\b\u0010\u0018\u001a\u00020\u000fH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/oui/shadow/OShadowLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "firstShadow", "Lcom/obric/oui/common/style/Shadow;", "secondShadow", "shadowCornerRadius", "", "drawShadow", "", "canvas", "Landroid/graphics/Canvas;", "path", "Landroid/graphics/Path;", "regionRect", "Landroid/graphics/RectF;", MaterialConfigFormatNames.SHADOW, "onDraw", "updatePadding", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OShadowLayout extends FrameLayout {
    public static final Companion Companion = null;
    private static final String TAG = "ShadowLayout";
    private Shadow firstShadow;
    private Shadow secondShadow;
    private float shadowCornerRadius;

    /* JADX INFO: compiled from: OShadowLayout.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/shadow/OShadowLayout$Companion;", "", "()V", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OShadowLayout(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public OShadowLayout(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ OShadowLayout(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public OShadowLayout(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.firstShadow = Shadow.NONE.copy();
        this.secondShadow = Shadow.NONE.copy();
        TypedArray r13 = r10.obtainStyledAttributes(r11, R.styleable.OShadowLayout, r12, 0);
        Intrinsics.checkNotNullExpressionValue(r13, "context.obtainStyledAttr…wLayout, defStyleAttr, 0)");
        ShadowConfigCore[] r14 = ShadowTokenCore.parse(r13.getString(R.styleable.OShadowLayout_oui_shadow));
        float r15 = r10.getResources().getDisplayMetrics().density;
        if (r14 != null) goto L5;
        this.firstShadow.updateFromConfig(ShadowConfig.Companion.fromStyleRes(r13, R.styleable.OShadowLayout_oui_firstShadowColor, R.styleable.OShadowLayout_oui_firstShadowRadius, R.styleable.OShadowLayout_oui_firstOffsetX, R.styleable.OShadowLayout_oui_firstOffsetY, R.styleable.OShadowLayout_oui_firstShadowSpread));
        this.secondShadow.updateFromConfig(ShadowConfig.Companion.fromStyleRes(r13, R.styleable.OShadowLayout_oui_secondShadowColor, R.styleable.OShadowLayout_oui_secondShadowRadius, R.styleable.OShadowLayout_oui_secondOffsetX, R.styleable.OShadowLayout_oui_secondOffsetY, R.styleable.OShadowLayout_oui_secondShadowSpread));
    L15:
        this.shadowCornerRadius = r13.getDimension(R.styleable.OShadowLayout_oui_shadowCornerRadius, 0.0f);
        r13.recycle();
        setWillNotDraw(false);
        updatePadding();
        return;
    L5:
        if (r14.length != 0) goto L7;
        boolean r0 = true;
    L9:
        if ((!r0) == false) goto L12;
        Shadow r1 = this.firstShadow;
        ShadowConfigCore r3 = r14[0];
        Intrinsics.checkNotNullExpressionValue(r3, "shadowToken[0]");
        r1.updateFromConfig(r3, r15);
    L12:
        if (r14.length <= 1) goto L15;
        Shadow r2 = this.secondShadow;
        ShadowConfigCore r16 = r14[1];
        Intrinsics.checkNotNullExpressionValue(r16, "shadowToken[1]");
        r2.updateFromConfig(r16, r15);
        goto L15
    L7:
        r0 = false;
        goto L9
    }

    private final void updatePadding() {
        Math.max(Math.abs(this.firstShadow.getOffsetX()) + Math.abs(this.firstShadow.getRadius()), Math.abs(this.secondShadow.getOffsetX()) + Math.abs(this.secondShadow.getRadius()));
        Math.max(Math.abs(this.firstShadow.getOffsetY()) + Math.abs(this.firstShadow.getRadius()), Math.abs(this.secondShadow.getOffsetY()) + Math.abs(this.secondShadow.getRadius()));
    }

    @Override // android.view.View
    protected void onDraw(Canvas r12) {
        Intrinsics.checkNotNullParameter(r12, "canvas");
        super.onDraw(r12);
        Path r0 = new Path();
        int r1 = getChildCount();
        int r2 = Integer.MAX_VALUE;
        int r5 = Integer.MIN_VALUE;
        int r6 = 0;
        int r3 = Integer.MAX_VALUE;
        int r4 = Integer.MIN_VALUE;
    L3:
        if (r6 >= r1) goto L9;
        int r7 = r6 + 1;
        View r8 = getChildAt(r6);
        ViewGroup.LayoutParams r9 = r8.getLayoutParams();
        if (r9 == null) goto L8;
        ViewGroup.MarginLayoutParams r10 = (ViewGroup.MarginLayoutParams) r9;
        r2 = Math.min(r2, r8.getLeft() - r10.leftMargin);
        r3 = Math.min(r3, r8.getTop() - r10.topMargin);
        r4 = Math.max(r4, r8.getRight() + r10.rightMargin);
        r5 = Math.max(r5, r8.getBottom() + r10.bottomMargin);
        r6 = r7;
        goto L3
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L9:
        RectF r11 = new RectF(r2, r3, r4, r5);
        float r13 = this.shadowCornerRadius;
        r0.addRoundRect(r11, r13, r13, Path.Direction.CW);
        RectF r14 = new RectF();
        r0.computeBounds(r14, true);
        drawShadow(r12, r0, r14, this.firstShadow);
        drawShadow(r12, r0, r14, this.secondShadow);
    }

    private final void drawShadow(Canvas r4, Path r5, RectF r6, Shadow r7) {
        int r0 = r4.save();
        RectF r1 = new RectF(r6);
        r1.offset(r7.getOffsetX(), r7.getOffsetY());
        r1.inset(-r7.getSpread(), -r7.getSpread());
        r4.clipOutPath(r5);
        float r3 = this.shadowCornerRadius;
        r4.drawRoundRect(r1, r3, r3, r7.getPaint());
        r4.restoreToCount(r0);
    }
}
