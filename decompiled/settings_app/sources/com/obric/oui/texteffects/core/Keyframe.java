package com.obric.oui.texteffects.core;

import android.icu.text.PluralRules;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextEffectProtocol.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/obric/oui/texteffects/core/Keyframe;", "", "timeMs", "", "value", "Lcom/obric/oui/texteffects/core/EffectValue;", "(JLcom/obric/oui/texteffects/core/EffectValue;)V", "getTimeMs", "()J", "getValue", "()Lcom/obric/oui/texteffects/core/EffectValue;", "component1", "component2", "copy", "equals", "", PluralRules.KEYWORD_OTHER, "hashCode", "", "toString", "", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Keyframe {
    private final long timeMs;
    private final EffectValue value;

    public static /* synthetic */ Keyframe copy$default(Keyframe r0, long r1, EffectValue r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.timeMs;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r3 = r0.value;
    L9:
        return r0.copy(r1, r3);
    }

    public final long component1() {
        return this.timeMs;
    }

    public final EffectValue component2() {
        return this.value;
    }

    public final Keyframe copy(long r1, EffectValue r3) {
        Intrinsics.checkNotNullParameter(r3, "value");
        return new Keyframe(r1, r3);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof Keyframe) == true) goto L8;
        return false;
    L8:
        Keyframe r9 = (Keyframe) r8;
        if (this.timeMs == r9.timeMs) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.value, r9.value) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Long.hashCode(this.timeMs) * 31) + this.value.hashCode();
    }

    public String toString() {
        return "Keyframe(timeMs=" + this.timeMs + ", value=" + this.value + ')';
    }

    public Keyframe(long r2, EffectValue r4) {
        Intrinsics.checkNotNullParameter(r4, "value");
        this.timeMs = r2;
        this.value = r4;
    }

    public final long getTimeMs() {
        return this.timeMs;
    }

    public final EffectValue getValue() {
        return this.value;
    }
}
