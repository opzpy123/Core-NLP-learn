package com.opzpy123.nlp.process;

import com.opzpy123.nlp.dto.EmotionDto;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;

import java.util.ArrayList;

public class EmotionAnalysis {

    private String emotionText;

    public EmotionAnalysis(String text) {
        CoreNLPHel coreNLPHel = CoreNLPHel.getInstance();
        StanfordCoreNLP pipeline = coreNLPHel.getPipeline();
        Annotation annotation = new Annotation(text);
        pipeline.annotate(annotation);

        StringBuilder sb = new StringBuilder();
        for (CoreMap sentence : annotation.get(CoreAnnotations.SentencesAnnotation.class)) {
            Tree tree = sentence.get(SentimentCoreAnnotations.SentimentAnnotatedTree.class);
            sb.append(sentence.get(SentimentCoreAnnotations.SentimentClass.class));
            sb.append("\t");
            sb.append(RNNCoreAnnotations.getPredictedClass(tree));
            sb.append("\t");
            sb.append(sentence);
            sb.append("\n");
        }
        emotionText = sb.toString();
    }

    public String getEmotion() {
        return emotionText;
    }
}
