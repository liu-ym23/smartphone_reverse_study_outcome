package obric.app.share;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes5.dex */
public class ShareItem implements Parcelable {
    public static final Parcelable.Creator<ShareItem> CREATOR = null;
    public static final String EXTRA_SHARE_ITEM_DATAS = "EXTRA_SHARE_ITEM_DATAS";
    public static final String EXTRA_SHARE_ITEM_ONLY_CUSTOM_ITEMS = "EXTRA_SHARE_ITEM_ONLY_CUSTOM_ITEMS";
    public static final String EXTRA_SHARE_ITEM_RETURN_TARGET = "EXTRA_SHARE_ITEM_RETURN_TARGET";
    public static final String EXTRA_SHARE_ITEM_RETURN_TYPE = "EXTRA_SHARE_ITEM_RETURN_TYPE";
    public static final int SHARE_ITEM_TYPE_ACTIVITY = 1;
    public static final int SHARE_ITEM_TYPE_CUSTOM = 2;
    public static final int SHARE_ITEM_TYPE_EXCLUDE = 3;
    public static final int SHARE_ITEM_TYPE_UNDEFINE = -1;
    private String mActivityName;
    private int mImgResId;
    private int mLabelResId;
    private String mPackageName;
    private String mTarget;
    private int mType;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* synthetic */ ShareItem(Parcel r1, AnonymousClass1 r2) {
        this(r1);
    }

    public static ShareItem createForActivity(String packageName) {
        return new ShareItem(packageName, 1, 0, 0, null, null);
    }

    public static ShareItem createForActivity(String packageName, String activityName) {
        return new ShareItem(packageName, 1, 0, 0, null, activityName);
    }

    public static ShareItem createForCustom(String packageName, int imgResId, int labelResId, String target) {
        return new ShareItem(packageName, 2, imgResId, labelResId, target, null);
    }

    public static ShareItem createForExclude(String packageName) {
        return new ShareItem(packageName, 3, 0, 0, null, null);
    }

    private ShareItem(String packageName, int type, int imgResId, int labelResId, String target, String activityName) {
        this.mType = type;
        this.mImgResId = imgResId;
        this.mLabelResId = labelResId;
        this.mTarget = target;
        this.mPackageName = packageName;
        this.mActivityName = activityName;
    }

    private ShareItem(Parcel in) {
        this.mType = in.readInt();
        this.mImgResId = in.readInt();
        this.mLabelResId = in.readInt();
        this.mTarget = in.readString();
        this.mPackageName = in.readString();
        this.mActivityName = in.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(this.mType);
        out.writeInt(this.mImgResId);
        out.writeInt(this.mLabelResId);
        out.writeString(this.mTarget);
        out.writeString(this.mPackageName);
        out.writeString(this.mActivityName);
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public int getType() {
        return this.mType;
    }

    public int getImgResId() {
        return this.mImgResId;
    }

    public int getLabelResId() {
        return this.mLabelResId;
    }

    public String getTarget() {
        return this.mTarget;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public String getActivityName() {
        return this.mActivityName;
    }

    public void setType(int type) {
        this.mType = type;
    }

    public void setImgResId(int imgResId) {
        this.mImgResId = imgResId;
    }

    public void setLabelResId(int labelResId) {
        this.mLabelResId = labelResId;
    }

    public void setTarget(String target) {
        this.mTarget = target;
    }

    public void setPackageName(String packageName) {
        this.mPackageName = packageName;
    }

    public void setActivityName(String activityName) {
        this.mActivityName = activityName;
    }

    public String toString() {
        Object[] r0 = new Object[6];
        r0[0] = Integer.valueOf(this.mType);
        r0[1] = Integer.valueOf(this.mImgResId);
        r0[2] = Integer.valueOf(this.mLabelResId);
        String r1 = this.mTarget;
        String r2 = "null";
        if (r1 != null) goto L6;
        r1 = "null";
    L6:
        r0[3] = r1;
        String r3 = this.mPackageName;
        if (r3 != null) goto L10;
        r3 = "null";
    L10:
        r0[4] = r3;
        String r4 = this.mActivityName;
        if (r4 == null) goto L13;
        r2 = r4;
    L13:
        r0[5] = r2;
        return String.format("{ mType=%d, mImgResId=%d, mLabelResId=%d, mTarget=%s, mPackageName=%s, mActivityName=%s }", r0);
    }

    public static boolean isValidCustomShareItem(ShareItem item) {
        if (item != null) goto L4;
        return false;
    L4:
        if (item.getType() == 2) goto L6;
        return false;
    L6:
        if (TextUtils.isEmpty(item.getPackageName()) == false) goto L8;
        return false;
    L8:
        if (item.getLabelResId() != 0) goto L10;
        return false;
    L10:
        if (item.getImgResId() == 0) goto L19;
        return true;
    L19:
        return false;
    }
}
