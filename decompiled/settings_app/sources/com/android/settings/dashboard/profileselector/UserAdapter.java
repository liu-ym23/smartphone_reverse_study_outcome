package com.android.settings.dashboard.profileselector;

import android.app.ActivityManager;
import android.app.admin.DevicePolicyManager;
import android.app.admin.DevicePolicyResourcesManager;
import android.content.Context;
import android.os.Flags;
import android.os.UserHandle;
import android.os.UserManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.internal.widget.RecyclerView;
import com.android.settings.R;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class UserAdapter extends BaseAdapter {
    private static final String TAG = "UserAdapter";
    private final LayoutInflater mInflater;
    private final ArrayList<UserDetails> mUserDetails;

    public interface OnClickListener {
        void onClick(int r1);
    }

    public static class UserDetails {
        private final String mTitle;
        private final UserHandle mUserHandle;
        private final UserManager mUserManager;

        static /* synthetic */ UserHandle access$000(UserDetails r0) {
            return r0.mUserHandle;
        }

        static /* synthetic */ String access$200(UserDetails r0) {
            return r0.mTitle;
        }

        public UserDetails(UserHandle r1, UserManager r2, Context r3) {
            this.mUserHandle = r1;
            this.mUserManager = r2;
            r2.getUserInfo(r1.getIdentifier());
            this.mTitle = getTitle(r3);
        }

        private String getTitle(final Context r5) {
            DevicePolicyResourcesManager r0 = ((DevicePolicyManager) Objects.requireNonNull((DevicePolicyManager) r5.getSystemService(DevicePolicyManager.class))).getResources();
            int r1 = this.mUserHandle.getIdentifier();
            if (r1 == (-2)) goto L24;
            if (r1 == ActivityManager.getCurrentUser()) goto L24;
            if (this.mUserManager.isManagedProfile(r1) == false) goto L12;
            return r0.getString("Settings.WORK_CATEGORY_HEADER", new UserAdapter$UserDetails$$ExternalSyntheticLambda1(r5));
        L12:
            if (Flags.allowPrivateProfile() == true) goto L14;
        L21:
            OLog.w(UserAdapter.TAG, "title requested for unexpected user id " + r1);
            return r0.getString("Settings.PERSONAL_CATEGORY_HEADER", new UserAdapter$UserDetails$$ExternalSyntheticLambda3(r5));
        L14:
            if (android.multiuser.Flags.enablePrivateSpaceFeatures() == false) goto L21;
            if (android.multiuser.Flags.handleInterleavedSettingsForPrivateSpace() == false) goto L21;
            if (this.mUserManager.getUserInfo(r1).isPrivateProfile() == false) goto L21;
            return r0.getString("Settings.PRIVATE_CATEGORY_HEADER", new UserAdapter$UserDetails$$ExternalSyntheticLambda2(r5));
        L24:
            return r0.getString("Settings.PERSONAL_CATEGORY_HEADER", new UserAdapter$UserDetails$$ExternalSyntheticLambda0(r5));
        }

        static /* synthetic */ String lambda$getTitle$0(Context r1) {
            return r1.getString(R.string.category_personal);
        }

        static /* synthetic */ String lambda$getTitle$1(Context r1) {
            return r1.getString(R.string.category_work);
        }

        static /* synthetic */ String lambda$getTitle$2(Context r1) {
            return r1.getString(R.string.category_private);
        }

        static /* synthetic */ String lambda$getTitle$3(Context r1) {
            return r1.getString(R.string.category_personal);
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final View mButtonView;
        private final ImageView mIconView;
        private final TextView mTitleView;

        /* synthetic */ ViewHolder(View r1, AnonymousClass1 r2) {
            this(r1);
        }

        /* synthetic */ ViewHolder(View r1, OnClickListener r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        static /* synthetic */ void access$300(ViewHolder r0, CharSequence r1) {
            r0.setTitle(r1);
        }

        private ViewHolder(View r2) {
            super(r2);
            this.mIconView = (ImageView) r2.findViewById(android.R.id.icon);
            this.mTitleView = (TextView) r2.findViewById(android.R.id.title);
            this.mButtonView = r2.findViewById(R.id.button);
        }

        private ViewHolder(View r2, final OnClickListener r3) {
            this(r2);
            View r4 = this.mButtonView;
            if (r4 == null) goto L6;
            r4.setOnClickListener(new UserAdapter$ViewHolder$$ExternalSyntheticLambda0(this, r3));
            return;
        }

        /* JADX INFO: renamed from: lambda$new$0$com-android-settings-dashboard-profileselector-UserAdapter$ViewHolder, reason: not valid java name */
        /* synthetic */ void m421x221e3c3a(OnClickListener r1, View r2) {
            r1.onClick(getAdapterPosition());
        }

        private ImageView getIconView() {
            return this.mIconView;
        }

        private void setTitle(CharSequence r2) {
            this.mTitleView.setText(r2);
            View r1 = this.mButtonView;
            if (r1 == null) goto L6;
            r1.setContentDescription(r2);
            return;
        }
    }

    static /* synthetic */ void access$500(UserAdapter r0, ViewHolder r1, int r2) {
        r0.bindViewHolder(r1, r2);
    }

    @Override // android.widget.Adapter
    public /* bridge */ /* synthetic */ Object getItem(int r1) {
        return getItem(r1);
    }

    public UserAdapter(Context r1, ArrayList<UserDetails> r2) {
        if (r2 == null) goto L7;
        this.mUserDetails = r2;
        this.mInflater = (LayoutInflater) r1.getSystemService(LayoutInflater.class);
        return;
    L7:
        throw new IllegalArgumentException("A list of user details must be provided");
    }

    public UserHandle getUserHandle(int r2) {
        if (r2 >= 0) goto L4;
        return null;
    L4:
        if (r2 < this.mUserDetails.size()) goto L7;
        return null;
    L7:
        return UserDetails.access$000(this.mUserDetails.get(r2));
    }

    @Override // android.widget.Adapter
    public View getView(int r3, View r4, ViewGroup r5) {
        if (r4 == null) goto L4;
        ViewHolder r6 = (ViewHolder) r4.getTag();
    L5:
        bindViewHolder(r6, r3);
        return r4;
    L4:
        r4 = this.mInflater.inflate(R.layout.user_preference, r5, false);
        r6 = new ViewHolder(r4, null);
        r4.setTag(r6);
        goto L5
    }

    private void bindViewHolder(ViewHolder r1, int r2) {
        ViewHolder.access$300(r1, UserDetails.access$200(getItem(r2)));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mUserDetails.size();
    }

    @Override // android.widget.Adapter
    public UserDetails getItem(int r1) {
        return this.mUserDetails.get(r1);
    }

    @Override // android.widget.Adapter
    public long getItemId(int r1) {
        return UserDetails.access$000(this.mUserDetails.get(r1)).getIdentifier();
    }

    private RecyclerView.Adapter<ViewHolder> createRecyclerViewAdapter(final OnClickListener r2) {
        return new AnonymousClass1(this, r2);
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

    public static RecyclerView.Adapter<ViewHolder> createUserRecycleViewAdapter(Context r1, List<UserHandle> r2, OnClickListener r3) {
        return createUserAdapter((UserManager) r1.getSystemService(UserManager.class), r1, r2).createRecyclerViewAdapter(r3);
    }

    private static UserAdapter createUserAdapter(UserManager r3, Context r4, List<UserHandle> r5) {
        updateUserHandlesIfNeeded(r3, r5);
        ArrayList r0 = new ArrayList(r5.size());
        Iterator<UserHandle> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L7;
        r0.add(new UserDetails(r6.next(), r3, r4));
        goto L4
    L7:
        return new UserAdapter(r4, r0);
    }

    private static void updateUserHandlesIfNeeded(UserManager r2, List<UserHandle> r3) {
        int r0 = r3.size() - 1;
    L3:
        if (r0 < 0) goto L8;
        if (ProfileSelectDialog.shouldHideUser(r3.get(r0), r2) == false) goto L7;
        r3.remove(r0);
    L7:
        r0 = r0 - 1;
        goto L3
    }
}
