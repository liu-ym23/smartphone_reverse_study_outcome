package com.google.android.material.animation;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class DrawableAlphaProperty extends Property<Drawable, Integer> {
    public static final Property<Drawable, Integer> DRAWABLE_ALPHA_COMPAT = null;
    private final WeakHashMap<Drawable, Integer> alphaCache;

    static {
        DRAWABLE_ALPHA_COMPAT = new DrawableAlphaProperty();
    }

    private DrawableAlphaProperty() {
        super(Integer.class, "drawableAlphaCompat");
        this.alphaCache = new WeakHashMap();
    }

    @Nullable
    /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
    public Integer get2(@NonNull Drawable r3) {
        if (Build.VERSION.SDK_INT < 19) goto L7;
        return Integer.valueOf(r3.getAlpha());
    L7:
        if (this.alphaCache.containsKey(r3) == false) goto L11;
        return this.alphaCache.get(r3);
    L11:
        return 255;
    }

    @Override // android.util.Property
    @Nullable
    public /* bridge */ /* synthetic */ Integer get(@NonNull Drawable r1) {
        return get2(r1);
    }

    /* JADX INFO: renamed from: set, reason: avoid collision after fix types in other method */
    public void set2(@NonNull Drawable r3, @NonNull Integer r4) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        this.alphaCache.put(r3, r4);
    L5:
        r3.setAlpha(r4.intValue());
    }

    @Override // android.util.Property
    public /* bridge */ /* synthetic */ void set(@NonNull Drawable r1, @NonNull Integer r2) {
        set2(r1, r2);
    }
}
