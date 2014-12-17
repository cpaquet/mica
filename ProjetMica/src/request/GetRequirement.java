package request;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import requirements.Requirement;
import requirements.RequirementsParser;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class GetRequirement extends AsyncTask<String, Void, String>{
	private View reqList;
    private ArrayList<Requirement> requirementsModels;
    
	public GetRequirement(View nReqList, ArrayList<Requirement> nRequirementsModels) {
		super();
		this.reqList = nReqList;
		this.requirementsModels = nRequirementsModels;
	}
	@Override
	protected String doInBackground(String... params) {
		String output = null;
		try {
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet(params[0]);
			HttpResponse httpResponse = httpClient.execute(httpGet);
			HttpEntity httpEntity = httpResponse.getEntity();
			output = EntityUtils.toString(httpEntity);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return output;
	}
	
	protected void onPostExecute(String output) {		
		RequirementsParser parser = new RequirementsParser();
		requirementsModels.addAll(parser.createRequirementsFromXML(output));
		ArrayAdapter a = (ArrayAdapter)((ListView)reqList).getAdapter();
		a.notifyDataSetChanged();
	}

}
