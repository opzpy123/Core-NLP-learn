package com.opzpy123.nlp.process;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

import java.util.ArrayList;
import java.util.List;

public class Segmentation {
    private String segtext = "";
    private ArrayList<String> segList;

    public String getSegtext() {
        return segtext;
    }

    public List<String> getSegList(){
        return segList;
    }

    public Segmentation(String text) {
        CoreNLPHel coreNLPHel = CoreNLPHel.getInstance();
        StanfordCoreNLP pipeline = coreNLPHel.getPipeline();
        Annotation annotation = new Annotation(text);
        pipeline.annotate(annotation);
        List<CoreMap> sentences = annotation.get(CoreAnnotations.SentencesAnnotation.class);
        StringBuilder sb = new StringBuilder();
        segList = new ArrayList<>();
        for (CoreMap sentence : sentences) {
            for (CoreLabel token : sentence.get(CoreAnnotations.TokensAnnotation.class)) {
                String word = token.get(CoreAnnotations.TextAnnotation.class);
                sb.append(word);
                sb.append(" ");
                segList.add(word);
            }
        }
        segtext = sb.toString().trim();
    }

}
