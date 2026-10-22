package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.model.content.ShapePath;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ShapeContent implements PathContent, BaseKeyframeAnimation.AnimationListener {
    private final boolean hidden;
    private boolean isPathValid;
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final Path path;
    private final BaseKeyframeAnimation<?, Path> shapeAnimation;
    private CompoundTrimPathContent trimPaths;

    public ShapeContent(LottieDrawable r2, BaseLayer r3, ShapePath r4) {
        this.path = new Path();
        this.trimPaths = new CompoundTrimPathContent();
        this.name = r4.getName();
        this.hidden = r4.isHidden();
        this.lottieDrawable = r2;
        BaseKeyframeAnimation<ShapeData, Path> r5 = r4.getShapePath().createAnimation();
        this.shapeAnimation = r5;
        r3.addAnimation(r5);
        r5.addUpdateListener(this);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        invalidate();
    }

    private void invalidate() {
        this.isPathValid = false;
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> r4, List<Content> r5) {
        int r6 = 0;
    L4:
        if (r6 >= r4.size()) goto L11;
        Content r0 = r4.get(r6);
        if ((r0 instanceof TrimPathContent) == false) goto L10;
        TrimPathContent r1 = (TrimPathContent) r0;
        if (r1.getType() != ShapeTrimPath.Type.SIMULTANEOUSLY) goto L10;
        this.trimPaths.addTrimPath(r1);
        r1.addListener(this);
    L10:
        r6 = r6 + 1;
        goto L4
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path getPath() {
        if (this.isPathValid == true) goto L5;
        this.path.reset();
        if (this.hidden == false) goto L10;
        this.isPathValid = true;
        return this.path;
    L10:
        this.path.set(this.shapeAnimation.getValue());
        this.path.setFillType(Path.FillType.EVEN_ODD);
        this.trimPaths.apply(this.path);
        this.isPathValid = true;
        return this.path;
    L5:
        return this.path;
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.name;
    }
}
