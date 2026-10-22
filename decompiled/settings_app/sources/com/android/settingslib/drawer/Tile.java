package com.android.settingslib.drawer;

import android.R;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.UserHandle;
import android.text.TextUtils;
import com.GlobalProxyLancet;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class Tile implements Parcelable {
    public static final Parcelable.Creator<Tile> CREATOR = null;
    private static final String TAG = "Tile";
    public static final Comparator<Tile> TILE_COMPARATOR = null;
    private String mCategory;
    protected ComponentInfo mComponentInfo;
    private final String mComponentName;
    private final String mComponentPackage;
    private String mGroupKey;
    private final Intent mIntent;
    long mLastUpdateTime;
    private Bundle mMetaData;
    private CharSequence mSummaryOverride;
    public HashMap<UserHandle, PendingIntent> pendingIntentMap;
    public ArrayList<UserHandle> userHandle;

    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type ACTION = null;
        public static final Type EXTERNAL_ACTION = null;
        public static final Type GROUP = null;
        public static final Type SWITCH = null;
        public static final Type SWITCH_WITH_ACTION = null;

        private static /* synthetic */ Type[] $values() {
            return new Type[]{ACTION, EXTERNAL_ACTION, SWITCH, SWITCH_WITH_ACTION, GROUP};
        }

        private Type(String r1, int r2) {
            super(r1, r2);
        }

        public static Type valueOf(String r1) {
            return (Type) Enum.valueOf(Type.class, r1);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        static {
            ACTION = new Type("ACTION", 0);
            EXTERNAL_ACTION = new Type("EXTERNAL_ACTION", 1);
            SWITCH = new Type("SWITCH", 2);
            SWITCH_WITH_ACTION = new Type("SWITCH_WITH_ACTION", 3);
            GROUP = new Type("GROUP", 4);
            $VALUES = $values();
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected abstract int getComponentIcon(ComponentInfo r1);

    protected abstract ComponentInfo getComponentInfo(Context r1);

    protected abstract CharSequence getComponentLabel(Context r1);

    public abstract String getDescription();

    public abstract int getId();

    public Tile(ComponentInfo r2, String r3, Bundle r4) {
        this.userHandle = new ArrayList();
        this.pendingIntentMap = new HashMap();
        this.mComponentInfo = r2;
        String r5 = r2.packageName;
        this.mComponentPackage = r5;
        String r0 = this.mComponentInfo.name;
        this.mComponentName = r0;
        this.mCategory = r3;
        this.mMetaData = r4;
        if (r4 == null) goto L5;
        this.mGroupKey = r4.getString(TileUtils.META_DATA_PREFERENCE_GROUP_KEY);
    L5:
        Intent r6 = new Intent().setClassName(r5, r0);
        this.mIntent = r6;
        if (isNewTask() == false) goto L9;
        r6.addFlags(268435456);
        return;
    }

    Tile(Parcel r5) {
        this.userHandle = new ArrayList();
        this.pendingIntentMap = new HashMap();
        String r0 = r5.readString();
        this.mComponentPackage = r0;
        String r1 = r5.readString();
        this.mComponentName = r1;
        this.mIntent = new Intent().setClassName(r0, r1);
        int r2 = r5.readInt();
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        this.userHandle.add((UserHandle) UserHandle.CREATOR.createFromParcel(r5));
        r3 = r3 + 1;
        goto L3
    L5:
        this.mCategory = r5.readString();
        this.mMetaData = r5.readBundle();
        if (isNewTask() == false) goto L8;
        this.mIntent.addFlags(268435456);
    L8:
        this.mGroupKey = r5.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r4, int r5) {
        r4.writeBoolean(this instanceof ProviderTile);
        r4.writeString(this.mComponentPackage);
        r4.writeString(this.mComponentName);
        int r0 = this.userHandle.size();
        r4.writeInt(r0);
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        this.userHandle.get(r1).writeToParcel(r4, r5);
        r1 = r1 + 1;
        goto L3
    L5:
        r4.writeString(this.mCategory);
        r4.writeBundle(this.mMetaData);
        r4.writeString(this.mGroupKey);
    }

    public String getPackageName() {
        return this.mComponentPackage;
    }

    public String getComponentName() {
        return this.mComponentName;
    }

    public Intent getIntent() {
        return this.mIntent;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void setCategory(String r1) {
        this.mCategory = r1;
    }

    public int getOrder() {
        if (hasOrder() == true) goto L5;
        return 0;
    L5:
        return this.mMetaData.getInt(TileUtils.META_DATA_KEY_ORDER);
    }

    public boolean hasOrder() {
        Bundle r0 = this.mMetaData;
        if (r0 != null) goto L5;
    L9:
        return false;
    L5:
        if (r0.containsKey(TileUtils.META_DATA_KEY_ORDER) == false) goto L9;
        if ((this.mMetaData.get(TileUtils.META_DATA_KEY_ORDER) instanceof Integer) == false) goto L9;
        return true;
    }

    public boolean hasSwitch() {
        Bundle r1 = this.mMetaData;
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.containsKey(TileUtils.META_DATA_PREFERENCE_SWITCH_URI) == false) goto L7;
        return true;
    }

    public boolean hasPendingIntent() {
        return !this.pendingIntentMap.isEmpty();
    }

    public CharSequence getTitle(Context r6) {
        ensureMetadataNotStale(r6);
        PackageManager r0 = r6.getPackageManager();
        Bundle r1 = this.mMetaData;
        String r2 = null;
        if (r1 != null) goto L5;
    L16:
        if (r2 == null) goto L18;
        return r2;
    L18:
        return getComponentLabel(r6);
    L5:
        if (r1.containsKey(TileUtils.META_DATA_PREFERENCE_TITLE) == false) goto L16;
        if (this.mMetaData.containsKey(TileUtils.META_DATA_PREFERENCE_TITLE_URI) == false) goto L10;
        return null;
    L10:
        if ((this.mMetaData.get(TileUtils.META_DATA_PREFERENCE_TITLE) instanceof Integer) == true) goto L19;
        r2 = this.mMetaData.getString(TileUtils.META_DATA_PREFERENCE_TITLE);
        goto L16
    L19:
        r2 = r0.getResourcesForApplication(this.mComponentPackage).getString(this.mMetaData.getInt(TileUtils.META_DATA_PREFERENCE_TITLE));     // Catch: Throwable -> L13
    L13:
        e = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Couldn't find info", e);
        goto L16
    }

    public void overrideSummary(CharSequence r1) {
        this.mSummaryOverride = r1;
    }

    public CharSequence getSummary(Context r4) {
        CharSequence r0 = this.mSummaryOverride;
        if (r0 == null) goto L5;
        return r0;
    L5:
        ensureMetadataNotStale(r4);
        PackageManager r5 = r4.getPackageManager();
        Bundle r1 = this.mMetaData;
        if (r1 != null) goto L8;
        return null;
    L8:
        if (r1.containsKey(TileUtils.META_DATA_PREFERENCE_SUMMARY_URI) == false) goto L11;
        return null;
    L11:
        if (this.mMetaData.containsKey(TileUtils.META_DATA_PREFERENCE_SUMMARY) == true) goto L13;
        return null;
    L13:
        if ((this.mMetaData.get(TileUtils.META_DATA_PREFERENCE_SUMMARY) instanceof Integer) == false) goto L19;
        return r5.getResourcesForApplication(this.mComponentPackage).getString(this.mMetaData.getInt(TileUtils.META_DATA_PREFERENCE_SUMMARY));
    L16:
        e = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Couldn't find info", e);
        return null;
    L19:
        return this.mMetaData.getString(TileUtils.META_DATA_PREFERENCE_SUMMARY);
    }

    public void setMetaData(Bundle r1) {
        this.mMetaData = r1;
    }

    public Bundle getMetaData() {
        return this.mMetaData;
    }

    public String getKey(Context r3) {
        ensureMetadataNotStale(r3);
        if (hasKey() == true) goto L7;
        return null;
    L7:
        if ((this.mMetaData.get(TileUtils.META_DATA_PREFERENCE_KEYHINT) instanceof Integer) == false) goto L11;
        return r3.getResources().getString(this.mMetaData.getInt(TileUtils.META_DATA_PREFERENCE_KEYHINT));
    L11:
        return this.mMetaData.getString(TileUtils.META_DATA_PREFERENCE_KEYHINT);
    }

    public boolean hasKey() {
        Bundle r1 = this.mMetaData;
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.containsKey(TileUtils.META_DATA_PREFERENCE_KEYHINT) == false) goto L7;
        return true;
    }

    public Icon getIcon(Context r5) {
        Icon r0 = null;
        if (r5 != null) goto L5;
    L18:
        return r0;
    L5:
        if (this.mMetaData == null) goto L18;
        ensureMetadataNotStale(r5);
        ComponentInfo r1 = getComponentInfo(r5);
        if (r1 != null) goto L11;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Cannot find ComponentInfo for " + getDescription());
        return null;
    L11:
        int r2 = this.mMetaData.getInt(TileUtils.META_DATA_PREFERENCE_ICON);
        if (r2 == 0) goto L18;
        if (r2 == 17170445) goto L18;
        r0 = Icon.createWithResource(r1.packageName, r2);
        if (isIconTintable(r5) == false) goto L18;
        TypedArray r4 = r5.obtainStyledAttributes(new int[]{R.attr.colorControlNormal});
        int r6 = r4.getColor(0, 0);
        r4.recycle();
        r0.setTint(r6);
        goto L18
    }

    public boolean isIconTintable(Context r2) {
        ensureMetadataNotStale(r2);
        Bundle r3 = this.mMetaData;
        if (r3 != null) goto L5;
        return false;
    L5:
        if (r3.containsKey(TileUtils.META_DATA_PREFERENCE_ICON_TINTABLE) == true) goto L7;
        return false;
    L7:
        return this.mMetaData.getBoolean(TileUtils.META_DATA_PREFERENCE_ICON_TINTABLE);
    }

    public boolean isNewTask() {
        Bundle r0 = this.mMetaData;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.containsKey(TileUtils.META_DATA_NEW_TASK) == true) goto L7;
        return false;
    L7:
        return this.mMetaData.getBoolean(TileUtils.META_DATA_NEW_TASK);
    }

    private void ensureMetadataNotStale(Context r5) {
        PackageManager r0 = r5.getApplicationContext().getPackageManager();
        long r1 = r0.getPackageInfo(this.mComponentPackage, 128).lastUpdateTime;     // Catch: PackageManager.NameNotFoundException -> L8
        if (r1 != this.mLastUpdateTime) goto L6;
        return;
    L6:
        this.mComponentInfo = null;     // Catch: PackageManager.NameNotFoundException -> L8
        getComponentInfo(r5);     // Catch: PackageManager.NameNotFoundException -> L8
        this.mLastUpdateTime = r1;     // Catch: PackageManager.NameNotFoundException -> L8
        return;
    L8:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Can't find package, probably uninstalled.");
    }

    static {
        CREATOR = new AnonymousClass1();
        TILE_COMPARATOR = new Tile$$ExternalSyntheticLambda0();
    }

    public boolean isPrimaryProfileOnly() {
        return isPrimaryProfileOnly(this.mMetaData);
    }

    static boolean isPrimaryProfileOnly(Bundle r2) {
        String r0 = TileUtils.PROFILE_ALL;
        if (r2 == null) goto L5;
        String r3 = r2.getString(TileUtils.META_DATA_KEY_PROFILE);
    L6:
        if (r3 == null) goto L9;
        r0 = r3;
    L9:
        return TextUtils.equals(r0, TileUtils.PROFILE_PRIMARY);
    L5:
        r3 = TileUtils.PROFILE_ALL;
        goto L6
    }

    public boolean hasGroupKey() {
        return !TextUtils.isEmpty(this.mGroupKey);
    }

    public void setGroupKey(String r1) {
        this.mGroupKey = r1;
    }

    public String getGroupKey() {
        return this.mGroupKey;
    }

    public boolean isSearchable() {
        Bundle r2 = this.mMetaData;
        if (r2 != null) goto L5;
        return true;
    L5:
        if (r2.getBoolean(TileUtils.META_DATA_PREFERENCE_SEARCHABLE, true) == true) goto L10;
        return false;
    L10:
        return true;
    }

    public Type getType() {
        boolean r0 = hasPendingIntent();
        if (r0 == false) goto L5;
    L8:
        boolean r1 = true;
    L9:
        boolean r2 = hasSwitch();
        if (r2 == false) goto L14;
        if (r1 == false) goto L14;
        return Type.SWITCH_WITH_ACTION;
    L14:
        if (r2 == true) goto L16;
        if (r0 == true) goto L19;
        if (r1 == false) goto L24;
        return Type.ACTION;
    L24:
        return Type.GROUP;
    L19:
        return Type.EXTERNAL_ACTION;
    L16:
        return Type.SWITCH;
    L5:
        if ((this instanceof ActivityTile) == true) goto L8;
        r1 = false;
        goto L9
    }

    static /* synthetic */ int lambda$static$0(Tile r0, Tile r1) {
        return r1.getOrder() - r0.getOrder();
    }
}
