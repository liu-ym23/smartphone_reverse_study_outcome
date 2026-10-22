package com.android.settings;

import android.app.AppGlobals;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.UserHandle;
import android.os.UserManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class AppListPreference extends CustomListPreference {
    public static final String ITEM_NONE_VALUE = "";
    private Drawable[] mEntryDrawables;
    protected final boolean mForWork;
    private boolean mShowItemNone;
    private CharSequence[] mSummaries;
    private int mSystemAppIndex;
    protected final int mUserId;

    public class AppArrayAdapter extends ArrayAdapter<CharSequence> {
        private Drawable[] mImageDrawables;
        private int mSelectedIndex;
        final /* synthetic */ AppListPreference this$0;

        public AppArrayAdapter(AppListPreference r1, Context r2, int r3, CharSequence[] r4, Drawable[] r5, int r6) {
            this.this$0 = r1;
            super(r2, r3, r4);
            this.mSelectedIndex = r6;
            this.mImageDrawables = r5;
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int r2) {
            if (AppListPreference.access$000(this.this$0) != null) goto L5;
        L8:
            return true;
        L5:
            if (AppListPreference.access$000(this.this$0)[r2] == null) goto L8;
            return false;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int r3, View r4, ViewGroup r5) {
            View r6 = LayoutInflater.from(getContext()).inflate(R.layout.app_preference_item, r5, false);
            ((TextView) r6.findViewById(android.R.id.title)).setText(getItem(r3));
            if (r3 != this.mSelectedIndex) goto L8;
            if (r3 != AppListPreference.access$100(this.this$0)) goto L8;
            r6.findViewById(R.id.system_default_label).setVisibility(0);
        L13:
            ((ImageView) r6.findViewById(android.R.id.icon)).setImageDrawable(this.mImageDrawables[r3]);
            if (AppListPreference.access$000(this.this$0) != null) goto L16;
        L19:
            boolean r7 = true;
        L20:
            r6.setEnabled(r7);
            if (r7 == true) goto L23;
            TextView r8 = (TextView) r6.findViewById(android.R.id.summary);
            r8.setText(AppListPreference.access$000(this.this$0)[r3]);
            r8.setVisibility(0);
        L23:
            return r6;
        L16:
            if (AppListPreference.access$000(this.this$0)[r3] == null) goto L19;
            r7 = false;
        L8:
            if (r3 != this.mSelectedIndex) goto L11;
            r6.findViewById(R.id.default_label).setVisibility(0);
            goto L13
        L11:
            if (r3 != AppListPreference.access$100(this.this$0)) goto L13;
            r6.findViewById(R.id.system_label).setVisibility(0);
            goto L13
        }
    }

    private static class SavedState implements Parcelable {
        public static Parcelable.Creator<SavedState> CREATOR;
        public final CharSequence[] entryValues;
        public final boolean showItemNone;
        public final CharSequence[] summaries;
        public final Parcelable superState;
        public final CharSequence value;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public SavedState(CharSequence[] r1, CharSequence r2, CharSequence[] r3, boolean r4, Parcelable r5) {
            this.entryValues = r1;
            this.value = r2;
            this.showItemNone = r4;
            this.superState = r5;
            this.summaries = r3;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r2, int r3) {
            r2.writeCharSequenceArray(this.entryValues);
            r2.writeCharSequence(this.value);
            r2.writeInt(this.showItemNone ? 1 : 0);
            r2.writeParcelable(this.superState, r3);
            r2.writeCharSequenceArray(this.summaries);
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    static /* synthetic */ CharSequence[] access$000(AppListPreference r0) {
        return r0.mSummaries;
    }

    static /* synthetic */ int access$100(AppListPreference r0) {
        return r0.mSystemAppIndex;
    }

    public AppListPreference(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, r4);
        this.mShowItemNone = false;
        this.mSystemAppIndex = -1;
        TypedArray r5 = r1.obtainStyledAttributes(r2, R.styleable.WorkPreference, 0, 0);
        boolean r6 = r5.getBoolean(0, false);
        this.mForWork = r6;
        UserHandle r7 = Utils.getManagedProfile(UserManager.get(r1));
        if (r6 == false) goto L6;
        if (r7 == null) goto L6;
        int r8 = r7.getIdentifier();
    L7:
        this.mUserId = r8;
        r5.recycle();
        return;
    L6:
        r8 = UserHandle.myUserId();
        goto L7
    }

    public AppListPreference(Context r3, AttributeSet r4) {
        super(r3, r4);
        this.mShowItemNone = false;
        this.mSystemAppIndex = -1;
        TypedArray r5 = r3.obtainStyledAttributes(r4, R.styleable.WorkPreference, 0, 0);
        boolean r0 = r5.getBoolean(0, false);
        this.mForWork = r0;
        UserHandle r6 = Utils.getManagedProfile(UserManager.get(r3));
        if (r0 == false) goto L6;
        if (r6 == null) goto L6;
        int r7 = r6.getIdentifier();
    L7:
        this.mUserId = r7;
        r5.recycle();
        return;
    L6:
        r7 = UserHandle.myUserId();
        goto L7
    }

    public void setShowItemNone(boolean r1) {
        this.mShowItemNone = r1;
    }

    public void setPackageNames(CharSequence[] r2, CharSequence r3) {
        setPackageNames(r2, r3, null);
    }

    public void setPackageNames(CharSequence[] r11, CharSequence r12, CharSequence r13) {
        PackageManager r0 = getContext().getPackageManager();
        int r1 = r11.length + (this.mShowItemNone ? 1 : 0);
        ArrayList r2 = new ArrayList(r1);
        ArrayList r3 = new ArrayList(r1);
        ArrayList r4 = new ArrayList(r1);
        this.mSystemAppIndex = -1;
        int r7 = -1;
        int r6 = 0;
    L4:
        if (r6 >= r11.length) goto L20;
        ApplicationInfo r8 = r0.getApplicationInfoAsUser(r11[r6].toString(), 0, this.mUserId);     // Catch: PackageManager.NameNotFoundException -> L27
        if (r8 == null) goto L18;
        r2.add(r8.loadLabel(r0));     // Catch: PackageManager.NameNotFoundException -> L27
        r3.add(r8.packageName);     // Catch: PackageManager.NameNotFoundException -> L27
        r4.add(r8.loadIcon(r0));     // Catch: PackageManager.NameNotFoundException -> L27
        if (r12 == null) goto L13;
        if (r8.packageName.contentEquals(r12) == false) goto L13;
        r7 = r6;
    L13:
        if (r8.packageName == null) goto L18;
        if (r13 == null) goto L18;
        if (r8.packageName.contentEquals(r13) == false) goto L18;
        this.mSystemAppIndex = r6;     // Catch: PackageManager.NameNotFoundException -> L27
    L18:
        r6 = r6 + 1;
        goto L4
    L20:
        if (this.mShowItemNone == false) goto L22;
        r2.add(getContext().getResources().getText(R.string.app_list_preference_none));
        r3.add("");
        r4.add(getContext().getDrawable(R.drawable.ic_remove_circle));
    L22:
        setEntries((CharSequence[]) r2.toArray(new CharSequence[r2.size()]));
        setEntryValues((CharSequence[]) r3.toArray(new CharSequence[r3.size()]));
        this.mEntryDrawables = (Drawable[]) r4.toArray(new Drawable[r4.size()]);
        if (r7 == (-1)) goto L25;
        setValueIndex(r7);
        return;
    L25:
        setValue(null);
    }

    public void setComponentNames(ComponentName[] r2, ComponentName r3) {
        setComponentNames(r2, r3, null);
    }

    public void setComponentNames(ComponentName[] r13, ComponentName r14, CharSequence[] r15) {
        this.mSummaries = r15;
        PackageManager r16 = getContext().getPackageManager();
        int r0 = r13.length + (this.mShowItemNone ? 1 : 0);
        ArrayList r1 = new ArrayList(r0);
        ArrayList r2 = new ArrayList(r0);
        ArrayList r3 = new ArrayList(r0);
        int r4 = 0;
        int r5 = -1;
    L3:
        CharSequence r7 = "";
        if (r4 >= r13.length) goto L19;
        ActivityInfo r6 = AppGlobals.getPackageManager().getActivityInfo(r13[r4], 0, this.mUserId);     // Catch: RemoteException -> L26
        if (r6 == null) goto L17;
        CharSequence r8 = r6.loadLabel(r16);     // Catch: RemoteException -> L26
        if (r8 == null) goto L12;
        r7 = r8;
    L12:
        r1.add(r7);     // Catch: RemoteException -> L26
        r2.add(r13[r4].flattenToString());     // Catch: RemoteException -> L26
        r3.add(r6.loadIcon(r16));     // Catch: RemoteException -> L26
        if (r14 == null) goto L17;
        if (r13[r4].equals(r14) == false) goto L17;
        r5 = r4;
    L17:
        r4 = r4 + 1;
        goto L3
    L19:
        if (this.mShowItemNone == false) goto L21;
        r1.add(getContext().getResources().getText(R.string.app_list_preference_none));
        r2.add("");
        r3.add(getContext().getDrawable(R.drawable.ic_remove_circle));
    L21:
        setEntries((CharSequence[]) r1.toArray(new CharSequence[r1.size()]));
        setEntryValues((CharSequence[]) r2.toArray(new CharSequence[r2.size()]));
        this.mEntryDrawables = (Drawable[]) r3.toArray(new Drawable[r3.size()]);
        if (r5 == (-1)) goto L24;
        setValueIndex(r5);
        return;
    L24:
        setValue(null);
    }

    protected ListAdapter createListAdapter() {
        String r0 = getValue();
        if (r0 != null) goto L5;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == false) goto L13;
        int r2 = -1;
    L14:
        Context r3 = getContext();
        CharSequence[] r5 = getEntries();
        Drawable[] r6 = this.mEntryDrawables;
        return new AppArrayAdapter(this, r3, R.layout.app_preference_item, r5, r6, r2);
    L13:
        r2 = findIndexOfValue(r0);
        goto L14
    L5:
        if (this.mShowItemNone == true) goto L7;
    L9:
        r1 = false;
        goto L11
    L7:
        if (r0.contentEquals("") == false) goto L9;
        goto L9
    }

    @Override // com.android.settings.CustomListPreference
    protected void onPrepareDialogBuilder(AlertDialog.Builder r1, DialogInterface.OnClickListener r2) {
        r1.setAdapter(createListAdapter(), r2);
    }

    @Override // androidx.preference.ListPreference, androidx.preference.Preference
    protected Parcelable onSaveInstanceState() {
        Parcelable r5 = super.onSaveInstanceState();
        return new SavedState(getEntryValues(), getValue(), this.mSummaries, this.mShowItemNone, r5);
    }

    @Override // androidx.preference.ListPreference, androidx.preference.Preference
    protected void onRestoreInstanceState(Parcelable r3) {
        if ((r3 instanceof SavedState) == false) goto L5;
        SavedState r4 = (SavedState) r3;
        this.mShowItemNone = r4.showItemNone;
        setPackageNames(r4.entryValues, r4.value);
        this.mSummaries = r4.summaries;
        super.onRestoreInstanceState(r4.superState);
        return;
    L5:
        super.onRestoreInstanceState(r3);
    }
}
