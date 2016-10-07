package com.dic.kimxeang.customlistview;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kim Xeang on 9/20/2016.
 */
public class CustomListViewAndroid extends Activity {
    ListView list;
    CustomAdapter adapter;
    public CustomListViewAndroid CustomListView = null;
    public ArrayList<ListModel> CustomListViewValuesArr = new ArrayList<ListModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view_android);
        CustomListView = this;

        setListData();
        Resources res = getResources();
        //List l = (ListView) findViewById(R.id.list);
        list=(ListView)findViewById(R.id.list);
        adapter = new CustomAdapter(CustomListView, CustomListViewValuesArr, res);
        list.setAdapter(adapter);
    }

    public void setListData() {

        for (int i = 0; i < 11; i++) {

            final ListModel sched = new ListModel();

            /******* Firstly take data in model object ******/
            sched.setCompanyName("Company " + i);
            sched.setImage("image" + i);
            sched.setUrl("http:\\www." + i + ".com");

            /******** Take Model Object in ArrayList **********/
            CustomListViewValuesArr.add(sched);
        }

    }

    /*****************
     * This function used by adapter
     ****************/
    public void onItemClick(int mPosition) {
        ListModel tempValues = (ListModel) CustomListViewValuesArr.get(mPosition);

        // SHOW ALERT

        Toast.makeText(CustomListView, "" + tempValues.getCompanyName() + " Image:" + tempValues.getImage() +
                " Url: " + tempValues.getUrl(), Toast.LENGTH_LONG).show();
    }

}
