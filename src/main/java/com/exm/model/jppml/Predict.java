package com.exm.model.jppml;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.dmg.pmml.FieldName;
import org.jpmml.evaluator.DefaultVisitorBattery;
import org.jpmml.evaluator.Evaluator;
import org.jpmml.evaluator.FieldValue;
import org.jpmml.evaluator.InputField;
import org.jpmml.evaluator.LoadingModelEvaluatorBuilder;
import org.jpmml.evaluator.TargetField;

public class Predict {

	public static void main(String[] args) throws Exception{
		// Building a model evaluator from a PMML file
		String pmmlPath = args[0];
		Evaluator evaluator = new LoadingModelEvaluatorBuilder()
			.setLocatable(false)
			.setVisitors(new DefaultVisitorBattery())
			.load(new File(pmmlPath))
			.build();

	
	
		Map<String, Object> arguments = new LinkedHashMap<String, Object>();
		arguments.put("gender", "Male");
		arguments.put("age",55 );
		arguments.put("hypertension", 1.0);
		arguments.put("heart_disease", 0);
		arguments.put("ever_married", "Yes");
		arguments.put("work_type", "Private");
		arguments.put("bmi_full", 17.6);
		
		Predict pd = new Predict();
		System.out.println("this is going to be a test");
		pd.preparePmmlValues(evaluator, arguments);
		
		
	}
	
	public void preparePmmlValues(Evaluator evaluator, Map<String, Object> userArguments) {
		Map<FieldName, FieldValue> pmmlArguments = new LinkedHashMap<FieldName, FieldValue>();
		
		List<InputField> activeFields = evaluator.getActiveFields();
		  for(InputField activeField : activeFields){
			  
		    Object userValue = userArguments.get(activeField.getFieldName().toString());
		    System.out.println("USER VALUE::" + userValue);
		   
		    FieldValue pmmlValue = FieldValue.create(activeField.getDataType(), activeField.getOpType(), userValue);

		    pmmlArguments.put(activeField.getFieldName(), pmmlValue);
		  }
		    Map<FieldName, ?> results = evaluator.evaluate(pmmlArguments);
		    
		    List<? extends TargetField> targetFields = evaluator.getTargetFields();
		    for(TargetField targetField : targetFields){
		    	FieldName targetName = targetField.getName();

		    	Object targetValue = results.get(targetName);
		    	
		    	System.out.println(targetName +" " + targetValue);
		    }
		    
		    
		  
		
	}

}
