package com.android.settingslib.widget;

import android.content.Context;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class LinkTextView extends TextView {
    public LinkTextView(Context r2) {
        this(r2, null);
    }

    public LinkTextView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence r3, TextView.BufferType r4) {
        super.setText(r3, r4);
        if ((r3 instanceof Spanned) == true) goto L5;
        return;
    L5:
        if (((ClickableSpan[]) ((Spanned) r3).getSpans(0, r3.length(), ClickableSpan.class)).length <= 0) goto L9;
        setMovementMethod(LinkMovementMethod.getInstance());
        return;
    }
}
