package com.opzpy123.nlp.process;

import edu.stanford.nlp.pipeline.StanfordCoreNLP;

public class CoreNLPHel {
    private static CoreNLPHel instance = new CoreNLPHel();
    private StanfordCoreNLP pipeline;

    private CoreNLPHel() {
        String props = "StanfordCoreNLP-chinese.properties";  //配置文件，放在main/resources目录下
        pipeline = new StanfordCoreNLP(props);
    }

    public static CoreNLPHel getInstance() {
        return instance;
    }

    public StanfordCoreNLP getPipeline() {
        return pipeline;
    }
}

