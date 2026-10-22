package com.google.i18n.phonenumbers.metadata.source;

import com.google.i18n.phonenumbers.Phonemetadata;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes2.dex */
final class MapBackedMetadataContainer<T> implements MetadataContainer {
    private final KeyProvider<T> keyProvider;
    private final ConcurrentMap<T, Phonemetadata.PhoneMetadata> metadataMap;

    interface KeyProvider<T> {
        T getKeyOf(Phonemetadata.PhoneMetadata r1);
    }

    static MapBackedMetadataContainer<String> byRegionCode() {
        return new MapBackedMetadataContainer(new AnonymousClass1());
    }

    static MapBackedMetadataContainer<Integer> byCountryCallingCode() {
        return new MapBackedMetadataContainer(new AnonymousClass2());
    }

    private MapBackedMetadataContainer(KeyProvider<T> r2) {
        this.metadataMap = new ConcurrentHashMap();
        this.keyProvider = r2;
    }

    Phonemetadata.PhoneMetadata getMetadataBy(T r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return this.metadataMap.get(r1);
    }

    KeyProvider<T> getKeyProvider() {
        return this.keyProvider;
    }

    @Override // com.google.i18n.phonenumbers.metadata.source.MetadataContainer
    public void accept(Phonemetadata.PhoneMetadata r2) {
        this.metadataMap.put(this.keyProvider.getKeyOf(r2), r2);
    }
}
