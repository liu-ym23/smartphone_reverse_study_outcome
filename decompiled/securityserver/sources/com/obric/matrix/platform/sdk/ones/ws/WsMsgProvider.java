package com.obric.matrix.platform.sdk.ones.ws;

import a.a;
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
import com.obric.matrix.platform.sdk.ones.MatrixOnesSdk;
import com.obric.matrix.platform.sdk.ones.internal.util.MLog;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class WsMsgProvider extends ContentProvider {

    @NotNull
    private static final String AUTHORITY_PRE = "com.obric.matrix.platform.sdk.ones.provider";

    @NotNull
    public static final Companion Companion = null;

    @NotNull
    private static final String DOT = ".";

    @NotNull
    private static final String TAG = "WsMsgProvider";

    @NotNull
    private static final String WS_MSG = "ws_msg";

    @NotNull
    private static final String WS_MSG_KEY_CHANNEL_ID = "channel_id";

    @NotNull
    private static final String WS_MSG_KEY_HEADERS = "ws_headers";

    @NotNull
    private static final String WS_MSG_KEY_LOG_ID = "log_id";

    @NotNull
    private static final String WS_MSG_KEY_METHOD = "method";

    @NotNull
    private static final String WS_MSG_KEY_PAYLOAD = "payload";

    @NotNull
    private static final String WS_MSG_KEY_PAYLOAD_ENCODING = "payload_encoding";

    @NotNull
    private static final String WS_MSG_KEY_PAYLOAD_TYPE = "payload_type";

    @NotNull
    private static final String WS_MSG_KEY_SEQ_ID = "seq_id";

    @NotNull
    private static final String WS_MSG_KEY_SERVICE = "service";

    @NotNull
    private UriMatcher mMatcher;

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public WsMsgProvider() {
        this.mMatcher = new UriMatcher(-1);
    }

    private final void logProxy(String r3) {
        if (MatrixOnesSdk.INSTANCE.getBridge$sdk_platform_ones_release() == null) goto L5;
        MLog.d$default(TAG, r3, null, 4, null);
        return;
    L5:
        Log.d(TAG, r3);
    }

    @Override // android.content.ContentProvider
    public int delete(@NotNull Uri r1, @Nullable String r2, @Nullable String[] r3) {
        Intrinsics.f(r1, "uri");
        return 0;
    }

    @NotNull
    public final UriMatcher getMMatcher() {
        return this.mMatcher;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NotNull Uri r1) {
        Intrinsics.f(r1, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NotNull Uri r1, @Nullable ContentValues r2) {
        Intrinsics.f(r1, "uri");
        return null;
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
        r1.append(r4);
        r0.addURI(r1.toString(), WS_MSG, 1);
        return true;
    L5:
        r4 = null;
        goto L6
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NotNull Uri r17, @Nullable String[] r18, @Nullable Bundle r19, @Nullable CancellationSignal r20) {
        Intrinsics.f(r17, "uri");
        logProxy("query() called with:  queryArgs = " + r19 + ", uri = " + r17 + ", projection = " + r18 + ", cancellationSignal = " + r20 + ", callingPackage = " + getCallingPackage());
        String r3 = getCallingPackage();
        byte[] r4 = null;
        if (r3 != null) goto L5;
        return null;
    L5:
        if (r3.length() != 0) goto L8;
        return null;
    L8:
        if (Intrinsics.a(getCallingPackage(), "com.obric.matrix") == true) goto L11;
        return null;
    L11:
        if (this.mMatcher.match(r17) == 1) goto L13;
        return null;
    L13:
        if (r19 == null) goto L15;
        Integer r1 = Integer.valueOf(r19.getInt("channel_id", 0));
    L17:
        if (r19 == null) goto L19;
        Long r5 = Long.valueOf(r19.getLong(WS_MSG_KEY_SEQ_ID, 0));
    L20:
        if (r19 == null) goto L22;
        Long r6 = Long.valueOf(r19.getLong("log_id", 0));
    L23:
        if (r19 == null) goto L25;
        Integer r7 = Integer.valueOf(r19.getInt("service", 0));
    L26:
        if (r19 == null) goto L28;
        Integer r0 = Integer.valueOf(r19.getInt(WS_MSG_KEY_METHOD, 0));
    L30:
        if (r19 == null) goto L32;
        Serializable r8 = r19.getSerializable(WS_MSG_KEY_HEADERS);
    L33:
        if (r8 == null) goto L41;
        if (r19 == null) goto L36;
        Serializable r9 = r19.getSerializable(WS_MSG_KEY_HEADERS);
    L37:
        if (r9 == null) goto L40;
        HashMap<String, String> r13 = (HashMap) r9;
    L42:
        if (r19 == null) goto L44;
        String r11 = r19.getString(WS_MSG_KEY_PAYLOAD_TYPE);
    L45:
        if (r19 == null) goto L47;
        String r10 = r19.getString(WS_MSG_KEY_PAYLOAD_ENCODING);
    L48:
        if (r19 == null) goto L50;
        r4 = r19.getByteArray("payload");
    L50:
        MatrixWsHelper r2 = MatrixWsHelper.INSTANCE;
        Intrinsics.c(r1);
        int r12 = r1.intValue();
        Intrinsics.c(r5);
        long r14 = r5.longValue();
        Intrinsics.c(r6);
        long r15 = r6.longValue();
        Intrinsics.c(r7);
        int r16 = r7.intValue();
        Intrinsics.c(r0);
        r2.onWsMsgReceivedByProvider$sdk_platform_ones_release(r12, r14, r15, r16, r0.intValue(), r10, r11, r4, r13);
        MatrixCursor r21 = new MatrixCursor(new String[]{"received"});
        r21.addRow(new String[]{"true"});
        return r21;
    L47:
        r10 = null;
        goto L48
    L44:
        r11 = null;
        goto L45
    L40:
        throw new NullPointerException("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.String> }");
    L36:
        r9 = null;
        goto L37
    L41:
        r13 = null;
        goto L42
    L32:
        r8 = null;
        goto L33
    L28:
        r0 = null;
        goto L30
    L25:
        r7 = null;
        goto L26
    L22:
        r6 = null;
        goto L23
    L19:
        r5 = null;
        goto L20
    L15:
        r1 = null;
        goto L17
    }

    public final void setMMatcher(@NotNull UriMatcher r2) {
        Intrinsics.f(r2, "<set-?>");
        this.mMatcher = r2;
    }

    @Override // android.content.ContentProvider
    public int update(@NotNull Uri r1, @Nullable ContentValues r2, @Nullable String r3, @Nullable String[] r4) {
        Intrinsics.f(r1, "uri");
        return 0;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NotNull Uri r3, @Nullable String[] r4, @Nullable String r5, @Nullable String[] r6, @Nullable String r7) {
        Intrinsics.f(r3, "uri");
        StringBuilder r0 = new StringBuilder("query() called with: uri = ");
        r0.append(r3);
        r0.append(", projection = ");
        r0.append(r4);
        r0.append(", selection = ");
        r0.append(r5);
        r0.append(", selectionArgs = ");
        r0.append(r6);
        logProxy(a.o(r0, ", sortOrder = ", r7));
        return null;
    }
}
