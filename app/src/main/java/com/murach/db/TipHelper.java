package com.murach.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * This class Creates, Updates, and Upgrades the Database
 */
public class TipHelper  extends SQLiteOpenHelper {

    private static final String DB_NAME = "savedtips.db";
    private static final int DB_VERSION = 1;

    private Context mContext;

    //Table column information must be public
    public static final String TABLE_TIPS = "TIPS";
    public static final String COL_ID = "_ID";
    public static final String COL_BILL_DATE = "BILL_DATE";
    public static final String COL_BILL_AMOUNT = "BILL_AMOUNT";
    public static final String COL_TIP_PERCENT = "TIP_PERCENT";

    private static final java.lang.String DB_CREATE_TIP_TABLE =
            "CREATE TABLE " + TABLE_TIPS +"(" +
                    COL_ID          + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_BILL_DATE   + " INTEGER NOT NULL, " +
                    COL_BILL_AMOUNT + " REAL NOT NULL, " +
                    COL_TIP_PERCENT + " REAL NOT NULL" +
                    ")";

    public TipHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        mContext = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP SCHEMEA IF EXISTS ");
        db.execSQL(DB_CREATE_TIP_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
