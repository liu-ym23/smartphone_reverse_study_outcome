package com.google.crypto.tink.subtle.prf;

import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.internal.EnumTypeProtoConverter;
import com.google.crypto.tink.prf.HkdfPrfKey;
import com.google.crypto.tink.prf.HkdfPrfParameters;
import com.google.crypto.tink.subtle.EngineFactory;
import com.google.crypto.tink.subtle.Enums;
import com.google.crypto.tink.util.Bytes;
import com.google.errorprone.annotations.Immutable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
public class HkdfStreamingPrf implements StreamingPrf {
    private static final EnumTypeProtoConverter<Enums.HashType, HkdfPrfParameters.HashType> HASH_TYPE_CONVERTER = null;
    private final Enums.HashType hashType;
    private final byte[] ikm;
    private final byte[] salt;

    /* JADX INFO: renamed from: com.google.crypto.tink.subtle.prf.HkdfStreamingPrf$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType = null;

        static {
            int[] r0 = new int[Enums.HashType.values().length];
            $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType = r0;
            r0[Enums.HashType.SHA1.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[Enums.HashType.SHA256.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[Enums.HashType.SHA384.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[Enums.HashType.SHA512.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    private class HkdfInputStream extends InputStream {
        private ByteBuffer buffer;
        private int ctr;
        private final byte[] input;
        private Mac mac;
        private byte[] prk;
        final /* synthetic */ HkdfStreamingPrf this$0;

        public HkdfInputStream(final HkdfStreamingPrf this$0, final byte[] input) {
            this.this$0 = this$0;
            this.ctr = -1;
            this.input = Arrays.copyOf(input, input.length);
        }

        private void initialize() throws GeneralSecurityException, IOException {
            this.mac = EngineFactory.MAC.getInstance(HkdfStreamingPrf.access$100(HkdfStreamingPrf.access$000(this.this$0)));     // Catch: GeneralSecurityException -> L12
            if (HkdfStreamingPrf.access$200(this.this$0) != null) goto L6;
        L9:
            this.mac.init(new SecretKeySpec(new byte[this.mac.getMacLength()], HkdfStreamingPrf.access$100(HkdfStreamingPrf.access$000(this.this$0))));
        L10:
            this.mac.update(HkdfStreamingPrf.access$300(this.this$0));
            this.prk = this.mac.doFinal();
            ByteBuffer r1 = ByteBuffer.allocateDirect(0);
            this.buffer = r1;
            r1.mark();
            this.ctr = 0;
            return;
        L6:
            if (HkdfStreamingPrf.access$200(this.this$0).length == 0) goto L9;
            this.mac.init(new SecretKeySpec(HkdfStreamingPrf.access$200(this.this$0), HkdfStreamingPrf.access$100(HkdfStreamingPrf.access$000(this.this$0))));
        L12:
            e = move-exception;
            throw new IOException("Creating HMac failed", e);
        }

        private void updateBuffer() throws GeneralSecurityException, IOException {
            this.mac.init(new SecretKeySpec(this.prk, HkdfStreamingPrf.access$100(HkdfStreamingPrf.access$000(this.this$0))));
            this.buffer.reset();
            this.mac.update(this.buffer);
            this.mac.update(this.input);
            int r0 = this.ctr + 1;
            this.ctr = r0;
            this.mac.update((byte) r0);
            ByteBuffer r1 = ByteBuffer.wrap(this.mac.doFinal());
            this.buffer = r1;
            r1.mark();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            byte[] r1 = new byte[1];
            int r3 = read(r1, 0, 1);
            if (r3 != 1) goto L7;
            return r1[0] & 255;
        L7:
            if (r3 != (-1)) goto L10;
            return r3;
        L10:
            throw new IOException("Reading failed");
        }

        @Override // java.io.InputStream
        public int read(byte[] dst) throws IOException {
            return read(dst, 0, dst.length);
        }

        @Override // java.io.InputStream
        public int read(byte[] b, int off, int len) throws IOException {
        L16:
            e = move-exception;
            this.mac = null;
            throw new IOException("HkdfInputStream failed", e);
        L3:
            if (this.ctr != (-1)) goto L5;
            initialize();     // Catch: GeneralSecurityException -> L16
        L5:
            int r0 = 0;
        L6:
            if (r0 >= len) goto L15;
            if (this.buffer.hasRemaining() == false) goto L10;
        L13:
            int r1 = Math.min(len - r0, this.buffer.remaining());     // Catch: GeneralSecurityException -> L16
            this.buffer.get(b, off, r1);     // Catch: GeneralSecurityException -> L16
            off = off + r1;
            r0 = r0 + r1;
            goto L6
        L10:
            if (this.ctr == 255) goto L11;
            updateBuffer();     // Catch: GeneralSecurityException -> L16
            goto L13
        L11:
            return r0;
        L15:
            return r0;
        }
    }

    static /* synthetic */ Enums.HashType access$000(HkdfStreamingPrf r0) {
        return r0.hashType;
    }

    static /* synthetic */ String access$100(Enums.HashType r0) throws GeneralSecurityException {
        return getJavaxHmacName(r0);
    }

    static /* synthetic */ byte[] access$200(HkdfStreamingPrf r0) {
        return r0.salt;
    }

    static /* synthetic */ byte[] access$300(HkdfStreamingPrf r0) {
        return r0.ikm;
    }

    static {
        HASH_TYPE_CONVERTER = EnumTypeProtoConverter.builder().add(Enums.HashType.SHA1, HkdfPrfParameters.HashType.SHA1).add(Enums.HashType.SHA224, HkdfPrfParameters.HashType.SHA224).add(Enums.HashType.SHA256, HkdfPrfParameters.HashType.SHA256).add(Enums.HashType.SHA384, HkdfPrfParameters.HashType.SHA384).add(Enums.HashType.SHA512, HkdfPrfParameters.HashType.SHA512).build();
    }

    private static String getJavaxHmacName(Enums.HashType hashType) throws GeneralSecurityException {
        int r0 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[hashType.ordinal()];
        if (r0 != 1) goto L5;
        return "HmacSha1";
    L5:
        if (r0 != 2) goto L7;
        return "HmacSha256";
    L7:
        if (r0 != 3) goto L9;
        return "HmacSha384";
    L9:
        if (r0 != 4) goto L13;
        return "HmacSha512";
    L13:
        throw new GeneralSecurityException("No getJavaxHmacName for given hash " + hashType + " known");
    }

    public HkdfStreamingPrf(final Enums.HashType hashType, final byte[] ikm, final byte[] salt) {
        this.hashType = hashType;
        this.ikm = Arrays.copyOf(ikm, ikm.length);
        this.salt = Arrays.copyOf(salt, salt.length);
    }

    public static StreamingPrf create(HkdfPrfKey key) throws GeneralSecurityException {
        Bytes r0 = key.getParameters().getSalt();
        Enums.HashType r2 = (Enums.HashType) HASH_TYPE_CONVERTER.toProtoEnum(key.getParameters().getHashType());
        byte[] r4 = key.getKeyBytes().toByteArray(InsecureSecretKeyAccess.get());
        if (r0 != null) goto L5;
        byte[] r1 = new byte[0];
    L7:
        return new HkdfStreamingPrf(r2, r4, r1);
    L5:
        r1 = r0.toByteArray();
        goto L7
    }

    @Override // com.google.crypto.tink.subtle.prf.StreamingPrf
    public InputStream computePrf(final byte[] input) {
        return new HkdfInputStream(this, input);
    }
}
