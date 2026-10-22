package com.google.common.escape;

import com.google.common.base.Preconditions;
import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public abstract class ArrayBasedCharEscaper extends CharEscaper {
    private final char[][] replacements;
    private final int replacementsLength;
    private final char safeMax;
    private final char safeMin;

    @CheckForNull
    protected abstract char[] escapeUnsafe(char r1);

    protected ArrayBasedCharEscaper(Map<Character, String> r1, char r2, char r3) {
        this(ArrayBasedEscaperMap.create(r1), r2, r3);
    }

    protected ArrayBasedCharEscaper(ArrayBasedEscaperMap r1, char r2, char r3) {
        Preconditions.checkNotNull(r1);
        char[][] r4 = r1.getReplacementArray();
        this.replacements = r4;
        this.replacementsLength = r4.length;
        if (r3 >= r2) goto L5;
        r3 = 0;
        r2 = 65535;
    L5:
        this.safeMin = r2;
        this.safeMax = r3;
    }

    @Override // com.google.common.escape.CharEscaper, com.google.common.escape.Escaper
    public final String escape(String r4) {
        Preconditions.checkNotNull(r4);
        int r0 = 0;
    L4:
        if (r0 >= r4.length()) goto L17;
        char r1 = r4.charAt(r0);
        if (r1 >= this.replacementsLength) goto L10;
        if (this.replacements[r1] == null) goto L10;
    L16:
        return escapeSlow(r4, r0);
    L10:
        if (r1 > this.safeMax) goto L16;
        if (r1 < this.safeMin) goto L16;
        r0 = r0 + 1;
        goto L4
    L17:
        return r4;
    }

    @Override // com.google.common.escape.CharEscaper
    @CheckForNull
    protected final char[] escape(char r2) {
        if (r2 >= this.replacementsLength) goto L8;
        char[] r0 = this.replacements[r2];
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (r2 < this.safeMin) goto L14;
        if (r2 > this.safeMax) goto L14;
        return null;
    L14:
        return escapeUnsafe(r2);
    }
}
