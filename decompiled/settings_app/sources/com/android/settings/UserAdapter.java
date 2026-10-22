package com.android.settings;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.UserInfo;
import android.database.DataSetObserver;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.UserHandle;
import android.os.UserManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.android.internal.util.UserIcons;
import com.android.settingslib.drawable.UserIconDrawable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class UserAdapter implements SpinnerAdapter, ListAdapter {
    private ArrayList<UserDetails> data;
    private final LayoutInflater mInflater;

    public static class UserDetails {
        private final Drawable mIcon;
        private final String mName;
        private final UserHandle mUserHandle;

        static /* synthetic */ UserHandle access$000(UserDetails r0) {
            return r0.mUserHandle;
        }

        static /* synthetic */ Drawable access$100(UserDetails r0) {
            return r0.mIcon;
        }

        public UserDetails(UserHandle r3, UserManager r4, Context r5) {
            this.mUserHandle = r3;
            UserInfo r6 = r4.getUserInfo(r3.getIdentifier());
            if (r6.isManagedProfile() == false) goto L5;
            this.mName = r5.getString(R.string.managed_user_title);
            Drawable r7 = r5.getDrawable(android.R.drawable.ic_zen_mode_icon_classical_building);
        L9:
            this.mIcon = encircle(r5, r7);
            return;
        L5:
            this.mName = r6.name;
            int r8 = r6.id;
            if (r4.getUserIcon(r8) == null) goto L8;
            r7 = new BitmapDrawable(r5.getResources(), r4.getUserIcon(r8));
            goto L9
        L8:
            r7 = UserIcons.getDefaultUserIcon(r5.getResources(), r8, false);
            goto L9
        }

        private static Drawable encircle(Context r0, Drawable r1) {
            return new UserIconDrawable().setIconDrawable(r1).bake();
        }
    }

    @Override // android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return true;
    }

    @Override // android.widget.Adapter
    public int getItemViewType(int r1) {
        return 0;
    }

    @Override // android.widget.Adapter
    public int getViewTypeCount() {
        return 1;
    }

    @Override // android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.ListAdapter
    public boolean isEnabled(int r1) {
        return true;
    }

    @Override // android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver r1) {
    }

    @Override // android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver r1) {
    }

    @Override // android.widget.Adapter
    public /* bridge */ /* synthetic */ Object getItem(int r1) {
        return getItem(r1);
    }

    public UserAdapter(Context r1, ArrayList<UserDetails> r2) {
        if (r2 == null) goto L7;
        this.data = r2;
        this.mInflater = (LayoutInflater) r1.getSystemService("layout_inflater");
        return;
    L7:
        throw new IllegalArgumentException("A list of user details must be provided");
    }

    public UserHandle getUserHandle(int r2) {
        if (r2 >= 0) goto L4;
        return null;
    L4:
        if (r2 < this.data.size()) goto L7;
        return null;
    L7:
        return UserDetails.access$000(this.data.get(r2));
    }

    @Override // android.widget.SpinnerAdapter
    public View getDropDownView(int r2, View r3, ViewGroup r4) {
        if (r3 != null) goto L5;
        r3 = createUser(r4);
    L5:
        UserDetails r5 = this.data.get(r2);
        ((ImageView) r3.findViewById(android.R.id.icon)).setImageDrawable(UserDetails.access$100(r5));
        ((TextView) r3.findViewById(android.R.id.title)).setText(getTitle(r5));
        return r3;
    }

    private int getTitle(UserDetails r1) {
        int r0 = UserDetails.access$000(r1).getIdentifier();
        if (r0 != (-2)) goto L5;
        return R.string.category_personal;
    L5:
        if (r0 == ActivityManager.getCurrentUser()) goto L11;
        return R.string.category_work;
    L11:
        return R.string.category_personal;
    }

    private View createUser(ViewGroup r3) {
        return this.mInflater.inflate(R.layout.user_preference, r3, false);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.data.size();
    }

    @Override // android.widget.Adapter
    public UserDetails getItem(int r1) {
        return this.data.get(r1);
    }

    @Override // android.widget.Adapter
    public long getItemId(int r1) {
        return UserDetails.access$000(this.data.get(r1)).getIdentifier();
    }

    @Override // android.widget.Adapter
    public View getView(int r1, View r2, ViewGroup r3) {
        return getDropDownView(r1, r2, r3);
    }

    @Override // android.widget.Adapter
    public boolean isEmpty() {
        return this.data.isEmpty();
    }

    public static UserAdapter createUserSpinnerAdapter(UserManager r3, Context r4) {
        List<UserHandle> r0 = r3.getUserProfiles();
        if (r0.size() >= 2) goto L6;
        return null;
    L6:
        UserHandle r1 = new UserHandle(UserHandle.myUserId());
        r0.remove(r1);
        r0.add(0, r1);
        return createUserAdapter(r3, r4, r0);
    }

    public static UserAdapter createUserAdapter(UserManager r5, Context r6, List<UserHandle> r7) {
        ArrayList r0 = new ArrayList(r7.size());
        int r1 = r7.size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        r0.add(new UserDetails(r7.get(r2), r5, r6));
        r2 = r2 + 1;
        goto L3
    L6:
        return new UserAdapter(r6, r0);
    }
}
