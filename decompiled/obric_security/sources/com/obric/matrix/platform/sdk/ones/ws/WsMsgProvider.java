package com.obric.matrix.platform.sdk.ones.ws;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.bytedanceos.utils.Constants;
import com.obric.matrix.platform.sdk.ones.MatrixOnesSdk;
import com.obric.matrix.platform.sdk.ones.internal.util.MLog;
import com.obric.security.health.score.HealthModuleIds;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WsMsgProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001'B\u0005¢\u0006\u0002\u0010\u0002J1\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0010\u0010\u000f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000e\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\u0013\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000eH\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J=\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u000b\u001a\u00020\f2\u0010\u0010\u001d\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000e\u0018\u00010\u00102\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0002\u0010\"JO\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u000b\u001a\u00020\f2\u0010\u0010\u001d\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000e\u0018\u00010\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0010\u0010\u000f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000e\u0018\u00010\u00102\b\u0010#\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0002\u0010$J;\u0010%\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0010\u0010\u000f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000e\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010&R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006("}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/ws/WsMsgProvider;", "Landroid/content/ContentProvider;", "()V", "mMatcher", "Landroid/content/UriMatcher;", "getMMatcher", "()Landroid/content/UriMatcher;", "setMMatcher", "(Landroid/content/UriMatcher;)V", "delete", "", "uri", "Landroid/net/Uri;", "selection", "", "selectionArgs", "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "getType", "insert", "values", "Landroid/content/ContentValues;", "logProxy", "", NotificationCompat.CATEGORY_MESSAGE, "onCreate", "", "query", "Landroid/database/Cursor;", "projection", "queryArgs", "Landroid/os/Bundle;", "cancellationSignal", "Landroid/os/CancellationSignal;", "(Landroid/net/Uri;[Ljava/lang/String;Landroid/os/Bundle;Landroid/os/CancellationSignal;)Landroid/database/Cursor;", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", HealthModuleIds.UPDATE, "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "Companion", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WsMsgProvider extends ContentProvider {
    private static final String AUTHORITY_PRE = "com.obric.matrix.platform.sdk.ones.provider";
    public static final Companion Companion = null;
    private static final String DOT = ".";
    private static final String TAG = "WsMsgProvider";
    private static final String WS_MSG = "ws_msg";
    private static final String WS_MSG_KEY_CHANNEL_ID = "channel_id";
    private static final String WS_MSG_KEY_HEADERS = "ws_headers";
    private static final String WS_MSG_KEY_LOG_ID = "log_id";
    private static final String WS_MSG_KEY_METHOD = "method";
    private static final String WS_MSG_KEY_PAYLOAD = "payload";
    private static final String WS_MSG_KEY_PAYLOAD_ENCODING = "payload_encoding";
    private static final String WS_MSG_KEY_PAYLOAD_TYPE = "payload_type";
    private static final String WS_MSG_KEY_SEQ_ID = "seq_id";
    private static final String WS_MSG_KEY_SERVICE = "service";
    private UriMatcher mMatcher;

    /* JADX INFO: compiled from: WsMsgProvider.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/ws/WsMsgProvider$Companion;", "", "()V", "AUTHORITY_PRE", "", "DOT", "TAG", "WS_MSG", "WS_MSG_KEY_CHANNEL_ID", "WS_MSG_KEY_HEADERS", "WS_MSG_KEY_LOG_ID", "WS_MSG_KEY_METHOD", "WS_MSG_KEY_PAYLOAD", "WS_MSG_KEY_PAYLOAD_ENCODING", "WS_MSG_KEY_PAYLOAD_TYPE", "WS_MSG_KEY_SEQ_ID", "WS_MSG_KEY_SERVICE", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    @Override // android.content.ContentProvider
    public int delete(Uri r1, String r2, String[] r3) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r1) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r1, ContentValues r2) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return 0;
    }

    public WsMsgProvider() {
        this.mMatcher = new UriMatcher(-1);
    }

    public final UriMatcher getMMatcher() {
        return this.mMatcher;
    }

    public final void setMMatcher(UriMatcher r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mMatcher = r2;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        logProxy("onCreate() called");
        UriMatcher r0 = this.mMatcher;
        StringBuilder r1 = new StringBuilder("com.obric.matrix.platform.sdk.ones.provider.");
        Context r3 = getContext();
        if (r3 == null) goto L5;
        String r4 = r3.getPackageName();
    L6:
        r0.addURI(r1.append(r4).toString(), WS_MSG, 1);
        return true;
    L5:
        r4 = null;
        goto L6
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r21, String[] r22, Bundle r23, CancellationSignal r24) {
        Intrinsics.checkNotNullParameter(r21, "uri");
        logProxy("query() called with:  queryArgs = " + r23 + ", uri = " + r21 + ", projection = " + r22 + ", cancellationSignal = " + r24 + ", callingPackage = " + getCallingPackage());
        String r3 = getCallingPackage();
        if (r3 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        byte[] r6 = null;
        if (r4 == false) goto L12;
        return null;
    L12:
        if (Intrinsics.areEqual(getCallingPackage(), "com.obric.matrix") == true) goto L15;
        return null;
    L15:
        if (this.mMatcher.match(r21) != 1) goto L56;
        if (r23 == null) goto L18;
        Integer r0 = Integer.valueOf(r23.getInt("channel_id", 0));
    L20:
        if (r23 == null) goto L22;
        Long r1 = Long.valueOf(r23.getLong(WS_MSG_KEY_SEQ_ID, 0));
    L23:
        if (r23 == null) goto L25;
        Long r5 = Long.valueOf(r23.getLong("log_id", 0));
    L26:
        if (r23 == null) goto L28;
        Integer r7 = Integer.valueOf(r23.getInt("service", 0));
    L29:
        if (r23 == null) goto L31;
        Integer r8 = Integer.valueOf(r23.getInt(WS_MSG_KEY_METHOD, 0));
    L33:
        if (r23 == null) goto L35;
        Serializable r9 = r23.getSerializable(WS_MSG_KEY_HEADERS);
    L36:
        if (r9 == null) goto L44;
        if (r23 == null) goto L39;
        Serializable r10 = r23.getSerializable(WS_MSG_KEY_HEADERS);
    L40:
        if (r10 == null) goto L43;
        HashMap<String, String> r19 = (HashMap) r10;
    L45:
        if (r23 == null) goto L47;
        String r17 = r23.getString(WS_MSG_KEY_PAYLOAD_TYPE);
    L48:
        if (r23 == null) goto L50;
        String r16 = r23.getString(WS_MSG_KEY_PAYLOAD_ENCODING);
    L51:
        if (r23 == null) goto L53;
        r6 = r23.getByteArray("payload");
    L53:
        MatrixWsHelper r11 = MatrixWsHelper.INSTANCE;
        Intrinsics.checkNotNull(r0);
        int r12 = r0.intValue();
        Intrinsics.checkNotNull(r1);
        long r13 = r1.longValue();
        Intrinsics.checkNotNull(r5);
        long r14 = r5.longValue();
        Intrinsics.checkNotNull(r7);
        int r15 = r7.intValue();
        Intrinsics.checkNotNull(r8);
        r11.onWsMsgReceivedByProvider$sdk_platform_ones_release(r12, r13, r14, r15, r8.intValue(), r16, r17, r6, r19);
        MatrixCursor r18 = new MatrixCursor(new String[]{"received"});
        r18.addRow(new String[]{Constants.IS_SET});
        return r18;
    L50:
        r16 = null;
        goto L51
    L47:
        r17 = null;
        goto L48
    L43:
        throw new NullPointerException("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.String> }");
    L39:
        r10 = null;
        goto L40
    L44:
        HashMap r20 = (HashMap) null;
        r19 = null;
        goto L45
    L35:
        r9 = null;
        goto L36
    L31:
        r8 = null;
        goto L33
    L28:
        r7 = null;
        goto L29
    L25:
        r5 = null;
        goto L26
    L22:
        r1 = null;
        goto L23
    L18:
        r0 = null;
        goto L20
    L56:
        return null;
    L5:
        if (r3.length() == 0) goto L8;
        r4 = false;
        goto L9
    }

    private final void logProxy(String r3) {
        if (MatrixOnesSdk.INSTANCE.getBridge$sdk_platform_ones_release() == null) goto L5;
        boolean r2 = true;
    L7:
        if (r2 == false) goto L9;
        MLog.d$default(TAG, r3, null, 4, null);
        return;
    L9:
        Log.d(TAG, r3);
        return;
    L5:
        r2 = false;
        goto L7
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r3, String[] r4, String r5, String[] r6, String r7) {
        Intrinsics.checkNotNullParameter(r3, "uri");
        logProxy("query() called with: uri = " + r3 + ", projection = " + r4 + ", selection = " + r5 + ", selectionArgs = " + r6 + ", sortOrder = " + r7);
        return null;
    }
}
