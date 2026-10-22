package xr;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.shapes.OvalShape;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R$color;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends OvalShape {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f23220a;

    @Override // android.graphics.drawable.shapes.OvalShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
    public final void draw(Canvas r5, Paint r10) {
        if (r10 == null) goto L5;
        Context r11 = this.f23220a;
        Intrinsics.checkNotNull(r11);
        r10.setColor(ContextCompat.getColor(r11, R$color.ConstTextInverse));
    L5:
        if (r10 == null) goto L8;
        Intrinsics.checkNotNullParameter("#40000000", "<this>");
        r10.setShadowLayer(2.0f, 0.0f, 1.0f, Color.parseColor("#40000000"));
    L8:
        super.draw(r5, r10);
    }
}
