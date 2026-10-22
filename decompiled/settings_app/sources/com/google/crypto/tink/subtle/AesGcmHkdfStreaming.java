package com.google.crypto.tink.subtle;

import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.StreamingAead;
import com.google.crypto.tink.streamingaead.AesGcmHkdfStreamingKey;
import com.google.crypto.tink.streamingaead.AesGcmHkdfStreamingParameters;
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
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes4.dex */
public final class AesGcmHkdfStreaming extends NonceBasedStreamingAead {
    private static final int NONCE_PREFIX_IN_BYTES = 7;
    private static final int NONCE_SIZE_IN_BYTES = 12;
    private static final int TAG_SIZE_IN_BYTES = 16;
    private final int ciphertextSegmentSize;
    private final int firstSegmentOffset;
    private final String hkdfAlg;
    private final byte[] ikm;
    private final int keySizeInBytes;
    private final int plaintextSegmentSize;

    class AesGcmHkdfStreamDecrypter implements StreamSegmentDecrypter {
        private Cipher cipher;
        private SecretKeySpec keySpec;
        private byte[] noncePrefix;
        final /* synthetic */ AesGcmHkdfStreaming this$0;

        AesGcmHkdfStreamDecrypter(final AesGcmHkdfStreaming this$0) {
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
            byte[] r0 = new byte[AesGcmHkdfStreaming.access$500(this.this$0)];     // Catch: Throwable -> L14
            header.get(r0);     // Catch: Throwable -> L14
            header.get(this.noncePrefix);     // Catch: Throwable -> L14
            this.keySpec = AesGcmHkdfStreaming.access$300(this.this$0, r0, aad);     // Catch: Throwable -> L14
            this.cipher = AesGcmHkdfStreaming.access$000();     // Catch: Throwable -> L14
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
            this.cipher.init(2, this.keySpec, AesGcmHkdfStreaming.access$400(this.noncePrefix, segmentNr, isLastSegment));     // Catch: Throwable -> L6
            this.cipher.doFinal(ciphertext, plaintext);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }
    }

    class AesGcmHkdfStreamEncrypter implements StreamSegmentEncrypter {
        private final Cipher cipher;
        private long encryptedSegments;
        private final ByteBuffer header;
        private final SecretKeySpec keySpec;
        private final byte[] noncePrefix;
        final /* synthetic */ AesGcmHkdfStreaming this$0;

        public AesGcmHkdfStreamEncrypter(final AesGcmHkdfStreaming this$0, byte[] aad) throws GeneralSecurityException {
            this.this$0 = this$0;
            this.encryptedSegments = 0;
            this.cipher = AesGcmHkdfStreaming.access$000();
            this.encryptedSegments = 0;
            byte[] r0 = AesGcmHkdfStreaming.access$100(this$0);
            byte[] r1 = AesGcmHkdfStreaming.access$200();
            this.noncePrefix = r1;
            ByteBuffer r2 = ByteBuffer.allocate(this$0.getHeaderLength());
            this.header = r2;
            r2.put((byte) this$0.getHeaderLength());
            r2.put(r0);
            r2.put(r1);
            r2.flip();
            this.keySpec = AesGcmHkdfStreaming.access$300(this$0, r0, aad);
        }

        @Override // com.google.crypto.tink.subtle.StreamSegmentEncrypter
        public ByteBuffer getHeader() {
            return this.header.asReadOnlyBuffer();
        }

