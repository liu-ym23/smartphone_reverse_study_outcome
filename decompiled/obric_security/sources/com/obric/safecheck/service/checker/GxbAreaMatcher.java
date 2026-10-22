package com.obric.safecheck.service.checker;

import android.content.Context;
import com.obric.baseservice.location.LocationAreaMatcher;
import com.obric.olog.OLog;
import com.obric.securitycenter.api.ApplicationContainer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: GxbAreaMatcher.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0007J\u0016\u0010\u000f\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011H\u0002J\u0016\u0010\u0012\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011H\u0002J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00112\u0006\u0010\u000e\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/safecheck/service/checker/GxbAreaMatcher;", "", "()V", "AREA_CODE_NATIONWIDE", "", "AREA_TYPE_ADMIN_DIVISION", "AREA_TYPE_IP_RANGE", "MATCH_TIMEOUT_SECONDS", "", "SEGMENT_SEPARATOR", "TAG", "isRuleAreaMatched", "", "areaType", "area", "matchAdminDivision", "segments", "", "matchIpRange", "splitSegments", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class GxbAreaMatcher {
    private static final String AREA_CODE_NATIONWIDE = "1";
    private static final String AREA_TYPE_ADMIN_DIVISION = "1";
    private static final String AREA_TYPE_IP_RANGE = "2";
    public static final GxbAreaMatcher INSTANCE = null;
    private static final long MATCH_TIMEOUT_SECONDS = 5;
    private static final String SEGMENT_SEPARATOR = ";";
    private static final String TAG = "GbtCodeDict-GxbAreaMatcher";

    static {
        INSTANCE = new GxbAreaMatcher();
    }

    private GxbAreaMatcher() {
    }

    @JvmStatic
    public static final boolean isRuleAreaMatched(String r6, String r7) {
        String r8 = r6;
        boolean r0 = false;
        if (r8 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == true) goto L41;
        String r9 = r7;
        if (r9 != null) goto L14;
    L15:
        r0 = true;
    L16:
        if (r0 == true) goto L41;
        String r10 = StringsKt.trim(r8).toString();
        String r11 = StringsKt.trim(r9).toString();
        if (Intrinsics.areEqual(r10, "1") == true) goto L21;
    L24:
        GxbAreaMatcher r3 = INSTANCE;
        List<String> r12 = r3.splitSegments(r11);
        if (r12.isEmpty() == false) goto L28;
        OLog.d(TAG, "match true, no valid segment after split");
        return true;
    L28:
        int r4 = r10.hashCode();
        if (r4 == 49) goto L37;
        if (r4 == 50) goto L34;
    L39:
        OLog.d(TAG, "match true, unknown areaType is " + r10);
        return true;
    L34:
        if (r10.equals("2") == false) goto L39;
        return r3.matchIpRange(r12);
    L37:
        if (r10.equals("1") == false) goto L39;
        return r3.matchAdminDivision(r12);
    L21:
        if (Intrinsics.areEqual(r11, "1") == false) goto L24;
        OLog.d(TAG, "match true, nationwide sentinel");
        return true;
    L14:
        if (StringsKt.isBlank(r9) == false) goto L16;
    L41:
        OLog.d(TAG, "match true, areaType or area is blank");
        return true;
    L5:
        if (StringsKt.isBlank(r8) == true) goto L8;
        r2 = false;
        goto L10
    }

    private final boolean matchAdminDivision(List<String> r7) {
        Context r0 = ApplicationContainer.INSTANCE.getApplication();
        if (r0 != null) goto L6;
        OLog.d(TAG, "matchAdminDivision context null, treat as matched");
        return true;
    L6:
        final CountDownLatch r6 = new CountDownLatch(1);
        final AtomicBoolean r3 = new AtomicBoolean(true);
        LocationAreaMatcher.matches(r0, r7, new AnonymousClass1(r3, r6));
        boolean r8 = r6.await(5, TimeUnit.SECONDS);     // Catch: InterruptedException -> L9
    L11:
        if (r8 == true) goto L14;
        OLog.e(TAG, "matchAdminDivision timeout after 5s, treat as matched");
        return false;
    L14:
        OLog.e(TAG, "matchAdminDivision  result： " + r3.get());
        return r3.get();
    L9:
        e = move-exception;
        Thread.currentThread().interrupt();
        OLog.e(TAG, "matchAdminDivision interrupted", e);
        r8 = false;
        goto L11
    }

    private final boolean matchIpRange(List<String> r2) {
        OLog.d(TAG, "matchIpRange segments size is " + r2.size() + ", todo");
        return true;
    }

    private final List<String> splitSegments(String r7) {
        ArrayList r6 = new ArrayList();
        Iterator r8 = StringsKt.split$default(r7, new String[]{SEGMENT_SEPARATOR}, false, 0, 6, null).iterator();
    L4:
        if (r8.hasNext() == false) goto L12;
        String r0 = StringsKt.trim((String) r8.next()).toString();
        if (r0.length() <= 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L4;
        r6.add(r0);
        goto L4
    L8:
        r1 = false;
        goto L9
    L12:
        return r6;
    }
}
