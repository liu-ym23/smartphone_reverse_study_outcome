package com.obric.oui.texteffects.core;

import com.bytedance.apm.constant.SlardarConfigConsts;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextEffectProtocol.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003JA\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006#"}, d2 = {"Lcom/obric/oui/texteffects/core/TextEffectSpec;", "", SlardarConfigConsts.CONFIG_ID, "", "version", "", "durationMs", "", "loop", "Lcom/obric/oui/texteffects/core/LoopSpec;", "stages", "", "Lcom/obric/oui/texteffects/core/EffectStage;", "(Ljava/lang/String;IJLcom/obric/oui/texteffects/core/LoopSpec;Ljava/util/List;)V", "getDurationMs", "()J", "getId", "()Ljava/lang/String;", "getLoop", "()Lcom/obric/oui/texteffects/core/LoopSpec;", "getStages", "()Ljava/util/List;", "getVersion", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TextEffectSpec {
    private final long durationMs;
    private final String id;
    private final LoopSpec loop;
    private final List<EffectStage> stages;
    private final int version;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TextEffectSpec copy$default(TextEffectSpec r4, String r5, int r6, long r7, LoopSpec r9, List r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.id;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.version;
    L8:
        int r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.durationMs;
    L11:
        long r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r9 = r4.loop;
    L14:
        LoopSpec r2 = r9;
        if ((r11 & 16) == 0) goto L17;
        r10 = r4.stages;
    L17:
        String r8 = r5;
        return r4.copy(r8, r13, r0, r2, r10);
    }

    public final String component1() {
        return this.id;
    }

    public final int component2() {
        return this.version;
    }

    public final long component3() {
        return this.durationMs;
    }

    public final LoopSpec component4() {
        return this.loop;
    }

    public final List<EffectStage> component5() {
        return this.stages;
    }

    public final TextEffectSpec copy(String r8, int r9, long r10, LoopSpec r12, List<EffectStage> r13) {
        Intrinsics.checkNotNullParameter(r8, SlardarConfigConsts.CONFIG_ID);
        Intrinsics.checkNotNullParameter(r12, "loop");
        Intrinsics.checkNotNullParameter(r13, "stages");
        return new TextEffectSpec(r8, r9, r10, r12, r13);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof TextEffectSpec) == true) goto L8;
        return false;
    L8:
        TextEffectSpec r9 = (TextEffectSpec) r8;
        if (Intrinsics.areEqual(this.id, r9.id) == true) goto L12;
        return false;
    L12:
        if (this.version == r9.version) goto L15;
        return false;
    L15:
        if (this.durationMs == r9.durationMs) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.loop, r9.loop) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.stages, r9.stages) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((this.id.hashCode() * 31) + Integer.hashCode(this.version)) * 31) + Long.hashCode(this.durationMs)) * 31) + this.loop.hashCode()) * 31) + this.stages.hashCode();
    }

    public String toString() {
        return "TextEffectSpec(id=" + this.id + ", version=" + this.version + ", durationMs=" + this.durationMs + ", loop=" + this.loop + ", stages=" + this.stages + ')';
    }

    public TextEffectSpec(String r2, int r3, long r4, LoopSpec r6, List<EffectStage> r7) {
        Intrinsics.checkNotNullParameter(r2, SlardarConfigConsts.CONFIG_ID);
        Intrinsics.checkNotNullParameter(r6, "loop");
        Intrinsics.checkNotNullParameter(r7, "stages");
        this.id = r2;
        this.version = r3;
        this.durationMs = r4;
        this.loop = r6;
        this.stages = r7;
    }

    public final String getId() {
        return this.id;
    }

    public final int getVersion() {
        return this.version;
    }

    public final long getDurationMs() {
        return this.durationMs;
    }

    public /* synthetic */ TextEffectSpec(String r8, int r9, long r10, LoopSpec.None r12, List r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L5;
        r9 = 1;
    L5:
        int r2 = r9;
        if ((r14 & 8) == 0) goto L8;
        r12 = LoopSpec.None.INSTANCE;
    L8:
        this(r8, r2, r10, r12, r13);
    }

    public final LoopSpec getLoop() {
        return this.loop;
    }

    public final List<EffectStage> getStages() {
        return this.stages;
    }
}
