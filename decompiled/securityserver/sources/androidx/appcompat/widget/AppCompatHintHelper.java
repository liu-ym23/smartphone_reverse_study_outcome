package androidx.appcompat.widget;

import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

/* JADX INFO: loaded from: classes.dex */
class AppCompatHintHelper {
    private AppCompatHintHelper() {
    }

    public static InputConnection onCreateInputConnection(InputConnection r1, EditorInfo r2, View r3) {
        if (r1 != null) goto L4;
    L12:
        return r1;
    L4:
        if (r2.hintText != null) goto L12;
        ViewParent r4 = r3.getParent();
    L7:
        if ((r4 instanceof View) == false) goto L12;
        if ((r4 instanceof WithHint) == true) goto L10;
        r4 = r4.getParent();
        goto L7
    L10:
        r2.hintText = ((WithHint) r4).getHint();
        goto L12
    }
}
