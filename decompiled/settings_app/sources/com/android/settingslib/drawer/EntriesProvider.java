package com.android.settingslib.drawer;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.GlobalProxyLancet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class EntriesProvider extends ContentProvider {
    public static final String EXTRA_ENTRY_DATA = "entry_data";
    public static final String EXTRA_SWITCH_CHECKED_STATE = "checked_state";

    @Deprecated
    public static final String EXTRA_SWITCH_DATA = "switch_data";
    public static final String EXTRA_SWITCH_SET_CHECKED_ERROR = "set_checked_error";
    public static final String EXTRA_SWITCH_SET_CHECKED_ERROR_MESSAGE = "set_checked_error_message";
    public static final String METHOD_GET_DYNAMIC_SUMMARY = "getDynamicSummary";
    public static final String METHOD_GET_DYNAMIC_TITLE = "getDynamicTitle";
    public static final String METHOD_GET_ENTRY_DATA = "getEntryData";
    public static final String METHOD_GET_PROVIDER_ICON = "getProviderIcon";

    @Deprecated
    public static final String METHOD_GET_SWITCH_DATA = "getSwitchData";
    public static final String METHOD_IS_CHECKED = "isChecked";
    public static final String METHOD_ON_CHECKED_CHANGED = "onCheckedChanged";
    private static final String TAG = "EntriesProvider";
    private String mAuthority;
    private final Map<String, EntryController> mControllerMap;
    private final List<Bundle> mEntryDataList;

    protected abstract List<? extends EntryController> createEntryControllers();

    public EntriesProvider() {
        this.mControllerMap = new LinkedHashMap();
        this.mEntryDataList = new ArrayList();
    }

    protected EntryController getController(String r1) {
        return this.mControllerMap.get(r1);
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context r3, ProviderInfo r4) {
        String r0 = r4.authority;
        this.mAuthority = r0;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_i(TAG, r0);
        super.attachInfo(r3, r4);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        List<? extends EntryController> r0 = createEntryControllers();
        if (r0 == null) goto L23;
        if (r0.isEmpty() == true) goto L23;
        Iterator<? extends EntryController> r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L20;
        EntryController r2 = r1.next();
        String r3 = r2.getKey();
        if (TextUtils.isEmpty(r3) == true) goto L19;
        if (this.mControllerMap.containsKey(r3) == true) goto L17;
        r2.setAuthority(this.mAuthority);
        this.mControllerMap.put(r3, r2);
        if ((r2 instanceof PrimarySwitchController) == true) goto L8;
        this.mEntryDataList.add(r2.getBundle());
        goto L8
    L17:
        throw new IllegalArgumentException("Entry key " + r3 + " is duplicated by: " + r2.getClass().getSimpleName());
    L19:
        throw new NullPointerException("Entry key cannot be null: " + r2.getClass().getSimpleName());
    L20:
        return true;
    L23:
        throw new IllegalArgumentException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.content.ContentProvider
    public Bundle call(String r7, String r8, Bundle r9) {
        Bundle r10 = new Bundle();
        if (r9 == null) goto L5;
        String r1 = r9.getString(TileUtils.META_DATA_PREFERENCE_KEYHINT);
    L7:
        if (TextUtils.isEmpty(r1) == false) goto L17;
        r7.hashCode();
        if (r7.equals(METHOD_GET_SWITCH_DATA) == false) goto L11;
        r10.putParcelableList(EXTRA_SWITCH_DATA, this.mEntryDataList);
        return r10;
    L11:
        if (r7.equals(METHOD_GET_ENTRY_DATA) == true) goto L13;
        return null;
    L13:
        r10.putParcelableList(EXTRA_ENTRY_DATA, this.mEntryDataList);
        return r10;
    L17:
        EntryController r2 = this.mControllerMap.get(r1);
        if (r2 != 0) goto L20;
        return null;
    L20:
        r7.hashCode();
        byte r5 = -1;
        switch(r7.hashCode()) {
            case -2097433649: goto L48;
            case -1844463779: goto L44;
            case -952092468: goto L40;
            case -645523212: goto L36;
            case -489466746: goto L32;
            case 162535197: goto L28;
            case 1207101568: goto L24;
            default: goto L52;
        };
    L24:
        if (r7.equals(METHOD_GET_PROVIDER_ICON) == false) goto L52;
        r5 = 6;
        goto L52
    L28:
        if (r7.equals(METHOD_IS_CHECKED) == false) goto L52;
        r5 = 5;
        goto L52
    L32:
        if (r7.equals(METHOD_GET_ENTRY_DATA) == false) goto L52;
        r5 = 4;
        goto L52
    L36:
        if (r7.equals(METHOD_GET_SWITCH_DATA) == false) goto L52;
        r5 = 3;
        goto L52
    L40:
        if (r7.equals(METHOD_ON_CHECKED_CHANGED) == false) goto L52;
        r5 = 2;
        goto L52
    L44:
        if (r7.equals(METHOD_GET_DYNAMIC_SUMMARY) == false) goto L52;
        r5 = 1;
        goto L52
    L48:
        if (r7.equals(METHOD_GET_DYNAMIC_TITLE) == false) goto L52;
        r5 = 0;
    L52:
        switch(r5) {
            case 0: goto L75;
            case 1: goto L71;
            case 2: goto L67;
            case 3: goto L63;
            case 4: goto L63;
            case 5: goto L59;
            case 6: goto L55;
            default: goto L78;
        };
    L78:
        return null;
    L55:
        if ((r2 instanceof ProviderIcon) == false) goto L78;
        return ((ProviderIcon) r2).getProviderIcon();
    L59:
        if ((r2 instanceof ProviderSwitch) == false) goto L78;
        r10.putBoolean(EXTRA_SWITCH_CHECKED_STATE, ((ProviderSwitch) r2).isSwitchChecked());
        return r10;
    L63:
        if ((r2 instanceof PrimarySwitchController) == true) goto L78;
        return r2.getBundle();
    L67:
        if ((r2 instanceof ProviderSwitch) == false) goto L78;
        return onSwitchCheckedChanged(r9.getBoolean(EXTRA_SWITCH_CHECKED_STATE), (ProviderSwitch) r2);
    L71:
        if ((r2 instanceof DynamicSummary) == false) goto L78;
        r10.putString(TileUtils.META_DATA_PREFERENCE_SUMMARY, ((DynamicSummary) r2).getDynamicSummary());
        return r10;
    L75:
        if ((r2 instanceof DynamicTitle) == false) goto L78;
        r10.putString(TileUtils.META_DATA_PREFERENCE_TITLE, ((DynamicTitle) r2).getDynamicTitle());
        return r10;
    L5:
        r1 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Bundle onSwitchCheckedChanged(boolean r5, ProviderSwitch r6) {
        boolean r0 = r6.onSwitchCheckedChanged(r5);
        Bundle r1 = new Bundle();
        r1.putBoolean(EXTRA_SWITCH_SET_CHECKED_ERROR, !r0);
        if (r0 == true) goto L5;
        r1.putString(EXTRA_SWITCH_SET_CHECKED_ERROR_MESSAGE, r6.getSwitchErrorMessage(r5));
    L8:
        return r1;
    L5:
        if ((r6 instanceof DynamicSummary) == false) goto L8;
        ((EntryController) r6).notifySummaryChanged(getContext());
        goto L8
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r1) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r1, ContentValues r2) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r1, String r2, String[] r3) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContentProvider
    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        throw new UnsupportedOperationException();
    }
}
