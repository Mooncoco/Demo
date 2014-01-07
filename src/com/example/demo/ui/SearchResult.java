package com.example.demo.ui;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.R;
import com.example.demo.adapter.ListViewBookAdapter;
import com.example.demo.bean.Book;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class SearchResult extends Activity 
{
	private ListViewBookAdapter lvBookAdapter;
	
	private List<Book> lvBookData = new ArrayList<Book>();
	
	private Handler lvBookHandler;
	
	private int lvBookSumData;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		ActionBar actionBar = this.getActionBar();  
		actionBar.setDisplayHomeAsUpEnabled(true);
	}
	
	private void initBookListView()
	{
		lvBookAdapter = new ListViewBookAdapter(this, lvBookData, R.layout.search_list_item);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.search_result, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) 
	{
	    switch (item.getItemId()) 
	    {
	        case R.id.action_refresh:
	        {
	        	Toast.makeText(getApplicationContext(), "refresh", Toast.LENGTH_SHORT).show();  
	        	return true;	        	
	        }
	        case android.R.id.home:
	        {
	        	finish();
	        }
	        default:
	        {
	            return super.onOptionsItemSelected(item);
	        }
	    }
	}
	
	
}
