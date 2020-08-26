package com.demo.antlr4.app;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import net.sf.json.JSONObject;
import java.io.*;
import com.demo.antlr4.app.*;

public class Main {
    public String main(String outInput) throws Exception {
        InputStream in_nocode = new ByteArrayInputStream(outInput.getBytes());
        CharStream input = CharStreams.fromStream(in_nocode);
        LibExprLexer lexer = new LibExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LibExprParser parser = new LibExprParser(tokens);
        ParseTree tree = parser.prog();

        LibExprBaseVisitorImpl calcVisitor = new LibExprBaseVisitorImpl();
        HashMap<String, List> result = calcVisitor.visit(tree);
        Iterator<Map.Entry<String, List>> iterator = result.entrySet().iterator();
        List<Double> resultList = new ArrayList<>();
        List<String> resultStringList = new ArrayList<>();
        Double resultAll = 0.0;
        JSONObject jsonResult = new JSONObject();
        while(iterator.hasNext())
        {
            Map.Entry<String, List> entry = iterator.next();
            List<String> valueList = entry.getValue();
            for (int i = 0; i < valueList.size(); i++) {
                String tmpValueList[] = valueList.get(i).split("\\(|,|\\)");
                String tmpPath = null;
                String tmpValue = null;
                for (int j = 0; j < tmpValueList.length; j++) {
                    if(j == 1) {
                        tmpPath = tmpValueList[j];
                    } else if(j == 2) {
                        tmpValue = tmpValueList[j];
                    }
                }
                tmpPath = tmpPath.replace("{", "(");
                tmpPath = tmpPath.replace("}", ")");
                tmpPath = tmpPath.replace("=", ",");
                tmpPath = tmpPath.replace(";", " ");
                resultStringList.add(tmpPath + " = " + tmpValue);
                System.out.println(tmpPath + " = " + tmpValue);
                if(Double.parseDouble(tmpValue) == -1.0) {
                    continue;
                } else {
                    resultList.add(Double.parseDouble(tmpValue));
                    resultAll += Double.parseDouble(tmpValue);
                }
            }
        }
        jsonResult.put("result", resultStringList);
        Double averageValue = 0.0;
        if(resultAll != 0 && resultList.size() != 0) {
            averageValue = resultAll / resultList.size();
        }
        jsonResult.put("average", averageValue);
        System.out.println("The average complexity is：" + resultAll / resultList.size());
//        System.out.println(tree.toStringTree(parser));
        return jsonResult.toString();
    }
}