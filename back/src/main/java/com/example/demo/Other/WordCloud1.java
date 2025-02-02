package com.example.demo.Other;

import com.example.demo.DemoApplication;
import com.kennycason.kumo.CollisionMode;
import com.kennycason.kumo.WordCloud;
import com.kennycason.kumo.WordFrequency;
import com.kennycason.kumo.bg.CircleBackground;
import com.kennycason.kumo.bg.PixelBoundryBackground;
import com.kennycason.kumo.font.KumoFont;
import com.kennycason.kumo.font.scale.SqrtFontScalar;
import com.kennycason.kumo.nlp.FrequencyAnalyzer;
import com.kennycason.kumo.nlp.tokenizers.ChineseWordTokenizer;
import com.kennycason.kumo.palette.LinearGradientColorPalette;
import org.springframework.boot.SpringApplication;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public class WordCloud1 {
    public void creatWordCloud() throws IOException {
        //建立词频分析器，设置词频，以及词语最短长度，此处的参数配置视情况而定即可
        FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
        frequencyAnalyzer.setWordFrequenciesToReturn(600);
        frequencyAnalyzer.setMinWordLength(2);

        //引入中文解析器
        frequencyAnalyzer.setWordTokenizer(new ChineseWordTokenizer());
//指定文本文件路径，生成词频集合
        final List<WordFrequency> wordFrequencyList = frequencyAnalyzer.load("F:\\shop\\JShop\\back\\src\\main\\resources\\static\\txt\\wordcloud.txt");
//设置图片分辨率
        Dimension dimension = new Dimension(400,400);
//此处的设置采用内置常量即可，生成词云对象
        WordCloud wordCloud = new WordCloud(dimension, CollisionMode.PIXEL_PERFECT);
        //设置边界及字体
        wordCloud.setPadding(2);
        java.awt.Font font = new java.awt.Font("STSong-Light", 2, 20);
//设置词云显示的三种颜色，越靠前设置表示词频越高的词语的颜色
        wordCloud.setColorPalette(new LinearGradientColorPalette(Color.RED, Color.BLUE, Color.GREEN, 30, 30));
        wordCloud.setKumoFont(new KumoFont(font));
//设置背景色
        wordCloud.setBackgroundColor(new Color(255,245,231));
//设置背景图片
//        wordCloud.setBackground(new PixelBoundryBackground("F:\\shop\\JShop\\back\\src\\main\\resources\\static\\images\\logo.jpg"));
//设置背景图层为圆形
        wordCloud.setBackground(new CircleBackground(200));
        wordCloud.setFontScalar(new SqrtFontScalar(12, 45));
//生成词云
        wordCloud.build(wordFrequencyList);
        wordCloud.writeToFile("F:\\shop\\JShop\\back\\src\\main\\resources\\static\\goodsImages/wy.png");
    }
    public static void main(String[] args) throws IOException {
       WordCloud1 wordCloud1 = new WordCloud1();
       wordCloud1.creatWordCloud();
    }
}
