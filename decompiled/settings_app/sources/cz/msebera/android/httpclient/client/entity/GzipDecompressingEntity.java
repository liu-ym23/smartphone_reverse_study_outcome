package cz.msebera.android.httpclient.client.entity;

import cz.msebera.android.httpclient.HttpEntity;

/* JADX INFO: loaded from: classes5.dex */
public class GzipDecompressingEntity extends DecompressingEntity {
    public GzipDecompressingEntity(HttpEntity r2) {
        super(r2, GZIPInputStreamFactory.getInstance());
    }
}
