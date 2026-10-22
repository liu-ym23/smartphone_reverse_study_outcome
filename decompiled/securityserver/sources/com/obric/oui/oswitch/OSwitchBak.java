package com.obric.oui.oswitch;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OSwitchBak extends SwitchCompat {
    public final void c(boolean r4, boolean r5) {
        if (r4 != isChecked()) goto L5;
    L20:
        super.setChecked(r4);
        return;
    L5:
        if ((getTrackDrawable() instanceof TransitionDrawable) == false) goto L20;
        if (r4 == false) goto L13;
        Drawable r2 = getTrackDrawable();
        if (r2 == null) goto L12;
        ((TransitionDrawable) r2).startTransition(180);
    L16:
        if (r5 == false) goto L20;
        performHapticFeedback(1, 2);
        goto L20
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
    L13:
        Drawable r3 = getTrackDrawable();
        if (r3 == null) goto L19;
        ((TransitionDrawable) r3).reverseTransition(180);
        goto L16
    L19:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // com.obric.oui.oswitch.SwitchCompat, android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r2) {
        c(r2, true);
    }

    public final void setCheckedWithoutFeedback(boolean r2) {
        c(r2, false);
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean r1) {
        super.setEnabled(r1);
        if (r1 == false) goto L5;
        float r2 = 1.0f;
    L6:
        setAlpha(r2);
        return;
    L5:
        r2 = 0.5f;
        goto L6
    }
}
