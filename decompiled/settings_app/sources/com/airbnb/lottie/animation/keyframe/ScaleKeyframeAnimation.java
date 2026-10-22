package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.ScaleXY;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ScaleKeyframeAnimation extends KeyframeAnimation<ScaleXY> {
    private final ScaleXY scaleXY;

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public /* bridge */ /* synthetic */ Object getValue(Keyframe r1, float r2) {
        return getValue(r1, r2);
    }

    public ScaleKeyframeAnimation(List<Keyframe<ScaleXY>> r1) {
        super(r1);
        this.scaleXY = new ScaleXY();
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
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public ScaleXY getValue(Keyframe<ScaleXY> r11, float r12) {
        if (r11.startValue == null) goto L14;
        if (r11.endValue == null) goto L14;
        ScaleXY r0 = r11.startValue;
        ScaleXY r9 = r11.endValue;
        if (this.valueCallback == null) goto L11;
        ScaleXY r13 = (ScaleXY) this.valueCallback.getValueInternal(r11.startFrame, r11.endFrame.floatValue(), r0, r9, r12, getLinearCurrentKeyframeProgress(), getProgress());
        if (r13 == null) goto L11;
        return r13;
    L11:
        this.scaleXY.set(MiscUtils.lerp(r0.getScaleX(), r9.getScaleX(), r12), MiscUtils.lerp(r0.getScaleY(), r9.getScaleY(), r12));
        return this.scaleXY;
    L14:
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
