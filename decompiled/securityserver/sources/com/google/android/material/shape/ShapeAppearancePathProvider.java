package com.google.android.material.shape;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
public class ShapeAppearancePathProvider {
    private final Path boundsPath;
    private final ShapePath[] cornerPaths;
    private final Matrix[] cornerTransforms;
    private boolean edgeIntersectionCheckEnabled;
    private final Matrix[] edgeTransforms;
    private final Path overlappedEdgePath;
    private final PointF pointF;
    private final float[] scratch;
    private final float[] scratch2;
    private final ShapePath shapePath;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface PathListener {
        void onCornerPathCreated(ShapePath r1, Matrix r2, int r3);

        void onEdgePathCreated(ShapePath r1, Matrix r2, int r3);
    }

    public static final class ShapeAppearancePathSpec {

        @NonNull
        public final RectF bounds;
        public final float interpolation;

        @NonNull
        public final Path path;

        @Nullable
        public final PathListener pathListener;

        @NonNull
        public final ShapeAppearanceModel shapeAppearanceModel;

        public ShapeAppearancePathSpec(@NonNull ShapeAppearanceModel r1, float r2, RectF r3, @Nullable PathListener r4, Path r5) {
            this.pathListener = r4;
            this.shapeAppearanceModel = r1;
            this.interpolation = r2;
            this.bounds = r3;
            this.path = r5;
        }
    }

    public ShapeAppearancePathProvider() {
        this.cornerPaths = new ShapePath[4];
        this.cornerTransforms = new Matrix[4];
        this.edgeTransforms = new Matrix[4];
        this.pointF = new PointF();
        this.overlappedEdgePath = new Path();
        this.boundsPath = new Path();
        this.shapePath = new ShapePath();
        this.scratch = new float[2];
        this.scratch2 = new float[2];
        this.edgeIntersectionCheckEnabled = true;
        int r1 = 0;
    L3:
        if (r1 >= 4) goto L5;
        this.cornerPaths[r1] = new ShapePath();
        this.cornerTransforms[r1] = new Matrix();
        this.edgeTransforms[r1] = new Matrix();
        r1 = r1 + 1;
        goto L3
    }

    private float angleOfEdge(int r1) {
        return (r1 + 1) * 90;
    }

    private void appendCornerPath(@NonNull ShapeAppearancePathSpec r5, int r6) {
        this.scratch[0] = this.cornerPaths[r6].getStartX();
        this.scratch[1] = this.cornerPaths[r6].getStartY();
        this.cornerTransforms[r6].mapPoints(this.scratch);
        if (r6 != 0) goto L5;
        Path r0 = r5.path;
        float[] r1 = this.scratch;
        r0.moveTo(r1[0], r1[1]);
    L6:
        this.cornerPaths[r6].applyToPath(this.cornerTransforms[r6], r5.path);
        PathListener r7 = r5.pathListener;
        if (r7 == null) goto L10;
        r7.onCornerPathCreated(this.cornerPaths[r6], this.cornerTransforms[r6], r6);
        return;
    L10:
        return;
    L5:
        Path r2 = r5.path;
        float[] r3 = this.scratch;
        r2.lineTo(r3[0], r3[1]);
        goto L6
    }

    private void appendEdgePath(@NonNull ShapeAppearancePathSpec r9, int r10) {
        int r0 = (r10 + 1) % 4;
        this.scratch[0] = this.cornerPaths[r10].getEndX();
        this.scratch[1] = this.cornerPaths[r10].getEndY();
        this.cornerTransforms[r10].mapPoints(this.scratch);
        this.scratch2[0] = this.cornerPaths[r0].getStartX();
        this.scratch2[1] = this.cornerPaths[r0].getStartY();
        this.cornerTransforms[r0].mapPoints(this.scratch2);
        float[] r1 = this.scratch;
        float r2 = r1[0];
        float[] r5 = this.scratch2;
        float r3 = Math.max(((float) Math.hypot(r2 - r5[0], r1[1] - r5[1])) - 0.001f, 0.0f);
        float r6 = getEdgeCenterForIndex(r9.bounds, r10);
        this.shapePath.reset(0.0f, 0.0f);
        EdgeTreatment r4 = getEdgeTreatmentForIndex(r10, r9.shapeAppearanceModel);
        r4.getEdgePath(r3, r6, r9.interpolation, this.shapePath);
        Path r7 = new Path();
        this.shapePath.applyToPath(this.edgeTransforms[r10], r7);
        if (this.edgeIntersectionCheckEnabled == true) goto L5;
    L11:
        this.shapePath.applyToPath(this.edgeTransforms[r10], r9.path);
    L12:
        PathListener r11 = r9.pathListener;
        if (r11 == null) goto L16;
        r11.onEdgePathCreated(this.shapePath, this.edgeTransforms[r10], r10);
        return;
    L16:
        return;
    L5:
        if (r4.forceIntersection() == false) goto L7;
    L10:
        r7.op(r7, this.boundsPath, Path.Op.DIFFERENCE);
        this.scratch[0] = this.shapePath.getStartX();
        this.scratch[1] = this.shapePath.getStartY();
        this.edgeTransforms[r10].mapPoints(this.scratch);
        Path r8 = this.overlappedEdgePath;
        float[] r12 = this.scratch;
        r8.moveTo(r12[0], r12[1]);
        this.shapePath.applyToPath(this.edgeTransforms[r10], this.overlappedEdgePath);
        goto L12
    L7:
        if (pathOverlapsCorner(r7, r10) == true) goto L10;
        if (pathOverlapsCorner(r7, r0) == false) goto L11;
        goto L10
    }

