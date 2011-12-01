/*
 * Counted.cpp
 *
 *  Created on: Nov 20, 2011
 *      Author: Alena Varkockova (varkockova.a@gmail.com)
 */

#ifndef COUNTED_H_
#define COUNTED_H_

#include <assert.h>
#include "Wrapper.h"

template <class T> class Wrapper;

template <class T>
class Counted {
	friend class Wrapper<T>;
private:
		T* const _pointer;
		unsigned _count;

        Counted(T* ptr) : _count(0), _pointer(ptr)
        {
        	ASSERT(ptr != 0);
        }
        ~Counted()
        {
        	assert(_count == 0);
        	delete _pointer;
        }

        unsigned GetRef()    { return ++_count; }
        unsigned FreeRef()
        {
        	assert(_count != 0);
        	return --_count;
        }
};

#endif /* COUNTED_H_ */
