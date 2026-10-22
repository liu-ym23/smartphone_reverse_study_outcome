package cz.msebera.android.httpclient.client.cache;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public interface ResourceFactory {
    Resource copy(String r1, Resource r2) throws IOException;

    Resource generate(String r1, InputStream r2, InputLimit r3) throws IOException;
}
