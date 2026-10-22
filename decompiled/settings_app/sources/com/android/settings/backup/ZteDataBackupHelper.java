package com.android.settings.backup;

import android.content.Context;
import android.os.Build;
import android.util.Xml;
import com.android.settings.OtherAlertToneFragment;
import com.android.settings.Utils;
import com.android.settings.backup.data.SettingKeyAccessType;
import com.android.settings.backup.zte.ZteDataBackupItem;
import com.bytedance.platform.godzilla.common.Constant;
import com.obric.olog.OLog;
import com.zte.settings.backup.IBackupStatusListener;
import cz.msebera.android.httpclient.message.TokenParser;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: compiled from: ZteDataBackupHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\r2\b\u0010#\u001a\u0004\u0018\u00010\u00042\b\u0010$\u001a\u0004\u0018\u00010%H\u0007J\b\u0010&\u001a\u00020'H\u0002J4\u0010(\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\r2\b\u0010#\u001a\u0004\u0018\u00010\u00042\u0006\u0010)\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010%H\u0002J6\u0010*\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\r2\b\u0010#\u001a\u0004\u0018\u00010\u00042\b\u0010)\u001a\u0004\u0018\u00010\u00042\b\u0010$\u001a\u0004\u0018\u00010%H\u0007J,\u0010+\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\r2\b\u0010#\u001a\u0004\u0018\u00010\u00042\b\u0010$\u001a\u0004\u0018\u00010%H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/android/settings/backup/ZteDataBackupHelper;", "", "()V", "BD_FONT_SCALE", "", "FEATURE", "FILE_DIR", "FILE_NAME", "TAG", "ZTE", "ZTE_BACKUP_VERSION", "ZTE_IS_AUTO_TIME_ZONE", "ZTE_MUSIC_MAX_VOLUME", "", "ZTE_NOTIFICATION_RINGTONE_URI", "ZTE_OTHER_MAX_VOLUME", "ZTE_QS_TILE", "ZTE_SCREEN_BRIGHTNESS", "ZTE_SCREEN_BRIGHTNESS_BACK", "ZTE_SCREEN_BRIGHTNESS_MODE_BACK", "ZTE_VIBRATE_WHEN_RINGING", "mBdIgnoreSettingSet", "", "mIsInBackup", "", "mIsInRestore", "mSettingItemList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/android/settings/backup/zte/ZteDataBackupItem;", "mZteIgnoreSettingMap", "", "backup", "context", "Landroid/content/Context;", "token", "id", "listener", "Lcom/zte/settings/backup/IBackupStatusListener;", "initSettingItem", "", "readFile", "dataFileDir", "restore", "writeFile", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ZteDataBackupHelper {
    private static final String BD_FONT_SCALE = "fontScale";
    private static final String FEATURE = "http://xmlpull.org/v1/doc/features.html#indent-output";
    private static final String FILE_DIR = "/data/data/com.android.settings/nubia_data_backup";
    private static final String FILE_NAME = "settings.xml";
    public static final ZteDataBackupHelper INSTANCE = null;
    private static final String TAG = "ZteDataBackupHelper";
    private static final String ZTE = "zte";
    private static final String ZTE_BACKUP_VERSION = "backupversion";
    private static final String ZTE_IS_AUTO_TIME_ZONE = "isAutoTimeZone";
    private static final int ZTE_MUSIC_MAX_VOLUME = 150;
    private static final String ZTE_NOTIFICATION_RINGTONE_URI = "notificationRingtoneUri";
    private static final int ZTE_OTHER_MAX_VOLUME = 15;
    private static final String ZTE_QS_TILE = "qstile";
    private static final String ZTE_SCREEN_BRIGHTNESS = "screenBrightness";
    private static final String ZTE_SCREEN_BRIGHTNESS_BACK = "screenBrightnessBack";
    private static final String ZTE_SCREEN_BRIGHTNESS_MODE_BACK = "screenBrightnessModeBack";
    private static final String ZTE_VIBRATE_WHEN_RINGING = "vibrateWhenRinging";
    private static final Set<String> mBdIgnoreSettingSet = null;
    private static volatile boolean mIsInBackup;
    private static volatile boolean mIsInRestore;
    private static final CopyOnWriteArrayList<ZteDataBackupItem> mSettingItemList = null;
    private static final Map<String, String> mZteIgnoreSettingMap = null;

    private ZteDataBackupHelper() {
    }

    static {
        INSTANCE = new ZteDataBackupHelper();
        mSettingItemList = new CopyOnWriteArrayList();
        mZteIgnoreSettingMap = MapsKt.mapOf(new Pair[]{TuplesKt.to(ZTE_IS_AUTO_TIME_ZONE, ""), TuplesKt.to(ZTE_VIBRATE_WHEN_RINGING, ""), TuplesKt.to(ZTE_SCREEN_BRIGHTNESS, ""), TuplesKt.to(ZTE_SCREEN_BRIGHTNESS_MODE_BACK, ""), TuplesKt.to(ZTE_SCREEN_BRIGHTNESS_BACK, ""), TuplesKt.to(ZTE_NOTIFICATION_RINGTONE_URI, ""), TuplesKt.to(ZTE_QS_TILE, "bd")});
        mBdIgnoreSettingSet = SetsKt.setOf(BD_FONT_SCALE);
    }

    @JvmStatic
    public static final boolean backup(Context r5, int r6, String r7, IBackupStatusListener r8) {
        Intrinsics.checkNotNullParameter(r5, "context");
        OLog.i(TAG, "backup: token = " + r6 + ", id = " + r7);
        if (mIsInBackup == false) goto L8;
        OLog.i(TAG, "backup: token = " + r6 + ", id = " + r7 + ", is in backup");
        if (r8 == null) goto L7;
        r8.onBackupFailed(r6, "is in backup");
    L7:
        return false;
    L8:
        ZteDataBackupHelper r0 = INSTANCE;
        mIsInBackup = true;
        if (mSettingItemList.isEmpty() == false) goto L22;
        r0.initSettingItem();
    L22:
        return r0.writeFile(r5, r6, r7, r8);
    L13:
        e = move-exception;
        OLog.e(TAG, "backup", e);
        if (r8 == null) goto L20;
        String r9 = e.getMessage();
        if (r9 != null) goto L19;
        r9 = "";
    L19:
        r8.onBackupFailed(r6, r9);
    L20:
        mIsInBackup = false;
        return false;
    }

    @JvmStatic
    public static final boolean restore(Context r9, int r10, String r11, String r12, IBackupStatusListener r13) {
        Intrinsics.checkNotNullParameter(r9, "context");
        OLog.i(TAG, "restore: token = " + r10 + ", id = " + r11 + ", dataFileDir = " + r12);
        String r1 = r12;
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L15;
        OLog.e(TAG, "restore: token = " + r10 + ", id = " + r11 + ", filePath is empty");
        if (r13 == null) goto L13;
        r13.onRestoreFailed(r10, "dataFile is empty");
    L13:
        return false;
    L15:
        if (mIsInRestore == false) goto L20;
        OLog.i(TAG, "restore: token = " + r10 + ", id = " + r11 + ", is in restore");
        if (r13 == null) goto L19;
        r13.onRestoreFailed(r10, "is in restore");
    L19:
        return false;
    L20:
        ZteDataBackupHelper r3 = INSTANCE;
        mIsInRestore = true;
        if (mSettingItemList.isEmpty() == false) goto L35;
        r3.initSettingItem();
    L35:
        return r3.readFile(r9, r10, r11, r12, r13);
    L26:
        e = move-exception;
        OLog.e(TAG, "restore", e);
        if (r13 == null) goto L33;
        String r0 = e.getMessage();
        if (r0 != null) goto L32;
        r0 = "";
    L32:
        r13.onRestoreFailed(r10, r0);
    L33:
        mIsInRestore = false;
        return false;
    L5:
        if (r1.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    private final boolean writeFile(Context r18, int r19, String r20, IBackupStatusListener r21) {
        OLog.i(TAG, "writeFile: token = " + r19 + ", id = " + r20 + ", fileDir = /data/data/com.android.settings/nubia_data_backup");
        File r5 = new File(FILE_DIR);
        if (r5.exists() == true) goto L5;
        r5.mkdirs();
    L5:
        File r6 = new File(FILE_DIR, FILE_NAME);
        if (r6.exists() == false) goto L8;
        OLog.i(TAG, "writeFile: file exists, delete it");
        r6.delete();
    L8:
        r6.createNewFile();
        XmlSerializer r8 = Xml.newSerializer();
        Intrinsics.checkNotNullExpressionValue(r8, "newSerializer(...)");
        FileOutputStream r9 = new FileOutputStream(r6);
        r8.setOutput(r9, Constant.CHARSET_UTF_8);     // Catch: Throwable -> L37
        String r11 = null;
        r8.startDocument(null, true);     // Catch: Throwable -> L37
        r8.setFeature(FEATURE, true);     // Catch: Throwable -> L37
        r8.startTag(null, "nubia-settings-backup");     // Catch: Throwable -> L37
        r8.startTag(null, "data");     // Catch: Throwable -> L37
        boolean r0 = Intrinsics.areEqual(r20, "zte");     // Catch: Throwable -> L37
        Iterator<T> r10 = mSettingItemList.iterator();     // Catch: Throwable -> L37
        int r13 = 0;
    L11:
        if (r10.hasNext() == false) goto L19;
        Object r14 = r10.next();     // Catch: Throwable -> L37
        int r15 = r13 + 1;     // Catch: Throwable -> L37
        if (r13 >= 0) goto L15;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L37
    L15:
        ZteDataBackupItem r16 = (ZteDataBackupItem) r14;     // Catch: Throwable -> L37
        String r7 = r16.getMXmlKey();     // Catch: Throwable -> L37
        String r17 = r16.getXmlValue(r18, r0);     // Catch: Throwable -> L37
        r8.attribute(r11, r7, r17);     // Catch: Throwable -> L37
        boolean r110 = r0;
        OLog.i(TAG, "writing: key = " + r7 + ", value = " + r17);     // Catch: Throwable -> L37
        if (r21 == null) goto L18;
        r21.onProgressChanged(r19, r13, mSettingItemList.size(), "writing key " + r7);     // Catch: Throwable -> L37
    L18:
        r13 = r15;
        r0 = r110;
        r11 = null;
        goto L11
    L19:
        Iterator<Map.Entry<String, String>> r1 = mZteIgnoreSettingMap.entrySet().iterator();     // Catch: Throwable -> L37
    L21:
        if (r1.hasNext() == false) goto L45;
        Map.Entry<String, String> r12 = r1.next();     // Catch: Throwable -> L37
        r8.attribute(null, r12.getKey(), r12.getValue());     // Catch: Throwable -> L37
        goto L21
    L45:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L26
        String r3 = Build.VERSION.RELEASE;     // Catch: Throwable -> L26
        Intrinsics.checkNotNull(r3);     // Catch: Throwable -> L26
        Object r4 = Result.m1508constructorimpl((String) StringsKt.split$default(r3, new String[]{"."}, false, 0, 6, null).get(0));     // Catch: Throwable -> L26
    L29:
        if (Result.m1514isFailureimpl(r4) == false) goto L31;
        r4 = "16";
    L31:
        String r22 = (String) r4;     // Catch: Throwable -> L37
        OLog.i(TAG, "writing: key = backupversion, value = " + r22);     // Catch: Throwable -> L37
        r8.attribute(null, ZTE_BACKUP_VERSION, r22);     // Catch: Throwable -> L37
        r8.endTag(null, "data");     // Catch: Throwable -> L37
        r8.endTag(null, "nubia-settings-backup");     // Catch: Throwable -> L37
        r8.endDocument();     // Catch: Throwable -> L37
        Unit r23 = Unit.INSTANCE;     // Catch: Throwable -> L37
        CloseableKt.closeFinally(r9, null);
        mIsInBackup = false;
        OLog.i(TAG, "writeFile success");
        if (r21 == null) goto L52;
        r21.onBackupCompleted(r19, FILE_DIR);
        return true;
    L52:
        return true;
    L26:
        th = move-exception;
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L37
        r4 = Result.m1508constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        throw th;     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        CloseableKt.closeFinally(r9, th);
        throw th;
    }

    private final boolean readFile(Context r17, int r18, String r19, String r20, IBackupStatusListener r21) {
        FileInputStream r2 = new FileInputStream(new File(r20, FILE_NAME));
        XmlPullParser r4 = Xml.newPullParser();     // Catch: Throwable -> L47
        r4.setInput(r2, Constant.CHARSET_UTF_8);     // Catch: Throwable -> L47
        int r3 = r4.getEventType();     // Catch: Throwable -> L47
        boolean r5 = Intrinsics.areEqual(r19, "zte");     // Catch: Throwable -> L47
    L5:
        if (r3 == 1) goto L41;
        if (r3 != 2) goto L40;
        if (Intrinsics.areEqual(r4.getName(), "data") == false) goto L40;
        int r6 = r4.getAttributeCount();     // Catch: Throwable -> L47
        int r9 = 0;
    L11:
        if (r9 >= r6) goto L40;
        String r10 = r4.getAttributeName(r9);     // Catch: Throwable -> L47
        String r11 = r4.getAttributeValue(r9);     // Catch: Throwable -> L47
        if (mZteIgnoreSettingMap.keySet().contains(r10) == true) goto L37;
        if (mBdIgnoreSettingSet.contains(r10) == true) goto L37;
        CopyOnWriteArrayList<ZteDataBackupItem> r12 = mSettingItemList;     // Catch: Throwable -> L47
        ArrayList r14 = new ArrayList();     // Catch: Throwable -> L47
        Iterator<T> r13 = r12.iterator();     // Catch: Throwable -> L47
    L20:
        if (r13.hasNext() == false) goto L25;
        Object r15 = r13.next();     // Catch: Throwable -> L47
        Intrinsics.checkNotNull(r10);     // Catch: Throwable -> L47
        if (((ZteDataBackupItem) r15).isMeetCondition(r10) == false) goto L20;
        r14.add(r15);     // Catch: Throwable -> L47
        goto L20
    L25:
        Iterator r8 = r14.iterator();     // Catch: Throwable -> L47
        boolean r16 = false;
    L27:
        if (r8.hasNext() == false) goto L29;
        ZteDataBackupItem r110 = (ZteDataBackupItem) r8.next();     // Catch: Throwable -> L47
        Intrinsics.checkNotNull(r11);     // Catch: Throwable -> L47
        r110.readXmlValue(r17, r11, r5);     // Catch: Throwable -> L47
        r16 = true;
        goto L27
    L29:
        OLog.i(TAG, "reading: key = " + r10 + ", value = " + r11 + ", result = " + r16);     // Catch: Throwable -> L47
        if (r21 == null) goto L39;
        int r22 = r4.getAttributeCount();     // Catch: Throwable -> L47
        StringBuilder r111 = new StringBuilder().append("read ").append(r10).append(TokenParser.SP);     // Catch: Throwable -> L47
        if (r16 == false) goto L34;
        String r112 = "success";
    L35:
        r21.onProgressChanged(r18, r9, r22, r111.append(r112).toString());     // Catch: Throwable -> L47
        goto L39
    L34:
        r112 = "failed";
    L39:
        r9 = r9 + 1;     // Catch: Throwable -> L47
    L37:
        if (r21 == null) goto L39;
        r21.onProgressChanged(r18, r9, r4.getAttributeCount(), "read " + r10 + ", ignore");     // Catch: Throwable -> L47
    L40:
        r3 = r4.next();     // Catch: Throwable -> L47
        goto L5
    L41:
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L47
        CloseableKt.closeFinally(r2, null);
        mIsInRestore = false;
        OLog.i(TAG, "readFile success");
        if (r21 == null) goto L69;
        r21.onRestoreCompleted(r18);
        return true;
    L69:
        return true;
    L47:
        th = move-exception;
        throw th;     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);
        throw th;
    }

    private final void initSettingItem() {
        CopyOnWriteArrayList<ZteDataBackupItem> r5 = mSettingItemList;
        final float r0 = Utils.getCurrentFontScale();
        final SettingKeyAccessType r1 = SettingKeyAccessType.SYSTEM;
        ZteDataBackupItem r2 = new AnonymousClass1(r0, r1);
        r2.setDefValueProvider(ZteDataBackupHelper$initSettingItem$2$1.INSTANCE);
        r5.add(r2);
        final SettingKeyAccessType r3 = SettingKeyAccessType.SYSTEM;
        ZteDataBackupItem r4 = new AnonymousClass3(r3);
        r4.setDefValueProvider(ZteDataBackupHelper$initSettingItem$4$1.INSTANCE);
        r5.add(r4);
        final SettingKeyAccessType r6 = SettingKeyAccessType.GLOBAL;
        ZteDataBackupItem r7 = new AnonymousClass5(r6);
        r7.setDefValueProvider(ZteDataBackupHelper$initSettingItem$6$1.INSTANCE);
        r5.add(r7);
        final SettingKeyAccessType r8 = SettingKeyAccessType.SYSTEM;
        r5.add(new AnonymousClass7(r8));
        final SettingKeyAccessType r9 = SettingKeyAccessType.SYSTEM;
        r5.add(new AnonymousClass8(r9));
        final SettingKeyAccessType r10 = SettingKeyAccessType.SYSTEM;
        r5.add(new AnonymousClass9(r10));
        final SettingKeyAccessType r11 = SettingKeyAccessType.SYSTEM;
        r5.add(new AnonymousClass10(r11));
        final SettingKeyAccessType r12 = SettingKeyAccessType.SYSTEM;
        ZteDataBackupItem r13 = new AnonymousClass11(r12);
        r13.setDefValueProvider(ZteDataBackupHelper$initSettingItem$12$1.INSTANCE);
        r5.add(r13);
        final SettingKeyAccessType r14 = SettingKeyAccessType.SYSTEM;
        ZteDataBackupItem r15 = new AnonymousClass13(r14);
        r15.setDefValueProvider(ZteDataBackupHelper$initSettingItem$14$1.INSTANCE);
        r5.add(r15);
        ZteDataBackupItem r16 = new ZteDataBackupItem("sound_effects_enabled", 1, SettingKeyAccessType.SYSTEM, "touchSound");
        r16.setDefValueProvider(ZteDataBackupHelper$initSettingItem$15$1.INSTANCE);
        r5.add(r16);
        ZteDataBackupItem r17 = new ZteDataBackupItem(OtherAlertToneFragment.LOW_BATTERY_SOUNDS_ENABLED, 1, SettingKeyAccessType.SYSTEM, "lowPowerSound");
        r17.setDefValueProvider(ZteDataBackupHelper$initSettingItem$16$1.INSTANCE);
        r5.add(r17);
        ZteDataBackupItem r18 = new ZteDataBackupItem("volume_key_function", 3, SettingKeyAccessType.GLOBAL, "VolumeController");
        r18.setDefValueProvider(ZteDataBackupHelper$initSettingItem$17$1.INSTANCE);
        r5.add(r18);
        ZteDataBackupItem r19 = new ZteDataBackupItem("screen_brightness_mode", 0, SettingKeyAccessType.SYSTEM, "screenBrightnessMode");
        r19.setDefValueProvider(ZteDataBackupHelper$initSettingItem$18$1.INSTANCE);
        r5.add(r19);
        final SettingKeyAccessType r20 = SettingKeyAccessType.SYSTEM;
        ZteDataBackupItem r21 = new AnonymousClass19(r20);
        r21.setDefValueProvider(ZteDataBackupHelper$initSettingItem$20$1.INSTANCE);
        r5.add(r21);
        final SettingKeyAccessType r22 = SettingKeyAccessType.SYSTEM;
        ZteDataBackupItem r23 = new AnonymousClass21(r22);
        r23.setDefValueProvider(ZteDataBackupHelper$initSettingItem$22$1.INSTANCE);
        r5.add(r23);
        final SettingKeyAccessType r24 = SettingKeyAccessType.SYSTEM;
        r5.add(new AnonymousClass23(r24));
    }
}
