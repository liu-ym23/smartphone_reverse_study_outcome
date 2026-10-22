package com.google.crypto.tink.internal;

import com.google.crypto.tink.CryptoFormat;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.monitoring.MonitoringAnnotations;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.util.Bytes;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class PrimitiveSet<P> {
    private final MonitoringAnnotations annotations;
    private final Map<Bytes, List<Entry<P>>> entries;
    private final List<Entry<P>> entriesInKeysetOrder;
    private final Entry<P> primary;
    private final Class<P> primitiveClass;

    /* JADX INFO: renamed from: com.google.crypto.tink.internal.PrimitiveSet$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder<P> {
        private MonitoringAnnotations annotations;
        private Map<Bytes, List<Entry<P>>> entries;
        private final List<Entry<P>> entriesInKeysetOrder;
        private Entry<P> primary;
        private final Class<P> primitiveClass;

        /* synthetic */ Builder(Class r1, AnonymousClass1 r2) {
            this(r1);
        }

        private Builder<P> addEntry(final P fullPrimitive, Key key, Keyset.Key protoKey, boolean asPrimary) throws GeneralSecurityException {
            if (this.entries == null) goto L20;
            if (fullPrimitive == null) goto L18;
            if (protoKey.getStatus() != KeyStatusType.ENABLED) goto L16;
            Entry<P> r0 = new Entry(fullPrimitive, Bytes.copyFrom(CryptoFormat.getOutputPrefix(protoKey)), protoKey.getStatus(), protoKey.getOutputPrefixType(), protoKey.getKeyId(), protoKey.getKeyData().getTypeUrl(), key, null);
            PrimitiveSet.access$200(r0, this.entries, this.entriesInKeysetOrder);
            if (asPrimary == true) goto L10;
        L14:
            return this;
        L10:
            if (this.primary != null) goto L13;
            this.primary = r0;
            goto L14
        L13:
            throw new IllegalStateException("you cannot set two primary primitives");
        L16:
            throw new GeneralSecurityException("only ENABLED key is allowed");
        L18:
            throw new NullPointerException("`fullPrimitive` must not be null");
        L20:
            throw new IllegalStateException("addEntry cannot be called after build");
        }

        public Builder<P> addFullPrimitive(final P fullPrimitive, Key key, Keyset.Key protoKey) throws GeneralSecurityException {
            return addEntry(fullPrimitive, key, protoKey, false);
        }

        public Builder<P> addPrimaryFullPrimitive(final P fullPrimitive, Key key, Keyset.Key protoKey) throws GeneralSecurityException {
            return addEntry(fullPrimitive, key, protoKey, true);
        }

        public Builder<P> setAnnotations(MonitoringAnnotations annotations) {
            if (this.entries == null) goto L7;
            this.annotations = annotations;
            return this;
        L7:
            throw new IllegalStateException("setAnnotations cannot be called after build");
        }

        public PrimitiveSet<P> build() throws GeneralSecurityException {
            if (this.entries == null) goto L7;
            PrimitiveSet<P> r0 = new PrimitiveSet(this.entries, this.entriesInKeysetOrder, this.primary, this.annotations, this.primitiveClass, null);
            this.entries = null;
            return r0;
        L7:
            throw new IllegalStateException("build cannot be called twice");
        }

        private Builder(Class<P> primitiveClass) {
            this.entries = new HashMap();
            this.entriesInKeysetOrder = new ArrayList();
            this.primitiveClass = primitiveClass;
            this.annotations = MonitoringAnnotations.EMPTY;
        }
    }

    public static final class Entry<P> {
        private final P fullPrimitive;
        private final Key key;
        private final int keyId;
        private final String keyTypeUrl;
        private final Bytes outputPrefix;
        private final OutputPrefixType outputPrefixType;
        private final KeyStatusType status;

        /* synthetic */ Entry(Object r1, Bytes r2, KeyStatusType r3, OutputPrefixType r4, int r5, String r6, Key r7, AnonymousClass1 r8) {
            this(r1, r2, r3, r4, r5, r6, r7);
        }

        static /* synthetic */ Bytes access$000(Entry r0) {
            return r0.getOutputPrefix();
        }

        private Entry(P fullPrimitive, final Bytes outputPrefix, KeyStatusType status, OutputPrefixType outputPrefixType, int keyId, String keyTypeUrl, Key key) {
            this.fullPrimitive = fullPrimitive;
            this.outputPrefix = outputPrefix;
            this.status = status;
            this.outputPrefixType = outputPrefixType;
            this.keyId = keyId;
            this.keyTypeUrl = keyTypeUrl;
            this.key = key;
        }

        public P getFullPrimitive() {
            return this.fullPrimitive;
        }

        public KeyStatusType getStatus() {
            return this.status;
        }

        public OutputPrefixType getOutputPrefixType() {
            return this.outputPrefixType;
        }

        private final Bytes getOutputPrefix() {
            return this.outputPrefix;
        }

        public int getKeyId() {
            return this.keyId;
        }

        public String getKeyTypeUrl() {
            return this.keyTypeUrl;
        }

        public Key getKey() {
            return this.key;
        }

        @Nullable
        public Parameters getParameters() {
            Key r0 = this.key;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.getParameters();
        }
    }

    /* synthetic */ PrimitiveSet(Map r1, List r2, Entry r3, MonitoringAnnotations r4, Class r5, AnonymousClass1 r6) {
        this(r1, r2, r3, r4, r5);
    }

    static /* synthetic */ void access$200(Entry r0, Map r1, List r2) {
        storeEntryInPrimitiveSet(r0, r1, r2);
    }

    private static <P> void storeEntryInPrimitiveSet(Entry<P> entry, Map<Bytes, List<Entry<P>>> entries, List<Entry<P>> entriesInKeysetOrder) {
        ArrayList r0 = new ArrayList();
        r0.add(entry);
        List<Entry<P>> r1 = entries.put(Entry.access$000(entry), Collections.unmodifiableList(r0));
        if (r1 == null) goto L5;
        ArrayList r2 = new ArrayList();
        r2.addAll(r1);
        r2.add(entry);
        entries.put(Entry.access$000(entry), Collections.unmodifiableList(r2));
    L5:
        entriesInKeysetOrder.add(entry);
    }

    @Nullable
    public Entry<P> getPrimary() {
        return this.primary;
    }

    public boolean hasAnnotations() {
        return !this.annotations.toMap().isEmpty();
    }

    public MonitoringAnnotations getAnnotations() {
        return this.annotations;
    }

    public List<Entry<P>> getRawPrimitives() {
        return getPrimitive(CryptoFormat.RAW_PREFIX);
    }

    public List<Entry<P>> getPrimitive(final byte[] identifier) {
        List<Entry<P>> r0 = this.entries.get(Bytes.copyFrom(identifier));
        if (r0 == null) goto L6;
        return r0;
    L6:
        return Collections.emptyList();
    }

    public Collection<List<Entry<P>>> getAll() {
        return this.entries.values();
    }

    public List<Entry<P>> getAllInKeysetOrder() {
        return Collections.unmodifiableList(this.entriesInKeysetOrder);
    }

    private PrimitiveSet(Map<Bytes, List<Entry<P>>> entries, List<Entry<P>> entriesInKeysetOrder, Entry<P> primary, MonitoringAnnotations annotations, Class<P> primitiveClass) {
        this.entries = entries;
        this.entriesInKeysetOrder = entriesInKeysetOrder;
        this.primary = primary;
        this.primitiveClass = primitiveClass;
        this.annotations = annotations;
    }

    public Class<P> getPrimitiveClass() {
        return this.primitiveClass;
    }

    public static <P> Builder<P> newBuilder(Class<P> primitiveClass) {
        return new Builder(primitiveClass, null);
    }
}
