package com.android.settings.settingitemsprovider.Items;

import android.content.ContentProviderClient;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.RemoteException;
import android.provider.Settings;
import android.util.Pair;
import com.android.settings.R;
import com.android.settings.accounts.OAccountHelper;
import com.android.settings.intelligent.AssistantActivationFragment;
import com.android.settings.intelligent.DoubaoAssistantEnabler;
import com.android.settings.intelligent.SystemIntelligentFragment;
import com.android.settings.settingitemsprovider.Constants;
import com.android.settings.settingitemsprovider.DatabaseHelper;
import com.android.settings.utils.ThreadUtils;
import com.obric.olog.OLog;
import obric.app.settings.search.SettingsSwitchKeyUtil;

/* JADX INFO: loaded from: classes2.dex */
public class IntelligentSettingItems extends SettingItems {
    private static final int AI_LAB_STATUS_BLACKLIST = 4;
    private static final int AI_LAB_STATUS_INIT = 0;
    public static final String IS_AUTO_RECORD_ENABLED = "is_auto_record_enabled";
    private static final String URI_PERMISSION_STATUS = "content://com.obric.memorydata.memory.ailabprovider/memory_permission_status";
    private static final String URI_STATUS = "content://com.obric.memorydata.memory.ailabprovider/ai_lab_status";

    public IntelligentSettingItems(Context r1) {
        super(r1);
    }

