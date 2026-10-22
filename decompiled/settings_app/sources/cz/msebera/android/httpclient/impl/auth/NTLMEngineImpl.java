package cz.msebera.android.httpclient.impl.auth;

import android.icu.lang.UCharacter;
import cz.msebera.android.httpclient.Consts;
import cz.msebera.android.httpclient.extras.Base64;
import java.nio.charset.Charset;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes5.dex */
final class NTLMEngineImpl implements NTLMEngine {
    private static final Charset DEFAULT_CHARSET = null;
    static final int FLAG_DOMAIN_PRESENT = 4096;
    static final int FLAG_REQUEST_128BIT_KEY_EXCH = 536870912;
    static final int FLAG_REQUEST_56BIT_ENCRYPTION = Integer.MIN_VALUE;
    static final int FLAG_REQUEST_ALWAYS_SIGN = 32768;
    static final int FLAG_REQUEST_EXPLICIT_KEY_EXCH = 1073741824;
    static final int FLAG_REQUEST_LAN_MANAGER_KEY = 128;
    static final int FLAG_REQUEST_NTLM2_SESSION = 524288;
    static final int FLAG_REQUEST_NTLMv1 = 512;
    static final int FLAG_REQUEST_OEM_ENCODING = 2;
    static final int FLAG_REQUEST_SEAL = 32;
    static final int FLAG_REQUEST_SIGN = 16;
    static final int FLAG_REQUEST_TARGET = 4;
    static final int FLAG_REQUEST_UNICODE_ENCODING = 1;
    static final int FLAG_REQUEST_VERSION = 33554432;
    static final int FLAG_TARGETINFO_PRESENT = 8388608;
    static final int FLAG_WORKSTATION_PRESENT = 8192;
    private static final byte[] MAGIC_TLS_SERVER_ENDPOINT = null;
    static final int MSV_AV_CHANNEL_BINDINGS = 10;
    static final int MSV_AV_DNS_COMPUTER_NAME = 3;
    static final int MSV_AV_DNS_DOMAIN_NAME = 4;
    static final int MSV_AV_DNS_TREE_NAME = 5;
    static final int MSV_AV_EOL = 0;
    static final int MSV_AV_FLAGS = 6;
    static final int MSV_AV_FLAGS_ACCOUNT_AUTH_CONSTAINED = 1;
    static final int MSV_AV_FLAGS_MIC = 2;
    static final int MSV_AV_FLAGS_UNTRUSTED_TARGET_SPN = 4;
    static final int MSV_AV_NB_COMPUTER_NAME = 1;
    static final int MSV_AV_NB_DOMAIN_NAME = 2;
    static final int MSV_AV_SINGLE_HOST = 8;
    static final int MSV_AV_TARGET_NAME = 9;
    static final int MSV_AV_TIMESTAMP = 7;
    private static final SecureRandom RND_GEN = null;
    private static final byte[] SEAL_MAGIC_CLIENT = null;
    private static final byte[] SEAL_MAGIC_SERVER = null;
    private static final byte[] SIGNATURE = null;
    private static final byte[] SIGN_MAGIC_CLIENT = null;
    private static final byte[] SIGN_MAGIC_SERVER = null;
    private static final String TYPE_1_MESSAGE = null;
    private static final Charset UNICODE_LITTLE_UNMARKED = null;

    protected static class CipherGen {
        protected final byte[] challenge;
        protected byte[] clientChallenge;
        protected byte[] clientChallenge2;
        protected final long currentTime;
        protected final String domain;
        protected byte[] lanManagerSessionKey;
        protected byte[] lm2SessionResponse;
        protected byte[] lmHash;
        protected byte[] lmResponse;
        protected byte[] lmUserSessionKey;
        protected byte[] lmv2Hash;
        protected byte[] lmv2Response;
        protected byte[] ntlm2SessionResponse;
        protected byte[] ntlm2SessionResponseUserSessionKey;
        protected byte[] ntlmHash;
        protected byte[] ntlmResponse;
        protected byte[] ntlmUserSessionKey;
        protected byte[] ntlmv2Blob;
        protected byte[] ntlmv2Hash;
        protected byte[] ntlmv2Response;
        protected byte[] ntlmv2UserSessionKey;
        protected final String password;
        protected final Random random;
        protected byte[] secondaryKey;
        protected final String target;
        protected final byte[] targetInformation;
        protected byte[] timestamp;
        protected final String user;

