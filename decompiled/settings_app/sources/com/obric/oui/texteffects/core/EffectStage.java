package com.obric.oui.texteffects.core;

import android.icu.text.PluralRules;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextEffectProtocol.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/obric/oui/texteffects/core/EffectStage;", "", "id", "", "startMs", "", "durationMs", "layers", "", "Lcom/obric/oui/texteffects/core/EffectLayer;", "(Ljava/lang/String;JJLjava/util/List;)V", "getDurationMs", "()J", "getId", "()Ljava/lang/String;", "getLayers", "()Ljava/util/List;", "getStartMs", "component1", "component2", "component3", "component4", "copy", "equals", "", PluralRules.KEYWORD_OTHER, "hashCode", "", "toString", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class EffectStage {
    private final long durationMs;
    private final String id;
    private final List<EffectLayer> layers;
    private final long startMs;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EffectStage copy$default(EffectStage r4, String r5, long r6, long r8, List r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.id;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.startMs;
    L8:
        long r0 = r6;
        if ((r11 & 4) == 0) goto L11;
        r8 = r4.durationMs;
    L11:
        long r2 = r8;
        if ((r11 & 8) == 0) goto L14;
        r10 = r4.layers;
    L14:
        String r7 = r5;
        return r4.copy(r7, r0, r2, r10);
    }

    public final String component1() {
        return this.id;
    }

    public final long component2() {
        return this.startMs;
    }

    public final long component3() {
        return this.durationMs;
    }

    public final List<EffectLayer> component4() {
        return this.layers;
    }

    public final EffectStage copy(String r8, long r9, long r11, List<? extends EffectLayer> r13) {
        Intrinsics.checkNotNullParameter(r8, "id");
        Intrinsics.checkNotNullParameter(r13, "layers");
        return new EffectStage(r8, r9, r11, r13);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof EffectStage) == true) goto L8;
        return false;
    L8:
        EffectStage r9 = (EffectStage) r8;
        if (Intrinsics.areEqual(this.id, r9.id) == true) goto L12;
        return false;
    L12:
        if (this.startMs == r9.startMs) goto L15;
        return false;
    L15:
        if (this.durationMs == r9.durationMs) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.layers, r9.layers) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.id.hashCode() * 31) + Long.hashCode(this.startMs)) * 31) + Long.hashCode(this.durationMs)) * 31) + this.layers.hashCode();
    }

    public String toString() {
        return "EffectStage(id=" + this.id + ", startMs=" + this.startMs + ", durationMs=" + this.durationMs + ", layers=" + this.layers + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EffectStage(String r2, long r3, long r5, List<? extends EffectLayer> r7) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r7, "layers");
        this.id = r2;
        this.startMs = r3;
        this.durationMs = r5;
        this.layers = r7;
    }

    public final String getId() {
        return this.id;
    }

    public final long getStartMs() {
        return this.startMs;
    }

    public final long getDurationMs() {
        return this.durationMs;
    }

    public final List<EffectLayer> getLayers() {
        return this.layers;
    }
}