    private void getCoordinatesOfCorner(int r1, @NonNull RectF r2, @NonNull PointF r3) {
        if (r1 != 1) goto L5;
        r3.set(r2.right, r2.bottom);
        return;
    L5:
        if (r1 != 2) goto L7;
        r3.set(r2.left, r2.bottom);
        return;
    L7:
        if (r1 == 3) goto L9;
        r3.set(r2.right, r2.top);
        return;
    L9:
        r3.set(r2.left, r2.top);
    }

    private CornerSize getCornerSizeForIndex(int r1, @NonNull ShapeAppearanceModel r2) {
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L13;
        if (r1 == 3) goto L11;
        return r2.getTopRightCornerSize();
    L11:
        return r2.getTopLeftCornerSize();
    L13:
        return r2.getBottomLeftCornerSize();
    L15:
        return r2.getBottomRightCornerSize();
    }

    private CornerTreatment getCornerTreatmentForIndex(int r1, @NonNull ShapeAppearanceModel r2) {
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L13;
        if (r1 == 3) goto L11;
        return r2.getTopRightCorner();
    L11:
        return r2.getTopLeftCorner();
    L13:
        return r2.getBottomLeftCorner();
    L15:
        return r2.getBottomRightCorner();
    }

    private float getEdgeCenterForIndex(@NonNull RectF r5, int r6) {
        float[] r0 = this.scratch;
        ShapePath r1 = this.cornerPaths[r6];
        r0[0] = r1.endX;
        r0[1] = r1.endY;
        this.cornerTransforms[r6].mapPoints(r0);
        if (r6 == 1) goto L9;
        if (r6 == 3) goto L9;
        return Math.abs(r5.centerY() - this.scratch[1]);
    L9:
        return Math.abs(r5.centerX() - this.scratch[0]);
    }

    private EdgeTreatment getEdgeTreatmentForIndex(int r1, @NonNull ShapeAppearanceModel r2) {
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L13;
        if (r1 == 3) goto L11;
        return r2.getRightEdge();
    L11:
        return r2.getTopEdge();
    L13:
        return r2.getLeftEdge();
    L15:
        return r2.getBottomEdge();
    }

    @RequiresApi(19)
    private boolean pathOverlapsCorner(Path r3, int r4) {
        Path r0 = new Path();
        this.cornerPaths[r4].applyToPath(this.cornerTransforms[r4], r0);
        RectF r2 = new RectF();
        r3.computeBounds(r2, true);
        r0.computeBounds(r2, true);
        r3.op(r0, Path.Op.INTERSECT);
        r3.computeBounds(r2, true);
        if (r2.isEmpty() == true) goto L5;
        return true;
    L5:
        if (r2.width() > 1.0f) goto L7;
    L9:
        return false;
    L7:
        if (r2.height() <= 1.0f) goto L9;
        return true;
    }

    private void setCornerPathAndTransform(@NonNull ShapeAppearancePathSpec r8, int r9) {
        CornerSize r6 = getCornerSizeForIndex(r9, r8.shapeAppearanceModel);
        getCornerTreatmentForIndex(r9, r8.shapeAppearanceModel).getCornerPath(this.cornerPaths[r9], 90.0f, r8.interpolation, r8.bounds, r6);
        float r0 = angleOfEdge(r9);
        this.cornerTransforms[r9].reset();
        getCoordinatesOfCorner(r9, r8.bounds, this.pointF);
        Matrix r10 = this.cornerTransforms[r9];
        PointF r1 = this.pointF;
        r10.setTranslate(r1.x, r1.y);
        this.cornerTransforms[r9].preRotate(r0);
    }

    private void setEdgePathAndTransform(int r6) {
        this.scratch[0] = this.cornerPaths[r6].getEndX();
        this.scratch[1] = this.cornerPaths[r6].getEndY();
        this.cornerTransforms[r6].mapPoints(this.scratch);
        float r0 = angleOfEdge(r6);
        this.edgeTransforms[r6].reset();
        Matrix r1 = this.edgeTransforms[r6];
        float[] r4 = this.scratch;
        r1.setTranslate(r4[0], r4[1]);
        this.edgeTransforms[r6].preRotate(r0);
    }

    public void calculatePath(ShapeAppearanceModel r7, float r8, RectF r9, @NonNull Path r10) {
        calculatePath(r7, r8, r9, null, r10);
    }

    public void setEdgeIntersectionCheckEnable(boolean r1) {
        this.edgeIntersectionCheckEnabled = r1;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void calculatePath(ShapeAppearanceModel r9, float r10, RectF r11, PathListener r12, @NonNull Path r13) {
        r13.rewind();
        this.overlappedEdgePath.rewind();
        this.boundsPath.rewind();
        this.boundsPath.addRect(r11, Path.Direction.CW);
        ShapeAppearancePathSpec r0 = new ShapeAppearancePathSpec(r9, r10, r11, r12, r13);
        int r14 = 0;
        int r15 = 0;
    L4:
        if (r15 >= 4) goto L6;
        setCornerPathAndTransform(r0, r15);
        setEdgePathAndTransform(r15);
        r15 = r15 + 1;
    L6:
        if (r14 >= 4) goto L8;
        appendCornerPath(r0, r14);
        appendEdgePath(r0, r14);
        r14 = r14 + 1;
        goto L6
    L8:
        r13.close();
        this.overlappedEdgePath.close();
        if (this.overlappedEdgePath.isEmpty() == true) goto L14;
        r13.op(this.overlappedEdgePath, Path.Op.UNION);
        return;
    }
}