        @Deprecated
        public CipherGen(String r15, String r16, String r17, byte[] r18, String r19, byte[] r20, byte[] r21, byte[] r22, byte[] r23, byte[] r24) {
            this(NTLMEngineImpl.access$000(), System.currentTimeMillis(), r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
        }

        public CipherGen(Random r2, long r3, String r5, String r6, String r7, byte[] r8, String r9, byte[] r10, byte[] r11, byte[] r12, byte[] r13, byte[] r14) {
            this.lmHash = null;
            this.lmResponse = null;
            this.ntlmHash = null;
            this.ntlmResponse = null;
            this.ntlmv2Hash = null;
            this.lmv2Hash = null;
            this.lmv2Response = null;
            this.ntlmv2Blob = null;
            this.ntlmv2Response = null;
            this.ntlm2SessionResponse = null;
            this.lm2SessionResponse = null;
            this.lmUserSessionKey = null;
            this.ntlmUserSessionKey = null;
            this.ntlmv2UserSessionKey = null;
            this.ntlm2SessionResponseUserSessionKey = null;
            this.lanManagerSessionKey = null;
            this.random = r2;
            this.currentTime = r3;
            this.domain = r5;
            this.target = r9;
            this.user = r6;
            this.password = r7;
            this.challenge = r8;
            this.targetInformation = r10;
            this.clientChallenge = r11;
            this.clientChallenge2 = r12;
            this.secondaryKey = r13;
            this.timestamp = r14;
        }

        @Deprecated
        public CipherGen(String r11, String r12, String r13, byte[] r14, String r15, byte[] r16) {
            this(NTLMEngineImpl.access$000(), System.currentTimeMillis(), r11, r12, r13, r14, r15, r16);
        }

        public CipherGen(Random r15, long r16, String r18, String r19, String r20, byte[] r21, String r22, byte[] r23) {
            this(r15, r16, r18, r19, r20, r21, r22, r23, null, null, null, null);
        }

        public byte[] getClientChallenge() throws NTLMEngineException {
            if (this.clientChallenge != null) goto L6;
            this.clientChallenge = NTLMEngineImpl.access$100(this.random);
        L6:
            return this.clientChallenge;
        }

        public byte[] getClientChallenge2() throws NTLMEngineException {
            if (this.clientChallenge2 != null) goto L6;
            this.clientChallenge2 = NTLMEngineImpl.access$100(this.random);
        L6:
            return this.clientChallenge2;
        }

        public byte[] getSecondaryKey() throws NTLMEngineException {
            if (this.secondaryKey != null) goto L6;
            this.secondaryKey = NTLMEngineImpl.access$200(this.random);
        L6:
            return this.secondaryKey;
        }

        public byte[] getLMHash() throws NTLMEngineException {
            if (this.lmHash != null) goto L6;
            this.lmHash = NTLMEngineImpl.access$300(this.password);
        L6:
            return this.lmHash;
        }

        public byte[] getLMResponse() throws NTLMEngineException {
            if (this.lmResponse != null) goto L6;
            this.lmResponse = NTLMEngineImpl.access$400(getLMHash(), this.challenge);
        L6:
            return this.lmResponse;
        }

        public byte[] getNTLMHash() throws NTLMEngineException {
            if (this.ntlmHash != null) goto L6;
            this.ntlmHash = NTLMEngineImpl.access$500(this.password);
        L6:
            return this.ntlmHash;
        }

        public byte[] getNTLMResponse() throws NTLMEngineException {
            if (this.ntlmResponse != null) goto L6;
            this.ntlmResponse = NTLMEngineImpl.access$400(getNTLMHash(), this.challenge);
        L6:
            return this.ntlmResponse;
        }

        public byte[] getLMv2Hash() throws NTLMEngineException {
            if (this.lmv2Hash != null) goto L6;
            this.lmv2Hash = NTLMEngineImpl.access$600(this.domain, this.user, getNTLMHash());
        L6:
            return this.lmv2Hash;
        }

        public byte[] getNTLMv2Hash() throws NTLMEngineException {
            if (this.ntlmv2Hash != null) goto L6;
            this.ntlmv2Hash = NTLMEngineImpl.access$700(this.domain, this.user, getNTLMHash());
        L6:
            return this.ntlmv2Hash;
        }

        public byte[] getTimestamp() {
            if (this.timestamp != null) goto L8;
            long r0 = (this.currentTime + 11644473600000L) * 10000;
            this.timestamp = new byte[8];
            int r3 = 0;
        L5:
            if (r3 >= 8) goto L8;
            this.timestamp[r3] = (byte) r0;
            r0 = r0 >>> 8;
            r3 = r3 + 1;
        L8:
            return this.timestamp;
        }

        public byte[] getNTLMv2Blob() throws NTLMEngineException {
            if (this.ntlmv2Blob != null) goto L6;
            this.ntlmv2Blob = NTLMEngineImpl.access$800(getClientChallenge2(), this.targetInformation, getTimestamp());
        L6:
            return this.ntlmv2Blob;
        }

        public byte[] getNTLMv2Response() throws NTLMEngineException {
            if (this.ntlmv2Response != null) goto L6;
            this.ntlmv2Response = NTLMEngineImpl.access$900(getNTLMv2Hash(), this.challenge, getNTLMv2Blob());
        L6:
            return this.ntlmv2Response;
        }

        public byte[] getLMv2Response() throws NTLMEngineException {
            if (this.lmv2Response != null) goto L6;
            this.lmv2Response = NTLMEngineImpl.access$900(getLMv2Hash(), this.challenge, getClientChallenge());
        L6:
            return this.lmv2Response;
        }

        public byte[] getNTLM2SessionResponse() throws NTLMEngineException {
            if (this.ntlm2SessionResponse != null) goto L6;
            this.ntlm2SessionResponse = NTLMEngineImpl.ntlm2SessionResponse(getNTLMHash(), this.challenge, getClientChallenge());
        L6:
            return this.ntlm2SessionResponse;
        }

        public byte[] getLM2SessionResponse() throws NTLMEngineException {
            if (this.lm2SessionResponse != null) goto L6;
            byte[] r0 = getClientChallenge();
            byte[] r1 = new byte[24];
            this.lm2SessionResponse = r1;
            System.arraycopy(r0, 0, r1, 0, r0.length);
            byte[] r2 = this.lm2SessionResponse;
            Arrays.fill(r2, r0.length, r2.length, (byte) 0);
        L6:
            return this.lm2SessionResponse;
        }

        public byte[] getLMUserSessionKey() throws NTLMEngineException {
            if (this.lmUserSessionKey != null) goto L6;
            this.lmUserSessionKey = new byte[16];
            System.arraycopy(getLMHash(), 0, this.lmUserSessionKey, 0, 8);
            Arrays.fill(this.lmUserSessionKey, 8, 16, (byte) 0);
        L6:
            return this.lmUserSessionKey;
        }

        public byte[] getNTLMUserSessionKey() throws NTLMEngineException {
            if (this.ntlmUserSessionKey != null) goto L6;
            MD4 r0 = new MD4();
            r0.update(getNTLMHash());
            this.ntlmUserSessionKey = r0.getOutput();
        L6:
            return this.ntlmUserSessionKey;
        }

        public byte[] getNTLMv2UserSessionKey() throws NTLMEngineException {
            if (this.ntlmv2UserSessionKey != null) goto L6;
            byte[] r0 = getNTLMv2Hash();
            byte[] r2 = new byte[16];
            System.arraycopy(getNTLMv2Response(), 0, r2, 0, 16);
            this.ntlmv2UserSessionKey = NTLMEngineImpl.hmacMD5(r2, r0);
        L6:
            return this.ntlmv2UserSessionKey;
        }

        public byte[] getNTLM2SessionResponseUserSessionKey() throws NTLMEngineException {
            if (this.ntlm2SessionResponseUserSessionKey != null) goto L6;
            byte[] r0 = getLM2SessionResponse();
            byte[] r1 = this.challenge;
            byte[] r2 = new byte[r1.length + r0.length];
            System.arraycopy(r1, 0, r2, 0, r1.length);
            System.arraycopy(r0, 0, r2, this.challenge.length, r0.length);
            this.ntlm2SessionResponseUserSessionKey = NTLMEngineImpl.hmacMD5(r2, getNTLMUserSessionKey());
        L6:
            return this.ntlm2SessionResponseUserSessionKey;
        }

        public byte[] getLanManagerSessionKey() throws NTLMEngineException {
            if (this.lanManagerSessionKey != null) goto L11;
            byte[] r2 = new byte[14];     // Catch: Exception -> L7
            System.arraycopy(getLMHash(), 0, r2, 0, 8);     // Catch: Exception -> L7
            Arrays.fill(r2, 8, 14, (byte) -67);     // Catch: Exception -> L7
            Key r1 = NTLMEngineImpl.access$1000(r2, 0);     // Catch: Exception -> L7
            Key r3 = NTLMEngineImpl.access$1000(r2, 7);     // Catch: Exception -> L7
            byte[] r4 = new byte[8];     // Catch: Exception -> L7
            System.arraycopy(getLMResponse(), 0, r4, 0, 8);     // Catch: Exception -> L7
            Cipher r5 = Cipher.getInstance("DES/ECB/NoPadding");     // Catch: Exception -> L7
            r5.init(1, r1);     // Catch: Exception -> L7
            byte[] r6 = r5.doFinal(r4);     // Catch: Exception -> L7
            Cipher r0 = Cipher.getInstance("DES/ECB/NoPadding");     // Catch: Exception -> L7
            r0.init(1, r3);     // Catch: Exception -> L7
            byte[] r7 = r0.doFinal(r4);     // Catch: Exception -> L7
            byte[] r8 = new byte[16];     // Catch: Exception -> L7
            this.lanManagerSessionKey = r8;     // Catch: Exception -> L7
            System.arraycopy(r6, 0, r8, 0, r6.length);     // Catch: Exception -> L7
            System.arraycopy(r7, 0, this.lanManagerSessionKey, r6.length, r7.length);     // Catch: Exception -> L7
        L7:
            e = move-exception;
            throw new NTLMEngineException(e.getMessage(), e);
        L11:
            return this.lanManagerSessionKey;
        }
    }

    static class HMACMD5 {
        protected final byte[] ipad;
        protected final MessageDigest md5;
        protected final byte[] opad;

        HMACMD5(byte[] r8) {
            MessageDigest r0 = NTLMEngineImpl.getMD5();
            this.md5 = r0;
            this.ipad = new byte[64];
            this.opad = new byte[64];
            int r2 = r8.length;
            if (r2 <= 64) goto L5;
            r0.update(r8);
            r8 = r0.digest();
            r2 = r8.length;
        L5:
            int r1 = 0;
        L7:
            if (r1 >= r2) goto L9;
            this.ipad[r1] = (byte) (54 ^ r8[r1]);
            this.opad[r1] = (byte) (92 ^ r8[r1]);
            r1 = r1 + 1;
        L9:
            if (r1 >= 64) goto L11;
            this.ipad[r1] = 54;
            this.opad[r1] = 92;
            r1 = r1 + 1;
            goto L9
        L11:
            this.md5.reset();
            this.md5.update(this.ipad);
        }

        byte[] getOutput() {
            byte[] r0 = this.md5.digest();
            this.md5.update(this.opad);
            return this.md5.digest(r0);
        }

        void update(byte[] r1) {
            this.md5.update(r1);
        }

        void update(byte[] r1, int r2, int r3) {
            this.md5.update(r1, r2, r3);
        }
    }

    static class Handle {
        private final byte[] exportedSessionKey;
        private final boolean isConnection;
        final Mode mode;
        private final Cipher rc4;
        private byte[] sealingKey;
        int sequenceNumber;
        private byte[] signingKey;

        Handle(byte[] r2, Mode r3, boolean r4) throws NTLMEngineException {
            this.sequenceNumber = 0;
            this.exportedSessionKey = r2;
            this.isConnection = r4;
            this.mode = r3;
            MessageDigest r5 = NTLMEngineImpl.getMD5();     // Catch: Exception -> L10
            MessageDigest r0 = NTLMEngineImpl.getMD5();     // Catch: Exception -> L10
            r5.update(r2);     // Catch: Exception -> L10
            r0.update(r2);     // Catch: Exception -> L10
            if (r3 != Mode.CLIENT) goto L6;
            r5.update(NTLMEngineImpl.access$1100());     // Catch: Exception -> L10
            r0.update(NTLMEngineImpl.access$1200());     // Catch: Exception -> L10
        L7:
            this.signingKey = r5.digest();     // Catch: Exception -> L10
            this.sealingKey = r0.digest();     // Catch: Exception -> L10
            this.rc4 = initCipher();
            return;
        L6:
            r5.update(NTLMEngineImpl.access$1300());     // Catch: Exception -> L10
            r0.update(NTLMEngineImpl.access$1400());     // Catch: Exception -> L10
        L10:
            e = move-exception;
            throw new NTLMEngineException(e.getMessage(), e);
        }

        public byte[] getSigningKey() {
            return this.signingKey;
        }

        public byte[] getSealingKey() {
            return this.sealingKey;
        }

