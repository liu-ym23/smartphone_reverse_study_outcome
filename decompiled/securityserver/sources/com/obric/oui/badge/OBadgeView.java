package com.obric.oui.badge;

import a.a;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;
import com.obric.common.oui.R;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OBadgeView extends OTextView {
    public static int n = 99;
    public final int m;

    @Metadata
    public static final class Companion {
    }

    @JvmOverloads
    public OBadgeView(@NotNull Context r3, @Nullable AttributeSet r4) {
        Intrinsics.f(r3, "context");
        super(r3, r4, 0, 8);
        TypedArray r5 = getContext().obtainStyledAttributes(r4, R.styleable.b);
        Intrinsics.e(r5, "context.obtainStyledAttr…, R.styleable.OBadgeView)");
        this.m = r5.getColor(0, 0);
        r5.recycle();
        setLines(1);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r8) {
        super.onDraw(r8);
        if (this.m == 0) goto L13;
        float r0 = getWidth() / 2.0f;
        float r2 = getHeight() / 2.0f;
        Resources r3 = Resources.getSystem();
        Intrinsics.e(r3, "Resources.getSystem()");
        float r1 = TypedValue.applyDimension(1, (float) 1.5d, r3.getDisplayMetrics());
        Paint r4 = new Paint();
        r4.setColor(this.m);
        r4.setAntiAlias(true);
        if (r8 == null) goto L8;
        r8.drawCircle(r0, r2, r1, r4);
    L8:
        if (r8 == null) goto L10;
        r8.drawCircle(r0 - a.d("Resources.getSystem()", 1, 6), r2, r1, r4);
    L10:
        if (r8 == null) goto L14;
        r8.drawCircle(r0 + a.d("Resources.getSystem()", 1, 6), r2, r1, r4);
        return;
    L14:
        return;
    }

    public final void setMaxNumberInCount(int r1) {
        n = r1;
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence r4, TextView.BufferType r5) {
        Intrinsics.f(r4, "inText");
        if (TextUtils.isEmpty(r4) == false) goto L16;
    L13:
        super.setText(r4, r5);
        return;
    L16:
        Integer r0 = Integer.valueOf(r4.toString());     // Catch: Exception -> L11
        if (r0.intValue() <= n) goto L8;
        StringBuilder r6 = new StringBuilder();     // Catch: Exception -> L11
        r6.append(n);     // Catch: Exception -> L11
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
