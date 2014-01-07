package com.example.demo.ui;

import com.example.demo.R;
import com.example.demo.api.ApiClient;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.Toast;

public class Main extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		ActionBar actionBar = this.getActionBar();  
		actionBar.setDisplayHomeAsUpEnabled(false);  
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		final SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
		searchView.setQueryHint(getResources().getString(R.string.action_search_hint));
		
		searchView.setOnQueryTextListener(new OnQueryTextListener() 
		{
			@Override
			public boolean onQueryTextSubmit(String q) 
			{
				InputMethodManager imm = (InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(searchView.getWindowToken(), 0);
				
				loadBookData(q, 0, 5);;
				
				Intent intent = new Intent(Main.this, SearchResult.class);
				startActivity(intent);
				
				return false;
			}
			
			@Override
			public boolean onQueryTextChange(String newText) 
			{
				if (newText.length() > 0) 
				{	
				}
				else
				{	
				}
				return false;
			}
		});
		
	    return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) 
	{
	    switch (item.getItemId()) 
	    {
	        case R.id.action_search:
	        {
	        	//openSearch();
	        	Toast.makeText(getApplicationContext(), "search", Toast.LENGTH_SHORT).show();  
	        	return true;	        	
	        }
	        case R.id.action_labels:
	        {
	            //composeMessage();
	        	Toast.makeText(getApplicationContext(), "labels", Toast.LENGTH_SHORT).show();
	        	Intent intent = new Intent(this, Labels.class);
	        	startActivity(intent);
	            return true;
	        }
	        default:
	        {
	            return super.onOptionsItemSelected(item);
	        }
	    }
	}
	
	private static void loadBookData(String q, int start, int count)
	{
		ApiClient.getBookList(q, start, count);
	}
}
