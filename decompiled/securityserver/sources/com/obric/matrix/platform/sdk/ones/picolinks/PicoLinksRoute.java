package com.obric.matrix.platform.sdk.ones.picolinks;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.bytedance.librarian.LibrarianImpl;
import com.obric.matrix.proto.MATRIX_CMD;
import com.obric.matrix.proto.PicoLinksCallback;
import com.obric.matrix.proto.Request;
import com.obric.matrix.proto.RequestBody;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class PicoLinksRoute {

    @NotNull
    public static final PicoLinksRoute INSTANCE = null;

    @NotNull
    private static final String PICO_LINKS_ID = "pico_links_id";

    @NotNull
    private static final String PICO_LINKS_URL = "pico_links_url";

    @NotNull
    private static final String TAG = "PicoLinksRoute";

    @Metadata
    public static final class Context {

        @NotNull
        private final Activity activity;
        private final int callbackId;

        @NotNull
        private final Uri url;

        public Context(@NotNull Activity r2, @NotNull Uri r3, int r4) {
            Intrinsics.f(r2, "activity");
            Intrinsics.f(r3, "url");
            this.activity = r2;
            this.url = r3;
            this.callbackId = r4;
        }

        @NotNull
        public final Activity getActivity() {
            return this.activity;
        }

        @NotNull
        public final Uri getUrl() {
            return this.url;
        }

        public final void setResult(@NotNull Map<String, String> r8) {
            Intrinsics.f(r8, "data");
            PicoLinksCallback r7 = new PicoLinksCallback.Builder().callbackId(Integer.valueOf(this.callbackId)).callbackData(r8).build();
            Request.Builder r9 = new Request.Builder();
            MATRIX_CMD r1 = MATRIX_CMD.CMD_PRIVATE_PICO_LINKS_CALLBACK;
            Request r2 = r9.cmd(Integer.valueOf(r1.getValue())).body(new RequestBody.Builder().picoLinksCallback(r7).build()).build();
            PicoLinksBroker r0 = PicoLinksBroker.INSTANCE;     // Catch: Throwable -> L5
            Intrinsics.e(r2, "request");     // Catch: Throwable -> L5
            PicoLinksBroker.sendCmd$default(r0, r1, r2, false, null, 12, null);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            Log.w(PicoLinksRoute.TAG, th);
        }
    }

    @Metadata
    public interface Handler {
        void handlePicoLinks(@NotNull Context r1, @NotNull String r2, @NotNull Bundle r3);
    }

    static {
        INSTANCE = new PicoLinksRoute();
    }

    private PicoLinksRoute() {
    }

    public static /* synthetic */ void a(String r0, Bundle r1, Handler r2, Activity r3, Uri r4, int r5) {
        m35processPicoLinksIntent$lambda3(r0, r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: processPicoLinksIntent$lambda-3, reason: not valid java name */
    private static final void m35processPicoLinksIntent$lambda3(String r3, Bundle r4, Handler r5, Activity r6, Uri r7, int r8) {
        Intrinsics.f(r3, "$path");
        Intrinsics.f(r4, "$params");
        Intrinsics.f(r5, "$handler");
        Intrinsics.f(r6, "$activity");
        Log.d(TAG, "handlePicoLinks, path=" + r3 + ", params=" + r4);     // Catch: Throwable -> L5
        r5.handlePicoLinks(new Context(r6, r7, r8), r3, r4);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Log.w(TAG, th);
    }

    public final boolean processPicoLinksIntent(@NotNull final Activity r10, @Nullable Intent r11, @NotNull final Handler r12) {
        Intrinsics.f(r10, "activity");
        Intrinsics.f(r12, "handler");
        if (r11 != null) goto L6;
        Log.w(TAG, "intent is null");
        return false;
    L6:
        final Uri r7 = (Uri) r11.getParcelableExtra(PICO_LINKS_URL);
        final int r8 = r11.getIntExtra(PICO_LINKS_ID, 0);
        if (r7 != null) goto L11;
        Log.w(TAG, "url is null");
        return false;
    L11:
        if (PicoLinksHook.INSTANCE.isPicoLinksUrl(r7) == true) goto L14;
        Log.w(TAG, "is no PicoLinks url");
        return false;
    L14:
        List<String> r9 = r7.getPathSegments();
        Intrinsics.e(r9, "url.pathSegments");
        ArrayList r1 = CollectionsKt.r(r9);
        if (r1.isEmpty() == true) goto L19;
        r1.remove(0);
    L19:
        if (r1.isEmpty() == true) goto L22;
        r1.remove(0);
    L22:
        final String r3 = CollectionsKt.i(r1, LibrarianImpl.Constants.SEPARATOR, null, null, null, 62);
        final Bundle r4 = new Bundle();
        String r13 = r7.getQueryParameter("params");
        if (r13 == null) goto L37;
        JSONObject r14 = new JSONObject(r13);
        Iterator<String> r15 = r14.keys();
        Intrinsics.e(r15, "jsonParams.keys()");
    L26:
        if (r15.hasNext() == false) goto L37;
        String r0 = r15.next();
        Object r2 = r14.get(r0);
        if ((r2 instanceof Integer) == true) goto L29;
        if ((r2 instanceof Boolean) == true) goto L32;
        if ((r2 instanceof String) == true) goto L35;
        r4.putString(r0, r2.toString());
        goto L26
    L35:
        r4.putString(r0, (String) r2);
        goto L26
    L32:
        r4.putBoolean(r0, ((Boolean) r2).booleanValue());
        goto L26
    L29:
        r4.putInt(r0, ((Number) r2).intValue());
    L37:
        new android.os.Handler(Looper.getMainLooper()).post(new a(r3, r4, r12, r10, r7, r8));
        return true;
    }
}
