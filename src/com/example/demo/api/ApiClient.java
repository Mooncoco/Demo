package com.example.demo.api;

import org.json.JSONObject;

import com.example.demo.bean.Book;
import com.example.demo.bean.BookList;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import android.graphics.Bitmap;

public class ApiClient 
{	
	/**
	 * 获取网络图片
	 * @param url
	 * @return bitmap
	 */
	public static Bitmap getNetBitmap(String url)
	{
		Bitmap bitmap = null;
		return bitmap;
	}
	
	/**
	 * 获取图书详细信息
	 * @param id
	 * @return book
	 */
	public static Book getBookDetail(String id)
	{	
		HttpClient.get(id, null, new JsonHttpResponseHandler()
		{
			@Override
			public void onSuccess(JSONObject arg0)
			{
				super.onSuccess(arg0);
			}

			@Override
			public void onFinish()
			{
				super.onFinish();
			}

			@Override
			public void onStart()
			{
				super.onStart();
			}
			
		});
		return Book.parse();
	}
	
	/**
	 * 图书列表（搜索图书结果）
	 * @param start
	 * @param count
	 * @return 图书列表
	 */
	public static BookList getBookList(String q, int start, int count)
	{
		RequestParams params = new RequestParams();
		
		try
		{
			params.put("q", q);
			params.put("start", String.valueOf(start));;
			params.put("count", String.valueOf(count));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		HttpClient.get("search", params, new JsonHttpResponseHandler()
		{

			@Override
			public void onFinish()
			{
				super.onFinish();
				System.out.println("android-asyn-http::onfinish!!!");
			}

			@Override
			public void onStart()
			{
				super.onStart();
				System.out.println("android-asyn-http::onstart!!!");
			}

			@Override
			public void onSuccess(JSONObject jsonObj)
			{
				super.onSuccess(jsonObj);
				System.out.println("android-asyn-http::onfinish::jsonobject!!!");
			}

			@Override
			public void onFailure(Throwable arg0)
			{
				System.out.println("android-asyn-http::onfailure!!!");
			}
			
		});
		
		return BookList.parse();
	}
}
