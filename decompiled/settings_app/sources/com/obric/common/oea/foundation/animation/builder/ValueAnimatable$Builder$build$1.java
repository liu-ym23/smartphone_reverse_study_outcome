package com.obric.common.oea.foundation.animation.builder;

import com.obric.common.oea.foundation.animation.command.AnimationCommand;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: compiled from: ValueAnimatable.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ValueAnimatable$Builder$build$1 extends MutablePropertyReference0Impl {
    ValueAnimatable$Builder$build$1(ValueAnimatable.Builder r7) {
        super(r7, ValueAnimatable.Builder.class, "valueAnimationCommand", "getValueAnimationCommand()Lcom/obric/common/oea/foundation/animation/command/AnimationCommand;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return ValueAnimatable.Builder.access$getValueAnimationCommand$p((ValueAnimatable.Builder) this.receiver);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r1) {
        ValueAnimatable.Builder.access$setValueAnimationCommand$p((ValueAnimatable.Builder) this.receiver, (AnimationCommand) r1);
    }
}
