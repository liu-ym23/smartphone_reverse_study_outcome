package com.obric.matrix.platform.sdk.ones.picolinks;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.obric.matrix.proto.MATRIX_CMD;
import com.obric.matrix.proto.Request;
import com.obric.matrix.proto.RequestBody;
import com.obric.matrix.proto.Response;
import com.obric.matrix.proto.StartPicoLinksRequest;
import com.obric.matrix.proto.StatusCode;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class PicoLinksHook {

    @NotNull
    public static final PicoLinksHook INSTANCE = null;

    @NotNull
    private static final String PATH_PICO_LINKS = "picolinks";

    @NotNull
    private static final String PHASE_DATA_KEY_REDIRECT_URL = "redirectUrl";

    @NotNull
    private static final String SCHEME_HTTP = "http";

    @NotNull
    private static final String SCHEME_HTTPS = "https";

    @NotNull
    private static final String SCHEME_PICO_LINKS = "picolinks";

    @NotNull
    private static final String TAG = "PicoLinksHook";

    @Metadata
    public interface Callback {

        @Metadata
        public static final class DefaultImpls {
            public static void onRedirect(@NotNull Callback r0, @NotNull String r1) {
                Intrinsics.f(r1, "url");
            }

            public static void onResult(@NotNull Callback r0, @NotNull Map<String, String> r1) {
                Intrinsics.f(r1, "data");
            }
        }

        void onRedirect(@NotNull String r1);

        void onResult(@NotNull Map<String, String> r1);
    }

    static {
        INSTANCE = new PicoLinksHook();
    }

    private PicoLinksHook() {
    }

    private final boolean invokeStartPicoLinks(StartPicoLinksRequest.SCENE r3, String r4, String r5, final Callback r6, boolean r7) {
        if (isPicoLinksUrl(r4) == true) goto L6;
        Log.e(TAG, r4 + " is not PicoLinks");
        return false;
    L6:
        StartPicoLinksRequest r2 = new StartPicoLinksRequest.Builder().scene(r3).referrer(r5).targetUrl(r4).build();
        Request.Builder r8 = new Request.Builder();
        MATRIX_CMD r9 = MATRIX_CMD.CMD_PRIVATE_START_PICO_LINKS;
        Request r10 = r8.cmd(Integer.valueOf(r9.getValue())).body(new RequestBody.Builder().startPicoLinksRequest(r2).build()).build();
        final Ref.ObjectRef r11 = new Ref.ObjectRef();
        PicoLinksBroker r12 = PicoLinksBroker.INSTANCE;
        Intrinsics.e(r10, "request");
        r12.sendCmd(r9, r10, r7, new AnonymousClass1(r11, r6));
        Response r13 = (Response) r11.b;
        if (r13 == null) goto L15;
        Integer r14 = r13.statusCode;
        int r15 = StatusCode.OK.getValue();
        if (r14 != null) goto L12;
        return false;
    L12:
        if (r14.intValue() != r15) goto L16;
        return true;
    L16:
        return false;
    L15:
        return false;
    }

    public static /* synthetic */ boolean shouldOverrideUrlLoading$default(PicoLinksHook r0, Context r1, String r2, String r3, Callback r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L6;
        r4 = null;
    L6:
        return r0.shouldOverrideUrlLoading(r1, r2, r3, r4);
    }

    public static /* synthetic */ boolean startPicoLinks$default(PicoLinksHook r0, Context r1, String r2, Callback r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = null;
    L6:
        return r0.startPicoLinks(r1, r2, r3);
    }

    public final void init(@NotNull Context r1) {
        Intrinsics.f(r1, "context");
    }

    public final boolean isPicoLinksUrl(@Nullable String r2) {
        if (r2 != null) goto L4;
        return false;
    L4:
        if (r2.length() == 0) goto L10;
        Uri r3 = Uri.parse(r2);
        Intrinsics.e(r3, "parse(url)");
        return isPicoLinksUrl(r3);
    L10:
        return false;
    }

    public final boolean shouldOverrideUrlLoading(@NotNull Context r9, @Nullable String r10, @Nullable String r11, @Nullable Callback r12) {
        Intrinsics.f(r9, "context");
        long r0 = System.currentTimeMillis();
        boolean r8 = invokeStartPicoLinks(StartPicoLinksRequest.SCENE.BROWSER, r10, r11, r12, true);
        Log.d(TAG, "shouldOverrideUrlLoading=" + r8 + ", cost=" + (System.currentTimeMillis() - r0));
        return r8;
    }

    public final boolean startPicoLinks(@NotNull Context r9, @Nullable String r10, @Nullable Callback r11) {
        Intrinsics.f(r9, "context");
        long r0 = System.currentTimeMillis();
        boolean r8 = invokeStartPicoLinks(StartPicoLinksRequest.SCENE.NATIVE_APP, r10, r9.getPackageName(), r11, false);
        Log.d(TAG, "startPicoLinks=" + r8 + ", cost=" + (System.currentTimeMillis() - r0));
        return r8;
    }

    public final boolean isPicoLinksUrl(@NotNull Uri r5) {
        Intrinsics.f(r5, "url");
        if (StringsKt.p(r5.getScheme(), "http", true) == true) goto L12;
        if (StringsKt.p(r5.getScheme(), SCHEME_HTTPS, true) == true) goto L12;
        if (StringsKt.p(r5.getScheme(), "picolinks", true) == true) goto L12;
        return false;
    L12:
        if (r5.getPathSegments().size() < 1) goto L17;
        if (StringsKt.p(r5.getPathSegments().get(0), "picolinks", true) == false) goto L17;
        return true;
    L17:
        return false;
    }
}
