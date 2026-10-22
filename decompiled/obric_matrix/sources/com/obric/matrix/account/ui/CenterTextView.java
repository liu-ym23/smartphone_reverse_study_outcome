package com.obric.matrix.account.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes2.dex */
public class CenterTextView extends View {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f8743j = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Paint f8744f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Paint f8745g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Rect f8746h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f8747i;

    static {
        f8743j = Color.parseColor("#FF4081");
    }

    public CenterTextView(Context r1, @Nullable AttributeSet r2) {
        super(r1, r2);
        a();
    }

    private void a() {
        Paint r0 = new Paint(1);
        this.f8744f = r0;
        r0.setTextSize(48.0f);
        this.f8744f.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f8744f.setTextAlign(Paint.Align.CENTER);
        Paint r1 = new Paint(1);
        this.f8745g = r1;
        r1.setColor(f8743j);
        this.f8746h = new Rect();
    }

    @Override // android.view.View
    protected void onDraw(Canvas r4) {
        super.onDraw(r4);
        int r0 = getWidth();
        int r1 = getHeight();
        Rect r2 = this.f8746h;
        int r3 = (r0 / 2) - 32;
        r2.left = r3;
        int r5 = (r1 / 2) - 32;
        r2.top = r5;
        r2.right = r3 + 64;
        r2.bottom = r5 + 64;
        r4.drawRect(r2, this.f8745g);
        r4.drawText(this.f8747i, this.f8746h.centerX(), this.f8746h.centerY() + 24, this.f8744f);
    }

    public void setText(String r1) {
        this.f8747i = r1;
        invalidate();
    }
}
