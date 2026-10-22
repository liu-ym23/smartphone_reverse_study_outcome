package com.airbnb.lottie.animation.content;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class TrimPathContent implements Content, BaseKeyframeAnimation.AnimationListener {
    private final BaseKeyframeAnimation<?, Float> endAnimation;
    private final boolean hidden;
    private final List<BaseKeyframeAnimation.AnimationListener> listeners;
    private final String name;
    private final BaseKeyframeAnimation<?, Float> offsetAnimation;
    private final BaseKeyframeAnimation<?, Float> startAnimation;
    private final ShapeTrimPath.Type type;

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> r1, List<Content> r2) {
    }

    public TrimPathContent(BaseLayer r3, ShapeTrimPath r4) {
        this.listeners = new ArrayList();
        this.name = r4.getName();
        this.hidden = r4.isHidden();
        this.type = r4.getType();
        BaseKeyframeAnimation<Float, Float> r0 = r4.getStart().createAnimation();
        this.startAnimation = r0;
        BaseKeyframeAnimation<Float, Float> r1 = r4.getEnd().createAnimation();
        this.endAnimation = r1;
        BaseKeyframeAnimation<Float, Float> r5 = r4.getOffset().createAnimation();
        this.offsetAnimation = r5;
        r3.addAnimation(r0);
        r3.addAnimation(r1);
        r3.addAnimation(r5);
        r0.addUpdateListener(this);
        r1.addUpdateListener(this);
        r5.addUpdateListener(this);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        int r0 = 0;
    L4:
        if (r0 >= this.listeners.size()) goto L6;
        this.listeners.get(r0).onValueChanged();
        r0 = r0 + 1;
        goto L4
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.name;
    }

    void addListener(BaseKeyframeAnimation.AnimationListener r1) {
        this.listeners.add(r1);
    }

    ShapeTrimPath.Type getType() {
        return this.type;
    }

    public BaseKeyframeAnimation<?, Float> getStart() {
        return this.startAnimation;
    }

    public BaseKeyframeAnimation<?, Float> getEnd() {
        return this.endAnimation;
    }

    public BaseKeyframeAnimation<?, Float> getOffset() {
        return this.offsetAnimation;
    }

    public boolean isHidden() {
        return this.hidden;
    }
}
