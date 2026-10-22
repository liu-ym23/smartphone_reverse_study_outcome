package se;

import android.text.Editable;
import android.text.NoCopySpan;
import android.text.SpannableStringBuilder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends Editable.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NoCopySpan[] f21891a;

    public c(NoCopySpan... r5) {
        Intrinsics.checkNotNullParameter(r5, "spans");
        this.f21891a = r5;
    }

    @Override // android.text.Editable.Factory
    public final Editable newEditable(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "source");
        SpannableStringBuilder r5 = SpannableStringBuilder.valueOf(r10);
        NoCopySpan[] r11 = this.f21891a;
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r5.setSpan(r11[r13], 0, r10.length(), 18);
        r13 = r13 + 1;
        goto L3
    L5:
        return r5;
    }
}
