package com.obric.oui.forms;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.CompletionInfo;
import androidx.appcompat.widget.AppCompatEditText;
import com.bytedance.securityserver.R;
import com.obric.oui.haptic.VibratorSmt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OEditText extends AppCompatEditText {
    public final OnFocusChangeListenerWrapper b;
    public final OnTouchListenerWrapper c;
    public final TextWatcherWrapper e;
    public CommitCompletionListener f;
    public boolean i;

    @Metadata
    public interface CommitCompletionListener {
        void a();
    }

    @Metadata
    public static final class OnFocusChangeListenerWrapper implements View.OnFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Function1 f224a;
        public View.OnFocusChangeListener b;

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View r3, boolean r4) {
            Function1 r0 = this.f224a;
            if (r0 == null) goto L5;
            Unit r1 = (Unit) r0.invoke(Boolean.valueOf(r4));
        L5:
            View.OnFocusChangeListener r2 = this.b;
            if (r2 == null) goto L9;
            r2.onFocusChange(r3, r4);
            return;
        }
    }

    @Metadata
    public static final class OnTouchListenerWrapper implements View.OnTouchListener {
        public Function1 b;
        public View.OnTouchListener c;

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r2, MotionEvent r3) {
            Function1 r0 = this.b;
            if (r0 == null) goto L5;
            Unit r1 = (Unit) r0.invoke(r3);
        L5:
            View.OnTouchListener r4 = this.c;
            if (r4 != null) goto L10;
            return false;
        L10:
            return r4.onTouch(r2, r3);
        }
    }

    @Metadata
    public static final class TextWatcherWrapper implements TextWatcher {
        public Function4 b;
        public Function1 c;

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r1) {
            Function1 r0 = this.c;
            if (r0 == null) goto L6;
            Unit r2 = (Unit) r0.invoke(r1);
            return;
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
            Function4 r0 = this.b;
            if (r0 == null) goto L6;
            Unit r5 = (Unit) r0.invoke(r1, Integer.valueOf(r2), Integer.valueOf(r3), Integer.valueOf(r4));
            return;
        }
    }

    @JvmOverloads
    public OEditText(@NotNull Context r3, @Nullable AttributeSet r4) {
        Intrinsics.f(r3, "context");
        super(r3, r4, 0);
        OnFocusChangeListenerWrapper r5 = new OnFocusChangeListenerWrapper();
        this.b = r5;
        OnTouchListenerWrapper r0 = new OnTouchListenerWrapper();
        this.c = r0;
        TextWatcherWrapper r1 = new TextWatcherWrapper();
        this.e = r1;
        setOnFocusChangeListener(r5);
        super.setOnTouchListener(r0);
        addTextChangedListener(r1);
        setHighlightColor(r3.getColor(R.color.oui_text_highlight_color));
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        return 0.0f;
    }

    @Nullable
    public final CommitCompletionListener getCommitCompletionListener() {
        return this.f;
    }

    @Override // android.widget.TextView, android.view.View
    public float getLeftFadingEdgeStrength() {
        return 0.0f;
    }

    @Override // android.view.View
    @Nullable
    public View.OnFocusChangeListener getOnFocusChangeListener() {
        View.OnFocusChangeListener r1 = super.getOnFocusChangeListener();
        if ((r1 instanceof OnFocusChangeListenerWrapper) == true) goto L5;
        return r1;
    L5:
        return ((OnFocusChangeListenerWrapper) r1).b;
    }

    @Override // android.widget.TextView, android.view.View
    public float getRightFadingEdgeStrength() {
        return 0.0f;
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        return 0.0f;
    }

    @Override // android.widget.TextView
    public final void onCommitCompletion(CompletionInfo r1) {
        super.onCommitCompletion(r1);
        CommitCompletionListener r0 = this.f;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // android.widget.TextView
    public final void onSelectionChanged(int r1, int r2) {
        super.onSelectionChanged(r1, r2);
        if (r1 == r2) goto L5;
        boolean r3 = true;
    L7:
        if (this.i == true) goto L11;
        if (r3 == false) goto L12;
        VibratorSmt.a(getContext(), 3);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r3 = false;
        goto L7
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean performLongClick() {
        this.i = true;
        boolean r0 = super.performLongClick();
        this.i = false;
        return r0;
    }

    public final void setCommitCompletionListener(@Nullable CommitCompletionListener r1) {
        this.f = r1;
    }

    @Override // android.view.View
    public void setOnFocusChangeListener(@Nullable View.OnFocusChangeListener r2) {
        if ((r2 instanceof OnFocusChangeListenerWrapper) == false) goto L5;
        super.setOnFocusChangeListener(r2);
        return;
    L5:
        this.b.b = r2;
    }

    @Override // android.view.View
    public void setOnTouchListener(@Nullable View.OnTouchListener r1) {
        this.c.c = r1;
    }
}
