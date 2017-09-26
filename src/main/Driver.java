package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Driver {

	public static class Tuple {
		public double b;
		public double update;
		
	}

	public static void main(String args[]) throws FileNotFoundException, IOException {
		
		List<Model> training00DataSet = new ArrayList<Model>();
		List<Model> training01DataSet = new ArrayList<Model>();
		List<Model> training02DataSet = new ArrayList<Model>();
		List<Model> training03DataSet = new ArrayList<Model>();
		List<Model> training04DataSet = new ArrayList<Model>();
		List<Model> devDataSet = new ArrayList<Model>();
		List<Model> trainDataSet = new ArrayList<Model>();
		List<Model> testDataSet = new ArrayList<Model>();
		
		try (BufferedReader br = new BufferedReader(new FileReader("phishing.dev"))) {
			String line;
		    while ((line = br.readLine()) != null) {
		    	Model m = new Model(line);
		    	devDataSet.add(m);
		    }
		}
		
		try (BufferedReader br = new BufferedReader(new FileReader("phishing.test"))) {
			String line;
		    while ((line = br.readLine()) != null) {
		    	Model m = new Model(line);
		    	testDataSet.add(m);
		    }
		}
		
		try (BufferedReader br = new BufferedReader(new FileReader("phishing.train"))) {
			String line;
		    while ((line = br.readLine()) != null) {
		    	Model m = new Model(line);
		    	trainDataSet.add(m);
		    }
		}
		
		for(int i = 0; i < 5; i++){
			String file = "CVSplits/training0" + i + ".data";
			try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			    String line;
			    while ((line = br.readLine()) != null) {
			    	Model m = new Model(line);
			    	if(i == 0){
			    		training00DataSet.add(m);
			    	}
			    	if(i == 1){
			    		training01DataSet.add(m);
			    	}
			    	if(i == 2){
			    		training02DataSet.add(m);
			    	}
			    	if(i == 3){
			    		training03DataSet.add(m);
			    	}
			    	if(i == 4){
			    		training04DataSet.add(m);
			    	}
			    }
			}
		}
		double learningRate = 0.1;
		double mu = 0.01;
		System.out.println("Learning rate = " + learningRate);
		System.out.println("Margin mu = " + mu);
//		int success00 = 0;
//		int total00 = 0;
//		
//		int success01 = 0;
//		int total01 = 0;
//		
//		int success02 = 0;
//		int total02 = 0;
//		
//		int success03 = 0;
//		int total03 = 0;
//		
//		int success04 = 0;
//		int total04 = 0;
//		
//		int epoch = 10;
//		
//		for(int i = 0; i < 5; i++) {
//			//initialize w
//			double[] w = new double[69];
//			double[] a = new double[69];
//			//initialize b
//			double b = 0.001;
//			 double ba = 0;
//
//			switch(i){
//				case 0:
//					System.out.println("Testing on 00");
//					for(Model m : training01DataSet){
//						Tuple t = perceptronTrain(m, epoch, w, b, learningRate, mu, a,ba);
//						b = t.b;
//						ba = t.update;
//						
//					}
//					for(Model m : training02DataSet){
//						Tuple t = perceptronTrain(m, epoch, w, b, learningRate, mu, a,ba);
//						b = t.b;
//						ba = t.update;
//					}
//					for(Model m : training03DataSet){
//						Tuple t = perceptronTrain(m, epoch, w, b, learningRate, mu, a,ba);
//						b = t.b;
//						ba = t.update;
//					}
//					for(Model m : training04DataSet){
//						Tuple t = perceptronTrain(m, epoch, w, b, learningRate, mu, a,ba);
//						b = t.b;
//						ba = t.update;
//					}
//
//					
//					for(Model m : training00DataSet){
//						int predicted =  perceptronTest(m, w, b);
//						if(predicted == m.labelVal) {
//							success00++;
//						}
//						total00++;
//					}
//					
//					System.out.println("Success = " + success00 + "/" + total00);
//					
//					break;
//				case 1:
//					System.out.println("Testing on 01");
//					for(Model m : training00DataSet){
//						Tuple t = perceptronTrain(m, epoch, w, b, learningRate, mu, a,ba);
//						b = t.b;
//						ba = t.update;
//					}
//					for(Model m : training02DataSet){
//						Tuple t = perceptronTrain(m, epoch, w, b, learningRate, mu, a,ba);
//						b = t.b;
//						ba = t.update;
//					}
//					for(Model m : training03DataSet){
//						Tuple t = perceptronTrain(m, epoch, w, b, learningRate, mu, a,ba);
//						b = t.b;
//						ba = t.update;
//					}
//					for(Model m : training04DataSet){
//						Tuple t = perceptronTrain(m, epoch, w, b, learningRate, mu, a,ba);
//						b = t.b;
//						ba = t.update;
//					}
//					
//					for(Model m : training01DataSet){
//						int predicted =  perceptronTest(m, w, b);
//						if(predicted == m.labelVal) {
//							success01++;
//						}
//						total01++;
//					}
//					
//					System.out.println("Success = " + success01 + "/" + total01);
//					break;
//				case 2:
//					System.out.println("Testing on 02");
//					for(Model m : training01DataSet){
//						Tuple t = perceptronTrain(m, epoch, w, b, learningRate, mu, a,ba);
//						b = t.b;
//						ba = t.update;
//					}
//					for(Model m : training00DataSet){
//						Tuple t = perceptronTrain(m, epoch, w, b, learningRate, mu, a,ba);
//						b = t.b;
//						ba = t.update;
//					}
//					for(Model m : training03DataSet){
//						Tuple t = perceptronTrain(m, epoch, w, b, learningRate, mu, a,ba);
//						b = t.b;
//						ba = t.update;
//					}
//					for(Model m : training04DataSet){
//						Tuple t = perceptronTrain(m, epoch, w, b, learningRate, mu, a,ba);
//						b = t.b;
//						ba = t.update;
//					}
//					
//					for(Model m : training02DataSet){
//						int predicted =  perceptronTest(m, w, b);
//						if(predicted == m.labelVal) {
//							success02++;
//						}
//						total02++;
//					}
//					
//					System.out.println("Success = " + success02 + "/" + total02);
//					break;
//				case 3:
//					System.out.println("Testing on 03");
//					for(Model m : training01DataSet){
//						Tuple t = perceptronTrain(m, epoch, w, b, learningRate, mu, a,ba);
//						b = t.b;
//						ba = t.update;
//					}
//					for(Model m : training02DataSet){
//						Tuple t = perceptronTrain(m, epoch, w, b, learningRate, mu, a,ba);
//						b = t.b;
//						ba = t.update;
//					}
//					for(Model m : training00DataSet){
//						Tuple t = perceptronTrain(m, epoch, w, b, learningRate, mu, a,ba);
//						b = t.b;
//						ba = t.update;
//					}
//					for(Model m : training04DataSet){
//						Tuple t = perceptronTrain(m, epoch, w, b, learningRate, mu, a,ba);
//						b = t.b;
//						ba = t.update;
//					}
//					
//					for(Model m : training03DataSet){
//						int predicted =  perceptronTest(m, w, b);
//						if(predicted == m.labelVal) {
//							success03++;
//						}
//						total03++;
//					}
//					
//					System.out.println("Success = " + success03 + "/" + total03);
//					break;
//				case 4:
//					System.out.println("Testing on 04");
//					for(Model m : training01DataSet){
//						Tuple t = perceptronTrain(m, epoch, w, b, learningRate, mu, a,ba);
//						b = t.b;
//						ba = t.update;
//					}
//					for(Model m : training02DataSet){
//						Tuple t = perceptronTrain(m, epoch, w, b, learningRate, mu, a,ba);
//						b = t.b;
//						ba = t.update;
//					}
//					for(Model m : training03DataSet){
//						Tuple t = perceptronTrain(m, epoch, w, b, learningRate, mu, a,ba);
//						b = t.b;
//						ba = t.update;
//					}
//					for(Model m : training00DataSet){
//						Tuple t = perceptronTrain(m, epoch, w, b, learningRate, mu, a,ba);
//						b = t.b;
//						ba = t.update;
//					}
//					
//					for(Model m : training04DataSet){
//						int predicted =  perceptronTest(m, w, b);
//						if(predicted == m.labelVal) {
//							success04++;
//						}
//						total04++;
//					}
//					
//					System.out.println("Success = " + success04 + "/" + total04);
//					break;
//			}
//		}
//		
//		double sum = success00 + success01 + success02 + success03 + success04;
//		double total = total00 + total01 + total02 + total03 + total04;
//		
//		double avg = sum / total;
//		System.out.println("Average for cross validation = " + avg);
		
		System.out.println("\n");
		
		//Train
		double[] w = new double[69];
		//initialize b
		double b = 0.001;
		
		double epoch = 20;
		
		int update = 0;
		
		int success = 0;
		
		int timeStep = 0;
		double dynamicLearningRate = learningRate;
		
		for(int i = 0; i < 15; i++) {
			for(Model m : trainDataSet){
				Tuple t = perceptronTrain1(m, w, b, dynamicLearningRate, devDataSet, mu);
				b = t.b;
				update += t.update;
			}
			
			int devSuccess = 0;
			//test on dev set
			for(Model m : devDataSet) {
				int predicted =  perceptronTest(m, w, b);
				if(predicted == m.labelVal) {
					devSuccess++;
				}
			}
			double accuracy = (double) devSuccess / (double) devDataSet.size();
			
			System.out.println("Accuracy at " + (i+1) + " epoch = " + accuracy);
			timeStep++;
			dynamicLearningRate = learningRate / (1+timeStep);
		}
//		
//		
		//test on phishing.test
		for(Model m : testDataSet){
			int predicted =  perceptronTest(m, w, b);
			if(predicted == m.labelVal) {
				success++;
			}
		}
		
		System.out.println("Accuracy = " + (double)success / (double)testDataSet.size());
		System.out.println("Update = " + update);
		
		System.out.println("Done");
		
	}
	
	public static Tuple perceptronTrain(Model data, int maxIter, double[] w, double b, double learningRate, double mu, double[] a, double ba) {
		double sum = 0;
		double dynamicLearningRate = learningRate;
		for(int i = 0; i < maxIter; i++) {
			for(int j = 0; j < w.length; j++) {
				if(data.featureVector.containsKey(j)){
					sum += w[j] * data.featureVector.get(j);
				}
			}
			sum += b;
			
			if(sum * data.labelVal < mu) {
				for(int j = 0; j < w.length; j++) {
					if(data.featureVector.containsKey(j)){
						w[j] += dynamicLearningRate * data.labelVal * data.featureVector.get(j);
					}
				}
				b += data.labelVal;
			}
			//timeStep++;
			//dynamicLearningRate = learningRate / (1 + timeStep);
			for(int j = 0; j < w.length; j++) {
				w[i] += a[i];
			}
			ba += b;
			
		}
		

		Tuple t = new Tuple();
		t.b = b;
		t.update = ba;
		return t;
	}
	
	public static Tuple perceptronTrain1(Model data, double[] w, double b, double learningRate, List<Model> devDataSet, double mu) {
		double sum = 0;
		int update = 0;
		
		//iterate over epochs
		int success = 0;
		//a = wx+b
		for(int j = 0; j < w.length; j++) {
			if(data.featureVector.containsKey(j)){
				sum += w[j] * data.featureVector.get(j);
			}
		}
		sum += b;
		
		//check for y*a
		if(sum * data.labelVal < mu) {
			for(int j = 0; j < w.length; j++) {
				if(data.featureVector.containsKey(j)){
					w[j] += learningRate * data.labelVal * data.featureVector.get(j);
				}
			}
			b += data.labelVal;
			update++;
		}
			
			//test on dev set
//			for(Model m : devDataSet) {
//				int predicted =  perceptronTest(m, w, b);
//				if(predicted == m.labelVal) {
//					success++;
//				}
//			}
//			double accuracy = (double) success / (double) devDataSet.size();
			
			//System.out.println("Accuracy at " + (i+1) + " epoch = " + accuracy);
		
		//System.out.println("Total updates = " + update);
		Tuple t = new Tuple();
		t.b = b;
		t.update = update;
		
		return t;
	}
	
	public static int perceptronTest(Model data, double[] w, double b) {
		double sum = 0;
		for(int j = 0; j < w.length; j++) {
			if(data.featureVector.containsKey(j)){
				sum += w[j] * data.featureVector.get(j);
			}
		}
		
		return (int)Math.signum(sum);
		
	}
}