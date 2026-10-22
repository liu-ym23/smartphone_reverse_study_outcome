package com.obric.common.oea.foundation.graphics.smoothcorner.impl;

import android.graphics.Path;
import android.graphics.RectF;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class ISmoothCornerImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f145a;

    @Metadata
    public static final class Companion {
        public static void a(Path r9, Point r10, float r11, float r12, float r13) {
            float r0 = r10.f146a;
            float r14 = r10.b;
            r9.arcTo(r0 - r11, r14 - r11, r0 + r11, r14 + r11, r12, r13 - r12, false);
        }
    }

    public ISmoothCornerImpl() {
        this.f145a = new RectF();
    }

    public static Path b(float r9, float r10, float r11, float r12, float r13) {
        Path r8 = new Path();
        r8.addRoundRect(r9, r10, r11, r12, r13, r13, Path.Direction.CW);
        r8.close();
        return r8;
    }

    public abstract Path a(float r1, float r2, float r3, float r4, float r5);

    public boolean c(float r1, float r2) {
        return true;
    }
}
