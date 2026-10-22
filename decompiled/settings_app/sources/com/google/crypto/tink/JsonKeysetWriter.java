package com.google.crypto.tink;

import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.KeysetInfo;
import com.google.crypto.tink.subtle.Base64;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public final class JsonKeysetWriter implements KeysetWriter {
    private static final Charset UTF_8 = null;
    private final OutputStream outputStream;

    private long toUnsignedLong(int x) {
        return ((long) x) & 4294967295L;
    }

    static {
        UTF_8 = Charset.forName("UTF-8");
    }

    private JsonKeysetWriter(OutputStream stream) {
        this.outputStream = stream;
    }

    public static KeysetWriter withOutputStream(OutputStream stream) {
        return new JsonKeysetWriter(stream);
    }

    @Deprecated
    public static KeysetWriter withFile(File file) throws IOException {
        return withOutputStream(new FileOutputStream(file));
    }

    @Deprecated
    public static KeysetWriter withPath(String path) throws IOException {
        return withOutputStream(new FileOutputStream(new File(path)));
    }

    @Deprecated
    public static KeysetWriter withPath(Path path) throws IOException {
        return withOutputStream(new FileOutputStream(path.toFile()));
    }

    @Override // com.google.crypto.tink.KeysetWriter
    public void write(Keyset keyset) throws IOException {
        OutputStream r0 = this.outputStream;     // Catch: Throwable -> L5 JsonParseException -> L7
        String r3 = toJson(keyset).toString();     // Catch: Throwable -> L5 JsonParseException -> L7
        Charset r1 = UTF_8;     // Catch: Throwable -> L5 JsonParseException -> L7
        r0.write(r3.getBytes(r1));     // Catch: Throwable -> L5 JsonParseException -> L7
        this.outputStream.write(System.lineSeparator().getBytes(r1));     // Catch: Throwable -> L5 JsonParseException -> L7
        this.outputStream.close();
        return;
    L7:
        e = move-exception;
        throw new IOException(e);     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        this.outputStream.close();
        throw th;
    }

    @Override // com.google.crypto.tink.KeysetWriter
    public void write(EncryptedKeyset keyset) throws IOException {
        OutputStream r0 = this.outputStream;
        String r3 = toJson(keyset).toString();
        Charset r1 = UTF_8;
        r0.write(r3.getBytes(r1));
        this.outputStream.write(System.lineSeparator().getBytes(r1));
        this.outputStream.close();
    }

    private JsonObject toJson(Keyset keyset) {
        JsonObject r0 = new JsonObject();
        r0.addProperty("primaryKeyId", Long.valueOf(toUnsignedLong(keyset.getPrimaryKeyId())));
        JsonArray r1 = new JsonArray();
        Iterator<Keyset.Key> r4 = keyset.getKeyList().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r1.add(toJson(r4.next()));
        goto L4
    L6:
        r0.add("key", r1);
        return r0;
    }

    private JsonObject toJson(Keyset.Key key) {
        JsonObject r0 = new JsonObject();
        r0.add("keyData", toJson(key.getKeyData()));
        r0.addProperty("status", key.getStatus().name());
        r0.addProperty("keyId", Long.valueOf(toUnsignedLong(key.getKeyId())));
        r0.addProperty("outputPrefixType", key.getOutputPrefixType().name());
        return r0;
    }

    private JsonObject toJson(KeyData keyData) {
        JsonObject r2 = new JsonObject();
        r2.addProperty("typeUrl", keyData.getTypeUrl());
        r2.addProperty("value", Base64.encode(keyData.getValue().toByteArray()));
        r2.addProperty("keyMaterialType", keyData.getKeyMaterialType().name());
        return r2;
    }

    private JsonObject toJson(EncryptedKeyset keyset) {
        JsonObject r0 = new JsonObject();
        r0.addProperty("encryptedKeyset", Base64.encode(keyset.getEncryptedKeyset().toByteArray()));
        r0.add("keysetInfo", toJson(keyset.getKeysetInfo()));
        return r0;
    }

    private JsonObject toJson(KeysetInfo keysetInfo) {
        JsonObject r0 = new JsonObject();
        r0.addProperty("primaryKeyId", Long.valueOf(toUnsignedLong(keysetInfo.getPrimaryKeyId())));
        JsonArray r1 = new JsonArray();
        Iterator<KeysetInfo.KeyInfo> r4 = keysetInfo.getKeyInfoList().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r1.add(toJson(r4.next()));
        goto L4
    L6:
        r0.add("keyInfo", r1);
        return r0;
    }

    private JsonObject toJson(KeysetInfo.KeyInfo keyInfo) {
        JsonObject r0 = new JsonObject();
        r0.addProperty("typeUrl", keyInfo.getTypeUrl());
        r0.addProperty("status", keyInfo.getStatus().name());
        r0.addProperty("keyId", Long.valueOf(toUnsignedLong(keyInfo.getKeyId())));
        r0.addProperty("outputPrefixType", keyInfo.getOutputPrefixType().name());
        return r0;
    }
}