        private Cipher initCipher() throws NTLMEngineException {
            Cipher r1 = Cipher.getInstance("RC4");     // Catch: Exception -> L8
            if (this.mode != Mode.CLIENT) goto L6;
            r1.init(1, new SecretKeySpec(this.sealingKey, "RC4"));     // Catch: Exception -> L8
        L7:
            return r1;
        L6:
            r1.init(2, new SecretKeySpec(this.sealingKey, "RC4"));     // Catch: Exception -> L8
        L8:
            e = move-exception;
            throw new NTLMEngineException(e.getMessage(), e);
        }

        private void advanceMessageSequence() throws NTLMEngineException {
            if (this.isConnection == true) goto L5;
            MessageDigest r0 = NTLMEngineImpl.getMD5();
            r0.update(this.sealingKey);
            byte[] r1 = new byte[4];
            NTLMEngineImpl.writeULong(r1, this.sequenceNumber, 0);
            r0.update(r1);
            this.sealingKey = r0.digest();
            initCipher();
        L5:
            this.sequenceNumber++;
        }

        private byte[] encrypt(byte[] r1) {
            return this.rc4.update(r1);
        }

        private byte[] decrypt(byte[] r1) {
            return this.rc4.update(r1);
        }

        private byte[] computeSignature(byte[] r5) {
            byte[] r0 = new byte[16];
            r0[0] = 1;
            r0[1] = 0;
            r0[2] = 0;
            r0[3] = 0;
            HMACMD5 r2 = new HMACMD5(this.signingKey);
            r2.update(NTLMEngineImpl.access$1500(this.sequenceNumber));
            r2.update(r5);
            byte[] r3 = new byte[8];
            System.arraycopy(r2.getOutput(), 0, r3, 0, 8);
            System.arraycopy(encrypt(r3), 0, r0, 4, 8);
            NTLMEngineImpl.access$1600(r0, 12, this.sequenceNumber);
            return r0;
        }

        private boolean validateSignature(byte[] r1, byte[] r2) {
            return Arrays.equals(r1, computeSignature(r2));
        }

        public byte[] signAndEncryptMessage(byte[] r5) throws NTLMEngineException {
            byte[] r0 = encrypt(r5);
            byte[] r6 = computeSignature(r5);
            byte[] r1 = new byte[r6.length + r0.length];
            System.arraycopy(r6, 0, r1, 0, r6.length);
            System.arraycopy(r0, 0, r1, r6.length, r0.length);
            advanceMessageSequence();
            return r1;
        }

        public byte[] decryptAndVerifySignedMessage(byte[] r6) throws NTLMEngineException {
            byte[] r1 = new byte[16];
            System.arraycopy(r6, 0, r1, 0, 16);
            int r3 = r6.length - 16;
            byte[] r4 = new byte[r3];
            System.arraycopy(r6, 16, r4, 0, r3);
            byte[] r7 = decrypt(r4);
            if (validateSignature(r1, r7) == false) goto L7;
            advanceMessageSequence();
            return r7;
        L7:
            throw new NTLMEngineException("Wrong signature");
        }
    }

    static class MD4 {
        protected int A;
        protected int B;
        protected int C;
        protected int D;
        protected long count;
        protected final byte[] dataBuffer;

        MD4() {
            this.A = 1732584193;
            this.B = -271733879;
            this.C = -1732584194;
            this.D = 271733878;
            this.count = 0;
            this.dataBuffer = new byte[64];
        }

        void update(byte[] r9) {
            int r0 = (int) (this.count & 63);
            int r2 = 0;
        L3:
            int r3 = (r9.length - r2) + r0;
            byte[] r4 = this.dataBuffer;
            if (r3 < r4.length) goto L7;
            int r5 = r4.length - r0;
            System.arraycopy(r9, r2, r4, r0, r5);
            this.count += (long) r5;
            r2 = r2 + r5;
            processBuffer();
            r0 = 0;
            goto L3
        L7:
            if (r2 >= r9.length) goto L11;
            int r1 = r9.length - r2;
            System.arraycopy(r9, r2, r4, r0, r1);
            this.count += (long) r1;
            return;
        }

        byte[] getOutput() {
            int r0 = (int) (this.count & 63);
            if (r0 >= 56) goto L5;
            int r1 = 56 - r0;
        L6:
            byte[] r2 = new byte[r1 + 8];
            r2[0] = -128;
            int r3 = 0;
        L8:
            if (r3 >= 8) goto L10;
            r2[r1 + r3] = (byte) ((this.count * 8) >>> (r3 * 8));
            r3 = r3 + 1;
            goto L8
        L10:
            update(r2);
            byte[] r4 = new byte[16];
            NTLMEngineImpl.writeULong(r4, this.A, 0);
            NTLMEngineImpl.writeULong(r4, this.B, 4);
            NTLMEngineImpl.writeULong(r4, this.C, 8);
            NTLMEngineImpl.writeULong(r4, this.D, 12);
            return r4;
        L5:
            r1 = 120 - r0;
            goto L6
        }

        protected void processBuffer() {
            int[] r1 = new int[16];
            int r2 = 0;
        L3:
            if (r2 >= 16) goto L5;
            byte[] r3 = this.dataBuffer;
            int r4 = r2 * 4;
            r1[r2] = (((r3[r4] & 255) + ((r3[r4 + 1] & 255) << 8)) + ((r3[r4 + 2] & 255) << 16)) + ((r3[r4 + 3] & 255) << 24);
            r2 = r2 + 1;
            goto L3
        L5:
            int r0 = this.A;
            int r5 = this.B;
            int r6 = this.C;
            int r7 = this.D;
            round1(r1);
            round2(r1);
            round3(r1);
            this.A += r0;
            this.B += r5;
            this.C += r6;
            this.D += r7;
        }

        protected void round1(int[] r9) {
            int r0 = NTLMEngineImpl.rotintlft((this.A + NTLMEngineImpl.F(this.B, this.C, this.D)) + r9[0], 3);
            this.A = r0;
            int r2 = NTLMEngineImpl.rotintlft((this.D + NTLMEngineImpl.F(r0, this.B, this.C)) + r9[1], 7);
            this.D = r2;
            int r3 = NTLMEngineImpl.rotintlft((this.C + NTLMEngineImpl.F(r2, this.A, this.B)) + r9[2], 11);
            this.C = r3;
            int r4 = NTLMEngineImpl.rotintlft((this.B + NTLMEngineImpl.F(r3, this.D, this.A)) + r9[3], 19);
            this.B = r4;
            int r5 = NTLMEngineImpl.rotintlft((this.A + NTLMEngineImpl.F(r4, this.C, this.D)) + r9[4], 3);
            this.A = r5;
            int r6 = NTLMEngineImpl.rotintlft((this.D + NTLMEngineImpl.F(r5, this.B, this.C)) + r9[5], 7);
            this.D = r6;
            int r7 = NTLMEngineImpl.rotintlft((this.C + NTLMEngineImpl.F(r6, this.A, this.B)) + r9[6], 11);
            this.C = r7;
            int r8 = NTLMEngineImpl.rotintlft((this.B + NTLMEngineImpl.F(r7, this.D, this.A)) + r9[7], 19);
            this.B = r8;
            int r10 = NTLMEngineImpl.rotintlft((this.A + NTLMEngineImpl.F(r8, this.C, this.D)) + r9[8], 3);
            this.A = r10;
            int r11 = NTLMEngineImpl.rotintlft((this.D + NTLMEngineImpl.F(r10, this.B, this.C)) + r9[9], 7);
            this.D = r11;
            int r12 = NTLMEngineImpl.rotintlft((this.C + NTLMEngineImpl.F(r11, this.A, this.B)) + r9[10], 11);
            this.C = r12;
            int r13 = NTLMEngineImpl.rotintlft((this.B + NTLMEngineImpl.F(r12, this.D, this.A)) + r9[11], 19);
            this.B = r13;
            int r1 = NTLMEngineImpl.rotintlft((this.A + NTLMEngineImpl.F(r13, this.C, this.D)) + r9[12], 3);
            this.A = r1;
            int r14 = NTLMEngineImpl.rotintlft((this.D + NTLMEngineImpl.F(r1, this.B, this.C)) + r9[13], 7);
            this.D = r14;
            int r15 = NTLMEngineImpl.rotintlft((this.C + NTLMEngineImpl.F(r14, this.A, this.B)) + r9[14], 11);
            this.C = r15;
            this.B = NTLMEngineImpl.rotintlft((this.B + NTLMEngineImpl.F(r15, this.D, this.A)) + r9[15], 19);
        }

