package com.obric.oui.stepper;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class OSteppers$registerInputFilter$1 implements InputFilterMinMax.FilterListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OSteppers f287a;

    public OSteppers$registerInputFilter$1(OSteppers r1) {
        this.f287a = r1;
    }

    @Override // com.obric.oui.stepper.InputFilterMinMax.FilterListener
    public final void a(int r1) {
        OSteppers.OnValueChangeListener r0 = this.f287a.getOnValueChangeListener();
        if (r0 == null) goto L6;
        r0.a();
        return;
    }
}
