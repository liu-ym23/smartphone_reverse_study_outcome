package com.obric.oui.infopanel.content;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OInfoPanelContentEntranceView extends ConstraintLayout {
    public static final /* synthetic */ int b = 0;

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        post(new AnonymousClass1(this));
    }

    public final void setEntranceText(@NotNull CharSequence r1) {
        Intrinsics.f(r1, "text");
        throw null;
    }
}
