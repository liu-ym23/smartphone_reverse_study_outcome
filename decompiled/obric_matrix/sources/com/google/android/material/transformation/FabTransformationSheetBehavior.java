package com.google.android.material.transformation;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.Positioning;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class FabTransformationSheetBehavior extends FabTransformationBehavior {

    @Nullable
    private Map<View, Integer> importantForAccessibilityMap;

    public FabTransformationSheetBehavior() {
    }

    public FabTransformationSheetBehavior(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    private void updateImportantForAccessibility(@NonNull View r10, boolean r11) {
        int r0 = Build.VERSION.SDK_INT;
        ViewParent r1 = r10.getParent();
        if ((r1 instanceof CoordinatorLayout) == true) goto L5;
        return;
    L5:
        CoordinatorLayout r2 = (CoordinatorLayout) r1;
        int r3 = r2.getChildCount();
        if (r0 < 16) goto L9;
        if (r11 == false) goto L9;
        this.importantForAccessibilityMap = new HashMap(r3);
    L9:
        int r5 = 0;
    L10:
        if (r5 >= r3) goto L31;
        View r6 = r2.getChildAt(r5);
        if ((r6.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) == true) goto L14;
    L16:
        boolean r7 = false;
    L17:
        if (r6 == r10) goto L30;
        if (r7 == true) goto L30;
        if (r11 == true) goto L26;
        Map<View, Integer> r8 = this.importantForAccessibilityMap;
        if (r8 == null) goto L30;
        if (r8.containsKey(r6) == false) goto L30;
        int r9 = this.importantForAccessibilityMap.get(r6).intValue();
    L29:
        ViewCompat.setImportantForAccessibility(r6, r9);
        goto L30
    L26:
        if (r0 < 16) goto L28;
        this.importantForAccessibilityMap.put(r6, Integer.valueOf(r6.getImportantForAccessibility()));
    L28:
        r9 = 4;
    L30:
        r5 = r5 + 1;
        goto L10
    L14:
        if ((((CoordinatorLayout.LayoutParams) r6.getLayoutParams()).getBehavior() instanceof FabTransformationScrimBehavior) == false) goto L16;
        r7 = true;
        goto L17
    L31:
        if (r11 == true) goto L40;
        this.importantForAccessibilityMap = null;
        return;
    }

    @Override // com.google.android.material.transformation.FabTransformationBehavior
    @NonNull
    protected FabTransformationBehavior.FabTransformationSpec onCreateMotionSpec(Context r2, boolean r3) {
        if (r3 == false) goto L4;
        int r1 = R.animator.mtrl_fab_transformation_sheet_expand_spec;
    L5:
        FabTransformationBehavior.FabTransformationSpec r4 = new FabTransformationBehavior.FabTransformationSpec();
        r4.timings = MotionSpec.createFromResource(r2, r1);
        r4.positioning = new Positioning(17, 0.0f, 0.0f);
        return r4;
    L4:
        r1 = R.animator.mtrl_fab_transformation_sheet_collapse_spec;
        goto L5
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior, com.google.android.material.transformation.ExpandableBehavior
    @CallSuper
    protected boolean onExpandedStateChange(@NonNull View r1, @NonNull View r2, boolean r3, boolean r4) {
        updateImportantForAccessibility(r2, r3);
        return super.onExpandedStateChange(r1, r2, r3, r4);
    }
}
