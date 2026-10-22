package com.google.i18n.phonenumbers.metadata.source;

import com.google.i18n.phonenumbers.MetadataLoader;
import com.google.i18n.phonenumbers.Phonemetadata;
import com.google.i18n.phonenumbers.metadata.init.MetadataParser;

/* JADX INFO: loaded from: classes2.dex */
public final class FormattingMetadataSourceImpl implements FormattingMetadataSource {
    private final MetadataBootstrappingGuard<MapBackedMetadataContainer<Integer>> bootstrappingGuard;
    private final PhoneMetadataFileNameProvider phoneMetadataFileNameProvider;

    public FormattingMetadataSourceImpl(PhoneMetadataFileNameProvider r1, MetadataBootstrappingGuard<MapBackedMetadataContainer<Integer>> r2) {
        this.phoneMetadataFileNameProvider = r1;
        this.bootstrappingGuard = r2;
    }

    public FormattingMetadataSourceImpl(PhoneMetadataFileNameProvider r3, MetadataLoader r4, MetadataParser r5) {
        this(r3, new BlockingMetadataBootstrappingGuard(r4, r5, MapBackedMetadataContainer.byCountryCallingCode()));
    }

    @Override // com.google.i18n.phonenumbers.metadata.source.FormattingMetadataSource
    public Phonemetadata.PhoneMetadata getFormattingMetadataForCountryCallingCode(int r3) {
        return ((MapBackedMetadataContainer) this.bootstrappingGuard.getOrBootstrap(this.phoneMetadataFileNameProvider.getFor(Integer.valueOf(r3)))).getMetadataBy(Integer.valueOf(r3));
    }
}
