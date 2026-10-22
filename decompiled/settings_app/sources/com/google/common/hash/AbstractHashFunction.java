package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
@ElementTypesAreNonnullByDefault
abstract class AbstractHashFunction implements HashFunction {
    AbstractHashFunction() {
    }

    @Override // com.google.common.hash.HashFunction
    public <T> HashCode hashObject(@ParametricNullness T r1, Funnel<? super T> r2) {
        return newHasher().putObject(r1, r2).hash();
    }

    @Override // com.google.common.hash.HashFunction
    public HashCode hashUnencodedChars(CharSequence r2) {
        return newHasher(r2.length() * 2).putUnencodedChars(r2).hash();
    }

    @Override // com.google.common.hash.HashFunction
    public HashCode hashString(CharSequence r1, Charset r2) {
        return newHasher().putString(r1, r2).hash();
    }

    @Override // com.google.common.hash.HashFunction
    public HashCode hashInt(int r2) {
        return newHasher(4).putInt(r2).hash();
    }

    @Override // com.google.common.hash.HashFunction
    public HashCode hashLong(long r2) {
        return newHasher(8).putLong(r2).hash();
    }

    @Override // com.google.common.hash.HashFunction
    public HashCode hashBytes(byte[] r3) {
        return hashBytes(r3, 0, r3.length);
    }

    @Override // com.google.common.hash.HashFunction
    public HashCode hashBytes(byte[] r3, int r4, int r5) {
        Preconditions.checkPositionIndexes(r4, r4 + r5, r3.length);
        return newHasher(r5).putBytes(r3, r4, r5).hash();
    }

    @Override // com.google.common.hash.HashFunction
    public HashCode hashBytes(ByteBuffer r2) {
        return newHasher(r2.remaining()).putBytes(r2).hash();
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher(int r3) {
        if (r3 < 0) goto L4;
        boolean r0 = true;
    L5:
        Preconditions.checkArgument(r0, "expectedInputSize must be >= 0 but was %s", r3);
        return newHasher();
    L4:
        r0 = false;
        goto L5
    }
}
