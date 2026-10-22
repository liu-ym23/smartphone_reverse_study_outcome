package com.bytedance.feedbackerlib.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;

/* JADX INFO: loaded from: classes.dex */
public class CustomEditText extends AppCompatEditText {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private a f4665f;

    public interface a {
        boolean a(int r1, int r2, int[] r3);
    }

    public CustomEditText(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.f4665f = null;
    }

    @Override // android.widget.TextView
    protected void onSelectionChanged(int r3, int r4) {
        a r0 = this.f4665f;
        if (r0 == null) goto L8;
        int[] r1 = new int[2];
        if (r0.a(r3, r4, r1) == false) goto L8;
        setSelection(r1[0], r1[1]);
        return;
    L8:
        super.onSelectionChanged(r3, r4);
    }

    public void setOnSelectionChangedListener(@Nullable a r1) {
        this.f4665f = r1;
    }
}
