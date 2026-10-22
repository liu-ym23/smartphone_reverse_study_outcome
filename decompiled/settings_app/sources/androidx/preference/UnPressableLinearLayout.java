package androidx.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes.dex */
public class UnPressableLinearLayout extends LinearLayout {
    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean r1) {
    }

    public UnPressableLinearLayout(Context r2) {
        this(r2, null);
    }

    public UnPressableLinearLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
    }
}
