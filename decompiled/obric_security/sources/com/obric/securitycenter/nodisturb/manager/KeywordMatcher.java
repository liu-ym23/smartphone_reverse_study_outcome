package com.obric.securitycenter.nodisturb.manager;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import com.obric.securitycenter.api.ApplicationContainer;
import com.obric.securitycenter.nodisturb.ProviderConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: KeywordMatcher.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007J\u0006\u0010\u000f\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/securitycenter/nodisturb/manager/KeywordMatcher;", "", "()V", "isInit", "", "keywordList", "", "", "init", "", "contentResolver", "Landroid/content/ContentResolver;", "loadKeywordsFromDB", "matchFirst", "smsContent", "reset", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KeywordMatcher {
    private boolean isInit;
    private List<String> keywordList;

    public KeywordMatcher() {
        this.keywordList = CollectionsKt.emptyList();
    }

    public final void init(ContentResolver r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        List<String> r6 = loadKeywordsFromDB(r5);
        ArrayList r0 = new ArrayList();
        Iterator<T> r7 = r6.iterator();
    L6:
        if (r7.hasNext() == false) goto L10;
        Object r1 = r7.next();
        if ((true ^ StringsKt.isBlank((String) r1)) == false) goto L6;
        r0.add(r1);
        goto L6
    L10:
        ArrayList r2 = r0;
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r3 = r2.iterator();
    L12:
        if (r3.hasNext() == false) goto L14;
        String r4 = ((String) r3.next()).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r4, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        r8.add(r4);
        goto L12
    L14:
        this.keywordList = r8;
        this.isInit = true;
    }

    public final String matchFirst(String r8) {
        Intrinsics.checkNotNullParameter(r8, "smsContent");
        Context r0 = ApplicationContainer.INSTANCE.getApplication();
        if (r0 == null) goto L5;
        ContentResolver r1 = r0.getContentResolver();
    L6:
        init(r1);
        if (this.keywordList.isEmpty() == false) goto L9;
    L17:
        return "";
    L9:
        if (StringsKt.isBlank(r8) == true) goto L17;
        String r9 = r8.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r9, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        Iterator<String> r7 = this.keywordList.iterator();
    L13:
        if (r7.hasNext() == false) goto L17;
        String r2 = r7.next();
        if (StringsKt.contains$default(r9, r2, false, 2, null) == false) goto L13;
        return r2;
    L5:
        r1 = null;
        goto L6
    }

    private final List<String> loadKeywordsFromDB(ContentResolver r8) {
        ArrayList r7 = new ArrayList();
        Cursor r9 = r8.query(ProviderConstants.INSTANCE.getKEYWORD_URI(), new String[]{ProviderConstants.KeyWord.KEYWORD}, null, null, null);
        if (r9 == null) goto L16;
        Cursor r10 = r9;
        Cursor r1 = r10;     // Catch: Throwable -> L11
    L7:
        if (r1.moveToNext() == false) goto L9;
        String r2 = r1.getString(r1.getColumnIndexOrThrow(ProviderConstants.KeyWord.KEYWORD));     // Catch: Throwable -> L11
        Intrinsics.checkNotNullExpressionValue(r2, "keyword");     // Catch: Throwable -> L11
        r7.add(r2);     // Catch: Throwable -> L11
        goto L7
    L9:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L11
        CloseableKt.closeFinally(r10, null);
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);
        throw th;
    L16:
        return r7;
    }

    public final void reset() {
        this.isInit = false;
        this.keywordList = CollectionsKt.emptyList();
    }
}
