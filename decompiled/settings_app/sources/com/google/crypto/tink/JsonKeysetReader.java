package com.google.crypto.tink;

import com.google.crypto.tink.internal.JsonParser;
import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.KeysetInfo;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.subtle.Base64;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Path;

/* JADX INFO: loaded from: classes4.dex */
public final class JsonKeysetReader implements KeysetReader {
    private static final long MAX_KEY_ID = 4294967295L;
    private static final long MIN_KEY_ID = -2147483648L;
    private static final Charset UTF_8 = null;
    private final InputStream inputStream;
    private boolean urlSafeBase64;

    static {
        UTF_8 = Charset.forName("UTF-8");
    }

    private JsonKeysetReader(InputStream inputStream) {
        this.urlSafeBase64 = false;
        this.inputStream = inputStream;
    }

    public static JsonKeysetReader withInputStream(InputStream input) throws IOException {
        return new JsonKeysetReader(input);
    }

    @Deprecated
    public static JsonKeysetReader withJsonObject(Object input) {
        return withString(input.toString());
    }

    public static JsonKeysetReader withString(String input) {
        return new JsonKeysetReader(new ByteArrayInputStream(input.getBytes(UTF_8)));
    }

    @Deprecated
    public static JsonKeysetReader withBytes(final byte[] bytes) {
        return new JsonKeysetReader(new ByteArrayInputStream(bytes));
    }

    @Deprecated
    public static JsonKeysetReader withFile(File file) throws IOException {
        return withInputStream(new FileInputStream(file));
    }

    @Deprecated
    public static JsonKeysetReader withPath(String path) throws IOException {
        return withInputStream(new FileInputStream(new File(path)));
    }

    @Deprecated
    public static JsonKeysetReader withPath(Path path) throws IOException {
        return withInputStream(new FileInputStream(path.toFile()));
    }

    public JsonKeysetReader withUrlSafeBase64() {
        this.urlSafeBase64 = true;
        return this;
    }

    @Override // com.google.crypto.tink.KeysetReader
    public Keyset read() throws IOException {
        Keyset r0 = keysetFromJson(JsonParser.parse(new String(Util.readAll(this.inputStream), UTF_8)).getAsJsonObject());     // Catch: Throwable -> L7 Throwable -> L9
        InputStream r3 = this.inputStream;
        if (r3 == null) goto L6;
        r3.close();
    L6:
        return r0;
    L7:
        th = move-exception;
        InputStream r4 = this.inputStream;
        if (r4 == null) goto L15;
        r4.close();
    L15:
        throw th;
    L9:
        e = move-exception;
        throw new IOException(e);     // Catch: Throwable -> L7
    }

    @Override // com.google.crypto.tink.KeysetReader
    public EncryptedKeyset readEncrypted() throws IOException {
        EncryptedKeyset r0 = encryptedKeysetFromJson(JsonParser.parse(new String(Util.readAll(this.inputStream), UTF_8)).getAsJsonObject());     // Catch: Throwable -> L7 Throwable -> L9
        InputStream r3 = this.inputStream;
        if (r3 == null) goto L6;
        r3.close();
    L6:
        return r0;
    L7:
        th = move-exception;
        InputStream r4 = this.inputStream;
        if (r4 == null) goto L15;
        r4.close();
    L15:
        throw th;
    L9:
        e = move-exception;
        throw new IOException(e);     // Catch: Throwable -> L7
    }

    private static int getKeyId(JsonElement element) throws IOException {
        long r0 = JsonParser.getParsedNumberAsLongOrThrow(element);     // Catch: NumberFormatException -> L11
        if (r0 > MAX_KEY_ID) goto L10;
        if (r0 < MIN_KEY_ID) goto L10;
        return (int) element.getAsLong();
    L10:
        throw new IOException("invalid key id");
    L11:
        e = move-exception;
        throw new IOException(e);
    }

