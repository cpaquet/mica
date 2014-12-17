package request;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.UUID;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import requirements.Requirement;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CreateRequirement extends AsyncTask<String, Void, String> {
	
	private String requirementDescription;
	private View reqList;
    private ArrayList<Requirement> requirementsModels;

	public CreateRequirement(String nRequirementDescription, View nReqList, ArrayList<Requirement> nRequirementsModels) {
		super();
		this.requirementDescription = nRequirementDescription;
		this.reqList = nReqList;
		this.requirementsModels = nRequirementsModels;
	}

	@Override
	protected String doInBackground(String... urls) {
		String output = null;
		for (String url : urls) {
			output = getOutputFromUrl(url);
		}
		return output;
	}

	private String getOutputFromUrl(String url) {
		String output = null;
		try {
			DefaultHttpClient httpClient = new DefaultHttpClient();      
			HttpResponse httpResponse = httpClient.execute(forgeCreateRequirementRequest(url));
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

	private HttpPost forgeCreateRequirementRequest(String url) {
		HttpPost httpPost = new HttpPost(url);

		ArrayList<NameValuePair> postParameters;
		postParameters = new ArrayList<NameValuePair>();
		String descriptionVal = requirementDescription;

		postParameters.add(new BasicNameValuePair("description",descriptionVal ));               

		try {
			httpPost.setEntity(new UrlEncodedFormEntity(postParameters));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return httpPost;
	}

	@Override
	protected void onPostExecute(String output) {
		System.out.println(output);
		requirementsModels.add(new Requirement(requirementDescription, output));
		ArrayAdapter a = (ArrayAdapter)((ListView)reqList).getAdapter();
		a.notifyDataSetChanged();
	}
	
}

