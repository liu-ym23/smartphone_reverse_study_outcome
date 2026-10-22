package com.google.i18n.phonenumbers.metadata.source;

import com.google.i18n.phonenumbers.MetadataLoader;
import com.google.i18n.phonenumbers.Phonemetadata;
import com.google.i18n.phonenumbers.internal.GeoEntityUtility;
import com.google.i18n.phonenumbers.metadata.init.MetadataParser;

/* JADX INFO: loaded from: classes2.dex */
public final class MetadataSourceImpl implements MetadataSource {
    private final MetadataBootstrappingGuard<CompositeMetadataContainer> bootstrappingGuard;
    private final PhoneMetadataFileNameProvider phoneMetadataFileNameProvider;

    public MetadataSourceImpl(PhoneMetadataFileNameProvider r1, MetadataBootstrappingGuard<CompositeMetadataContainer> r2) {
        this.phoneMetadataFileNameProvider = r1;
        this.bootstrappingGuard = r2;
    }

    public MetadataSourceImpl(PhoneMetadataFileNameProvider r3, MetadataLoader r4, MetadataParser r5) {
        this(r3, new BlockingMetadataBootstrappingGuard(r4, r5, new CompositeMetadataContainer()));
    }

    @Override // com.google.i18n.phonenumbers.metadata.source.NonGeographicalEntityMetadataSource
    public Phonemetadata.PhoneMetadata getMetadataForNonGeographicalRegion(int r3) {
        if (GeoEntityUtility.isGeoEntity(r3) == true) goto L7;
        return ((CompositeMetadataContainer) this.bootstrappingGuard.getOrBootstrap(this.phoneMetadataFileNameProvider.getFor(Integer.valueOf(r3)))).getMetadataBy(r3);
    L7:
        throw new IllegalArgumentException(r3 + " calling code belongs to a geo entity");
    }

    @Override // com.google.i18n.phonenumbers.metadata.source.RegionMetadataSource
    public Phonemetadata.PhoneMetadata getMetadataForRegion(String r2) {
        if (GeoEntityUtility.isGeoEntity(r2) == false) goto L7;
        return ((CompositeMetadataContainer) this.bootstrappingGuard.getOrBootstrap(this.phoneMetadataFileNameProvider.getFor(r2))).getMetadataBy(r2);
    L7:
        throw new IllegalArgumentException(r2 + " region code is a non-geo entity");
    }
}
