#include "Counted.h"
#include "Wrapper.h"

template <class T>
Wrapper<T>::Wrapper() : _counted = 0 {}

template <class T>
Wrapper<T>::Wrapper(T* ptr)
{
	_counted = new Counted<T>(ptr);
	_counted->GetRef();
}

template <class T>
Wrapper<T>::~Wrapper()
{
	UnBind();
}

template <class T>
Wrapper<T>::UnBind()
{
	if(!Null() && _counted->FreeRef() == 0) {
		delete _counted;
	}

	_counted = 0;
}

template <class T>
const T* Wrapper<T>::operator->() const
{
	 if(Null())
	 {
		 throw -1;
	 }

	 return _counted->_pointer;
}

template <class T>
T* Wrapper<T>::operator->()
{
	 if(Null())
	 {
		 throw -1;
	 }

	 return _counted->_pointer;
}
