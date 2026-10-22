package com.obric.matrix.badge;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.matrix.common_api.IBadgeApi;
import com.obric.matrix.r.c.c;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.d.g;
import kotlin.n0.d.o;
import kotlin.v;
import kotlin.w;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J4\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/obric/matrix/badge/BadgeApiImpl;", "Lcom/obric/matrix/common_api/IBadgeApi;", "()V", "updateBadge", "", "context", "Landroid/content/Context;", "pkg", "", "setNum", "", "addNum", TypedValues.TransitionType.S_FROM, "Companion", "badge_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BadgeApiImpl implements IBadgeApi {
    public static final a Companion = null;
    private static final String TAG = "BadgeApiImpl";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/matrix/badge/BadgeApiImpl$Companion;", "", "()V", "TAG", "", "badge_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    public BadgeApiImpl() {
    }

    @Override // com.obric.matrix.common_api.IBadgeApi
    public void updateBadge(Context r7, String r8, int r9, int r10, String r11) {
        o.f(r11, TypedValues.TransitionType.S_FROM);
        if (r8 != null) goto L5;
    L8:
        boolean r6 = true;
    L10:
        if (r6 == false) goto L13;
        c.s(TAG, "updateBadge skipped, pkg is empty");
        return;
    L13:
        if (r7 != null) goto L17;
        c.s(TAG, "updateBadge skipped, context is null, pkg=" + r8);
        return;
    L17:
        if (r9 < 0) goto L19;
        String r3 = "set";
        int r4 = r9;
    L31:
        v.a r5 = v.f21457g;     // Catch: Throwable -> L23
        MessageBadgeProvider.f(r7, r8, r4, r11, r3);     // Catch: Throwable -> L23
        Object r12 = f0.f18324a;     // Catch: Throwable -> L23
        v.b(r12);     // Catch: Throwable -> L23
    L25:
        Throwable r13 = v.d(r12);
        if (r13 == null) goto L33;
        c.g(TAG, "updateBadge failed, pkg=" + r8 + " badgeNum=" + r9 + " addNum=" + r10 + " badgeOp=" + r3 + " from=" + r11, r13);
        return;
    L33:
        return;
    L23:
        th = move-exception;
        v.a r14 = v.f21457g;
        r12 = w.a(th);
        v.b(r12);
        goto L25
    L19:
        if (r10 <= 0) goto L29;
        r3 = "add";
        r4 = r10;
        goto L31
    L29:
        c.j(TAG, "updateBadge skipped, no valid badge value, pkg=" + r8 + " badgeNum=" + r9 + " addNum=" + r10 + " from=" + r11);
        return;
    L5:
        if (r8.length() == 0) goto L8;
        r6 = false;
        goto L10
    }
}
