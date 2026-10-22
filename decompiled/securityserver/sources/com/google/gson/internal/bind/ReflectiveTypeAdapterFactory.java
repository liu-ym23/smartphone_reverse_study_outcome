package com.google.gson.internal.bind;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.reflect.ReflectionAccessor;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class ReflectiveTypeAdapterFactory implements TypeAdapterFactory {
    private final ReflectionAccessor accessor;
    private final ConstructorConstructor constructorConstructor;
    private final Excluder excluder;
    private final FieldNamingStrategy fieldNamingPolicy;
    private final JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;

    public static final class Adapter<T> extends TypeAdapter<T> {
        private final Map<String, BoundField> boundFields;
        private final ObjectConstructor<T> constructor;

        public Adapter(ObjectConstructor<T> r1, Map<String, BoundField> r2) {
            this.constructor = r1;
            this.boundFields = r2;
        }

        @Override // com.google.gson.TypeAdapter
        public T read(JsonReader r4) {
            if (r4.peek() != JsonToken.NULL) goto L6;
            r4.nextNull();
            return null;
        L6:
            T r0 = this.constructor.construct();
            r4.beginObject();     // Catch: IllegalAccessException -> L16 IllegalStateException -> L18
        L8:
            if (r4.hasNext() == false) goto L22;
            String r1 = r4.nextName();     // Catch: IllegalAccessException -> L16 IllegalStateException -> L18
            BoundField r2 = this.boundFields.get(r1);     // Catch: IllegalAccessException -> L16 IllegalStateException -> L18
            if (r2 == null) goto L20;
            if (r2.deserialized == false) goto L20;
            r2.read(r4, r0);     // Catch: IllegalAccessException -> L16 IllegalStateException -> L18
        L20:
            r4.skipValue();     // Catch: IllegalAccessException -> L16 IllegalStateException -> L18
            goto L8
        L22:
            r4.endObject();
            return r0;
        L16:
            e = move-exception;
            throw new AssertionError(e);
        L18:
            e = move-exception;
            throw new JsonSyntaxException(e);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter r3, T r4) {
            if (r4 != null) goto L5;
            r3.nullValue();
            return;
        L5:
            r3.beginObject();
            Iterator<BoundField> r2 = this.boundFields.values().iterator();     // Catch: IllegalAccessException -> L13
        L8:
            if (r2.hasNext() == false) goto L15;
            BoundField r0 = r2.next();     // Catch: IllegalAccessException -> L13
            if (r0.writeField(r4) == false) goto L8;
            r3.name(r0.name);     // Catch: IllegalAccessException -> L13
            r0.write(r3, r4);     // Catch: IllegalAccessException -> L13
            goto L8
        L15:
            r3.endObject();
            return;
        L13:
            e = move-exception;
            throw new AssertionError(e);
        }
    }

    public static abstract class BoundField {
        final boolean deserialized;
        final String name;
        final boolean serialized;

        public BoundField(String r1, boolean r2, boolean r3) {
            this.name = r1;
            this.serialized = r2;
            this.deserialized = r3;
        }

        public abstract void read(JsonReader r1, Object r2);

        public abstract void write(JsonWriter r1, Object r2);

        public abstract boolean writeField(Object r1);
    }

    public ReflectiveTypeAdapterFactory(ConstructorConstructor r2, FieldNamingStrategy r3, Excluder r4, JsonAdapterAnnotationTypeAdapterFactory r5) {
        this.accessor = ReflectionAccessor.getInstance();
        this.constructorConstructor = r2;
        this.fieldNamingPolicy = r3;
        this.excluder = r4;
        this.jsonAdapterFactory = r5;
    }

    private BoundField createBoundField(final Gson r13, final Field r14, final String r15, final TypeToken<?> r16, final boolean r17, final boolean r18) {
        final boolean r10 = Primitives.isPrimitive(r16.getRawType());
        JsonAdapter r0 = (JsonAdapter) r14.getAnnotation(JsonAdapter.class);
        if (r0 == null) goto L5;
        TypeAdapter<?> r1 = this.jsonAdapterFactory.getTypeAdapter(this.constructorConstructor, r13, r16, r0);
    L6:
        if (r1 == null) goto L9;
        boolean r2 = true;
    L8:
        final boolean r6 = r2;
        if (r1 != null) goto L12;
        r1 = r13.getAdapter(r16);
    L12:
        final TypeAdapter<?> r7 = r1;
        return new AnonymousClass1(this, r15, r17, r18, r14, r6, r7, r13, r16, r10);
    L9:
        r2 = false;
        goto L8
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r20v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    private Map<String, BoundField> getBoundFields(Gson r24, TypeToken<?> r25, Class<?> r26) {
        LinkedHashMap r8 = new LinkedHashMap();
        if (r26.isInterface() == false) goto L5;
        return r8;
    L5:
        Type r9 = r25.getType();
        TypeToken<?> r10 = r25;
        Class<?> r11 = r26;
    L7:
        if (r11 == Object.class) goto L31;
        Field[] r12 = r11.getDeclaredFields();
        int r13 = r12.length;
        boolean r14 = false;
        int r15 = 0;
    L9:
        if (r15 >= r13) goto L30;
        Field r6 = r12[r15];
        boolean r0 = excludeField(r6, true);
        boolean r16 = excludeField(r6, r14);
        if (r0 == true) goto L14;
        if (r16 == true) goto L14;
    L27:
        r15 = r15 + 1;
        r14 = false;
    L14:
        this.accessor.makeAccessible(r6);
        Type r17 = C$Gson$Types.resolve(r10.getType(), r11, r6.getGenericType());
        List<String> r5 = getFieldNames(r6);
        int r4 = r5.size();
        BoundField r3 = null;
        ?? r2 = r14;
    L15:
        if (r2 >= r4) goto L25;
        String r1 = r5.get(r2);
        if (r2 == 0) goto L19;
        boolean r18 = r14;
    L20:
        ?? r20 = r2;
        BoundField r19 = r3;
        int r21 = r4;
        List<String> r110 = r5;
        Field r22 = r6;
        BoundField r7 = (BoundField) r8.put(r1, createBoundField(r24, r6, r1, TypeToken.get(r17), r18, r16));
        if (r19 != null) goto L23;
        r3 = r7;
    L24:
        r0 = r18;
        r5 = r110;
        r4 = r21;
        r6 = r22;
        r14 = false;
        r2 = (r20 == true ? 1 : 0) + 1;
        goto L15
    L23:
        r3 = r19;
        goto L24
    L19:
        r18 = r0;
        goto L20
    L25:
        BoundField r111 = r3;
        if (r111 == null) goto L27;
        throw new IllegalArgumentException(r9 + " declares multiple JSON fields named " + r111.name);
    L30:
        r10 = TypeToken.get(C$Gson$Types.resolve(r10.getType(), r11, r11.getGenericSuperclass()));
        r11 = r10.getRawType();
        goto L7
    L31:
        return r8;
    }

    private List<String> getFieldNames(Field r4) {
        SerializedName r0 = (SerializedName) r4.getAnnotation(SerializedName.class);
        if (r0 == null) goto L5;
        String r3 = r0.value();
        String[] r5 = r0.alternate();
        if (r5.length == 0) goto L9;
        ArrayList r1 = new ArrayList(r5.length + 1);
        r1.add(r3);
        int r6 = r5.length;
        int r2 = 0;
    L11:
        if (r2 >= r6) goto L13;
        r1.add(r5[r2]);
        r2 = r2 + 1;
        goto L11
    L13:
        return r1;
    L9:
        return Collections.singletonList(r3);
    L5:
        return Collections.singletonList(this.fieldNamingPolicy.translateName(r4));
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson r4, TypeToken<T> r5) {
        Class<? super T> r0 = r5.getRawType();
        if (Object.class.isAssignableFrom(r0) == true) goto L7;
        return null;
    L7:
        return new Adapter(this.constructorConstructor.get(r5), getBoundFields(r4, r5, r0));
    }

    public boolean excludeField(Field r1, boolean r2) {
        return excludeField(r1, r2, this.excluder);
    }

    public static boolean excludeField(Field r1, boolean r2, Excluder r3) {
        if (r3.excludeClass(r1.getType(), r2) == false) goto L5;
    L7:
        return false;
    L5:
        if (r3.excludeField(r1, r2) == true) goto L7;
        return true;
    }
}
