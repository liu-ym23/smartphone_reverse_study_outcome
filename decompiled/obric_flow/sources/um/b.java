package um;

import android.graphics.Rect;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import com.lynx.tasm.behavior.ui.LynxUI;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b extends a {
    public abstract boolean F();

    @Override // um.a
    public final Animation f(LynxUI r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20, int r21, int r22, int r23, int r24, int r25, int r26, Rect r27, float r28) {
        View r5 = r10.getView();
        int r29 = ((tm.b) this.f22372b).d;
        float r30 = 1.0f;
        float r31 = 0.0f;
        if (r29 == 2) goto L37;
        if (r29 == 4) goto L28;
        if (r29 == 8) goto L19;
        if (F() == false) goto L11;
        float r32 = r28;
    L13:
        if (F() == true) goto L17;
        r31 = r28;
    L17:
        return new j(r5, r32, r31);
    L11:
        r32 = 0.0f;
        goto L13
    L19:
        if (F() == false) goto L21;
        float r33 = 1.0f;
    L23:
        if (F() == false) goto L26;
        r30 = 0.0f;
    L26:
        return new ScaleAnimation(r33, r30, r33, r30, 1, 0.5f, 1, 0.5f);
    L21:
        r33 = 0.0f;
        goto L23
    L28:
        if (F() == false) goto L30;
        float r34 = 1.0f;
    L32:
        if (F() == false) goto L35;
        r30 = 0.0f;
    L35:
        return new ScaleAnimation(1.0f, 1.0f, r34, r30, 1, 0.0f, 1, 0.5f);
    L30:
        r34 = 0.0f;
        goto L32
    L37:
        if (F() == false) goto L39;
        float r35 = 1.0f;
    L41:
        if (F() == false) goto L44;
        r30 = 0.0f;
    L44:
        return new ScaleAnimation(r35, r30, 1.0f, 1.0f, 1, 0.5f, 1, 0.0f);
    L39:
        r35 = 0.0f;
        goto L41
    }
}
