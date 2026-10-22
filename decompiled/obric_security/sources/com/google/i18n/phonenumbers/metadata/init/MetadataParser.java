package com.google.i18n.phonenumbers.metadata.init;

import com.google.i18n.phonenumbers.Phonemetadata;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class MetadataParser {
    private static final Logger logger = null;
    private final boolean strictMode;

    static {
        logger = Logger.getLogger(MetadataParser.class.getName());
    }

    public static MetadataParser newLenientParser() {
        return new MetadataParser(false);
    }

    public static MetadataParser newStrictParser() {
        return new MetadataParser(true);
    }

    private MetadataParser(boolean r1) {
        this.strictMode = r1;
    }

    public Collection<Phonemetadata.PhoneMetadata> parse(InputStream r6) {
        if (r6 != null) goto L27;
        return handleNullSource();
    L27:
        ObjectInputStream r1 = new ObjectInputStream(r6);     // Catch: Throwable -> L16 IOException -> L18
        Phonemetadata.PhoneMetadataCollection r0 = new Phonemetadata.PhoneMetadataCollection();     // Catch: IOException -> L14 Throwable -> L22
        r0.readExternal(r1);     // Catch: IOException -> L14 Throwable -> L22
        if (r0.getMetadataList().isEmpty() == true) goto L13;
        List<Phonemetadata.PhoneMetadata> r7 = r0.getMetadataList();     // Catch: IOException -> L14 Throwable -> L22
        close(r1);
        return r7;
    L13:
        throw new IllegalStateException("Empty metadata");     // Catch: IOException -> L14 Throwable -> L22
    L14:
        IOException e = e;
    L21:
        throw new IllegalStateException("Unable to parse metadata file", e);     // Catch: Throwable -> L22
    L22:
        Throwable th = th;
    L23:
        if (0 == 0) goto L25;
        close(null);
    L26:
        throw th;
    L25:
        close(r6);
    L18:
        e = move-exception;
        e = e;
    L16:
        th = move-exception;
        th = th;
        goto L23
    }

    private List<Phonemetadata.PhoneMetadata> handleNullSource() {
        if (this.strictMode == true) goto L7;
        return Collections.emptyList();
    L7:
        throw new IllegalArgumentException("Source cannot be null");
    }

    private void close(InputStream r3) {
        r3.close();     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        logger.log(Level.WARNING, "Error closing input stream (ignored)", e);
    }
}
