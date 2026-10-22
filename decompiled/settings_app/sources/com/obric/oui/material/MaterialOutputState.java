package com.obric.oui.material;

import android.icu.text.PluralRules;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MaterialConfigFormatBuilders.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/obric/oui/material/MaterialOutputState;", "", "xmlName", "", "stateSet", "", "(Ljava/lang/String;[I)V", "getStateSet", "()[I", "getXmlName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", PluralRules.KEYWORD_OTHER, "hashCode", "", "toString", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class MaterialOutputState {
    private final int[] stateSet;
    private final String xmlName;

    public static /* synthetic */ MaterialOutputState copy$default(MaterialOutputState r0, String r1, int[] r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.xmlName;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.stateSet;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.xmlName;
    }

    public final int[] component2() {
        return this.stateSet;
    }

    public final MaterialOutputState copy(String r1, int[] r2) {
        Intrinsics.checkNotNullParameter(r1, "xmlName");
        Intrinsics.checkNotNullParameter(r2, "stateSet");
        return new MaterialOutputState(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MaterialOutputState) == true) goto L8;
        return false;
    L8:
        MaterialOutputState r6 = (MaterialOutputState) r5;
        if (Intrinsics.areEqual(this.xmlName, r6.xmlName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.stateSet, r6.stateSet) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.xmlName.hashCode() * 31) + Arrays.hashCode(this.stateSet);
    }

    public String toString() {
        return "MaterialOutputState(xmlName=" + this.xmlName + ", stateSet=" + Arrays.toString(this.stateSet) + ')';
    }

    public MaterialOutputState(String r2, int[] r3) {
        Intrinsics.checkNotNullParameter(r2, "xmlName");
        Intrinsics.checkNotNullParameter(r3, "stateSet");
        this.xmlName = r2;
        this.stateSet = r3;
    }

    public final String getXmlName() {
        return this.xmlName;
    }

    public final int[] getStateSet() {
        return this.stateSet;
    }
}
