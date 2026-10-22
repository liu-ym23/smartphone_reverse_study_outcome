package com.obric.oui.dialog.alert.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.checkbox.OCheckBox;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
@Metadata
public final class DialogConfirmView extends ConstraintLayout {
    public static final /* synthetic */ int b = 0;

    /* JADX INFO: renamed from: com.obric.oui.dialog.alert.view.DialogConfirmView$onAttachedToWindow$1, reason: invalid class name */
    @Metadata
    final class AnonymousClass1 implements View.OnClickListener {
        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            int r0 = DialogConfirmView.b;
            throw null;
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.dialog.alert.view.DialogConfirmView$onAttachedToWindow$2, reason: invalid class name */
    @Metadata
    final class AnonymousClass2 implements View.OnClickListener {
        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            throw null;
        }
    }

    @NotNull
    public final OCheckBox getCheckBox() {
        return null;
    }

    @NotNull
    public final TextView getLinkTextView() {
        return null;
    }

    @NotNull
    public final TextView getNormalTextView() {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getParent() != null) goto L5;
        return;
    L5:
        if ((getParent() instanceof ViewGroup) == false) goto L13;
        ViewParent r1 = getParent();
        if (r1 == null) goto L9;
        ViewGroup r2 = (ViewGroup) r1;
        r2.getPaddingTop();
        r2.getPaddingBottom();
        throw null;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }
}
