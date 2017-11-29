package weka;

import weka.core.Instances;
import weka.core.Utils;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.StringToWordVector;
import weka.classifiers.evaluation.Evaluation;
import weka.classifiers.functions.LinearRegression;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.classifiers.functions.SimpleLinearRegression;

import java.io.FileReader;
import java.util.Random;

public class MultilayerPerceptronClass {

	public static void arffReaderFinal() throws Exception {
		// cargar datos arff
		DataSource source = new DataSource("file:///C:/Users/P/Desktop/TFG/output2.arff");
		Instances data = source.getDataSet();
		if (data.classIndex() == -1)
			data.setClassIndex(data.numAttributes() - 1);
		System.out.println("datos cargados");
		data = filter(data);
		System.out.println("datos filtrados");
		MultilayerPerceptron mlp = classificationLinearRegression(data);
		System.out.println("classificador creado");
		crossValidation(mlp, data);
		System.out.println("classificador entrenado");
	}

	public static Instances filter(Instances data) throws Exception {
		StringToWordVector filter = new StringToWordVector();
		filter.setInputFormat(data);
		return Filter.useFilter(data, filter);
	}

	public static MultilayerPerceptron classificationLinearRegression(Instances data) throws Exception {
		MultilayerPerceptron mlp = new MultilayerPerceptron();
		// Setting Parameters
//		mlp.setLearningRate(0.1);
//		mlp.setMomentum(0.2);
//		mlp.setTrainingTime(200);
//		mlp.setHiddenLayers("3");
		mlp.setOptions(Utils.splitOptions("-L 0.3 -M 0.2 -N 3 -V 0 -S 0 -E 20 ")); 
		return mlp;
//		L = Learning Rate
//		M = Momentum
//		N = Training Time or Epochs
//		H = Hidden Layers
	}

	public static void crossValidation(MultilayerPerceptron mlp, Instances data) throws Exception {
		mlp.buildClassifier(data);
		Evaluation eval = new Evaluation(data);
		eval.crossValidateModel(mlp, data, 10, new Random(1));
		System.out.println(eval.toSummaryString());
		System.out.println("precisión: " + eval.precision(1));
		System.out.println("Recall: " + eval.recall(1));
	}

}
