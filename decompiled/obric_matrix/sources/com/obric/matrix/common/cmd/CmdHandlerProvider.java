package com.obric.matrix.common.cmd;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import com.obric.matrix.q.a.b;
import com.obric.matrix.r.c.c;
import com.obric.matrix.w.b0;
import com.obric.matrix.w.d0;
import com.squareup.wire.ProtoAdapter;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J=\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0010\u0010\u0007\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/obric/matrix/common/cmd/CmdHandlerProvider;", "Lcom/obric/matrix/base/auth/BaseAuthenticationProvider;", "()V", "query", "Landroid/database/Cursor;", "uri", "Landroid/net/Uri;", "projection", "", "", "queryArgs", "Landroid/os/Bundle;", "cancellationSignal", "Landroid/os/CancellationSignal;", "(Landroid/net/Uri;[Ljava/lang/String;Landroid/os/Bundle;Landroid/os/CancellationSignal;)Landroid/database/Cursor;", "Companion", "common_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CmdHandlerProvider extends b {
    static {
    }

    public CmdHandlerProvider() {
        a().addURI("com.obric.matrix.sdk.cmd.handler.provider", "SEND_CMD_BY_PROVIDER", 1);
    }

    @Override // com.obric.matrix.q.a.b, android.content.ContentProvider
    public Cursor query(Uri r6, String[] r7, Bundle r8, CancellationSignal r9) {
        o.f(r6, "uri");
        MatrixCursor r4 = null;
        super.query(r6, r7, r8, r9);     // Catch: Throwable -> L21
        if (a().match(r6) != 1) goto L30;
        if (r8 == null) goto L7;
        int r5 = r8.getInt("MATRIX_CMD");     // Catch: Throwable -> L21
    L8:
        if (r8 == null) goto L20;
        byte[] r10 = r8.getByteArray("REQUEST_BYTE_ARRAY");     // Catch: Throwable -> L21
        if (r10 == null) goto L20;
        b0 r11 = b0.r.decode(r10);     // Catch: Throwable -> L21
        c.b("CmdHandlerProvider", "cmd handler provider request decode end thread " + Thread.currentThread());     // Catch: Throwable -> L21
        MatrixCursor r12 = new MatrixCursor(new String[]{"RESPONSE_BYTE_ARRAY"});     // Catch: Throwable -> L21
        if (r5 <= 0) goto L31;
        if (r11 == null) goto L31;
        c.b("CmdHandlerProvider", "cmd handler provider cmd=" + r5 + " request " + r11);     // Catch: Throwable -> L16
        com.obric.matrix.u.b r13 = a.f8910a.a(r5, r11);     // Catch: Throwable -> L16
        d0.a r14 = new d0.a();     // Catch: Throwable -> L16
        r14.d(Integer.valueOf(r5));     // Catch: Throwable -> L16
        r14.j(r13.b().f10265g);     // Catch: Throwable -> L16
        r14.e(r13.b().f10266h);     // Catch: Throwable -> L16
        r14.g(r13.b().f10267i);     // Catch: Throwable -> L16
        r14.i(r11.f10196g);     // Catch: Throwable -> L16
        r14.b(r13.c());     // Catch: Throwable -> L16
        r12.addRow(new byte[][]{d0.o.encode(r14.c())});     // Catch: Throwable -> L16
    L16:
        th = th;
        r4 = r12;
    L23:
        if ((th instanceof com.obric.matrix.s.b) == false) goto L25;
        MatrixCursor r15 = new MatrixCursor(new String[]{"RESPONSE_BYTE_ARRAY"});
        ProtoAdapter<d0> r16 = d0.o;
        d0.a r17 = new d0.a();
        r17.j(Integer.valueOf(th.a()));
        r17.e(th.getMessage());
        r15.addRow(new byte[][]{r16.encode(r17.c())});
        return r15;
    L25:
        c.g("CmdHandlerProvider", "Failed to process command", th);
        return r4;
    L31:
        return r12;
    L20:
        throw new IllegalArgumentException("queryArgs is null");     // Catch: Throwable -> L21
    L7:
        r5 = 0;
        goto L8
    L30:
        return null;
    L21:
        th = th;
        goto L23
    }
}
