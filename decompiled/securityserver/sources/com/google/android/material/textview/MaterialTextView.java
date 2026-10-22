package com.google.android.material.textview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleableRes;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.R;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* JADX INFO: loaded from: classes.dex */
public class MaterialTextView extends AppCompatTextView {
    public MaterialTextView(@NonNull Context r2) {
        this(r2, null);
    }

    private void applyLineHeightFromViewAppearance(@NonNull Resources.Theme r3, int r4) {
        TypedArray r5 = r3.obtainStyledAttributes(r4, R.styleable.MaterialTextAppearance);
        int r6 = readFirstAvailableDimension(getContext(), r5, new int[]{R.styleable.MaterialTextAppearance_android_lineHeight, R.styleable.MaterialTextAppearance_lineHeight});
        r5.recycle();
        if (r6 < 0) goto L6;
        setLineHeight(r6);
        return;
    }

    private static boolean canApplyTextAppearanceLineHeight(Context r2) {
        return MaterialAttributes.resolveBoolean(r2, R.attr.textAppearanceLineHeightEnabled, true);
    }

    private static int findViewAppearanceResourceId(@NonNull Resources.Theme r1, @Nullable AttributeSet r2, int r3, int r4) {
        TypedArray r5 = r1.obtainStyledAttributes(r2, R.styleable.MaterialTextView, r3, r4);
        int r6 = r5.getResourceId(R.styleable.MaterialTextView_android_textAppearance, -1);
        r5.recycle();
        return r6;
    }

    private static int readFirstAvailableDimension(@NonNull Context r4, @NonNull TypedArray r5, @NonNull @StyleableRes int... r6) {
        int r1 = 0;
        int r2 = -1;
    L4:
        if (r1 >= r6.length) goto L7;
        if (r2 >= 0) goto L7;
        r2 = MaterialResources.getDimensionPixelSize(r4, r5, r6[r1], -1);
        r1 = r1 + 1;
    L7:
        return r2;
    }

    private static boolean viewAttrsHasLineHeight(@NonNull Context r1, @NonNull Resources.Theme r2, @Nullable AttributeSet r3, int r4, int r5) {
        TypedArray r6 = r2.obtainStyledAttributes(r3, R.styleable.MaterialTextView, r4, r5);
        int r7 = readFirstAvailableDimension(r1, r6, new int[]{R.styleable.MaterialTextView_android_lineHeight, R.styleable.MaterialTextView_lineHeight});
        r6.recycle();
        if (r7 == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setTextAppearance(@NonNull Context r2, int r3) {
        super.setTextAppearance(r2, r3);
        if (canApplyTextAppearanceLineHeight(r2) == false) goto L6;
        applyLineHeightFromViewAppearance(r2.getTheme(), r3);
        return;
    }

    public MaterialTextView(@NonNull Context r2, @Nullable AttributeSet r3) {
        this(r2, r3, android.R.attr.textViewStyle);
    }

    public MaterialTextView(@NonNull Context r2, @Nullable AttributeSet r3, int r4) {
        this(r2, r3, r4, 0);
    }

    public MaterialTextView(@NonNull Context r2, @Nullable AttributeSet r3, int r4, int r5) {
        super(MaterialThemeOverlay.wrap(r2, r3, r4, r5), r3, r4);
        Context r6 = getContext();
        if (canApplyTextAppearanceLineHeight(r6) == false) goto L10;
        Resources.Theme r0 = r6.getTheme();
        if (viewAttrsHasLineHeight(r6, r0, r3, r4, r5) == true) goto L11;
        int r7 = findViewAppearanceResourceId(r0, r3, r4, r5);
        if (r7 == (-1)) goto L12;
        applyLineHeightFromViewAppearance(r0, r7);
        return;
    L12:
        return;
    L11:
        return;
    }
}
