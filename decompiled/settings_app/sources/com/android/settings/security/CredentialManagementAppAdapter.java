package com.android.settings.security;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.settings.R;
import com.android.settingslib.utils.StringUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class CredentialManagementAppAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int HEADER_VIEW = 1;
    private final Map<String, Map<Uri, String>> mAppUriAuthentication;
    private final Context mContext;
    private final String mCredentialManagerPackage;
    private final boolean mIncludeExpander;
    private final boolean mIncludeHeader;
    private final boolean mIsLayoutRtl;
    private final PackageManager mPackageManager;
    private final List<String> mSortedAppNames;
    private final RecyclerView.RecycledViewPool mViewPool;

    public class AppAuthenticationViewHolder extends RecyclerView.ViewHolder {
        private final ImageView mAppIconView;
        private final TextView mAppNameView;
        private final RecyclerView mChildRecyclerView;
        private final List<String> mExpandedApps;
        private final ImageView mExpanderIconView;
        private final TextView mNumberOfUrisView;
        final /* synthetic */ CredentialManagementAppAdapter this$0;

        public AppAuthenticationViewHolder(CredentialManagementAppAdapter r5, View r6) {
            this.this$0 = r5;
            super(r6);
            this.mAppIconView = (ImageView) r6.findViewById(R.id.app_icon);
            this.mAppNameView = (TextView) r6.findViewById(R.id.app_name);
            this.mNumberOfUrisView = (TextView) r6.findViewById(R.id.number_of_uris);
            ImageView r2 = (ImageView) r6.findViewById(R.id.expand);
            this.mExpanderIconView = r2;
            this.mChildRecyclerView = (RecyclerView) r6.findViewById(R.id.uris);
            this.mExpandedApps = new ArrayList();
            if (CredentialManagementAppAdapter.access$300(r5) == false) goto L5;
            RelativeLayout.LayoutParams r7 = (RelativeLayout.LayoutParams) ((RelativeLayout) r6.findViewById(R.id.app_details)).getLayoutParams();
            r7.addRule(0, R.id.app_icon);
            r7.addRule(1, R.id.expand);
            r6.setLayoutParams(r7);
        L5:
            r2.setOnClickListener(new CredentialManagementAppAdapter$AppAuthenticationViewHolder$$ExternalSyntheticLambda0(this));
        }

        /* JADX INFO: renamed from: lambda$new$0$com-android-settings-security-CredentialManagementAppAdapter$AppAuthenticationViewHolder, reason: not valid java name */
        /* synthetic */ void m590xd419f8d0(View r2) {
            String r3 = (String) CredentialManagementAppAdapter.access$400(this.this$0).get(getAdapterPosition());
            if (this.mExpandedApps.contains(r3) == false) goto L5;
            this.mExpandedApps.remove(r3);
        L6:
            bindPolicyView(r3);
            return;
        L5:
            this.mExpandedApps.add(r3);
            goto L6
        }

        public void bindView(int r6) {
            String r7 = (String) CredentialManagementAppAdapter.access$400(this.this$0).get(r6);
            ApplicationInfo r0 = CredentialManagementAppAdapter.access$100(this.this$0).getApplicationInfo(r7, 0);     // Catch: PackageManager.NameNotFoundException -> L5
            this.mAppIconView.setImageDrawable(CredentialManagementAppAdapter.access$100(this.this$0).getApplicationIcon(r0));     // Catch: PackageManager.NameNotFoundException -> L5
            this.mAppNameView.setText(String.valueOf(r0.loadSafeLabel(CredentialManagementAppAdapter.access$100(this.this$0), 1000.0f, 5)));     // Catch: PackageManager.NameNotFoundException -> L5
        L6:
            bindPolicyView(r7);
            return;
        L5:
            this.mAppIconView.setImageDrawable(null);
            this.mAppNameView.setText(r7);
            goto L6
        }

        private void bindPolicyView(String r4) {
            if (CredentialManagementAppAdapter.access$500(this.this$0) == false) goto L8;
            this.mExpanderIconView.setVisibility(0);
            if (this.mExpandedApps.contains(r4) == false) goto L7;
            this.mNumberOfUrisView.setVisibility(8);
            this.mExpanderIconView.setImageResource(R.drawable.ic_expand_less);
            bindChildView((Map) CredentialManagementAppAdapter.access$600(this.this$0).get(r4));
            return;
        L7:
            this.mChildRecyclerView.setVisibility(8);
            this.mNumberOfUrisView.setVisibility(0);
            this.mNumberOfUrisView.setText(getNumberOfUrlsText((Map) CredentialManagementAppAdapter.access$600(this.this$0).get(r4)));
            this.mExpanderIconView.setImageResource(android.R.drawable.input_method_item_background_selector);
            return;
        L8:
            this.mNumberOfUrisView.setVisibility(8);
            this.mExpanderIconView.setVisibility(8);
            bindChildView((Map) CredentialManagementAppAdapter.access$600(this.this$0).get(r4));
        }

        private void bindChildView(Map<Uri, String> r5) {
            LinearLayoutManager r0 = new LinearLayoutManager(this.mChildRecyclerView.getContext(), 1, false);
            r0.setInitialPrefetchItemCount(r5.size());
            UriAuthenticationPolicyAdapter r1 = new UriAuthenticationPolicyAdapter(new ArrayList(r5.keySet()));
            this.mChildRecyclerView.setLayoutManager(r0);
            this.mChildRecyclerView.setVisibility(0);
            this.mChildRecyclerView.setAdapter(r1);
            this.mChildRecyclerView.setRecycledViewPool(CredentialManagementAppAdapter.access$700(this.this$0));
        }

        private String getNumberOfUrlsText(Map<Uri, String> r2) {
            return StringUtil.getIcuPluralsString(CredentialManagementAppAdapter.access$200(this.this$0), r2.size(), R.string.number_of_urls);
        }
    }

    public class HeaderViewHolder extends RecyclerView.ViewHolder {
        private final ImageView mAppIconView;
        private final TextView mTitleView;
        final /* synthetic */ CredentialManagementAppAdapter this$0;

        public HeaderViewHolder(CredentialManagementAppAdapter r1, View r2) {
            this.this$0 = r1;
            super(r2);
            this.mAppIconView = (ImageView) r2.findViewById(R.id.credential_management_app_icon);
            this.mTitleView = (TextView) r2.findViewById(R.id.credential_management_app_title);
        }

        public void bindView() {
            ApplicationInfo r3 = CredentialManagementAppAdapter.access$100(this.this$0).getApplicationInfo(CredentialManagementAppAdapter.access$000(this.this$0), 0);     // Catch: PackageManager.NameNotFoundException -> L5
            this.mAppIconView.setImageDrawable(CredentialManagementAppAdapter.access$100(this.this$0).getApplicationIcon(r3));     // Catch: PackageManager.NameNotFoundException -> L5
            this.mTitleView.setText(TextUtils.expandTemplate(CredentialManagementAppAdapter.access$200(this.this$0).getText(R.string.request_manage_credentials_title), new CharSequence[]{r3.loadSafeLabel(CredentialManagementAppAdapter.access$100(this.this$0), 1000.0f, 5)}));     // Catch: PackageManager.NameNotFoundException -> L5
            return;
        L5:
            this.mAppIconView.setImageDrawable(null);
            this.mTitleView.setText(TextUtils.expandTemplate(CredentialManagementAppAdapter.access$200(this.this$0).getText(R.string.request_manage_credentials_title), new CharSequence[]{CredentialManagementAppAdapter.access$000(this.this$0)}));
        }
    }

    static /* synthetic */ String access$000(CredentialManagementAppAdapter r0) {
        return r0.mCredentialManagerPackage;
    }

    static /* synthetic */ PackageManager access$100(CredentialManagementAppAdapter r0) {
        return r0.mPackageManager;
    }

    static /* synthetic */ Context access$200(CredentialManagementAppAdapter r0) {
        return r0.mContext;
    }

    static /* synthetic */ boolean access$300(CredentialManagementAppAdapter r0) {
        return r0.mIsLayoutRtl;
    }

    static /* synthetic */ List access$400(CredentialManagementAppAdapter r0) {
        return r0.mSortedAppNames;
    }

    static /* synthetic */ boolean access$500(CredentialManagementAppAdapter r0) {
        return r0.mIncludeExpander;
    }

    static /* synthetic */ Map access$600(CredentialManagementAppAdapter r0) {
        return r0.mAppUriAuthentication;
    }

    static /* synthetic */ RecyclerView.RecycledViewPool access$700(CredentialManagementAppAdapter r0) {
        return r0.mViewPool;
    }

    public CredentialManagementAppAdapter(Context r1, String r2, Map<String, Map<Uri, String>> r3, boolean r4, boolean r5) {
        this.mContext = r1;
        this.mCredentialManagerPackage = r2;
        this.mPackageManager = r1.getPackageManager();
        this.mAppUriAuthentication = r3;
        this.mSortedAppNames = sortPackageNames(r3);
        this.mViewPool = new RecyclerView.RecycledViewPool();
        this.mIncludeHeader = r4;
        this.mIncludeExpander = r5;
        boolean r6 = true;
        if (r1.getResources().getConfiguration().getLayoutDirection() == 1) goto L6;
        r6 = false;
    L6:
        this.mIsLayoutRtl = r6;
    }

    private List<String> sortPackageNames(Map<String, Map<Uri, String>> r2) {
        ArrayList r0 = new ArrayList(r2.keySet());
        r0.sort(new CredentialManagementAppAdapter$$ExternalSyntheticLambda0(this));
        return r0;
    }

    /* JADX INFO: renamed from: lambda$sortPackageNames$0$com-android-settings-security-CredentialManagementAppAdapter, reason: not valid java name */
    /* synthetic */ int m589x27dd3770(String r2, String r3) {
        boolean r0 = isPackageInstalled(r2);
        if (r0 == isPackageInstalled(r3)) goto L5;
        if (r0 == false) goto L9;
        return -1;
    L9:
        return 1;
    L5:
        return r2.compareTo(r3);
    }

    private boolean isPackageInstalled(String r2) {
        this.mPackageManager.getPackageInfo(r2, 0);     // Catch: PackageManager.NameNotFoundException -> L6
        return true;
    L6:
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        if (r4 != 1) goto L7;
        View r5 = LayoutInflater.from(r3.getContext()).inflate(R.layout.request_manage_credentials_header, r3, false);
        r5.setEnabled(false);
        return new HeaderViewHolder(this, r5);
    L7:
        return new AppAuthenticationViewHolder(this, LayoutInflater.from(r3.getContext()).inflate(R.layout.app_authentication_item, r3, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder r2, int r3) {
        if ((r2 instanceof HeaderViewHolder) == false) goto L6;
        ((HeaderViewHolder) r2).bindView();
        return;
    L6:
        if ((r2 instanceof AppAuthenticationViewHolder) == true) goto L8;
        return;
    L8:
        if (this.mIncludeHeader == false) goto L10;
        r3 = r3 - 1;
    L10:
        ((AppAuthenticationViewHolder) r2).bindView(r3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        boolean r0 = this.mIncludeHeader;
        int r1 = this.mAppUriAuthentication.size();
        if (r0 == true) goto L5;
        return r1;
    L5:
        return r1 + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r2) {
        if (this.mIncludeHeader == false) goto L8;
        if (r2 != 0) goto L8;
        return 1;
    L8:
        return super.getItemViewType(r2);
    }
}
