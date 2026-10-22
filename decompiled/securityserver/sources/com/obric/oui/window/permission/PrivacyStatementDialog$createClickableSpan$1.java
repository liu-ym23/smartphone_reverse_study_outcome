package com.obric.oui.window.permission;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.bytedance.securityserver.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class PrivacyStatementDialog$createClickableSpan$1 extends ClickableSpan {
    @Override // android.text.style.ClickableSpan
    public final void onClick(View r1) {
        Intrinsics.f(r1, "widget");
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r2) {
        Intrinsics.f(r2, "ds");
        super.updateDrawState(r2);
        r2.setColor(ContextCompat.getColor(null, R.color.oui_fill_highlighted));
        r2.setUnderlineText(false);
    }
}
