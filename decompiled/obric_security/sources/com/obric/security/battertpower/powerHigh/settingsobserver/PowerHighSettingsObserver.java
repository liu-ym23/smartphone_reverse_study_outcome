package com.obric.security.battertpower.powerHigh.settingsobserver;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import com.obric.olog.OLog;
import com.obric.security.battertpower.powerHigh.notice.PowerHighWarningReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PowerHighSettingsObserver.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0010\nJ\u001a\u0010\u0006\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/security/battertpower/powerHigh/settingsobserver/PowerHighSettingsObserver;", "Landroid/database/ContentObserver;", "context", "Landroid/content/Context;", "handler", "Landroid/os/Handler;", "onChange", "Lkotlin/Function2;", "", "", "(Landroid/content/Context;Landroid/os/Handler;Lkotlin/jvm/functions/Function2;)V", "selfChange", "", "uri", "Landroid/net/Uri;", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class PowerHighSettingsObserver extends ContentObserver {
    public static final String ALLOW_BG_POWER_HIGH = "allow_bg_power_high";
    public static final Companion Companion = null;
    private final Context context;
    private final Handler handler;
    private final Function2<String, String, Unit> onChange;

    /* JADX INFO: compiled from: PowerHighSettingsObserver.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/security/battertpower/powerHigh/settingsobserver/PowerHighSettingsObserver$Companion;", "", "()V", "ALLOW_BG_POWER_HIGH", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
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

    /* JADX WARN: Multi-variable type inference failed */
    public PowerHighSettingsObserver(Context r2, Handler r3, Function2<? super String, ? super String, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "handler");
        Intrinsics.checkNotNullParameter(r4, "onChange");
        super(r3);
        this.context = r2;
        this.handler = r3;
        this.onChange = r4;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean r2, Uri r3) {
        super.onChange(r2, r3);
        boolean r4 = PowerHighWarningReceiver.isNotificationShowing(this.context, PowerHighWarningReceiver.CHANNEL_ID);
        OLog.d("PowerHighAppsManager", "allow bg list changed, notification is show:" + r4);
        if (r4 == true) goto L5;
        return;
    L5:
        this.onChange.invoke("allow_bg_power_high", "");
    }
}
