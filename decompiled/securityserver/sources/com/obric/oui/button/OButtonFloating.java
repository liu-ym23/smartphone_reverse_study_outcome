package com.obric.oui.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import com.bytedance.securityserver.R;
import com.obric.oui.text.OBaseTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class OButtonFloating extends OShadowFrame {
    public OBaseTextView u;

    @NotNull
    public final OBaseTextView getTextView() {
        OBaseTextView r0 = this.u;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.m("textView");
        throw null;
    }

    @NotNull
    public final TextView getTitleView() {
        OBaseTextView r0 = this.u;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.m("textView");
        throw null;
    }

    @Override // com.obric.oui.button.OShadowFrame
    public final void j(Context r6, FrameLayout r7, TypedArray r8) {
        Intrinsics.f(r6, "context");
        Intrinsics.f(r7, "contentView");
        CharSequence r0 = r8.getText(12);
        int r1 = r8.getResourceId(14, R.style.Button_2_Medium);
        int r9 = r8.getColor(13, getResources().getColor(R.color.oui_basic_text_1, null));
        OBaseTextView r2 = new OBaseTextView(r6, null, 6);
        r2.setTextAppearance(r1);
        r2.setTextColor(r9);
        r2.setText(r0);
        r2.setSingleLine();
        r2.setIncludeFontPadding(false);
        r2.setGravity(17);
        this.u = r2;
        FrameLayout.LayoutParams r5 = new FrameLayout.LayoutParams(-2, -2);
        r5.gravity = 17;
        r7.addView(r2, r5);
    }

    @Override // com.obric.oui.button.OShadowFrame
    public final void k(boolean r3) {
        super.k(r3);
        if (r3 == false) goto L9;
        OBaseTextView r2 = this.u;
        if (r2 == null) goto L7;
        r2.setAlpha(1.0f);
        return;
    L7:
        Intrinsics.m("textView");
        throw null;
    L9:
        OBaseTextView r4 = this.u;
        if (r4 == null) goto L13;
        r4.setAlpha(0.3f);
        return;
    L13:
        Intrinsics.m("textView");
        throw null;
    }

    public final void setTextView(@NotNull OBaseTextView r2) {
        Intrinsics.f(r2, "<set-?>");
        this.u = r2;
    }

    public final void setTitle(@NotNull CharSequence r2) {
        Intrinsics.f(r2, "text");
        OBaseTextView r1 = this.u;
        if (r1 == null) goto L6;
        r1.setText(r2);
        return;
    L6:
        Intrinsics.m("textView");
        throw null;
    }

    public final void setTitle(@StringRes int r1) {
        OBaseTextView r0 = this.u;
        if (r0 == null) goto L6;
        r0.setText(r1);
        return;
    L6:
        Intrinsics.m("textView");
        throw null;
    }
}
