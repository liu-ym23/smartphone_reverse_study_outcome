package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
@ElementTypesAreNonnullByDefault
final class MessageDigestHashFunction extends AbstractHashFunction implements Serializable {
    private final int bytes;
    private final MessageDigest prototype;
    private final boolean supportsClone;
    private final String toString;

    /* JADX INFO: renamed from: com.google.common.hash.MessageDigestHashFunction$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class MessageDigestHasher extends AbstractByteHasher {
        private final int bytes;
        private final MessageDigest digest;
        private boolean done;

        /* synthetic */ MessageDigestHasher(MessageDigest r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private MessageDigestHasher(MessageDigest r1, int r2) {
            this.digest = r1;
            this.bytes = r2;
        }

        @Override // com.google.common.hash.AbstractByteHasher
        protected void update(byte r1) {
            checkNotDone();
            this.digest.update(r1);
        }

        @Override // com.google.common.hash.AbstractByteHasher
        protected void update(byte[] r1, int r2, int r3) {
            checkNotDone();
            this.digest.update(r1, r2, r3);
        }

        @Override // com.google.common.hash.AbstractByteHasher
        protected void update(ByteBuffer r1) {
            checkNotDone();
            this.digest.update(r1);
        }

        private void checkNotDone() {
            Preconditions.checkState(!this.done, "Cannot re-use a Hasher after calling hash() on it");
        }

        @Override // com.google.common.hash.Hasher
        public HashCode hash() {
            checkNotDone();
            this.done = true;
            if (this.bytes != this.digest.getDigestLength()) goto L6;
            return HashCode.fromBytesNoCopy(this.digest.digest());
        L6:
            return HashCode.fromBytesNoCopy(Arrays.copyOf(this.digest.digest(), this.bytes));
        }
    }

    private static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final String algorithmName;
        private final int bytes;
        private final String toString;

        /* synthetic */ SerializedForm(String r1, int r2, String r3, AnonymousClass1 r4) {
            this(r1, r2, r3);
        }

        private SerializedForm(String r1, int r2, String r3) {
            this.algorithmName = r1;
            this.bytes = r2;
            this.toString = r3;
        }

        private Object readResolve() {
            return new MessageDigestHashFunction(this.algorithmName, this.bytes, this.toString);
        }
    }

    MessageDigestHashFunction(String r2, String r3) {
        MessageDigest r4 = getMessageDigest(r2);
        this.prototype = r4;
        this.bytes = r4.getDigestLength();
        this.toString = (String) Preconditions.checkNotNull(r3);
        this.supportsClone = supportsClone(r4);
    }

    MessageDigestHashFunction(String r3, int r4, String r5) {
        this.toString = (String) Preconditions.checkNotNull(r5);
        MessageDigest r6 = getMessageDigest(r3);
        this.prototype = r6;
        int r7 = r6.getDigestLength();
        if (r4 < 4) goto L6;
        if (r4 > r7) goto L6;
        boolean r0 = true;
    L7:
        Preconditions.checkArgument(r0, "bytes (%s) must be >= 4 and < %s", r4, r7);
        this.bytes = r4;
        this.supportsClone = supportsClone(r6);
        return;
    L6:
        r0 = false;
        goto L7
    }

    private static boolean supportsClone(MessageDigest r0) {
        r0.clone();     // Catch: CloneNotSupportedException -> L5
        return true;
    L5:
        return false;
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return this.bytes * 8;
    }

    public String toString() {
        return this.toString;
    }

    private static MessageDigest getMessageDigest(String r1) {
        return MessageDigest.getInstance(r1);
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        AnonymousClass1 r1 = null;
        if (this.supportsClone == false) goto L7;
        return new MessageDigestHasher((MessageDigest) this.prototype.clone(), this.bytes, r1);
    L7:
        return new MessageDigestHasher(getMessageDigest(this.prototype.getAlgorithm()), this.bytes, r1);
    }

    Object writeReplace() {
        return new SerializedForm(this.prototype.getAlgorithm(), this.bytes, this.toString, null);
    }
}
