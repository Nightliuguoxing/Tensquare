package com.tensquare.common.util;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;
import java.io.IOException;
import java.io.StringReader;

/**
 * @ClassName: IKUtil
 * @Author: Samele LGX
 * @CreateTime: 2020-08-03 22:53
 * @Description: IK分词工具类
 */
public class IKUtil {

    /**
     * 根据文本返回分词后的文本
     * @param content
     * @return
     */
    public static String split(String content,String splitChar) throws IOException {
        StringReader sr=new StringReader(content);
        IKSegmenter ik=new IKSegmenter(sr, true);
        Lexeme lex=null;
        StringBuilder sb=new StringBuilder("");
        while((lex=ik.next())!=null){
            // 拼接
            sb.append(lex.getLexemeText()+splitChar);
        }
        return sb.toString();
    }

}
