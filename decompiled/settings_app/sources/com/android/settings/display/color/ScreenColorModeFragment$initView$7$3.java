package com.android.settings.display.color;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScreenColorModeFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* synthetic */ class ScreenColorModeFragment$initView$7$3 extends FunctionReferenceImpl implements Function1<ScreenColorModeViewModel.TemperatureMode, Unit> {
    ScreenColorModeFragment$initView$7$3(Object r8) {
        super(1, r8, ScreenColorModeViewModel.class, "updateCurrentTemperatureMode", "updateCurrentTemperatureMode(Lcom/android/settings/display/color/ScreenColorModeViewModel$TemperatureMode;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ScreenColorModeViewModel.TemperatureMode r1) {
        invoke2(r1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ScreenColorModeViewModel.TemperatureMode r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        ((ScreenColorModeViewModel) this.receiver).updateCurrentTemperatureMode(r2);
    }
}
