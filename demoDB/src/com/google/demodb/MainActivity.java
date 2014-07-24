package com.google.demodb;

import java.sql.ResultSet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		try {
            //データベースに接続
            Connection con = MySqlConnect.getConnection();
            //ステートメントオブジェクトを作成
            Statement stmt = (Statement) con.createStatement();

            //SQL
            String mySql = "select id from point_list;";
            ResultSet rs = stmt.executeQuery(mySql);

            while(rs.next()) {
                Toast.makeText(getApplicationContext(), rs.getString("id"), Toast.LENGTH_LONG).show();
            }

            //オブジェクトを解放
            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {

        }


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}


	// 新規作成ボタンをタップ
	public void newBtn_onClick (View view) {

		Intent i = new Intent(MainActivity.this, NewActivity.class);
		startActivity(i);

	}
}
