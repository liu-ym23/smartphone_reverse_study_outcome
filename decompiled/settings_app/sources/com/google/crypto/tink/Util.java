package com.google.crypto.tink;

import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.KeysetInfo;
import com.google.crypto.tink.proto.OutputPrefixType;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
final class Util {
    public static final Charset UTF_8 = null;

    static {
        UTF_8 = Charset.forName("UTF-8");
    }

    public static KeysetInfo getKeysetInfo(Keyset keyset) {
        KeysetInfo.Builder r0 = KeysetInfo.newBuilder().setPrimaryKeyId(keyset.getPrimaryKeyId());
        Iterator<Keyset.Key> r2 = keyset.getKeyList().iterator();
    L4:
        if (r2.hasNext() == false) goto L7;
        r0.addKeyInfo(getKeyInfo(r2.next()));
        goto L4
    L7:
        return (KeysetInfo) r0.build();
    }

    public static KeysetInfo.KeyInfo getKeyInfo(Keyset.Key key) {
        return (KeysetInfo.KeyInfo) KeysetInfo.KeyInfo.newBuilder().setTypeUrl(key.getKeyData().getTypeUrl()).setStatus(key.getStatus()).setOutputPrefixType(key.getOutputPrefixType()).setKeyId(key.getKeyId()).build();
    }

    public static void validateKey(Keyset.Key key) throws GeneralSecurityException {
        if (key.hasKeyData() == false) goto L14;
        if (key.getOutputPrefixType() == OutputPrefixType.UNKNOWN_PREFIX) goto L12;
        if (key.getStatus() == KeyStatusType.UNKNOWN_STATUS) goto L10;
        return;
    L10:
        throw new GeneralSecurityException(String.format("key %d has unknown status", new Object[]{Integer.valueOf(key.getKeyId())}));
    L12:
        throw new GeneralSecurityException(String.format("key %d has unknown prefix", new Object[]{Integer.valueOf(key.getKeyId())}));
    L14:
        throw new GeneralSecurityException(String.format("key %d has no key data", new Object[]{Integer.valueOf(key.getKeyId())}));
    }

    public static void validateKeyset(Keyset keyset) throws GeneralSecurityException {
        int r0 = keyset.getPrimaryKeyId();
        Iterator<Keyset.Key> r9 = keyset.getKeyList().iterator();
        int r3 = 0;
        boolean r4 = false;
        boolean r5 = true;
    L4:
        if (r9.hasNext() == false) goto L18;
        Keyset.Key r6 = r9.next();
        if (r6.getStatus() != KeyStatusType.ENABLED) goto L4;
        validateKey(r6);
        if (r6.getKeyId() != r0) goto L15;
        if (r4 == true) goto L13;
        r4 = true;
        goto L15
    L13:
        throw new GeneralSecurityException("keyset contains multiple primary keys");
    L15:
        if (r6.getKeyData().getKeyMaterialType() == KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC) goto L17;
        r5 = false;
    L17:
        r3 = r3 + 1;
        goto L4
    L18:
        if (r3 == 0) goto L26;
        if (r4 == true) goto L24;
        if (r5 == false) goto L23;
        return;
    L23:
        throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
    L24:
        return;
    L26:
        throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
    }

    public static byte[] readAll(InputStream inputStream) throws IOException {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        byte[] r1 = new byte[1024];
    L3:
        int r2 = inputStream.read(r1);
        if (r2 == (-1)) goto L7;
        r0.write(r1, 0, r2);
        goto L3
    L7:
        return r0.toByteArray();
    }

    private Util() {
    }
}
