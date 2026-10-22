package xe;

import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import com.lynx.tasm.behavior.LynxContext;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f23107a;

    public a(Context r5) {
        super(r5);
        this.f23107a = 0;
    }

    private Rect getBoundRectForOverflow() {
        if (this.f23107a != 3) goto L6;
        return null;
    L6:
        if ((getContext() instanceof LynxContext) == false) goto L16;
        LynxContext r5 = (LynxContext) getContext();
        int r10 = getWidth();
        int r11 = getHeight();
        DisplayMetrics r12 = r5.f10152u;
        int r13 = 0;
        if ((getOverflow() & 1) == 0) goto L10;
        int r14 = r12.widthPixels;
        int r15 = 0 - r14;
        r10 = r10 + (r14 * 2);
    L12:
        if ((getOverflow() & 2) == 0) goto L15;
        int r16 = r12.heightPixels;
        r13 = 0 - r16;
        r11 = r11 + (r16 * 2);
    L15:
        return new Rect(r15, r13, r10 + r15, r11 + r13);
    L10:
        r15 = 0;
        goto L12
    L16:
        return null;
    }

    public int getOverflow() {
        return this.f23107a;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        super.onLayout(r5, r10, r11, r12, r13);
        int r14 = this.f23107a;
        if (r14 != 0) goto L5;
        return;
    L5:
        if (r14 != 0) goto L7;
    L10:
        ViewCompat.setClipBounds(this, getBoundRectForOverflow());
        if (getChildAt(0) == null) goto L15;
        ViewCompat.setClipBounds(getChildAt(0), getBoundRectForOverflow());
        return;
    L15:
        return;
    L7:
        if ((getParent() instanceof ViewGroup) == false) goto L9;
        ((ViewGroup) getParent()).setClipChildren(false);
    L9:
        setClipChildren(false);
        goto L10
    }

    public void setOverflow(int r5) {
        this.f23107a = r5;
    }
}
