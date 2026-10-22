package androidx.vectordrawable.graphics.drawable;

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
        float r1 = (float) Math.pow(((r10 >> 16) & 255) / 255.0f, 2.2d);
        float r2 = (float) Math.pow(((r10 >> 8) & 255) / 255.0f, 2.2d);
        float r16 = (float) Math.pow((r10 & 255) / 255.0f, 2.2d);
        float r4 = (float) Math.pow(((r15 >> 16) & 255) / 255.0f, 2.2d);
        float r17 = r14 + (((((r15 >> 24) & 255) / 255.0f) - r14) * r11);
        float r3 = r2 + ((((float) Math.pow(((r15 >> 8) & 255) / 255.0f, 2.2d)) - r2) * r11);
        float r18 = r16 + (r11 * (((float) Math.pow((r15 & 255) / 255.0f, 2.2d)) - r16));
        float r19 = ((float) Math.pow(r1 + ((r4 - r1) * r11), 0.45454545454545453d)) * 255.0f;
        float r110 = ((float) Math.pow(r3, 0.45454545454545453d)) * 255.0f;
        float r111 = ((float) Math.pow(r18, 0.45454545454545453d)) * 255.0f;
        return Integer.valueOf(Math.round(r111) | (((Math.round(r19) << 16) | (Math.round(r17 * 255.0f) << 24)) | (Math.round(r110) << 8)));
    }
}
