package com.bytedance.feedbackerlib.matisse.internal.ui.widget;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.feedbackerlib.d;

/* JADX INFO: loaded from: classes.dex */
public class CheckRadioView extends AppCompatImageView {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Drawable f4421f;

    public CheckRadioView(Context r1, AttributeSet r2) {
        super(r1, r2);
        f();
    }

    private void f() {
        setChecked(false);
    }

    public void setChecked(boolean r1) {
        if (r1 == false) goto L4;
        setImageResource(d.q);
        return;
    L4:
        setImageResource(d.p);
        setColor(-5592406);
    }

    public void setColor(int r2) {
        if (this.f4421f != null) goto L5;
        this.f4421f = getDrawable();
    L5:
        this.f4421f.setColorFilter(r2, PorterDuff.Mode.SRC_IN);
    }
}
