package d.c.c.f;

import android.webkit.MimeTypeMap;
import d.c.c.d.f;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final MimeTypeMap f15392a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, String> f15393b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<String, String> f15394c = null;

    static {
        f15392a = MimeTypeMap.getSingleton();
        f15393b = f.of("image/heif", "heif", "image/heic", "heic");
        f15394c = f.of("heif", "image/heif", "heic", "image/heic");
    }

    public static String a(String r1) {
        String r0 = f15394c.get(r1);
        if (r0 == null) goto L6;
        return r0;
    L6:
        return f15392a.getMimeTypeFromExtension(r1);
    }
}