        protected void round2(int[] r10) {
            int r0 = NTLMEngineImpl.rotintlft(((this.A + NTLMEngineImpl.G(this.B, this.C, this.D)) + r10[0]) + 1518500249, 3);
            this.A = r0;
            int r3 = NTLMEngineImpl.rotintlft(((this.D + NTLMEngineImpl.G(r0, this.B, this.C)) + r10[4]) + 1518500249, 5);
            this.D = r3;
            int r4 = NTLMEngineImpl.rotintlft(((this.C + NTLMEngineImpl.G(r3, this.A, this.B)) + r10[8]) + 1518500249, 9);
            this.C = r4;
            int r5 = NTLMEngineImpl.rotintlft(((this.B + NTLMEngineImpl.G(r4, this.D, this.A)) + r10[12]) + 1518500249, 13);
            this.B = r5;
            int r6 = NTLMEngineImpl.rotintlft(((this.A + NTLMEngineImpl.G(r5, this.C, this.D)) + r10[1]) + 1518500249, 3);
            this.A = r6;
            int r7 = NTLMEngineImpl.rotintlft(((this.D + NTLMEngineImpl.G(r6, this.B, this.C)) + r10[5]) + 1518500249, 5);
            this.D = r7;
            int r8 = NTLMEngineImpl.rotintlft(((this.C + NTLMEngineImpl.G(r7, this.A, this.B)) + r10[9]) + 1518500249, 9);
            this.C = r8;
            int r9 = NTLMEngineImpl.rotintlft(((this.B + NTLMEngineImpl.G(r8, this.D, this.A)) + r10[13]) + 1518500249, 13);
            this.B = r9;
            int r11 = NTLMEngineImpl.rotintlft(((this.A + NTLMEngineImpl.G(r9, this.C, this.D)) + r10[2]) + 1518500249, 3);
            this.A = r11;
            int r12 = NTLMEngineImpl.rotintlft(((this.D + NTLMEngineImpl.G(r11, this.B, this.C)) + r10[6]) + 1518500249, 5);
            this.D = r12;
            int r13 = NTLMEngineImpl.rotintlft(((this.C + NTLMEngineImpl.G(r12, this.A, this.B)) + r10[10]) + 1518500249, 9);
            this.C = r13;
            int r14 = NTLMEngineImpl.rotintlft(((this.B + NTLMEngineImpl.G(r13, this.D, this.A)) + r10[14]) + 1518500249, 13);
            this.B = r14;
            int r2 = NTLMEngineImpl.rotintlft(((this.A + NTLMEngineImpl.G(r14, this.C, this.D)) + r10[3]) + 1518500249, 3);
            this.A = r2;
            int r1 = NTLMEngineImpl.rotintlft(((this.D + NTLMEngineImpl.G(r2, this.B, this.C)) + r10[7]) + 1518500249, 5);
            this.D = r1;
            int r15 = NTLMEngineImpl.rotintlft(((this.C + NTLMEngineImpl.G(r1, this.A, this.B)) + r10[11]) + 1518500249, 9);
            this.C = r15;
            this.B = NTLMEngineImpl.rotintlft(((this.B + NTLMEngineImpl.G(r15, this.D, this.A)) + r10[15]) + 1518500249, 13);
        }

        protected void round3(int[] r10) {
            int r0 = NTLMEngineImpl.rotintlft(((this.A + NTLMEngineImpl.H(this.B, this.C, this.D)) + r10[0]) + 1859775393, 3);
            this.A = r0;
            int r3 = NTLMEngineImpl.rotintlft(((this.D + NTLMEngineImpl.H(r0, this.B, this.C)) + r10[8]) + 1859775393, 9);
            this.D = r3;
            int r4 = NTLMEngineImpl.rotintlft(((this.C + NTLMEngineImpl.H(r3, this.A, this.B)) + r10[4]) + 1859775393, 11);
            this.C = r4;
            int r5 = NTLMEngineImpl.rotintlft(((this.B + NTLMEngineImpl.H(r4, this.D, this.A)) + r10[12]) + 1859775393, 15);
            this.B = r5;
            int r6 = NTLMEngineImpl.rotintlft(((this.A + NTLMEngineImpl.H(r5, this.C, this.D)) + r10[2]) + 1859775393, 3);
            this.A = r6;
            int r7 = NTLMEngineImpl.rotintlft(((this.D + NTLMEngineImpl.H(r6, this.B, this.C)) + r10[10]) + 1859775393, 9);
            this.D = r7;
            int r8 = NTLMEngineImpl.rotintlft(((this.C + NTLMEngineImpl.H(r7, this.A, this.B)) + r10[6]) + 1859775393, 11);
            this.C = r8;
            int r9 = NTLMEngineImpl.rotintlft(((this.B + NTLMEngineImpl.H(r8, this.D, this.A)) + r10[14]) + 1859775393, 15);
            this.B = r9;
            int r11 = NTLMEngineImpl.rotintlft(((this.A + NTLMEngineImpl.H(r9, this.C, this.D)) + r10[1]) + 1859775393, 3);
            this.A = r11;
            int r12 = NTLMEngineImpl.rotintlft(((this.D + NTLMEngineImpl.H(r11, this.B, this.C)) + r10[9]) + 1859775393, 9);
            this.D = r12;
            int r13 = NTLMEngineImpl.rotintlft(((this.C + NTLMEngineImpl.H(r12, this.A, this.B)) + r10[5]) + 1859775393, 11);
            this.C = r13;
            int r14 = NTLMEngineImpl.rotintlft(((this.B + NTLMEngineImpl.H(r13, this.D, this.A)) + r10[13]) + 1859775393, 15);
            this.B = r14;
            int r2 = NTLMEngineImpl.rotintlft(((this.A + NTLMEngineImpl.H(r14, this.C, this.D)) + r10[3]) + 1859775393, 3);
            this.A = r2;
            int r1 = NTLMEngineImpl.rotintlft(((this.D + NTLMEngineImpl.H(r2, this.B, this.C)) + r10[11]) + 1859775393, 9);
            this.D = r1;
            int r15 = NTLMEngineImpl.rotintlft(((this.C + NTLMEngineImpl.H(r1, this.A, this.B)) + r10[7]) + 1859775393, 11);
            this.C = r15;
            this.B = NTLMEngineImpl.rotintlft(((this.B + NTLMEngineImpl.H(r15, this.D, this.A)) + r10[15]) + 1859775393, 15);
        }
    }

    static final enum Mode extends Enum<Mode> {
        private static final /* synthetic */ Mode[] $VALUES = null;
        public static final Mode CLIENT = null;
        public static final Mode SERVER = null;

        private Mode(String r1, int r2) {
            super(r1, r2);
        }

        public static Mode valueOf(String r1) {
            return (Mode) Enum.valueOf(Mode.class, r1);
        }

        public static Mode[] values() {
            return (Mode[]) $VALUES.clone();
        }

        static {
            Mode r0 = new Mode("CLIENT", 0);
            CLIENT = r0;
            Mode r1 = new Mode("SERVER", 1);
            SERVER = r1;
            $VALUES = new Mode[]{r0, r1};
        }
    }

    static class NTLMMessage {
        protected int currentOutputPosition;
        protected byte[] messageContents;

        NTLMMessage() {
            this.messageContents = null;
            this.currentOutputPosition = 0;
        }

        NTLMMessage(String r2, int r3) throws NTLMEngineException {
            this(Base64.decode(r2.getBytes(NTLMEngineImpl.access$1700()), 2), r3);
        }

        NTLMMessage(byte[] r3, int r4) throws NTLMEngineException {
            int r0 = 0;
            this.currentOutputPosition = 0;
            this.messageContents = r3;
            if (r3.length < NTLMEngineImpl.access$1800().length) goto L18;
        L5:
            if (r0 >= NTLMEngineImpl.access$1800().length) goto L11;
            if (this.messageContents[r0] != NTLMEngineImpl.access$1800()[r0]) goto L10;
            r0 = r0 + 1;
            goto L5
        L10:
            throw new NTLMEngineException("NTLM message expected - instead got unrecognized bytes");
        L11:
            int r5 = readULong(NTLMEngineImpl.access$1800().length);
            if (r5 != r4) goto L16;
            this.currentOutputPosition = this.messageContents.length;
            return;
        L16:
            throw new NTLMEngineException("NTLM type " + Integer.toString(r4) + " message expected - instead got type " + Integer.toString(r5));
        L18:
            throw new NTLMEngineException("NTLM message decoding error - packet too short");
        }

        protected int getPreambleLength() {
            return NTLMEngineImpl.access$1800().length + 4;
        }

        protected int getMessageLength() {
            return this.currentOutputPosition;
        }

        protected byte readByte(int r3) throws NTLMEngineException {
            byte[] r2 = this.messageContents;
            if (r2.length < (r3 + 1)) goto L7;
            return r2[r3];
        L7:
            throw new NTLMEngineException("NTLM: Message too short");
        }

        protected void readBytes(byte[] r3, int r4) throws NTLMEngineException {
            byte[] r2 = this.messageContents;
            if (r2.length < (r3.length + r4)) goto L7;
            System.arraycopy(r2, r4, r3, 0, r3.length);
            return;
        L7:
            throw new NTLMEngineException("NTLM: Message too short");
        }

