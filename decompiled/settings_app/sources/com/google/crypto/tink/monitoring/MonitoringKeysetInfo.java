package com.google.crypto.tink.monitoring;

import com.google.crypto.tink.KeyStatus;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
public final class MonitoringKeysetInfo {
    private final MonitoringAnnotations annotations;
    private final List<Entry> entries;

    @Nullable
    private final Integer primaryKeyId;

    /* JADX INFO: renamed from: com.google.crypto.tink.monitoring.MonitoringKeysetInfo$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        private MonitoringAnnotations builderAnnotations;

        @Nullable
        private ArrayList<Entry> builderEntries;

        @Nullable
        private Integer builderPrimaryKeyId;

        public Builder() {
            this.builderEntries = new ArrayList();
            this.builderAnnotations = MonitoringAnnotations.EMPTY;
            this.builderPrimaryKeyId = null;
        }

        public Builder setAnnotations(MonitoringAnnotations annotations) {
            if (this.builderEntries == null) goto L7;
            this.builderAnnotations = annotations;
            return this;
        L7:
            throw new IllegalStateException("setAnnotations cannot be called after build()");
        }

        public Builder addEntry(KeyStatus status, int keyId, String keyType, String keyPrefix) {
            ArrayList<Entry> r0 = this.builderEntries;
            if (r0 == null) goto L7;
            r0.add(new Entry(status, keyId, keyType, keyPrefix, null));
            return this;
        L7:
            throw new IllegalStateException("addEntry cannot be called after build()");
        }

        public Builder setPrimaryKeyId(int primaryKeyId) {
            if (this.builderEntries == null) goto L7;
            this.builderPrimaryKeyId = Integer.valueOf(primaryKeyId);
            return this;
        L7:
            throw new IllegalStateException("setPrimaryKeyId cannot be called after build()");
        }

        private boolean isKeyIdInEntries(int keyId) {
            Iterator<Entry> r1 = this.builderEntries.iterator();
        L4:
            if (r1.hasNext() == false) goto L9;
            if (r1.next().getKeyId() != keyId) goto L4;
            return true;
        L9:
            return false;
        }

        public MonitoringKeysetInfo build() throws GeneralSecurityException {
            if (this.builderEntries == null) goto L14;
            Integer r0 = this.builderPrimaryKeyId;
            if (r0 != null) goto L7;
        L11:
            MonitoringKeysetInfo r1 = new MonitoringKeysetInfo(this.builderAnnotations, Collections.unmodifiableList(this.builderEntries), this.builderPrimaryKeyId, null);
            this.builderEntries = null;
            return r1;
        L7:
            if (isKeyIdInEntries(r0.intValue()) == true) goto L11;
            throw new GeneralSecurityException("primary key ID is not present in entries");
        L14:
            throw new IllegalStateException("cannot call build() twice");
        }
    }

    @Immutable
    public static final class Entry {
        private final int keyId;
        private final String keyPrefix;
        private final String keyType;
        private final KeyStatus status;

        /* synthetic */ Entry(KeyStatus r1, int r2, String r3, String r4, AnonymousClass1 r5) {
            this(r1, r2, r3, r4);
        }

        public KeyStatus getStatus() {
            return this.status;
        }

        public int getKeyId() {
            return this.keyId;
        }

        public String getKeyType() {
            return this.keyType;
        }

        public String getKeyPrefix() {
            return this.keyPrefix;
        }

        private Entry(KeyStatus status, int keyId, String keyType, String keyPrefix) {
            this.status = status;
            this.keyId = keyId;
            this.keyType = keyType;
            this.keyPrefix = keyPrefix;
        }

        public boolean equals(Object obj) {
            if ((obj instanceof Entry) == true) goto L5;
            return false;
        L5:
            Entry r4 = (Entry) obj;
            if (this.status == r4.status) goto L8;
            return false;
        L8:
            if (this.keyId == r4.keyId) goto L10;
            return false;
        L10:
            if (this.keyType.equals(r4.keyType) == true) goto L12;
            return false;
        L12:
            if (this.keyPrefix.equals(r4.keyPrefix) == false) goto L18;
            return true;
        L18:
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.status, Integer.valueOf(this.keyId), this.keyType, this.keyPrefix});
        }

        public String toString() {
            return String.format("(status=%s, keyId=%s, keyType='%s', keyPrefix='%s')", new Object[]{this.status, Integer.valueOf(this.keyId), this.keyType, this.keyPrefix});
        }
    }

    /* synthetic */ MonitoringKeysetInfo(MonitoringAnnotations r1, List r2, Integer r3, AnonymousClass1 r4) {
        this(r1, r2, r3);
    }

    private MonitoringKeysetInfo(MonitoringAnnotations annotations, List<Entry> entries, Integer primaryKeyId) {
        this.annotations = annotations;
        this.entries = entries;
        this.primaryKeyId = primaryKeyId;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public MonitoringAnnotations getAnnotations() {
        return this.annotations;
    }

    public List<Entry> getEntries() {
        return this.entries;
    }

    @Nullable
    public Integer getPrimaryKeyId() {
        return this.primaryKeyId;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof MonitoringKeysetInfo) == true) goto L5;
        return false;
    L5:
        MonitoringKeysetInfo r4 = (MonitoringKeysetInfo) obj;
        if (this.annotations.equals(r4.annotations) == true) goto L8;
        return false;
    L8:
        if (this.entries.equals(r4.entries) == true) goto L10;
        return false;
    L10:
        if (Objects.equals(this.primaryKeyId, r4.primaryKeyId) == false) goto L15;
        return true;
    L15:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.annotations, this.entries});
    }

    public String toString() {
        return String.format("(annotations=%s, entries=%s, primaryKeyId=%s)", new Object[]{this.annotations, this.entries, this.primaryKeyId});
    }
}
