package com.google.i18n.phonenumbers.metadata.source;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class MultiFileModeFileNameProvider implements PhoneMetadataFileNameProvider {
    private static final Pattern ALPHANUMERIC = null;
    private final String phoneMetadataFileNamePrefix;

    static {
        ALPHANUMERIC = Pattern.compile("^[\\p{L}\\p{N}]+$");
    }

    public MultiFileModeFileNameProvider(String r2) {
        this.phoneMetadataFileNamePrefix = r2 + "_";
    }

    @Override // com.google.i18n.phonenumbers.metadata.source.PhoneMetadataFileNameProvider
    public String getFor(Object r3) {
        String r0 = r3.toString();
        if (ALPHANUMERIC.matcher(r0).matches() == false) goto L7;
        return this.phoneMetadataFileNamePrefix + r3;
    L7:
        throw new IllegalArgumentException("Invalid key: " + r0);
    }
}
