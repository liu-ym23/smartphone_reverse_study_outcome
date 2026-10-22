package com.obric.oui.sectiontitlebar;

import android.annotation.SuppressLint;
import android.widget.FrameLayout;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SuppressLint({"AppCompatCustomView"})
public final class OSectionSupportiveText extends FrameLayout {
    private final TextView getSectionDes() {
        throw null;
    }

    public final void setSectionDes(@NotNull String r2) {
        Intrinsics.f(r2, "sectionText");
        getSectionDes().setText(r2);
    }
}
