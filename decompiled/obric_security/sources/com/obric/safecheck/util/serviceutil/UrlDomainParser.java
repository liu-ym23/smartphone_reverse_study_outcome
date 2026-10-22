package com.obric.safecheck.util.serviceutil;

import com.bytedance.librarian.LibrarianImpl;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: UrlDomainParser.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\u0006\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0003\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/obric/safecheck/util/serviceutil/UrlDomainParser;", "", "()V", "extractMainDomain", "", "host", "parseDomainFromUrl", "url", "", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class UrlDomainParser {
    public static final UrlDomainParser INSTANCE = null;

    static {
        INSTANCE = new UrlDomainParser();
    }

    private UrlDomainParser() {
    }

    public static /* synthetic */ String parseDomainFromUrl$default(UrlDomainParser r0, String r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        return r0.parseDomainFromUrl(r1, r2);
    }

    public final String parseDomainFromUrl(String r7, boolean r8) {
        String r0 = r7;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L13;
        return "";
    L13:
        if (StringsKt.startsWith$default(r7, "http://", false, 2, null) == false) goto L15;
    L26:
        String r9 = new URL(r7).getHost();     // Catch: MalformedURLException -> L23
        if (r8 == false) goto L21;
        Intrinsics.checkNotNullExpressionValue(r9, "host");     // Catch: MalformedURLException -> L23
        r9 = extractMainDomain(r9);     // Catch: MalformedURLException -> L23
    L21:
        Intrinsics.checkNotNullExpressionValue(r9, "if (extractMainDomain) {…       host\n            }");     // Catch: MalformedURLException -> L23
        return r9;
    L23:
        e = move-exception;
        e.printStackTrace();
        return "";
    L15:
        if (StringsKt.startsWith$default(r7, "https://", false, 2, null) == true) goto L26;
        r7 = "http://" + r7;
        goto L26
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L10
    }

    private final String extractMainDomain(String r10) {
        List r0 = StringsKt.split$default(r10, new String[]{LibrarianImpl.Constants.DOT}, false, 0, 6, null);
        if (r0.size() < 3) goto L8;
        if (CollectionsKt.listOf(new String[]{"com.cn", "net.cn", "org.cn", "gov.cn"}).contains(((String) r0.get(r0.size() - 2)) + LibrarianImpl.Constants.DOT + ((String) r0.get(r0.size() - 1))) == false) goto L8;
        return CollectionsKt.joinToString$default(CollectionsKt.takeLast(r0, 3), LibrarianImpl.Constants.DOT, null, null, 0, null, null, 62, null);
    L8:
        if (r0.size() >= 2) goto L10;
        return r10;
    L10:
        return CollectionsKt.joinToString$default(CollectionsKt.takeLast(r0, 2), LibrarianImpl.Constants.DOT, null, null, 0, null, null, 62, null);
    }
}
