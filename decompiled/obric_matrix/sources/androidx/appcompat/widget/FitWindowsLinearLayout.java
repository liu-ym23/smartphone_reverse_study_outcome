package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class FitWindowsLinearLayout extends LinearLayout implements FitWindowsViewGroup {
    private FitWindowsViewGroup.OnFitSystemWindowsListener mListener;

    public FitWindowsLinearLayout(@NonNull Context r1) {
        super(r1);
    }

    public FitWindowsLinearLayout(@NonNull Context r1, @Nullable AttributeSet r2) {
        super(r1, r2);
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect r2) {
        FitWindowsViewGroup.OnFitSystemWindowsListener r0 = this.mListener;
        if (r0 == null) goto L6;
        r0.onFitSystemWindows(r2);
    L6:
        return super.fitSystemWindows(r2);
    }

    @Override // androidx.appcompat.widget.FitWindowsViewGroup
    public void setOnFitSystemWindowsListener(FitWindowsViewGroup.OnFitSystemWindowsListener r1) {
        this.mListener = r1;
    }
}
