package se;

import android.text.Selection;
import android.text.SpanWatcher;
import android.text.Spannable;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements SpanWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f21892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f21893b;

    @Override // android.text.SpanWatcher
    public final void onSpanAdded(Spannable r5, Object r10, int r11, int r12) {
    }

    @Override // android.text.SpanWatcher
    public final void onSpanChanged(Spannable r5, Object r10, int r11, int r12, int r13, int r14) {
        if (Intrinsics.areEqual(r10, Selection.SELECTION_END) == false) goto L18;
        if (this.f21893b == r13) goto L18;
        this.f21893b = r13;
        if (r5 == null) goto L18;
        b[] r15 = (b[]) r5.getSpans(r13, r14, b.class);
        if (r15 == null) goto L18;
        b r16 = (b) ArraysKt.firstOrNull(r15);
        if (r16 == null) goto L18;
        int r17 = r5.getSpanStart(r16);
        int r18 = r5.getSpanEnd(r16);
        if (Math.abs(this.f21893b - r18) > Math.abs(this.f21893b - r17)) goto L16;
        r17 = r18;
    L16:
        Selection.setSelection(r5, Selection.getSelectionStart(r5), r17);
    L18:
        if (r10 == Selection.SELECTION_START) goto L20;
        return;
    L20:
        if (this.f21892a == r13) goto L34;
        this.f21892a = r13;
        if (r5 == null) goto L35;
        b[] r19 = (b[]) r5.getSpans(r13, r14, b.class);
        if (r19 == null) goto L36;
        b r20 = (b) ArraysKt.firstOrNull(r19);
        if (r20 == null) goto L37;
        int r21 = r5.getSpanStart(r20);
        int r22 = r5.getSpanEnd(r20);
        if (Math.abs(this.f21892a - r22) > Math.abs(this.f21892a - r21)) goto L31;
        r21 = r22;
    L31:
        Selection.setSelection(r5, r21, Selection.getSelectionEnd(r5));
        return;
    L37:
        return;
    L36:
        return;
    L35:
        return;
    }

    @Override // android.text.SpanWatcher
    public final void onSpanRemoved(Spannable r5, Object r10, int r11, int r12) {
    }
}
