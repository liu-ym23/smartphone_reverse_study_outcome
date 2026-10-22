package com.google.i18n.phonenumbers.metadata.source;

import com.google.i18n.phonenumbers.Phonemetadata;
import com.google.i18n.phonenumbers.internal.GeoEntityUtility;

/* JADX INFO: loaded from: classes2.dex */
final class CompositeMetadataContainer implements MetadataContainer {
    private final MapBackedMetadataContainer<Integer> metadataByCountryCode;
    private final MapBackedMetadataContainer<String> metadataByRegionCode;

    CompositeMetadataContainer() {
        this.metadataByCountryCode = MapBackedMetadataContainer.byCountryCallingCode();
        this.metadataByRegionCode = MapBackedMetadataContainer.byRegionCode();
    }

    Phonemetadata.PhoneMetadata getMetadataBy(String r1) {
        return this.metadataByRegionCode.getMetadataBy(r1);
    }

    Phonemetadata.PhoneMetadata getMetadataBy(int r1) {
        return this.metadataByCountryCode.getMetadataBy(Integer.valueOf(r1));
    }

    @Override // com.google.i18n.phonenumbers.metadata.source.MetadataContainer
    public void accept(Phonemetadata.PhoneMetadata r2) {
        if (GeoEntityUtility.isGeoEntity(this.metadataByRegionCode.getKeyProvider().getKeyOf(r2)) == false) goto L5;
        this.metadataByRegionCode.accept(r2);
        return;
    L5:
        this.metadataByCountryCode.accept(r2);
    }
}
