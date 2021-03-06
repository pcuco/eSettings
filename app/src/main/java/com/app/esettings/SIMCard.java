package com.app.esettings;

import android.Manifest;
import android.content.Context;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;

/**
 * Created by pcuco on 30/10/2016.
 */

// @TODO - Dual SIM

public class SIMCard {

    // GET SIM Card NUmber
    public static String getNumber(Context mContext){

        String simNumber;
        TelephonyManager mTelephonyManager = (TelephonyManager) mContext.getSystemService(Context.TELEPHONY_SERVICE);

        if (mTelephonyManager.getLine1Number() != null) {

            if (mTelephonyManager.getLine1Number().equals(""))
                simNumber = mContext.getString(R.string.unknown_SIM_number);
            else
                simNumber = mTelephonyManager.getLine1Number();

        } else
            simNumber = mContext.getString(R.string.NO_SIMCard);

        return simNumber;
    }

    //GET MCC(country)
    public static String getMCC (Context mContext){

        String mcc;
        TelephonyManager mTelephonyManager = (TelephonyManager) mContext.getSystemService(Context.TELEPHONY_SERVICE);

        if (mTelephonyManager.getSimCountryIso() != null) {
            mcc = mTelephonyManager.getSimCountryIso();

        } else {
            mcc = mContext.getString(R.string.error);
        }
        return mcc;
    }

    // GET MNC(Operator)
    public static String getMNC (Context mContext){

        String mnc;
        TelephonyManager mTelephonyManager = (TelephonyManager) mContext.getSystemService(Context.TELEPHONY_SERVICE);

        if (mTelephonyManager.getSimOperator() != null) {
            mnc = mTelephonyManager.getSimOperator();

        } else {
            mnc = mContext.getString(R.string.error);
        }
        return mnc;
    }

    // GET SIM Serial Number
    public static String getSerialNumber (Context mContext){

        String simSerialNumber;
        TelephonyManager mTelephonyManager = (TelephonyManager) mContext.getSystemService(Context.TELEPHONY_SERVICE);
        if (mTelephonyManager.getSimSerialNumber() != null) {
            simSerialNumber = mTelephonyManager.getSimSerialNumber();

        } else {
            simSerialNumber = mContext.getString(R.string.error);
        }
        return simSerialNumber;
    }

    // GET SIM IMSI Number
    public static String getIMSI (Context mContext){

        String simIMSI;
        TelephonyManager mTelephonyManager = (TelephonyManager) mContext.getSystemService(Context.TELEPHONY_SERVICE);
        if (mTelephonyManager.getSubscriberId() != null) {
            simIMSI = mTelephonyManager.getSubscriberId();

        } else {
            simIMSI = mContext.getString(R.string.error);
        }
        return simIMSI;
    }
}
