package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.Enum;
import java.util.EnumMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class EnumBiMap<K extends Enum<K>, V extends Enum<V>> extends AbstractBiMap<K, V> {
    private static final long serialVersionUID = 0;
    private transient Class<K> keyType;
    private transient Class<V> valueType;

    @Override // com.google.common.collect.AbstractBiMap
    /* bridge */ /* synthetic */ Object checkKey(Object r1) {
        return checkKey((Enum) r1);
    }

    @Override // com.google.common.collect.AbstractBiMap
    /* bridge */ /* synthetic */ Object checkValue(Object r1) {
        return checkValue((Enum) r1);
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.ForwardingMap, java.util.Map
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.ForwardingMap, java.util.Map
    public /* bridge */ /* synthetic */ boolean containsValue(@CheckForNull Object r1) {
        return super.containsValue(r1);
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.ForwardingMap, java.util.Map
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.BiMap
    @CheckForNull
    public /* bridge */ /* synthetic */ Object forcePut(@ParametricNullness Object r1, @ParametricNullness Object r2) {
        return super.forcePut(r1, r2);
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.BiMap
    public /* bridge */ /* synthetic */ BiMap inverse() {
        return super.inverse();
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.ForwardingMap, java.util.Map
    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    @CheckForNull
    public /* bridge */ /* synthetic */ Object put(@ParametricNullness Object r1, @ParametricNullness Object r2) {
        return super.put(r1, r2);
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    public /* bridge */ /* synthetic */ void putAll(Map r1) {
        super.putAll(r1);
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.ForwardingMap, java.util.Map
    @CheckForNull
    public /* bridge */ /* synthetic */ Object remove(@CheckForNull Object r1) {
        return super.remove(r1);
    }

    @Override // com.google.common.collect.AbstractBiMap, java.util.Map
    public /* bridge */ /* synthetic */ void replaceAll(BiFunction r1) {
        super.replaceAll(r1);
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    public /* bridge */ /* synthetic */ Set values() {
        return super.values();
    }

    public static <K extends Enum<K>, V extends Enum<V>> EnumBiMap<K, V> create(Class<K> r1, Class<V> r2) {
        return new EnumBiMap(r1, r2);
    }

    public static <K extends Enum<K>, V extends Enum<V>> EnumBiMap<K, V> create(Map<K, V> r2) {
        EnumBiMap<K, V> r0 = create(inferKeyType(r2), inferValueType(r2));
        r0.putAll(r2);
        return r0;
    }

    private EnumBiMap(Class<K> r3, Class<V> r4) {
        super(new EnumMap(r3), new EnumMap(r4));
        this.keyType = r3;
        this.valueType = r4;
    }

    static <K extends Enum<K>> Class<K> inferKeyType(Map<K, ?> r1) {
        if ((r1 instanceof EnumBiMap) == false) goto L7;
        return ((EnumBiMap) r1).keyType();
    L7:
        if ((r1 instanceof EnumHashBiMap) == true) goto L9;
        Preconditions.checkArgument(!r1.isEmpty());
        return r1.keySet().iterator().next().getDeclaringClass();
    L9:
        return ((EnumHashBiMap) r1).keyType();
    }

    private static <V extends Enum<V>> Class<V> inferValueType(Map<?, V> r1) {
        if ((r1 instanceof EnumBiMap) == true) goto L5;
        Preconditions.checkArgument(!r1.isEmpty());
        return r1.values().iterator().next().getDeclaringClass();
    L5:
        return ((EnumBiMap) r1).valueType;
    }

    public Class<K> keyType() {
        return this.keyType;
    }

    public Class<V> valueType() {
        return this.valueType;
    }

    K checkKey(K r1) {
        return (K) Preconditions.checkNotNull(r1);
    }

    V checkValue(V r1) {
        return (V) Preconditions.checkNotNull(r1);
    }

    private void writeObject(ObjectOutputStream r2) throws IOException {
        r2.defaultWriteObject();
        r2.writeObject(this.keyType);
        r2.writeObject(this.valueType);
        Serialization.writeMap(this, r2);
    }

    private void readObject(ObjectInputStream r4) throws IOException, ClassNotFoundException {
        r4.defaultReadObject();
        this.keyType = (Class) r4.readObject();
        this.valueType = (Class) r4.readObject();
        setDelegates(new EnumMap(this.keyType), new EnumMap(this.valueType));
        Serialization.populateMap(this, r4);
    }
}
