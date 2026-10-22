package com.android.settings.textboom.db;

import android.net.Uri;
import android.provider.BaseColumns;

/* JADX INFO: loaded from: classes2.dex */
public class OcrAppInfoColumn {
    public static final String AUTHORITY = "com.android.settings.ocrappinfo";
    public static Uri CONTENT_URI = null;
    public static final String TABLE_NAME = "apps";

    public static class ItemsRecord implements BaseColumns {
        public static final String COLUMN_CAN_BOOM = "can_boom";
        public static final String COLUMN_DELETED = "deleted";
        public static final String COLUMN_DIRTY = "dirty";
        public static final String COLUMN_PACKAGE_NAME = "package_name";
        public static final String COLUMN_SYNC_ID = "sync_id";

        public ItemsRecord() {
        }
    }

    public OcrAppInfoColumn() {
    }

    static {
        CONTENT_URI = Uri.parse("content://com.android.settings.ocrappinfo/appinfo");
    }
}
