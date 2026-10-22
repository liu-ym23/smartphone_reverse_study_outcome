package com.google.crypto.tink.subtle;

import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.StreamingAead;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.streamingaead.AesCtrHmacStreamingKey;
import com.google.crypto.tink.streamingaead.AesCtrHmacStreamingParameters;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes4.dex */
public final class AesCtrHmacStreaming extends NonceBasedStreamingAead {
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = null;
    private static final int HMAC_KEY_SIZE_IN_BYTES = 32;
    private static final int NONCE_PREFIX_IN_BYTES = 7;
    private static final int NONCE_SIZE_IN_BYTES = 16;
    private final int ciphertextSegmentSize;
    private final int firstSegmentOffset;
    private final String hkdfAlgo;
    private final byte[] ikm;
    private final int keySizeInBytes;
    private final int plaintextSegmentSize;
    private final String tagAlgo;
    private final int tagSizeInBytes;

    class AesCtrHmacStreamDecrypter implements StreamSegmentDecrypter {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private Cipher cipher;
        private SecretKeySpec hmacKeySpec;
        private SecretKeySpec keySpec;
        private Mac mac;
        private byte[] noncePrefix;
        final /* synthetic */ AesCtrHmacStreaming this$0;

        static {
        }

        AesCtrHmacStreamDecrypter(final AesCtrHmacStreaming this$0) {
            this.this$0 = this$0;
        }

        @Override // com.google.crypto.tink.subtle.StreamSegmentDecrypter
        public synchronized void init(ByteBuffer header, byte[] aad) throws GeneralSecurityException {
            monitor-enter(this);
        L14:
            th = move-exception;
            throw th;
        L4:
            if (header.remaining() != this.this$0.getHeaderLength()) goto L13;
            if (header.get() != this.this$0.getHeaderLength()) goto L11;
            this.noncePrefix = new byte[7];     // Catch: Throwable -> L14
            byte[] r0 = new byte[AesCtrHmacStreaming.access$900(this.this$0)];     // Catch: Throwable -> L14
            header.get(r0);     // Catch: Throwable -> L14
            header.get(this.noncePrefix);     // Catch: Throwable -> L14
            byte[] r3 = AesCtrHmacStreaming.access$400(this.this$0, r0, aad);     // Catch: Throwable -> L14
            this.keySpec = AesCtrHmacStreaming.access$500(this.this$0, r3);     // Catch: Throwable -> L14
            this.hmacKeySpec = AesCtrHmacStreaming.access$600(this.this$0, r3);     // Catch: Throwable -> L14
            this.cipher = AesCtrHmacStreaming.access$000();     // Catch: Throwable -> L14
            this.mac = AesCtrHmacStreaming.access$100(this.this$0);     // Catch: Throwable -> L14
            monitor-exit(this);
            return;
        L11:
            throw new GeneralSecurityException("Invalid ciphertext");     // Catch: Throwable -> L14
        L13:
            throw new InvalidAlgorithmParameterException("Invalid header length");     // Catch: Throwable -> L14
        }

        @Override // com.google.crypto.tink.subtle.StreamSegmentDecrypter
        public synchronized void decryptSegment(ByteBuffer ciphertext, int segmentNr, boolean isLastSegment, ByteBuffer plaintext) throws GeneralSecurityException {
            monitor-enter(this);
            int r0 = ciphertext.position();     // Catch: Throwable -> L14
            byte[] r7 = AesCtrHmacStreaming.access$700(this.this$0, this.noncePrefix, segmentNr, isLastSegment);     // Catch: Throwable -> L14
            int r8 = ciphertext.remaining();     // Catch: Throwable -> L14
            if (r8 < AesCtrHmacStreaming.access$800(this.this$0)) goto L13;
            int r1 = r0 + (r8 - AesCtrHmacStreaming.access$800(this.this$0));     // Catch: Throwable -> L14
            ByteBuffer r9 = ciphertext.duplicate();     // Catch: Throwable -> L14
            r9.limit(r1);     // Catch: Throwable -> L14
            ByteBuffer r2 = ciphertext.duplicate();     // Catch: Throwable -> L14
            r2.position(r1);     // Catch: Throwable -> L14
            this.mac.init(this.hmacKeySpec);     // Catch: Throwable -> L14
            this.mac.update(r7);     // Catch: Throwable -> L14
            this.mac.update(r9);     // Catch: Throwable -> L14
            byte[] r10 = Arrays.copyOf(this.mac.doFinal(), AesCtrHmacStreaming.access$800(this.this$0));     // Catch: Throwable -> L14
            byte[] r3 = new byte[AesCtrHmacStreaming.access$800(this.this$0)];     // Catch: Throwable -> L14
            r2.get(r3);     // Catch: Throwable -> L14
            if (Bytes.equal(r3, r10) == false) goto L11;
            ciphertext.limit(r1);     // Catch: Throwable -> L14
            this.cipher.init(1, this.keySpec, new IvParameterSpec(r7));     // Catch: Throwable -> L14
            this.cipher.doFinal(ciphertext, plaintext);     // Catch: Throwable -> L14
            monitor-exit(this);
            return;
        L11:
            throw new GeneralSecurityException("Tag mismatch");     // Catch: Throwable -> L14
        L13:
            throw new GeneralSecurityException("Ciphertext too short");     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            throw th;
        }
    }

