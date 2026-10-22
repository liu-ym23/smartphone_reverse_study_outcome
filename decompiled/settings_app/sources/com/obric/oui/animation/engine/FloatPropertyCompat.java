package com.obric.oui.animation.engine;

import android.util.FloatProperty;

/* JADX INFO: loaded from: classes4.dex */
public abstract class FloatPropertyCompat<T> {
    final String mPropertyName;

    public abstract float getValue(T r1);

    public abstract void setValue(T r1, float r2);

    public FloatPropertyCompat(String r1) {
        this.mPropertyName = r1;
    }

    public static <T> FloatPropertyCompat<T> createFloatPropertyCompat(final FloatProperty<T> r2) {
        final String r1 = r2.getName();
        return new AnonymousClass1(r1, r2);
    }
}
