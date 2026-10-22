package com.google.gson;

import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.Streams;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.internal.bind.JsonTreeWriter;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.NumberTypeAdapter;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.internal.sql.SqlTypesSupport;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX INFO: loaded from: classes.dex */
public final class Gson {
    static final boolean DEFAULT_COMPLEX_MAP_KEYS = false;
    static final boolean DEFAULT_ESCAPE_HTML = true;
    static final boolean DEFAULT_JSON_NON_EXECUTABLE = false;
    static final boolean DEFAULT_LENIENT = false;
    static final boolean DEFAULT_PRETTY_PRINT = false;
    static final boolean DEFAULT_SERIALIZE_NULLS = false;
    static final boolean DEFAULT_SPECIALIZE_FLOAT_VALUES = false;
    private static final String JSON_NON_EXECUTABLE_PREFIX = ")]}'\n";
    private static final TypeToken<?> NULL_KEY_SURROGATE = null;
    final List<TypeAdapterFactory> builderFactories;
    final List<TypeAdapterFactory> builderHierarchyFactories;
    private final ThreadLocal<Map<TypeToken<?>, FutureTypeAdapter<?>>> calls;
    final boolean complexMapKeySerialization;
    private final ConstructorConstructor constructorConstructor;
    final String datePattern;
    final int dateStyle;
    final Excluder excluder;
    final List<TypeAdapterFactory> factories;
    final FieldNamingStrategy fieldNamingStrategy;
    final boolean generateNonExecutableJson;
    final boolean htmlSafe;
    final Map<Type, InstanceCreator<?>> instanceCreators;
    private final JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;
    final boolean lenient;
    final LongSerializationPolicy longSerializationPolicy;
    final ToNumberStrategy numberToNumberStrategy;
    final ToNumberStrategy objectToNumberStrategy;
    final boolean prettyPrinting;
    final boolean serializeNulls;
    final boolean serializeSpecialFloatingPointValues;
    final int timeStyle;
    private final Map<TypeToken<?>, TypeAdapter<?>> typeTokenCache;

    public static class FutureTypeAdapter<T> extends TypeAdapter<T> {
        private TypeAdapter<T> delegate;

        public FutureTypeAdapter() {
        }

        @Override // com.google.gson.TypeAdapter
        public T read(JsonReader r1) {
            TypeAdapter<T> r0 = this.delegate;
            if (r0 == null) goto L7;
            return r0.read(r1);
        L7:
            throw new IllegalStateException();
        }

        public void setDelegate(TypeAdapter<T> r2) {
            if (this.delegate != null) goto L7;
            this.delegate = r2;
            return;
        L7:
            throw new AssertionError();
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter r1, T r2) {
            TypeAdapter<T> r0 = this.delegate;
            if (r0 == null) goto L7;
            r0.write(r1, r2);
            return;
        L7:
            throw new IllegalStateException();
        }
    }

    static {
        NULL_KEY_SURROGATE = TypeToken.get(Object.class);
    }

