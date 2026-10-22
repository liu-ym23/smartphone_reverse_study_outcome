package com.google.common.collect;

import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
class ImmutableMapEntry<K, V> extends ImmutableEntry<K, V> {

    static final class NonTerminalImmutableBiMapEntry<K, V> extends NonTerminalImmutableMapEntry<K, V> {

        @CheckForNull
        private final transient ImmutableMapEntry<K, V> nextInValueBucket;

        NonTerminalImmutableBiMapEntry(K r1, V r2, @CheckForNull ImmutableMapEntry<K, V> r3, @CheckForNull ImmutableMapEntry<K, V> r4) {
            super(r1, r2, r3);
            this.nextInValueBucket = r4;
        }

        @Override // com.google.common.collect.ImmutableMapEntry
        @CheckForNull
        ImmutableMapEntry<K, V> getNextInValueBucket() {
            return this.nextInValueBucket;
        }
    }

    static class NonTerminalImmutableMapEntry<K, V> extends ImmutableMapEntry<K, V> {

        @CheckForNull
        private final transient ImmutableMapEntry<K, V> nextInKeyBucket;

        @Override // com.google.common.collect.ImmutableMapEntry
        final boolean isReusable() {
            return false;
        }

        NonTerminalImmutableMapEntry(K r1, V r2, @CheckForNull ImmutableMapEntry<K, V> r3) {
            super(r1, r2);
            this.nextInKeyBucket = r3;
        }

        @Override // com.google.common.collect.ImmutableMapEntry
        @CheckForNull
        final ImmutableMapEntry<K, V> getNextInKeyBucket() {
            return this.nextInKeyBucket;
        }
    }

    @CheckForNull
    ImmutableMapEntry<K, V> getNextInKeyBucket() {
        return null;
    }

    @CheckForNull
    ImmutableMapEntry<K, V> getNextInValueBucket() {
        return null;
    }

    boolean isReusable() {
        return true;
    }

    static <K, V> ImmutableMapEntry<K, V>[] createEntryArray(int r0) {
        return new ImmutableMapEntry[r0];
    }

    ImmutableMapEntry(K r1, V r2) {
        super(r1, r2);
        CollectPreconditions.checkEntryNotNull(r1, r2);
    }

    ImmutableMapEntry(ImmutableMapEntry<K, V> r2) {
        super(r2.getKey(), r2.getValue());
    }
}
