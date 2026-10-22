package com.android.settings;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import coil.Coil;
import coil.request.Disposable;
import coil.request.ImageRequest;
import coil.transform.CircleCropTransformation;
import coil.transform.Transformation;
import com.android.settings.accounts.OAccountHelper;
import com.obric.matrix.platform.sdk.ones.account.AccountInfo;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.text.OTextView;
import com.obric.widget.SettingListItem;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final enum AccountSettingHelper extends Enum<AccountSettingHelper> {
    private static final /* synthetic */ AccountSettingHelper[] $VALUES = null;
    public static final AccountSettingHelper INSTANCE = null;
    private static final String TAG = "AccountSettingHelper";

    private static /* synthetic */ AccountSettingHelper[] $values() {
        return new AccountSettingHelper[]{INSTANCE};
    }

    private AccountSettingHelper(String r1, int r2) {
        super(r1, r2);
    }

    static /* synthetic */ void access$000(List r0) {
        disposeRequest(r0);
    }

    public static AccountSettingHelper valueOf(String r1) {
        return (AccountSettingHelper) Enum.valueOf(AccountSettingHelper.class, r1);
    }

    public static AccountSettingHelper[] values() {
        return (AccountSettingHelper[]) $VALUES.clone();
    }

    static {
        INSTANCE = new AccountSettingHelper("INSTANCE", 0);
        $VALUES = $values();
    }

    public void setupSettingItemView(Context r7, SettingListItem r8, MainSettingsFragment.SettingItem r9, View.OnClickListener r10) {
        OLog.d(TAG, "setupAccountSettingItem, settingItem id: " + r9.mId);
        AccountInfo r0 = OAccountHelper.getAccountInfo();
        if (r0 != null) goto L6;
        OLog.e(TAG, "setupAccountSettingItem, accountInfo is null");
        return;
    L6:
        r8.setId(r9.mId);
        OTextView r2 = r8.getTailTitleTextView();
        if (r9.mSubTitle != null) goto L9;
        String r3 = "";
    L10:
        r2.setText(r3);
        r8.setOnClickListener(r10);
        String r11 = r7.getString(r9.mTitleRes);
        OLog.i(TAG, "setupAccountSettingItem, accountInfo.getLoginState() " + r0.getLoginState());
        if (r0.getLoginState() == false) goto L17;
        String r4 = r0.getUserName();
        if (TextUtils.isEmpty(r4) == true) goto L16;
        r11 = r4;
    L16:
        r8.getTitleTextView().setText(r11);
    L18:
        r8.getSubtitleTextView().setText(r7.getString(R.string.system_account_header_subtitle));
        String r12 = r0.getAvatarUrl();
        final ArrayList r1 = new ArrayList();
        r1.add(Coil.imageLoader(r7).enqueue(new ImageRequest.Builder(r7).transformations(new Transformation[]{new CircleCropTransformation()}).placeholder(r9.mIconRes).error(r9.mIconRes).data(r12).target(r8.getContentImageView()).listener(new AnonymousClass1(this, r1)).build()));     // Catch: Exception -> L21
        return;
    L21:
        e = move-exception;
        OLog.e(TAG, "setupAccountSettingItem. load avatar error", e);
        disposeRequest(r1);
        r8.getContentImageView().setImageResource(r9.mIconRes);
        return;
    L17:
        r8.getTitleTextView().setText(r11);
        goto L18
    L9:
        r3 = r9.mSubTitle;
        goto L10
    }

    public void setupSettingItemView(Context r7, final OCardListItem r8, MainSettingsFragment.SettingItem r9, final View.OnClickListener r10) {
        OLog.d(TAG, "setupAccountSettingItem, settingItem id: " + r9.mId);
        AccountInfo r0 = OAccountHelper.getAccountInfo();
        if (r0 != null) goto L6;
        OLog.e(TAG, "setupAccountSettingItem, accountInfo is null");
        return;
    L6:
        r8.setId(r9.mId);
        r8.showSubTitle(true);
        r8.setOnContentClickListener(new AnonymousClass2(this, r10, r8));
        String r11 = r7.getString(r9.mTitleRes);
        OLog.i(TAG, "setupAccountSettingItem, accountInfo.getLoginState() " + r0.getLoginState());
        if (r0.getLoginState() == false) goto L13;
        String r3 = r0.getUserName();
        if (TextUtils.isEmpty(r3) == true) goto L12;
        r11 = r3;
    L12:
        r8.setTitle(r11);
        r8.setSubTitle(r7.getString(R.string.system_account_header_subtitle));
    L14:
        String r12 = r0.getAvatarUrl();
        final ArrayList r1 = new ArrayList();
        r1.add(Coil.imageLoader(r7).enqueue(new ImageRequest.Builder(r7).transformations(new Transformation[]{new CircleCropTransformation()}).placeholder(r9.mIconRes).error(r9.mIconRes).data(r12).listener(new AnonymousClass3(this, r8, r1)).build()));     // Catch: Exception -> L17
        return;
    L17:
        e = move-exception;
        OLog.e(TAG, "setupAccountSettingItem. load avatar error", e);
        disposeRequest(r1);
        r8.setIcon(r9.mIconRes);
        return;
    L13:
        r8.setTitle(r11);
        r8.setSubTitle(r7.getString(R.string.system_account_header_subtitle));
        goto L14
    }

    private static void disposeRequest(List<Disposable> r2) {
    L9:
        e = move-exception;
        OLog.e(TAG, "disposeRequest error", e);
        return;
    L3:
        if (r2.isEmpty() == true) goto L14;
        Disposable r0 = r2.get(0);     // Catch: Exception -> L9
        if (r0 == null) goto L7;
        r0.dispose();     // Catch: Exception -> L9
    L7:
        r2.clear();     // Catch: Exception -> L9
        return;
    }
}
