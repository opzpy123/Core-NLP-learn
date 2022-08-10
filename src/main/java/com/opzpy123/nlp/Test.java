package com.opzpy123.nlp;


import com.opzpy123.nlp.process.EmotionAnalysis;
import com.opzpy123.nlp.process.NamedEntity;
import com.opzpy123.nlp.process.PosTag;
import com.opzpy123.nlp.process.SPTree;
import com.opzpy123.nlp.process.Segmentation;
import com.opzpy123.nlp.process.SenSplit;

public class Test {
    public static void main(String[] args) {
        String text = "清明前后，天气时雨时晴。如同人生，祸福相依。站在先人的坟前，没人是不真诚的。细想想先人们留下了什么，大多是一片茫然。就连先人的面容也大多模糊，更别谈英名了。如同飞过的鸟儿，谁能想起它们的叫声？也许那叫声当年多么与众不同，都淹没在风中雨中，淹没在无声的岁月中……五千年的历史，古今多少事，都付笑谈中。想青史留名的想法很丰满，现实却相当的骨感。还是好好活着，做点有意义的事吧，活好人立好德再说。";
        //分词
        System.out.println(String.join("\n", new Segmentation(text).getSegList()));
        //分句
        System.out.println(String.join("\n", new SenSplit(text).getSensRes()));
        //词性标注
        System.out.println(new PosTag(text).getPostext());
        //命名实体识别
        System.out.println(new NamedEntity(text).getNertext());
        //句子的解析树
        SPTree spTree = new SPTree(text);
        System.out.println(spTree.getPrasetext());
        //句子依存分析
        System.out.println(spTree.getDepprasetext());
        //情感分析
        String emoStr = "这里有一本好书。我享受阅读它。我可以在星期天阅读。今天周二。等不及下周日了。工作周长得令人难以忍受。太可怕了。";
        String emoEnStr = "This is an excellent book. I enjoy reading it. I can read on Sundays. Today is only Tuesday. Can't wait for next Sunday. The working week is unbearably long. It's awful.";
        System.out.println(new EmotionAnalysis(emoEnStr).getEmotion());
        System.out.println(new EmotionAnalysis(emoStr).getEmotion());
    }
}
