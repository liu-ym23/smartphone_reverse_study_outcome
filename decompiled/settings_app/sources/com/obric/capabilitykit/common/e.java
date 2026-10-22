package com.obric.capabilitykit.common;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.EntityClassData;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.oui.material.MaterialConfigBuilder;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/obric/capabilitykit/entity/AppEntityDeserializerTypeAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "()V", "deserialize", MaterialConfigBuilder.SERIALIZATION_FORMAT_JSON, "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class e implements JsonDeserializer<AppEntity> {
    public e() {
    }

    public AppEntity a(JsonElement r1, Type r2, JsonDeserializationContext r3) {
        Integer r0 = null;
        if (r1 == null) goto L5;
        JsonObject r4 = r1.getAsJsonObject();
    L6:
        if (r4 == null) goto L10;
        JsonElement r5 = r4.get("type");
        if (r5 == null) goto L10;
        r0 = Integer.valueOf(r5.getAsInt());
    L10:
        EntityClassData<? extends AppEntity> r6 = EntityType.INSTANCE.getClassMap().get(r0);
        if (r6 == null) goto L17;
        GenericDeclaration r7 = r6.getClazz();
        if (r7 == null) goto L17;
        Object r8 = EntityExtKt.getInnerEntityGson().fromJson(r1, r7);
        Intrinsics.checkNotNullExpressionValue(r8, "innerEntityGson.fromJson(json, targetClass)");
        return (AppEntity) r8;
    L17:
        throw new IllegalArgumentException("Unknown entity type: " + r0);
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.google.gson.JsonDeserializer
    public /* bridge */ /* synthetic */ AppEntity deserialize(JsonElement r1, Type r2, JsonDeserializationContext r3) {
        return a(r1, r2, r3);
    }
}
