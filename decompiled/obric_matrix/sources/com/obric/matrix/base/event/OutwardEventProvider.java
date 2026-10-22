package com.obric.matrix.base.event;

import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import com.obric.matrix.q.a.b;
import com.obric.matrix.q.h.k;
import com.obric.matrix.r.c.c;
import kotlin.Metadata;
import kotlin.n0.d.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J=\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0010\u0010\u0007\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/obric/matrix/base/event/OutwardEventProvider;", "Lcom/obric/matrix/base/auth/BaseAuthenticationProvider;", "()V", "query", "Landroid/database/Cursor;", "uri", "Landroid/net/Uri;", "projection", "", "", "queryArgs", "Landroid/os/Bundle;", "cancellationSignal", "Landroid/os/CancellationSignal;", "(Landroid/net/Uri;[Ljava/lang/String;Landroid/os/Bundle;Landroid/os/CancellationSignal;)Landroid/database/Cursor;", "Companion", "internal_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OutwardEventProvider extends b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f8846g = null;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/matrix/base/event/OutwardEventProvider$Companion;", "", "()V", "AUTHORITY", "", "GET_LAST_SCREEN_OFF_TIMESTAMP", "SCREEN_OFF_TIMESTAMP", "TAG", "notifyChange", "", "context", "Landroid/content/Context;", "eventPath", "internal_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g r1) {
            this();
        }

        public final void a(Context r3, String r4) {
            o.f(r3, "context");
            o.f(r4, "eventPath");
            Uri r2 = new Uri.Builder().scheme("content").authority("com.obric.matrix.outward_event_provider").path(r4).build();
            c.b("OutwardEventProvider", "notifyChange, path: " + r4 + ", uri: " + r2);
            r3.getContentResolver().notifyChange(r2, null);
        }
    }

    static {
        f8846g = new a(null);
    }

    public OutwardEventProvider() {
        c.b("OutwardEventProvider", "init");
        a().addURI("com.obric.matrix.outward_event_provider", "get_last_screen_off_timestamp", 1);
    }

    public static final void b(Context r1, String r2) {
        f8846g.a(r1, r2);
    }

    @Override // com.obric.matrix.q.a.b, android.content.ContentProvider
    public Cursor query(Uri r3, String[] r4, Bundle r5, CancellationSignal r6) {
        o.f(r3, "uri");
        super.query(r3, r4, r5, r6);
        c.b("OutwardEventProvider", "query, uri: " + r3 + ", projection: " + r4 + ", queryArgs: " + r5 + ", cancellationSignal: " + r6);
        if (a().match(r3) != 1) goto L5;
        long r0 = k.f9885a.n();
        MatrixCursor r7 = new MatrixCursor(new String[]{"screen_off_timestamp"});
        r7.addRow(new Long[]{Long.valueOf(r0)});
        c.b("OutwardEventProvider", "query, lastScreenOffTimestamp: " + r0);
        return r7;
    L5:
        return null;
    }
}