    public Gson() {
        this(Excluder.DEFAULT, FieldNamingPolicy.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, false, LongSerializationPolicy.DEFAULT, null, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), ToNumberPolicy.DOUBLE, ToNumberPolicy.LAZILY_PARSED_NUMBER);
    }

    private static void assertFullConsumption(Object r0, JsonReader r1) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            if (r0 == 0) goto L23
            com.google.gson.stream.JsonToken r0 = r1.peek()     // Catch: java.io.IOException -> L13 com.google.gson.stream.MalformedJsonException -> L15
            com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.END_DOCUMENT     // Catch: java.io.IOException -> L13 com.google.gson.stream.MalformedJsonException -> L15
            if (r0 != r1) goto Lb
            goto L23
        Lb:
            com.google.gson.JsonIOException r0 = new com.google.gson.JsonIOException     // Catch: java.io.IOException -> L13 com.google.gson.stream.MalformedJsonException -> L15
            java.lang.String r1 = "JSON document was not fully consumed."
            r0.<init>(r1)     // Catch: java.io.IOException -> L13 com.google.gson.stream.MalformedJsonException -> L15
            throw r0     // Catch: java.io.IOException -> L13 com.google.gson.stream.MalformedJsonException -> L15
        L13:
            r0 = move-exception
            goto L17
        L15:
            r0 = move-exception
            goto L1d
        L17:
            com.google.gson.JsonIOException r1 = new com.google.gson.JsonIOException
            r1.<init>(r0)
            throw r1
        L1d:
            com.google.gson.JsonSyntaxException r1 = new com.google.gson.JsonSyntaxException
            r1.<init>(r0)
            throw r1
        L23:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.Gson.assertFullConsumption(java.lang.Object, com.google.gson.stream.JsonReader):void");
    }

    private static TypeAdapter<AtomicLong> atomicLongAdapter(final TypeAdapter<Number> r1) {
        return new AnonymousClass4(r1).nullSafe();
    }

    private static TypeAdapter<AtomicLongArray> atomicLongArrayAdapter(final TypeAdapter<Number> r1) {
        return new AnonymousClass5(r1).nullSafe();
    }

    public static void checkValidFloatingPoint(double r2) {
        if (Double.isNaN(r2) == true) goto L8;
        if (Double.isInfinite(r2) == true) goto L8;
        return;
    L8:
        throw new IllegalArgumentException(r2 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
    }

    private TypeAdapter<Number> doubleAdapter(boolean r1) {
        if (r1 == false) goto L6;
        return TypeAdapters.DOUBLE;
    L6:
        return new AnonymousClass1(this);
    }

    private TypeAdapter<Number> floatAdapter(boolean r1) {
        if (r1 == false) goto L6;
        return TypeAdapters.FLOAT;
    L6:
        return new AnonymousClass2(this);
    }

    private static TypeAdapter<Number> longAdapter(LongSerializationPolicy r1) {
        if (r1 != LongSerializationPolicy.DEFAULT) goto L7;
        return TypeAdapters.LONG;
    L7:
        return new AnonymousClass3();
    }

    @Deprecated
    public Excluder excluder() {
        return this.excluder;
    }

    public FieldNamingStrategy fieldNamingStrategy() {
        return this.fieldNamingStrategy;
    }

    public <T> T fromJson(String r1, Class<T> r2) {
        Object r0 = fromJson(r1, r2);
        return (T) Primitives.wrap(r2).cast(r0);
    }

    public <T> TypeAdapter<T> getAdapter(TypeToken<T> r6) {
        Map<TypeToken<?>, TypeAdapter<?>> r0 = this.typeTokenCache;
        if (r6 != null) goto L5;
        Object r1 = NULL_KEY_SURROGATE;
    L6:
        TypeAdapter<T> r2 = (TypeAdapter) r0.get(r1);
        if (r2 == null) goto L9;
        return r2;
    L9:
        Map<TypeToken<?>, FutureTypeAdapter<?>> r3 = this.calls.get();
        if (r3 != null) goto L12;
        r3 = new HashMap();
        this.calls.set(r3);
        boolean r4 = true;
    L13:
        FutureTypeAdapter<?> r5 = r3.get(r6);
        if (r5 == null) goto L34;
        return r5;
    L34:
        FutureTypeAdapter<?> r7 = new FutureTypeAdapter();     // Catch: Throwable -> L26
        r3.put(r6, r7);     // Catch: Throwable -> L26
        Iterator<TypeAdapterFactory> r8 = this.factories.iterator();     // Catch: Throwable -> L26
    L18:
        if (r8.hasNext() == false) goto L29;
        TypeAdapter<T> r9 = r8.next().create(this, r6);     // Catch: Throwable -> L26
        if (r9 == null) goto L18;
        r7.setDelegate(r9);     // Catch: Throwable -> L26
        this.typeTokenCache.put(r6, r9);     // Catch: Throwable -> L26
        r3.remove(r6);
        if (r4 == false) goto L25;
        this.calls.remove();
    L25:
        return r9;
    L29:
        throw new IllegalArgumentException("GSON (2.8.9) cannot handle " + r6);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        r3.remove(r6);
        if (r4 == false) goto L33;
        this.calls.remove();
    L33:
        throw th;
    L12:
        r4 = false;
        goto L13
    L5:
        r1 = r6;
        goto L6
    }

    public <T> TypeAdapter<T> getDelegateAdapter(TypeAdapterFactory r4, TypeToken<T> r5) {
        if (this.factories.contains(r4) == true) goto L5;
        r4 = this.jsonAdapterFactory;
    L5:
        Iterator<TypeAdapterFactory> r0 = this.factories.iterator();
        boolean r1 = false;
    L7:
        if (r0.hasNext() == false) goto L16;
        TypeAdapterFactory r2 = r0.next();
        if (r1 == false) goto L10;
        TypeAdapter<T> r3 = r2.create(this, r5);
        if (r3 == null) goto L7;
        return r3;
    L10:
        if (r2 != r4) goto L7;
        r1 = true;
        goto L7
    L16:
        throw new IllegalArgumentException("GSON cannot serialize " + r5);
    }

    public boolean htmlSafe() {
        return this.htmlSafe;
    }

    public GsonBuilder newBuilder() {
        return new GsonBuilder(this);
    }

    public JsonReader newJsonReader(Reader r2) {
        JsonReader r0 = new JsonReader(r2);
        r0.setLenient(this.lenient);
        return r0;
    }

    public JsonWriter newJsonWriter(Writer r2) {
        if (this.generateNonExecutableJson == false) goto L5;
        r2.write(JSON_NON_EXECUTABLE_PREFIX);
    L5:
        JsonWriter r0 = new JsonWriter(r2);
        if (this.prettyPrinting == false) goto L8;
        r0.setIndent("  ");
    L8:
        r0.setSerializeNulls(this.serializeNulls);
        return r0;
    }

    public boolean serializeNulls() {
        return this.serializeNulls;
    }

    public String toJson(Object r2) {
        if (r2 != null) goto L6;
        return toJson(JsonNull.INSTANCE);
    L6:
        return toJson(r2, r2.getClass());
    }

    public JsonElement toJsonTree(Object r2) {
        if (r2 != null) goto L6;
        return JsonNull.INSTANCE;
    L6:
        return toJsonTree(r2, r2.getClass());
    }

    public String toString() {
        return "{serializeNulls:" + this.serializeNulls + ",factories:" + this.factories + ",instanceCreators:" + this.constructorConstructor + "}";
    }

    public <T> T fromJson(String r2, Type r3) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return (T) fromJson(new StringReader(r2), r3);
    }

    public String toJson(Object r2, Type r3) {
        StringWriter r0 = new StringWriter();
        toJson(r2, r3, r0);
        return r0.toString();
    }

    public JsonElement toJsonTree(Object r2, Type r3) {
        JsonTreeWriter r0 = new JsonTreeWriter();
        toJson(r2, r3, r0);
        return r0.get();
    }

    public <T> T fromJson(Reader r1, Class<T> r2) {
        JsonReader r3 = newJsonReader(r1);
        Object r0 = fromJson(r3, r2);
        assertFullConsumption(r0, r3);
        return (T) Primitives.wrap(r2).cast(r0);
    }

    public Gson(Excluder r13, FieldNamingStrategy r14, Map<Type, InstanceCreator<?>> r15, boolean r16, boolean r17, boolean r18, boolean r19, boolean r20, boolean r21, boolean r22, LongSerializationPolicy r23, String r24, int r25, int r26, List<TypeAdapterFactory> r27, List<TypeAdapterFactory> r28, List<TypeAdapterFactory> r29, ToNumberStrategy r30, ToNumberStrategy r31) {
        this.calls = new ThreadLocal();
        this.typeTokenCache = new ConcurrentHashMap();
        this.excluder = r13;
        this.fieldNamingStrategy = r14;
        this.instanceCreators = r15;
        ConstructorConstructor r6 = new ConstructorConstructor(r15);
        this.constructorConstructor = r6;
        this.serializeNulls = r16;
        this.complexMapKeySerialization = r17;
        this.generateNonExecutableJson = r18;
        this.htmlSafe = r19;
        this.prettyPrinting = r20;
        this.lenient = r21;
        this.serializeSpecialFloatingPointValues = r22;
        this.longSerializationPolicy = r23;
        this.datePattern = r24;
        this.dateStyle = r25;
        this.timeStyle = r26;
        this.builderFactories = r27;
        this.builderHierarchyFactories = r28;
        this.objectToNumberStrategy = r30;
        this.numberToNumberStrategy = r31;
        ArrayList r9 = new ArrayList();
        r9.add(TypeAdapters.JSON_ELEMENT_FACTORY);
        r9.add(ObjectTypeAdapter.getFactory(r30));
        r9.add(r13);
        r9.addAll(r29);
        r9.add(TypeAdapters.STRING_FACTORY);
        r9.add(TypeAdapters.INTEGER_FACTORY);
        r9.add(TypeAdapters.BOOLEAN_FACTORY);
        r9.add(TypeAdapters.BYTE_FACTORY);
        r9.add(TypeAdapters.SHORT_FACTORY);
        TypeAdapter<Number> r3 = longAdapter(r23);
        r9.add(TypeAdapters.newFactory(Long.TYPE, Long.class, r3));
        r9.add(TypeAdapters.newFactory(Double.TYPE, Double.class, doubleAdapter(r22)));
        r9.add(TypeAdapters.newFactory(Float.TYPE, Float.class, floatAdapter(r22)));
        r9.add(NumberTypeAdapter.getFactory(r31));
        r9.add(TypeAdapters.ATOMIC_INTEGER_FACTORY);
        r9.add(TypeAdapters.ATOMIC_BOOLEAN_FACTORY);
        r9.add(TypeAdapters.newFactory(AtomicLong.class, atomicLongAdapter(r3)));
        r9.add(TypeAdapters.newFactory(AtomicLongArray.class, atomicLongArrayAdapter(r3)));
        r9.add(TypeAdapters.ATOMIC_INTEGER_ARRAY_FACTORY);
        r9.add(TypeAdapters.CHARACTER_FACTORY);
        r9.add(TypeAdapters.STRING_BUILDER_FACTORY);
        r9.add(TypeAdapters.STRING_BUFFER_FACTORY);
        r9.add(TypeAdapters.newFactory(BigDecimal.class, TypeAdapters.BIG_DECIMAL));
        r9.add(TypeAdapters.newFactory(BigInteger.class, TypeAdapters.BIG_INTEGER));
        r9.add(TypeAdapters.URL_FACTORY);
        r9.add(TypeAdapters.URI_FACTORY);
        r9.add(TypeAdapters.UUID_FACTORY);
        r9.add(TypeAdapters.CURRENCY_FACTORY);
        r9.add(TypeAdapters.LOCALE_FACTORY);
        r9.add(TypeAdapters.INET_ADDRESS_FACTORY);
        r9.add(TypeAdapters.BIT_SET_FACTORY);
        r9.add(DateTypeAdapter.FACTORY);
        r9.add(TypeAdapters.CALENDAR_FACTORY);
        if (SqlTypesSupport.SUPPORTS_SQL_TYPES == false) goto L5;
        r9.add(SqlTypesSupport.TIME_FACTORY);
        r9.add(SqlTypesSupport.DATE_FACTORY);
        r9.add(SqlTypesSupport.TIMESTAMP_FACTORY);
    L5:
        r9.add(ArrayTypeAdapter.FACTORY);
        r9.add(TypeAdapters.CLASS_FACTORY);
        r9.add(new CollectionTypeAdapterFactory(r6));
        r9.add(new MapTypeAdapterFactory(r6, r17));
        JsonAdapterAnnotationTypeAdapterFactory r4 = new JsonAdapterAnnotationTypeAdapterFactory(r6);
        this.jsonAdapterFactory = r4;
        r9.add(r4);
        r9.add(TypeAdapters.ENUM_FACTORY);
        r9.add(new ReflectiveTypeAdapterFactory(r6, r14, r13, r4));
        this.factories = Collections.unmodifiableList(r9);
    }

    public void toJson(Object r2, Appendable r3) {
        if (r2 == null) goto L4;
        toJson(r2, r2.getClass(), r3);
        return;
    L4:
        toJson(JsonNull.INSTANCE, r3);
    }

    public void toJson(Object r1, Type r2, Appendable r3) {
        toJson(r1, r2, newJsonWriter(Streams.writerForAppendable(r3)));     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        throw new JsonIOException(e);
    }

    public <T> T fromJson(Reader r1, Type r2) {
        JsonReader r3 = newJsonReader(r1);
        T r0 = (T) fromJson(r3, r2);
        assertFullConsumption(r0, r3);
        return r0;
    }

    public void toJson(Object r5, Type r6, JsonWriter r7) {
        TypeAdapter r8 = getAdapter(TypeToken.get(r6));
        boolean r1 = r7.isLenient();
        r7.setLenient(true);
        boolean r2 = r7.isHtmlSafe();
        r7.setHtmlSafe(this.htmlSafe);
        boolean r3 = r7.getSerializeNulls();
        r7.setSerializeNulls(this.serializeNulls);
        r8.write(r7, r5);     // Catch: Throwable -> L6 AssertionError -> L8 IOException -> L11
        r7.setLenient(r1);
        r7.setHtmlSafe(r2);
        r7.setSerializeNulls(r3);
        return;
    L6:
        th = move-exception;
        r7.setLenient(r1);
        r7.setHtmlSafe(r2);
        r7.setSerializeNulls(r3);
        throw th;
    L8:
        e = move-exception;
        AssertionError r9 = new AssertionError("AssertionError (GSON 2.8.9): " + e.getMessage());     // Catch: Throwable -> L6
        r9.initCause(e);     // Catch: Throwable -> L6
        throw r9;     // Catch: Throwable -> L6
    L11:
        e = move-exception;
        throw new JsonIOException(e);     // Catch: Throwable -> L6
    }

    public <T> T fromJson(JsonReader r4, Type r5) {
        boolean r1 = r4.isLenient();
        boolean r2 = true;
        r4.setLenient(true);
        r4.peek();     // Catch: Throwable -> L6 AssertionError -> L8 IOException -> L10 IllegalStateException -> L12 EOFException -> L14
        r2 = false;
        T r3 = getAdapter(TypeToken.get(r5)).read(r4);     // Catch: Throwable -> L6 AssertionError -> L8 IOException -> L10 IllegalStateException -> L12 EOFException -> L14
        r4.setLenient(r1);
        return r3;
    L6:
        th = move-exception;
        r4.setLenient(r1);
        throw th;
    L10:
        e = move-exception;
        throw new JsonSyntaxException(e);     // Catch: Throwable -> L6
    L12:
        e = move-exception;
        throw new JsonSyntaxException(e);     // Catch: Throwable -> L6
    L14:
        e = move-exception;
        if (r2 == false) goto L26;
        r4.setLenient(r1);
        return null;
    L26:
        throw new JsonSyntaxException(e);     // Catch: Throwable -> L6
    L8:
        e = move-exception;
        AssertionError r6 = new AssertionError("AssertionError (GSON 2.8.9): " + e.getMessage());     // Catch: Throwable -> L6
        r6.initCause(e);     // Catch: Throwable -> L6
        throw r6;     // Catch: Throwable -> L6
    }

    public <T> TypeAdapter<T> getAdapter(Class<T> r1) {
        return getAdapter(TypeToken.get(r1));
    }

    public <T> T fromJson(JsonElement r1, Class<T> r2) {
        Object r0 = fromJson(r1, r2);
        return (T) Primitives.wrap(r2).cast(r0);
    }

    public String toJson(JsonElement r2) {
        StringWriter r0 = new StringWriter();
        toJson(r2, r0);
        return r0.toString();
    }

    public <T> T fromJson(JsonElement r2, Type r3) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return (T) fromJson(new JsonTreeReader(r2), r3);
    }

    public void toJson(JsonElement r1, Appendable r2) {
        toJson(r1, newJsonWriter(Streams.writerForAppendable(r2)));     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        throw new JsonIOException(e);
    }

    public void toJson(JsonElement r6, JsonWriter r7) {
        boolean r1 = r7.isLenient();
        r7.setLenient(true);
        boolean r2 = r7.isHtmlSafe();
        r7.setHtmlSafe(this.htmlSafe);
        boolean r3 = r7.getSerializeNulls();
        r7.setSerializeNulls(this.serializeNulls);
        Streams.write(r6, r7);     // Catch: Throwable -> L6 AssertionError -> L8 IOException -> L11
        r7.setLenient(r1);
        r7.setHtmlSafe(r2);
        r7.setSerializeNulls(r3);
        return;
    L6:
        th = move-exception;
        r7.setLenient(r1);
        r7.setHtmlSafe(r2);
        r7.setSerializeNulls(r3);
        throw th;
    L11:
        e = move-exception;
        throw new JsonIOException(e);     // Catch: Throwable -> L6
    L8:
        e = move-exception;
        AssertionError r8 = new AssertionError("AssertionError (GSON 2.8.9): " + e.getMessage());     // Catch: Throwable -> L6
        r8.initCause(e);     // Catch: Throwable -> L6
        throw r8;     // Catch: Throwable -> L6
    }
}
