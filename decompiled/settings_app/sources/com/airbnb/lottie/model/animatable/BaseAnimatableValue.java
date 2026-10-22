package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.value.Keyframe;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
abstract class BaseAnimatableValue<V, O> implements AnimatableValue<V, O> {
    final List<Keyframe<V>> keyframes;

    BaseAnimatableValue(V r2) {
        this(Collections.singletonList(new Keyframe(r2)));
    }

    BaseAnimatableValue(List<Keyframe<V>> r1) {
        this.keyframes = r1;
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public List<Keyframe<V>> getKeyframes() {
        return this.keyframes;
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public boolean isStatic() {
        if (this.keyframes.isEmpty() == false) goto L5;
        return true;
    L5:
        if (this.keyframes.size() != 1) goto L10;
        if (this.keyframes.get(0).isStatic() == false) goto L10;
        return true;
    L10:
        return false;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.keyframes.isEmpty() == true) goto L6;
        r0.append("values=").append(Arrays.toString(this.keyframes.toArray()));
    L6:
        return r0.toString();
    }
}
