package um;

import android.graphics.Rect;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import com.lynx.tasm.behavior.ui.LynxUI;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends a {
    @Override // um.a
    public final Animation f(LynxUI r21, int r22, int r23, int r24, int r25, int r26, int r27, int r28, int r29, int r30, int r31, int r32, int r33, int r34, int r35, int r36, int r37, Rect r38, float r39) {
        r21.getView();
        boolean r5 = true;
        if (r21.getOriginLeft() == r22) goto L5;
    L8:
        boolean r10 = true;
    L10:
        if (r21.getWidth() != r24) goto L16;
        if (r21.getHeight() != r25) goto L16;
        r5 = false;
    L16:
        if (r10 == true) goto L20;
        if (r5 == true) goto L20;
        return null;
    L20:
        if (r10 == false) goto L25;
        if (r5 == true) goto L25;
        return new TranslateAnimation(r21.getOriginLeft() - r22, 0.0f, r21.getOriginTop() - r23, 0.0f);
    L25:
        return new k(r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38);
    L5:
        if (r21.getOriginTop() != r23) goto L8;
        r10 = false;
        goto L10
    }
}
