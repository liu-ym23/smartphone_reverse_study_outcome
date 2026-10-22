package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;

/* JADX INFO: loaded from: classes.dex */
public class NullLayer extends BaseLayer {
    @Override // com.airbnb.lottie.model.layer.BaseLayer
    void drawLayer(Canvas r1, Matrix r2, int r3) {
    }

    NullLayer(LottieDrawable r1, Layer r2) {
        super(r1, r2);
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF r1, Matrix r2, boolean r3) {
        super.getBounds(r1, r2, r3);
        r1.set(0.0f, 0.0f, 0.0f, 0.0f);
    }
}
