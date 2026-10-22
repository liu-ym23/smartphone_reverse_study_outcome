package com.airbnb.lottie.animation;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.LocaleList;

/* JADX INFO: loaded from: classes.dex */
public class LPaint extends Paint {
    @Override // android.graphics.Paint
    public void setTextLocales(LocaleList r1) {
    }

    public LPaint() {
    }

    public LPaint(int r1) {
        super(r1);
    }

    public LPaint(PorterDuff.Mode r2) {
        setXfermode(new PorterDuffXfermode(r2));
    }

    public LPaint(int r1, PorterDuff.Mode r2) {
        super(r1);
        setXfermode(new PorterDuffXfermode(r2));
    }
}
