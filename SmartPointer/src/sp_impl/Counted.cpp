/*
 * Counted.cpp
 *
 *  Created on: Nov 20, 2011
 *      Author: Alena Varkockova (varkockova.a@gmail.com)
 */

#include "Counted.h"

template <class T>
class Counted {
public:
        Counted() : Count(0) {}
        ~Counted()           { ASSERT(Count == 0); }

        unsigned GetRef()    { return ++Count; }
        unsigned FreeRef()   { ASSERT(Count > 0); return --Count; }
        T* operator->()      { return &myT; }
private:
        T               myT;
        unsigned        Count;
};
