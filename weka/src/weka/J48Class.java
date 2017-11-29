package weka;

import weka.core.Instances;
import weka.core.Utils;
import weka.core.converters.ConverterUtils.DataSource;
import weka.core.Instances;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;
import weka.filters.unsupervised.attribute.StringToWordVector;
import weka.classifiers.evaluation.Evaluation;
import weka.classifiers.trees.J48;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class J48Class {
	public static void arffReader() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\P\\Desktop\\TFG\\wekaPau.arff"));
		Instances data = new Instances(reader);
		reader.close();
		System.out.println(data);
		// setting class attribute
		// data.setClassIndex(data.numAttributes() - 1);
	}

	public static void arffReader2() throws Exception {
		DataSource source = new DataSource("C:\\Users\\P\\Desktop\\TFG\\output.arff");
		Instances data = source.getDataSet();
		// setting class attribute if the data format does not provide this information
		// For example, the XRFF format saves the class attribute information as well
		if (data.classIndex() == -1)
			data.setClassIndex(data.numAttributes() - 1);
	}

	public static void arffReaderFinal() throws Exception {
		// cargar datos arff
		DataSource source = new DataSource("file:///C:/Users/P/Desktop/TFG/output2.arff");
		Instances data = source.getDataSet();
		if (data.classIndex() == -1)
			data.setClassIndex(data.numAttributes() - 1);
		System.out.println("datos cargados");
		data = filter(data);
		System.out.println("datos filtrados");
		J48 j48 = classificationTreeJ48(data);
		System.out.println("classificador creado");
		crossValidation(j48, data);
		System.out.println("classificador entrenado");
	}

	public static Instances filter(Instances data) throws Exception {
		// http://weka.sourceforge.net/doc.dev/weka/filters/Filter.html
		// http://weka.sourceforge.net/doc.dev/weka/filters/unsupervised/attribute/StringToWordVector.html
		StringToWordVector filter = new StringToWordVector();
		filter.setInputFormat(data);
		return Filter.useFilter(data, filter);
	}

	public static J48 classificationTreeJ48(Instances data) throws Exception {
		J48 j48 = new J48();
		//j48.buildClassifier(data);
		j48.setOptions(Utils.splitOptions("-C 0.5 -M 15"));
		return j48;

	}

	public static void crossValidation(J48 j48, Instances data) throws Exception {
		Evaluation eval = new Evaluation(data);
		System.out.println("Entrenando clasificador ...");
		eval.crossValidateModel(j48, data, 10, new Random(1));
//		String[] options = new String[2];
//		options[0] = "-t";
//		options[1] = "file:///C:/Users/P/Desktop/TFG/output2.arff";
//		System.out.println(Evaluation.evaluateModel(new J48(), options));
		System.out.println(eval.toSummaryString());
		System.out.println(eval.precision(1));
		System.out.println(eval.recall(1));
	}
}

// https://www.programcreek.com/java-api-examples/index.php?api=weka.filters.unsupervised.attribute.StringToWordVector