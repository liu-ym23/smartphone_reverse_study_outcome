package zm;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.LineBackgroundSpan;
import com.lynx.tasm.behavior.ui.utils.BackgroundDrawable;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class l implements LineBackgroundSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f23500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f23501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f23502c;
    public HashMap d;
    public final com.lynx.tasm.behavior.ui.utils.g e;

    public l(int r5, int r10, com.lynx.tasm.behavior.ui.utils.g r11) {
        this.f23502c = true;
        this.f23500a = r5;
        this.f23501b = r10;
        this.e = r11;
    }

    @Override // android.text.style.LineBackgroundSpan
    public final void drawBackground(Canvas r5, Paint r10, int r11, int r12, int r13, int r14, int r15, CharSequence r16, int r17, int r18, int r19) {
        com.lynx.tasm.behavior.ui.utils.g r20 = this.e;
        if (r20 == null) goto L19;
        HashMap r21 = this.d;
        if (r21 != null) goto L7;
        return;
    L7:
        if (this.f23502c == true) goto L10;
        return;
    L10:
        if (r21.containsKey(Integer.valueOf(r19)) == false) goto L21;
        int[] r22 = (int[]) this.d.get(Integer.valueOf(r19));
        if (r22 != null) goto L14;
        return;
    L14:
        if (r22.length != 2) goto L23;
        BackgroundDrawable r23 = (BackgroundDrawable) r20.f10750b;
        if (r23 == null) goto L24;
        r23.setBounds(Math.min(r22[0], r22[1]), r13, Math.max(r22[0], r22[1]), r15);
        ((BackgroundDrawable) r20.f10750b).draw(r5);
        return;
    L24:
        return;
    L23:
        return;
    L21:
        return;
    }
}