        protected int readUShort(int r1) throws NTLMEngineException {
            return NTLMEngineImpl.access$1900(this.messageContents, r1);
        }

        protected int readULong(int r1) throws NTLMEngineException {
            return NTLMEngineImpl.access$2000(this.messageContents, r1);
        }

        protected byte[] readSecurityBuffer(int r1) throws NTLMEngineException {
            return NTLMEngineImpl.access$2100(this.messageContents, r1);
        }

        protected void prepareResponse(int r1, int r2) {
            this.messageContents = new byte[r1];
            this.currentOutputPosition = 0;
            addBytes(NTLMEngineImpl.access$1800());
            addULong(r2);
        }

        protected void addByte(byte r3) {
            byte[] r0 = this.messageContents;
            int r1 = this.currentOutputPosition;
            r0[r1] = r3;
            this.currentOutputPosition = r1 + 1;
        }

        protected void addBytes(byte[] r6) {
            if (r6 != null) goto L4;
            return;
        L4:
            int r0 = r6.length;
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L7;
            byte r2 = r6[r1];
            byte[] r3 = this.messageContents;
            int r4 = this.currentOutputPosition;
            r3[r4] = r2;
            this.currentOutputPosition = r4 + 1;
            r1 = r1 + 1;
            goto L5
        }

        protected void addUShort(int r2) {
            addByte((byte) (r2 & 255));
            addByte((byte) ((r2 >> 8) & 255));
        }

        protected void addULong(int r2) {
            addByte((byte) (r2 & 255));
            addByte((byte) ((r2 >> 8) & 255));
            addByte((byte) ((r2 >> 16) & 255));
            addByte((byte) ((r2 >> 24) & 255));
        }

        public String getResponse() {
            return new String(Base64.encode(getBytes(), 2), Consts.ASCII);
        }

        public byte[] getBytes() {
            if (this.messageContents != null) goto L5;
            buildMessage();
        L5:
            byte[] r0 = this.messageContents;
            int r1 = r0.length;
            int r2 = this.currentOutputPosition;
            if (r1 <= r2) goto L9;
            byte[] r3 = new byte[r2];
            System.arraycopy(r0, 0, r3, 0, r2);
            this.messageContents = r3;
        L9:
            return this.messageContents;
        }

        protected void buildMessage() {
            throw new RuntimeException("Message builder not implemented for " + getClass().getName());
        }
    }

    static class Type1Message extends NTLMMessage {
        private final byte[] domainBytes;
        private final int flags;
        private final byte[] hostBytes;

        private int getDefaultFlags() {
            return -1576500735;
        }

        Type1Message(String r2, String r3) throws NTLMEngineException {
            this(r2, r3, null);
        }

        Type1Message(String r2, String r3, Integer r4) throws NTLMEngineException {
            if (r4 != null) goto L5;
            int r5 = getDefaultFlags();
        L6:
            this.flags = r5;
            String r6 = NTLMEngineImpl.access$2200(r3);
            String r7 = NTLMEngineImpl.access$2300(r2);
            byte[] r8 = null;
            if (r6 == null) goto L9;
            byte[] r9 = r6.getBytes(NTLMEngineImpl.access$2400());
        L10:
            this.hostBytes = r9;
            if (r7 == null) goto L13;
            r8 = r7.toUpperCase(Locale.ROOT).getBytes(NTLMEngineImpl.access$2400());
        L13:
            this.domainBytes = r8;
            return;
        L9:
            r9 = null;
            goto L10
        L5:
            r5 = r4.intValue();
            goto L6
        }

        Type1Message() {
            this.hostBytes = null;
            this.domainBytes = null;
            this.flags = getDefaultFlags();
        }

        @Override // cz.msebera.android.httpclient.impl.auth.NTLMEngineImpl.NTLMMessage
        protected void buildMessage() {
            byte[] r0 = this.domainBytes;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.length;
        L6:
            byte[] r3 = this.hostBytes;
            if (r3 == null) goto L9;
            r1 = r3.length;
        L9:
            prepareResponse((r1 + 40) + r2, 1);
            addULong(this.flags);
            addUShort(r2);
            addUShort(r2);
            addULong((r1 + 32) + 8);
            addUShort(r1);
            addUShort(r1);
            addULong(40);
            addUShort(UCharacter.UnicodeBlock.SUPPLEMENTAL_SYMBOLS_AND_PICTOGRAPHS_ID);
            addULong(2600);
            addUShort(3840);
            byte[] r4 = this.hostBytes;
            if (r4 == null) goto L12;
            addBytes(r4);
        L12:
            byte[] r5 = this.domainBytes;
            if (r5 == null) goto L16;
            addBytes(r5);
            return;
        L16:
            return;
        L5:
            r2 = 0;
            goto L6
        }
    }

    static class Type2Message extends NTLMMessage {
        protected final byte[] challenge;
        protected final int flags;
        protected String target;
        protected byte[] targetInfo;

        Type2Message(String r2) throws NTLMEngineException {
            this(Base64.decode(r2.getBytes(NTLMEngineImpl.access$1700()), 2));
        }

        Type2Message(byte[] r4) throws NTLMEngineException {
            super(r4, 2);
            byte[] r5 = new byte[8];
            this.challenge = r5;
            readBytes(r5, 24);
            int r0 = readULong(20);
            this.flags = r0;
            this.target = null;
            if (getMessageLength() < 20) goto L7;
            byte[] r6 = readSecurityBuffer(12);
            if (r6.length == 0) goto L7;
            this.target = new String(r6, NTLMEngineImpl.access$2500(r0));
        L7:
            this.targetInfo = null;
            if (getMessageLength() < 48) goto L13;
            byte[] r7 = readSecurityBuffer(40);
            if (r7.length == 0) goto L14;
            this.targetInfo = r7;
            return;
        L14:
            return;
        }

        byte[] getChallenge() {
            return this.challenge;
        }

        String getTarget() {
            return this.target;
        }

        byte[] getTargetInfo() {
            return this.targetInfo;
        }

        int getFlags() {
            return this.flags;
        }
    }

    static class Type3Message extends NTLMMessage {
        protected final boolean computeMic;
        protected final byte[] domainBytes;
        protected final byte[] exportedSessionKey;
        protected final byte[] hostBytes;
        protected byte[] lmResp;
        protected byte[] ntResp;
        protected final byte[] sessionKey;
        protected final byte[] type1Message;
        protected final int type2Flags;
        protected final byte[] type2Message;
        protected final byte[] userBytes;

        Type3Message(String r13, String r14, String r15, String r16, byte[] r17, int r18, String r19, byte[] r20) throws NTLMEngineException {
            this(r13, r14, r15, r16, r17, r18, r19, r20, null, null, null);
        }

        Type3Message(Random r16, long r17, String r19, String r20, String r21, String r22, byte[] r23, int r24, String r25, byte[] r26) throws NTLMEngineException {
            this(r16, r17, r19, r20, r21, r22, r23, r24, r25, r26, null, null, null);
        }

