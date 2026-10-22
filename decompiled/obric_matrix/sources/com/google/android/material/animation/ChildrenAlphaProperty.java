package com.google.android.material.animation;

import android.util.Property;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes2.dex */
public class ChildrenAlphaProperty extends Property<ViewGroup, Float> {
    public static final Property<ViewGroup, Float> CHILDREN_ALPHA = null;

    static {
        CHILDREN_ALPHA = new ChildrenAlphaProperty("childrenAlpha");
    }

    private ChildrenAlphaProperty(String r2) {
        super(Float.class, r2);
    }

    @NonNull
    /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
    public Float get2(@NonNull ViewGroup r1) {
        Float r0 = (Float) r1.getTag(R.id.mtrl_internal_children_alpha_tag);
        if (r0 == null) goto L6;
        return r0;
    L6:
        return Float.valueOf(1.0f);
    }

    @Override // android.util.Property
    @NonNull
    public /* bridge */ /* synthetic */ Float get(@NonNull ViewGroup r1) {
        return get2(r1);
    }

    /* JADX INFO: renamed from: set, reason: avoid collision after fix types in other method */
    public void set2(@NonNull ViewGroup r3, @NonNull Float r4) {
        float r2 = r4.floatValue();
        r3.setTag(R.id.mtrl_internal_children_alpha_tag, Float.valueOf(r2));
        int r5 = r3.getChildCount();
        int r0 = 0;
    L3:
        if (r0 >= r5) goto L5;
        r3.getChildAt(r0).setAlpha(r2);
        r0 = r0 + 1;
        goto L3
    }

    @Override // android.util.Property
    public /* bridge */ /* synthetic */ void set(@NonNull ViewGroup r1, @NonNull Float r2) {
        set2(r1, r2);
    }
}
