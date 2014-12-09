package apply;
 
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import request.CreateRequirement;
import request.GetRequirement;

 
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import cpaquet.app.R;
 
public class MainActivity extends Activity implements OnClickListener{
    Button button;
    TextView outputText;
    EditText requirementDescription;
    ListView requirementsView ;
    ArrayList<String> requirementsModels;
    ArrayAdapter<String> adapter;
    
    public static final String URL = "http://10.0.2.2:8080/requirements";
 
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_get_servlet);
        requirementsModels = new ArrayList<String>();
        
        findViewsById();
        initRequirementsView();
        button.setOnClickListener(this);
    }
 
    private void findViewsById() {
        button = (Button) findViewById(R.id.button);
        outputText = (TextView) findViewById(R.id.outputTxt);
        requirementDescription = (EditText) findViewById(R.id.requirementDescription);
        requirementsView = (ListView) findViewById(R.id.requirementsList);
    }
    
    private void initRequirementsView() {
 
    	adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, requirementsModels);
       // Assign adapter to ListView
    	requirementsView.setAdapter(adapter); 
    	
    	 GetRequirement task = new GetRequirement();
         task.execute(new String[] { URL });
    }
 
    public void onClick(View view) {
        CreateRequirement task = new CreateRequirement(requirementDescription.getText().toString(), requirementsView, requirementsModels);
        task.execute(new String[] { URL });
    }
   
}
