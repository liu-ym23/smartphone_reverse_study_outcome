package com.bytedance.sdk.account.ticketguard;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.android.sdk.bdticketguard.b1;
import com.bytedance.android.sdk.bdticketguard.c1;
import com.bytedance.android.sdk.bdticketguard.u;
import com.bytedance.android.sdk.bdticketguard.v;
import com.bytedance.android.sdk.bdticketguard.w;
import com.bytedance.android.sdk.bdticketguard.x;
import com.bytedance.android.sdk.bdticketguard.z0;
import com.ss.android.i.j;
import com.ss.android.token.o;
import kotlin.f0;
import kotlin.n0.c.l;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class AccountTicketGuardHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static c1 f5765a;

    public static class TicketGuardInitParamImpl implements c1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final w f5766a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final v f5767b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final u f5768c;

        class a implements x {
            a(TicketGuardInitParamImpl r1) {
            }

            @Override // com.bytedance.android.sdk.bdticketguard.x
            public void log(int r3, @NonNull String r4, @NonNull String r5, @Nullable Throwable r6) {
                String r0 = "";
                if (r3 != 4) goto L5;
                StringBuilder r2 = new StringBuilder();
                r2.append(r5);
                if (r6 == null) goto L19;
                r0 = "\n" + Log.getStackTraceString(r6);
            L19:
                r2.append(r0);
                d.b.s.a.a0.a.d(r4, r2.toString());
                return;
            L5:
                if (r3 != 5) goto L7;
                d.b.s.a.a0.a.i(r4, r5, r6);
                return;
            L7:
                if (r3 == 6) goto L13;
                StringBuilder r7 = new StringBuilder();
                r7.append(r5);
                if (r6 == null) goto L12;
                r0 = "\n" + Log.getStackTraceString(r6);
            L12:
                r7.append(r0);
                d.b.s.a.a0.a.a(r4, r7.toString());
                return;
            L13:
                d.b.s.a.a0.a.c(r4, r5, r6);
            }
        }

        public TicketGuardInitParamImpl() {
            this.f5766a = new d();
            this.f5767b = com.bytedance.sdk.account.ticketguard.a.f5769a;
            this.f5768c = new a(this);
        }

        static /* synthetic */ void c(String r0, JSONObject r1) {
            AccountTicketGuardHelper.a(r1);
            o.C(r0, r1);
        }

        @Override // com.bytedance.android.sdk.bdticketguard.c1
        @NonNull
        public u a() {
            return this.f5768c;
        }

        @Override // com.bytedance.android.sdk.bdticketguard.c1
        @NonNull
        public v b() {
            return this.f5767b;
        }

        @Override // com.bytedance.android.sdk.bdticketguard.c1
        @Nullable
        public w d() {
            return this.f5766a;
        }

        @Override // com.bytedance.android.sdk.bdticketguard.c1
        @NonNull
        public Context e() {
            return j.k().e();
        }
    }

    static class a implements kotlin.n0.c.a<Boolean> {
        a() {
        }

        public Boolean a() {
            return Boolean.valueOf(d.b.s.a.l0.d.k());
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return a();
        }
    }

    public AccountTicketGuardHelper() {
    }

    static /* synthetic */ void a(JSONObject r0) {
        b(r0);
    }

    private static void b(JSONObject r2) {
        if (r2 != null) goto L9;
        return;
    L9:
        r2.put("token_config_version", f.d());     // Catch: JSONException -> L6
        return;
    L6:
        e = move-exception;
        d.b.s.a.a0.a.c("TicketGuardHelper", "addCommonParams error", e);
    }

    private static c1 c() {
        c1 r0 = f5765a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        TicketGuardInitParamImpl r1 = new TicketGuardInitParamImpl();
        f5765a = r1;
        return r1;
    }

    public static void initTicketGuard(Context r0, l<Boolean, f0> r1) {
        e.f5776b.c();
        b1.d(c(), r1);
        z0 r2 = z0.f1102e;
        r2.V(f.n());
        r2.U(new a());
    }

    public static void initTicketInstance() {
        e.f5776b.c();
        b1.a(c());
    }

    public static void onAccountSettingsUpdate() {
        e.f5776b.d();
    }
}
