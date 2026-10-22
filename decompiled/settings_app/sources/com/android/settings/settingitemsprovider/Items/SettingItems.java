package com.android.settings.settingitemsprovider.Items;

import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteStatement;
import android.os.Handler;
import com.android.settings.SettingsApplication;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class SettingItems {
    static final String TAG = "SettingItems";
    protected Context mContext;
    protected List<Items> mItemList;

    public class Items {
        public String alias;
        public String defValue;
        public String description;
        public String extra;
        public String intent;
        public boolean isSearchable;
        public boolean isSwitch;
        public String itemPath;
        public String name;
        public String specialKey;
        public String switchKey;
        public String switchTable;
        final /* synthetic */ SettingItems this$0;

        public Items(SettingItems r2, int r3, int r4, String r5, String r6, boolean r7, String r8, String r9) {
            this.this$0 = r2;
            this.name = r2.mContext.getString(r3);
            this.alias = r2.mContext.getString(r4);
            this.intent = r5;
            this.extra = r6;
            this.isSearchable = r7;
            this.itemPath = r8;
            this.description = r9;
        }

        public Items(SettingItems r1, int r2, String r3, String r4, String r5, boolean r6, String r7, String r8) {
            this.this$0 = r1;
            this.name = r1.mContext.getString(r2);
            this.alias = r3;
            this.intent = r4;
            this.extra = r5;
            this.isSearchable = r6;
            this.itemPath = r7;
            this.description = r8;
        }

        public Items(SettingItems r2, int r3, int r4, String r5, String r6, boolean r7, int r8, int r9) {
            this.this$0 = r2;
            this.name = r2.mContext.getString(r3);
            this.alias = r2.mContext.getString(r4);
            this.intent = r5;
            this.extra = r6;
            this.isSearchable = r7;
            this.itemPath = r2.mContext.getString(r8);
            this.description = r2.mContext.getString(r9);
        }

        public Items(SettingItems r2, int r3, int r4, String r5, String r6, boolean r7, String r8, int r9) {
            this.this$0 = r2;
            this.name = r2.mContext.getString(r3);
            this.alias = r2.mContext.getString(r4);
            this.intent = r5;
            this.extra = r6;
            this.isSearchable = r7;
            this.itemPath = r8;
            this.description = r2.mContext.getString(r9);
        }

        public Items(SettingItems r2, int r3, String r4, String r5, String r6, boolean r7, int r8, int r9) {
            this.this$0 = r2;
            this.name = r2.mContext.getString(r3);
            this.alias = r4;
            this.intent = r5;
            this.extra = r6;
            this.isSearchable = r7;
            this.itemPath = r2.mContext.getString(r8);
            this.description = r2.mContext.getString(r9);
        }

        public Items(SettingItems r2, int r3, String r4, String r5, String r6, boolean r7, String r8, int r9) {
            this.this$0 = r2;
            this.name = r2.mContext.getString(r3);
            this.alias = r4;
            this.intent = r5;
            this.extra = r6;
            this.isSearchable = r7;
            this.itemPath = r8;
            this.description = r2.mContext.getString(r9);
        }

        public Items(SettingItems r1, String r2, String r3, String r4, String r5, boolean r6, String r7, int r8) {
            this.this$0 = r1;
            this.name = r2;
            this.alias = r3;
            this.intent = r4;
            this.extra = r5;
            this.isSearchable = r6;
            this.itemPath = r7;
            this.description = r1.mContext.getString(r8);
        }

        public Items(SettingItems r2, int r3, String r4, String r5, String r6, boolean r7, int r8, String r9) {
            this.this$0 = r2;
            this.name = r2.mContext.getString(r3);
            this.alias = r4;
            this.intent = r5;
            this.extra = r6;
            this.isSearchable = r7;
            this.itemPath = r2.mContext.getString(r8);
            this.description = r9;
        }

        public Items(SettingItems r2, int r3, int r4, String r5, String r6, boolean r7, int r8, String r9) {
            this.this$0 = r2;
            this.name = r2.mContext.getString(r3);
            this.alias = r2.mContext.getString(r4);
            this.intent = r5;
            this.extra = r6;
            this.isSearchable = r7;
            this.itemPath = r2.mContext.getString(r8);
            this.description = r9;
        }

        public Items(SettingItems r1, String r2, String r3, String r4, String r5, boolean r6, String r7, String r8) {
            this.this$0 = r1;
            this.name = r2;
            this.alias = r3;
            this.intent = r4;
            this.extra = r5;
            this.isSearchable = r6;
            this.itemPath = r7;
            this.description = r8;
        }

        public Items(SettingItems r2, int r3, int r4, boolean r5, String r6, String r7, String r8, String r9, boolean r10, String r11, String r12) {
            this.this$0 = r2;
            this.name = r2.mContext.getString(r3);
            this.alias = r2.mContext.getString(r4);
            this.isSwitch = r5;
            this.switchTable = r6;
            this.switchKey = r7;
            this.specialKey = r8;
            this.defValue = r9;
            this.isSearchable = r10;
            this.itemPath = r11;
            this.description = r12;
        }

        public Items(SettingItems r1, int r2, String r3, boolean r4, String r5, String r6, String r7, String r8, boolean r9, String r10, String r11) {
            this.this$0 = r1;
            this.name = r1.mContext.getString(r2);
            this.alias = r3;
            this.isSwitch = r4;
            this.switchTable = r5;
            this.switchKey = r6;
            this.specialKey = r7;
            this.defValue = r8;
            this.isSearchable = r9;
            this.itemPath = r10;
            this.description = r11;
        }

        public Items(SettingItems r1, String r2, String r3, boolean r4, String r5, String r6, String r7, String r8, boolean r9, String r10, String r11) {
            this.this$0 = r1;
            this.name = r2;
            this.alias = r3;
            this.isSwitch = r4;
            this.switchTable = r5;
            this.switchKey = r6;
            this.specialKey = r7;
            this.defValue = r8;
            this.isSearchable = r9;
            this.itemPath = r10;
            this.description = r11;
        }

        public Items(SettingItems r1, String r2, String r3, boolean r4, String r5, String r6, String r7, String r8, boolean r9, String r10, int r11) {
            this.this$0 = r1;
            this.name = r2;
            this.alias = r3;
            this.isSwitch = r4;
            this.switchTable = r5;
            this.switchKey = r6;
            this.specialKey = r7;
            this.defValue = r8;
            this.isSearchable = r9;
            this.itemPath = r10;
            this.description = r1.mContext.getString(r11);
        }

        public Items(SettingItems r2, int r3, String r4, boolean r5, String r6, String r7, String r8, String r9, boolean r10, String r11, int r12) {
            this.this$0 = r2;
            this.name = r2.mContext.getString(r3);
            this.alias = r4;
            this.isSwitch = r5;
            this.switchTable = r6;
            this.switchKey = r7;
            this.specialKey = r8;
            this.defValue = r9;
            this.isSearchable = r10;
            this.itemPath = r11;
            this.description = r2.mContext.getString(r12);
        }

        public Items(SettingItems r1, String r2, String r3, String r4, boolean r5, String r6, String r7, String r8, String r9, boolean r10, String r11, String r12) {
            this.this$0 = r1;
            this.name = r2;
            this.intent = r3;
            this.extra = r4;
            this.isSwitch = r5;
            this.switchTable = r6;
            this.switchKey = r7;
            this.specialKey = r8;
            this.defValue = r9;
            this.isSearchable = r10;
            this.itemPath = r11;
            this.description = r12;
        }
    }

    static class SettingsTable {
        static final String Global = "global";
        static final String Secure = "secure";
        static final String System = "system";

        SettingsTable() {
        }
    }

    public abstract void initItemList();

    public SettingItems(Context r2) {
        this.mItemList = new ArrayList();
        this.mContext = r2;
        initItemList();
    }

    public void loadItems(SQLiteStatement r10) {
        int r0 = 0;
    L4:
        if (r0 >= this.mItemList.size()) goto L54;
        Items r1 = this.mItemList.get(r0);
        r10.bindString(1, r1.name);
        if (r1.alias == null) goto L8;
        r10.bindString(2, r1.alias);
    L10:
        if (r1.intent == null) goto L12;
        r10.bindString(3, r1.intent);
    L14:
        if (r1.extra == null) goto L16;
        r10.bindString(4, r1.extra);
    L17:
        long r3 = 1;
        if (r1.isSwitch == false) goto L20;
        long r7 = 1;
    L21:
        r10.bindLong(5, r7);
        if (r1.switchTable == null) goto L24;
        r10.bindString(6, r1.switchTable);
    L26:
        if (r1.switchKey == null) goto L28;
        r10.bindString(7, r1.switchKey);
    L30:
        if (r1.specialKey == null) goto L32;
        r10.bindString(8, r1.specialKey);
    L34:
        if (r1.defValue == null) goto L36;
        r10.bindString(9, r1.defValue);
    L38:
        if (r1.isSearchable == true) goto L41;
        r3 = 0;
    L41:
        r10.bindLong(10, r3);
        r10.bindNull(11);
        if (r1.itemPath == null) goto L44;
        r10.bindString(12, r1.itemPath);
    L45:
        r10.bindNull(13);
        r10.bindNull(14);
        if (r1.description == null) goto L48;
        r10.bindString(15, r1.description);
    L55:
        r10.execute();     // Catch: SQLiteDiskIOException -> L51
    L53:
        r0 = r0 + 1;
    L51:
        e = move-exception;
        e.printStackTrace();
        OLog.e(TAG, "execute error " + e.getMessage());
        goto L53
    L48:
        r10.bindNull(15);
        goto L55
    L44:
        r10.bindNull(12);
        goto L45
    L36:
        r10.bindNull(9);
        goto L38
    L32:
        r10.bindNull(8);
        goto L34
    L28:
        r10.bindNull(7);
        goto L30
    L24:
        r10.bindNull(6);
        goto L26
    L20:
        r7 = 0;
        goto L21
    L16:
        r10.bindNull(4);
        goto L17
    L12:
        r10.bindNull(3);
        goto L14
    L8:
        r10.bindNull(2);
        goto L10
    }

    public static void executeUpdate(Handler r8, final Context r9, final SQLiteDatabase r10, final String r11, final String r12, final String r13, final String r14) {
        r8.post(new AnonymousClass1(r10, r11, r12, r13, r14, r9));
    }

    public List<Items> getItemList() {
        return this.mItemList;
    }

    public static String buildPath(String... r3) {
        StringBuilder r0 = new StringBuilder();
        int r1 = 0;
    L4:
        if (r1 >= r3.length) goto L10;
        r0.append(r3[r1]);
        if (r1 >= (r3.length - 1)) goto L8;
        r0.append(" > ");
    L8:
        r1 = r1 + 1;
        goto L4
    L10:
        return r0.toString();
    }

    public static String buildPath(int... r4) {
        StringBuilder r0 = new StringBuilder();
        int r1 = 0;
    L4:
        if (r1 >= r4.length) goto L10;
        r0.append(SettingsApplication.getContext().getString(r4[r1]));
        if (r1 >= (r4.length - 1)) goto L8;
        r0.append(" > ");
    L8:
        r1 = r1 + 1;
        goto L4
    L10:
        return r0.toString();
    }

    public String buildPath(String r5, int... r6) {
        StringBuilder r0 = new StringBuilder(r5);
        int r7 = r6.length;
        int r1 = 0;
    L3:
        if (r1 >= r7) goto L6;
        int r2 = r6[r1];
        r0.append(" > ");
        r0.append(this.mContext.getString(r2));
        r1 = r1 + 1;
        goto L3
    L6:
        return r0.toString();
    }

    public static String getPackageString(Context r1, String r2, String r3) {
        return getContextString(r1.createPackageContext(r2, 2), r3);
    L5:
        e = move-exception;
        OLog.e(TAG, "Can not find " + r2 + " Context: ", e);
        return "";
    }

    public static String getContextString(Context r3, String r4) {
        int r5 = r3.getResources().getIdentifier(r4, "string", r3.getPackageName());     // Catch: Resources.NotFoundException -> L6
        if (r5 <= 0) goto L12;
        return r3.getString(r5);
    L12:
        return "";
    L6:
        e = move-exception;
        e.printStackTrace();
        OLog.e(TAG, "Resources not found ! \nContext: " + r3.getPackageName());
        return "";
    }
}
