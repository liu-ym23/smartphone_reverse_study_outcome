package com.github.lcdsmao.springx;

import com.obric.oui.animation.easy.SpringAnimationConfig;
import com.obric.oui.animation.engine.SpringAnimation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class SpringAnimationHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SpringAnimation f91a;
    public final SpringAnimationConfig b;

    public SpringAnimationHolder(SpringAnimation r1, SpringAnimationConfig r2) {
        this.f91a = r1;
        this.b = r2;
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof SpringAnimationHolder) == false) goto L10;
        SpringAnimationHolder r4 = (SpringAnimationHolder) r3;
        SpringAnimation r0 = r4.f91a;
        if (Intrinsics.a(this.f91a, r0) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.a(this.b, r4.b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r0 = 0;
        SpringAnimation r1 = this.f91a;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L6:
        int r3 = r2 * 31;
        SpringAnimationConfig r4 = this.b;
        if (r4 == null) goto L10;
        r0 = r4.hashCode();
    L10:
        return r3 + r0;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "SpringAnimationHolder(animation=" + this.f91a + ", config=" + this.b + ")";
    }
}
