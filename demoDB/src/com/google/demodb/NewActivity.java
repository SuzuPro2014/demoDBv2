package com.google.demodb;

import java.util.ArrayList;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;


public class NewActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_newdata);

		WifiManager manager = (WifiManager) getSystemService(WIFI_SERVICE);
		WifiInfo info = manager.getConnectionInfo();

		String[] apInfo = new String[2];

		// SSIDを取得
		apInfo[0] = String.format("SSID : %s", info.getSSID());

		// BSSIDを取得 ※Wi-FiのMacアドレス
		apInfo[1] = String.format("BSSID : %s", info.getBSSID());

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, apInfo);

		ListView listView = (ListView) findViewById(R.id.wifiInfo_list);
		listView.setAdapter(adapter);

		createSpinner();

	}

	public void createSpinner () {

		ArrayList<String> locList = new ArrayList<String>();

		String [] memo = {"ゼミ101A", "ゼミ101B", "ゼミ101C", "ゼミ101D", "ゼミ101E", "ゼミ101F", "ゼミ101G", "ゼミ101H",
						  "10101教室", "10102教室", "10103教室", "SHIDAX", "ラウンジ", "コネクションギャラリー", "コウサ展 in Summer 会場"};

		for (int i = 0; i < memo.length; i++) {
			locList.add(memo[i]);
		}

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, locList);

		Spinner sp = (Spinner) this.findViewById(R.id.location_spinner);

		sp.setAdapter(adapter);

		sp.setOnItemSelectedListener(new OnItemSelectedListener () {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				// TODO 自動生成されたメソッド・スタブ
				Spinner sp =(Spinner)parent;

				Toast.makeText(NewActivity.this,
						String.format("選択項目：%s", sp.getSelectedItem()),
						Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO 自動生成されたメソッド・スタブ

			}

		});

	}


	// 保存ボタンを押した処理
	public void saveBtn_onClick (View view) {

		finish();

	}

}
