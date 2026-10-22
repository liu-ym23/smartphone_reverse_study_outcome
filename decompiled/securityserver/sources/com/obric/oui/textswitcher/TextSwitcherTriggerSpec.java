package com.obric.oui.textswitcher;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class TextSwitcherTriggerSpec {
    public final boolean equals(Object r1) {
        if (this != r1) goto L4;
        return true;
    L4:
        if ((r1 instanceof TextSwitcherTriggerSpec) == false) goto L6;
        ((TextSwitcherTriggerSpec) r1).getClass();
        return true;
    L6:
        return false;
    }

    public final int hashCode() {
        int r2 = Long.hashCode(0) * 31;
        return (Long.hashCode(0) + r2) * 31;
    }

    public final String toString() {
        return "TextSwitcherTriggerSpec(startDelayMs=0, showInternalMs=0, isOneLineNeedSwitch=false)";
    }
}
