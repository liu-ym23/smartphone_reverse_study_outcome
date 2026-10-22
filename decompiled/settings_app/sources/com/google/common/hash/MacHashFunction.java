package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
@ElementTypesAreNonnullByDefault
final class MacHashFunction extends AbstractHashFunction {
    private final int bits;
    private final Key key;
    private final Mac prototype;
    private final boolean supportsClone;
    private final String toString;

    /* JADX INFO: renamed from: com.google.common.hash.MacHashFunction$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class MacHasher extends AbstractByteHasher {
        private boolean done;
        private final Mac mac;

        /* synthetic */ MacHasher(Mac r1, AnonymousClass1 r2) {
            this(r1);
        }

        private MacHasher(Mac r1) {
            this.mac = r1;
        }

        @Override // com.google.common.hash.AbstractByteHasher
        protected void update(byte r1) {
            checkNotDone();
            this.mac.update(r1);
        }

        @Override // com.google.common.hash.AbstractByteHasher
        protected void update(byte[] r1) {
            checkNotDone();
            this.mac.update(r1);
        }

        @Override // com.google.common.hash.AbstractByteHasher
        protected void update(byte[] r1, int r2, int r3) {
            checkNotDone();
            this.mac.update(r1, r2, r3);
        }

        @Override // com.google.common.hash.AbstractByteHasher
        protected void update(ByteBuffer r1) {
            checkNotDone();
            Preconditions.checkNotNull(r1);
            this.mac.update(r1);
        }

        private void checkNotDone() {
            Preconditions.checkState(!this.done, "Cannot re-use a Hasher after calling hash() on it");
        }

        @Override // com.google.common.hash.Hasher
        public HashCode hash() {
            checkNotDone();
            this.done = true;
            return HashCode.fromBytesNoCopy(this.mac.doFinal());
        }
    }

    MacHashFunction(String r1, Key r2, String r3) {
        Mac r4 = getMac(r1, r2);
        this.prototype = r4;
        this.key = (Key) Preconditions.checkNotNull(r2);
        this.toString = (String) Preconditions.checkNotNull(r3);
        this.bits = r4.getMacLength() * 8;
        this.supportsClone = supportsClone(r4);
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return this.bits;
    }

    private static boolean supportsClone(Mac r0) {
        r0.clone();     // Catch: CloneNotSupportedException -> L5
        return true;
    L5:
        return false;
    }

    private static Mac getMac(String r0, Key r1) {
        Mac r2 = Mac.getInstance(r0);     // Catch: InvalidKeyException -> L4 NoSuchAlgorithmException -> L7
        r2.init(r1);     // Catch: InvalidKeyException -> L4 NoSuchAlgorithmException -> L7
        return r2;
    L4:
        e = move-exception;
        throw new IllegalArgumentException(e);
    L7:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        AnonymousClass1 r1 = null;
        if (this.supportsClone == false) goto L7;
        return new MacHasher((Mac) this.prototype.clone(), r1);
    L7:
        return new MacHasher(getMac(this.prototype.getAlgorithm(), this.key), r1);
    }

    public String toString() {
        return this.toString;
    }
}
