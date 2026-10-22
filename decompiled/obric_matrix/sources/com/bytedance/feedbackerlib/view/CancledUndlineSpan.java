package com.bytedance.feedbackerlib.view;

import android.text.TextPaint;
import android.text.style.UnderlineSpan;

/* JADX INFO: loaded from: classes.dex */
public class CancledUndlineSpan extends UnderlineSpan {
    public CancledUndlineSpan() {
    }

    @Override // android.text.style.UnderlineSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint r1) {
        r1.setUnderlineText(false);
    }
}
