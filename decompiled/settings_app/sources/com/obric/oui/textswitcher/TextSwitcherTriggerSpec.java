package com.obric.oui.textswitcher;

import android.icu.text.PluralRules;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: OTextSwitcher.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/obric/oui/textswitcher/TextSwitcherTriggerSpec;", "", "startDelayMs", "", "showInternalMs", "isOneLineNeedSwitch", "", "(JJZ)V", "()Z", "setOneLineNeedSwitch", "(Z)V", "getShowInternalMs", "()J", "setShowInternalMs", "(J)V", "getStartDelayMs", "setStartDelayMs", "component1", "component2", "component3", "copy", "equals", PluralRules.KEYWORD_OTHER, "hashCode", "", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TextSwitcherTriggerSpec {
    private boolean isOneLineNeedSwitch;
    private long showInternalMs;
    private long startDelayMs;

    public TextSwitcherTriggerSpec() {
        this(0, 0, false, 7, null);
    }

    public static /* synthetic */ TextSwitcherTriggerSpec copy$default(TextSwitcherTriggerSpec r6, long r7, long r9, boolean r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r7 = r6.startDelayMs;
    L5:
        long r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r9 = r6.showInternalMs;
    L8:
        long r3 = r9;
        if ((r12 & 4) == 0) goto L12;
        r11 = r6.isOneLineNeedSwitch;
    L12:
        return r6.copy(r1, r3, r11);
    }

    public final long component1() {
        return this.startDelayMs;
    }

    public final long component2() {
        return this.showInternalMs;
    }

    public final boolean component3() {
        return this.isOneLineNeedSwitch;
    }

    public final TextSwitcherTriggerSpec copy(long r7, long r9, boolean r11) {
        return new TextSwitcherTriggerSpec(r7, r9, r11);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof TextSwitcherTriggerSpec) == true) goto L8;
        return false;
    L8:
        TextSwitcherTriggerSpec r9 = (TextSwitcherTriggerSpec) r8;
        if (this.startDelayMs == r9.startDelayMs) goto L12;
        return false;
    L12:
        if (this.showInternalMs == r9.showInternalMs) goto L15;
        return false;
    L15:
        if (this.isOneLineNeedSwitch == r9.isOneLineNeedSwitch) goto L17;
        return false;
    L17:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    public int hashCode() {
        int r0 = ((Long.hashCode(this.startDelayMs) * 31) + Long.hashCode(this.showInternalMs)) * 31;
        boolean r3 = this.isOneLineNeedSwitch;
        ?? r4 = r3;
        if (r3 == false) goto L6;
        r4 = 1;
    L6:
        return r0 + r4;
    }

    public String toString() {
        return "TextSwitcherTriggerSpec(startDelayMs=" + this.startDelayMs + ", showInternalMs=" + this.showInternalMs + ", isOneLineNeedSwitch=" + this.isOneLineNeedSwitch + ')';
    }

    public TextSwitcherTriggerSpec(long r1, long r3, boolean r5) {
        this.startDelayMs = r1;
        this.showInternalMs = r3;
        this.isOneLineNeedSwitch = r5;
    }

    public /* synthetic */ TextSwitcherTriggerSpec(long r7, long r9, boolean r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L5;
        r7 = 0;
    L5:
        long r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r9 = 1000;
    L8:
        long r3 = r9;
        if ((r12 & 4) == 0) goto L11;
        r11 = false;
    L11:
        this(r1, r3, r11);
    }

    public final long getStartDelayMs() {
        return this.startDelayMs;
    }

    public final void setStartDelayMs(long r1) {
        this.startDelayMs = r1;
    }

    public final long getShowInternalMs() {
        return this.showInternalMs;
    }

    public final void setShowInternalMs(long r1) {
        this.showInternalMs = r1;
    }

    public final boolean isOneLineNeedSwitch() {
        return this.isOneLineNeedSwitch;
    }

    public final void setOneLineNeedSwitch(boolean r1) {
        this.isOneLineNeedSwitch = r1;
    }
}
