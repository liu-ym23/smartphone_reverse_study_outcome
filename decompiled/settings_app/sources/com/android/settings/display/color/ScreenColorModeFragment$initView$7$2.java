package com.android.settings.display.color;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: ScreenColorModeFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* synthetic */ class ScreenColorModeFragment$initView$7$2 extends FunctionReferenceImpl implements Function3<Float, Float, Boolean, Unit> {
    ScreenColorModeFragment$initView$7$2(Object r8) {
        super(3, r8, ScreenColorModeViewModel.class, "updateTemperature", "updateTemperature(FFZ)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Float r1, Float r2, Boolean r3) {
        invoke(r1.floatValue(), r2.floatValue(), r3.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(float r1, float r2, boolean r3) {
        ((ScreenColorModeViewModel) this.receiver).updateTemperature(r1, r2, r3);
    }
}
