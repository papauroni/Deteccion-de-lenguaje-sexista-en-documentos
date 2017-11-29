package weka;

import java.util.Random;

import weka.classifiers.bayes.BayesNet;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.bayes.net.search.ci.ICSSearchAlgorithm;
import weka.classifiers.evaluation.Evaluation;
import weka.core.Instances;
import weka.core.Utils;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.StringToWordVector;

public class BayesNetClass {
	
	public static void arffReaderFinal() throws Exception {
		// cargar datos arff
		DataSource source = new DataSource("file:///C:/Users/P/Desktop/TFG/output2.arff");
		Instances data = source.getDataSet();
		if (data.classIndex() == -1)
			data.setClassIndex(data.numAttributes() - 1);
		System.out.println("datos cargados");
		data = filter(data);
		System.out.println("datos filtrados");
		BayesNet bayes = classificationBayesNet(data);
		System.out.println("classificador creado");
		crossValidation(bayes, data);
		System.out.println("classificador entrenado");
	}

	public static Instances filter(Instances data) throws Exception {
		StringToWordVector filter = new StringToWordVector();
		filter.setInputFormat(data);
		return Filter.useFilter(data, filter);
	}

	public static BayesNet classificationBayesNet(Instances data) throws Exception {
		BayesNet bayes=new BayesNet();
		
//		weka.classifiers.bayes.net.search.local.K2 scheme = new weka.classifiers.bayes.net.search.local.K2();
//		scheme.setOptions(weka.core.Utils.splitOptions("-P 1 -S BAYES"));
//		scheme.buildStructure(bayes, data);
		//bayes.setSearchAlgorithm( new ICSSearchAlgorithm());
		//bayes.setOptions(Utils.splitOptions("-Q weka.classifiers.bayes.net.search.local.K2 -- -P 2 -S ENTROPY  -E weka.classifiers.bayes.net.estimate.SimpleEstimator -- -A 1.0"));
		//bayes.setUseKernelEstimator(true);
		return bayes;
	}

	public static void crossValidation(BayesNet bayes, Instances data) throws Exception {
		Evaluation eval = new Evaluation(data);
		eval.crossValidateModel(bayes, data, 10, new Random(1));
		System.out.println(eval.toSummaryString());
		System.out.println("precisión: "+ eval.precision(1));
		System.out.println("Recall: "+ eval.recall(1));
	}

}


// https://github.com/bnjmn/weka/blob/master/weka/src/main/java/weka/classifiers/bayes/BayesNet.java