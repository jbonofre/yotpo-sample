package com.yotpo.sample.rules;

import org.apache.unomi.api.Metadata;
import org.apache.unomi.api.actions.Action;
import org.apache.unomi.api.conditions.Condition;
import org.apache.unomi.api.rules.Rule;
import org.apache.unomi.api.services.RulesService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import java.util.HashMap;
import java.util.Map;

@Component
public class CustomRulesInjector {

    @Reference
    RulesService rulesService;

    @Activate
    public void activate() throws Exception {
        Rule rule = new Rule();
        Metadata metadata = new Metadata();
        metadata.setId("exampleEventCopy");
        metadata.setName("Example Copy Event To Profile");
        metadata.setDescription("Copy event properties to profile properties");
        rule.setMetadata(metadata);
        Condition condition = new Condition();
        condition.setConditionTypeId("eventTypeCondition");
        Map<String, Object> conditionParameterValues = new HashMap<>();
        conditionParameterValues.put("eventTypeId", "myEvent");
        condition.setParameterValues(conditionParameterValues);
        rule.setCondition(condition);
        Action action = new Action();
        action.setActionTypeId("allEventToProfilePropertiesAction");
        action.setParameterValues(new HashMap<>());
        rulesService.setRule(rule);
    }

    @Deactivate
    public void deactivate() throws Exception {
        rulesService.removeRule("exampleEventCopy");
    }

}
