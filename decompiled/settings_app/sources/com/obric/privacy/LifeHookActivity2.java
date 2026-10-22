package com.obric.privacy;

import android.app.assist.AssistContent;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.obric.olog.OLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LifeHookActivity2.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u000e\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0006\u0010\u000f\u001a\u00020\bJ\u0006\u0010\u0010\u001a\u00020\bJ\u0010\u0010\u0011\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0006\u0010\u0012\u001a\u00020\bJ\u0006\u0010\u0013\u001a\u00020\bJ\u0006\u0010\u0014\u001a\u00020\bJ\u0006\u0010\u0015\u001a\u00020\bJ\u0006\u0010\u0016\u001a\u00020\bJ\u0010\u0010\u0017\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001aR\u0014\u0010\u0003\u001a\u00020\u0004X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001b"}, d2 = {"Lcom/obric/privacy/LifeHookActivity2;", "Landroidx/fragment/app/FragmentActivity;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "onCreateWhenPrivacyNotOk", "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntentWhenPrivacyNotOk", "intent", "Landroid/content/Intent;", "onSuperCreate", "onSuperDestroy", "onSuperPause", "onSuperPostCreate", "onSuperPostResume", "onSuperResume", "onSuperStart", "onSuperStop", "superFinish", "superOnNewIntent", "superOnProvideAssistContent", "outContent", "Landroid/app/assist/AssistContent;", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class LifeHookActivity2 extends FragmentActivity {
    private final String TAG;

    public LifeHookActivity2() {
        String r0 = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(r0, "getSimpleName(...)");
        this.TAG = r0;
    }

    protected final String getTAG() {
        return this.TAG;
    }

    public final void onCreateWhenPrivacyNotOk(final Bundle r5) {
        Intent r0 = getIntent();
        OLog.i(this.TAG, "onCreateWhenPrivacyNotOk intent action=" + r0.getAction() + ", flags=" + r0.getFlags());
        GrantUtil.INSTANCE.requestGrant(this, new AnonymousClass1(this, r5));
    }

    public final void onNewIntentWhenPrivacyNotOk(Intent r4) {
        Intent r0 = getIntent();
        OLog.i(this.TAG, "onNewIntentWhenPrivacyNotOk");
        if (r0 == null) goto L5;
        String r1 = this.TAG;
        StringBuilder r2 = new StringBuilder("onNewIntentWhenPrivacyNotOk intent action=");
        Intrinsics.checkNotNull(r4);
        OLog.d(r1, r2.append(r4.getAction()).append(", flags=").append(r4.getFlags()).toString());
    L5:
        GrantUtil.INSTANCE.requestGrant(this, new C03201(this));
    }

    public final void onSuperCreate(Bundle r1) {
        super.onCreate(r1);
    }

    public final void onSuperPostCreate(Bundle r1) {
        super.onPostCreate(r1);
    }

    public final void onSuperStart() {
        super.onStart();
    }

    public final void onSuperResume() {
        super.onResume();
    }

    public final void onSuperPostResume() {
        super.onPostResume();
    }

    public final void onSuperPause() {
        super.onPause();
    }

    public final void onSuperStop() {
        super.onStop();
    }

    public final void onSuperDestroy() {
        super.onDestroy();
    }

    public final void superFinish() {
        super.finish();
    }

    public final void superOnNewIntent(Intent r1) {
        super.onNewIntent(r1);
    }

    public final void superOnProvideAssistContent(AssistContent r2) {
        Intrinsics.checkNotNullParameter(r2, "outContent");
        super.onProvideAssistContent(r2);
    }
}
