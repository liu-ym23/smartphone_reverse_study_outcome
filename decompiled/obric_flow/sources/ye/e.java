package ye;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewParent;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends com.lynx.tasm.behavior.ui.view.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f23251a;

    public e(Context r5) {
        new LinkedHashMap();
        super(r5);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "ev");
        if (r5.getActionMasked() != 0) goto L10;
        if (this.f23251a == false) goto L10;
        ViewParent r10 = getParent();
        if (r10 == null) goto L10;
        r10.requestDisallowInterceptTouchEvent(true);
    L10:
        return super.dispatchTouchEvent(r5);
    }

    public final void setHandleGesture(boolean r5) {
        this.f23251a = r5;
    }
}
