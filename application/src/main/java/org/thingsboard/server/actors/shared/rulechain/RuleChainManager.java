package org.thingsboard.server.actors.shared.rulechain;

import akka.japi.Creator;
import lombok.extern.slf4j.Slf4j;
import org.thingsboard.server.actors.ActorSystemContext;
import org.thingsboard.server.actors.ruleChain.RuleChainActor;
import org.thingsboard.server.actors.shared.EntityActorsManager;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.rule.RuleChain;
import org.thingsboard.server.dao.rule.RuleChainService;

/**
 * Created by ashvayka on 15.03.18.
 */
@Slf4j
public abstract class RuleChainManager extends EntityActorsManager<RuleChainId, RuleChainActor, RuleChain> {

    protected final RuleChainService service;

    public RuleChainManager(ActorSystemContext systemContext) {
        super(systemContext);
        this.service = systemContext.getRuleChainService();
    }

    @Override
    public Creator<RuleChainActor> creator(RuleChainId entityId) {
        return new RuleChainActor.ActorCreator(systemContext, getTenantId(), entityId);
    }

}