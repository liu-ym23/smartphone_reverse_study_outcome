package com.google.android.material.animation;

import android.graphics.drawable.Drawable;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
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

    @Override // android.util.Property
    @Nullable
    public /* bridge */ /* synthetic */ Integer get(@NonNull Drawable r1) {
        return get2(r1);
    }

    @Override // android.util.Property
    public /* bridge */ /* synthetic */ void set(@NonNull Drawable r1, @NonNull Integer r2) {
        set2(r1, r2);
    }

    @Nullable
    /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
    public Integer get2(@NonNull Drawable r1) {
        return Integer.valueOf(r1.getAlpha());
    }

    /* JADX INFO: renamed from: set, reason: avoid collision after fix types in other method */
    public void set2(@NonNull Drawable r1, @NonNull Integer r2) {
        r1.setAlpha(r2.intValue());
    }
}
