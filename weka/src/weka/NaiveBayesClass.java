package weka;

import weka.core.Instances;
import weka.core.Utils;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.StringToWordVector;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.evaluation.Evaluation;
import java.util.Random;

public class NaiveBayesClass {
	
	public static void arffReaderFinal() throws Exception {
		// cargar datos arff
		DataSource source = new DataSource("file:///C:/Users/P/Desktop/TFG/output2.arff");
		Instances data = source.getDataSet();
		if (data.classIndex() == -1)
			data.setClassIndex(data.numAttributes() - 1);
		System.out.println("datos cargados");
		data = filter(data);
		System.out.println("datos filtrados");
		NaiveBayes bayes = classificationNaiveBayes(data);
		System.out.println("classificador creado");
		crossValidation(bayes, data);
		System.out.println("classificador entrenado");
	}

	public static Instances filter(Instances data) throws Exception {
		StringToWordVector filter = new StringToWordVector();
		filter.setInputFormat(data);
		return Filter.useFilter(data, filter);
	}

	public static NaiveBayes classificationNaiveBayes(Instances data) throws Exception {
		NaiveBayes bayes=new NaiveBayes();
		bayes.setOptions(Utils.splitOptions("-K"));
		//bayes.setUseKernelEstimator(true);
		return bayes;
	}

	public static void crossValidation(NaiveBayes bayes, Instances data) throws Exception {
		Evaluation eval = new Evaluation(data);
		eval.crossValidateModel(bayes, data, 10, new Random(1));
		System.out.println(eval.toSummaryString());
		System.out.println("precisión: "+ eval.precision(1));
		System.out.println("Recall: "+ eval.recall(1));
	}

}
