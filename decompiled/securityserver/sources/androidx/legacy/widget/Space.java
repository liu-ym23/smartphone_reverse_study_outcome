package androidx.legacy.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class Space extends View {
    @Deprecated
    public Space(@NonNull Context r1, @Nullable AttributeSet r2, int r3) {
        super(r1, r2, r3);
        if (getVisibility() != 0) goto L6;
        setVisibility(4);
        return;
    }

    private static int getDefaultSize2(int r2, int r3) {
        int r0 = View.MeasureSpec.getMode(r3);
        int r4 = View.MeasureSpec.getSize(r3);
        if (r0 == Integer.MIN_VALUE) goto L9;
        if (r0 == 1073741824) goto L10;
        return r2;
    L10:
        return r4;
    L9:
        return Math.min(r2, r4);
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    @Deprecated
    public void draw(Canvas r1) {
    }

    @Override // android.view.View
    @Deprecated
    public void onMeasure(int r2, int r3) {
        setMeasuredDimension(getDefaultSize2(getSuggestedMinimumWidth(), r2), getDefaultSize2(getSuggestedMinimumHeight(), r3));
    }

    @Deprecated
    public Space(@NonNull Context r2, @Nullable AttributeSet r3) {
        this(r2, r3, 0);
    }

    @Deprecated
    public Space(@NonNull Context r2) {
        this(r2, null);
    }
}
