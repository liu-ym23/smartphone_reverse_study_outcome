package com.google.i18n.phonenumbers.metadata.init;

import com.google.i18n.phonenumbers.MetadataLoader;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class ClassPathResourceMetadataLoader implements MetadataLoader {
    private static final Logger logger = null;

    public ClassPathResourceMetadataLoader() {
    }

    static {
        logger = Logger.getLogger(ClassPathResourceMetadataLoader.class.getName());
    }

    @Override // com.google.i18n.phonenumbers.MetadataLoader
    public InputStream loadMetadata(String r5) {
        InputStream r4 = ClassPathResourceMetadataLoader.class.getResourceAsStream(r5);
        if (r4 != null) goto L5;
        logger.log(Level.WARNING, String.format("File %s not found", new Object[]{r5}));
    L5:
        return r4;
    }
}
