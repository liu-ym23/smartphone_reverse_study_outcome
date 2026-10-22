package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.security.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.zip.Checksum;
import javax.annotation.CheckForNull;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class Hashing {
    static final int GOOD_FAST_HASH_SEED = 0;

    /* JADX INFO: renamed from: com.google.common.hash.Hashing$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    @Immutable
    static abstract enum ChecksumType extends Enum<ChecksumType> implements ImmutableSupplier<Checksum> {
        private static final /* synthetic */ ChecksumType[] $VALUES = null;
        public static final ChecksumType ADLER_32 = null;
        public static final ChecksumType CRC_32 = null;
        public final HashFunction hashFunction;

        private static /* synthetic */ ChecksumType[] $values() {
            return new ChecksumType[]{CRC_32, ADLER_32};
        }

        public static ChecksumType valueOf(String r1) {
            return (ChecksumType) Enum.valueOf(ChecksumType.class, r1);
        }

        public static ChecksumType[] values() {
            return (ChecksumType[]) $VALUES.clone();
        }

        /* synthetic */ ChecksumType(String r1, int r2, String r3, AnonymousClass1 r4) {
            this(r1, r2, r3);
        }

        static {
            final int r1 = 0;
            final String r2 = "Hashing.crc32()";
            final String r3 = "CRC_32";
            CRC_32 = new AnonymousClass1(r3, r1, r2);
            final int r4 = 1;
            final String r5 = "Hashing.adler32()";
            final String r6 = "ADLER_32";
            ADLER_32 = new AnonymousClass2(r6, r4, r5);
            $VALUES = $values();
        }

        private ChecksumType(String r1, int r2, String r3) {
            super(r1, r2);
            this.hashFunction = new ChecksumHashFunction(this, 32, r3);
        }
    }

    private static final class ConcatenatedHashFunction extends AbstractCompositeHashFunction {
        /* synthetic */ ConcatenatedHashFunction(HashFunction[] r1, AnonymousClass1 r2) {
            this(r1);
        }

        private ConcatenatedHashFunction(HashFunction... r7) {
            super(r7);
            int r6 = r7.length;
            int r1 = 0;
        L3:
            if (r1 >= r6) goto L9;
            HashFunction r2 = r7[r1];
            if ((r2.bits() % 8) != 0) goto L7;
            boolean r3 = true;
        L8:
            Preconditions.checkArgument(r3, "the number of bits (%s) in hashFunction (%s) must be divisible by 8", r2.bits(), r2);
            r1 = r1 + 1;
            goto L3
        L7:
            r3 = false;
            goto L8
        }

        @Override // com.google.common.hash.AbstractCompositeHashFunction
        HashCode makeHash(Hasher[] r6) {
            byte[] r5 = new byte[bits() / 8];
            int r0 = r6.length;
            int r1 = 0;
            int r2 = 0;
        L3:
            if (r1 >= r0) goto L6;
            HashCode r3 = r6[r1].hash();
            r2 = r2 + r3.writeBytesTo(r5, r2, r3.bits() / 8);
            r1 = r1 + 1;
            goto L3
        L6:
            return HashCode.fromBytesNoCopy(r5);
        }

        @Override // com.google.common.hash.HashFunction
        public int bits() {
            HashFunction[] r4 = this.functions;
            int r0 = r4.length;
            int r1 = 0;
            int r2 = 0;
        L3:
            if (r1 >= r0) goto L5;
            r2 = r2 + r4[r1].bits();
            r1 = r1 + 1;
            goto L3
        L5:
            return r2;
        }

        public boolean equals(@CheckForNull Object r2) {
            if ((r2 instanceof ConcatenatedHashFunction) == true) goto L5;
            return false;
        L5:
            return Arrays.equals(this.functions, ((ConcatenatedHashFunction) r2).functions);
        }

        public int hashCode() {
            return Arrays.hashCode(this.functions);
        }
    }

    private static final class LinearCongruentialGenerator {
        private long state;

        public LinearCongruentialGenerator(long r1) {
            this.state = r1;
        }

        public double nextDouble() {
            long r2 = (this.state * 2862933555777941757L) + 1;
            this.state = r2;
            return ((double) (((int) (r2 >>> 33)) + 1)) / 2.147483648E9d;
        }
    }

    private static class Md5Holder {
        static final HashFunction MD5 = null;

        private Md5Holder() {
        }

        static {
            MD5 = new MessageDigestHashFunction("MD5", "Hashing.md5()");
        }
    }

    private static class Sha1Holder {
        static final HashFunction SHA_1 = null;

        private Sha1Holder() {
        }

        static {
            SHA_1 = new MessageDigestHashFunction("SHA-1", "Hashing.sha1()");
        }
    }

    private static class Sha256Holder {
        static final HashFunction SHA_256 = null;

        private Sha256Holder() {
        }

        static {
            SHA_256 = new MessageDigestHashFunction("SHA-256", "Hashing.sha256()");
        }
    }

    private static class Sha384Holder {
        static final HashFunction SHA_384 = null;

        private Sha384Holder() {
        }

        static {
            SHA_384 = new MessageDigestHashFunction("SHA-384", "Hashing.sha384()");
        }
    }

    private static class Sha512Holder {
        static final HashFunction SHA_512 = null;

        private Sha512Holder() {
        }

        static {
            SHA_512 = new MessageDigestHashFunction("SHA-512", "Hashing.sha512()");
        }
    }

    public static HashFunction goodFastHash(int r4) {
        int r5 = checkPositiveAndMakeMultipleOf32(r4);
        if (r5 != 32) goto L7;
        return Murmur3_32HashFunction.GOOD_FAST_HASH_32;
    L7:
        if (r5 <= 128) goto L9;
        int r6 = (r5 + 127) / 128;
        HashFunction[] r0 = new HashFunction[r6];
        r0[0] = Murmur3_128HashFunction.GOOD_FAST_HASH_128;
        int r1 = GOOD_FAST_HASH_SEED;
        int r2 = 1;
    L11:
        if (r2 >= r6) goto L14;
        r1 = r1 + 1500450271;
        r0[r2] = murmur3_128(r1);
        r2 = r2 + 1;
        goto L11
    L14:
        return new ConcatenatedHashFunction(r0, null);
    L9:
        return Murmur3_128HashFunction.GOOD_FAST_HASH_128;
    }

    static {
        GOOD_FAST_HASH_SEED = (int) System.currentTimeMillis();
    }

    @Deprecated
    public static HashFunction murmur3_32(int r2) {
        return new Murmur3_32HashFunction(r2, false);
    }

    @Deprecated
    public static HashFunction murmur3_32() {
        return Murmur3_32HashFunction.MURMUR3_32;
    }

    public static HashFunction murmur3_32_fixed(int r2) {
        return new Murmur3_32HashFunction(r2, true);
    }

    public static HashFunction murmur3_32_fixed() {
        return Murmur3_32HashFunction.MURMUR3_32_FIXED;
    }

    public static HashFunction murmur3_128(int r1) {
        return new Murmur3_128HashFunction(r1);
    }

    public static HashFunction murmur3_128() {
        return Murmur3_128HashFunction.MURMUR3_128;
    }

    public static HashFunction sipHash24() {
        return SipHashFunction.SIP_HASH_24;
    }

    public static HashFunction sipHash24(long r8, long r10) {
        return new SipHashFunction(2, 4, r8, r10);
    }

    @Deprecated
    public static HashFunction md5() {
        return Md5Holder.MD5;
    }

    @Deprecated
    public static HashFunction sha1() {
        return Sha1Holder.SHA_1;
    }

    public static HashFunction sha256() {
        return Sha256Holder.SHA_256;
    }

    public static HashFunction sha384() {
        return Sha384Holder.SHA_384;
    }

    public static HashFunction sha512() {
        return Sha512Holder.SHA_512;
    }

    public static HashFunction hmacMd5(Key r3) {
        return new MacHashFunction("HmacMD5", r3, hmacToString("hmacMd5", r3));
    }

    public static HashFunction hmacMd5(byte[] r2) {
        return hmacMd5(new SecretKeySpec((byte[]) Preconditions.checkNotNull(r2), "HmacMD5"));
    }

    public static HashFunction hmacSha1(Key r3) {
        return new MacHashFunction("HmacSHA1", r3, hmacToString("hmacSha1", r3));
    }

    public static HashFunction hmacSha1(byte[] r2) {
        return hmacSha1(new SecretKeySpec((byte[]) Preconditions.checkNotNull(r2), "HmacSHA1"));
    }

    public static HashFunction hmacSha256(Key r3) {
        return new MacHashFunction("HmacSHA256", r3, hmacToString("hmacSha256", r3));
    }

    public static HashFunction hmacSha256(byte[] r2) {
        return hmacSha256(new SecretKeySpec((byte[]) Preconditions.checkNotNull(r2), "HmacSHA256"));
    }

    public static HashFunction hmacSha512(Key r3) {
        return new MacHashFunction("HmacSHA512", r3, hmacToString("hmacSha512", r3));
    }

    public static HashFunction hmacSha512(byte[] r2) {
        return hmacSha512(new SecretKeySpec((byte[]) Preconditions.checkNotNull(r2), "HmacSHA512"));
    }

    private static String hmacToString(String r2, Key r3) {
        return String.format("Hashing.%s(Key[algorithm=%s, format=%s])", new Object[]{r2, r3.getAlgorithm(), r3.getFormat()});
    }

    public static HashFunction crc32c() {
        return Crc32cHashFunction.CRC_32_C;
    }

    public static HashFunction crc32() {
        return ChecksumType.CRC_32.hashFunction;
    }

    public static HashFunction adler32() {
        return ChecksumType.ADLER_32.hashFunction;
    }

    public static HashFunction farmHashFingerprint64() {
        return FarmHashFingerprint64.FARMHASH_FINGERPRINT_64;
    }

    public static int consistentHash(HashCode r2, int r3) {
        return consistentHash(r2.padToLong(), r3);
    }

    public static int consistentHash(long r4, int r6) {
        int r0 = 0;
        if (r6 <= 0) goto L5;
        boolean r1 = true;
    L6:
        Preconditions.checkArgument(r1, "buckets must be positive: %s", r6);
        LinearCongruentialGenerator r2 = new LinearCongruentialGenerator(r4);
    L7:
        int r5 = (int) (((double) (r0 + 1)) / r2.nextDouble());
        if (r5 < 0) goto L11;
        if (r5 >= r6) goto L11;
        r0 = r5;
    L11:
        return r0;
    L5:
        r1 = false;
        goto L6
    }

    public static HashCode combineOrdered(Iterable<HashCode> r6) {
        Iterator<HashCode> r0 = r6.iterator();
        Preconditions.checkArgument(r0.hasNext(), "Must be at least 1 hash code to combine.");
        int r1 = r0.next().bits() / 8;
        byte[] r2 = new byte[r1];
        Iterator<HashCode> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L14;
        byte[] r3 = r7.next().asBytes();
        int r4 = 0;
        if (r3.length != r1) goto L8;
        boolean r5 = true;
    L9:
        Preconditions.checkArgument(r5, "All hashcodes must have the same bit length.");
    L11:
        if (r4 >= r3.length) goto L4;
        r2[r4] = (byte) ((r2[r4] * 37) ^ r3[r4]);
        r4 = r4 + 1;
        goto L11
    L8:
        r5 = false;
        goto L9
    L14:
        return HashCode.fromBytesNoCopy(r2);
    }

    public static HashCode combineUnordered(Iterable<HashCode> r6) {
        Iterator<HashCode> r0 = r6.iterator();
        Preconditions.checkArgument(r0.hasNext(), "Must be at least 1 hash code to combine.");
        int r1 = r0.next().bits() / 8;
        byte[] r2 = new byte[r1];
        Iterator<HashCode> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L14;
        byte[] r3 = r7.next().asBytes();
        int r4 = 0;
        if (r3.length != r1) goto L8;
        boolean r5 = true;
    L9:
        Preconditions.checkArgument(r5, "All hashcodes must have the same bit length.");
    L11:
        if (r4 >= r3.length) goto L4;
        r2[r4] = (byte) (r2[r4] + r3[r4]);
        r4 = r4 + 1;
        goto L11
    L8:
        r5 = false;
        goto L9
    L14:
        return HashCode.fromBytesNoCopy(r2);
    }

    static int checkPositiveAndMakeMultipleOf32(int r2) {
        if (r2 <= 0) goto L4;
        boolean r0 = true;
    L5:
        Preconditions.checkArgument(r0, "Number of bits must be positive");
        return (r2 + 31) & (-32);
    L4:
        r0 = false;
        goto L5
    }

    public static HashFunction concatenating(HashFunction r1, HashFunction r2, HashFunction... r3) {
        ArrayList r0 = new ArrayList();
        r0.add(r1);
        r0.add(r2);
        r0.addAll(Arrays.asList(r3));
        return new ConcatenatedHashFunction((HashFunction[]) r0.toArray(new HashFunction[0]), null);
    }

    public static HashFunction concatenating(Iterable<HashFunction> r4) {
        Preconditions.checkNotNull(r4);
        ArrayList r0 = new ArrayList();
        Iterator<HashFunction> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L7;
        r0.add(r5.next());
        goto L4
    L7:
        if (r0.size() <= 0) goto L9;
        boolean r6 = true;
    L10:
        Preconditions.checkArgument(r6, "number of hash functions (%s) must be > 0", r0.size());
        return new ConcatenatedHashFunction((HashFunction[]) r0.toArray(new HashFunction[0]), null);
    L9:
        r6 = false;
        goto L10
    }

    private Hashing() {
    }
}
