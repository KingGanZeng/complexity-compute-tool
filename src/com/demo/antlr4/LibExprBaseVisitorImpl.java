//package com.demo.antlr4.app;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.EnumMap;
//import java.util.List;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Iterator;
//import java.math.BigDecimal;
//import java.util.regex.*;
//import com.demo.antlr4.app.*;
//
//public class LibExprBaseVisitorImpl extends LibExprBaseVisitor<HashMap> {
//    private HashMap<String, List> variables = new HashMap<String, List>();
//    private HashMap<String, List> exprMap = new HashMap<String, List>();
//
//    /**
//     * 判断字符串中是否有数字
//     * @param content
//     * @return
//     */
//    public boolean HasDigit(String content) {
//        boolean flag = false;
//        Pattern p = Pattern.compile(".*\\d+.*");
//        Matcher m = p.matcher(content);
//        if (m.matches()) {
//            flag = true;
//        }
//        return flag;
//    }
//
//    /**
//     * Entry to the formula
//     * @param ctx
//     * @return
//     */
//    @Override
//    public HashMap<String, List> visitCalculate(LibExprParser.CalculateContext ctx) {
//        return visit(ctx.calculateExpr());
//    }
//
//    /**
//     * Definition of components with Calculation formula
//     * Sample input:
//     * P=[a,3.0]
//     * @param ctx
//     * @return
//     */
//    @Override
//    public HashMap<String, List> visitSetVarible(LibExprParser.SetVaribleContext ctx)
//    {
//        HashMap<String, List> valueMap = visit(ctx.calculateExpr());
//        Iterator<Map.Entry<String, List>> iterator = valueMap.entrySet().iterator();
//        List<String> valueList = new ArrayList<>();
//        while(iterator.hasNext())
//        {
//            Map.Entry<String, List> entry = iterator.next();
//            List<String> tmpList = entry.getValue();
//            for (int i = 0; i < tmpList.size(); i++) {
//                String tmp = tmpList.get(i);
//                valueList.add(tmp);
//            }
//        }
//        variables.put(ctx.ID().getText(), valueList);
//        return variables;
//    }
//
//    /**
//     * Definition of components with Value
//     * Sample input:
//     * P=[a,3.0]
//     * @param ctx
//     * @return
//     */
//    @Override
//    public HashMap<String, List> visitSetVaribleBRA(LibExprParser.SetVaribleBRAContext ctx)
//    {
//        HashMap<String, List> valueMap = visit(ctx.getAtom());
//        Iterator<Map.Entry<String, List>> iterator = valueMap.entrySet().iterator();
//        List<String> valueList = new ArrayList<>();
//        while(iterator.hasNext())
//        {
//            Map.Entry<String, List> entry = iterator.next();
//            List<String> tmpList = entry.getValue();
//            String tmpValue = null;
//            for (int i = 0; i < tmpList.size(); i++) {
//                if (i % 2 == 0) {
//                    tmpValue = "(" +  tmpList.get(i) + ",";
//                } else {
//                    tmpValue = tmpValue + tmpList.get(i) + ")";
//                    valueList.add(tmpValue);
//                }
//            }
//        }
//        variables.put(ctx.ID().getText(), valueList);
//        return variables;
//    }
//
//    /**
//     * Variable assignment
//     * @param ctx
//     * @return
//     */
//    @Override
//    public HashMap<String, List> visitSetAtomVal(LibExprParser.SetAtomValContext ctx)
//    {
//        HashMap<String, List> resultMap = new HashMap<String, List>();
//        String resultPath = "(" + ctx.ATOM().getText() + "," + ctx.atom().getText() + ")";
//        List<String> resultList = new ArrayList<>();
//        resultList.add(ctx.ATOM().getText()); // push key
//        resultList.add(ctx.atom().getText()); // push value
//        resultMap.put(resultPath, resultList); // push [a,3.0] into the map
//        return resultMap;
//    }
//
//    /**
//     * Definition of activities (Temporarily abandoned)
//     * Sample input:
//     * a=1
//     * @param ctx
//     * @return
//     */
//    @Override
//    public HashMap<String, List> visitSetAtom(LibExprParser.SetAtomContext ctx)
//    {
//        HashMap<String, Double> valueMap = visit(ctx.calculateExpr());
//        Iterator<Map.Entry<String, Double>> iterator = valueMap.entrySet().iterator();
//        List<Double> valueList = new ArrayList<>();
//        while(iterator.hasNext())
//        {
//            Map.Entry<String, Double> entry = iterator.next();
//            valueList.add(entry.getValue());
//        }
//        variables.put(ctx.ATOM().getText(), valueList);
//
//        return variables;
//    }
//
//    /**
//     * Definition of multiplication rule
//     * Sample Input:
//     * P=3*A
//     * @param ctx
//     * @return
//     */
//    @Override
//    public HashMap<String, List> visitMultiplication(LibExprParser.MultiplicationContext ctx)
//    {
//        HashMap<String, List> resultMap = new HashMap<String, List>();
//        HashMap<String, List> atomMap = visit(ctx.atom());
//
//        Iterator<Map.Entry<String, List>> iterator = atomMap.entrySet().iterator();
//        List<String> resultValue = new ArrayList<>();
//        Double param = Double.parseDouble(ctx.INT().getText());
//        while(iterator.hasNext())
//        {
//            Map.Entry<String, List> entry = iterator.next();
//            List<String> valueList = entry.getValue();
//            for (int i = 0; i < valueList.size(); i++) {
//                String tmpValueList[] = valueList.get(i).split("\\(|,|\\)");
//                String tmpPath = tmpValueList[1];
//                String tmpValue = tmpValueList[2];
//
//                // 避免重复添加花括号的操作
//                if(tmpPath.contains("=")) {
//                    tmpPath = tmpPath;
//                } else {
//                    tmpPath = "{" + tmpPath + "=" + tmpValue + "}";
//                }
//
//                // 对活动做处理
//                String finalPath = null;
//                String pathArr[] = tmpPath.split(";");
//                for (int j = 0; j < pathArr.length; j++)
//                {
//                    String keyItem = pathArr[j].split("\\{|\\=|\\}")[1];
//                    Double valueItem = Double.parseDouble(pathArr[j].split("\\{|\\=|\\}")[2]);
//                    valueItem = valueItem * param;
//                    BigDecimal bg = new BigDecimal(valueItem); // 保留两位小数
//                    valueItem = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
//                    if (j == 0)
//                    {
//                        finalPath = "{" + keyItem + "=" + valueItem + "}";
//                    } else {
//                        finalPath = finalPath + ";{" + keyItem + "=" + valueItem + "}";
//                    }
//                }
//
//                String tmpResultPath = finalPath;
//                // 结果保存
//                Double tmpResultValue = param *  Double.parseDouble(tmpValue);
//                BigDecimal bg = new BigDecimal(tmpResultValue); // 保留两位小数
//                tmpResultValue = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
//                String result = "(" + tmpResultPath + "," + tmpResultValue + ")";
//                resultValue.add(result);
//            }
//            String trace = ctx.INT().getText() + "*" + entry.getKey();
//            resultMap.put(trace, resultValue);
//        }
//
//        return resultMap;
//    }
//
//    /**
//     * Definition of a sequential evaluation rule
//     * Sample Input:
//     * P=A;B ==> P=A+B
//     * @param ctx
//     * @return
//     */
//    @Override
//    public HashMap<String, List> visitSequential(LibExprParser.SequentialContext ctx)
//    {
//        HashMap<String, List> resultMap = new HashMap<String, List>();
//        HashMap<String, List> calculateExprMap = visit(ctx.calculateExpr());
//        HashMap<String, List> callOrchoiceMap = visit(ctx.callOrchoice());
//
//        Iterator<Map.Entry<String, List>> iterator = calculateExprMap.entrySet().iterator();
//        while(iterator.hasNext())
//        {
//            Map.Entry<String, List> entry = iterator.next();
//            List<String> valueList = entry.getValue();
//            String traceLeft = entry.getKey();
//            List<String> resultValueFinal = new ArrayList<>();
//
//            for (int i = 0; i < valueList.size(); i++) {
//                String tmpValueListOne[] = valueList.get(i).split("\\(|,|\\)");
//                String tmpPathOne = null;
//                String tmpValueOne = null;
//                for (int j = 0; j < tmpValueListOne.length; j++) {
//                    if(j == 1) {
//                        tmpPathOne = tmpValueListOne[j];
//                    } else if(j == 2) {
//                        tmpValueOne = tmpValueListOne[j];
//                    }
//                }
//                if(tmpPathOne.contains("=")) {
//                    tmpPathOne = tmpPathOne;
//                } else {
//                    tmpPathOne = "{" + tmpPathOne + "=" + tmpValueOne + "}";
//                }
//
//                Iterator<Map.Entry<String, List>> iterator2 = callOrchoiceMap.entrySet().iterator();
//                while(iterator2.hasNext()) {
//                    Map.Entry<String, List> entry2 = iterator2.next();
//                    List<String> valueList2 = entry2.getValue();
//                    String traceRight = entry2.getKey();
//                    List<String> resultValue = new ArrayList<>(); // 中间过程结果存储
//                    for (int m = 0; m < valueList2.size(); m++) {
//                        String tmpValueListTwo[] = valueList2.get(m).split("\\(|,|\\)");
//                        String tmpPathTwo = tmpValueListTwo[1];
//                        String tmpValueTwo = tmpValueListTwo[2];
//
//                        if(tmpPathTwo.contains("=")) {
//                            tmpPathTwo = tmpPathTwo;
//                        } else {
//                            tmpPathTwo = "{" + tmpPathTwo + "=" + tmpValueTwo + "}";
//                        }
//
//                        String tmpResultPath = tmpPathOne + ";" + tmpPathTwo;
//                        Double tmpResultValue = Double.parseDouble(tmpValueOne) + Double.parseDouble(tmpValueTwo);
//                        BigDecimal bg = new BigDecimal(tmpResultValue); // 保留两位小数
//                        tmpResultValue = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
//                        String result = "(" + tmpResultPath + "," + tmpResultValue + ")";
//                        resultValue.add(result);
//                    }
//
//                    // 判断hashmap里是否有值，有值则向后添加
//                    String tmpTrace = traceLeft + ";" + traceRight;
//                    if(resultMap.get(tmpTrace) != null) {
//                        List<String> tmpfinalResult = resultMap.get(tmpTrace);
//                        for (int a = 0; a < resultValue.size(); a++)
//                        {
//                            tmpfinalResult.add(resultValue.get(a));
//                        }
//                        resultMap.put(tmpTrace, tmpfinalResult);
//                    } else {
//                        resultMap.put(traceLeft + ";" + traceRight, resultValue);
//                    }
//                }
//            }
//        }
//        return resultMap;
//    }
//
//    /**
//     * Definition of the choice calculation rule
//     * Sample Input:
//     * P=A#2B => P=2*A | P=2*B
//     * @param ctx
//     * @return
//     */
//    @Override
//    public HashMap<String, List> visitChoice(LibExprParser.ChoiceContext ctx)
//    {
//        HashMap<String, List> resultMap = new HashMap<String, List>();
//        HashMap<String, List> atomMap = visit(ctx.atom());
//        HashMap<String, List> callOrchoiceMap = visit(ctx.callOrchoice());
//        HashMap<String, List> nextMap = visit(ctx.next());
//        Double param = Double.parseDouble(ctx.atom().getText());
//
//        // Select the first path
//        Iterator<Map.Entry<String, List>> iterator = callOrchoiceMap.entrySet().iterator();
//        List<String> resultValue = new ArrayList<>();
//        while(iterator.hasNext())
//        {
//            Map.Entry<String, List> entry = iterator.next();
//            List<String> valueList = entry.getValue();
//            for (int i = 0; i < valueList.size(); i++) {
//                String tmpValueList[] = valueList.get(i).split("\\(|,|\\)");
//                String tmpPath = tmpValueList[1];
//                String tmpValue = tmpValueList[2];
//
//                // 避免重复添加花括号的操作
//                if(tmpPath.contains("=")) {
//                    tmpPath = tmpPath;
//                } else {
//                    tmpPath = "{" + tmpPath + "=" + tmpValue + "}";
//                }
//
//                // 对活动做处理
//                String finalPath = null;
//                String pathArr[] = tmpPath.split(";");
//
//                for (int j = 0; j < pathArr.length; j++)
//                {
//                    String keyItem = pathArr[j].split("\\{|\\=|\\}")[1];
//                    Double valueItem = Double.parseDouble(pathArr[j].split("\\{|\\=|\\}")[2]);
//                    valueItem = valueItem * param;
//                    BigDecimal bg = new BigDecimal(valueItem); // 保留两位小数
//                    valueItem = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
//                    if (j == 0)
//                    {
//                        finalPath = "{" + keyItem + "=" + valueItem + "}";
//                    } else {
//                        finalPath = finalPath + ";{" + keyItem + "=" + valueItem + "}";
//                    }
//                }
//                tmpPath = finalPath;
//
//                Double result1 = param * Double.parseDouble(tmpValue);
//                BigDecimal bg = new BigDecimal(result1); // 保留两位小数
//                result1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
//                String trace1 = tmpPath;
//                String result = "(" + trace1 + "," + result1 + ")";
//                resultValue.add(result);
//            }
//        }
////        String trace1 = ctx.atom().getText() + "*" + ctx.callOrchoice().getText();
////        resultMap.put(trace1, resultValue);
//
//        // Select the second path
//        Iterator<Map.Entry<String, List>> iterator2 = nextMap.entrySet().iterator();
////        List<String> resultValue2 = new ArrayList<>();
//        while(iterator2.hasNext())
//        {
//            Map.Entry<String, List> entry = iterator2.next();
//            List<String> valueList = new ArrayList<>();
//            valueList = entry.getValue();
//            for (int i = 0; i < valueList.size(); i++) {
//                String tmpValueList[] = valueList.get(i).split("\\(|,|\\)");
//                String tmpPath = tmpValueList[1];
//                String tmpValue = tmpValueList[2];
//
//                if(tmpPath.contains("=")) {
//                    tmpPath = tmpPath;
//                } else {
//                    tmpPath = "{" + tmpPath + "=" + tmpValue + "}";
//                }
//
//                // 对活动做处理
//                String finalPath = null;
//                String pathArr[] = tmpPath.split(";");
//                for (int j = 0; j < pathArr.length; j++)
//                {
//                    String keyItem = pathArr[j].split("\\{|\\=|\\}")[1];
//                    Double valueItem = Double.parseDouble(pathArr[j].split("\\{|\\=|\\}")[2]);
//                    valueItem = valueItem * param;
//                    BigDecimal bg = new BigDecimal(valueItem); // 保留两位小数
//                    valueItem = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
//                    if (j == 0)
//                    {
//                        finalPath = "{" + keyItem + "=" + valueItem + "}";
//                    } else {
//                        finalPath = finalPath + ";{" + keyItem + "=" + valueItem + "}";
//                    }
//                }
//                tmpPath = finalPath;
//
//                Double result2 =  Double.parseDouble(ctx.atom().getText()) * Double.parseDouble(tmpValue);
//                BigDecimal bg = new BigDecimal(result2); // 保留两位小数
//                result2 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
//                String trace2 = tmpPath;
//                String result = "(" + trace2 + "," + result2 + ")";
//                resultValue.add(result);
//            }
//        }
//        String trace2 = ctx.callOrchoice().getText() + "#" + ctx.next().getText();
//        resultMap.put(trace2, resultValue);
//
//        return resultMap;
//    }
//
//
//    /**
//     * Definition of the call calculation rule
//     * Sample Input:
//     * P=A@2B => P=A | P=2*B;A
//     * @param ctx
//     * @return
//     */
//    @Override
//    public HashMap<String, List> visitCall(LibExprParser.CallContext ctx)
//    {
//        HashMap<String, List> resultMap = new HashMap<String, List>();
//        HashMap<String, List> atomMap = visit(ctx.atom());
//        HashMap<String, List> callOrchoiceMap = visit(ctx.callOrchoice());
//        HashMap<String, List> nextMap = visit(ctx.next());
//
//        Iterator<Map.Entry<String, List>> iterator = callOrchoiceMap.entrySet().iterator();
//        List<String> valueListOne = new ArrayList<>();
//        List<String> valueListTwo = new ArrayList<>();
//        String trace1 = ctx.callOrchoice().getText() + "@" + ctx.next().getText();
//        String trace2= ctx.callOrchoice().getText() + "@" + ctx.next().getText();
//        Double param = Double.parseDouble(ctx.atom().getText());
//        while(iterator.hasNext())
//        {
//            Map.Entry<String, List> entry = iterator.next();
//            List<String> valueList = entry.getValue();
//            for (int i = 0; i < valueList.size(); i++) {
//                String tmpValueList[] = valueList.get(i).split("\\(|,|\\)");
//                String tmpPath = tmpValueList[1];
//                String tmpValue = tmpValueList[2];
//
//                if(tmpPath.contains("=")) {
//                    tmpPath = tmpPath;
//                } else {
//                    tmpPath = "{" + tmpPath + "=" + tmpValue + "}";
//                }
//                // 未发生调用
//                Double result1 = Double.parseDouble(tmpValue);
//                String resultLeft = "(" + tmpPath + "," + result1 + ")";
//                valueListOne.add(resultLeft);
//
//                // 发生调用
//                Iterator<Map.Entry<String, List>> iterator2 = nextMap.entrySet().iterator();
//                while(iterator2.hasNext()) {
//                    Map.Entry<String, List> entry2 = iterator2.next();
//                    List<String> valueList2 = entry2.getValue();
//                    trace2 = entry2.getKey();
//                    for (int j = 0; j < valueList2.size(); j++) {
//                        String tmpValueListTwo[] = valueList2.get(j).split("\\(|,|\\)");
//                        String tmpPathTwo= tmpValueListTwo[1];
//                        String tmpValueTwo = tmpValueListTwo[2];
//
//                        // 避免重复添加花括号的操作
//                        if(tmpPathTwo.contains("=")) {
//                            tmpPathTwo = tmpPathTwo;
//                        } else {
//                            tmpPathTwo = "{" + tmpPathTwo + "=" + tmpValueTwo + "}";
//                        }
//
//                        // 对活动做处理
//                        String finalPath = null;
//                        String pathArr[] = tmpPathTwo.split(";");
//                        for (int m = 0; m < pathArr.length; m++)
//                        {
//                            String keyItem = pathArr[j].split("\\{|\\=|\\}")[1];
//                            Double valueItem = Double.parseDouble(pathArr[j].split("\\{|\\=|\\}")[2]);
//                            valueItem = valueItem * param;
//                            BigDecimal bg = new BigDecimal(valueItem); // 保留两位小数
//                            valueItem = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
//                            if (m == 0)
//                            {
//                                finalPath = "{" + keyItem + "=" + valueItem + "}";
//                            } else {
//                                finalPath = finalPath + ";{" + keyItem + "=" + valueItem + "}";
//                            }
//                        }
//
//                        Double result2 = param * Double.parseDouble(tmpValueTwo) + result1;
//                        BigDecimal bg = new BigDecimal(result2); // 保留两位小数
//                        result2 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
//                        String tmpPath2 = finalPath + ";" + tmpPath;
//                        String resultRight = "(" + tmpPath2 + "," + result2 + ")";
//                        valueListOne.add(resultRight);
//                    }
//                }
//            }
//            resultMap.put(trace1, valueListOne);
////            resultMap.put(trace2, valueListTwo);
//        }
//        return resultMap;
//    }
//
//    /**
//     * Definition of the Paralle calculation rule
//     * Sample Input:
//     * P=A||2B
//     * @param ctx
//     * @return
//     */
//    @Override
//    public HashMap<String, List> visitParalle(LibExprParser.ParalleContext ctx)
//    {
//        HashMap<String, List> resultMap = new HashMap<String, List>();
//        HashMap<String, List> atomMap = visit(ctx.atom());
//        HashMap<String, List> calculateExprMap = visit(ctx.calculateExpr());
//        HashMap<String, List> callOrchoiceMap = visit(ctx.callOrchoice());
//
//        Iterator<Map.Entry<String, List>> iterator = calculateExprMap.entrySet().iterator();
//        List<String> resultValue = new ArrayList<>();
//        Double param = Double.parseDouble(ctx.atom().getText()); // 计算符参数
//        while(iterator.hasNext())
//        {
//            Map.Entry<String, List> entry = iterator.next();
//            List<String> valueList = entry.getValue();
//            for (int i = 0; i < valueList.size(); i++) {
//                String tmpValueList[] = valueList.get(i).split("\\(|,|\\)");
//                String tmpPath = tmpValueList[1];
//                String tmpValue = tmpValueList[2];
//
//                if(tmpPath.contains("=")) {
//                    tmpPath = tmpPath;
//                } else {
//                    tmpPath = "{" + tmpPath + "=" + tmpValue + "}";
//                }
//
//                Iterator<Map.Entry<String, List>> iterator2 = callOrchoiceMap.entrySet().iterator();
//                while(iterator2.hasNext()) {
//                    Map.Entry<String, List> entry2 = iterator2.next();
//                    List<String> valueList2 = entry2.getValue();
//                    String errorValue = null; // 用于存储死锁信息
//                    String tmpResultTrace = null; // 用于存储路径信息
//                    Double tmpResultValue = 0.0;
//
//                    for (int j = 0; j < valueList2.size(); j++) {
//                        String tmpValueListInner[] = valueList2.get(j).split("\\(|,|\\)");
//                        String tmpPathInner = tmpValueListInner[1];
//                        String tmpValueInner = tmpValueListInner[2];
//
//                        if(tmpPathInner.contains("=")) {
//                            tmpPathInner = tmpPathInner;
//                        } else {
//                            tmpPathInner = "{" + tmpPathInner + "=" + tmpValueInner + "}";
//                        }
//
//                        // 存储为二元组
//                        String keyList1[] = tmpPath.split("\\;");
//                        String keyList2[] = tmpPathInner.split("\\;");
//                        Integer isLoop = 0; // 不知道同步谁先谁后
//                        while(isLoop < 2) {
//
//                            List<String> paralleKey = new ArrayList<>(); // 用于记录同步的活动名
//
//                            Boolean flag = false; // 用于判断是否会产生死锁
//                            Boolean paralleFlag = false; // 用于判断是否会产生同步
//                            Integer innerStartIndex = 0;
//                            for (int x = 0; x < keyList1.length && !flag; x++) {
//                                String key1 = keyList1[x].split("\\{|\\=|\\}")[1];
//                                String value1 = keyList1[x].split("\\{|\\=|\\}")[2];
//
//                                // 用于存放右侧的中间路径及中间值
//                                String tmpRightPath = null;
//                                Double tmpRightValue = 0.0;
//                                String paralleRightValue = null; // 用于存放右侧同步活动的复杂度
//                                for (int y = 0; y < keyList2.length && !flag && !paralleFlag; y++) {
//                                    String key2 = keyList2[y].split("\\{|\\=|\\}")[1];
//                                    String value2 = keyList2[y].split("\\{|\\=|\\}")[2];
//
//                                    if (key1.equals(key2))
//                                    {
//                                        // 对于有可能发生死锁的情况，判断在key1之后的活动是否出现在key2之前
//                                        for (int a = x + 1; a < keyList1.length && !flag; a++)
//                                        {
//                                            String innerKey1 = keyList1[a].split("\\{|\\=|\\}")[1];
//                                            for (int b = 0; b < y && !flag; b++)
//                                            {
//                                                String innerKey2 = keyList2[b].split("\\{|\\=|\\}")[1];
//                                                if(innerKey1.equals(innerKey2))
//                                                {
//                                                    flag = true;
//                                                    errorValue = "Deadlock appeared";
//                                                    tmpResultTrace = Arrays.toString(keyList1).replace(",", "").replace("[", "").replace("]", "") + "||" + Arrays.toString(keyList2).replace(",", "").replace("[", "").replace("]", "");
//                                                    tmpResultValue = -1.0;
//                                                    break;
//                                                }
//                                            }
//                                        }
//                                        // 如果没有死锁，那么同步条件成立
//                                        paralleFlag = true;
//                                        paralleRightValue = value2;
//                                        paralleKey.add(key1); // 记录同步活动
//                                    } else {
//                                        // 判断不同步的活动是否在之前已经记录
//                                        if (!paralleKey.contains(key2)) {
//                                            // 如果没有被记录,在此处赋值
//                                            if(tmpRightPath == null)
//                                            {
//                                                tmpRightPath = "{" + key2 + "=" + value2 + "}";
//                                                tmpRightValue = Double.parseDouble(value2);
//                                            } else {
//                                                tmpRightPath += ";{" + key2 + "=" + value2 + "}";
//                                                tmpRightValue += Double.parseDouble(value2);
//                                            }
//                                        }
//                                    }
//                                }
//
//                                // 对于不存在死锁的情况，现将两边的路径进行存储
//                                if(!flag && !paralleFlag)
//                                {
//                                    if(x == 0)
//                                    {
//                                        tmpResultTrace = "{" + key1 + "=" + value1 + "}";
//
//                                    } else {
//                                        tmpResultTrace += ";{" + key1 + "=" + value1 + "}";
//                                    }
//                                    if(x + 1 == keyList1.length) {
//                                        if(tmpRightPath == null)
//                                        {
//                                            tmpResultTrace = tmpResultTrace;
//                                        } else {
//                                            tmpResultTrace += ";" + tmpRightPath;
//                                        }
//                                    }
//                                } else if(!flag && paralleFlag) {
//                                    // 处理同步活动
//                                    Double paralleValue = param * param * Double.parseDouble(value1) * Double.parseDouble(paralleRightValue);
//                                    if(x == 0)
//                                    {
//                                        tmpResultTrace = "{" + key1 + 2 + "=" + paralleValue + "}";
//                                    } else {
//                                        if(tmpRightPath == null)
//                                        {
//                                            tmpResultTrace += ";{" + key1 + 2 + "=" + paralleValue + "}";
//                                        } else {
//                                            tmpResultTrace += ";" + tmpRightPath + ";{" + key1 + 2 + "=" + paralleValue + "}";
//                                        }
//                                    }
//                                    paralleFlag = false; // 取消同步的监控
//                                }
//                            }
//
//                            // 计算总复杂度
//                            String finalPath = null;
//                            Double finalValue = 0.0;
//                            String pathArr[] = tmpResultTrace.split(";");
//                            if(flag) {
//                                finalPath = tmpResultTrace;
//                                finalValue = -1.0;
//                            } else {
//                                for(int a = 0; a < pathArr.length; a++)
//                                {
//                                    String keyItem = pathArr[a].split("\\{|\\=|\\}")[1];
//                                    Double valueItem = Double.parseDouble(pathArr[a].split("\\{|\\=|\\}")[2]);
//                                    if(HasDigit(keyItem))
//                                    {
//                                        keyItem = keyItem.split("")[0];
//                                    } else {
//                                        valueItem = param * valueItem;
//                                    }
//                                    BigDecimal bg = new BigDecimal(valueItem); // 保留两位小数
//                                    valueItem = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
//                                    if (a == 0)
//                                    {
//                                        finalPath = "{" + keyItem + "=" + valueItem + "}";
//                                    } else {
//                                        finalPath = finalPath + ";{" + keyItem + "=" + valueItem + "}";
//                                    }
//                                    finalValue += valueItem;
//                                }
//                            }
//
//                            String tmpResult = "(" + finalPath + "," + finalValue + ")";
//                            resultValue.add(tmpResult);
//
//                            // 交换顺序
//                            String tmpList[] = keyList2.clone();
//                            keyList2 = keyList1.clone();
//                            keyList1 = tmpList.clone();
//                            isLoop++;
//                        }
//                    }
//                }
//            }
//        }
//        String trace = ctx.calculateExpr().getText() + "||" + ctx.callOrchoice().getText();
//        resultMap.put(trace, resultValue);
//        return resultMap;
//    }
//
//    @Override
//    public HashMap<String, Double> visitInt(LibExprParser.IntContext ctx)
//    {
//        HashMap<String, Double> resultMap = new HashMap<String, Double>(1);
//        resultMap.put(ctx.INT().getText(), Double.parseDouble(ctx.INT().getText()));
//        return resultMap;
//    }
//
//    @Override
//    public HashMap<String, Double> visitDouble(LibExprParser.DoubleContext ctx)
//    {
//        HashMap<String, Double> resultMap = new HashMap<String, Double>(1);
//        resultMap.put(ctx.DOUBLE().getText(), Double.parseDouble(ctx.DOUBLE().getText()));
//        return resultMap;
//    }
//
//    @Override
//    public HashMap<String, List> visitVariable(LibExprParser.VariableContext ctx)
//    {
//        HashMap<String, List> resultMap = new HashMap<String, List>();
//        List<Double> valueList = variables.get(ctx.ID().getText());
//        resultMap.put(ctx.ID().getText(), valueList);
//        return resultMap;
//    }
//
//    @Override
//    public HashMap<String, List> visitAtomVar(LibExprParser.AtomVarContext ctx)
//    {
//        HashMap<String, List> resultMap = new HashMap<String, List>(1);
//        List<Double> valueList = variables.get(ctx.ATOM().getText());
//        resultMap.put(ctx.ATOM().getText(), valueList);
//        return resultMap;
//    }
//
//    @Override
//    public HashMap<String, Double> visitBraces(LibExprParser.BracesContext ctx)
//    {
//        return visit(ctx.calculateExpr());
//    }
//}
