package vendor.bytedance.hardware.keymanager;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class KeyParameterValue implements Parcelable {
    public static final Parcelable.Creator<KeyParameterValue> CREATOR = null;
    public static final int algorithm = 1;
    public static final int attestInfo = 8;
    public static final int boolValue = 7;
    public static final int digest = 2;
    public static final int expiryDate = 6;
    public static final int invalid = 0;
    public static final int keyBytes = 5;
    public static final int length = 4;
    public static final int purpose = 3;
    private int _tag;
    private Object _value;

    public @interface Tag {
        public static final int algorithm = 1;
        public static final int attestInfo = 8;
        public static final int boolValue = 7;
        public static final int digest = 2;
        public static final int expiryDate = 6;
        public static final int invalid = 0;
        public static final int keyBytes = 5;
        public static final int length = 4;
        public static final int purpose = 3;
    }

    /* synthetic */ KeyParameterValue(Parcel r1, KeyParameterValueIA r2) {
        this(r1);
    }

    public KeyParameterValue() {
        this._tag = 0;
        this._value = 0;
    }

    private KeyParameterValue(Parcel _aidl_parcel) {
        readFromParcel(_aidl_parcel);
    }

    private KeyParameterValue(int _tag, Object _value) {
        this._tag = _tag;
        this._value = _value;
    }

    public int getTag() {
        return this._tag;
    }

    public static KeyParameterValue invalid(int _value) {
        return new KeyParameterValue(0, Integer.valueOf(_value));
    }

    public int getInvalid() {
        _assertTag(0);
        return ((Integer) this._value).intValue();
    }

    public void setInvalid(int _value) {
        _set(0, Integer.valueOf(_value));
    }

    public static KeyParameterValue algorithm(int _value) {
        return new KeyParameterValue(1, Integer.valueOf(_value));
    }

    public int getAlgorithm() {
        _assertTag(1);
        return ((Integer) this._value).intValue();
    }

    public void setAlgorithm(int _value) {
        _set(1, Integer.valueOf(_value));
    }

    public static KeyParameterValue digest(int _value) {
        return new KeyParameterValue(2, Integer.valueOf(_value));
    }

    public int getDigest() {
        _assertTag(2);
        return ((Integer) this._value).intValue();
    }

    public void setDigest(int _value) {
        _set(2, Integer.valueOf(_value));
    }

    public static KeyParameterValue purpose(int _value) {
        return new KeyParameterValue(3, Integer.valueOf(_value));
    }

    public int getPurpose() {
        _assertTag(3);
        return ((Integer) this._value).intValue();
    }

    public void setPurpose(int _value) {
        _set(3, Integer.valueOf(_value));
    }

    public static KeyParameterValue length(int _value) {
        return new KeyParameterValue(4, Integer.valueOf(_value));
    }

    public int getLength() {
        _assertTag(4);
        return ((Integer) this._value).intValue();
    }

    public void setLength(int _value) {
        _set(4, Integer.valueOf(_value));
    }

    public static KeyParameterValue keyBytes(byte[] _value) {
        return new KeyParameterValue(5, _value);
    }

    public byte[] getKeyBytes() {
        _assertTag(5);
        return (byte[]) this._value;
    }

    public void setKeyBytes(byte[] _value) {
        _set(5, _value);
    }

    public static KeyParameterValue expiryDate(String _value) {
        return new KeyParameterValue(6, _value);
    }

    public String getExpiryDate() {
        _assertTag(6);
        return (String) this._value;
    }

    public void setExpiryDate(String _value) {
        _set(6, _value);
    }

    public static KeyParameterValue boolValue(boolean _value) {
        return new KeyParameterValue(7, Boolean.valueOf(_value));
    }

    public boolean getBoolValue() {
        _assertTag(7);
        return ((Boolean) this._value).booleanValue();
    }

    public void setBoolValue(boolean _value) {
        _set(7, Boolean.valueOf(_value));
    }

    public static KeyParameterValue attestInfo(String _value) {
        return new KeyParameterValue(8, _value);
    }

    public String getAttestInfo() {
        _assertTag(8);
        return (String) this._value;
    }

    public void setAttestInfo(String _value) {
        _set(8, _value);
    }

    public final int getStability() {
        return 1;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel _aidl_parcel, int _aidl_flag) {
        _aidl_parcel.writeInt(this._tag);
        switch(this._tag) {
            case 0: goto L13;
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            case 8: goto L5;
            default: goto L23;
        };
    L5:
        _aidl_parcel.writeString(getAttestInfo());
        return;
    L6:
        _aidl_parcel.writeBoolean(getBoolValue());
        return;
    L7:
        _aidl_parcel.writeString(getExpiryDate());
        return;
    L8:
        _aidl_parcel.writeByteArray(getKeyBytes());
        return;
    L9:
        _aidl_parcel.writeInt(getLength());
        return;
    L10:
        _aidl_parcel.writeInt(getPurpose());
        return;
    L11:
        _aidl_parcel.writeInt(getDigest());
        return;
    L12:
        _aidl_parcel.writeInt(getAlgorithm());
        return;
    L13:
        _aidl_parcel.writeInt(getInvalid());
        return;
    }

    public void readFromParcel(Parcel _aidl_parcel) {
        int _aidl_tag = _aidl_parcel.readInt();
        switch(_aidl_tag) {
            case 0: goto L22;
            case 1: goto L20;
            case 2: goto L18;
            case 3: goto L16;
            case 4: goto L14;
            case 5: goto L12;
            case 6: goto L10;
            case 7: goto L8;
            case 8: goto L6;
            default: goto L5;
        };
    L6:
        String _aidl_value = _aidl_parcel.readString();
        _set(_aidl_tag, _aidl_value);
        return;
    L8:
        boolean _aidl_value2 = _aidl_parcel.readBoolean();
        _set(_aidl_tag, Boolean.valueOf(_aidl_value2));
        return;
    L10:
        String _aidl_value3 = _aidl_parcel.readString();
        _set(_aidl_tag, _aidl_value3);
        return;
    L12:
        byte[] _aidl_value4 = _aidl_parcel.createByteArray();
        _set(_aidl_tag, _aidl_value4);
        return;
    L14:
        int _aidl_value5 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value5));
        return;
    L16:
        int _aidl_value6 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value6));
        return;
    L18:
        int _aidl_value7 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value7));
        return;
    L20:
        int _aidl_value8 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value8));
        return;
    L22:
        int _aidl_value9 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value9));
        return;
    L5:
        throw new IllegalArgumentException("union: unknown tag: " + _aidl_tag);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        getTag();
        return 0;
    }

    private void _assertTag(int tag) {
        if (getTag() != tag) goto L6;
        return;
    L6:
        throw new IllegalStateException("bad access: " + _tagString(tag) + ", " + _tagString(getTag()) + " is available.");
    }

    private String _tagString(int _tag) {
        switch(_tag) {
            case 0: goto L21;
            case 1: goto L19;
            case 2: goto L17;
            case 3: goto L15;
            case 4: goto L13;
            case 5: goto L11;
            case 6: goto L9;
            case 7: goto L7;
            case 8: goto L5;
            default: goto L4;
        };
    L5:
        return "attestInfo";
    L7:
        return "boolValue";
    L9:
        return "expiryDate";
    L11:
        return "keyBytes";
    L13:
        return "length";
    L15:
        return "purpose";
    L17:
        return "digest";
    L19:
        return "algorithm";
    L21:
        return "invalid";
    L4:
        throw new IllegalStateException("unknown field: " + _tag);
    }

    private void _set(int _tag, Object _value) {
        this._tag = _tag;
        this._value = _value;
    }
}
