package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Primitives;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class MutableClassToInstanceMap<B> extends ForwardingMap<Class<? extends B>, B> implements ClassToInstanceMap<B>, Serializable {
    private final Map<Class<? extends B>, B> delegate;

    /* JADX INFO: renamed from: com.google.common.collect.MutableClassToInstanceMap$2, reason: invalid class name */
    class AnonymousClass2 extends ForwardingSet<Map.Entry<Class<? extends B>, B>> {
        final /* synthetic */ MutableClassToInstanceMap this$0;

        AnonymousClass2(MutableClassToInstanceMap r1) {
            this.this$0 = r1;
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected Set<Map.Entry<Class<? extends B>, B>> delegate() {
            return this.this$0.delegate().entrySet();
        }

        static /* synthetic */ Map.Entry lambda$spliterator$0(Map.Entry r0) {
            return MutableClassToInstanceMap.access$100(r0);
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.Set
        public Spliterator<Map.Entry<Class<? extends B>, B>> spliterator() {
            return CollectSpliterators.map(delegate().spliterator(), new MutableClassToInstanceMap$2$$ExternalSyntheticLambda0());
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<Class<? extends B>, B>> iterator() {
            final Iterator<Map.Entry<Class<? extends B>, B>> r1 = delegate().iterator();
            return new AnonymousClass1(this, r1);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] r1) {
            return (T[]) standardToArray(r1);
        }
    }

    private static final class SerializedForm<B> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Map<Class<? extends B>, B> backingMap;

        SerializedForm(Map<Class<? extends B>, B> r1) {
            this.backingMap = r1;
        }

        Object readResolve() {
            return MutableClassToInstanceMap.create(this.backingMap);
        }
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    @CheckForNull
    public /* bridge */ /* synthetic */ Object put(Object r1, Object r2) {
        return put((Class) r1, r2);
    }

    static /* synthetic */ Object access$000(Class r0, Object r1) {
        return cast(r0, r1);
    }

    static /* synthetic */ Map.Entry access$100(Map.Entry r0) {
        return checkedEntry(r0);
    }

    public static <B> MutableClassToInstanceMap<B> create() {
        return new MutableClassToInstanceMap(new HashMap());
    }

    public static <B> MutableClassToInstanceMap<B> create(Map<Class<? extends B>, B> r1) {
        return new MutableClassToInstanceMap(r1);
    }

    private MutableClassToInstanceMap(Map<Class<? extends B>, B> r1) {
        this.delegate = (Map) Preconditions.checkNotNull(r1);
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    protected Map<Class<? extends B>, B> delegate() {
        return this.delegate;
    }

    private static <B> Map.Entry<Class<? extends B>, B> checkedEntry(final Map.Entry<Class<? extends B>, B> r1) {
        return new AnonymousClass1(r1);
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public Set<Map.Entry<Class<? extends B>, B>> entrySet() {
        return new AnonymousClass2(this);
    }

    @CheckForNull
    public B put(Class<? extends B> r1, B r2) {
        return (B) super.put(r1, cast(r1, r2));
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    public void putAll(Map<? extends Class<? extends B>, ? extends B> r4) {
        LinkedHashMap r0 = new LinkedHashMap(r4);
        Iterator r5 = r0.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) r5.next();
        cast((Class) r1.getKey(), r1.getValue());
        goto L4
    L6:
        super.putAll(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ClassToInstanceMap
    @CheckForNull
    public <T extends B> T putInstance(Class<T> r1, T r2) {
        return (T) cast(r1, put(r1, r2));
    }

    @Override // com.google.common.collect.ClassToInstanceMap
    @CheckForNull
    public <T extends B> T getInstance(Class<T> r1) {
        return (T) cast(r1, get(r1));
    }

    @CheckForNull
    private static <B, T extends B> T cast(Class<T> r0, @CheckForNull B r1) {
        return (T) Primitives.wrap(r0).cast(r1);
    }

    private Object writeReplace() {
        return new SerializedForm(delegate());
    }
}
