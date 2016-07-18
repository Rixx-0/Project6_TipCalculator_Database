package com.murach.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.murach.tipcalculator.Tip;

/**
 * This class will run all query options
 */
public class TipDataSource {

    private SQLiteDatabase mDatabase;
    private TipHelper mTipHelper;
    private Context mContext;

    public TipDataSource(Context context) {
        mContext = context;
        mTipHelper = new TipHelper(context);
    }

    // open database
    public void open() throws SQLException {
        //getWriteableDatabase() pulls from SQLiteOpenHelper class
        mDatabase = mTipHelper.getWritableDatabase();
    }
    // close database
    public void close(){
        mDatabase.close();
    }

    // insert query
    public void insertTip(String date, float amount, float percent){
        ContentValues values = new ContentValues();
        values.put(TipHelper.COL_BILL_DATE, date);
        values.put(TipHelper.COL_BILL_AMOUNT, amount);
        values.put(TipHelper.COL_TIP_PERCENT, percent);
        mDatabase.insert(TipHelper.TABLE_TIPS, null, values);
    }
    // select queries
    // ===== select all ========
    public Cursor selectAllTips(){
        Cursor cursor = mDatabase.query(
                TipHelper.TABLE_TIPS, // table
                new String[] {
                        TipHelper.COL_ID,
                        TipHelper.COL_BILL_DATE,
                        TipHelper.COL_BILL_AMOUNT,
                        TipHelper.COL_TIP_PERCENT }, // column names
                null, // where clause
                null, // where params
                null, // groupby
                null, // having
                null  // orderby
        );

        if(cursor != null){
            cursor.moveToFirst();
        }
        return cursor;
    }

    // update query

    // delete query
}