    class AesCtrHmacStreamEncrypter implements StreamSegmentEncrypter {
        private final Cipher cipher;
        private long encryptedSegments;
        private ByteBuffer header;
        private final SecretKeySpec hmacKeySpec;
        private final SecretKeySpec keySpec;
        private final Mac mac;
        private final byte[] noncePrefix;
        final /* synthetic */ AesCtrHmacStreaming this$0;

        public AesCtrHmacStreamEncrypter(final AesCtrHmacStreaming this$0, byte[] aad) throws GeneralSecurityException {
            this.this$0 = this$0;
            this.encryptedSegments = 0;
            this.cipher = AesCtrHmacStreaming.access$000();
            this.mac = AesCtrHmacStreaming.access$100(this$0);
            this.encryptedSegments = 0;
            byte[] r0 = AesCtrHmacStreaming.access$200(this$0);
            byte[] r1 = AesCtrHmacStreaming.access$300(this$0);
            this.noncePrefix = r1;
            ByteBuffer r2 = ByteBuffer.allocate(this$0.getHeaderLength());
            this.header = r2;
            r2.put((byte) this$0.getHeaderLength());
            this.header.put(r0);
            this.header.put(r1);
            this.header.flip();
            byte[] r6 = AesCtrHmacStreaming.access$400(this$0, r0, aad);
            this.keySpec = AesCtrHmacStreaming.access$500(this$0, r6);
            this.hmacKeySpec = AesCtrHmacStreaming.access$600(this$0, r6);
        }

        @Override // com.google.crypto.tink.subtle.StreamSegmentEncrypter
        public ByteBuffer getHeader() {
            return this.header.asReadOnlyBuffer();
        }

