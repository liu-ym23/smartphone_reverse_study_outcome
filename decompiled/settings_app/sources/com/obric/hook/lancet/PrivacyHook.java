package com.obric.hook.lancet;

import android.app.assist.AssistContent;
import android.content.Intent;
import android.os.Bundle;
import com.obric.privacy.GrantUtil;
import com.obric.privacy.LifeHookActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Origin;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.This;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: compiled from: PrivacyHook.kt */
/* JADX INFO: loaded from: classes4.dex */
@TargetClass(scope = Scope.ALL, value = "com.obric.privacy.LifeHookActivity")
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007J\b\u0010\b\u001a\u00020\u0004H\u0007J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007J\b\u0010\f\u001a\u00020\u0004H\u0007J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007J\b\u0010\u000e\u001a\u00020\u0004H\u0007J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\b\u0010\u0012\u001a\u00020\u0004H\u0007J\b\u0010\u0013\u001a\u00020\u0004H\u0007J\b\u0010\u0014\u001a\u00020\u0004H\u0007¨\u0006\u0015"}, d2 = {"Lcom/obric/hook/lancet/PrivacyHook;", "", "()V", "finish", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "Landroid/content/Intent;", "onPause", "onPostCreate", "onPostResume", "onProvideAssistContent", "outContent", "Landroid/app/assist/AssistContent;", "onResume", "onStart", "onStop", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Skip({"com.android.settings.provision.WifiPickerActivity2", "com.android.settings.provision.FaceActivity", "com.android.settings.provision.PasswordActivity", "com.android.settings.FallbackHome"})
public final class PrivacyHook {
    public static final PrivacyHook INSTANCE = null;

    static {
        INSTANCE = new PrivacyHook();
    }

    public PrivacyHook() {
    }

    @Insert("onCreate")
    public final void onCreate(Bundle r2) {
        Object r1 = This.get();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        LifeHookActivity r3 = (LifeHookActivity) r1;
        if (GrantUtil.INSTANCE.isHookAllowed(r3) == false) goto L6;
        r3.onCreateWhenPrivacyNotOk(null);
        r3.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        Origin.callVoid();
    }

    @Insert("onPostCreate")
    public final void onPostCreate(Bundle r3) {
        Object r2 = This.get();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        LifeHookActivity r4 = (LifeHookActivity) r2;
        if (GrantUtil.INSTANCE.isHookAllowed(r4) == false) goto L6;
        r4.onSuperPostCreate(r3);
        return;
    L6:
        Origin.callVoid();
    }

    @Insert("onStart")
    public final void onStart() {
        Object r2 = This.get();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        LifeHookActivity r3 = (LifeHookActivity) r2;
        if (GrantUtil.INSTANCE.isHookAllowed(r3) == false) goto L6;
        r3.onSuperStart();
        return;
    L6:
        Origin.callVoid();
    }

    @Insert("onResume")
    public final void onResume() {
        Object r2 = This.get();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        LifeHookActivity r3 = (LifeHookActivity) r2;
        if (GrantUtil.INSTANCE.isHookAllowed(r3) == false) goto L6;
        r3.onSuperResume();
        return;
    L6:
        Origin.callVoid();
    }

    @Insert("onPostResume")
    public final void onPostResume() {
        Object r2 = This.get();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        LifeHookActivity r3 = (LifeHookActivity) r2;
        if (GrantUtil.INSTANCE.isHookAllowed(r3) == false) goto L6;
        r3.onSuperPostResume();
        return;
    L6:
        Origin.callVoid();
    }

    @Insert("onPause")
    public final void onPause() {
        Object r2 = This.get();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        LifeHookActivity r3 = (LifeHookActivity) r2;
        if (GrantUtil.INSTANCE.isHookAllowed(r3) == false) goto L6;
        r3.onSuperPause();
        return;
    L6:
        Origin.callVoid();
    }

    @Insert("onStop")
    public final void onStop() {
        Object r2 = This.get();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        LifeHookActivity r3 = (LifeHookActivity) r2;
        if (GrantUtil.INSTANCE.isHookAllowed(r3) == false) goto L6;
        r3.onSuperStop();
        return;
    L6:
        Origin.callVoid();
    }

    @Insert("onDestroy")
    public final void onDestroy() {
        Object r2 = This.get();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        LifeHookActivity r3 = (LifeHookActivity) r2;
        if (GrantUtil.INSTANCE.isHookAllowed(r3) == false) goto L6;
        r3.onSuperDestroy();
        return;
    L6:
        Origin.callVoid();
    }

    @Insert("finish")
    public final void finish() {
        Object r2 = This.get();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        LifeHookActivity r3 = (LifeHookActivity) r2;
        if (GrantUtil.INSTANCE.isHookAllowed(r3) == false) goto L6;
        r3.superFinish();
        return;
    L6:
        Origin.callVoid();
    }

    @Insert("onNewIntent")
    public final void onNewIntent(Intent r3) {
        Object r2 = This.get();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        LifeHookActivity r4 = (LifeHookActivity) r2;
        if (GrantUtil.INSTANCE.isHookAllowed(r4) == false) goto L6;
        r4.onNewIntentWhenPrivacyNotOk(null);
        r4.superOnNewIntent(r3);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        Origin.callVoid();
    }

    @Insert("onProvideAssistContent")
    public final void onProvideAssistContent(AssistContent r3) {
        Intrinsics.checkNotNullParameter(r3, "outContent");
        Object r2 = This.get();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        LifeHookActivity r4 = (LifeHookActivity) r2;
        if (GrantUtil.INSTANCE.isHookAllowed(r4) == false) goto L6;
        r4.superOnProvideAssistContent(r3);
        return;
    L6:
        Origin.callVoid();
    }
}
