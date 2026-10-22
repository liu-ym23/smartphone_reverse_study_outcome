package com.android.settings;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.android.settings.AppWidgetLoader.LabelledItem;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AppWidgetLoader<Item extends LabelledItem> {
    private static final boolean LOGD = false;
    private static final String TAG = "AppWidgetAdapter";
    private AppWidgetManager mAppWidgetManager;
    private Context mContext;
    ItemConstructor<Item> mItemConstructor;

    public interface ItemConstructor<Item> {
        Item createItem(Context r1, AppWidgetProviderInfo r2, Bundle r3);
    }

    interface LabelledItem {
        CharSequence getLabel();
    }

    public AppWidgetLoader(Context r1, AppWidgetManager r2, ItemConstructor<Item> r3) {
        this.mContext = r1;
        this.mAppWidgetManager = r2;
        this.mItemConstructor = r3;
    }

    void putCustomAppWidgets(List<Item> r10, Intent r11) {
        ArrayList r0 = r11.getParcelableArrayListExtra("customInfo");
        if (r0 != null) goto L5;
    L32:
        OLog.i(TAG, "EXTRA_CUSTOM_INFO not present.");
        List<AppWidgetProviderInfo> r4 = r0;
        List<Bundle> r5 = null;
    L33:
        putAppWidgetItems(r4, r5, r10, 0, true);
        return;
    L5:
        if (r0.size() == 0) goto L32;
        int r3 = r0.size();
        int r6 = 0;
        int r7 = 0;
    L8:
        if (r7 >= r3) goto L17;
        Parcelable r8 = (Parcelable) r0.get(r7);
        if (r8 == null) goto L15;
        if ((r8 instanceof AppWidgetProviderInfo) == false) goto L15;
        r7 = r7 + 1;
    L15:
        OLog.e(TAG, "error using EXTRA_CUSTOM_INFO index=" + r7);
    L16:
        r4 = null;
        r5 = null;
        goto L33
    L17:
        ArrayList r12 = r11.getParcelableArrayListExtra("customExtras");
        if (r12 != null) goto L20;
        OLog.e(TAG, "EXTRA_CUSTOM_INFO without EXTRA_CUSTOM_EXTRAS");
        r5 = r12;
        r4 = null;
        goto L33
    L20:
        int r9 = r12.size();
        if (r3 == r9) goto L23;
        OLog.e(TAG, "list size mismatch: EXTRA_CUSTOM_INFO: " + r3 + " EXTRA_CUSTOM_EXTRAS: " + r9);
    L23:
        if (r6 >= r9) goto L31;
        Parcelable r13 = (Parcelable) r12.get(r6);
        if (r13 == null) goto L30;
        if ((r13 instanceof Bundle) == false) goto L30;
        r6 = r6 + 1;
    L30:
        OLog.e(TAG, "error using EXTRA_CUSTOM_EXTRAS index=" + r6);
        goto L16
    L31:
        r5 = r12;
        r4 = r0;
        goto L33
    }

    void putAppWidgetItems(List<AppWidgetProviderInfo> r7, List<Bundle> r8, List<Item> r9, int r10, boolean r11) {
        if (r7 != null) goto L4;
        return;
    L4:
        int r0 = r7.size();
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L17;
        AppWidgetProviderInfo r2 = r7.get(r1);
        if (r11 == false) goto L9;
    L11:
        ItemConstructor<Item> r3 = this.mItemConstructor;
        Context r4 = this.mContext;
        if (r8 == null) goto L14;
        Bundle r5 = r8.get(r1);
    L15:
        r9.add(r3.createItem(r4, r2, r5));
    L16:
        r1 = r1 + 1;
        goto L5
    L14:
        r5 = null;
        goto L15
    L9:
        if ((r2.widgetCategory & r10) != 0) goto L11;
    }

    protected List<Item> getItems(Intent r5) {
        boolean r0 = r5.getBooleanExtra("customSort", true);
        ArrayList r2 = new ArrayList();
        putInstalledAppWidgets(r2, r5.getIntExtra("categoryFilter", 1));
        if (r0 == false) goto L5;
        putCustomAppWidgets(r2, r5);
    L5:
        Collections.sort(r2, new AnonymousClass1(this));
        if (r0 == true) goto L8;
        ArrayList r1 = new ArrayList();
        putCustomAppWidgets(r1, r5);
        r2.addAll(r1);
    L8:
        return r2;
    }

    void putInstalledAppWidgets(List<Item> r8, int r9) {
        putAppWidgetItems(this.mAppWidgetManager.getInstalledProviders(r9), null, r8, r9, false);
    }
}
