package com.obric.oui.slider;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.obric.oui.common.util.OUnitExtensionKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ThumbDrawable.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/oui/slider/TickMarkDrawable;", "Landroid/graphics/drawable/BitmapDrawable;", "res", "Landroid/content/res/Resources;", "bitmap", "Landroid/graphics/Bitmap;", "(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V", "getIntrinsicHeight", "", "getIntrinsicWidth", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TickMarkDrawable extends BitmapDrawable {
    private final Resources res;

    public TickMarkDrawable(Resources r2, Bitmap r3) {
        Intrinsics.checkNotNullParameter(r2, "res");
        Intrinsics.checkNotNullParameter(r3, "bitmap");
        super(r2, r3);
        this.res = r2;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return OUnitExtensionKt.cdp(this.res, 18);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return OUnitExtensionKt.cdp(this.res, 14);
    }
}
