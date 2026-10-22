package com.google.android.material.shape;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.google.android.material.shadow.ShadowRenderer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ShapePath {
    protected static final float ANGLE_LEFT = 180.0f;
    private static final float ANGLE_UP = 270.0f;
    private boolean containsIncompatibleShadowOp;

    @Deprecated
    public float currentShadowAngle;

    @Deprecated
    public float endShadowAngle;

    @Deprecated
    public float endX;

    @Deprecated
    public float endY;
    private final List<PathOperation> operations;
    private final List<ShadowCompatOperation> shadowCompatOperations;

    @Deprecated
    public float startX;

    @Deprecated
    public float startY;

    public static class ArcShadowOperation extends ShadowCompatOperation {
        private final PathArcOperation operation;

        public ArcShadowOperation(PathArcOperation r1) {
            this.operation = r1;
        }

        @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
        public void draw(Matrix r9, @NonNull ShadowRenderer r10, int r11, @NonNull Canvas r12) {
            float r6 = PathArcOperation.access$800(this.operation);
            float r7 = PathArcOperation.access$900(this.operation);
            r10.drawCornerShadow(r12, r9, new RectF(PathArcOperation.access$1000(this.operation), PathArcOperation.access$1100(this.operation), PathArcOperation.access$1200(this.operation), PathArcOperation.access$1300(this.operation)), r11, r6, r7);
        }
    }

    public static class LineShadowOperation extends ShadowCompatOperation {
        private final PathLineOperation operation;
        private final float startX;
        private final float startY;

        public LineShadowOperation(PathLineOperation r1, float r2, float r3) {
            this.operation = r1;
            this.startX = r2;
            this.startY = r3;
        }

        @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
        public void draw(Matrix r6, @NonNull ShadowRenderer r7, int r8, @NonNull Canvas r9) {
            RectF r2 = new RectF(0.0f, 0.0f, (float) Math.hypot(PathLineOperation.access$100(this.operation) - this.startY, PathLineOperation.access$000(this.operation) - this.startX), 0.0f);
            Matrix r0 = new Matrix(r6);
            r0.preTranslate(this.startX, this.startY);
            r0.preRotate(getAngle());
            r7.drawEdgeShadow(r9, r0, r2, r8);
        }

        public float getAngle() {
            return (float) Math.toDegrees(Math.atan((PathLineOperation.access$100(this.operation) - this.startY) / (PathLineOperation.access$000(this.operation) - this.startX)));
        }
    }

    public static class PathArcOperation extends PathOperation {
        private static final RectF rectF = null;

        @Deprecated
        public float bottom;

        @Deprecated
        public float left;

        @Deprecated
        public float right;

        @Deprecated
        public float startAngle;

        @Deprecated
        public float sweepAngle;

        @Deprecated
        public float top;

        static {
            rectF = new RectF();
        }

        public PathArcOperation(float r1, float r2, float r3, float r4) {
            setLeft(r1);
            setTop(r2);
            setRight(r3);
            setBottom(r4);
        }

        public static /* synthetic */ float access$1000(PathArcOperation r0) {
            return r0.getLeft();
        }

        public static /* synthetic */ float access$1100(PathArcOperation r0) {
            return r0.getTop();
        }

        public static /* synthetic */ float access$1200(PathArcOperation r0) {
            return r0.getRight();
        }

        public static /* synthetic */ float access$1300(PathArcOperation r0) {
            return r0.getBottom();
        }

        public static /* synthetic */ void access$600(PathArcOperation r0, float r1) {
            r0.setStartAngle(r1);
        }

        public static /* synthetic */ void access$700(PathArcOperation r0, float r1) {
            r0.setSweepAngle(r1);
        }

        public static /* synthetic */ float access$800(PathArcOperation r0) {
            return r0.getStartAngle();
        }

        public static /* synthetic */ float access$900(PathArcOperation r0) {
            return r0.getSweepAngle();
        }

        private float getBottom() {
            return this.bottom;
        }

        private float getLeft() {
            return this.left;
        }

        private float getRight() {
            return this.right;
        }

        private float getStartAngle() {
            return this.startAngle;
        }

        private float getSweepAngle() {
            return this.sweepAngle;
        }

        private float getTop() {
            return this.top;
        }

        private void setBottom(float r1) {
            this.bottom = r1;
        }

        private void setLeft(float r1) {
            this.left = r1;
        }

        private void setRight(float r1) {
            this.right = r1;
        }

        private void setStartAngle(float r1) {
            this.startAngle = r1;
        }

        private void setSweepAngle(float r1) {
            this.sweepAngle = r1;
        }

        private void setTop(float r1) {
            this.top = r1;
        }

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void applyToPath(@NonNull Matrix r6, @NonNull Path r7) {
            Matrix r0 = this.matrix;
            r6.invert(r0);
            r7.transform(r0);
            RectF r1 = rectF;
            r1.set(getLeft(), getTop(), getRight(), getBottom());
            r7.arcTo(r1, getStartAngle(), getSweepAngle(), false);
            r7.transform(r6);
        }
    }

    public static class PathCubicOperation extends PathOperation {
        private float controlX1;
        private float controlX2;
        private float controlY1;
        private float controlY2;
        private float endX;
        private float endY;

        public PathCubicOperation(float r1, float r2, float r3, float r4, float r5, float r6) {
            setControlX1(r1);
            setControlY1(r2);
            setControlX2(r3);
            setControlY2(r4);
            setEndX(r5);
            setEndY(r6);
        }

        private float getControlX1() {
            return this.controlX1;
        }

        private float getControlX2() {
            return this.controlX2;
        }

        private float getControlY1() {
            return this.controlY1;
        }

        private float getControlY2() {
            return this.controlY1;
        }

        private float getEndX() {
            return this.endX;
        }

        private float getEndY() {
            return this.endY;
        }

        private void setControlX1(float r1) {
            this.controlX1 = r1;
        }

        private void setControlX2(float r1) {
            this.controlX2 = r1;
        }

        private void setControlY1(float r1) {
            this.controlY1 = r1;
        }

        private void setControlY2(float r1) {
            this.controlY2 = r1;
        }

        private void setEndX(float r1) {
            this.endX = r1;
        }

        private void setEndY(float r1) {
            this.endY = r1;
        }

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void applyToPath(@NonNull Matrix r9, @NonNull Path r10) {
            Matrix r0 = this.matrix;
            r9.invert(r0);
            r10.transform(r0);
            r10.cubicTo(this.controlX1, this.controlY1, this.controlX2, this.controlY2, this.endX, this.endY);
            r10.transform(r9);
        }
    }

    public static class PathLineOperation extends PathOperation {
        private float x;
        private float y;

        public PathLineOperation() {
        }

        public static /* synthetic */ float access$000(PathLineOperation r0) {
            return r0.x;
        }

        public static /* synthetic */ float access$002(PathLineOperation r0, float r1) {
            r0.x = r1;
            return r1;
        }

        public static /* synthetic */ float access$100(PathLineOperation r0) {
            return r0.y;
        }

        public static /* synthetic */ float access$102(PathLineOperation r0, float r1) {
            r0.y = r1;
            return r1;
        }

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void applyToPath(@NonNull Matrix r2, @NonNull Path r3) {
            Matrix r0 = this.matrix;
            r2.invert(r0);
            r3.transform(r0);
            r3.lineTo(this.x, this.y);
            r3.transform(r2);
        }
    }

    public static abstract class PathOperation {
        protected final Matrix matrix;

        public PathOperation() {
            this.matrix = new Matrix();
        }

        public abstract void applyToPath(Matrix r1, Path r2);
    }

    public static class PathQuadOperation extends PathOperation {

        @Deprecated
        public float controlX;

        @Deprecated
        public float controlY;

        @Deprecated
        public float endX;

        @Deprecated
        public float endY;

        public PathQuadOperation() {
        }

        public static /* synthetic */ void access$200(PathQuadOperation r0, float r1) {
            r0.setControlX(r1);
        }

        public static /* synthetic */ void access$300(PathQuadOperation r0, float r1) {
            r0.setControlY(r1);
        }

        public static /* synthetic */ void access$400(PathQuadOperation r0, float r1) {
            r0.setEndX(r1);
        }

        public static /* synthetic */ void access$500(PathQuadOperation r0, float r1) {
            r0.setEndY(r1);
        }

        private float getControlX() {
            return this.controlX;
        }

        private float getControlY() {
            return this.controlY;
        }

        private float getEndX() {
            return this.endX;
        }

        private float getEndY() {
            return this.endY;
        }

        private void setControlX(float r1) {
            this.controlX = r1;
        }

        private void setControlY(float r1) {
            this.controlY = r1;
        }

        private void setEndX(float r1) {
            this.endX = r1;
        }

        private void setEndY(float r1) {
            this.endY = r1;
        }

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void applyToPath(@NonNull Matrix r4, @NonNull Path r5) {
            Matrix r0 = this.matrix;
            r4.invert(r0);
            r5.transform(r0);
            r5.quadTo(getControlX(), getControlY(), getEndX(), getEndY());
            r5.transform(r4);
        }
    }

    public static abstract class ShadowCompatOperation {
        static final Matrix IDENTITY_MATRIX = null;

        static {
            IDENTITY_MATRIX = new Matrix();
        }

        public ShadowCompatOperation() {
        }

        public abstract void draw(Matrix r1, ShadowRenderer r2, int r3, Canvas r4);

        public final void draw(ShadowRenderer r2, int r3, Canvas r4) {
            draw(IDENTITY_MATRIX, r2, r3, r4);
        }
    }

    public ShapePath() {
        this.operations = new ArrayList();
        this.shadowCompatOperations = new ArrayList();
        reset(0.0f, 0.0f);
    }

    private void addConnectingShadowIfNecessary(float r7) {
        if (getCurrentShadowAngle() != r7) goto L5;
        return;
    L5:
        float r0 = ((r7 - getCurrentShadowAngle()) + 360.0f) % 360.0f;
        if (r0 <= ANGLE_LEFT) goto L8;
        return;
    L8:
        PathArcOperation r1 = new PathArcOperation(getEndX(), getEndY(), getEndX(), getEndY());
        PathArcOperation.access$600(r1, getCurrentShadowAngle());
        PathArcOperation.access$700(r1, r0);
        this.shadowCompatOperations.add(new ArcShadowOperation(r1));
        setCurrentShadowAngle(r7);
    }

    private void addShadowCompatOperation(ShadowCompatOperation r1, float r2, float r3) {
        addConnectingShadowIfNecessary(r2);
        this.shadowCompatOperations.add(r1);
        setCurrentShadowAngle(r3);
    }

    private float getCurrentShadowAngle() {
        return this.currentShadowAngle;
    }

    private float getEndShadowAngle() {
        return this.endShadowAngle;
    }

    private void setCurrentShadowAngle(float r1) {
        this.currentShadowAngle = r1;
    }

    private void setEndShadowAngle(float r1) {
        this.endShadowAngle = r1;
    }

    private void setEndX(float r1) {
        this.endX = r1;
    }

    private void setEndY(float r1) {
        this.endY = r1;
    }

    private void setStartX(float r1) {
        this.startX = r1;
    }

    private void setStartY(float r1) {
        this.startY = r1;
    }

    public void addArc(float r5, float r6, float r7, float r8, float r9, float r10) {
        PathArcOperation r0 = new PathArcOperation(r5, r6, r7, r8);
        PathArcOperation.access$600(r0, r9);
        PathArcOperation.access$700(r0, r10);
        this.operations.add(r0);
        ArcShadowOperation r1 = new ArcShadowOperation(r0);
        float r2 = r9 + r10;
        if (r10 >= 0.0f) goto L5;
        boolean r11 = true;
    L7:
        if (r11 == false) goto L9;
        r9 = (r9 + ANGLE_LEFT) % 360.0f;
    L9:
        if (r11 == false) goto L11;
        float r3 = (ANGLE_LEFT + r2) % 360.0f;
    L12:
        addShadowCompatOperation(r1, r9, r3);
        double r4 = r2;
        setEndX((((r7 - r5) / 2.0f) * ((float) Math.cos(Math.toRadians(r4)))) + ((r5 + r7) * 0.5f));
        setEndY((((r8 - r6) / 2.0f) * ((float) Math.sin(Math.toRadians(r4)))) + ((r6 + r8) * 0.5f));
        return;
    L11:
        r3 = r2;
        goto L12
    L5:
        r11 = false;
        goto L7
    }

    public void applyToPath(Matrix r4, Path r5) {
        int r0 = this.operations.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        this.operations.get(r1).applyToPath(r4, r5);
        r1 = r1 + 1;
        goto L3
    }

    public boolean containsIncompatibleShadowOp() {
        return this.containsIncompatibleShadowOp;
    }

    @NonNull
    public ShadowCompatOperation createShadowCompatOperation(final Matrix r3) {
        addConnectingShadowIfNecessary(getEndShadowAngle());
        final ArrayList r0 = new ArrayList(this.shadowCompatOperations);
        return new AnonymousClass1(this, r0, r3);
    }

    @RequiresApi(21)
    public void cubicToPoint(float r9, float r10, float r11, float r12, float r13, float r14) {
        PathCubicOperation r7 = new PathCubicOperation(r9, r10, r11, r12, r13, r14);
        this.operations.add(r7);
        this.containsIncompatibleShadowOp = true;
        setEndX(r13);
        setEndY(r14);
    }

    public float getEndX() {
        return this.endX;
    }

    public float getEndY() {
        return this.endY;
    }

    public float getStartX() {
        return this.startX;
    }

    public float getStartY() {
        return this.startY;
    }

    public void lineTo(float r5, float r6) {
        PathLineOperation r0 = new PathLineOperation();
        PathLineOperation.access$002(r0, r5);
        PathLineOperation.access$102(r0, r6);
        this.operations.add(r0);
        LineShadowOperation r1 = new LineShadowOperation(r0, getEndX(), getEndY());
        addShadowCompatOperation(r1, r1.getAngle() + ANGLE_UP, r1.getAngle() + ANGLE_UP);
        setEndX(r5);
        setEndY(r6);
    }

    @RequiresApi(21)
    public void quadToPoint(float r2, float r3, float r4, float r5) {
        PathQuadOperation r0 = new PathQuadOperation();
        PathQuadOperation.access$200(r0, r2);
        PathQuadOperation.access$300(r0, r3);
        PathQuadOperation.access$400(r0, r4);
        PathQuadOperation.access$500(r0, r5);
        this.operations.add(r0);
        this.containsIncompatibleShadowOp = true;
        setEndX(r4);
        setEndY(r5);
    }

    public void reset(float r3, float r4) {
        reset(r3, r4, ANGLE_UP, 0.0f);
    }

    public void reset(float r1, float r2, float r3, float r4) {
        setStartX(r1);
        setStartY(r2);
        setEndX(r1);
        setEndY(r2);
        setCurrentShadowAngle(r3);
        setEndShadowAngle((r3 + r4) % 360.0f);
        this.operations.clear();
        this.shadowCompatOperations.clear();
        this.containsIncompatibleShadowOp = false;
    }

    public ShapePath(float r2, float r3) {
        this.operations = new ArrayList();
        this.shadowCompatOperations = new ArrayList();
        reset(r2, r3);
    }
}
