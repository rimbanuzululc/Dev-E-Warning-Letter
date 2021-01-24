package com.sli.somasi.foundation.service;

import com.sli.somasi.foundation.dto.Agent;
import io.vertx.core.Future;
import java.util.List;

/**
 *
 * @author hp
 */
public interface AgentService {
    
    Future<Agent> add (Agent agent);
    Future<List<Agent>> getAgentbyIdDebitur (int idDebitur);
    Future<List<Agent>> listAgent();
    
}
