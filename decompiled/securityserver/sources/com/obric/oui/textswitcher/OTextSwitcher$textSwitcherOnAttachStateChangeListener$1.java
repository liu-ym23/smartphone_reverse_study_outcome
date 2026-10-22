package com.obric.oui.textswitcher;

import android.view.View;
import com.obric.oui.common.util.ToolsExtKt;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OTextSwitcher$textSwitcherOnAttachStateChangeListener$1 implements View.OnAttachStateChangeListener {
    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r1) {
        Intrinsics.f(r1, BaseSwitches.V);
        ToolsExtKt.a("the o textview switcher component had attach to window");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r1) {
        Intrinsics.f(r1, BaseSwitches.V);
        ToolsExtKt.a("the o textview switcher component had detach to window");
        throw null;
    }
}
