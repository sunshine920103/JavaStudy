package com.cc.designPattern;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：cc
 * @date ：created in 2020/8/16 19:49
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
public class Factory {

}

interface IRuleParser {
    public String parser();
}

class JsonRuleParser implements IRuleParser {

    @Override
    public String parser() {
        return "json";
    }
}

class XmlRuleParser implements IRuleParser {

    @Override
    public String parser() {
        return "xml";
    }
}

//简单工厂
class RuleParserSimpleFactory {

    public static IRuleParser createParser(String configFormat) {
        IRuleParser parser = null;
        if ("json".equalsIgnoreCase(configFormat)) {
            parser = new JsonRuleParser();
        } else if ("xml".equalsIgnoreCase(configFormat)) {
            parser = new XmlRuleParser();
        }
        return parser;
    }
}

//简单工厂2
class RuleParserSimpleFactory2 {
    private static final Map<String, IRuleParser> ruleParserMap = new HashMap<>();

    static {
        ruleParserMap.put("json", new JsonRuleParser());
        ruleParserMap.put("xml", new XmlRuleParser());
    }

    public static IRuleParser createParser(String configFormat) {
        return ruleParserMap.get(configFormat.toLowerCase());
    }
}

//工厂方法
interface IRuleParserFactory {
    public IRuleParser createParser();
}

class JsonRuleParserFactory implements IRuleParserFactory {

    @Override
    public IRuleParser createParser() {
        return new JsonRuleParser();
    }
}

class XmlRuleParserFactory implements IRuleParserFactory {

    @Override
    public IRuleParser createParser() {
        return new XmlRuleParser();
    }
}

class RuleParserFactoryMap {
    private static final Map<String, IRuleParserFactory> ruleParserFactoryMap = new HashMap<>();

    static {
        ruleParserFactoryMap.put("json", new JsonRuleParserFactory());
        ruleParserFactoryMap.put("xml", new XmlRuleParserFactory());
    }

    public static IRuleParserFactory getParserFactory(String factory) {
        return ruleParserFactoryMap.get(factory.toLowerCase() );
    }
}








