package com.obric.privacy;

import android.app.assist.AssistContent;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LifeHookActivity.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\n\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0004J\u0010\u0010\r\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\u000e\u001a\u00020\u0004J\u0006\u0010\u000f\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u0004J\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0004J\u0010\u0010\u0013\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016¨\u0006\u0017"}, d2 = {"Lcom/obric/privacy/LifeHookActivity;", "Landroidx/fragment/app/FragmentActivity;", "()V", "onCreateWhenPrivacyNotOk", "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntentWhenPrivacyNotOk", "intent", "Landroid/content/Intent;", "onSuperCreate", "onSuperDestroy", "onSuperPause", "onSuperPostCreate", "onSuperPostResume", "onSuperResume", "onSuperStart", "onSuperStop", "superFinish", "superOnNewIntent", "superOnProvideAssistContent", "outContent", "Landroid/app/assist/AssistContent;", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class LifeHookActivity extends FragmentActivity {
    public void onCreateWhenPrivacyNotOk(Bundle r1) {
    }

    public void onNewIntentWhenPrivacyNotOk(Intent r1) {
    }

    public LifeHookActivity() {
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
