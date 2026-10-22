package com.obric.oui.forms;

import a.a;
import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OInputLayout$resetInputContainerCorner$1 extends ViewOutlineProvider {
    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r7, Outline r8) {
        Intrinsics.f(r7, "view");
        Intrinsics.f(r8, "outline");
        r8.setRoundRect(0, 0, r7.getWidth(), r7.getHeight(), a.d("Resources.getSystem()", 1, 16));
    }
}
