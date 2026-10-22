package com.obric.oui.titlebar.optimize;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.obric.common.oui.g;
import com.obric.oui.button.OButton;
import java.util.Objects;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static final OButton a(OCTitleBar r1, Context r2, int r3) {
        o.f(r1, "$this$createButton");
        o.f(r2, "context");
        View r4 = LayoutInflater.from(r2).inflate(r3, r1, false);
        Objects.requireNonNull(r4, "null cannot be cast to non-null type com.obric.oui.button.OButton");
        return (OButton) r4;
    }

    public static final OButton b(OCTitleBar r1, Context r2) {
        o.f(r1, "$this$createTransIconButton");
        o.f(r2, "context");
        return a(r1, r2, g.G);
    }
}
