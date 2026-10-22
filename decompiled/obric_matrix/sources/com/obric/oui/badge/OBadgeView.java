package com.obric.oui.badge;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.common.oui.k;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.n0.d.g;
import kotlin.n0.d.o;
import kotlin.o0.a;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010&\u001a\u00020%\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010'\u001a\u00020\u0012¢\u0006\u0004\b(\u0010)J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J!\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0015¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J7\u0010 \u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u0012H\u0014¢\u0006\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006*"}, d2 = {"Lcom/obric/oui/badge/OBadgeView;", "Lcom/obric/oui/text/OTextView;", "Landroid/util/AttributeSet;", "attrs", "Lkotlin/f0;", "g", "(Landroid/util/AttributeSet;)V", "h", "", "inText", "Landroid/widget/TextView$BufferType;", WsConstants.KEY_CONNECTION_TYPE, "setText", "(Ljava/lang/CharSequence;Landroid/widget/TextView$BufferType;)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "", "maxNumber", "setMaxNumberInCount", "(I)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "n", "I", "mEllipsisColor", "Landroid/content/Context;", "context", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public final class OBadgeView extends OTextView {
    private static int o = 99;
    private int n;

    static {
    }

    public OBadgeView(Context r7, AttributeSet r8) {
        this(r7, r8, 0, 4, null);
    }

    public OBadgeView(Context r9, AttributeSet r10, int r11) {
        o.f(r9, "context");
        super(r9, r10, r11, null, 8, null);
        g(r10);
    }

    public /* synthetic */ OBadgeView(Context r1, AttributeSet r2, int r3, int r4, g r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    private final void g(AttributeSet r1) {
        h(r1);
        setLines(1);
    }

    private final void h(AttributeSet r3) {
        TypedArray r4 = getContext().obtainStyledAttributes(r3, k.f8295h);
        o.e(r4, "context.obtainStyledAttr…, R.styleable.OBadgeView)");
        this.n = r4.getColor(k.f8296i, 0);
        r4.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas r9) {
        super.onDraw(r9);
        if (this.n == 0) goto L13;
        float r0 = getWidth() / 2.0f;
        float r2 = getHeight() / 2.0f;
        Resources r3 = Resources.getSystem();
        o.e(r3, "Resources.getSystem()");
        float r1 = TypedValue.applyDimension(1, (float) 1.5d, r3.getDisplayMetrics());
        Paint r4 = new Paint();
        r4.setColor(this.n);
        r4.setAntiAlias(true);
        if (r9 == null) goto L8;
        r9.drawCircle(r0, r2, r1, r4);
    L8:
        if (r9 == null) goto L10;
        Resources r7 = Resources.getSystem();
        o.e(r7, "Resources.getSystem()");
        r9.drawCircle(r0 - a.a(TypedValue.applyDimension(1, 6, r7.getDisplayMetrics())), r2, r1, r4);
    L10:
        if (r9 == null) goto L14;
        Resources r6 = Resources.getSystem();
        o.e(r6, "Resources.getSystem()");
        r9.drawCircle(r0 + a.a(TypedValue.applyDimension(1, 6, r6.getDisplayMetrics())), r2, r1, r4);
        return;
    L14:
        return;
    }

    @Override // com.obric.oui.text.OTextView, android.widget.TextView, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // com.obric.oui.text.OTextView, android.widget.TextView, android.view.View
    protected void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    public final void setMaxNumberInCount(int r1) {
        o = r1;
    }

    @Override // android.widget.TextView
    public void setText(CharSequence r4, TextView.BufferType r5) {
        o.f(r4, "inText");
        if (TextUtils.isEmpty(r4) == false) goto L16;
    L13:
        super.setText(r4, r5);
        return;
    L16:
        Integer r0 = Integer.valueOf(r4.toString());     // Catch: Exception -> L11
        if (r0.intValue() <= o) goto L8;
        StringBuilder r6 = new StringBuilder();     // Catch: Exception -> L11
        r6.append(o);     // Catch: Exception -> L11
        r6.append('+');     // Catch: Exception -> L11
        r4 = r6.toString();     // Catch: Exception -> L11
    L15:
    L8:
        if (r0.intValue() >= 0) goto L15;
        r4 = "";
    L12:
        throw new IllegalArgumentException("Excepted a int but get " + getText());
    }
}