        Type3Message(String r16, String r17, String r18, String r19, byte[] r20, int r21, String r22, byte[] r23, Certificate r24, byte[] r25, byte[] r26) throws NTLMEngineException {
            this(NTLMEngineImpl.access$000(), System.currentTimeMillis(), r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
        }

        Type3Message(Random r18, long r19, String r21, String r22, String r23, String r24, byte[] r25, int r26, String r27, byte[] r28, Certificate r29, byte[] r30, byte[] r31) throws NTLMEngineException {
            if (r18 == null) goto L52;
            this.type2Flags = r26;
            this.type1Message = r30;
            this.type2Message = r31;
            String r13 = NTLMEngineImpl.access$2200(r22);
            String r14 = NTLMEngineImpl.access$2300(r21);
            if (r29 == null) goto L7;
            byte[] r3 = addGssMicAvsToTargetInfo(r28, r29);
            this.computeMic = true;
            byte[] r12 = r3;
        L8:
            CipherGen r16 = new CipherGen(r18, r19, r14, r23, r24, r25, r27, r12);
            if ((8388608 & r26) == 0) goto L17;
            if (r28 == null) goto L17;
            if (r27 == null) goto L17;
            this.ntResp = r16.getNTLMv2Response();     // Catch: NTLMEngineException -> L27
            this.lmResp = r16.getLMv2Response();     // Catch: NTLMEngineException -> L27
            if ((r26 & 128) == 0) goto L15;
            byte[] r2 = r16.getLanManagerSessionKey();     // Catch: NTLMEngineException -> L27
        L53:
        L31:
            byte[] r4 = null;
            if ((r26 & 16) == 0) goto L38;
            if ((1073741824 & r26) == 0) goto L36;
            byte[] r5 = r16.getSecondaryKey();
            this.exportedSessionKey = r5;
            this.sessionKey = NTLMEngineImpl.RC4(r5, r2);
        L40:
            Charset r1 = NTLMEngineImpl.access$2500(r26);
            if (r13 == null) goto L43;
            byte[] r6 = r13.getBytes(r1);
        L44:
            this.hostBytes = r6;
            if (r14 == null) goto L47;
            r4 = r14.toUpperCase(Locale.ROOT).getBytes(r1);
        L47:
            this.domainBytes = r4;
            this.userBytes = r23.getBytes(r1);
            return;
        L43:
            r6 = null;
            goto L44
        L36:
            this.sessionKey = r2;
            this.exportedSessionKey = r2;
            goto L40
        L38:
            if (this.computeMic == true) goto L50;
            this.sessionKey = null;
            this.exportedSessionKey = null;
            goto L40
        L50:
            throw new NTLMEngineException("Cannot sign/seal: no exported session key");
        L15:
            r2 = r16.getNTLMv2UserSessionKey();     // Catch: NTLMEngineException -> L27
        L17:
            if ((524288 & r26) == 0) goto L22;
            this.ntResp = r16.getNTLM2SessionResponse();     // Catch: NTLMEngineException -> L27
            this.lmResp = r16.getLM2SessionResponse();     // Catch: NTLMEngineException -> L27
            if ((r26 & 128) == 0) goto L21;
            r2 = r16.getLanManagerSessionKey();     // Catch: NTLMEngineException -> L27
            goto L53
        L21:
            r2 = r16.getNTLM2SessionResponseUserSessionKey();     // Catch: NTLMEngineException -> L27
            goto L53
        L22:
            this.ntResp = r16.getNTLMResponse();     // Catch: NTLMEngineException -> L27
            this.lmResp = r16.getLMResponse();     // Catch: NTLMEngineException -> L27
            if ((r26 & 128) == 0) goto L25;
            r2 = r16.getLanManagerSessionKey();     // Catch: NTLMEngineException -> L27
            goto L53
        L25:
            r2 = r16.getNTLMUserSessionKey();     // Catch: NTLMEngineException -> L27
        L27:
            this.ntResp = new byte[0];
            this.lmResp = r16.getLMResponse();
            if ((r26 & 128) == 0) goto L30;
            r2 = r16.getLanManagerSessionKey();
            goto L31
        L30:
            r2 = r16.getLMUserSessionKey();
            goto L31
        L7:
            this.computeMic = false;
            r12 = r28;
            goto L8
        L52:
            throw new NTLMEngineException("Random generator not available");
        }

        public byte[] getEncryptedRandomSessionKey() {
            return this.sessionKey;
        }

        public byte[] getExportedSessionKey() {
            return this.exportedSessionKey;
        }

        @Override // cz.msebera.android.httpclient.impl.auth.NTLMEngineImpl.NTLMMessage
        protected void buildMessage() {
            int r1 = this.ntResp.length;
            int r2 = this.lmResp.length;
            byte[] r3 = this.domainBytes;
            if (r3 == null) goto L5;
            int r4 = r3.length;
        L6:
            byte[] r5 = this.hostBytes;
            if (r5 == null) goto L9;
            int r6 = r5.length;
        L10:
            int r7 = this.userBytes.length;
            byte[] r8 = this.sessionKey;
            if (r8 == null) goto L13;
            int r9 = r8.length;
        L15:
            if (this.computeMic == false) goto L17;
            int r10 = 16;
        L18:
            int r11 = r10 + 72;
            int r12 = r11 + r2;
            int r13 = r12 + r1;
            int r14 = r13 + r4;
            int r15 = r14 + r7;
            int r16 = r15 + r6;
            prepareResponse(r16 + r9, 3);
            addUShort(r2);
            addUShort(r2);
            addULong(r11);
            addUShort(r1);
            addUShort(r1);
            addULong(r12);
            addUShort(r4);
            addUShort(r4);
            addULong(r13);
            addUShort(r7);
            addUShort(r7);
            addULong(r14);
            addUShort(r6);
            addUShort(r6);
            addULong(r15);
            addUShort(r9);
            addUShort(r9);
            addULong(r16);
            addULong(this.type2Flags);
            addUShort(UCharacter.UnicodeBlock.SUPPLEMENTAL_SYMBOLS_AND_PICTOGRAPHS_ID);
            addULong(2600);
            addUShort(3840);
            if (this.computeMic == false) goto L21;
            int r17 = this.currentOutputPosition;
            this.currentOutputPosition += 16;
        L22:
            addBytes(this.lmResp);
            addBytes(this.ntResp);
            addBytes(this.domainBytes);
            addBytes(this.userBytes);
            addBytes(this.hostBytes);
            byte[] r18 = this.sessionKey;
            if (r18 == null) goto L26;
            addBytes(r18);
        L26:
            if (this.computeMic == false) goto L29;
            HMACMD5 r19 = new HMACMD5(this.exportedSessionKey);
            r19.update(this.type1Message);
            r19.update(this.type2Message);
            r19.update(this.messageContents);
            byte[] r20 = r19.getOutput();
            System.arraycopy(r20, 0, this.messageContents, r17, r20.length);
            return;
        L29:
            return;
        L21:
            r17 = -1;
            goto L22
        L17:
            r10 = 0;
            goto L18
        L13:
            r9 = 0;
            goto L15
        L9:
            r6 = 0;
            goto L10
        L5:
            r4 = 0;
            goto L6
        }

        private byte[] addGssMicAvsToTargetInfo(byte[] r7, Certificate r8) throws NTLMEngineException {
            byte[] r6 = new byte[(r7.length + 8) + 20];
            int r1 = r7.length - 4;
            System.arraycopy(r7, 0, r6, 0, r1);
            NTLMEngineImpl.writeUShort(r6, 6, r1);
            NTLMEngineImpl.writeUShort(r6, 4, r1 + 2);
            NTLMEngineImpl.writeULong(r6, 2, r1 + 4);
            NTLMEngineImpl.writeUShort(r6, 10, r1 + 8);
            NTLMEngineImpl.writeUShort(r6, 16, r1 + 10);
            byte[] r9 = r8.getEncoded();     // Catch: NoSuchAlgorithmException -> L6 CertificateEncodingException -> L9
            byte[] r10 = MessageDigest.getInstance("SHA-256").digest(r9);     // Catch: NoSuchAlgorithmException -> L6 CertificateEncodingException -> L9
            byte[] r11 = new byte[(NTLMEngineImpl.access$2600().length + 20) + r10.length];     // Catch: NoSuchAlgorithmException -> L6 CertificateEncodingException -> L9
            NTLMEngineImpl.writeULong(r11, 53, 16);     // Catch: NoSuchAlgorithmException -> L6 CertificateEncodingException -> L9
            System.arraycopy(NTLMEngineImpl.access$2600(), 0, r11, 20, NTLMEngineImpl.access$2600().length);     // Catch: NoSuchAlgorithmException -> L6 CertificateEncodingException -> L9
            System.arraycopy(r10, 0, r11, NTLMEngineImpl.access$2600().length + 20, r10.length);     // Catch: NoSuchAlgorithmException -> L6 CertificateEncodingException -> L9
            System.arraycopy(NTLMEngineImpl.getMD5().digest(r11), 0, r6, r1 + 12, 16);
            return r6;
        L6:
            e = move-exception;
            throw new NTLMEngineException(e.getMessage(), e);
        L9:
            e = move-exception;
            throw new NTLMEngineException(e.getMessage(), e);
        }
    }

    static int F(int r0, int r1, int r2) {
        int r3 = r1 & r0;
        return ((~r0) & r2) | r3;
    }

    static int G(int r1, int r2, int r3) {
        int r0 = r1 & r2;
        return ((r1 & r3) | r0) | (r2 & r3);
    }

    static int H(int r0, int r1, int r2) {
        return (r0 ^ r1) ^ r2;
    }

    static int rotintlft(int r1, int r2) {
        int r0 = r1 << r2;
        return (r1 >>> (32 - r2)) | r0;
    }

    static /* synthetic */ SecureRandom access$000() {
        return RND_GEN;
    }

    static /* synthetic */ byte[] access$100(Random r0) {
        return makeRandomChallenge(r0);
    }

    static /* synthetic */ Key access$1000(byte[] r0, int r1) {
        return createDESKey(r0, r1);
    }

    static /* synthetic */ byte[] access$1100() {
        return SIGN_MAGIC_CLIENT;
    }

    static /* synthetic */ byte[] access$1200() {
        return SEAL_MAGIC_CLIENT;
    }

    static /* synthetic */ byte[] access$1300() {
        return SIGN_MAGIC_SERVER;
    }

    static /* synthetic */ byte[] access$1400() {
        return SEAL_MAGIC_SERVER;
    }

