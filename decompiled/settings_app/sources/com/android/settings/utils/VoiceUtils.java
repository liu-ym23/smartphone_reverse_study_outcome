package com.android.settings.utils;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.provider.Settings;
import com.android.settings.R;
import com.android.settings.SettingsApplication;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VoiceUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\b\u0010\b\u001a\u0004\u0018\u00010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u0004\u0018\u00010\u0004¨\u0006\u000b"}, d2 = {"Lcom/android/settings/utils/VoiceUtils;", "", "()V", "getAlarmRingtoneUri", "Landroid/net/Uri;", "getDefaultRingtoneUri", "type", "", "getNotificationRingtoneUri", "getRingtoneUri", "getSim1RingtoneUri", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class VoiceUtils {
    public VoiceUtils() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v4 */
    public final Uri getDefaultRingtoneUri(String r10) {
        Intrinsics.checkNotNullParameter(r10, "type");
        Context r0 = SettingsApplication.getContext();
        if (Intrinsics.areEqual(r10, "ringtone") == false) goto L6;
        String r2 = r0.getString(R.string.ringtone_default);
    L9:
        Intrinsics.checkNotNull(r2);
        if (Intrinsics.areEqual(r10, "ringtone") == false) goto L13;
        String r11 = "is_ringtone = 1";
    L16:
        ?? r1 = 0;
        Uri r3 = null;
        r3 = null;
        r3 = null;
        r3 = null;
        Cursor r12 = r0.getContentResolver().query(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, new String[]{"_id"}, "title = ? AND ".concat(r11), new String[]{r2}, null);     // Catch: Throwable -> L27 Exception -> L29
        if (r12 != null) goto L41;
    L25:
        if (r12 == null) goto L34;
    L26:
        r12.close();
    L34:
        return r3;
    L41:
    L23:
        e = e;
    L31:
        e.printStackTrace();     // Catch: Throwable -> L35
        if (r12 == null) goto L34;
    L20:
        if (r12.moveToFirst() == false) goto L25;
        r3 = ContentUris.withAppendedId(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, r12.getInt(0));     // Catch: Exception -> L23 Throwable -> L35
        goto L25
    L35:
        th = th;
        r1 = r11;
    L37:
        if (r1 == 0) goto L39;
        r1.close();
    L39:
        throw th;
    L29:
        e = e;
        r12 = null;
    L27:
        th = th;
        goto L37
    L13:
        if (Intrinsics.areEqual(r10, "alarm_alert") == false) goto L15;
        r11 = "is_alarm = 1";
        goto L16
    L15:
        r11 = "is_notification = 1";
        goto L16
    L6:
        if (Intrinsics.areEqual(r10, "alarm_alert") == false) goto L8;
        r2 = r0.getString(R.string.ringtone_alarm_default);
        goto L9
    L8:
        r2 = r0.getString(R.string.ringtone_notification_default);
        goto L9
    }

    private final Uri getRingtoneUri(String r2) {
        ContentResolver r1 = SettingsApplication.getContext().getContentResolver();
        Intrinsics.checkNotNullExpressionValue(r1, "getContentResolver(...)");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r3 = Result.m1508constructorimpl(Uri.parse(Settings.System.getString(r1, r2)));     // Catch: Throwable -> L5
    L8:
        if (Result.m1514isFailureimpl(r3) == false) goto L11;
        r3 = null;
    L11:
        return (Uri) r3;
    L5:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r3 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public final Uri getSim1RingtoneUri() {
        Uri r1 = getRingtoneUri("ringtone");
        if (r1 == null) goto L5;
        return r1;
    L5:
        return getDefaultRingtoneUri("ringtone");
    }

    public final Uri getNotificationRingtoneUri() {
        Uri r1 = getRingtoneUri("notification_sound");
        if (r1 == null) goto L5;
        return r1;
    L5:
        return getDefaultRingtoneUri("notification_sound");
    }

    public final Uri getAlarmRingtoneUri() {
        Uri r1 = getRingtoneUri("alarm_alert");
        if (r1 == null) goto L5;
        return r1;
    L5:
        return getDefaultRingtoneUri("alarm_alert");
    }
}