    @Override // com.android.settings.settingitemsprovider.Items.SettingItems
    public void initItemList() {
        this.mItemList.add(new SettingItems.Items(this, R.string.system_intelligent_title, null, Constants.COMPONENT_INTELLIGENT, null, true, R.string.system_intelligent_title, null));
        boolean r13 = OAccountHelper.isLogin();
        this.mItemList.add(new SettingItems.Items(this, R.string.doubao_settings, null, Constants.COMPONENT_DOUBAO_SETTINGS, null, r13, buildPath(new int[]{R.string.system_intelligent_title, R.string.doubao_settings}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.doubao_settings_devices, null, Constants.COMPONENT_DOUBAO_SETTINGS, "sub_page=accessary_settings", r13, buildPath(new int[]{R.string.system_intelligent_title, R.string.doubao_settings_devices}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.doubao_assistant, null, Constants.COMPONENT_INTELLIGENT, null, r13, buildPath(new int[]{R.string.system_intelligent_title, R.string.doubao_assistant}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.assistant_activation, null, Constants.COMPONENT_ASSISTANT_ACTIVATION, null, r13, buildPath(new int[]{R.string.system_intelligent_title, R.string.assistant_activation}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.open_doubao_dialog, null, Constants.COMPONENT_ASSISTANT_ACTIVATION, null, r13, buildPath(new int[]{R.string.system_intelligent_title, R.string.assistant_activation, R.string.open_doubao_dialog}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.open_doubao_full_screen_application, null, Constants.COMPONENT_ASSISTANT_ACTIVATION, null, r13, buildPath(new int[]{R.string.system_intelligent_title, R.string.assistant_activation, R.string.open_doubao_full_screen_application}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.no_events, null, Constants.COMPONENT_ASSISTANT_ACTIVATION, null, r13, buildPath(new int[]{R.string.system_intelligent_title, R.string.assistant_activation, R.string.no_events}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.voice_call, null, Constants.COMPONENT_ASSISTANT_ACTIVATION, null, r13, buildPath(new int[]{R.string.system_intelligent_title, R.string.assistant_activation, R.string.voice_call}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.video_call, null, Constants.COMPONENT_ASSISTANT_ACTIVATION, null, r13, buildPath(new int[]{R.string.system_intelligent_title, R.string.assistant_activation, R.string.video_call}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.share_screen_call, null, Constants.COMPONENT_ASSISTANT_ACTIVATION, null, r13, buildPath(new int[]{R.string.system_intelligent_title, R.string.assistant_activation, R.string.share_screen_call}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.doubao_camera, null, Constants.COMPONENT_ASSISTANT_ACTIVATION, null, r13, buildPath(new int[]{R.string.system_intelligent_title, R.string.assistant_activation, R.string.doubao_camera}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.doubao_assistant_key_enable_ai_key_when_screen_off, null, true, SettingsSwitchKeyUtil.SettingTable.Global, AssistantActivationFragment.DOUBAO_SCREEN_OFF_AI_KEY_WAKE, null, "1", r13, buildPath(new int[]{R.string.system_intelligent_title, R.string.assistant_activation, R.string.doubao_assistant_key_enable_ai_key_when_screen_off}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.ai_key_sensitivity, null, Constants.COMPONENT_ASSISTANT_ACTIVATION, null, r13, buildPath(new int[]{R.string.system_intelligent_title, R.string.assistant_activation, R.string.ai_key_sensitivity}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.ailab_settings, null, Constants.COMPONENT_AI_LAB_SETTIINGS, null, false, buildPath(new int[]{R.string.system_intelligent_title, R.string.ailab_settings}), ""));
        this.mItemList.add(new SettingItems.Items(this, R.string.assistant_memory, null, Constants.COMPONENT_ASSISTANT_MEMORY, null, r13, buildPath(new int[]{R.string.system_intelligent_title, R.string.assistant_memory}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.assistant_call_forwarding, null, Constants.COMPONENT_ASSISTANT_CALL_FORWARDING, null, r13, buildPath(new int[]{R.string.system_intelligent_title, R.string.assistant_call_forwarding}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.assistant_recording_summary, null, Constants.COMPONENT_ASSISTANT_RECORDING_SUMMARY, null, r13, buildPath(new int[]{R.string.system_intelligent_title, R.string.assistant_recording_summary}), null));
    }

    public static void updateItems(final Handler r13, final Context r14, final SQLiteDatabase r15) {
        String r1 = "1";
        if (OAccountHelper.isLogin() == false) goto L5;
        String r0 = "1";
    L6:
        final String r10 = DatabaseHelper.ItemsRecord.IS_SEARCHABLE;
        final String r11 = "name";
        if (OAccountHelper.isLogin() == false) goto L9;
        Settings.Global.getInt(r14.getContentResolver(), IS_AUTO_RECORD_ENABLED, 0);
    L9:
        boolean r3 = !DoubaoAssistantEnabler.Companion.getAssistantDisabled(r14);
        if (OAccountHelper.isLogin() == false) goto L13;
        if (r3 == false) goto L13;
        String r12 = "1";
    L15:
        if (OAccountHelper.isLogin() == true) goto L17;
    L19:
        r1 = "0";
    L20:
        String r7 = r12;
        executeUpdate(r13, r14, r15, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r7, "name", r14.getString(R.string.doubao_settings));
        executeUpdate(r13, r14, r15, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r7, "name", r14.getString(R.string.doubao_assistant));
        executeUpdate(r13, r14, r15, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r7, "name", r14.getString(R.string.assistant_activation));
        executeUpdate(r13, r14, r15, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r7, "name", r14.getString(R.string.open_doubao_dialog));
        executeUpdate(r13, r14, r15, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r7, "name", r14.getString(R.string.open_doubao_full_screen_application));
        executeUpdate(r13, r14, r15, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r7, "name", r14.getString(R.string.no_events));
        executeUpdate(r13, r14, r15, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r7, "name", r14.getString(R.string.voice_call));
        executeUpdate(r13, r14, r15, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r7, "name", r14.getString(R.string.video_call));
        executeUpdate(r13, r14, r15, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r7, "name", r14.getString(R.string.share_screen_call));
        executeUpdate(r13, r14, r15, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r7, "name", r14.getString(R.string.doubao_camera));
        executeUpdate(r13, r14, r15, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r7, "name", r14.getString(R.string.doubao_settings_devices));
        executeUpdate(r13, r14, r15, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r7, "name", r14.getString(R.string.doubao_assistant_key_enable_ai_key_when_screen_off));
        ThreadUtils.postOnBackgroundThread(new IntelligentSettingItems$$ExternalSyntheticLambda1(r14, r13, r15, r10, r11));
        executeUpdate(r13, r14, r15, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r1, "name", r14.getString(R.string.assistant_memory));
        SystemIntelligentFragment.refreshEnterpriseAccountStatus(r14, new IntelligentSettingItems$$ExternalSyntheticLambda2(r13, r14, r15, r10, r11));
        String r8 = r0;
        executeUpdate(r13, r14, r15, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r8, "name", r14.getString(R.string.assistant_call_forwarding));
        executeUpdate(r13, r14, r15, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r8, "name", r14.getString(R.string.assistant_recording_summary));
        return;
    L17:
        if (SystemIntelligentFragment.shouldShowNonEnterpriseAccountItems(r14) == false) goto L19;
    L13:
        r12 = "0";
        goto L15
    L5:
        r0 = "0";
        goto L6
    }

    static /* synthetic */ void lambda$updateItems$0(Context r8, Handler r9, SQLiteDatabase r10, String r11, String r12) {
        Pair<Integer, Integer> r0 = getAILabState(r8);
        if (((Integer) r0.first).intValue() != 4) goto L5;
    L7:
        boolean r1 = false;
    L9:
        if (OAccountHelper.isLogin() == false) goto L12;
        if (r1 == false) goto L12;
        String r2 = "1";
    L13:
        executeUpdate(r9, r8, r10, r11, r2, r12, r8.getString(R.string.ailab_settings));
        return;
    L12:
        r2 = "0";
        goto L13
    L5:
        if (((Integer) r0.first).intValue() == 0) goto L7;
        r1 = true;
        goto L9
    }

    static /* synthetic */ void lambda$updateItems$1(Handler r7, Context r8, SQLiteDatabase r9, String r10, String r11, boolean r12) {
        if (OAccountHelper.isLogin() == false) goto L6;
        if (r12 == true) goto L6;
        String r13 = "1";
    L7:
        executeUpdate(r7, r8, r9, r10, r13, r11, r8.getString(R.string.assistant_memory));
        return;
    L6:
        r13 = "0";
        goto L7
    }

    public static void updateAILabItems(final Handler r6, final Context r7, final SQLiteDatabase r8, boolean r9) {
        final String r4 = DatabaseHelper.ItemsRecord.IS_SEARCHABLE;
        final String r5 = "name";
        ThreadUtils.postOnBackgroundThread(new IntelligentSettingItems$$ExternalSyntheticLambda0(r7, r6, r8, r4, r5));
    }

    static /* synthetic */ void lambda$updateAILabItems$2(Context r8, Handler r9, SQLiteDatabase r10, String r11, String r12) {
        Pair<Integer, Integer> r0 = getAILabState(r8);
        if (((Integer) r0.first).intValue() != 4) goto L5;
    L7:
        boolean r1 = false;
    L9:
        if (OAccountHelper.isLogin() == false) goto L12;
        if (r1 == false) goto L12;
        String r2 = "1";
    L13:
        executeUpdate(r9, r8, r10, r11, r2, r12, r8.getString(R.string.ailab_settings));
        return;
    L12:
        r2 = "0";
        goto L13
    L5:
        if (((Integer) r0.first).intValue() == 0) goto L7;
        r1 = true;
        goto L9
    }

    public static void updateAssistantItems(Handler r9, Context r10, SQLiteDatabase r11, boolean r12) {
        if (OAccountHelper.isLogin() == false) goto L6;
        if (r12 == false) goto L6;
        String r13 = "1";
    L7:
        String r4 = r13;
        executeUpdate(r9, r10, r11, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r4, "name", r10.getString(R.string.doubao_settings));
        executeUpdate(r9, r10, r11, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r4, "name", r10.getString(R.string.doubao_assistant));
        executeUpdate(r9, r10, r11, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r4, "name", r10.getString(R.string.assistant_activation));
        executeUpdate(r9, r10, r11, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r4, "name", r10.getString(R.string.open_doubao_dialog));
        executeUpdate(r9, r10, r11, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r4, "name", r10.getString(R.string.open_doubao_full_screen_application));
        executeUpdate(r9, r10, r11, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r4, "name", r10.getString(R.string.no_events));
        executeUpdate(r9, r10, r11, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r4, "name", r10.getString(R.string.voice_call));
        executeUpdate(r9, r10, r11, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r4, "name", r10.getString(R.string.video_call));
        executeUpdate(r9, r10, r11, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r4, "name", r10.getString(R.string.share_screen_call));
        executeUpdate(r9, r10, r11, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r4, "name", r10.getString(R.string.doubao_camera));
        executeUpdate(r9, r10, r11, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r4, "name", r10.getString(R.string.doubao_settings_devices));
        executeUpdate(r9, r10, r11, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r4, "name", r10.getString(R.string.doubao_assistant_key_enable_ai_key_when_screen_off));
        executeUpdate(r9, r10, r11, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r4, "name", r10.getString(R.string.assistant_call_forwarding));
        executeUpdate(r9, r10, r11, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r4, "name", r10.getString(R.string.assistant_recording_summary));
        return;
    L6:
        r13 = "0";
        goto L7
    }

    private static Pair<Integer, Integer> getAILabState(Context r7) {
        if (r7 == null) goto L5;
        Uri r4 = Uri.parse(URI_STATUS);
        Uri r5 = Uri.parse(URI_PERMISSION_STATUS);
        ContentProviderClient r6 = r7.getContentResolver().acquireUnstableContentProviderClient(r4);     // Catch: Throwable -> L22 RemoteException -> L26 DeadObjectException -> L30
        if (r6 != null) goto L12;
        Pair<Integer, Integer> r8 = new Pair(0, 0);     // Catch: Throwable -> L22 RemoteException -> L26 DeadObjectException -> L30
        releaseQuietly(r6);
        return r8;
    L12:
        Integer r9 = readStatus(r6, r4);     // Catch: Throwable -> L22 RemoteException -> L26 DeadObjectException -> L30
        Integer r10 = readStatus(r6, r5);     // Catch: Throwable -> L22 RemoteException -> L26 DeadObjectException -> L30
        if (r9 == null) goto L19;
        if (r10 == null) goto L19;
        Pair<Integer, Integer> r11 = new Pair(r9, r10);     // Catch: Throwable -> L22 RemoteException -> L26 DeadObjectException -> L30
        releaseQuietly(r6);
        return r11;
    L19:
        Pair<Integer, Integer> r12 = new Pair(0, 0);     // Catch: Throwable -> L22 RemoteException -> L26 DeadObjectException -> L30
        releaseQuietly(r6);
        return r12;
    L33:
        th = move-exception;
        releaseQuietly(null);
        throw th;
    L30:
        Pair<Integer, Integer> r13 = new Pair(0, 0);     // Catch: Throwable -> L33
        releaseQuietly(null);
        return r13;
    L26:
        e = move-exception;
        OLog.e("SettingItems", "getAILabState RemoteException: " + e.getMessage());     // Catch: Throwable -> L33
        Pair<Integer, Integer> r14 = new Pair(0, 0);     // Catch: Throwable -> L33
        releaseQuietly(null);
        return r14;
    L22:
        th = move-exception;
        OLog.e("SettingItems", "初始化权限逻辑失败:" + th.getMessage());     // Catch: Throwable -> L33
        Pair<Integer, Integer> r15 = new Pair(0, 0);     // Catch: Throwable -> L33
        releaseQuietly(null);
        return r15;
    L5:
        return new Pair(0, 0);
    }

    private static Integer readStatus(ContentProviderClient r7, Uri r8) throws RemoteException {
        Cursor r6 = null;
        Integer r9 = null;
        Cursor r10 = r7.query(r8, null, null, null, null);     // Catch: Throwable -> L17
        if (r10 != null) goto L22;
    L15:
        closeQuietly(r10);
        return null;
    L22:
    L13:
        th = th;
        r6 = r10;
    L18:
        closeQuietly(r6);
        throw th;
    L6:
        if (r10.moveToFirst() == false) goto L15;
        int r11 = r10.getColumnIndex("status");     // Catch: Throwable -> L13
        if (r11 < 0) goto L11;
        r9 = Integer.valueOf(r10.getInt(r11));     // Catch: Throwable -> L13
    L11:
        closeQuietly(r10);
        return r9;
    L17:
        th = th;
        goto L18
    }

    private static void closeQuietly(AutoCloseable r0) {
        if (r0 != null) goto L7;
        return;
    L7:
        r0.close();     // Catch: Throwable -> L6
        return;
    }

    private static void releaseQuietly(ContentProviderClient r0) {
        if (r0 != null) goto L7;
        return;
    L7:
        r0.close();     // Catch: Throwable -> L6
        return;
    }
}
