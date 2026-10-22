package com.obric.securitycenter.nodisturb.sms.keyword;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.room.RoomDatabase;
import com.obric.securitycenter.nodisturb.ProviderConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.io.IOUtils;

/* JADX INFO: compiled from: SMSKeywordFilterViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0013J\u001c\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00130\u00052\u0006\u0010\u0011\u001a\u00020\fJ\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0011\u001a\u00020\fH\u0002J\u000e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\fJ\b\u0010\u001a\u001a\u00020\u0016H\u0014J\u000e\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\fJ\u0006\u0010\u001c\u001a\u00020\u0016R\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/obric/securitycenter/nodisturb/sms/keyword/SMSKeywordFilterViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "keywords", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/obric/securitycenter/nodisturb/sms/keyword/KeywordItem;", "getKeywords", "()Landroidx/lifecycle/MutableLiveData;", "observer", "Landroid/database/ContentObserver;", "observerResolver", "Landroid/content/ContentResolver;", "addKeywords", "Lcom/obric/securitycenter/nodisturb/sms/keyword/AddResult;", "input", "", "resolver", "maxLen", "", "maxCount", "deleteKeyword", "", "ids", "loadKeywords", "observeProvider", "onCleared", "refreshKeywords", "unobserveProvider", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SMSKeywordFilterViewModel extends ViewModel {
    private final MutableLiveData<List<KeywordItem>> keywords;
    private ContentObserver observer;
    private ContentResolver observerResolver;

    public SMSKeywordFilterViewModel() {
        this.keywords = new MutableLiveData();
    }

    public final MutableLiveData<List<KeywordItem>> getKeywords() {
        return this.keywords;
    }

    public final void refreshKeywords(ContentResolver r2) {
        Intrinsics.checkNotNullParameter(r2, "resolver");
        List<KeywordItem> r3 = loadKeywords(r2);
        this.keywords.setValue(r3);
    }

    private final List<KeywordItem> loadKeywords(ContentResolver r9) {
        ArrayList r8 = new ArrayList();
        String[] r4 = {"_id", ProviderConstants.KeyWord.KEYWORD};
        Cursor r10 = r9.query(ProviderConstants.INSTANCE.getKEYWORD_URI(), r4, null, null, "_id ASC");
        if (r10 == null) goto L20;
        Cursor r11 = r10;
        Cursor r2 = r11;     // Catch: Throwable -> L15
        int r0 = r2.getColumnIndex("_id");     // Catch: Throwable -> L15
        int r1 = r2.getColumnIndex(ProviderConstants.KeyWord.KEYWORD);     // Catch: Throwable -> L15
    L7:
        if (r2.moveToNext() == false) goto L13;
        int r3 = r2.getInt(r0);     // Catch: Throwable -> L15
        String r5 = r2.getString(r1);     // Catch: Throwable -> L15
        if (r5 != null) goto L11;
        r5 = "";
    L12:
        r8.add(new KeywordItem(r3, r5));     // Catch: Throwable -> L15
        goto L7
    L11:
        Intrinsics.checkNotNullExpressionValue(r5, "c.getString(kwIdx) ?: \"\"");     // Catch: Throwable -> L15
        goto L12
    L13:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L15
        CloseableKt.closeFinally(r11, null);
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);
        throw th;
    L20:
        return r8;
    }

    public static /* synthetic */ AddResult addKeywords$default(SMSKeywordFilterViewModel r0, String r1, ContentResolver r2, int r3, int r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = 15;
    L6:
        if ((r5 & 8) == 0) goto L9;
        r4 = RoomDatabase.MAX_BIND_PARAMETER_CNT;
    L9:
        return r0.addKeywords(r1, r2, r3, r4);
    }

    public final AddResult addKeywords(String r10, ContentResolver r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "input");
        Intrinsics.checkNotNullParameter(r11, "resolver");
        List<KeywordItem> r0 = this.keywords.getValue();
        if (r0 == null) goto L10;
        List<KeywordItem> r1 = r0;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r3 = r1.iterator();
    L6:
        if (r3.hasNext() == false) goto L8;
        r2.add(((KeywordItem) r3.next()).getText());
        goto L6
    L8:
        LinkedHashSet r4 = CollectionsKt.toMutableSet(r2);
        if (r4 == null) goto L10;
    L11:
        List r14 = StringsKt.split$default(r10, new String[]{" ", "，", ",", IOUtils.LINE_SEPARATOR_UNIX}, false, 0, 6, null);
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator r15 = r14.iterator();
    L13:
        if (r15.hasNext() == false) goto L15;
        r5.add(StringsKt.trim((String) r15.next()).toString());
        goto L13
    L15:
        ArrayList r16 = new ArrayList();
        Iterator r6 = r5.iterator();
    L16:
        boolean r7 = true;
        if (r6.hasNext() == false) goto L24;
        Object r8 = r6.next();
        if (((String) r8).length() > 0) goto L22;
        r7 = false;
    L22:
        if (r7 == false) goto L16;
        r16.add(r8);
        goto L16
    L24:
        ArrayList r17 = r16;
        ArrayList r9 = new ArrayList();
        ArrayList r18 = new ArrayList();
        List<KeywordItem> r19 = this.keywords.getValue();
        if (r19 == null) goto L27;
        int r20 = r19.size();
    L28:
        Iterator r110 = r17.iterator();
    L30:
        if (r110.hasNext() == false) goto L42;
        String r21 = (String) r110.next();
        if (r20 >= r13) goto L42;
        if (r21.length() > r12) goto L35;
        if (r4.contains(r21) == true) goto L38;
        ContentValues r22 = new ContentValues();
        r22.put(ProviderConstants.KeyWord.KEYWORD, r21);
        if (r11.insert(ProviderConstants.INSTANCE.getKEYWORD_URI(), r22) == null) goto L30;
        r4.add(r21);
        r20 = r20 + 1;
        goto L30
    L38:
        r18.add(r21);
        goto L30
    L35:
        r9.add(r21);
    L42:
        refreshKeywords(r11);
        if (r20 >= r13) goto L47;
        r7 = false;
    L47:
        return new AddResult(r9, r18, r7);
    L27:
        r20 = 0;
    L10:
        r4 = new LinkedHashSet();
        goto L11
    }

    public final void deleteKeyword(List<Integer> r11, ContentResolver r12) {
        Intrinsics.checkNotNullParameter(r11, "ids");
        Intrinsics.checkNotNullParameter(r12, "resolver");
        List<Integer> r13 = r11;
        String r0 = "_id IN (" + CollectionsKt.joinToString$default(r13, ",", null, null, 0, null, SMSKeywordFilterViewModel$deleteKeyword$where$1.INSTANCE, 30, null) + ")";
        Uri r1 = ProviderConstants.INSTANCE.getKEYWORD_URI();
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator<T> r14 = r13.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        r2.add(String.valueOf(((Number) r14.next()).intValue()));
        goto L4
    L6:
        r12.delete(r1, r0, (String[]) r2.toArray(new String[0]));
        refreshKeywords(r12);
    }

    public final void observeProvider(final ContentResolver r3) {
        Intrinsics.checkNotNullParameter(r3, "resolver");
        if (this.observer == null) goto L5;
        return;
    L5:
        this.observerResolver = r3;
        final Handler r0 = new Handler(Looper.getMainLooper());
        this.observer = new AnonymousClass1(this, r3, r0);
        Uri r1 = ProviderConstants.INSTANCE.getKEYWORD_URI();
        ContentObserver r2 = this.observer;
        Intrinsics.checkNotNull(r2);
        r3.registerContentObserver(r1, true, r2);
    }

    public final void unobserveProvider() {
        ContentResolver r0 = this.observerResolver;
        ContentObserver r1 = this.observer;
        if (r0 == null) goto L6;
        if (r1 == null) goto L6;
        r0.unregisterContentObserver(r1);
    L6:
        this.observer = null;
        this.observerResolver = null;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        unobserveProvider();
        super.onCleared();
    }
}
