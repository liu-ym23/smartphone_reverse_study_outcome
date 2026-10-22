package com.google.android.material.animation;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class ImageMatrixProperty extends Property<ImageView, Matrix> {
    private final Matrix matrix;

    public ImageMatrixProperty() {
        super(Matrix.class, "imageMatrixProperty");
        this.matrix = new Matrix();
    }

    @Override // android.util.Property
    @NonNull
    public /* bridge */ /* synthetic */ Matrix get(@NonNull ImageView r1) {
        return get2(r1);
    }

    @Override // android.util.Property
    public /* bridge */ /* synthetic */ void set(@NonNull ImageView r1, @NonNull Matrix r2) {
        set2(r1, r2);
    }

    @NonNull
    /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
    public Matrix get2(@NonNull ImageView r2) {
        this.matrix.set(r2.getImageMatrix());
        return this.matrix;
    }

    /* JADX INFO: renamed from: set, reason: avoid collision after fix types in other method */
    public void set2(@NonNull ImageView r1, @NonNull Matrix r2) {
        r1.setImageMatrix(r2);
    }
}
