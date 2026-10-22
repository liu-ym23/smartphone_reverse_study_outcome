package com.obric.oui.texteffects.core;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: TextEffectProtocol.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/obric/oui/texteffects/core/LoopSpec;", "", "()V", "Count", "Infinite", "None", "Lcom/obric/oui/texteffects/core/LoopSpec$None;", "Lcom/obric/oui/texteffects/core/LoopSpec$Infinite;", "Lcom/obric/oui/texteffects/core/LoopSpec$Count;", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class LoopSpec {

    /* JADX INFO: compiled from: TextEffectProtocol.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/obric/oui/texteffects/core/LoopSpec$Count;", "Lcom/obric/oui/texteffects/core/LoopSpec;", "count", "", "(I)V", "getCount", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Count extends LoopSpec {
        private final int count;

        public static /* synthetic */ Count copy$default(Count r0, int r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.count;
        L6:
            return r0.copy(r1);
        }

        public final int component1() {
            return this.count;
        }

        public final Count copy(int r1) {
            return new Count(r1);
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof Count) == true) goto L9;
            return false;
        L9:
            if (this.count == ((Count) r4).count) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Integer.hashCode(this.count);
        }

        public String toString() {
            return "Count(count=" + this.count + ')';
        }

        public Count(int r2) {
            super(null);
            this.count = r2;
        }

        public final int getCount() {
            return this.count;
        }
    }

    /* JADX INFO: compiled from: TextEffectProtocol.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/obric/oui/texteffects/core/LoopSpec$Infinite;", "Lcom/obric/oui/texteffects/core/LoopSpec;", "()V", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Infinite extends LoopSpec {
        public static final Infinite INSTANCE = null;

        static {
            INSTANCE = new Infinite();
        }

        private Infinite() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: TextEffectProtocol.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/obric/oui/texteffects/core/LoopSpec$None;", "Lcom/obric/oui/texteffects/core/LoopSpec;", "()V", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class None extends LoopSpec {
        public static final None INSTANCE = null;

        static {
            INSTANCE = new None();
        }

        private None() {
            super(null);
        }
    }

    public /* synthetic */ LoopSpec(DefaultConstructorMarker r1) {
        this();
    }

    private LoopSpec() {
    }
}
