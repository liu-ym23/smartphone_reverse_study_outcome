package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public final class TreeTypeAdapter<T> extends TypeAdapter<T> {
    private final TreeTypeAdapter<T>.GsonContextImpl context;
    private TypeAdapter<T> delegate;
    private final JsonDeserializer<T> deserializer;
    final Gson gson;
    private final JsonSerializer<T> serializer;
    private final TypeAdapterFactory skipPast;
    private final TypeToken<T> typeToken;

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TreeTypeAdapter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public final class GsonContextImpl implements JsonSerializationContext, JsonDeserializationContext {
        final /* synthetic */ TreeTypeAdapter this$0;

        private GsonContextImpl(TreeTypeAdapter r1) {
            this.this$0 = r1;
        }

        @Override // com.google.gson.JsonDeserializationContext
        public <R> R deserialize(JsonElement r1, Type r2) {
            return (R) this.this$0.gson.fromJson(r1, r2);
        }

        @Override // com.google.gson.JsonSerializationContext
        public JsonElement serialize(Object r1) {
            return this.this$0.gson.toJsonTree(r1);
        }

        public /* synthetic */ GsonContextImpl(TreeTypeAdapter r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.google.gson.JsonSerializationContext
        public JsonElement serialize(Object r1, Type r2) {
            return this.this$0.gson.toJsonTree(r1, r2);
        }
    }

    public static final class SingleTypeFactory implements TypeAdapterFactory {
        private final JsonDeserializer<?> deserializer;
        private final TypeToken<?> exactType;
        private final Class<?> hierarchyType;
        private final boolean matchRawType;
        private final JsonSerializer<?> serializer;

        public SingleTypeFactory(Object r4, TypeToken<?> r5, boolean r6, Class<?> r7) {
            JsonDeserializer<?> r1 = null;
            if ((r4 instanceof JsonSerializer) == false) goto L5;
            JsonSerializer<?> r0 = (JsonSerializer) r4;
        L6:
            this.serializer = r0;
            if ((r4 instanceof JsonDeserializer) == false) goto L9;
            r1 = (JsonDeserializer) r4;
        L9:
            this.deserializer = r1;
            if (r0 != null) goto L14;
            if (r1 != null) goto L14;
            boolean r8 = false;
        L15:
            C$Gson$Preconditions.checkArgument(r8);
            this.exactType = r5;
            this.matchRawType = r6;
            this.hierarchyType = r7;
            return;
        L14:
            r8 = true;
            goto L15
        L5:
            r0 = null;
            goto L6
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson r8, TypeToken<T> r9) {
            TypeToken<?> r0 = this.exactType;
            if (r0 != null) goto L5;
            boolean r1 = this.hierarchyType.isAssignableFrom(r9.getRawType());
        L14:
            if (r1 == true) goto L18;
            return null;
        L18:
            return new TreeTypeAdapter(this.serializer, this.deserializer, r8, r9, this);
        L5:
            if (r0.equals(r9) == false) goto L7;
        L12:
            r1 = true;
            goto L14
        L7:
            if (this.matchRawType == true) goto L9;
        L11:
            r1 = false;
            goto L14
        L9:
            if (this.exactType.getType() != r9.getRawType()) goto L11;
            goto L11
        }
    }

    public TreeTypeAdapter(JsonSerializer<T> r3, JsonDeserializer<T> r4, Gson r5, TypeToken<T> r6, TypeAdapterFactory r7) {
        this.context = new GsonContextImpl(this, null);
        this.serializer = r3;
        this.deserializer = r4;
        this.gson = r5;
        this.typeToken = r6;
        this.skipPast = r7;
    }

    private TypeAdapter<T> delegate() {
        TypeAdapter<T> r0 = this.delegate;
        if (r0 != null) goto L7;
        TypeAdapter<T> r1 = this.gson.getDelegateAdapter(this.skipPast, this.typeToken);
        this.delegate = r1;
        return r1;
    L7:
        return r0;
    }

    public static TypeAdapterFactory newFactory(TypeToken<?> r3, Object r4) {
        return new SingleTypeFactory(r4, r3, false, null);
    }

    public static TypeAdapterFactory newFactoryWithMatchRawType(TypeToken<?> r3, Object r4) {
        if (r3.getType() != r3.getRawType()) goto L5;
        boolean r0 = true;
    L7:
        return new SingleTypeFactory(r4, r3, r0, null);
    L5:
        r0 = false;
        goto L7
    }

    public static TypeAdapterFactory newTypeHierarchyFactory(Class<?> r3, Object r4) {
        return new SingleTypeFactory(r4, null, false, r3);
    }

    @Override // com.google.gson.TypeAdapter
    public T read(JsonReader r3) {
        if (this.deserializer == null) goto L5;
        JsonElement r4 = Streams.parse(r3);
        if (r4.isJsonNull() == false) goto L11;
        return null;
    L11:
        return this.deserializer.deserialize(r4, this.typeToken.getType(), this.context);
    L5:
        return delegate().read(r3);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter r3, T r4) {
        JsonSerializer<T> r0 = this.serializer;
        if (r0 != null) goto L6;
        delegate().write(r3, r4);
        return;
    L6:
        if (r4 != null) goto L9;
        r3.nullValue();
        return;
    L9:
        Streams.write(r0.serialize(r4, this.typeToken.getType(), this.context), r3);
    }
}
