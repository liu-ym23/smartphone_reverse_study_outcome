package se;

import android.text.Editable;
import android.text.Selection;
import com.bytedance.ies.xelement.input.t;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f21888a = null;

    static {
        f21888a = new a();
    }

    @Override // com.bytedance.ies.xelement.input.t
    public final boolean a(Editable r10) {
        Intrinsics.checkNotNullParameter(r10, "editableText");
        int r11 = Selection.getSelectionStart(r10);
        int r5 = Selection.getSelectionEnd(r10);
        Object[] r12 = r10.getSpans(r11, r5, b.class);
        int r13 = r12.length;
        boolean r14 = false;
        int r15 = 0;
    L3:
        if (r15 >= r13) goto L8;
        Object r16 = r12[r15];
        if (r10.getSpanEnd((b) r16) == r11) goto L9;
        r15 = r15 + 1;
    L9:
        b r17 = (b) r16;
        if (r17 == null) goto L14;
        if (r11 != r5) goto L13;
        r14 = true;
    L13:
        Selection.setSelection(r10, r10.getSpanStart(r17), r10.getSpanEnd(r17));
    L14:
        return r14;
    L8:
        r16 = null;
        goto L9
    }
}
