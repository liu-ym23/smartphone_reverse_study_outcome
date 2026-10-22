package com.obric.oui.texteffects.runtime;

import android.icu.text.PluralRules;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextEffectFrame.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/obric/oui/texteffects/runtime/TextEffectFrame;", "", "playTimeMs", "", "normalizedPlayTimeMs", "layers", "", "Lcom/obric/oui/texteffects/runtime/LayerFrame;", "(JJLjava/util/List;)V", "getLayers", "()Ljava/util/List;", "getNormalizedPlayTimeMs", "()J", "getPlayTimeMs", "component1", "component2", "component3", "copy", "equals", "", PluralRules.KEYWORD_OTHER, "hashCode", "", "toString", "", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TextEffectFrame {
    private final List<LayerFrame> layers;
    private final long normalizedPlayTimeMs;
    private final long playTimeMs;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TextEffectFrame copy$default(TextEffectFrame r6, long r7, long r9, List r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r7 = r6.playTimeMs;
    L5:
        long r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r9 = r6.normalizedPlayTimeMs;
    L8:
        long r3 = r9;
        if ((r12 & 4) == 0) goto L12;
        r11 = r6.layers;
    L12:
        return r6.copy(r1, r3, r11);
    }

    public final long component1() {
        return this.playTimeMs;
    }

    public final long component2() {
        return this.normalizedPlayTimeMs;
    }

    public final List<LayerFrame> component3() {
        return this.layers;
    }

    public final TextEffectFrame copy(long r7, long r9, List<LayerFrame> r11) {
        Intrinsics.checkNotNullParameter(r11, "layers");
        return new TextEffectFrame(r7, r9, r11);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof TextEffectFrame) == true) goto L8;
        return false;
    L8:
        TextEffectFrame r9 = (TextEffectFrame) r8;
        if (this.playTimeMs == r9.playTimeMs) goto L12;
        return false;
    L12:
        if (this.normalizedPlayTimeMs == r9.normalizedPlayTimeMs) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.layers, r9.layers) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Long.hashCode(this.playTimeMs) * 31) + Long.hashCode(this.normalizedPlayTimeMs)) * 31) + this.layers.hashCode();
    }

    public String toString() {
        return "TextEffectFrame(playTimeMs=" + this.playTimeMs + ", normalizedPlayTimeMs=" + this.normalizedPlayTimeMs + ", layers=" + this.layers + ')';
    }

    public TextEffectFrame(long r2, long r4, List<LayerFrame> r6) {
        Intrinsics.checkNotNullParameter(r6, "layers");
        this.playTimeMs = r2;
        this.normalizedPlayTimeMs = r4;
        this.layers = r6;
    }

    public final long getPlayTimeMs() {
        return this.playTimeMs;
    }

    public final long getNormalizedPlayTimeMs() {
        return this.normalizedPlayTimeMs;
    }

    public final List<LayerFrame> getLayers() {
        return this.layers;
    }
}
