package com.obric.securitycenter.nodisturb.manager;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.obric.olog.OLog;
import com.obric.securitycenter.api.ApplicationContainer;
import com.obric.securitycenter.nodisturb.ProviderConstants;
import com.obric.securitycenter.nodisturb.utils.EncryptToMd5Kt;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: BlackListManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\b"}, d2 = {"Lcom/obric/securitycenter/nodisturb/manager/BlackListManager;", "", "()V", "isInBlackList", "", "targetPhone", "", "Companion", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BlackListManager {
    public static final Companion Companion = null;
    private static final String TAG = "BlackListManager";

    /* JADX INFO: compiled from: BlackListManager.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/securitycenter/nodisturb/manager/BlackListManager$Companion;", "", "()V", "TAG", "", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public BlackListManager() {
    }

    public final long isInBlackList(String r13) {
        Intrinsics.checkNotNullParameter(r13, "targetPhone");
        if (StringsKt.isBlank(r13) == false) goto L6;
        OLog.w(TAG, "isInBlackList skip: targetPhone is blank");
        return -1;
    L6:
        Context r1 = ApplicationContainer.INSTANCE.getApplication();
        if (r1 == null) goto L9;
        ContentResolver r6 = r1.getContentResolver();
    L10:
        if (r6 != null) goto L38;
        OLog.w(TAG, "isInBlackList skip: application or contentResolver is null");
        return -1;
    L38:
        Cursor r7 = r6.query(Uri.withAppendedPath(ProviderConstants.INSTANCE.getIN_BLACK_LIST_URI(), r13), new String[]{"_id"}, null, null, null);     // Catch: Exception -> L31
        if (r7 == null) goto L29;
        Cursor r8 = r7;     // Catch: Exception -> L31
        Cursor r12 = r8;     // Catch: Throwable -> L24
        if (r12.moveToFirst() == false) goto L21;
        long r0 = r12.getLong(r12.getColumnIndexOrThrow("_id"));     // Catch: Throwable -> L24
    L22:
        CloseableKt.closeFinally(r8, null);     // Catch: Exception -> L31
        return r0;
    L21:
        r0 = -1;
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        CloseableKt.closeFinally(r8, th);     // Catch: Exception -> L31
        throw th;     // Catch: Exception -> L31
    L29:
        BlackListManager r14 = this;     // Catch: Exception -> L31
        OLog.w(TAG, "isInBlackList query failed: cursor is null, targetMd5=" + EncryptToMd5Kt.calculateMD5(r13));     // Catch: Exception -> L31
        return -1;
    L31:
        e = move-exception;
        OLog.e(TAG, "isInBlackList query exception, targetMd5=" + EncryptToMd5Kt.calculateMD5(r13), e);
        return -1;
    L9:
        r6 = null;
        goto L10
    }
}
