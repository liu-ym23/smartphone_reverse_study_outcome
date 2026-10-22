package cz.msebera.android.httpclient.conn.util;

import com.android.vcard.VCardConstants;
import cz.msebera.android.httpclient.Consts;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.util.Args;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public final class PublicSuffixMatcherLoader {
    private static volatile PublicSuffixMatcher DEFAULT_INSTANCE;

    public PublicSuffixMatcherLoader() {
    }

    private static PublicSuffixMatcher load(InputStream r3) throws IOException {
        return new PublicSuffixMatcher(new PublicSuffixListParser().parseByType(new InputStreamReader(r3, Consts.UTF_8)));
    }

    public static PublicSuffixMatcher load(URL r1) throws IOException {
        Args.notNull(r1, VCardConstants.PROPERTY_URL);
        InputStream r2 = r1.openStream();
        PublicSuffixMatcher r0 = load(r2);     // Catch: Throwable -> L6
        r2.close();
        return r0;
    L6:
        th = move-exception;
        r2.close();
        throw th;
    }

    public static PublicSuffixMatcher load(File r1) throws IOException {
        Args.notNull(r1, "File");
        FileInputStream r0 = new FileInputStream(r1);
        PublicSuffixMatcher r2 = load(r0);     // Catch: Throwable -> L6
        r0.close();
        return r2;
    L6:
        th = move-exception;
        r0.close();
        throw th;
    }

    public static PublicSuffixMatcher getDefault() {
        if (DEFAULT_INSTANCE != null) goto L23;
        monitor-enter(PublicSuffixMatcherLoader.class);
    L19:
        th = move-exception;
        throw th;
    L7:
        if (DEFAULT_INSTANCE != null) goto L17;
        URL r1 = PublicSuffixMatcherLoader.class.getResource("/mozilla/public-suffix-list.txt");     // Catch: Throwable -> L19
        if (r1 != null) goto L26;
        DEFAULT_INSTANCE = new PublicSuffixMatcher(Arrays.asList(new String[]{"com"}), null);     // Catch: Throwable -> L19
        goto L17
    L26:
        DEFAULT_INSTANCE = load(r1);     // Catch: IOException -> L12 Throwable -> L19
    L12:
        e = move-exception;
        HttpClientAndroidLog r2 = new HttpClientAndroidLog(PublicSuffixMatcherLoader.class);     // Catch: Throwable -> L19
        if (r2.isWarnEnabled() == false) goto L17;
        r2.warn("Failure loading public suffix list from default resource", e);     // Catch: Throwable -> L19
    L17:
        monitor-exit(PublicSuffixMatcherLoader.class);     // Catch: Throwable -> L19
    L23:
        return DEFAULT_INSTANCE;
    }
}
