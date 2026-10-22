package com.obric.matrix.base.settings;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import androidx.core.app.NotificationCompat;
import com.obric.matrix.base.settings.iconfig.IMatrixSdkConfig;
import com.obric.matrix.w.f0;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0016J=\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0010\u0010\r\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0002\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/obric/matrix/base/settings/MatrixSdkSettingsProvider;", "Lcom/obric/matrix/base/auth/BaseAuthenticationProvider;", "()V", NotificationCompat.CATEGORY_CALL, "Landroid/os/Bundle;", "method", "", "arg", "extras", "query", "Landroid/database/Cursor;", "uri", "Landroid/net/Uri;", "projection", "", "queryArgs", "cancellationSignal", "Landroid/os/CancellationSignal;", "(Landroid/net/Uri;[Ljava/lang/String;Landroid/os/Bundle;Landroid/os/CancellationSignal;)Landroid/database/Cursor;", "Companion", "internal_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MatrixSdkSettingsProvider extends com.obric.matrix.q.a.b {
    static {
    }

    public MatrixSdkSettingsProvider() {
        a().addURI("com.obric.matrix.sdk.settings.provider", "get_settings_config", 1);
    }

    @Override // com.obric.matrix.q.a.b, android.content.ContentProvider
    public Bundle call(String r2, String r3, Bundle r4) {
        o.f(r2, "method");
        super.call(r2, r3, r4);
        if (o.a(r2, "update_settings") == false) goto L7;
        com.bytedance.news.common.settings.e.g(true);
        return null;
    L7:
        return null;
    }

    @Override // com.obric.matrix.q.a.b, android.content.ContentProvider
    public Cursor query(Uri r5, String[] r6, Bundle r7, CancellationSignal r8) {
        o.f(r5, "uri");
        super.query(r5, r6, r7, r8);
        com.obric.matrix.r.c.c.b("MatrixSdkSettingsProvider", "matrix settings provider query start");
        Object r9 = com.bytedance.news.common.settings.e.e(IMatrixSdkConfig.class);
        o.e(r9, "obtain(IMatrixSdkConfig::class.java)");
        IMatrixSdkConfig r10 = (IMatrixSdkConfig) r9;
        if (a().match(r5) != 1) goto L16;
        MatrixCursor r0 = new MatrixCursor(new String[]{"all_config_str", "sdk_config_items", "sdk_all_config"});
        com.obric.matrix.base.settings.config.f r4 = r10.getMatrixSdkConfig();     // Catch: Exception -> L13
        if (r4 == null) goto L9;
        f0 r11 = r4.b();     // Catch: Exception -> L13
        if (r11 == null) goto L9;
    L10:
        Object r1 = f0.f10318h.encode(r11);     // Catch: Exception -> L13
        com.obric.matrix.r.c.c.b("MatrixSdkSettingsProvider", "all config = " + r11);     // Catch: Exception -> L13
        r0.addRow(new Serializable[]{r10.getMatrixSdkConfigStr(), null, (Serializable) r1});     // Catch: Exception -> L13
    L9:
        r11 = new f0.a().a();     // Catch: Exception -> L13
    L12:
        return r0;
    L16:
        return null;
    }
}
