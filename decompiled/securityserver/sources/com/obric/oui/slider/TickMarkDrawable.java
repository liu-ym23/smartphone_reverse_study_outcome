package com.obric.oui.slider;

import a.a;
import android.graphics.drawable.BitmapDrawable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class TickMarkDrawable extends BitmapDrawable {
    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return a.d("Resources.getSystem()", 1, 18);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return a.d("Resources.getSystem()", 1, 14);
    }
}
