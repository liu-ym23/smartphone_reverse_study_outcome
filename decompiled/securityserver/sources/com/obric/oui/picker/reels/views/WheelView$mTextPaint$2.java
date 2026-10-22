package com.obric.oui.picker.reels.views;

import android.text.TextPaint;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class WheelView$mTextPaint$2 extends Lambda implements Function0<TextPaint> {
    public static final WheelView$mTextPaint$2 b = null;

    static {
        b = new WheelView$mTextPaint$2(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        TextPaint r1 = new TextPaint();
        r1.setAntiAlias(true);
        return r1;
    }
}
