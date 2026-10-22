package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
@ElementTypesAreNonnullByDefault
abstract class AbstractCompositeHashFunction extends AbstractHashFunction {
    private static final long serialVersionUID = 0;
    final HashFunction[] functions;

    abstract HashCode makeHash(Hasher[] r1);

    AbstractCompositeHashFunction(HashFunction... r4) {
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        Preconditions.checkNotNull(r4[r1]);
        r1 = r1 + 1;
        goto L3
    L5:
        this.functions = r4;
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        int r0 = this.functions.length;
        Hasher[] r1 = new Hasher[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L6;
        r1[r2] = this.functions[r2].newHasher();
        r2 = r2 + 1;
        goto L3
    L6:
        return fromHashers(r1);
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public Hasher newHasher(int r5) {
        int r0 = 0;
        if (r5 < 0) goto L5;
        boolean r1 = true;
    L6:
        Preconditions.checkArgument(r1);
        int r2 = this.functions.length;
        Hasher[] r3 = new Hasher[r2];
    L7:
        if (r0 >= r2) goto L10;
        r3[r0] = this.functions[r0].newHasher(r5);
        r0 = r0 + 1;
        goto L7
    L10:
        return fromHashers(r3);
    L5:
        r1 = false;
        goto L6
    }

    private Hasher fromHashers(final Hasher[] r2) {
        return new AnonymousClass1(this, r2);
    }
}
