package com.google.i18n.phonenumbers.metadata.source;

import com.google.i18n.phonenumbers.MetadataLoader;
import com.google.i18n.phonenumbers.Phonemetadata;
import com.google.i18n.phonenumbers.internal.GeoEntityUtility;
import com.google.i18n.phonenumbers.metadata.init.MetadataParser;

/* JADX INFO: loaded from: classes2.dex */
public final class RegionMetadataSourceImpl implements RegionMetadataSource {
    private final MetadataBootstrappingGuard<MapBackedMetadataContainer<String>> bootstrappingGuard;
    private final PhoneMetadataFileNameProvider phoneMetadataFileNameProvider;

    public RegionMetadataSourceImpl(PhoneMetadataFileNameProvider r1, MetadataBootstrappingGuard<MapBackedMetadataContainer<String>> r2) {
        this.phoneMetadataFileNameProvider = r1;
        this.bootstrappingGuard = r2;
    }

    public RegionMetadataSourceImpl(PhoneMetadataFileNameProvider r3, MetadataLoader r4, MetadataParser r5) {
        this(r3, new BlockingMetadataBootstrappingGuard(r4, r5, MapBackedMetadataContainer.byRegionCode()));
    }

    @Override // com.google.i18n.phonenumbers.metadata.source.RegionMetadataSource
    public Phonemetadata.PhoneMetadata getMetadataForRegion(String r2) {
        if (GeoEntityUtility.isGeoEntity(r2) == false) goto L7;
        return ((MapBackedMetadataContainer) this.bootstrappingGuard.getOrBootstrap(this.phoneMetadataFileNameProvider.getFor(r2))).getMetadataBy(r2);
    L7:
        throw new IllegalArgumentException(r2 + " region code is a non-geo entity");
    }
}
