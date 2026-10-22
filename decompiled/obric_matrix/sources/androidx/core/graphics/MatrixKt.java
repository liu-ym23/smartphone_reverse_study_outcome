package androidx.core.graphics;

import android.graphics.Matrix;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u0014\n\u0000\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u001a\u001a\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003\u001a\u001a\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u001a\u0015\u0010\f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0086\n\u001a\r\u0010\u000e\u001a\u00020\u000f*\u00020\u0001H\u0086\b¨\u0006\u0010"}, d2 = {"rotationMatrix", "Landroid/graphics/Matrix;", "degrees", "", "px", "py", "scaleMatrix", "sx", "sy", "translationMatrix", "tx", "ty", "times", "m", "values", "", "core-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class MatrixKt {
    public static final Matrix rotationMatrix(float r1, float r2, float r3) {
        Matrix r0 = new Matrix();
        r0.setRotate(r1, r2, r3);
        return r0;
    }

    public static /* synthetic */ Matrix rotationMatrix$default(float r1, float r2, float r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = 0.0f;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = 0.0f;
    L9:
        return rotationMatrix(r1, r2, r3);
    }

    public static final Matrix scaleMatrix(float r1, float r2) {
        Matrix r0 = new Matrix();
        r0.setScale(r1, r2);
        return r0;
    }

    public static /* synthetic */ Matrix scaleMatrix$default(float r1, float r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = 1.0f;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = 1.0f;
    L9:
        return scaleMatrix(r1, r2);
    }

    public static final Matrix times(Matrix r1, Matrix r2) {
        o.f(r1, "<this>");
        o.f(r2, "m");
        Matrix r0 = new Matrix(r1);
        r0.preConcat(r2);
        return r0;
    }

    public static final Matrix translationMatrix(float r1, float r2) {
        Matrix r0 = new Matrix();
        r0.setTranslate(r1, r2);
        return r0;
    }

    public static /* synthetic */ Matrix translationMatrix$default(float r1, float r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = 0.0f;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = 0.0f;
    L9:
        return translationMatrix(r1, r2);
    }

    public static final float[] values(Matrix r1) {
        o.f(r1, "<this>");
        float[] r0 = new float[9];
        r1.getValues(r0);
        return r0;
    }
}
