/*
 * LocationNaive.cpp
 *
 *  Created on: 15 Sep 2010
 */

#include "LocationNaive.h"

using namespace std;


LocationNaive::~LocationNaive() {
	for(AgentList::const_iterator it = agents.begin();it != agents.end();it++)
    {
    	delete *it;
    }
}

void LocationNaive::agentEnters(Wrapper<Agent>* a) {
	agents.push_back(a);
}

void LocationNaive::agentLeaves(Wrapper<Agent>* a) {
	agents.remove(a);
}

AgentList LocationNaive::agentsInside()
{
	return agents;
}


