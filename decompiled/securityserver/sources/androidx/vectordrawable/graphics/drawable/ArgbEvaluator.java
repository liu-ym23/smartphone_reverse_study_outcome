package androidx.vectordrawable.graphics.drawable;

import a.a;
import android.animation.TypeEvaluator;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ArgbEvaluator implements TypeEvaluator {
    private static final ArgbEvaluator sInstance = null;

    static {
        sInstance = new ArgbEvaluator();
    }

    public ArgbEvaluator() {
    }

    public static ArgbEvaluator getInstance() {
        return sInstance;
    }

    @Override // android.animation.TypeEvaluator
    public Object evaluate(float r11, Object r12, Object r13) {
        int r10 = ((Integer) r12).intValue();
        float r14 = ((r10 >> 24) & 255) / 255.0f;
        int r15 = ((Integer) r13).intValue();
        float r3 = ((r15 >> 24) & 255) / 255.0f;
        float r1 = (float) Math.pow(((r10 >> 16) & 255) / 255.0f, 2.2d);
        float r2 = (float) Math.pow(((r10 >> 8) & 255) / 255.0f, 2.2d);
        float r16 = (float) Math.pow((r10 & 255) / 255.0f, 2.2d);
        float r4 = (float) Math.pow(((r15 >> 16) & 255) / 255.0f, 2.2d);
        float r5 = (float) Math.pow(((r15 >> 8) & 255) / 255.0f, 2.2d);
        float r17 = (float) Math.pow((r15 & 255) / 255.0f, 2.2d);
        float r18 = a.a(r3, r14, r11, r14);
        float r6 = a.a(r4, r1, r11, r1);
        float r7 = a.a(r5, r2, r11, r2);
        float r19 = a.a(r17, r16, r11, r16);
        float r110 = ((float) Math.pow(r6, 0.45454545454545453d)) * 255.0f;
        float r111 = ((float) Math.pow(r7, 0.45454545454545453d)) * 255.0f;
        float r112 = ((float) Math.pow(r19, 0.45454545454545453d)) * 255.0f;
        return Integer.valueOf(Math.round(r112) | (((Math.round(r110) << 16) | (Math.round(r18 * 255.0f) << 24)) | (Math.round(r111) << 8)));
    }
}
