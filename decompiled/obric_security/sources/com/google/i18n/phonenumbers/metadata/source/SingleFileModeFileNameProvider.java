package com.google.i18n.phonenumbers.metadata.source;

/* JADX INFO: loaded from: classes2.dex */
public final class SingleFileModeFileNameProvider implements PhoneMetadataFileNameProvider {
    private final String phoneMetadataFileName;

    public SingleFileModeFileNameProvider(String r1) {
        this.phoneMetadataFileName = r1;
    }

    @Override // com.google.i18n.phonenumbers.metadata.source.PhoneMetadataFileNameProvider
    public String getFor(Object r1) {
        return this.phoneMetadataFileName;
    }
}
