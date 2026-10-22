package com.obric.oui.oswitch;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.shapes.OvalShape;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OSwitchBak.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u000e"}, d2 = {"Lcom/obric/oui/oswitch/OvalShapeWithShadow;", "Landroid/graphics/drawable/shapes/OvalShape;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "setContext", "draw", "", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OvalShapeWithShadow extends OvalShape {
    private Context context;

    public OvalShapeWithShadow(Context r1) {
        this.context = r1;
    }

    public final Context getContext() {
        return this.context;
    }

    public final void setContext(Context r1) {
        this.context = r1;
    }

    @Override // android.graphics.drawable.shapes.OvalShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
    public void draw(Canvas r5, Paint r6) {
        if (r6 == null) goto L5;
        Context r0 = this.context;
        Intrinsics.checkNotNull(r0);
        r6.setColor(ContextCompat.getColor(r0, R.color.ConstTextInverse));
    L5:
        if (r6 == null) goto L8;
        r6.setShadowLayer(2.0f, 0.0f, 1.0f, OUnitExtensionKt.getColor("#40000000"));
    L8:
        super.draw(r5, r6);
    }
}