        @Override // com.google.crypto.tink.subtle.StreamSegmentEncrypter
        public synchronized void encryptSegment(ByteBuffer plaintext, boolean isLastSegment, ByteBuffer ciphertext) throws GeneralSecurityException {
            monitor-enter(this);
            this.cipher.init(1, this.keySpec, AesGcmHkdfStreaming.access$400(this.noncePrefix, this.encryptedSegments, isLastSegment));     // Catch: Throwable -> L6
            this.encryptedSegments++;     // Catch: Throwable -> L6
            this.cipher.doFinal(plaintext, ciphertext);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        @Override // com.google.crypto.tink.subtle.StreamSegmentEncrypter
        public synchronized void encryptSegment(ByteBuffer part1, ByteBuffer part2, boolean isLastSegment, ByteBuffer ciphertext) throws GeneralSecurityException {
            monitor-enter(this);
            this.cipher.init(1, this.keySpec, AesGcmHkdfStreaming.access$400(this.noncePrefix, this.encryptedSegments, isLastSegment));     // Catch: Throwable -> L9
            this.encryptedSegments++;     // Catch: Throwable -> L9
            if (part2.hasRemaining() == false) goto L6;
            this.cipher.update(part1, ciphertext);     // Catch: Throwable -> L9
            this.cipher.doFinal(part2, ciphertext);     // Catch: Throwable -> L9
        L7:
            monitor-exit(this);
            return;
        L6:
            this.cipher.doFinal(part1, ciphertext);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            throw th;
        }
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public int getCiphertextOverhead() {
        return 16;
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

    static /* synthetic */ byte[] access$100(AesGcmHkdfStreaming r0) {
        return r0.randomSalt();
    }

    static /* synthetic */ byte[] access$200() {
        return randomNonce();
    }

    static /* synthetic */ SecretKeySpec access$300(AesGcmHkdfStreaming r0, byte[] r1, byte[] r2) throws GeneralSecurityException {
        return r0.deriveKeySpec(r1, r2);
    }

    static /* synthetic */ GCMParameterSpec access$400(byte[] r0, long r1, boolean r3) throws GeneralSecurityException {
        return paramsForSegment(r0, r1, r3);
    }

    static /* synthetic */ int access$500(AesGcmHkdfStreaming r0) {
        return r0.keySizeInBytes;
    }

    public AesGcmHkdfStreaming(byte[] ikm, String hkdfAlg, int keySizeInBytes, int ciphertextSegmentSize, int firstSegmentOffset) throws InvalidAlgorithmParameterException {
        if (ikm.length < 16) goto L13;
        if (ikm.length < keySizeInBytes) goto L13;
        Validators.validateAesKeySize(keySizeInBytes);
        if (ciphertextSegmentSize <= ((getHeaderLength() + firstSegmentOffset) + 16)) goto L11;
        this.ikm = Arrays.copyOf(ikm, ikm.length);
        this.hkdfAlg = hkdfAlg;
        this.keySizeInBytes = keySizeInBytes;
        this.ciphertextSegmentSize = ciphertextSegmentSize;
        this.firstSegmentOffset = firstSegmentOffset;
        this.plaintextSegmentSize = ciphertextSegmentSize - 16;
        return;
    L11:
        throw new InvalidAlgorithmParameterException("ciphertextSegmentSize too small");
    L13:
        throw new InvalidAlgorithmParameterException("ikm too short, must be >= " + Math.max(16, keySizeInBytes));
    }

    private AesGcmHkdfStreaming(AesGcmHkdfStreamingKey key) throws GeneralSecurityException {
        this.ikm = key.getInitialKeyMaterial().toByteArray(InsecureSecretKeyAccess.get());
        if (key.getParameters().getHkdfHashType().equals(AesGcmHkdfStreamingParameters.HashType.SHA1) == false) goto L6;
        String r0 = "HmacSha1";
    L11:
        this.hkdfAlg = r0;
        this.keySizeInBytes = key.getParameters().getDerivedAesGcmKeySizeBytes();
        int r3 = key.getParameters().getCiphertextSegmentSizeBytes();
        this.ciphertextSegmentSize = r3;
        this.firstSegmentOffset = 0;
        this.plaintextSegmentSize = r3 - 16;
        return;
    L6:
        if (key.getParameters().getHkdfHashType().equals(AesGcmHkdfStreamingParameters.HashType.SHA256) == false) goto L9;
        r0 = "HmacSha256";
        goto L11
    L9:
        if (key.getParameters().getHkdfHashType().equals(AesGcmHkdfStreamingParameters.HashType.SHA512) == false) goto L14;
        r0 = "HmacSha512";
        goto L11
    L14:
        throw new GeneralSecurityException("Unknown HKDF algorithm " + key.getParameters().getHkdfHashType());
    }

    public static StreamingAead create(AesGcmHkdfStreamingKey key) throws GeneralSecurityException {
        return new AesGcmHkdfStreaming(key);
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public AesGcmHkdfStreamEncrypter newStreamSegmentEncrypter(byte[] aad) throws GeneralSecurityException {
        return new AesGcmHkdfStreamEncrypter(this, aad);
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public AesGcmHkdfStreamDecrypter newStreamSegmentDecrypter() throws GeneralSecurityException {
        return new AesGcmHkdfStreamDecrypter(this);
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public int getPlaintextSegmentSize() {
        return this.plaintextSegmentSize;
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public int getCiphertextSegmentSize() {
        return this.ciphertextSegmentSize;
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public int getHeaderLength() {
        return (this.keySizeInBytes + 1) + 7;
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public int getCiphertextOffset() {
        return getHeaderLength() + this.firstSegmentOffset;
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
        return r1 + (r7 + 16);
    }

    private static Cipher cipherInstance() throws GeneralSecurityException {
        return EngineFactory.CIPHER.getInstance("AES/GCM/NoPadding");
    }

    private byte[] randomSalt() {
        return Random.randBytes(this.keySizeInBytes);
    }

    private static GCMParameterSpec paramsForSegment(byte[] r2, long r3, boolean r5) throws GeneralSecurityException {
        ByteBuffer r0 = ByteBuffer.allocate(12);
        r0.order(ByteOrder.BIG_ENDIAN);
        r0.put(r2);
        SubtleUtil.putAsUnsigedInt(r0, r3);
        r0.put(r5 ? 1 : 0);
        return new GCMParameterSpec(128, r0.array());
    }

    private static byte[] randomNonce() {
        return Random.randBytes(7);
    }

    private SecretKeySpec deriveKeySpec(byte[] salt, byte[] aad) throws GeneralSecurityException {
        return new SecretKeySpec(Hkdf.computeHkdf(this.hkdfAlg, this.ikm, salt, aad, this.keySizeInBytes), "AES");
    }
}
