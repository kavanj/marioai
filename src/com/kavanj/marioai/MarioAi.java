package com.kavanj.marioai;

import ch.idsia.agents.controllers.BasicMarioAIAgent;
import ch.idsia.benchmark.mario.environments.Environment;

/**
 * Created by joe on 2015-05-11.
 */
public class MarioAi extends BasicMarioAIAgent
{

    public MarioAi()
    {
        super(MarioAi.class.getName());
    }

    @Override
    public boolean[] getAction()
    {
        boolean[] action = new boolean[Environment.numberOfKeys];

        return action;
    }

}