    static /* synthetic */ byte[] access$1500(int r0) {
        return encodeLong(r0);
    }

    static /* synthetic */ void access$1600(byte[] r0, int r1, int r2) {
        encodeLong(r0, r1, r2);
    }

    static /* synthetic */ Charset access$1700() {
        return DEFAULT_CHARSET;
    }

    static /* synthetic */ byte[] access$1800() {
        return SIGNATURE;
    }

    static /* synthetic */ int access$1900(byte[] r0, int r1) {
        return readUShort(r0, r1);
    }

    static /* synthetic */ byte[] access$200(Random r0) {
        return makeSecondaryKey(r0);
    }

    static /* synthetic */ int access$2000(byte[] r0, int r1) {
        return readULong(r0, r1);
    }

    static /* synthetic */ byte[] access$2100(byte[] r0, int r1) {
        return readSecurityBuffer(r0, r1);
    }

    static /* synthetic */ String access$2200(String r0) {
        return convertHost(r0);
    }

    static /* synthetic */ String access$2300(String r0) {
        return convertDomain(r0);
    }

    static /* synthetic */ Charset access$2400() {
        return UNICODE_LITTLE_UNMARKED;
    }

    static /* synthetic */ Charset access$2500(int r0) throws NTLMEngineException {
        return getCharset(r0);
    }

    static /* synthetic */ byte[] access$2600() {
        return MAGIC_TLS_SERVER_ENDPOINT;
    }

    static /* synthetic */ byte[] access$300(String r0) throws NTLMEngineException {
        return lmHash(r0);
    }

    static /* synthetic */ byte[] access$400(byte[] r0, byte[] r1) throws NTLMEngineException {
        return lmResponse(r0, r1);
    }

    static /* synthetic */ byte[] access$500(String r0) throws NTLMEngineException {
        return ntlmHash(r0);
    }

    static /* synthetic */ byte[] access$600(String r0, String r1, byte[] r2) throws NTLMEngineException {
        return lmv2Hash(r0, r1, r2);
    }

    static /* synthetic */ byte[] access$700(String r0, String r1, byte[] r2) throws NTLMEngineException {
        return ntlmv2Hash(r0, r1, r2);
    }

    static /* synthetic */ byte[] access$800(byte[] r0, byte[] r1, byte[] r2) {
        return createBlob(r0, r1, r2);
    }

    static /* synthetic */ byte[] access$900(byte[] r0, byte[] r1, byte[] r2) {
        return lmv2Response(r0, r1, r2);
    }

    static {
        UNICODE_LITTLE_UNMARKED = Charset.forName("UnicodeLittleUnmarked");
        DEFAULT_CHARSET = Consts.ASCII;
        SecureRandom r0 = SecureRandom.getInstance("SHA1PRNG");     // Catch: Exception -> L5
    L6:
        RND_GEN = r0;
        SIGNATURE = getNullTerminatedAsciiString("NTLMSSP");
        SIGN_MAGIC_SERVER = getNullTerminatedAsciiString("session key to server-to-client signing key magic constant");
        SIGN_MAGIC_CLIENT = getNullTerminatedAsciiString("session key to client-to-server signing key magic constant");
        SEAL_MAGIC_SERVER = getNullTerminatedAsciiString("session key to server-to-client sealing key magic constant");
        SEAL_MAGIC_CLIENT = getNullTerminatedAsciiString("session key to client-to-server sealing key magic constant");
        MAGIC_TLS_SERVER_ENDPOINT = "tls-server-end-point:".getBytes(Consts.ASCII);
        TYPE_1_MESSAGE = new Type1Message().getResponse();
        return;
    L5:
        r0 = null;
        goto L6
    }

    private static byte[] getNullTerminatedAsciiString(String r3) {
        byte[] r4 = r3.getBytes(Consts.ASCII);
        byte[] r0 = new byte[r4.length + 1];
        System.arraycopy(r4, 0, r0, 0, r4.length);
        r0[r4.length] = 0;
        return r0;
    }

    NTLMEngineImpl() {
    }

    static String getType1Message(String r0, String r1) {
        return TYPE_1_MESSAGE;
    }

    static String getType3Message(String r10, String r11, String r12, String r13, byte[] r14, int r15, String r16, byte[] r17) throws NTLMEngineException {
        return new Type3Message(r13, r12, r10, r11, r14, r15, r16, r17).getResponse();
    }

    static String getType3Message(String r13, String r14, String r15, String r16, byte[] r17, int r18, String r19, byte[] r20, Certificate r21, byte[] r22, byte[] r23) throws NTLMEngineException {
        return new Type3Message(r16, r15, r13, r14, r17, r18, r19, r20, r21, r22, r23).getResponse();
    }

    private static int readULong(byte[] r2, int r3) {
        if (r2.length >= (r3 + 4)) goto L6;
        return 0;
    L6:
        int r0 = ((r2[r3] & 255) | ((r2[r3 + 1] & 255) << 8)) | ((r2[r3 + 2] & 255) << 16);
        return ((r2[r3 + 3] & 255) << 24) | r0;
    }

    private static int readUShort(byte[] r2, int r3) {
        if (r2.length >= (r3 + 2)) goto L6;
        return 0;
    L6:
        int r0 = r2[r3] & 255;
        return ((r2[r3 + 1] & 255) << 8) | r0;
    }

    private static byte[] readSecurityBuffer(byte[] r3, int r4) {
        int r0 = readUShort(r3, r4);
        int r5 = readULong(r3, r4 + 4);
        if (r3.length < (r5 + r0)) goto L5;
        byte[] r1 = new byte[r0];
        System.arraycopy(r3, r5, r1, 0, r0);
        return r1;
    L5:
        return new byte[r0];
    }

