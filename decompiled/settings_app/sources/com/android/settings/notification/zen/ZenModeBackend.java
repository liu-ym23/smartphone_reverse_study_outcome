package com.android.settings.notification.zen;

import android.app.ActivityManager;
import android.app.AutomaticZenRule;
import android.app.NotificationManager;
import android.content.Context;
import android.database.Cursor;
import android.icu.text.MessageFormat;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.service.notification.ZenAdapters;
import android.service.notification.ZenModeConfig;
import android.service.notification.ZenPolicy;
import com.android.settings.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ZenModeBackend {
    public static final Comparator<Map.Entry<String, AutomaticZenRule>> RULE_COMPARATOR = null;
    protected static final int SOURCE_NONE = -1;
    private static final String TAG = "ZenModeSettingsBackend";
    protected static final String ZEN_MODE_FROM_ANYONE = "zen_mode_from_anyone";
    protected static final String ZEN_MODE_FROM_CONTACTS = "zen_mode_from_contacts";
    protected static final String ZEN_MODE_FROM_NONE = "zen_mode_from_none";
    protected static final String ZEN_MODE_FROM_STARRED = "zen_mode_from_starred";
    private static ZenModeBackend sInstance;
    private final Context mContext;
    private final NotificationManager mNotificationManager;
    protected NotificationManager.Policy mPolicy;
    protected int mZenMode;

    private int clearDeprecatedEffects(int r1) {
        return r1 & (-4);
    }

    protected static int getContactSettingFromZenPolicySetting(int r2) {
        if (r2 != 1) goto L5;
        return 0;
    L5:
        if (r2 != 2) goto L7;
        return 1;
    L7:
        if (r2 == 3) goto L10;
        return -1;
    L10:
        return 2;
    }

    protected static String getKeyFromSetting(int r1) {
        if (r1 != 0) goto L4;
        return ZEN_MODE_FROM_ANYONE;
    L4:
        if (r1 != 1) goto L6;
        return ZEN_MODE_FROM_CONTACTS;
    L6:
        if (r1 == 2) goto L9;
        return ZEN_MODE_FROM_NONE;
    L9:
        return ZEN_MODE_FROM_STARRED;
    }

    protected static String getKeyFromZenPolicySetting(int r1) {
        if (r1 != 1) goto L5;
        return ZEN_MODE_FROM_ANYONE;
    L5:
        if (r1 != 2) goto L7;
        return ZEN_MODE_FROM_CONTACTS;
    L7:
        if (r1 == 3) goto L10;
        return ZEN_MODE_FROM_NONE;
    L10:
        return ZEN_MODE_FROM_STARRED;
    }

    protected int getAlarmsTotalSilencePeopleSummary(int r1) {
        if (r1 != 4) goto L7;
        return R.string.zen_mode_none_messages;
    L7:
        if (r1 != 8) goto L10;
        return R.string.zen_mode_none_calls;
    L10:
        return R.string.zen_mode_from_no_conversations;
    }

    static /* synthetic */ List access$000() {
        return getDefaultRuleIds();
    }

    public static ZenModeBackend getInstance(Context r1) {
        if (sInstance != null) goto L6;
        sInstance = new ZenModeBackend(r1);
    L6:
        return sInstance;
    }

    public ZenModeBackend(Context r2) {
        this.mContext = r2;
        this.mNotificationManager = (NotificationManager) r2.getSystemService("notification");
        updateZenMode();
        updatePolicy();
    }

    protected void updatePolicy() {
        NotificationManager r0 = this.mNotificationManager;
        if (r0 == null) goto L6;
        this.mPolicy = r0.getNotificationPolicy();
        return;
    }

    protected void updateZenMode() {
        this.mZenMode = Settings.Global.getInt(this.mContext.getContentResolver(), "zen_mode", this.mZenMode);
    }

    protected boolean updateZenRule(String r2, AutomaticZenRule r3) {
        return this.mNotificationManager.updateAutomaticZenRule(r2, r3, true);
    }

    protected void setZenMode(int r5) {
        this.mNotificationManager.setZenMode(r5, null, TAG, true);
        this.mZenMode = getZenMode();
    }

    protected void setZenModeForDuration(int r4) {
        Uri r5 = ZenModeConfig.toTimeCondition(this.mContext, r4, ActivityManager.getCurrentUser(), true).id;
        this.mNotificationManager.setZenMode(1, r5, TAG, true);
        this.mZenMode = getZenMode();
    }

    protected int getZenMode() {
        int r0 = Settings.Global.getInt(this.mContext.getContentResolver(), "zen_mode", this.mZenMode);
        this.mZenMode = r0;
        return r0;
    }

    protected boolean isVisualEffectSuppressed(int r1) {
        if ((this.mPolicy.suppressedVisualEffects & r1) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    protected boolean isPriorityCategoryEnabled(int r1) {
        if ((this.mPolicy.priorityCategories & r1) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    protected int getNewDefaultPriorityCategories(boolean r1, int r2) {
        int r0 = this.mPolicy.priorityCategories;
        if (r1 == false) goto L6;
        return r0 | r2;
    L6:
        return r0 & (~r2);
    }

    protected int getPriorityCallSenders() {
        if (isPriorityCategoryEnabled(8) == true) goto L5;
        return -1;
    L5:
        return this.mPolicy.priorityCallSenders;
    }

    protected int getPriorityMessageSenders() {
        if (isPriorityCategoryEnabled(4) == true) goto L5;
        return -1;
    L5:
        return this.mPolicy.priorityMessageSenders;
    }

    protected int getPriorityConversationSenders() {
        if (isPriorityCategoryEnabled(256) == true) goto L5;
        return 3;
    L5:
        return this.mPolicy.priorityConversationSenders;
    }

    protected void saveVisualEffectsPolicy(int r7, boolean r8) {
        int r4 = getNewSuppressedEffects(r8, r7);
        savePolicy(this.mPolicy.priorityCategories, this.mPolicy.priorityCallSenders, this.mPolicy.priorityMessageSenders, r4, this.mPolicy.priorityConversationSenders);
    }

    protected void saveSoundPolicy(int r7, boolean r8) {
        savePolicy(getNewDefaultPriorityCategories(r8, r7), this.mPolicy.priorityCallSenders, this.mPolicy.priorityMessageSenders, this.mPolicy.suppressedVisualEffects, this.mPolicy.priorityConversationSenders);
    }

    protected void savePolicy(int r8, int r9, int r10, int r11, int r12) {
        NotificationManager.Policy r6 = new NotificationManager.Policy(r8, r9, r10, r11, r12);
        this.mPolicy = r6;
        this.mNotificationManager.setNotificationPolicy(r6, true);
    }

    private int getNewSuppressedEffects(boolean r2, int r3) {
        int r0 = this.mPolicy.suppressedVisualEffects;
        if (r2 == false) goto L5;
        int r4 = r0 | r3;
    L7:
        return clearDeprecatedEffects(r4);
    L5:
        r4 = (~r3) & r0;
        goto L7
    }

    protected boolean isEffectAllowed(int r1) {
        if ((this.mPolicy.suppressedVisualEffects & r1) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    protected void saveSenders(int r12, int r13) {
        int r0 = getPriorityCallSenders();
        int r1 = getPriorityMessageSenders();
        int r2 = getPrioritySenders(r12);
        if (r13 == (-1)) goto L5;
        boolean r4 = true;
    L6:
        if (r13 != (-1)) goto L9;
        r13 = r2;
    L9:
        if (r12 != 8) goto L11;
        int r7 = r13;
    L13:
        if (r12 != 4) goto L15;
        int r8 = r13;
    L16:
        savePolicy(getNewDefaultPriorityCategories(r4, r12), r7, r8, this.mPolicy.suppressedVisualEffects, this.mPolicy.priorityConversationSenders);
        return;
    L15:
        r8 = r1;
        goto L16
    L11:
        r7 = r0;
        goto L13
    L5:
        r4 = false;
        goto L6
    }

    protected void saveConversationSenders(int r9) {
        if (r9 == 3) goto L5;
        boolean r0 = true;
    L6:
        savePolicy(getNewDefaultPriorityCategories(r0, 256), this.mPolicy.priorityCallSenders, this.mPolicy.priorityMessageSenders, this.mPolicy.suppressedVisualEffects, r9);
        return;
    L5:
        r0 = false;
        goto L6
    }

    private int getPrioritySenders(int r2) {
        if (r2 != 8) goto L7;
        return getPriorityCallSenders();
    L7:
        if (r2 != 4) goto L11;
        return getPriorityMessageSenders();
    L11:
        if (r2 == 256) goto L13;
        return -1;
    L13:
        return getPriorityConversationSenders();
    }

    protected int getContactsCallsSummary(ZenPolicy r1) {
        int r0 = r1.getPriorityCallSenders();
        if (r0 != 1) goto L5;
        return R.string.zen_mode_from_anyone;
    L5:
        if (r0 != 2) goto L7;
        return R.string.zen_mode_from_contacts;
    L7:
        if (r0 == 3) goto L10;
        return R.string.zen_mode_none_calls;
    L10:
        return R.string.zen_mode_from_starred;
    }

    protected int getContactsMessagesSummary(ZenPolicy r1) {
        int r0 = r1.getPriorityMessageSenders();
        if (r0 != 1) goto L5;
        return R.string.zen_mode_from_anyone;
    L5:
        if (r0 != 2) goto L7;
        return R.string.zen_mode_from_contacts;
    L7:
        if (r0 == 3) goto L10;
        return R.string.zen_mode_none_messages;
    L10:
        return R.string.zen_mode_from_starred;
    }

    protected static int getZenPolicySettingFromPrefKey(String r4) {
        switch(r4.hashCode()) {
            case -946901971: goto L15;
            case -423126328: goto L12;
            case 187510959: goto L9;
            case 462773226: goto L6;
            default: goto L17;
        };
    L17:
        byte r5 = -1;
    L18:
        if (r5 == 0) goto L25;
        if (r5 == 1) goto L24;
        if (r5 == 2) goto L23;
        return 4;
    L23:
        return 3;
    L24:
        return 2;
    L25:
        return 1;
    L6:
        if (r4.equals(ZEN_MODE_FROM_STARRED) == false) goto L17;
        r5 = 2;
        goto L18
    L9:
        if (r4.equals(ZEN_MODE_FROM_ANYONE) == false) goto L17;
        r5 = 0;
        goto L18
    L12:
        if (r4.equals(ZEN_MODE_FROM_CONTACTS) == false) goto L17;
        r5 = 1;
        goto L18
    L15:
        if (r4.equals(ZEN_MODE_FROM_NONE) == false) goto L17;
        r5 = 3;
        goto L18
    }

    public boolean removeZenRule(String r2) {
        return this.mNotificationManager.removeAutomaticZenRule(r2, true);
    }

    public NotificationManager.Policy getConsolidatedPolicy() {
        return NotificationManager.from(this.mContext).getConsolidatedNotificationPolicy();
    }

    protected String addZenRule(AutomaticZenRule r2) {
        return this.mNotificationManager.addAutomaticZenRule(r2, true);
    L4:
        return null;
    }

    ZenPolicy setDefaultZenPolicy(ZenPolicy r5) {
        int r1 = 4;
        if (this.mPolicy.allowCalls() == false) goto L5;
        int r0 = ZenAdapters.prioritySendersToPeopleType(this.mPolicy.allowCallsFrom());
    L7:
        if (this.mPolicy.allowMessages() == false) goto L10;
        r1 = ZenAdapters.prioritySendersToPeopleType(this.mPolicy.allowMessagesFrom());
    L10:
        if (this.mPolicy.allowConversations() == false) goto L12;
        int r2 = this.mPolicy.allowConversationsFrom();
    L14:
        return new ZenPolicy.Builder(r5).allowAlarms(this.mPolicy.allowAlarms()).allowCalls(r0).allowEvents(this.mPolicy.allowEvents()).allowMedia(this.mPolicy.allowMedia()).allowMessages(r1).allowConversations(r2).allowReminders(this.mPolicy.allowReminders()).allowRepeatCallers(this.mPolicy.allowRepeatCallers()).allowSystem(this.mPolicy.allowSystem()).showFullScreenIntent(this.mPolicy.showFullScreenIntents()).showLights(this.mPolicy.showLights()).showInAmbientDisplay(this.mPolicy.showAmbient()).showInNotificationList(this.mPolicy.showInNotificationList()).showBadges(this.mPolicy.showBadges()).showPeeking(this.mPolicy.showPeeking()).showStatusBarIcons(this.mPolicy.showStatusBarIcons()).build();
    L12:
        r2 = 3;
        goto L14
    L5:
        r0 = 4;
        goto L7
    }

    protected Map.Entry<String, AutomaticZenRule>[] getAutomaticZenRules() {
        Map<String, AutomaticZenRule> r1 = NotificationManager.from(this.mContext).getAutomaticZenRules();
        Map.Entry<String, AutomaticZenRule>[] r2 = (Map.Entry[]) r1.entrySet().toArray(new Map.Entry[r1.size()]);
        Arrays.sort(r2, RULE_COMPARATOR);
        return r2;
    }

    protected AutomaticZenRule getAutomaticZenRule(String r1) {
        return NotificationManager.from(this.mContext).getAutomaticZenRule(r1);
    }

    private static List<String> getDefaultRuleIds() {
        return ZenModeConfig.getDefaultRuleIds();
    }

    NotificationManager.Policy toNotificationPolicy(ZenPolicy r1) {
        return new ZenModeConfig().toNotificationPolicy(r1);
    }

    List<String> getStarredContacts(Cursor r4) {
        ArrayList r0 = new ArrayList();
        if (r4 != null) goto L5;
    L12:
        return r0;
    L5:
        if (r4.moveToFirst() == false) goto L12;
    L6:
        String r1 = r4.getString(0);
        if (r1 != null) goto L10;
        r1 = this.mContext.getString(R.string.zen_mode_starred_contacts_empty_name);
    L10:
        r0.add(r1);
        if (r4.moveToNext() == true) goto L6;
        goto L12
    }

    private List<String> getStarredContacts() {
        Cursor r0 = queryStarredContactsData();     // Catch: Throwable -> L9
        List<String> r1 = getStarredContacts(r0);     // Catch: Throwable -> L7
        if (r0 == null) goto L6;
        r0.close();
    L6:
        return r1;
    L7:
        th = th;
    L11:
        if (r0 == null) goto L13;
        r0.close();
    L13:
        throw th;
    L9:
        th = th;
        r0 = null;
        goto L11
    }

    String getStarredContactsSummary(Context r6) {
        List<String> r7 = getStarredContacts();
        int r0 = r7.size();
        MessageFormat r1 = new MessageFormat(this.mContext.getString(R.string.zen_mode_starred_contacts_summary_contacts), Locale.getDefault());
        HashMap r5 = new HashMap();
        r5.put("count", Integer.valueOf(r0));
        if (r0 < 1) goto L10;
        r5.put("contact_1", r7.get(0));
        if (r0 < 2) goto L10;
        r5.put("contact_2", r7.get(1));
        if (r0 != 3) goto L10;
        r5.put("contact_3", r7.get(2));
    L10:
        return r1.format(r5);
    }

    String getContactsNumberSummary(Context r3) {
        MessageFormat r4 = new MessageFormat(this.mContext.getString(R.string.zen_mode_contacts_count), Locale.getDefault());
        HashMap r0 = new HashMap();
        r0.put("count", Integer.valueOf(queryAllContactsData().getCount()));
        return r4.format(r0);
    }

    private Cursor queryStarredContactsData() {
        return this.mContext.getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, new String[]{"display_name"}, "starred=1", null, "times_contacted");
    }

    private Cursor queryAllContactsData() {
        return this.mContext.getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, new String[]{"display_name"}, null, null, null);
    }

    static {
        RULE_COMPARATOR = new AnonymousClass1();
    }
}
