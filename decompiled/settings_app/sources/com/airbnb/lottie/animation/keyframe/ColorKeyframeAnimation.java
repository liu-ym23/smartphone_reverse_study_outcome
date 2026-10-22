package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.GammaEvaluator;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ColorKeyframeAnimation extends KeyframeAnimation<Integer> {
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* bridge */ /* synthetic */ Object getValue(Keyframe r1, float r2) {
        return getValue(r1, r2);
    }

    public ColorKeyframeAnimation(List<Keyframe<Integer>> r1) {
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
    public int getIntValue(Keyframe<Integer> r12, float r13) {
        if (r12.startValue == null) goto L15;
        if (r12.endValue == null) goto L15;
        int r0 = r12.startValue.intValue();
        int r1 = r12.endValue.intValue();
        if (this.valueCallback == null) goto L13;
        Integer r11 = (Integer) this.valueCallback.getValueInternal(r12.startFrame, r12.endFrame.floatValue(), Integer.valueOf(r0), Integer.valueOf(r1), r13, getLinearCurrentKeyframeProgress(), getProgress());
        if (r11 == null) goto L13;
        return r11.intValue();
    L13:
        return GammaEvaluator.evaluate(MiscUtils.clamp(r13, 0.0f, 1.0f), r0, r1);
    L15:
        throw new IllegalStateException("Missing values for keyframe.");
    }

    public int getIntValue() {
        return getIntValue(getCurrentKeyframe(), getInterpolatedCurrentKeyframeProgress());
    }
}