    private Keyset keysetFromJson(JsonObject json) throws IOException {
        validateKeyset(json);
        Keyset.Builder r0 = Keyset.newBuilder();
        if (json.has("primaryKeyId") == false) goto L5;
        r0.setPrimaryKeyId(getKeyId(json.get("primaryKeyId")));
    L5:
        JsonArray r4 = json.getAsJsonArray("key");
        int r1 = 0;
    L7:
        if (r1 >= r4.size()) goto L10;
        r0.addKey(keyFromJson(r4.get(r1).getAsJsonObject()));
        r1 = r1 + 1;
        goto L7
    L10:
        return (Keyset) r0.build();
    }

    private EncryptedKeyset encryptedKeysetFromJson(JsonObject json) throws IOException {
        validateEncryptedKeyset(json);
        if (this.urlSafeBase64 == false) goto L5;
        byte[] r2 = Base64.urlSafeDecode(json.get("encryptedKeyset").getAsString());
    L7:
        if (json.has("keysetInfo") == false) goto L11;
        return (EncryptedKeyset) EncryptedKeyset.newBuilder().setEncryptedKeyset(ByteString.copyFrom(r2)).setKeysetInfo(keysetInfoFromJson(json.getAsJsonObject("keysetInfo"))).build();
    L11:
        return (EncryptedKeyset) EncryptedKeyset.newBuilder().setEncryptedKeyset(ByteString.copyFrom(r2)).build();
    L5:
        r2 = Base64.decode(json.get("encryptedKeyset").getAsString());
        goto L7
    }

    private Keyset.Key keyFromJson(JsonObject json) throws IOException {
        validateKey(json);
        return (Keyset.Key) Keyset.Key.newBuilder().setStatus(getStatus(json.get("status").getAsString())).setKeyId(getKeyId(json.get("keyId"))).setOutputPrefixType(getOutputPrefixType(json.get("outputPrefixType").getAsString())).setKeyData(keyDataFromJson(json.getAsJsonObject("keyData"))).build();
    }

    private static KeysetInfo keysetInfoFromJson(JsonObject json) throws IOException {
        KeysetInfo.Builder r0 = KeysetInfo.newBuilder();
        if (json.has("primaryKeyId") == false) goto L6;
        r0.setPrimaryKeyId(getKeyId(json.get("primaryKeyId")));
    L6:
        if (json.has("keyInfo") == false) goto L12;
        JsonArray r3 = json.getAsJsonArray("keyInfo");
        int r1 = 0;
    L9:
        if (r1 >= r3.size()) goto L12;
        r0.addKeyInfo(keyInfoFromJson(r3.get(r1).getAsJsonObject()));
        r1 = r1 + 1;
    L12:
        return (KeysetInfo) r0.build();
    }

    private static KeysetInfo.KeyInfo keyInfoFromJson(JsonObject json) throws IOException {
        return (KeysetInfo.KeyInfo) KeysetInfo.KeyInfo.newBuilder().setStatus(getStatus(json.get("status").getAsString())).setKeyId(getKeyId(json.get("keyId"))).setOutputPrefixType(getOutputPrefixType(json.get("outputPrefixType").getAsString())).setTypeUrl(json.get("typeUrl").getAsString()).build();
    }

    private KeyData keyDataFromJson(JsonObject json) {
        validateKeyData(json);
        if (this.urlSafeBase64 == false) goto L5;
        byte[] r2 = Base64.urlSafeDecode(json.get("value").getAsString());
    L7:
        return (KeyData) KeyData.newBuilder().setTypeUrl(json.get("typeUrl").getAsString()).setValue(ByteString.copyFrom(r2)).setKeyMaterialType(getKeyMaterialType(json.get("keyMaterialType").getAsString())).build();
    L5:
        r2 = Base64.decode(json.get("value").getAsString());
        goto L7
    }

