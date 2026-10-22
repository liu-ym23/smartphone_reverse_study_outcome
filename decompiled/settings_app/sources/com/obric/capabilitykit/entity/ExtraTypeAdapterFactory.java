package com.obric.capabilitykit.entity;

import androidx.exifinterface.media.ExifInterface;
import com.android.vcard.VCardConstants;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.obric.capabilitykit.entity.app.ExtraEntity;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0002\n\u000bB\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\n\u0012\u0004\u0012\u0002H\u0005\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\tH\u0016¨\u0006\f"}, d2 = {"Lcom/obric/capabilitykit/entity/ExtraTypeAdapterFactory;", "Lcom/google/gson/TypeAdapterFactory;", "()V", "create", "Lcom/google/gson/TypeAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "gson", "Lcom/google/gson/Gson;", "type", "Lcom/google/gson/reflect/TypeToken;", "Companion", "ExtraEntityTypeAdapter", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ExtraTypeAdapterFactory implements TypeAdapterFactory {
    public static final a Companion = null;
    private static final String KEY = "key";
    private static final String KEY_DATA_TYPE = "data_type";
    private static final String VALUE = "value";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/capabilitykit/entity/ExtraTypeAdapterFactory$Companion;", "", "()V", "KEY", "", "KEY_DATA_TYPE", VCardConstants.PARAM_VALUE, "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0002\u0010\u0006J\u0015\u0010\t\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\fJ\u001d\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0012R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/capabilitykit/entity/ExtraTypeAdapterFactory$ExtraEntityTypeAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/google/gson/TypeAdapter;", "gson", "Lcom/google/gson/Gson;", "delegate", "(Lcom/google/gson/Gson;Lcom/google/gson/TypeAdapter;)V", "getDelegate", "()Lcom/google/gson/TypeAdapter;", "read", "in", "Lcom/google/gson/stream/JsonReader;", "(Lcom/google/gson/stream/JsonReader;)Ljava/lang/Object;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "value", "(Lcom/google/gson/stream/JsonWriter;Ljava/lang/Object;)V", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b<T> extends TypeAdapter<T> {
        private final Gson a;
        private final TypeAdapter<T> b;

        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/obric/capabilitykit/entity/ExtraTypeAdapterFactory$ExtraEntityTypeAdapter$read$listType$1", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/google/gson/JsonElement;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class a extends TypeToken<List<? extends JsonElement>> {
            public a() {
            }
        }

        public b(Gson r2, TypeAdapter<T> r3) {
            Intrinsics.checkNotNullParameter(r2, "gson");
            Intrinsics.checkNotNullParameter(r3, "delegate");
            this.a = r2;
            this.b = r3;
        }

        public final TypeAdapter<T> a() {
            return this.b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r3v7, types: [java.util.ArrayList, java.util.Collection] */
        @Override // com.google.gson.TypeAdapter
        public T read(JsonReader r9) {
            Intrinsics.checkNotNullParameter(r9, "in");
            JsonObject r10 = new JsonParser().parse(r9).getAsJsonObject();
            JsonElement r1 = r10.get("value");
            r10.add("value", null);
            T r11 = this.b.fromJsonTree(r10);
            if ((r11 instanceof ExtraEntity) == true) goto L5;
        L14:
            return r11;
        L5:
            if ((r1 instanceof JsonObject) == false) goto L14;
            JsonObject r2 = (JsonObject) r1;
            String r3 = r2.get("data_type").getAsString();
            JsonElement r4 = r2.get("value");
            ExtraEntity r5 = (ExtraEntity) r11;
            if (List.class.isAssignableFrom(Class.forName(r3)) == false) goto L12;
            Type r6 = new a().getType();
            List r7 = (List) this.a.fromJson(r4, r6);
            Intrinsics.checkNotNullExpressionValue(r7, "jsonList");
            Object r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
            Iterator<T> r12 = r7.iterator();
        L10:
            if (r12.hasNext() == false) goto L13;
            JsonElement r13 = (JsonElement) r12.next();
            String r14 = r13.getAsJsonObject().get("data_type").getAsString();
            r8.add(this.a.fromJson(r13.getAsJsonObject().get("value"), Class.forName(r14)));
        L13:
            r5.setValue(r8);
            goto L14
        L12:
            r8 = this.a.fromJson(r4, Class.forName(r3));
            goto L13
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter r10, T r11) {
            Intrinsics.checkNotNullParameter(r10, "out");
            JsonObject r0 = this.b.toJsonTree(r11).getAsJsonObject();
            if ((r11 instanceof ExtraEntity) == false) goto L21;
            ExtraEntity r12 = (ExtraEntity) r11;
            if (r12.getValue() == null) goto L21;
            JsonObject r1 = new JsonObject();
            Object r3 = r12.getValue();
            Intrinsics.checkNotNull(r3);
            r1.add("data_type", new JsonPrimitive(r3.getClass().getName()));
            if ((r12.getValue() instanceof List) == false) goto L19;
            JsonArray r2 = new JsonArray();
            Object r13 = r12.getValue();
            Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlin.collections.List<*>");
            Iterator<T> r14 = ((List) r13).iterator();
        L10:
            if (r14.hasNext() == false) goto L18;
            T r5 = r14.next();
            JsonObject r6 = new JsonObject();
            if (r5 == null) goto L16;
            Class<?> r8 = r5.getClass();
            if (r8 == null) goto L16;
            String r9 = r8.getName();
        L17:
            r6.add("data_type", new JsonPrimitive(r9));
            r6.add("value", this.a.toJsonTree(r5));
            r2.add(r6);
        L16:
            r9 = null;
            goto L17
        L18:
            r1.add("value", r2);
        L20:
            r0.add("value", r1);
            goto L21
        L19:
            r1.add("value", this.a.toJsonTree(r12.getValue()));
        L21:
            this.a.toJson(r0, r10);
        }
    }

    static {
        Companion = new a(null);
    }

    public ExtraTypeAdapterFactory() {
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson r3, TypeToken<T> r4) {
        Intrinsics.checkNotNullParameter(r3, "gson");
        Intrinsics.checkNotNullParameter(r4, "type");
        if (Intrinsics.areEqual(r4.getRawType(), ExtraEntity.class) == false) goto L5;
        TypeAdapter<T> r2 = r3.getDelegateAdapter(this, r4);
        Intrinsics.checkNotNullExpressionValue(r2, "delegate");
        return new b(r3, r2);
    L5:
        return null;
    }
}
