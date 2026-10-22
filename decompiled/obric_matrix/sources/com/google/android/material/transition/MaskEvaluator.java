package com.google.android.material.transition;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;

/* JADX INFO: loaded from: classes2.dex */
class MaskEvaluator {
    private ShapeAppearanceModel currentShapeAppearanceModel;
    private final Path endPath;
    private final Path path;
    private final ShapeAppearancePathProvider pathProvider;
    private final Path startPath;

    MaskEvaluator() {
        this.path = new Path();
        this.startPath = new Path();
        this.endPath = new Path();
        this.pathProvider = ShapeAppearancePathProvider.getInstance();
    }

    void clip(Canvas r3) {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        r3.clipPath(this.path);
        return;
    L5:
        r3.clipPath(this.startPath);
        r3.clipPath(this.endPath, Region.Op.UNION);
    }

    void evaluate(float r8, ShapeAppearanceModel r9, ShapeAppearanceModel r10, RectF r11, RectF r12, RectF r13, MaterialContainerTransform.ProgressThresholds r14) {
        ShapeAppearanceModel r15 = TransitionUtils.lerp(r9, r10, r11, r13, r14.getStart(), r14.getEnd(), r8);
        this.currentShapeAppearanceModel = r15;
        this.pathProvider.calculatePath(r15, 1.0f, r12, this.startPath);
        this.pathProvider.calculatePath(this.currentShapeAppearanceModel, 1.0f, r13, this.endPath);
        if (Build.VERSION.SDK_INT < 23) goto L6;
        this.path.op(this.startPath, this.endPath, Path.Op.UNION);
        return;
    }

    ShapeAppearanceModel getCurrentShapeAppearanceModel() {
        return this.currentShapeAppearanceModel;
    }

    Path getPath() {
        return this.path;
    }
}
