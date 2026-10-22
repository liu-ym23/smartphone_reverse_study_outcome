package com.obric.oui.forms;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.ViewGroupKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SuppressLint({"ClickableViewAccessibility"})
public class OInputLayout extends FrameLayout {
    public static final /* synthetic */ int j = 0;
    public int b;
    public int c;
    public int e;
    public boolean f;
    public LimitStateChangeObserver i;

    /* JADX INFO: renamed from: com.obric.oui.forms.OInputLayout$2, reason: invalid class name */
    @Metadata
    final class AnonymousClass2 implements View.OnClickListener {
        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.forms.OInputLayout$3, reason: invalid class name */
    @Metadata
    final class AnonymousClass3 implements View.OnClickListener {
        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.forms.OInputLayout$4, reason: invalid class name */
    @Metadata
    final class AnonymousClass4 implements View.OnClickListener {
        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            throw null;
        }
    }

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public interface LimitStateChangeObserver {
    }

    @Nullable
    public final View getCustomEnd() {
        throw null;
    }

    @Nullable
    public final View getCustomStart() {
        throw null;
    }

    @Nullable
    public final CharSequence getHint() {
        throw null;
    }

    public final int getInputType() {
        return this.c;
    }

    @Nullable
    public final CharSequence getLabel() {
        throw null;
    }

    public final int getLimitCount() {
        return this.e;
    }

    public final int getMaxLines() {
        throw null;
    }

    @Nullable
    public CharSequence getText() {
        throw null;
    }

    @Nullable
    public final CharSequence getTip() {
        throw null;
    }

    public final int getType() {
        return this.b;
    }

    @NotNull
    public final OEditText getVInput() {
        return null;
    }

    public final void setAutoChangeWithLimit(boolean r1) {
        setTextState(false);
    }

    public final void setCustomEnd(int r1) {
        throw null;
    }

    public void setCustomStart(int r1) {
        throw null;
    }

    public void setDefaultCustomStart(int r1) {
        throw null;
    }

    @Override // android.view.View
    public void setEnabled(boolean r2) {
        super.setEnabled(r2);
        Iterator r1 = ViewGroupKt.getChildren(this).iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        ((View) r1.next()).setEnabled(r2);
        goto L4
    L7:
        throw null;
    }

    public final void setHint(@Nullable CharSequence r1) {
        throw null;
    }

    public final void setInputType(int r2) {
        if ((r2 & 1) != 0) goto L12;
        if ((r2 & 2) != 0) goto L12;
        if ((r2 & 3) != 0) goto L12;
        if ((r2 & 4) != 0) goto L12;
        r2 = r2 | 1;
    L12:
        if (this.c == r2) goto L14;
        this.c = r2;
    L14:
        getMaxLines();
        getMaxLines();
        throw null;
    }

    public final void setLabel(@Nullable CharSequence r1) {
        throw null;
    }

    public void setLimitCount(int r2) {
        if (this.e != r2) goto L5;
        return;
    L5:
        this.e = r2;
        if (r2 > 0) goto L8;
        throw null;
    L8:
        throw null;
    }

    public final void setLimitStateChangeListener(@NotNull LimitStateChangeObserver r2) {
        Intrinsics.f(r2, "limitStateChangeListener");
        this.i = r2;
    }

    public final void setMaxLines(int r1) {
        if (r1 > 0) goto L5;
        return;
    L5:
        throw null;
    }

    public final void setText(@Nullable CharSequence r1) {
        throw null;
    }

    public final void setTextState(boolean r1) {
        if (this.f == false) goto L5;
        return;
    L5:
        this.f = true;
        throw null;
    }

    public final void setTip(@Nullable CharSequence r1) {
        throw null;
    }

    public void setType(int r2) {
        if (r2 != 0) goto L4;
    L6:
        this.b = r2;
        throw null;
    L4:
        if (r2 == 1) goto L6;
    }
}
