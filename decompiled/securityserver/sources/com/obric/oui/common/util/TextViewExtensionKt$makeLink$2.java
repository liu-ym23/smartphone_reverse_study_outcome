package com.obric.oui.common.util;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class TextViewExtensionKt$makeLink$2 extends ClickableSpan {
    @Override // android.text.style.ClickableSpan
    public final void onClick(View r1) {
        Intrinsics.f(r1, "widget");
        throw null;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r2) {
        Intrinsics.f(r2, "ds");
        super.updateDrawState(r2);
        r2.setUnderlineText(false);
        throw null;
    }
}
