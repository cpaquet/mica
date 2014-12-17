package apply;

import java.util.ArrayList;

import request.CreateRequirement;
import request.GetRequirement;
import requirements.Requirement;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import cpaquet.app.R;

public class MainActivity extends Activity implements OnClickListener{
	Button button;
	TextView outputText;
	EditText requirementDescription;
	ListView requirementsView ;
	ArrayList<Requirement> requirementsModels;
	ArrayAdapter<Requirement> adapter;

	public static final String URL = "http://10.0.2.2:8080/requirements";

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_http_get_servlet);
		requirementsModels = new ArrayList<Requirement>();

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

		adapter = new ArrayAdapter<Requirement>(this,
				android.R.layout.simple_list_item_1, requirementsModels);
		
		// Assign adapter to ListView
		requirementsView.setAdapter(adapter); 

		GetRequirement task = new GetRequirement(requirementsView, requirementsModels);
		task.execute(new String[] { URL });
	}

	public void onClick(View view) {
		CreateRequirement task = new CreateRequirement(requirementDescription.getText().toString(), requirementsView, requirementsModels);
		task.execute(new String[] { URL });
	}

}
