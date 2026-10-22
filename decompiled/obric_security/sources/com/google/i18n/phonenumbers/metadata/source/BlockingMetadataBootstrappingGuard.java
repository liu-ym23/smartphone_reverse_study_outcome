package com.google.i18n.phonenumbers.metadata.source;

import com.google.i18n.phonenumbers.MetadataLoader;
import com.google.i18n.phonenumbers.Phonemetadata;
import com.google.i18n.phonenumbers.metadata.init.MetadataParser;
import com.google.i18n.phonenumbers.metadata.source.MetadataContainer;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
final class BlockingMetadataBootstrappingGuard<T extends MetadataContainer> implements MetadataBootstrappingGuard<T> {
    private final Map<String, String> loadedFiles;
    private final T metadataContainer;
    private final MetadataLoader metadataLoader;
    private final MetadataParser metadataParser;

    BlockingMetadataBootstrappingGuard(MetadataLoader r1, MetadataParser r2, T r3) {
        this.metadataLoader = r1;
        this.metadataParser = r2;
        this.metadataContainer = r3;
        this.loadedFiles = new ConcurrentHashMap();
    }

    @Override // com.google.i18n.phonenumbers.metadata.source.MetadataBootstrappingGuard
    public T getOrBootstrap(String r2) {
        if (this.loadedFiles.containsKey(r2) == true) goto L6;
        bootstrapMetadata(r2);
    L6:
        return this.metadataContainer;
    }

    private synchronized void bootstrapMetadata(String r4) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.loadedFiles.containsKey(r4) == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        Iterator<Phonemetadata.PhoneMetadata> r0 = read(r4).iterator();     // Catch: Throwable -> L14
    L9:
        if (r0.hasNext() == false) goto L11;
        Phonemetadata.PhoneMetadata r1 = r0.next();     // Catch: Throwable -> L14
        this.metadataContainer.accept(r1);     // Catch: Throwable -> L14
        goto L9
    L11:
        this.loadedFiles.put(r4, r4);     // Catch: Throwable -> L14
        monitor-exit(this);
    }

    private Collection<Phonemetadata.PhoneMetadata> read(String r4) {
        return this.metadataParser.parse(this.metadataLoader.loadMetadata(r4));
    L4:
        e = move-exception;
        throw new IllegalStateException("Failed to read file " + r4, e);
    }
}
