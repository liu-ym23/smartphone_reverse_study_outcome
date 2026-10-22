package androidx.transition;

import android.view.View;
import android.view.WindowId;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(18)
class WindowIdApi18 implements WindowIdImpl {
    private final WindowId mWindowId;

    public WindowIdApi18(@NonNull View r1) {
        this.mWindowId = r1.getWindowId();
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof WindowIdApi18) == true) goto L5;
    L7:
        return false;
    L5:
        if (((WindowIdApi18) r2).mWindowId.equals(this.mWindowId) == false) goto L7;
        return true;
    }

    public int hashCode() {
        return this.mWindowId.hashCode();
    }
}
