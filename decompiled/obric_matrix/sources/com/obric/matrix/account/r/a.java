package com.obric.matrix.account.r;

import kotlin.Metadata;
import kotlin.n0.d.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u001c\u0010\n\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u00040\u000b2\u0006\u0010\f\u001a\u00020\u0004J\f\u0010\r\u001a\u00020\u0004*\u0004\u0018\u00010\u000eJ\f\u0010\u000f\u001a\u00020\u0004*\u0004\u0018\u00010\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/matrix/account/util/AccountSdkExt;", "", "()V", "EXTRA_ERROR_INFO_END", "", "EXTRA_ERROR_INFO_HEAD", "attachJsonInfoWithMarkers", "errMsg", "jsonInfo", "Lorg/json/JSONObject;", "extractJsonInfoWithMarkers", "Lkotlin/Pair;", "combinedErrMsg", "dumpStr", "Lcom/bytedance/sdk/account/api/call/BaseApiResponse;", "dumpStrWithoutMsg", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8616a = null;

    static {
        f8616a = new a();
    }

    private a() {
    }

    public final String a(String r2, JSONObject r3) {
        o.f(r2, "errMsg");
        o.f(r3, "jsonInfo");
        String r1 = r3.toString();
        o.e(r1, "jsonInfo.toString()");
        return "<<EXTRA_ERR_HEAD>>" + r1 + "<<EXTRA_ERR_END>>" + r2;
    }

    public final String b(d.b.s.a.q.j.b r3) {
        if (r3 != null) goto L4;
        return "null";
    L4:
        String r2 = r3.f14894j;
        if (r2 != null) goto L7;
    L10:
        boolean r4 = true;
    L11:
        if (r4 == false) goto L13;
    L15:
        String r5 = r3.f14893i;
    L17:
        return "success? " + r3.f14887c + ", logId: [" + r3.f14885a + "], error: " + r3.f14891g + ", errorMsg: " + r5;
    L13:
        if (o.a(r3.f14894j, r3.f14893i) == true) goto L15;
        r5 = r3.f14893i + ", detail: " + r3.f14894j;
        goto L17
    L7:
        if (r2.length() == 0) goto L10;
        r4 = false;
        goto L11
    }

    public final String c(d.b.s.a.q.j.b r2) {
        if (r2 != null) goto L5;
        return "null";
    L5:
        return "success? " + r2.f14887c + ", logId: [" + r2.f14885a + "], error: " + r2.f14891g + ", detailError: " + r2.f14892h;
    }
}
