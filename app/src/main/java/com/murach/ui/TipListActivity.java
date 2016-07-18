package com.murach.ui;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteQueryBuilder;
import android.icu.math.BigDecimal;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.murach.db.TipDataSource;
import com.murach.db.TipHelper;
import com.murach.tipcalculator.R;
import com.murach.tipcalculator.Tip;
import com.murach.tipcalculator.TipCalculatorActivity;

import java.util.ArrayList;
import java.util.List;

public class TipListActivity extends Activity {

    private Button backButton;

    protected TipDataSource mDataSource;
    protected ArrayList<BigDecimal> mTipsArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_tip_list);

        mDataSource = new TipDataSource(TipListActivity.this);
        mTipsArrayList = new ArrayList<BigDecimal>();

        //initialise button and add listener
        backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(TipListActivity.this, TipCalculatorActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mDataSource.open();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mDataSource.close();
    }


}