        @Override // com.google.crypto.tink.subtle.StreamSegmentEncrypter
        public synchronized void encryptSegment(ByteBuffer plaintext, boolean isLastSegment, ByteBuffer ciphertext) throws GeneralSecurityException {
            monitor-enter(this);
            int r0 = ciphertext.position();     // Catch: Throwable -> L6
            byte[] r7 = AesCtrHmacStreaming.access$700(this.this$0, this.noncePrefix, this.encryptedSegments, isLastSegment);     // Catch: Throwable -> L6
            this.cipher.init(1, this.keySpec, new IvParameterSpec(r7));     // Catch: Throwable -> L6
            this.encryptedSegments++;     // Catch: Throwable -> L6
            this.cipher.doFinal(plaintext, ciphertext);     // Catch: Throwable -> L6
            ByteBuffer r6 = ciphertext.duplicate();     // Catch: Throwable -> L6
            r6.flip();     // Catch: Throwable -> L6
            r6.position(r0);     // Catch: Throwable -> L6
            this.mac.init(this.hmacKeySpec);     // Catch: Throwable -> L6
            this.mac.update(r7);     // Catch: Throwable -> L6
            this.mac.update(r6);     // Catch: Throwable -> L6
            ciphertext.put(this.mac.doFinal(), 0, AesCtrHmacStreaming.access$800(this.this$0));     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        @Override // com.google.crypto.tink.subtle.StreamSegmentEncrypter
        public synchronized void encryptSegment(ByteBuffer part1, ByteBuffer part2, boolean isLastSegment, ByteBuffer ciphertext) throws GeneralSecurityException {
            monitor-enter(this);
            int r0 = ciphertext.position();     // Catch: Throwable -> L6
            byte[] r8 = AesCtrHmacStreaming.access$700(this.this$0, this.noncePrefix, this.encryptedSegments, isLastSegment);     // Catch: Throwable -> L6
            this.cipher.init(1, this.keySpec, new IvParameterSpec(r8));     // Catch: Throwable -> L6
            this.encryptedSegments++;     // Catch: Throwable -> L6
            this.cipher.update(part1, ciphertext);     // Catch: Throwable -> L6
            this.cipher.doFinal(part2, ciphertext);     // Catch: Throwable -> L6
            ByteBuffer r6 = ciphertext.duplicate();     // Catch: Throwable -> L6
            r6.flip();     // Catch: Throwable -> L6
            r6.position(r0);     // Catch: Throwable -> L6
            this.mac.init(this.hmacKeySpec);     // Catch: Throwable -> L6
            this.mac.update(r8);     // Catch: Throwable -> L6
            this.mac.update(r6);     // Catch: Throwable -> L6
            ciphertext.put(this.mac.doFinal(), 0, AesCtrHmacStreaming.access$800(this.this$0));     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead, com.google.crypto.tink.StreamingAead
    public /* bridge */ /* synthetic */ ReadableByteChannel newDecryptingChannel(ReadableByteChannel ciphertextChannel, byte[] associatedData) throws GeneralSecurityException, IOException {
        return super.newDecryptingChannel(ciphertextChannel, associatedData);
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead, com.google.crypto.tink.StreamingAead
    public /* bridge */ /* synthetic */ InputStream newDecryptingStream(InputStream ciphertextStream, byte[] associatedData) throws GeneralSecurityException, IOException {
        return super.newDecryptingStream(ciphertextStream, associatedData);
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead, com.google.crypto.tink.StreamingAead
    public /* bridge */ /* synthetic */ WritableByteChannel newEncryptingChannel(WritableByteChannel ciphertextChannel, byte[] associatedData) throws GeneralSecurityException, IOException {
        return super.newEncryptingChannel(ciphertextChannel, associatedData);
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead, com.google.crypto.tink.StreamingAead
    public /* bridge */ /* synthetic */ OutputStream newEncryptingStream(OutputStream ciphertext, byte[] associatedData) throws GeneralSecurityException, IOException {
        return super.newEncryptingStream(ciphertext, associatedData);
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead, com.google.crypto.tink.StreamingAead
    public /* bridge */ /* synthetic */ SeekableByteChannel newSeekableDecryptingChannel(SeekableByteChannel ciphertextSource, byte[] associatedData) throws GeneralSecurityException, IOException {
        return super.newSeekableDecryptingChannel(ciphertextSource, associatedData);
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public /* bridge */ /* synthetic */ StreamSegmentDecrypter newStreamSegmentDecrypter() throws GeneralSecurityException {
        return newStreamSegmentDecrypter();
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public /* bridge */ /* synthetic */ StreamSegmentEncrypter newStreamSegmentEncrypter(byte[] aad) throws GeneralSecurityException {
        return newStreamSegmentEncrypter(aad);
    }

    static /* synthetic */ Cipher access$000() throws GeneralSecurityException {
        return cipherInstance();
    }

    static /* synthetic */ Mac access$100(AesCtrHmacStreaming r0) throws GeneralSecurityException {
        return r0.macInstance();
    }

    static /* synthetic */ byte[] access$200(AesCtrHmacStreaming r0) {
        return r0.randomSalt();
    }

    static /* synthetic */ byte[] access$300(AesCtrHmacStreaming r0) {
        return r0.randomNonce();
    }

    static /* synthetic */ byte[] access$400(AesCtrHmacStreaming r0, byte[] r1, byte[] r2) throws GeneralSecurityException {
        return r0.deriveKeyMaterial(r1, r2);
    }

    static /* synthetic */ SecretKeySpec access$500(AesCtrHmacStreaming r0, byte[] r1) throws GeneralSecurityException {
        return r0.deriveKeySpec(r1);
    }

    static /* synthetic */ SecretKeySpec access$600(AesCtrHmacStreaming r0, byte[] r1) throws GeneralSecurityException {
        return r0.deriveHmacKeySpec(r1);
    }

    static /* synthetic */ byte[] access$700(AesCtrHmacStreaming r0, byte[] r1, long r2, boolean r4) throws GeneralSecurityException {
        return r0.nonceForSegment(r1, r2, r4);
    }

    static /* synthetic */ int access$800(AesCtrHmacStreaming r0) {
        return r0.tagSizeInBytes;
    }

    static /* synthetic */ int access$900(AesCtrHmacStreaming r0) {
        return r0.keySizeInBytes;
    }

    static {
        FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS;
    }

    public AesCtrHmacStreaming(byte[] ikm, String hkdfAlgo, int keySizeInBytes, String tagAlgo, int tagSizeInBytes, int ciphertextSegmentSize, int firstSegmentOffset) throws GeneralSecurityException {
        if (FIPS.isCompatible() == false) goto L7;
        validateParameters(ikm.length, keySizeInBytes, tagAlgo, tagSizeInBytes, ciphertextSegmentSize, firstSegmentOffset);
        this.ikm = Arrays.copyOf(ikm, ikm.length);
        this.hkdfAlgo = hkdfAlgo;
        this.keySizeInBytes = keySizeInBytes;
        this.tagAlgo = tagAlgo;
        this.tagSizeInBytes = tagSizeInBytes;
        this.ciphertextSegmentSize = ciphertextSegmentSize;
        this.firstSegmentOffset = firstSegmentOffset;
        this.plaintextSegmentSize = ciphertextSegmentSize - tagSizeInBytes;
        return;
    L7:
        throw new GeneralSecurityException("Can not use AES-CTR-HMAC streaming in FIPS-mode.");
    }

    private AesCtrHmacStreaming(AesCtrHmacStreamingKey key) throws GeneralSecurityException {
        if (FIPS.isCompatible() == false) goto L27;
        this.ikm = key.getInitialKeyMaterial().toByteArray(InsecureSecretKeyAccess.get());
        String r1 = "HmacSha512";
        if (key.getParameters().getHkdfHashType().equals(AesCtrHmacStreamingParameters.HashType.SHA1) == false) goto L8;
        String r0 = "HmacSha1";
    L14:
        this.hkdfAlgo = r0;
        this.keySizeInBytes = key.getParameters().getDerivedKeySizeBytes();
        if (key.getParameters().getHmacHashType().equals(AesCtrHmacStreamingParameters.HashType.SHA1) == false) goto L18;
        r1 = "HmacSha1";
    L24:
        this.tagAlgo = r1;
        int r2 = key.getParameters().getHmacTagSizeBytes();
        this.tagSizeInBytes = r2;
        int r7 = key.getParameters().getCiphertextSegmentSizeBytes();
        this.ciphertextSegmentSize = r7;
        this.firstSegmentOffset = 0;
        this.plaintextSegmentSize = r7 - r2;
        return;
    L18:
        if (key.getParameters().getHmacHashType().equals(AesCtrHmacStreamingParameters.HashType.SHA256) == false) goto L21;
        r1 = "HmacSha256";
        goto L24
    L21:
        if (key.getParameters().getHmacHashType().equals(AesCtrHmacStreamingParameters.HashType.SHA512) == true) goto L24;
        r1 = "";
        goto L24
    L8:
        if (key.getParameters().getHkdfHashType().equals(AesCtrHmacStreamingParameters.HashType.SHA256) == false) goto L11;
        r0 = "HmacSha256";
        goto L14
    L11:
        if (key.getParameters().getHkdfHashType().equals(AesCtrHmacStreamingParameters.HashType.SHA512) == false) goto L13;
        r0 = "HmacSha512";
        goto L14
    L13:
        r0 = "";
        goto L14
    L27:
        throw new GeneralSecurityException("Can not use AES-CTR-HMAC streaming in FIPS-mode.");
    }

    public static StreamingAead create(AesCtrHmacStreamingKey key) throws GeneralSecurityException {
        return new AesCtrHmacStreaming(key);
    }

    private static void validateParameters(int ikmSize, int keySizeInBytes, String tagAlgo, int tagSizeInBytes, int ciphertextSegmentSize, int firstSegmentOffset) throws InvalidAlgorithmParameterException {
        if (ikmSize < 16) goto L30;
        if (ikmSize < keySizeInBytes) goto L30;
        Validators.validateAesKeySize(keySizeInBytes);
        if (tagSizeInBytes < 10) goto L28;
        if (tagAlgo.equals("HmacSha1") == false) goto L12;
        if (tagSizeInBytes <= 20) goto L12;
    L21:
        throw new InvalidAlgorithmParameterException("tag size too big");
    L12:
        if (tagAlgo.equals("HmacSha256") == false) goto L16;
        if (tagSizeInBytes > 32) goto L21;
    L16:
        if (tagAlgo.equals("HmacSha512") == false) goto L23;
        if (tagSizeInBytes > 64) goto L21;
    L23:
        if ((((((ciphertextSegmentSize - firstSegmentOffset) - tagSizeInBytes) - keySizeInBytes) - 7) - 1) <= 0) goto L26;
        return;
    L26:
        throw new InvalidAlgorithmParameterException("ciphertextSegmentSize too small");
    L28:
        throw new InvalidAlgorithmParameterException("tag size too small " + tagSizeInBytes);
    L30:
        throw new InvalidAlgorithmParameterException("ikm too short, must be >= " + Math.max(16, keySizeInBytes));
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public AesCtrHmacStreamEncrypter newStreamSegmentEncrypter(byte[] aad) throws GeneralSecurityException {
        return new AesCtrHmacStreamEncrypter(this, aad);
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public AesCtrHmacStreamDecrypter newStreamSegmentDecrypter() throws GeneralSecurityException {
        return new AesCtrHmacStreamDecrypter(this);
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public int getCiphertextSegmentSize() {
        return this.ciphertextSegmentSize;
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public int getPlaintextSegmentSize() {
        return this.plaintextSegmentSize;
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public int getHeaderLength() {
        return (this.keySizeInBytes + 1) + 7;
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public int getCiphertextOffset() {
        return getHeaderLength() + this.firstSegmentOffset;
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public int getCiphertextOverhead() {
        return this.tagSizeInBytes;
    }

    public int getFirstSegmentOffset() {
        return this.firstSegmentOffset;
    }

    public long expectedCiphertextSize(long plaintextSize) {
        long r6 = plaintextSize + ((long) getCiphertextOffset());
        int r0 = this.plaintextSegmentSize;
        long r1 = (r6 / ((long) r0)) * ((long) this.ciphertextSegmentSize);
        long r7 = r6 % ((long) r0);
        if (r7 > 0) goto L5;
        return r1;
    L5:
        return r1 + (r7 + ((long) this.tagSizeInBytes));
    }

    private static Cipher cipherInstance() throws GeneralSecurityException {
        return EngineFactory.CIPHER.getInstance("AES/CTR/NoPadding");
    }

    private Mac macInstance() throws GeneralSecurityException {
        return EngineFactory.MAC.getInstance(this.tagAlgo);
    }

    private byte[] randomSalt() {
        return Random.randBytes(this.keySizeInBytes);
    }

    private byte[] nonceForSegment(byte[] r2, long r3, boolean r5) throws GeneralSecurityException {
        ByteBuffer r1 = ByteBuffer.allocate(16);
        r1.order(ByteOrder.BIG_ENDIAN);
        r1.put(r2);
        SubtleUtil.putAsUnsigedInt(r1, r3);
        r1.put(r5 ? 1 : 0);
        r1.putInt(0);
        return r1.array();
    }

    private byte[] randomNonce() {
        return Random.randBytes(7);
    }

    private byte[] deriveKeyMaterial(byte[] salt, byte[] aad) throws GeneralSecurityException {
        int r0 = this.keySizeInBytes + 32;
        return Hkdf.computeHkdf(this.hkdfAlgo, this.ikm, salt, aad, r0);
    }

    private SecretKeySpec deriveKeySpec(byte[] keyMaterial) throws GeneralSecurityException {
        return new SecretKeySpec(keyMaterial, 0, this.keySizeInBytes, "AES");
    }

    private SecretKeySpec deriveHmacKeySpec(byte[] keyMaterial) throws GeneralSecurityException {
        return new SecretKeySpec(keyMaterial, this.keySizeInBytes, 32, this.tagAlgo);
    }
}
