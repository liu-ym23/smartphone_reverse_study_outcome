package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Layout;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class DialogTitle extends AppCompatTextView {
    public DialogTitle(@NonNull Context r1, @Nullable AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int r7, int r8) {
        super.onMeasure(r7, r8);
        Layout r0 = getLayout();
        if (r0 == null) goto L13;
        int r1 = r0.getLineCount();
        if (r1 > 0) goto L7;
        return;
    L7:
        if (r0.getEllipsisCount(r1 - 1) <= 0) goto L15;
        setSingleLine(false);
        setMaxLines(2);
        TypedArray r2 = getContext().obtainStyledAttributes(null, R.styleable.TextAppearance, android.R.attr.textAppearanceMedium, android.R.style.TextAppearance.Medium);
        int r3 = r2.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, 0);
        if (r3 == 0) goto L11;
        setTextSize(0, r3);
    L11:
        r2.recycle();
        super.onMeasure(r7, r8);
        return;
    L15:
        return;
    }

    public DialogTitle(@NonNull Context r1, @Nullable AttributeSet r2) {
        super(r1, r2);
    }

    public DialogTitle(@NonNull Context r1) {
        super(r1);
    }
}
