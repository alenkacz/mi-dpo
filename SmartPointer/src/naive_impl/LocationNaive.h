/*
 * LocationNaive.h
 *
 *  Created on: 15 Sep 2010
 *      
 */

#ifndef LOCATIONNAIVE_H_
#define LOCATIONNAIVE_H_
#include "../Location.h"
#include "../sp_impl/Wrapper.h"

using namespace std;

typedef list<Wrapper<Agent>*> AgentList;

class LocationNaive: public Location {
private:
	AgentList agents;

public:
	LocationNaive(EventLogger* logger, string name) : Location(logger, name) {};
	virtual ~LocationNaive();

	void agentEnters(Wrapper<Agent>* a);

	void agentLeaves(Wrapper<Agent>* a);

	AgentList agentsInside();

};

#endif /* LOCATIONNAIVE_H_ */
