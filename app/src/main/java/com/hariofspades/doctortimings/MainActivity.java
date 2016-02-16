package com.hariofspades.doctortimings;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.hariofspades.doctortimings.Adapter.TimingsAdapter;
import com.hariofspades.doctortimings.Pojo.Timings;
import com.touchboarder.weekdaysbuttons.WeekdaysDataItem;
import com.touchboarder.weekdaysbuttons.WeekdaysDataSource;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements WeekdaysDataSource.Callback {

    RecyclerView recyclerView;
    TimingsAdapter adapter;
    private ArrayList<Timings> listContentArr= new ArrayList<>();
    String[] weekNames={"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        WeekdaysDataSource wds = new WeekdaysDataSource(this, R.id.weekdays_stub)
                .start(this);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        recyclerView=(RecyclerView)findViewById(R.id.list);
        //As explained in the tutorial, LineatLayoutManager tells the RecyclerView that the view
        //must be arranged in linear fashion
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new TimingsAdapter(this);
        adapter.setListContent(listContentArr);
        //We in turn set the adapter to the RecyclerView
        recyclerView.setAdapter(adapter);
        //Method call for populating the view
        //populateRecyclerViewValues();
    }

    private void populateRecyclerViewValues() {
        for(int i=0;i<weekNames.length;i++) {
            Timings pojoObject = new Timings();
            //Values are binded using set method of the POJO class
            pojoObject.setWeek(weekNames[i]);
            //After setting the values, we add all the Objects to the array
            //Hence, listConentArr is a collection of Array of POJO objects
            listContentArr.add(pojoObject);
        }
        adapter.setListContent(listContentArr);
        //We in turn set the adapter to the RecyclerView
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onWeekdaysItemClicked(int i, WeekdaysDataItem weekdaysDataItem) {
//        Calendar calendar = Calendar.getInstance();
//        if(weekdaysDataItem.getCalendarDayId()==calendar.get(Calendar.DAY_OF_WEEK)
//                &&weekdaysDataItem.isSelected())
//            Toast.makeText(MainActivity.this,
//                   weekdaysDataItem.getLabel(), Toast.LENGTH_SHORT).show();
        AdditionDeletionTime(weekdaysDataItem);
    }

    @Override
    public void onWeekdaysSelected(int i, ArrayList<WeekdaysDataItem> arrayList) {

    }

    public void AdditionDeletionTime(WeekdaysDataItem dataItem){
        if(dataItem.isSelected()){
            Timings pojoObject = new Timings();
            //Values are binded using set method of the POJO class
            pojoObject.setWeek(dataItem.getLabel());
            //After setting the values, we add all the Objects to the array
            //Hence, listConentArr is a collection of Array of POJO objects
            listContentArr.add(pojoObject);
        }
        if(!dataItem.isSelected()){

            int i;
            for(i=0;i<listContentArr.size();i++){
                if(dataItem.getLabel().equals(listContentArr.get(i).getWeek())) {
                    listContentArr.remove(i);
                    break;
                }
            }
            adapter.setListContent(listContentArr);
        }

        adapter.notifyDataSetChanged();

    }
}
