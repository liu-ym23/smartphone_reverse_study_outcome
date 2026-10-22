package com.obric.oui.stepper;

import a.a;
import android.widget.TextView;
import com.obric.oui.layout.OUIConstraintLayout;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OSteppers extends OUIConstraintLayout {
    public static final /* synthetic */ int p = 0;
    public OnValueChangeListener k;
    public int l;
    public int m;
    public int n;
    public int o;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public interface OnValueChangeListener {

        @Metadata
        public static final class DefaultImpls {
        }

        void a();

        void b();
    }

    private final void setMMaxValue(int r4) {
        this.n = r4;
        int r1 = this.m;
        OSteppers$registerInputFilter$1 r2 = new OSteppers$registerInputFilter$1(this);
        InputFilterMinMax r0 = new InputFilterMinMax();
        r0.f286a = r1;
        r0.b = r4;
        r0.c = r2;
        throw null;
    }

    private final void setMMinValue(int r4) {
        this.m = r4;
        int r1 = this.n;
        OSteppers$registerInputFilter$1 r2 = new OSteppers$registerInputFilter$1(this);
        InputFilterMinMax r0 = new InputFilterMinMax();
        r0.f286a = r4;
        r0.b = r1;
        r0.c = r2;
        throw null;
    }

    private final void setMStepValue(int r1) {
        this.o = r1;
        String.valueOf(this.l);
        TextView.BufferType r0 = TextView.BufferType.EDITABLE;
        throw null;
    }

    private final void setMValue(int r2) {
        if (this.l != r2) goto L5;
        return;
    L5:
        this.l = r2;
        OnValueChangeListener r3 = this.k;
        if (r3 == null) goto L8;
        r3.b();
    L8:
        String.valueOf(this.l);
        TextView.BufferType r1 = TextView.BufferType.EDITABLE;
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void clearFocus() {
        super.clearFocus();
        throw null;
    }

    public final int getMaxValue() {
        return this.n;
    }

    public final int getMinValue() {
        return this.m;
    }

    @Nullable
    public final OnValueChangeListener getOnValueChangeListener() {
        return this.k;
    }

    public final int getValue() {
        return this.l;
    }

    public final void setMaxValue(int r2) {
        setMMaxValue(r2);
        setMValue(Math.min(r2, this.l));
    }

    public final void setMinValue(int r2) {
        setMMinValue(r2);
        setMValue(Math.max(r2, this.l));
    }

    public final void setOnValueChangeListener(@Nullable OnValueChangeListener r1) {
        this.k = r1;
    }

    public final void setStepValue(int r2) {
        if (this.o <= 0) goto L7;
        setMStepValue(r2);
        return;
    L7:
        throw new IllegalArgumentException("step value should be a positive integer");
    }

    public final void setValue(int r3) {
        if (r3 >= this.m) goto L5;
    L8:
        StringBuilder r1 = new StringBuilder();
        r1.append(r3);
        r1.append(" is not in [");
        r1.append(this.m);
        r1.append(", ");
        throw new IllegalArgumentException(a.n(r1, "].", this.n));
    L5:
        if (r3 > this.n) goto L8;
        setMValue(r3);
    }
}
