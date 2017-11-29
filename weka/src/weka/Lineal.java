package weka;

import weka.core.Instances;
import weka.core.Utils;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.StringToWordVector;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.evaluation.Evaluation;
import weka.classifiers.functions.SMO;

import java.util.Random;

public class Lineal {

	public static void arffReaderFinal() throws Exception {
		// cargar datos arff
		DataSource source = new DataSource("file:///C:/Users/P/Desktop/TFG/output2.arff");
		Instances data = source.getDataSet();
		if (data.classIndex() == -1)
			data.setClassIndex(data.numAttributes() - 1);
		System.out.println("datos cargados");
		data = filter(data);
		System.out.println("datos filtrados");
		SMO smo = classificationSMO(data);
		System.out.println("classificador creado");
		crossValidation(smo, data);
		System.out.println("classificador entrenado");
	}

	public static Instances filter(Instances data) throws Exception {
		StringToWordVector filter = new StringToWordVector();
		filter.setInputFormat(data);
		return Filter.useFilter(data, filter);
	}

	public static SMO classificationSMO(Instances data) throws Exception {
		SMO smo=new SMO();
		smo.setOptions(Utils.splitOptions("-C 12 -L 0.0010 -P 1.0E-12 -N 0 -V -1 -W 1 -K weka.classifiers.functions.supportVector.RBFKernel"));
		//smo.weka.classifiers.functions.SMO -C 1.0 -L 0.0010 -P 1.0E-12 -N 0 -V -1 -W 1 -K "weka.classifiers.functions.supportVector.PolyKernel -C 250007 -E 1.0
		return smo;
	}

	public static void crossValidation(SMO smo, Instances data) throws Exception {
		Evaluation eval = new Evaluation(data);
		eval.crossValidateModel(smo, data, 10, new Random(1));
		System.out.println(eval.toSummaryString());
		double precision = eval.precision(1);
		double recall = eval.recall(1);
		System.out.println("precisión: "+ precision);
		System.out.println("Recall: "+ recall);
		double f1 = 2*((precision * recall)/(precision + recall));
		System.out.println("f1 score = " + f1);
	}

}
// weka.classifiers.functions.SMO -C 1.0 -L 0.0010 -P 1.0E-12 -N 0 -V -1 -W 1 -K "weka.classifiers.functions.supportVector.PolyKernel -C 250007 -E 1.0"

// https://list.waikato.ac.nz/pipermail/wekalist/2010-December/050570.html

