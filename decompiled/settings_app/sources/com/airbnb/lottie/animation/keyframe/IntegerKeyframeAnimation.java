package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class IntegerKeyframeAnimation extends KeyframeAnimation<Integer> {
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* bridge */ /* synthetic */ Object getValue(Keyframe r1, float r2) {
        return getValue(r1, r2);
    }

    public IntegerKeyframeAnimation(List<Keyframe<Integer>> r1) {
        super(r1);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    Integer getValue(Keyframe<Integer> r1, float r2) {
        return Integer.valueOf(getIntValue(r1, r2));
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    int getIntValue(Keyframe<Integer> r10, float r11) {
        if (r10.startValue == null) goto L15;
        if (r10.endValue == null) goto L15;
        if (this.valueCallback == null) goto L13;
        Integer r9 = (Integer) this.valueCallback.getValueInternal(r10.startFrame, r10.endFrame.floatValue(), r10.startValue, r10.endValue, r11, getLinearCurrentKeyframeProgress(), getProgress());
        if (r9 == null) goto L13;
        return r9.intValue();
    L13:
        return MiscUtils.lerp(r10.getStartValueInt(), r10.getEndValueInt(), r11);
    L15:
        throw new IllegalStateException("Missing values for keyframe.");
    }

    public int getIntValue() {
        return getIntValue(getCurrentKeyframe(), getInterpolatedCurrentKeyframeProgress());
    }
}
