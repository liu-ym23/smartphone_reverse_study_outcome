package com.android.settings;

import android.content.DialogInterface;
import android.os.Bundle;
import com.android.internal.app.AlertActivity;
import com.obric.olog.OLog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;

/* JADX INFO: loaded from: classes2.dex */
public class TimeZoneChangeWarnActivity extends AlertActivity {
    private String zoneInfo;

    public TimeZoneChangeWarnActivity() {
    }

    public void onCreate(Bundle r2) {
        super.onCreate(r2);
        this.zoneInfo = getIntent().getStringExtra(TimeChangeReceiver.EXTRA_ZONE_CHANGE_WARN_MSG);
        OLog.d("TimeZoneChange", "time zone changed:" + this.zoneInfo);
        setupDialog();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void setupDialog() {
        new OAlertDialogBuilder(this).horizontalButton().title(R.string.time_zone_changed_dialog_title).message(getString(R.string.time_zone_changed_notif_title) + this.zoneInfo).negativeButton(R.string.ok, new TimeZoneChangeWarnActivity$$ExternalSyntheticLambda0(this)).build().show();
    }

    /* JADX INFO: renamed from: lambda$setupDialog$0$com-android-settings-TimeZoneChangeWarnActivity, reason: not valid java name */
    /* synthetic */ void m212xe800b8e(DialogInterface r1, int r2) {
        r1.dismiss();
        finish();
    }

    public void finish() {
        super.finish();
    }
}