    private static KeyStatusType getStatus(String status) {
        status.hashCode();
        byte r1 = -1;
        switch(status.hashCode()) {
            case -891611359: goto L14;
            case 478389753: goto L10;
            case 1053567612: goto L6;
            default: goto L17;
        };
    L17:
        switch(r1) {
            case 0: goto L25;
            case 1: goto L23;
            case 2: goto L21;
            default: goto L19;
        };
    L19:
        throw new JsonParseException("unknown status: " + status);
    L21:
        return KeyStatusType.DISABLED;
    L23:
        return KeyStatusType.DESTROYED;
    L25:
        return KeyStatusType.ENABLED;
    L6:
        if (status.equals("DISABLED") == false) goto L17;
        r1 = 2;
        goto L17
    L10:
        if (status.equals("DESTROYED") == false) goto L17;
        r1 = 1;
        goto L17
    L14:
        if (status.equals("ENABLED") == false) goto L17;
        r1 = 0;
        goto L17
    }

    private static OutputPrefixType getOutputPrefixType(String type) {
        type.hashCode();
        byte r1 = -1;
        switch(type.hashCode()) {
            case -2053249079: goto L18;
            case 80904: goto L14;
            case 2575090: goto L10;
            case 1761684556: goto L6;
            default: goto L21;
        };
    L21:
        switch(r1) {
            case 0: goto L31;
            case 1: goto L29;
            case 2: goto L27;
            case 3: goto L25;
            default: goto L23;
        };
    L23:
        throw new JsonParseException("unknown output prefix type: " + type);
    L25:
        return OutputPrefixType.CRUNCHY;
    L27:
        return OutputPrefixType.TINK;
    L29:
        return OutputPrefixType.RAW;
    L31:
        return OutputPrefixType.LEGACY;
    L6:
        if (type.equals("CRUNCHY") == false) goto L21;
        r1 = 3;
        goto L21
    L10:
        if (type.equals("TINK") == false) goto L21;
        r1 = 2;
        goto L21
    L14:
        if (type.equals("RAW") == false) goto L21;
        r1 = 1;
        goto L21
    L18:
        if (type.equals("LEGACY") == false) goto L21;
        r1 = 0;
        goto L21
    }

    private static KeyData.KeyMaterialType getKeyMaterialType(String type) {
        type.hashCode();
        byte r1 = -1;
        switch(type.hashCode()) {
            case -1881281466: goto L18;
            case -1609477353: goto L14;
            case 249237018: goto L10;
            case 1534613202: goto L6;
            default: goto L21;
        };
    L21:
        switch(r1) {
            case 0: goto L31;
            case 1: goto L29;
            case 2: goto L27;
            case 3: goto L25;
            default: goto L23;
        };
    L23:
        throw new JsonParseException("unknown key material type: " + type);
    L25:
        return KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC;
    L27:
        return KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE;
    L29:
        return KeyData.KeyMaterialType.SYMMETRIC;
    L31:
        return KeyData.KeyMaterialType.REMOTE;
    L6:
        if (type.equals("ASYMMETRIC_PUBLIC") == false) goto L21;
        r1 = 3;
        goto L21
    L10:
        if (type.equals("ASYMMETRIC_PRIVATE") == false) goto L21;
        r1 = 2;
        goto L21
    L14:
        if (type.equals("SYMMETRIC") == false) goto L21;
        r1 = 1;
        goto L21
    L18:
        if (type.equals("REMOTE") == false) goto L21;
        r1 = 0;
        goto L21
    }

    private static void validateKeyset(JsonObject json) {
        if (json.has("key") == false) goto L8;
        if (json.getAsJsonArray("key").size() == 0) goto L8;
        return;
    L8:
        throw new JsonParseException("invalid keyset");
    }

    private static void validateEncryptedKeyset(JsonObject json) {
        if (json.has("encryptedKeyset") == false) goto L6;
        return;
    L6:
        throw new JsonParseException("invalid encrypted keyset");
    }

    private static void validateKey(JsonObject json) {
        if (json.has("keyData") == false) goto L12;
        if (json.has("status") == false) goto L12;
        if (json.has("keyId") == false) goto L12;
        if (json.has("outputPrefixType") == false) goto L12;
        return;
    L12:
        throw new JsonParseException("invalid key");
    }

    private static void validateKeyData(JsonObject json) {
        if (json.has("typeUrl") == false) goto L10;
        if (json.has("value") == false) goto L10;
        if (json.has("keyMaterialType") == false) goto L10;
        return;
    L10:
        throw new JsonParseException("invalid keyData");
    }
}
