package com.android.settings.utils;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

/* JADX INFO: loaded from: classes2.dex */
public class StringClickBuilder {
    final SpannableStringBuilder mBuilder;
    final String mFullText;
    final TextView mView;

    public StringClickBuilder(TextView r2) {
        this(String.valueOf(r2.getText()), r2);
    }

    public StringClickBuilder(int r2, TextView r3) {
        this(r3.getContext().getString(r2), r3);
    }

    public StringClickBuilder(String r2, TextView r3) {
        this.mBuilder = new SpannableStringBuilder(r2);
        this.mFullText = r2;
        this.mView = r3;
    }

    public StringClickBuilder onClick(int r2, final int r3, final View.OnClickListener r4) {
        return setClickSpan(this.mView.getContext().getString(r2), new AnonymousClass1(this, r4, r3));
    }

    public StringClickBuilder setClickSpan(String r4, ClickableSpan r5) {
        int r0 = this.mFullText.indexOf(r4);
        if (r0 < 0) goto L5;
        int r6 = r4.length() + r0;
        this.mBuilder.setSpan(r5, r0, r6, 33);
    L5:
        return this;
    }

    public Spanned build() {
        return this.mBuilder;
    }
}
