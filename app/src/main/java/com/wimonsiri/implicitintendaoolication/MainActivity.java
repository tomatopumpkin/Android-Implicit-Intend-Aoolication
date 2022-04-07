package com.wimonsiri.implicitintendaoolication;

import androidx.appcompat.app.AppCompatActivity;
import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
public class MainActivity extends ListActivity {
    static final String[] ACTIVITY_CHOICES = new String[] {
            "Open WebSite Example", "Open Contacts",
            "Open Phone Dialer Example", "Search Google Example" , "Exit"
    };
    final String searchTerms = "superman";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, ACTIVITY_CHOICES));
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        getListView().setTextFilterEnabled(true);
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int
                    arg2, long arg3) {
                switch (arg2) {
                    case 0:// open web brower and navigates to given website
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://www.android.com/")));
                        break;
                    case 1: // open contacts application to browse contacts
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("content://contacts/people/")));
                        break;
                    case 2: //open phone dialer and fill in the given number
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("tel:037217200")));
                        break;
                    case 3: // search Google for the string
                        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                        intent.putExtra(SearchManager.QUERY, searchTerms);
                        startActivity(intent);

                        break;

                    case 4: // exit program
                        finish();
                        break;
                    default:
                        break;
                }
            }
        });
    }
}