    private static byte[] makeRandomChallenge(Random r1) {
        byte[] r0 = new byte[8];
        monitor-enter(r1);
        r1.nextBytes(r0);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    private static byte[] makeSecondaryKey(Random r1) {
        byte[] r0 = new byte[16];
        monitor-enter(r1);
        r1.nextBytes(r0);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    static byte[] hmacMD5(byte[] r1, byte[] r2) throws NTLMEngineException {
        HMACMD5 r0 = new HMACMD5(r2);
        r0.update(r1);
        return r0.getOutput();
    }

    static byte[] RC4(byte[] r3, byte[] r4) throws NTLMEngineException {
        Cipher r1 = Cipher.getInstance("RC4");     // Catch: Exception -> L5
        r1.init(1, new SecretKeySpec(r4, "RC4"));     // Catch: Exception -> L5
        return r1.doFinal(r3);
    L5:
        e = move-exception;
        throw new NTLMEngineException(e.getMessage(), e);
    }

    static byte[] ntlm2SessionResponse(byte[] r2, byte[] r3, byte[] r4) throws NTLMEngineException {
        MessageDigest r0 = getMD5();     // Catch: Exception -> L4
        r0.update(r3);     // Catch: Exception -> L4
        r0.update(r4);     // Catch: Exception -> L4
        byte[] r5 = r0.digest();     // Catch: Exception -> L4
        byte[] r1 = new byte[8];     // Catch: Exception -> L4
        System.arraycopy(r5, 0, r1, 0, 8);     // Catch: Exception -> L4
        return lmResponse(r2, r1);
    L4:
        e = move-exception;
        if ((e instanceof NTLMEngineException) == false) goto L10;
        throw ((NTLMEngineException) e);
    L10:
        throw new NTLMEngineException(e.getMessage(), e);
    }

    private static byte[] lmHash(String r5) throws NTLMEngineException {
        byte[] r6 = r5.toUpperCase(Locale.ROOT).getBytes(Consts.ASCII);     // Catch: Exception -> L4
        byte[] r1 = new byte[14];     // Catch: Exception -> L4
        System.arraycopy(r6, 0, r1, 0, Math.min(r6.length, 14));     // Catch: Exception -> L4
        Key r7 = createDESKey(r1, 0);     // Catch: Exception -> L4
        Key r0 = createDESKey(r1, 7);     // Catch: Exception -> L4
        byte[] r2 = "KGS!@#$%".getBytes(Consts.ASCII);     // Catch: Exception -> L4
        Cipher r3 = Cipher.getInstance("DES/ECB/NoPadding");     // Catch: Exception -> L4
        r3.init(1, r7);     // Catch: Exception -> L4
        byte[] r8 = r3.doFinal(r2);     // Catch: Exception -> L4
        r3.init(1, r0);     // Catch: Exception -> L4
        byte[] r4 = r3.doFinal(r2);     // Catch: Exception -> L4
        byte[] r9 = new byte[16];     // Catch: Exception -> L4
        System.arraycopy(r8, 0, r9, 0, 8);     // Catch: Exception -> L4
        System.arraycopy(r4, 0, r9, 8, 8);     // Catch: Exception -> L4
        return r9;
    L4:
        e = move-exception;
        throw new NTLMEngineException(e.getMessage(), e);
    }

    private static byte[] ntlmHash(String r1) throws NTLMEngineException {
        Charset r0 = UNICODE_LITTLE_UNMARKED;
        if (r0 == null) goto L7;
        byte[] r2 = r1.getBytes(r0);
        MD4 r3 = new MD4();
        r3.update(r2);
        return r3.getOutput();
    L7:
        throw new NTLMEngineException("Unicode not supported");
    }

    private static byte[] lmv2Hash(String r2, String r3, byte[] r4) throws NTLMEngineException {
        Charset r0 = UNICODE_LITTLE_UNMARKED;
        if (r0 == null) goto L10;
        HMACMD5 r1 = new HMACMD5(r4);
        r1.update(r3.toUpperCase(Locale.ROOT).getBytes(r0));
        if (r2 == null) goto L8;
        r1.update(r2.toUpperCase(Locale.ROOT).getBytes(r0));
    L8:
        return r1.getOutput();
    L10:
        throw new NTLMEngineException("Unicode not supported");
    }

    private static byte[] ntlmv2Hash(String r2, String r3, byte[] r4) throws NTLMEngineException {
        Charset r0 = UNICODE_LITTLE_UNMARKED;
        if (r0 == null) goto L10;
        HMACMD5 r1 = new HMACMD5(r4);
        r1.update(r3.toUpperCase(Locale.ROOT).getBytes(r0));
        if (r2 == null) goto L8;
        r1.update(r2.getBytes(r0));
    L8:
        return r1.getOutput();
    L10:
        throw new NTLMEngineException("Unicode not supported");
    }

    private static byte[] lmResponse(byte[] r6, byte[] r7) throws NTLMEngineException {
        byte[] r0 = new byte[21];     // Catch: Exception -> L5
        System.arraycopy(r6, 0, r0, 0, 16);     // Catch: Exception -> L5
        Key r8 = createDESKey(r0, 0);     // Catch: Exception -> L5
        Key r3 = createDESKey(r0, 7);     // Catch: Exception -> L5
        Key r1 = createDESKey(r0, 14);     // Catch: Exception -> L5
        Cipher r4 = Cipher.getInstance("DES/ECB/NoPadding");     // Catch: Exception -> L5
        r4.init(1, r8);     // Catch: Exception -> L5
        byte[] r9 = r4.doFinal(r7);     // Catch: Exception -> L5
        r4.init(1, r3);     // Catch: Exception -> L5
        byte[] r5 = r4.doFinal(r7);     // Catch: Exception -> L5
        r4.init(1, r1);     // Catch: Exception -> L5
        byte[] r10 = r4.doFinal(r7);     // Catch: Exception -> L5
        byte[] r2 = new byte[24];     // Catch: Exception -> L5
        System.arraycopy(r9, 0, r2, 0, 8);     // Catch: Exception -> L5
        System.arraycopy(r5, 0, r2, 8, 8);     // Catch: Exception -> L5
        System.arraycopy(r10, 0, r2, 16, 8);     // Catch: Exception -> L5
        return r2;
    L5:
        e = move-exception;
        throw new NTLMEngineException(e.getMessage(), e);
    }

    private static byte[] lmv2Response(byte[] r2, byte[] r3, byte[] r4) {
        HMACMD5 r0 = new HMACMD5(r2);
        r0.update(r3);
        r0.update(r4);
        byte[] r5 = r0.getOutput();
        byte[] r6 = new byte[r5.length + r4.length];
        System.arraycopy(r5, 0, r6, 0, r5.length);
        System.arraycopy(r4, 0, r6, r5.length, r4.length);
        return r6;
    }

    private static byte[] encodeLong(int r2) {
        byte[] r0 = new byte[4];
        encodeLong(r0, 0, r2);
        return r0;
    }

    private static void encodeLong(byte[] r2, int r3, int r4) {
        r2[r3 + 0] = (byte) (r4 & 255);
        r2[r3 + 1] = (byte) ((r4 >> 8) & 255);
        r2[r3 + 2] = (byte) ((r4 >> 16) & 255);
        r2[r3 + 3] = (byte) ((r4 >> 24) & 255);
    }

    private static byte[] createBlob(byte[] r8, byte[] r9, byte[] r10) {
        byte[] r5 = new byte[((((r10.length + 8) + 8) + 4) + r9.length) + 4];
        System.arraycopy(new byte[]{1, 1, 0, 0}, 0, r5, 0, 4);
        System.arraycopy(new byte[]{0, 0, 0, 0}, 0, r5, 4, 4);
        System.arraycopy(r10, 0, r5, 8, r10.length);
        int r11 = r10.length + 8;
        System.arraycopy(r8, 0, r5, r11, 8);
        int r12 = r11 + 8;
        System.arraycopy(new byte[]{0, 0, 0, 0}, 0, r5, r12, 4);
        int r13 = r12 + 4;
        System.arraycopy(r9, 0, r5, r13, r9.length);
        System.arraycopy(new byte[]{0, 0, 0, 0}, 0, r5, r13 + r9.length, 4);
        return r5;
    }

    private static Key createDESKey(byte[] r9, int r10) {
        byte[] r1 = new byte[7];
        System.arraycopy(r9, r10, r1, 0, 7);
        byte[] r11 = {r1[0], (byte) ((r1[0] << 7) | ((r1[1] & 255) >>> 1)), (byte) ((r1[1] << 6) | ((r1[2] & 255) >>> 2)), (byte) ((r1[2] << 5) | ((r1[3] & 255) >>> 3)), (byte) ((r1[3] << 4) | ((r1[4] & 255) >>> 4)), (byte) ((r1[4] << 3) | ((r1[5] & 255) >>> 5)), (byte) ((r1[5] << 2) | ((r1[6] & 255) >>> 6)), (byte) (r1[6] << 1)};
        oddParity(r11);
        return new SecretKeySpec(r11, "DES");
    }

    private static void oddParity(byte[] r5) {
        int r1 = 0;
    L4:
        if (r1 >= r5.length) goto L13;
        byte r2 = r5[r1];
        boolean r4 = true;
        if (((((((((r2 >>> 7) ^ (r2 >>> 6)) ^ (r2 >>> 5)) ^ (r2 >>> 4)) ^ (r2 >>> 3)) ^ (r2 >>> 2)) ^ (r2 >>> 1)) & 1) == 0) goto L9;
        r4 = false;
    L9:
        if (r4 == false) goto L11;
        r5[r1] = (byte) (r2 | 1);
    L12:
        r1 = r1 + 1;
        goto L4
    L11:
        r5[r1] = (byte) (r2 & (-2));
        goto L12
    }

    private static Charset getCharset(int r1) throws NTLMEngineException {
        if ((r1 & 1) == 0) goto L5;
        Charset r2 = UNICODE_LITTLE_UNMARKED;
        if (r2 == null) goto L10;
        return r2;
    L10:
        throw new NTLMEngineException("Unicode not supported");
    L5:
        return DEFAULT_CHARSET;
    }

    private static String stripDotSuffix(String r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        int r0 = r2.indexOf(46);
        if (r0 != (-1)) goto L8;
        return r2;
    L8:
        return r2.substring(0, r0);
    }

    private static String convertHost(String r0) {
        return stripDotSuffix(r0);
    }

    private static String convertDomain(String r0) {
        return stripDotSuffix(r0);
    }

    static void writeUShort(byte[] r1, int r2, int r3) {
        r1[r3] = (byte) (r2 & 255);
        r1[r3 + 1] = (byte) ((r2 >> 8) & 255);
    }

    static void writeULong(byte[] r2, int r3, int r4) {
        r2[r4] = (byte) (r3 & 255);
        r2[r4 + 1] = (byte) ((r3 >> 8) & 255);
        r2[r4 + 2] = (byte) ((r3 >> 16) & 255);
        r2[r4 + 3] = (byte) ((r3 >> 24) & 255);
    }

    static MessageDigest getMD5() {
        return MessageDigest.getInstance("MD5");
    L4:
        e = move-exception;
        throw new RuntimeException("MD5 message digest doesn't seem to exist - fatal error: " + e.getMessage(), e);
    }

    @Override // cz.msebera.android.httpclient.impl.auth.NTLMEngine
    public String generateType1Msg(String r1, String r2) throws NTLMEngineException {
        return getType1Message(r2, r1);
    }

    @Override // cz.msebera.android.httpclient.impl.auth.NTLMEngine
    public String generateType3Msg(String r9, String r10, String r11, String r12, String r13) throws NTLMEngineException {
        Type2Message r8 = new Type2Message(r13);
        return getType3Message(r9, r10, r12, r11, r8.getChallenge(), r8.getFlags(), r8.getTarget(), r8.getTargetInfo());
    }
}
