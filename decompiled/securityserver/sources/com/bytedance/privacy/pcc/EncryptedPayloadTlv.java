package com.bytedance.privacy.pcc;

import android.util.Base64;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public class EncryptedPayloadTlv {

    /* JADX INFO: renamed from: com.bytedance.privacy.pcc.EncryptedPayloadTlv$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class BizAttribute {
    }

    public static final class ByteArrayBase64Adapter implements JsonSerializer<byte[]>, JsonDeserializer<byte[]> {
        @Override // com.google.gson.JsonDeserializer
        public final byte[] deserialize(JsonElement r1, Type r2, JsonDeserializationContext r3) {
            return Base64.decode(r1.getAsString(), 0);
        }

        @Override // com.google.gson.JsonSerializer
        public final JsonElement serialize(byte[] r1, Type r2, JsonSerializationContext r3) {
            return new JsonPrimitive(Base64.encodeToString(r1, 2));
        }
    }

    public static class ContentInfoMeta {
    }

    public static class KeyEnvelope {
    }

    public static class KeyEnvelopePayload {
    }

    public static class MetaInfo {
    }

    public static class OtherKeyAttribute {
    }

    public static class SignContentInfo {
    }

    public static final class TlvReader {
    }

    public static final class TlvWriter {
    }

    static {
        new GsonBuilder().registerTypeHierarchyAdapter(byte[].class, new ByteArrayBase64Adapter()).setPrettyPrinting().create();
    }
}
