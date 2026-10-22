package com.google.gson;

import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.DefaultDateTypeAdapter;
import com.google.gson.internal.bind.TreeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.internal.sql.SqlTypesSupport;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public final class GsonBuilder {
    private boolean complexMapKeySerialization;
    private String datePattern;
    private int dateStyle;
    private boolean escapeHtmlChars;
    private Excluder excluder;
    private final List<TypeAdapterFactory> factories;
    private FieldNamingStrategy fieldNamingPolicy;
    private boolean generateNonExecutableJson;
    private final List<TypeAdapterFactory> hierarchyFactories;
    private final Map<Type, InstanceCreator<?>> instanceCreators;
    private boolean lenient;
    private LongSerializationPolicy longSerializationPolicy;
    private ToNumberStrategy numberToNumberStrategy;
    private ToNumberStrategy objectToNumberStrategy;
    private boolean prettyPrinting;
    private final LinkedList<ReflectionAccessFilter> reflectionFilters;
    private boolean serializeNulls;
    private boolean serializeSpecialFloatingPointValues;
    private int timeStyle;
    private boolean useJdkUnsafe;

    public GsonBuilder() {
        this.excluder = Excluder.DEFAULT;
        this.longSerializationPolicy = LongSerializationPolicy.DEFAULT;
        this.fieldNamingPolicy = FieldNamingPolicy.IDENTITY;
        this.instanceCreators = new HashMap();
        this.factories = new ArrayList();
        this.hierarchyFactories = new ArrayList();
        this.serializeNulls = false;
        this.datePattern = Gson.DEFAULT_DATE_PATTERN;
        this.dateStyle = 2;
        this.timeStyle = 2;
        this.complexMapKeySerialization = false;
        this.serializeSpecialFloatingPointValues = false;
        this.escapeHtmlChars = true;
        this.prettyPrinting = false;
        this.generateNonExecutableJson = false;
        this.lenient = false;
        this.useJdkUnsafe = true;
        this.objectToNumberStrategy = Gson.DEFAULT_OBJECT_TO_NUMBER_STRATEGY;
        this.numberToNumberStrategy = Gson.DEFAULT_NUMBER_TO_NUMBER_STRATEGY;
        this.reflectionFilters = new LinkedList();
    }

    GsonBuilder(Gson r6) {
        this.excluder = Excluder.DEFAULT;
        this.longSerializationPolicy = LongSerializationPolicy.DEFAULT;
        this.fieldNamingPolicy = FieldNamingPolicy.IDENTITY;
        HashMap r0 = new HashMap();
        this.instanceCreators = r0;
        ArrayList r1 = new ArrayList();
        this.factories = r1;
        ArrayList r2 = new ArrayList();
        this.hierarchyFactories = r2;
        this.serializeNulls = false;
        this.datePattern = Gson.DEFAULT_DATE_PATTERN;
        this.dateStyle = 2;
        this.timeStyle = 2;
        this.complexMapKeySerialization = false;
        this.serializeSpecialFloatingPointValues = false;
        this.escapeHtmlChars = true;
        this.prettyPrinting = false;
        this.generateNonExecutableJson = false;
        this.lenient = false;
        this.useJdkUnsafe = true;
        this.objectToNumberStrategy = Gson.DEFAULT_OBJECT_TO_NUMBER_STRATEGY;
        this.numberToNumberStrategy = Gson.DEFAULT_NUMBER_TO_NUMBER_STRATEGY;
        LinkedList<ReflectionAccessFilter> r3 = new LinkedList();
        this.reflectionFilters = r3;
        this.excluder = r6.excluder;
        this.fieldNamingPolicy = r6.fieldNamingStrategy;
        r0.putAll(r6.instanceCreators);
        this.serializeNulls = r6.serializeNulls;
        this.complexMapKeySerialization = r6.complexMapKeySerialization;
        this.generateNonExecutableJson = r6.generateNonExecutableJson;
        this.escapeHtmlChars = r6.htmlSafe;
        this.prettyPrinting = r6.prettyPrinting;
        this.lenient = r6.lenient;
        this.serializeSpecialFloatingPointValues = r6.serializeSpecialFloatingPointValues;
        this.longSerializationPolicy = r6.longSerializationPolicy;
        this.datePattern = r6.datePattern;
        this.dateStyle = r6.dateStyle;
        this.timeStyle = r6.timeStyle;
        r1.addAll(r6.builderFactories);
        r2.addAll(r6.builderHierarchyFactories);
        this.useJdkUnsafe = r6.useJdkUnsafe;
        this.objectToNumberStrategy = r6.objectToNumberStrategy;
        this.numberToNumberStrategy = r6.numberToNumberStrategy;
        r3.addAll(r6.reflectionFilters);
    }

    public GsonBuilder setVersion(double r3) {
        if (Double.isNaN(r3) == true) goto L9;
        if (r3 < 0.0d) goto L9;
        this.excluder = this.excluder.withVersion(r3);
        return this;
    L9:
        throw new IllegalArgumentException("Invalid version: " + r3);
    }

    public GsonBuilder excludeFieldsWithModifiers(int... r2) {
        Objects.requireNonNull(r2);
        this.excluder = this.excluder.withModifiers(r2);
        return this;
    }

    public GsonBuilder generateNonExecutableJson() {
        this.generateNonExecutableJson = true;
        return this;
    }

    public GsonBuilder excludeFieldsWithoutExposeAnnotation() {
        this.excluder = this.excluder.excludeFieldsWithoutExposeAnnotation();
        return this;
    }

    public GsonBuilder serializeNulls() {
        this.serializeNulls = true;
        return this;
    }

    public GsonBuilder enableComplexMapKeySerialization() {
        this.complexMapKeySerialization = true;
        return this;
    }

    public GsonBuilder disableInnerClassSerialization() {
        this.excluder = this.excluder.disableInnerClassSerialization();
        return this;
    }

    public GsonBuilder setLongSerializationPolicy(LongSerializationPolicy r1) {
        this.longSerializationPolicy = (LongSerializationPolicy) Objects.requireNonNull(r1);
        return this;
    }

    public GsonBuilder setFieldNamingPolicy(FieldNamingPolicy r1) {
        return setFieldNamingStrategy(r1);
    }

    public GsonBuilder setFieldNamingStrategy(FieldNamingStrategy r1) {
        this.fieldNamingPolicy = (FieldNamingStrategy) Objects.requireNonNull(r1);
        return this;
    }

    public GsonBuilder setObjectToNumberStrategy(ToNumberStrategy r1) {
        this.objectToNumberStrategy = (ToNumberStrategy) Objects.requireNonNull(r1);
        return this;
    }

    public GsonBuilder setNumberToNumberStrategy(ToNumberStrategy r1) {
        this.numberToNumberStrategy = (ToNumberStrategy) Objects.requireNonNull(r1);
        return this;
    }

    public GsonBuilder setExclusionStrategies(ExclusionStrategy... r6) {
        Objects.requireNonNull(r6);
        int r0 = r6.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        ExclusionStrategy r2 = r6[r1];
        this.excluder = this.excluder.withExclusionStrategy(r2, true, true);
        r1 = r1 + 1;
        goto L3
    L5:
        return this;
    }

    public GsonBuilder addSerializationExclusionStrategy(ExclusionStrategy r4) {
        Objects.requireNonNull(r4);
        this.excluder = this.excluder.withExclusionStrategy(r4, true, false);
        return this;
    }

    public GsonBuilder addDeserializationExclusionStrategy(ExclusionStrategy r4) {
        Objects.requireNonNull(r4);
        this.excluder = this.excluder.withExclusionStrategy(r4, false, true);
        return this;
    }

    public GsonBuilder setPrettyPrinting() {
        this.prettyPrinting = true;
        return this;
    }

    public GsonBuilder setLenient() {
        this.lenient = true;
        return this;
    }

    public GsonBuilder disableHtmlEscaping() {
        this.escapeHtmlChars = false;
        return this;
    }

    public GsonBuilder setDateFormat(String r1) {
        this.datePattern = r1;
        return this;
    }

    public GsonBuilder setDateFormat(int r1) {
        this.dateStyle = r1;
        this.datePattern = null;
        return this;
    }

    public GsonBuilder setDateFormat(int r1, int r2) {
        this.dateStyle = r1;
        this.timeStyle = r2;
        this.datePattern = null;
        return this;
    }

    public GsonBuilder registerTypeAdapter(Type r4, Object r5) {
        Objects.requireNonNull(r4);
        boolean r0 = r5 instanceof JsonSerializer;
        if (r0 == false) goto L5;
    L12:
        boolean r1 = true;
    L13:
        C$Gson$Preconditions.checkArgument(r1);
        if ((r5 instanceof InstanceCreator) == false) goto L16;
        this.instanceCreators.put(r4, (InstanceCreator) r5);
    L16:
        if (r0 == false) goto L18;
    L19:
        TypeToken<?> r2 = TypeToken.get(r4);
        this.factories.add(TreeTypeAdapter.newFactoryWithMatchRawType(r2, r5));
    L21:
        if ((r5 instanceof TypeAdapter) == false) goto L23;
        TypeAdapterFactory r6 = TypeAdapters.newFactory(TypeToken.get(r4), (TypeAdapter) r5);
        this.factories.add(r6);
    L23:
        return this;
    L18:
        if ((r5 instanceof JsonDeserializer) == false) goto L21;
    L5:
        if ((r5 instanceof JsonDeserializer) == true) goto L12;
        if ((r5 instanceof InstanceCreator) == true) goto L12;
        if ((r5 instanceof TypeAdapter) == true) goto L12;
        r1 = false;
        goto L13
    }

    public GsonBuilder registerTypeAdapterFactory(TypeAdapterFactory r2) {
        Objects.requireNonNull(r2);
        this.factories.add(r2);
        return this;
    }

    public GsonBuilder registerTypeHierarchyAdapter(Class<?> r3, Object r4) {
        Objects.requireNonNull(r3);
        boolean r0 = r4 instanceof JsonSerializer;
        if (r0 == false) goto L5;
    L10:
        boolean r1 = true;
    L11:
        C$Gson$Preconditions.checkArgument(r1);
        if ((r4 instanceof JsonDeserializer) == true) goto L14;
        if (r0 == true) goto L14;
    L16:
        if ((r4 instanceof TypeAdapter) == false) goto L18;
        TypeAdapterFactory r5 = TypeAdapters.newTypeHierarchyFactory(r3, (TypeAdapter) r4);
        this.factories.add(r5);
    L18:
        return this;
    L14:
        this.hierarchyFactories.add(TreeTypeAdapter.newTypeHierarchyFactory(r3, r4));
        goto L16
    L5:
        if ((r4 instanceof JsonDeserializer) == true) goto L10;
        if ((r4 instanceof TypeAdapter) == true) goto L10;
        r1 = false;
        goto L11
    }

    public GsonBuilder serializeSpecialFloatingPointValues() {
        this.serializeSpecialFloatingPointValues = true;
        return this;
    }

    public GsonBuilder disableJdkUnsafe() {
        this.useJdkUnsafe = false;
        return this;
    }

    public GsonBuilder addReflectionAccessFilter(ReflectionAccessFilter r2) {
        Objects.requireNonNull(r2);
        this.reflectionFilters.addFirst(r2);
        return this;
    }

    public Gson create() {
        List<TypeAdapterFactory> r1 = new ArrayList((this.factories.size() + this.hierarchyFactories.size()) + 3);
        r1.addAll(this.factories);
        Collections.reverse(r1);
        ArrayList r2 = new ArrayList(this.hierarchyFactories);
        Collections.reverse(r2);
        r1.addAll(r2);
        addTypeAdaptersForDate(this.datePattern, this.dateStyle, this.timeStyle, r1);
        return new Gson(this.excluder, this.fieldNamingPolicy, new HashMap(this.instanceCreators), this.serializeNulls, this.complexMapKeySerialization, this.generateNonExecutableJson, this.escapeHtmlChars, this.prettyPrinting, this.lenient, this.serializeSpecialFloatingPointValues, this.useJdkUnsafe, this.longSerializationPolicy, this.datePattern, this.dateStyle, this.timeStyle, new ArrayList(this.factories), new ArrayList(this.hierarchyFactories), r1, this.objectToNumberStrategy, this.numberToNumberStrategy, new ArrayList(this.reflectionFilters));
    }

    private void addTypeAdaptersForDate(String r4, int r5, int r6, List<TypeAdapterFactory> r7) {
        boolean r3 = SqlTypesSupport.SUPPORTS_SQL_TYPES;
        TypeAdapterFactory r0 = null;
        if (r4 == null) goto L11;
        if (r4.trim().isEmpty() == true) goto L11;
        TypeAdapterFactory r8 = DefaultDateTypeAdapter.DateType.DATE.createAdapterFactory(r4);
        if (r3 == false) goto L9;
        r0 = SqlTypesSupport.TIMESTAMP_DATE_TYPE.createAdapterFactory(r4);
        TypeAdapterFactory r9 = SqlTypesSupport.DATE_DATE_TYPE.createAdapterFactory(r4);
    L17:
        r7.add(r8);
        if (r3 == false) goto L23;
        r7.add(r0);
        r7.add(r9);
        return;
    L23:
        return;
    L9:
        r9 = null;
    L11:
        if (r5 == 2) goto L21;
        if (r6 == 2) goto L22;
        TypeAdapterFactory r10 = DefaultDateTypeAdapter.DateType.DATE.createAdapterFactory(r5, r6);
        if (r3 == false) goto L16;
        r0 = SqlTypesSupport.TIMESTAMP_DATE_TYPE.createAdapterFactory(r5, r6);
        TypeAdapterFactory r11 = SqlTypesSupport.DATE_DATE_TYPE.createAdapterFactory(r5, r6);
        r8 = r10;
        r9 = r11;
        goto L17
    L16:
        r8 = r10;
        goto L9
    L22:
        return;
    }
}
