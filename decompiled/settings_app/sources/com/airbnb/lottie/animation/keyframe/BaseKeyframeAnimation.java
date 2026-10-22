package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.L;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseKeyframeAnimation<K, A> {
    private float cachedEndProgress;
    private A cachedGetValue;
    private float cachedStartDelayProgress;
    private boolean isDiscrete;
    private final KeyframesWrapper<K> keyframesWrapper;
    final List<AnimationListener> listeners;
    private float progress;
    protected LottieValueCallback<A> valueCallback;

    /* JADX INFO: renamed from: com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public interface AnimationListener {
        void onValueChanged();
    }

    private static final class EmptyKeyframeWrapper<T> implements KeyframesWrapper<T> {
        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float getEndProgress() {
            return 1.0f;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float getStartDelayProgress() {
            return 0.0f;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isEmpty() {
            return true;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isValueChanged(float r1) {
            return false;
        }

        private EmptyKeyframeWrapper() {
        }

        /* synthetic */ EmptyKeyframeWrapper(AnonymousClass1 r1) {
            this();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public Keyframe<T> getCurrentKeyframe() {
            throw new IllegalStateException("not implemented");
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isCachedValueEnabled(float r1) {
            throw new IllegalStateException("not implemented");
        }
    }

    private interface KeyframesWrapper<T> {
        Keyframe<T> getCurrentKeyframe();

        float getEndProgress();

        float getStartDelayProgress();

        boolean isCachedValueEnabled(float r1);

        boolean isEmpty();

        boolean isValueChanged(float r1);
    }

    private static final class KeyframesWrapperImpl<T> implements KeyframesWrapper<T> {
        private Keyframe<T> cachedCurrentKeyframe;
        private float cachedInterpolatedProgress;
        private Keyframe<T> currentKeyframe;
        private final List<? extends Keyframe<T>> keyframes;

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isEmpty() {
            return false;
        }

        KeyframesWrapperImpl(List<? extends Keyframe<T>> r2) {
            this.cachedCurrentKeyframe = null;
            this.cachedInterpolatedProgress = -1.0f;
            this.keyframes = r2;
            this.currentKeyframe = findKeyframe(0.0f);
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isValueChanged(float r3) {
            if (this.currentKeyframe.containsProgress(r3) == true) goto L5;
            this.currentKeyframe = findKeyframe(r3);
            return true;
        L5:
            return !this.currentKeyframe.isStatic();
        }

        private Keyframe<T> findKeyframe(float r5) {
            List<? extends Keyframe<T>> r0 = this.keyframes;
            Keyframe<T> r1 = r0.get(r0.size() - 1);
            if (r5 < r1.getStartProgress()) goto L5;
            return r1;
        L5:
            int r2 = this.keyframes.size() - 2;
        L6:
            if (r2 < 1) goto L15;
            Keyframe<T> r3 = this.keyframes.get(r2);
            if (this.currentKeyframe == r3) goto L13;
            if (r3.containsProgress(r5) == false) goto L13;
            return r3;
        L13:
            r2 = r2 - 1;
            goto L6
        L15:
            return this.keyframes.get(0);
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public Keyframe<T> getCurrentKeyframe() {
            return this.currentKeyframe;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float getStartDelayProgress() {
            return this.keyframes.get(0).getStartProgress();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float getEndProgress() {
            List<? extends Keyframe<T>> r1 = this.keyframes;
            return r1.get(r1.size() - 1).getEndProgress();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isCachedValueEnabled(float r3) {
            Keyframe<T> r0 = this.cachedCurrentKeyframe;
            Keyframe<T> r1 = this.currentKeyframe;
            if (r0 == r1) goto L5;
        L8:
            this.cachedCurrentKeyframe = r1;
            this.cachedInterpolatedProgress = r3;
            return false;
        L5:
            if (this.cachedInterpolatedProgress != r3) goto L8;
            return true;
        }
    }

    private static final class SingleKeyframeWrapper<T> implements KeyframesWrapper<T> {
        private float cachedInterpolatedProgress;
        private final Keyframe<T> keyframe;

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isEmpty() {
            return false;
        }

        SingleKeyframeWrapper(List<? extends Keyframe<T>> r2) {
            this.cachedInterpolatedProgress = -1.0f;
            this.keyframe = r2.get(0);
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isValueChanged(float r1) {
            return !this.keyframe.isStatic();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public Keyframe<T> getCurrentKeyframe() {
            return this.keyframe;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float getStartDelayProgress() {
            return this.keyframe.getStartProgress();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float getEndProgress() {
            return this.keyframe.getEndProgress();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isCachedValueEnabled(float r2) {
            if (this.cachedInterpolatedProgress != r2) goto L6;
            return true;
        L6:
            this.cachedInterpolatedProgress = r2;
            return false;
        }
    }

    abstract A getValue(Keyframe<K> r1, float r2);

    BaseKeyframeAnimation(List<? extends Keyframe<K>> r3) {
        this.listeners = new ArrayList(1);
        this.isDiscrete = false;
        this.progress = 0.0f;
        this.cachedGetValue = null;
        this.cachedStartDelayProgress = -1.0f;
        this.cachedEndProgress = -1.0f;
        this.keyframesWrapper = wrap(r3);
    }

    public void setIsDiscrete() {
        this.isDiscrete = true;
    }

    public void addUpdateListener(AnimationListener r1) {
        this.listeners.add(r1);
    }

    public void setProgress(float r2) {
        if (this.keyframesWrapper.isEmpty() == false) goto L6;
        return;
    L6:
        if (r2 >= getStartDelayProgress()) goto L9;
        r2 = getStartDelayProgress();
    L12:
        if (r2 != this.progress) goto L14;
        return;
    L14:
        this.progress = r2;
        if (this.keyframesWrapper.isValueChanged(r2) == false) goto L18;
        notifyListeners();
        return;
    L18:
        return;
    L9:
        if (r2 <= getEndProgress()) goto L12;
        r2 = getEndProgress();
        goto L12
    }

    public void notifyListeners() {
        int r0 = 0;
    L4:
        if (r0 >= this.listeners.size()) goto L6;
        this.listeners.get(r0).onValueChanged();
        r0 = r0 + 1;
        goto L4
    }

    protected Keyframe<K> getCurrentKeyframe() {
        L.beginSection("BaseKeyframeAnimation#getCurrentKeyframe");
        Keyframe<K> r1 = this.keyframesWrapper.getCurrentKeyframe();
        L.endSection("BaseKeyframeAnimation#getCurrentKeyframe");
        return r1;
    }

    float getLinearCurrentKeyframeProgress() {
        if (this.isDiscrete == false) goto L5;
        return 0.0f;
    L5:
        Keyframe<K> r0 = getCurrentKeyframe();
        if (r0.isStatic() == false) goto L9;
        return 0.0f;
    L9:
        return (this.progress - r0.getStartProgress()) / (r0.getEndProgress() - r0.getStartProgress());
    }

    protected float getInterpolatedCurrentKeyframeProgress() {
        Keyframe<K> r0 = getCurrentKeyframe();
        if (r0.isStatic() == false) goto L7;
        return 0.0f;
    L7:
        return r0.interpolator.getInterpolation(getLinearCurrentKeyframeProgress());
    }

    private float getStartDelayProgress() {
        if (this.cachedStartDelayProgress != (-1.0f)) goto L6;
        this.cachedStartDelayProgress = this.keyframesWrapper.getStartDelayProgress();
    L6:
        return this.cachedStartDelayProgress;
    }

    float getEndProgress() {
        if (this.cachedEndProgress != (-1.0f)) goto L6;
        this.cachedEndProgress = this.keyframesWrapper.getEndProgress();
    L6:
        return this.cachedEndProgress;
    }

    public A getValue() {
        float r0 = getInterpolatedCurrentKeyframeProgress();
        if (this.valueCallback == null) goto L5;
    L8:
        A r1 = getValue(getCurrentKeyframe(), r0);
        this.cachedGetValue = r1;
        return r1;
    L5:
        if (this.keyframesWrapper.isCachedValueEnabled(r0) == false) goto L8;
        return this.cachedGetValue;
    }

    public float getProgress() {
        return this.progress;
    }

    public void setValueCallback(LottieValueCallback<A> r3) {
        LottieValueCallback<A> r0 = this.valueCallback;
        if (r0 == null) goto L5;
        r0.setAnimation(null);
    L5:
        this.valueCallback = r3;
        if (r3 == null) goto L9;
        r3.setAnimation(this);
        return;
    }

    private static <T> KeyframesWrapper<T> wrap(List<? extends Keyframe<T>> r2) {
        if (r2.isEmpty() == false) goto L7;
        return new EmptyKeyframeWrapper(null);
    L7:
        if (r2.size() != 1) goto L11;
        return new SingleKeyframeWrapper(r2);
    L11:
        return new KeyframesWrapperImpl(r2);
    }
}
