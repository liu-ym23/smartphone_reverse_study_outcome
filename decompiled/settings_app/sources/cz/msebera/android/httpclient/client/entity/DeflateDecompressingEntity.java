package cz.msebera.android.httpclient.client.entity;

import cz.msebera.android.httpclient.HttpEntity;

/* JADX INFO: loaded from: classes5.dex */
public class DeflateDecompressingEntity extends DecompressingEntity {
    public DeflateDecompressingEntity(HttpEntity r2) {
        super(r2, DeflateInputStreamFactory.getInstance());
    }
}
