package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.ShapeGroup;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ShapeLayer extends BaseLayer {
    private final ContentGroup contentGroup;

    ShapeLayer(LottieDrawable r4, Layer r5) {
        super(r4, r5);
        ContentGroup r6 = new ContentGroup(r4, this, new ShapeGroup("__container", r5.getShapes(), false));
        this.contentGroup = r6;
        r6.setContents(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    void drawLayer(Canvas r1, Matrix r2, int r3) {
        this.contentGroup.draw(r1, r2, r3);
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF r1, Matrix r2, boolean r3) {
        super.getBounds(r1, r2, r3);
        this.contentGroup.getBounds(r1, this.boundsMatrix, r3);
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    protected void resolveChildKeyPath(KeyPath r1, int r2, List<KeyPath> r3, KeyPath r4) {
        this.contentGroup.resolveKeyPath(r1, r2, r3, r4);
    }
}
