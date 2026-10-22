package com.obric.oui.oswitch;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.shapes.OvalShape;
import androidx.core.content.ContextCompat;
import com.bytedance.securityserver.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OvalShapeWithShadow extends OvalShape {
    @Override // android.graphics.drawable.shapes.OvalShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
    public final void draw(Canvas r5, Paint r6) {
        if (r6 == null) goto L4;
        Intrinsics.c(null);
        r6.setColor(ContextCompat.getColor(null, R.color.ConstTextInverse));
    L4:
        if (r6 == null) goto L6;
        r6.setShadowLayer(2.0f, 0.0f, 1.0f, Color.parseColor("#40000000"));
    L6:
        super.draw(r5, r6);
    }
}
